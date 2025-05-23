package com.tencent.biz.pubaccount.weishi.util;

import UserGrowth.stNotificationRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSchema;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ac {
    private static WSDownloadParams a(stNotificationRsp stnotificationrsp) {
        WSDownloadParams wSDownloadParams = new WSDownloadParams();
        wSDownloadParams.mScene = 1;
        wSDownloadParams.mEventId = c(stnotificationrsp);
        wSDownloadParams.mTestId = bb.x(4);
        stReportItem g16 = com.tencent.biz.pubaccount.weishi.report.a.g();
        g16.pagetype = 4;
        g16.optype = 115;
        wSDownloadParams.mStReportItem = g16;
        wSDownloadParams.mScheme = d(stnotificationrsp);
        return wSDownloadParams;
    }

    private static stSchema b(stNotificationRsp stnotificationrsp) {
        stSchema stschema = new stSchema();
        stschema.schema = d(stnotificationrsp);
        stschema.H5Url = stnotificationrsp.h5Url;
        return stschema;
    }

    private static String d(stNotificationRsp stnotificationrsp) {
        if (stnotificationrsp == null) {
            return "weishi://main";
        }
        if (!TextUtils.isEmpty(stnotificationrsp.scheme_url)) {
            return stnotificationrsp.scheme_url;
        }
        int i3 = stnotificationrsp.type;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return "weishi://main";
        }
        return "weishi://message";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ stNotificationRsp f81691a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f81692b;

        a(stNotificationRsp stnotificationrsp, String str) {
            this.f81691a = stnotificationrsp;
            this.f81692b = str;
        }

        @Override // h00.d, h00.b
        public void a() {
            stNotificationRsp stnotificationrsp = this.f81691a;
            WSReportDc00898.t(140, stnotificationrsp.type, stnotificationrsp.cid);
            stNotificationRsp stnotificationrsp2 = this.f81691a;
            com.tencent.biz.pubaccount.weishi.recommend.a.p("gzh_click", stnotificationrsp2.type, 1000004, stnotificationrsp2.cid, stnotificationrsp2.trace_id, this.f81692b);
        }

        @Override // h00.d, h00.b
        public void b() {
            stNotificationRsp stnotificationrsp = this.f81691a;
            WSReportDc00898.t(115, stnotificationrsp.type, stnotificationrsp.cid);
            stNotificationRsp stnotificationrsp2 = this.f81691a;
            com.tencent.biz.pubaccount.weishi.recommend.a.p("gzh_click", stnotificationrsp2.type, 1000002, stnotificationrsp2.cid, stnotificationrsp2.trace_id, this.f81692b);
        }

        @Override // h00.d, h00.b
        public void d() {
            com.tencent.biz.pubaccount.weishi.report.a.j(4, 114, 0, null, null);
            stNotificationRsp stnotificationrsp = this.f81691a;
            WSReportDc00898.t(114, stnotificationrsp.type, stnotificationrsp.cid);
            stNotificationRsp stnotificationrsp2 = this.f81691a;
            com.tencent.biz.pubaccount.weishi.recommend.a.p("gzh_click", stnotificationrsp2.type, 1000003, stnotificationrsp2.cid, stnotificationrsp2.trace_id, this.f81692b);
        }

        @Override // h00.d, h00.b
        public void c() {
        }
    }

    private static int c(stNotificationRsp stnotificationrsp) {
        if (stnotificationrsp == null) {
            return 102;
        }
        int i3 = stnotificationrsp.type;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return 101;
        }
        return i3 != 6 ? 102 : 103;
    }

    public static void e(Context context, stNotificationRsp stnotificationrsp, String str) {
        if (context == null || stnotificationrsp == null) {
            return;
        }
        new h00.j(context).o(b(stnotificationrsp)).l(true).i(a(stnotificationrsp)).m(new a(stnotificationrsp, str)).h();
    }
}
