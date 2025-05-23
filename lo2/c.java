package lo2;

import MQQ.LhLogoResources;
import NearbyGroup.Color;
import NearbyGroup.GroupLabel;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imsdk.BaseConstants;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchQidianUtilApi;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.util.NumberUtil;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends com.tencent.mobileqq.search.model.z {
    public boolean A0;
    public int B0;
    public String C0;
    public boolean D0;
    public int E0;
    public long F0;
    protected String G;
    public String G0;
    public String H;
    public String H0;
    public String I;
    public List<RecommendLabel> I0;
    protected String J;
    public String J0;
    public String K;
    public int K0;
    protected String L;
    public int L0;
    protected long M;
    public int M0;
    protected CharSequence N;
    public int N0;
    public String O0;
    protected CharSequence P;
    public String P0;
    protected String Q;
    public int Q0;
    protected boolean R;
    public int R0;
    public List<String> S;
    public int S0;
    public int T;
    public int T0;
    public int U;
    private int U0;
    public String V;
    private String V0;
    public boolean W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f415183a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f415184b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f415185c0;

    /* renamed from: d0, reason: collision with root package name */
    public long f415186d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f415187e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f415188f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f415189g0;

    /* renamed from: h0, reason: collision with root package name */
    public ArrayList<GroupLabel> f415190h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f415191i0;

    /* renamed from: j0, reason: collision with root package name */
    public String f415192j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f415193k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f415194l0;

    /* renamed from: m0, reason: collision with root package name */
    public String f415195m0;

    /* renamed from: n0, reason: collision with root package name */
    public String f415196n0;

    /* renamed from: o0, reason: collision with root package name */
    public String f415197o0;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f415198p0;

    /* renamed from: q0, reason: collision with root package name */
    public int[] f415199q0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f415200r0;

    /* renamed from: s0, reason: collision with root package name */
    StringBuffer f415201s0;

    /* renamed from: t0, reason: collision with root package name */
    Context f415202t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f415203u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f415204v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f415205w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f415206x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f415207y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f415208z0;

    public c() {
        this.R = false;
        this.W = false;
        this.Y = R.color.skin_gray2_item;
        this.f415185c0 = -1;
        this.f415189g0 = -1;
        this.f415199q0 = new int[3];
        this.f415201s0 = new StringBuffer();
        this.f415202t0 = BaseApplication.getContext();
        this.f415204v0 = 0;
        this.f415207y0 = false;
        this.f415208z0 = false;
        this.A0 = false;
        this.H0 = "";
        this.J0 = null;
        this.L0 = -1;
        this.M0 = -1;
        this.Q0 = 0;
        this.U0 = 0;
    }

    private void P() {
        JSONObject jSONObject;
        boolean z16;
        int i3;
        boolean z17;
        JSONObject jSONObject2;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "extension info:" + this.L);
        }
        if (!TextUtils.isEmpty(this.L)) {
            try {
                JSONObject jSONObject3 = new JSONObject(this.L);
                String optString = jSONObject3.optString("thirdLineText");
                if (Q(this.M, jSONObject3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "child class has already parsed json data. groupMask=" + this.M);
                        return;
                    }
                    return;
                }
                int i17 = (int) this.M;
                if (i17 != 1001) {
                    if (i17 != 1002) {
                        if (i17 != 1107) {
                            if (i17 == 1073745984) {
                                this.X = jSONObject3.optInt("video_or_music");
                                String optString2 = jSONObject3.optString("busi_mask");
                                if (!TextUtils.isEmpty(optString2)) {
                                    if (Integer.parseInt(optString2) == 2049) {
                                        this.N = jSONObject3.optString("brief");
                                    } else if (Integer.parseInt(optString2) == 64) {
                                        this.N = jSONObject3.optString("content");
                                    } else if (Integer.parseInt(optString2) == 4096) {
                                        this.N = jSONObject3.optString("description");
                                    }
                                    this.P = jSONObject3.optString("from") + com.tencent.mobileqq.search.util.c.a(Long.parseLong(jSONObject3.optString(AlbumCacheData.CREATE_TIME)));
                                    this.R = true;
                                }
                            }
                        } else {
                            if (jSONObject3.optLong("join_flag", -1L) > 0) {
                                i16 = 0;
                            } else {
                                i16 = 1;
                            }
                            this.E0 = i16;
                            this.G0 = jSONObject3.optString("join_guild_sig");
                            this.J = jSONObject3.optString("avatar", this.J);
                            this.O0 = jSONObject3.optString("guild_code");
                            this.W = true;
                        }
                    } else {
                        this.f415186d0 = jSONObject3.optLong("flag_ext");
                        this.Q = "";
                        JSONArray optJSONArray = jSONObject3.optJSONArray("label");
                        if (optJSONArray != null) {
                            ArrayList<GroupLabel> arrayList = new ArrayList<>();
                            int i18 = 0;
                            while (i18 < optJSONArray.length()) {
                                try {
                                    JSONObject jSONObject4 = optJSONArray.getJSONObject(i18);
                                    GroupLabel groupLabel = new GroupLabel();
                                    Color color = new Color();
                                    JSONObject optJSONObject = jSONObject4.optJSONObject("edging_color");
                                    jSONObject2 = jSONObject3;
                                    try {
                                        color.R = optJSONObject.optLong("r");
                                        color.G = optJSONObject.optLong("g");
                                        color.B = optJSONObject.optLong("b");
                                        groupLabel.edging_color = color;
                                        Color color2 = new Color();
                                        JSONObject optJSONObject2 = jSONObject4.optJSONObject("text_color");
                                        color2.R = optJSONObject2.optLong("r");
                                        color2.G = optJSONObject2.optLong("g");
                                        color2.B = optJSONObject2.optLong("b");
                                        groupLabel.text_color = color2;
                                        groupLabel.strWording = jSONObject4.optString("name");
                                        groupLabel.type = jSONObject4.optLong("attr");
                                        arrayList.add(groupLabel);
                                    } catch (JSONException e16) {
                                        e = e16;
                                        if (QLog.isColorLevel()) {
                                            QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "parse extension JSONException:" + e.toString());
                                        }
                                        i18++;
                                        jSONObject3 = jSONObject2;
                                    }
                                } catch (JSONException e17) {
                                    e = e17;
                                    jSONObject2 = jSONObject3;
                                }
                                i18++;
                                jSONObject3 = jSONObject2;
                            }
                            jSONObject = jSONObject3;
                            this.f415190h0 = arrayList;
                        } else {
                            jSONObject = jSONObject3;
                        }
                        JSONObject jSONObject5 = jSONObject;
                        String optString3 = jSONObject5.optString("memo");
                        if (TextUtils.isEmpty(optString3)) {
                            optString3 = this.f415202t0.getString(R.string.drk);
                        }
                        this.N = optString3;
                        long optLong = jSONObject5.optLong("active", 0L);
                        long optLong2 = jSONObject5.optLong("join_group_flag", -1L);
                        long optLong3 = jSONObject5.optLong("privilege_flag", 0L);
                        this.H0 = jSONObject5.optString("arithmetic");
                        if (jSONObject5.optInt("exact_search") == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.f415200r0 = z16;
                        this.F0 = optLong;
                        if (optLong2 > -1) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        this.E0 = i3;
                        if ((512 & optLong3) != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        this.D0 = z17;
                        this.G0 = jSONObject5.optString("join_group_auth");
                        this.M0 = jSONObject5.optInt("allow", -1);
                        this.N0 = jSONObject5.optInt("invite_only", 0);
                    }
                } else {
                    this.Q = "(" + this.H + ")";
                    this.Z = jSONObject3.optInt("gender");
                    this.f415183a0 = jSONObject3.optInt("age");
                    T(jSONObject3.optString(IProfileProtocolConst.KEY_COLLEGE), 1);
                    if (jSONObject3.optString("location").equals(jSONObject3.optString(IProfileProtocolConst.KEY_HOMETOWN))) {
                        T(jSONObject3.optString("location"), 4);
                    } else {
                        T(jSONObject3.optString("location"), 4);
                        T(jSONObject3.optString(IProfileProtocolConst.KEY_HOMETOWN), 4);
                    }
                    T(jSONObject3.optString(LpReport_UserInfo_dc02148.CONSTELLATION), 2);
                    this.N = jSONObject3.optString("location");
                    this.f415188f0 = jSONObject3.optString("authIcon");
                    this.J0 = jSONObject3.optString("longnick");
                    this.M0 = jSONObject3.optInt("allow", -1);
                    this.f415184b0 = jSONObject3.optInt("liangrichflag", 0);
                    this.f415185c0 = jSONObject3.optInt("liangnumblevel", -1);
                    try {
                        this.B0 = jSONObject3.optInt("cspecialflag");
                        String optString4 = jSONObject3.optString("qdmasteruin");
                        String optString5 = jSONObject3.optString("qdemailuin");
                        this.C0 = jSONObject3.optString("kfaccount");
                        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                        ((ISearchQidianUtilApi) QRoute.api(ISearchQidianUtilApi.class)).updateQidianAccountType(appInterface, this.B0, this.H);
                        if (!TextUtils.isEmpty(this.C0) && com.tencent.mobileqq.search.util.y.c()) {
                            ((ISearchQidianUtilApi) QRoute.api(ISearchQidianUtilApi.class)).updateQidianAccountType(appInterface, this.B0, this.C0);
                        }
                        ((ISearchQidianUtilApi) QRoute.api(ISearchQidianUtilApi.class)).addShowUin(appInterface, this.H, optString4);
                        if (((ISearchQidianUtilApi) QRoute.api(ISearchQidianUtilApi.class)).isQidianMaster(this.B0) || ((ISearchQidianUtilApi) QRoute.api(ISearchQidianUtilApi.class)).isCrmMaster(this.B0)) {
                            if (TextUtils.isEmpty(optString5)) {
                                this.Q = "";
                                QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json qdemailuin is empty ");
                            } else {
                                this.Q = "(" + optString5 + ")";
                            }
                            if (TextUtils.isEmpty(this.C0)) {
                                QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json kfaccount is empty ");
                            }
                        }
                    } catch (Exception e18) {
                        e18.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "Parse search qidian json fail: " + this.H + APLogFileUtil.SEPARATOR_LOG + e18.getMessage());
                        }
                    }
                }
                if (!TextUtils.isEmpty(optString)) {
                    this.P = optString;
                }
            } catch (JSONException e19) {
                e19.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.search.model.z
    public boolean B() {
        if (!TextUtils.isEmpty(this.I) && this.I.equals(this.G)) {
            return true;
        }
        return false;
    }

    public String G() {
        String str = this.H0;
        if (str != null) {
            return str;
        }
        return "";
    }

    public String H() {
        return this.J;
    }

    public int I(Context context) {
        Intent intent;
        if (!(context instanceof Activity) || (intent = ((Activity) context).getIntent()) == null) {
            return 0;
        }
        return intent.getIntExtra("from_type_for_report", 0);
    }

    public int J() {
        return (int) this.M;
    }

    public String K() {
        return this.H;
    }

    public int L() {
        return this.U0;
    }

    public String M() {
        String str = this.H;
        if (((ISearchQidianUtilApi) QRoute.api(ISearchQidianUtilApi.class)).isQidianMaster(this.B0) || ((ISearchQidianUtilApi) QRoute.api(ISearchQidianUtilApi.class)).isCrmMaster(this.B0)) {
            return this.C0;
        }
        return str;
    }

    public int N(int i3) {
        int i16;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    i16 = -1;
                } else {
                    i16 = this.T0;
                }
            } else {
                i16 = this.S0;
            }
        } else {
            i16 = this.R0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "getPosition(). type=" + i3 + "  position=" + i16);
        }
        return i16;
    }

    public boolean O() {
        boolean z16 = false;
        if (!TextUtils.isEmpty(this.L)) {
            try {
                if (new JSONObject(this.L).optInt("is_mobile_no", 0) == 1) {
                    z16 = true;
                }
            } catch (JSONException e16) {
                QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "isMobileNumberSearchResult JSONException", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "isMobileNumberSearchResult result = " + z16);
        }
        return z16;
    }

    public boolean Q(long j3, JSONObject jSONObject) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "JSONObject info:" + jSONObject);
            return false;
        }
        return false;
    }

    protected void R() {
        long j3 = this.M;
        if (j3 == VasBusiness.QWALLET) {
            C(11);
            if (B()) {
                C(4);
                return;
            }
            return;
        }
        if (j3 == 1001) {
            C(6);
        } else if (j3 == Constant.FROM_ID_UNINSTALL_PLUGIN) {
            C(7);
        }
    }

    public void S(int i3) {
        this.U0 = i3;
    }

    public void T(String str, int i3) {
        int i16;
        if (str != null && !str.equals("")) {
            if (this.I0 == null) {
                this.I0 = new ArrayList();
            }
            if (i3 == 3 && ((this.I0.size() > 2 && ((i16 = this.Z) == 1 || i16 == 2)) || this.I0.size() > 3)) {
                return;
            }
            MayKnowRecommend.MayKnowRecommendLabel mayKnowRecommendLabel = new MayKnowRecommend.MayKnowRecommendLabel();
            mayKnowRecommendLabel.text_color = -1;
            mayKnowRecommendLabel.bytes_name = str;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            mayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#C573FF");
                        }
                    } else {
                        mayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#FF8A2D");
                    }
                } else {
                    mayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#FFC619");
                }
            } else {
                mayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#7373FF");
            }
            this.I0.add(mayKnowRecommendLabel);
        }
    }

    public void U(String str) {
        this.V0 = str;
    }

    public void V(int i3, int i16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.T0 = i16;
                    return;
                }
                return;
            }
            this.S0 = i16;
            return;
        }
        this.R0 = i16;
    }

    public void W(int i3, int i16, int i17) {
        V(2, i3);
        V(1, i16);
        V(3, i17);
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        if (J() == 1001) {
            return 1;
        }
        if (J() == 1002) {
            return 4;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public String l() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence m() {
        com.tencent.mobileqq.search.util.e eVar = new com.tencent.mobileqq.search.util.e(this.S, getKeyword());
        String i06 = SearchUtils.i0(this.N);
        this.N = i06;
        boolean z16 = false;
        SpannableString e16 = eVar.e(i06, false, false, false);
        if (eVar.f285040b > 0) {
            z16 = true;
        }
        this.f415208z0 = z16;
        if (e16 == null) {
            return "";
        }
        return e16;
    }

    @Override // com.tencent.mobileqq.search.model.z, com.tencent.mobileqq.search.model.y
    public Object n(String str) {
        int i3 = 0;
        r1 = false;
        boolean z16 = false;
        if ("ActiveEntitySearchResultPresenter_add_troop".equals(str)) {
            String string = this.f415202t0.getResources().getString(R.string.fvi);
            int i16 = this.E0;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 == 2) {
                        string = this.f415202t0.getResources().getString(R.string.fvj);
                    }
                } else {
                    string = this.f415202t0.getResources().getString(R.string.fvi);
                }
                z16 = true;
            } else {
                string = this.f415202t0.getResources().getString(R.string.fvk);
            }
            return new Pair(string, Boolean.valueOf(z16));
        }
        if ("ActiveEntitySearchResultPresenter_pay_troop".equals(str)) {
            return Boolean.valueOf(this.D0);
        }
        if ("ActiveEntitySearchResultPresenter_hot_troop".equals(str)) {
            int i17 = (int) this.F0;
            if (i17 >= 0) {
                i3 = i17;
            }
            if (i3 > 10) {
                i3 = 10;
            }
            return Integer.valueOf(i3);
        }
        return super.n(str);
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        if (!this.f415207y0 && !this.f415208z0) {
            SpannableString d16 = new com.tencent.mobileqq.search.util.e(this.S, getKeyword()).d(this.P, false, this.R);
            if (d16 == null) {
                return "";
            }
            return d16;
        }
        return this.P;
    }

    @Override // com.tencent.mobileqq.search.model.z, com.tencent.mobileqq.search.model.y
    public int p() {
        return this.f415205w0;
    }

    @Override // com.tencent.mobileqq.search.model.z, com.tencent.mobileqq.search.model.y
    public int q() {
        return this.f415206x0;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.G;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        CharSequence i06;
        com.tencent.mobileqq.search.util.e eVar = new com.tencent.mobileqq.search.util.e(this.S, getKeyword());
        String str = null;
        if (!TextUtils.isEmpty(this.V)) {
            i06 = SearchUtils.i0("(" + this.V + ")");
        } else if (this.f415184b0 == 1) {
            this.Q = SearchUtils.i0(this.Q);
            LhLogoResources lhLogoResources = PrettyAccountUtil.getLhLogoResources(this.f415185c0);
            if (lhLogoResources != null) {
                str = lhLogoResources.lightColor;
            }
            i06 = PrettyAccountUtil.handleAccountTxt(this.f415184b0, this.f415185c0, this.Q, this.H);
        } else {
            i06 = SearchUtils.i0(this.Q);
        }
        SpannableString b16 = eVar.b(i06, str, false, false, true);
        if (b16 == null) {
            return "";
        }
        return b16;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        boolean z16 = false;
        if (J() == 268435456) {
            try {
                return SearchUtils.G(this.I, getKeyword(), true);
            } catch (Exception e16) {
                QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, e16, new Object[0]);
                return this.I;
            }
        }
        com.tencent.mobileqq.search.util.e eVar = new com.tencent.mobileqq.search.util.e(this.S, getKeyword());
        if (J() == 1002) {
            String i06 = SearchUtils.i0(this.I);
            this.I = i06;
            SpannableString c16 = eVar.c(i06, true);
            if (c16 == null) {
                return "";
            }
            return c16;
        }
        String i07 = SearchUtils.i0(this.I);
        this.I = i07;
        SpannableString c17 = eVar.c(i07, true);
        if (eVar.f285040b > 0) {
            z16 = true;
        }
        this.f415207y0 = z16;
        if (c17 == null) {
            return "";
        }
        return c17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:169:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x06ec  */
    @Override // com.tencent.mobileqq.search.model.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(View view) {
        Class cls;
        Context context;
        int i3;
        int i16;
        String str;
        Context context2;
        long[] longArrayExtra;
        int i17;
        int i18;
        int i19;
        char c16;
        String str2;
        int i26;
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "onAction(). jumpUrl = " + this.K + "  id=" + this.H);
        }
        int J = J();
        if (J == 1001) {
            SearchUtils.e1(this.G, 70, 0, this.f415203u0, view);
            if (this.L0 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 0, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 2, 0, "", "", "", "");
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 0, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 1, 0, "", "", "", "");
            }
        } else if (J == 1002) {
            SearchUtils.e1(this.G, 80, 0, this.f415203u0, view);
        } else if (J == 268435456) {
            SearchUtils.o1((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), this.G, this.V0, K(), L());
            SearchUtils.e1(this.G, 120, 0, this.f415203u0, view);
            String str3 = this.V0;
            if (str3 != null && !TextUtils.isEmpty(str3)) {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.T, "0X8009D31", 4, 0, this.H, null);
            } else if (B()) {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.T, "0X8009D35", 0, 0, this.H, null);
            } else {
                com.tencent.mobileqq.search.report.b.e(null, 0, this.T, "0X8009D49", 0, 0, this.H, null);
            }
        }
        if (this.M == Constant.FROM_ID_UNINSTALL_PLUGIN) {
            ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).reportSearchResultClickItem(this);
        }
        EventCollector.getInstance().onViewClicked(view);
        Context context3 = view.getContext();
        if (context3 instanceof nn2.b) {
            nn2.b bVar = (nn2.b) context3;
            bVar.isInitiativeSearch();
            ActivityResultCaller currentSearchFragment = bVar.getCurrentSearchFragment();
            an anVar = currentSearchFragment instanceof an ? (an) currentSearchFragment : null;
            int currentPageType = bVar.getCurrentPageType();
            if (currentPageType == 1) {
                cls = ISearchUtilFetcher.class;
                str = "all_result";
                HashMap<com.tencent.mobileqq.search.model.v, SearchUtils.d> hashMap = SearchUtils.f284965n;
                if (!hashMap.containsKey(this) || J() == 268435456) {
                    context = context3;
                } else {
                    SearchUtils.d dVar = hashMap.get(this);
                    AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                        jSONObject.put("event_src", "client");
                        jSONObject.put("obj_lct", dVar.f284978c);
                        jSONObject.put("get_src", "web");
                    } catch (JSONException e16) {
                        QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "e = " + e16);
                    }
                    ReportModelDC02528 action = new ReportModelDC02528().module(str).action("clk_item");
                    StringBuilder sb5 = new StringBuilder();
                    context = context3;
                    sb5.append(this.M);
                    sb5.append("");
                    com.tencent.mobileqq.search.report.b.h(null, action.obj1(sb5.toString()).obj2(dVar.f284980e).ver1(this.G).ver2(com.tencent.mobileqq.search.report.b.a(this.T)).ver7(jSONObject.toString()).session_id(appInterface.getCurrentAccountUin() + SearchUtils.f284963l));
                }
                if (SearchUtils.D0(this.M)) {
                    if (SearchUtils.f284964m.containsKey(this)) {
                        SearchUtils.d dVar2 = SearchUtils.f284964m.get(this);
                        int i27 = dVar2.f284981f ? 2 : 1;
                        c16 = 0;
                        SearchUtils.U0(str, "clk_object", i27, 0, this.G, "" + this.M, dVar2.f284980e + "", dVar2.f284978c + "");
                    } else {
                        c16 = 0;
                    }
                    if (anVar != null && anVar.isFirstClickResultItem()) {
                        anVar.setFirstClickResultItemFlag(true);
                        String[] strArr = new String[4];
                        strArr[c16] = bVar.getSearchKeyword();
                        strArr[1] = "" + this.M;
                        strArr[2] = "" + N(3);
                        strArr[3] = SearchUtils.g0("dynamic_tab_search.1", bVar.getCurrentPageMasks());
                        SearchUtils.W0(str, "clk_first_result", strArr);
                    }
                } else {
                    SearchUtils.U0(str, "clk_content", ((ISearchUtilFetcher) QRoute.api(cls)).getSearchUtilIsContentFromHotWord() ? 2 : 1, 0, bVar.getSearchKeyword(), "" + this.M, "", SearchUtils.g0("dynamic_tab_search.1", bVar.getCurrentPageMasks()));
                    if (anVar != null && anVar.isFirstClickResultItem()) {
                        anVar.setFirstClickResultItemFlag(true);
                        i16 = 4;
                        i3 = 3;
                        SearchUtils.W0(str, "clk_first_result", bVar.getSearchKeyword(), "" + this.M, "" + N(2), SearchUtils.g0("dynamic_tab_search.1", bVar.getCurrentPageMasks()));
                    }
                }
                i16 = 4;
                i3 = 3;
            } else if (currentPageType == 2) {
                if (anVar == null || !anVar.isFirstClickResultItem()) {
                    str = "all_result";
                } else {
                    anVar.setFirstClickResultItemFlag(true);
                    str = "all_result";
                    SearchUtils.W0(str, "clk_tab_first_result", bVar.getSearchKeyword(), "" + this.M, "" + N(2), SearchUtils.g0("dynamic_tab_search.1", bVar.getCurrentPageMasks()));
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                cls = ISearchUtilFetcher.class;
                sb6.append(this.M);
                SearchUtils.W0(str, "clk_tab_result", bVar.getSearchKeyword(), sb6.toString(), "", SearchUtils.g0("dynamic_tab_search.1", bVar.getCurrentPageMasks()));
                context = context3;
                i3 = 3;
                i16 = 4;
            } else if (currentPageType == 3) {
                if (anVar == null || !anVar.isFirstClickResultItem()) {
                    str2 = "all_result";
                    i26 = 4;
                } else {
                    anVar.setFirstClickResultItemFlag(true);
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("");
                    str2 = "all_result";
                    sb7.append(this.M);
                    SearchUtils.W0("sub_result", "clk_sub_first_result", bVar.getSearchKeyword(), sb7.toString(), "" + N(2), SearchUtils.g0("dynamic_tab_search.1", bVar.getCurrentPageMasks()));
                    i26 = 4;
                }
                String[] strArr2 = new String[i26];
                strArr2[0] = bVar.getSearchKeyword();
                strArr2[1] = "" + this.M;
                strArr2[2] = "" + N(2);
                strArr2[3] = SearchUtils.g0("dynamic_tab_search.1", bVar.getCurrentPageMasks());
                SearchUtils.W0("sub_result", "clk_result", strArr2);
                context = context3;
                i3 = 3;
                str = str2;
                i16 = 4;
                cls = ISearchUtilFetcher.class;
            }
            if (J() != 268435456) {
                String[] strArr3 = new String[i3];
                strArr3[0] = "" + this.G;
                strArr3[1] = "" + this.H;
                strArr3[2] = "" + (this.f415203u0 + 1);
                SearchUtils.W0(str, "clk_function", strArr3);
                if ("63".equals(l())) {
                    context2 = context;
                    if (((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivityBySearch(context2, (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime())) {
                        SearchUtils.h1(this.H, this.I, this.J, "");
                        return;
                    }
                } else {
                    context2 = context;
                }
                if ("24".equals(l())) {
                    AppInterface appInterface2 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (((IQQHealthService) appInterface2.getRuntimeService(IQQHealthService.class, ProcessConstant.MULTI)).redirectAIOToMainPage(appInterface2.getApplicationContext(), 166)) {
                        SearchUtils.h1(this.H, this.I, this.J, "");
                        return;
                    }
                }
                if (view.getContext().getClass().getName().equals(((ISearchUtilFetcher) QRoute.api(cls)).getUniteSearchActivityClass().getName())) {
                    HashMap<com.tencent.mobileqq.search.model.v, SearchUtils.d> hashMap2 = SearchUtils.f284965n;
                    if (hashMap2.containsKey(this)) {
                        SearchUtils.d dVar3 = hashMap2.get(this);
                        AppInterface appInterface3 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("project", com.tencent.mobileqq.search.report.b.c());
                            jSONObject2.put("event_src", "client");
                            jSONObject2.put("obj_lct", dVar3.f284978c);
                            jSONObject2.put("get_src", "native");
                        } catch (JSONException e17) {
                            QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "e = " + e17);
                        }
                        com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module(str).action("clk_item").obj1(dVar3.f284977b + "").obj2(dVar3.f284980e).ver1(dVar3.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(((ISearchUtilFetcher) QRoute.api(cls)).getUniteSearchActivityFromForHistoryCode())).ver7(jSONObject2.toString()).session_id(appInterface3.getCurrentAccountUin() + SearchUtils.f284963l));
                    }
                }
            } else {
                context2 = context;
            }
            if (this.M != 1107) {
                if (this.T == 99) {
                    i18 = 246613;
                    i19 = 2;
                } else {
                    i18 = 246614;
                    i19 = 1;
                }
                if (this.E0 == 0) {
                    GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
                    guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", "functional_qq_search");
                    ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildInTab(context2, this.H, "", guildAppReportSourceInfo);
                } else {
                    ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).addGuildByAuthSig(context2, this.H, this.G0, i18);
                }
                SearchUtils.V0("Sgrp", "search_result", "clk", i19, 0, this.H);
                return;
            }
            if (!TextUtils.isEmpty(this.K)) {
                String str4 = this.K;
                if ("3".equals(this.H)) {
                    str4 = VasWebviewUtil.addEntryParamToUrl(this.K, 55);
                }
                if (!str4.startsWith("http") && !str4.startsWith("https")) {
                    if (context2 instanceof QBaseActivity) {
                        ax c17 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), context2, str4);
                        if (c17 != null) {
                            c17.b();
                        } else {
                            context2.startActivity(new Intent(context2, (Class<?>) JumpActivity.class).setData(Uri.parse(str4)));
                        }
                    } else {
                        context2.startActivity(new Intent(context2, (Class<?>) JumpActivity.class).setData(Uri.parse(str4)));
                    }
                } else {
                    Intent intent = new Intent(context2, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", str4);
                    context2.startActivity(intent);
                }
                if (J() == 268435456) {
                    SearchUtils.h1(this.H, this.I, this.J, str4);
                    return;
                }
                return;
            }
            long j3 = this.M;
            if (j3 == VasBusiness.QWALLET) {
                SearchUtils.A0(view.getContext(), Integer.valueOf(this.H).intValue(), this.T);
                SearchUtils.h1(this.H, this.I, this.J, "");
                return;
            }
            if (j3 == 1001) {
                boolean O = O();
                int I = I(view.getContext());
                if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "onAction mobileNumberResult = " + O + ",id = " + this.H);
                }
                AppInterface appInterface4 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                SearchResultItem searchResultItem = new SearchResultItem();
                searchResultItem.f283460d = NumberUtil.stringToLong(M());
                searchResultItem.f283462f = this.I;
                if (((ISearchUtilFetcher) QRoute.api(cls)).isRobotUin(appInterface4, this.H)) {
                    ((ISearchUtilFetcher) QRoute.api(cls)).openRobotProfileCard(view.getContext(), null, this.H);
                    return;
                }
                int i28 = (this.T == 99 || I == 11) ? i16 : I == 10 ? 5 : 3;
                if (O) {
                    searchResultItem.f283460d = 0L;
                    searchResultItem.f283463h = this.H;
                    i17 = 0;
                } else {
                    i17 = i28;
                }
                if (!TextUtils.isEmpty(this.V)) {
                    searchResultItem.F = 1;
                }
                searchResultItem.G = this.U;
                ((ISearchUtilFetcher) QRoute.api(cls)).startProfileCardActivity((Activity) view.getContext(), searchResultItem, appInterface4, true, i17);
                return;
            }
            if (j3 == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                Context context4 = view.getContext();
                int I2 = I(context4);
                int i29 = I2 == 9 ? 112 : 103;
                if (context4 != null && context2.getClass().getName().equals(((ISearchUtilFetcher) QRoute.api(cls)).getActiveEntitySearchActivityClass().getName()) && (longArrayExtra = ((Activity) context4).getIntent().getLongArrayExtra("group_mask_long_array")) != null && longArrayExtra.length == 1 && longArrayExtra[0] == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                    i29 = I2 == 9 ? 113 : 104;
                }
                if (this.T == 99 || I2 == 11) {
                    i29 = this.f415200r0 ? 30004 : BaseConstants.ERR_SVR_FRIENDSHIP_WRITE_CONFLICT;
                }
                if (i29 == 103 || i29 == 104) {
                    i29 = this.f415200r0 ? BaseConstants.ERR_SVR_FRIENDSHIP_PEER_FRIEND_LIMIT : 30016;
                } else if (i29 == 112 || i29 == 113) {
                    i29 = this.f415200r0 ? 30018 : 30020;
                }
                Bundle b16 = aq.b(this.H, i29);
                b16.putInt("exposureSource", 3);
                b16.putString("keyword", getKeyword());
                b16.putBoolean("isFromNative", true);
                b16.putInt("t_s_f", 1000);
                b16.putString("authSig", this.G0);
                b16.putString("trans_info", com.tencent.mobileqq.search.util.ai.a(getKeyword(), this.P0, this.Q0));
                b16.putString(AppConstants.Key.TROOP_INFO_NAME, this.I);
                ((ISearchUtilFetcher) QRoute.api(cls)).openTroopInfoActivity(view.getContext(), b16, 2);
                return;
            }
            return;
        }
        cls = ISearchUtilFetcher.class;
        context = context3;
        i3 = 3;
        i16 = 4;
        str = "all_result";
        if (J() != 268435456) {
        }
        if (this.M != 1107) {
        }
    }

    @Override // com.tencent.mobileqq.search.model.z, com.tencent.mobileqq.search.model.y
    public void w(int i3, int i16) {
        this.f415205w0 = i3;
        this.f415206x0 = i16;
    }

    @Override // com.tencent.mobileqq.search.model.z
    public Map<String, String> y() {
        HashMap hashMap = new HashMap();
        if (J() == 1001) {
            hashMap.put("to_uin", l());
        } else if (J() == 1002) {
            hashMap.put("group_id", l());
            hashMap.put("group_name", this.I);
        }
        return hashMap;
    }

    public c(String str, String str2, String str3, String str4, String str5, String str6, long j3, List<String> list, int i3) {
        this.R = false;
        this.W = false;
        this.Y = R.color.skin_gray2_item;
        this.f415185c0 = -1;
        this.f415189g0 = -1;
        this.f415199q0 = new int[3];
        this.f415201s0 = new StringBuffer();
        this.f415202t0 = BaseApplication.getContext();
        this.f415204v0 = 0;
        this.f415207y0 = false;
        this.f415208z0 = false;
        this.A0 = false;
        this.H0 = "";
        this.J0 = null;
        this.L0 = -1;
        this.M0 = -1;
        this.Q0 = 0;
        this.U0 = 0;
        this.G = str;
        this.H = str2;
        this.I = str3;
        this.J = str4;
        this.K = str5;
        this.L = str6;
        this.M = j3;
        this.S = list;
        this.T = i3;
        this.D0 = false;
        this.E0 = 1;
        this.F0 = 0L;
        P();
        R();
        D(str2);
    }

    public c(String str, String str2, String str3, String str4, String str5, String str6, long j3, List<String> list, int i3, String str7, String str8, int i16, int i17, String str9, String str10, String str11) {
        this.R = false;
        this.W = false;
        this.Y = R.color.skin_gray2_item;
        this.f415185c0 = -1;
        this.f415189g0 = -1;
        this.f415199q0 = new int[3];
        this.f415201s0 = new StringBuffer();
        this.f415202t0 = BaseApplication.getContext();
        this.f415204v0 = 0;
        this.f415207y0 = false;
        this.f415208z0 = false;
        this.A0 = false;
        this.H0 = "";
        this.J0 = null;
        this.L0 = -1;
        this.M0 = -1;
        this.Q0 = 0;
        this.U0 = 0;
        this.G = str;
        this.H = str2;
        this.I = str3;
        this.J = str4;
        this.K = str5;
        this.L = str6;
        this.M = j3;
        this.S = list;
        this.T = i3;
        this.f415191i0 = str7;
        this.f415192j0 = str8;
        this.f415193k0 = i16;
        this.f415194l0 = i17;
        this.f415195m0 = str9;
        this.f415196n0 = str10;
        this.f415197o0 = str11;
        this.D0 = false;
        this.E0 = 1;
        this.F0 = 0L;
        P();
        R();
        D(str2);
    }
}
