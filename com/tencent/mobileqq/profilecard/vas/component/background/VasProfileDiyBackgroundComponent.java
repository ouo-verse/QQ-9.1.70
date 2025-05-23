package com.tencent.mobileqq.profilecard.vas.component.background;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import com.tencent.mobileqq.vip.diy.d;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileDiyBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/vas/component/background/AbsVasProfileBackgroundComponent;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "data", "", "onVasDataUpdate", "Lcom/tencent/mobileqq/vip/diy/d;", "mQVipBackgroundCreator", "Lcom/tencent/mobileqq/vip/diy/d;", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "cardInfo", "<init>", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class VasProfileDiyBackgroundComponent extends AbsVasProfileBackgroundComponent {

    @Nullable
    private d mQVipBackgroundCreator;

    public VasProfileDiyBackgroundComponent(@Nullable IComponentCenter iComponentCenter, @Nullable ProfileCardInfo profileCardInfo) {
        super("VasProfileDiyBackgroundComponent", iComponentCenter, profileCardInfo);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.mQVipBackgroundCreator;
        if (dVar != null) {
            dVar.a();
        }
        this.mQVipBackgroundCreator = null;
    }

    @Override // com.tencent.mobileqq.profilecard.vas.component.background.AbsVasProfileBackgroundComponent
    public boolean onVasDataUpdate(@NotNull VasProfileData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.mQVipBackgroundCreator != null) {
            return true;
        }
        try {
            VasDiyData diyData = data.getDiyData();
            if (diyData != null) {
                Object bgJson = diyData.getBgJson();
                if (bgJson instanceof JSONObject) {
                    this.mQVipBackgroundCreator = d.b(this.mActivity).f(getContainerView()).d((JSONObject) bgJson);
                } else if (bgJson instanceof JSONArray) {
                    this.mQVipBackgroundCreator = d.b(this.mActivity).f(getContainerView()).c((JSONArray) bgJson);
                }
            }
        } catch (Exception e16) {
            QLog.e(getTAG(), 1, e16, new Object[0]);
            getContainerView().removeAllViews();
        }
        return true;
    }
}
