package com.qzone.album.ui.widget;

import NS_MOBILE_PHOTO.TabTimeLine;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView;
import com.qzone.album.business.photolist.ui.timeline.view.RecentPhotoTimeLineView;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.TimeLine;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumTimeLineView {

    /* renamed from: a, reason: collision with root package name */
    private c5.a f44140a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f44141b;

    /* renamed from: d, reason: collision with root package name */
    private View f44143d;

    /* renamed from: e, reason: collision with root package name */
    private View f44144e;

    /* renamed from: f, reason: collision with root package name */
    private AbstractTimeLineView f44145f;

    /* renamed from: g, reason: collision with root package name */
    private View f44146g;

    /* renamed from: l, reason: collision with root package name */
    private View f44151l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f44152m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f44153n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f44154o;

    /* renamed from: q, reason: collision with root package name */
    private AnimationDrawable f44156q;

    /* renamed from: r, reason: collision with root package name */
    private AnimationDrawable f44157r;

    /* renamed from: s, reason: collision with root package name */
    private long f44158s;

    /* renamed from: t, reason: collision with root package name */
    private com.qzone.album.business.albumlist.fragment.e f44159t;

    /* renamed from: c, reason: collision with root package name */
    private SparseIntArray f44142c = new SparseIntArray(12);

    /* renamed from: h, reason: collision with root package name */
    private long f44147h = 0;

    /* renamed from: i, reason: collision with root package name */
    private Animation f44148i = null;

    /* renamed from: j, reason: collision with root package name */
    private Animation f44149j = null;

    /* renamed from: k, reason: collision with root package name */
    private int f44150k = 500;

    /* renamed from: p, reason: collision with root package name */
    private long f44155p = -1;

    /* renamed from: u, reason: collision with root package name */
    private com.qzone.album.business.photolist.ui.timeline.a f44160u = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AlbumTimeLineView.this.t(false);
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
            com.qzone.album.env.common.a.m().P(368, 2, "8", true, null);
            AlbumTimeLineView.this.t(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AlbumTimeLineView(Activity activity, View view, c5.a aVar, long j3, com.qzone.album.business.albumlist.fragment.e eVar) {
        this.f44141b = activity;
        this.f44143d = view;
        this.f44140a = aVar;
        this.f44158s = j3;
        this.f44159t = eVar;
        l();
    }

    private Drawable f(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3 * 1000);
        try {
            return this.f44141b.getResources().getDrawable(this.f44142c.get(calendar.get(2) + 1));
        } catch (Exception e16) {
            QZLog.e("QZonePhotoListTimeLine.", "getDrawableByMonth catch an exception.", e16);
            return null;
        }
    }

    public static boolean g(int i3, long j3) {
        return u5.b.D(h(i3, j3), false);
    }

    private static String h(int i3, long j3) {
        return "AlbumTimeLineView_" + i3 + "_" + j3 + "_" + com.qzone.album.env.common.a.m().s();
    }

    private void i() {
        this.f44142c.clear();
        this.f44142c.put(1, R.drawable.hyv);
        this.f44142c.put(2, R.drawable.hyw);
        this.f44142c.put(3, R.drawable.hyx);
        this.f44142c.put(4, R.drawable.hyy);
        this.f44142c.put(5, R.drawable.hyz);
        this.f44142c.put(6, R.drawable.f162354hz0);
        this.f44142c.put(7, R.drawable.f162355hz1);
        this.f44142c.put(8, R.drawable.f162356hz2);
        this.f44142c.put(9, R.drawable.f162357hz3);
        this.f44142c.put(10, R.drawable.hys);
        this.f44142c.put(11, R.drawable.hyt);
        this.f44142c.put(12, R.drawable.hyu);
    }

    private void j() {
        if (this.f44151l == null) {
            this.f44151l = ((ViewStub) this.f44141b.findViewById(R.id.f165896dt3)).inflate();
        }
        this.f44144e = this.f44143d.findViewById(R.id.i19);
        this.f44146g = this.f44143d.findViewById(R.id.fqc);
        RecentPhotoTimeLineView recentPhotoTimeLineView = (RecentPhotoTimeLineView) this.f44143d.findViewById(R.id.i18);
        this.f44145f = recentPhotoTimeLineView;
        Activity activity = this.f44141b;
        if (activity instanceof Activity) {
            recentPhotoTimeLineView.setPaddingForTimeLineHeader(activity);
        }
        this.f44144e.setVisibility(4);
        this.f44145f.setTimeLineListener(this.f44160u);
        this.f44146g.setOnClickListener(new a());
        k(this.f44151l);
    }

    private void l() {
        j();
        this.f44148i = AnimationUtils.loadAnimation(this.f44141b, R.anim.f155013gl);
        this.f44149j = AnimationUtils.loadAnimation(this.f44141b, R.anim.f155014gm);
    }

    private boolean m() {
        return com.qzone.album.env.common.a.m().s() != this.f44158s;
    }

    private void n(long j3) {
        if (this.f44153n == null || this.f44154o == null || this.f44156q == null || this.f44157r == null) {
            return;
        }
        if (this.f44155p == -1) {
            this.f44155p = j3;
        }
        this.f44153n.setImageDrawable(f(this.f44155p));
        this.f44153n.setAlpha(1.0f);
        this.f44154o.setVisibility(8);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.f44155p * 1000);
        int i3 = calendar.get(1);
        int i16 = calendar.get(2) + 1;
        calendar.setTimeInMillis(1000 * j3);
        int i17 = calendar.get(1);
        int i18 = calendar.get(2) + 1;
        if (i3 == i17 && i16 == i18) {
            return;
        }
        Drawable f16 = f(j3);
        this.f44154o.setImageDrawable(f16);
        this.f44156q.stop();
        this.f44157r.stop();
        this.f44153n.clearAnimation();
        this.f44154o.clearAnimation();
        if (this.f44155p < j3) {
            this.f44152m.setImageDrawable(this.f44156q);
            this.f44156q.start();
        } else {
            this.f44152m.setImageDrawable(this.f44157r);
            this.f44157r.start();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setAnimationListener(new c(f16));
        alphaAnimation.setDuration(400L);
        alphaAnimation2.setDuration(80L);
        this.f44153n.startAnimation(alphaAnimation);
        this.f44154o.setAlpha(0.0f);
        this.f44154o.setVisibility(0);
        this.f44154o.postDelayed(new Runnable() { // from class: com.qzone.album.ui.widget.AlbumTimeLineView.4
            @Override // java.lang.Runnable
            public void run() {
                AlbumTimeLineView.this.f44154o.startAnimation(alphaAnimation2);
            }
        }, 280L);
        this.f44155p = j3;
    }

    public void p(int i3) {
        View view = this.f44151l;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public void r(long j3) {
        this.f44147h = j3;
        this.f44145f.setSelection(j3);
    }

    public void s(long j3) {
        r(j3);
        n(j3);
    }

    public void t(boolean z16) {
        if (this.f44144e.getVisibility() == 0 && !z16) {
            this.f44149j.setDuration(this.f44150k);
            this.f44144e.startAnimation(this.f44149j);
            this.f44144e.setVisibility(4);
            this.f44146g.setVisibility(8);
            return;
        }
        if (this.f44144e.getVisibility() == 0 || !z16) {
            return;
        }
        this.f44148i.setDuration(this.f44150k);
        this.f44144e.startAnimation(this.f44148i);
        this.f44144e.setVisibility(0);
        this.f44146g.setVisibility(0);
        r(this.f44147h);
        this.f44145f.b();
    }

    public static void o(int i3, boolean z16, long j3) {
        QZLog.d("recentPhotoTimeLine", 1, "saveHasMore direction:", Integer.valueOf(i3), " hasMore:", Boolean.valueOf(z16), " uin:", Long.valueOf(j3));
        u5.b.o0(h(i3, j3), z16);
    }

    public void u(ArrayList<TabTimeLine> arrayList) {
        com.qzone.album.business.albumlist.fragment.e eVar;
        if (arrayList != null && arrayList.size() > 0) {
            com.qzone.album.env.common.a.m().b("recentPhotoTimeLine", "updateTimeLine CommonALbum showTimeLine");
            this.f44145f.setRecentPhotoData(arrayList);
            this.f44159t.a(true);
        } else {
            this.f44151l.setVisibility(8);
            if (!m() && (eVar = this.f44159t) != null) {
                eVar.a(true);
            }
            com.qzone.album.env.common.a.m().b("recentPhotoTimeLine", "updateTimeLine CommonALbum NoShowTimeLine");
        }
    }

    public void k(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.heh);
        this.f44152m = imageView;
        imageView.setImageDrawable(this.f44141b.getResources().getDrawable(R.drawable.axf));
        this.f44153n = (ImageView) view.findViewById(R.id.hei);
        this.f44154o = (ImageView) view.findViewById(R.id.hej);
        this.f44156q = (AnimationDrawable) this.f44141b.getResources().getDrawable(R.drawable.axo);
        this.f44157r = (AnimationDrawable) this.f44141b.getResources().getDrawable(R.drawable.axp);
        i();
        view.setVisibility(0);
        view.setOnClickListener(new b());
        AccessibilityUtil.p(view, l.a(R.string.f2201768e));
        view.setId(R.id.f165896dt3);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.setMargins(0, 0, ar.e(4.0f), 0);
        layoutParams.addRule(11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Drawable f44164d;

        c(Drawable drawable) {
            this.f44164d = drawable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AlbumTimeLineView.this.f44153n.setImageDrawable(this.f44164d);
            AlbumTimeLineView.this.f44153n.setAlpha(1.0f);
            AlbumTimeLineView.this.f44154o.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements com.qzone.album.business.photolist.ui.timeline.a {
        d() {
        }

        @Override // com.qzone.album.business.photolist.ui.timeline.a
        public void a(long j3, long j16, int i3) {
            if (!AlbumTimeLineView.this.f44140a.checkNetworkConnect()) {
                com.qzone.album.env.common.a.m().U(R.string.gdc);
                return;
            }
            AlbumTimeLineView.o(2, i3 > 0, AlbumTimeLineView.this.f44158s);
            AlbumTimeLineView.this.f44140a.f2(0, j3, j16);
            AlbumTimeLineView.this.f44147h = j3;
            AlbumTimeLineView.this.t(false);
        }

        @Override // com.qzone.album.business.photolist.ui.timeline.a
        public void b(PhotoPoiArea photoPoiArea) {
        }

        @Override // com.qzone.album.business.photolist.ui.timeline.a
        public void c(TimeLine timeLine) {
        }
    }

    public void q() {
    }
}
