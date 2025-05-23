package com.tencent.mobileqq.mini.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mini/sdk/MiniAppCompatibleLauncher;", "", "()V", "TAG", "", "WX_APPID_PREFIX", "launchMiniApp", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Lcom/tencent/mobileqq/mini/sdk/LaunchParam;", "slotId", "", "launchMiniAppByAppId", "context", "Landroid/content/Context;", "appId", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppCompatibleLauncher {
    public static final MiniAppCompatibleLauncher INSTANCE = new MiniAppCompatibleLauncher();
    private static final String TAG = "MiniAppCompatibleLauncher";
    private static final String WX_APPID_PREFIX = "wx";

    MiniAppCompatibleLauncher() {
    }

    public final void launchMiniApp(Activity activity, MiniAppInfo miniAppInfo, LaunchParam launchParam, int slotId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        if (miniAppInfo.isWxMiniApp()) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(activity, miniAppInfo.appId, "", 3401);
            return;
        }
        try {
            if (TextUtils.isEmpty(miniAppInfo.downloadUrl)) {
                MiniAppLauncher.launchMiniAppById(activity, launchParam, null);
            } else {
                MiniAppLauncher.launchAppByAppInfo(activity, miniAppInfo, 3401, slotId);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "startMiniApp exception: ", e16);
        }
    }

    public final void launchMiniAppByAppId(Context context, String appId, LaunchParam launchParam) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        if (!(appId == null || appId.length() == 0)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(appId, "wx", false, 2, null);
            if (startsWith$default) {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(context, appId, "", launchParam.scene);
                return;
            } else {
                MiniAppLauncher.launchMiniAppById(context, launchParam, null);
                return;
            }
        }
        QLog.e(TAG, 1, "launchMiniAppByAppId appId invalid");
    }
}
