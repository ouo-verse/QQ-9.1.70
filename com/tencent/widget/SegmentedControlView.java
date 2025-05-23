package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiRadioGroupBase;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SegmentedControlView extends KapalaiRadioGroupBase {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f384667d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f384668e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f384669f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f384670h;

    public SegmentedControlView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            setOrientation(0);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void b() {
        int childCount = getChildCount();
        if (childCount > 1) {
            if (this.f384667d != null) {
                getChildAt(0).setBackgroundDrawable(this.f384667d);
            }
            if (this.f384669f != null) {
                for (int i3 = childCount - 2; i3 > 0; i3--) {
                    getChildAt(i3).setBackgroundDrawable(this.f384669f);
                }
            }
            if (this.f384668e != null) {
                getChildAt(childCount - 1).setBackgroundDrawable(this.f384668e);
                return;
            }
            return;
        }
        if (childCount == 1 && this.f384670h != null) {
            getChildAt(0).setBackgroundDrawable(this.f384670h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.utils.kapalaiadapter.KapalaiRadioGroupBase
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.a();
            b();
        }
    }

    public void setBackgroundFirstButton(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
        } else {
            this.f384667d = drawable;
        }
    }

    public void setBackgroundLastButton(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
        } else {
            this.f384668e = drawable;
        }
    }

    public void setBackgroundMiddleButton(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
        } else {
            this.f384669f = drawable;
        }
    }

    public void setBackgroundUniqueButton(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable);
        } else {
            this.f384670h = drawable;
        }
    }

    public SegmentedControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegmentedControlView);
        try {
            this.f384667d = obtainStyledAttributes.getDrawable(R.styleable.SegmentedControlView_firstButtonBackground);
            this.f384668e = obtainStyledAttributes.getDrawable(R.styleable.SegmentedControlView_lastButtonBackground);
            this.f384669f = obtainStyledAttributes.getDrawable(R.styleable.SegmentedControlView_middleButtonBackground);
            this.f384670h = obtainStyledAttributes.getDrawable(R.styleable.SegmentedControlView_uniqueButtonBackground);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i("Q.recent", 2, e16.toString());
            }
        }
        setOrientation(obtainStyledAttributes.getInt(R.styleable.SegmentedControlView_android_orientation, 0));
        obtainStyledAttributes.recycle();
    }
}
