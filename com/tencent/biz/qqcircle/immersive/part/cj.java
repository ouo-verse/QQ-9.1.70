package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.QFSWorkSuggestionsFragment;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cj extends u implements View.OnClickListener {
    private TextView C;
    private LinearLayout D;
    private LinearLayout E;
    private AnimatorSet F;
    private boolean G;
    private int H;
    private QQCircleFeedBase$StReportInfoForClient I;

    /* renamed from: d, reason: collision with root package name */
    private final QCircleLayerBean f87824d;

    /* renamed from: e, reason: collision with root package name */
    private e30.b f87825e;

    /* renamed from: f, reason: collision with root package name */
    private ViewStub f87826f;

    /* renamed from: h, reason: collision with root package name */
    private View f87827h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f87828i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f87829m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends QFSAsyncUtils.Callback<Void, Void> {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            VideoReport.clearElementExposure(cj.this.D, false);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            cj.this.R9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends QFSAsyncUtils.Callback<Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f87832a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f87833b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f87834c;

        c(View view, String str, d dVar) {
            this.f87832a = view;
            this.f87833b = str;
            this.f87834c = dVar;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            VideoReport.setElementId(this.f87832a, this.f87833b);
            VideoReport.setEventDynamicParams(this.f87832a, this.f87834c);
            VideoReport.setElementExposePolicy(this.f87832a, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(this.f87832a, ClickPolicy.REPORT_ALL);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<cj> f87836a;

        public d(cj cjVar) {
            this.f87836a = new WeakReference<>(cjVar);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            WeakReference<cj> weakReference = this.f87836a;
            if (weakReference != null && weakReference.get() != null) {
                return this.f87836a.get().C9();
            }
            return null;
        }
    }

    public cj(QCircleLayerBean qCircleLayerBean) {
        this.f87824d = qCircleLayerBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> C9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.d(this.f87825e));
        e30.b bVar = this.f87825e;
        if (bVar != null && bVar.g() != null && this.f87825e.g().poster != null) {
            buildElementParams.put("xsj_target_qq", this.f87825e.g().poster.f398463id.get());
            QQCircleFeedBase$StReportInfoForClient G9 = G9();
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_TYPE3, Integer.valueOf(G9.feedtype3.get()));
            if (!TextUtils.isEmpty(G9.datongJsonData.get())) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, G9.datongJsonData.get());
            }
        }
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        if (buildElementParams.containsKey(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID)) {
            QLog.d("QFSLayerPageBottomVisitCountPart", 1, "element param key : xsj_layer_page_ref_eid = " + buildElementParams.get(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID));
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.H + 1));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
        return buildElementParams;
    }

    private void D9() {
        ViewStub viewStub = this.f87826f;
        if (viewStub != null && !this.G) {
            View inflate = viewStub.inflate();
            this.G = true;
            this.f87827h = inflate.findViewById(R.id.f45401rs);
            this.f87829m = (TextView) inflate.findViewById(R.id.f45381rq);
            this.f87828i = (ImageView) inflate.findViewById(R.id.f45331rl);
            TextView textView = (TextView) inflate.findViewById(R.id.f45501s2);
            this.C = textView;
            textView.setOnClickListener(this);
            Q9(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA_SET_RIGHT_BUTTON);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f44801q6);
            this.D = linearLayout;
            linearLayout.setOnClickListener(this);
            Q9(this.D, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA_DATA_GUIDE_BUTTON);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.f44811q7);
            this.E = linearLayout2;
            linearLayout2.setOnClickListener(this);
            Q9(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA_DATA_GUIDE_BUTTON);
            VideoReport.setElementParam(this.E, QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, "advise");
        }
    }

    private ObjectAnimator E9(View view, String str) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, str, 1.0f, 1.1f, 1.0f).setDuration(1000L);
        duration.setStartDelay(900L);
        duration.setRepeatCount(5);
        duration.setRepeatMode(1);
        return duration;
    }

    private String F9() {
        QCircleReportBean fromReportBean;
        QCircleLayerBean qCircleLayerBean = this.f87824d;
        if (qCircleLayerBean == null) {
            fromReportBean = null;
        } else {
            fromReportBean = qCircleLayerBean.getFromReportBean();
        }
        if (fromReportBean == null) {
            return null;
        }
        return fromReportBean.getDtPageId();
    }

    private boolean I9() {
        e30.b bVar = this.f87825e;
        if (bVar != null && bVar.g() != null && this.f87825e.g().f398449id.get() != null && this.f87825e.g().f398449id.get().contains("share_fake_")) {
            return true;
        }
        return false;
    }

    private boolean J9() {
        e30.b bVar = this.f87825e;
        if (bVar != null && bVar.g() != null && this.f87825e.g().urlInfo.get() != null && this.f87825e.g().urlInfo.size() > 0 && !I9() && this.f87825e.g().visitorInfo.advice_desc.get().isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean K9() {
        e30.b bVar = this.f87825e;
        if (bVar != null && bVar.g() != null && !I9() && !this.f87825e.g().visitorInfo.advice_desc.get().isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean L9() {
        e30.b bVar = this.f87825e;
        if (bVar != null && bVar.g().opMask2.get().contains(22) && ((getReportBean().getFromPageId() != 80000 || !com.tencent.biz.qqcircle.immersive.utils.r.o0(this.f87825e.g())) && !M9())) {
            return true;
        }
        return false;
    }

    private boolean M9() {
        return TextUtils.equals(F9(), QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit N9(QFSWorkSuggestionsFragment qFSWorkSuggestionsFragment) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_custom_pgid", getReportBean().getDtPageId());
        qFSWorkSuggestionsFragment.Lh(buildElementParams);
        qFSWorkSuggestionsFragment.Ih(String.valueOf(this.f87825e.g().f398449id.get()));
        qFSWorkSuggestionsFragment.Hh(this.f87825e.g().createTime.get());
        return Unit.INSTANCE;
    }

    private void O9() {
        if (!J9()) {
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.g(getActivity(), com.tencent.biz.qqcircle.utils.bh.d(this.f87825e.g().urlInfo.get(), "creator_data"));
    }

    private void P9() {
        QFSWorkSuggestionsFragment.INSTANCE.a(getHostFragment().getParentFragmentManager(), new Function1() { // from class: com.tencent.biz.qqcircle.immersive.part.ci
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit N9;
                N9 = cj.this.N9((QFSWorkSuggestionsFragment) obj);
                return N9;
            }
        });
    }

    private void Q9(View view, String str) {
        if (view == null) {
            return;
        }
        QFSAsyncUtils.executeSub(new c(view, str, new d(this)), new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9() {
        uq3.k.b().j("key_sp_show_data_suggestions_icon_anim", true);
    }

    private boolean S9() {
        if (this.E == null || I9()) {
            return false;
        }
        return !uq3.k.b().c("key_sp_show_data_suggestions_icon_anim", false);
    }

    private void T9() {
        LinearLayout linearLayout = this.E;
        if (linearLayout != null && this.F == null) {
            ObjectAnimator E9 = E9(linearLayout, BasicAnimation.KeyPath.SCALE_X);
            ObjectAnimator E92 = E9(this.E, BasicAnimation.KeyPath.SCALE_Y);
            AnimatorSet animatorSet = new AnimatorSet();
            this.F = animatorSet;
            animatorSet.playTogether(E9, E92);
            this.F.addListener(new b());
            this.F.start();
        }
    }

    private void U9(boolean z16) {
        int i3;
        int e16 = uq3.k.b().e("key_sp_show_data_analyze_icon_anim_count", 0);
        QLog.d("QFSLayerPageBottomVisitCountPart", 1, "[updateDataAnalyzeIconAnimCount] count: " + e16);
        uq3.k b16 = uq3.k.b();
        if (z16) {
            i3 = 3;
        } else {
            i3 = e16 + 1;
        }
        b16.m("key_sp_show_data_analyze_icon_anim_count", i3);
    }

    private void V9() {
        int i3;
        if (this.f87828i != null && this.f87829m != null) {
            e30.b bVar = this.f87825e;
            if (bVar != null && bVar.g() != null && this.f87825e.g().visitorInfo != null) {
                i3 = this.f87825e.g().visitorInfo.viewCount.get();
            } else {
                i3 = 0;
            }
            if (i3 > 0 && QCirclePluginUtil.isFeedOwner(this.f87825e.g())) {
                String str = com.tencent.biz.qqcircle.immersive.utils.r.f(i3) + uq3.c.D4();
                this.f87829m.getLayoutParams().width = ((int) Math.ceil(this.f87829m.getPaint().measureText(str))) + this.f87829m.getPaddingLeft() + this.f87829m.getPaddingRight() + com.tencent.biz.qqcircle.utils.cx.a(2.0f);
                this.f87829m.setText(str);
                this.f87828i.setVisibility(0);
                this.f87829m.setVisibility(0);
                return;
            }
            this.f87828i.setVisibility(8);
            this.f87829m.setVisibility(8);
            return;
        }
        QLog.e("QFSLayerPageBottomVisitCountPart", 1, "[updateVisitCountVisibility] mVisitCountIcon == null");
    }

    @SuppressLint({"SetTextI18n"})
    private void updateView() {
        D9();
        if (L9()) {
            if (I9()) {
                this.f87827h.setVisibility(8);
            } else {
                this.f87827h.setVisibility(0);
                V9();
            }
            if (this.D != null) {
                if (J9()) {
                    this.D.setVisibility(0);
                } else {
                    this.D.setVisibility(8);
                }
            }
            if (this.E != null) {
                if (K9()) {
                    this.E.setVisibility(0);
                    ((TextView) this.E.findViewById(R.id.f44821q8)).setText(this.f87825e.g().visitorInfo.advice_desc.get());
                    if (S9()) {
                        T9();
                    }
                } else {
                    this.E.setVisibility(8);
                }
            }
            broadcastMessage("layer_notify_visit_count_part_show", null);
            return;
        }
        this.f87827h.setVisibility(8);
        broadcastMessage("layer_notify_visit_count_part_gone", null);
    }

    public QQCircleFeedBase$StReportInfoForClient G9() {
        if (this.I == null) {
            H9();
        }
        return this.I;
    }

    public void H9() {
        this.I = new QQCircleFeedBase$StReportInfoForClient();
        e30.b bVar = this.f87825e;
        if (bVar != null && bVar.g() != null && this.f87825e.g().reportInfoForClient.get() != null) {
            try {
                this.I.mergeFrom(this.f87825e.g().reportInfoForClient.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.w("QFSLayerPageBottomVisitCountPart", 1, "[buildFeedReportInfoMap] InvalidProtocolBufferMicroException");
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerPageBottomVisitCountPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        super.handleBroadcastMessage(str, obj);
        if ("layer_notify_part_update_feed".equals(str)) {
            if (!(obj instanceof e30.b)) {
                return;
            }
            e30.b bVar = (e30.b) obj;
            this.f87825e = bVar;
            if (bVar != null && bVar.g() != null) {
                feedCloudMeta$StFeed = this.f87825e.g();
            } else {
                QCircleLayerBean qCircleLayerBean = this.f87824d;
                if (qCircleLayerBean != null) {
                    feedCloudMeta$StFeed = qCircleLayerBean.getFeed();
                } else {
                    feedCloudMeta$StFeed = null;
                }
            }
            this.f87825e = new e30.b(feedCloudMeta$StFeed);
            H9();
            updateView();
            return;
        }
        if (!"layer_notify_part_update_feed_index".equals(str) || !(obj instanceof Integer)) {
            return;
        }
        this.H = ((Integer) obj).intValue();
        LinearLayout linearLayout = this.D;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            QFSAsyncUtils.executeSub(new a(), new Void[0]);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.f45501s2) {
                broadcastMessage("layer_open_setting_permission_window", this.f87825e);
            } else if (id5 == R.id.f44801q6) {
                O9();
                U9(true);
            } else if (id5 == R.id.f44811q7) {
                P9();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f87826f = (ViewStub) view.findViewById(R.id.f45391rr);
        this.G = false;
    }
}
