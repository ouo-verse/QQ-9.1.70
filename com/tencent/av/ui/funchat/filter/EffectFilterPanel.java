package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.funchat.filter.EffectFilterTextPager;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class EffectFilterPanel extends RelativeLayout implements EffectConfigBase.b<FilterItem> {
    private VideoAppInterface C;
    a D;

    /* renamed from: d, reason: collision with root package name */
    private EffectFilterTextPager f75787d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f75788e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f75789f;

    /* renamed from: h, reason: collision with root package name */
    private MyScroolTextDispearRunnable f75790h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f75791i;

    /* renamed from: m, reason: collision with root package name */
    private fu.a f75792m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class MyScroolTextDispearRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<EffectFilterPanel> f75793d;

        MyScroolTextDispearRunnable(EffectFilterPanel effectFilterPanel) {
            this.f75793d = new WeakReference<>(effectFilterPanel);
        }

        @Override // java.lang.Runnable
        public void run() {
            EffectFilterPanel effectFilterPanel = this.f75793d.get();
            if (effectFilterPanel != null) {
                effectFilterPanel.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements EffectFilterTextPager.e {

        /* renamed from: a, reason: collision with root package name */
        EffectFilterTextPager.e f75794a;

        a(EffectFilterTextPager.e eVar) {
            b(eVar);
        }

        @Override // com.tencent.av.ui.funchat.filter.EffectFilterTextPager.e
        public void a(long j3, int i3, String str) {
            if (e.k()) {
                QLog.w("EffectFilterPanel", 1, "OnItemSelected, id[" + i3 + "], name[" + str + "], seq[" + j3 + "], Visibility[" + EffectFilterPanel.this.f75788e.getVisibility() + "], mlistener[" + this.f75794a + "]");
            }
            if (EffectFilterPanel.this.f75788e.getVisibility() == 0) {
                EffectFilterPanel.this.f75789f.removeCallbacks(EffectFilterPanel.this.f75790h);
                EffectFilterPanel.this.f75788e.clearAnimation();
                EffectFilterPanel.this.f75788e.setVisibility(8);
            }
            FilterItem w3 = EffectFilterPanel.this.f75792m.w(str);
            EffectFilterPanel.this.f75792m.L(j3, w3);
            if (w3 != null) {
                if (!w3.isUsable()) {
                    EffectFilterPanel.this.f75792m.N(j3, w3);
                }
                EffectFilterPanel.this.k();
                if (w3.getId() != null && w3.getId().compareToIgnoreCase("MANHUA") == 0) {
                    r.h0().o1(51, w3.getId());
                } else {
                    r.h0().o1(0, w3.getId());
                }
            }
        }

        public void b(EffectFilterTextPager.e eVar) {
            this.f75794a = eVar;
        }
    }

    public EffectFilterPanel(Context context, VideoAppInterface videoAppInterface) {
        super(context);
        this.C = videoAppInterface;
        this.f75789f = new Handler();
        this.f75790h = new MyScroolTextDispearRunnable(this);
        fu.a aVar = (fu.a) videoAppInterface.B(1);
        this.f75792m = aVar;
        aVar.p(-1043L, this);
        g(context, videoAppInterface);
    }

    @TargetApi(11)
    public void e(boolean z16, boolean z17) {
        int i3;
        AVCoreLog.printColorLog("EffectFilterPanel", "changeLayoutStyle: " + this.f75791i + "|" + z16 + "|" + z17);
        if (this.f75791i != z16) {
            this.f75791i = z16;
            if (z16) {
                DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
                AVCoreLog.printColorLog("EffectFilterPanel", "changeLayoutStyle 22: " + displayMetrics.widthPixels);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(displayMetrics.widthPixels / 2, -1);
                int i16 = 11;
                if (z17) {
                    i3 = 11;
                } else {
                    i3 = 9;
                }
                layoutParams.addRule(i3);
                this.f75787d.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(displayMetrics.widthPixels / 2, -1);
                if (!z17) {
                    i16 = 9;
                }
                layoutParams2.addRule(i16);
                layoutParams2.setMargins(0, -((int) getContext().getResources().getDimension(R.dimen.f159339a44)), 0, 0);
                this.f75788e.setLayoutParams(layoutParams2);
                this.f75788e.setScaleX(0.9f);
                this.f75788e.setScaleY(0.9f);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f75787d.getLayoutParams();
                layoutParams3.width = -1;
                layoutParams3.height = -1;
                this.f75787d.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.setMargins(0, (int) getContext().getResources().getDimension(R.dimen.f159338a43), 0, 0);
                layoutParams4.addRule(14);
                this.f75788e.setLayoutParams(layoutParams4);
                this.f75788e.setScaleX(1.0f);
                this.f75788e.setScaleY(1.0f);
            }
            this.f75787d.g(z16);
        }
    }

    void f() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(450L);
        alphaAnimation.setAnimationListener(new b(this.f75788e));
        this.f75788e.startAnimation(alphaAnimation);
    }

    void g(Context context, VideoAppInterface videoAppInterface) {
        long d16 = e.d();
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f168523zk, this);
        this.f75788e = (ImageView) viewGroup.findViewById(R.id.f166566g80);
        EffectFilterTextPager effectFilterTextPager = (EffectFilterTextPager) viewGroup.findViewById(R.id.kqt);
        this.f75787d = effectFilterTextPager;
        effectFilterTextPager.setApp(videoAppInterface);
        setOnFilterListenner(null);
        FilterItem u16 = this.f75792m.u();
        this.f75787d.l(this.f75792m.q(null));
        this.f75787d.setCurrentFilter(u16);
        this.f75792m.L(d16, u16);
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onItemSelectedChanged(long j3, FilterItem filterItem) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onItemSelectedChanged, seq[");
        sb5.append(j3);
        sb5.append("], mFilterPager[");
        if (this.f75787d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("], current[");
        sb5.append(filterItem);
        sb5.append("]");
        QLog.w("EffectFilterPanel", 1, sb5.toString());
        EffectFilterTextPager effectFilterTextPager = this.f75787d;
        if (effectFilterTextPager != null) {
            effectFilterTextPager.setCurrentFilter(filterItem);
        }
    }

    public void k() {
        boolean z16;
        int i3;
        int i16 = n.e().f().S0;
        if (i16 != 1 && i16 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        ReportController.o(null, "dc00898", "", "", "0X800BC06", "0X800BC06", i3, 0, "", "", "", "");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f75791i) {
            this.f75787d.dispatchTouchEvent(motionEvent);
            AVCoreLog.printColorLog("EffectFilterPanel", "onTouchEvent: " + motionEvent.toString());
            return true;
        }
        return false;
    }

    public void setAnimationTrigger(VideoUtil.AnimationTrigger animationTrigger) {
        this.f75787d.setAnimationTrigger(animationTrigger);
    }

    public void setOnFilterListenner(EffectFilterTextPager.e eVar) {
        a aVar = this.D;
        if (aVar == null) {
            this.D = new a(eVar);
        } else {
            aVar.b(eVar);
        }
        this.f75787d.setOnFilterListenner(this.D);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        this.f75787d.setVisibility(i3);
        SessionInfo f16 = n.e().f();
        if (f16.M1) {
            f16.M1 = false;
            this.f75788e.setVisibility(0);
            this.f75789f.postDelayed(this.f75790h, 4000L);
        }
        super.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<View> f75796d;

        b(View view) {
            this.f75796d = new WeakReference<>(view);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f75796d.get();
            AVCoreLog.printColorLog("EffectFilterPanel", "MyTextAlphaAnimationListener onAnimationEnd :" + view + "|" + animation);
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(FilterItem filterItem, int i3) {
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onDownloadFinish(long j3, FilterItem filterItem, boolean z16) {
    }
}
