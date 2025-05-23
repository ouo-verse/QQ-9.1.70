package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class JumpReportCtr {

    /* renamed from: k, reason: collision with root package name */
    public static boolean f307025k = false;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f307026l = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f307027a = false;

    /* renamed from: b, reason: collision with root package name */
    private String f307028b = "-1";

    /* renamed from: c, reason: collision with root package name */
    private String f307029c = "-1";

    /* renamed from: d, reason: collision with root package name */
    private String f307030d = "-1";

    /* renamed from: e, reason: collision with root package name */
    private String f307031e = "-1";

    /* renamed from: f, reason: collision with root package name */
    private String f307032f = "-1";

    /* renamed from: g, reason: collision with root package name */
    private String f307033g = "-1";

    /* renamed from: h, reason: collision with root package name */
    String f307034h = "-1";

    /* renamed from: i, reason: collision with root package name */
    String f307035i = "";

    /* renamed from: j, reason: collision with root package name */
    String f307036j = "";

    public JumpReportCtr() {
        if (f307026l) {
            return;
        }
        f307026l = true;
        final float f16 = 0.01f;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.utils.JumpReportCtr.1
            @Override // java.lang.Runnable
            public void run() {
                JumpReportCtr.this.c(f16);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f16) {
        boolean z16 = false;
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("JumpReportCtr_SP", 0);
        if (Math.abs(System.currentTimeMillis() - sharedPreferences.getLong("lastShotTime", 0L)) >= 43200000) {
            if (f16 >= Math.random()) {
                z16 = true;
            }
            f307025k = z16;
            sharedPreferences.edit().putLong("lastShotTime", System.currentTimeMillis()).putBoolean("lastShotResult", f307025k).apply();
        } else {
            f307025k = sharedPreferences.getBoolean("lastShotResult", false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("JumpActivity.Report", 2, "JumpReportCtr init needReport= " + f307025k);
        }
    }

    public void b(AppRuntime appRuntime, Activity activity, Intent intent) {
        String str;
        Bundle extras;
        if (intent == null || !f307025k) {
            return;
        }
        HashSet<String> b16 = bg.b(activity);
        StringBuilder sb5 = new StringBuilder();
        if (b16 != null && !b16.isEmpty()) {
            Iterator<String> it = b16.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (sb5.length() > 0) {
                    sb5.append("|");
                }
                sb5.append(next);
            }
        }
        this.f307028b = sb5.toString();
        this.f307027a = d(intent);
        this.f307030d = intent.getAction();
        this.f307031e = intent.getScheme();
        this.f307032f = intent.getType();
        String dataString = intent.getDataString();
        this.f307033g = dataString;
        if (this.f307027a) {
            if ((this.f307030d.equals("android.intent.action.SEND") || this.f307030d.equals("android.intent.action.SEND_MULTIPLE")) && (extras = intent.getExtras()) != null) {
                if (!TextUtils.isEmpty(extras.getString("android.intent.extra.TEXT"))) {
                    this.f307034h = extras.getString("android.intent.extra.TEXT");
                } else {
                    Object obj = extras.get("android.intent.extra.STREAM");
                    if (obj != null) {
                        if (obj instanceof Uri) {
                            this.f307034h = ((Uri) obj).toString();
                        } else if (obj instanceof String) {
                            this.f307034h = (String) obj;
                        } else if (obj instanceof ArrayList) {
                            this.f307034h = "MULTIPLE_SHARE";
                        }
                    }
                }
            }
        } else if (!TextUtils.isEmpty(dataString) && appRuntime != null) {
            this.f307036j = ((IQJumpApi) QRoute.api(IQJumpApi.class)).parseJumpActionName(appRuntime, activity, this.f307033g);
            this.f307035i = ((IQJumpApi) QRoute.api(IQJumpApi.class)).parseJumpServerName(appRuntime, activity, this.f307033g);
        }
        IMobileReportManager iMobileReportManager = (IMobileReportManager) QRoute.api(IMobileReportManager.class);
        String str2 = this.f307028b;
        if (!TextUtils.isEmpty(this.f307033g)) {
            str = this.f307033g;
        } else {
            str = this.f307030d + "/shareContext:" + this.f307034h;
        }
        iMobileReportManager.reportSchemaInfo(str2, str);
    }

    public boolean d(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        if (action.equals("android.intent.action.SEND") || action.equals("android.intent.action.SEND_MULTIPLE")) {
            return true;
        }
        String scheme = intent.getScheme();
        if (!action.equals(CommonConstant.ACTION.HWID_SCHEME_URL) || TextUtils.isEmpty(scheme) || (!scheme.equals("file") && !scheme.equals("content"))) {
            return false;
        }
        return true;
    }

    public void e(Intent intent) {
        String str;
        ComponentName component;
        if (!f307025k) {
            return;
        }
        if (intent != null && (component = intent.getComponent()) != null) {
            this.f307029c = component.getClassName();
        }
        if (this.f307027a) {
            HashMap<String, String> hashMap = new HashMap<>(5);
            hashMap.put("action", this.f307030d);
            hashMap.put(ZPlanPublishSource.FROM_SCHEME, this.f307031e);
            hashMap.put("type", this.f307032f);
            hashMap.put("data", this.f307033g);
            hashMap.put("fromPkg", this.f307028b);
            hashMap.put("jumpToAct", this.f307029c);
            hashMap.put("shareContext", this.f307034h);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "jump_act_system_report", true, 0L, 0L, hashMap, null);
            StringBuilder sb5 = new StringBuilder(256);
            sb5.append("action=");
            sb5.append(this.f307030d);
            sb5.append(", pkgName=");
            sb5.append(this.f307028b);
            sb5.append(", jumpToAct=");
            sb5.append(this.f307029c);
            sb5.append(", scheme=");
            sb5.append(this.f307031e);
            sb5.append(", type=");
            sb5.append(this.f307032f);
            sb5.append(", shareContext=");
            sb5.append(this.f307034h);
            sb5.append("\n data=");
            sb5.append(this.f307033g);
            if (QLog.isColorLevel()) {
                QLog.d("JumpActivity.Report", 2, "systemShare|report : \n" + sb5.toString());
                return;
            }
            return;
        }
        String str2 = this.f307036j;
        if (str2 != null) {
            str = "-1";
        } else {
            str2 = "-1";
            str = str2;
        }
        String str3 = this.f307035i;
        if (str3 == null) {
            str3 = str;
        }
        HashMap<String, String> hashMap2 = new HashMap<>(8);
        hashMap2.put("action", this.f307030d);
        hashMap2.put(ZPlanPublishSource.FROM_SCHEME, this.f307031e);
        hashMap2.put("type", this.f307032f);
        hashMap2.put("data", this.f307033g);
        hashMap2.put("fromPkg", this.f307028b);
        hashMap2.put("jumpToAct", this.f307029c);
        hashMap2.put("server_name", str3);
        hashMap2.put("action_name", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "jump_act_business_report", true, 0L, 0L, hashMap2, null);
        StringBuilder sb6 = new StringBuilder(256);
        sb6.append("action=");
        sb6.append(this.f307030d);
        sb6.append(", type=");
        sb6.append(this.f307032f);
        sb6.append(", pkgName=");
        sb6.append(this.f307028b);
        sb6.append(", jumpToAct=");
        sb6.append(this.f307029c);
        sb6.append(", scheme=");
        sb6.append(this.f307031e);
        sb6.append(", server_name=");
        sb6.append(str3);
        sb6.append(", action_name=");
        sb6.append(str2);
        sb6.append("\n data=");
        sb6.append(this.f307033g);
        if (QLog.isColorLevel()) {
            QLog.d("JumpActivity.Report", 2, "business share |report params: \n" + sb6.toString());
        }
    }
}
