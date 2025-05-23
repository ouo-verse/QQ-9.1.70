package com.tencent.mobileqq.profilecard.vas.component.background;

import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.VasCardData;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.profilecard.vas.VasDiyTextData;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\u0010\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0012H&R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/component/background/AbsVasProfileBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsQQProfileComponent;", "Landroid/widget/FrameLayout;", "TAG", "", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Ljava/lang/String;Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "getTAG", "()Ljava/lang/String;", "isBackgroundShow", "", "()Z", "setBackgroundShow", "(Z)V", "buildVasProfileData", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "info", "getComponentName", "getComponentType", "", "getContainerView", "getDefaultResourceID", "onDataUpdate", "data", "onVasDataUpdate", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public abstract class AbsVasProfileBackgroundComponent extends AbsQQProfileComponent<FrameLayout> {

    @NotNull
    private final String TAG;
    private boolean isBackgroundShow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsVasProfileBackgroundComponent(@NotNull String TAG, @Nullable IComponentCenter iComponentCenter, @Nullable ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        Intrinsics.checkNotNullParameter(TAG, "TAG");
        this.TAG = TAG;
    }

    @NotNull
    public final VasProfileData buildVasProfileData(@Nullable ProfileCardInfo info) {
        Card card;
        String str;
        String str2;
        String str3;
        if (info != null) {
            card = info.card;
        } else {
            card = null;
        }
        if (card == null) {
            return new VasProfileData(0L, 0L, null, null, null, null, 63, null);
        }
        Card card2 = info.card;
        long j3 = card2.lCurrentStyleId;
        long j16 = card2.lCurrentBgId;
        String backgroundUrl = card2.backgroundUrl;
        Intrinsics.checkNotNullExpressionValue(backgroundUrl, "backgroundUrl");
        long j17 = card2.backgroundColor;
        int i3 = card2.dynamicCardFlag;
        String str4 = card2.strZipUrl;
        if (str4 == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "strZipUrl ?: \"\"");
            str = str4;
        }
        String str5 = card2.strActiveUrl;
        if (str5 == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str5, "strActiveUrl ?: \"\"");
            str2 = str5;
        }
        String str6 = card2.strDrawerCardUrl;
        if (str6 == null) {
            str3 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str6, "strDrawerCardUrl ?: \"\"");
            str3 = str6;
        }
        String strWzryHeroUrl = card2.strWzryHeroUrl;
        Intrinsics.checkNotNullExpressionValue(strWzryHeroUrl, "strWzryHeroUrl");
        VasCardData vasCardData = new VasCardData(j3, j16, backgroundUrl, j17, i3, str, str2, str3, strWzryHeroUrl, card2.wzryHonorInfo, card2.strExtInfo, card2.strCurrentBgUrl);
        Card card3 = info.card;
        VasDiyTextData vasDiyTextData = new VasDiyTextData(card3.diyText, card3.diyTextFontId, card3.diyTextWidth, card3.diyTextHeight, card3.diyTextLocX, card3.diyTextLocY, card3.diyTextDegree, card3.diyTextScale, card3.diyTextTransparency, card3.diyDefaultText);
        return new VasProfileData(info.curUseStyleId, info.curUseTemplateVersion, info.currentTemplate, vasCardData, (VasDiyData) info.getBusinessInfo(VasDiyData.class), vasDiyTextData);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    @NotNull
    /* renamed from: getComponentName, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public final int getComponentType() {
        return 1003;
    }

    public final int getDefaultResourceID() {
        return R.drawable.qq_profilecard_info_bg;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    /* renamed from: isBackgroundShow, reason: from getter */
    public final boolean getIsBackgroundShow() {
        return this.isBackgroundShow;
    }

    public abstract boolean onVasDataUpdate(@NotNull VasProfileData data);

    public final void setBackgroundShow(boolean z16) {
        this.isBackgroundShow = z16;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    @NotNull
    public FrameLayout getContainerView() {
        Object containerView = super.getContainerView();
        Intrinsics.checkNotNull(containerView);
        return (FrameLayout) containerView;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public final boolean lambda$checkValidComponent$3(@Nullable ProfileCardInfo data) {
        VasProfileData buildVasProfileData = buildVasProfileData(data);
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 4, "vasdata = " + buildVasProfileData);
        }
        return super.lambda$checkValidComponent$3((AbsVasProfileBackgroundComponent) data) | onVasDataUpdate(buildVasProfileData);
    }
}
