package a20;

import UserGrowth.stTabInfo;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import h00.j;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f25360a;

        a(String str) {
            this.f25360a = str;
        }

        @Override // h00.d, h00.b
        public void a() {
            WSPublicAccReport.getInstance().reportTabLiveBtnClick(this.f25360a, 1000004);
        }

        @Override // h00.d, h00.b
        public void b() {
            WSPublicAccReport.getInstance().reportTabLiveBtnClick(this.f25360a, 1000002);
        }

        @Override // h00.d, h00.b
        public void c() {
            WSPublicAccReport.getInstance().reportTabLiveBtnClick(this.f25360a, 1000007);
        }

        @Override // h00.d, h00.b
        public void d() {
            WSPublicAccReport.getInstance().reportTabLiveBtnClick(this.f25360a, 1000003);
        }
    }

    private static WSDownloadParams a(String str) {
        WSDownloadParams wSDownloadParams = new WSDownloadParams();
        wSDownloadParams.mScene = 1;
        wSDownloadParams.mLinkStrategyType = iz.a.g().p();
        wSDownloadParams.mTestId = bb.x(wSDownloadParams.mScene);
        wSDownloadParams.mScheme = str;
        return wSDownloadParams;
    }

    public static void b(Context context, stTabInfo sttabinfo, String str) {
        if (bb.E()) {
            return;
        }
        if (sttabinfo != null && context != null) {
            new j(context).o(sttabinfo.schema).l(true).i(a(sttabinfo.schema.schema)).m(new a(str)).h();
            return;
        }
        x.f("WSTabUtils", "[WSTabUtils.java][tabImgBtnClick] context or tabInfo is null !!! context:" + context + ", tabInfo:" + sttabinfo);
    }
}
