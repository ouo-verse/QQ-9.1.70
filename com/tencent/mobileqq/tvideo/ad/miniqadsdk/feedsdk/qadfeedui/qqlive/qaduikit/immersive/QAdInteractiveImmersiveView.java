package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ax2.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.SpanSequenceTextView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.roundlayout.RoundRelativeLayout;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.image.QAdImageView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.interactive.QAdInteractiveImmersiveEndMaskView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.interactive.QAdInteractiveImmersiveProgressView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.interactive.QAdInteractiveVideoRootLayout;
import java.util.ArrayList;
import pw2.e;
import pw2.s;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdInteractiveImmersiveView extends QAdFeedBaseUI<bx2.a, Object> {
    private View C;
    private QAdImageView D;
    private QAdInteractiveVideoRootLayout E;
    private RoundRelativeLayout F;
    private TextView G;
    private QAdInteractiveImmersiveProgressView H;
    private QAdInteractiveImmersiveEndMaskView I;
    private ImageView J;
    private TextView K;
    private SpanSequenceTextView L;
    private TextView M;
    protected bx2.a N;
    protected zw2.a P;
    protected com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.b Q;
    protected int R;
    protected boolean S;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements SpanSequenceTextView.c {

        /* renamed from: a, reason: collision with root package name */
        boolean f304174a;

        b() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.SpanSequenceTextView.c
        public void a(View view) {
            if (((QAdFeedBaseUI) QAdInteractiveImmersiveView.this).f304156i != null) {
                ((QAdFeedBaseUI) QAdInteractiveImmersiveView.this).f304156i.a(view);
                this.f304174a = true;
            }
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.SpanSequenceTextView.c
        public void b(View view) {
            if (!this.f304174a) {
                a(view);
            }
            if (((QAdFeedBaseUI) QAdInteractiveImmersiveView.this).f304157m != null) {
                ((QAdFeedBaseUI) QAdInteractiveImmersiveView.this).f304157m.onClick(view);
            }
        }
    }

    public QAdInteractiveImmersiveView(Context context) {
        super(context);
        this.Q = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.b();
        p(context);
    }

    private Drawable m(int i3) {
        return getResources().getDrawable(i3);
    }

    private void u(c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.e(this.C);
        cVar.f(this.G);
        cVar.g(this.F);
    }

    private void v() {
        QAdImageView qAdImageView;
        bx2.a aVar = this.N;
        if (aVar != null && (qAdImageView = this.D) != null) {
            qAdImageView.a(aVar.g(), R.drawable.n5v);
        }
    }

    private void x() {
        TextView textView;
        bx2.a aVar = this.N;
        if (aVar != null && (textView = this.G) != null) {
            textView.setText(aVar.f());
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.N.d())) {
                SpanSequenceTextView.f fVar = new SpanSequenceTextView.f(s.a(0.0f), this.N.b(), e.a(R.color.f158017al3));
                fVar.b(new b());
                arrayList.add(fVar);
            }
            arrayList.add(new SpanSequenceTextView.d(s.a(6.0f), s.a(30.0f), s.a(16.0f), m(R.drawable.n5w)));
            this.L.setRichText(arrayList);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.Q.f304163c = ((int) motionEvent.getRawX()) - i3;
                this.Q.f304164d = ((int) motionEvent.getRawY()) - i16;
            }
        } else {
            this.Q.f304161a = ((int) motionEvent.getRawX()) - i3;
            this.Q.f304162b = ((int) motionEvent.getRawY()) - i16;
        }
        zw2.a aVar = this.P;
        if (aVar != null) {
            aVar.a(this.Q);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI
    public final void e(cx2.a aVar) {
        super.e(aVar);
        s();
    }

    protected void l() {
        x();
        v();
        w();
    }

    protected int n() {
        return R.layout.fsk;
    }

    public RelativeLayout o() {
        return this.E;
    }

    protected void p(Context context) {
        q(context);
        setId(R.id.f29810mn);
    }

    protected void q(Context context) {
        View.inflate(context, n(), this);
        this.C = findViewById(R.id.sbr);
        this.D = (QAdImageView) findViewById(R.id.xlf);
        this.F = (RoundRelativeLayout) findViewById(R.id.xll);
        this.E = (QAdInteractiveVideoRootLayout) findViewById(R.id.xlk);
        this.G = (TextView) findViewById(R.id.xlj);
        this.H = (QAdInteractiveImmersiveProgressView) findViewById(R.id.xlg);
        this.I = (QAdInteractiveImmersiveEndMaskView) findViewById(R.id.xla);
        this.J = (ImageView) findViewById(R.id.xlh);
        this.K = (TextView) findViewById(R.id.tba);
        this.L = (SpanSequenceTextView) findViewById(R.id.taz);
        this.M = (TextView) findViewById(R.id.t_0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.QAdFeedBaseUI
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final void f(bx2.a aVar) {
        super.f(aVar);
        this.N = aVar;
        if (aVar == null) {
            return;
        }
        l();
    }

    protected void s() {
        this.I.e(this.f304156i);
        setViewOnClickListener(this.G, this.J, this.E.a(), this.I, this.K, this.L, this.M, this);
    }

    public void setContentImageViewShow(boolean z16) {
        int i3;
        QAdImageView qAdImageView = this.D;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qAdImageView.setVisibility(i3);
    }

    public void setEndMaskShow(boolean z16) {
        int i3;
        QAdInteractiveImmersiveEndMaskView qAdInteractiveImmersiveEndMaskView = this.I;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qAdInteractiveImmersiveEndMaskView.setVisibility(i3);
    }

    public void setEndMaskViewData(com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.c cVar) {
        this.I.setData(cVar);
    }

    public final void setImmersiveType(int i3) {
        y(i3);
    }

    public void setLandscape(boolean z16) {
        if (this.S != z16) {
            this.S = z16;
            y(this.R);
        }
    }

    public void setProgress(int i3) {
        this.H.setProgress(i3);
    }

    public void setVideoPauseIconShow(boolean z16) {
        QAdInteractiveVideoRootLayout qAdInteractiveVideoRootLayout = this.E;
        if (qAdInteractiveVideoRootLayout == null) {
            return;
        }
        if (z16) {
            qAdInteractiveVideoRootLayout.d();
        } else {
            qAdInteractiveVideoRootLayout.b();
        }
    }

    public void t(zw2.a aVar) {
        this.P = aVar;
    }

    protected void w() {
        TextView textView;
        if (this.N != null && (textView = this.K) != null) {
            textView.setText("@" + this.N.e());
        }
    }

    protected void y(int i3) {
        c aVar;
        if (i3 == 0) {
            return;
        }
        this.R = i3;
        if (4 == i3) {
            aVar = new ax2.b(false);
        } else {
            aVar = new ax2.a(false);
        }
        aVar.d(this.S);
        u(aVar);
    }

    public QAdInteractiveImmersiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Q = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.b();
        p(context);
    }

    public QAdInteractiveImmersiveView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.Q = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.feed.model.b();
        p(context);
    }

    public void setReturnImageVisible(int i3) {
    }

    public void setTitleLayoutMargin(int i3) {
    }
}
