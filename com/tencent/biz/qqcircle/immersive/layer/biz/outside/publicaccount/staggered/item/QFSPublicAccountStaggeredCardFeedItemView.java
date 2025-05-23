package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import qqcircle.QQCircleDitto$StItemContainer;

/* loaded from: classes4.dex */
public class QFSPublicAccountStaggeredCardFeedItemView extends QCircleBaseWidgetView<e30.b> implements View.OnClickListener, SimpleEventReceiver {
    private static final int F = cx.a(8.0f);
    private static final int G = ImmersiveUtils.dpToPx(8.0f);
    private FeedCloudMeta$StFeed C;
    private QQCircleDitto$StItemContainer D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private FrameLayout f86805d;

    /* renamed from: e, reason: collision with root package name */
    private RoundCorneredRelativeLayout f86806e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f86807f;

    /* renamed from: h, reason: collision with root package name */
    private int f86808h;

    /* renamed from: i, reason: collision with root package name */
    private int f86809i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleInitBean f86810m;

    public QFSPublicAccountStaggeredCardFeedItemView(@NonNull Context context, QCircleInitBean qCircleInitBean) {
        super(context);
        this.f86810m = qCircleInitBean;
        n0(this);
    }

    private void k0(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        ImageView imageView = this.f86807f;
        if (imageView != null && qQCircleDitto$StItemContainer != null) {
            VideoReport.setElementId(imageView, QCircleDaTongConstant.ElementId.EM_XSJ_OPERATION_ACTIVITY_CARD);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_operation_activity_id", QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemContainer.busiInfo.get(), "task_id"));
            VideoReport.setElementParams(this.f86807f, hashMap);
            VideoReport.setElementReuseIdentifier(this.f86807f, QCircleDaTongConstant.ElementId.EM_XSJ_OPERATION_ACTIVITY_CARD);
            return;
        }
        QLog.e("QFSPublicAccountStaggeredCardFeedItemView", 1, "[dtReportBindViewData] stItemContainer == null");
    }

    private void l0() {
        if (this.D == null) {
            QLog.e("QFSPublicAccountStaggeredCardFeedItemView", 1, "[handleCardClick] mItemInfo == null");
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), QCirclePluginUtil.getValueFromListEntry(this.D.urlInfo.get(), "jump_url"));
        int i3 = this.E;
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g.g(i3 + 1, i3 % 2, this.C, this.f86810m);
    }

    private void m0(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        if (this.f86805d != null && this.f86807f != null && qQCircleDitto$StItemContainer != null) {
            Option predecode = Option.obtain().setTargetView(this.f86807f).setUrl(QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemContainer.urlInfo.get(), "cover_url")).setRequestWidth(this.f86808h).setRequestHeight(this.f86809i).setPredecode(true);
            predecode.setSupportRecycler(true);
            predecode.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            QCircleFeedPicLoader.g().loadImage(predecode);
            this.f86805d.setVisibility(0);
            return;
        }
        QLog.e("QFSPublicAccountStaggeredCardFeedItemView", 1, "[initBanner] stItemContainer == null");
    }

    private void n0(View view) {
        this.f86805d = (FrameLayout) view.findViewById(R.id.f47321wz);
        this.f86806e = (RoundCorneredRelativeLayout) view.findViewById(R.id.f47331x0);
        ImageView imageView = (ImageView) view.findViewById(R.id.f47311wy);
        this.f86807f = imageView;
        imageView.setOnClickListener(this);
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = this.f86806e;
        int i3 = F;
        roundCorneredRelativeLayout.setRadius(i3, i3, i3, i3);
        this.f86805d.setVisibility(8);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void o0() {
        if (this.f86807f == null) {
            QLog.e("QFSPublicAccountStaggeredCardFeedItemView", 1, "[setCoverWidthAndHeight] mIvCover == null");
            return;
        }
        int j3 = (bz.j() - (G * 3)) / 2;
        this.f86808h = j3;
        int i3 = (int) (j3 * 1.7777778f);
        ViewGroup.LayoutParams layoutParams = this.f86807f.getLayoutParams();
        layoutParams.width = this.f86808h;
        layoutParams.height = i3;
        this.f86809i = i3;
        this.f86807f.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gjd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPublicAccountStaggeredCardFeedItemView";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f47311wy) {
            l0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            this.C = bVar.g();
            QQCircleDitto$StItemContainer i16 = com.tencent.biz.qqcircle.immersive.views.mixfeed.d.i(bVar, String.valueOf(bVar.g().dittoFeed.dittoId.get()));
            if (i16 == null) {
                QLog.e("QFSPublicAccountStaggeredCardFeedItemView", 1, "[bindData] position = " + i3 + ", stItemContainer is null.");
                return;
            }
            this.D = i16;
            this.E = i3;
            o0();
            m0(i16);
            k0(i16);
            return;
        }
        QLog.e("QFSPublicAccountStaggeredCardFeedItemView", 1, "[bindData] feedBlockData == null ");
    }
}
