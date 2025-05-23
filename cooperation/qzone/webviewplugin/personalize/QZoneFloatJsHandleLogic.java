package cooperation.qzone.webviewplugin.personalize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneFloatJsHandleLogic {
    public static final String TAG = "QZoneFloatJsHandleLogic";
    private static String data = "";
    public static String url = "";
    private static SurfaceView view;

    public static void handleDownLoadFloatFinish(WebViewPlugin.b bVar, String... strArr) {
        if (bVar == null || bVar.e() == null || bVar.a() == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) bVar.a().findViewById(R.id.webview);
        SurfaceView surfaceView = view;
        if (surfaceView != null && surfaceView.getParent() == frameLayout) {
            QZoneHelper.resumeQZoneFloatObjectView(bVar.a(), view);
            return;
        }
        url = bVar.e().getUrl();
        if (strArr != null) {
            data = strArr[0];
        }
        if (TextUtils.isEmpty(data)) {
            return;
        }
        SurfaceView createQZoneFloatObjectView = QZoneHelper.createQZoneFloatObjectView(bVar.a(), data);
        view = createQZoneFloatObjectView;
        if (createQZoneFloatObjectView != null) {
            frameLayout.addView(createQZoneFloatObjectView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public static void handleSetFloatFinish(WebViewPlugin.b bVar, String... strArr) {
        Activity a16;
        SurfaceView surfaceView;
        if (bVar == null || (a16 = bVar.a()) == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) a16.findViewById(R.id.webview);
        if (frameLayout != null && (surfaceView = view) != null) {
            frameLayout.removeView(surfaceView);
        }
        QZoneHelper.stopQZoneFloatObjectView(a16, view);
        view = null;
        Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_WEB_JS_TO_QZONE);
        Bundle bundle = new Bundle();
        bundle.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_SETFLOAT);
        bundle.putString("data", data);
        intent.putExtras(bundle);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "actionString: " + intent.getAction());
        }
        QZoneHelper.forwardToQzoneTransluentActivity(a16, QZoneHelper.UserInfo.getInstance(), intent);
        QZoneWebViewJsHandleLogic.doRefreshFeed(a16);
        a16.finish();
        if (QZoneHelper.isInFloatItemBlacklist()) {
            ToastUtil.a().f(QZoneHelper.STR_TIPS_FLOAT_ITEM_NOT_ALLOW_TO_SHOW, 1);
        }
    }
}
