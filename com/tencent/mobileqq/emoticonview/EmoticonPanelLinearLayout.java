package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class EmoticonPanelLinearLayout extends LinearLayout {
    static IPatchRedirector $redirector_;
    private IEmoticonPanelLinearLayoutHelper mHelper;
    private boolean mIsAttachedToWindow;

    public EmoticonPanelLinearLayout(Context context, IEmoticonPanelLinearLayoutHelper iEmoticonPanelLinearLayoutHelper, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, iEmoticonPanelLinearLayoutHelper, Integer.valueOf(i3));
            return;
        }
        this.mHelper = iEmoticonPanelLinearLayoutHelper;
        iEmoticonPanelLinearLayoutHelper.attachCurrentView(this);
        this.mHelper.setBusinessType(i3);
        this.mHelper.initHelper(context);
    }

    @Override // android.view.View
    public int getWindowAttachCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return super.getWindowAttachCount();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.mIsAttachedToWindow;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
        this.mHelper.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
        this.mHelper.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.mHelper.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.mHelper.onTouchEvent(motionEvent);
    }

    public void setCallBack(EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonCallback);
        } else {
            this.mHelper.setCallBack(emoticonCallback);
        }
    }

    public void setInterceptListener(IEmoticonPanelLinearLayoutHelper.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onClickListener);
        } else {
            this.mHelper.setInterceptListener(onClickListener);
        }
    }

    public void setPanelType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mHelper.setPanelType(i3);
        }
    }

    public void setReportCallBack(EmoticonReportCallback emoticonReportCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) emoticonReportCallback);
        } else {
            this.mHelper.setReportCallback(emoticonReportCallback);
        }
    }

    public EmoticonPanelLinearLayout(Context context, IEmoticonPanelLinearLayoutHelper iEmoticonPanelLinearLayoutHelper) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) iEmoticonPanelLinearLayoutHelper);
            return;
        }
        this.mHelper = iEmoticonPanelLinearLayoutHelper;
        iEmoticonPanelLinearLayoutHelper.attachCurrentView(this);
        this.mHelper.initHelper(context);
    }
}
