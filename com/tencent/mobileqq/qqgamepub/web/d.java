package com.tencent.mobileqq.qqgamepub.web;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static String f264814e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<Integer, String> f264815f;

    /* renamed from: d, reason: collision with root package name */
    protected String f264816d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f264817d;

        a(String str) {
            this.f264817d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) str);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            QLog.i("QQGamePub_QQGameWebViewJsPlugin", 1, "openStrategyPage ipc callback result:" + eIPCResult.code);
            if (eIPCResult.code == 0 && eIPCResult.data != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appId", eIPCResult.data.getInt("appId"));
                    jSONObject.put("questionId", eIPCResult.data.getLong("questionId"));
                    jSONObject.put("answerId", eIPCResult.data.getLong("answerId"));
                    d.this.x(this.f264817d, eIPCResult.data.getInt("code"), null, jSONObject.toString());
                } catch (JSONException e16) {
                    QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, e16, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f264819d;

        b(String str) {
            this.f264819d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) str);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            QLog.i("QQGamePub_QQGameWebViewJsPlugin", 1, "handleGamePublishQuestionIpc callback result:" + eIPCResult.code);
            if (eIPCResult.code == 0 && eIPCResult.data != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appId", eIPCResult.data.getInt("appId"));
                    jSONObject.put("questionId", eIPCResult.data.getLong("questionId"));
                    d.this.x(this.f264819d, eIPCResult.data.getInt("code"), null, jSONObject.toString());
                } catch (JSONException e16) {
                    QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, e16, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f264821a;

        c(JSONObject jSONObject) {
            this.f264821a = jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) jSONObject);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleRemoveCalendarRemind, onAllGranted");
            d.this.N(this.f264821a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDenied(list, list2);
            QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleRemoveCalendarRemind, onDenied");
            d dVar = d.this;
            dVar.x(dVar.f264816d, -2, "no permission", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqgamepub.web.d$d, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8336d extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f264823a;

        C8336d(JSONObject jSONObject) {
            this.f264823a = jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) jSONObject);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleAddCalendarRemind, onAllGranted");
            d.this.s(this.f264823a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                return;
            }
            super.onDenied(list, list2);
            QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleAddCalendarRemind, onDenied");
            d dVar = d.this;
            dVar.x(dVar.f264816d, -2, "no permission", null);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22408);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f264814e = "qqgame_api";
        HashMap hashMap = new HashMap();
        f264815f = hashMap;
        hashMap.put(1, "MO");
        hashMap.put(2, "TU");
        hashMap.put(3, "WE");
        hashMap.put(4, "TH");
        hashMap.put(5, "FR");
        hashMap.put(6, "SA");
        hashMap.put(7, "SU");
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int B() {
        return 1;
    }

    private void E(String str) {
        QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleAddCalendarRemind, json=", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f264816d = jSONObject.optString("callback");
            if (!GamePubAccountHelper.B()) {
                QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleAddCalendarRemind, disable");
                x(this.f264816d, -3, "calendar disabled", null);
                return;
            }
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(this.mRuntime.a(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_GAME_CENTER_CALENDAR, QQPermissionConstants.Business.SCENE.GAME_CENTER_CALENDAR_REMIND));
            if (qQPermission == null) {
                QLog.w("QQGamePub_QQGameWebViewJsPlugin", 1, "handleAddCalendarRemind qqPermission null");
                x(this.f264816d, -4, "permission null", null);
            } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_CALENDAR) != 0) {
                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_CALENDAR}, 2, new C8336d(jSONObject));
            } else {
                s(jSONObject);
            }
        } catch (Exception e16) {
            QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "handleAddCalendarRemind, get callback e=", e16);
        }
    }

    private void F(String str) {
        QLog.i("QQGamePub_QQGameWebViewJsPlugin", 1, "handleGameStrategyAnswerIpc callback:" + str);
        QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "callbackGameStrategyAnswer", null, new a(str));
    }

    private void G(String str) {
        QLog.i("QQGamePub_QQGameWebViewJsPlugin", 1, "handleGamePublishQuestionIpc callback:" + str);
        QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "callbackGameStrategyQuestion", null, new b(str));
    }

    private void H(String str) {
        QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleIsCalendarRemindExist, json=", str);
        try {
            this.f264816d = new JSONObject(str).optString("callback");
            if (!GamePubAccountHelper.B()) {
                QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleIsCalendarRemindExist, disable");
                x(this.f264816d, -3, "calendar disabled", null);
            } else {
                x(this.f264816d, -2, "no permission", null);
            }
        } catch (Exception e16) {
            QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "handleIsCalendarRemindExist, get callback exception=", e16);
        }
    }

    private void I(String str) {
        QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleRemoveCalendarRemind, json=", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f264816d = jSONObject.optString("callback");
            if (!GamePubAccountHelper.B()) {
                QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleRemoveCalendarRemind, disable");
                x(this.f264816d, -3, "calendar disabled", null);
                return;
            }
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(this.mRuntime.a(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_GAME_CENTER_CALENDAR, QQPermissionConstants.Business.SCENE.GAME_CENTER_CALENDAR_REMIND));
            if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_CALENDAR) != 0) {
                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_CALENDAR}, 2, new c(jSONObject));
            } else {
                N(jSONObject);
            }
        } catch (Exception e16) {
            QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "handleAddCalendarRemind, e=", e16);
        }
    }

    private void J(String str) {
        QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "handleShowKuiklyFloat, json=", str);
        try {
            ((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).openKuiklyFloatDialog(this.mRuntime.a(), new JSONObject(str));
        } catch (Throwable th5) {
            QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, th5, new Object[0]);
        }
    }

    private void K(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("business_type");
            this.f264816d = jSONObject.optString("callback");
            boolean parseBoolean = Boolean.parseBoolean(jSONObject.optString("isMulti", "false"));
            int optInt2 = jSONObject.optInt("limitNum");
            if (optInt == 2) {
                w(parseBoolean, optInt2);
            } else {
                v(jSONObject, optInt, parseBoolean, optInt2);
            }
        } catch (Exception unused) {
            QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "");
            errorCallBack();
        }
    }

    private void L(String str, String str2) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_QQGameWebViewJsPlugin", 2, "openStrategyPage:", str2);
            }
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("appId");
            int optInt2 = jSONObject.optInt("miniGameAppId");
            String optString = jSONObject.optString("callback");
            int optInt3 = jSONObject.optInt("scene");
            String optString2 = jSONObject.optString("data");
            this.f264816d = optString;
            String optString3 = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
            if ("openStrategyQuestion".equals(str)) {
                if (!u(optInt3)) {
                    return;
                }
                ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameStrategyQuestion(MobileQQ.sMobileQQ, optInt, optString3, optString2, optInt3, optInt2);
                G(optString);
                return;
            }
            if (!"openStrategyAnswer".equals(str) || !u(optInt3)) {
                return;
            }
            ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameStrategyAnswer(MobileQQ.sMobileQQ, optInt, jSONObject.optLong("questionId"), jSONObject.optString("questionTitle"), optString3, optString2, optInt3, optInt2);
            F(optString);
        } catch (JSONException e16) {
            QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, e16, new Object[0]);
            x(this.f264816d, -1, "json parse error", null);
        }
    }

    private void M(String str, String str2) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_QQGameWebViewJsPlugin", 2, "openTransparentMiddlePage:", str2);
            }
            JSONObject jSONObject = new JSONObject(str2);
            ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openTransparentPage(this.mRuntime.a(), jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL), jSONObject.optInt("miniAppId"));
        } catch (JSONException e16) {
            QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(JSONObject jSONObject) {
        if (jSONObject != null) {
            int e16 = py3.b.e(MobileQQ.sMobileQQ.getContentResolver(), ContentUris.withAppendedId(Uri.parse("content://com.android.calendar/events"), jSONObject.optLong("calendarEventId")), null, null);
            if (e16 == -1) {
                QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "removeCalendarRemind, result=", Integer.valueOf(e16));
                x(this.f264816d, -1, "remove calendar event failed", null);
            } else {
                x(this.f264816d, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, null);
            }
        }
    }

    private boolean O(List<String> list, List<String> list2, List<Integer> list3, List<Integer> list4) {
        if (list != null && list2 != null && list3 != null && list4 != null) {
            return true;
        }
        return false;
    }

    private void backH5Friends(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            ArrayList<ResultRecord> D = D(intent);
            if (D != null && D.size() != 0) {
                JSONObject A = A(intent, D);
                if (A != null) {
                    doCallback(this.f264816d, A.toString());
                    return;
                }
                return;
            }
            errorCallBack();
        } catch (Exception unused) {
            errorCallBack();
        }
    }

    private void doCallback(String str, String str2) {
        QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, "doCallback: " + str + " js: " + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            super.callJs(str, str2);
        }
    }

    private void errorCallBack() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", "-1");
            jSONObject.put("msg", "error, parameters wrong...");
        } catch (JSONException unused) {
        }
        QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, "errorCallBack: " + jSONObject);
        doCallback(this.f264816d, jSONObject.toString());
    }

    private Context getCurrentContext() {
        return ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).getCurrentContext(this.mRuntime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(JSONObject jSONObject) {
        Uri uri;
        Uri uri2;
        if (jSONObject == null) {
            return;
        }
        int B = B();
        if (B < 0) {
            QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "addCalendarRemind, invalid account id");
            x(this.f264816d, -1, "no calendar account", null);
            return;
        }
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("description");
        if (jSONObject.has("startTime") && jSONObject.has("endTime")) {
            long optLong = jSONObject.optLong("startTime") * 1000;
            long optLong2 = jSONObject.optLong("endTime") * 1000;
            if (optLong > optLong2) {
                QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "addCalendarRemind, endTime must >= startTime");
                x(this.f264816d, -1, "endTime must >= startTime", null);
                return;
            }
            String optString3 = jSONObject.optString("location");
            boolean optBoolean = jSONObject.optBoolean("isWeeklyRepeat");
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", optString);
            contentValues.put("calendar_id", Integer.valueOf(B));
            contentValues.put("eventTimezone", TimeZone.getDefault().getID());
            contentValues.put("description", optString2);
            contentValues.put("dtstart", Long.valueOf(optLong));
            contentValues.put("dtend", Long.valueOf(optLong2));
            if (!TextUtils.isEmpty(optString3)) {
                contentValues.put("eventLocation", optString3);
            }
            if (optBoolean) {
                contentValues.put("allDay", (Integer) 1);
                JSONArray optJSONArray = jSONObject.optJSONArray("repeatWeeklyDay");
                StringBuilder sb5 = new StringBuilder();
                if (optJSONArray != null) {
                    try {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            String str = f264815f.get(Integer.valueOf(optJSONArray.optInt(i3)));
                            if (!TextUtils.isEmpty(str)) {
                                sb5.append(str);
                                if (i3 != length - 1) {
                                    sb5.append(",");
                                }
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "addCalendarRemind, get weekday str exception=", e16);
                    }
                }
                contentValues.put("rrule", String.format("FREQ=WEEKLY;UNTIL=%sT000000Z;WKST=SU;BYDAY=%s", new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(optLong2)), sb5));
            }
            try {
                uri = MobileQQ.sMobileQQ.getContentResolver().insert(Uri.parse("content://com.android.calendar/events"), contentValues);
            } catch (Exception e17) {
                QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "addCalendarRemind, insert exception:", e17);
                uri = null;
            }
            if (uri == null) {
                QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "addCalendarRemind, addCalendarEvent null");
                x(this.f264816d, -1, "add calendar event failed", null);
                return;
            }
            long parseId = ContentUris.parseId(uri);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("event_id", Long.valueOf(parseId));
            contentValues2.put(TuxTimeView.TUX_TIME_STYLE_MINUTES, Integer.valueOf(jSONObject.optInt("advanceTime")));
            contentValues2.put("method", (Integer) 1);
            try {
                uri2 = MobileQQ.sMobileQQ.getContentResolver().insert(Uri.parse("content://com.android.calendar/reminders"), contentValues2);
            } catch (Throwable th5) {
                QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "addCalendarRemind, insert remind exception=", th5);
                uri2 = null;
            }
            if (uri2 == null) {
                QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "addCalendarRemind, add remind failed");
                x(this.f264816d, -1, "add calendar remind failed", null);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("calendarEventId", parseId);
                x(this.f264816d, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, jSONObject2.toString());
                return;
            } catch (JSONException e18) {
                QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "addCalendarRemind, do callback exception=", e18);
                return;
            }
        }
        QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, "addCalendarRemind, startTime and endTime required");
        x(this.f264816d, -1, "startTime and endTime required", null);
    }

    private void t(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            boolean booleanExtra = intent.getBooleanExtra("is_multi_selection", false);
            JSONArray jSONArray = new JSONArray();
            if (!booleanExtra) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("channelId", intent.getStringExtra("uin"));
                jSONObject.put("guildId", intent.getStringExtra("guild_id"));
                jSONArray.mo162put(jSONObject);
            } else {
                ArrayList<ResultRecord> parcelableArrayListExtra = intent.getParcelableArrayListExtra(AppConstants.Key.FORWARD_MULTI_TARGET);
                if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                    for (ResultRecord resultRecord : parcelableArrayListExtra) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("channelId", resultRecord.uin);
                        jSONObject2.put("guildId", resultRecord.guildId);
                        jSONArray.mo162put(jSONObject2);
                    }
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("guildInfos", jSONArray);
            doCallback(this.f264816d, jSONObject3.toString());
        } catch (Exception unused) {
            errorCallBack();
        }
    }

    private boolean u(int i3) {
        if (!((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).getSupportSceneSet().contains(Integer.valueOf(i3))) {
            x(this.f264816d, -4, "this scene not support,scene:" + i3, null);
            return false;
        }
        return true;
    }

    private void v(JSONObject jSONObject, int i3, boolean z16, int i16) {
        String str;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        Context currentContext = getCurrentContext();
        if (currentContext != null && jSONObject != null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString(WadlReportBuilder.TableElem.GAME_APPID);
            ArrayList<String> arrayList = new ArrayList<>();
            JSONObject optJSONObject = jSONObject.optJSONObject("from_group");
            if (optJSONObject != null) {
                String optString3 = optJSONObject.optString("group_uin");
                int optInt = optJSONObject.optInt("group_type");
                int optInt2 = optJSONObject.optInt("enable_select_all");
                int optInt3 = optJSONObject.optInt("enable_show_myself");
                int optInt4 = optJSONObject.optInt("enable_filter_robot");
                if (i3 == 1) {
                    i28 = optJSONObject.optInt(ISelectMemberActivityConstants.PARAM_GAME_INFO_FLAG);
                } else {
                    i28 = 0;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("group_members");
                if (optJSONArray != null) {
                    for (int i29 = 0; i29 < optJSONArray.length(); i29++) {
                        String optString4 = optJSONArray.optString(i29);
                        if (!TextUtils.isEmpty(optString4)) {
                            arrayList.add(optString4);
                        }
                    }
                }
                i27 = i28;
                i26 = optInt4;
                i19 = optInt3;
                i18 = optInt2;
                i17 = optInt;
                str = optString3;
            } else {
                str = null;
                i17 = 0;
                i18 = 0;
                i19 = 0;
                i26 = 0;
                i27 = 0;
            }
            if (z16) {
                if (i16 < 0) {
                    errorCallBack();
                } else {
                    super.startActivityForResult(C(currentContext, optString, i3, i16, str, i17, arrayList, i18, i19, i26, i27, optString2), (byte) 33);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, int i3, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i3);
            jSONObject.put("msg", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("data", new JSONObject(str3));
            }
        } catch (JSONException e16) {
            QLog.e("QQGamePub_QQGameWebViewJsPlugin", 1, e16, new Object[0]);
        }
        doCallback(str, jSONObject.toString());
    }

    private JSONArray y(List<String> list, List<String> list2, List<Integer> list3, List<Integer> list4, JSONArray jSONArray) throws JSONException {
        String str;
        int i3;
        int i16;
        if (O(list, list2, list3, list4)) {
            jSONArray = new JSONArray();
            for (int i17 = 0; i17 < list.size() && i17 < list2.size() && i17 < list3.size() && i17 < list4.size(); i17++) {
                String str2 = "";
                if (TextUtils.isEmpty(list.get(i17))) {
                    str = "";
                } else {
                    str = list.get(i17);
                }
                if (!TextUtils.isEmpty(list2.get(i17))) {
                    str2 = list2.get(i17);
                }
                if (list3.get(i17) != null) {
                    i3 = list3.get(i17).intValue();
                } else {
                    i3 = 0;
                }
                if (list4.get(i17) != null) {
                    i16 = list4.get(i17).intValue();
                } else {
                    i16 = 0;
                }
                if (i16 == 4 || i16 == 8) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("uin", str);
                    jSONObject.put("name", str2);
                    jSONObject.put("type", i16);
                    jSONObject.put("count", i3);
                    jSONArray.mo162put(jSONObject);
                }
            }
        }
        return jSONArray;
    }

    private void z(List<String> list, List<String> list2, List<Integer> list3, List<String> list4, JSONArray jSONArray) throws JSONException {
        String str;
        String str2;
        if (list != null && list2 != null) {
            for (int i3 = 0; i3 < list.size() && i3 < list2.size(); i3++) {
                String str3 = "";
                if (TextUtils.isEmpty(list.get(i3))) {
                    str = "";
                } else {
                    str = list.get(i3);
                }
                if (TextUtils.isEmpty(list2.get(i3))) {
                    str2 = "";
                } else {
                    str2 = list2.get(i3);
                }
                if (list4 != null && list4.size() - 1 >= i3 && !TextUtils.isEmpty(list4.get(i3))) {
                    str3 = list4.get(i3);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uin", str);
                jSONObject.put("name", str2);
                jSONObject.put("levelIcon", str3);
                if (list3 != null && list3.size() > i3) {
                    jSONObject.put("type", list3.get(i3));
                } else {
                    jSONObject.put("type", 1);
                }
                jSONArray.mo162put(jSONObject);
            }
        }
    }

    public JSONObject A(Intent intent, ArrayList<ResultRecord> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (JSONObject) iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent, (Object) arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        String stringExtra = intent.getStringExtra("group_uin");
        String stringExtra2 = intent.getStringExtra("group_name");
        int intExtra = intent.getIntExtra("group_type", 0);
        int intExtra2 = intent.getIntExtra("group_member_type", 0);
        if (stringExtra != null) {
            arrayList2.add(stringExtra);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            arrayList3.add(stringExtra2);
            arrayList4.add(Integer.valueOf(intExtra));
            arrayList5.add(Integer.valueOf(intExtra2));
        }
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        Iterator<ResultRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            arrayList6.add(next.uin);
            arrayList7.add(next.name);
            arrayList8.add(Integer.valueOf(intExtra));
            arrayList9.add(next.gameLevelIcon);
        }
        JSONObject jsBackJson = getJsBackJson(intent, arrayList6, arrayList7, arrayList8, arrayList9, arrayList2, arrayList3, arrayList5, arrayList4);
        QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, "doChooseFriendResult: " + jsBackJson);
        if (QLog.isColorLevel()) {
            QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, "doChooseFriendResult: " + jsBackJson);
        }
        return jsBackJson;
    }

    public Intent C(Context context, String str, int i3, int i16, String str2, int i17, ArrayList<String> arrayList, int i18, int i19, int i26, int i27, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Intent) iPatchRedirector.redirect((short) 10, this, context, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Integer.valueOf(i17), arrayList, Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), str3);
        }
        Intent startSelectMemberActivityIntentForJsPlugin = ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).getStartSelectMemberActivityIntentForJsPlugin(context);
        startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        if (i16 > 0) {
            startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_MAX, i16);
        }
        startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, str);
        startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 43);
        startSelectMemberActivityIntentForJsPlugin.putExtra("GAME_H5_SELECT_BUSINESS_TYPE", i3);
        startSelectMemberActivityIntentForJsPlugin.putExtra(ITroopUtilApi.GAME_H5_SELECT_GAME_APPID, str3);
        startSelectMemberActivityIntentForJsPlugin.addFlags(67108864);
        if (!TextUtils.isEmpty(str2) && (i17 == 4 || i17 == 8)) {
            startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_OVERLOAD_TIPS_INCLUDE_DEFAULT_COUNT, true);
            startSelectMemberActivityIntentForJsPlugin.putExtra("group_uin", str2);
            startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ENABLE_ALL_SELECT, i18 != 0);
            startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_SHOW_MYSELF, i19 != 0);
            startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_FILTER_ROBOT, i26 != 0);
            if (arrayList.size() > 0) {
                if (arrayList.size() > i16) {
                    arrayList.subList(i16, arrayList.size()).clear();
                }
                startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECTED_FRIENDS, arrayList);
            }
            if (i17 == 4) {
                startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, true);
                if (1 == i3) {
                    startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_GAME_INFO_FLAG, i27);
                }
            } else {
                startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_DISCUSSION_MEMBER, true);
            }
        } else {
            startSelectMemberActivityIntentForJsPlugin.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        }
        return startSelectMemberActivityIntentForJsPlugin;
    }

    public ArrayList<ResultRecord> D(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
        }
        return intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
    }

    protected JSONObject getJsBackJson(Intent intent, List<String> list, List<String> list2, List<Integer> list3, List<String> list4, List<String> list5, List<String> list6, List<Integer> list7, List<Integer> list8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (JSONObject) iPatchRedirector.redirect((short) 11, this, intent, list, list2, list3, list4, list5, list6, list7, list8);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            z(list, list2, list3, list4, jSONArray);
            JSONArray y16 = y(list5, list6, list7, list8, null);
            jSONObject.put("friends", jSONArray);
            if (y16 != null && y16.length() > 0) {
                jSONObject.put("groups", y16);
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return f264814e;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).longValue();
        }
        return 8589934621L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3), map)).booleanValue();
        }
        super.handleEvent(str, j3, map);
        if (j3 == 8589934621L) {
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    Integer num = (Integer) map.get("action");
                    if (num.intValue() != 1 && num.intValue() != 2 && num.intValue() != 3) {
                        if (num.intValue() == 4) {
                            jSONObject.put("action", num);
                            jSONObject.put("perfData", map.get("perfData"));
                        }
                    }
                    jSONObject.put("action", num);
                    if (map.containsKey("height")) {
                        jSONObject.put("height", map.get("height"));
                    }
                    if (map.containsKey("index")) {
                        jSONObject.put("index", map.get("index"));
                    }
                    if (map.containsKey("gameData")) {
                        jSONObject.put("gameData", map.get("gameData"));
                    }
                } catch (ClassCastException e16) {
                    e16.printStackTrace();
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            }
            dispatchJsEvent("gameFeedsEvent", jSONObject, null);
            return true;
        }
        if (j3 == 8589934625L) {
            dispatchJsEvent("gameFeedsPause", new JSONObject(), null);
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (f264814e.equals(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, "pkgName:" + str2 + " method:" + str3);
            }
            if ("notifyWebLoaded".equals(str3)) {
                Intent intent = new Intent("action_qgame_jaspi_webloaded");
                intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
                MobileQQ.sMobileQQ.sendBroadcast(intent);
                return true;
            }
            if ("playVideo".equals(str3)) {
                Intent intent2 = new Intent("action_qgame_h5_video_play");
                intent2.setPackage(MobileQQ.sMobileQQ.getPackageName());
                MobileQQ.sMobileQQ.sendBroadcast(intent2);
                return true;
            }
            if ("videoPause".equals(str3)) {
                Intent intent3 = new Intent("action_qgame_h5_video_pause");
                intent3.setPackage(MobileQQ.sMobileQQ.getPackageName());
                MobileQQ.sMobileQQ.sendBroadcast(intent3);
                return true;
            }
            if (VasCommonJsPlugin.H5_CALLBACK_GETFRIENDINFO.equals(str3)) {
                if (strArr.length <= 0) {
                    K(null);
                } else {
                    K(strArr[0]);
                }
                return true;
            }
            if (!"openStrategyQuestion".equals(str3) && !"openStrategyAnswer".equals(str3)) {
                if ("jumpTransparentMiddlePage".equals(str3)) {
                    M(str3, strArr[0]);
                    return true;
                }
                if ("addCalendarRemind".equals(str3)) {
                    E(strArr[0]);
                    return true;
                }
                if ("removeCalendarRemind".equals(str3)) {
                    I(strArr[0]);
                    return true;
                }
                if ("isCalendarRemindExist".equals(str3)) {
                    H(strArr[0]);
                    return true;
                }
                if ("showKuiklyFloat".equals(str3)) {
                    J(strArr[0]);
                    return true;
                }
            } else {
                L(str3, strArr[0]);
                return true;
            }
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, intent, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        super.onActivityResult(intent, b16, i3);
        if (QLog.isColorLevel()) {
            QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, "onActivityResult requestCode = " + ((int) b16) + " resultCode = " + i3);
        }
        if (i3 == -1) {
            if (b16 == 33) {
                backH5Friends(intent);
                return;
            } else {
                if (b16 == 34) {
                    t(intent);
                    return;
                }
                return;
            }
        }
        errorCallBack();
    }

    protected void w(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            return;
        }
        Intent intent = new Intent();
        if (z16) {
            intent.putExtra("is_multi_selection", true);
        } else {
            intent.putExtra("only_single_selection", true);
        }
        intent.putExtra("forward_type", 1055);
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(a16, intent, i.f(34, ao.a(this)));
    }
}
