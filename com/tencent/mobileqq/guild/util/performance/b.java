package com.tencent.mobileqq.guild.util.performance;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.nt.misc.api.IBeaconReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f235583a = new Bundle();

    public static b c() {
        return new b();
    }

    private String d(String str, HashMap<String, String> hashMap) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("report:  event = " + str + "  |  ");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            sb5.append(entry.getKey() + " = " + entry.getValue() + "  |  ");
        }
        return sb5.toString();
    }

    public b a(String str) {
        this.f235583a.putString("action", str);
        return this;
    }

    public b b(@NonNull String str, @NonNull String str2) {
        this.f235583a.putString(str, str2);
        return this;
    }

    public b e(String str) {
        this.f235583a.putString("module", str);
        return this;
    }

    public b f(String str) {
        this.f235583a.putString("page", str);
        return this;
    }

    public void g() {
        String string = this.f235583a.getString("action");
        String string2 = this.f235583a.getString("page");
        String string3 = this.f235583a.getString("module");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
            String format = String.format("%s#%s#%s", string, string2, string3);
            HashMap<String, String> hashMap = new HashMap<>();
            for (String str : this.f235583a.keySet()) {
                String string4 = this.f235583a.getString(str);
                if (!TextUtils.isEmpty(string4)) {
                    hashMap.put(str, string4);
                }
            }
            String currentAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
            QLog.i("Guild-DataReporter", 4, d(format, hashMap));
            ((IBeaconReportApi) QRoute.api(IBeaconReportApi.class)).report(currentAccountUin, format, hashMap, true);
        }
    }
}
