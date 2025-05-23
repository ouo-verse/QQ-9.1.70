package com.tencent.mobileqq.emoticonview.searchemo;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class KeyboardVisibilityHelper extends PopupWindow {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "KeyboardVisibilityHelper";
    private KeyBoardLayoutListener mListener;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class KeyBoardLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;
        private View mContentView;
        private Context mContext;
        private boolean mIgnoreBarHeight;
        private KeyboardCallback mKeyBoardCallback;

        public KeyBoardLayoutListener(Context context, View view, KeyboardCallback keyboardCallback, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, KeyboardVisibilityHelper.this, context, view, keyboardCallback, Boolean.valueOf(z16));
                return;
            }
            this.mContext = context;
            this.mContentView = view;
            this.mKeyBoardCallback = keyboardCallback;
            this.mIgnoreBarHeight = z16;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            if (windowManager == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(KeyboardVisibilityHelper.TAG, 2, "window manager is null, return");
                    return;
                }
                return;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            Rect rect = new Rect();
            this.mContentView.getWindowVisibleDisplayFrame(rect);
            int i3 = displayMetrics.heightPixels - (rect.bottom - rect.top);
            int identifier = this.mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0 && !this.mIgnoreBarHeight) {
                i3 -= this.mContext.getResources().getDimensionPixelSize(identifier);
            }
            boolean z16 = false;
            if (i3 < 100) {
                i3 = 0;
            }
            if (i3 > 0) {
                z16 = true;
            }
            KeyboardCallback keyboardCallback = this.mKeyBoardCallback;
            if (keyboardCallback != null) {
                keyboardCallback.onKeyboardHeightChanged(i3, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface KeyboardCallback {
        void onKeyboardHeightChanged(int i3, boolean z16);
    }

    public KeyboardVisibilityHelper(@NotNull Context context, @NotNull View view, @Nullable KeyboardCallback keyboardCallback, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, view, keyboardCallback, Boolean.valueOf(z16));
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mListener = new KeyBoardLayoutListener(context, linearLayout, keyboardCallback, z16);
        linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.mListener);
        setContentView(linearLayout);
        setSoftInputMode(21);
        setInputMethodMode(1);
        setWidth(0);
        setHeight(-1);
        setOnDismissListener(new PopupWindow.OnDismissListener(linearLayout) { // from class: com.tencent.mobileqq.emoticonview.searchemo.KeyboardVisibilityHelper.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ LinearLayout val$contentView;

            {
                this.val$contentView = linearLayout;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KeyboardVisibilityHelper.this, (Object) linearLayout);
                }
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    this.val$contentView.getViewTreeObserver().removeOnGlobalLayoutListener(KeyboardVisibilityHelper.this.mListener);
                }
            }
        });
        view.post(new Runnable(view) { // from class: com.tencent.mobileqq.emoticonview.searchemo.KeyboardVisibilityHelper.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ View val$parentView;

            {
                this.val$parentView = view;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KeyboardVisibilityHelper.this, (Object) view);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    KeyboardVisibilityHelper.this.showAtLocation(this.val$parentView, 0, 0, 0);
                }
            }
        });
    }
}
