package com.tencent.mobileqq.profilecard.utils;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.ProfileEditDateUtils;
import com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment;
import com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit;
import com.tencent.mobileqq.profilecard.widget.CoverDialog;
import com.tencent.mobileqq.profilecard.widget.ProfileLocationActionSheet;
import com.tencent.mobileqq.profilecard.widget.selector.AgeSelectorView;
import com.tencent.mobileqq.profilecard.widget.selector.BirthDaySelectorView;
import com.tencent.mobileqq.profilecard.widget.selector.SexSelectorView;
import com.tencent.mobileqq.profilesetting.ReqSetSettingItem;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.Objects;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileEditSelectorHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String AGE_TITLE = "\u9009\u62e9\u5e74\u9f84";
    private static final String BIRTHDAY_TITLE = "\u9009\u62e9\u751f\u65e5";
    private static final long DISMISS_COVER_DIALOG_DURATION = 200;
    private static final String GENDER_TITLE = "\u9009\u62e9\u6027\u522b";
    private static final String TAG = "ProfileEditSelectorHelper";

    /* loaded from: classes16.dex */
    private static class Holder {
        static IPatchRedirector $redirector_;
        private static final ProfileEditSelectorHelper sInstance;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36616);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                sInstance = new ProfileEditSelectorHelper();
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    ProfileEditSelectorHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissCoverDialog(final CoverDialog coverDialog) {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.utils.i
            @Override // java.lang.Runnable
            public final void run() {
                ProfileEditSelectorHelper.lambda$dismissCoverDialog$4(CoverDialog.this);
            }
        }, DISMISS_COVER_DIALOG_DURATION);
    }

    public static ProfileEditSelectorHelper getInstance() {
        return Holder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dismissCoverDialog$4(CoverDialog coverDialog) {
        if (coverDialog != null) {
            coverDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openProfileAgeSelector$1(IProfileEditApi.BirthdayEditListener birthdayEditListener, int i3, int i16) {
        birthdayEditListener.onPrivacyUpdate(i16);
        setPrivacy(41610, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openProfileBirthdaySelector$2(IProfileEditApi.BirthdayEditListener birthdayEditListener, int i3, int i16) {
        birthdayEditListener.onPrivacyUpdate(i16);
        setPrivacy(41607, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openProfileGenderSelector$0(IProfileEditApi.GenderEditListener genderEditListener, int i3, int i16) {
        genderEditListener.onPrivacyUpdate(i16);
        setPrivacy(41611, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openProfileLocationSelector$3(IProfileEditApi.LocationEditListener locationEditListener, int i3, int i16) {
        locationEditListener.onPrivacyUpdate(i16);
        setPrivacy(41614, i3, i16);
    }

    public void openProfileAgeSelector(Context context, int i3, final int i16, final IProfileEditApi.BirthdayEditListener birthdayEditListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(i3), Integer.valueOf(i16), birthdayEditListener);
            return;
        }
        AgeSelectorView ageSelectorView = new AgeSelectorView(context);
        ageSelectorView.setTitle(AGE_TITLE);
        int[] parseBirthdayCode = ProfileEditDateUtils.parseBirthdayCode(i3);
        ageSelectorView.init(parseBirthdayCode[0], parseBirthdayCode[1], parseBirthdayCode[2]);
        ageSelectorView.setPrivacy(i16);
        CoverDialog coverDialog = new CoverDialog(context);
        if (ageSelectorView.getOnActionSheetListener() == null) {
            ageSelectorView.setOnActionSheetListener(new ActionSheetProfileEdit.OnActionSheetListener(coverDialog, ageSelectorView, birthdayEditListener) { // from class: com.tencent.mobileqq.profilecard.utils.ProfileEditSelectorHelper.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ AgeSelectorView val$ageSelectorView;
                final /* synthetic */ CoverDialog val$dialog;
                final /* synthetic */ IProfileEditApi.BirthdayEditListener val$listener;

                {
                    this.val$dialog = coverDialog;
                    this.val$ageSelectorView = ageSelectorView;
                    this.val$listener = birthdayEditListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileEditSelectorHelper.this, coverDialog, ageSelectorView, birthdayEditListener);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onConfirm() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                        return;
                    }
                    if (!this.val$ageSelectorView.isHide()) {
                        int birthdayCode = this.val$ageSelectorView.getBirthdayCode();
                        int[] parseBirthdayCode2 = ProfileEditDateUtils.parseBirthdayCode(birthdayCode);
                        this.val$listener.onConfirm(birthdayCode, ProfileEditDateUtils.getAge(parseBirthdayCode2[0], parseBirthdayCode2[1], parseBirthdayCode2[2]), Utils.r(parseBirthdayCode2[1], parseBirthdayCode2[2]));
                    }
                    ProfileEditSelectorHelper.this.dismissCoverDialog(this.val$dialog);
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onDismiss() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ProfileEditSelectorHelper.this.dismissCoverDialog(this.val$dialog);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        if (ageSelectorView.getOnPrivacyListener() == null) {
            ageSelectorView.setOnPrivacyListener(new ActionSheetProfileEdit.OnPrivacyListener() { // from class: com.tencent.mobileqq.profilecard.utils.h
                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyListener
                public final void onConfirm(int i17) {
                    ProfileEditSelectorHelper.this.lambda$openProfileAgeSelector$1(birthdayEditListener, i16, i17);
                }
            });
        }
        coverDialog.show();
        ageSelectorView.show();
    }

    public void openProfileBirthdaySelector(Context context, int i3, final int i16, final IProfileEditApi.BirthdayEditListener birthdayEditListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(i3), Integer.valueOf(i16), birthdayEditListener);
            return;
        }
        BirthDaySelectorView birthDaySelectorView = new BirthDaySelectorView(context);
        birthDaySelectorView.setTitle(BIRTHDAY_TITLE);
        int[] parseBirthdayCode = ProfileEditDateUtils.parseBirthdayCode(i3);
        birthDaySelectorView.init(parseBirthdayCode[0], parseBirthdayCode[1], parseBirthdayCode[2]);
        birthDaySelectorView.setPrivacy(i16);
        CoverDialog coverDialog = new CoverDialog(context);
        if (birthDaySelectorView.getOnActionSheetListener() == null) {
            birthDaySelectorView.setOnActionSheetListener(new ActionSheetProfileEdit.OnActionSheetListener(coverDialog, birthDaySelectorView, birthdayEditListener) { // from class: com.tencent.mobileqq.profilecard.utils.ProfileEditSelectorHelper.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ BirthDaySelectorView val$birthDaySelectorView;
                final /* synthetic */ CoverDialog val$dialog;
                final /* synthetic */ IProfileEditApi.BirthdayEditListener val$listener;

                {
                    this.val$dialog = coverDialog;
                    this.val$birthDaySelectorView = birthDaySelectorView;
                    this.val$listener = birthdayEditListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileEditSelectorHelper.this, coverDialog, birthDaySelectorView, birthdayEditListener);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onConfirm() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                        return;
                    }
                    if (!this.val$birthDaySelectorView.isHide()) {
                        int birthdayCode = this.val$birthDaySelectorView.getBirthdayCode();
                        int[] parseBirthdayCode2 = ProfileEditDateUtils.parseBirthdayCode(birthdayCode);
                        this.val$listener.onConfirm(birthdayCode, ProfileEditDateUtils.getAge(parseBirthdayCode2[0], parseBirthdayCode2[1], parseBirthdayCode2[2]), Utils.r(parseBirthdayCode2[1], parseBirthdayCode2[2]));
                    }
                    ProfileEditSelectorHelper.this.dismissCoverDialog(this.val$dialog);
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onDismiss() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ProfileEditSelectorHelper.this.dismissCoverDialog(this.val$dialog);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        if (birthDaySelectorView.getOnPrivacyListener() == null) {
            birthDaySelectorView.setOnPrivacyListener(new ActionSheetProfileEdit.OnPrivacyListener() { // from class: com.tencent.mobileqq.profilecard.utils.g
                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyListener
                public final void onConfirm(int i17) {
                    ProfileEditSelectorHelper.this.lambda$openProfileBirthdaySelector$2(birthdayEditListener, i16, i17);
                }
            });
        }
        coverDialog.show();
        birthDaySelectorView.show();
    }

    public void openProfileGenderSelector(Context context, int i3, final int i16, final IProfileEditApi.GenderEditListener genderEditListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Integer.valueOf(i16), genderEditListener);
            return;
        }
        SexSelectorView sexSelectorView = new SexSelectorView(context);
        sexSelectorView.setTitle(GENDER_TITLE);
        sexSelectorView.init(i3);
        sexSelectorView.setPrivacy(i16);
        CoverDialog coverDialog = new CoverDialog(context);
        if (sexSelectorView.getOnActionSheetListener() == null) {
            sexSelectorView.setOnActionSheetListener(new ActionSheetProfileEdit.OnActionSheetListener(coverDialog, sexSelectorView, genderEditListener) { // from class: com.tencent.mobileqq.profilecard.utils.ProfileEditSelectorHelper.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ CoverDialog val$dialog;
                final /* synthetic */ IProfileEditApi.GenderEditListener val$listener;
                final /* synthetic */ SexSelectorView val$sexSelectorView;

                {
                    this.val$dialog = coverDialog;
                    this.val$sexSelectorView = sexSelectorView;
                    this.val$listener = genderEditListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileEditSelectorHelper.this, coverDialog, sexSelectorView, genderEditListener);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onConfirm() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                        return;
                    }
                    if (!this.val$sexSelectorView.isHide()) {
                        this.val$listener.onConfirm(this.val$sexSelectorView.getSex());
                    }
                    ProfileEditSelectorHelper.this.dismissCoverDialog(this.val$dialog);
                }

                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnActionSheetListener
                public void onDismiss() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ProfileEditSelectorHelper.this.dismissCoverDialog(this.val$dialog);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        if (sexSelectorView.getOnPrivacyListener() == null) {
            sexSelectorView.setOnPrivacyListener(new ActionSheetProfileEdit.OnPrivacyListener() { // from class: com.tencent.mobileqq.profilecard.utils.d
                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyListener
                public final void onConfirm(int i17) {
                    ProfileEditSelectorHelper.this.lambda$openProfileGenderSelector$0(genderEditListener, i16, i17);
                }
            });
        }
        coverDialog.show();
        sexSelectorView.show();
    }

    public void openProfileLocationSelector(Context context, Card card, final int i3, final IProfileEditApi.LocationEditListener locationEditListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, card, Integer.valueOf(i3), locationEditListener);
            return;
        }
        Objects.requireNonNull(locationEditListener);
        ProfileEditFragment.OnLocationUpdateListener onLocationUpdateListener = new ProfileEditFragment.OnLocationUpdateListener() { // from class: com.tencent.mobileqq.profilecard.utils.e
            @Override // com.tencent.mobileqq.profilecard.fragment.ProfileEditFragment.OnLocationUpdateListener
            public final void onLocationStrUpdate(String str, String[] strArr) {
                IProfileEditApi.LocationEditListener.this.onUpdate(str, strArr);
            }
        };
        ProfileLocationActionSheet profileLocationActionSheet = new ProfileLocationActionSheet();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
            return;
        }
        profileLocationActionSheet.init(context, (BaseQQAppInterface) peekAppRuntime, card, onLocationUpdateListener);
        profileLocationActionSheet.disableSaveInfo();
        if (profileLocationActionSheet.getOnPrivacyListener() == null) {
            profileLocationActionSheet.setOnPrivacyListener(new ActionSheetProfileEdit.OnPrivacyListener() { // from class: com.tencent.mobileqq.profilecard.utils.f
                @Override // com.tencent.mobileqq.profilecard.widget.ActionSheetProfileEdit.OnPrivacyListener
                public final void onConfirm(int i16) {
                    ProfileEditSelectorHelper.this.lambda$openProfileLocationSelector$3(locationEditListener, i3, i16);
                }
            });
        }
        profileLocationActionSheet.setPrivacy(i3);
        profileLocationActionSheet.show();
    }

    public void setPrivacy(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        ArrayList<ReqSetSettingItem> arrayList = new ArrayList<>();
        arrayList.add(new ReqSetSettingItem(i3, i16, i17));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).requestSetCardDisplaySetting((AppInterface) peekAppRuntime, arrayList);
        }
    }
}
