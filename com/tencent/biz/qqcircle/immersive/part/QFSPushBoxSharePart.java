package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.events.QCircleShowPushBoxShareEvent;
import com.tencent.biz.qqcircle.immersive.adapter.z;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqforward.api.RecentContactListener;
import com.tencent.mobileqq.qqforward.api.RecentUserBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPushBoxSharePart extends u implements View.OnClickListener, SimpleEventReceiver {
    private final Runnable C = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSPushBoxSharePart.1
        @Override // java.lang.Runnable
        public void run() {
            if (QFSPushBoxSharePart.this.f87518e != null) {
                QFSPushBoxSharePart.this.f87518e.setVisibility(8);
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private ViewStub f87517d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f87518e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f87519f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f87520h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.adapter.z f87521i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.viewmodel.wink.f f87522m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Observer<List<e40.o>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<e40.o> list) {
            QFSPushBoxSharePart.this.f87521i.setDatas(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements RecentContactListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqforward.api.RecentContactListener
        public void onResult(List<RecentUserBean> list) {
            QFSPushBoxSharePart.this.f87522m.P1(QFSPushBoxSharePart.this.getActivity(), list);
        }
    }

    private void C9() {
        if (this.f87519f != null && QCircleCommonUtil.isInNightMode()) {
            this.f87519f.setImageResource(R.drawable.qvideo_skin_icon_general_close_light);
        }
    }

    private void D9() {
        String dtPageId;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PYLIST_ESC_BUTTON);
        if (getReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = getReportBean().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", dtPageId);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(e40.o oVar) {
        com.tencent.biz.qqcircle.immersive.viewmodel.wink.f fVar = this.f87522m;
        if (fVar == null) {
            QLog.e("QFSPushBoxSharePart", 1, "forward failed by view model is null");
            return;
        }
        try {
            FeedCloudMeta$StFeed value = fVar.O1().getValue();
            if (value == null) {
                QLog.w("QFSPushBoxSharePart", 1, "forward failed, publish feed data is empty");
            } else if (oVar.b() == 2) {
                com.tencent.biz.qqcircle.immersive.utils.bp.f90195c.e(getActivity(), value);
            } else {
                com.tencent.biz.qqcircle.immersive.utils.bp.f90195c.b(getActivity(), oVar.c(), oVar.b(), value);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("QFSPushBoxSharePart", 1, "forward failed:" + e16.getMessage());
        }
    }

    private void F9() {
        if (getMainHandler() != null) {
            getMainHandler().removeCallbacks(this.C);
            getMainHandler().postDelayed(this.C, 4000L);
        }
    }

    private void G9() {
        String dtPageId;
        if (this.f87517d != null) {
            I9();
            return;
        }
        View partRootView = getPartRootView();
        if (partRootView != null && getActivity() != null && !getActivity().isFinishing()) {
            ViewStub viewStub = (ViewStub) partRootView.findViewById(R.id.f505025k);
            this.f87517d = viewStub;
            if (viewStub == null) {
                QLog.d("QFSPushBoxSharePart", 1, "view stub is null");
                return;
            }
            LinearLayout linearLayout = (LinearLayout) viewStub.inflate().findViewById(R.id.f55782iu);
            this.f87518e = linearLayout;
            this.f87519f = (ImageView) linearLayout.findViewById(R.id.f44171og);
            this.f87520h = (RecyclerView) this.f87518e.findViewById(R.id.f504925j);
            this.f87518e.setOnClickListener(this);
            this.f87519f.setOnClickListener(this);
            C9();
            com.tencent.biz.qqcircle.immersive.adapter.z zVar = new com.tencent.biz.qqcircle.immersive.adapter.z(getContext());
            this.f87521i = zVar;
            zVar.n0(new z.b() { // from class: com.tencent.biz.qqcircle.immersive.part.eq
                @Override // com.tencent.biz.qqcircle.immersive.adapter.z.b
                public final void a(e40.o oVar) {
                    QFSPushBoxSharePart.this.E9(oVar);
                }
            });
            com.tencent.biz.qqcircle.immersive.adapter.z zVar2 = this.f87521i;
            if (getReportBean() == null) {
                dtPageId = "";
            } else {
                dtPageId = getReportBean().getDtPageId();
            }
            zVar2.m0(dtPageId);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(0);
            this.f87520h.setLayoutManager(linearLayoutManager);
            this.f87520h.setAdapter(this.f87521i);
            initViewModel();
            H9();
            F9();
        }
    }

    private void H9() {
        String dtPageId;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SHARE_PANEL_TOP);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYLIST_TYPE, 2);
        if (getReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = getReportBean().getDtPageId();
        }
        buildElementParams.put("xsj_custom_pgid", dtPageId);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private void I9() {
        String dtPageId;
        if (this.f87518e != null) {
            H9();
            this.f87518e.setVisibility(0);
            F9();
        }
        com.tencent.biz.qqcircle.immersive.adapter.z zVar = this.f87521i;
        if (zVar != null) {
            if (getReportBean() == null) {
                dtPageId = "";
            } else {
                dtPageId = getReportBean().getDtPageId();
            }
            zVar.m0(dtPageId);
        }
    }

    private void initViewModel() {
        com.tencent.biz.qqcircle.immersive.viewmodel.wink.f fVar = (com.tencent.biz.qqcircle.immersive.viewmodel.wink.f) getViewModel(com.tencent.biz.qqcircle.immersive.viewmodel.wink.f.class);
        this.f87522m = fVar;
        if (fVar == null) {
            QLog.d("QFSPushBoxSharePart", 1, "push box view model is null");
        } else {
            fVar.N1().observe(getHostFragment(), new a());
            com.tencent.biz.qqcircle.immersive.utils.bp.f90195c.c(new b());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPushBoxSharePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if (TextUtils.equals(str, "share_action_show_push_box_share_sheet")) {
            G9();
            if (obj instanceof QCircleShowPushBoxShareEvent) {
                FeedCloudMeta$StFeed feed = ((QCircleShowPushBoxShareEvent) obj).getFeed();
                com.tencent.biz.qqcircle.immersive.viewmodel.wink.f fVar = this.f87522m;
                if (fVar != null) {
                    fVar.T1(feed);
                }
            }
        }
        super.handleBroadcastMessage(str, obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.f44171og && this.f87518e != null) {
            D9();
            this.f87518e.setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (getMainHandler() != null) {
            getMainHandler().removeCallbacks(this.C);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
