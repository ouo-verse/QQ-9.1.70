package com.tencent.biz.qqcircle.immersive.views.banner.bottom.autoslideguide;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.immersive.feed.event.an;
import com.tencent.biz.qqcircle.immersive.manager.e;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.c;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAutoSlideGuideView extends c implements View.OnClickListener {
    private static final float M = cx.a(44.0f);
    private View D;
    private View E;
    private View F;
    private TextView G;
    private TextView H;
    private boolean I;
    private boolean J;
    private boolean K;
    private final Runnable L;

    public QFSAutoSlideGuideView(@NonNull com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        this.J = true;
        this.K = false;
        this.L = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.autoslideguide.QFSAutoSlideGuideView.1
            @Override // java.lang.Runnable
            public void run() {
                QFSAutoSlideGuideView.this.onElementInactivated();
            }
        };
    }

    private void A() {
        View view;
        if (this.D != null && (view = this.F) != null && view.getVisibility() != 0 && this.J && this.E != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.D.getContext(), R.anim.f154548b2);
            loadAnimation.setDuration(250L);
            loadAnimation.setStartOffset(80L);
            loadAnimation.setInterpolator(new LinearOutSlowInInterpolator());
            this.F.startAnimation(loadAnimation);
            View view2 = this.D;
            float f16 = M;
            view2.setTranslationY(f16);
            this.D.animate().translationYBy(-f16).setInterpolator(new LinearInterpolator()).setDuration(250L);
            this.E.setTranslationY(f16);
            this.E.animate().translationYBy(-f16).setInterpolator(new LinearInterpolator()).setDuration(250L);
        }
    }

    private void t() {
        if (this.f90602e == null) {
            return;
        }
        String a16 = a.a();
        if (a16 != null && !TextUtils.equals(this.f90602e.f398449id.get(), a16)) {
            y(false);
        }
        a.c(this.f90602e.f398449id.get());
    }

    private void u(String str, View view) {
        if (view != null && this.f90602e != null) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_AUTOPLAY_PLAYING_GUIDE);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_feed_id", this.f90602e.f398449id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f90602e.poster.f398463id.get());
            VideoReport.reportEvent(str, view, hashMap);
        }
    }

    private void v(View view) {
        QCircleSettingBean qCircleSettingBean = new QCircleSettingBean();
        qCircleSettingBean.setFromReportBean(p().m466clone());
        com.tencent.biz.qqcircle.launcher.c.i0(view.getContext(), qCircleSettingBean);
        n().removeCallbacks(this.L);
        n().postDelayed(this.L, 500L);
        u("dt_clck", this.F);
    }

    private void w(an anVar) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (anVar.d() <= 0 && (feedCloudMeta$StFeed = this.f90602e) != null && this.J && a.b(feedCloudMeta$StFeed, this.f90603f, p().getDtPageId()) && anVar.e() > 2000) {
            QLog.d("QFSAutoSlideGuideView", 1, "Show Auto Slide Guide Animation");
            this.J = false;
            this.I = false;
            e.a().notifyGroupActivate(this);
        }
    }

    private void x(@NonNull View view) {
        this.D = view.findViewById(R.id.f34510zc);
        this.E = view.findViewById(R.id.f39941d1);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f33900xp);
        if (viewStub == null) {
            return;
        }
        View findViewById = viewStub.inflate().findViewById(R.id.f33890xo);
        this.F = findViewById;
        this.G = (TextView) findViewById.findViewById(R.id.t08);
        this.H = (TextView) this.F.findViewById(R.id.t07);
        this.F.setOnClickListener(this);
    }

    private void y(boolean z16) {
        int i3;
        View view = this.F;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private void z() {
        int i3;
        if (this.G != null && this.H != null) {
            A();
            y(true);
            a.d(true);
            if (bz.p()) {
                i3 = R.string.f181553e3;
            } else {
                i3 = R.string.f181543e2;
            }
            this.G.setText(h.a(i3));
            this.H.setText(h.a(R.string.f181533e1));
            u("dt_imp", this.F);
            return;
        }
        QLog.d("QFSAutoSlideGuideView", 1, "mGuideText or mGoSetting is null");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void f(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.f(hVar);
        if (this.I && (hVar instanceof an)) {
            w((an) hVar);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 120;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(b bVar, int i3) {
        super.h(bVar, i3);
        t();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        String str;
        if (this.K) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[isElementCanActivate] ");
            sb5.append(this);
            sb5.append(" is operate once, do not show again. feed id =");
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            sb5.append(str);
            sb5.append(", getContextHashCode =");
            sb5.append(getContextHashCode());
            sb5.append(", mIsClicked =");
            sb5.append(this.K);
            QLog.d("QFSAutoSlideGuideView", 1, sb5.toString());
            return false;
        }
        return a.b(this.f90602e, this.f90603f, p().getDtPageId());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f33890xo) {
            v(view);
            this.K = true;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d("QFSAutoSlideGuideView", 1, "[onElementActivated]");
        x(this.f90604h);
        if (this.K) {
            y(false);
            QLog.d("QFSAutoSlideGuideView", 1, "auto slide is clicked");
            return;
        }
        View view = this.F;
        if (view != null && view.getVisibility() != 0) {
            if (!this.J) {
                z();
            }
            this.I = true;
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        y(false);
        this.I = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        n().removeCallbacks(this.L);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }
}
