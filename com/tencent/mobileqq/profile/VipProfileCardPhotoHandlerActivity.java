package com.tencent.mobileqq.profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import java.util.List;

/* loaded from: classes16.dex */
public class VipProfileCardPhotoHandlerActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name */
    public static boolean f260082e0;

    /* renamed from: a0, reason: collision with root package name */
    private Uri f260083a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f260084b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f260085c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f260086d0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        class DialogInterfaceOnDismissListenerC8243a implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnDismissListenerC8243a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                    return;
                }
                VipProfileCardPhotoHandlerActivity.this.finish();
                VipProfileCardPhotoHandlerActivity.this.f260086d0 = false;
                VasCommonReporter.getDiyCard().setValue1("no Permission take photo, uri:  " + VipProfileCardPhotoHandlerActivity.this.f260083a0).report();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VipProfileCardPhotoHandlerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                VipProfileCardPhotoHandlerActivity vipProfileCardPhotoHandlerActivity = VipProfileCardPhotoHandlerActivity.this;
                vipProfileCardPhotoHandlerActivity.f260083a0 = ProfileCardUtils.enterSnapshot(vipProfileCardPhotoHandlerActivity, 5);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissionRequestDialog, (Object) list);
            } else {
                if (!VasToggle.isEnable(VasToggle.PER_DIALOG_HANDLE, true)) {
                    return;
                }
                super.onDialogShow(permissionRequestDialog, list);
                VipProfileCardPhotoHandlerActivity.this.f260086d0 = true;
                permissionRequestDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC8243a());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73810);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f260082e0 = false;
        }
    }

    public VipProfileCardPhotoHandlerActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f260084b0 = false;
        this.f260085c0 = false;
        this.f260086d0 = false;
    }

    private void K2() {
        Intent intent = new Intent();
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        intent.putExtra("Business_Origin", 101);
        intent.putExtra(PeakConstants.COMPRESS_QUALITY, 80);
        PhotoUtils.startPhotoListEdit(intent, this, VipProfileCardPhotoHandlerActivity.class.getName(), ProfileCardUtil.d(this), ProfileCardUtil.c(this), ProfileCardUtil.d(this), ProfileCardUtil.c(this), ProfileCardUtil.C());
    }

    private void L2() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.CARD_CAMERA));
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a());
        } else {
            this.f260083a0 = ProfileCardUtils.enterSnapshot(this, 5);
        }
    }

    protected void I2(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) uri);
            return;
        }
        String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(this, uri);
        Intent intent = new Intent();
        intent.putExtra("Business_Origin", 101);
        intent.putExtra(PeakConstants.COMPRESS_QUALITY, 80);
        PhotoUtils.startPhotoEdit(intent, this, VipProfileCardPhotoHandlerActivity.class.getName(), ProfileCardUtil.d(this), ProfileCardUtil.c(this), ProfileCardUtil.d(this), ProfileCardUtil.c(this), realPathFromContentURI, ProfileCardUtil.C());
    }

    protected void J2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(this, (Class<?>) VipProfileCardPreviewActivity.class);
            intent.putExtra("custom_card_background", str);
            startActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 5 && i16 == -1) {
            this.f260085c0 = true;
            I2(this.f260083a0);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("action"))) {
            if (intent.getStringExtra("action").equals("select_photo")) {
                K2();
                return true;
            }
            if (intent.getStringExtra("action").equals("take_photo")) {
                L2();
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        J2(intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"));
        finish();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnPause();
            this.f260084b0 = true;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        if ((!this.f260086d0 || !VasToggle.isEnable(VasToggle.PER_DIALOG_HANDLE, true)) && this.f260084b0) {
            if (!this.f260085c0) {
                finish();
            } else {
                this.f260085c0 = false;
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnStop();
            this.f260084b0 = true;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
