package com.tencent.richframework.gallery.delegate.outer;

import android.graphics.drawable.Drawable;
import com.tencent.libra.request.Option;
import com.tencent.libra.request.SizeFormat;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.video.SwitchUrlType;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0003H\u0017J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH\u0017J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H\u0017J\b\u0010\u001a\u001a\u00020\u0003H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/richframework/gallery/delegate/outer/IMediaShowStrategyProvider;", "", "addWhiteColorFilter", "", "clickPicCloseHost", "disableRotate", "itemInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "doOnVisible", "", "enableAutoMagnifyExternalSmallPic", "getLoadingDrawable", "Landroid/graphics/drawable/Drawable;", "getSizeFormat", "Lcom/tencent/libra/request/SizeFormat;", "getSwitchUrlType", "Lcom/tencent/richframework/video/SwitchUrlType;", "isSupportMagnifyLongPic", "isSupportRegionScale", "option", "Lcom/tencent/libra/request/Option;", "needShowErrorUI", "Lcom/tencent/richframework/gallery/delegate/outer/ErrorUIConfig;", "innerErrorInfo", "Lcom/tencent/richframework/gallery/delegate/outer/InnerErrorInfo;", "useBitmapConfig8888", "useSoftLayerType", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface IMediaShowStrategyProvider {
    @JvmDefault
    boolean addWhiteColorFilter();

    @JvmDefault
    boolean clickPicCloseHost();

    @JvmDefault
    boolean disableRotate(@NotNull RFWLayerItemMediaInfo itemInfo);

    void doOnVisible(@NotNull RFWLayerItemMediaInfo itemInfo);

    @JvmDefault
    boolean enableAutoMagnifyExternalSmallPic();

    @NotNull
    Drawable getLoadingDrawable();

    @JvmDefault
    @NotNull
    SizeFormat getSizeFormat();

    @NotNull
    SwitchUrlType getSwitchUrlType();

    boolean isSupportMagnifyLongPic();

    boolean isSupportRegionScale(@NotNull Option option, @NotNull RFWLayerItemMediaInfo itemInfo);

    @Nullable
    ErrorUIConfig needShowErrorUI(@NotNull RFWLayerItemMediaInfo itemInfo, @Nullable InnerErrorInfo innerErrorInfo);

    @JvmDefault
    boolean useBitmapConfig8888();

    boolean useSoftLayerType();
}
