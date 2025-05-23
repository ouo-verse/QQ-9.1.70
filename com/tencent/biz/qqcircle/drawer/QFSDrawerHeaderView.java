package com.tencent.biz.qqcircle.drawer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCirclePersonEditUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSMedalRedPointRemoveEvent;
import com.tencent.biz.qqcircle.events.QFSRocketNumUpdateEvent;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import trpcprotocol.feedcloud.sidebar.MedalInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDrawerHeaderView extends LinearLayout implements View.OnClickListener, SimpleEventReceiver {
    private final TextView C;
    private final View D;
    private final View E;
    private final View F;
    private final View G;
    private final View H;
    private final View I;
    private final ImageView J;
    private final ImageView K;
    private final TextView L;

    /* renamed from: d, reason: collision with root package name */
    private d f84382d;

    /* renamed from: e, reason: collision with root package name */
    private final TextView f84383e;

    /* renamed from: f, reason: collision with root package name */
    private final ImageView f84384f;

    /* renamed from: h, reason: collision with root package name */
    private final TextView f84385h;

    /* renamed from: i, reason: collision with root package name */
    private final View f84386i;

    /* renamed from: m, reason: collision with root package name */
    private final ImageView f84387m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSDrawerHeaderView> f84388a;

        public a(QFSDrawerHeaderView qFSDrawerHeaderView) {
            this.f84388a = new WeakReference<>(qFSDrawerHeaderView);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (this.f84388a.get() != null && this.f84388a.get().f84382d != null) {
                d dVar = this.f84388a.get().f84382d;
                if (!(!RFSafeListUtils.isEmpty(dVar.c()))) {
                    return buildElementParams;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MEDAL_CONTENT, dVar.c().get(0).name);
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MEDAL_TAG, Integer.valueOf(dVar.c().get(0).type));
                buildElementParams.put("xsj_if_red_dot", Integer.valueOf(dVar.i() ? 1 : 0));
            }
            return buildElementParams;
        }
    }

    public QFSDrawerHeaderView(Context context) {
        this(context, null);
    }

    private void c(List<MedalInfo> list, boolean z16) {
        int i3;
        int i16;
        int i17;
        boolean z17 = !RFSafeListUtils.isEmpty(list);
        QLog.d("QFSDrawerHeaderView", 1, "[bindMedalIcon] needShowRedPoint: " + z16 + ", hasMedal: " + z17);
        int i18 = 8;
        if (z17) {
            this.G.setVisibility(8);
            this.I.setVisibility(8);
            this.f84386i.setVisibility(0);
            View view = this.E;
            if (z16) {
                i18 = 0;
            }
            view.setVisibility(i18);
            MedalInfo medalInfo = list.get(0);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestHeight(DisplayUtil.dip2px(this.f84387m.getContext(), 18.0f)).setRequestWidth(DisplayUtil.dip2px(this.f84387m.getContext(), 18.0f)).setUrl(medalInfo.iconURL).setTargetView(this.f84387m));
            this.C.setText(medalInfo.name);
            this.D.setBackground(g(this.C.getContext(), R.color.qui_common_fill_standard_primary, 1.0f, true));
            return;
        }
        if (z16) {
            this.f84386i.setVisibility(8);
            this.G.setVisibility(8);
            this.I.setVisibility(0);
            List<MedalInfo> d16 = this.f84382d.d();
            boolean z18 = !RFSafeListUtils.isEmpty(d16);
            ImageView imageView = this.J;
            if (z18) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            ImageView imageView2 = this.K;
            if (z18 && d16.size() > 1) {
                i18 = 0;
            }
            imageView2.setVisibility(i18);
            if (z18) {
                ImageView[] imageViewArr = {this.J, this.K};
                for (int i19 = 0; i19 < Math.min(d16.size(), 2); i19++) {
                    String str = d16.get(i19).iconURL;
                    ImageView imageView3 = imageViewArr[i19];
                    QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestHeight(DisplayUtil.dip2px(imageView3.getContext(), 18.0f)).setRequestWidth(DisplayUtil.dip2px(imageView3.getContext(), 18.0f)).setUrl(str).setTargetView(imageView3));
                }
                TextView textView = this.L;
                textView.setBackground(g(textView.getContext(), R.color.qui_common_brand_standard, 0.1f, true));
            } else {
                TextView textView2 = this.L;
                textView2.setBackground(g(textView2.getContext(), R.color.qui_common_brand_standard, 0.1f, false));
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.L.getLayoutParams();
            if (z18) {
                i16 = DisplayUtil.dip2px(this.I.getContext(), 9.0f);
            } else {
                i16 = 0;
            }
            layoutParams.leftMargin = i16;
            this.L.setLayoutParams(layoutParams);
            int paddingRight = this.L.getPaddingRight();
            TextView textView3 = this.L;
            if (z18) {
                i17 = DisplayUtil.dip2px(this.I.getContext(), 20.0f);
            } else {
                i17 = paddingRight;
            }
            textView3.setPadding(i17, 0, paddingRight, 0);
            return;
        }
        m();
    }

    private void d() {
        View view;
        d dVar = this.f84382d;
        if (dVar == null || !dVar.i()) {
            return;
        }
        if ((!RFSafeListUtils.isEmpty(this.f84382d.c())) && (view = this.E) != null) {
            view.setVisibility(8);
        } else {
            m();
        }
    }

    private void e() {
        RFWLog.d("QFSDrawerHeaderView", RFWLog.USR, "clearRocketRedPoint");
        d dVar = this.f84382d;
        if (dVar == null) {
            return;
        }
        dVar.j();
        View view = this.F;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void f() {
        if (this.f84382d == null) {
            return;
        }
        VideoReport.setElementId(this.f84383e, QCircleDaTongConstant.ElementId.EM_XSJ_USER_INFO);
        TextView textView = this.f84383e;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(textView, exposurePolicy);
        VideoReport.setElementId(this.f84384f, QCircleDaTongConstant.ElementId.EM_XSJ_USER_INFO);
        VideoReport.setElementExposePolicy(this.f84384f, exposurePolicy);
        VideoReport.setElementId(this.H, QCircleDaTongConstant.ElementId.EM_XSJ_ROCKETNUM_ENTER);
        VideoReport.setElementExposePolicy(this.H, exposurePolicy);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_amount", Long.valueOf(this.f84382d.f()));
        VideoReport.setElementParams(this.H, buildElementParams);
        boolean z16 = !RFSafeListUtils.isEmpty(this.f84382d.c());
        boolean i3 = this.f84382d.i();
        if (z16) {
            VideoReport.setElementId(this.f84386i, QCircleDaTongConstant.ElementId.EM_XSJ_MEDAL_TAG);
            VideoReport.setElementExposePolicy(this.f84386i, exposurePolicy);
            VideoReport.setEventDynamicParams(this.f84386i, new a(this));
        } else if (i3) {
            VideoReport.setElementId(this.I, QCircleDaTongConstant.ElementId.EM_XSJ_MEDAL_GET_ICON);
            VideoReport.setElementExposePolicy(this.I, exposurePolicy);
        } else {
            VideoReport.setElementId(this.G, QCircleDaTongConstant.ElementId.EM_XSJ_MEDAL_WALL_ICON);
            VideoReport.setElementExposePolicy(this.G, exposurePolicy);
        }
    }

    private Drawable g(Context context, int i3, float f16, boolean z16) {
        float f17;
        float f18;
        float f19;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(QFSQUIUtilsKt.c(context, i3, f16));
        int dip2px = DisplayUtil.dip2px(context, 10.0f);
        float[] fArr = new float[8];
        float f26 = 0.0f;
        if (z16) {
            f17 = 0.0f;
        } else {
            f17 = dip2px;
        }
        fArr[0] = f17;
        if (z16) {
            f18 = 0.0f;
        } else {
            f18 = dip2px;
        }
        fArr[1] = f18;
        float f27 = dip2px;
        fArr[2] = f27;
        fArr[3] = f27;
        fArr[4] = f27;
        fArr[5] = f27;
        if (z16) {
            f19 = 0.0f;
        } else {
            f19 = f27;
        }
        fArr[6] = f19;
        if (!z16) {
            f26 = f27;
        }
        fArr[7] = f26;
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    private void h(QCirclePersonEditUpdateEvent qCirclePersonEditUpdateEvent) {
        if (qCirclePersonEditUpdateEvent.getNick() != null && !TextUtils.isEmpty(qCirclePersonEditUpdateEvent.getNick().showText)) {
            String str = qCirclePersonEditUpdateEvent.getNick().showText;
            QLog.d("QFSDrawerHeaderView", 1, "[handleEditUpdate] nick:" + str);
            this.f84383e.setText(str);
            ViewGroup.LayoutParams layoutParams = this.f84383e.getLayoutParams();
            layoutParams.width = -2;
            this.f84383e.setLayoutParams(layoutParams);
        }
    }

    private void i() {
        QLog.d("QFSDrawerHeaderView", 4, "[handleRedPointRemove] ");
        View view = this.I;
        if (view != null && view.getVisibility() == 0) {
            this.I.setVisibility(8);
            m();
            return;
        }
        View view2 = this.E;
        if (view2 != null && view2.getVisibility() == 0) {
            this.E.setVisibility(8);
        }
    }

    private void j() {
        d dVar = this.f84382d;
        if (dVar != null && !TextUtils.isEmpty(dVar.b())) {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.f84382d.b());
        }
    }

    private void k() {
        if (this.f84382d == null) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(this.f84382d.h());
        com.tencent.biz.qqcircle.launcher.c.d0(getContext(), qCircleInitBean);
    }

    private void l() {
        if (this.f84382d == null) {
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.g(getContext(), this.f84382d.g());
    }

    private void m() {
        View view = this.G;
        if (view != null && this.I != null && this.f84386i != null) {
            view.setVisibility(0);
            this.I.setVisibility(8);
            this.f84386i.setVisibility(8);
        }
    }

    private void n(long j3) {
        if (this.f84385h == null) {
            return;
        }
        QLog.d("QFSDrawerHeaderView", 1, "[updateRocketNum] count: " + j3);
        String g16 = r.g(j3, false);
        this.f84385h.setText(getContext().getResources().getString(R.string.f194934d9) + " " + g16);
    }

    public void b(d dVar) {
        int i3;
        this.f84382d = dVar;
        this.f84383e.setText(dVar.e());
        n(dVar.f());
        c(dVar.c(), dVar.i());
        this.G.setOnClickListener(this);
        this.f84383e.setOnClickListener(this);
        this.f84384f.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.f84386i.setOnClickListener(this);
        View view = this.F;
        if (dVar.a()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        f();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSRocketNumUpdateEvent.class);
        arrayList.add(QCirclePersonEditUpdateEvent.class);
        arrayList.add(QFSMedalRedPointRemoveEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.f368615p && id5 != R.id.f368515o) {
            if (id5 != R.id.f367815h && id5 != R.id.f368015j && id5 != R.id.f368315m) {
                if (id5 == R.id.f369015t) {
                    l();
                    e();
                }
            } else {
                j();
                d();
            }
        } else {
            k();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePersonEditUpdateEvent) {
            h((QCirclePersonEditUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSMedalRedPointRemoveEvent) {
            i();
        } else if (simpleBaseEvent instanceof QFSRocketNumUpdateEvent) {
            n(((QFSRocketNumUpdateEvent) simpleBaseEvent).getCount());
        }
    }

    public QFSDrawerHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.g_r, (ViewGroup) this, true);
        this.f84383e = (TextView) findViewById(R.id.f368515o);
        this.f84384f = (ImageView) findViewById(R.id.f368615p);
        this.f84385h = (TextView) findViewById(R.id.f369115u);
        this.f84386i = findViewById(R.id.f368015j);
        this.f84387m = (ImageView) findViewById(R.id.f367715g);
        this.C = (TextView) findViewById(R.id.f367515e);
        this.D = findViewById(R.id.f367615f);
        this.E = findViewById(R.id.f367915i);
        this.F = findViewById(R.id.f52302_f);
        this.G = findViewById(R.id.f367815h);
        this.H = findViewById(R.id.f369015t);
        this.I = findViewById(R.id.f368315m);
        this.J = (ImageView) findViewById(R.id.f368115k);
        this.K = (ImageView) findViewById(R.id.f368215l);
        this.L = (TextView) findViewById(R.id.f368415n);
    }
}
