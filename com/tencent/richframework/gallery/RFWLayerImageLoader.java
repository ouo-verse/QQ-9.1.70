package com.tencent.richframework.gallery;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/richframework/gallery/RFWLayerImageLoader;", "", "()V", "getExtraData", "", "", "data", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "picType", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$PicType;", "getReqOption", "Lcom/tencent/libra/request/Option;", "view", "Landroid/widget/ImageView;", "decodeFormat", "Lcom/tencent/libra/request/DecodeFormat;", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerImageLoader {

    @NotNull
    public static final RFWLayerImageLoader INSTANCE = new RFWLayerImageLoader();

    RFWLayerImageLoader() {
    }

    @JvmStatic
    @NotNull
    public static final Map<String, Object> getExtraData(@NotNull RFWLayerItemMediaInfo data, @NotNull RFWLayerPicInfo.PicType picType) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(picType, "picType");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Object extraData = data.getExtraData();
        if (extraData != null) {
            concurrentHashMap.put(WadlProxyConsts.EXTRA_DATA, extraData);
        }
        if (!TextUtils.isEmpty(data.getMediaId())) {
            String mediaId = data.getMediaId();
            Intrinsics.checkNotNull(mediaId);
            concurrentHashMap.put("id", mediaId);
        }
        concurrentHashMap.put("picType", picType.toString());
        return concurrentHashMap;
    }

    @JvmStatic
    @NotNull
    public static final Option getReqOption(@NotNull RFWLayerItemMediaInfo data, @NotNull ImageView view, @NotNull DecodeFormat decodeFormat) {
        RFWLayerPicInfo.PicType picType;
        RFWLayerPicInfo.PicType picType2;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(decodeFormat, "decodeFormat");
        RFWLayerPicInfo layerPicInfo = data.getLayerPicInfo();
        Intrinsics.checkNotNull(layerPicInfo);
        Option targetView = Option.obtain().setUrl(layerPicInfo.getCurrentPicInfo().getUrl()).setLocalPath(layerPicInfo.getCurrentPicInfo().getLocalPath()).setPreferDecodeFormat(decodeFormat).setNeedShowLoadingDrawable(false).setTargetView(view);
        if (data.isShowOriginPic()) {
            picType = RFWLayerPicInfo.PicType.ORIGIN;
        } else {
            picType = RFWLayerPicInfo.PicType.LARGE;
        }
        Option reqOption = targetView.setExtraData(getExtraData(data, picType));
        reqOption.disableHardwareDecode();
        if (!TextUtils.isEmpty(layerPicInfo.getPicId())) {
            Intrinsics.checkNotNullExpressionValue(reqOption, "reqOption");
            LibraGroupKey libraGroupKey = new LibraGroupKey(layerPicInfo.getPicId());
            libraGroupKey.setCacheStrategy(LibraGroupKey.CacheStrategy.HIGHEST);
            Unit unit = Unit.INSTANCE;
            reqOption.setGroupKey(libraGroupKey);
        }
        if (TextUtils.isEmpty(layerPicInfo.getCurrentPicInfo().getUrl()) && !TextUtils.isEmpty(layerPicInfo.getPicId())) {
            Intrinsics.checkNotNullExpressionValue(reqOption, "reqOption");
            String picId = layerPicInfo.getPicId();
            if (data.isShowOriginPic()) {
                picType2 = RFWLayerPicInfo.PicType.ORIGIN;
            } else {
                picType2 = RFWLayerPicInfo.PicType.LARGE;
            }
            reqOption.setPathKey(new LibraDownloadKey(Intrinsics.stringPlus(picId, picType2)));
        }
        RFWLayerPicInfo.RFWPicInfo smallPicInfo = layerPicInfo.getSmallPicInfo();
        if (data.isShowOriginPic() && layerPicInfo.getBigPicInfo() != null) {
            smallPicInfo = layerPicInfo.getBigPicInfo();
        }
        if (smallPicInfo != null && smallPicInfo != layerPicInfo.getCurrentPicInfo() && view.getDrawable() == null) {
            Option thumbOption = Option.obtain().setUrl(smallPicInfo.getUrl()).setLocalPath(smallPicInfo.getLocalPath()).setNeedShowLoadingDrawable(false).setNeedShowFailedDrawable(false).setExtraData(getExtraData(data, RFWLayerPicInfo.PicType.THUMB));
            if (smallPicInfo == layerPicInfo.getSmallPicInfo()) {
                Intrinsics.checkNotNullExpressionValue(thumbOption, "thumbOption");
                thumbOption.setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(smallPicInfo.getLocalPath())).build());
            }
            Intrinsics.checkNotNullExpressionValue(reqOption, "reqOption");
            reqOption.setThumbnailOption(thumbOption);
        }
        Intrinsics.checkNotNullExpressionValue(reqOption, "reqOption");
        return reqOption;
    }
}
