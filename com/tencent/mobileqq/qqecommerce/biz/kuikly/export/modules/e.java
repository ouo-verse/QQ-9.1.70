package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0012\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JQ\u0010\u0017\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/e;", "Li01/e;", "", ark.ARKMETADATA_JSON, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Lorg/json/JSONObject;", "jsonObject", "o", "d", "", "code", "msg", "data", "g", "method", "params", "call", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class e extends i01.e {

    /* renamed from: e, reason: collision with root package name */
    private static final Map<Integer, String> f262987e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/e$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f262989b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262990c;

        b(JSONObject jSONObject, Function1<Object, Unit> function1) {
            this.f262989b = jSONObject;
            this.f262990c = function1;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d("QQKuiklyCalendarModule", 1, "handleAddCalendarRemind, onAllGranted");
            e.this.d(this.f262989b, this.f262990c);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            super.onDenied(permissions, results);
            QLog.d("QQKuiklyCalendarModule", 1, "handleAddCalendarRemind, onDenied");
            e.i(e.this, this.f262990c, -2, "no permission", null, 8, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/e$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f262992b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262993c;

        c(JSONObject jSONObject, Function1<Object, Unit> function1) {
            this.f262992b = jSONObject;
            this.f262993c = function1;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d("QQKuiklyCalendarModule", 1, "handleRemoveCalendarRemind, onAllGranted");
            e.this.o(this.f262992b, this.f262993c);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            super.onDenied(permissions, results);
            QLog.d("QQKuiklyCalendarModule", 1, "handleRemoveCalendarRemind, onDenied");
            e.i(e.this, this.f262993c, -2, "no permission", null, 8, null);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(1, "MO");
        hashMap.put(2, "TU");
        hashMap.put(3, "WE");
        hashMap.put(4, "TH");
        hashMap.put(5, "FR");
        hashMap.put(6, "SA");
        hashMap.put(7, "SU");
        f262987e = hashMap;
    }

    private final void g(Function1<Object, Unit> callback, int code, String msg2, String data) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", code);
            jSONObject.put("msg", msg2);
            if (!TextUtils.isEmpty(data)) {
                jSONObject.put("data", new JSONObject(data));
            }
        } catch (Throwable th5) {
            QLog.e("QQKuiklyCalendarModule", 1, th5, new Object[0]);
        }
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -1615005468) {
            if (hashCode != 998993799) {
                if (hashCode == 1770001738 && method.equals("isCalendarRemindExist")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("removeCalendarRemind")) {
                m(params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("addCalendarRemind")) {
            j(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    private final void j(String json, Function1<Object, Unit> callback) {
        boolean z16 = false;
        QLog.d("QQKuiklyCalendarModule", 1, "handleAddCalendarRemind, json=", json);
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && !topActivity.isFinishing()) {
            z16 = true;
        }
        if (z16) {
            try {
                JSONObject jSONObject = new JSONObject(json);
                QQPermission qQPermission = QQPermissionFactory.getQQPermission(topActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_GAME_CENTER_CALENDAR, QQPermissionConstants.Business.SCENE.GAME_CENTER_CALENDAR_REMIND));
                Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(topActivity, config)");
                if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_CALENDAR) != 0) {
                    qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_CALENDAR}, 2, new b(jSONObject, callback));
                } else {
                    d(jSONObject, callback);
                }
            } catch (Exception e16) {
                QLog.e("QQKuiklyCalendarModule", 1, "handleAddCalendarRemind, get callback e=", e16);
                i(this, callback, -3, QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR, null, 8, null);
            }
        }
    }

    private final void l(String json, Function1<Object, Unit> callback) {
        QLog.d("QQKuiklyCalendarModule", 1, "handleIsCalendarRemindExist, json=", json);
        i(this, callback, -2, "no permission", null, 8, null);
    }

    private final void m(String json, Function1<Object, Unit> callback) {
        boolean z16 = false;
        QLog.d("QQKuiklyCalendarModule", 1, "handleRemoveCalendarRemind, json=", json);
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && !topActivity.isFinishing()) {
            z16 = true;
        }
        if (z16) {
            try {
                JSONObject jSONObject = new JSONObject(json);
                QQPermission qQPermission = QQPermissionFactory.getQQPermission(topActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_GAME_CENTER_CALENDAR, QQPermissionConstants.Business.SCENE.GAME_CENTER_CALENDAR_REMIND));
                Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(topActivity, config)");
                if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_CALENDAR) != 0) {
                    qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_CALENDAR}, 2, new c(jSONObject, callback));
                } else {
                    o(jSONObject, callback);
                }
            } catch (Exception e16) {
                QLog.e("QQKuiklyCalendarModule", 1, "handleAddCalendarRemind, e=", e16);
                i(this, callback, -3, QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR, null, 8, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(JSONObject jsonObject, Function1<Object, Unit> callback) {
        if (jsonObject != null) {
            Uri withAppendedId = ContentUris.withAppendedId(Uri.parse("content://com.android.calendar/events"), jsonObject.optLong("calendarEventId"));
            Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(\n        \u2026ndarEventId\n            )");
            MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
            int e16 = py3.b.e(sMobileQQ.getContentResolver(), withAppendedId, null, null);
            if (e16 == -1) {
                QLog.e("QQKuiklyCalendarModule", 1, "removeCalendarRemind, result=", Integer.valueOf(e16));
                i(this, callback, -1, "remove calendar event failed", null, 8, null);
            } else {
                g(callback, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, null);
            }
        }
    }

    static /* synthetic */ void i(e eVar, Function1 function1, int i3, String str, String str2, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 8) != 0) {
                str2 = null;
            }
            eVar.g(function1, i3, str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doCallback");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(JSONObject jsonObject, Function1<Object, Unit> callback) {
        Uri uri;
        if (jsonObject == null) {
            return;
        }
        String optString = jsonObject.optString("title");
        String optString2 = jsonObject.optString("description");
        if (jsonObject.has("startTime") && jsonObject.has("endTime")) {
            long j3 = 1000;
            long optLong = jsonObject.optLong("startTime") * j3;
            long optLong2 = jsonObject.optLong("endTime") * j3;
            if (optLong > optLong2) {
                QLog.e("QQKuiklyCalendarModule", 1, "addCalendarRemind, endTime must >= startTime");
                g(callback, -1, "endTime must >= startTime", null);
                return;
            }
            String optString3 = jsonObject.optString("location");
            boolean optBoolean = jsonObject.optBoolean("isWeeklyRepeat");
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", optString);
            contentValues.put("calendar_id", (Integer) 1);
            contentValues.put("eventTimezone", TimeZone.getDefault().getID());
            contentValues.put("description", optString2);
            contentValues.put("dtstart", Long.valueOf(optLong));
            contentValues.put("dtend", Long.valueOf(optLong2));
            if (!TextUtils.isEmpty(optString3)) {
                contentValues.put("eventLocation", optString3);
            }
            if (optBoolean) {
                contentValues.put("allDay", (Integer) 1);
                JSONArray optJSONArray = jsonObject.optJSONArray("repeatWeeklyDay");
                StringBuilder sb5 = new StringBuilder();
                if (optJSONArray != null) {
                    try {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            String str = f262987e.get(Integer.valueOf(optJSONArray.optInt(i3)));
                            if (!TextUtils.isEmpty(str)) {
                                sb5.append(str);
                                if (i3 != length - 1) {
                                    sb5.append(",");
                                }
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e("QQKuiklyCalendarModule", 1, "addCalendarRemind, get weekday str exception=", e16);
                    }
                }
                String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date(optLong2));
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format2 = String.format("FREQ=WEEKLY;UNTIL=%sT000000Z;WKST=SU;BYDAY=%s", Arrays.copyOf(new Object[]{format, sb5}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                contentValues.put("rrule", format2);
            }
            Uri insert = MobileQQ.sMobileQQ.getContentResolver().insert(Uri.parse("content://com.android.calendar/events"), contentValues);
            if (insert == null) {
                QLog.e("QQKuiklyCalendarModule", 1, "addCalendarRemind, addCalendarEvent null");
                g(callback, -1, "add calendar event failed", null);
                return;
            }
            long parseId = ContentUris.parseId(insert);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("event_id", Long.valueOf(parseId));
            contentValues2.put(TuxTimeView.TUX_TIME_STYLE_MINUTES, Integer.valueOf(jsonObject.optInt("advanceTime")));
            contentValues2.put("method", (Integer) 1);
            try {
                uri = MobileQQ.sMobileQQ.getContentResolver().insert(Uri.parse("content://com.android.calendar/reminders"), contentValues2);
            } catch (Throwable th5) {
                QLog.e("QQKuiklyCalendarModule", 1, "addCalendarRemind, insert remind exception=", th5);
                uri = null;
            }
            if (uri == null) {
                QLog.e("QQKuiklyCalendarModule", 1, "addCalendarRemind, add remind failed");
                g(callback, -1, "add calendar remind failed", null);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("calendarEventId", parseId);
                g(callback, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, jSONObject.toString());
                return;
            } catch (JSONException e17) {
                QLog.e("QQKuiklyCalendarModule", 1, "addCalendarRemind, do callback exception=", e17);
                return;
            }
        }
        QLog.e("QQKuiklyCalendarModule", 1, "addCalendarRemind, startTime and endTime required");
        i(this, callback, -1, "startTime and endTime required", null, 8, null);
    }
}
