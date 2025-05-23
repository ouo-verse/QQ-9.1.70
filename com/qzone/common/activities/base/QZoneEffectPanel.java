package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.particle.ParticleManager;
import com.qzone.widget.particle.ParticleTextSurfaceView;
import com.qzone.widget.particle.ParticleTextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.lang.ref.WeakReference;

/* loaded from: classes39.dex */
public class QZoneEffectPanel extends LinearLayout {
    protected Button C;
    protected Button D;
    private boolean E;
    private boolean F;
    private boolean G;
    private ViewGroup H;
    private float I;
    private int J;
    private int K;
    private boolean L;
    private View.OnClickListener M;
    private View.OnClickListener N;
    private View.OnClickListener P;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f45282d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<Fragment> f45283e;

    /* renamed from: f, reason: collision with root package name */
    protected WeakReference<EditText> f45284f;

    /* renamed from: h, reason: collision with root package name */
    protected long f45285h;

    /* renamed from: i, reason: collision with root package name */
    protected Handler f45286i;

    /* renamed from: m, reason: collision with root package name */
    protected ViewGroup f45287m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneEffectPanel.this.w();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!QZoneEffectPanel.this.G) {
                if (!QZoneEffectPanel.this.F) {
                    QZoneEffectPanel.this.u();
                }
            } else {
                QZoneEffectPanel.this.o();
            }
            if (LoginData.getInstance().isSuperQzoneVip()) {
                QZoneEffectPanel.this.F = !r0.F;
                if (QZoneEffectPanel.this.F) {
                    ClickReport.q("46", "12", "4", true);
                } else {
                    ClickReport.q("46", "12", "5", true);
                }
            } else {
                ClickReport.q("46", "12", "3", true);
            }
            QZoneEffectPanel.this.y();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneEffectPanel(Activity activity, Fragment fragment, EditText editText, long j3) {
        super(activity);
        this.E = false;
        this.F = false;
        this.G = false;
        this.K = R.color.qzone_skin_font_panel_background_color;
        this.L = false;
        this.M = new c();
        this.N = new View.OnClickListener() { // from class: com.qzone.common.activities.base.QZoneEffectPanel.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!LoginData.getInstance().isQzoneVip()) {
                    ClickReport.q("46", "12", "11", true);
                    QZoneEffectPanel.this.v();
                    QZoneEffectPanel.this.f45286i.postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.QZoneEffectPanel.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneEffectPanel.this.p();
                        }
                    }, 3000L);
                } else {
                    QZoneEffectPanel.this.E = !r0.E;
                    if (QZoneEffectPanel.this.E) {
                        ClickReport.q("46", "12", "12", true);
                    } else {
                        ClickReport.q("46", "12", "13", true);
                    }
                    QZoneEffectPanel.this.x();
                    if (QZoneEffectPanel.this.E) {
                        QZoneEffectPanel.this.v();
                    } else {
                        QZoneEffectPanel.this.p();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.P = new d();
        q(activity, fragment, editText, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f45284f.get() != null) {
            this.f45284f.get().setTextSize(0, this.I);
            this.f45284f.get().scrollTo(0, 0);
            if (this.J <= 0) {
                this.f45284f.get().setMaxLines(7);
            } else {
                this.f45284f.get().setMaxLines(this.J);
            }
        }
    }

    private void q(Activity activity, Fragment fragment, EditText editText, long j3) {
        this.f45282d = new WeakReference<>(activity);
        this.f45284f = new WeakReference<>(editText);
        this.f45283e = new WeakReference<>(fragment);
        this.J = editText.getMaxLines();
        this.I = editText.getTextSize();
        this.f45286i = new Handler(Looper.getMainLooper());
        this.f45285h = j3;
        r();
    }

    private void t(View view, int i3) {
        Activity activity;
        WeakReference<Activity> weakReference = this.f45282d;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        view.setBackgroundColor(activity.getResources().getColor(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.f45284f.get() != null) {
            this.f45284f.get().setTextSize(0, com.qzone.util.ar.e(l()));
            this.f45284f.get().setMaxLines(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Activity activity = this.f45282d.get();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("aid", "ssxiaoguo");
            intent.putExtra("direct_go", true);
            intent.putExtra("viptype", 2);
            VipComponentProxy.f50997g.getUiInterface().goOpenYellowVip(activity, intent, -1);
        }
        ClickReport.q("46", "12", "2", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (!LoginData.getInstance().isQzoneVip()) {
            this.D.setText(com.qzone.util.l.a(R.string.rsn));
            return;
        }
        if (this.E) {
            this.D.setText(com.qzone.util.l.a(R.string.rsg));
            this.D.setSelected(true);
            v();
        } else {
            this.D.setText(com.qzone.util.l.a(R.string.rsm));
            this.D.setSelected(false);
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (!LoginData.getInstance().isSuperQzoneVip()) {
            this.C.setText(com.qzone.util.l.a(R.string.rsf));
        } else if (this.F) {
            this.C.setText(com.qzone.util.l.a(R.string.rsi));
            this.C.setSelected(true);
        } else {
            this.C.setText(com.qzone.util.l.a(R.string.rsr));
            this.C.setSelected(false);
        }
    }

    public boolean k() {
        return this.E;
    }

    protected int l() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZ_CUSTOM_FONT, QzoneConfig.SECONDARY_LARGE_FONT_SIZE, 30);
    }

    public boolean m() {
        return this.F;
    }

    public boolean n() {
        String[] split;
        String string4Uin = LocalMultiProcConfig.getString4Uin(LocalMultiProcConfig.QZONE_LARGE_FONT_SAVE_DATA, "", this.f45285h);
        return !TextUtils.isEmpty(string4Uin) && (split = string4Uin.split(";")) != null && split.length >= 1 && "1".equals(split[0]);
    }

    protected void r() {
        ((LayoutInflater) this.f45282d.get().getSystemService("layout_inflater")).inflate(R.layout.bkg, this);
        t(this, this.K);
        setOnClickListener(new a());
        this.f45287m = (ViewGroup) findViewById(R.id.e4o);
        this.C = (Button) findViewById(R.id.hlk);
        Button button = (Button) findViewById(R.id.hsb);
        this.D = button;
        button.setOnClickListener(this.N);
        if (!ParticleManager.u()) {
            this.f45287m.setVisibility(8);
        }
        this.C.setOnClickListener(this.M);
        AsyncImageView asyncImageView = (AsyncImageView) findViewById(R.id.hgl);
        if (LoginData.getInstance().isQzoneVip()) {
            asyncImageView.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20181029170117_uointIz9Rs.png");
        } else {
            asyncImageView.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20181029170117_zC12ppEt5g.png");
        }
        asyncImageView.setOnClickListener(new b());
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneEffectPanel.3
            @Override // java.lang.Runnable
            public void run() {
                QZoneEffectPanel qZoneEffectPanel = QZoneEffectPanel.this;
                qZoneEffectPanel.E = qZoneEffectPanel.n();
                if (!LoginData.getInstance().isQzoneVip()) {
                    QZoneEffectPanel.this.E = false;
                }
                QZoneEffectPanel.this.f45286i.post(new Runnable() { // from class: com.qzone.common.activities.base.QZoneEffectPanel.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneEffectPanel.this.x();
                        QZoneEffectPanel.this.y();
                    }
                });
            }
        });
    }

    public void s() {
        StringBuilder sb5 = new StringBuilder();
        if (this.E) {
            sb5.append("1;");
        } else {
            sb5.append("0;");
        }
        LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.QZONE_LARGE_FONT_SAVE_DATA, sb5.toString(), this.f45285h);
    }

    public void setBackgroundResId(int i3) {
        this.K = i3;
    }

    public void setIsKuolie(boolean z16) {
        this.L = z16;
        if (z16) {
            this.f45287m.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (i3 == 0) {
            y();
            x();
        } else {
            o();
        }
    }

    public void o() {
        this.G = false;
        ViewGroup viewGroup = this.H;
        if (viewGroup == null || viewGroup.getParent() == null) {
            return;
        }
        ((ParticleTextSurfaceView) this.H.findViewById(R.id.fil)).i();
        ((ViewGroup) this.H.getParent()).removeView(this.H);
        this.H = null;
    }

    public void u() {
        this.G = true;
        RelativeLayout relativeLayout = (RelativeLayout) ((QZonePublishMoodBaseActivity) this.f45283e.get()).getRoot();
        if (this.H == null) {
            this.H = (ViewGroup) ((LayoutInflater) this.f45282d.get().getSystemService("layout_inflater")).inflate(R.layout.bny, (ViewGroup) null);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.qzone.util.ar.e(164.0f), com.qzone.util.ar.e(57.0f));
        layoutParams.addRule(11, -1);
        layoutParams.rightMargin = com.qzone.util.ar.e(12.0f);
        layoutParams.addRule(12, -1);
        int[] iArr = new int[2];
        this.C.getLocationOnScreen(iArr);
        layoutParams.bottomMargin = com.qzone.util.ar.k() - iArr[1];
        relativeLayout.addView(this.H, layoutParams);
        this.H.setLayoutParams(layoutParams);
        ParticleTextView particleTextView = (ParticleTextView) this.H.findViewById(R.id.fik);
        particleTextView.setGravity(17);
        particleTextView.setVisibility(4);
        ((ParticleTextSurfaceView) this.H.findViewById(R.id.fil)).o(particleTextView);
        this.f45286i.postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.QZoneEffectPanel.4
            @Override // java.lang.Runnable
            public void run() {
                QZoneEffectPanel.this.o();
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
