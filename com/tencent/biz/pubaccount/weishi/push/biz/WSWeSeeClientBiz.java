package com.tencent.biz.pubaccount.weishi.push.biz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.qqstory.utils.l;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSWeSeeClientBiz extends a<WSRedDotPushMsg, WSPushStrategyInfo> {

    /* renamed from: b, reason: collision with root package name */
    private int f81344b;

    /* renamed from: c, reason: collision with root package name */
    private Intent f81345c;

    public WSWeSeeClientBiz(WSRedDotPushMsg wSRedDotPushMsg, int i3, Intent intent) {
        super(wSRedDotPushMsg);
        this.f81344b = i3;
        this.f81345c = intent;
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.parse(str).getQueryParameter("logsour");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (this.f81344b == 2 && TextUtils.equals(c(str), "2020020163")) {
            WSReportDc00898.p();
            WSPublicAccReport.getInstance().feedsItemForPushReport("gzh_click", 1000003);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.biz.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(final Context context, final WSPushStrategyInfo wSPushStrategyInfo) {
        boolean z16;
        boolean c16 = l.c(context);
        x.f("WSPushLog", "WSWeSeeClientBiz strategyInfo.scheme = " + wSPushStrategyInfo.mScheme + ", isInstallWeishi = " + c16);
        if (this.f81344b == 2) {
            WSHomeFragment.di(new com.tencent.biz.pubaccount.weishi.l(context, 1, "from_home_page"));
            z16 = true;
        } else {
            z16 = false;
        }
        if (TextUtils.isEmpty(wSPushStrategyInfo.mScheme) || !c16) {
            return z16;
        }
        com.tencent.biz.pubaccount.weishi.net.g.b().c(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.push.biz.WSWeSeeClientBiz.1
            @Override // java.lang.Runnable
            public void run() {
                ao.e(context.getApplicationContext(), "biz_src_jc_gzh_weishi", wSPushStrategyInfo.mScheme);
                WSWeSeeClientBiz.this.e(wSPushStrategyInfo.mScheme);
            }
        }, 200L);
        return true;
    }
}
