package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.view.View;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* loaded from: classes17.dex */
public class NotificationPermissionHandler extends BasePermissionHandler {
    static IPatchRedirector $redirector_;

    /* loaded from: classes17.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQPermission.BasePermissionsListener f274325d;

        a(QQPermission.BasePermissionsListener basePermissionsListener) {
            this.f274325d = basePermissionsListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotificationPermissionHandler.this, (Object) basePermissionsListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (NotificationPermissionHandler.this.areNotificationsEnabled()) {
                this.f274325d.onAllGranted();
            } else {
                PermissionUtil.gotoSettingPage(NotificationPermissionHandler.this.mContext);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public NotificationPermissionHandler(QQPermission qQPermission) {
        super(qQPermission);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQPermission);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean areNotificationsEnabled() {
        return QQNotificationManager.getInstance().areNotificationsEnabled(this.mContext);
    }

    @Override // com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler
    public boolean canHandle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        return QQPermissionConstants.Permission.PERMISSION_NOTIFICATION.equals(str);
    }

    @Override // com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler
    public int checkPermission(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? areNotificationsEnabled() ? 0 : -1 : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
    }

    @Override // com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler
    public void requestPermissions(List<String> list, int i3, QQPermission.BasePermissionsListener basePermissionsListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, Integer.valueOf(i3), basePermissionsListener);
            return;
        }
        if (areNotificationsEnabled()) {
            basePermissionsListener.onAllGranted();
            return;
        }
        if (i3 == 2) {
            PermissionRequestDialog buildRequestDialog = buildRequestDialog(this.mContext.getString(R.string.f202724y_), this.mContext.getString(R.string.f202714y9));
            basePermissionsListener.onDialogShow(buildRequestDialog, list);
            buildRequestDialog.show();
        } else if (i3 == 1) {
            PermissionRequestView permissionRequestView = new PermissionRequestView(this.mContext);
            permissionRequestView.setTitle(R.string.f202724y_);
            permissionRequestView.setContent(R.string.f202714y9);
            permissionRequestView.setOnSettingClickListener(new a(basePermissionsListener));
            basePermissionsListener.onViewShow(permissionRequestView, list);
        }
    }

    @Override // com.tencent.mobileqq.qqpermission.permissionhandler.BasePermissionHandler
    public int checkPermission(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? checkPermission(str2) : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2)).intValue();
    }
}
