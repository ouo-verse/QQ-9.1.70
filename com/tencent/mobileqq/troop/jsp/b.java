package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.biz.troop.b f297707d;

    /* renamed from: e, reason: collision with root package name */
    protected AtomicBoolean f297708e;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f297707d = null;
            this.f297708e = new AtomicBoolean(false);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "troopAssistantFeeds";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).longValue();
        }
        return 3L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if ("troopAssistantFeeds".equals(str2)) {
            if ("openGroupCard".equals(str3) && strArr.length > 0) {
                r(strArr[0]);
                return true;
            }
            if ("openGroupMemCard".equals(str3) && strArr.length > 0) {
                t(strArr[0]);
                return true;
            }
            if ("openGroupAIO".equals(str3) && strArr.length > 0) {
                q(strArr[0]);
                return true;
            }
            if ("openGroupFileDetail".equals(str3) && strArr.length > 0) {
                openFile(strArr[0]);
                return true;
            }
            if ("openGroupPhotoDetail".equals(str3) && strArr.length > 0) {
                p(strArr[0]);
                return true;
            }
            if ("openVideo".equals(str3) && strArr.length > 0) {
                u(strArr[0]);
                return true;
            }
            if ("openGroupFeedsDetail".equals(str3) && strArr.length > 0) {
                s(strArr[0]);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onDestroy();
        try {
            com.tencent.biz.troop.b bVar = this.f297707d;
            if (bVar != null) {
                bVar.q();
            }
        } catch (Exception unused) {
        } catch (Throwable th5) {
            this.f297708e.set(false);
            throw th5;
        }
        this.f297708e.set(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void openFile(String str) {
        String str2;
        String string;
        long j3;
        long j16;
        String string2;
        String string3;
        int i3;
        String optString;
        long optLong;
        Activity a16;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + str);
            }
            JSONObject jSONObject = new JSONObject(str);
            string = jSONObject.getString("uuid");
            try {
                j3 = jSONObject.getLong("fileSize");
                j16 = jSONObject.getLong("gcode");
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + e16.toString());
                }
                j3 = 0;
                j16 = 0;
            }
            string2 = jSONObject.getString(WadlProxyConsts.PARAM_FILENAME);
            string3 = jSONObject.getString("url");
            i3 = jSONObject.getInt("bisID");
            optString = jSONObject.optString(AppConstants.Key.COLUMN_MSG_SENDER_UIN);
            optLong = jSONObject.optLong("lastTime");
            a16 = this.mRuntime.a();
            intent = new Intent(a16, (Class<?>) TroopFileDetailBrowserActivity.class);
            str2 = "TroopAssistantFeedsJsHandler";
        } catch (Exception e17) {
            e = e17;
            str2 = "TroopAssistantFeedsJsHandler";
            if (!QLog.isColorLevel()) {
            }
        }
        try {
            intent.putExtra("from_webview", true);
            intent.putExtra("bisId", i3);
            intent.putExtra("sender_uin", optString);
            intent.putExtra("last_time", optLong);
            ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
            forwardFileInfo.w(4);
            forwardFileInfo.N(10006);
            forwardFileInfo.y(string2);
            forwardFileInfo.z(j3);
            forwardFileInfo.B(j16);
            forwardFileInfo.Z(string);
            forwardFileInfo.M(string3);
            intent.putExtra("fileinfo", forwardFileInfo);
            a16.startActivity(intent);
        } catch (Exception e18) {
            e = e18;
            if (!QLog.isColorLevel()) {
                QLog.d(str2, 2, "openFile:" + e.toString());
            }
        }
    }

    protected void p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openQZoneAlbumDetail:" + str);
            }
            String string = new JSONObject(str).getString("url");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            AppInterface b16 = this.mRuntime.b();
            Activity a16 = this.mRuntime.a();
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = b16.getCurrentAccountUin();
            userInfo.nickname = "";
            QZoneHelper.forwardToQunAlbumDetail(a16, userInfo, string, QZoneHelper.QZoneAppConstants.REFER_QQ_CHAT_QZONE_NEWEST_FEED, -1);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openQZoneAlbumDetail:" + e16.toString());
            }
        }
    }

    protected void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopAIO:" + str);
            }
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("guin");
            String string2 = jSONObject.getString("gcode");
            String string3 = jSONObject.getString("gname");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Activity a16 = this.mRuntime.a();
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(a16), null);
                m3.putExtra("uin", string2);
                m3.putExtra("troop_uin", string);
                m3.putExtra("uintype", 1);
                m3.putExtra("uinname", string3);
                a16.startActivity(m3);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopAIO:" + e16.toString());
            }
        }
    }

    protected void r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopCard:" + str);
            }
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("guin");
            String string2 = jSONObject.getString("gcode");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Activity a16 = this.mRuntime.a();
                Bundle b16 = aq.b(String.valueOf(string2), 6);
                b16.putString(AppConstants.Key.TROOP_CODE, string);
                b16.putString("troop_uin", string2);
                b16.putInt("troop_uin", 6);
                TroopUtils.I(a16, b16, 2);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopCard:" + e16.toString());
            }
        }
    }

    protected void s(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopFeeds:" + str);
            }
            if (TextUtils.isEmpty(new JSONObject(str).getString("url"))) {
                return;
            }
            QQToast.makeText(this.mRuntime.a(), 0, HardCodeUtil.qqStr(R.string.ubf), 0).show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopFeeds:" + e16.toString());
            }
        }
    }

    protected void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopMemberCard:" + str);
            }
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("guin");
            String string2 = jSONObject.getString("gcode");
            String string3 = jSONObject.getString("muin");
            String currentAccountUin = this.mRuntime.b().getCurrentAccountUin();
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(currentAccountUin)) {
                Activity a16 = this.mRuntime.a();
                Intent profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(a16, null);
                profileCardIntentOnly.putExtra("troopUin", string2);
                profileCardIntentOnly.putExtra(IProfileProtocolConst.PARAM_TROOP_CODE, string);
                profileCardIntentOnly.putExtra("memberUin", string3);
                profileCardIntentOnly.putExtra("fromFlag", 3);
                a16.startActivity(profileCardIntentOnly);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopMemberCard:" + e16.toString());
            }
        }
    }

    protected void u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.getString("guin");
            jSONObject.getString("gcode");
            v(jSONObject.getString("videourl"));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void v(String str) {
        String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideoInBrowserActivity:" + str);
            }
            Activity a16 = this.mRuntime.a();
            String trim = str.trim();
            String currentAccountUin = this.mRuntime.b().getCurrentAccountUin();
            Intent intent = new Intent(a16, (Class<?>) QQBrowserDelegationActivity.class);
            StringBuilder sb5 = new StringBuilder(trim);
            if (trim.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) > 0) {
                str2 = "";
            }
            sb5.append(str2);
            sb5.append("&from=androidqq");
            intent.putExtra("param_force_internal_browser", true);
            intent.putExtra("injectrecommend", false);
            intent.putExtra("key_isReadModeEnabled", true);
            intent.putExtra("url", sb5.toString().trim());
            intent.putExtra("uin", currentAccountUin);
            intent.putExtra("friendUin", "");
            a16.startActivity(intent);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideoInBrowserActivity:" + e16.toString());
            }
        }
    }
}
