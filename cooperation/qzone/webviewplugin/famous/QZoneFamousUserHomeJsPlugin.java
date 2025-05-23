package cooperation.qzone.webviewplugin.famous;

import android.content.Intent;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.qzone.reborn.albumx.qzonex.utils.d;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.qzone.reborn.route.QZoneUserHomeBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneJumpPageApi;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.statistic.access.concept.Global;
import ho.i;
import org.json.JSONException;
import org.json.JSONObject;
import xe.b;

/* loaded from: classes38.dex */
public class QZoneFamousUserHomeJsPlugin extends WebViewPlugin {
    public static String KEY_NICKNAME = "key_nickname";
    public static String KEY_UIN = "key_uin";
    public static String PKG_NAME = "QZFamousUserHome";
    public static String REFER = "famous";
    private static final String TAG = "QZoneFamousUserHomeJsPlugin";
    public static String USERALBUM = "useralbum";
    public static String USERHOME = "userhome";
    public static String USERMOODLIST = "usermoodlist";

    private void openAlbum(String... strArr) {
        try {
            long j3 = new JSONObject(strArr[0]).getLong("uin");
            if (d.a()) {
                QLog.i(TAG, 1, "openAlbum  context = " + this.mRuntime.a() + " | uin = " + j3);
                QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean = new QZAlbumxMainPageInitBean(String.valueOf(j3));
                qZAlbumxMainPageInitBean.setFrom(REFER);
                i.x().i(this.mRuntime.a(), qZAlbumxMainPageInitBean, null);
            } else {
                Intent intent = new Intent();
                QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.PERSONAL_ALBUM);
                intent.putExtra(QZoneHelper.QZoneAlbumConstants.KEY_LEFT_TAB_TITLE, this.mRuntime.a().getString(R.string.gaz));
                intent.putExtra("key_right_tab_title", this.mRuntime.a().getString(R.string.gcb));
                intent.putExtra("key_album_owner_uin", j3);
                intent.putExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_TAB, 0);
                intent.putExtra("refer", REFER);
                QzonePluginProxyActivity.launchPluingActivityForResult(this.mRuntime.a(), this.mRuntime.b().getAccount(), intent, 0);
            }
        } catch (JSONException e16) {
            b.f447841a.d(e16);
        }
    }

    private void openUserHome(String... strArr) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            long j3 = jSONObject.getLong("uin");
            int i3 = jSONObject.has("actiontype") ? jSONObject.getInt("actiontype") : 0;
            int i16 = jSONObject.has(ProfileCardDtReportUtil.DT_REPORT_PARAM_COVER_TYPE) ? jSONObject.getInt(ProfileCardDtReportUtil.DT_REPORT_PARAM_COVER_TYPE) : 0;
            if (jSONObject.has(AlbumCacheData.ACTIONURL)) {
                str = jSONObject.optString(AlbumCacheData.ACTIONURL);
            } else {
                str = "";
            }
            QZoneUserHomeBean qZoneUserHomeBean = new QZoneUserHomeBean();
            qZoneUserHomeBean.setUin(j3);
            if (i3 <= 0) {
                i3 = i16;
            }
            qZoneUserHomeBean.setActionType(i3);
            qZoneUserHomeBean.setActionUrl(str);
            i.z().n(this.mRuntime.a(), qZoneUserHomeBean);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void openUserMoodList(String... strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            i.j().b(this.mRuntime.a(), new QZoneMoodListInitBean(jSONObject.getLong("uin"), jSONObject.getString("nick"), REFER));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return PKG_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!PKG_NAME.equals(str2)) {
            return false;
        }
        if (str3.equals(USERMOODLIST)) {
            if (strArr != null && strArr.length > 0) {
                openUserMoodList(strArr);
            }
            return true;
        }
        if (str3.equals(USERALBUM)) {
            if (strArr != null && strArr.length > 0) {
                openAlbum(strArr);
            }
            return true;
        }
        if (!str3.equals(USERHOME)) {
            return false;
        }
        if (strArr != null && strArr.length > 0) {
            openUserHome(strArr);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        try {
            QLog.d(TAG, 1, "[createWebView] isCallToProfileCard: " + ((IQZoneJumpPageApi) QRoute.api(IQZoneJumpPageApi.class)).isCallToProfileCard(Global.getContext()));
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[createWebView] error: ", th5);
        }
    }
}
