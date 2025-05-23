package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneFontPanel;
import com.qzone.common.activities.base.QZoneSuperFontPanel;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.publish.ui.activity.QZonePublishMoodActivity;
import com.qzone.widget.particle.ParticleManager;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFontTabView extends LinearLayout {
    public QZoneEffectPanel C;
    private View D;
    private View E;
    private View F;
    protected View G;
    protected int H;
    protected ArrayList<View> I;
    protected ArrayList<View> J;
    protected int K;
    private ImageView L;
    private boolean M;
    private boolean N;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f45364d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<Fragment> f45365e;

    /* renamed from: f, reason: collision with root package name */
    protected WeakReference<EditText> f45366f;

    /* renamed from: h, reason: collision with root package name */
    protected long f45367h;

    /* renamed from: i, reason: collision with root package name */
    public QZoneFontPanel f45368i;

    /* renamed from: m, reason: collision with root package name */
    public QZoneSuperFontPanel f45369m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFontTabView qZoneFontTabView = QZoneFontTabView.this;
            qZoneFontTabView.r(qZoneFontTabView.f45368i, view);
            QZoneFontTabView.this.H = 0;
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
            QZoneFontTabView.this.m();
            QZoneFontTabView qZoneFontTabView = QZoneFontTabView.this;
            qZoneFontTabView.r(qZoneFontTabView.f45369m, view);
            QZoneFontTabView.this.H = 1;
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFontTabView qZoneFontTabView = QZoneFontTabView.this;
            qZoneFontTabView.r(qZoneFontTabView.C, view);
            QZoneFontTabView.this.H = 2;
            ClickReport.q("46", "12", "1", true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneFontTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = 0;
        this.I = new ArrayList<>();
        this.J = new ArrayList<>();
        this.K = -1;
        this.L = null;
        this.M = false;
        this.N = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        WeakReference<Fragment> weakReference;
        if (this.C == null || (weakReference = this.f45365e) == null || weakReference.get() == null || !(this.f45365e.get() instanceof QZonePublishMoodActivity)) {
            return;
        }
        ImageView imageView = this.L;
        if (imageView != null && imageView.getParent() != null) {
            ((ViewGroup) this.L.getParent()).removeView(this.L);
        }
        this.L = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        u5.b.q0("SuperFontRedIcon" + LoginData.getInstance().getUin(), 0);
        View findViewById = findViewById(R.id.hs_);
        if (findViewById == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    private void t() {
        int i3 = this.H;
        if (i3 == 0) {
            View view = this.D;
            if (view != null) {
                view.performClick();
            } else {
                QZoneFontPanel qZoneFontPanel = this.f45368i;
                if (qZoneFontPanel != null) {
                    qZoneFontPanel.setVisibility(0);
                }
            }
        } else if (i3 == 1) {
            View view2 = this.E;
            if (view2 != null) {
                view2.performClick();
            } else {
                QZoneSuperFontPanel qZoneSuperFontPanel = this.f45369m;
                if (qZoneSuperFontPanel != null) {
                    qZoneSuperFontPanel.setVisibility(0);
                }
            }
        } else if (i3 == 2) {
            View view3 = this.F;
            if (view3 != null) {
                view3.performClick();
            } else {
                QZoneEffectPanel qZoneEffectPanel = this.C;
                if (qZoneEffectPanel != null) {
                    qZoneEffectPanel.setVisibility(0);
                }
            }
        }
        if (this.I.size() <= 1) {
            QZoneFontPanel.setViewVisible(this.G, 8);
        } else {
            QZoneFontPanel.setViewVisible(this.G, 0);
        }
        QZoneEffectPanel qZoneEffectPanel2 = this.C;
        if (qZoneEffectPanel2 != null) {
            qZoneEffectPanel2.o();
        }
    }

    private void v() {
        WeakReference<Fragment> weakReference;
        if (!this.M && ParticleManager.u() && (weakReference = this.f45365e) != null && weakReference.get() != null && (this.f45365e.get() instanceof QZonePublishMoodActivity) && ParticleManager.h(this.f45364d.get()) && this.L == null) {
            File imageFile = ImageLoader.getInstance().getImageFile("https://qzonestyle.gtimg.cn/aoi/sola/20181029170117_0puP866QT2.png");
            if (imageFile != null && imageFile.exists()) {
                this.f45364d.get().runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.QZoneFontTabView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneFontTabView.this.x();
                    }
                });
            } else {
                ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20181029170117_0puP866QT2.png", (ImageLoader.ImageLoadListener) null, (ImageLoader.Options) null);
            }
        }
    }

    private void w(View view, Boolean bool) {
        TextView textView;
        WeakReference<Activity> weakReference;
        int i3;
        if ((QQTheme.isNowThemeIsNightForQzone() || this.N) && view != null) {
            int id5 = view.getId();
            if (id5 != R.id.hjh && id5 != R.id.hif) {
                textView = id5 == R.id.hsa ? (TextView) findViewById(R.id.hs9) : null;
            } else {
                textView = (TextView) view;
            }
            if (textView == null || (weakReference = this.f45364d) == null) {
                return;
            }
            Activity activity = weakReference.get();
            if (this.N) {
                i3 = bool.booleanValue() ? R.color.qui_common_fill_standard_primary : R.color.qui_common_fill_light_secondary;
            } else {
                i3 = bool.booleanValue() ? R.color.qzone_skin_widget_tab_selected_bg : R.color.qzone_skin_widget_tab_nornal_bg;
            }
            if (activity != null) {
                view.setBackgroundColor(activity.getResources().getColor(i3));
            }
            textView.getPaint().setFakeBoldText(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        WeakReference<Fragment> weakReference;
        if (this.C == null || (weakReference = this.f45365e) == null || weakReference.get() == null || !(this.f45365e.get() instanceof QZonePublishMoodActivity)) {
            return;
        }
        this.L = new ImageView(this.f45364d.get());
        Drawable loadImage = ImageLoader.getInstance().loadImage("https://qzonestyle.gtimg.cn/aoi/sola/20181029170117_0puP866QT2.png", new ImageLoader.ImageLoadListener() { // from class: com.qzone.common.activities.base.QZoneFontTabView.5
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                WeakReference<Activity> weakReference2 = QZoneFontTabView.this.f45364d;
                if (weakReference2 == null || weakReference2.get() == null) {
                    return;
                }
                QZoneFontTabView.this.f45364d.get().runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.QZoneFontTabView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QZoneFontTabView.this.L != null) {
                            QZoneFontTabView.this.L.setImageDrawable(drawable);
                        }
                    }
                });
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        }, (ImageLoader.Options) null);
        if (loadImage != null) {
            this.L.setImageDrawable(loadImage);
        }
        RelativeLayout relativeLayout = (RelativeLayout) ((QZonePublishMoodActivity) this.f45365e.get()).getRoot();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.qzone.util.ar.e(132.0f), com.qzone.util.ar.e(43.0f));
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        layoutParams.rightMargin = com.qzone.util.ar.e(5.0f);
        layoutParams.bottomMargin = this.G.getHeight();
        relativeLayout.addView(this.L, layoutParams);
        this.L.bringToFront();
        ClickReport.q("46", "12", "9", true);
        ParticleManager.L(this.f45364d.get(), false);
        ((QZonePublishMoodActivity) this.f45365e.get()).runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.QZoneFontTabView.6
            @Override // java.lang.Runnable
            public void run() {
                QZoneFontTabView.this.l();
            }
        }, 3000L);
    }

    private void z() {
        int G = u5.b.G("SuperFontRedIcon" + LoginData.getInstance().getUin(), 1);
        View findViewById = findViewById(R.id.hs_);
        if (findViewById == null) {
            return;
        }
        if (G == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    public void f(boolean z16, boolean z17) {
        WeakReference<Activity> weakReference = this.f45364d;
        if (weakReference == null || this.f45366f == null || weakReference.get() == null || this.f45366f.get() == null) {
            return;
        }
        QZoneFontPanel qZoneFontPanel = new QZoneFontPanel(this.f45364d.get(), this.f45366f.get(), LoginData.getInstance().getUin(), this.K, z16, z17);
        this.f45368i = qZoneFontPanel;
        if (this.N) {
            qZoneFontPanel.setBackgroundResId(R.color.qui_common_bg_bottom_light);
            this.f45368i.setItemBackgroundDrawable(R.drawable.f143927);
        }
        addView(this.f45368i, 0, new LinearLayout.LayoutParams(-1, (int) (com.qzone.util.ar.l() * 0.67f)));
        this.J.add(this.f45368i);
        i();
    }

    public void g() {
        WeakReference<Activity> weakReference = this.f45364d;
        if (weakReference == null || this.f45366f == null || weakReference.get() == null || this.f45366f.get() == null) {
            return;
        }
        QZoneEffectPanel qZoneEffectPanel = new QZoneEffectPanel(this.f45364d.get(), this.f45365e.get(), this.f45366f.get(), LoginData.getInstance().getUin());
        this.C = qZoneEffectPanel;
        if (this.N) {
            qZoneEffectPanel.setBackgroundResId(R.color.qui_common_bg_bottom_light);
        }
        this.C.setVisibility(8);
        addView(this.C, 0, new LinearLayout.LayoutParams(-1, (int) (com.qzone.util.ar.l() * 0.67f)));
        this.J.add(this.C);
        this.C.setIsKuolie(this.M);
        j();
    }

    public void h() {
        WeakReference<Activity> weakReference = this.f45364d;
        if (weakReference == null || this.f45366f == null || weakReference.get() == null || this.f45366f.get() == null) {
            return;
        }
        QZoneSuperFontPanel qZoneSuperFontPanel = new QZoneSuperFontPanel(this.f45364d.get(), this.f45366f.get(), LoginData.getInstance().getUin());
        this.f45369m = qZoneSuperFontPanel;
        qZoneSuperFontPanel.setVisibility(8);
        if (this.N) {
            this.f45369m.setBackgroundResId(R.color.qui_common_bg_bottom_light);
            this.f45369m.setItemBackgroundDrawable(R.drawable.f143927);
        }
        addView(this.f45369m, 0, new LinearLayout.LayoutParams(-1, (int) (com.qzone.util.ar.l() * 0.67f)));
        this.J.add(this.f45369m);
        k();
    }

    protected void i() {
        q();
        View findViewById = this.G.findViewById(R.id.hif);
        this.D = findViewById;
        findViewById.setSelected(true);
        this.D.setVisibility(0);
        this.D.setOnClickListener(new a());
        this.I.add(this.D);
    }

    protected void j() {
        q();
        View findViewById = this.G.findViewById(R.id.hjh);
        this.F = findViewById;
        findViewById.setSelected(false);
        this.F.setVisibility(0);
        this.F.setOnClickListener(new c());
        this.I.add(this.F);
    }

    protected void k() {
        q();
        View findViewById = this.G.findViewById(R.id.hsa);
        this.E = findViewById;
        findViewById.setSelected(false);
        this.E.setVisibility(0);
        z();
        this.E.setOnClickListener(new b());
        this.I.add(this.E);
    }

    public void o(Activity activity, Fragment fragment, EditText editText, long j3) {
        this.f45364d = new WeakReference<>(activity);
        this.f45366f = new WeakReference<>(editText);
        this.f45365e = new WeakReference<>(fragment);
        this.f45367h = j3;
        p();
    }

    protected void p() {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneFontTabView", 4, "begin initFontPanel");
        }
    }

    protected void q() {
        if (this.G == null) {
            this.G = View.inflate(this.f45364d.get(), R.layout.bln, null);
            addView(this.G, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    protected void r(View view, View view2) {
        u(view);
        s(view2);
    }

    public void setBottomTab(int i3) {
        this.H = i3;
    }

    public void setFontItemClickListener(QZoneFontPanel.e eVar) {
        QZoneFontPanel qZoneFontPanel = this.f45368i;
        if (qZoneFontPanel != null) {
            qZoneFontPanel.setFontItemClickListener(eVar);
        }
    }

    public void setIsActionPanel(boolean z16) {
        this.N = z16;
    }

    public void setIsKuolie(boolean z16) {
        this.M = z16;
        QZoneEffectPanel qZoneEffectPanel = this.C;
        if (qZoneEffectPanel != null) {
            qZoneEffectPanel.setIsKuolie(z16);
        }
    }

    public void setSelectFontId(int i3) {
        this.K = i3;
    }

    public void setSuperFontItemClickListener(QZoneSuperFontPanel.c cVar) {
        QZoneSuperFontPanel qZoneSuperFontPanel = this.f45369m;
        if (qZoneSuperFontPanel != null) {
            qZoneSuperFontPanel.setFontItemClickListener(cVar);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (i3 == 0) {
            t();
        }
    }

    public void y() {
        t();
        setVisibility(0);
        v();
    }

    public void e(boolean z16) {
        f(z16, false);
    }

    private void s(View view) {
        ArrayList<View> arrayList;
        if (view == null || (arrayList = this.I) == null) {
            return;
        }
        Iterator<View> it = arrayList.iterator();
        View view2 = null;
        while (it.hasNext()) {
            View next = it.next();
            if (next == view) {
                view2 = next;
            }
            next.setSelected(false);
            w(next, Boolean.FALSE);
        }
        if (view2 != null) {
            view2.setSelected(true);
            w(view2, Boolean.TRUE);
        }
    }

    private void u(View view) {
        ArrayList<View> arrayList;
        if (view == null || (arrayList = this.J) == null) {
            return;
        }
        Iterator<View> it = arrayList.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (next == view) {
                next.setVisibility(0);
            } else {
                next.setVisibility(8);
            }
        }
    }

    public void n() {
        setVisibility(8);
        QZoneEffectPanel qZoneEffectPanel = this.C;
        if (qZoneEffectPanel != null) {
            qZoneEffectPanel.o();
        }
        if (this.L != null) {
            l();
        }
    }

    public QZoneFontTabView(Activity activity, Fragment fragment, EditText editText, long j3) {
        super(activity, null);
        this.H = 0;
        this.I = new ArrayList<>();
        this.J = new ArrayList<>();
        this.K = -1;
        this.L = null;
        this.M = false;
        this.N = false;
        o(activity, fragment, editText, j3);
    }
}
