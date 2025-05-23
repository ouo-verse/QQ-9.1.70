package com.tencent.relation.common.api.impl;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.relation.common.api.IRelationFloatWindow;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationFloatWindowImpl implements IRelationFloatWindow {
    static IPatchRedirector $redirector_;

    public RelationFloatWindowImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.relation.common.api.IRelationFloatWindow
    public boolean checkFloatWindowShowing(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        return com.tencent.relation.common.window.b.d().b(str);
    }

    @Override // com.tencent.relation.common.api.IRelationFloatWindow
    public void hideRelationFloatWindow(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            com.tencent.relation.common.window.b.d().e(str);
        }
    }

    @Override // com.tencent.relation.common.api.IRelationFloatWindow
    public boolean showRelationFloatWindow(View view, String str, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, str, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        return com.tencent.relation.common.window.b.d().f(view, str, new FloatingScreenParams.FloatingBuilder().setShapeType(4).setCustomSize(ViewUtils.dip2px(f16), ViewUtils.dip2px(f17)).setCanMove(true).setCanZoom(false).setWindowFlags(131072).build());
    }
}
