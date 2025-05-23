package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.fling.TopContentLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TopLayout extends RelativeLayout implements TopContentLayout.OnOutScreenListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TopLayout";
    private TopBehindLayout mBehindView;
    private boolean mConfigChanged;
    private TopContentLayout mContentView;
    private OnDraggingListener mListener;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface OnDraggingListener {
        void cancelDrag();

        void endDrag();

        void startDrag();
    }

    public TopLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void init(Context context) {
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        TopBehindLayout topBehindLayout = new TopBehindLayout(context);
        this.mBehindView = topBehindLayout;
        addView(topBehindLayout, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        TopContentLayout topContentLayout = new TopContentLayout(context);
        this.mContentView = topContentLayout;
        topContentLayout.setOnOutScreenListener(this);
        addView(this.mContentView, layoutParams2);
    }

    private void scaleView(View view, float f16) {
        int width = getWidth();
        int height = getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        int i3 = (int) (width * f16);
        layoutParams.width = i3;
        int i16 = (int) (height * f16);
        layoutParams.height = i16;
        layoutParams.leftMargin = (width - i3) / 2;
        layoutParams.topMargin = (height - i16) / 2;
        view.setLayoutParams(layoutParams);
    }

    public OnDraggingListener getOnDraggingListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (OnDraggingListener) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mListener;
    }

    public void onConfigChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) configuration);
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopContentLayout.OnOutScreenListener
    public void outing(int i3, int i16, View view) {
        OnDraggingListener onDraggingListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), view);
            return;
        }
        int i17 = getContext().getResources().getDisplayMetrics().widthPixels;
        TopBehindLayout topBehindLayout = this.mBehindView;
        if (topBehindLayout != null) {
            float abs = Math.abs(i3 / i17);
            float f16 = (0.050000012f * abs) + 0.95f;
            if (f16 < 1.0f) {
                topBehindLayout.setForeground(new ColorDrawable(((int) ((1.0f - abs) * 128.0f)) << 24));
            }
            scaleView(topBehindLayout, f16);
        }
        if (Math.abs(i3) >= i17) {
            OnDraggingListener onDraggingListener2 = this.mListener;
            if (onDraggingListener2 != null) {
                onDraggingListener2.endDrag();
                return;
            }
            return;
        }
        if (i3 == 0 && (onDraggingListener = this.mListener) != null) {
            onDraggingListener.cancelDrag();
        }
    }

    public void setBehind(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.mBehindView.setContent(view);
        }
    }

    public void setContent(ContentWrapView contentWrapView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) contentWrapView);
        } else {
            this.mContentView.setContent(contentWrapView);
        }
    }

    public void setOnDraggingListener(OnDraggingListener onDraggingListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onDraggingListener);
        } else {
            this.mListener = onDraggingListener;
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopContentLayout.OnOutScreenListener
    public void startDrag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        OnDraggingListener onDraggingListener = this.mListener;
        if (onDraggingListener != null) {
            onDraggingListener.startDrag();
        }
    }

    public TopLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TopLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
