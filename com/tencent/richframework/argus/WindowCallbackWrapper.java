package com.tencent.richframework.argus;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.GestureDetector;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Argus;
import com.tencent.richframework.argus.ActionInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class WindowCallbackWrapper implements Window.Callback {
    private final Window.Callback mCallback;
    private final GestureDetector mDetector;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public WindowCallbackWrapper(final Activity activity, Window.Callback callback) {
        this.mCallback = callback;
        this.mDetector = new GestureDetector(activity, new GestureDetector.OnGestureListener() { // from class: com.tencent.richframework.argus.WindowCallbackWrapper.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                if (activity.getWindow().peekDecorView() != null && activity.getWindow().peekDecorView().getWindowToken() != null) {
                    Argus.INSTANCE.sendActionInfo(new ActionInfo(activity.getWindow().peekDecorView().getWindowToken().hashCode(), ActionInfo.Type.FLING));
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (activity.getWindow().peekDecorView() != null && activity.getWindow().peekDecorView().getWindowToken() != null) {
                    Argus.INSTANCE.sendActionInfo(new ActionInfo(activity.getWindow().peekDecorView().getWindowToken().hashCode(), ActionInfo.Type.CLICK_VIEW, motionEvent.getX(), motionEvent.getY()));
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onWindowAttributesChanged$0(WindowManager.LayoutParams layoutParams) {
        this.mCallback.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mCallback.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            Argus.INSTANCE.sendActionInfo(new ActionInfo(0, ActionInfo.Type.KEY_BACK));
        }
        return this.mCallback.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mCallback.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mCallback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mDetector.onTouchEvent(motionEvent);
        return this.mCallback.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mCallback.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.mCallback.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.mCallback.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mCallback.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.mCallback.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, @NonNull Menu menu) {
        return this.mCallback.onCreatePanelMenu(i3, menu);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public View onCreatePanelView(int i3) {
        return this.mCallback.onCreatePanelView(i3);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mCallback.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, @NonNull MenuItem menuItem) {
        return this.mCallback.onMenuItemSelected(i3, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i3, @NonNull Menu menu) {
        return this.mCallback.onMenuOpened(i3, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i3, @NonNull Menu menu) {
        this.mCallback.onPanelClosed(i3, menu);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(api = 26)
    public void onPointerCaptureChanged(boolean z16) {
        this.mCallback.onPointerCaptureChanged(z16);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i3, @Nullable View view, @NonNull Menu menu) {
        return this.mCallback.onPreparePanel(i3, view, menu);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(api = 24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, @Nullable Menu menu, int i3) {
        this.mCallback.onProvideKeyboardShortcuts(list, menu, i3);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mCallback.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(final WindowManager.LayoutParams layoutParams) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mCallback.onWindowAttributesChanged(layoutParams);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.tencent.richframework.argus.a
                @Override // java.lang.Runnable
                public final void run() {
                    WindowCallbackWrapper.this.lambda$onWindowAttributesChanged$0(layoutParams);
                }
            });
        }
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        this.mCallback.onWindowFocusChanged(z16);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.mCallback.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.mCallback.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i3) {
        return this.mCallback.onWindowStartingActionMode(callback, i3);
    }
}
