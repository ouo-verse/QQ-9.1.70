package com.tencent.mobileqq.resourcesgrab.strategy;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableColorStateList;
import com.tencent.widget.SingleLineTextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends c {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(View view, List<com.tencent.mobileqq.resourcesgrab.c> list) {
        try {
            Field declaredField = view.getClass().getDeclaredField("mDrawables");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            Field declaredField2 = obj.getClass().getDeclaredField("mDrawableLeft");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 instanceof Drawable) {
                a((Drawable) obj2, list, 2);
            }
            Field declaredField3 = obj.getClass().getDeclaredField("mDrawableRight");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj);
            if (obj3 instanceof Drawable) {
                a((Drawable) obj3, list, 2);
            }
        } catch (Exception e16) {
            QLog.d("GrabMainTabResourceName", 1, e16, new Object[0]);
        }
    }

    private void d(View view, List<com.tencent.mobileqq.resourcesgrab.c> list) {
        try {
            Field declaredField = view.getClass().getDeclaredField("mIconDrawables");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            if (obj instanceof Object[]) {
                for (Object obj2 : (Object[]) obj) {
                    Field declaredField2 = obj2.getClass().getDeclaredField("mDrawable");
                    declaredField2.setAccessible(true);
                    Object obj3 = declaredField2.get(obj2);
                    if (obj3 instanceof Drawable) {
                        a((Drawable) obj3, list, 2);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.d("GrabMainTabResourceName", 1, e16, new Object[0]);
        }
    }

    private void e(View view, List<com.tencent.mobileqq.resourcesgrab.c> list) {
        try {
            Field declaredField = view.getClass().getDeclaredField("mTextColor");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            if (obj instanceof SkinnableColorStateList) {
                SkinnableColorStateList skinnableColorStateList = (SkinnableColorStateList) obj;
                com.tencent.mobileqq.resourcesgrab.c cVar = new com.tencent.mobileqq.resourcesgrab.c(3, ((SkinnableColorStateList) obj).skinData);
                cVar.f281278c = skinnableColorStateList.getStateSpecs();
                cVar.f281279d = skinnableColorStateList.getColors();
                list.add(cVar);
            }
        } catch (Exception e16) {
            QLog.d("GrabMainTabResourceName", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.resourcesgrab.strategy.c
    public List<com.tencent.mobileqq.resourcesgrab.c> b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof SingleLineTextView) {
            e(view, arrayList);
            c(view, arrayList);
            d(view, arrayList);
        }
        return arrayList;
    }
}
