package com.tencent.mobileqq.resourcesgrab.strategy;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends c {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Drawable c(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            try {
                Field declaredField = view.getClass().getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(view);
                if (obj instanceof Drawable) {
                    return (Drawable) obj;
                }
                return null;
            } catch (Exception e16) {
                QLog.d("GrabMainTabResourceName", 1, e16, new Object[0]);
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.resourcesgrab.strategy.c
    public List<com.tencent.mobileqq.resourcesgrab.c> b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof TabDragAnimationView) {
            a(c(view, "mBgDrawable"), arrayList, 0);
            a(c(view, "mBgPressedDrawable"), arrayList, 0);
            a(c(view, "mEmotionDrawable"), arrayList, 0);
            a(c(view, "mEmotionPressedDrawable"), arrayList, 0);
            a(c(view, "mClickAnimationDrawable"), arrayList, 0);
        }
        return arrayList;
    }
}
