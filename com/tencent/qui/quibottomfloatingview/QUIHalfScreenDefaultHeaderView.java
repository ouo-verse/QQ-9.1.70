package com.tencent.qui.quibottomfloatingview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quicommon.AccessibilityUtil;
import com.tencent.biz.qui.quicommon.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QUIHalfScreenDefaultHeaderView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QUIBaseHalfScreenFloatingView f363687d;

    public QUIHalfScreenDefaultHeaderView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void b() {
        QUIBaseHalfScreenFloatingView qUIBaseHalfScreenFloatingView = this.f363687d;
        if (qUIBaseHalfScreenFloatingView != null) {
            qUIBaseHalfScreenFloatingView.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b();
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setFloatingView(QUIBaseHalfScreenFloatingView qUIBaseHalfScreenFloatingView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qUIBaseHalfScreenFloatingView);
        } else {
            this.f363687d = qUIBaseHalfScreenFloatingView;
        }
    }

    public QUIHalfScreenDefaultHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public QUIHalfScreenDefaultHeaderView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(getContext().getDrawable(R.drawable.qui_bottom_floating_view_drag_icon));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(imageView, layoutParams);
        setLayoutParams(new FrameLayout.LayoutParams(-1, e.c(14.0f)));
        if (AccessibilityUtil.b(context)) {
            AccessibilityUtil.a(imageView, context.getResources().getString(R.string.close), Button.class.getName());
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qui.quibottomfloatingview.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QUIHalfScreenDefaultHeaderView.this.c(view);
                }
            });
        }
    }
}
