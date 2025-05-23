package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.al;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.w;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeURLImageView;
import java.util.ArrayList;
import java.util.List;
import lo2.x;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l extends com.tencent.mobileqq.search.business.net.view.c {
    public LinearLayout M;
    public URLImageView N;
    public TextView P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public ImageView T;
    public View U;
    public LinearLayout V;
    public ArrayList<a> W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public View f285137a;

        /* renamed from: b, reason: collision with root package name */
        public URLImageView f285138b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f285139c;

        /* renamed from: d, reason: collision with root package name */
        public View.OnClickListener f285140d = new ViewOnClickListenerC8551a();

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.search.view.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        class ViewOnClickListenerC8551a implements View.OnClickListener {
            ViewOnClickListenerC8551a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3;
                String a16;
                EventCollector.getInstance().onViewClickedBefore(view);
                Object tag = view.getTag(R.id.jb9);
                Object tag2 = view.getTag(R.id.jb_);
                if (tag != null && (tag instanceof String)) {
                    Context context = view.getContext();
                    String str = (String) tag;
                    Object tag3 = view.getTag(R.id.jan);
                    if (tag3 instanceof Integer) {
                        i3 = ((Integer) tag3).intValue();
                    } else {
                        i3 = 0;
                    }
                    if (TextUtils.isEmpty(str)) {
                        SearchUtils.n1("\u540e\u53f0\u6ca1\u6709\u914d\u7f6e\u94fe\u63a5\uff0c\u7ec8\u7aef\u62fc\u63a5\u8df3\u8f6c");
                        a16 = w.g((String) tag2, 3, w.f(i3));
                    } else {
                        SearchUtils.n1("\u540e\u53f0\u914d\u7f6e\u4e86\u94fe\u63a5\uff0c\u4f7f\u7528\u540e\u53f0\u94fe\u63a5\u8df3\u8f6c");
                        a16 = w.a(str, i3);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("NetSearchTemplateNewEntranceView", 2, "open Browser append suffix url = " + a16);
                    }
                    if (a16 == null) {
                        QLog.e("NetSearchTemplateNewEntranceView", 2, "NetSearchSubView click jumpurl is null");
                    } else {
                        com.tencent.mobileqq.search.report.b.e(null, 0, i3, "0X8009D5F", 0, 0, null, null);
                        x xVar = (x) view.getTag(R.id.kxb);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                            jSONObject.put("event_src", "client");
                            jSONObject.put(QAdVrReportParams.ParamKey.EXPERIMENT_ID, com.tencent.mobileqq.search.report.b.f283718b);
                        } catch (JSONException e16) {
                            QLog.e("NetSearchTemplateNewEntranceView", 2, "e = " + e16);
                        }
                        if (xVar != null) {
                            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                            ReportModelDC02528 action = new ReportModelDC02528().module("all_result").action("clk_relatedsearch_list");
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(xVar.J);
                            String str2 = "";
                            sb5.append("");
                            ReportModelDC02528 ver2 = action.obj1(sb5.toString()).obj2(xVar.G).ver1(xVar.getKeyword()).ver2(com.tencent.mobileqq.search.report.b.a(i3));
                            if (tag2 != null) {
                                str2 = tag2.toString();
                            }
                            com.tencent.mobileqq.search.report.b.h(null, ver2.ver4(str2).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
                        }
                        if (!a16.startsWith("https://") && !a16.startsWith("http://")) {
                            if (context instanceof BaseActivity) {
                                ax c16 = bi.c(((BaseActivity) context).app, context, a16);
                                if (c16 != null) {
                                    c16.b();
                                } else {
                                    context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(a16)));
                                }
                            } else {
                                context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(a16)));
                            }
                        } else {
                            ((IRIJJumpUtils) QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(context, (String) tag2, a16);
                        }
                        if (xVar != null) {
                            al.a(xVar.C, 20, xVar.getKeyword(), (String) tag2);
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a(Context context) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.b1u, (ViewGroup) l.this.V, false);
            this.f285137a = inflate;
            this.f285138b = (URLImageView) inflate.findViewById(R.id.image);
            this.f285139c = (TextView) this.f285137a.findViewById(R.id.bg6);
            this.f285137a.setOnClickListener(this.f285140d);
        }
    }

    public l(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
        this.W = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        View j3 = j(this.E);
        this.M = (LinearLayout) j3.findViewById(R.id.bxy);
        URLImageView uRLImageView = (URLImageView) j3.findViewById(R.id.image);
        this.N = uRLImageView;
        if (uRLImageView instanceof ThemeURLImageView) {
            ((ThemeURLImageView) uRLImageView).setSupportMaskView(false);
        }
        this.P = (TextView) j3.findViewById(R.id.title);
        this.Q = (TextView) j3.findViewById(R.id.f166931j64);
        this.R = (TextView) j3.findViewById(R.id.f166931j64);
        this.S = (TextView) j3.findViewById(R.id.bgt);
        this.T = (ImageView) j3.findViewById(R.id.f166793ia2);
        this.U = j3.findViewById(R.id.f165819dm3);
        this.V = (LinearLayout) j3.findViewById(R.id.f166929j61);
    }

    public void p(x xVar) {
        this.W.clear();
        this.V.removeAllViews();
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            this.Q.setTextColor(Color.parseColor("#004080"));
        } else if (SimpleUIUtil.isNowElderMode()) {
            this.Q.setTextColor(Color.parseColor("#0099FF"));
        }
        List<lo2.al> list = xVar.f415307g0;
        if (list != null && list.size() != 0) {
            this.U.setVisibility(0);
            this.V.setVisibility(0);
            Context context = this.V.getContext();
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            for (int i3 = 0; i3 < xVar.f415307g0.size() && i3 < 6; i3++) {
                lo2.al alVar = xVar.f415307g0.get(i3);
                a aVar = new a(context);
                if (!TextUtils.isEmpty(xVar.f415308h0)) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mFailedDrawable = colorDrawable;
                    obtain.mLoadingDrawable = colorDrawable;
                    obtain.mRequestWidth = com.tencent.mobileqq.util.x.c(context, 16.0f);
                    obtain.mRequestHeight = com.tencent.mobileqq.util.x.c(context, 16.0f);
                    obtain.mMemoryCacheKeySuffix = "subItemLeftIconUrl";
                    URLDrawable drawable = URLDrawable.getDrawable(xVar.f415308h0, obtain);
                    drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                    aVar.f285138b.setImageDrawable(drawable);
                    if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                        drawable.restartDownload();
                    }
                    aVar.f285138b.setVisibility(0);
                } else {
                    aVar.f285138b.setVisibility(8);
                }
                aVar.f285137a.setTag(R.id.kxb, xVar);
                if (!TextUtils.isEmpty(alVar.f415168a)) {
                    aVar.f285139c.setText(alVar.f415168a);
                    aVar.f285139c.setVisibility(0);
                    aVar.f285137a.setTag(R.id.jb_, alVar.f415168a);
                } else {
                    aVar.f285139c.setVisibility(8);
                }
                if (!TextUtils.isEmpty(alVar.f415169b)) {
                    aVar.f285137a.setTag(R.id.jb9, alVar.f415169b);
                    aVar.f285137a.setTag(R.id.jan, Integer.valueOf(xVar.R));
                }
                this.V.addView(aVar.f285137a);
                this.W.add(aVar);
                am.r(aVar.f285137a, alVar.f415168a, "24", "", i3, xVar.e() + i3, String.valueOf(alVar.hashCode()), "normal");
            }
            return;
        }
        this.U.setVisibility(8);
        this.V.setVisibility(8);
    }
}
