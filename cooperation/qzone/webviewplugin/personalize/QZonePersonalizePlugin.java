package cooperation.qzone.webviewplugin.personalize;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.l;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.Map;

/* loaded from: classes38.dex */
public class QZonePersonalizePlugin extends WebViewPlugin implements l {
    public static final String CARDTAG = "QZoneCardLogic";
    public static final String TAG = "QZonePersonalizePlugin";
    private BroadcastReceiver preDownloadBrocastReceiver = new BroadcastReceiver() { // from class: cooperation.qzone.webviewplugin.personalize.QZonePersonalizePlugin.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            String str;
            String str2;
            CustomWebView e16;
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("intent is: ");
                sb5.append(intent == null ? "null" : "not null");
                QLog.d(QZonePersonalizePlugin.TAG, 4, sb5.toString());
            }
            if (intent != null && "QZoneCardPreDownload".equals(intent.getAction())) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("QZoneCardLogic.QZonePersonalizePlugin", 4, "QZoneCardPreDownload js receive setting action" + intent.getAction());
                }
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    str = extras2.getString("result");
                    str2 = extras2.getString("cardurl");
                } else {
                    str = "";
                    str2 = "";
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QZoneCardLogic.QZonePersonalizePlugin", 4, "QZoneCardPreDownload js receive cardurl:" + str2 + "\n dowonload result:" + str);
                }
                WebViewPlugin.b bVar = QZonePersonalizePlugin.this.mRuntime;
                if (bVar == null || bVar.e() == null || (e16 = QZonePersonalizePlugin.this.mRuntime.e()) == null) {
                    return;
                }
                e16.callJs("window.QzFeedDressJSInterface.onReceive({type:\"cardurl\",data:\"" + str2 + "\"});window.QzFeedDressJSInterface.onReceive({type:\"result\",data:\"success\"});");
                return;
            }
            if (intent == null || !QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_FACADE_QZONE_TO_JS.equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
                return;
            }
            int i3 = extras.getInt("ret");
            String string = extras.getString("imgDir");
            String string2 = extras.getString("imgNameList");
            if (QLog.isDevelopLevel()) {
                QLog.d(QZonePersonalizePlugin.TAG, 4, "receive ret:" + i3 + "|imgDir:" + string + "|imgNameList:" + string2);
            }
            WebViewPlugin.b bVar2 = QZonePersonalizePlugin.this.mRuntime;
            if (bVar2 == null || bVar2.e() == null) {
                return;
            }
            if (i3 == 0) {
                QZonePersonalizePlugin.this.callJs("window.QzAvatarDressJSInterface.onReceive({type:\"result\",data:\"success\",imgDir:\"" + string + "\",imgNameList:\"" + string2 + "\"});");
                return;
            }
            QZonePersonalizePlugin.this.callJs("window.QzAvatarDressJSInterface.onReceive({type:\"result\",data:\"fail\"});");
        }
    };

    @Override // com.tencent.mobileqq.webview.swift.l
    public String[] getMultiNameSpace() {
        return new String[]{QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_NAMESPACE, QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_NAMESPACE, QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_NAMESPACE};
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        if (QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_NAMESPACE.equals(str) || QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_NAMESPACE.equals(str) || QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_NAMESPACE.equals(str)) {
            return 2L;
        }
        return super.getWebViewEventByNameSpace(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest \n url: " + str + "\n pkgName:" + str2 + "\n method:" + str3);
        }
        if (QZoneJsConstants.isForce(str3)) {
            LocalMultiProcConfig.putBool(QZoneJsConstants.TAG_QZONE_FORCE_REFREASH, true);
            LocalMultiProcConfig.putBool(QZoneJsConstants.TAG_QZONE_FORCE_REFREASH_PASSIVE, true);
        }
        if (str2.equals(QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_NAMESPACE)) {
            if (str3.equals(QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_CLOSECARDPREVIEW)) {
                return true;
            }
            if (str3.equals(QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_SETCARDFINISH)) {
                QZoneCardJsHandleLogic.handleSetSkinFinish(this, this.mRuntime, strArr);
            }
            if (str3.equals(QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_DOWNLOADCARD)) {
                QZoneCardJsHandleLogic.handleDownCardMethod(this.mRuntime, strArr);
                return true;
            }
        } else if (str2.equals(QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_NAMESPACE)) {
            if (str3.equals(QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_DOWNLOAD)) {
                QZoneFacadeJsHandleLogic.handleDownloadFacadeFinish(this.mRuntime, strArr);
            } else if (str3.equals(QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR)) {
                QZoneFacadeJsHandleLogic.handleSetFacadeFinish(this.mRuntime, strArr);
            } else if (str3.equalsIgnoreCase(QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_CHECKIDLIST)) {
                QZoneFacadeJsHandleLogic.handleCheckDownloadedIdList(this.mRuntime, new String[0]);
            }
        } else if (str2.equals(QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_NAMESPACE)) {
            if (str3.equals(QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_DOWNLOADFLOAT)) {
                QZoneFloatJsHandleLogic.handleDownLoadFloatFinish(this.mRuntime, strArr);
                return true;
            }
            if (str3.equals(QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_SETFLOAT)) {
                QZoneFloatJsHandleLogic.handleSetFloatFinish(this.mRuntime, strArr);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        registerBroadcastReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        unRegisterBroadcastReceiver();
    }

    public void registerBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("QZoneCardPreDownload");
        intentFilter.addAction(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_FACADE_QZONE_TO_JS);
        BaseApplication.getContext().registerReceiver(this.preDownloadBrocastReceiver, intentFilter);
    }

    public void unRegisterBroadcastReceiver() {
        BaseApplication.getContext().unregisterReceiver(this.preDownloadBrocastReceiver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 != 2 || !str.equals(QZoneFloatJsHandleLogic.url)) {
            return false;
        }
        QZoneFloatJsHandleLogic.handleDownLoadFloatFinish(this.mRuntime, null);
        return false;
    }
}
