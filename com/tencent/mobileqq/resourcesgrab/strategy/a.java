package com.tencent.mobileqq.resourcesgrab.strategy;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.theme.SkinnableColorStateList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends c {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.resourcesgrab.strategy.c
    public List<com.tencent.mobileqq.resourcesgrab.c> b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof ImageView) {
            a(((ImageView) view).getDrawable(), arrayList, 1);
        } else if (view instanceof TextView) {
            TextView textView = (TextView) view;
            for (Drawable drawable : textView.getCompoundDrawables()) {
                a(drawable, arrayList, 2);
            }
            ColorStateList textColors = textView.getTextColors();
            if (textColors instanceof SkinnableColorStateList) {
                SkinnableColorStateList skinnableColorStateList = (SkinnableColorStateList) textColors;
                com.tencent.mobileqq.resourcesgrab.c cVar = new com.tencent.mobileqq.resourcesgrab.c(3, skinnableColorStateList.skinData);
                cVar.f281278c = skinnableColorStateList.getStateSpecs();
                cVar.f281279d = skinnableColorStateList.getColors();
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }
}
