package com.tencent.mobileqq.unusedcodecheck;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unusedcodecheck.CheckStateData;
import com.tencent.mobileqq.unusedcodecheck.dexparse.DexParseException;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 )2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0004R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0014\u0010!\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 R$\u0010(\u001a\u0004\u0018\u00010\"8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010-\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/InitClassInfo;", "", "Lcom/tencent/mobileqq/unusedcodecheck/CheckStateData;", "checkState", "", "e", "isMainProcess", "Landroid/content/Context;", "context", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "c", "f", "", "apkPath", "g", "Ljava/io/File;", "i", DomainData.DOMAIN_NAME, "k", "d", "", "a", "I", "fileCacheMemoryLimit", "b", "fileBufferedSize", "allowLookupFailCount", "J", "remainStorageLimit", "Ljava/lang/String;", "currentVersion", "Lcom/tencent/mobileqq/unusedcodecheck/f;", "Lcom/tencent/mobileqq/unusedcodecheck/f;", tl.h.F, "()Lcom/tencent/mobileqq/unusedcodecheck/f;", "setClassDef$unusedcode_check_debug", "(Lcom/tencent/mobileqq/unusedcodecheck/f;)V", "classDef", "j", "()I", "setStatusCode", "(I)V", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "<init>", "()V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class InitClassInfo {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f306076h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private static final Lazy f306077i;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int fileCacheMemoryLimit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int fileBufferedSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int allowLookupFailCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long remainStorageLimit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String currentVersion;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f classDef;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int statusCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\r\u001a\u0004\u0018\u00010\u00028@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/InitClassInfo$a;", "", "Ljava/io/File;", "b", "()Ljava/io/File;", "", "isLoadSoSuc$delegate", "Lkotlin/Lazy;", "d", "()Z", "isLoadSoSuc", "rootDirFile$delegate", "c", "rootDirFile", "", "INIT_ERROR_CODE_COPYDEX_FAILED", "I", "INIT_ERROR_CODE_GENERATE_DEF_FILE_FAILED", "INIT_ERROR_CODE_GET_APK_PATH_FAILED", "INIT_ERROR_CODE_GET_EXTERNAL_FILE_DIR_FAILED", "INIT_ERROR_CODE_GET_PROCESS_FAILED", "INIT_ERROR_CODE_LOADSO_FAIELD", "INIT_ERROR_CODE_LOOKUP_FAIL_TOO_MUCH", "INIT_ERROR_CODE_LOW_MEMORY", "INIT_ERROR_CODE_LOW_STORAGE_SPACE", "INIT_ERROR_CODE_NOT_MAIN_PROCESS_FAILED", "INIT_ERROR_CODE_SUC", "", "ROOT_DIR_NAME", "Ljava/lang/String;", "SO_NAME", "TAG", "<init>", "()V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.unusedcodecheck.InitClassInfo$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d() {
            return ((Boolean) InitClassInfo.f306076h.getValue()).booleanValue();
        }

        @NotNull
        public final File b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (File) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new File(CheckCore.INSTANCE.a(), "class_def");
        }

        @Nullable
        public final File c() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                value = iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                value = InitClassInfo.f306077i.getValue();
            }
            return (File) value;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8277);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(InitClassInfo$Companion$isLoadSoSuc$2.INSTANCE);
        f306076h = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(InitClassInfo$Companion$rootDirFile$2.INSTANCE);
        f306077i = lazy2;
    }

    public InitClassInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        b bVar = b.f306127n;
        this.fileCacheMemoryLimit = bVar.h();
        this.fileBufferedSize = bVar.g();
        this.allowLookupFailCount = bVar.d();
        this.remainStorageLimit = bVar.m();
        this.currentVersion = bVar.f();
    }

    private final long c() {
        long j3 = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long freeMemory = j3 - Runtime.getRuntime().freeMemory();
        long j16 = maxMemory - freeMemory;
        b.f306127n.n().c("UnusedCodeCheck.Init", "mainProcessInit maxMemory:" + maxMemory + " usingMemory:" + freeMemory + " remainMemory:" + j16);
        return j16;
    }

    private final boolean e(CheckStateData checkState) {
        if (checkState.e() >= this.allowLookupFailCount) {
            this.statusCode = -1007;
            return false;
        }
        return true;
    }

    private final void f() {
        File c16 = INSTANCE.c();
        Intrinsics.checkNotNull(c16);
        if (c16.exists()) {
            File[] listFiles = c16.listFiles();
            if (listFiles == null) {
                b.f306127n.n().e("UnusedCodeCheck.Init", "cleanOldVersionFile fail checkRootDirFile:" + c16.getAbsolutePath() + " isDir:" + c16.isDirectory());
                return;
            }
            ArrayList<File> arrayList = new ArrayList();
            for (File file : listFiles) {
                if (!file.equals(CheckCore.INSTANCE.a())) {
                    arrayList.add(file);
                }
            }
            for (File it : arrayList) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                FilesKt__UtilsKt.deleteRecursively(it);
            }
        }
    }

    private final boolean g(String apkPath, CheckStateData checkState) {
        Object obj;
        OutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        b.f306127n.n().c("UnusedCodeCheck.Init", "generateClassDefFile start");
        File b16 = INSTANCE.b();
        boolean z16 = false;
        try {
            b16.delete();
            fileOutputStream = new FileOutputStream(b16);
        } catch (DexParseException e16) {
            b.f306127n.n().h("UnusedCodeCheck.Init", "generateClassDefFile failed,dex parse error", e16);
        } catch (IOException e17) {
            b.f306127n.n().h("UnusedCodeCheck.Init", "generateClassDefFile failed,io error", e17);
        }
        try {
            int i3 = this.fileBufferedSize;
            if (fileOutputStream instanceof BufferedOutputStream) {
                bufferedOutputStream = (BufferedOutputStream) fileOutputStream;
            } else {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream, i3);
            }
            try {
                final DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
                try {
                    File i16 = i();
                    i16.delete();
                    i16.mkdirs();
                    new com.tencent.mobileqq.unusedcodecheck.dexparse.a(apkPath, this.fileBufferedSize, i16, new Function2<String, Integer, Unit>(dataOutputStream) { // from class: com.tencent.mobileqq.unusedcodecheck.InitClassInfo$generateClassDefFile$1$1$1$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ DataOutputStream $outputStream;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                            this.$outputStream = dataOutputStream;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataOutputStream);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
                            invoke(str, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull String className, int i17) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) className, i17);
                            } else {
                                Intrinsics.checkNotNullParameter(className, "className");
                                this.$outputStream.writeUTF(className);
                            }
                        }
                    }).b();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(dataOutputStream, null);
                    CloseableKt.closeFinally(bufferedOutputStream, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    z16 = true;
                    if (z16) {
                        checkState.j(b16.length());
                        b.f306127n.n().d("unusedcodecheck_mmkv_check_state_data", checkState);
                    }
                    g n3 = b.f306127n.n();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("generateClassDefFile end result:");
                    sb5.append(z16);
                    sb5.append("  length:");
                    if (z16) {
                        obj = Long.valueOf(b16.length());
                    } else {
                        obj = "0";
                    }
                    sb5.append(obj);
                    n3.e("UnusedCodeCheck.Init", sb5.toString());
                    return z16;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    private final File i() {
        File file = new File(CheckCore.INSTANCE.a(), "copy_dex_files");
        file.mkdirs();
        return file;
    }

    private final void l(boolean isMainProcess, Context context, CheckStateData checkState) {
        if (isMainProcess) {
            m(context, checkState);
            new a(checkState).d();
        } else {
            n(checkState);
        }
    }

    private final void m(Context context, CheckStateData checkState) {
        Companion companion = INSTANCE;
        File b16 = companion.b();
        if (b16.exists()) {
            if (b16.length() != checkState.a()) {
                b16.delete();
            } else {
                this.classDef = new d(b16, this.fileBufferedSize);
                if (!companion.d()) {
                    this.statusCode = -1001;
                    return;
                }
                return;
            }
        }
        f();
        if (c() < this.fileCacheMemoryLimit) {
            this.statusCode = -1006;
            return;
        }
        if (b.f306127n.n().a() < this.remainStorageLimit) {
            this.statusCode = -1009;
            return;
        }
        String packageCodePath = context.getPackageCodePath();
        if (packageCodePath == null) {
            this.statusCode = -1010;
            return;
        }
        if (!g(packageCodePath, checkState)) {
            this.statusCode = -1004;
            return;
        }
        this.classDef = new d(companion.b(), this.fileBufferedSize);
        if (!companion.d()) {
            this.statusCode = -1001;
        }
    }

    private final boolean n(CheckStateData checkState) {
        Companion companion = INSTANCE;
        File b16 = companion.b();
        if (b16.exists() && b16.length() == checkState.a()) {
            this.classDef = new d(b16, this.fileBufferedSize);
            if (companion.d()) {
                return true;
            }
            this.statusCode = -1001;
            return false;
        }
        this.statusCode = -1002;
        return false;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        int i3 = this.statusCode;
        if (i3 != -1007 && i3 != -1009) {
            return true;
        }
        return false;
    }

    @Nullable
    public final f h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (f) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.classDef;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.statusCode;
    }

    public final void k(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (INSTANCE.c() == null) {
            this.statusCode = -1011;
            return;
        }
        b bVar = b.f306127n;
        String b16 = bVar.n().b();
        if (b16 == null) {
            this.statusCode = -1005;
            return;
        }
        boolean areEqual = Intrinsics.areEqual(bVar.l(), b16);
        CheckStateData.Companion companion = CheckStateData.INSTANCE;
        CheckStateData b17 = companion.b();
        if (!Intrinsics.areEqual(b17.f(), this.currentVersion)) {
            CheckStateData c16 = companion.c();
            if (areEqual) {
                h.b(new h(), b17, bVar.j(), true, 0, 8, null);
                bVar.n().e("UnusedCodeCheck.Init", "checkstate version change, current state:" + b17 + ", new state:" + c16);
                bVar.n().d("unusedcodecheck_mmkv_check_state_data", c16);
            }
            b17 = c16;
        }
        if (!e(b17)) {
            return;
        }
        l(areEqual, context, b17);
    }
}
