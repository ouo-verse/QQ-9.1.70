package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCircleVideoRateEvent;
import com.tencent.biz.qqcircle.events.QFSBarrageSwitchEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cb;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class QFSShareBottomPlayRateView extends FrameLayout {
    private Switch C;
    private View D;
    private View E;

    /* renamed from: d, reason: collision with root package name */
    private View f93424d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleShareInfo f93425e;

    /* renamed from: f, reason: collision with root package name */
    private b f93426f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f93427h;

    /* renamed from: i, reason: collision with root package name */
    private d f93428i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f93429m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            int i3;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            int i16 = 1;
            QLog.d("QFSShareBottomPlayRateView", 1, "switchBarrage isBarrageOpen before: ", Boolean.valueOf(com.tencent.biz.qqcircle.manager.d.b().d()), ", after: ", Boolean.valueOf(z16));
            if (z16) {
                i3 = R.string.f1902141h;
            } else {
                i3 = R.string.f1902241i;
            }
            QCircleToast.h(i3, 0);
            com.tencent.biz.qqcircle.manager.d.b().h(z16);
            if (!z16) {
                i16 = 2;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSBarrageSwitchEvent(i16));
            if (QFSShareBottomPlayRateView.this.f93426f != null) {
                QFSShareBottomPlayRateView.this.f93426f.onClick();
            }
            QFSShareBottomPlayRateView.this.e(z16, "ev_xsj_sharepanel_action");
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends BaseWidgetView<e> {

        /* renamed from: d, reason: collision with root package name */
        private TextView f93431d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f93433d;

            a(e eVar) {
                this.f93433d = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                c.this.n0(this.f93433d);
                QFSShareBottomPlayRateView.this.f(true, "ev_xsj_sharepanel_action", view);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public c(@NonNull Context context) {
            super(context);
            this.f93431d = (TextView) findViewById(R.id.f31780rz);
            com.tencent.biz.qqcircle.immersive.utils.r.M0(getContext(), this.f93431d);
        }

        private void l0(e eVar) {
            this.f93431d.setOnClickListener(new a(eVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(e eVar) {
            if (eVar != null) {
                String str = eVar.f93438c;
                if (!TextUtils.isEmpty(str)) {
                    if ((eVar.f93437b == 1.5f || eVar.f93437b == 2.0f) && cb.c() && !cb.a()) {
                        QCircleToast.j(QCircleToast.f91644d, QCircleApplication.getAPP().getResources().getString(R.string.f193654_s, gb0.b.s(eVar.f93437b)), 0);
                        cb.h();
                        if (QFSShareBottomPlayRateView.this.h() != null && QFSShareBottomPlayRateView.this.h().mReportBean != null) {
                            cb.g(this.f93431d, QCircleDaTongConstant.ElementId.EM_XSJ_SPEED_GUIDE_TOAST, QFSShareBottomPlayRateView.this.h().feed, QFSShareBottomPlayRateView.this.h().mReportBean.getDtPageId());
                        } else {
                            QLog.d("QFSShareBottomPlayRateView", 1, "onRateItemClick shareInfo is empty");
                            return;
                        }
                    } else {
                        QCircleToast.j(QCircleToast.f91644d, QCircleApplication.getAPP().getResources().getString(R.string.f193644_r, str), 0);
                    }
                }
                QCirclePluginGlobalInfo.k0(QFSShareBottomPlayRateView.this.f93425e.feed.f398449id.get(), eVar.f93437b);
                QCircleVideoRateEvent qCircleVideoRateEvent = new QCircleVideoRateEvent(QFSShareBottomPlayRateView.this.f93425e.feed.f398449id.get(), eVar.f93437b);
                QLog.d("QFSShareBottomPlayRateView", 1, "onRateItemClick QCircleVideoRateEvent:" + qCircleVideoRateEvent);
                SimpleEventBus.getInstance().dispatchEvent(qCircleVideoRateEvent);
                if (QFSShareBottomPlayRateView.this.f93426f != null) {
                    QFSShareBottomPlayRateView.this.f93426f.onClick();
                }
                QFSShareBottomPlayRateView.this.l(eVar.f93437b);
                return;
            }
            QLog.d("QFSShareBottomPlayRateView", 1, "onRateItemClick rateData is np");
        }

        @Override // com.tencent.biz.richframework.widget.BaseWidgetView
        public int getLayoutId() {
            return R.layout.g4z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.widget.BaseWidgetView
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void bindData(e eVar, int i3) {
            this.f93431d.setText(eVar.d());
            if (eVar.f93439d) {
                this.f93431d.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_brand_standard));
            } else {
                this.f93431d.setTextColor(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_primary));
            }
            this.f93431d.getPaint().setFakeBoldText(true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f93431d.getLayoutParams();
            layoutParams.width = DisplayUtil.getScreenWidth() - (DisplayUtil.dip2px(getContext(), 116.0f) / 4);
            layoutParams.gravity = 21;
            this.f93431d.setLayoutParams(layoutParams);
            l0(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class d extends RecyclerView.Adapter<f> {

        /* renamed from: m, reason: collision with root package name */
        private List<e> f93435m = new ArrayList();

        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f93435m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull f fVar, int i3) {
            fVar.l(this.f93435m.get(i3), i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public f onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            return new f(new c(viewGroup.getContext()));
        }

        public void setDataList(List<e> list) {
            this.f93435m.clear();
            this.f93435m.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        private String f93436a;

        /* renamed from: b, reason: collision with root package name */
        private float f93437b;

        /* renamed from: c, reason: collision with root package name */
        private String f93438c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f93439d;

        e() {
        }

        public String d() {
            return this.f93436a;
        }

        public e e(boolean z16) {
            this.f93439d = z16;
            return this;
        }

        public e f(float f16) {
            this.f93437b = f16;
            return this;
        }

        public e g(String str) {
            this.f93436a = str;
            return this;
        }

        public e h(String str) {
            this.f93438c = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class f extends RecyclerView.ViewHolder {
        private c E;

        public f(@NonNull View view) {
            super(view);
            this.E = (c) view;
        }

        public void l(e eVar, int i3) {
            this.E.bindData(eVar, i3);
        }
    }

    public QFSShareBottomPlayRateView(@NonNull Context context) {
        super(context);
        j();
    }

    private String g(float f16) {
        if (f16 == 0.5f) {
            return "1";
        }
        if (f16 == 1.5f) {
            return "3";
        }
        if (f16 == 2.0f) {
            return "4";
        }
        return "2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QCircleShareInfo h() {
        return this.f93425e;
    }

    private void i() {
        this.D = this.f93424d.findViewById(R.id.f75343yp);
        this.E = this.f93424d.findViewById(R.id.bmt);
        Switch r06 = (Switch) this.f93424d.findViewById(R.id.f34170yf);
        this.C = r06;
        if (r06 == null) {
            QLog.e("QFSShareBottomPlayRateView", 1, "[initBottomBarrageView] mBarrageSwitch should not be null");
            return;
        }
        n();
        this.C.setChecked(com.tencent.biz.qqcircle.manager.d.b().d());
        this.C.setOnCheckedChangeListener(new a());
    }

    private void j() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g5p, (ViewGroup) this, true);
        this.f93424d = inflate;
        this.f93429m = (LinearLayout) inflate.findViewById(R.id.f54542fh);
        com.tencent.biz.qqcircle.immersive.utils.r.M0(getContext(), this.f93429m);
        this.f93427h = (RecyclerView) this.f93424d.findViewById(R.id.f31790s0);
        SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(getContext(), 4);
        safeGridLayoutManager.setOrientation(1);
        this.f93427h.setLayoutManager(safeGridLayoutManager);
        d dVar = new d();
        this.f93428i = dVar;
        this.f93427h.setAdapter(dVar);
        i();
    }

    private boolean k() {
        if (h() != null && com.tencent.biz.qqcircle.manager.d.b().e(h().feed)) {
            return true;
        }
        return false;
    }

    private void m() {
        boolean z16;
        boolean z17;
        boolean z18;
        ArrayList arrayList = new ArrayList();
        e f16 = new e().g(com.tencent.biz.qqcircle.utils.h.a(R.string.f193484_b)).h(com.tencent.biz.qqcircle.utils.h.a(R.string.f193504_d)).f(0.5f);
        boolean z19 = true;
        if (this.f93425e.mPlayRate == 0.5f) {
            z16 = true;
        } else {
            z16 = false;
        }
        arrayList.add(f16.e(z16));
        e h16 = new e().g(com.tencent.biz.qqcircle.utils.h.a(R.string.f193554_i)).f(1.0f).h(com.tencent.biz.qqcircle.utils.h.a(R.string.f193544_h));
        if (this.f93425e.mPlayRate == 1.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        arrayList.add(h16.e(z17));
        e h17 = new e().g(com.tencent.biz.qqcircle.utils.h.a(R.string.f193564_j)).f(1.5f).h(com.tencent.biz.qqcircle.utils.h.a(R.string.f193584_l));
        if (this.f93425e.mPlayRate == 1.5f) {
            z18 = true;
        } else {
            z18 = false;
        }
        arrayList.add(h17.e(z18));
        e h18 = new e().g(com.tencent.biz.qqcircle.utils.h.a(R.string.f193394_3)).f(2.0f).h(com.tencent.biz.qqcircle.utils.h.a(R.string.f193414_5));
        if (this.f93425e.mPlayRate != 2.0f) {
            z19 = false;
        }
        arrayList.add(h18.e(z19));
        this.f93428i.setDataList(arrayList);
    }

    private void n() {
        if (this.C == null) {
            return;
        }
        int dip2px = DisplayUtil.dip2px(getContext(), 47.0f);
        int dip2px2 = DisplayUtil.dip2px(getContext(), 26.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.width = dip2px;
        layoutParams.height = dip2px2;
        this.C.setLayoutParams(layoutParams);
    }

    private void o() {
        boolean z16;
        int i3;
        if (this.E != null && this.D != null) {
            QCircleShareInfo h16 = h();
            int i16 = 0;
            if (h16 != null && h16.isShareBottomBarrageSwitch) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.D.setVisibility(8);
                this.E.setVisibility(8);
                return;
            }
            boolean z17 = !k();
            QLog.d("QFSShareBottomPlayRateView", 2, "[updateBarrageVisible] isHideBarrage = " + z17);
            View view = this.E;
            if (z17) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view.setVisibility(i3);
            View view2 = this.D;
            if (z17) {
                i16 = 8;
            }
            view2.setVisibility(i16);
            return;
        }
        QLog.e("QFSShareBottomPlayRateView", 1, "[updateBarrageVisible] mDivider || mRlBarrageSwitch should not be null.");
    }

    public void d(QCircleShareInfo qCircleShareInfo, b bVar) {
        this.f93426f = bVar;
        this.f93425e = qCircleShareInfo;
        m();
        f(false, "dt_imp", this.f93429m);
        o();
    }

    protected void e(boolean z16, String str) {
        int i3;
        String str2;
        if (h() != null && h().feedBlockData != null && h().feed != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(h().feedBlockData));
            if (h().extraTypeInfo != null) {
                i3 = h().extraTypeInfo.mDataPosition + 1;
            } else {
                i3 = -1;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3));
            buildElementParams.put("xsj_target_qq", h().feed.poster.f398463id.get());
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put("xsj_topic_page_source", h().feedTagPageFromType);
            buildElementParams.put("xsj_topic_id", h().tagId);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHAREPANEL_SOURCE, Integer.valueOf(h().source));
            if (z16) {
                str2 = QCircleDaTongConstant.ElementParamValue.OPEN_BULLET_SCREEN;
            } else {
                str2 = QCircleDaTongConstant.ElementParamValue.CLOSE_BULLET_SCREEN;
            }
            buildElementParams.put("xsj_action_type", str2);
            if (str.equals("ev_xsj_sharepanel_action") && w20.a.j().k() > 0) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().k()));
            }
            VideoReport.setElementId(this.C, "em_xsj_sharepanel");
            VideoReport.reportEvent(str, this.C, buildElementParams);
            return;
        }
        QLog.e("QFSShareBottomPlayRateView", 1, "build QFSShareBottomPlayRateView error, check the building params");
    }

    protected void f(boolean z16, String str, View view) {
        int i3;
        if (h() != null && h().feedBlockData != null && h().feed != null) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(h().feedBlockData));
            int i16 = 1;
            if (h().extraTypeInfo != null) {
                i3 = h().extraTypeInfo.mDataPosition + 1;
            } else {
                i3 = -1;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3));
            buildElementParams.put("xsj_target_qq", h().feed.poster.f398463id.get());
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put("xsj_topic_page_source", h().feedTagPageFromType);
            buildElementParams.put("xsj_topic_id", h().tagId);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHAREPANEL_SOURCE, 1);
            buildElementParams.put("xsj_action_type", QCircleDaTongConstant.ElementParamValue.FAST_FORWARD);
            if (str.equals("ev_xsj_sharepanel_action") && w20.a.j().k() > 0) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().k()));
            }
            if (z16) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PANEL_BUTTON_LOCATION, gb0.b.s(QCirclePluginGlobalInfo.t(h().feed.f398449id.get())));
                VideoReport.setPageId(view, h().mReportBean.getDtPageId());
            } else {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_FAST_FORWARD_BUTTON, 1);
                if (QCirclePluginGlobalInfo.t(h().feed.f398449id.get()) == 1.0f) {
                    i16 = 0;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FAST_FORWARD_BUTTON_STATE, Integer.valueOf(i16));
                VideoReport.setPageId(this.f93424d, h().mReportBean.getDtPageId());
            }
            VideoReport.setElementId(view, "em_xsj_sharepanel");
            VideoReport.reportEvent(str, view, buildElementParams);
        }
    }

    protected void l(float f16) {
        if (h() != null && h().feed != null && h().extraTypeInfo != null && h().mReportBean != null) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(h().feed)).setActionType(129).setSubActionType(2).setToUin(h().feed.poster.f398463id.get()).setPosition(h().extraTypeInfo.mDataPosition).setPlayScene(h().extraTypeInfo.mPlayScene).setExt1(g(f16)).setPageId(h().mReportBean.getPageId()).setfpageid(h().mReportBean.getFromPageId()).setFirstFeedId(w20.a.j().h()));
        }
    }
}
