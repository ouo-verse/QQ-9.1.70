package com.tencent.mobileqq.profilecard.bussiness.anonymous;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.TokenResUtils;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/ProfileEmptyAnonymousComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileContentComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "isInitDtReport", "", "getComponentName", "", "getComponentType", "", "getProfileContentKey", "initAnonymousView", "Landroid/view/View;", "initDtElementReport", "", "isShowEmptyItem", "anonymousAnswerInfo", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/ProfileAnonymousAnswerInfo;", "isHost", "makeOrRefresh", "profileCardInfo", "onDataUpdate", "Companion", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileEmptyAnonymousComponent extends AbsProfileContentComponent {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String DT_REPORT_ANONYMOUS = "em_profile_question";

    @NotNull
    private static final String DT_REPORT_PARAM_GUEST_EMPTY_IS_NEW = "profile_em_guest_empty_is_new";

    @NotNull
    private static final String DT_REPORT_PARAM_IS_EMPTY = "profile_em_is_empty";
    private static final int DT_REPORT_PARAM_ITEM_IS_EMPTY = 1;

    @NotNull
    private static final String TAG = "ProfileEmptyAnonymousComponent";
    private boolean isInitDtReport;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/ProfileEmptyAnonymousComponent$Companion;", "", "()V", "DT_REPORT_ANONYMOUS", "", "DT_REPORT_PARAM_GUEST_EMPTY_IS_NEW", "DT_REPORT_PARAM_IS_EMPTY", "DT_REPORT_PARAM_ITEM_IS_EMPTY", "", "TAG", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17650);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ProfileEmptyAnonymousComponent(@Nullable IComponentCenter iComponentCenter, @Nullable ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    private final View initAnonymousView() {
        View inflate = View.inflate(this.mActivity, R.layout.h06, null);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.anonymous.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileEmptyAnonymousComponent.initAnonymousView$lambda$0(ProfileEmptyAnonymousComponent.this, view);
            }
        });
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAnonymousView$lambda$0(ProfileEmptyAnonymousComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QBaseActivity qBaseActivity = this$0.mActivity;
        Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type android.app.Activity");
        AnonymousViewHelper.jumpToAskQuestion(qBaseActivity, ((ProfileCardInfo) this$0.mData).allInOne.uin, 6);
        ReportController.o(null, "dc00898", "", "", "0X800B472", "0X800B472", 0, 0, "", "", "", "");
        VideoReport.reportEvent("clck", this$0.mViewContainer, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initDtElementReport() {
        VideoReport.setElementId(this.mViewContainer, DT_REPORT_ANONYMOUS);
        VideoReport.setElementClickPolicy(this.mViewContainer, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.mViewContainer, ExposurePolicy.REPORT_ALL);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("profile_em_is_empty", 1);
        linkedHashMap.put("profile_em_guest_empty_is_new", 1);
        VideoReport.setElementParams(this.mViewContainer, linkedHashMap);
    }

    private final boolean isShowEmptyItem(ProfileAnonymousAnswerInfo anonymousAnswerInfo, boolean isHost) {
        if ((anonymousAnswerInfo == null || anonymousAnswerInfo.mAnsweredQuestionCount == 0) && !isHost && ProfileCardFeatureSwitch.INSTANCE.isVisitorProfileCardEmptySignEnable()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.view.View, VIEW] */
    private final boolean makeOrRefresh(ProfileCardInfo profileCardInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        String str2;
        String str3;
        boolean z19 = true;
        if (profileCardInfo.allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ProfileAnonymousAnswerInfo profileAnonymousAnswerInfo = (ProfileAnonymousAnswerInfo) profileCardInfo.getBusinessInfo(ProfileAnonymousAnswerInfo.class);
        IProfileConfig iProfileConfig = this.mConfigHelper;
        if (iProfileConfig != null && !iProfileConfig.isSwitchEnable(13)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).getProfileDisplaySettingStateFromCard(42425, profileCardInfo.card, this.mApp) != 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        boolean isPaTypeFriend = ProfilePAUtils.isPaTypeFriend(profileCardInfo.allInOne);
        if (isShowEmptyItem(profileAnonymousAnswerInfo, z16) && z17 && z18 && isPaTypeFriend) {
            if (this.mViewContainer == 0) {
                this.mViewContainer = initAnonymousView();
                if (z16) {
                    str = "";
                } else {
                    str = ((ProfileCardInfo) this.mData).allInOne.uin;
                }
                String str4 = str;
                if (z16) {
                    str2 = "0X800B461";
                } else {
                    str2 = "0X800B462";
                }
                if (z16) {
                    str3 = "0X800B461";
                } else {
                    str3 = "0X800B462";
                }
                ReportController.o(null, "dc00898", "", str4, str2, str3, 0, 0, "", "", "", "");
            } else {
                z19 = false;
            }
            TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.info);
            ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f164472yw);
            ImageView imageView2 = (ImageView) ((View) this.mViewContainer).findViewById(R.id.icon);
            if (TokenResUtils.useTokenIcon()) {
                imageView2.setBackgroundResource(R.drawable.qui_anonymity);
            } else {
                if (QQTheme.isNowSimpleUI()) {
                    imageView2.setBackgroundResource(R.drawable.qui_anonymity);
                } else {
                    imageView2.setBackgroundResource(R.drawable.nfv);
                }
                if (QQTheme.isNowThemeIsNight()) {
                    imageView2.setColorFilter(Color.parseColor("#999999"));
                }
            }
            updateItemTheme((View) this.mViewContainer, textView, null, imageView);
            return z19;
        }
        if (this.mViewContainer == 0) {
            return false;
        }
        this.mViewContainer = null;
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    @NotNull
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
        return 1039;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    @NotNull
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_ANONYMOUS_EMPTY;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(@NotNull ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(profileCardInfo, "profileCardInfo");
        boolean makeOrRefresh = makeOrRefresh(profileCardInfo) | super.lambda$checkValidComponent$3((ProfileEmptyAnonymousComponent) profileCardInfo);
        if (makeOrRefresh && !this.isInitDtReport && this.mViewContainer != 0) {
            this.isInitDtReport = true;
            initDtElementReport();
        }
        return makeOrRefresh;
    }
}
