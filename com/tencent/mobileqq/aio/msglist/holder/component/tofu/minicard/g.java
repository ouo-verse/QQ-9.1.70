package com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard;

import android.view.View;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.utils.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static Map<String, Object> a(ah ahVar) {
        HashMap hashMap = new HashMap();
        if (ahVar == null) {
            return hashMap;
        }
        b.a g16 = com.tencent.mobileqq.aio.utils.b.f194119a.g();
        if (g16 != null) {
            hashMap.putAll(g16.e().a());
        }
        hashMap.put("curd_block_id", ahVar.m2());
        hashMap.put("curd_block_business_type", Long.valueOf(ahVar.n2()));
        hashMap.put("curd_block_style", Integer.valueOf(ahVar.k2()));
        hashMap.put("service_custom_field", ahVar.l2());
        hashMap.put("tofu_block_trigger_type", String.valueOf(ahVar.q2().b()));
        return hashMap;
    }

    public static void b(View view, String str, ah ahVar) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, a(ahVar));
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }
}
