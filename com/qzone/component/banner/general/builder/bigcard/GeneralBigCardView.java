package com.qzone.component.banner.general.builder.bigcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.component.banner.general.builder.GeneralModelBaseCardView;
import com.qzone.component.banner.general.view.GeneralBigCardVideoView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GeneralBigCardView extends GeneralModelBaseCardView implements View.OnClickListener {
    public TextView C;
    public GeneralBigCardVideoView D;
    public ImageView E;
    public TextView F;
    public Button G;
    public LinearLayout H;
    public LinearLayout I;
    private View J;

    /* renamed from: h, reason: collision with root package name */
    public RoundImageView f46576h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f46577i;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f46578m;

    public GeneralBigCardView(Context context) {
        super(context);
    }

    private void A(i6.a aVar) {
        if (TextUtils.isEmpty(aVar.x())) {
            this.C.setVisibility(8);
        } else {
            this.C.setText(aVar.x());
            this.C.setVisibility(0);
        }
    }

    private boolean B(i6.a aVar) {
        if (aVar.A() != null && aVar.z() != null) {
            this.D.setVisibility(0);
            this.D.H0(aVar.A());
            this.D.play();
            return true;
        }
        s();
        return false;
    }

    private boolean C() {
        GeneralBigCardVideoView generalBigCardVideoView = this.D;
        return generalBigCardVideoView != null && generalBigCardVideoView.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(LoadState loadState, Option option) {
        if (loadState == LoadState.STATE_SUCCESS && option != null && option.getResultBitMap() != null && option.getResultBitMap().getConfig() != null) {
            Bitmap resultBitMap = option.getResultBitMap();
            QLog.d("GeneralBigCardView", 4, "initAvatar [onStateChange] -> bitmap size = " + resultBitMap.getAllocationByteCount() + " , bitmap type = " + resultBitMap.getConfig().name() + " , bitmapSize = " + resultBitMap.getWidth() + " * " + resultBitMap.getHeight() + " , pic url = " + option.getUrl());
            this.f46576h.setImageBitmap(resultBitMap);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initAvatar [onStateChange] -> state = ");
        sb5.append(loadState);
        sb5.append(" , pic url = ");
        sb5.append(option != null ? option.getUrl() : null);
        QLog.w("GeneralBigCardView", 1, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(i6.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        yo.d.c(aVar.j(), view.getContext());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(int i3, int i16, i6.a aVar, LoadState loadState, Option option) {
        if (loadState.isFinish()) {
            QLog.i("GeneralBigCardView", 2, "loadImage  | state = " + loadState + " | width = " + i3 + " | height = " + i16 + " | url = " + aVar.r());
        }
    }

    private void s() {
        if (C()) {
            if (this.D.isPlaying()) {
                this.D.a();
            }
            this.D.setVisibility(8);
        }
    }

    private void t(i6.a aVar) {
        Option obtain = Option.obtain();
        obtain.setUrl(aVar.h());
        com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new IPicLoadStateListener() { // from class: com.qzone.component.banner.general.builder.bigcard.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                GeneralBigCardView.this.D(loadState, option);
            }
        });
    }

    private void u(final i6.a aVar) {
        if (!TextUtils.isEmpty(aVar.k()) && !TextUtils.isEmpty(aVar.j())) {
            this.G.setVisibility(0);
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.component.banner.general.builder.bigcard.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GeneralBigCardView.E(i6.a.this, view);
                }
            });
        } else {
            this.G.setVisibility(8);
        }
    }

    private boolean v(i6.a aVar) {
        if (TextUtils.isEmpty(aVar.t()) && (TextUtils.isEmpty(aVar.k()) || TextUtils.isEmpty(aVar.j()))) {
            this.H.setVisibility(8);
            return false;
        }
        this.H.setVisibility(0);
        return true;
    }

    private void w(i6.a aVar) {
        if (TextUtils.isEmpty(aVar.t())) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
            this.F.setText(aVar.t());
        }
    }

    private void x() {
        i6.a aVar = this.f46574e;
        if (aVar == null || TextUtils.isEmpty(aVar.n()) || !this.f46574e.a()) {
            return;
        }
        findViewById(R.id.mqt).setOnClickListener(this);
        this.D.setOnClickListener(this);
    }

    private void y(i6.a aVar) {
        this.f46577i.setText(aVar.q());
    }

    private boolean z(final i6.a aVar) {
        if (this.E == null) {
            QLog.i("GeneralBigCardView", 2, "mPicView is null");
            return false;
        }
        if (aVar != null && "2".equals(aVar.o()) && !TextUtils.isEmpty(aVar.r())) {
            this.E.setVisibility(0);
            Option obtain = Option.obtain();
            obtain.setUrl(aVar.r());
            obtain.setTargetView(this.E);
            ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
            final int l3 = pl.a.f426446a.l(getContext());
            final int i3 = (int) (l3 * 0.5625f);
            if (layoutParams != null) {
                layoutParams.width = l3;
                layoutParams.height = i3;
                this.E.setLayoutParams(layoutParams);
                obtain.setRequestWidth(l3);
                obtain.setRequestHeight(i3);
            }
            obtain.setLoadingDrawable(getResources().getDrawable(R.drawable.at8));
            obtain.setFailDrawable(getResources().getDrawable(R.drawable.at_));
            com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new IPicLoadStateListener() { // from class: com.qzone.component.banner.general.builder.bigcard.b
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    GeneralBigCardView.F(l3, i3, aVar, loadState, option);
                }
            });
            return true;
        }
        this.E.setVisibility(8);
        return false;
    }

    public void G(boolean z16) {
        if (C()) {
            this.D.m1(z16);
        }
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, gf.r
    public void a() {
        super.a();
        if (C()) {
            this.D.a();
        }
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, gf.r
    public QZoneVideoItemWidgetView d() {
        return this.D;
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView
    protected int g() {
        return R.layout.f167320co4;
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView
    protected String h() {
        return "GeneralBigCardView";
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView
    public void j(i6.a aVar) {
        t(aVar);
        y(aVar);
        A(aVar);
        this.f46578m.setOnClickListener(this);
        if (!z(aVar)) {
            B(aVar);
        } else {
            s();
        }
        if (v(aVar)) {
            w(aVar);
            u(aVar);
        }
        x();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i6.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f162746l32) {
            r();
        } else if ((id5 == R.id.mqt || id5 == R.id.f162969nl4) && (aVar = this.f46574e) != null) {
            yo.d.c(aVar.n(), view.getContext());
            int f16 = l6.d.f(this.f46574e, "app_type");
            l6.d.j(this.f46574e.g(), "914335", "", this.f46574e.s(), "20", String.valueOf(f16), this.f46574e.e(), String.valueOf(this.f46574e.c()), l6.d.a(f16));
            LpReportInfo_pf00064.allReport(619, 18, 2, "", "1");
            l6.d.k(this.f46574e.d(), 102, "tianshu.289");
            if (l6.d.h(this.f46574e) && l6.d.i(this.f46574e)) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.qzone.component.banner.general.builder.bigcard.GeneralBigCardView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((GeneralModelBaseCardView) GeneralBigCardView.this).f46575f != null) {
                            ((GeneralModelBaseCardView) GeneralBigCardView.this).f46575f.b();
                        }
                    }
                }, 3000L);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, i6.e
    public void onClose() {
        super.onClose();
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, i6.e
    public void onDestroy() {
        super.onDestroy();
        if (C()) {
            this.D.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (C()) {
            this.D.a();
        }
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, i6.e
    public void onPause() {
        super.onPause();
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, i6.e
    public void onResume() {
        super.onResume();
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, gf.r
    public void pause() {
        super.pause();
        if (C()) {
            this.D.pause();
        }
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView, gf.r
    public void play() {
        super.play();
        G(false);
    }

    public void r() {
        onClose();
        i6.d dVar = this.f46575f;
        if (dVar != null) {
            dVar.b();
            onDestroy();
        }
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView
    public void setDividerLineVisible(boolean z16) {
        View view = this.J;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
    }

    public GeneralBigCardView(Context context, AttributeSet attributeSet) {
        super(context);
    }

    @Override // com.qzone.component.banner.general.builder.GeneralModelBaseCardView
    protected void k() {
        this.f46576h = (RoundImageView) findViewById(R.id.ku9);
        this.f46577i = (TextView) findViewById(R.id.njc);
        this.f46578m = (ImageView) findViewById(R.id.f162746l32);
        this.C = (TextView) findViewById(R.id.nkf);
        this.D = (GeneralBigCardVideoView) findViewById(R.id.f162969nl4);
        this.E = (ImageView) findViewById(R.id.lox);
        this.H = (LinearLayout) findViewById(R.id.f192759);
        this.I = (LinearLayout) findViewById(R.id.f19285_);
        this.F = (TextView) findViewById(R.id.f19295a);
        this.G = (Button) findViewById(R.id.f19315c);
        this.J = findViewById(R.id.f20458f);
        this.f46578m.setOnClickListener(this);
    }
}
