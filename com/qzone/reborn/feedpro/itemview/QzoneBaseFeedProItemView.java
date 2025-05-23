package com.qzone.reborn.feedpro.itemview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.misc.network.report.QzoneFeedProVisitorReportService;
import com.qzone.proxy.covercomponent.QZoneCoverUtils;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.feedx.viewmodel.f;
import com.qzone.reborn.feedx.widget.i;
import com.qzone.reborn.util.p;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QZoneConfigHelper;
import de.e;
import java.util.List;
import vg.d;

/* loaded from: classes37.dex */
public abstract class QzoneBaseFeedProItemView extends QZoneBaseWidgetView<CommonFeed> implements View.OnClickListener, de.c, d {
    public CommonFeed C;
    private int D;

    /* renamed from: e, reason: collision with root package name */
    protected final ne.b f53916e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f53917f;

    /* renamed from: h, reason: collision with root package name */
    protected float f53918h;

    /* renamed from: i, reason: collision with root package name */
    protected float f53919i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f53920m;

    public QzoneBaseFeedProItemView(Context context) {
        super(context);
        this.f53916e = new ne.b();
        this.D = 255;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.f53920m = QZoneConfigHelper.u();
    }

    private void o0(final CommonFeed commonFeed) {
        RFWIocAbilityProvider.g().getIoc(e.class).originView(this).done(new OnPromiseResolved() { // from class: com.qzone.reborn.feedpro.itemview.a
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QzoneBaseFeedProItemView.this.v0(commonFeed, (e) obj);
            }
        }).run();
    }

    private void s0() {
        f fVar;
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.qui_common_fill_light_primary));
        if (l0() != null && (fVar = (f) p(f.class)) != null) {
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
    public /* synthetic */ void v0(CommonFeed commonFeed, e eVar) {
        eVar.c(this, commonFeed);
    }

    @Override // de.c
    public boolean Q() {
        return true;
    }

    @Override // com.qzone.reborn.widget.QZoneBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public Activity getHostActivity() {
        Activity activity = this.f53917f;
        return activity != null ? activity : super.getHostActivity();
    }

    protected abstract String getLogTag();

    @Override // vg.d
    public vg.c i0() {
        return this.f53916e;
    }

    public void initView() {
        this.f53916e.o(q0());
        this.f53916e.m(r0());
        this.f53916e.h(this, this.mParentView);
        this.f53917f = i.c(this);
        View findViewById = findViewById(R.id.mwb);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        setClickable(true);
        setOnClickListener(this);
        s0();
        AccessibilityUtil.n(this, false);
    }

    @Override // de.c
    public boolean j() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f53916e.k();
        QzoneFeedProVisitorReportService.h().k(this.C);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!CommonFeedExtKt.isFakeFeed(getData()) && u0()) {
            if (view.getId() == R.id.mwb && getData().getCellOrigin() != null) {
                if (getData().getCellCommon() != null && getData().getCellCommon().getAppId() == 7035) {
                    QLog.d(getLogTag(), 1, "onClick favor feed dont launch original feed");
                } else {
                    p0();
                }
            } else if (!x.f55790a.c(q0())) {
                ho.i.f().b(this.f53917f, getData(), this, 0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f53916e.l();
        QzoneFeedProVisitorReportService.h().l(CommonFeedExtKt.getFeedUniqueKey(this.C));
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.f53920m && p.b(motionEvent.getX(), motionEvent.getY(), this.f53918h, this.f53919i)) {
                return true;
            }
        } else {
            this.f53918h = motionEvent.getX();
            this.f53919i = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.f53920m && p.b(motionEvent.getX(), motionEvent.getY(), this.f53918h, this.f53919i)) {
                return false;
            }
        } else {
            this.f53918h = motionEvent.getX();
            this.f53919i = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void p0() {
        ho.i.f().b(this.f53917f, CommonFeedExtKt.getCellOriginFeed(getData()), this, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int q0() {
        return k0().getPageType();
    }

    protected abstract List<Class<? extends ne.a>> r0();

    public boolean u0() {
        return true;
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
    public void bindData(CommonFeed commonFeed, int i3) {
        if (commonFeed == null) {
            return;
        }
        this.C = commonFeed;
        this.f53916e.n(commonFeed, i3);
        o0(commonFeed);
    }
}
