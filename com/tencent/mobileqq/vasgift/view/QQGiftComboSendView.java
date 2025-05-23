package com.tencent.mobileqq.vasgift.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager;
import com.tencent.mobileqq.vasgift.utils.LongClickHandler;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.mobileqq.vasgift.view.anim.f;
import com.tencent.mobileqq.vasgift.view.anim.g;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQGiftComboSendView extends FrameLayout implements g {
    private int C;
    private final ImageView D;
    private final ImageView E;
    private final TextView F;
    private final LongClickHandler G;
    private final com.tencent.mobileqq.vasgift.view.anim.b H;
    private final com.tencent.mobileqq.vasgift.view.anim.d I;
    private final f J;
    private final com.tencent.mobileqq.vasgift.view.anim.a K;
    private final com.tencent.mobileqq.vasgift.view.anim.d L;
    private final com.tencent.mobileqq.vasgift.view.anim.e M;
    private BannerResManager N;

    /* renamed from: d, reason: collision with root package name */
    private ph2.b f312043d;

    /* renamed from: e, reason: collision with root package name */
    private int f312044e;

    /* renamed from: f, reason: collision with root package name */
    private int f312045f;

    /* renamed from: h, reason: collision with root package name */
    private int f312046h;

    /* renamed from: i, reason: collision with root package name */
    private long f312047i;

    /* renamed from: m, reason: collision with root package name */
    private int f312048m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class DelaySendRunnable implements Runnable {
        DelaySendRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QQGiftComboSendView.this.i();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends com.tencent.mobileqq.vasgift.view.b {
        a(int i3) {
            super(i3);
        }

        @Override // com.tencent.mobileqq.vasgift.view.b
        public void a(View view) {
            QQGiftComboSendView.this.o();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements LongClickHandler.c {
        b() {
        }

        @Override // com.tencent.mobileqq.vasgift.utils.LongClickHandler.c
        public void a(View view) {
            QQGiftComboSendView.this.l();
        }

        @Override // com.tencent.mobileqq.vasgift.utils.LongClickHandler.c
        public void b(View view) {
            QQGiftComboSendView.this.m();
        }

        @Override // com.tencent.mobileqq.vasgift.utils.LongClickHandler.c
        public void c(View view) {
            QQGiftComboSendView.this.n();
        }
    }

    public QQGiftComboSendView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f312044e = 1;
        this.f312045f = -1;
        this.f312046h = Integer.MAX_VALUE;
        this.f312047i = 0L;
        this.f312048m = 0;
        this.C = R.drawable.nk8;
        LayoutInflater.from(context).inflate(R.layout.h8u, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.f88474x6);
        this.D = imageView;
        this.L = new com.tencent.mobileqq.vasgift.view.anim.d(imageView);
        this.M = new com.tencent.mobileqq.vasgift.view.anim.e(imageView);
        QQGiftCircleProgress qQGiftCircleProgress = (QQGiftCircleProgress) findViewById(R.id.g1f);
        qQGiftCircleProgress.setStrokeWidth(ImmersiveUtils.dpToPx(1.0f));
        qQGiftCircleProgress.setBgAndProgressColor(0, 0, 100, Color.parseColor("#FFE99F"));
        qQGiftCircleProgress.setProgress(100.0f);
        com.tencent.mobileqq.vasgift.view.anim.b bVar = new com.tencent.mobileqq.vasgift.view.anim.b(qQGiftCircleProgress, 3000);
        this.H = bVar;
        bVar.d(this);
        this.J = new f(findViewById(R.id.f120717_a));
        this.K = new com.tencent.mobileqq.vasgift.view.anim.a(findViewById(R.id.t9a));
        this.F = (TextView) findViewById(R.id.f164846u15);
        ImageView imageView2 = (ImageView) findViewById(R.id.send_btn);
        this.E = imageView2;
        this.I = new com.tencent.mobileqq.vasgift.view.anim.d(imageView2);
        imageView2.setOnClickListener(new a(200));
        LongClickHandler longClickHandler = new LongClickHandler(imageView2);
        this.G = longClickHandler;
        longClickHandler.h(new b(), 200);
    }

    private void g() {
        int h16 = h();
        if (h16 != this.f312045f) {
            this.f312045f = h16;
            k();
        }
    }

    private int h() {
        int i3 = this.f312044e;
        if (i3 < 10) {
            return 1;
        }
        if (i3 < 50) {
            return 2;
        }
        if (i3 < 100) {
            return 3;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int i3;
        ph2.b bVar = this.f312043d;
        if (bVar != null && (i3 = this.f312048m) > 0) {
            bVar.c(i3, this.f312044e, false);
        }
        this.f312048m = 0;
    }

    private void j() {
        if (this.f312044e == this.f312046h) {
            this.f312043d.e();
            return;
        }
        p();
        this.I.a();
        int i3 = this.f312044e + 1;
        this.f312044e = i3;
        ph2.b bVar = this.f312043d;
        if (bVar != null) {
            bVar.s(i3);
        }
        r();
        q();
        g();
        long currentTimeMillis = System.currentTimeMillis();
        this.f312048m++;
        if (this.f312044e == this.f312046h) {
            i();
        } else if (currentTimeMillis - this.f312047i > 1000) {
            this.f312047i = currentTimeMillis;
            ThreadManager.b(new DelaySendRunnable(), 1000L);
        }
    }

    private void k() {
        this.J.e(this.f312045f);
        this.D.setImageBitmap(this.N.t(this.f312045f));
        this.E.setImageBitmap(this.N.r(this.f312045f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.H.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.H.c();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.H.c();
        this.H.e();
        j();
    }

    private void p() {
        if (this.D.getVisibility() != 0) {
            this.D.setVisibility(0);
            this.M.a();
        } else {
            this.M.b();
            this.L.a();
        }
    }

    private void q() {
        int i3 = this.f312044e;
        if (i3 == 7 || i3 == 17 || i3 == 47) {
            this.K.e();
        }
    }

    private void r() {
        this.F.setText(HippyTKDListViewAdapter.X + this.f312044e);
        int i3 = this.f312044e;
        if (i3 / 10 == 0) {
            if (this.C != R.drawable.nk8) {
                this.C = R.drawable.nk8;
                this.F.setBackgroundResource(R.drawable.nk8);
                return;
            }
            return;
        }
        if (i3 / 100 == 0) {
            if (this.C != R.drawable.nk9) {
                this.C = R.drawable.nk9;
                this.F.setBackgroundResource(R.drawable.nk9);
                return;
            }
            return;
        }
        if (this.C != R.drawable.nk_) {
            this.C = R.drawable.nk_;
            this.F.setBackgroundResource(R.drawable.nk_);
        }
    }

    @Override // com.tencent.mobileqq.vasgift.view.anim.g
    public void a() {
        i();
        ph2.b bVar = this.f312043d;
        if (bVar != null) {
            bVar.b(this.f312044e);
        }
    }

    public void setComboListener(ph2.b bVar) {
        this.f312043d = bVar;
    }
}
