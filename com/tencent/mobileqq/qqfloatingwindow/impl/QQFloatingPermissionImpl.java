package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.c;

/* loaded from: classes16.dex */
public class QQFloatingPermissionImpl implements IQQFloatingPermission {
    static IPatchRedirector $redirector_;

    public QQFloatingPermissionImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission
    public boolean checkPermission(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        return FloatingScreenPermission.checkPermission(context);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission
    public void enterPermissionRequestDialog(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else {
            FloatingScreenPermission.enterPermissionRequestDialog(context);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission
    public void enterPermissionRequestDialogCustom(Context context, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            FloatingScreenPermission.enterPermissionRequestDialogCustom(context, i3, i16);
        } else {
            iPatchRedirector.redirect((short) 5, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission
    public void enterPermissionRequestDialogCustomWithDecorator(Context context, int i3, int i16, int i17, int i18, DialogInterface.OnClickListener onClickListener, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), onClickListener, cVar);
        } else {
            FloatingScreenPermission.enterPermissionRequestDialogCustom(context, i3, i16, i17, i18, onClickListener, null, null, cVar);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission
    public boolean requestPermission(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        return FloatingScreenPermission.requestPermission(context);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission
    public void enterPermissionRequestDialogCustom(Context context, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            FloatingScreenPermission.enterPermissionRequestDialogCustom(context, i3, i16, i17, i18);
        } else {
            iPatchRedirector.redirect((short) 6, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission
    public void enterPermissionRequestDialogCustom(Context context, int i3, int i16, int i17, int i18, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            FloatingScreenPermission.enterPermissionRequestDialogCustom(context, i3, i16, i17, i18, onClickListener, null, null, null);
        } else {
            iPatchRedirector.redirect((short) 7, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), onClickListener);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission
    public void enterPermissionRequestDialogCustom(Context context, int i3, int i16, int i17, int i18, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            FloatingScreenPermission.enterPermissionRequestDialogCustom(context, i3, i16, i17, i18, onClickListener, onClickListener2, onDismissListener, null);
        } else {
            iPatchRedirector.redirect((short) 8, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), onClickListener, onClickListener2, onDismissListener);
        }
    }
}
