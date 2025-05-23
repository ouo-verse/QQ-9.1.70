package com.tencent.mobileqq.profilecard.vas.component.baseinfo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilecard.vas.view.ProfileBaseInfoView;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001c\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/component/baseinfo/ProfileBaseInfoComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileContentComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "TAG", "", "childComponentArray", "", "isInitDtReport", "", "checkValidComponent", HippyQQConstants.URL_COMPONENT_NAME, "destroyChildComponent", "", "getChildComponentTypeList", "", "", "getComponentName", "getComponentType", "getProfileContentKey", "initChildComponent", "onChildComponentDataUpdate", "onCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onDataUpdate", "data", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileBaseInfoComponent extends AbsProfileContentComponent {

    @NotNull
    private final String TAG;

    @NotNull
    private final int[] childComponentArray;
    private boolean isInitDtReport;

    public ProfileBaseInfoComponent(@Nullable IComponentCenter iComponentCenter, @Nullable ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.TAG = "ProfileBaseInfoComponent";
        this.childComponentArray = new int[]{1032, 1023, 1033, 1011, 1051, 1013, 1021, 1019};
    }

    private final boolean checkValidComponent(AbsProfileContentComponent component, ProfileCardInfo cardInfo) {
        if (!cardInfo.isTroopMemberCard) {
            return true;
        }
        IRuntimeService runtimeService = this.mApp.getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mApp.getRuntimeService(I\u2026va, ProcessConstant.MAIN)");
        if (!((ITroopInfoService) runtimeService).isQidianPrivateTroop(cardInfo.troopUin)) {
            return true;
        }
        String profileContentKey = component.getProfileContentKey();
        String[] KEY_MAP_QIDIAN_PRIVATE_TROOP = IProfileContentKey.KEY_MAP_QIDIAN_PRIVATE_TROOP;
        Intrinsics.checkNotNullExpressionValue(KEY_MAP_QIDIAN_PRIVATE_TROOP, "KEY_MAP_QIDIAN_PRIVATE_TROOP");
        for (String str : KEY_MAP_QIDIAN_PRIVATE_TROOP) {
            if (TextUtils.equals(profileContentKey, str)) {
                return true;
            }
        }
        return false;
    }

    private final void destroyChildComponent() {
        Iterator<Integer> it = getChildComponentTypeList().iterator();
        while (it.hasNext()) {
            try {
                IComponent<? extends View, ProfileCardInfo> component = getComponent(it.next().intValue());
                if (component != null) {
                    removeComponent(component);
                    component.detachFromComponentCenter();
                }
            } catch (Exception e16) {
                QLog.e(this.TAG, 1, "destroyChildComponent fail.", e16);
            }
        }
    }

    private final List<Integer> getChildComponentTypeList() {
        ArrayList arrayList = new ArrayList();
        for (int i3 : this.childComponentArray) {
            arrayList.add(Integer.valueOf(i3));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initChildComponent() {
        Iterator<Integer> it = getChildComponentTypeList().iterator();
        while (it.hasNext()) {
            try {
                AbsProfileComponent create = ProfileUtils.create(it.next().intValue(), this.mComponentCenter, (ProfileCardInfo) this.mData, this.mDelegate);
                Intrinsics.checkNotNullExpressionValue(create, "create(componentType, mC\u2026Center, mData, mDelegate)");
                create.attachToComponentCenter();
                addComponent(create);
            } catch (Exception e16) {
                QLog.e(this.TAG, 1, "initChildComponent fail.", e16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean onChildComponentDataUpdate(ProfileCardInfo cardInfo) {
        AbsProfileContentComponent absProfileContentComponent;
        boolean z16;
        if (QLog.isDevelopLevel()) {
            String str = this.TAG;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("onDateUpdate this=%s", Arrays.copyOf(new Object[]{this}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d(str, 4, format);
        }
        if (!(this.mViewContainer instanceof ProfileBaseInfoView)) {
            return false;
        }
        this.mData = cardInfo;
        int size = this.mChildComponent.size();
        boolean z17 = false;
        for (int i3 = 0; i3 < size; i3++) {
            Object valueAt = this.mChildComponent.valueAt(i3);
            if (valueAt instanceof AbsProfileContentComponent) {
                absProfileContentComponent = (AbsProfileContentComponent) valueAt;
            } else {
                absProfileContentComponent = null;
            }
            if (absProfileContentComponent != null) {
                DATA mData = this.mData;
                Intrinsics.checkNotNullExpressionValue(mData, "mData");
                if (checkValidComponent(absProfileContentComponent, (ProfileCardInfo) mData)) {
                    try {
                        z16 = absProfileContentComponent.lambda$checkValidComponent$3(cardInfo);
                    } catch (Exception e16) {
                        QLog.e(this.TAG, 1, "onDataUpdate fail.", e16);
                        z16 = true;
                    }
                    String profileContentKey = absProfileContentComponent.getProfileContentKey();
                    View containerView = absProfileContentComponent.getContainerView();
                    if (containerView != null) {
                        containerView.getParent();
                    }
                    if (z16) {
                        VIEW view = this.mViewContainer;
                        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.profilecard.vas.view.ProfileBaseInfoView");
                        HashMap<String, View> moreInfoMap = ((ProfileBaseInfoView) view).getMoreInfoMap();
                        if (containerView == null) {
                            moreInfoMap.remove(profileContentKey);
                        } else {
                            Intrinsics.checkNotNullExpressionValue(moreInfoMap, "moreInfoMap");
                            moreInfoMap.put(profileContentKey, containerView);
                        }
                    }
                    z17 |= z16;
                }
            }
        }
        if (z17) {
            VIEW view2 = this.mViewContainer;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.mobileqq.profilecard.vas.view.ProfileBaseInfoView");
            ((ProfileBaseInfoView) view2).rebuildProfileContent((ProfileCardInfo) this.mData);
        }
        if (z17 && !this.isInitDtReport) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) this.mViewContainer, ProfileCardDtReportUtil.DT_REPORT_BASEINFO);
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    @NotNull
    /* renamed from: getComponentName, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1035;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    @NotNull
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_DIY_BASE_INFO;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(@Nullable QBaseActivity activity, @Nullable Bundle savedInstanceState) {
        super.onCreate(activity, savedInstanceState);
        ProfileBaseInfoView profileBaseInfoView = new ProfileBaseInfoView(activity);
        profileBaseInfoView.setOrientation(1);
        setContainerView(profileBaseInfoView);
        initChildComponent();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        destroyChildComponent();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(@NotNull ProfileCardInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getContainerView().getLayoutParams();
            if (marginLayoutParams == null) {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
            }
            marginLayoutParams.setMargins(ViewUtils.dip2px(11.0f), ViewUtils.dip2px(11.0f), ViewUtils.dip2px(11.0f), ViewUtils.dip2px(11.0f));
            getContainerView().setLayoutParams(marginLayoutParams);
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) getContainerView().getLayoutParams();
            if (marginLayoutParams2 == null) {
                marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-1, -1);
            }
            marginLayoutParams2.setMargins(0, 0, 0, 0);
            getContainerView().setLayoutParams(marginLayoutParams2);
        }
        IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (diyMoreInfoManager.isDiy()) {
            diyMoreInfoManager.updateBaseInfoForDeepDiy(getContainerView());
        }
        return onChildComponentDataUpdate(data);
    }
}
