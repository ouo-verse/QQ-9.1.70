package com.tencent.mobileqq.profilecard.bussiness.guide;

import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.guide.action.ProfileGuideAction;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import com.tencent.mobileqq.profilecard.bussiness.guide.handler.ProfileGuideHandler;
import com.tencent.mobileqq.profilecard.bussiness.guide.handler.ProfileGuideObserver;
import com.tencent.mobileqq.profilecard.bussiness.guide.report.ProfileGuideReporter;
import com.tencent.mobileqq.profilecard.bussiness.guide.view.ProfileGuideClickListener;
import com.tencent.mobileqq.profilecard.bussiness.guide.view.ProfileGuideView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u001a\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u000fH\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u0013H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/guide/ProfileGuideComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileContentComponent;", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/view/ProfileGuideClickListener;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "guideAction", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/action/ProfileGuideAction;", "guideObserver", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideObserver;", "profileGuide", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "dismissProfileGuide", "", "getComponentName", "", "getComponentType", "", "getProfileContentKey", "getProfileGuide", "getProfileGuideHandler", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/common/app/AppInterface;", "handleGetProfileGuide", "makeOrRefresh", "", "onCloseClick", "onCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onDataUpdate", "profileCardInfo", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFillClick", "onUpdateClick", "reportProfileGuideRead", QCircleDaTongConstant.ElementParamValue.OPERATION, "Companion", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileGuideComponent extends AbsProfileContentComponent implements ProfileGuideClickListener {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "ProfileGuideComponent";
    private ProfileGuideAction guideAction;

    @NotNull
    private final ProfileGuideObserver guideObserver;

    @Nullable
    private ProfileGuide profileGuide;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/guide/ProfileGuideComponent$Companion;", "", "()V", "TAG", "", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18486);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ProfileGuideComponent(@Nullable IComponentCenter iComponentCenter, @Nullable ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.guideObserver = new ProfileGuideObserver() { // from class: com.tencent.mobileqq.profilecard.bussiness.guide.ProfileGuideComponent$guideObserver$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileGuideComponent.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.bussiness.guide.handler.ProfileGuideObserver
                public void onGetProfileGuide(boolean success, @Nullable ProfileGuide profileGuide) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(success), profileGuide);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("onGetProfileGuide success=%s profileGuide=%s", Arrays.copyOf(new Object[]{Boolean.valueOf(success), profileGuide}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        QLog.d("ProfileGuideComponent", 2, format);
                    }
                    if (success) {
                        ProfileGuideComponent.this.handleGetProfileGuide(profileGuide);
                    }
                }
            };
        }
    }

    private final void dismissProfileGuide() {
        this.profileGuide = null;
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.notifyCardUpdate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void getProfileGuide() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getProfileGuide");
        }
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        BusinessHandler profileGuideHandler = getProfileGuideHandler(this.mApp);
        if (z16 && (profileGuideHandler instanceof ProfileGuideHandler)) {
            ((ProfileGuideHandler) profileGuideHandler).getProfileGuide();
        }
    }

    private final BusinessHandler getProfileGuideHandler(AppInterface app) {
        if (app != null) {
            return app.getBusinessHandler(ProfileGuideHandler.class.getName());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGetProfileGuide(ProfileGuide profileGuide) {
        ProfileGuide profileGuide2;
        Integer num = null;
        if (profileGuide != null && !profileGuide.isValid()) {
            profileGuide2 = null;
        } else {
            profileGuide2 = profileGuide;
        }
        if (!Intrinsics.areEqual(this.profileGuide, profileGuide2)) {
            this.profileGuide = profileGuide2;
            IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
            if (iProfileActivityDelegate != null) {
                iProfileActivityDelegate.notifyCardUpdate();
            }
            if (profileGuide != null) {
                num = Integer.valueOf(profileGuide.getGuideType());
            }
            if (num != null && num.intValue() == 1) {
                ProfileGuideReporter.INSTANCE.reportProfileGuideFill(profileGuide.getGuideId(), 1);
            } else if (num != null && num.intValue() == 2) {
                ProfileGuideReporter.INSTANCE.reportProfileGuideUpdate(profileGuide.getGuideId(), 1);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.tencent.mobileqq.profilecard.bussiness.guide.view.ProfileGuideView, VIEW] */
    private final boolean makeOrRefresh(ProfileGuide profileGuide) {
        boolean z16 = true;
        if (profileGuide != null && profileGuide.isValid()) {
            if (this.mViewContainer == 0) {
                QBaseActivity mActivity = this.mActivity;
                Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                ?? profileGuideView = new ProfileGuideView(mActivity);
                profileGuideView.setClickListener(this);
                this.mViewContainer = profileGuideView;
            } else {
                z16 = false;
            }
            View view = (View) this.mViewContainer;
            if (view instanceof ProfileGuideView) {
                ((ProfileGuideView) view).updateProfileGuide(profileGuide);
                return z16;
            }
            return z16;
        }
        if (this.mViewContainer == 0) {
            return false;
        }
        this.mViewContainer = null;
        return true;
    }

    private final void reportProfileGuideRead(ProfileGuide profileGuide, int operation) {
        BusinessHandler profileGuideHandler = getProfileGuideHandler(this.mApp);
        if (profileGuideHandler instanceof ProfileGuideHandler) {
            ((ProfileGuideHandler) profileGuideHandler).reportProfileGuideRead(profileGuide.getGuideId(), profileGuide.getGuideType(), operation);
        }
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
        return 1029;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    @NotNull
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_GUIDE;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.guide.view.ProfileGuideClickListener
    public void onCloseClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ProfileGuide profileGuide = this.profileGuide;
        if (profileGuide != null) {
            reportProfileGuideRead(profileGuide, 1);
            dismissProfileGuide();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(@NotNull QBaseActivity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        AppInterface mApp = this.mApp;
        Intrinsics.checkNotNullExpressionValue(mApp, "mApp");
        QBaseActivity mActivity = this.mActivity;
        Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
        DATA mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        IComponentCenter mComponentCenter = this.mComponentCenter;
        Intrinsics.checkNotNullExpressionValue(mComponentCenter, "mComponentCenter");
        this.guideAction = new ProfileGuideAction(mApp, mActivity, (ProfileCardInfo) mData, mComponentCenter);
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.addObserver(this.guideObserver);
        }
        getProfileGuide();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.removeObserver(this.guideObserver);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.guide.view.ProfileGuideClickListener
    public void onFillClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ProfileGuide profileGuide = this.profileGuide;
        if (profileGuide != null) {
            ProfileGuideAction profileGuideAction = this.guideAction;
            if (profileGuideAction == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideAction");
                profileGuideAction = null;
            }
            profileGuideAction.onAction(profileGuide.getGuideId(), profileGuide.getGuideType());
            reportProfileGuideRead(profileGuide, 0);
            dismissProfileGuide();
            ProfileGuideReporter.INSTANCE.reportProfileGuideFill(profileGuide.getGuideId(), 2);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.guide.view.ProfileGuideClickListener
    public void onUpdateClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ProfileGuide profileGuide = this.profileGuide;
        if (profileGuide != null) {
            ProfileGuideAction profileGuideAction = this.guideAction;
            if (profileGuideAction == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guideAction");
                profileGuideAction = null;
            }
            profileGuideAction.onAction(profileGuide.getGuideId(), profileGuide.getGuideType());
            reportProfileGuideRead(profileGuide, 0);
            dismissProfileGuide();
            ProfileGuideReporter.INSTANCE.reportProfileGuideUpdate(profileGuide.getGuideId(), 2);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(@NotNull ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(profileCardInfo, "profileCardInfo");
        return super.lambda$checkValidComponent$3((ProfileGuideComponent) profileCardInfo) | makeOrRefresh(this.profileGuide);
    }
}
