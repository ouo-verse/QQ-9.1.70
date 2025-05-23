package com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import u0.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LoadingView extends FrameLayout implements ThreadCenter.HandlerKeyable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f271798d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f271799e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f271800f;

    public LoadingView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f271800f = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.LoadingView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LoadingView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LoadingView.this.getContext() != null) {
                        LoadingView.this.setVisibility(8);
                    }
                }
            };
            b();
        }
    }

    private void a() {
        a.h().c("https://dlied5.qq.com/now/qq-live/images/loading.png", this.f271798d, new a.c(0, true, false));
    }

    private void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fm9, (ViewGroup) this, true);
        this.f271798d = (ImageView) inflate.findViewById(R.id.ys7);
        this.f271799e = (TextView) inflate.findViewById(R.id.zrk);
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDetachedFromWindow();
            ThreadCenter.clear(this);
        }
    }

    public void setLoadingStatus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        setVisibility(0);
        if (z16) {
            this.f271798d.setVisibility(0);
            this.f271799e.setVisibility(8);
        } else {
            this.f271798d.setVisibility(8);
            this.f271799e.setVisibility(0);
            ThreadCenter.postDelayedUITask(this, this.f271800f, 1000L);
        }
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f271800f = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.LoadingView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LoadingView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LoadingView.this.getContext() != null) {
                        LoadingView.this.setVisibility(8);
                    }
                }
            };
            b();
        }
    }

    public LoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f271800f = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.LoadingView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LoadingView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LoadingView.this.getContext() != null) {
                        LoadingView.this.setVisibility(8);
                    }
                }
            };
            b();
        }
    }
}
