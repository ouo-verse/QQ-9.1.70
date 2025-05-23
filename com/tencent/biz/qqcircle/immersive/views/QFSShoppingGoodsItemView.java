package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCircleShoppingGoodsInfoBean;
import com.tencent.biz.qqcircle.events.QCircleShoppingLayerExitEvent;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSShoppingGoodsItemView extends QCircleBaseWidgetView<QCircleShoppingGoodsInfoBean> implements View.OnClickListener, SimpleEventReceiver {
    private TextView C;
    private Button D;
    private ArrayList<String> E;
    private String F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private QCircleShoppingGoodsInfoBean f90467d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.adapter.x f90468e;

    /* renamed from: f, reason: collision with root package name */
    private ViewPager2 f90469f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90470h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90471i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f90472m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i3, float f16, int i16) {
            super.onPageScrolled(i3, f16, i16);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            QFSShoppingGoodsItemView.this.u0(i3);
            QFSShoppingGoodsItemView.this.G = i3;
        }
    }

    public QFSShoppingGoodsItemView(@NonNull Context context) {
        super(context);
        this.E = new ArrayList<>();
        q0(this);
    }

    private void n0() {
        if (this.f90467d != null && this.D != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GOODS_ID, this.f90467d.getId());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GOODS_NAME, this.f90467d.getDesc());
            VideoReport.setElementId(this.D, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCTS_BUY_BUTTON);
            VideoReport.setElementParams(this.D, hashMap);
            VideoReport.setElementExposePolicy(this.D, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(this.D, ClickPolicy.REPORT_ALL);
        }
    }

    private void o0() {
        if (this.f90468e == null) {
            p0();
        }
        this.f90469f.setAdapter(this.f90468e);
        this.f90469f.registerOnPageChangeCallback(new a());
    }

    private void p0() {
        com.tencent.biz.qqcircle.immersive.adapter.x xVar = new com.tencent.biz.qqcircle.immersive.adapter.x(this.f90467d, getContext());
        this.f90468e = xVar;
        xVar.setEnableLoop(false);
        this.f90468e.notifyDataSetChanged();
    }

    private void q0(View view) {
        this.f90469f = (ViewPager2) view.findViewById(R.id.f84704mz);
        this.f90470h = (TextView) view.findViewById(R.id.f107136_l);
        this.f90471i = (TextView) view.findViewById(R.id.f108366cx);
        this.f90472m = (TextView) view.findViewById(R.id.f108376cy);
        this.C = (TextView) view.findViewById(R.id.f108356cw);
        Button button = (Button) view.findViewById(R.id.f84674mw);
        this.D = button;
        button.setOnClickListener(this);
    }

    private void r0() {
        if (this.f90467d != null && this.f90469f != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GOODS_ID, this.f90467d.getId());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GOODS_NAME, this.f90467d.getDesc());
            VideoReport.setElementId(this.f90469f, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCTS_INFORMATION);
            VideoReport.setElementParams(this.f90469f, hashMap);
            VideoReport.setElementExposePolicy(this.f90469f, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(this.f90469f, ClickPolicy.REPORT_NONE);
        }
    }

    private void s0() {
        QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = this.f90467d;
        if (qCircleShoppingGoodsInfoBean != null) {
            this.C.setText(qCircleShoppingGoodsInfoBean.getDesc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i3) {
        this.f90470h.setText((i3 + 1) + "/" + this.F);
    }

    private void v0() {
        double d16;
        QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = this.f90467d;
        if (qCircleShoppingGoodsInfoBean != null) {
            try {
                d16 = Double.parseDouble(qCircleShoppingGoodsInfoBean.getPrice()) / 100.0d;
            } catch (ClassCastException unused) {
                QLog.d("QFSShoppingGoodsItemView", 1, "price format is wrong");
                d16 = 0.0d;
            }
            this.f90471i.setText(String.valueOf(d16));
            RFWTypefaceUtil.setNumberTypeface(this.f90471i, false);
        }
    }

    private void w0() {
        QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = this.f90467d;
        if (qCircleShoppingGoodsInfoBean != null) {
            this.f90472m.setText(qCircleShoppingGoodsInfoBean.getSales());
        }
    }

    private void x0() {
        QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = this.f90467d;
        if (qCircleShoppingGoodsInfoBean != null) {
            ArrayList<String> imageUrls = qCircleShoppingGoodsInfoBean.getImageUrls();
            this.E = imageUrls;
            this.F = String.valueOf(imageUrls.size());
            this.f90470h.setText("1/" + this.F);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleShoppingLayerExitEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g5s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSShoppingGoodsItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean, int i3) {
        if (qCircleShoppingGoodsInfoBean == null) {
            return;
        }
        this.f90467d = qCircleShoppingGoodsInfoBean;
        s0();
        v0();
        w0();
        x0();
        p0();
        o0();
        r0();
        n0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.f84674mw) {
            com.tencent.biz.qqcircle.launcher.c.h(view.getContext(), this.f90467d.getJumpUrl(), "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleShoppingLayerExitEvent) {
            int curPosition = ((QCircleShoppingLayerExitEvent) simpleBaseEvent).getCurPosition();
            ViewPager2 viewPager2 = this.f90469f;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(curPosition, false);
            }
        }
    }
}
