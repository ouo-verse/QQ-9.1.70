package com.tencent.mobileqq.search.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.ISearchBindView;
import com.tencent.mobileqq.search.api.ISearchGuildDaTongApi;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateSearchSuggestView;
import com.tencent.mobileqq.search.business.net.view.p;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.search.model.ad;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.al;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.w;
import com.tencent.mobileqq.search.view.o;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lo2.NetSearchTemplateUsedMiniAppItem;
import lo2.ae;
import lo2.af;
import lo2.ag;
import lo2.ai;
import lo2.aj;
import lo2.m;
import lo2.q;
import lo2.r;
import lo2.s;
import lo2.t;
import lo2.u;
import lo2.x;
import lo2.y;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* loaded from: classes18.dex */
public class SearchTemplatePresenter implements qn2.c<lo2.m, com.tencent.mobileqq.search.business.net.view.c>, com.tencent.mobileqq.music.g, qn2.b {
    public static int C;

    /* renamed from: d, reason: collision with root package name */
    public ColorDrawable f283588d = new ColorDrawable(Color.parseColor("#e7e7e7"));

    /* renamed from: e, reason: collision with root package name */
    public Drawable f283589e = com.tencent.mobileqq.urldrawable.b.f306350a;

    /* renamed from: f, reason: collision with root package name */
    private IFaceDecoder f283590f;

    /* renamed from: h, reason: collision with root package name */
    private long f283591h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<ImageView> f283592i;

    /* renamed from: m, reason: collision with root package name */
    private jn2.c f283593m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ lo2.m f283600d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.business.net.view.c f283601e;

        a(lo2.m mVar, com.tencent.mobileqq.search.business.net.view.c cVar) {
            this.f283600d = mVar;
            this.f283601e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 1, "model.groupMask:", Long.valueOf(this.f283600d.J), "   presenter.class:", getClass().getName(), "   model.class:", this.f283600d.getClass().getName(), "   view.class:", this.f283601e.getClass().getName());
            this.f283600d.v(view);
            al.b(this.f283600d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ up2.a f283603d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.business.net.view.l f283604e;

        b(up2.a aVar, com.tencent.mobileqq.search.business.net.view.l lVar) {
            this.f283603d = aVar;
            this.f283604e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 1, "presenter.class:" + getClass().getName() + "   model.class:" + this.f283603d.getClass().getName() + "  view.class:" + this.f283604e.getClass().getName());
            this.f283603d.v(view);
            SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo = new SimpleMiniAppConfig.SimpleMiniAppInfo();
            simpleMiniAppInfo.appId = this.f283603d.X.appId;
            SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(simpleMiniAppInfo);
            if (this.f283603d.X.showMask == 1) {
                str = "used";
            } else {
                str = "unused";
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async(simpleMiniAppConfig, "search", "result_click", str, this.f283603d.getKeyword());
            al.b(this.f283603d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ x f283606d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.view.l f283607e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f283608f;

        c(x xVar, com.tencent.mobileqq.search.view.l lVar, Context context) {
            this.f283606d = xVar;
            this.f283607e = lVar;
            this.f283608f = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 1, "presenter.class:" + getClass().getName() + "   model.class:" + this.f283606d.getClass().getName() + "  view.class:" + this.f283607e.getClass().getName());
            com.tencent.mobileqq.search.report.b.e(null, 0, this.f283606d.R, "0X8009D5D", 0, 0, null, null);
            ReportModelDC02528 ver6 = new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.f283606d.N).ver2(com.tencent.mobileqq.search.report.b.a(UniteSearchActivity.f282684b0)).ver5("1").ver6("1");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("{experiment_id:");
            sb5.append(com.tencent.mobileqq.search.report.b.f283718b);
            sb5.append("}");
            com.tencent.mobileqq.search.report.b.h(null, ver6.ver7(sb5.toString()));
            if (TextUtils.isEmpty(this.f283606d.f415306f0)) {
                SearchUtils.n1("\u540e\u53f0\u6ca1\u6709\u914d\u7f6e\u94fe\u63a5\uff0c\u7ec8\u7aef\u62fc\u63a5\u8df3\u8f6c");
                String g16 = w.g(this.f283606d.getKeyword(), 0, w.q(this.f283606d.R));
                Intent intent = new Intent(this.f283608f, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", g16);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "open Browser append suffix url = " + g16);
                }
                this.f283608f.startActivity(intent);
            } else {
                SearchUtils.n1("\u540e\u53f0\u914d\u7f6e\u4e86\u94fe\u63a5\uff0c\u4f7f\u7528\u540e\u53f0\u94fe\u63a5\u8df3\u8f6c");
                x xVar = this.f283606d;
                ((IRIJJumpUtils) QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(this.f283608f, this.f283606d.getKeyword(), w.b(w.h(xVar.f415306f0, xVar.getKeyword(), 0, com.tencent.mobileqq.search.report.b.a(this.f283606d.R)), this.f283606d.R));
                al.b(this.f283606d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ lo2.w f283610d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.view.k f283611e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f283612f;

        d(lo2.w wVar, com.tencent.mobileqq.search.view.k kVar, Context context) {
            this.f283610d = wVar;
            this.f283611e = kVar;
            this.f283612f = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 1, "presenter.class:" + getClass().getName() + "   model.class:" + this.f283610d.getClass().getName() + "  view.class:" + this.f283611e.getClass().getName());
            if (!TextUtils.isEmpty(this.f283610d.f415299f0)) {
                SearchUtils.n1("\u540e\u53f0\u914d\u7f6e\u4e86\u94fe\u63a5\uff0c\u4f7f\u7528\u540e\u53f0\u94fe\u63a5\u8df3\u8f6c");
                String g16 = w.g(this.f283610d.getKeyword(), 0, com.tencent.mobileqq.search.report.b.a(this.f283610d.R));
                Intent intent = new Intent(this.f283612f, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", g16);
                this.f283612f.startActivity(intent);
                com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.f283610d.N).ver2(com.tencent.mobileqq.search.report.b.a(UniteSearchActivity.f282684b0)).ver5("1").ver6("1").ver7("{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}"));
            } else {
                SearchUtils.n1("\u540e\u53f0\u6ca1\u6709\u914d\u7f6e\u94fe\u63a5\uff0c\u7ec8\u7aef\u62fc\u63a5\u8df3\u8f6c");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ lo2.w f283614d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.view.k f283615e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f283616f;

        e(lo2.w wVar, com.tencent.mobileqq.search.view.k kVar, Context context) {
            this.f283614d = wVar;
            this.f283615e = kVar;
            this.f283616f = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 1, "presenter.class:" + getClass().getName() + "   model.class:" + this.f283614d.getClass().getName() + "  view.class:" + this.f283615e.getClass().getName());
            if (!TextUtils.isEmpty(this.f283614d.f415299f0)) {
                SearchUtils.n1("\u540e\u53f0\u914d\u7f6e\u4e86\u94fe\u63a5\uff0c\u4f7f\u7528\u540e\u53f0\u94fe\u63a5\u8df3\u8f6c");
                String g16 = w.g(this.f283614d.getKeyword(), 0, com.tencent.mobileqq.search.report.b.a(this.f283614d.R));
                Intent intent = new Intent(this.f283616f, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", g16);
                this.f283616f.startActivity(intent);
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = 0; i3 < this.f283614d.f415300g0.size(); i3++) {
                    if (i3 != this.f283614d.f415300g0.size() - 1) {
                        sb5.append(this.f283614d.f415300g0.get(i3).f415215b);
                        sb5.append("::");
                    } else {
                        sb5.append(this.f283614d.f415300g0.get(i3).f415215b);
                    }
                }
                com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_web_search").obj1("2073745984").ver1(this.f283614d.N).ver2(com.tencent.mobileqq.search.report.b.a(UniteSearchActivity.f282684b0)).ver4(sb5.toString()).ver5("1").ver6("2").ver7("{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}"));
            } else {
                SearchUtils.n1("\u540e\u53f0\u6ca1\u6709\u914d\u7f6e\u94fe\u63a5\uff0c\u7ec8\u7aef\u62fc\u63a5\u8df3\u8f6c");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ae f283618d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ o f283619e;

        f(ae aeVar, o oVar) {
            this.f283618d = aeVar;
            this.f283619e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 1, "presenter.class:" + getClass().getName() + "   model.class:" + this.f283618d.getClass().getName() + "  view.class:" + this.f283619e.getClass().getName());
            this.f283618d.v(this.f283619e.getView());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class g implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ai f283621d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.business.net.view.o f283622e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f283623f;

        g(ai aiVar, com.tencent.mobileqq.search.business.net.view.o oVar, Context context) {
            this.f283621d = aiVar;
            this.f283622e = oVar;
            this.f283623f = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 1, "presenter.class:" + getClass().getName() + "   model.class:" + this.f283621d.getClass().getName() + "  view.class:" + this.f283622e.getClass().getName());
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            SearchUtils.Q0(qQAppInterface, this.f283623f, this.f283621d.f415125b0.f415132c);
            HashMap<v, SearchUtils.d> hashMap = SearchUtils.f284965n;
            if (hashMap.containsKey(this.f283621d)) {
                SearchUtils.d dVar = hashMap.get(this.f283621d);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                    jSONObject.put("event_src", "client");
                    jSONObject.put("obj_lct", dVar.f284978c);
                    jSONObject.put("get_src", "web");
                } catch (JSONException e16) {
                    QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + e16);
                }
                com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(dVar.f284977b + "").obj2(dVar.f284980e).ver1(dVar.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(this.f283621d.R)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class h implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ai f283625d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.business.net.view.o f283626e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f283627f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f283628h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f283629i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ SongInfo f283630m;

        h(ai aiVar, com.tencent.mobileqq.search.business.net.view.o oVar, int i3, Context context, boolean z16, SongInfo songInfo) {
            this.f283625d = aiVar;
            this.f283626e = oVar;
            this.f283627f = i3;
            this.f283628h = context;
            this.f283629i = z16;
            this.f283630m = songInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            EventCollector.getInstance().onViewClickedBefore(view);
            boolean z16 = true;
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 1, "presenter.class:" + getClass().getName() + "   model.class:" + this.f283625d.getClass().getName() + "  view.class:" + this.f283626e.getClass().getName());
            ImageView imageView = this.f283626e.P;
            imageView.setTag(Integer.valueOf(this.f283627f));
            SearchTemplatePresenter.this.f283592i = new WeakReference(imageView);
            if (QQPlayerService.m0() == 2 && SearchTemplatePresenter.this.f283591h == SearchUtils.f284954c) {
                QQPlayerService.m1(this.f283628h);
                SearchUtils.f284954c = -1L;
                imageView.clearAnimation();
                if (this.f283629i) {
                    imageView.setImageResource(R.drawable.bxh);
                } else {
                    imageView.setImageResource(R.drawable.bxg);
                }
                z16 = false;
            } else {
                if (!SearchTemplatePresenter.this.P()) {
                    Intent intent = new Intent(this.f283628h, (Class<?>) MusicPlayerActivity.class);
                    intent.putExtra("url", this.f283630m.f251870h);
                    intent.putExtra("param_force_internal_browser", true);
                    QQPlayerService.b1(intent);
                    if (QQPlayerService.f0() == null) {
                        QQPlayerService.a1(new Bundle());
                    }
                    QQPlayerService.Z0(SearchTemplatePresenter.this);
                    QQPlayerService.c1(101);
                    QQPlayerService.i1(this.f283628h, QQPlayerService.o0(), new SongInfo[]{this.f283630m});
                }
                EventCollector.getInstance().onViewClicked(view);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            HashMap<v, SearchUtils.d> hashMap = SearchUtils.f284965n;
            if (hashMap.containsKey(this.f283625d)) {
                SearchUtils.d dVar = hashMap.get(this.f283625d);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                    jSONObject.put("event_src", "client");
                    jSONObject.put("obj_lct", dVar.f284978c);
                    jSONObject.put("get_src", "web");
                } catch (JSONException e16) {
                    QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + e16);
                }
                ReportModelDC02528 reportModelDC02528 = new ReportModelDC02528();
                if (this.f283628h instanceof UniteSearchActivity) {
                    str = "all_result";
                } else {
                    str = "subweb_search";
                }
                ReportModelDC02528 module = reportModelDC02528.module(str);
                if (z16) {
                    str2 = "play_music";
                } else {
                    str2 = "pause_music";
                }
                com.tencent.mobileqq.search.report.b.h(null, module.action(str2).obj1(this.f283625d.J + "").obj2(this.f283625d.G).ver1(UniteSearchActivity.f282690h0).ver2(com.tencent.mobileqq.search.report.b.a(UniteSearchActivity.f282684b0)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ai f283631d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.search.business.net.view.o f283632e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f283633f;

        i(ai aiVar, com.tencent.mobileqq.search.business.net.view.o oVar, Context context) {
            this.f283631d = aiVar;
            this.f283632e = oVar;
            this.f283633f = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 1, "presenter.class:" + getClass().getName() + "   model.class:" + this.f283631d.getClass().getName() + "  view.class:" + this.f283632e.getClass().getName());
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            SearchUtils.Q0(qQAppInterface, this.f283633f, this.f283631d.f415125b0.f415132c);
            HashMap<v, SearchUtils.d> hashMap = SearchUtils.f284965n;
            if (hashMap.containsKey(this.f283631d)) {
                SearchUtils.d dVar = hashMap.get(this.f283631d);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                    jSONObject.put("event_src", "client");
                    jSONObject.put("obj_lct", dVar.f284978c);
                    jSONObject.put("get_src", "web");
                } catch (JSONException e16) {
                    QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + e16);
                }
                com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(dVar.f284977b + "").obj2(dVar.f284980e).ver1(dVar.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(this.f283631d.R)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SearchTemplatePresenter(IFaceDecoder iFaceDecoder, jn2.c cVar) {
        this.f283590f = iFaceDecoder;
        this.f283593m = cVar;
    }

    private void C(ae aeVar, o oVar) {
        if (aeVar != null && oVar != null) {
            LinearLayout linearLayout = oVar.Q;
            linearLayout.setPadding(linearLayout.getPaddingLeft(), 0, oVar.Q.getPaddingRight(), 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) oVar.M.getLayoutParams();
            boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
            if (aeVar.f415113e0) {
                layoutParams.addRule(5, 0);
                layoutParams.addRule(14);
            } else {
                layoutParams.addRule(14, 0);
                layoutParams.addRule(5);
            }
            Context context = oVar.M.getContext();
            int c16 = context.getResources().getDisplayMetrics().widthPixels - com.tencent.mobileqq.util.x.c(context, 38.0f);
            if (!TextUtils.isEmpty(aeVar.f415111c0)) {
                oVar.N.setVisibility(0);
                if (isNowThemeIsNight) {
                    oVar.N.setText(aeVar.f415111c0.toString());
                } else {
                    oVar.N.setText(aeVar.f415111c0);
                }
                c16 = (int) (c16 - (SearchUtils.t0(oVar.N, aeVar.f415111c0) + com.tencent.mobileqq.util.x.c(context, 10.0f)));
            } else {
                oVar.N.setVisibility(8);
            }
            if (!TextUtils.isEmpty(aeVar.f415110b0)) {
                oVar.M.setVisibility(0);
                CharSequence charSequence = aeVar.f415110b0;
                if (!aeVar.f415113e0) {
                    charSequence = SearchUtils.X(oVar.M, c16, charSequence);
                }
                if (isNowThemeIsNight) {
                    oVar.M.setText(charSequence.toString());
                } else {
                    oVar.M.setText(charSequence);
                }
            } else {
                oVar.M.setVisibility(8);
            }
            oVar.P.setBackgroundDrawable(O(aeVar.f415112d0));
            oVar.P.setOnClickListener(new f(aeVar, oVar));
        }
    }

    private void D(af afVar, com.tencent.mobileqq.search.view.n nVar) {
        TextView textView;
        LinearLayout linearLayout;
        if (afVar != null && nVar != null && !TextUtils.isEmpty(afVar.f415114b0) && (textView = nVar.M) != null) {
            Context context = textView.getContext();
            int c16 = context.getResources().getDisplayMetrics().widthPixels - com.tencent.mobileqq.util.x.c(context, 40.0f);
            if (!TextUtils.isEmpty(afVar.K) && (linearLayout = nVar.N) != null) {
                linearLayout.setVisibility(0);
                c16 -= com.tencent.mobileqq.util.x.c(context, 26.0f);
            } else {
                LinearLayout linearLayout2 = nVar.N;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
            }
            nVar.M.setText(SearchUtils.X(nVar.M, c16, afVar.f415114b0));
        }
    }

    public static Pair<Integer, Integer> E(lo2.m mVar, com.tencent.mobileqq.search.business.net.view.c cVar, boolean z16, int i3) {
        SquareImageView squareImageView;
        String str;
        if (cVar != null && cVar.F != null && (squareImageView = cVar.G) != null && mVar != null) {
            m.a aVar = mVar.U;
            if (aVar != null && !TextUtils.isEmpty(aVar.f415230b)) {
                cVar.F.setVisibility(0);
                Context context = squareImageView.getContext();
                Pair<Integer, Integer> t16 = t(squareImageView, aVar.f415229a, aVar.f415230b, aVar.f415231c, z16, i3, mVar);
                int intValue = ((Integer) t16.first).intValue();
                int intValue2 = ((Integer) t16.second).intValue();
                ViewGroup.LayoutParams layoutParams = squareImageView.getLayoutParams();
                layoutParams.width = intValue;
                layoutParams.height = intValue2;
                squareImageView.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) cVar.F.getLayoutParams();
                layoutParams2.width = intValue;
                layoutParams2.height = intValue2;
                cVar.F.setLayoutParams(layoutParams2);
                int c16 = intValue + com.tencent.mobileqq.util.x.c(context, 10.0f);
                if (!TextUtils.isEmpty(aVar.f415233e) && cVar.I != null) {
                    if (SearchUtils.C0(aVar.f415234f)) {
                        str = aVar.f415234f;
                    } else {
                        str = "#fd7f32";
                    }
                    ((GradientDrawable) cVar.I.getBackground()).setColor(Color.parseColor(str));
                    cVar.I.setVisibility(0);
                    cVar.I.setText(aVar.f415233e);
                } else {
                    TextView textView = cVar.I;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                }
                ImageView imageView = cVar.H;
                if (imageView != null) {
                    if (aVar.f415232d) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(8);
                    }
                }
                if (cVar.J != null) {
                    if (!TextUtils.isEmpty(aVar.f415235g)) {
                        cVar.J.setVisibility(0);
                        cVar.J.setText(aVar.f415235g);
                    } else {
                        cVar.J.setVisibility(8);
                    }
                }
                if (cVar.K != null) {
                    if (!TextUtils.isEmpty(aVar.f415236h)) {
                        cVar.K.setVisibility(0);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        ColorDrawable colorDrawable = new ColorDrawable(-1);
                        obtain.mFailedDrawable = colorDrawable;
                        obtain.mLoadingDrawable = colorDrawable;
                        obtain.mRequestWidth = cVar.K.getLayoutParams().width;
                        obtain.mRequestHeight = cVar.K.getLayoutParams().height;
                        URLDrawable drawable = URLDrawable.getDrawable(aVar.f415236h, obtain);
                        if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                            drawable.restartDownload();
                        }
                        cVar.K.setImageDrawable(drawable);
                    } else {
                        cVar.K.setVisibility(8);
                    }
                }
                if (cVar.L != null) {
                    if (!TextUtils.isEmpty(aVar.f415237i)) {
                        cVar.L.setVisibility(0);
                        cVar.L.setText(aVar.f415237i);
                    } else {
                        cVar.L.setVisibility(8);
                    }
                }
                return new Pair<>(Integer.valueOf(c16), Integer.valueOf(intValue2));
            }
            cVar.F.setVisibility(8);
            return new Pair<>(0, 0);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
        }
        return new Pair<>(0, 0);
    }

    private void I(ai aiVar, com.tencent.mobileqq.search.business.net.view.o oVar) {
        Button button;
        if (aiVar != null && aiVar.f415125b0 != null && oVar != null) {
            Button button2 = oVar.W;
            if (button2 == null) {
                return;
            }
            Context context = button2.getContext();
            ai.a aVar = aiVar.f415125b0;
            if (aVar.f415130a == 1 && !TextUtils.isEmpty(aVar.f415131b)) {
                oVar.W.setVisibility(0);
                oVar.W.setText(aiVar.f415125b0.f415131b);
                oVar.W.setOnClickListener(new i(aiVar, oVar, context));
                return;
            }
            oVar.W.setVisibility(8);
            return;
        }
        if (oVar != null && (button = oVar.W) != null) {
            button.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int J(ai aiVar, com.tencent.mobileqq.search.business.net.view.o oVar, int i3, int i16) {
        LinearLayout linearLayout;
        int i17;
        int i18;
        TextView textView;
        int i19;
        ArrayList<ai.c> arrayList;
        int c16;
        int i26;
        String str;
        int t06;
        CharSequence X;
        if (oVar == null || aiVar == null || (linearLayout = oVar.Q) == null) {
            return 0;
        }
        Context context = linearLayout.getContext();
        int c17 = ((context.getResources().getDisplayMetrics().widthPixels - i3) - i16) - com.tencent.mobileqq.util.x.c(context, 30.0f);
        ArrayList<ai.c> arrayList2 = aiVar.f415127d0;
        if (arrayList2 != null && arrayList2.size() > 0) {
            oVar.Q.setVisibility(0);
            int i27 = 1;
            if (aiVar.f415126c0 != null && (arrayList = aiVar.f415127d0) != null && arrayList.size() > 0) {
                oVar.R.setVisibility(0);
                SquareImageView squareImageView = oVar.U;
                if (squareImageView != null) {
                    squareImageView.setVisibility(8);
                }
                int i28 = aiVar.f415126c0.f415134a;
                if (i28 == 1) {
                    TextView textView2 = oVar.T;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    if (oVar.U != null && !TextUtils.isEmpty(aiVar.f415126c0.f415135b)) {
                        oVar.U.setVisibility(0);
                        y(oVar.U, aiVar.f415126c0.f415135b);
                        c16 = com.tencent.mobileqq.util.x.c(context, 24.0f);
                        t06 = c17 - c16;
                    }
                    t06 = c17;
                } else {
                    if (i28 == 2) {
                        SquareImageView squareImageView2 = oVar.U;
                        if (squareImageView2 != null) {
                            squareImageView2.setVisibility(8);
                        }
                        if (oVar.T != null && !TextUtils.isEmpty(aiVar.f415126c0.f415138e)) {
                            if (SearchUtils.C0(aiVar.f415126c0.f415139f)) {
                                str = aiVar.f415126c0.f415139f;
                            } else {
                                str = "#fd7f32";
                            }
                            ((GradientDrawable) oVar.T.getBackground()).setColor(Color.parseColor(str));
                            oVar.T.setVisibility(0);
                            oVar.T.setText(aiVar.f415126c0.f415138e);
                            t06 = (int) (c17 - (SearchUtils.t0(oVar.T, aiVar.f415126c0.f415138e) + com.tencent.mobileqq.util.x.c(context, 10.0f)));
                        }
                    } else if (i28 == 3) {
                        TextView textView3 = oVar.T;
                        if (textView3 != null) {
                            textView3.setVisibility(8);
                        }
                        if (oVar.U != null && !TextUtils.isEmpty(aiVar.f415126c0.f415135b)) {
                            oVar.U.setVisibility(0);
                            ai.b bVar = aiVar.f415126c0;
                            int i29 = bVar.f415136c;
                            if (i29 > 0 && (i26 = bVar.f415137d) > 0) {
                                n(oVar.U, i29, i26, bVar.f415135b);
                                c16 = com.tencent.mobileqq.util.x.c(context, com.tencent.mobileqq.util.x.c(context, aiVar.f415126c0.f415136c) + 4);
                            } else {
                                y(oVar.U, bVar.f415135b);
                                c16 = com.tencent.mobileqq.util.x.c(context, 24.0f);
                            }
                            t06 = c17 - c16;
                        }
                    }
                    t06 = c17;
                }
                if (oVar.S != null && !TextUtils.isEmpty(aiVar.f415127d0.get(0).f415141a)) {
                    CharSequence charSequence = aiVar.f415127d0.get(0).f415141a;
                    if (aiVar.f415127d0.get(0).f415144d) {
                        X = SearchUtils.J(oVar.S, t06, 1, charSequence.toString(), aiVar.P.f285039a, false, false, true);
                    } else {
                        X = SearchUtils.X(oVar.S, t06, charSequence.toString());
                    }
                    oVar.S.setTextColor(context.getResources().getColor(R.color.qui_common_text_primary));
                    oVar.S.setText(X);
                }
                i17 = 1;
            } else {
                LinearLayout linearLayout2 = oVar.R;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                i17 = 0;
            }
            LinearLayout linearLayout3 = oVar.V;
            if (linearLayout3 == null) {
                return oVar.Q.getHeight();
            }
            linearLayout3.removeAllViews();
            ArrayList<ai.c> arrayList3 = aiVar.f415127d0;
            if (arrayList3 != null && arrayList3.size() > 0) {
                while (i17 < aiVar.f415127d0.size()) {
                    ai.c cVar = aiVar.f415127d0.get(i17);
                    TextView textView4 = new TextView(context);
                    R(textView4, cVar.f415142b, cVar.f415143c);
                    CharSequence charSequence2 = cVar.f415141a;
                    if (!TextUtils.isEmpty(charSequence2)) {
                        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
                            charSequence2 = charSequence2.toString();
                        }
                        int i36 = cVar.f415143c;
                        if (context instanceof PublicAcntSearchActivity) {
                            i18 = i27;
                        } else {
                            i18 = i36;
                        }
                        if (cVar.f415144d) {
                            if (!cVar.f415142b.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) && !cVar.f415142b.equals("B")) {
                                i19 = 0;
                            } else {
                                i19 = i27;
                            }
                            textView = textView4;
                            charSequence2 = SearchUtils.J(textView4, c17, i18, charSequence2.toString(), aiVar.P.f285039a, false, i19, true);
                        } else {
                            textView = textView4;
                        }
                        if (i17 != 0) {
                            textView.setPadding(0, com.tencent.mobileqq.util.x.c(context, 7.0f - N(aiVar.f415127d0.get(i17 - 1).f415142b, cVar.f415142b)), 0, 0);
                        }
                        textView.setText(charSequence2);
                        textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_secondary));
                        oVar.V.addView(textView);
                    }
                    i17++;
                    i27 = 1;
                }
            }
        } else {
            oVar.Q.setVisibility(8);
        }
        I(aiVar, oVar);
        oVar.Q.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return oVar.Q.getMeasuredHeight();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0138, code lost:
    
        if (r2.optInt("playable") == 1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int K(ai aiVar, com.tencent.mobileqq.search.business.net.view.o oVar) {
        ImageView imageView;
        Button button;
        ai.a aVar;
        boolean z16;
        if (aiVar != null && (aVar = aiVar.f415125b0) != null && oVar != null && oVar.M != null) {
            boolean z17 = true;
            if (aVar.f415130a == 1) {
                Button button2 = oVar.N;
                if (button2 != null) {
                    button2.setVisibility(8);
                }
                ImageView imageView2 = oVar.P;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                return 0;
            }
            boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
            Context context = oVar.M.getContext();
            int i3 = aiVar.f415125b0.f415130a;
            if (i3 == 2) {
                ImageView imageView3 = oVar.P;
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                if (oVar.N == null) {
                    return 0;
                }
                if (!TextUtils.isEmpty(aiVar.f415125b0.f415131b)) {
                    oVar.N.setVisibility(0);
                    oVar.N.setText(aiVar.f415125b0.f415131b);
                    oVar.N.setOnClickListener(new g(aiVar, oVar, context));
                } else {
                    oVar.N.setVisibility(8);
                }
                int t06 = (int) (0 + SearchUtils.t0(oVar.N, aiVar.f415125b0.f415131b) + com.tencent.mobileqq.util.x.c(context, 32.0f) + com.tencent.mobileqq.util.x.c(context, 15.0f));
                if (isNowThemeIsNight) {
                    oVar.N.setBackgroundResource(R.drawable.a3c);
                    oVar.N.setTextColor(Color.parseColor("#6991B8"));
                    return t06;
                }
                oVar.N.setBackgroundResource(R.drawable.a3b);
                oVar.N.setTextColor(Color.parseColor("#000000"));
                return t06;
            }
            if (i3 == 3) {
                Button button3 = oVar.N;
                if (button3 != null) {
                    button3.setVisibility(8);
                }
                if (oVar.M == null || oVar.P == null) {
                    return 0;
                }
                int intValue = ((Integer) oVar.getView().getTag(R.id.kxc)).intValue();
                SongInfo songInfo = new SongInfo();
                try {
                    JSONObject jSONObject = new JSONObject(aiVar.Q);
                    songInfo.f251870h = jSONObject.optString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
                    songInfo.f251871i = jSONObject.optString("title");
                    songInfo.f251872m = jSONObject.optString("desc");
                    songInfo.C = jSONObject.optString("image_url");
                    z16 = !TextUtils.isEmpty(jSONObject.optString("id"));
                    if (z16) {
                        try {
                            songInfo.f251867d = Long.parseLong(jSONObject.optString("id"));
                        } catch (Exception e16) {
                            e = e16;
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, e.toString());
                            }
                            z17 = false;
                            this.f283591h = songInfo.f251867d;
                            QQPlayerService.t0(this);
                            if (QQPlayerService.m0() != 2) {
                                SearchUtils.f284954c = -1L;
                            } else {
                                SongInfo b06 = QQPlayerService.b0();
                                if (b06 != null) {
                                    SearchUtils.f284954c = b06.f251867d;
                                }
                            }
                            if (isNowThemeIsNight) {
                                if (this.f283591h == SearchUtils.f284954c) {
                                    oVar.P.setImageResource(R.drawable.bxj);
                                } else {
                                    oVar.P.setImageResource(R.drawable.bxh);
                                }
                            } else if (this.f283591h == SearchUtils.f284954c) {
                                oVar.P.setImageResource(R.drawable.bxi);
                            } else {
                                oVar.P.setImageResource(R.drawable.bxg);
                            }
                            if (z17 && z16 && !TextUtils.isEmpty(songInfo.f251870h)) {
                                oVar.P.setVisibility(0);
                                oVar.M.setOnClickListener(new h(aiVar, oVar, intValue, context, isNowThemeIsNight, songInfo));
                            } else {
                                oVar.P.setVisibility(8);
                            }
                            return com.tencent.mobileqq.util.x.c(context, 39.0f) + 0;
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    z16 = false;
                }
            } else {
                oVar.N.setVisibility(8);
                return 0;
            }
        } else {
            if (oVar != null && (button = oVar.N) != null) {
                button.setVisibility(8);
            }
            if (oVar != null && (imageView = oVar.P) != null) {
                imageView.setVisibility(8);
            }
            return 0;
        }
    }

    private void L(ai aiVar, com.tencent.mobileqq.search.business.net.view.o oVar) {
        Context context = oVar.F.getContext();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) oVar.Q.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) oVar.F.getLayoutParams();
        if (aiVar.f415128e0) {
            layoutParams.addRule(15);
            layoutParams2.addRule(15);
            layoutParams2.addRule(10, 0);
            layoutParams2.addRule(10, 0);
        } else {
            layoutParams.addRule(10);
            layoutParams2.addRule(10);
            layoutParams.addRule(15, 0);
            layoutParams2.addRule(15, 0);
        }
        Pair<Integer, Integer> E = E(aiVar, oVar, false, 0);
        if (((Integer) E.first).intValue() != 0) {
            ((RelativeLayout.LayoutParams) oVar.F.getLayoutParams()).rightMargin = com.tencent.mobileqq.util.x.c(context, 10.0f);
        }
        int J = J(aiVar, oVar, ((Integer) E.first).intValue(), K(aiVar, oVar));
        if (((Integer) E.second).intValue() > J) {
            J = ((Integer) E.second).intValue();
        }
        RelativeLayout relativeLayout = oVar.M;
        if (relativeLayout != null) {
            ((RelativeLayout.LayoutParams) relativeLayout.getLayoutParams()).height = J;
        }
    }

    private void M(aj ajVar, p pVar) {
        int i3;
        int i16;
        SearchTemplatePresenter searchTemplatePresenter = this;
        Context context = pVar.getView().getContext();
        View view = pVar.getView();
        if (ajVar.f415155k0) {
            view.setPadding(view.getPaddingLeft(), UIUtils.b(view.getContext(), 9.0f), view.getPaddingRight(), UIUtils.b(view.getContext(), 9.0f));
        } else {
            view.setPadding(view.getPaddingLeft(), UIUtils.b(view.getContext(), 6.0f), view.getPaddingRight(), UIUtils.b(view.getContext(), 6.0f));
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fsi);
        ArrayList arrayList = new ArrayList();
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int childCount = linearLayout.getChildCount();
            i3 = R.id.de8;
            if (i18 >= childCount) {
                break;
            }
            View findViewById = linearLayout.getChildAt(i18).findViewById(R.id.de8);
            if (findViewById instanceof SquareImageView) {
                arrayList.add((SquareImageView) findViewById);
            }
            i18++;
        }
        if (!arrayList.isEmpty()) {
            if (ajVar.f415156l0) {
                for (int i19 = 0; i19 < arrayList.size(); i19++) {
                    ((SquareImageView) arrayList.get(i19)).setRoundRect(UIUtils.b(context, 4.0f));
                }
            } else {
                for (int i26 = 0; i26 < arrayList.size(); i26++) {
                    ((SquareImageView) arrayList.get(i26)).setRoundRect(0);
                }
            }
        }
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            pVar.b().setTextColor(Color.parseColor("#6991B8"));
            pVar.k().setTextColor(Color.parseColor("#44608A"));
            pVar.c().setTextColor(Color.parseColor("#44608A"));
        } else {
            pVar.b().setTextColor(Color.parseColor("#262626"));
            pVar.k().setTextColor(Color.parseColor("#737373"));
            pVar.c().setTextColor(Color.parseColor("#737373"));
        }
        if (!TextUtils.isEmpty(ajVar.W)) {
            z(context, (SquareImageView) pVar.f(), pVar.N, pVar.P, ajVar.f415146b0, ajVar.W, null, com.tencent.mobileqq.util.x.c(context, 21.0f));
        }
        if (!TextUtils.isEmpty(ajVar.f415148d0)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = searchTemplatePresenter.f283589e;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            obtain.mRequestWidth = pVar.M.getLayoutParams().width;
            obtain.mRequestHeight = pVar.M.getLayoutParams().height;
            URLDrawable drawable2 = URLDrawable.getDrawable(ajVar.f415148d0, obtain);
            pVar.M.setImageDrawable(drawable2);
            if (drawable2.getStatus() != 1 && drawable2.getStatus() != 0) {
                drawable2.restartDownload();
            }
            pVar.M.setVisibility(0);
        } else {
            pVar.M.setVisibility(8);
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ajq);
        int i27 = ajVar.f415146b0;
        if (i27 == 6 || i27 == 8) {
            dimensionPixelSize = com.tencent.mobileqq.util.x.c(context, 100.0f);
        }
        pVar.b().setText(SearchUtils.J(pVar.b(), SearchUtils.t0(pVar.b(), HardCodeUtil.qqStr(R.string.t7n)) * 10.0f, 1, ajVar.f415147c0.toString(), ajVar.P.f285039a, false, false, true));
        pVar.b().setEllipsize(null);
        searchTemplatePresenter.G(pVar.c(), SearchUtils.K(pVar.c(), (context.getResources().getDisplayMetrics().widthPixels - com.tencent.mobileqq.util.x.c(context, 40.0f)) - dimensionPixelSize, 2, ajVar.f415149e0.toString(), "", false, false, true), false);
        if (!TextUtils.isEmpty(ajVar.f415150f0)) {
            pVar.k().setText(SearchUtils.I(pVar.k(), context.getResources().getDisplayMetrics().widthPixels - com.tencent.mobileqq.util.x.c(context, 30.0f), 2, ajVar.f415150f0.toString(), ajVar.P.f285039a, false, false));
            pVar.k().setVisibility(0);
        } else {
            pVar.k().setVisibility(8);
        }
        List<lo2.f> list = ajVar.f415151g0;
        if (list != null) {
            float f16 = 0.0f;
            double d16 = 1.0d;
            if (list.size() == 1) {
                pVar.T.setVisibility(0);
                pVar.Q.setVisibility(8);
                Resources resources = pVar.getView().getResources();
                if (C == 0) {
                    C = resources.getDisplayMetrics().widthPixels;
                }
                SquareImageView squareImageView = pVar.R;
                squareImageView.setImageScale((float) (1.0d / ajVar.f415152h0), 0.0f);
                float dimension = resources.getDimension(R.dimen.ajj);
                float dimension2 = resources.getDimension(R.dimen.ajj);
                int c16 = com.tencent.mobileqq.util.x.c(pVar.getView().getContext(), 2.0f);
                double childCount2 = ((int) (((C - dimension) - dimension2) - ((r6 - 1) * c16))) / pVar.Q.getChildCount();
                double d17 = ajVar.f415154j0;
                int i28 = (int) (childCount2 * d17);
                int i29 = (int) (childCount2 * d17);
                squareImageView.setLayoutParams(new FrameLayout.LayoutParams(i28, i29));
                lo2.f fVar = ajVar.f415151g0.get(0);
                String str = fVar.f415209a;
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable = searchTemplatePresenter.f283588d;
                obtain2.mFailedDrawable = colorDrawable;
                obtain2.mLoadingDrawable = colorDrawable;
                obtain2.mRequestWidth = i28;
                obtain2.mRequestHeight = i29;
                obtain2.mPlayGifImage = true;
                URLDrawable drawable3 = URLDrawable.getDrawable(str, obtain2);
                squareImageView.setImageDrawable(drawable3);
                if (drawable3.getStatus() != 1 && drawable3.getStatus() != 0) {
                    drawable3.restartDownload();
                }
                if (fVar.f415210b == 2) {
                    pVar.S.setVisibility(0);
                } else {
                    pVar.S.setVisibility(8);
                }
                return;
            }
            pVar.T.setVisibility(8);
            pVar.Q.setVisibility(0);
            int childCount3 = pVar.Q.getChildCount();
            int i36 = 0;
            while (i36 < ajVar.f415151g0.size() && i36 < childCount3) {
                View childAt = pVar.Q.getChildAt(i36);
                childAt.setVisibility(i17);
                SquareImageView squareImageView2 = (SquareImageView) childAt.findViewById(i3);
                ImageView imageView = (ImageView) childAt.findViewById(R.id.f166006e23);
                int m3 = UIUtils.m(context) / childCount3;
                double d18 = ajVar.f415152h0;
                int i37 = (int) (m3 * d18);
                squareImageView2.setImageScale((float) (d16 / d18), f16);
                lo2.f fVar2 = ajVar.f415151g0.get(i36);
                String str2 = fVar2.f415209a;
                URLDrawable.URLDrawableOptions obtain3 = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable2 = this.f283588d;
                obtain3.mFailedDrawable = colorDrawable2;
                obtain3.mLoadingDrawable = colorDrawable2;
                obtain3.mRequestWidth = m3;
                obtain3.mRequestHeight = i37;
                obtain3.mPlayGifImage = true;
                URLDrawable drawable4 = URLDrawable.getDrawable(str2, obtain3);
                squareImageView2.setImageDrawable(drawable4);
                if (drawable4.getStatus() != 1 && drawable4.getStatus() != 0) {
                    drawable4.restartDownload();
                }
                squareImageView2.setVisibility(0);
                if (fVar2.f415210b == 2) {
                    imageView.setVisibility(0);
                    i16 = 8;
                } else {
                    i16 = 8;
                    imageView.setVisibility(8);
                }
                if (i36 == childCount3 - 1 && ajVar.f415153i0 > childCount3) {
                    imageView.setVisibility(i16);
                    squareImageView2.setFilterColor(Color.parseColor("#66000000"));
                    int i38 = ajVar.f415153i0 - childCount3;
                    if (i38 > 99) {
                        i38 = 99;
                    }
                    squareImageView2.setFilterText(Marker.ANY_NON_NULL_MARKER + i38);
                    squareImageView2.setFilterTextSize(com.tencent.mobileqq.util.x.c(squareImageView2.getContext(), 20.0f));
                } else {
                    squareImageView2.setFilterColor(-1);
                    squareImageView2.setFilterText("");
                }
                i36++;
                searchTemplatePresenter = this;
                i17 = 0;
                f16 = 0.0f;
                d16 = 1.0d;
                i3 = R.id.de8;
            }
            while (i36 < childCount3) {
                pVar.Q.getChildAt(i36).setVisibility(4);
                i36++;
            }
            return;
        }
        pVar.T.setVisibility(8);
        pVar.Q.setVisibility(8);
    }

    private float N(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return 3.5f;
        }
        return 7.0f;
    }

    private StateListDrawable O(String str) {
        String str2;
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            str = "#040E1C";
            str2 = "#194A90";
        } else {
            if (!SearchUtils.C0(str)) {
                str = "#F1F1F1";
            }
            str2 = "#E5E6E7";
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(str2));
        ColorDrawable colorDrawable2 = new ColorDrawable(Color.parseColor(str));
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, colorDrawable);
        stateListDrawable.addState(new int[0], colorDrawable2);
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        boolean z16 = !"true".equals(AVBizModuleFactory.getModuleByName(Constants.Business.DEFAULT).checkAVFocus());
        QLog.i("Q.uniteSearch.SearchTemplatePresenter", 1, "isAudioBusy=" + z16);
        return z16;
    }

    private void Q(View view, long j3, String str, String str2) {
        if (j3 == 1105 && !TextUtils.isEmpty(str2)) {
            am.o(view, str2, str);
        }
    }

    private void R(TextView textView, String str, int i3) {
        if (textView != null && !TextUtils.isEmpty(str) && i3 > 0) {
            Context context = textView.getContext();
            textView.setMaxLines(i3);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
            if (str.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)) {
                textView.setTextSize(1, 17.0f);
                if (isNowThemeIsNight) {
                    textView.setTextColor(Color.parseColor("#737373"));
                } else {
                    textView.setTextColor(context.getResources().getColor(R.color.skin_black_26));
                }
                textView.setIncludeFontPadding(false);
                return;
            }
            if (str.equals("B")) {
                textView.setTextSize(1, 15.0f);
                if (isNowThemeIsNight) {
                    textView.setTextColor(Color.parseColor("#737373"));
                } else {
                    textView.setTextColor(context.getResources().getColor(R.color.skin_black_26));
                }
                textView.setIncludeFontPadding(false);
                return;
            }
            if (str.equals(BdhLogUtil.LogTag.Tag_Conn)) {
                textView.setTextSize(1, 14.0f);
                if (isNowThemeIsNight) {
                    textView.setTextColor(Color.parseColor("#4A4A4A"));
                } else {
                    textView.setTextColor(context.getResources().getColor(R.color.skin_black_73));
                }
                textView.setIncludeFontPadding(false);
                return;
            }
            if (str.equals("D")) {
                textView.setTextSize(1, 13.0f);
                if (isNowThemeIsNight) {
                    textView.setTextColor(Color.parseColor("#4A4A4A"));
                } else {
                    textView.setTextColor(context.getResources().getColor(R.color.skin_black_73));
                }
                textView.setIncludeFontPadding(false);
                return;
            }
            if (str.equals("E")) {
                textView.setTextSize(1, 12.0f);
                if (isNowThemeIsNight) {
                    textView.setTextColor(Color.parseColor("#4A4A4A"));
                } else {
                    textView.setTextColor(context.getResources().getColor(R.color.skin_black_73));
                }
                textView.setIncludeFontPadding(false);
                return;
            }
            if (str.equals(UserInfo.SEX_FEMALE)) {
                textView.setTextSize(1, 12.0f);
                textView.setIncludeFontPadding(false);
                if (isNowThemeIsNight) {
                    textView.setTextColor(Color.parseColor("#4A4A4A"));
                    return;
                } else {
                    textView.setTextColor(context.getResources().getColor(R.color.skin_search_special));
                    return;
                }
            }
            textView.setTextSize(1, 17.0f);
            textView.setTextColor(context.getResources().getColor(R.color.skin_black_theme_version2));
            textView.setIncludeFontPadding(false);
        }
    }

    private void j(lo2.j jVar, lo2.k kVar) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Context context = kVar.getView().getContext();
        if (ThemeUtil.isNowThemeIsNight(runtime, false, null)) {
            kVar.M.setTextColor(Color.parseColor("#737373"));
        } else {
            kVar.M.setTextColor(Color.parseColor("#262626"));
        }
        if (TextUtils.isEmpty(jVar.f415216b0)) {
            kVar.M.setVisibility(8);
        } else {
            CharSequence J = SearchUtils.J(kVar.M, (int) ((kVar.M.getContext().getResources().getDisplayMetrics().widthPixels - com.tencent.mobileqq.util.x.c(kVar.M.getContext(), 30.0f)) - SearchUtils.t0(kVar.M, jVar.f415217c0)), 1, jVar.f415216b0.toString(), jVar.P.f285039a, false, false, true);
            if (J == null) {
                J = "";
            }
            if (jVar.f415217c0 == null) {
                jVar.f415217c0 = "";
            }
            kVar.M.setText(new SpannableStringBuilder(J).append((CharSequence) jVar.f415217c0));
            kVar.M.setVisibility(0);
        }
        int i3 = 4;
        boolean z16 = true;
        if (jVar.f415220f0 != null) {
            kVar.Q.setVisibility(0);
            kVar.N.setVisibility(8);
            int Z = (((int) (ah.Z() - UIUtils.b(context, 30.0f))) / 2) - UIUtils.b(context, 3.0f);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mPlayGifImage = true;
            obtain.mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            obtain.mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            obtain.mRequestWidth = Z;
            obtain.mRequestHeight = Z;
            URLDrawable drawable = URLDrawable.getDrawable(jVar.f415220f0.f415209a, obtain);
            kVar.S.setImageDrawable(drawable);
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kVar.S.getLayoutParams();
            layoutParams.height = Z;
            layoutParams.width = Z;
            kVar.S.setLayoutParams(layoutParams);
            kVar.S.setVisibility(0);
            List<lo2.f> list = jVar.f415219e0;
            if (list != null) {
                int min = Math.min(list.size(), 4);
                int b16 = (Z - UIUtils.b(context, 3.0f)) / 2;
                int[] iArr = {R.id.dcq, R.id.dcr, R.id.dcs, R.id.dct};
                int i16 = 0;
                while (i16 < min) {
                    SquareImageView squareImageView = (SquareImageView) kVar.Q.findViewById(iArr[i16]);
                    String str = jVar.f415219e0.get(i16).f415209a;
                    obtain.mPlayGifImage = z16;
                    ColorDrawable colorDrawable = this.f283588d;
                    obtain.mFailedDrawable = colorDrawable;
                    obtain.mLoadingDrawable = colorDrawable;
                    obtain.mRequestWidth = b16;
                    obtain.mRequestHeight = b16;
                    URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
                    squareImageView.setImageDrawable(drawable2);
                    if (drawable2.getStatus() != z16 && drawable2.getStatus() != 0) {
                        drawable2.restartDownload();
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) squareImageView.getLayoutParams();
                    layoutParams2.height = b16;
                    layoutParams2.width = b16;
                    squareImageView.setLayoutParams(layoutParams2);
                    squareImageView.setVisibility(0);
                    if (i16 == 3 && jVar.f415218d0 > 4) {
                        squareImageView.setFilterColor(Color.parseColor("#66000000"));
                        int i17 = jVar.f415218d0 - 4;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(Marker.ANY_NON_NULL_MARKER);
                        if (i17 > 99) {
                            i17 = 99;
                        }
                        sb5.append(i17);
                        squareImageView.setFilterText(sb5.toString());
                        squareImageView.setFilterTextSize(com.tencent.mobileqq.util.x.c(kVar.getView().getContext(), 20.0f));
                    } else {
                        squareImageView.setFilterColor(-1);
                        squareImageView.setFilterText("");
                    }
                    i16++;
                    i3 = 4;
                    z16 = true;
                }
                for (int i18 = i3; i16 < i18; i18 = 4) {
                    kVar.Q.findViewById(iArr[i16]).setVisibility(i18);
                    i16++;
                }
                return;
            }
            return;
        }
        kVar.Q.setVisibility(8);
        kVar.N.setVisibility(0);
        List<lo2.f> list2 = jVar.f415219e0;
        if (list2 != null) {
            int min2 = Math.min(list2.size(), kVar.P);
            int Z2 = (int) (ah.Z() - UIUtils.b(kVar.getView().getContext(), ((min2 - 1) * 2) + 27));
            int i19 = 0;
            while (i19 < min2) {
                SquareImageView squareImageView2 = (SquareImageView) kVar.N.getChildAt(i19);
                String str2 = jVar.f415219e0.get(i19).f415209a;
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                obtain2.mPlayGifImage = true;
                ColorDrawable colorDrawable2 = this.f283588d;
                obtain2.mFailedDrawable = colorDrawable2;
                obtain2.mLoadingDrawable = colorDrawable2;
                obtain2.mRequestWidth = Z2;
                obtain2.mRequestHeight = Z2;
                obtain2.mMemoryCacheKeySuffix = "fourPic";
                URLDrawable drawable3 = URLDrawable.getDrawable(str2, obtain2);
                squareImageView2.setImageDrawable(drawable3);
                if (drawable3.getStatus() != 1 && drawable3.getStatus() != 0) {
                    drawable3.restartDownload();
                }
                if (jVar.f415221g0 != 0) {
                    squareImageView2.setImageScale(((Z2 / 4) * 1.0f) / com.tencent.mobileqq.util.x.c(context, r5 / 2), 0.0f);
                } else {
                    squareImageView2.setImageScale(1.0f, 0.0f);
                }
                squareImageView2.setVisibility(0);
                int i26 = kVar.P;
                if (i19 == i26 - 1 && jVar.f415218d0 > i26) {
                    squareImageView2.setFilterColor(Color.parseColor("#66000000"));
                    int i27 = jVar.f415218d0 - kVar.P;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(Marker.ANY_NON_NULL_MARKER);
                    if (i27 > 99) {
                        i27 = 99;
                    }
                    sb6.append(i27);
                    squareImageView2.setFilterText(sb6.toString());
                    squareImageView2.setFilterTextSize(com.tencent.mobileqq.util.x.c(kVar.getView().getContext(), 20.0f));
                } else {
                    squareImageView2.setFilterColor(-1);
                    squareImageView2.setFilterText("");
                }
                i19++;
            }
            while (i19 < kVar.P) {
                kVar.N.getChildAt(i19).setVisibility(4);
                i19++;
            }
        }
    }

    private void k(lo2.l lVar, com.tencent.mobileqq.search.business.net.view.b bVar) {
        int c16;
        Context context = bVar.getView().getContext();
        if (!TextUtils.isEmpty(lVar.W)) {
            bVar.R.setVisibility(0);
            z(context, (SquareImageView) bVar.S, bVar.T, bVar.N, lVar.f415224c0, lVar.W, lVar.f415227f0, context.getResources().getDimensionPixelSize(R.dimen.ajq));
        } else {
            bVar.R.setVisibility(8);
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ajq);
        int i3 = lVar.f415224c0;
        if (i3 == 6 || i3 == 8) {
            dimensionPixelSize = com.tencent.mobileqq.util.x.c(context, 100.0f);
        }
        if (bVar.R.getVisibility() == 8) {
            c16 = 0;
        } else {
            c16 = dimensionPixelSize + com.tencent.mobileqq.util.x.c(context, 10.0f);
        }
        bVar.M.setText(SearchUtils.I(bVar.M, context.getResources().getDisplayMetrics().widthPixels - com.tencent.mobileqq.util.x.c(context, 30.0f), 2, lVar.f415223b0.toString(), lVar.P.f285039a, false, true));
        CharSequence I = SearchUtils.I(bVar.P, (context.getResources().getDisplayMetrics().widthPixels - com.tencent.mobileqq.util.x.c(context, 30.0f)) - c16, 2, lVar.f415225d0.toString(), lVar.P.f285039a, false, false);
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            bVar.P.setTextColor(Color.parseColor("#4A4A4A"));
            bVar.Q.setTextColor(Color.parseColor("#4A4A4A"));
        } else {
            bVar.P.setTextColor(Color.parseColor("#737373"));
            bVar.Q.setTextColor(Color.parseColor("#737373"));
        }
        G(bVar.P, I, true);
        F(bVar.Q, lVar.f415226e0);
    }

    private void l(lo2.n nVar, com.tencent.mobileqq.search.business.net.view.d dVar) {
        int i3;
        int i16;
        Context context = dVar.getView().getContext();
        int i17 = nVar.f415242b0;
        if (i17 == 1) {
            i3 = com.tencent.mobileqq.util.x.c(context, 375.0f);
            i16 = com.tencent.mobileqq.util.x.c(context, 150.0f);
        } else if (i17 == 2) {
            i3 = com.tencent.mobileqq.util.x.c(context, 375.0f);
            i16 = com.tencent.mobileqq.util.x.c(context, 180.0f);
        } else if (i17 == 0) {
            i3 = com.tencent.mobileqq.util.x.c(context, nVar.f415244d0 / 2.0f);
            i16 = com.tencent.mobileqq.util.x.c(context, nVar.f415245e0 / 2.0f);
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (i3 == 0 || i16 == 0) {
            i3 = com.tencent.mobileqq.util.x.c(context, 375.0f);
            i16 = com.tencent.mobileqq.util.x.c(context, 150.0f);
        }
        if (!TextUtils.isEmpty(nVar.f415243c0)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = this.f283589e;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
            obtain.mPlayGifImage = true;
            URLDrawable drawable2 = URLDrawable.getDrawable(nVar.f415243c0, obtain);
            dVar.N.setImageDrawable(drawable2);
            if (drawable2.getStatus() != 1 && drawable2.getStatus() != 0) {
                drawable2.restartDownload();
            }
        } else {
            dVar.N.setImageDrawable(this.f283589e);
        }
        dVar.N.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.M.getLayoutParams();
        layoutParams.height = (int) (((UIUtils.m(context) * i16) * 1.0f) / i3);
        dVar.M.setLayoutParams(layoutParams);
        dVar.M.setPadding(0, 0, 0, 0);
        if (!TextUtils.isEmpty(nVar.f415248h0)) {
            dVar.Q.setText(nVar.f415248h0);
            dVar.Q.setVisibility(0);
        } else {
            dVar.Q.setVisibility(8);
        }
        if (!TextUtils.isEmpty(nVar.f415249i0)) {
            dVar.R.setText(nVar.f415249i0);
            dVar.R.setVisibility(0);
        } else {
            dVar.R.setVisibility(8);
        }
        if (!TextUtils.isEmpty(nVar.f415246f0)) {
            dVar.S.setText(nVar.f415246f0);
            try {
                if (!nVar.f415247g0.startsWith("#")) {
                    nVar.f415247g0 = "#" + nVar.f415247g0;
                }
                dVar.S.setBackgroundColor(Color.parseColor(nVar.f415247g0));
            } catch (Exception unused) {
                dVar.S.setBackgroundColor(Color.parseColor("#FF00FF00"));
                if (QLog.isColorLevel()) {
                    QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + nVar.f415247g0);
                }
            }
            dVar.S.setVisibility(0);
        } else {
            dVar.S.setVisibility(8);
        }
        View childAt = ((ViewGroup) dVar.getView()).getChildAt(((ViewGroup) dVar.getView()).getChildCount() - 1);
        if (childAt != null && (childAt.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            if (nVar.q() == 0) {
                ((LinearLayout.LayoutParams) childAt.getLayoutParams()).topMargin = 0;
                dVar.M.setPadding(0, 0, 0, com.tencent.mobileqq.util.x.c(context, 6.0f));
            } else if (nVar.q() == 2) {
                ((LinearLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin = 0;
            }
        }
    }

    private void n(SquareImageView squareImageView, int i3, int i16, String str) {
        if (squareImageView != null && !TextUtils.isEmpty(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = this.f283588d;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            float f16 = i3;
            squareImageView.getLayoutParams().width = com.tencent.mobileqq.util.x.c(squareImageView.getContext(), f16);
            float f17 = i16;
            squareImageView.getLayoutParams().height = com.tencent.mobileqq.util.x.c(squareImageView.getContext(), f17);
            squareImageView.setImageScale(f16 / f17, 0.0f);
            obtain.mRequestWidth = squareImageView.getLayoutParams().width;
            obtain.mRequestHeight = squareImageView.getLayoutParams().height;
            squareImageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        }
    }

    private void o(lo2.m mVar, View view, int i3, int i16) {
        View findViewById = view.findViewById(i16);
        if (findViewById == null) {
            return;
        }
        String valueOf = String.valueOf(mVar.getTitleSpans());
        String e16 = com.tencent.mobileqq.search.util.x.e(mVar);
        String z16 = mVar.z();
        String valueOf2 = String.valueOf(mVar.hashCode());
        int x16 = mVar.x();
        am.r(findViewById, valueOf, e16, z16, i3, mVar.e(), valueOf2, mVar.getRecallReason());
        am.k(findViewById, x16);
    }

    private void q(r rVar, com.tencent.mobileqq.search.business.net.view.h hVar) {
        int i3;
        int i16;
        Context context = hVar.getView().getContext();
        View view = hVar.getView();
        if (rVar.f415261k0) {
            view.setPadding(view.getPaddingLeft(), UIUtils.b(view.getContext(), 6.0f), view.getPaddingRight(), UIUtils.b(view.getContext(), 6.0f));
        } else {
            view.setPadding(view.getPaddingLeft(), UIUtils.b(view.getContext(), 3.0f), view.getPaddingRight(), UIUtils.b(view.getContext(), 3.0f));
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fsi);
        ArrayList arrayList = new ArrayList();
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int childCount = linearLayout.getChildCount();
            i3 = R.id.de8;
            if (i18 >= childCount) {
                break;
            }
            View findViewById = linearLayout.getChildAt(i18).findViewById(R.id.de8);
            if (findViewById instanceof SquareImageView) {
                arrayList.add((SquareImageView) findViewById);
            }
            i18++;
        }
        if (!arrayList.isEmpty()) {
            if (rVar.f415262l0) {
                for (int i19 = 0; i19 < arrayList.size(); i19++) {
                    ((SquareImageView) arrayList.get(i19)).setRoundRect(UIUtils.b(context, 4.0f));
                }
            } else {
                for (int i26 = 0; i26 < arrayList.size(); i26++) {
                    ((SquareImageView) arrayList.get(i26)).setRoundRect(0);
                }
            }
        }
        if (!TextUtils.isEmpty(rVar.W)) {
            z(context, (SquareImageView) hVar.f(), hVar.N, hVar.P, rVar.f415252b0, rVar.W, null, com.tencent.mobileqq.util.x.c(context, 32.0f));
        }
        if (!TextUtils.isEmpty(rVar.f415254d0)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = this.f283589e;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            obtain.mRequestWidth = hVar.M.getLayoutParams().width;
            obtain.mRequestHeight = hVar.M.getLayoutParams().height;
            URLDrawable drawable2 = URLDrawable.getDrawable(rVar.f415254d0, obtain);
            hVar.M.setImageDrawable(drawable2);
            if (drawable2.getStatus() != 1 && drawable2.getStatus() != 0) {
                drawable2.restartDownload();
            }
            hVar.M.setVisibility(0);
        } else {
            hVar.M.setVisibility(8);
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ajq);
        int i27 = rVar.f415252b0;
        if (i27 == 6 || i27 == 8) {
            dimensionPixelSize = com.tencent.mobileqq.util.x.c(context, 100.0f);
        }
        hVar.b().setText(SearchUtils.J(hVar.b(), SearchUtils.t0(hVar.b(), HardCodeUtil.qqStr(R.string.t7o)) * 10.0f, 1, rVar.f415253c0.toString(), rVar.P.f285039a, false, false, true));
        hVar.b().setEllipsize(null);
        G(hVar.c(), SearchUtils.K(hVar.c(), (context.getResources().getDisplayMetrics().widthPixels - com.tencent.mobileqq.util.x.c(context, 40.0f)) - dimensionPixelSize, 2, rVar.f415255e0.toString(), "", false, false, true), false);
        if (!TextUtils.isEmpty(rVar.f415256f0)) {
            hVar.k().setText(SearchUtils.I(hVar.k(), context.getResources().getDisplayMetrics().widthPixels - com.tencent.mobileqq.util.x.c(context, 30.0f), 2, rVar.f415256f0.toString(), rVar.P.f285039a, false, false));
            hVar.k().setVisibility(0);
        } else {
            hVar.k().setVisibility(8);
        }
        List<lo2.f> list = rVar.f415257g0;
        if (list != null) {
            float f16 = 0.0f;
            double d16 = 1.0d;
            if (list.size() == 1) {
                hVar.T.setVisibility(0);
                hVar.Q.setVisibility(8);
                Resources resources = hVar.getView().getResources();
                if (C == 0) {
                    C = resources.getDisplayMetrics().widthPixels;
                }
                SquareImageView squareImageView = hVar.R;
                squareImageView.setImageScale((float) (1.0d / rVar.f415258h0), 0.0f);
                float dimension = resources.getDimension(R.dimen.ajj);
                float dimension2 = resources.getDimension(R.dimen.ajj);
                int c16 = com.tencent.mobileqq.util.x.c(hVar.getView().getContext(), 2.0f);
                double childCount2 = ((int) (((C - dimension) - dimension2) - ((r7 - 1) * c16))) / hVar.Q.getChildCount();
                double d17 = rVar.f415260j0;
                int i28 = (int) (childCount2 * d17);
                int i29 = (int) (childCount2 * d17);
                squareImageView.setLayoutParams(new FrameLayout.LayoutParams(i28, i29));
                lo2.f fVar = rVar.f415257g0.get(0);
                String str = fVar.f415209a;
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable = this.f283588d;
                obtain2.mFailedDrawable = colorDrawable;
                obtain2.mLoadingDrawable = colorDrawable;
                obtain2.mRequestWidth = i28;
                obtain2.mRequestHeight = i29;
                obtain2.mPlayGifImage = true;
                URLDrawable drawable3 = URLDrawable.getDrawable(str, obtain2);
                squareImageView.setImageDrawable(drawable3);
                if (drawable3.getStatus() != 1 && drawable3.getStatus() != 0) {
                    drawable3.restartDownload();
                }
                if (fVar.f415210b == 2) {
                    hVar.S.setVisibility(0);
                } else {
                    hVar.S.setVisibility(8);
                }
            } else {
                hVar.T.setVisibility(8);
                hVar.Q.setVisibility(0);
                int childCount3 = hVar.Q.getChildCount();
                int i36 = 0;
                while (i36 < rVar.f415257g0.size() && i36 < childCount3) {
                    View childAt = hVar.Q.getChildAt(i36);
                    childAt.setVisibility(i17);
                    SquareImageView squareImageView2 = (SquareImageView) childAt.findViewById(i3);
                    ImageView imageView = (ImageView) childAt.findViewById(R.id.f166006e23);
                    squareImageView2.setImageScale((float) (d16 / rVar.f415258h0), f16);
                    lo2.f fVar2 = rVar.f415257g0.get(i36);
                    String str2 = fVar2.f415209a;
                    URLDrawable.URLDrawableOptions obtain3 = URLDrawable.URLDrawableOptions.obtain();
                    obtain3.mRequestHeight = 200;
                    obtain3.mRequestWidth = 200;
                    ColorDrawable colorDrawable2 = this.f283588d;
                    obtain3.mFailedDrawable = colorDrawable2;
                    obtain3.mLoadingDrawable = colorDrawable2;
                    obtain3.mPlayGifImage = true;
                    URLDrawable drawable4 = URLDrawable.getDrawable(str2, obtain3);
                    squareImageView2.setImageDrawable(drawable4);
                    if (drawable4.getStatus() != 1 && drawable4.getStatus() != 0) {
                        drawable4.restartDownload();
                    }
                    squareImageView2.setVisibility(0);
                    if (fVar2.f415210b == 2) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(8);
                    }
                    if (i36 == childCount3 - 1 && rVar.f415259i0 > childCount3) {
                        imageView.setVisibility(8);
                        squareImageView2.setFilterColor(Color.parseColor("#66000000"));
                        int i37 = rVar.f415259i0 - childCount3;
                        if (i37 > 99) {
                            i37 = 99;
                        }
                        squareImageView2.setFilterText(Marker.ANY_NON_NULL_MARKER + i37);
                        squareImageView2.setFilterTextSize(com.tencent.mobileqq.util.x.c(squareImageView2.getContext(), 20.0f));
                    } else {
                        squareImageView2.setFilterColor(-1);
                        squareImageView2.setFilterText("");
                    }
                    i36++;
                    f16 = 0.0f;
                    d16 = 1.0d;
                    i17 = 0;
                    i3 = R.id.de8;
                }
                while (i36 < childCount3) {
                    hVar.Q.getChildAt(i36).setVisibility(4);
                    i36++;
                }
            }
        } else {
            hVar.T.setVisibility(8);
            hVar.Q.setVisibility(8);
        }
        if (rVar.f415263m0 == null && TextUtils.equals(rVar.f415266p0, "0") && TextUtils.equals(rVar.f415268r0, "0")) {
            hVar.V.setVisibility(8);
            return;
        }
        if (rVar.f415263m0 != null) {
            hVar.U.removeAllViews();
            for (int size = rVar.f415263m0.size() - 1; size >= 0; size--) {
                if (size > 0) {
                    i16 = com.tencent.mobileqq.util.x.c(context, 11.0f) * size;
                } else {
                    i16 = 0;
                }
                SquareImageView squareImageView3 = (SquareImageView) LayoutInflater.from(context).inflate(R.layout.a0c, (ViewGroup) null, false);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.tencent.mobileqq.util.x.c(context, 16.0f), com.tencent.mobileqq.util.x.c(context, 16.0f));
                layoutParams.leftMargin = i16;
                hVar.U.addView(squareImageView3, (rVar.f415263m0.size() - 1) - size, layoutParams);
                String str3 = rVar.f415263m0.get(size);
                URLDrawable.URLDrawableOptions obtain4 = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable3 = this.f283588d;
                obtain4.mFailedDrawable = colorDrawable3;
                obtain4.mLoadingDrawable = colorDrawable3;
                obtain4.mRequestWidth = squareImageView3.getLayoutParams().width;
                obtain4.mRequestHeight = squareImageView3.getLayoutParams().height;
                URLDrawable drawable5 = URLDrawable.getDrawable(str3, obtain4);
                drawable5.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                squareImageView3.setImageDrawable(drawable5);
                if (drawable5.getStatus() != 1 && drawable5.getStatus() != 0) {
                    drawable5.restartDownload();
                }
                squareImageView3.setVisibility(0);
            }
        } else {
            hVar.U.removeAllViews();
        }
        if (!TextUtils.isEmpty(rVar.f415264n0)) {
            hVar.W.setText(rVar.f415264n0);
            hVar.W.setVisibility(0);
        } else {
            hVar.W.setVisibility(8);
        }
        if (!TextUtils.isEmpty(rVar.f415265o0)) {
            URLDrawable.URLDrawableOptions obtain5 = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable6 = this.f283589e;
            obtain5.mFailedDrawable = drawable6;
            obtain5.mLoadingDrawable = drawable6;
            obtain5.mRequestWidth = hVar.X.getLayoutParams().width;
            obtain5.mRequestHeight = hVar.X.getLayoutParams().height;
            URLDrawable drawable7 = URLDrawable.getDrawable(rVar.f415265o0, obtain5);
            hVar.X.setImageDrawable(drawable7);
            if (drawable7.getStatus() != 1 && drawable7.getStatus() != 0) {
                drawable7.restartDownload();
            }
            hVar.X.setVisibility(0);
        } else {
            hVar.X.setVisibility(8);
        }
        if (!TextUtils.isEmpty(rVar.f415266p0)) {
            hVar.Y.setText(rVar.f415266p0);
            hVar.Y.setVisibility(0);
        } else {
            hVar.Y.setVisibility(8);
        }
        if (!TextUtils.isEmpty(rVar.f415267q0)) {
            URLDrawable.URLDrawableOptions obtain6 = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable8 = this.f283589e;
            obtain6.mFailedDrawable = drawable8;
            obtain6.mLoadingDrawable = drawable8;
            obtain6.mRequestWidth = hVar.Z.getLayoutParams().width;
            obtain6.mRequestHeight = hVar.Z.getLayoutParams().height;
            URLDrawable drawable9 = URLDrawable.getDrawable(rVar.f415267q0, obtain6);
            hVar.Z.setImageDrawable(drawable9);
            if (drawable9.getStatus() != 1 && drawable9.getStatus() != 0) {
                drawable9.restartDownload();
            }
            hVar.Z.setVisibility(0);
        } else {
            hVar.Z.setVisibility(8);
        }
        if (!TextUtils.isEmpty(rVar.f415268r0)) {
            hVar.f283047a0.setText(rVar.f415268r0);
            hVar.f283047a0.setVisibility(0);
        } else {
            hVar.f283047a0.setVisibility(8);
        }
    }

    public static Pair<Integer, Integer> t(SquareImageView squareImageView, int i3, String str, int i16, boolean z16, int i17, lo2.m mVar) {
        int i18;
        int i19;
        int i26;
        boolean z17;
        URLDrawable uRLDrawable;
        int i27 = i17;
        if (squareImageView != null && !TextUtils.isEmpty(str)) {
            Context context = squareImageView.getContext();
            if (i3 != 128) {
                switch (i3) {
                    case 1:
                        i18 = com.tencent.mobileqq.util.x.c(context, 60.0f);
                        i26 = com.tencent.mobileqq.util.x.c(context, 60.0f);
                        z17 = false;
                        break;
                    case 2:
                        i18 = com.tencent.mobileqq.util.x.c(context, 50.0f);
                        i26 = com.tencent.mobileqq.util.x.c(context, 50.0f);
                        z17 = false;
                        break;
                    case 3:
                        if (squareImageView.getContext() instanceof PublicAcntSearchActivity) {
                            i18 = com.tencent.mobileqq.util.x.c(squareImageView.getContext(), 50.0f);
                            i26 = com.tencent.mobileqq.util.x.c(squareImageView.getContext(), 50.0f);
                        } else {
                            i18 = com.tencent.mobileqq.util.x.c(context, 60.0f);
                            i26 = com.tencent.mobileqq.util.x.c(context, 60.0f);
                        }
                        z17 = true;
                        break;
                    case 4:
                        int c16 = com.tencent.mobileqq.util.x.c(context, 40.0f);
                        z17 = true;
                        i26 = com.tencent.mobileqq.util.x.c(context, 40.0f);
                        i18 = c16;
                        break;
                    case 5:
                        i18 = com.tencent.mobileqq.util.x.c(context, 60.0f);
                        i26 = com.tencent.mobileqq.util.x.c(context, 85.0f);
                        z17 = false;
                        break;
                    case 6:
                        i18 = com.tencent.mobileqq.util.x.c(context, 113.0f);
                        i26 = com.tencent.mobileqq.util.x.c(context, 60.0f);
                        z17 = false;
                        break;
                    case 7:
                        i18 = com.tencent.mobileqq.util.x.c(context, 100.0f);
                        i26 = com.tencent.mobileqq.util.x.c(context, 141.0f);
                        z17 = false;
                        break;
                    case 8:
                        i18 = com.tencent.mobileqq.util.x.c(context, 220.0f);
                        i26 = com.tencent.mobileqq.util.x.c(context, 136.0f);
                        z17 = false;
                        break;
                    case 9:
                        i18 = com.tencent.mobileqq.util.x.c(context, 162.0f);
                        i26 = com.tencent.mobileqq.util.x.c(context, 162.0f);
                        z17 = false;
                        break;
                    case 10:
                        i18 = com.tencent.mobileqq.util.x.c(context, 162.0f);
                        i26 = com.tencent.mobileqq.util.x.c(context, 228.0f);
                        z17 = false;
                        break;
                    case 11:
                        i18 = com.tencent.mobileqq.util.x.c(context, 162.0f);
                        i26 = com.tencent.mobileqq.util.x.c(context, 162.0f);
                        z17 = true;
                        break;
                    default:
                        i18 = com.tencent.mobileqq.util.x.c(context, 60.0f);
                        i26 = com.tencent.mobileqq.util.x.c(context, 60.0f);
                        z17 = false;
                        break;
                }
            } else {
                if (mVar instanceof ai) {
                    i18 = com.tencent.mobileqq.util.x.c(context, mVar.U.f415238j / 2);
                    i19 = com.tencent.mobileqq.util.x.c(context, mVar.U.f415239k / 2);
                } else {
                    i18 = 0;
                    i19 = 0;
                }
                m.a aVar = mVar.U;
                if (i16 == aVar.f415238j / 2 && i16 == aVar.f415239k / 2) {
                    i26 = i19;
                    z17 = true;
                } else {
                    i26 = i19;
                    z17 = false;
                }
            }
            Drawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            if (z16) {
                i26 = (int) (i27 * ((i26 * 1.0f) / i18));
                if (z17) {
                    squareImageView.setPadding(com.tencent.mobileqq.util.x.c(context, 3.0f), com.tencent.mobileqq.util.x.c(context, 3.0f), com.tencent.mobileqq.util.x.c(context, 3.0f), com.tencent.mobileqq.util.x.c(context, 3.0f));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) squareImageView.getLayoutParams();
                    int c17 = ((int) ((i27 * 0.19999999999999996d) / 2.0d)) - com.tencent.mobileqq.util.x.c(context, 3.0f);
                    layoutParams.rightMargin = c17;
                    layoutParams.leftMargin = c17;
                    layoutParams.topMargin = c17;
                    squareImageView.setLayoutParams(layoutParams);
                }
            } else {
                i27 = i18;
            }
            float f16 = i27;
            squareImageView.setImageScale((1.0f * f16) / i26, 0.0f);
            try {
                if (!TextUtils.isEmpty(str)) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestWidth = i27;
                    obtain.mRequestHeight = i26;
                    if (z17) {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setShape(0);
                        gradientDrawable.setCornerRadius(f16 / 2.0f);
                        gradientDrawable.setColor(-1579033);
                        obtain.mLoadingDrawable = gradientDrawable;
                        obtain.mFailedDrawable = gradientDrawable;
                    } else {
                        obtain.mFailedDrawable = colorDrawable;
                        obtain.mLoadingDrawable = colorDrawable;
                        squareImageView.setBackgroundColor(0);
                    }
                    obtain.mPlayGifImage = true;
                    if (z17) {
                        obtain.mMemoryCacheKeySuffix = "isAvatar" + i27 + i26;
                        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
                        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                        uRLDrawable = drawable;
                    } else {
                        obtain.mMemoryCacheKeySuffix = "isNotAvatar" + i27 + i26 + i16;
                        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
                        drawable2.setTag(com.tencent.mobileqq.urldrawable.a.c(i27, i26, i16));
                        drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                        uRLDrawable = drawable2;
                    }
                    if (uRLDrawable.getStatus() != 1 && uRLDrawable.getStatus() != 0) {
                        uRLDrawable.restartDownload();
                    }
                    colorDrawable = uRLDrawable;
                }
            } catch (Exception e16) {
                QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + str, e16);
            }
            squareImageView.setImageDrawable(colorDrawable);
            return new Pair<>(Integer.valueOf(i27), Integer.valueOf(i26));
        }
        return new Pair<>(0, 0);
    }

    private void v(lo2.w wVar, com.tencent.mobileqq.search.view.k kVar) {
        View view = kVar.getView();
        Context context = view.getContext();
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            if (linearLayout.getChildCount() == 1) {
                View childAt = linearLayout.getChildAt(0);
                childAt.setPadding(childAt.getPaddingLeft(), 0, childAt.getPaddingRight(), 0);
            }
        }
        if (!TextUtils.isEmpty(wVar.f415295b0)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = this.f283588d;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mRequestWidth = com.tencent.mobileqq.util.x.c(context, 50.0f);
            obtain.mRequestHeight = com.tencent.mobileqq.util.x.c(context, 50.0f);
            obtain.mMemoryCacheKeySuffix = "leftIcon";
            URLDrawable drawable = URLDrawable.getDrawable(wVar.f415295b0, obtain);
            kVar.N.setImageDrawable(drawable);
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
            kVar.N.setVisibility(0);
        } else {
            kVar.N.setVisibility(8);
        }
        if (!TextUtils.isEmpty(wVar.f415296c0)) {
            kVar.P.setText(wVar.f415296c0);
            kVar.P.setVisibility(0);
        } else {
            kVar.P.setVisibility(8);
        }
        if (!TextUtils.isEmpty(wVar.N)) {
            kVar.Q.setText(wVar.N);
            kVar.Q.setVisibility(0);
        } else {
            kVar.Q.setVisibility(8);
        }
        if (!TextUtils.isEmpty(wVar.f415297d0)) {
            kVar.R.setVisibility(0);
            kVar.R.setText(wVar.f415297d0);
        } else {
            kVar.R.setVisibility(8);
        }
        if (!TextUtils.isEmpty(wVar.f415298e0)) {
            URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable2 = this.f283588d;
            obtain2.mFailedDrawable = colorDrawable2;
            obtain2.mLoadingDrawable = colorDrawable2;
            obtain2.mRequestWidth = com.tencent.mobileqq.util.x.c(context, 30.0f);
            obtain2.mRequestHeight = com.tencent.mobileqq.util.x.c(context, 30.0f);
            obtain2.mMemoryCacheKeySuffix = "rightIcon";
            URLDrawable drawable2 = URLDrawable.getDrawable(wVar.f415298e0, obtain2);
            kVar.S.setImageDrawable(drawable2);
            if (drawable2.getStatus() != 1 && drawable2.getStatus() != 0) {
                drawable2.restartDownload();
            }
            kVar.S.setVisibility(0);
        } else {
            kVar.S.setVisibility(8);
        }
        kVar.p(wVar);
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            kVar.M.setBackgroundResource(R.drawable.f160534jf);
            kVar.U.setBackgroundResource(R.drawable.f160534jf);
            kVar.P.setTextColor(Color.parseColor("#737373"));
            kVar.R.setTextColor(Color.parseColor("#4A4A4A"));
        } else {
            kVar.M.setBackgroundResource(R.drawable.f160533je);
            kVar.U.setBackgroundResource(R.drawable.f160533je);
            kVar.P.setTextColor(Color.parseColor("#262626"));
            kVar.R.setTextColor(Color.parseColor("#737373"));
        }
        TextView textView = kVar.Q;
        if (textView != null) {
            textView.setTextColor(com.tencent.mobileqq.search.util.a.a());
        }
        kVar.M.setOnClickListener(new d(wVar, kVar, context));
        kVar.U.setOnClickListener(new e(wVar, kVar, context));
    }

    private void x(x xVar, com.tencent.mobileqq.search.view.l lVar) {
        View view = lVar.getView();
        Context context = view.getContext();
        if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            if (linearLayout.getChildCount() == 1) {
                View childAt = linearLayout.getChildAt(0);
                childAt.setPadding(childAt.getPaddingLeft(), 0, childAt.getPaddingRight(), 0);
            }
        }
        if (!TextUtils.isEmpty(xVar.f415302b0)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = this.f283588d;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mRequestWidth = com.tencent.mobileqq.util.x.c(context, 40.0f);
            obtain.mRequestHeight = com.tencent.mobileqq.util.x.c(context, 40.0f);
            obtain.mMemoryCacheKeySuffix = "leftIcon";
            URLDrawable drawable = URLDrawable.getDrawable(xVar.f415302b0, obtain);
            lVar.N.setImageDrawable(drawable);
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
            lVar.N.setVisibility(0);
        } else {
            lVar.N.setVisibility(8);
        }
        if (!TextUtils.isEmpty(xVar.f415303c0)) {
            lVar.P.setText(xVar.f415303c0);
            lVar.P.setVisibility(0);
        } else {
            lVar.P.setVisibility(8);
        }
        if (!TextUtils.isEmpty(xVar.N)) {
            lVar.R.setText(xVar.N);
            lVar.R.setVisibility(0);
        } else {
            lVar.R.setVisibility(8);
        }
        if (!TextUtils.isEmpty(xVar.f415304d0)) {
            lVar.S.setVisibility(0);
            lVar.S.setText(xVar.f415304d0);
        } else {
            lVar.S.setVisibility(8);
        }
        if (xVar.f415305e0) {
            lVar.T.setVisibility(0);
        } else {
            lVar.T.setVisibility(8);
        }
        com.tencent.mobileqq.search.report.b.e(null, 0, xVar.R, "0X8009D5C", 0, 0, null, null);
        List<lo2.al> list = xVar.f415307g0;
        if (list != null && list.size() > 0) {
            com.tencent.mobileqq.search.report.b.e(null, 0, xVar.R, "0X8009D5E", 0, 0, null, null);
        }
        lVar.p(xVar);
        lVar.M.setOnClickListener(new c(xVar, lVar, context));
    }

    private void y(SquareImageView squareImageView, String str) {
        if (squareImageView != null && !TextUtils.isEmpty(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = this.f283588d;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mRequestWidth = squareImageView.getLayoutParams().width;
            obtain.mRequestHeight = squareImageView.getLayoutParams().height;
            squareImageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.tencent.image.URLDrawable] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r8v10, types: [com.tencent.image.URLDrawable] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    public void A(SquareImageView squareImageView, ImageView imageView, TextView textView, int i3, int i16, boolean z16, String str, String str2, int i17, boolean z17) {
        ColorDrawable colorDrawable;
        ?? r85;
        ?? drawable;
        ViewGroup.LayoutParams layoutParams = squareImageView.getLayoutParams();
        if (squareImageView.getContext() instanceof PublicAcntSearchActivity) {
            layoutParams.width = com.tencent.mobileqq.util.x.c(squareImageView.getContext(), 50.0f);
            layoutParams.height = com.tencent.mobileqq.util.x.c(squareImageView.getContext(), 50.0f);
        } else {
            layoutParams.width = i3;
            layoutParams.height = i16;
        }
        squareImageView.setLayoutParams(layoutParams);
        if (i16 != 0) {
            squareImageView.setImageScale((i3 * 1.0f) / i16, 0.0f);
        } else {
            squareImageView.setImageScale(1.0f, 0.0f);
        }
        if (z16) {
            squareImageView.setFilterColor(Color.parseColor("#66000000"));
        } else {
            squareImageView.setFilterColor(-1);
        }
        if (i17 != 0) {
            imageView.setImageResource(i17);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            textView.setVisibility(0);
            textView.setText(str2);
        } else {
            textView.setVisibility(8);
        }
        ColorDrawable colorDrawable2 = this.f283588d;
        colorDrawable2.setBounds(0, 0, i3, i16);
        try {
            colorDrawable = colorDrawable2;
            if (!TextUtils.isEmpty(str)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = i3;
                obtain.mRequestHeight = i16;
                ColorDrawable colorDrawable3 = this.f283588d;
                obtain.mFailedDrawable = colorDrawable3;
                obtain.mLoadingDrawable = colorDrawable3;
                if (z17) {
                    obtain.mMemoryCacheKeySuffix = "isAvatar";
                    r85 = URLDrawable.getDrawable(str, obtain);
                    r85.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                    drawable = r85;
                } else {
                    obtain.mMemoryCacheKeySuffix = "isNotAvatar";
                    r85 = colorDrawable2;
                    drawable = URLDrawable.getDrawable(str, obtain);
                }
                try {
                    int status = drawable.getStatus();
                    colorDrawable = drawable;
                    if (status != 1) {
                        int status2 = drawable.getStatus();
                        colorDrawable = drawable;
                        if (status2 != 0) {
                            drawable.restartDownload();
                            colorDrawable = drawable;
                        }
                    }
                } catch (Exception e16) {
                    ColorDrawable colorDrawable4 = r85;
                    e = e16;
                    colorDrawable2 = colorDrawable4;
                    QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + str, e);
                    colorDrawable = colorDrawable2;
                    squareImageView.setImageDrawable(colorDrawable);
                }
            }
        } catch (Exception e17) {
            e = e17;
        }
        squareImageView.setImageDrawable(colorDrawable);
    }

    protected void B(y yVar, com.tencent.mobileqq.search.view.m mVar) {
        List<lo2.a> list;
        Context context = mVar.getView().getContext();
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            mVar.N.setTextColor(Color.parseColor("#737373"));
            mVar.Q.setTextColor(Color.parseColor("#4A4A4A"));
        } else {
            mVar.N.setTextColor(Color.parseColor("#262626"));
            mVar.Q.setTextColor(Color.parseColor("#737373"));
        }
        if (!TextUtils.isEmpty(yVar.f415310b0)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = this.f283588d;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mRequestWidth = com.tencent.mobileqq.util.x.c(context, 18.0f);
            obtain.mRequestHeight = com.tencent.mobileqq.util.x.c(context, 18.0f);
            obtain.mMemoryCacheKeySuffix = "askIcon";
            URLDrawable drawable = URLDrawable.getDrawable(yVar.f415310b0, obtain);
            mVar.M.setImageDrawable(drawable);
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
            mVar.M.setVisibility(0);
        } else {
            mVar.M.setVisibility(8);
        }
        if (!TextUtils.isEmpty(yVar.f415311c0)) {
            int i3 = mVar.N.getContext().getResources().getDisplayMetrics().widthPixels;
            String str = "";
            for (int i16 = 0; i16 < com.tencent.mobileqq.util.x.c(context, 22.0f) / ((int) SearchUtils.t0(mVar.N, " ")); i16++) {
                str = str + " ";
            }
            mVar.N.setText(SearchUtils.J(mVar.N, i3, 2, str + yVar.f415311c0, yVar.P.f285039a, false, false, true));
        }
        mVar.p(yVar);
        if (!TextUtils.isEmpty(yVar.f415312d0) && (list = yVar.f415313e0) != null && list.size() != 0) {
            mVar.Q.setText(yVar.f415312d0);
            mVar.Q.setVisibility(0);
        } else {
            mVar.Q.setVisibility(8);
        }
    }

    public void F(TextView textView, CharSequence charSequence) {
        G(textView, charSequence, true);
    }

    public void G(TextView textView, CharSequence charSequence, boolean z16) {
        if (!z16) {
            textView.setEllipsize(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setText(charSequence);
            if (textView.getVisibility() != 0) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        if (textView.getVisibility() != 8) {
            textView.setVisibility(8);
        }
    }

    protected void H(lo2.ah ahVar, com.tencent.mobileqq.search.business.net.view.n nVar) {
        if (!TextUtils.isEmpty(ahVar.f415120b0)) {
            nVar.M.setVisibility(0);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = this.f283588d;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mRequestWidth = nVar.M.getLayoutParams().width;
            obtain.mRequestHeight = nVar.M.getLayoutParams().height;
            URLDrawable drawable = URLDrawable.getDrawable(ahVar.f415120b0, obtain);
            nVar.M.setImageDrawable(drawable);
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
        } else {
            nVar.M.setVisibility(8);
        }
        if (!TextUtils.isEmpty(ahVar.f415121c0)) {
            nVar.N.setVisibility(0);
            nVar.N.setText(SearchUtils.J(nVar.N, nVar.N.getContext().getResources().getDisplayMetrics().widthPixels, 1, ahVar.f415121c0, ahVar.P.f285039a, false, false, true));
        } else {
            nVar.N.setVisibility(8);
        }
        if (!TextUtils.isEmpty(ahVar.f415123e0)) {
            nVar.P.setText(ahVar.f415123e0);
            nVar.P.setVisibility(0);
            nVar.Q.setVisibility(0);
        } else {
            nVar.P.setVisibility(8);
            nVar.Q.setVisibility(8);
        }
        if (!TextUtils.isEmpty(ahVar.f415122d0)) {
            nVar.R.setText(ahVar.f415122d0);
            nVar.R.setVisibility(0);
        } else {
            nVar.R.setVisibility(8);
        }
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            TextView textView = nVar.N;
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.acg));
            TextView textView2 = nVar.R;
            textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.acf));
            TextView textView3 = nVar.P;
            textView3.setTextColor(textView3.getContext().getResources().getColor(R.color.acf));
            return;
        }
        nVar.N.setTextColor(Color.parseColor("#262626"));
        nVar.R.setTextColor(Color.parseColor("#737373"));
        nVar.P.setTextColor(Color.parseColor("#737373"));
    }

    public void S(ImageView imageView) {
        Animation loadAnimation;
        if (imageView != null && (loadAnimation = AnimationUtils.loadAnimation(imageView.getContext(), R.anim.f154870el)) != null) {
            loadAnimation.setInterpolator(new LinearInterpolator());
            imageView.startAnimation(loadAnimation);
        }
    }

    @Override // qn2.c
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void f(lo2.m mVar, com.tencent.mobileqq.search.business.net.view.c cVar, Bitmap bitmap) {
        if (cVar.f() != null) {
            cVar.f().setImageBitmap(bitmap);
        }
    }

    @Override // qn2.b
    public void b(v vVar, View view, int i3, int i16) {
        if (vVar instanceof x) {
            am.n(view, i3, com.tencent.mobileqq.search.util.x.d(vVar), com.tencent.mobileqq.search.util.x.h(vVar), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
            View findViewById = view.findViewById(R.id.f166929j61);
            x xVar = (x) vVar;
            List<lo2.al> list = xVar.f415307g0;
            if (findViewById != null && list != null && list.size() > 0) {
                am.n(findViewById, i3 + 1, com.tencent.mobileqq.search.util.x.d(vVar), String.valueOf(20), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
            }
            View findViewById2 = view.findViewById(R.id.bxy);
            if (findViewById2 != null) {
                am.r(findViewById2, String.valueOf(xVar.getTitleSpans()), com.tencent.mobileqq.search.util.x.e(vVar), "", 0, vVar.e(), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
            }
        } else if (vVar instanceof lo2.m) {
            lo2.m mVar = (lo2.m) vVar;
            long j3 = mVar.J;
            if (j3 != 1105 && j3 != 1106) {
                if (j3 != Constant.FROM_ID_START_ACTIVITY && !mVar.P()) {
                    if (j3 == 1701) {
                        View findViewById3 = view.findViewById(R.id.dqx);
                        if (findViewById3 != null) {
                            lo2.m mVar2 = (lo2.m) vVar;
                            am.t(findViewById3, String.valueOf(mVar.getTitleSpans()), com.tencent.mobileqq.search.util.x.e(vVar), mVar.z(), i3, vVar.e(), String.valueOf(vVar.hashCode()), vVar.getRecallReason(), null, mVar2.y());
                            am.k(findViewById3, mVar2.x());
                        }
                    } else if (j3 == 1108) {
                        View findViewById4 = view.findViewById(R.id.f80974cx);
                        if (findViewById4 != null) {
                            String valueOf = String.valueOf(22);
                            am.j(i3, "1", valueOf);
                            VideoReport.setElementParams(findViewById4, am.g(valueOf));
                            ((ISearchGuildDaTongApi) QRoute.api(ISearchGuildDaTongApi.class)).reportDaTongForGuildItem(findViewById4, vVar, i3);
                        }
                        am.k(view, 22);
                    } else {
                        if (j3 == 1109) {
                            o(mVar, view, i3, R.id.f80914cr);
                            return;
                        }
                        if (j3 != 1111 && j3 != 1114 && j3 != 1115 && j3 != 1116) {
                            if (j3 == 1110) {
                                am.n(view, i3, com.tencent.mobileqq.search.util.x.d(vVar), com.tencent.mobileqq.search.util.x.h(vVar), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
                                return;
                            } else {
                                if (j3 == 1117) {
                                    am.n(view, i3, com.tencent.mobileqq.search.util.x.d(vVar), com.tencent.mobileqq.search.util.x.h(vVar), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
                                    VideoReport.setElementParam(view, "is_manual_operation", 0);
                                    VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
                                    return;
                                }
                                return;
                            }
                        }
                        if (view != null) {
                            lo2.m mVar3 = (lo2.m) vVar;
                            am.t(view, String.valueOf(mVar.getTitleSpans()), com.tencent.mobileqq.search.util.x.e(vVar), mVar.z(), i3, vVar.e(), String.valueOf(vVar.hashCode()), vVar.getRecallReason(), null, mVar3.y());
                            am.k(view, mVar3.x());
                            if (j3 == 1111 && !TextUtils.isEmpty(mVar3.M)) {
                                am.u(view, mVar3.M);
                            }
                        }
                    }
                } else {
                    am.r(view, String.valueOf(mVar.getTitleSpans()), com.tencent.mobileqq.search.util.x.e(vVar), mVar.z(), i3, vVar.e(), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
                    if (j3 == Constant.FROM_ID_START_ACTIVITY) {
                        am.k(view, ((lo2.m) vVar).x());
                    }
                }
            } else {
                String h16 = com.tencent.mobileqq.search.util.x.h(vVar);
                am.n(view, i3, com.tencent.mobileqq.search.util.x.d(vVar), h16, String.valueOf(vVar.hashCode()), vVar.getRecallReason());
                Q(view, j3, h16, ((lo2.m) vVar).Q);
            }
        }
    }

    @Override // com.tencent.mobileqq.music.g
    public String getToken() {
        return QQPlayerService.Y(7, ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin());
    }

    @Override // qn2.d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void a(lo2.m mVar, com.tencent.mobileqq.search.business.net.view.c cVar) {
        rn2.k.c(mVar.p(), mVar.q(), cVar.getView(), mVar.V, mVar.f283548i, mVar.f283549m);
        switch (mVar.J()) {
            case 2:
                j((lo2.j) mVar, (lo2.k) cVar);
                break;
            case 3:
                M((aj) mVar, (p) cVar);
                break;
            case 4:
                k((lo2.l) mVar, (com.tencent.mobileqq.search.business.net.view.b) cVar);
                break;
            case 6:
                L((ai) mVar, (com.tencent.mobileqq.search.business.net.view.o) cVar);
                break;
            case 7:
                s((ad) mVar, (com.tencent.mobileqq.search.view.h) cVar);
                break;
            case 8:
                C((ae) mVar, (o) cVar);
                break;
            case 9:
                D((af) mVar, (com.tencent.mobileqq.search.view.n) cVar);
                break;
            case 11:
                q((r) mVar, (com.tencent.mobileqq.search.business.net.view.h) cVar);
                break;
            case 12:
                l((lo2.n) mVar, (com.tencent.mobileqq.search.business.net.view.d) cVar);
                break;
            case 13:
                r((ac) mVar, (com.tencent.mobileqq.search.view.g) cVar);
                break;
            case 14:
                H((lo2.ah) mVar, (com.tencent.mobileqq.search.business.net.view.n) cVar);
                break;
            case 15:
                B((y) mVar, (com.tencent.mobileqq.search.view.m) cVar);
                break;
            case 16:
                v((lo2.w) mVar, (com.tencent.mobileqq.search.view.k) cVar);
                break;
            case 17:
                x((x) mVar, (com.tencent.mobileqq.search.view.l) cVar);
                break;
            case 18:
                w((com.tencent.mobileqq.search.model.ah) mVar, (com.tencent.mobileqq.search.business.net.view.l) cVar);
                break;
            case 19:
                u((com.tencent.mobileqq.search.model.af) mVar, (com.tencent.mobileqq.search.view.i) cVar);
                break;
            case 20:
                Bundle bundle = new Bundle();
                bundle.putInt(ISearchBindView.GUILD_SEARCH_ITEM_INT_FROM_TYPE, this.f283593m.f410661m);
                bundle.putBoolean(ISearchBindView.GUILD_SEARCH_ITEM_BOOLEAN_SHOW_GUILD, GuildInjectImpl.L());
                ((ISearchBindView) QRoute.api(ISearchBindView.class)).bindNetSearchGuildItemView((t) mVar, (go2.g) cVar, bundle);
                break;
            case 21:
                ((ISearchBindView) QRoute.api(ISearchBindView.class)).bindNetSearchGameView((s) mVar, (com.tencent.mobileqq.search.business.game.e) cVar);
                break;
            case 23:
                ((com.tencent.mobileqq.search.business.qcircle.video.base.b) cVar).p((lo2.ac) mVar);
                break;
            case 24:
                ((yo2.a) cVar).r((ag) mVar);
                break;
            case 25:
                ((com.tencent.mobileqq.search.business.net.view.g) cVar).p((q) mVar);
                break;
            case 26:
                ((com.tencent.mobileqq.search.business.net.view.k) cVar).p((lo2.v) mVar);
                break;
            case 27:
                ((com.tencent.mobileqq.search.model.ai) cVar).p((NetSearchTemplateUsedMiniAppItem) mVar);
                break;
            case 28:
                ((com.tencent.mobileqq.search.business.qcircle.video.game.union.a) cVar).p((lo2.h) mVar, mVar.e());
                break;
            case 29:
                ((NetSearchTemplateSearchSuggestView) cVar).r((lo2.ad) mVar, FTSEntitySearchFragment.class);
                break;
        }
        i(mVar, cVar);
        mVar.Q();
        if (TextUtils.isEmpty(mVar.W)) {
            c(mVar, cVar);
        }
    }

    protected void i(lo2.m mVar, com.tencent.mobileqq.search.business.net.view.c cVar) {
        if (cVar.getView() != null) {
            cVar.getView().setOnClickListener(new a(mVar, cVar));
        }
    }

    protected void m(lo2.m mVar, View view, int i3) {
        am.r(view, String.valueOf(mVar.getTitleSpans()), com.tencent.mobileqq.search.util.x.e(mVar), mVar.z(), i3, mVar.e(), String.valueOf(mVar.hashCode()), mVar.getRecallReason());
    }

    @Override // com.tencent.mobileqq.music.g
    public void onPlayStateChanged(int i3) {
        final ImageView imageView;
        WeakReference<ImageView> weakReference = this.f283592i;
        if (weakReference == null || weakReference.get() == null || (imageView = this.f283592i.get()) == null) {
            return;
        }
        final boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        Resources resources = imageView.getContext().getResources();
        if (i3 == 1) {
            imageView.post(new Runnable() { // from class: com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.10
                @Override // java.lang.Runnable
                public void run() {
                    if (isNowThemeIsNight) {
                        imageView.setImageResource(R.drawable.bxf);
                    } else {
                        imageView.setImageResource(R.drawable.bxe);
                    }
                    SearchTemplatePresenter.this.S(imageView);
                }
            });
            return;
        }
        if (i3 == 2) {
            imageView.getContext();
            ((Integer) imageView.getTag()).intValue();
            SearchUtils.f284954c = this.f283591h;
            imageView.post(new Runnable() { // from class: com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.11
                @Override // java.lang.Runnable
                public void run() {
                    imageView.clearAnimation();
                    if (isNowThemeIsNight) {
                        imageView.setImageResource(R.drawable.bxj);
                    } else {
                        imageView.setImageResource(R.drawable.bxi);
                    }
                }
            });
            imageView.setContentDescription(resources.getString(R.string.f170493st));
            this.f283593m.notifyDataSetChanged();
            return;
        }
        imageView.post(new Runnable() { // from class: com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.12
            @Override // java.lang.Runnable
            public void run() {
                imageView.clearAnimation();
                if (isNowThemeIsNight) {
                    imageView.setImageResource(R.drawable.bxh);
                } else {
                    imageView.setImageResource(R.drawable.bxg);
                }
            }
        });
        imageView.setContentDescription(resources.getString(R.string.f170491sr));
    }

    @Override // qn2.c
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void c(lo2.m mVar, com.tencent.mobileqq.search.business.net.view.c cVar) {
        if (cVar.f() != null && (mVar instanceof com.tencent.mobileqq.search.model.t) && !TextUtils.isEmpty(mVar.getUin())) {
            cVar.f().setImageDrawable(SearchUtils.u(this.f283590f, mVar));
        }
    }

    protected void r(ac acVar, com.tencent.mobileqq.search.view.g gVar) {
        ArrayList<u> arrayList = acVar.f283475i0;
        if (arrayList != null && arrayList.size() != 0) {
            jn2.g gVar2 = (jn2.g) gVar.M.getAdapter();
            if (gVar2 == null || gVar2.d() != acVar.f283475i0) {
                gVar2 = new jn2.g(acVar, this.f283593m.f410661m, gVar.M);
                gVar.M.setAdapter((ListAdapter) gVar2);
            }
            if (gVar2.d() != acVar.f283475i0) {
                gVar.N = acVar;
                gVar.M.resetCurrentX(acVar.f283476j0);
            }
            gVar2.setData(acVar.f283475i0);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
        }
    }

    protected void s(ad adVar, com.tencent.mobileqq.search.view.h hVar) {
        hVar.getView().getContext();
        hVar.getView();
        ArrayList<u> arrayList = adVar.f283479c0;
        if (arrayList != null && arrayList.size() != 0) {
            hVar.p(adVar);
            if (adVar.f283479c0.size() != hVar.M.size()) {
                QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
            }
            int size = adVar.f283479c0.size();
            for (int i3 = 0; i3 < size; i3++) {
                adVar.f283479c0.get(i3).W(hVar.M.get(i3));
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
        }
    }

    protected void u(com.tencent.mobileqq.search.model.af afVar, com.tencent.mobileqq.search.view.i iVar) {
        List<u> list = afVar.f283492b0;
        if (list != null && list.size() != 0) {
            iVar.p(afVar);
            if (afVar.f283492b0.size() != iVar.M.size()) {
                QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindIndividualContainerTemplateView, vas_search, view.size != model.size");
            }
            int size = afVar.f283492b0.size();
            for (int i3 = 0; i3 < size; i3++) {
                afVar.f283492b0.get(i3).W(iVar.M.get(i3));
                m(afVar.f283492b0.get(i3), iVar.M.get(i3).getView(), i3);
            }
            afVar.W(size);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindIndividualContainerTemplateView, vas_search, containerItem.horizontalModelItems is empty");
        }
    }

    protected void w(com.tencent.mobileqq.search.model.ah ahVar, com.tencent.mobileqq.search.business.net.view.l lVar) {
        String str;
        LinearLayout linearLayout = (LinearLayout) lVar.p();
        if (linearLayout != null && ahVar.f283512b0 != null) {
            linearLayout.removeAllViews();
            if (linearLayout.getParent() != null) {
                ((View) linearLayout.getParent()).setPadding(0, 0, 0, 0);
            }
            up2.a aVar = ahVar.f283512b0;
            Context context = lVar.getView().getContext();
            View inflate = LayoutInflater.from(context).inflate(R.layout.bxw, (ViewGroup) null);
            io2.b bVar = new io2.b(inflate);
            View findViewById = inflate.findViewById(R.id.dpr);
            int dip2px = ViewUtils.dip2px(6.0f);
            findViewById.setPadding(0, dip2px, 0, dip2px);
            linearLayout.addView(inflate);
            if (aVar.getDescription() == null) {
                if (bVar.k() != null) {
                    bVar.k().setVisibility(8);
                }
                if (bVar.b() != null) {
                    bVar.b().setVisibility(8);
                }
                URLImageView q16 = bVar.q();
                if (q16 != null) {
                    q16.setVisibility(8);
                }
                TextView p16 = bVar.p();
                if (p16 != null) {
                    p16.setVisibility(0);
                    if (!TextUtils.isEmpty(aVar.getTitleSpans())) {
                        p16.setText(aVar.getTitleSpans());
                    }
                }
            } else {
                if (bVar.k() != null && !TextUtils.isEmpty(aVar.getDescription())) {
                    bVar.k().setVisibility(0);
                    bVar.k().setText(aVar.getDescription());
                } else if (bVar.k() != null) {
                    bVar.k().setVisibility(8);
                }
                if (bVar.b() != null) {
                    bVar.b().setVisibility(0);
                }
                TextView p17 = bVar.p();
                if (p17 != null) {
                    p17.setVisibility(8);
                }
                if (!TextUtils.isEmpty(aVar.getTitleSpans())) {
                    bVar.b().setText(aVar.getTitleSpans());
                }
            }
            if (bVar.f() != null && !TextUtils.isEmpty(aVar.U())) {
                String U = aVar.U();
                ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = com.tencent.mobileqq.util.x.c(context, 50.0f);
                obtain.mRequestHeight = com.tencent.mobileqq.util.x.c(context, 50.0f);
                obtain.mFailedDrawable = colorDrawable;
                obtain.mLoadingDrawable = colorDrawable;
                if (URLUtil.isValidUrl(U)) {
                    URLDrawable drawable = URLDrawable.getDrawable(U, obtain);
                    drawable.setTag(com.tencent.mobileqq.urldrawable.a.c(com.tencent.mobileqq.util.x.c(context, 50.0f), com.tencent.mobileqq.util.x.c(lVar.getView().getContext(), 50.0f), com.tencent.mobileqq.util.x.c(context, 3.0f)));
                    drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                    bVar.f().setImageDrawable(drawable);
                    if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                        drawable.restartDownload();
                    }
                } else {
                    bVar.f().setImageDrawable(colorDrawable);
                }
            }
            bVar.getView().setOnClickListener(new b(aVar, lVar));
            if (bVar.q() != null && aVar.R()) {
                String S = aVar.S();
                ColorDrawable colorDrawable2 = new ColorDrawable(Color.parseColor("#e7e7e7"));
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                obtain2.mRequestWidth = com.tencent.mobileqq.util.x.c(context, 40.0f);
                obtain2.mRequestHeight = com.tencent.mobileqq.util.x.c(context, 12.0f);
                obtain2.mFailedDrawable = colorDrawable2;
                obtain2.mLoadingDrawable = colorDrawable2;
                URLDrawable drawable2 = URLDrawable.getDrawable(S, obtain2);
                drawable2.setTag(com.tencent.mobileqq.urldrawable.a.c(com.tencent.mobileqq.util.x.c(context, 38.0f), com.tencent.mobileqq.util.x.c(context, 12.0f), 0));
                drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                bVar.q().setImageDrawable(drawable2);
                if (drawable2.getStatus() != 1 && drawable2.getStatus() != 0) {
                    drawable2.restartDownload();
                }
            }
            SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo = new SimpleMiniAppConfig.SimpleMiniAppInfo();
            simpleMiniAppInfo.appId = aVar.X.appId;
            SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(simpleMiniAppInfo);
            if (aVar.X.showMask == 1) {
                str = "used";
            } else {
                str = "unused";
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async(simpleMiniAppConfig, "search", "result_view", str, aVar.getKeyword());
        }
    }

    public void z(Context context, SquareImageView squareImageView, ImageView imageView, TextView textView, int i3, String str, String str2, int i16) {
        switch (i3) {
            case 1:
                A(squareImageView, imageView, textView, i16, i16, false, str, null, 0, false);
                return;
            case 2:
                A(squareImageView, imageView, textView, i16, (int) (i16 * 1.4f), false, str, null, 0, false);
                return;
            case 3:
                A(squareImageView, imageView, textView, i16, i16, false, str, null, R.drawable.des, false);
                return;
            case 4:
                A(squareImageView, imageView, textView, i16, i16, false, str, null, R.drawable.des, false);
                return;
            case 5:
                A(squareImageView, imageView, textView, i16, i16, false, str, null, 0, true);
                return;
            case 6:
                A(squareImageView, imageView, textView, com.tencent.mobileqq.util.x.c(context, 100.0f), com.tencent.mobileqq.util.x.c(context, 62.0f), false, str, null, R.drawable.des, false);
                return;
            case 7:
                A(squareImageView, imageView, textView, com.tencent.mobileqq.util.x.c(context, 100.0f), com.tencent.mobileqq.util.x.c(context, 62.0f), false, str, str2, 0, false);
                return;
            case 8:
                A(squareImageView, imageView, textView, com.tencent.mobileqq.util.x.c(context, 100.0f), com.tencent.mobileqq.util.x.c(context, 62.0f), false, str, null, 0, false);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.music.g
    public void onPlaySongChanged(SongInfo songInfo) {
    }
}
