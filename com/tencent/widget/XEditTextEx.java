package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.util.ab;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XEditTextEx extends XEditText implements View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f384703d;

    /* renamed from: e, reason: collision with root package name */
    private int f384704e;

    /* renamed from: f, reason: collision with root package name */
    private PerformClick f384705f;

    /* renamed from: h, reason: collision with root package name */
    private List<WeakReference<View.OnClickListener>> f384706h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnLongClickListener f384707i;

    /* renamed from: m, reason: collision with root package name */
    private List<e> f384708m;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private final class PerformClick implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        long f384709d;

        /* renamed from: e, reason: collision with root package name */
        View f384710e;

        PerformClick(View view, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, XEditTextEx.this, view, Long.valueOf(j3));
            } else {
                this.f384710e = view;
                this.f384709d = j3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            View.OnClickListener onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (XEditTextEx.this.f384706h != null && XEditTextEx.this.f384706h.size() > 0) {
                for (WeakReference weakReference : XEditTextEx.this.f384706h) {
                    if (weakReference != null && (onClickListener = (View.OnClickListener) weakReference.get()) != null) {
                        onClickListener.onClick(this.f384710e);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface e {
        boolean a();

        boolean b();

        boolean onCopy();
    }

    public XEditTextEx(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f384708m = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) onClickListener);
            return;
        }
        if (this.f384706h == null) {
            this.f384706h = new ArrayList();
        }
        this.f384706h.add(new WeakReference<>(onClickListener));
    }

    public boolean c(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18))).booleanValue();
        }
        float f19 = -f18;
        if (f16 >= f19 && f17 >= f19 && f16 < (getRight() - getLeft()) + f18 && f17 < (getBottom() - getTop()) + f18) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onCheckIsTextEditor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return super.onCheckIsTextEditor();
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) accessibilityNodeInfo);
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence emoticonToTextForTalkBack = TextUtils.emoticonToTextForTalkBack(getText().toString());
        accessibilityNodeInfo.setText(emoticonToTextForTalkBack);
        if (ab.a()) {
            if (android.text.TextUtils.isEmpty(emoticonToTextForTalkBack)) {
                emoticonToTextForTalkBack = getHint();
            }
            accessibilityNodeInfo.setContentDescription(emoticonToTextForTalkBack);
            return;
        }
        accessibilityNodeInfo.setContentDescription(emoticonToTextForTalkBack);
    }

    @Override // android.widget.TextView
    public boolean onPrivateIMECommand(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) bundle)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("XEditTextEx", 1, "onPrivateIMECommand(), action:" + str + " data:" + bundle);
        }
        return super.onPrivateIMECommand(str, bundle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        try {
            for (e eVar : this.f384708m) {
                switch (i3) {
                    case 16908320:
                        if (eVar.b()) {
                            return true;
                        }
                        break;
                    case 16908321:
                        if (eVar.onCopy()) {
                            return true;
                        }
                        break;
                    case 16908322:
                        if (eVar.a()) {
                            return true;
                        }
                        break;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            return super.onTextContextMenuItem(i3);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("XEditTextEx", 2, "onTextContextMenuItem has exception,", e16);
            }
            return false;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (!view.isClickable()) {
            return false;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f384703d == 0) {
            this.f384703d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
        if (this.f384704e == 0) {
            this.f384704e = ViewConfiguration.getLongPressTimeout();
        }
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.f384705f = null;
                    }
                } else if (!c(x16, y16, this.f384703d)) {
                    this.f384705f = null;
                }
            } else {
                PerformClick performClick = this.f384705f;
                if (performClick != null && Math.abs(currentTimeMillis - performClick.f384709d) < this.f384704e) {
                    post(this.f384705f);
                }
                this.f384705f = null;
            }
        } else {
            this.f384705f = new PerformClick(view, currentTimeMillis);
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            super.onWindowFocusChanged(z16);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        try {
            z16 = super.performLongClick();
        } catch (IndexOutOfBoundsException e16) {
            QLog.w("XEditTextEx", 1, "performLongClick: ", e16);
            z16 = false;
        }
        View.OnLongClickListener onLongClickListener = this.f384707i;
        if (onLongClickListener != null) {
            onLongClickListener.onLongClick(this);
        }
        return z16;
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.scrollTo(i3, i16);
        }
    }

    public void setKeyEventPreImeListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
    }

    public void setOnKeyboardShowListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onLongClickListener);
        } else {
            this.f384707i = onLongClickListener;
        }
    }

    public void setOnPrivateIMECommandListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        }
    }

    public void setOnWindowFocusChangedListener(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) dVar);
        }
    }

    public XEditTextEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f384708m = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
