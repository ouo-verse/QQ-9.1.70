package com.tencent.qqmini.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.action.FavoritesAction;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.action.RestartAction;
import com.tencent.qqmini.sdk.action.ShareAction;
import com.tencent.qqmini.sdk.action.UpdateUIAction;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class DefaultMoreItemSelectedListener implements OnMoreItemSelectedListener {
    private static final String TAG = "DefaultMoreItemSelectedListener";
    private static MiniAppProxy sMiniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
    private static ChannelProxy sChannelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);

    private String onAboutSelect(IMiniAppContext iMiniAppContext, Activity activity, MiniAppInfo miniAppInfo) {
        if (activity != null && miniAppInfo != null) {
            startAboutPage(activity, miniAppInfo, GetShareState.obtain(iMiniAppContext));
            return "about";
        }
        return "about";
    }

    private String onComplaintSelect(Activity activity, MiniAppInfo miniAppInfo) {
        if (activity != null && miniAppInfo != null) {
            startComplaintPage(activity, miniAppInfo.appId);
            return "report";
        }
        return "report";
    }

    private String onFavoriteSelect(MiniAppInfo miniAppInfo) {
        int i3;
        if (miniAppInfo.topType == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        miniAppInfo.topType = i3;
        sChannelProxy.setUserAppTop(miniAppInfo, null);
        if (miniAppInfo.topType == 1) {
            return "settop_on";
        }
        return "settop_off";
    }

    private void reportClick(IMiniAppContext iMiniAppContext, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SDKMiniProgramLpReportDC04239.reportUserClick(iMiniAppContext.getMiniAppInfo(), SDKMiniProgramLpReportDC04239.getAppType(iMiniAppContext.getMiniAppInfo()), PageAction.obtain(iMiniAppContext).getPageUrl(), "user_click", "more_button", str);
    }

    private void startAboutPage(Activity activity, MiniAppInfo miniAppInfo, ShareState shareState) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("mini_app_info", miniAppInfo);
        intent.putExtra("versionType", miniAppInfo.version);
        MiniFragmentLauncher.start(activity, intent, MiniFragmentLauncher.FragmentType.FRAGMENT_MAIN_PAGE);
    }

    private void startComplaintPage(Activity activity, String str) {
        String str2;
        if (activity != null && str != null) {
            try {
                str2 = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                QMLog.e(TAG, "startComplainAndCallback, url = ");
                e16.printStackTrace();
                str2 = "";
            }
            String str3 = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + str + "&openid=" + LoginManager.getInstance().getAccount() + "&avatar=" + str2 + "&nickname=\u6e38\u5ba2";
            Intent intent = new Intent();
            intent.putExtra("url", str3);
            intent.putExtra("title", "\u6295\u8bc9\u4e0e\u53cd\u9988");
            Bundle bundle = new Bundle();
            bundle.putBoolean("hide_more_button", true);
            intent.putExtras(bundle);
            sMiniAppProxy.startBrowserActivity(activity, intent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener
    public void onMoreItemSelected(IMiniAppContext iMiniAppContext, int i3) {
        String str;
        if (iMiniAppContext == null) {
            return;
        }
        if (i3 >= 100 && i3 <= 200) {
            Bundle bundle = new Bundle();
            bundle.putInt(ShareAction.KEY_SHARE_ITEM_ID, i3);
            iMiniAppContext.performAction(ShareAction.obtain(7, bundle));
            reportClick(iMiniAppContext, SDKMiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_OTHER + i3);
            return;
        }
        Activity attachActivity = iMiniAppContext.getAttachActivity();
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        switch (i3) {
            case -1:
                str = "cancel";
                break;
            case 0:
                str = "cancel_system";
                break;
            case 1:
                iMiniAppContext.performAction(ShareAction.obtain(1));
                str = "share_QQ";
                break;
            case 2:
                iMiniAppContext.performAction(ShareAction.obtain(2));
                str = "share_QZ";
                break;
            case 3:
                iMiniAppContext.performAction(ShareAction.obtain(3));
                str = "share_WX";
                break;
            case 4:
                iMiniAppContext.performAction(ShareAction.obtain(4));
                str = "share_Moments";
                break;
            case 5:
                str = onAboutSelect(iMiniAppContext, attachActivity, miniAppInfo);
                break;
            case 6:
                str = onComplaintSelect(attachActivity, miniAppInfo);
                break;
            case 7:
                UpdateUIAction.toggleDebugPanel(iMiniAppContext);
                MiniToast.makeText(attachActivity, "\u8c03\u8bd5\u9762\u677f\u9700\u91cd\u542f\u751f\u6548", 1).show();
                str = "";
                break;
            case 8:
                UpdateUIAction.toggleMonitorPanel(iMiniAppContext);
                str = "";
                break;
            case 9:
                RestartAction.restart(iMiniAppContext);
                str = "";
                break;
            case 10:
                str = onFavoriteSelect(miniAppInfo);
                break;
            case 11:
                sMiniAppProxy.addShortcut(attachActivity, miniAppInfo, null);
                str = "add_desktop";
                break;
            case 12:
                iMiniAppContext.performAction(FavoritesAction.obtain(1));
                str = SDKMiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_QQ_FAVORITES;
                break;
            case 13:
                iMiniAppContext.performAction(ActionBridge.ExportLogFileBridge.obtain());
                str = "";
                break;
            default:
                str = "";
                break;
        }
        reportClick(iMiniAppContext, str);
    }
}
