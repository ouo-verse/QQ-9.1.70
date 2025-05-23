package com.tencent.mobileqq.resourcesgrab.strategy;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.BaseConstantState;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable, List<com.tencent.mobileqq.resourcesgrab.c> list, int i3) {
        if (drawable != null && drawable.getConstantState() != null && list != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof BaseConstantState) {
                list.add(new com.tencent.mobileqq.resourcesgrab.c(i3, ((BaseConstantState) constantState).skinData));
                if (QLog.isColorLevel()) {
                    QLog.d("SpecialResourceNameGrab", 2, "getFileNameByConstantState BaseConstantState resourceNames -> " + list);
                    return;
                }
                return;
            }
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                if (QLog.isColorLevel()) {
                    QLog.d("SpecialResourceNameGrab", 2, "getFileNameByConstantState DrawableContainerState");
                }
                for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (drawable2 != null) {
                        a(drawable2, list, i3);
                    }
                }
            }
        }
    }

    public abstract List<com.tencent.mobileqq.resourcesgrab.c> b(View view);
}
