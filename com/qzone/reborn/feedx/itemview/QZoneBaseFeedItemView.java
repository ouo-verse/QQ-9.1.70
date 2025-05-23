package com.qzone.reborn.feedx.itemview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.misc.network.report.QzoneFeedVisitorReportService;
import com.qzone.proxy.covercomponent.QZoneCoverUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.feedx.widget.i;
import com.qzone.reborn.util.p;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QZoneConfigHelper;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class QZoneBaseFeedItemView extends QZoneBaseWidgetView<BusinessFeedData> implements View.OnClickListener, de.c, vg.d {
    public BusinessFeedData C;
    private int D;

    /* renamed from: e, reason: collision with root package name */
    protected final vg.b f54810e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f54811f;

    /* renamed from: h, reason: collision with root package name */
    protected float f54812h;

    /* renamed from: i, reason: collision with root package name */
    protected float f54813i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f54814m;

    public QZoneBaseFeedItemView(Context context) {
        super(context);
        this.f54810e = new vg.b();
        this.D = 255;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.f54814m = QZoneConfigHelper.u();
    }

    private void o0(final BusinessFeedData businessFeedData) {
        RFWIocAbilityProvider.g().getIoc(gf.e.class).originView(this).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedx.itemview.a
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QZoneBaseFeedItemView.this.w0(businessFeedData, (gf.e) obj);
            }
        }).run();
    }

    private void u0() {
        com.qzone.reborn.feedx.viewmodel.f fVar;
        int color = getResources().getColor(R.color.qui_common_fill_light_primary);
        x0(color);
        ColorDrawable colorDrawable = new ColorDrawable(color);
        if (l0() != null && (fVar = (com.qzone.reborn.feedx.viewmodel.f) p(com.qzone.reborn.feedx.viewmodel.f.class)) != null) {
            if (fVar.M1().getValue() != null) {
                this.D = fVar.M1().getValue().intValue();
            } else {
                this.D = QZoneCoverUtils.getSuperCoverTrans(null);
            }
            colorDrawable.setAlpha(this.D);
        }
        setBackground(colorDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(BusinessFeedData businessFeedData, gf.e eVar) {
        eVar.w5(this, businessFeedData);
    }

    private void x0(int i3) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        try {
            QLog.i("QZoneQUIProfile", 1, "QZoneBaseFeedItemView backgroundColor: " + Integer.toHexString(i3));
        } catch (Exception e16) {
            QLog.e("QZoneQUIProfile", 1, "QZoneBaseFeedItemView printBackgroundColor error:", e16);
        }
    }

    @Override // de.c
    public boolean Q() {
        return true;
    }

    @Override // com.qzone.reborn.widget.QZoneBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public Activity getHostActivity() {
        Activity activity = this.f54811f;
        return activity != null ? activity : super.getHostActivity();
    }

    protected abstract String getLogTag();

    @Override // vg.d
    public vg.c i0() {
        return this.f54810e;
    }

    public void initView() {
        this.f54810e.p(q0());
        this.f54810e.n(s0());
        this.f54810e.i(this, this.mParentView);
        this.f54811f = i.c(this);
        View findViewById = findViewById(R.id.n2_);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        setClickable(true);
        setOnClickListener(this);
        u0();
        AccessibilityUtil.n(this, false);
    }

    @Override // de.c
    public boolean j() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f54810e.l();
        QzoneFeedVisitorReportService.f().i(this.C);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!getData().isFakeFeed() && v0()) {
            if (view.getId() == R.id.n2_ && getData().getOriginalInfo() != null) {
                if (getData().cellFeedCommInfo != null && getData().cellFeedCommInfo.appid == 7035) {
                    QLog.d(getLogTag(), 1, "onClick favor feed dont launch original feed");
                } else {
                    p0();
                }
            } else if (!x.f55790a.c(q0())) {
                xg.d.a(getData(), this.f54811f, this);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f54810e.m();
        QzoneFeedVisitorReportService.f().k(ef.b.a(this.C));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.f54814m && p.b(motionEvent.getX(), motionEvent.getY(), this.f54812h, this.f54813i)) {
                return true;
            }
        } else {
            this.f54812h = motionEvent.getX();
            this.f54813i = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.f54814m && p.b(motionEvent.getX(), motionEvent.getY(), this.f54812h, this.f54813i)) {
                return false;
            }
        } else {
            this.f54812h = motionEvent.getX();
            this.f54813i = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void p0() {
        xg.d.a(getData().getOriginalInfo(), this.f54811f, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int q0() {
        return k0().getPageType();
    }

    public Object r0(Class<? extends vg.a> cls) {
        return this.f54810e.f(cls);
    }

    protected abstract List<Class<? extends vg.a>> s0();

    public boolean v0() {
        return true;
    }

    public void y0(Integer num) {
        this.D = num.intValue();
        Drawable background = getBackground();
        if (background != null) {
            background.setAlpha(num.intValue());
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != null) {
            drawable.setAlpha(this.D);
        }
        super.setBackground(drawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData == null) {
            return;
        }
        this.C = businessFeedData;
        this.f54810e.o(businessFeedData, i3);
        o0(businessFeedData);
    }
}
