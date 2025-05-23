package com.tencent.biz.qqcircle.immersive.personal.part;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalCollectBoxDetailBean;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalCollectBoxEvent;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSDeleteCollectBoxRequest;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalCollectBoxAddFeedBottomSheet;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalNewCollectBoxBottomSheet;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudFavoritessvr$DelFavoritesRsp;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFavoritesFeedsPageRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener {
    private View.OnClickListener C;
    private boolean D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f88915d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f88916e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f88917f;

    /* renamed from: h, reason: collision with root package name */
    private FeedCloudMeta$StShare f88918h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.widget.tip.a f88919i;

    /* renamed from: m, reason: collision with root package name */
    private QFSPersonalCollectBoxDetailBean f88920m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f88921d;

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.immersive.personal.part.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0901a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$DelFavoritesRsp> {
            C0901a() {
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$DelFavoritesRsp feedCloudFavoritessvr$DelFavoritesRsp) {
                if (z16 && j3 == 0 && feedCloudFavoritessvr$DelFavoritesRsp != null) {
                    QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent = new QFSPersonalCollectBoxEvent(4);
                    qFSPersonalCollectBoxEvent.setFavoritesInfo(d.this.f88920m.getFavoritesInfo());
                    SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent);
                    QCircleToast.v(QCircleToast.f91644d, com.tencent.biz.qqcircle.utils.h.a(R.string.f1898240f), 0);
                    d.this.getActivity().finish();
                    return;
                }
                QLog.e("QFSPersonalCollectBoxDetailTitlePart", 1, "addFeedComment error:" + j3 + "  errorMsg:" + str);
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f1898040d), 0);
            }
        }

        a(String str) {
            this.f88921d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            VSNetworkHelper.getInstance().sendRequest(new QFSDeleteCollectBoxRequest(d.this.f88920m.getFavoritesInfo().f398434id.get()), new C0901a());
            d.this.A9(true, this.f88921d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f88924d;

        b(String str) {
            this.f88924d = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            d.this.A9(true, this.f88924d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A9(boolean z16, String str) {
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_DELETE_COLLECT_FOLDER_POPUP);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.f88920m.getFavoritesInfo().f398434id.get()));
        if (z16) {
            buildElementParams.put("xsj_item_name", str);
        }
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        if (z16) {
            str2 = "ev_xsj_abnormal_clck";
        } else {
            str2 = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str2, buildElementParams);
    }

    private void B9(boolean z16, TextView textView) {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_FOLDER_EDIT_MENU);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.f88920m.getFavoritesInfo().f398434id.get()));
        if (z16) {
            buildElementParams.put("xsj_item_name", textView.getText());
        }
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        if (z16) {
            str = "ev_xsj_abnormal_clck";
        } else {
            str = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str, buildElementParams);
    }

    private void C9() {
        VideoReport.setElementId(this.f88916e, "em_xsj_share_button");
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        QFSPersonalCollectBoxDetailBean qFSPersonalCollectBoxDetailBean = this.f88920m;
        if (qFSPersonalCollectBoxDetailBean != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(qFSPersonalCollectBoxDetailBean.getFavoritesInfo().f398434id.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_NAME, this.f88920m.getFavoritesInfo().title.get());
        }
        VideoReport.setElementParams(this.f88916e, buildElementParams);
    }

    private void D9() {
        if (this.f88918h == null) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gkg, (ViewGroup) null);
        inflate.findViewById(R.id.f10583673).setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(R.id.f10622685);
        textView.setEnabled(this.E);
        textView.setOnClickListener(this);
        inflate.findViewById(R.id.f110686j7).setOnClickListener(this);
        inflate.findViewById(R.id.f107306a2).setOnClickListener(this);
        com.tencent.mobileqq.widget.tip.a r16 = com.tencent.mobileqq.widget.tip.a.r(getContext());
        this.f88919i = r16;
        r16.S(this.f88917f).a0(inflate).R(0).k0(1).W(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_top_light)).b0(-1L).e0(true);
        B9(false, null);
    }

    private void E9() {
        this.f88919i.o();
        long j3 = this.f88920m.getFavoritesInfo().feed_num.get();
        int i3 = QFSPersonalCollectBoxAddFeedBottomSheet.S;
        if (j3 >= i3) {
            QCircleToast.o(getContext().getString(R.string.f187993vh, Integer.valueOf(i3)), 0);
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.bean.f fVar = new com.tencent.biz.qqcircle.immersive.personal.bean.f(3);
        fVar.c(this.f88920m.getFavoritesInfo());
        new QFSPersonalCollectBoxAddFeedBottomSheet(getContext(), this.mParentView, fVar, getReportBean()).show();
    }

    private void F9(View view) {
        this.f88919i.o();
        this.f88917f.setVisibility(8);
        this.f88916e.setVisibility(8);
        View.OnClickListener onClickListener = this.C;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private void G9() {
        int i3;
        this.f88919i.o();
        if (this.E) {
            i3 = R.string.f1898140e;
        } else {
            i3 = R.string.f1897940c;
        }
        String a16 = com.tencent.biz.qqcircle.utils.h.a(i3);
        String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.cancel);
        String a18 = com.tencent.biz.qqcircle.utils.h.a(R.string.f171151ok);
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, a16, a17, a18, new a(a18), new b(a17)).show();
        A9(false, null);
    }

    private void I9() {
        this.f88919i.o();
        com.tencent.biz.qqcircle.immersive.personal.bean.n nVar = new com.tencent.biz.qqcircle.immersive.personal.bean.n(2);
        nVar.d(this.f88920m.getFavoritesInfo());
        new QFSPersonalNewCollectBoxBottomSheet(getContext(), getPartRootView(), nVar, getReportBean()).show();
    }

    private void O9() {
        if (this.D) {
            this.f88917f.setVisibility(0);
        } else {
            this.f88917f.setVisibility(8);
        }
    }

    private void P9() {
        if (this.f88918h == null) {
            return;
        }
        if (!this.E) {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f195574ez), 0);
            return;
        }
        if (this.f88920m.getFavoritesInfo().status.get() == 1) {
            DialogUtil.createCustomDialog(getContext(), 230, (String) null, com.tencent.biz.qqcircle.utils.h.a(R.string.f195564ey), (String) null, com.tencent.biz.qqcircle.utils.h.a(R.string.f1910643s), new c(), (DialogInterface.OnClickListener) null).show();
            return;
        }
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        qCircleShareInfo.type = 9;
        qCircleShareInfo.shareStyleType = 9;
        qCircleShareInfo.collectBoxId = this.f88920m.getFavoritesInfo().f398434id.get();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        qCircleShareInfo.feed = feedCloudMeta$StFeed;
        qCircleShareInfo.feedBlockData = new e30.b(feedCloudMeta$StFeed);
        broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
    }

    public void H9(QQCircleFeedBase$StFavoritesFeedsPageRsp qQCircleFeedBase$StFavoritesFeedsPageRsp) {
        this.f88918h = qQCircleFeedBase$StFavoritesFeedsPageRsp.share_info.get();
        this.D = QCirclePluginUtil.isOwner(qQCircleFeedBase$StFavoritesFeedsPageRsp.author);
        O9();
    }

    public void J9() {
        this.f88917f.setVisibility(8);
        this.f88916e.setVisibility(8);
    }

    public void K9() {
        O9();
        this.f88916e.setVisibility(0);
    }

    public void L9(QFSPersonalCollectBoxDetailBean qFSPersonalCollectBoxDetailBean) {
        this.f88920m = qFSPersonalCollectBoxDetailBean;
    }

    public void M9(boolean z16) {
        this.E = z16;
    }

    public void N9(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCollectBoxDetailTitlePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f165970y94) {
            P9();
        } else if (view.getId() == R.id.du6) {
            getPartHost().getHostActivity().onBackPressed();
        } else if (view.getId() == R.id.y2m) {
            D9();
        } else if (view.getId() == R.id.f10583673) {
            E9();
            B9(true, (TextView) view);
        } else if (view.getId() == R.id.f10622685) {
            F9(view);
            B9(true, (TextView) view);
        } else if (view.getId() == R.id.f110686j7) {
            I9();
            B9(true, (TextView) view);
        } else if (view.getId() == R.id.f107306a2) {
            G9();
            B9(true, (TextView) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.du6);
        this.f88915d = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.f165970y94);
        this.f88916e = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.y2m);
        this.f88917f = imageView3;
        imageView3.setOnClickListener(this);
        VideoReport.setElementId(this.f88917f, QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_FOLDER_EDIT_BUTTON);
        C9();
    }
}
