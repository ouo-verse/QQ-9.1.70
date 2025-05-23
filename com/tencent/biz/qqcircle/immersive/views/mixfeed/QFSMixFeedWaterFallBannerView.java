package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedWaterFallBannerView extends QFSMixFeedBaseWidgetView<e30.b> implements SimpleEventReceiver {

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f90894e;

    /* renamed from: f, reason: collision with root package name */
    private RoundCorneredRelativeLayout f90895f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f90896h;

    /* renamed from: i, reason: collision with root package name */
    private e30.b f90897i;

    public QFSMixFeedWaterFallBannerView(@NonNull Context context) {
        super(context);
        o0(this);
    }

    private void l0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        ImageView imageView = this.f90896h;
        if (imageView != null && qQCircleDitto$StItemInfo != null) {
            VideoReport.setElementId(imageView, QCircleDaTongConstant.ElementId.EM_XSJ_OPERATION_ACTIVITY_CARD);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_operation_activity_id", QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "activityID"));
            VideoReport.setElementParams(this.f90896h, hashMap);
            VideoReport.setElementReuseIdentifier(this.f90896h, QCircleDaTongConstant.ElementId.EM_XSJ_OPERATION_ACTIVITY_CARD);
        }
    }

    private void m0(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        q0(this.f90897i, null);
    }

    private void n0(final List<QQCircleDitto$StItemInfo> list, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (this.f90894e != null && this.f90895f != null && this.f90896h != null && list.size() >= 1 && list.get(0).images.size() >= 1) {
            Option predecode = Option.obtain().setTargetView(this.f90896h).setUrl(list.get(0).images.get(0).picUrl.get()).setRequestWidth(uRLDrawableOptions.mRequestWidth).setRequestHeight(uRLDrawableOptions.mRequestHeight).setPredecode(true);
            predecode.setSupportRecycler(true);
            predecode.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            QCircleFeedPicLoader.g().loadImage(predecode);
            this.f90894e.setVisibility(0);
            this.f90896h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSMixFeedWaterFallBannerView.this.p0(list, view);
                }
            });
            return;
        }
        QLog.e("QFSMixFeedWaterFallBannerView", 1, "[initBanner] mFlBannerContainer == null");
    }

    private void o0(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f47321wz);
        this.f90894e = frameLayout;
        frameLayout.setPadding(cx.a(4.0f), cx.a(4.0f), cx.a(4.0f), cx.a(4.0f));
        this.f90895f = (RoundCorneredRelativeLayout) view.findViewById(R.id.f47331x0);
        this.f90896h = (ImageView) view.findViewById(R.id.f47311wy);
        float a16 = cx.a(8.0f);
        this.f90895f.setRadius(a16, a16, a16, a16);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(List list, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), d.f((QQCircleDitto$StItemInfo) list.get(0), "recom_card_jump_url"));
        EventCollector.getInstance().onViewClicked(view);
    }

    private void q0(e30.b bVar, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (bVar == null) {
            return;
        }
        Pair<Integer, Integer> h16 = d.h(getContext(), bVar.g());
        if (((Integer) h16.first).intValue() != 0 && ((Integer) h16.second).intValue() != 0) {
            ViewGroup.LayoutParams layoutParams = this.f90896h.getLayoutParams();
            layoutParams.width = ((Integer) h16.first).intValue();
            layoutParams.height = ((Integer) h16.second).intValue();
            this.f90896h.setLayoutParams(layoutParams);
            QLog.i("QFSMixFeedWaterFallBannerView", 1, "mIvFeedCover  measureWidthAndHeight  params.width : " + h16.first + " , params.height : " + h16.second);
            if (uRLDrawableOptions == null) {
                return;
            }
            uRLDrawableOptions.mRequestWidth = ((Integer) h16.first).intValue();
            uRLDrawableOptions.mRequestHeight = ((Integer) h16.second).intValue();
            QLog.i("QFSMixFeedWaterFallBannerView", 1, "mIvFeedCover  measureWidthAndHeight  params.width : " + h16.first + " , params.height : " + h16.second);
        }
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
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedWaterFallBannerView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            m0((QCircleConfigChangeEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            this.f90897i = bVar;
            QQCircleDitto$StItemContainer i16 = d.i(bVar, String.valueOf(bVar.g().dittoFeed.dittoId.get()));
            if (i16 == null || i16.items.size() < 1) {
                return;
            }
            QLog.i("QFSMixFeedWaterFallBannerView", 1, "[setOnClickListener] -> position = " + i3 + ", itemInfos.size() = " + i16.items.size());
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            q0(bVar, obtain);
            n0(i16.items.get(), obtain);
            l0(i16.items.get(0));
            return;
        }
        QLog.e("QFSMixFeedWaterFallBannerView", 1, "[bindData] feedBlockData == null ");
    }
}
