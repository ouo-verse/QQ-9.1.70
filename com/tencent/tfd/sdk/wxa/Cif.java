package com.tencent.tfd.sdk.wxa;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tfd.sdk.wxa.ComaBerenices;
import java.util.List;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.if, reason: invalid class name */
/* loaded from: classes26.dex */
public abstract class Cif implements Window.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Window.Callback f375757a;

    public Cif(Window.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
        } else {
            if (callback != null) {
                this.f375757a = callback;
                return;
            }
            throw new IllegalArgumentException("Window callback may not be null");
        }
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.f375757a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return this.f375757a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return this.f375757a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) accessibilityEvent)).booleanValue();
        }
        return this.f375757a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        Gooseberry gooseberry = (Gooseberry) this;
        ((ComaBerenices.Cif) gooseberry.f375633b).a(gooseberry.f375634c, motionEvent);
        try {
            return this.f375757a.dispatchTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.f375757a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) actionMode);
        } else {
            this.f375757a.onActionModeFinished(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) actionMode);
        } else {
            this.f375757a.onActionModeStarted(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.f375757a.onAttachedToWindow();
        }
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.f375757a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i3, Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) menu)).booleanValue();
        }
        return this.f375757a.onCreatePanelMenu(i3, menu);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        return this.f375757a.onCreatePanelView(i3);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.f375757a.onDetachedFromWindow();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) menuItem)).booleanValue();
        }
        return this.f375757a.onMenuItemSelected(i3, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i3, Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) menu)).booleanValue();
        }
        return this.f375757a.onMenuOpened(i3, menu);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i3, Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3, (Object) menu);
        } else {
            this.f375757a.onPanelClosed(i3, menu);
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            this.f375757a.onPointerCaptureChanged(z16);
        } else {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i3, View view, Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, menu)).booleanValue();
        }
        return this.f375757a.onPreparePanel(i3, view, menu);
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            this.f375757a.onProvideKeyboardShortcuts(list, menu, i3);
        } else {
            iPatchRedirector.redirect((short) 25, this, list, menu, Integer.valueOf(i3));
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? this.f375757a.onSearchRequested(searchEvent) : ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) searchEvent)).booleanValue();
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) layoutParams);
        } else {
            try {
                this.f375757a.onWindowAttributesChanged(layoutParams);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.f375757a.onWindowFocusChanged(z16);
        }
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? this.f375757a.onWindowStartingActionMode(callback) : (ActionMode) iPatchRedirector.redirect((short) 21, (Object) this, (Object) callback);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? this.f375757a.onSearchRequested() : ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? this.f375757a.onWindowStartingActionMode(callback, i3) : (ActionMode) iPatchRedirector.redirect((short) 22, (Object) this, (Object) callback, i3);
    }
}
