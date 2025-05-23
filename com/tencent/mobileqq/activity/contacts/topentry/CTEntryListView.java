package com.tencent.mobileqq.activity.contacts.topentry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.HorizontalListView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CTEntryListView extends HorizontalListView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f181717d;

    /* renamed from: e, reason: collision with root package name */
    private int f181718e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f181719f;

    public CTEntryListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.widget.HorizontalListView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        boolean z17 = true;
        if (action == 0) {
            this.f181717d = (int) (motionEvent.getX() + 0.5f);
            this.f181718e = (int) (motionEvent.getY() + 0.5f);
            this.f181719f = true;
            FrameHelperActivity.gj(false, "CTEntryListView");
        } else if (action == 2) {
            int x16 = (int) (motionEvent.getX() + 0.5f);
            int y16 = (int) (motionEvent.getY() + 0.5f);
            int abs = Math.abs(x16 - this.f181717d);
            int abs2 = Math.abs(y16 - this.f181718e);
            int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            if (this.f181719f && abs > scaledTouchSlop) {
                if (abs2 / abs < 0.6f && this.f181717d > ((int) (ScreenUtil.SCREEN_WIDTH * 0.1f))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    FrameHelperActivity.gj(true, "CTEntryListView");
                }
                this.f181719f = false;
                if (!z16) {
                    try {
                        if (!super.onInterceptTouchEvent(motionEvent)) {
                            z17 = false;
                        }
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return z17;
            }
        } else if (action == 1 || action == 3) {
            FrameHelperActivity.gj(true, "CTEntryListView");
            this.f181719f = false;
        }
        z16 = false;
        if (!z16) {
        }
        return z17;
    }

    @Override // com.tencent.widget.HorizontalListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            FrameHelperActivity.gj(false, "CTEntryListView");
        } else if (action == 1 || action == 3) {
            FrameHelperActivity.gj(true, "CTEntryListView");
            this.f181719f = false;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public CTEntryListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
