package com.tencent.richframework.gallery.part;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.libra.request.Option;
import com.tencent.libra.request.SizeFormat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.gallery.QQLayerUtil;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.delegate.outer.ErrorUIConfig;
import com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider;
import com.tencent.richframework.gallery.delegate.outer.InnerErrorInfo;
import com.tencent.richframework.gallery.event.HideSaveView;
import com.tencent.richframework.video.SwitchUrlType;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yz3.a;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0004J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/richframework/gallery/part/QQMediaStrategyPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaShowStrategyProvider;", "()V", "addWhiteColorFilter", "", "isAndroidNSupportSoftwareLayerType", "isForceSoftLayer", "isForceUseGE", "isForceUseLE", "isSupportMagnifyLongPic", "isSupportRegionScale", "layerRotateDisabled", "useRGB8888", "buildVideoErrorToast", "", "innerErrorInfo", "Lcom/tencent/richframework/gallery/delegate/outer/InnerErrorInfo;", "disableRotate", "itemInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "doOnVisible", "", "getErrorDrawable", "Landroid/graphics/drawable/Drawable;", "drawableId", "", "getLoadingDrawable", "getSizeFormat", "Lcom/tencent/libra/request/SizeFormat;", "getSwitchUrlType", "Lcom/tencent/richframework/video/SwitchUrlType;", "isLargePicError", "option", "Lcom/tencent/libra/request/Option;", "needShowErrorUI", "Lcom/tencent/richframework/gallery/delegate/outer/ErrorUIConfig;", "onInitView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "useBitmapConfig8888", "useSoftLayerType", "Companion", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public class QQMediaStrategyPart extends RFWLayerBasePart implements IMediaShowStrategyProvider {
    private boolean addWhiteColorFilter;
    private boolean isAndroidNSupportSoftwareLayerType;
    private boolean isSupportMagnifyLongPic;
    private boolean isSupportRegionScale;
    private boolean useRGB8888;
    private boolean isForceSoftLayer = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("FORCE_SOFTWARE_LAYER_TYPE", false);
    private boolean isForceUseGE = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("USE_GE_SIZE", false);
    private boolean isForceUseLE = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("USE_LE_SIZE", false);
    private boolean layerRotateDisabled = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("DISABLE_LAYER_ROTATE", false);

    public QQMediaStrategyPart() {
        boolean z16 = true;
        this.isSupportRegionScale = true;
        this.isAndroidNSupportSoftwareLayerType = true;
        this.isSupportMagnifyLongPic = true;
        this.useRGB8888 = true;
        this.isSupportRegionScale = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("SUPPORT_REGION", true);
        this.isAndroidNSupportSoftwareLayerType = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ANDROID_N_SUPPORT_SOFTWARE_LAYER_TYPE", true);
        this.isSupportMagnifyLongPic = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("SUPPORT_MAGNIFY_LONG_PIC", true);
        this.useRGB8888 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("RFW_GALLERY_USE_ARGB_8888", true);
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ADD_WHITE_COLOR_FILTER", false) && RFWApplication.isPublicVersion()) {
            z16 = false;
        }
        this.addWhiteColorFilter = z16;
    }

    private final String buildVideoErrorToast(InnerErrorInfo innerErrorInfo) {
        String str;
        RFWLayerVideoInfo layerVideoInfo;
        int i3 = RFWLog.USR;
        int errorCode = innerErrorInfo.getErrorCode();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        String str2 = null;
        if (rFWLayerItemMediaInfo != null) {
            str = rFWLayerItemMediaInfo.getMediaId();
        } else {
            str = null;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo2 != null && (layerVideoInfo = rFWLayerItemMediaInfo2.getLayerVideoInfo()) != null) {
            str2 = layerVideoInfo.getCurrentVideoUrl();
        }
        RFWLog.i("QQMediaStrategyPart", i3, "error code is " + errorCode + "\nvideo id is " + str + "\nvideo url is " + str2);
        if (innerErrorInfo.getErrorCode() == 14010028) {
            String string = getActivity().getResources().getString(R.string.f2070259w);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026g.qq_video_network_error)");
            return string;
        }
        return getActivity().getResources().getString(R.string.f2070359x) + "[" + innerErrorInfo.getErrorCode() + "]\n" + getActivity().getResources().getString(R.string.f2070459y);
    }

    private final boolean isLargePicError(RFWLayerItemMediaInfo itemInfo) {
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo;
        String str;
        RFWLayerPicInfo.RFWPicInfo bigPicInfo;
        RFWLayerPicInfo.RFWPicInfo smallPicInfo;
        if (!itemInfo.isVideo() && !itemInfo.isShowOriginPic()) {
            RFWLayerPicInfo layerPicInfo = itemInfo.getLayerPicInfo();
            String str2 = null;
            if (layerPicInfo != null) {
                rFWPicInfo = layerPicInfo.getOriginPicInfo();
            } else {
                rFWPicInfo = null;
            }
            if (rFWPicInfo != null) {
                RFWLayerPicInfo layerPicInfo2 = itemInfo.getLayerPicInfo();
                if (layerPicInfo2 != null && (smallPicInfo = layerPicInfo2.getSmallPicInfo()) != null) {
                    str = smallPicInfo.getLocalPath();
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    RFWLayerPicInfo layerPicInfo3 = itemInfo.getLayerPicInfo();
                    if (layerPicInfo3 != null && (bigPicInfo = layerPicInfo3.getBigPicInfo()) != null) {
                        str2 = bigPicInfo.getLocalPath();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        QQLayerUtil qQLayerUtil = QQLayerUtil.INSTANCE;
                        RFWLayerPicInfo layerPicInfo4 = itemInfo.getLayerPicInfo();
                        Intrinsics.checkNotNull(layerPicInfo4);
                        RFWLayerPicInfo.RFWPicInfo originPicInfo = layerPicInfo4.getOriginPicInfo();
                        Intrinsics.checkNotNull(originPicInfo);
                        int width = originPicInfo.getWidth();
                        RFWLayerPicInfo layerPicInfo5 = itemInfo.getLayerPicInfo();
                        Intrinsics.checkNotNull(layerPicInfo5);
                        RFWLayerPicInfo.RFWPicInfo originPicInfo2 = layerPicInfo5.getOriginPicInfo();
                        Intrinsics.checkNotNull(originPicInfo2);
                        int height = originPicInfo2.getHeight();
                        RFWLayerPicInfo layerPicInfo6 = itemInfo.getLayerPicInfo();
                        Intrinsics.checkNotNull(layerPicInfo6);
                        RFWLayerPicInfo.RFWPicInfo originPicInfo3 = layerPicInfo6.getOriginPicInfo();
                        Intrinsics.checkNotNull(originPicInfo3);
                        if (qQLayerUtil.checkFileThumbOverSize(width, height, originPicInfo3.getSize())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    /* renamed from: addWhiteColorFilter, reason: from getter */
    public boolean getAddWhiteColorFilter() {
        return this.addWhiteColorFilter;
    }

    public /* synthetic */ boolean clickPicCloseHost() {
        return a.b(this);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    public boolean disableRotate(@NotNull RFWLayerItemMediaInfo itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        return this.layerRotateDisabled;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    public void doOnVisible(@NotNull RFWLayerItemMediaInfo itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        if (itemInfo.isVideo()) {
            QQToastUtil.showQQToast(1, R.string.f221396ap);
        } else if (!isLargePicError(itemInfo)) {
            if (RFWNetworkUtils.isNetworkAvailable(getContext())) {
                QQToastUtil.showQQToast(1, R.string.f221376an);
            } else {
                QQToastUtil.showQQToast(1, "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            }
        }
    }

    public /* synthetic */ boolean enableAutoMagnifyExternalSmallPic() {
        return a.d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Drawable getErrorDrawable(int drawableId) {
        Drawable tintDrawableSafely = QQLayerUtil.INSTANCE.tintDrawableSafely(ResourcesCompat.getDrawable(getActivity().getResources(), drawableId, null), Color.parseColor("#4D4D4D"));
        Intrinsics.checkNotNull(tintDrawableSafely);
        return tintDrawableSafely;
    }

    @NotNull
    public Drawable getLoadingDrawable() {
        Drawable loadingDrawable = LoadingUtil.getLoadingDrawable(getContext(), 1);
        Intrinsics.checkNotNullExpressionValue(loadingDrawable, "getLoadingDrawable(conte\u2026gType.LOADING_TYPE_WHITE)");
        return loadingDrawable;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    @NotNull
    public SizeFormat getSizeFormat() {
        if (this.isForceUseGE) {
            return SizeFormat.GE;
        }
        if (this.isForceUseLE) {
            return SizeFormat.LE;
        }
        return SizeFormat.LE;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    @NotNull
    public SwitchUrlType getSwitchUrlType() {
        return SwitchUrlType.IMMEDIATELY;
    }

    /* renamed from: isSupportMagnifyLongPic, reason: from getter */
    public boolean getIsSupportMagnifyLongPic() {
        return this.isSupportMagnifyLongPic;
    }

    public boolean isSupportRegionScale(@NotNull Option option, @NotNull RFWLayerItemMediaInfo itemInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        Pair<Integer, Integer> originPicWidthAndHeight = QQLayerUtil.INSTANCE.getOriginPicWidthAndHeight(option, itemInfo);
        if (originPicWidthAndHeight.getFirst().intValue() <= ImmersiveUtils.getScreenWidth() * 1.2f && originPicWidthAndHeight.getSecond().intValue() <= ImmersiveUtils.getScreenHeight() * 1.2f) {
            z16 = false;
        } else {
            z16 = true;
        }
        RFWLog.i("QQMediaStrategyPart", RFWLog.USR, " isBigPic:" + z16 + " originSize:" + originPicWidthAndHeight + " width:" + option.getResultBitMap().getWidth() + " height:" + option.getResultBitMap().getHeight());
        if (!z16 || !this.isSupportRegionScale || Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return true;
    }

    @Nullable
    public ErrorUIConfig needShowErrorUI(@NotNull RFWLayerItemMediaInfo itemInfo, @Nullable InnerErrorInfo innerErrorInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        if ((itemInfo.getInvalid() && TextUtils.isEmpty(itemInfo.getExistSaveOrEditPath())) || (!itemInfo.isVideo() && innerErrorInfo != null)) {
            z16 = true;
        } else {
            z16 = false;
        }
        SimpleEventBus.getInstance().dispatchEvent(new HideSaveView(itemInfo.getMediaId(), z16));
        if (itemInfo.isVideo()) {
            if (itemInfo.getInvalid() && TextUtils.isEmpty(itemInfo.getExistSaveOrEditPath())) {
                Drawable errorDrawable = getErrorDrawable(R.drawable.qui_caution_circle_icon_secondary);
                String string = getActivity().getResources().getString(R.string.f238137iy);
                Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026g(R.string.video_expired)");
                return new ErrorUIConfig(errorDrawable, string);
            }
            if (innerErrorInfo == null) {
                return null;
            }
            return new ErrorUIConfig(getErrorDrawable(R.drawable.qui_caution_circle_icon_secondary), buildVideoErrorToast(innerErrorInfo));
        }
        if (itemInfo.getInvalid() && TextUtils.isEmpty(itemInfo.getExistSaveOrEditPath())) {
            Drawable errorDrawable2 = getErrorDrawable(R.drawable.qui_caution_circle_icon_secondary);
            String string2 = getActivity().getResources().getString(R.string.f174452vw);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getString(R.string.pic_expired)");
            return new ErrorUIConfig(errorDrawable2, string2);
        }
        if (isLargePicError(itemInfo) && TextUtils.isEmpty(itemInfo.getExistSaveOrEditPath())) {
            Drawable errorDrawable3 = getErrorDrawable(R.drawable.qui_image_aio_oversized_icon_aio_toolbar_normal);
            String string3 = getActivity().getResources().getString(R.string.f221386ao);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.resources.getSt\u2026ayer_pic_invalid_too_big)");
            return new ErrorUIConfig(errorDrawable3, string3);
        }
        if (innerErrorInfo == null) {
            return null;
        }
        Drawable errorDrawable4 = getErrorDrawable(R.drawable.qui_image_broken);
        String string4 = getActivity().getResources().getString(R.string.f221506b0);
        Intrinsics.checkNotNullExpressionValue(string4, "activity.resources.getSt\u2026ing.rich_media_load_fail)");
        return new ErrorUIConfig(errorDrawable4, string4);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerIOCUtil.registerPicShowStrategyProvider(rootView, this);
    }

    /* renamed from: useBitmapConfig8888, reason: from getter */
    public boolean getUseRGB8888() {
        return this.useRGB8888;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaShowStrategyProvider
    public boolean useSoftLayerType() {
        if (this.isForceSoftLayer) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 26 && this.isAndroidNSupportSoftwareLayerType) {
            return true;
        }
        return false;
    }
}
