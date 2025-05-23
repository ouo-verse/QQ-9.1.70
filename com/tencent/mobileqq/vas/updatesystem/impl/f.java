package com.tencent.mobileqq.vas.updatesystem.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasUtilProxy;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f implements sw4.f {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f311221a;

    static {
        HashSet<String> hashSet = new HashSet<>();
        f311221a = hashSet;
        try {
            UnitedProxy a16 = ar.a("shouyouye", "2024-06-12", "vas_report_gray_scid_list");
            if (a16.isEnable(true)) {
                String stringData = a16.getStringData("");
                if (!TextUtils.isEmpty(stringData)) {
                    Collections.addAll(hashSet, stringData.split(","));
                }
            }
        } catch (Exception e16) {
            QLog.i("VasUpdate_ReportImpl", 1, "parse error: " + e16.getMessage());
        }
    }

    @Override // sw4.f
    public void a(com.tencent.vas.update.entity.b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.f384007a += 100;
        if (QLog.isColorLevel()) {
            QLog.d("VasUpdate_ReportImpl", 2, "reportDLEvent: bid = " + bVar.f384008b + " scid = " + bVar.f384009c + " dlFrom = " + bVar.f384007a + " bIncrement = " + bVar.f384011e + " errorCode = " + bVar.f384012f + " httpCode = " + bVar.f384013g + " errorMsg = " + bVar.f384015i + " count = " + bVar.f384014h + " fileSize = " + bVar.f384019m + " downloadTimeConsume = " + bVar.f384020n);
        }
        if (f311221a.contains(bVar.f384009c) || ((int) (Math.random() * 1000.0d)) == 1) {
            b(bVar);
        }
    }

    public void b(@NonNull com.tencent.vas.update.entity.b bVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from", String.valueOf(bVar.f384007a));
        hashMap.put("bid", String.valueOf(bVar.f384008b));
        hashMap.put("scid", String.valueOf(bVar.f384009c));
        hashMap.put("md5", String.valueOf(bVar.f384010d));
        hashMap.put("eventCode", String.valueOf(bVar.f384012f));
        hashMap.put("httpCode", String.valueOf(bVar.f384013g));
        hashMap.put(TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, String.valueOf(bVar.f384014h));
        hashMap.put("errorMsg", String.valueOf(bVar.f384015i));
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && mobileQQ.peekAppRuntime() != null) {
            hashMap.put("userId", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
        }
        hashMap.put("fileSize", String.valueOf(bVar.f384019m));
        hashMap.put("downloadTimeConsume", String.valueOf(bVar.f384020n));
        ((IVasUtilProxy) QRoute.api(IVasUtilProxy.class)).collectPerformance(hashMap);
    }
}
