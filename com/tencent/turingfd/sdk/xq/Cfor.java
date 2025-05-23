package com.tencent.turingfd.sdk.xq;

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
import java.util.List;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.for, reason: invalid class name */
/* loaded from: classes27.dex */
public abstract class Cfor implements Window.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Window.Callback f383355a;

    public Cfor(Window.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
        } else {
            if (callback != null) {
                this.f383355a = callback;
                return;
            }
            throw new IllegalArgumentException("Window callback may not be null");
        }
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.f383355a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return this.f383355a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) keyEvent)).booleanValue();
        }
        return this.f383355a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) accessibilityEvent)).booleanValue();
        }
        return this.f383355a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
            return this.f383355a.dispatchTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.f383355a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) actionMode);
        } else {
            this.f383355a.onActionModeFinished(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) actionMode);
        } else {
            this.f383355a.onActionModeStarted(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.f383355a.onAttachedToWindow();
        }
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.f383355a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) menu)).booleanValue();
        }
        return this.f383355a.onCreatePanelMenu(i3, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        return this.f383355a.onCreatePanelView(i3);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.f383355a.onDetachedFromWindow();
        }
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) menuItem)).booleanValue();
        }
        return this.f383355a.onMenuItemSelected(i3, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i3, Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) menu)).booleanValue();
        }
        return this.f383355a.onMenuOpened(i3, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3, (Object) menu);
        } else {
            this.f383355a.onPanelClosed(i3, menu);
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            this.f383355a.onPointerCaptureChanged(z16);
        } else {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        }
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, menu)).booleanValue();
        }
        return this.f383355a.onPreparePanel(i3, view, menu);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            this.f383355a.onProvideKeyboardShortcuts(list, menu, i3);
        } else {
            iPatchRedirector.redirect((short) 25, this, list, menu, Integer.valueOf(i3));
        }
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? this.f383355a.onSearchRequested(searchEvent) : ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) searchEvent)).booleanValue();
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) layoutParams);
        } else {
            try {
                this.f383355a.onWindowAttributesChanged(layoutParams);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.f383355a.onWindowFocusChanged(z16);
        }
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? this.f383355a.onWindowStartingActionMode(callback) : (ActionMode) iPatchRedirector.redirect((short) 21, (Object) this, (Object) callback);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? this.f383355a.onSearchRequested() : ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? this.f383355a.onWindowStartingActionMode(callback, i3) : (ActionMode) iPatchRedirector.redirect((short) 22, (Object) this, (Object) callback, i3);
    }
}
