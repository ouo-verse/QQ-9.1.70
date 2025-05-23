package com.tencent.biz.qqcircle.immersive.feed;

import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* loaded from: classes4.dex */
public class QFSHotTagPresenter extends com.tencent.biz.qqcircle.immersive.feed.b implements View.OnClickListener {

    /* renamed from: k0, reason: collision with root package name */
    private static final Drawable f85284k0 = new ColorDrawable(0);
    private LinearLayout S;
    private LinearLayout T;
    private RecyclerView U;
    private com.tencent.biz.qqcircle.immersive.adapter.g V;
    private ImageView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f85285a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f85286b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f85287c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f85288d0 = "";

    /* renamed from: e0, reason: collision with root package name */
    private String f85289e0 = "";

    /* renamed from: f0, reason: collision with root package name */
    private String f85290f0 = "";

    /* renamed from: g0, reason: collision with root package name */
    private String f85291g0 = "";

    /* renamed from: h0, reason: collision with root package name */
    private String f85292h0 = "";

    /* renamed from: i0, reason: collision with root package name */
    private e70.c f85293i0;

    /* renamed from: j0, reason: collision with root package name */
    private Observer<QQCircleDitto$StItemInfo> f85294j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.QFSHotTagPresenter$3, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass3 implements Observer<QQCircleDitto$StItemInfo> {
        AnonymousClass3() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(final QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
            if (QFSHotTagPresenter.this.V != null && QFSHotTagPresenter.this.X != null && QFSHotTagPresenter.this.Z != null && qQCircleDitto$StItemInfo != null) {
                RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSHotTagPresenter.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        StringBuilder obtain = RFWStringBuilderUtils.obtain();
                        ArrayList<e30.b> b16 = e30.d.b(qQCircleDitto$StItemInfo.feeds.get());
                        final ArrayList arrayList = new ArrayList();
                        Iterator<e30.b> it = b16.iterator();
                        while (it.hasNext()) {
                            e30.b next = it.next();
                            obtain.append(next.g().f398449id.get());
                            obtain.append(";");
                            arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.bean.e(next));
                        }
                        QFSHotTagPresenter.this.f85289e0 = obtain.toString();
                        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSHotTagPresenter.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                QFSHotTagPresenter.this.z1(qQCircleDitto$StItemInfo, arrayList);
                            }
                        });
                    }
                });
            }
        }
    }

    /* loaded from: classes4.dex */
    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), DisplayUtil.dip2px(QFSHotTagPresenter.this.m0(), 6.0f));
        }
    }

    /* loaded from: classes4.dex */
    class b implements QFSPersonalFeedBaseAdapter.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter.b
        public void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
            if (QFSHotTagPresenter.this.f85293i0 == null) {
                return;
            }
            if (QFSHotTagPresenter.this.f85293i0.O1().getValue() != null && QFSHotTagPresenter.this.f85293i0.O1().getValue().getData().size() > i3) {
                QFSHotTagPresenter.this.u1(i3, eVar, qCircleBaseWidgetView);
            } else {
                QFSHotTagPresenter.this.f85293i0.Z1();
                QFSHotTagPresenter.this.x1();
            }
        }
    }

    private void t1(String str, String str2) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_topic_id", str);
        buildElementParams.put("xsj_topic_name", str2);
        VideoReport.setElementId(this.S, QCircleDaTongConstant.ElementId.EM_XSJ_TOPIC_SINGLE_LIST_CARD);
        VideoReport.setElementParams(this.T, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.T, str);
        VideoReport.setElementId(this.T, "em_xsj_topic_card");
        VideoReport.setElementParams(this.T, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.T, str);
        VideoReport.setElementId(this.Z, QCircleDaTongConstant.ElementId.EM_XSJ_CONTRIBUTE_BUTTON);
        VideoReport.setElementParams(this.Z, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.Z, str);
        VideoReport.setElementId(this.f85285a0, QCircleDaTongConstant.ElementId.EM_XSJ_SWITCH_BUTTON);
        VideoReport.setElementParams(this.f85285a0, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.f85285a0, str);
        VideoReport.setElementId(this.f85286b0, QCircleDaTongConstant.ElementId.EM_XSJ_VIEW_MORE_BUTTON);
        VideoReport.setElementParams(this.f85286b0, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.f85286b0, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QCircleBaseWidgetView qCircleBaseWidgetView) {
        if (eVar != null && qCircleBaseWidgetView != null && this.f85293i0 != null) {
            QCircleLayerBean v16 = v1(i3, eVar);
            int[] iArr = new int[2];
            qCircleBaseWidgetView.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i16 = iArr[0];
            v16.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], qCircleBaseWidgetView.getWidth() + i16, iArr[1] + qCircleBaseWidgetView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(eVar.a()));
            if (qCircleBaseWidgetView.getChildCount() > 0 && (qCircleBaseWidgetView.getChildAt(0) instanceof FrameLayout) && ((FrameLayout) qCircleBaseWidgetView.getChildAt(0)).getChildCount() > 0 && (((FrameLayout) qCircleBaseWidgetView.getChildAt(0)).getChildAt(0) instanceof ImageView)) {
                v16.getTransitionAnimBean().setCoverDrawable(((ImageView) ((FrameLayout) qCircleBaseWidgetView.getChildAt(0)).getChildAt(0)).getDrawable());
            }
            com.tencent.biz.qqcircle.launcher.c.u(m0(), v16);
        }
    }

    private void w1() {
        this.f85293i0 = (e70.c) A0(e70.c.class);
        w20.a.j().registerDisplaySurface(this.f85293i0.P1(), this.f85293i0);
        this.f85294j0 = new AnonymousClass3();
        this.f85293i0.N1().observeForever(this.f85294j0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1() {
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(610).setSubActionType(2).setExt1(this.f85288d0));
        com.tencent.biz.qqcircle.launcher.c.g(m0(), this.f85291g0);
    }

    private void y1(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSHotTagPresenter", 1, "[updateHotBackground] sendBgUrl is null");
            return;
        }
        this.Z.setBackgroundDrawable(f85284k0);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setTargetView(this.f85287c0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, ArrayList<com.tencent.biz.qqcircle.immersive.personal.bean.e> arrayList) {
        String str = qQCircleDitto$StItemInfo.f429300id.get();
        String str2 = qQCircleDitto$StItemInfo.name.get();
        this.f85288d0 = str2;
        this.X.setText(str2);
        this.Z.setText(qQCircleDitto$StItemInfo.buttonInfo.name.get());
        y1(qQCircleDitto$StItemInfo.buttonInfo.style.button_diaplay_url.get());
        if (qQCircleDitto$StItemInfo.des.size() > 0) {
            this.Y.setText(qQCircleDitto$StItemInfo.des.get(0));
        }
        this.V.r0(str);
        this.V.s0(this.f85288d0);
        this.V.setDatas(arrayList);
        this.f85291g0 = com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "jump_url");
        this.f85290f0 = qQCircleDitto$StItemInfo.buttonInfo.jumpUrl.get();
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "icon_url")).setTargetView(this.W));
        t1(str, this.f85288d0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        e70.c cVar = this.f85293i0;
        if (cVar != null) {
            cVar.N1().observeForever(this.f85294j0);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        e70.c cVar = this.f85293i0;
        if (cVar != null) {
            cVar.N1().removeObserver(this.f85294j0);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        w1();
        this.S = (LinearLayout) view.findViewById(R.id.f46161tu);
        this.W = (ImageView) view.findViewById(R.id.f44331ow);
        this.X = (TextView) view.findViewById(R.id.f56322ka);
        this.Y = (TextView) view.findViewById(R.id.f56332kb);
        this.Z = (TextView) view.findViewById(R.id.f56372kf);
        this.f85287c0 = (ImageView) view.findViewById(R.id.f44271oq);
        this.f85285a0 = (TextView) view.findViewById(R.id.f56342kc);
        this.f85286b0 = (TextView) view.findViewById(R.id.f56362ke);
        this.T = (LinearLayout) view.findViewById(R.id.f46121tq);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f515528e);
        this.U = recyclerView;
        recyclerView.setOutlineProvider(new a());
        this.U.setClipToOutline(true);
        this.U.setLayoutManager(new SafeGridLayoutManager(m0(), 3));
        com.tencent.biz.qqcircle.immersive.adapter.g gVar = new com.tencent.biz.qqcircle.immersive.adapter.g(null);
        this.V = gVar;
        gVar.p0(new b());
        this.U.setAdapter(this.V);
        this.T.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f85285a0.setOnClickListener(this);
        this.f85286b0.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        boolean z16;
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 38) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = ((QQCircleDitto$StCircleDittoDataNew) this.E.b(String.valueOf(feedCloudMeta$StFeed.dittoFeed.dittoId.get()))).itemContainter.get();
        this.f85292h0 = com.tencent.biz.qqcircle.immersive.utils.af.a(qQCircleDitto$StItemContainer.urlInfo.get(), "jump_url");
        List<QQCircleDitto$StItemInfo> list = qQCircleDitto$StItemContainer.items.get();
        if (list.size() == 0) {
            return;
        }
        this.f85293i0.Q1(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f56372kf) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(610).setSubActionType(3).setExt3(this.f85288d0).setExt4(this.f85289e0));
            com.tencent.biz.qqcircle.launcher.c.g(m0(), this.f85290f0);
        } else if (id5 == R.id.f56362ke) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(610).setSubActionType(5).setExt3(this.f85288d0).setExt4(this.f85289e0));
            com.tencent.biz.qqcircle.launcher.c.g(m0(), this.f85292h0);
        } else if (id5 == R.id.f56342kc) {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(610).setSubActionType(4).setExt3(this.f85288d0).setExt4(this.f85289e0));
            this.f85293i0.U1();
        } else if (id5 == R.id.f46121tq) {
            x1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(610).setSubActionType(1).setExt1(this.f85288d0));
    }

    public QCircleLayerBean v1(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        if (getReportBean() != null) {
            qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
        }
        if (eVar != null) {
            qCircleLayerBean.setFeed(eVar.b());
        }
        qCircleLayerBean.setDataPosInList(i3);
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setGlobalViewModelKey(this.f85293i0.P1());
        qCircleLayerBean.setPageCode(hashCode());
        return qCircleLayerBean;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSHotTagPresenter";
    }
}
