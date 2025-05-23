package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopNickEdit;
import com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopNickEditImpl implements ITroopNickEdit {
    static IPatchRedirector $redirector_;

    public TroopNickEditImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNickEdit
    public void onDetachedFromWindow(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
        } else if (drawable instanceof TroopNickResDrawable) {
            TroopNickResDrawable troopNickResDrawable = (TroopNickResDrawable) drawable;
            troopNickResDrawable.g(null);
            troopNickResDrawable.recycle();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNickEdit
    public void setCustomCloth(TextView textView, Context context, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, textView, context, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            com.tencent.mobileqq.vas.troopnick.a.b(textView, context, i3, z16);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNickEdit
    public void updateDrawablePadding(Drawable drawable, PointF pointF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable, (Object) pointF);
            return;
        }
        if (drawable instanceof TroopNickResDrawable) {
            TroopNickResDrawable troopNickResDrawable = (TroopNickResDrawable) drawable;
            if (pointF.x == 0.0f && pointF.y == 0.0f) {
                pointF.x = 1.0f;
            }
            troopNickResDrawable.f(pointF);
        }
    }
}
