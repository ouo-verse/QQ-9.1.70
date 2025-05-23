package com.tencent.mobileqq.qmmkv;

import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bb;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.y;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J1\u0010\n\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/y;", "Lcom/tencent/mobileqq/app/bb$a;", "", "mmapId", ImageTaskConst.ERROR_TYPE, "", "r", "T", "key", "value", "onEncode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "onDecode", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "onSync", "mmapID", "onMMKVCRCCheckFail", "onMMKVFileLengthError", "<init>", "()V", "d", "a", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class y implements bb.a {
    private static volatile boolean C;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private static j f262055e;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f262057h;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f262059m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f262056f = 1024;

    /* renamed from: i, reason: collision with root package name */
    private static volatile int f262058i = 64;

    @NotNull
    private static AtomicBoolean D = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u001b\u0010\u0013\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\"\u0010$\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\"\u0010'\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u0010\u0016R\u0014\u00102\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/y$a;", "", "", "k", "", "cacheDir", "", "limit", "", "outFiles", "c", "Lcom/tencent/mobileqq/qmmkv/j;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "T", "t", "", "b", "(Ljava/lang/Object;)I", "reportEncodeByteSize", "I", tl.h.F, "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "needReportEncodeSize", "Z", "e", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "reportFileSizeLimit", "i", "r", "needReportFileSize", "f", "o", "needReportSyncOp", "g", "p", "Ljava/util/concurrent/atomic/AtomicBoolean;", "inited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setInited", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "FILESIZE_QUITEBIG_FORPRINT", "TAG", "Ljava/lang/String;", "sCallback", "Lcom/tencent/mobileqq/qmmkv/j;", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qmmkv.y$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(String cacheDir, long limit, Map<String, Long> outFiles) {
            StringBuilder sb5;
            File[] listFiles;
            boolean z16;
            String extension;
            boolean z17;
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder();
            } else {
                sb5 = null;
            }
            File file = new File(cacheDir);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    for (File file2 : listFiles) {
                        Intrinsics.checkNotNullExpressionValue(file2, "file");
                        extension = FilesKt__UtilsKt.getExtension(file2);
                        if (extension.length() > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (!z17) {
                            long length = file2.length();
                            if (length >= limit) {
                                String name = file2.getName();
                                Intrinsics.checkNotNullExpressionValue(name, "file.name");
                                outFiles.put(name, Long.valueOf(length));
                            }
                            if (sb5 != null && length >= 4194304) {
                                sb5.append("[");
                                sb5.append(file2.getName());
                                sb5.append("]");
                                sb5.append(length >>> 20);
                                sb5.append("Mb,");
                            }
                        }
                    }
                }
            }
            if (sb5 != null) {
                QLog.d("MMKVReport", 1, "mmkv_files: " + ((Object) sb5));
            }
        }

        private final void k() {
            if (MobileQQ.sProcessId == 1 && f() && i() > 0) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        y.Companion.l();
                    }
                }, 64, null, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void l() {
            String str = BaseApplication.context.getFilesDir().getAbsolutePath() + "/mmkv";
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Companion companion = y.INSTANCE;
            companion.c(str, companion.i() * 1048576, linkedHashMap);
            QLog.d("MMKVReport", 1, "calcExceedLimitSizeFiles limit:" + companion.i() + "(Mb) outFiles:" + linkedHashMap);
            if (!(!linkedHashMap.isEmpty())) {
                linkedHashMap = null;
            }
            if (linkedHashMap != null) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(WadlProxyConsts.PARAM_FILENAME, entry.getKey());
                    hashMap.put("byteSize", String.valueOf(((Number) entry.getValue()).longValue()));
                    n.f262021a.report("actMMKVFileSizeReport", hashMap);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> int b(T t16) {
            boolean z16;
            String str;
            int i3 = 0;
            if (t16 instanceof Set) {
                for (T t17 : (Iterable) t16) {
                    if (t17 instanceof String) {
                        str = (String) t17;
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        i3 += str.length() * 2;
                    }
                }
                return i3;
            }
            if (t16 instanceof byte[]) {
                return ((byte[]) t16).length;
            }
            if (t16 instanceof Parcelable) {
                Parcel obtain = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
                ((Parcelable) t16).writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                OaidMonitor.parcelRecycle(obtain);
                if (marshall == null) {
                    return 0;
                }
                return marshall.length;
            }
            if (t16 instanceof String) {
                return ((String) t16).length() * 2;
            }
            boolean z17 = true;
            if (t16 instanceof Boolean) {
                return 1;
            }
            if (t16 instanceof Double) {
                z16 = true;
            } else {
                z16 = t16 instanceof Long;
            }
            if (z16) {
                return 8;
            }
            if (!(t16 instanceof Integer)) {
                z17 = t16 instanceof Float;
            }
            if (!z17) {
                return 0;
            }
            return 4;
        }

        @NotNull
        public final AtomicBoolean d() {
            return y.D;
        }

        public final boolean e() {
            return y.f262057h;
        }

        public final boolean f() {
            return y.f262059m;
        }

        public final boolean g() {
            return y.C;
        }

        public final int h() {
            return y.f262056f;
        }

        public final int i() {
            return y.f262058i;
        }

        public final boolean j() {
            if (!d().compareAndSet(false, true)) {
                return false;
            }
            MMKVConfig a16 = MMKVConfig.INSTANCE.a();
            n(a16.getReportEncodeSizeSwitchOn());
            o(a16.getReportFileSizeSwitchOn());
            p(a16.getReportSyncOpRateSwitchOn());
            q(a16.getReportEncodeByteSize());
            r(a16.getReportFileSizeLimit());
            if (g()) {
                QMMKV.syncMonitorOn = true;
            }
            if (e()) {
                QMMKV.encodeMonitorOn = true;
            }
            QLog.d("MMKVReport", 1, "init needReportFileSize:" + f() + " needReportEncodeSize:" + e() + " needReportSyncOp:" + g() + " fileSizeLimit:" + i() + " byteSizeLimit:" + h());
            k();
            c.f262004d.c();
            return true;
        }

        public final void m(@Nullable j callback) {
            y.f262055e = callback;
        }

        public final void n(boolean z16) {
            y.f262057h = z16;
        }

        public final void o(boolean z16) {
            y.f262059m = z16;
        }

        public final void p(boolean z16) {
            y.C = z16;
        }

        public final void q(int i3) {
            y.f262056f = i3;
        }

        public final void r(int i3) {
            y.f262058i = i3;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(String str, String str2, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mmapId", String.valueOf(str));
        hashMap.put("key", String.valueOf(str2));
        hashMap.put("size", String.valueOf(i3));
        if (QLog.isDevelopLevel()) {
            QLog.i("MMKVReport", 2, "onEncode actMMKVEncodeReport:" + hashMap + " ");
        }
        n.f262021a.report("actMMKVEncodeReport", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String str, boolean z16, boolean z17) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mmapId", String.valueOf(str));
        hashMap.put(FileReaderHelper.OPEN_FILE_FROM_FORCE, String.valueOf(z16 ? 1 : 0));
        hashMap.put("isMainThread", String.valueOf(z17 ? 1 : 0));
        if (QLog.isDevelopLevel()) {
            QLog.i("MMKVReport", 2, "postReportSyncOpt actMMKVSyncOpReport:" + hashMap + " ");
        }
        n.f262021a.report("actMMKVSyncOpReport", hashMap);
    }

    private final void r(final String mmapId, final String errType) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.w
            @Override // java.lang.Runnable
            public final void run() {
                y.s(mmapId, errType);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String str, String errType) {
        Intrinsics.checkNotNullParameter(errType, "$errType");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mmapId", String.valueOf(str));
        hashMap.put(ImageTaskConst.ERROR_TYPE, errType);
        if (QLog.isDevelopLevel()) {
            QLog.i("MMKVReport", 2, "actMMKVErrorReport:" + hashMap + " ");
        }
        n.f262021a.report("actMMKVErrorReport", hashMap);
    }

    @Override // com.tencent.mobileqq.qmmkv.j
    public void onDecode(@Nullable String mmapId, @Nullable String key) {
        j jVar = f262055e;
        if (jVar != null) {
            jVar.onDecode(mmapId, key);
        }
    }

    @Override // com.tencent.mobileqq.qmmkv.j
    public <T> void onEncode(@Nullable final String mmapId, @Nullable final String key, T value) {
        final int b16;
        j jVar = f262055e;
        if (jVar != null) {
            jVar.onEncode(mmapId, key, value);
        }
        if (f262057h && value != null && (b16 = INSTANCE.b(value)) >= f262056f) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.u
                @Override // java.lang.Runnable
                public final void run() {
                    y.p(mmapId, key, b16);
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.mobileqq.app.bb
    public void onMMKVCRCCheckFail(@Nullable String mmapID) {
        r(mmapID, "crcFail");
    }

    @Override // com.tencent.mobileqq.app.bb
    public void onMMKVFileLengthError(@Nullable String mmapID) {
        r(mmapID, "lenError");
    }

    @Override // com.tencent.mobileqq.qmmkv.j
    public void onSync(@Nullable final String mmapId, final boolean force) {
        final boolean areEqual = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        if (!D.get()) {
            return;
        }
        if (areEqual || C) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.v
                @Override // java.lang.Runnable
                public final void run() {
                    y.q(mmapId, force, areEqual);
                }
            }, 64, null, true);
        }
    }
}
