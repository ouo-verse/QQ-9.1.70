package com.tencent.mobileqq.search.model;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.widget.RoundRelativeLayout;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unite.DynamicSearch$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ae extends lo2.u {

    /* renamed from: p0, reason: collision with root package name */
    public static final String f283480p0 = "ae";

    /* renamed from: q0, reason: collision with root package name */
    private static final Pattern f283481q0 = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");

    /* renamed from: r0, reason: collision with root package name */
    private static final Pattern f283482r0 = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);

    /* renamed from: g0, reason: collision with root package name */
    public String f283483g0;

    /* renamed from: h0, reason: collision with root package name */
    public String f283484h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f283485i0;

    /* renamed from: j0, reason: collision with root package name */
    public String f283486j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f283487k0;

    /* renamed from: l0, reason: collision with root package name */
    public String f283488l0;

    /* renamed from: m0, reason: collision with root package name */
    public String f283489m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f283490n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f283491o0;

    /* JADX INFO: Access modifiers changed from: protected */
    public ae(String str, long j3, List<String> list, int i3, JSONObject jSONObject, int i16, DynamicSearch$ResultItem dynamicSearch$ResultItem, int i17) {
        super(str, j3, list, i3, jSONObject, i16, dynamicSearch$ResultItem);
        this.f283491o0 = 0;
        this.f283490n0 = i17;
        V(false);
        D(this.f283486j0);
    }

    public static String Z(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(",nick:");
        int indexOf2 = str.indexOf("}");
        if (indexOf != -1) {
            i3 = indexOf + 6;
        } else {
            i3 = 0;
        }
        if (indexOf2 == -1 || i3 == 0) {
            return null;
        }
        return str.substring(i3, indexOf2);
    }

    public static String a0(String str, QQAppInterface qQAppInterface) {
        if (!TextUtils.isEmpty(str) && qQAppInterface != null) {
            Matcher matcher = f283481q0.matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                String b06 = b0(group);
                String str2 = "";
                if (!TextUtils.isEmpty(b06)) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(b06), f283480p0);
                    if (friendsSimpleInfoWithUid != null) {
                        str2 = SearchUtils.x(friendsSimpleInfoWithUid);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = Z(group);
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    str = str.replace(group, "@" + str2 + " ");
                }
            }
            return str;
        }
        return null;
    }

    public static String b0(String str) {
        int i3;
        if ("".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf("uin:");
        int indexOf2 = str.indexOf(",");
        if (indexOf != -1) {
            i3 = indexOf + 4;
        } else {
            i3 = 0;
        }
        if (i3 == 0 || indexOf2 == -1) {
            return null;
        }
        return str.substring(i3, indexOf2);
    }

    public static String c0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = f283482r0.matcher(str);
        while (matcher.find()) {
            str = str.replace(matcher.group(), "");
        }
        return str;
    }

    @Override // lo2.u
    public void W(com.tencent.mobileqq.search.business.net.view.i iVar) {
        if (!(iVar instanceof com.tencent.mobileqq.search.business.net.view.j)) {
            return;
        }
        int i3 = iVar.getView().getLayoutParams().width;
        if (this.U != null) {
            SearchTemplatePresenter.E(this, iVar, true, i3);
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(runtime, false, null);
        if (isNowThemeIsNight) {
            iVar.b().setTextColor(Color.parseColor("#737373"));
            iVar.k().setTextColor(Color.parseColor("#4A4A4A"));
        } else {
            iVar.b().setTextColor(Color.parseColor("#262626"));
            iVar.k().setTextColor(Color.parseColor("#737373"));
        }
        if (TextUtils.isEmpty(this.f283483g0)) {
            iVar.b().setVisibility(8);
        } else {
            iVar.b().setVisibility(0);
            if (this.f283487k0) {
                iVar.b().setText(SearchUtils.I(iVar.b(), i3, 2, this.f283483g0, this.P.f285039a, false, false));
            } else {
                iVar.b().setText(this.f283483g0);
            }
            if (this.f283491o0 == 6) {
                iVar.b().setMaxLines(1);
                iVar.b().setMinLines(1);
            }
        }
        if (TextUtils.isEmpty(this.f283484h0)) {
            iVar.k().setVisibility(8);
        } else {
            iVar.k().setVisibility(0);
            iVar.k().setText(this.f283484h0);
        }
        if (this.f283485i0) {
            iVar.b().setGravity(1);
            iVar.k().setGravity(1);
        } else {
            iVar.b().setGravity(3);
            iVar.k().setGravity(3);
        }
        if (TextUtils.isEmpty(this.f283486j0)) {
            iVar.getView().setOnClickListener(null);
        } else {
            iVar.getView().setOnClickListener(this);
        }
        if (runtime instanceof QQAppInterface) {
            URLImageView uRLImageView = (URLImageView) iVar.getView().findViewById(R.id.a2o);
            if (this.f283491o0 == 6) {
                uRLImageView.setVisibility(8);
            } else {
                uRLImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable((QQAppInterface) runtime, this.f283488l0, (byte) 2));
            }
        }
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) iVar.getView().findViewById(R.id.f81084d8);
        roundRelativeLayout.setRoundLayoutRadius(com.tencent.mobileqq.util.x.c(iVar.getView().getContext(), 12.0f));
        if (isNowThemeIsNight) {
            roundRelativeLayout.setBackgroundResource(R.drawable.k_e);
        } else {
            roundRelativeLayout.setBackgroundResource(R.drawable.k_d);
        }
        if (aq.a()) {
            iVar.n(iVar.b(), R.color.qui_common_text_primary);
            iVar.n(iVar.k(), R.color.qui_common_text_secondary);
            iVar.getView().setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext5", this.f283490n0 + "");
        hashMap.put("ext6", getKeyword());
        if (this.f283491o0 == 6) {
            hashMap.put("ext7", this.f283483g0);
            hashMap.put("ext8", "1");
        } else {
            hashMap.put("ext7", this.f283489m0);
            hashMap.put("ext8", "2");
        }
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(73).setSubActionType(1).setThrActionType(1).setExtras(hashMap));
    }

    @Override // lo2.u
    public void X(JSONObject jSONObject) {
        boolean z16;
        int indexOf;
        int indexOf2;
        String optString = jSONObject.optString("title");
        this.f283483g0 = optString;
        boolean z17 = true;
        try {
            String a06 = a0(optString, (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
            this.f283483g0 = a06;
            this.f283483g0 = c0(a06);
        } catch (Exception e16) {
            QLog.e(f283480p0, 1, e16 + "");
        }
        this.f283484h0 = jSONObject.optString("desc");
        if (jSONObject.optInt("needCenter") == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f283485i0 = z16;
        this.f283486j0 = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
        if (jSONObject.optInt("highlightTitle", 1) != 1) {
            z17 = false;
        }
        this.f283487k0 = z17;
        this.f415281e0 = jSONObject.optString("result_id");
        this.f415280d0 = jSONObject.optString("extra_report_info");
        this.f283488l0 = jSONObject.optString("uin");
        if (!TextUtils.isEmpty(this.f283486j0) && this.f283486j0.contains("feedid") && (indexOf2 = this.f283486j0.indexOf(ContainerUtils.FIELD_DELIMITER, (indexOf = this.f283486j0.indexOf("feedid")))) > indexOf + 6) {
            this.f283489m0 = this.f283486j0.substring(indexOf + 7, indexOf2);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("imageInfo");
        if (optJSONObject != null) {
            R(optJSONObject);
        } else {
            this.U = null;
        }
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public String getTitleSpans() {
        return this.f283483g0;
    }

    public void d0(int i3) {
        this.f283491o0 = i3;
    }

    @Override // lo2.u, lo2.m, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        super.v(view);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext5", this.f283490n0 + "");
        hashMap.put("ext6", getKeyword());
        if (this.f283491o0 == 6) {
            hashMap.put("ext7", this.f283483g0);
            hashMap.put("ext8", "1");
        } else {
            hashMap.put("ext7", this.f283489m0);
            hashMap.put("ext8", "2");
        }
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(73).setSubActionType(1).setThrActionType(2).setExtras(hashMap));
        SearchUtils.Q0((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), view.getContext(), this.f283486j0);
        com.tencent.mobileqq.search.report.b.e(null, 0, this.R, "0X800BA23", 0, 0, null, null);
        com.tencent.mobileqq.search.util.al.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ae(String str, long j3, List<String> list, int i3, JSONObject jSONObject, int i16, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem, int i17) {
        super(str, j3, list, i3, jSONObject, i16, unifySearchCommon$ResultItem);
        this.f283491o0 = 0;
        this.f283490n0 = i17;
        V(false);
        D(this.f283486j0);
    }
}
