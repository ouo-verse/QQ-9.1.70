package com.tencent.mobileqq.profilecard.bussiness.thirdapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.widgets.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;

/* loaded from: classes16.dex */
public class ProfileThirdAppComponent extends AbsQQProfileComponent<View> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileThirdAppComponent";
    private SDKAvatarSettingManager sdkAvatarSettingManager;
    private e shareResultDlg;

    public ProfileThirdAppComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.shareResultDlg = null;
        }
    }

    private void initAvatarManager(Intent intent) {
        Bundle bundleExtra;
        if (intent != null && (bundleExtra = intent.getBundleExtra(IProfileCardConst.KEY_PROFILE_EXTRA)) != null && bundleExtra.getBoolean("key_from_sdk_set_avatar", false)) {
            SDKAvatarSettingManager sDKAvatarSettingManager = new SDKAvatarSettingManager(this.mActivity);
            this.sdkAvatarSettingManager = sDKAvatarSettingManager;
            sDKAvatarSettingManager.o(intent);
            this.sdkAvatarSettingManager.x();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1031;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        SDKAvatarSettingManager sDKAvatarSettingManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1035 && (sDKAvatarSettingManager = this.sdkAvatarSettingManager) != null) {
            sDKAvatarSettingManager.p(i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public boolean onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        SDKAvatarSettingManager sDKAvatarSettingManager = this.sdkAvatarSettingManager;
        if (sDKAvatarSettingManager != null) {
            sDKAvatarSettingManager.m();
        }
        return super.onBackPressed();
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) bundle);
        } else {
            super.onCreate(qBaseActivity, bundle);
            initAvatarManager(qBaseActivity.getIntent());
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        SDKAvatarSettingManager sDKAvatarSettingManager = this.sdkAvatarSettingManager;
        if (sDKAvatarSettingManager != null) {
            sDKAvatarSettingManager.q();
        }
        e eVar = this.shareResultDlg;
        if (eVar != null) {
            eVar.dismiss();
            this.shareResultDlg = null;
        }
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        if (intent != null) {
            try {
                AllInOne allInOne = (AllInOne) intent.getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
                if (allInOne != null && allInOne.profileEntryType == 115) {
                    ((ProfileCardInfo) this.mData).allInOne = allInOne;
                    IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
                    if (iProfileActivityDelegate != null) {
                        iProfileActivityDelegate.requestUpdateCard();
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16.getMessage(), e16);
            }
        }
        SDKAvatarSettingManager sDKAvatarSettingManager = this.sdkAvatarSettingManager;
        if (sDKAvatarSettingManager == null) {
            initAvatarManager(intent);
        } else {
            sDKAvatarSettingManager.r(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        if (((ProfileCardInfo) this.mData).allInOne.profileEntryType == 115 && AddFriendLogicActivity.f174690v0) {
            qbShowShareResultDialog(this.mActivity.getIntent().getStringExtra("src_name"));
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onStop();
        e eVar = this.shareResultDlg;
        if (eVar != null && eVar.isShowing()) {
            this.shareResultDlg.dismiss();
            this.shareResultDlg = null;
        }
    }

    void qbShowShareResultDialog(String str) {
        e eVar = this.shareResultDlg;
        if (eVar != null && !eVar.isShowing()) {
            this.shareResultDlg.show();
            return;
        }
        e eVar2 = new e(this.mActivity);
        this.shareResultDlg = eVar2;
        eVar2.Q(this.mActivity.getString(R.string.f9v));
        String string = this.mActivity.getString(R.string.hih);
        if (str != null) {
            string = string + str;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.thirdapp.ProfileThirdAppComponent.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileThirdAppComponent.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                if (i3 != 0) {
                    if (i3 == 1 && QLog.isColorLevel()) {
                        QLog.i(ProfileThirdAppComponent.TAG, 2, "qbShowShareResultDialog stay");
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i(ProfileThirdAppComponent.TAG, 2, "qbShowShareResultDialog back");
                    }
                    Intent intent = ((AbsComponent) ProfileThirdAppComponent.this).mActivity.getIntent();
                    if (intent.getIntExtra("source_id", BuddySource.DEFAULT) == 3090) {
                        try {
                            ForwardSdkBaseOption.E(((AbsComponent) ProfileThirdAppComponent.this).mActivity, true, "action_game_make_friend", Long.parseLong(intent.getStringExtra("extra")), -1, HardCodeUtil.qqStr(R.string.mt7));
                        } catch (Exception e16) {
                            QLog.e(ProfileThirdAppComponent.TAG, 1, "feedBackToGameSDK error = " + e16);
                        }
                    }
                    ((AbsComponent) ProfileThirdAppComponent.this).mActivity.moveTaskToBack(true);
                }
                ProfileThirdAppComponent.this.shareResultDlg.dismiss();
                AddFriendLogicActivity.f174690v0 = false;
            }
        };
        this.shareResultDlg.O(string, onClickListener);
        this.shareResultDlg.P(onClickListener);
        this.shareResultDlg.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((ProfileThirdAppComponent) profileCardInfo);
        e eVar = this.shareResultDlg;
        if (eVar != null && eVar.isShowing()) {
            DATA data = this.mData;
            if (((ProfileCardInfo) data).card != null) {
                if (!TextUtils.isEmpty(((ProfileCardInfo) data).card.strReMark)) {
                    this.shareResultDlg.Q(((ProfileCardInfo) this.mData).card.strReMark + this.mActivity.getString(R.string.f9v));
                } else if (!TextUtils.isEmpty(((ProfileCardInfo) this.mData).card.strNick)) {
                    this.shareResultDlg.Q(((ProfileCardInfo) this.mData).card.strNick + this.mActivity.getString(R.string.f9v));
                }
            }
        }
        return lambda$checkValidComponent$3;
    }
}
