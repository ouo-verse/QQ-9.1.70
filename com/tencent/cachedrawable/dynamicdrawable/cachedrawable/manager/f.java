package com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010=\u001a\u00020\u0004\u0012\u0006\u0010>\u001a\u00020\u0014\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0014\u0010 \u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010*R(\u00100\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070-0,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\"R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u0004028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001fR\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0016\u00108\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010:R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010:\u00a8\u0006A"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/f;", "", "", "index", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "key", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "j", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "k", "i", "l", "frameData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "p", "t", "", "isUseHardware", "u", "r", "Lcom/tencent/cachedrawable/dynamicdrawable/g;", "callback", "g", DomainData.DOMAIN_NAME, "d", "e", "a", "Z", "isUseCache", "b", "Ljava/lang/String;", "md5", "c", "mFileName", "Lcom/tencent/cachedrawable/dynamicdrawable/f;", "Lcom/tencent/cachedrawable/dynamicdrawable/f;", "mFrameLruCache", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/framecache/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/framecache/a;", "mFrameFileCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "mWeakFrameHashMap", "keyPre", "Landroid/util/SparseArray;", tl.h.F, "Landroid/util/SparseArray;", "mKeyMap", "mDisableHardWare", "isHardwareString", "mUseFileCache", "Landroid/os/Handler;", "Landroid/os/Handler;", "readHandler", "writeHandler", "filePath", "useFileCache", "<init>", "(Ljava/lang/String;Z)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
@SuppressLint({"LongLogTag"})
/* loaded from: classes5.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isUseCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String md5;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mFileName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.cachedrawable.dynamicdrawable.f mFrameLruCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.cachedrawable.dynamicdrawable.cachedrawable.framecache.a mFrameFileCache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<String, WeakReference<b>> mWeakFrameHashMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String keyPre;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SparseArray<String> mKeyMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mDisableHardWare;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String isHardwareString;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean mUseFileCache;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler readHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler writeHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/f$a;", "", "", "FILE_CACHE_DIR", "Ljava/lang/String;", "HARD", "SOFT", "TAG", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.f$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(@NotNull String filePath, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, filePath, Boolean.valueOf(z16));
            return;
        }
        this.isUseCache = com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.j();
        this.md5 = "";
        this.mFileName = "";
        this.mFrameLruCache = com.tencent.cachedrawable.dynamicdrawable.cachedrawable.framecache.c.f98952a;
        this.mFrameFileCache = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.framecache.a(filePath);
        this.mWeakFrameHashMap = new ConcurrentHashMap<>();
        this.keyPre = "";
        this.mKeyMap = new SparseArray<>();
        if (this.mDisableHardWare) {
            str = "HARD";
        } else {
            str = "SOFT";
        }
        this.isHardwareString = str;
        this.mUseFileCache = z16;
        h hVar = h.f99037a;
        this.readHandler = new Handler(hVar.b().getLooper());
        this.writeHandler = new Handler(hVar.c().getLooper());
        File file = new File(filePath);
        try {
            String d16 = com.tencent.cachedrawable.dynamicdrawable.utils.g.d(file);
            this.md5 = d16 == null ? "null" : d16;
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "file.name");
            this.mFileName = name;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(com.tencent.cachedrawable.dynamicdrawable.business.dynamicInit.a.f98862a.b());
            sb5.append(filePath);
            String str2 = File.separator;
            sb5.append((Object) str2);
            sb5.append(this.md5);
            sb5.append((Object) str2);
            this.keyPre = sb5.toString();
            if (Build.VERSION.SDK_INT < 28) {
                this.readHandler = new Handler(hVar.c().getLooper());
            }
        } catch (Exception e16) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameCacheManager", Intrinsics.stringPlus("init e : ", e16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void f(f this$0, int i3, com.tencent.cachedrawable.dynamicdrawable.g gVar) {
        String m3;
        String stringPlus;
        b i16;
        b k3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            m3 = this$0.m(i3);
            stringPlus = Intrinsics.stringPlus(m3, this$0.isHardwareString);
            i16 = this$0.i(stringPlus);
        } catch (OutOfMemoryError unused) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameCacheManager", "oom happened!");
        }
        if (i16 == null) {
            b j3 = this$0.j(stringPlus);
            if (j3 == null) {
                b l3 = this$0.l(stringPlus);
                if (l3 == null) {
                    if (this$0.mUseFileCache && (k3 = this$0.k(m3, null)) != null) {
                        if (!k3.i()) {
                            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameCacheManager", Intrinsics.stringPlus("decoder error : frameCount <= 0 path : ", this$0.mFileName));
                            if (gVar != null) {
                                gVar.a(null);
                            }
                        }
                        if (gVar != null) {
                            gVar.a(k3);
                        }
                        this$0.q(stringPlus, k3);
                        this$0.t(stringPlus, k3);
                        com.tencent.cachedrawable.dynamicdrawable.report.a.f99050a.c();
                        return;
                    }
                    gVar.a(null);
                }
                if (gVar != null) {
                    gVar.a(l3);
                }
                this$0.q(stringPlus, l3);
                this$0.p(stringPlus, l3);
                com.tencent.cachedrawable.dynamicdrawable.report.a.f99050a.e();
                return;
            }
            if (gVar != null) {
                gVar.a(j3);
            }
            this$0.t(stringPlus, j3);
            this$0.p(stringPlus, j3);
            com.tencent.cachedrawable.dynamicdrawable.report.a.f99050a.d();
            return;
        }
        if (gVar != null) {
            gVar.a(i16);
        }
        this$0.t(stringPlus, i16);
        this$0.q(stringPlus, i16);
        com.tencent.cachedrawable.dynamicdrawable.report.a.f99050a.a();
        return;
        gVar.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(f this$0, int i3, Bitmap bitmap, com.tencent.cachedrawable.dynamicdrawable.g gVar) {
        b k3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String m3 = this$0.m(i3);
        if (this$0.mUseFileCache && (k3 = this$0.k(m3, bitmap)) != null) {
            if (!k3.i()) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameCacheManager", Intrinsics.stringPlus("decoder error : frameCount <= 0 path : ", this$0.mFileName));
                if (gVar != null) {
                    gVar.a(null);
                    return;
                }
                return;
            }
            if (gVar != null) {
                gVar.a(k3);
            }
            com.tencent.cachedrawable.dynamicdrawable.report.a.f99050a.c();
            return;
        }
        if (gVar != null) {
            gVar.a(null);
        }
    }

    private final b i(String key) {
        return com.tencent.cachedrawable.dynamicdrawable.business.cache.a.f98855a.b(key);
    }

    private final b j(String key) {
        return this.mFrameLruCache.b(key, null);
    }

    private final b k(String key, Bitmap bitmap) {
        b b16 = this.mFrameFileCache.b(key, bitmap);
        if (b16 != null && b16.c() <= 1) {
            this.mFrameFileCache.c();
            return null;
        }
        return b16;
    }

    private final b l(String key) {
        WeakReference<b> weakReference = this.mWeakFrameHashMap.get(key);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private final String m(int index) {
        String str = this.mKeyMap.get(index, null);
        if (str == null) {
            String key = Intrinsics.stringPlus(this.keyPre, Integer.valueOf(index));
            this.mKeyMap.put(index, key);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            return key;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(f this$0, String key, b frameData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(frameData, "$frameData");
        this$0.s(key, frameData);
    }

    private final void p(String key, b frameData) {
        com.tencent.cachedrawable.dynamicdrawable.business.cache.a.f98855a.a(key, frameData);
    }

    private final void q(String key, b frameData) {
        this.mFrameLruCache.a(key, frameData);
    }

    private final void s(String key, b frameData) {
        if (frameData.c() > 1) {
            this.mFrameFileCache.a(key, frameData);
        }
    }

    private final void t(String key, b frameData) {
        b bVar;
        WeakReference<b> weakReference = this.mWeakFrameHashMap.get(key);
        if (weakReference == null) {
            bVar = null;
        } else {
            bVar = weakReference.get();
        }
        if (bVar == null) {
            this.mWeakFrameHashMap.put(key, new WeakReference<>(frameData));
        }
    }

    @Nullable
    public b d(int index) {
        b k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, index);
        }
        if (!this.isUseCache) {
            return null;
        }
        String m3 = m(index);
        String stringPlus = Intrinsics.stringPlus(m3, this.isHardwareString);
        b i3 = i(stringPlus);
        if (i3 == null) {
            b j3 = j(stringPlus);
            if (j3 == null) {
                b l3 = l(stringPlus);
                if (l3 == null) {
                    if (!this.mUseFileCache || (k3 = k(m3, null)) == null) {
                        return null;
                    }
                    if (!k3.i()) {
                        com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("FrameCacheManager", Intrinsics.stringPlus("decoder error : frameCount <= 0 path : ", this.mFileName));
                        return null;
                    }
                    q(stringPlus, k3);
                    this.mWeakFrameHashMap.put(stringPlus, new WeakReference<>(k3));
                    com.tencent.cachedrawable.dynamicdrawable.report.a.f99050a.c();
                    return k3;
                }
                q(stringPlus, l3);
                p(stringPlus, l3);
                com.tencent.cachedrawable.dynamicdrawable.report.a.f99050a.e();
                return l3;
            }
            t(stringPlus, j3);
            p(stringPlus, j3);
            com.tencent.cachedrawable.dynamicdrawable.report.a.f99050a.d();
            return j3;
        }
        t(stringPlus, i3);
        q(stringPlus, i3);
        com.tencent.cachedrawable.dynamicdrawable.report.a.f99050a.a();
        return i3;
    }

    public void e(final int index, @Nullable final com.tencent.cachedrawable.dynamicdrawable.g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, index, (Object) callback);
        } else {
            if (!this.isUseCache) {
                if (callback != null) {
                    callback.a(null);
                    return;
                }
                return;
            }
            this.readHandler.post(new Runnable() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.f(f.this, index, callback);
                }
            });
        }
    }

    public void g(final int index, @Nullable final com.tencent.cachedrawable.dynamicdrawable.g callback, @Nullable final Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(index), callback, bitmap);
        } else {
            if (!this.isUseCache) {
                return;
            }
            this.readHandler.post(new Runnable() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.h(f.this, index, bitmap, callback);
                }
            });
        }
    }

    public void n(@NotNull final b frameData, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) frameData, index);
            return;
        }
        Intrinsics.checkNotNullParameter(frameData, "frameData");
        if (!this.isUseCache) {
            return;
        }
        final String m3 = m(index);
        String stringPlus = Intrinsics.stringPlus(m3, this.isHardwareString);
        t(stringPlus, frameData);
        p(stringPlus, frameData);
        q(stringPlus, frameData);
        if (this.mUseFileCache) {
            this.writeHandler.post(new Runnable() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.o(f.this, m3, frameData);
                }
            });
        }
    }

    public void r(@NotNull b frameData, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) frameData, index);
            return;
        }
        Intrinsics.checkNotNullParameter(frameData, "frameData");
        if (!this.isUseCache) {
            return;
        }
        String m3 = m(index);
        if (this.mUseFileCache) {
            s(m3, frameData);
        }
    }

    public final void u(boolean isUseHardware) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isUseHardware);
            return;
        }
        this.mDisableHardWare = isUseHardware;
        this.mFrameFileCache.e(isUseHardware);
        if (this.mDisableHardWare) {
            str = "HARD";
        } else {
            str = "SOFT";
        }
        this.isHardwareString = str;
    }
}
