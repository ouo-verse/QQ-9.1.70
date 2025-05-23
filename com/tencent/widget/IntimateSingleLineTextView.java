package com.tencent.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.SingleLineTextView;

/* compiled from: P */
/* loaded from: classes27.dex */
public class IntimateSingleLineTextView extends SingleLineTextView {
    static IPatchRedirector $redirector_;

    public IntimateSingleLineTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.widget.SingleLineTextView
    protected Drawable getIconDrawableWithStatus(Context context, SingleLineTextView.IconDrawableInfo iconDrawableInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) iconDrawableInfo);
        }
        com.tencent.mobileqq.mutualmark.e eVar = null;
        if (context == null || iconDrawableInfo == null) {
            return null;
        }
        if (!TextUtils.isEmpty(iconDrawableInfo.iconUrl) && iconDrawableInfo.markVersion == 1) {
            eVar = new com.tencent.mobileqq.mutualmark.e(context, iconDrawableInfo.iconUrl, this);
        } else if (!TextUtils.isEmpty(iconDrawableInfo.iconDynamicUrl) && iconDrawableInfo.markVersion == 0) {
            eVar = new com.tencent.mobileqq.mutualmark.e(context, iconDrawableInfo.iconDynamicUrl, this);
        } else if (!TextUtils.isEmpty(iconDrawableInfo.icon_static_url) && iconDrawableInfo.markVersion == 0) {
            eVar = new com.tencent.mobileqq.mutualmark.e(context, iconDrawableInfo.icon_static_url, this);
        } else if (iconDrawableInfo.iconResId != 0 && iconDrawableInfo.markVersion == 0) {
            eVar = new com.tencent.mobileqq.mutualmark.e(context, iconDrawableInfo.iconResId);
        }
        if (eVar != null) {
            Drawable mutate = eVar.mutate();
            mutate.setAlpha((int) (iconDrawableInfo.icon_status_alpha * 255.0f));
            mutate.setBounds(0, 0, mutate.getIntrinsicWidth(), mutate.getIntrinsicHeight());
            return mutate;
        }
        return eVar;
    }

    @Override // com.tencent.widget.SingleLineTextView
    protected boolean isSameDrawable(Drawable drawable, SingleLineTextView.IconDrawable iconDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable, (Object) iconDrawable)).booleanValue();
        }
        Drawable drawable2 = iconDrawable.mDrawable;
        if (drawable != drawable2 && (!(drawable2 instanceof com.tencent.mobileqq.mutualmark.e) || ((com.tencent.mobileqq.mutualmark.e) drawable2).d() != drawable)) {
            return false;
        }
        return true;
    }

    public IntimateSingleLineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public IntimateSingleLineTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
