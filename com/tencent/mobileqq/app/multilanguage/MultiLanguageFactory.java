package com.tencent.mobileqq.app.multilanguage;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.widget.AlphaClickableButton;
import com.tencent.widget.AlphaClickableTextView;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class MultiLanguageFactory implements LayoutInflater.Factory2 {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f196361e;

    /* renamed from: d, reason: collision with root package name */
    private Activity f196362d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70456);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f196361e = new int[]{R.attr.text, R.attr.hint, R.attr.contextDescription, com.tencent.mobileqq.R.attr.f155777ih, com.tencent.mobileqq.R.attr.f156132pl, com.tencent.mobileqq.R.attr.f156291sa, com.tencent.mobileqq.R.attr.f156293sb};
        }
    }

    public MultiLanguageFactory(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            this.f196362d = activity;
        }
    }

    private View a(String str, Context context, AttributeSet attributeSet) {
        if (str.equals("TextView")) {
            return new TextView(context, attributeSet);
        }
        if (str.equals(ComponentFactory.ComponentType.BUTTON)) {
            return new Button(context, attributeSet);
        }
        if (str.equals("com.tencent.mobileqq.activity.recent.cur.DragTextView")) {
            return new DragTextView(context, attributeSet);
        }
        if (str.equals("com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView")) {
            return new com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView(context, attributeSet);
        }
        if (str.equals("com.tencent.mobileqq.widget.FormSwitchItem")) {
            return new FormSwitchItem(context, attributeSet);
        }
        if (str.equals("com.tencent.mobileqq.widget.FormSimpleItem")) {
            return new FormSimpleItem(context, attributeSet);
        }
        if (str.equals("com.tencent.mobileqq.widget.FormSwitchSimpleItem")) {
            return new FormSwitchSimpleItem(context, attributeSet);
        }
        if (str.equals("com.tencent.mobileqq.widget.FormMultiLineSwitchItem")) {
            return new FormMultiLineSwitchItem(context, attributeSet);
        }
        if (str.equals("com.tencent.widget.AlphaClickableTextView")) {
            return new AlphaClickableTextView(context, attributeSet);
        }
        if (str.equals("com.tencent.widget.AlphaClickableButton")) {
            return new AlphaClickableButton(context, attributeSet);
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return null;
        }
        return (View) iPatchRedirector.redirect((short) 3, this, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (View) iPatchRedirector.redirect((short) 1, this, view, str, context, attributeSet);
        }
        View a16 = a(str, context, attributeSet);
        if (a16 != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f196361e);
            int i3 = 0;
            while (true) {
                int[] iArr = f196361e;
                if (i3 >= iArr.length) {
                    break;
                }
                int resourceId = obtainStyledAttributes.getResourceId(i3, 0);
                if (resourceId != 0) {
                    String string = context.getString(resourceId);
                    int i16 = iArr[i3];
                    if (i16 == 16843087) {
                        if (a16 instanceof TextView) {
                            ((TextView) a16).setText(string);
                        } else if (a16 instanceof Button) {
                            ((Button) a16).setText(string);
                        } else if (a16 instanceof FormSwitchItem) {
                            ((FormSwitchItem) a16).setText(string);
                        }
                    } else if (i16 == 16843088) {
                        if (a16 instanceof TextView) {
                            ((TextView) a16).setHint(string);
                        } else if (a16 instanceof Button) {
                            ((Button) a16).setHint(string);
                        }
                    } else if (i16 == 16844078) {
                        if (a16 instanceof TextView) {
                            ((TextView) a16).setContentDescription(string);
                        } else if (a16 instanceof Button) {
                            ((Button) a16).setContentDescription(string);
                        }
                    } else if (i16 == com.tencent.mobileqq.R.attr.f155777ih) {
                        if (a16 instanceof FormSimpleItem) {
                            ((FormSimpleItem) a16).setLeftText(string);
                        }
                    } else if (i16 == com.tencent.mobileqq.R.attr.f156132pl) {
                        if (a16 instanceof FormSimpleItem) {
                            ((FormSimpleItem) a16).setRightText(string);
                        }
                    } else if (i16 == com.tencent.mobileqq.R.attr.f156293sb) {
                        if (a16 instanceof FormSwitchItem) {
                            ((FormSwitchItem) a16).setText(string);
                        }
                    } else if (i16 == com.tencent.mobileqq.R.attr.f156291sa && (a16 instanceof FormMultiLineSwitchItem)) {
                        ((FormMultiLineSwitchItem) a16).setSecendLineText(string);
                    }
                }
                i3++;
            }
            obtainStyledAttributes.recycle();
        }
        return a16;
    }
}
