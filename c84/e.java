package c84;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Lc84/e;", "", "", "dressKey", "", MiniGamePAHippyBaseFragment.KEY_THEME, "c", "b", "srcPath", "", "f", "d", "e", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f30458a = new e();

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String srcPath, String savePath) {
        Intrinsics.checkNotNullParameter(srcPath, "$srcPath");
        Intrinsics.checkNotNullParameter(savePath, "$savePath");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            FileUtils.deleteDirectory(com.tencent.sqshow.zootopia.avatar.filament.a.f369963a.b());
            FileUtils.copyFile(srcPath, savePath);
            QLog.i("ZPlanLoadingRecordManager_", 1, "saveFirstFrameStaticImage success, cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", savePath=" + savePath);
        } catch (Throwable th5) {
            QLog.i("ZPlanLoadingRecordManager_", 1, "saveFirstFrameStaticImage error", th5);
        }
    }

    public final boolean b() {
        boolean z16;
        String q16 = ZPlanFeatureSwitch.f369852a.q1();
        QLog.i("ZPlanLoadingRecordManager_", 1, "canShowRecordAvatar config:" + q16);
        try {
            z16 = new JSONObject(q16).optBoolean("switchStatus");
        } catch (Exception unused) {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        BaseApplication ctx = BaseApplication.context;
        u.Companion companion = u.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
        boolean e16 = u.Companion.e(companion, ctx, false, 2, null);
        QLog.i("ZPlanLoadingRecordManager_", 1, "canShowRecordAvatar isFolderScreenMode:" + e16);
        return !e16;
    }

    public final String d(String dressKey, boolean isNightMode) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        if (!ZPlanFeatureSwitch.f369852a.x0()) {
            QLog.i("ZPlanLoadingRecordManager_", 1, "getFirstFrameStaticImagePath disable");
            return null;
        }
        String c16 = c(dressKey, isNightMode);
        if (new File(c16).exists()) {
            return c16;
        }
        return null;
    }

    public final boolean e(String dressKey, boolean isNightMode) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        return new File(c(dressKey, isNightMode)).exists();
    }

    public final void f(final String srcPath, String dressKey, boolean isNightMode) {
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        if (!ZPlanFeatureSwitch.f369852a.x0()) {
            QLog.i("ZPlanLoadingRecordManager_", 1, "saveFirstFrameStaticImage disable");
        } else {
            final String c16 = c(dressKey, isNightMode);
            ThreadManagerV2.excute(new Runnable() { // from class: c84.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.g(srcPath, c16);
                }
            }, 64, null, true);
        }
    }

    private final String c(String dressKey, boolean isNightMode) {
        String str;
        if (isNightMode) {
            str = "night";
        } else {
            str = MiniAppConst.MENU_STYLE_LIGHT;
        }
        String str2 = com.tencent.sqshow.zootopia.avatar.filament.a.f369963a.b() + "/" + dressKey + "_0_" + str + ".png";
        QLog.i("ZPlanLoadingRecordManager_", 1, "getFrameSavePath, savePath=" + str2);
        return str2;
    }
}
