package cooperation.qzone.webviewplugin.personalize;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneZebraAlbumJsHandleLogic {
    public static final String TAG = "QZoneZebraAlbumJsHandleLogicQZonePersonalizePlugin";

    public static void handleCleanZebraNum(WebViewPlugin.b bVar, String... strArr) {
        Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_WEB_JS_TO_QZONE);
        Bundle bundle = new Bundle();
        bundle.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.ZEBARALBUM_METHOD_CLEANZEBRANUM);
        intent.putExtras(bundle);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "actionString: " + intent.getAction());
        }
        QZoneHelper.forwardToQzoneTransluentActivity(bVar.a(), QZoneHelper.UserInfo.getInstance(), intent);
    }
}
