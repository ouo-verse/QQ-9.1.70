package cooperation.qzone.webviewplugin;

import NS_QMALL_COVER.AlbumThemeSkin;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.magicface.model.f;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.IQzoneGiftFullScreenViewController;
import cooperation.qzone.QzoneGiftFullScreenActionManager;
import cooperation.qzone.QzoneGiftFullScreenViewController;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZonePassivePraiseJsPlugin extends QzoneInternalWebViewPlugin implements WebEventListener {
    public static final String NAMESPACE = "Qzone";
    public static final String QZONE_GIFTDETAILPAGE_URL = "https://h5.qzone.qq.com/gift/detail?_wv=2097155&uin={uin}&ugcid={ugcid}";
    private static final String TAG = "QZoneGiftFullScreenJsPlugin";
    private String downloadCMD = "";
    private QzoneGiftFullScreenViewController giftController = null;

    private void checkAnimationRs(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String[] strArr) {
        String str;
        JSONObject jSONObject;
        String str2 = "";
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int i3 = 0;
        if (strArr[0] != null) {
            try {
                jSONObject = new JSONObject(strArr[0]);
                str = jSONObject.getString("zipUrl");
            } catch (JSONException e16) {
                e = e16;
                str = "";
            }
            try {
                str2 = jSONObject.getString("callback");
            } catch (JSONException e17) {
                e = e17;
                e.printStackTrace();
                if (TextUtils.isEmpty(str)) {
                    return;
                } else {
                    return;
                }
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            File file = new File(QzoneGiftFullScreenActionManager.getPassiveFullScreenFolderPath(MD5Utils.toMD5(str.replace("sbig", f.d()))) + f.d());
            if (file.exists() && file.isDirectory()) {
                i3 = 1;
            }
            if (this.parentPlugin != null) {
                this.parentPlugin.callJs("window." + str2 + "({checked:" + i3 + "})");
            }
        }
    }

    private void downloadAnimationRs(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, final String[] strArr) {
        bVar.b().getHandler(QzoneDeviceTagJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZonePassivePraiseJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                JSONObject jSONObject;
                String[] strArr2 = strArr;
                if (strArr2 == null || strArr2.length <= 0 || strArr2[0] == null) {
                    return;
                }
                try {
                    jSONObject = new JSONObject(strArr[0]);
                    str = jSONObject.getString("zipUrl");
                } catch (JSONException e16) {
                    e = e16;
                    str = "";
                }
                try {
                    QZonePassivePraiseJsPlugin.this.downloadCMD = jSONObject.getString("callback");
                } catch (JSONException e17) {
                    e = e17;
                    e.printStackTrace();
                    if (TextUtils.isEmpty(str)) {
                        return;
                    } else {
                        return;
                    }
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(QZonePassivePraiseJsPlugin.this.downloadCMD)) {
                    return;
                }
                RemoteHandleManager.getInstance().getSender().downloadPassivePraise("", str);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void playAnimation(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String[] strArr) {
        String str;
        JSONObject jSONObject;
        final String str2 = "";
        if (strArr == null || strArr.length <= 0 || strArr[0] == null) {
            return;
        }
        try {
            jSONObject = new JSONObject(strArr[0]);
            str = jSONObject.getString("zipUrl");
        } catch (JSONException e16) {
            e = e16;
            str = "";
        }
        try {
            str2 = jSONObject.getString("callback");
        } catch (JSONException e17) {
            e = e17;
            e.printStackTrace();
            if (TextUtils.isEmpty(str2)) {
            }
        }
        if (TextUtils.isEmpty(str2)) {
            String passiveFullScreenFolderPath = QzoneGiftFullScreenActionManager.getPassiveFullScreenFolderPath(MD5Utils.toMD5(str.replace("sbig", f.d())));
            File file = new File(passiveFullScreenFolderPath);
            if (file.exists() && file.isDirectory()) {
                this.giftController = new QzoneGiftFullScreenViewController(this.parentPlugin.mRuntime.a());
                if (QzoneGiftFullScreenViewController.isSupportMagicface()) {
                    this.giftController.playMaigcface(str, passiveFullScreenFolderPath, true, new IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener() { // from class: cooperation.qzone.webviewplugin.QZonePassivePraiseJsPlugin.2
                        @Override // cooperation.qzone.IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener
                        public void giftFullScreenPlayEnd() {
                            if (QZonePassivePraiseJsPlugin.this.parentPlugin != null) {
                                QZonePassivePraiseJsPlugin.this.parentPlugin.callJs("window." + str2 + "({playAnimationFinish:1})");
                            }
                        }
                    });
                }
            }
        }
    }

    private void refreshPassiveFeeds() {
        RemoteHandleManager.getInstance().getSender().refreshPassiveFeeds();
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if ("Qzone".equals(str2) && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (QZoneJsConstants.METHOD_CHECK.equalsIgnoreCase(str3)) {
                WebViewPlugin webViewPlugin2 = this.parentPlugin;
                checkAnimationRs(webViewPlugin2, webViewPlugin2.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_DOWNLOAD.equalsIgnoreCase(str3)) {
                RemoteHandleManager.getInstance().addWebEventListener(this);
                WebViewPlugin webViewPlugin3 = this.parentPlugin;
                downloadAnimationRs(webViewPlugin3, webViewPlugin3.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_PLAY.equalsIgnoreCase(str3)) {
                WebViewPlugin webViewPlugin4 = this.parentPlugin;
                playAnimation(webViewPlugin4, webViewPlugin4.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_ALBUM_THEME.equalsIgnoreCase(str3)) {
                WebViewPlugin webViewPlugin5 = this.parentPlugin;
                chageAlbumTheme(webViewPlugin5, webViewPlugin5.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_HIGH_FIVE_FROM_LIKE_LIST.equalsIgnoreCase(str3)) {
                refreshPassiveFeeds();
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        super.onDestroy();
    }

    private void chageAlbumTheme(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String[] strArr) {
        if (strArr == null || strArr.length <= 0 || strArr[0] == null) {
            return;
        }
        String str = "";
        AlbumThemeSkin albumThemeSkin = new AlbumThemeSkin();
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            int i3 = jSONObject.getInt("itemId");
            albumThemeSkin.iItemId = i3;
            if (i3 == -1) {
                RemoteHandleManager.getInstance().getSender().setAlbumTheme(0L, albumThemeSkin);
            } else {
                albumThemeSkin.strPicZipUrl = jSONObject.getString(QzoneZipCacheHelper.ZIPURL);
                albumThemeSkin.iColor = jSONObject.getInt("icolor");
                albumThemeSkin.lTabBarSelectedFontColor = jSONObject.getLong("tabBarFontColorSelected");
                albumThemeSkin.lTabBarUnselectedFontColor = jSONObject.getLong("tabBarFontColor");
                albumThemeSkin.lVideoButonColor = jSONObject.getLong("videoButonColor");
                albumThemeSkin.lVideoButtonBgColor = jSONObject.getLong("videoButtonBgColor");
                albumThemeSkin.lTabbarUnderLineColor = jSONObject.getLong("tabbarUnderLineColor");
                RemoteHandleManager.getInstance().getSender().setAlbumTheme(0L, albumThemeSkin);
                str = jSONObject.getString("callback");
                if (this.parentPlugin != null) {
                    this.parentPlugin.callJs("window." + str + "({})");
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        TextUtils.isEmpty(str);
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        String str2;
        if (bundle == null || !bundle.containsKey("data")) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "call js function,bundle is empty");
                return;
            }
            return;
        }
        if (RemoteHandleConst.CMD_DOWNLOAD_PASSIVE_PRAISE.equals(str)) {
            int i3 = bundle2.getInt(RemoteHandleConst.PARAM_FULLSCREEN_GIFT_DOWNLOADPROGRESS);
            if (i3 <= 0) {
                str2 = "-1";
            } else if (i3 < 100) {
                str2 = String.format("%.1f", Double.valueOf(i3 * 0.01d));
            } else {
                str2 = "1";
            }
            if (this.parentPlugin == null || TextUtils.isEmpty(this.downloadCMD)) {
                return;
            }
            this.parentPlugin.callJs("window." + this.downloadCMD + "({download:" + str2 + "})");
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        int indexOf;
        QzoneGiftFullScreenViewController qzoneGiftFullScreenViewController;
        if (j3 == 8589934601L) {
            String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_GIFTDETAILPAGE, "https://h5.qzone.qq.com/gift/detail?_wv=2097155&uin={uin}&ugcid={ugcid}");
            if (!TextUtils.isEmpty(config) && (indexOf = config.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) != -1) {
                String substring = config.substring(0, indexOf);
                if (!TextUtils.isEmpty(str) && str.startsWith(substring) && (qzoneGiftFullScreenViewController = this.giftController) != null) {
                    qzoneGiftFullScreenViewController.onBackEvent();
                }
            }
        }
        return super.handleEvent(str, j3, map);
    }
}
