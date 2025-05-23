package com.qzone.component.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.reborn.event.QZoneFeedxRefreshEvent;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.qzone.widget.AvatarImageView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.Pair;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import ho.i;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneMessageBubbleBanner extends Banner {
    private AvatarImageView C;
    private TextView D;
    private ImageView E;
    private int F;
    protected Animation G;
    protected Animation H;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f46482h;

    /* renamed from: i, reason: collision with root package name */
    private AvatarImageView f46483i;

    /* renamed from: m, reason: collision with root package name */
    private AvatarImageView f46484m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(BaseActivity.class.getSimpleName(), view);
            if (QZoneMessageBubbleBanner.this.getContext() != null) {
                i.u().a(QZoneMessageBubbleBanner.this.getContext(), QZoneHelper.QZoneAppConstants.REFER_PUSH_BANNER, 1);
            }
            QZoneMessageBubbleBanner.this.g();
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(302, 506, 2), false, true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(BaseActivity.class.getSimpleName(), view);
            QZoneFeedxRefreshEvent qZoneFeedxRefreshEvent = new QZoneFeedxRefreshEvent();
            qZoneFeedxRefreshEvent.setContext(QZoneMessageBubbleBanner.this.getContext());
            qZoneFeedxRefreshEvent.setScrollToTop(true);
            SimpleEventBus.getInstance().dispatchEvent(qZoneFeedxRefreshEvent);
            QZoneMessageBubbleBanner.this.g();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneMessageBubbleBanner(Context context) {
        super(context);
        y();
    }

    private void B(com.qzone.feed.business.model.a aVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Pair<QZoneCountUserInfo, String>> arrayList2 = aVar.f47122f;
        if (arrayList2 != null) {
            Iterator<Pair<QZoneCountUserInfo, String>> it = arrayList2.iterator();
            while (it.hasNext()) {
                Pair<QZoneCountUserInfo, String> next = it.next();
                QZoneCountUserInfo qZoneCountUserInfo = next.first;
                if (qZoneCountUserInfo != null) {
                    if (!arrayList.contains(Long.valueOf(qZoneCountUserInfo.uin))) {
                        arrayList.add(Long.valueOf(next.first.uin));
                    }
                    if (arrayList.size() >= 3) {
                        break;
                    }
                }
            }
        }
        this.f46483i.setVisibility(8);
        this.f46484m.setVisibility(8);
        this.C.setVisibility(8);
        int size = arrayList.size();
        if (size == 1) {
            A(((Long) arrayList.get(0)).longValue(), this.f46483i);
            return;
        }
        if (size == 2) {
            A(((Long) arrayList.get(0)).longValue(), this.f46483i);
            A(((Long) arrayList.get(1)).longValue(), this.f46484m);
        } else {
            if (size != 3) {
                return;
            }
            A(((Long) arrayList.get(0)).longValue(), this.f46483i);
            A(((Long) arrayList.get(1)).longValue(), this.f46484m);
            A(((Long) arrayList.get(2)).longValue(), this.C);
        }
    }

    private View.OnClickListener v() {
        return new b();
    }

    private View.OnClickListener w() {
        return new a();
    }

    private void y() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hl9, (ViewGroup) this, true);
        this.f46482h = (LinearLayout) inflate.findViewById(R.id.yp5);
        this.f46483i = (AvatarImageView) inflate.findViewById(R.id.y5q);
        this.f46484m = (AvatarImageView) inflate.findViewById(R.id.y5r);
        this.C = (AvatarImageView) inflate.findViewById(R.id.y5s);
        this.D = (TextView) inflate.findViewById(R.id.f109286fe);
        this.E = (ImageView) inflate.findViewById(R.id.y5p);
        if (QQTheme.isNowThemeIsNightForQzone()) {
            this.f46482h.setBackgroundResource(R.drawable.nx8);
            this.D.setTextColor(getResources().getColor(R.color.black));
            this.E.setImageResource(R.drawable.gam);
        } else {
            this.f46482h.setBackgroundResource(R.drawable.nx7);
            this.D.setTextColor(getResources().getColor(R.color.f158017al3));
            this.E.setImageResource(R.drawable.gak);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 1;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 2;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (this.f46297e) {
            setVisibility(z16 ? 0 : 8);
            QLog.d("QZoneMessageBubbleBanner", 1, "internal_show  needShow = " + z16);
            if (z16) {
                u();
                this.f46298f = false;
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && getVisibility() == 0;
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        int i3;
        if (!this.f46297e || aVar == null) {
            return;
        }
        B(aVar);
        int i16 = aVar.f47118b;
        if (i16 == 1) {
            this.D.setText(l.a(R.string.f17674323));
            this.f46482h.setOnClickListener(w());
            this.F = 5;
            this.E.setVisibility(0);
            i3 = 506;
        } else if (i16 != 2) {
            i3 = 0;
        } else {
            this.D.setText(l.a(R.string.f17673322));
            this.f46482h.setOnClickListener(v());
            this.F = 5;
            this.E.setVisibility(8);
            i3 = 507;
        }
        this.f46298f = true;
        c();
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(302, i3, 1), false, true);
    }

    protected void u() {
        Animation animation = this.H;
        if (animation == null || this.G == null) {
            return;
        }
        startAnimation(animation);
    }

    public int x() {
        return this.F;
    }

    protected void z(final long j3) {
        c cVar = new c();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154776cg);
        this.G = loadAnimation;
        loadAnimation.setAnimationListener(cVar);
        Animation.AnimationListener animationListener = new Animation.AnimationListener() { // from class: com.qzone.component.banner.QZoneMessageBubbleBanner.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.component.banner.QZoneMessageBubbleBanner.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZoneMessageBubbleBanner.this.l()) {
                            QZoneMessageBubbleBanner qZoneMessageBubbleBanner = QZoneMessageBubbleBanner.this;
                            qZoneMessageBubbleBanner.startAnimation(qZoneMessageBubbleBanner.G);
                        }
                    }
                }, j3);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154775cf);
        this.H = loadAnimation2;
        loadAnimation2.setAnimationListener(animationListener);
    }

    private void A(long j3, AvatarImageView avatarImageView) {
        avatarImageView.setVisibility(0);
        avatarImageView.setStrokeWidth(ar.e(1.0f));
        avatarImageView.setStrokeColor(-1);
        avatarImageView.j(j3);
    }

    public QZoneMessageBubbleBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y();
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        z(5000L);
        setVisibility(8);
        this.F = 1025;
        this.f46297e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QZoneMessageBubbleBanner.this.g();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
