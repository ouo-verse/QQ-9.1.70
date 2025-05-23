package com.tencent.theme;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;

/* loaded from: classes26.dex */
public class SkinnableActivityProcesser extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "[SkinnableActivityProcesser]";
    private final Activity mActivity;
    private final Callback mCallback;

    /* loaded from: classes26.dex */
    public interface Callback {
        void onPostThemeChanged();

        void onPreThemeChanged();
    }

    public SkinnableActivityProcesser(Activity activity, Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) callback);
            return;
        }
        this.mActivity = activity;
        this.mCallback = callback;
        try {
            activity.registerReceiver(this, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
            m.a(TAG, 1, "registerReceiver!");
        } catch (Exception e16) {
            m.d(TAG, 1, "registerReceiver error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean updateDrawableContainerPadding(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) drawable.getConstantState()) != null) {
            Drawable[] children = drawableContainerState.getChildren();
            int childCount = drawableContainerState.getChildCount();
            boolean z16 = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                Drawable drawable2 = children[i3];
                if (drawable2 instanceof SkinnableNinePatchDrawable) {
                    z16 = true;
                } else if (drawable2 instanceof DrawableContainer) {
                    z16 |= updateDrawableContainerPadding(drawable2);
                }
            }
            try {
                Field declaredField = DrawableContainer.DrawableContainerState.class.getDeclaredField("mComputedConstantSize");
                declaredField.setAccessible(true);
                declaredField.setBoolean(drawableContainerState, false);
            } catch (Exception unused) {
            }
            if (z16) {
                try {
                    Field declaredField2 = DrawableContainer.DrawableContainerState.class.getDeclaredField("mPaddingChecked");
                    declaredField2.setAccessible(true);
                    declaredField2.setBoolean(drawableContainerState, false);
                    Field declaredField3 = DrawableContainer.DrawableContainerState.class.getDeclaredField("mConstantPadding");
                    declaredField3.setAccessible(true);
                    declaredField3.set(drawableContainerState, null);
                } catch (Exception unused2) {
                }
                return true;
            }
        }
        return false;
    }

    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            this.mActivity.unregisterReceiver(this);
            m.a(TAG, 1, "unregisterReceiver!");
        } catch (Exception e16) {
            m.d(TAG, 1, "unregisterReceiver error", e16);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
            return;
        }
        int intExtra = intent.getIntExtra("pid", Process.myPid());
        if (intExtra != Process.myPid()) {
            m.a(TAG, 1, "onReceive differentPid! callPid=" + intExtra + ",current=" + Process.myPid());
            return;
        }
        m.a(SkinEngine.TAG, 1, "SkinnableActivityProcesser on pre theme changed");
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onPreThemeChanged();
        }
        update(intent);
        m.a(SkinEngine.TAG, 1, "SkinnableActivityProcesser on post theme changed");
    }

    public void update(Intent intent) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        try {
            view = this.mActivity.getWindow().getDecorView();
        } catch (Exception unused) {
            view = null;
        }
        if (view == null) {
            return;
        }
        if (intent.getBooleanExtra("isFont", false)) {
            TextHook.getInstance().checkTypeface(view.getContext());
            TextHook.updateFont(view);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        View[] viewArr = new View[childCount];
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            viewArr[i3] = viewGroup.getChildAt(i3);
        }
        try {
            viewGroup.removeAllViews();
        } catch (Exception e16) {
            m.d(TAG, 1, "removeAllViews error", e16);
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            try {
                viewGroup.addView(viewArr[i16]);
            } catch (Exception e17) {
                m.d(TAG, 1, "addView error", e17);
            }
        }
        SkinEngine.invalidateAll(view);
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onPostThemeChanged();
        }
    }
}
