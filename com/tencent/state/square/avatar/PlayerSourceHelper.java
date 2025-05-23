package com.tencent.state.square.avatar;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.state.service.ImageService;
import com.tencent.state.service.UniqueImageDisplayer;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.Size;
import com.tencent.state.square.media.SquareMedia;
import com.tencent.state.square.media.SquarePlayerReportConst;
import com.tencent.state.utils.DrawableUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001(B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002JR\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00182$\b\u0002\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\"\u0010\u001e\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u0004J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0006H\u0002J!\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010&J\"\u0010'\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/square/avatar/PlayerSourceHelper;", "", "()V", "TAG", "", "mapZoomLevel", "", "getMapZoomLevel", "()I", "setMapZoomLevel", "(I)V", "scaleLevel", "", "getScaleLevel", "()F", "displayAvatarCover", "", "source", "Lcom/tencent/state/square/media/MapPlayableSource;", "imageView", "Landroid/widget/ImageView;", "displayImage", LayoutAttrDefine.CLICK_URI, "options", "Lcom/nostra13/universalimageloader/core/DisplayImageOptions;", "completion", "Lkotlin/Function3;", "", "showSize", "Lcom/tencent/state/square/media/Size;", IPrefRecorder.MILESTONE_EXTRACT_COVER, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "getDisplayImageOptions", "url", "defaultSource", "getShowSize", "Lcom/nostra13/universalimageloader/core/assist/ImageSize;", "minScale", "(Lcom/tencent/state/square/media/Size;Ljava/lang/Float;)Lcom/nostra13/universalimageloader/core/assist/ImageSize;", "setStaticImage", "ImageLoadListener", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PlayerSourceHelper {
    private static final String TAG = "PlayerSourceHelper";
    public static final PlayerSourceHelper INSTANCE = new PlayerSourceHelper();
    private static int mapZoomLevel = 3;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\tJ$\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/avatar/PlayerSourceHelper$ImageLoadListener;", "Lcom/nostra13/universalimageloader/core/listener/SimpleImageLoadingListener;", LayoutAttrDefine.CLICK_URI, "", "completion", "Lkotlin/Function3;", "", "Landroid/widget/ImageView;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "onLoadingComplete", "imageUri", "view", "Landroid/view/View;", "loadedImage", "Landroid/graphics/Bitmap;", "onLoadingFailed", "failReason", "Lcom/nostra13/universalimageloader/core/assist/FailReason;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class ImageLoadListener extends SimpleImageLoadingListener {
        private final Function3<String, Boolean, ImageView, Unit> completion;
        private final String uri;

        public /* synthetic */ ImageLoadListener(String str, Function3 function3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : function3);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            boolean startsWith$default;
            Map<String, Object> mutableMapOf;
            Intrinsics.checkNotNullParameter(imageUri, "imageUri");
            Function3<String, Boolean, ImageView, Unit> function3 = this.completion;
            if (function3 != null) {
                Boolean bool = Boolean.TRUE;
                if (!(view instanceof ImageView)) {
                    view = null;
                }
                function3.invoke(imageUri, bool, (ImageView) view);
            }
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(imageUri, "/", false, 2, null);
            int i3 = startsWith$default ? 1 : 2;
            IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquarePlayerReportConst.PARAM_COVER_FROM, Integer.valueOf(i3)));
            reporter.reportEvent(SquarePlayerReportConst.EVENT_COVER_FROM, mutableMapOf);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
            Intrinsics.checkNotNullParameter(imageUri, "imageUri");
            SquareBaseKt.getSquareLog().d(PlayerSourceHelper.TAG, "play item cover loaded failed:" + this.uri);
            Function3<String, Boolean, ImageView, Unit> function3 = this.completion;
            if (function3 != null) {
                Boolean bool = Boolean.FALSE;
                if (!(view instanceof ImageView)) {
                    view = null;
                }
                function3.invoke(imageUri, bool, (ImageView) view);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ImageLoadListener(String uri, Function3<? super String, ? super Boolean, ? super ImageView, Unit> function3) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
            this.completion = function3;
        }
    }

    PlayerSourceHelper() {
    }

    private final void displayAvatarCover(MapPlayableSource source, ImageView imageView) {
        imageView.setTag(source.getCoverUrl());
        displayImage$default(this, source.getCoverUrl(), imageView, getDisplayImageOptions(source.getCoverUrl(), source.getDefaultResourceId()), null, source.getShowSize(), 8, null);
    }

    private final float getScaleLevel() {
        int i3 = mapZoomLevel;
        if (i3 == 0) {
            return 0.4f;
        }
        if (i3 == 1) {
            return 0.5f;
        }
        if (i3 == 2) {
            return 0.6f;
        }
        if (i3 != 3) {
            return i3 != 4 ? 0.6f : 0.8f;
        }
        return 0.7f;
    }

    public final void extractCover(ImageView imageView, MapPlayableSource source, String uniqueId) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        SquareBaseKt.getSquareThread().postOnFileThread(new PlayerSourceHelper$extractCover$1(source, uniqueId, imageView));
    }

    public final int getMapZoomLevel() {
        return mapZoomLevel;
    }

    public final ImageSize getShowSize(Size showSize, Float minScale) {
        float scaleLevel;
        Intrinsics.checkNotNullParameter(showSize, "showSize");
        if (showSize.getWidth() == 0 || showSize.getHeight() == 0) {
            return null;
        }
        if (minScale != null) {
            scaleLevel = RangesKt___RangesKt.coerceAtLeast(minScale.floatValue(), getScaleLevel());
        } else {
            scaleLevel = getScaleLevel();
        }
        return new ImageSize((int) (showSize.getWidth() * scaleLevel), (int) (showSize.getHeight() * scaleLevel));
    }

    public final void setMapZoomLevel(int i3) {
        mapZoomLevel = i3;
    }

    public final void setStaticImage(ImageView imageView, MapPlayableSource source, String r85) {
        boolean isBlank;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(r85, "uniqueId");
        if (source != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(source.getCoverUrl());
            if (!isBlank) {
                displayAvatarCover(source, imageView);
                return;
            }
            SquareMedia.INSTANCE.getDownloader().addNormalTask(source.getMediaSource(), new DynamicSourceDownloadCallback(imageView, source, DrawableUtil.INSTANCE.getDrawable(source.getDefaultResourceId())));
            IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquarePlayerReportConst.PARAM_COVER_FROM, 4));
            reporter.reportEvent(SquarePlayerReportConst.EVENT_COVER_FROM, mutableMapOf);
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageDrawable(null);
    }

    private final DisplayImageOptions getDisplayImageOptions(String url, int defaultSource) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "/", false, 2, null);
        if (startsWith$default) {
            DisplayImageOptions build = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).displayer(new UniqueImageDisplayer(url)).build();
            Intrinsics.checkNotNullExpressionValue(build, "DisplayImageOptions.Buil\u2026\n                .build()");
            return build;
        }
        DisplayImageOptions build2 = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).showImageForEmptyUri(defaultSource).showImageOnFail(defaultSource).displayer(new UniqueImageDisplayer(url)).build();
        Intrinsics.checkNotNullExpressionValue(build2, "DisplayImageOptions.Buil\u2026\n                .build()");
        return build2;
    }

    public static /* synthetic */ void extractCover$default(PlayerSourceHelper playerSourceHelper, ImageView imageView, MapPlayableSource mapPlayableSource, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "";
        }
        playerSourceHelper.extractCover(imageView, mapPlayableSource, str);
    }

    public static /* synthetic */ void setStaticImage$default(PlayerSourceHelper playerSourceHelper, ImageView imageView, MapPlayableSource mapPlayableSource, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "";
        }
        playerSourceHelper.setStaticImage(imageView, mapPlayableSource, str);
    }

    public static /* synthetic */ ImageSize getShowSize$default(PlayerSourceHelper playerSourceHelper, Size size, Float f16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f16 = null;
        }
        return playerSourceHelper.getShowSize(size, f16);
    }

    private final void displayImage(String r95, ImageView imageView, DisplayImageOptions options, Function3<? super String, ? super Boolean, ? super ImageView, Unit> completion, Size showSize) {
        ImageSize showSize$default = (imageView == null || showSize == null) ? null : getShowSize$default(this, showSize, null, 2, null);
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("imageSize = ");
            sb5.append(mapZoomLevel);
            sb5.append(',');
            sb5.append(getScaleLevel());
            sb5.append(',');
            sb5.append(showSize$default != null ? Integer.valueOf(showSize$default.getWidth()) : null);
            sb5.append('~');
            sb5.append(showSize$default != null ? Integer.valueOf(showSize$default.getHeight()) : null);
            squareLog.i(TAG, sb5.toString());
        }
        if (showSize$default != null) {
            ImageLoader loader = ImageService.INSTANCE.getLoader();
            if (loader != null) {
                loader.displayImage(r95, new ImageViewAware(imageView), options, showSize$default, new ImageLoadListener(r95, completion), null);
                return;
            }
            return;
        }
        ImageLoader loader2 = ImageService.INSTANCE.getLoader();
        if (loader2 != null) {
            loader2.displayImage(r95, imageView, options, new ImageLoadListener(r95, completion));
        }
    }

    static /* synthetic */ void displayImage$default(PlayerSourceHelper playerSourceHelper, String str, ImageView imageView, DisplayImageOptions displayImageOptions, Function3 function3, Size size, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function3 = null;
        }
        playerSourceHelper.displayImage(str, imageView, displayImageOptions, function3, size);
    }
}
