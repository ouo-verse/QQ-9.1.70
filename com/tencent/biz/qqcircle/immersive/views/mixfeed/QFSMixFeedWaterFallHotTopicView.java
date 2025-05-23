package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedWaterFallHotTopicView extends QFSMixFeedBaseWidgetView<e30.b> implements SimpleEventReceiver, View.OnClickListener {
    private static final int I = cx.a(48.0f);
    private TextView C;
    private ImageView D;
    private View E;
    private e30.b F;
    private List<QQCircleDitto$StItemInfo> G;
    private c H;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f90903e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f90904f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f90905h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f90906i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f90907m;

    public QFSMixFeedWaterFallHotTopicView(@NotNull Context context) {
        super(context);
        this.G = new ArrayList();
        r0(this);
    }

    private void k0() {
        LinearLayout linearLayout = this.f90905h;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setPadding(0, cx.a(56.0f), 0, 0);
    }

    private void l0() {
        List<QQCircleDitto$StItemInfo> a16 = this.H.a();
        for (int i3 = 0; i3 < a16.size(); i3++) {
            n0(i3).bindData(a16.get(i3), i3);
        }
    }

    private void m0() {
        LinearLayout linearLayout = this.f90906i;
        if (linearLayout == null) {
            return;
        }
        VideoReport.setElementId(linearLayout, QCircleDaTongConstant.ElementId.EM_XSJ_HOT_TOPIC_SWITCH);
    }

    private QFSMixFeedWaterFallHotTopicItemView n0(int i3) {
        LinearLayout linearLayout = this.f90905h;
        if (linearLayout == null) {
            return new QFSMixFeedWaterFallHotTopicItemView(getContext());
        }
        if (linearLayout.getChildCount() > i3) {
            return (QFSMixFeedWaterFallHotTopicItemView) this.f90905h.getChildAt(i3);
        }
        QFSMixFeedWaterFallHotTopicItemView qFSMixFeedWaterFallHotTopicItemView = new QFSMixFeedWaterFallHotTopicItemView(getContext());
        this.f90905h.addView(qFSMixFeedWaterFallHotTopicItemView);
        return qFSMixFeedWaterFallHotTopicItemView;
    }

    private int o0() {
        if (bz.j() < 1080) {
            return 3;
        }
        return 4;
    }

    private void p0() {
        List<QQCircleDitto$StItemInfo> list = this.G;
        if (list == null) {
            QLog.e("QFSMixFeedWaterFallHotTopicView", 1, "[inflateUpdateBtn] mAllInfoList is null");
        } else if (list.size() > o0()) {
            this.f90906i.setVisibility(0);
        } else {
            this.f90906i.setVisibility(8);
        }
    }

    private void q0() {
        Option targetView = Option.obtain().setUrl(QCircleSkinHelper.getInstance().getUrl("qvideo_skin_img_quanzi_huatirebang")).setTargetView(this.D);
        int i3 = I;
        Option requestHeight = targetView.setRequestWidth(i3).setRequestHeight(i3);
        requestHeight.setSupportRecycler(true);
        requestHeight.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(requestHeight);
    }

    private void r0(View view) {
        this.f90903e = (FrameLayout) view.findViewById(R.id.yqh);
        this.f90904f = (LinearLayout) view.findViewById(R.id.yom);
        this.f90906i = (LinearLayout) view.findViewById(R.id.yrd);
        this.f90907m = (ImageView) view.findViewById(R.id.f165963y83);
        this.C = (TextView) view.findViewById(R.id.f108726dw);
        this.D = (ImageView) view.findViewById(R.id.y4m);
        this.E = view.findViewById(R.id.y4l);
        this.f90905h = (LinearLayout) findViewById(R.id.xbs);
        this.H = new c(o0());
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void s0(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        Pair<Integer, Integer> h16 = d.h(getContext(), bVar.g());
        if (((Integer) h16.first).intValue() != 0 && ((Integer) h16.second).intValue() != 0) {
            ViewGroup.LayoutParams layoutParams = this.f90904f.getLayoutParams();
            layoutParams.width = ((Integer) h16.first).intValue();
            layoutParams.height = ((Integer) h16.second).intValue();
            this.f90904f.setLayoutParams(layoutParams);
            QLog.i("QFSMixFeedWaterFallHotTopicView", 1, "mIvFeedCover  measureWidthAndHeight  params.width : " + h16.first + " \uff5c params.height : " + h16.second);
            this.f90904f.setLayoutParams(layoutParams);
            k0();
            return;
        }
        QLog.e("QFSMixFeedWaterFallHotTopicView", 1, "[setWidthAndHeight] paramsResult.first == 0 || paramsResult.second == 0");
    }

    private void u0() {
        Drawable drawable;
        int color;
        TextView textView = this.C;
        if (textView != null) {
            if (QCircleSkinHelper.getInstance().isDarkMode()) {
                color = RFWApplication.getApplication().getColor(R.color.cbv);
            } else {
                color = RFWApplication.getApplication().getColor(R.color.cbw);
            }
            textView.setTextColor(color);
        }
        View view = this.E;
        if (view != null) {
            if (QCircleSkinHelper.getInstance().isDarkMode()) {
                drawable = RFWApplication.getApplication().getDrawable(R.drawable.kkp);
            } else {
                drawable = RFWApplication.getApplication().getDrawable(R.drawable.kkq);
            }
            view.setBackground(drawable);
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
        return R.layout.g4p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedWaterFallHotTopicView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(cx.a(4.0f), cx.a(4.0f), cx.a(4.0f), cx.a(4.0f));
        return layoutParams;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.yrd) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(500L);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.f90907m.startAnimation(rotateAnimation);
            l0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            s0(this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            this.F = bVar;
            s0(bVar);
            QQCircleDitto$StItemContainer i16 = d.i(bVar, String.valueOf(bVar.g().dittoFeed.dittoId.get()));
            if (i16 != null && i16.items.size() >= 1) {
                this.G = i16.items.get();
                p0();
                this.H.c(this.G);
                this.H.b();
                this.f90906i.setOnClickListener(this);
                l0();
                m0();
                q0();
                u0();
                return;
            }
            QLog.d("QFSMixFeedWaterFallHotTopicView", 1, "[bindData] stItemContainer == null");
            return;
        }
        QLog.e("QFSMixFeedWaterFallHotTopicView", 1, "[bindData] feedBlockData == null");
    }
}
