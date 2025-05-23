package com.tencent.mobileqq.profilecard.bussiness.miniapp;

import NS_MINI_APP_MISC.MISC$StAppPlayingInfo;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.instep.IBusinessZPlanHandleEventListener;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.widget.ElegantProfileContentTitleView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes16.dex */
public class ElegantProfileMiniAppComponent extends BaseProfileMiniAppComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ElegantProfileMiniApp";
    private boolean isInitDtReport;
    private final IBusinessZPlanHandleEventListener mBusinessZPlanHandleEventListener;
    private BaseMiniAppProfileCardView mProfileCardView;

    public ElegantProfileMiniAppComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.isInitDtReport = false;
            this.mBusinessZPlanHandleEventListener = new IBusinessZPlanHandleEventListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.miniapp.ElegantProfileMiniAppComponent.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ElegantProfileMiniAppComponent.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.bussiness.instep.IBusinessZPlanHandleEventListener
                public boolean handleZPlanEvent(MotionEvent motionEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
                    }
                    if (ElegantProfileMiniAppComponent.this.mProfileCardView != null && ElegantProfileMiniAppComponent.this.mProfileCardView.getListView() != null) {
                        return ElegantProfileMiniAppComponent.this.mProfileCardView.getListView().onTouchEvent(motionEvent);
                    }
                    return false;
                }
            };
        }
    }

    private void addBusinessHandleEvent() {
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null && iProfileActivityDelegate.getListView() != null) {
            this.mDelegate.getListView().addBusinessHandleEvent(this.mBusinessZPlanHandleEventListener);
        }
    }

    private void addProfileCardView(ElegantProfileContentTitleView elegantProfileContentTitleView, boolean z16, ProfileMiniAppInfo profileMiniAppInfo) {
        int i3;
        BaseMiniAppProfileCardView baseMiniAppProfileCardView;
        List<INTERFACE$StApiAppInfo> convertPlayingInfo;
        if (elegantProfileContentTitleView.getContentView() instanceof BaseMiniAppProfileCardView) {
            baseMiniAppProfileCardView = (BaseMiniAppProfileCardView) elegantProfileContentTitleView.getContentView();
        } else {
            BaseMiniAppProfileCardView createMiniAppProfileCardView = ((IMiniAppService) QRoute.api(IMiniAppService.class)).createMiniAppProfileCardView(this.mActivity);
            elegantProfileContentTitleView.addContentView(createMiniAppProfileCardView);
            if (z16) {
                i3 = 2062;
            } else {
                i3 = LaunchScene.LAUNCH_SCENE_PROFILE_GUEST_CARD;
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameProfile(null, i3, false);
            addBusinessHandleEvent();
            baseMiniAppProfileCardView = createMiniAppProfileCardView;
        }
        if (z16) {
            convertPlayingInfo = profileMiniAppInfo.miniAppInfoArrayList;
        } else {
            convertPlayingInfo = convertPlayingInfo(profileMiniAppInfo.appPlayingInfos);
        }
        baseMiniAppProfileCardView.setData(convertPlayingInfo);
        baseMiniAppProfileCardView.setProfileType(z16);
        this.mProfileCardView = baseMiniAppProfileCardView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean checkProfileInvalid(Card card) {
        DATA data;
        if (card != null && (data = this.mData) != 0) {
            ProfileMiniAppInfo profileMiniAppInfo = (ProfileMiniAppInfo) ((ProfileCardInfo) data).getBusinessInfo(ProfileMiniAppInfo.class);
            if (profileMiniAppInfo == null) {
                QLog.w(TAG, 1, "checkProfileInvalid profileMiniAppInfo is null");
                return true;
            }
            if (!profileMiniAppInfo.isShowMiniPlaying) {
                QLog.w(TAG, 1, "checkProfileInvalid isShowMiniPlaying false.");
            }
            if (card.uin.equals(this.mQQAppInterface.getCurrentAccountUin())) {
                ArrayList<INTERFACE$StApiAppInfo> arrayList = profileMiniAppInfo.miniAppInfoArrayList;
                QLog.w(TAG, 1, "checkProfileInvalid owner appList is empty");
                if (arrayList == null || arrayList.isEmpty()) {
                    return true;
                }
                return false;
            }
            List<MISC$StAppPlayingInfo> list = profileMiniAppInfo.appPlayingInfos;
            QLog.w(TAG, 1, "checkProfileInvalid guest appList is empty");
            if (list == null || list.isEmpty()) {
                return true;
            }
            return false;
        }
        QLog.w(TAG, 1, "checkProfileInvalid card or mData is null.");
        return true;
    }

    private List<INTERFACE$StApiAppInfo> convertPlayingInfo(List<MISC$StAppPlayingInfo> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<MISC$StAppPlayingInfo> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().appMetaInfo);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private Drawable getDrawable() {
        return ContextCompat.getDrawable(this.mActivity, R.drawable.qui_minigame);
    }

    private String getTitle() {
        return this.mActivity.getString(R.string.f175962zz);
    }

    private void makeOrRefreshGuestProfile(ElegantProfileContentTitleView elegantProfileContentTitleView, ProfileMiniAppInfo profileMiniAppInfo, String str) {
        boolean z16;
        addProfileCardView(elegantProfileContentTitleView, false, profileMiniAppInfo);
        if (profileMiniAppInfo.guestAppTotal > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        elegantProfileContentTitleView.setArrowEnable(z16);
        if (profileMiniAppInfo.guestAppTotal > 1) {
            setClickTag(elegantProfileContentTitleView.mTitleContainer, false);
        }
    }

    private void makeOrRefreshOwnerProfile(ElegantProfileContentTitleView elegantProfileContentTitleView, ProfileMiniAppInfo profileMiniAppInfo) {
        boolean z16;
        addProfileCardView(elegantProfileContentTitleView, true, profileMiniAppInfo);
        ArrayList<INTERFACE$StApiAppInfo> arrayList = profileMiniAppInfo.miniAppInfoArrayList;
        if (arrayList.size() > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        elegantProfileContentTitleView.setArrowEnable(z16);
        if (arrayList.size() > 1) {
            setClickTag(elegantProfileContentTitleView.mTitleContainer, true);
        }
    }

    private void setClickTag(View view, boolean z16) {
        if (view == null) {
            return;
        }
        view.setTag(new b(96, Boolean.valueOf(z16)));
        view.setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateItemColor(View view) {
        if (((ProfileCardInfo) this.mData).currentTemplate == null) {
            return;
        }
        if (view instanceof BaseMiniAppProfileCardView) {
            updateMiniItemColor((BaseMiniAppProfileCardView) view);
        } else if (view instanceof MiniAppProfileCardGuestView) {
            updateMiniGuestItemColor((MiniAppProfileCardGuestView) view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.tencent.mobileqq.profilecard.widget.ElegantProfileContentTitleView, VIEW] */
    @Override // com.tencent.mobileqq.profilecard.bussiness.miniapp.BaseProfileMiniAppComponent
    public boolean makeOrRefreshMini(Card card) {
        ElegantProfileContentTitleView elegantProfileContentTitleView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) card)).booleanValue();
        }
        boolean z16 = false;
        if (!((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppOpenOnProfile()) {
            return false;
        }
        if (checkProfileInvalid(card)) {
            if (this.mViewContainer == 0) {
                return false;
            }
            this.mViewContainer = null;
            return true;
        }
        ProfileMiniAppInfo profileMiniAppInfo = (ProfileMiniAppInfo) ((ProfileCardInfo) this.mData).getBusinessInfo(ProfileMiniAppInfo.class);
        VIEW view = this.mViewContainer;
        if (view instanceof ElegantProfileContentTitleView) {
            elegantProfileContentTitleView = (ElegantProfileContentTitleView) view;
        } else {
            ?? elegantProfileContentTitleView2 = new ElegantProfileContentTitleView(this.mActivity);
            this.mViewContainer = elegantProfileContentTitleView2;
            z16 = true;
            elegantProfileContentTitleView = elegantProfileContentTitleView2;
        }
        if (card.uin.equals(this.mQQAppInterface.getCurrentAccountUin())) {
            makeOrRefreshOwnerProfile(elegantProfileContentTitleView, profileMiniAppInfo);
        } else {
            makeOrRefreshGuestProfile(elegantProfileContentTitleView, profileMiniAppInfo, card.uin);
        }
        updateItemColor(elegantProfileContentTitleView.getContentView());
        elegantProfileContentTitleView.setTitle(getTitle());
        elegantProfileContentTitleView.setIcon(getDrawable());
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.miniapp.BaseProfileMiniAppComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3(profileCardInfo);
        VIEW view = this.mViewContainer;
        if (view != 0 && !this.isInitDtReport) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) view, ProfileCardDtReportUtil.DT_REPORT_GAME);
        }
        return lambda$checkValidComponent$3;
    }
}
