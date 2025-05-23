package com.tencent.mobileqq.profilecard.bussiness.miniapp;

import NS_MINI_APP_MISC.MISC$StAppPlayingInfo;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class BaseProfileMiniAppComponent extends AbsQQProfileContentComponent implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BaseProfileMiniAppComponent";

    public BaseProfileMiniAppComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 1014;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_MINI_PLAYING;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0191  */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView, VIEW] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean makeOrRefreshMini(Card card) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) card)).booleanValue();
        }
        ProfileCardInfo profileCardInfo = (ProfileCardInfo) this.mData;
        QQAppInterface qQAppInterface = this.mQQAppInterface;
        boolean z19 = false;
        if (card == null) {
            return false;
        }
        boolean equals = card.uin.equals(qQAppInterface.getCurrentAccountUin());
        View view = (View) this.mViewContainer;
        ThemeUtil.isInNightMode(qQAppInterface);
        if (profileCardInfo.currentTemplate != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        ProfileMiniAppInfo profileMiniAppInfo = (ProfileMiniAppInfo) ((ProfileCardInfo) this.mData).getBusinessInfo(ProfileMiniAppInfo.class);
        if (profileMiniAppInfo != null && profileMiniAppInfo.isShowMiniPlaying) {
            if (view == null) {
                ?? profileContentTitleView = new ProfileContentTitleView(this.mActivity);
                if (equals) {
                    ArrayList<INTERFACE$StApiAppInfo> arrayList = profileMiniAppInfo.miniAppInfoArrayList;
                    if (arrayList == null || arrayList.size() <= 0) {
                        return false;
                    }
                    profileContentTitleView.setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_PROFILECARD_MINI_PLAYING_NAME, QzoneConfig.DefaultValue.DEFAULT_PROFILECARD_MINI_PLAYING_NAME));
                    if (profileMiniAppInfo.miniAppInfoArrayList.size() > 1) {
                        z19 = true;
                    }
                    profileContentTitleView.setArrowEnable(z19);
                    BaseMiniAppProfileCardView createMiniAppProfileCardView = ((IMiniAppService) QRoute.api(IMiniAppService.class)).createMiniAppProfileCardView(this.mActivity);
                    createMiniAppProfileCardView.setData(profileMiniAppInfo.miniAppInfoArrayList);
                    profileContentTitleView.addContentView(createMiniAppProfileCardView);
                    if (z16) {
                        updateMiniItemColor(createMiniAppProfileCardView);
                    }
                } else {
                    List<MISC$StAppPlayingInfo> list = profileMiniAppInfo.appPlayingInfos;
                    if (list == null || list.size() <= 0) {
                        return false;
                    }
                    profileContentTitleView.setTitle(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_PROFILECARD_MINI_PLAYING_NAME_GUEST_DEFAULT, QzoneConfig.DefaultValue.DEFAULT_PROFILECARD_MINI_PLAYING_NAME_GUEST_DEFAULT));
                    if (profileMiniAppInfo.appPlayingInfos.size() > 1) {
                        z19 = true;
                    }
                    profileContentTitleView.setArrowEnable(z19);
                    MiniAppProfileCardGuestView miniAppProfileCardGuestView = new MiniAppProfileCardGuestView(this.mActivity);
                    miniAppProfileCardGuestView.setData(profileMiniAppInfo.appPlayingInfos, profileMiniAppInfo.guestJumpUrl, card.uin);
                    profileContentTitleView.addContentView(miniAppProfileCardGuestView);
                    if (z16) {
                        updateMiniGuestItemColor(miniAppProfileCardGuestView);
                    }
                }
                this.mViewContainer = profileContentTitleView;
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportProfileCardExposed(profileMiniAppInfo, equals);
                view = profileContentTitleView;
                z19 = true;
                if (view instanceof ProfileContentTitleView) {
                }
                return z19;
            }
            if (equals) {
                if (view instanceof ProfileContentTitleView) {
                    ProfileContentTitleView profileContentTitleView2 = (ProfileContentTitleView) view;
                    if (profileMiniAppInfo.miniAppInfoArrayList.size() > 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    profileContentTitleView2.setArrowEnable(z18);
                    BaseMiniAppProfileCardView baseMiniAppProfileCardView = (BaseMiniAppProfileCardView) profileContentTitleView2.getContentView();
                    baseMiniAppProfileCardView.setData(profileMiniAppInfo.miniAppInfoArrayList);
                    if (z16) {
                        updateMiniItemColor(baseMiniAppProfileCardView);
                    }
                    if (profileMiniAppInfo.miniAppInfoArrayList.size() > 1) {
                        ViewGroup viewGroup = profileContentTitleView2.mTitleContainer;
                        viewGroup.setTag(new b(96, Boolean.TRUE));
                        viewGroup.setOnClickListener(this);
                    }
                }
            } else if (view instanceof ProfileContentTitleView) {
                ProfileContentTitleView profileContentTitleView3 = (ProfileContentTitleView) view;
                profileContentTitleView3.setTitle(profileMiniAppInfo.guestAppTotal + QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_PROFILECARD_MINI_PLAYING_NAME_GUEST, QzoneConfig.DefaultValue.DEFAULT_PROFILECARD_MINI_PLAYING_NAME_GUEST));
                if (profileMiniAppInfo.guestAppTotal > 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                profileContentTitleView3.setArrowEnable(z17);
                MiniAppProfileCardGuestView miniAppProfileCardGuestView2 = (MiniAppProfileCardGuestView) profileContentTitleView3.getContentView();
                miniAppProfileCardGuestView2.setData(profileMiniAppInfo.appPlayingInfos, profileMiniAppInfo.guestJumpUrl, card.uin);
                if (z16) {
                    updateMiniGuestItemColor(miniAppProfileCardGuestView2);
                }
                if (profileMiniAppInfo.guestAppTotal > 1) {
                    ViewGroup viewGroup2 = profileContentTitleView3.mTitleContainer;
                    viewGroup2.setTag(new b(96, Boolean.FALSE));
                    viewGroup2.setOnClickListener(this);
                }
            }
            if (view instanceof ProfileContentTitleView) {
            }
            return z19;
        }
        if (view != null) {
            this.mViewContainer = null;
            view = view;
            z19 = true;
        }
        if (view instanceof ProfileContentTitleView) {
            updateItemTheme((ProfileContentTitleView) view, true);
        }
        return z19;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            boolean booleanValue = ((Boolean) ((b) view.getTag()).f260136b).booleanValue();
            ProfileMiniAppInfo profileMiniAppInfo = (ProfileMiniAppInfo) ((ProfileCardInfo) this.mData).getBusinessInfo(ProfileMiniAppInfo.class);
            if (booleanValue) {
                i3 = 2062;
            } else {
                i3 = LaunchScene.LAUNCH_SCENE_PROFILE_GUEST_CARD;
            }
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            Context context = view.getContext();
            if (booleanValue) {
                str = profileMiniAppInfo.tabJumpUrl;
            } else {
                str = profileMiniAppInfo.guestJumpUrl;
            }
            iMiniAppService.startMiniApp(context, str, i3, null);
            ProfileCardReport.reportMiniAppClick(this.mQQAppInterface, (ProfileCardInfo) this.mData);
            VIEW view2 = this.mViewContainer;
            if (view2 != 0) {
                ProfileCardDtReportUtil.dtReportClick((View) view2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) bundle);
        } else {
            super.onCreate(qBaseActivity, bundle);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateMiniGuestItemColor(MiniAppProfileCardGuestView miniAppProfileCardGuestView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) miniAppProfileCardGuestView);
            return;
        }
        Object obj = ((ProfileCardInfo) this.mData).currentTemplate.templateAttr.get("commonItemContentColor");
        if (obj == null) {
            return;
        }
        if (obj instanceof ColorStateList) {
            miniAppProfileCardGuestView.setTextColor((ColorStateList) obj);
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (str.startsWith("#")) {
                miniAppProfileCardGuestView.setTextColor(Color.parseColor(str));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateMiniItemColor(BaseMiniAppProfileCardView baseMiniAppProfileCardView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) baseMiniAppProfileCardView);
            return;
        }
        Object obj = ((ProfileCardInfo) this.mData).currentTemplate.templateAttr.get("commonItemContentColor");
        if (obj == null) {
            return;
        }
        if (obj instanceof ColorStateList) {
            baseMiniAppProfileCardView.setTextColor((ColorStateList) obj);
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (str.startsWith("#")) {
                baseMiniAppProfileCardView.setTextColor(Color.parseColor(str));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public boolean onDataUpdate(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? super.onDataUpdate((BaseProfileMiniAppComponent) profileCardInfo) | makeOrRefreshMini(((ProfileCardInfo) this.mData).card) : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileCardInfo)).booleanValue();
    }
}
