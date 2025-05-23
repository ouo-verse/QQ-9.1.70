package com.tencent.qqnt.aio.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SelectTouchBarView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    public int C;

    /* renamed from: d, reason: collision with root package name */
    private Context f352443d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f352444e;

    /* renamed from: f, reason: collision with root package name */
    protected int f352445f;

    /* renamed from: h, reason: collision with root package name */
    protected MutliSeletedBottomLine f352446h;

    /* renamed from: i, reason: collision with root package name */
    protected MutliSeletedBottomLine f352447i;

    /* renamed from: m, reason: collision with root package name */
    private int f352448m;

    public SelectTouchBarView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        this.f352448m = -1;
        this.C = 0;
        this.f352443d = context;
        LayoutInflater.from(context).inflate(R.layout.c6l, this);
        this.f352444e = (TextView) findViewById(R.id.l9j);
        if (com.tencent.qqnt.aio.utils.multiForward.a.f352306a.b()) {
            this.f352444e.setBackgroundResource(R.drawable.j8s);
        }
        b((RelativeLayout) findViewById(R.id.l9i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(RelativeLayout relativeLayout) {
        b(relativeLayout);
        invalidate();
    }

    protected void b(RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) relativeLayout);
            return;
        }
        int width = relativeLayout.getWidth();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f352444e.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = ((width - this.f352444e.getMeasuredWidth()) - x.c(this.f352443d, 16.0f)) / 2;
        if (measuredWidth < 0) {
            measuredWidth = 0;
        }
        this.f352446h = new MutliSeletedBottomLine(this.f352443d, measuredWidth, false);
        this.f352447i = new MutliSeletedBottomLine(this.f352443d, measuredWidth, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(measuredWidth, -2);
        layoutParams.addRule(9);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(measuredWidth, -2);
        layoutParams2.addRule(11);
        relativeLayout.addView(this.f352446h, layoutParams);
        relativeLayout.addView(this.f352447i, layoutParams2);
    }

    public SelectTouchBarView c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SelectTouchBarView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f352445f <= 0) {
            this.f352445f = 30;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.f352445f;
        layoutParams.width = -1;
        setLayoutParams(layoutParams);
        g();
        return this;
    }

    public SelectTouchBarView e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SelectTouchBarView) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        this.f352445f = i3;
        if (i3 <= 0) {
            this.f352445f = 0;
        }
        setMinimumHeight(this.f352445f);
        return this;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f352444e.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.j8s));
            this.f352444e.setTextColor(getContext().getColor(R.color.qui_common_brand_standard));
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.l9i);
        relativeLayout.removeView(this.f352446h);
        relativeLayout.removeView(this.f352447i);
        if (relativeLayout.getWidth() == 0) {
            relativeLayout.post(new Runnable() { // from class: com.tencent.qqnt.aio.widget.j
                @Override // java.lang.Runnable
                public final void run() {
                    SelectTouchBarView.this.d(relativeLayout);
                }
            });
        } else {
            b(relativeLayout);
            invalidate();
        }
    }

    public void setCheckedNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 0) {
            sb5.append("\u9009\u62e9\u5230\u8fd9\u91cc");
        } else {
            sb5.append("\u9009\u62e9\u5230\u8fd9\u91cc(\u5df2\u9009" + i3 + "\u6761)");
        }
        this.f352444e.setText(sb5.toString());
        this.f352444e.setContentDescription(sb5.toString());
        g();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onClickListener);
        } else {
            this.f352444e.setOnClickListener(onClickListener);
        }
    }
}
