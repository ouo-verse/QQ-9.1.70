package lo2;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.haoliyou.orion.XorCipher;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.shadow.dynamic.host.Constant;
import java.net.URLEncoder;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends do2.r {
    private String C;
    public long D;
    String E;
    public List<com.tencent.mobileqq.search.model.y> F;
    long G;
    String H;
    String I;
    public String J;
    public String K;
    public List<String> L;
    public boolean M;
    public boolean N;
    public boolean P;
    public int Q;
    public boolean R;
    public String S;

    public b() {
    }

    protected void A() {
        long j3 = this.D;
        if (j3 == Constant.FROM_ID_START_ACTIVITY) {
            r(17);
            return;
        }
        if (j3 == 1106) {
            r(14);
            return;
        }
        if (j3 == 1105) {
            r(18);
            return;
        }
        if (j3 == 1108) {
            r(22);
            return;
        }
        if (j3 == 1701) {
            r(9);
            return;
        }
        if (j3 == 1111) {
            r(24);
            return;
        }
        if (j3 == 1114) {
            r(25);
            return;
        }
        if (j3 == 1115) {
            r(26);
        } else if (j3 == 1116) {
            r(27);
        } else if (j3 == 1117) {
            r(29);
        }
    }

    public void B(int i3) {
        this.Q = i3;
    }

    public void C(List<com.tencent.mobileqq.search.model.y> list) {
        this.F = list;
    }

    public void D(int i3) {
        if (this.D == Constant.FROM_ID_UNINSTALL_PLUGIN && !this.H.isEmpty()) {
            this.H += "&sourceext=" + i3;
        }
    }

    public void E(long j3) {
        this.G = j3;
    }

    public void F(String str) {
        if (this.D == Constant.FROM_ID_UNINSTALL_PLUGIN && !TextUtils.isEmpty(this.H) && !TextUtils.isEmpty(str)) {
            this.H += "&trace_id=" + str;
        }
    }

    @Override // do2.r, com.tencent.mobileqq.search.model.x
    public String l() {
        String str = this.E;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // do2.r, com.tencent.mobileqq.search.model.x
    public String m() {
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "getKeyword." + this.C);
        }
        return this.C;
    }

    @Override // do2.r, com.tencent.mobileqq.search.model.x
    public int n() {
        return 1;
    }

    @Override // do2.r, com.tencent.mobileqq.search.model.x
    public List<com.tencent.mobileqq.search.model.y> o() {
        return this.F;
    }

    @Override // do2.r, com.tencent.mobileqq.search.model.x
    public void q(View view) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "onMoreAction. searchKey=" + this.C + " groupName=" + this.E + " groupMask=" + this.D);
        }
        z(view);
        if (this.D == Constant.FROM_ID_UNINSTALL_PLUGIN) {
            ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).reportSearchResultClickMore(this.F, this.C);
        }
        long j3 = this.D;
        if (j3 == 1701) {
            Intent intent = new Intent();
            intent.putExtra("search_keyword", this.C);
            intent.putExtra("key_refer", 1005);
            ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).publicFragmentStart(view.getContext(), intent, ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppSearchFragmentClass());
            com.tencent.mobileqq.search.report.b.e(null, 0, this.Q, "0X8009D47", 0, 0, null, null);
            return;
        }
        String str = this.H;
        if (j3 == Constant.FROM_ID_START_ACTIVITY) {
            com.tencent.mobileqq.search.report.b.e(null, 0, this.Q, "0X8009D53", 0, 0, null, null);
        } else if (j3 == 1001) {
            VideoReport.reportEvent("dt_clck", view, null);
        } else if (1108 == j3 && !bl.b(this.F)) {
            com.tencent.mobileqq.search.model.y yVar = this.F.get(0);
            if ((yVar instanceof t) && !TextUtils.isEmpty(str)) {
                str = str + "&guildTraceId=" + ((t) yVar).X().f405471q.f405478f;
            }
        }
        if (!TextUtils.isEmpty(this.H)) {
            ax c16 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), view.getContext(), this.H);
            if (c16 != null) {
                c16.b();
                return;
            }
            if (this.H.startsWith("http://") || this.H.startsWith("https://")) {
                Long valueOf = Long.valueOf(Double.valueOf(0.0d).longValue());
                String str2 = str + "&keyword=" + URLEncoder.encode(this.C) + "&gpstype=1&lon=" + Long.valueOf(Double.valueOf(0.0d).longValue()) + "&lat=" + valueOf;
                if (QLog.isColorLevel()) {
                    try {
                        QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "onMoreAction,moreUrl = " + this.H + ",dstUrl = " + XorCipher.encrypt(str2));
                    } catch (XorCipherException e16) {
                        e16.printStackTrace();
                    }
                }
                Context context = view.getContext();
                Intent intent2 = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("url", str2);
                context.startActivity(intent2);
                return;
            }
            return;
        }
        ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).launchActiveEntitySearchActivity(true, view.getContext(), this.C, this.E, new long[]{this.D});
    }

    public String toString() {
        return "GroupBaseNetSearchModel{searchKey='" + this.C + "', groupMask=" + this.D + ", groupName='" + this.E + "', mFrom=" + this.Q + ", isEnd=" + this.R + ", positionInList=" + this.f394399h + ", positionInBuss=" + this.f394400i + "} " + super.toString();
    }

    public int v() {
        return (int) this.D;
    }

    public String w() {
        String str = this.I;
        if (str == null) {
            return "\u66f4\u591a";
        }
        return str;
    }

    public String x() {
        String str = this.H;
        if (str == null) {
            return "";
        }
        return str;
    }

    public long y() {
        return this.G;
    }

    public void z(View view) {
        long j3 = this.D;
        if (j3 == 1106) {
            ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).mobileReportAction("more", "4", SearchConstants.PLATFORM, "7", "1", 102, 1, System.currentTimeMillis());
            com.tencent.mobileqq.search.report.b.e(null, 0, this.Q, SearchConstants.INDIVIDUATION_CLICK_SOUP, 0, 0, null, null);
        } else if (j3 == 1108) {
            VideoReport.reportEvent("clck", view, null);
        }
    }

    public b(String str, long j3, String str2, List<com.tencent.mobileqq.search.model.y> list, long j16, String str3, String str4, List<String> list2, boolean z16, boolean z17, boolean z18, String str5, String str6) {
        this.C = str;
        this.D = j3;
        this.E = str2;
        this.F = list;
        this.G = j16;
        this.H = str3;
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupBaseNetSearchModel", 2, "GroupBaseNetSearchModel ,moreUrl = " + str3);
        }
        this.I = str4;
        this.L = list2;
        this.M = z16;
        this.N = z17;
        this.P = z18;
        this.K = str6;
        this.J = str5;
        A();
    }
}
