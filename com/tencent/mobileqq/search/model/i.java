package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i extends do2.r {
    public String C;
    private String D;
    private boolean E;
    private String F;
    private x G;
    private boolean H;
    public boolean I;
    public boolean J;
    private boolean K;

    /* JADX WARN: Multi-variable type inference failed */
    public i(x xVar) {
        this.D = HardCodeUtil.qqStr(R.string.n5h);
        this.I = true;
        this.J = false;
        this.G = xVar;
        this.C = xVar.l();
        if (xVar.o() != null) {
            if (xVar instanceof w) {
                this.E = ((w) xVar).getItemCount() > xVar.n();
            } else {
                this.E = xVar.o().size() > xVar.n();
            }
        }
    }

    private void B() {
        List<y> o16;
        if (this.K) {
            return;
        }
        this.K = true;
        if (!this.E || (o16 = this.G.o()) == null) {
            return;
        }
        for (y yVar : o16) {
            if (yVar instanceof ah) {
                com.tencent.mobileqq.search.report.b.e(null, 0, ((ah) yVar).R, "0X8009D46", 0, 0, null, null);
                return;
            } else if (yVar instanceof lo2.m) {
                lo2.m mVar = (lo2.m) yVar;
                if (mVar.J == Constant.FROM_ID_START_ACTIVITY) {
                    com.tencent.mobileqq.search.report.b.e(null, 0, mVar.R, "0X8009D52", 0, 0, null, null);
                    return;
                }
            }
        }
    }

    private void C(nn2.b bVar) {
        x xVar;
        boolean z16;
        String str;
        if (bVar != null && (xVar = this.G) != null && (xVar instanceof lo2.b)) {
            lo2.b bVar2 = (lo2.b) xVar;
            if (SearchUtils.D0(bVar2.D)) {
                if (!TextUtils.isEmpty(this.F) && (this.F.startsWith("http://") || this.F.startsWith("https://"))) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                String[] strArr = new String[3];
                strArr[0] = bVar.getSearchKeyword();
                strArr[1] = "" + w();
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                strArr[2] = str;
                SearchUtils.W0("all_result", "more_object", strArr);
            }
            if (!TextUtils.isEmpty(bVar2.x()) && bVar2.x().contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_SEARCH)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("ext6", m());
                List<y> list = bVar2.F;
                if (list != null && list.size() > 0 && (bVar2.F.get(0) instanceof ae)) {
                    int i3 = ((ae) bVar2.F.get(0)).f283491o0;
                    if (i3 == 6) {
                        hashMap.put("ext8", "1");
                    } else if (i3 == 5) {
                        hashMap.put("ext8", "2");
                    }
                }
                ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(73).setSubActionType(2).setThrActionType(2).setExtras(hashMap));
                com.tencent.mobileqq.search.report.b.e(null, 0, UniteSearchActivity.f282684b0, "0X800BA25", 0, 0, null, null);
            }
        }
    }

    public boolean A() {
        return this.E;
    }

    public void D(boolean z16) {
        this.E = z16;
    }

    public void E(boolean z16) {
        this.I = z16;
    }

    @Override // do2.r, com.tencent.mobileqq.search.model.x
    public String l() {
        return this.C;
    }

    @Override // do2.r, com.tencent.mobileqq.search.model.x
    public String m() {
        x xVar = this.G;
        if (xVar != null) {
            return xVar.m();
        }
        return null;
    }

    @Override // do2.r, com.tencent.mobileqq.search.model.x
    public int n() {
        return 3;
    }

    @Override // do2.r, com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void p() {
        super.p();
        B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // do2.r, com.tencent.mobileqq.search.model.x
    public void q(View view) {
        Context context = view.getContext();
        if (context instanceof nn2.b) {
            nn2.b bVar = (nn2.b) context;
            int currentPageType = bVar.getCurrentPageType();
            if (currentPageType != 1) {
                if (currentPageType != 2) {
                    if (currentPageType == 3) {
                        SearchUtils.W0("sub_result", "more_result", bVar.getSearchKeyword(), "" + bVar.getCurrentPageMasks(), "" + s(1), SearchUtils.g0("dynamic_tab_search.1", bVar.getCurrentPageMasks()));
                    }
                }
            } else {
                if (this.G instanceof lo2.b) {
                    C(bVar);
                }
                if (!SearchUtil.f282611a) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                        jSONObject.put("event_src", "client");
                        jSONObject.put("get_src", "web");
                    } catch (JSONException e16) {
                        QLog.e("Q.uniteSearch.SearchResultGroupModelImpl", 2, "e = " + e16);
                    }
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                    com.tencent.mobileqq.search.report.b.h(qQAppInterface, new ReportModelDC02528().module("all_result").action("clk_more").obj1(w() + "").ver1(bVar.getSearchKeyword()).ver2(com.tencent.mobileqq.search.report.b.a(UniteSearchActivity.f282684b0)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
                }
            }
            SearchUtils.W0("all_result", "clk_tab_more", m(), SearchUtils.e0(bVar.getCurrentPageMasks()), "", SearchUtils.g0("UnifySearch.Unite", bVar.getCurrentPageMasks()));
        }
        x xVar = this.G;
        if (xVar != null) {
            xVar.q(view);
        } else if (this.E) {
            context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(this.F)));
        }
    }

    public x v() {
        return this.G;
    }

    public long w() {
        int q16;
        x xVar = this.G;
        if (xVar != null && (q16 = SearchUtil.q(xVar)) > 0) {
            return q16;
        }
        x xVar2 = this.G;
        if (xVar2 != null && (xVar2 instanceof lo2.b)) {
            return ((lo2.b) xVar2).D;
        }
        return -1L;
    }

    public int x() {
        x xVar = this.G;
        if (xVar instanceof lo2.b) {
            if (SearchUtils.D0(((lo2.b) xVar).D)) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public boolean y() {
        return this.H;
    }

    public String z() {
        String str = this.D;
        if (str == null) {
            return "";
        }
        return str;
    }

    public i(x xVar, boolean z16, boolean z17) {
        this.D = HardCodeUtil.qqStr(R.string.n5h);
        this.I = true;
        this.J = false;
        this.G = xVar;
        this.C = xVar.l();
        this.E = z16;
        this.H = z17;
    }

    public i(x xVar, String str, boolean z16) {
        this.D = HardCodeUtil.qqStr(R.string.n5h);
        this.I = true;
        this.J = false;
        this.G = xVar;
        if (TextUtils.isEmpty(str)) {
            this.C = xVar.l();
        } else {
            this.C = str;
        }
        this.E = z16;
    }

    public i(String str, String str2, String str3) {
        HardCodeUtil.qqStr(R.string.n5h);
        this.I = true;
        this.J = false;
        this.C = str;
        this.D = str2;
        this.F = str3;
        if (TextUtils.isEmpty(str2)) {
            this.D = HardCodeUtil.qqStr(R.string.n5m);
        }
        this.E = !TextUtils.isEmpty(str3);
    }
}
