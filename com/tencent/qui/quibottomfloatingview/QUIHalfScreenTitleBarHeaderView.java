package com.tencent.qui.quibottomfloatingview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quicommon.AccessibilityUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QUIHalfScreenTitleBarHeaderView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f363689d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f363690e;

    /* renamed from: f, reason: collision with root package name */
    public QUIHalfScreenFloatingView f363691f;

    /* renamed from: h, reason: collision with root package name */
    private final float f363692h;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUIHalfScreenTitleBarHeaderView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QUIHalfScreenFloatingView qUIHalfScreenFloatingView = QUIHalfScreenTitleBarHeaderView.this.f363691f;
                if (qUIHalfScreenFloatingView != null) {
                    qUIHalfScreenFloatingView.h();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QUIHalfScreenTitleBarHeaderView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    protected int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        return (int) ((i3 * this.f363692h) + 0.5f);
    }

    public void setHalfScreenView(QUIHalfScreenFloatingView qUIHalfScreenFloatingView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qUIHalfScreenFloatingView);
        } else {
            this.f363691f = qUIHalfScreenFloatingView;
        }
    }

    public void setThemeId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f363690e.setTextColor(ie0.a.f().h(getContext(), R.color.qui_common_text_primary, i3));
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.f363690e.setText(str);
        if (ud0.a.c()) {
            AccessibilityUtil.c(this.f363690e);
        }
    }

    public QUIHalfScreenTitleBarHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public QUIHalfScreenTitleBarHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f363692h = getContext().getResources().getDisplayMetrics().density;
        TextView textView = new TextView(getContext());
        this.f363690e = textView;
        textView.setTextSize(17.0f);
        this.f363690e.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
        this.f363690e.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(13);
        addView(this.f363690e, layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.f363689d = imageView;
        imageView.setImageDrawable(getContext().getDrawable(R.drawable.qui_close_selector));
        this.f363689d.setContentDescription(context.getResources().getString(R.string.close));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(24), a(24));
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, 0, a(10), 0);
        addView(this.f363689d, layoutParams2);
        this.f363689d.setOnClickListener(new a());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, a(44));
        layoutParams3.topMargin = a(8);
        setLayoutParams(layoutParams3);
    }
}
