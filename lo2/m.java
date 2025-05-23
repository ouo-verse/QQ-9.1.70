package lo2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.QZoneHelper;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lo2.ai;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m extends com.tencent.mobileqq.search.model.z {

    /* renamed from: a0, reason: collision with root package name */
    public static final String f415228a0 = LogTag.TAG_UNITE_SEARCH + m.class.getName();
    public String G;
    private int H;
    private String I;
    public long J;
    public String K;
    public List<String> L;
    public String M;
    public String N;
    public com.tencent.mobileqq.search.util.e P;
    public String Q;
    public int R;
    private Object S;
    private List<Object> T;
    public a U;
    public boolean V;
    public String W;
    private boolean X;
    public String Y;
    public int Z = 0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f415229a;

        /* renamed from: b, reason: collision with root package name */
        public String f415230b;

        /* renamed from: c, reason: collision with root package name */
        public int f415231c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f415232d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f415233e;

        /* renamed from: f, reason: collision with root package name */
        public String f415234f;

        /* renamed from: g, reason: collision with root package name */
        public CharSequence f415235g;

        /* renamed from: h, reason: collision with root package name */
        public String f415236h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f415237i;

        /* renamed from: j, reason: collision with root package name */
        public int f415238j;

        /* renamed from: k, reason: collision with root package name */
        public int f415239k;

        public a() {
        }
    }

    public m(String str, long j3, List<String> list, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i3) {
        if (dynamicSearch$ResultItem != null) {
            this.G = dynamicSearch$ResultItem.result_id.get().toStringUtf8();
            this.H = dynamicSearch$ResultItem.layout_id.get();
            this.Q = dynamicSearch$ResultItem.extension.get().toStringUtf8();
            if (G()) {
                this.I = dynamicSearch$ResultItem.layout_content.get().toStringUtf8();
            }
            this.K = dynamicSearch$ResultItem.jmp_url.get().toStringUtf8();
            this.J = dynamicSearch$ResultItem.group_mask.has() ? dynamicSearch$ResultItem.group_mask.get() : j3;
            if (dynamicSearch$ResultItem.sub_result_items.has()) {
                ArrayList arrayList = new ArrayList();
                this.T = arrayList;
                arrayList.addAll(dynamicSearch$ResultItem.sub_result_items.get());
            }
            this.M = dynamicSearch$ResultItem.report_ext_data.get().toStringUtf8();
        }
        this.R = i3;
        this.S = dynamicSearch$ResultItem;
        this.L = list;
        this.N = str;
        this.P = new com.tencent.mobileqq.search.util.e(list, s());
        if (!TextUtils.isEmpty(this.I)) {
            S(this.I, null);
        }
        V(false);
        D(this.G);
    }

    private void L(View view) {
        long j3 = this.J;
        if (j3 == VasBusiness.QWALLET) {
            SearchUtils.A0(view.getContext(), Integer.valueOf(this.G).intValue(), -1);
            return;
        }
        if (j3 == 1001) {
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            SearchResultItem searchResultItem = new SearchResultItem();
            searchResultItem.f283460d = Long.valueOf(this.G).longValue();
            searchResultItem.f283462f = u().toString();
            ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToProfileCardActivity((Activity) view.getContext(), searchResultItem, appInterface, true, 1);
            return;
        }
        if (j3 == Constant.FROM_ID_UNINSTALL_PLUGIN) {
            Bundle troopProfileExtra = ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getTroopProfileExtra(this.G, 2);
            troopProfileExtra.putInt("exposureSource", 3);
            troopProfileExtra.putInt("t_s_f", 1000);
            ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToTroopInfoActivity(view.getContext(), troopProfileExtra, 2);
        }
    }

    protected boolean G() {
        return true;
    }

    public Object H() {
        return this.S;
    }

    public int I() {
        switch (this.H) {
            case 2:
                return R.layout.a0d;
            case 3:
                return R.layout.a0t;
            case 4:
                return R.layout.a0e;
            case 5:
            case 10:
            case 22:
            case 23:
            default:
                throw new RuntimeException(this.H + "in NetSearchTemplateBaseItem.getLayoutId() is not supported!!!");
            case 6:
                return R.layout.a0s;
            case 7:
            case 19:
                return R.layout.a0h;
            case 8:
                return R.layout.a0p;
            case 9:
                return R.layout.a0q;
            case 11:
                return R.layout.a0g;
            case 12:
                return R.layout.a0f;
            case 13:
                return R.layout.a0j;
            case 14:
                return R.layout.a0r;
            case 15:
                return R.layout.a0n;
            case 16:
                return R.layout.f168537a04;
            case 17:
                return R.layout.b1t;
            case 18:
                return R.layout.bxi;
            case 20:
            case 21:
                return R.layout.fuj;
            case 24:
                return R.layout.fuu;
            case 25:
            case 26:
                return R.layout.fui;
            case 27:
                return R.layout.fuo;
        }
    }

    public int J() {
        return this.H;
    }

    public int K(int i3) {
        return 1;
    }

    protected boolean M(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ax c16 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), context, str);
        if (c16 != null) {
            c16.b();
            SearchUtils.j1(u().toString(), str);
            return true;
        }
        if (URLUtil.isNetworkUrl(str)) {
            QZoneHelper.reportIfIsFromQZone(str);
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToQQBrowserActivity(context, hashMap);
            return true;
        }
        if (!str.startsWith("tel://")) {
            return false;
        }
        context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + str.substring(6))));
        return true;
    }

    public boolean N() {
        return true;
    }

    public boolean O() {
        ai aiVar;
        ArrayList<ai.c> arrayList;
        ai.c cVar;
        if (!(this instanceof ai) || TextUtils.isEmpty(this.N) || (arrayList = (aiVar = (ai) this).f415127d0) == null || arrayList.size() <= 0 || (cVar = aiVar.f415127d0.get(0)) == null) {
            return false;
        }
        return cVar.f415141a.toString().equalsIgnoreCase(this.N);
    }

    public boolean P() {
        if ("\u81ea\u6740".equals(this.N) && this.J == 1000000) {
            return true;
        }
        return false;
    }

    public void Q() {
        U();
    }

    public void R(JSONObject jSONObject) {
        this.U = new a();
        int optInt = jSONObject.optInt(NodeProps.CUSTOM_PROP_IMAGE_TYPE);
        this.U.f415230b = jSONObject.optString("imageUrl");
        this.U.f415229a = K(optInt);
        this.U.f415231c = jSONObject.optInt("cornerRadius");
        a aVar = this.U;
        boolean z16 = true;
        if (jSONObject.optInt("needPlayIcon") != 1) {
            z16 = false;
        }
        aVar.f415232d = z16;
        this.U.f415233e = jSONObject.optString("topLeftTagText");
        this.U.f415234f = jSONObject.optString("topLeftTagColor");
        this.U.f415235g = jSONObject.optString("bottomRightText");
        this.U.f415236h = jSONObject.optString("bottomRightIconUrl");
        this.U.f415237i = jSONObject.optString("bottomRightIconText");
        this.U.f415239k = jSONObject.optInt("imageHeight");
        this.U.f415238j = jSONObject.optInt("imageWidth");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        int i3;
        String str;
        HashMap<com.tencent.mobileqq.search.model.v, SearchUtils.d> hashMap = SearchUtils.f284965n;
        if (hashMap.containsKey(this)) {
            SearchUtils.d dVar = hashMap.get(this);
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("project", ((ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class)).getSearchPlanReportString());
                jSONObject.put("event_src", "client");
                jSONObject.put("obj_lct", dVar.f284978c);
                jSONObject.put("get_src", "web");
                jSONObject.put("tepl", this.M);
            } catch (JSONException e16) {
                QLog.e(f415228a0, 2, "e = " + e16);
            }
            if (this instanceof af) {
                str = "clk_more";
            } else {
                str = "clk_item";
            }
            com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action(str).obj1(this.J + "").obj2(dVar.f284980e).ver1(this.N).ver2(com.tencent.mobileqq.search.report.b.a(this.R)).ver7(jSONObject.toString()).session_id(appInterface.getCurrentAccountUin() + SearchUtils.f284963l));
        }
        if (SearchUtils.f284964m.containsKey(this)) {
            SearchUtils.d dVar2 = SearchUtils.f284964m.get(this);
            if (dVar2.f284981f) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            SearchUtils.U0("all_result", "clk_object", i3, 0, this.N, "" + this.J, dVar2.f284980e + "", dVar2.f284978c + "");
        }
    }

    public void U() {
        if (this.X) {
            return;
        }
        this.X = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(boolean z16) {
        long j3 = this.J;
        if (j3 == Constant.FROM_ID_START_ACTIVITY) {
            C(17);
            if (O()) {
                C(5);
                return;
            }
            return;
        }
        if (j3 == 1106) {
            C(14);
            return;
        }
        if (j3 == 1101) {
            C(19);
            return;
        }
        if (j3 == 1100) {
            C(10);
            if (z16) {
                C(1);
                return;
            }
            return;
        }
        if (j3 == 1105) {
            C(18);
            return;
        }
        if (j3 == 1108) {
            C(22);
            return;
        }
        if (P()) {
            C(21);
            return;
        }
        long j16 = this.J;
        if (j16 == 1111) {
            C(24);
            return;
        }
        if (j16 == 1114) {
            C(25);
            return;
        }
        if (j16 == 1115) {
            C(26);
            return;
        }
        if (j16 == 1116) {
            C(27);
        } else if (j16 == 1110) {
            C(28);
        } else if (j16 == 1117) {
            C(29);
        }
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public String l() {
        return this.G;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence m() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public String s() {
        return this.N;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence t() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence u() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        T();
        if (M(view.getContext(), this.K)) {
            return;
        }
        L(view);
    }

    public m(String str, long j3, List<String> list, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i3) {
        if (unifySearchCommon$ResultItem != null) {
            this.G = unifySearchCommon$ResultItem.result_id.get().toStringUtf8();
            this.H = unifySearchCommon$ResultItem.layout_id.get();
            this.Q = unifySearchCommon$ResultItem.extension.get().toStringUtf8();
            if (G()) {
                this.I = unifySearchCommon$ResultItem.layout_content.get().toStringUtf8();
            }
            this.K = unifySearchCommon$ResultItem.jmp_url.get().toStringUtf8();
            this.J = unifySearchCommon$ResultItem.group_mask.has() ? unifySearchCommon$ResultItem.group_mask.get() : j3;
            if (unifySearchCommon$ResultItem.sub_result_items.has()) {
                ArrayList arrayList = new ArrayList();
                this.T = arrayList;
                arrayList.addAll(unifySearchCommon$ResultItem.sub_result_items.get());
            }
            this.M = unifySearchCommon$ResultItem.report_ext_data.get().toStringUtf8();
        }
        this.R = i3;
        this.S = unifySearchCommon$ResultItem;
        this.L = list;
        this.N = str;
        this.P = new com.tencent.mobileqq.search.util.e(list, s());
        if (!TextUtils.isEmpty(this.I)) {
            S(this.I, null);
        }
        V(false);
        D(this.G);
    }

    public m(String str, long j3, List<String> list, UfsResultItem ufsResultItem, int i3) {
        if (ufsResultItem != null) {
            this.G = ufsResultItem.resultId;
            this.H = ufsResultItem.layoutId;
            this.Q = ufsResultItem.bytesExtension;
            if (G()) {
                this.I = new String(ufsResultItem.layoutContent, StandardCharsets.UTF_8);
            }
            this.K = ufsResultItem.jmpUrl;
            long j16 = ufsResultItem.groupMask;
            this.J = j16 > 0 ? j16 : j3;
            ArrayList<UfsResultItem> arrayList = ufsResultItem.subResultItems;
            if (arrayList != null && !arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                this.T = arrayList2;
                arrayList2.addAll(ufsResultItem.subResultItems);
            }
            this.M = new String(ufsResultItem.reportExtData, StandardCharsets.UTF_8);
        }
        this.R = i3;
        this.S = ufsResultItem;
        this.L = list;
        this.N = str;
        this.P = new com.tencent.mobileqq.search.util.e(list, s());
        if (!TextUtils.isEmpty(this.I)) {
            S(this.I, ufsResultItem != null ? ufsResultItem.layoutContentObject : null);
        }
        V(false);
        D(this.G);
    }

    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
    }
}
