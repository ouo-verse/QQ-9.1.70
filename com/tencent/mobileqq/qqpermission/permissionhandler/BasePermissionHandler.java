package com.tencent.mobileqq.qqpermission.permissionhandler;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.business.QQPermissionBusinessManager;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* loaded from: classes17.dex */
public abstract class BasePermissionHandler {
    static IPatchRedirector $redirector_;
    protected Activity mActivity;
    protected Context mContext;
    protected Fragment mFragment;
    protected QQPermission mQQPermission;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BasePermissionHandler.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                PermissionUtil.gotoSettingPage(BasePermissionHandler.this.mContext);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public BasePermissionHandler(QQPermission qQPermission) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQPermission);
            return;
        }
        this.mQQPermission = qQPermission;
        this.mActivity = qQPermission.getActivity();
        this.mFragment = qQPermission.getFragment();
        this.mContext = qQPermission.getContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PermissionRequestDialog buildRequestDialog(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? buildRequestDialog(str, str2, new a()) : (PermissionRequestDialog) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
    }

    public abstract boolean canHandle(String str);

    public abstract int checkPermission(String str);

    public abstract int checkPermission(String str, String str2);

    public abstract void requestPermissions(List<String> list, int i3, QQPermission.BasePermissionsListener basePermissionsListener);

    protected PermissionRequestDialog buildRequestDialog(String str, String str2, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PermissionRequestDialog) iPatchRedirector.redirect((short) 3, this, str, str2, onClickListener);
        }
        PermissionRequestDialog permissionRequestDialog = new PermissionRequestDialog(this.mContext, R.style.f173539a44);
        permissionRequestDialog.setCanceledOnTouchOutside(false);
        permissionRequestDialog.setCancelable(true);
        permissionRequestDialog.setRequestTitle(QQPermissionBusinessManager.getBusinessName(this.mContext, this.mQQPermission.getBusinessConfig().getBusinessId()) + str);
        permissionRequestDialog.setRequestContent(str2);
        permissionRequestDialog.setOnSettingClickListener(onClickListener);
        return permissionRequestDialog;
    }
}
