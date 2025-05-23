package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ChatFragmentTopGestureLayout extends TopGestureLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f182247d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f182248e;
    public ChatFragment.a mMyDispatchDrawListener;

    public ChatFragmentTopGestureLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f182248e = false;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, view, Integer.valueOf(i3), layoutParams);
            return;
        }
        super.addView(view, i3, layoutParams);
        if (view.getId() != R.id.f164059ir) {
            QLog.d(TopGestureLayout.TAG, 1, Log.getStackTraceString(new Throwable("child is not aio")));
        }
    }

    public void disableTopInset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f182248e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
        } else {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) rect)).booleanValue();
        }
        this.f182247d = rect.top;
        if (this.f182248e) {
            rect.top = 0;
        }
        return super.fitSystemWindows(rect);
    }

    public int getTopInst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f182247d;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        super.setFitsSystemWindows(z16);
        if (z16) {
            QLog.d(TopGestureLayout.TAG, 1, Log.getStackTraceString(new Throwable("fitSystemWindows is " + z16)));
        }
    }

    public void setMyDispatchDrawListener(ChatFragment.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        }
    }

    public ChatFragmentTopGestureLayout(Context context, ChatFragment.a aVar, TopGestureLayout.InterceptTouchEventListener interceptTouchEventListener) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, aVar, interceptTouchEventListener);
            return;
        }
        this.f182248e = false;
        init(context);
        this.mInterceptTouchEventListener = interceptTouchEventListener;
    }
}
