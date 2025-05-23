package com.tencent.mobileqq.unusedcodecheck;

import android.content.Context;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bH\u0010IJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004R\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010!\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\"\u0010(\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010+\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\"\u0010.\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010#\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u0010<\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010#\u001a\u0004\b:\u0010%\"\u0004\b;\u0010'R\"\u0010>\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010#\u001a\u0004\b\u001e\u0010%\"\u0004\b=\u0010'R\"\u0010E\u001a\u00020?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010G\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010#\u001a\u0004\b6\u0010%\"\u0004\bF\u0010'\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/b;", "", "Landroid/content/Context;", "context", "", "checkInitStatus", "Lcom/tencent/mobileqq/unusedcodecheck/c;", "a", "", "o", "keepInitInfo", "c", "Lcom/tencent/mobileqq/unusedcodecheck/g;", "Lcom/tencent/mobileqq/unusedcodecheck/g;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/unusedcodecheck/g;", "y", "(Lcom/tencent/mobileqq/unusedcodecheck/g;)V", "tool", "", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;)V", "currentVersion", "e", "r", "currentCommitID", "d", "l", HippyTKDListViewAdapter.X, "mainProcessName", "", "I", "getCheckPartSize", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "checkPartSize", tl.h.F, "setGenerateFileCacheMemoryLimit", "generateFileCacheMemoryLimit", "g", "t", "fileBufferedSize", "", "D", "getLoadRateLimit", "()D", "u", "(D)V", "loadRateLimit", "i", "j", "v", "loadRateLimitLastVersion", "k", "w", "lookupCountLimit", "p", "allowLookupFailCount", "", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "setRemainStorageLimit", "(J)V", "remainStorageLimit", "setGenerateLoadCacheFrequency", "generateLoadCacheFrequency", "<init>", "()V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static g tool;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static String currentVersion;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static String currentCommitID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static String mainProcessName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int checkPartSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int generateFileCacheMemoryLimit;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int fileBufferedSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static double loadRateLimit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static double loadRateLimitLastVersion;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static int lookupCountLimit;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static int allowLookupFailCount;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static long remainStorageLimit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static int generateLoadCacheFrequency;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public static final b f306127n;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
            return;
        }
        f306127n = new b();
        checkPartSize = 3000;
        generateFileCacheMemoryLimit = 41943040;
        fileBufferedSize = 204800;
        loadRateLimit = 0.45d;
        loadRateLimitLastVersion = 0.6d;
        lookupCountLimit = 20;
        allowLookupFailCount = 3;
        remainStorageLimit = 5368709120L;
        generateLoadCacheFrequency = 50;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        }
    }

    public static /* synthetic */ c b(b bVar, Context context, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return bVar.a(context, z16);
    }

    @NotNull
    public final c a(@NotNull Context context, boolean checkInitStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (c) iPatchRedirector.redirect((short) 27, this, context, Boolean.valueOf(checkInitStatus));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        g gVar = tool;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tool");
        }
        gVar.c("UnusedCodeCheck.Check", "check start");
        InitClassInfo initClassInfo = new InitClassInfo();
        initClassInfo.k(context);
        g gVar2 = tool;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tool");
        }
        gVar2.e("UnusedCodeCheck.Check", "init end result:" + initClassInfo.j());
        boolean d16 = initClassInfo.d();
        if (initClassInfo.j() == 0) {
            f h16 = initClassInfo.h();
            Intrinsics.checkNotNull(h16);
            CheckCore checkCore = new CheckCore(h16, checkInitStatus);
            checkCore.storeCheckInfo$unusedcode_check_debug(checkPartSize);
            z16 = checkCore.isCheckSuc$unusedcode_check_debug();
        }
        g gVar3 = tool;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tool");
        }
        gVar3.c("UnusedCodeCheck.Check", "check end");
        return new c(d16, z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(boolean keepInitInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, keepInitInfo);
            return;
        }
        if (!keepInitInfo) {
            g gVar = tool;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tool");
            }
            gVar.d("unusedcodecheck_mmkv_check_state_data", CheckStateData.INSTANCE.c());
        }
        File[] listFiles = CheckCore.INSTANCE.a().listFiles();
        if (listFiles != null) {
            for (File it : listFiles) {
                if (keepInitInfo) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (Intrinsics.areEqual(it.getAbsolutePath(), InitClassInfo.INSTANCE.b().getAbsolutePath())) {
                        z16 = false;
                        if (!z16) {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            FilesKt__UtilsKt.deleteRecursively(it);
                        }
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
        }
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return allowLookupFailCount;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = currentCommitID;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentCommitID");
        }
        return str;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = currentVersion;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentVersion");
        }
        return str;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return fileBufferedSize;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return generateFileCacheMemoryLimit;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return generateLoadCacheFrequency;
    }

    public final double j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Double) iPatchRedirector.redirect((short) 17, (Object) this)).doubleValue();
        }
        return loadRateLimitLastVersion;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return lookupCountLimit;
    }

    @NotNull
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String str = mainProcessName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainProcessName");
        }
        return str;
    }

    public final long m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return remainStorageLimit;
    }

    @NotNull
    public final g n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (g) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        g gVar = tool;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tool");
        }
        return gVar;
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        String str = mainProcessName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainProcessName");
        }
        g gVar = tool;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tool");
        }
        if (Intrinsics.areEqual(str, gVar.b())) {
            CheckStateData b16 = CheckStateData.INSTANCE.b();
            if (!b16.g() && h.b(new h(), b16, loadRateLimit, false, 0, 8, null)) {
                g gVar2 = tool;
                if (gVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tool");
                }
                b16.m(true);
                Unit unit = Unit.INSTANCE;
                gVar2.d("unusedcodecheck_mmkv_check_state_data", b16);
            }
        }
    }

    public final void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            allowLookupFailCount = i3;
        }
    }

    public final void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            checkPartSize = i3;
        }
    }

    public final void r(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            currentCommitID = str;
        }
    }

    public final void s(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            currentVersion = str;
        }
    }

    public final void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            fileBufferedSize = i3;
        }
    }

    public final void u(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Double.valueOf(d16));
        } else {
            loadRateLimit = d16;
        }
    }

    public final void v(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Double.valueOf(d16));
        } else {
            loadRateLimitLastVersion = d16;
        }
    }

    public final void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            lookupCountLimit = i3;
        }
    }

    public final void x(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            mainProcessName = str;
        }
    }

    public final void y(@NotNull g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        } else {
            Intrinsics.checkNotNullParameter(gVar, "<set-?>");
            tool = gVar;
        }
    }
}
