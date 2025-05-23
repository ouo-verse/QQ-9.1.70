package com.tencent.mobileqq.profilecard.vas.component.background;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.view.ShakeImageView;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.VasCardData;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileWzBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/vas/component/background/AbsVasProfileBackgroundComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "mCardData", "Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "mDefaultBackgroundView", "Landroid/widget/ImageView;", "mWzBg", "Landroid/graphics/Bitmap;", "mWzBgView", "Lcom/tencent/mobileqq/profile/view/ShakeImageView;", "mWzCharacter", "mWzCharacterView", "initWzryDynamicBgAndHero", "", "data", "onCreate", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onVasDataUpdate", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "updateImage", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class VasProfileWzBackgroundComponent extends AbsVasProfileBackgroundComponent {

    @Nullable
    private VasCardData mCardData;

    @Nullable
    private ImageView mDefaultBackgroundView;

    @Nullable
    private Bitmap mWzBg;

    @Nullable
    private ShakeImageView mWzBgView;

    @Nullable
    private Bitmap mWzCharacter;

    @Nullable
    private ShakeImageView mWzCharacterView;

    public VasProfileWzBackgroundComponent(@Nullable IComponentCenter iComponentCenter, @Nullable ProfileCardInfo profileCardInfo) {
        super("VasProfileWzryBackgroundComponent", iComponentCenter, profileCardInfo);
    }

    private final boolean initWzryDynamicBgAndHero(VasCardData data) {
        if (QLog.isColorLevel()) {
            String tag = getTAG();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("initWzryDynamicBgAndHero bgId=%s bgUrl=%s heroUrl=%s", Arrays.copyOf(new Object[]{Long.valueOf(data.getLCurrentBgId()), data.getBackgroundUrl(), data.getStrWzryHeroUrl()}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d(tag, 2, format);
        }
        if (!TextUtils.isEmpty(data.getBackgroundUrl()) || !TextUtils.isEmpty(data.getStrWzryHeroUrl())) {
            try {
                String t16 = ProfileCardManager.t(this.mActivity, data.getLCurrentBgId());
                String str = t16 + "wzBgImage.png";
                String str2 = t16 + "wzMainImage.png";
                ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
                Bitmap f16 = imageCacheHelper.f(str);
                if (f16 == null || f16.isRecycled()) {
                    f16 = j.c(str);
                }
                if (f16 != null && !Intrinsics.areEqual(this.mWzBg, f16)) {
                    this.mWzBg = f16;
                    imageCacheHelper.i(str, f16, Business.AIO);
                }
                Bitmap f17 = imageCacheHelper.f(str2);
                if (f17 == null || f17.isRecycled()) {
                    f17 = j.c(str2);
                }
                if (f17 != null && !Intrinsics.areEqual(this.mWzCharacter, f17)) {
                    this.mWzCharacter = f17;
                    imageCacheHelper.i(str2, f17, Business.AIO);
                }
                return true;
            } catch (Throwable th5) {
                QLog.e(getTAG(), 1, "initWzryDynamicBgAndHero fail.", th5);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onVasDataUpdate$lambda$3(VasProfileWzBackgroundComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateImage();
    }

    private final void updateImage() {
        ShakeImageView shakeImageView;
        ShakeImageView shakeImageView2;
        Bitmap bitmap = this.mWzBg;
        if (bitmap != null && (shakeImageView2 = this.mWzBgView) != null) {
            shakeImageView2.setImage(bitmap, (int) (getContainerView().getWidth() * 1.1d), (int) (getContainerView().getHeight() * 1.1d), 1.0f);
        }
        Bitmap bitmap2 = this.mWzCharacter;
        if (bitmap2 != null && (shakeImageView = this.mWzCharacterView) != null) {
            shakeImageView.setImage(bitmap2, (int) (getContainerView().getWidth() * 1.1d), (int) (getContainerView().getHeight() * 1.1d), -1.0f);
        }
        if (this.mWzBg == null && this.mWzCharacter == null) {
            ImageView imageView = this.mDefaultBackgroundView;
            if (imageView != null) {
                imageView.setBackgroundResource(getDefaultResourceID());
            }
            setBackgroundShow(false);
            return;
        }
        ImageView imageView2 = this.mDefaultBackgroundView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
        }
        setBackgroundShow(true);
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(@NotNull QBaseActivity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        ImageView imageView = new ImageView(activity);
        imageView.setContentDescription("qqvip_bg");
        getContainerView().addView(imageView);
        this.mDefaultBackgroundView = imageView;
        ShakeImageView shakeImageView = new ShakeImageView(activity);
        shakeImageView.setContentDescription("qqvip_wzry_bg");
        getContainerView().addView(shakeImageView);
        this.mWzBgView = shakeImageView;
        ShakeImageView shakeImageView2 = new ShakeImageView(activity);
        shakeImageView2.setContentDescription("qqvip_wzry_character");
        getContainerView().addView(shakeImageView2);
        this.mWzCharacterView = shakeImageView2;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        getContainerView().removeView(this.mDefaultBackgroundView);
        getContainerView().removeView(this.mWzBgView);
        getContainerView().removeView(this.mWzCharacterView);
        this.mDefaultBackgroundView = null;
        this.mWzBgView = null;
        this.mWzCharacterView = null;
    }

    @Override // com.tencent.mobileqq.profilecard.vas.component.background.AbsVasProfileBackgroundComponent
    public boolean onVasDataUpdate(@NotNull VasProfileData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getCurrentTemplate() == null) {
            ImageView imageView = this.mDefaultBackgroundView;
            if (imageView != null) {
                imageView.setBackgroundResource(getDefaultResourceID());
            }
            return true;
        }
        if (data.getCardData().equals(this.mCardData) && getIsBackgroundShow()) {
            return true;
        }
        this.mCardData = data.getCardData();
        initWzryDynamicBgAndHero(data.getCardData());
        getContainerView().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.component.background.a
            @Override // java.lang.Runnable
            public final void run() {
                VasProfileWzBackgroundComponent.onVasDataUpdate$lambda$3(VasProfileWzBackgroundComponent.this);
            }
        });
        return true;
    }
}
