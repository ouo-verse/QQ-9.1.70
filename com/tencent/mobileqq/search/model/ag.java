package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.util.VasColorUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.List;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ag extends lo2.u {

    /* renamed from: g0, reason: collision with root package name */
    public String f283494g0;

    /* renamed from: h0, reason: collision with root package name */
    public String f283495h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f283496i0;

    /* renamed from: j0, reason: collision with root package name */
    public String f283497j0;

    /* renamed from: k0, reason: collision with root package name */
    public String f283498k0;

    /* renamed from: l0, reason: collision with root package name */
    public String f283499l0;

    /* renamed from: m0, reason: collision with root package name */
    public String f283500m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f283501n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f283502o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f283503p0;

    /* renamed from: q0, reason: collision with root package name */
    public int f283504q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f283505r0;

    /* renamed from: s0, reason: collision with root package name */
    public String f283506s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f283507t0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends URLDrawableHelper.Adapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.view.j f283508d;

        a(com.tencent.mobileqq.search.view.j jVar) {
            this.f283508d = jVar;
        }

        @Override // com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter, com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            if (uRLDrawable != null) {
                this.f283508d.R.setCompoundDrawables(null, null, ff.U(BaseAIOUtils.f(12.0f, BaseApplication.getContext().getResources()), uRLDrawable), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends URLDrawableHelper.Adapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.view.j f283510d;

        b(com.tencent.mobileqq.search.view.j jVar) {
            this.f283510d = jVar;
        }

        @Override // com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter, com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            this.f283510d.N.setImageDrawable(uRLDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ag(String str, long j3, List<String> list, int i3, JSONObject jSONObject, int i16, UnifySearchCommon$ResultItem unifySearchCommon$ResultItem) {
        super(str, j3, list, i3, jSONObject, i16, unifySearchCommon$ResultItem);
        this.f283507t0 = false;
    }

    @RequiresApi(api = 16)
    private void Y(com.tencent.mobileqq.search.view.j jVar) {
        if (!TextUtils.isEmpty(this.f283506s0)) {
            try {
                int parseColor = Color.parseColor(this.f283506s0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColors(new int[]{VasColorUtil.getColorWithAlpha(0.3f, parseColor), VasColorUtil.getColorWithAlpha(0.5f, parseColor)});
                gradientDrawable.setGradientType(0);
                gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
                jVar.M.setBackgroundDrawable(gradientDrawable);
            } catch (Exception e16) {
                QLog.e(lo2.u.f415277f0, 2, "vas_search_content_color, e = " + e16);
            }
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setStroke(ViewUtils.dip2px(1.0f), Color.parseColor("#05000000"));
        gradientDrawable2.setCornerRadius(ViewUtils.dip2px(6.0f));
        gradientDrawable2.setShape(0);
        jVar.Q.setBackgroundDrawable(gradientDrawable2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.N.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (this.f283505r0 == -1) {
            jVar.N.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            jVar.N.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        if (this.f283504q0 == -1) {
            layoutParams.addRule(15);
        }
        int max = Math.max(ViewUtils.dip2px(this.f283504q0 / 2.0f), 0);
        int max2 = Math.max(ViewUtils.dip2px(this.f283505r0 / 2.0f), 0);
        layoutParams.setMargins(max2, max, max2, max);
    }

    private void Z(com.tencent.mobileqq.search.view.j jVar) {
        jVar.getView().setOnClickListener(this);
    }

    private void b0(com.tencent.mobileqq.search.view.j jVar) {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoadListener(new a(jVar));
        jVar.R.setCompoundDrawables(null, null, ff.U(BaseAIOUtils.f(12.0f, BaseApplication.getContext().getResources()), ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(ag.class.getName(), this.f283496i0, apngOptions)), null);
        if (aq.a()) {
            TextView textView = jVar.R;
            textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_primary));
        }
    }

    private void c0(com.tencent.mobileqq.search.view.j jVar) {
        if (TextUtils.isEmpty(this.f283500m0)) {
            jVar.P.setVisibility(8);
            return;
        }
        jVar.P.setVisibility(0);
        jVar.P.setText(this.f283500m0);
        try {
            jVar.P.setTextColor(Color.parseColor(this.f283499l0));
        } catch (Exception e16) {
            QLog.e(lo2.u.f415277f0, 2, "vas_search_type_shape, e = " + e16);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) jVar.P.getLayoutParams();
        int i3 = this.f283501n0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        layoutParams.addRule(11);
                        layoutParams.addRule(12);
                    }
                } else {
                    layoutParams.addRule(11);
                    layoutParams.addRule(10);
                }
            } else {
                layoutParams.addRule(9);
                layoutParams.addRule(10);
            }
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(12);
        }
        jVar.P.setLayoutParams(layoutParams);
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor(this.f283498k0));
            gradientDrawable.setCornerRadius(BaseAIOUtils.f(3.0f, BaseApplicationImpl.getApplication().getResources()));
            jVar.P.setBackgroundDrawable(gradientDrawable);
        } catch (Exception e17) {
            QLog.e(lo2.u.f415277f0, 2, "vas_search_bg_shape, e = " + e17);
        }
        int i16 = jVar.getView().getLayoutParams().width;
        TextView textView = jVar.R;
        textView.setText(SearchUtils.I(textView, i16, 1, this.f283497j0, this.P.f285039a, false, false));
    }

    private void d0(View view, Uri uri) {
        Context context = view.getContext();
        if (!(context instanceof Activity)) {
            return;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return;
        }
        try {
            if (path.equals("/signatureEdit")) {
                a33.b.f((Activity) context, VasUtil.getAppInterface(), 0, "signature_chouti", -1, Integer.parseInt(uri.getQueryParameter("templateId")), Integer.parseInt(uri.getQueryParameter(MessageForRichState.SIGN_MSG_FONT_ID)), null);
            }
        } catch (Exception e16) {
            QLog.e(lo2.u.f415277f0, 2, "vas_search_schema_error, e = " + e16);
        }
    }

    private void e0() {
        if (this.J == 1106) {
            MobileReportManager.getInstance().reportAction(String.valueOf(this.f283503p0), String.valueOf(this.f283502o0), SearchConstants.PLATFORM, "7", "1", 102, 1, System.currentTimeMillis());
            com.tencent.mobileqq.search.report.b.e(null, 0, this.R, SearchConstants.ITEM_CLICK_SOUP, this.f283503p0, this.f283502o0, null, null);
        }
    }

    private void f0() {
        if (this.f283507t0) {
            return;
        }
        this.f283507t0 = true;
        if (this.J == 1106) {
            MobileReportManager.getInstance().reportAction(String.valueOf(this.f283503p0), String.valueOf(this.f283502o0), SearchConstants.PLATFORM, "7", "1", 101, 1, System.currentTimeMillis());
            com.tencent.mobileqq.search.report.b.e(null, 0, this.R, SearchConstants.ITEM_SEE_SOUP, this.f283503p0, this.f283502o0, null, null);
        }
    }

    @Override // lo2.u
    public void W(com.tencent.mobileqq.search.business.net.view.i iVar) {
        if (!(iVar instanceof com.tencent.mobileqq.search.view.j)) {
            return;
        }
        com.tencent.mobileqq.search.view.j jVar = (com.tencent.mobileqq.search.view.j) iVar;
        Z(jVar);
        a0(jVar);
        b0(jVar);
        c0(jVar);
        f0();
    }

    @Override // lo2.u
    public void X(JSONObject jSONObject) {
        this.f283494g0 = jSONObject.optString("actionURL");
        this.f283495h0 = jSONObject.optString("contentPic");
        this.f283496i0 = jSONObject.optString("icon");
        this.f283497j0 = jSONObject.optString("name");
        this.f283498k0 = jSONObject.optString("typeBackgroupColor");
        this.f283499l0 = jSONObject.optString("typeFontColor");
        this.f283500m0 = jSONObject.optString("typeName");
        this.f283501n0 = jSONObject.optInt("typePosition");
        this.f283503p0 = jSONObject.optInt("itemID");
        this.f283502o0 = jSONObject.optInt("appID");
        this.f283506s0 = jSONObject.optString("contextBackgroundColor");
        this.f283504q0 = jSONObject.optInt("topMargin", -1);
        this.f283505r0 = jSONObject.optInt("leftMargin", 0);
    }

    public void a0(com.tencent.mobileqq.search.view.j jVar) {
        Y(jVar);
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setTagId(new int[]{41});
        apngOptions.setLoadListener(new b(jVar));
        jVar.N.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(ag.class.getName(), this.f283495h0, apngOptions));
    }

    @Override // lo2.u, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        com.tencent.mobileqq.search.util.al.b(this);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        if (this.J == 1106) {
            return this.f283497j0;
        }
        return super.getTitleSpans();
    }

    @Override // lo2.u, lo2.m, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        Uri parse;
        super.v(view);
        if (TextUtils.isEmpty(this.f283494g0) || (parse = Uri.parse(this.f283494g0)) == null) {
            return;
        }
        String scheme = parse.getScheme();
        if (StringUtil.isEmpty(scheme)) {
            return;
        }
        if (!scheme.startsWith("http") && !scheme.startsWith("https")) {
            if (scheme.startsWith("mqzone")) {
                d0(view, parse);
            }
        } else {
            SearchUtils.Q0((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), view.getContext(), this.f283494g0);
        }
        e0();
    }
}
