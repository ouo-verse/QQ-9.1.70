package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkNativeSessionManager;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ab {

    /* renamed from: f, reason: collision with root package name */
    private static ab f64050f;

    /* renamed from: a, reason: collision with root package name */
    private String f64051a;

    /* renamed from: b, reason: collision with root package name */
    private String f64052b;

    /* renamed from: c, reason: collision with root package name */
    private String f64053c;

    /* renamed from: d, reason: collision with root package name */
    private String f64054d;

    /* renamed from: e, reason: collision with root package name */
    private String f64055e;

    ab() {
    }

    public static ab c() {
        if (f64050f == null) {
            f64050f = new ab();
        }
        return f64050f;
    }

    private String d() {
        WinkContext e16 = WinkContext.INSTANCE.e();
        if (e16 != null) {
            return e16.getDtParams().c();
        }
        return f("android_camera_session_wink");
    }

    private String f(String str) {
        return String.format(Locale.getDefault(), "%s_%s_%d_%d", str, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(100)));
    }

    private String h(Activity activity) {
        HashMap hashMap;
        if (activity.getIntent() != null && (hashMap = (HashMap) activity.getIntent().getSerializableExtra("key_attrs")) != null && hashMap.containsKey("xsj_operation_activity_id")) {
            return (String) hashMap.get("xsj_operation_activity_id");
        }
        Object obj = WinkDatongCurrentParams.get("xsj_operation_activity_id");
        if (obj != null) {
            return obj.toString();
        }
        return "none";
    }

    private String i(Activity activity) {
        Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME);
        if (obj != null) {
            return obj.toString();
        }
        return "none";
    }

    private String j(Activity activity) {
        if (activity.getIntent() != null) {
            return activity.getIntent().getStringExtra("xsj_ref_pgid");
        }
        return "";
    }

    public void a(Activity activity) {
        this.f64051a = WinkNativeSessionManager.g().getSessionId();
        this.f64052b = d();
        this.f64053c = h(activity);
        this.f64054d = j(activity);
        this.f64055e = i(activity);
        ms.a.f("FlashShowDtReportHelper", "session begin: sessionId = " + this.f64051a + ", cameraSessionId = " + this.f64052b);
    }

    public HashMap<String, Object> e() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, WinkDTParamBuilder.APP_KEY);
        hashMap.put("xsj_session_id", this.f64051a);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, this.f64054d);
        return hashMap;
    }

    public HashMap<String, Object> g() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, WinkDTParamBuilder.APP_KEY);
        hashMap.put("xsj_session_id", this.f64051a);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, this.f64052b);
        hashMap.put("xsj_operation_activity_id", this.f64053c);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, this.f64054d);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, this.f64055e);
        Object obj = WinkDatongCurrentParams.get("xsj_resource_type");
        if (obj != null) {
            hashMap.put("xsj_resource_type", obj);
        }
        Object obj2 = WinkDatongCurrentParams.get("xsj_tianshu_task_id");
        if (obj2 != null) {
            hashMap.put("xsj_tianshu_task_id", obj2);
        }
        Object obj3 = WinkDatongCurrentParams.get("xsj_publish_location");
        if (obj3 != null) {
            hashMap.put("xsj_publish_location", obj3);
        }
        Object obj4 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID);
        if (obj4 != null) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, obj4);
        }
        Object obj5 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.ADID);
        if (obj5 != null) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.ADID, obj5);
        }
        return hashMap;
    }

    public void b() {
        this.f64051a = null;
        this.f64052b = null;
        this.f64053c = null;
        this.f64055e = null;
    }
}
