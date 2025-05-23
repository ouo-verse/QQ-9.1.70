package com.tencent.mobileqq.ad.troopad.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.ad.troopad.util.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopAdIconView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final Context f186965d;

    /* renamed from: e, reason: collision with root package name */
    private View f186966e;

    /* renamed from: f, reason: collision with root package name */
    private PopupWindow f186967f;

    /* renamed from: h, reason: collision with root package name */
    private final List<ValueAnimator> f186968h;

    /* renamed from: i, reason: collision with root package name */
    private final View.OnClickListener f186969i;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAdIconView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopAdIconView.this.c(view);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TroopAdIconView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f186968h = Collections.synchronizedList(new ArrayList());
        this.f186969i = new a();
        this.f186965d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        QLog.d("TroopAdIconView", 1, "handleAdClick");
        b bVar = b.f186956a;
        throw null;
    }

    private void e() {
        throw null;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        for (ValueAnimator valueAnimator : this.f186968h) {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        this.f186968h.clear();
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.d("TroopAdIconView", 1, "handleAdClose");
        this.f186966e.setVisibility(8);
        this.f186967f.dismiss();
        e();
        b();
        com.tencent.mobileqq.ad.troopad.util.a.f186952a.a();
    }
}
