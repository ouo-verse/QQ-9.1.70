package pn2;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends z {
    public String G;
    public String H;
    public int I;
    public int J;
    public String K;
    public String L;
    public String M;
    public String N;
    public String P;
    public String Q;
    public boolean R;
    public boolean S;
    public boolean T;
    private String U;
    private String V;

    public c(String str, int i3, int i16, boolean z16) {
        this.G = str;
        this.I = i3;
        this.J = i16;
        this.R = z16;
        M();
    }

    private void L() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchResultModelForEntrance", 2, "extension info:" + this.L);
        }
        if (!TextUtils.isEmpty(this.L)) {
            try {
                JSONObject jSONObject = new JSONObject(this.L);
                if (jSONObject.getInt("hideArrow") == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.R = z16;
                this.M = jSONObject.optString("title1");
                this.G = jSONObject.optString("title2");
                this.N = jSONObject.optString("title3");
                this.P = jSONObject.optString("secondLine");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public String G() {
        return this.V;
    }

    public String H() {
        if (this.S) {
            return HardCodeUtil.qqStr(R.string.f213955rl);
        }
        return HardCodeUtil.qqStr(R.string.f213935rj);
    }

    public int I() {
        int i3 = this.I;
        if (i3 != -4 && i3 != -3) {
            return R.layout.f168534a00;
        }
        return R.layout.f168531zu;
    }

    public boolean J() {
        if (this.I == -1) {
            return true;
        }
        return false;
    }

    public boolean K() {
        return this.T;
    }

    protected void M() {
        int i3 = this.I;
        if (i3 == -1 || i3 == -5) {
            C(8);
        }
    }

    public void N(String str) {
        this.V = str;
    }

    public void O(String str) {
        this.U = str;
    }

    public void P(boolean z16) {
        this.T = z16;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        int i3 = this.I;
        if (i3 != -5) {
            if (i3 != -4) {
                if (i3 != -1) {
                    return "";
                }
            } else {
                return this.P;
            }
        }
        return nn2.a.g(MobileQQ.sMobileQQ, ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getCurrentUin());
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return this.R;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeywords() {
        return this.U;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitle() {
        return this.G;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitle() {
        int i3 = this.I;
        if (i3 != -5) {
            if (i3 != -4) {
                if (i3 != -1) {
                    return HardCodeUtil.qqStr(R.string.t7i);
                }
            } else {
                return this.M;
            }
        }
        return this.G;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        int i3 = this.I;
        String str = "";
        if (i3 != -4 && i3 != -3) {
            if (i3 != -1) {
                String str2 = this.H;
                if (i3 == -5) {
                    try {
                        if (TextUtils.isEmpty(URLDecoder.decode(Uri.parse(str2).getQueryParameter("keyword"), "UTF-8").trim())) {
                            QQToast.makeText(view.getContext(), HardCodeUtil.qqStr(R.string.t66), 0).show();
                            return;
                        }
                    } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    ax c16 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), view.getContext(), str2);
                    if (c16 != null) {
                        c16.b();
                        return;
                    } else {
                        if (str2.startsWith("http://") || str2.startsWith("https://")) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("url", str2);
                            ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToQQBrowserActivity(view.getContext(), hashMap);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            long[] jArr = {1001, Constant.FROM_ID_UNINSTALL_PLUGIN, 1107};
            if (this.S) {
                jArr = new long[]{1001, Constant.FROM_ID_UNINSTALL_PLUGIN, 1107, 1108};
            }
            ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToActiveEntitySearchActivity(view.getContext(), this.G, HardCodeUtil.qqStr(R.string.f172669t74), jArr);
            SearchUtils.W0("all_result", "clk_people_group", this.G);
            SearchUtils.V0("all_search", "all_result", "clk_user_grp", 0, 0, "", "", this.G, "");
            if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
                HashMap<v, SearchUtils.d> hashMap2 = SearchUtils.f284965n;
                if (hashMap2.containsKey(this)) {
                    SearchUtils.d dVar = hashMap2.get(this);
                    AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("project", ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getSearchPlanReportString());
                        jSONObject.put("event_src", "client");
                        jSONObject.put("obj_lct", dVar.f284978c);
                        jSONObject.put("get_src", "native");
                    } catch (JSONException e16) {
                        QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, "e = " + e16);
                    }
                    ((ISearchReportFetcher) QRoute.api(ISearchReportFetcher.class)).onReportRuntimeDC02528(appInterface, dVar.f284977b, dVar.f284980e, dVar.f284976a, jSONObject);
                }
                ((ISearchReportFetcher) QRoute.api(ISearchReportFetcher.class)).onReportClick898(null, this.C, 0, "0X8009D3F", 0, 0, null, null);
                return;
            }
            return;
        }
        String jumpUrl = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getJumpUrl(view.getContext(), this.G, this.H);
        if (!TextUtils.isEmpty(jumpUrl)) {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("url", jumpUrl);
            hashMap3.put("search_title", this.G);
            ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToQQBrowserActivity(view.getContext(), hashMap3);
        }
        String[] strArr = new String[1];
        if (!TextUtils.isEmpty(this.G)) {
            str = this.G;
        }
        strArr[0] = str;
        SearchUtils.W0("all_result", "clk_net_search", strArr);
        if (((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).isUniteSearchActivity(view.getContext())) {
            HashMap<v, SearchUtils.d> hashMap4 = SearchUtils.f284965n;
            if (hashMap4.containsKey(this)) {
                SearchUtils.d dVar2 = hashMap4.get(this);
                AppInterface appInterface2 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("project", ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getSearchPlanReportString());
                    jSONObject2.put("event_src", "client");
                    jSONObject2.put("obj_lct", dVar2.f284978c);
                    jSONObject2.put("get_src", "web");
                } catch (JSONException e17) {
                    QLog.e("Q.uniteSearch.SearchResultModelForEntrance", 2, "e = " + e17);
                }
                ((ISearchReportFetcher) QRoute.api(ISearchReportFetcher.class)).onReportRuntimeDC02528(appInterface2, dVar2.f284977b, dVar2.f284980e, dVar2.f284976a, jSONObject2);
            }
        }
    }

    public c(String str, String str2, int i3, String str3) {
        this.R = true;
        this.G = str;
        this.L = str2;
        this.I = i3;
        this.K = str3;
        L();
        M();
    }
}
