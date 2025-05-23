package com.tencent.mobileqq.wink.editor.sticker;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.Size;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.StickerModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/g;", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bC\u0010DJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0007JF\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0004JF\u0010(\u001a\u00020\u00072\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010\u00182\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J,\u0010)\u001a\u00020\u00072\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010*\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u0010/\u001a\u00020.8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020.8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u00100R\u0014\u00102\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u0002048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b7\u00106R\u0014\u00108\u001a\u0002048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0014\u00109\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b9\u0010+R\u0014\u0010:\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b:\u0010+R\u0014\u0010;\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u0010+R\u0014\u0010<\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b<\u0010+R\u0014\u0010=\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b=\u0010+R\u0014\u0010>\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b>\u0010+R\u0014\u0010?\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b?\u0010+R\u0014\u0010@\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b@\u0010+R\u0014\u0010A\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bA\u0010+R\u0014\u0010B\u001a\u00020#8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bB\u0010+\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/g$a;", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "stickerModel", "", "topLine", "bottomLine", "", "d", "", "points", "c", "b", "Landroid/graphics/Matrix;", "matrix", HippyTKDListViewAdapter.X, "y", "Landroid/graphics/PointF;", "a", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCut", "forceUpdate", "", tl.h.F, "Lcom/tencent/videocut/model/MediaModel;", "mediaModel", "originScaleX", "originScaley", "originTopY", "originWidth", "originHeight", "isStretched", "ratio", "g", "", "", "stickerModels", "video", "renderWidthLocal", "renderHeightLocal", "f", "e", "CUSTOM_STICKER_ID", "Ljava/lang/String;", "EFFECT_TYPE_FACE", "EFFECT_TYPE_SCREEN", "", "PROGRESS_PROPORTION_FONT_FILE", "D", "PROGRESS_PROPORTION_PAG_ZIP", "STICKER_1DP", UserInfo.SEX_FEMALE, "", "STICKER_CUSTOM_WIDTH", "I", "STICKER_MAX_HEIGHT", "STICKER_QQ_EMOTION_WIDTH", "STICKER_TYPE_APNG", "STICKER_TYPE_COMMON", "STICKER_TYPE_CUSTOM", "STICKER_TYPE_DATASOURCE", "STICKER_TYPE_FIX_TEXT", "STICKER_TYPE_GIF", "STICKER_TYPE_MASK", "STICKER_TYPE_TEXT", "STIKCER_PRE_FIX", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.g$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final PointF a(Matrix matrix, float r46, float y16) {
            float[] fArr = {r46, y16};
            matrix.mapPoints(fArr);
            return new PointF(fArr[0], fArr[1]);
        }

        private final float b(float[] points) {
            if (points == null) {
                return 0.0f;
            }
            float f16 = -2.14748365E9f;
            for (float f17 : points) {
                f16 = Math.max(f17, f16);
            }
            return f16;
        }

        private final float c(float[] points) {
            if (points == null) {
                return 0.0f;
            }
            float f16 = 2.14748365E9f;
            for (float f17 : points) {
                f16 = Math.min(f17, f16);
            }
            return f16;
        }

        private final boolean d(WinkStickerModel stickerModel, float topLine, float bottomLine) {
            float f16 = stickerModel.getCenterInView().f320587x;
            float f17 = stickerModel.getCenterInView().f320588y;
            Matrix matrix = new Matrix();
            matrix.setRotate(stickerModel.rotate * (-1.0f), f16, f17);
            float[] fArr = {a(matrix, stickerModel.getClickBoundsLeftTopInView().f320587x, stickerModel.getClickBoundsRightBottomInView().f320588y).y, a(matrix, stickerModel.getClickBoundsLeftTopInView().f320587x, stickerModel.getClickBoundsLeftTopInView().f320588y).y, a(matrix, stickerModel.getClickBoundsRightBottomInView().f320587x, stickerModel.getClickBoundsRightBottomInView().f320588y).y, a(matrix, stickerModel.getClickBoundsRightBottomInView().f320587x, stickerModel.getClickBoundsLeftTopInView().f320588y).y};
            float c16 = c(fArr);
            float b16 = b(fArr);
            w53.b.a("StickerUtils", "isStickersOutside topLine:" + topLine + ", bottomLine:" + bottomLine + ", topY:" + c16 + ", bottomY:" + b16);
            float f18 = (float) 2;
            if (c16 + f18 >= topLine && b16 - f18 <= bottomLine) {
                return false;
            }
            return true;
        }

        public static /* synthetic */ void i(Companion companion, dr drVar, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            companion.h(drVar, z16);
        }

        private static final float j(RectF rectF) {
            return Math.abs(((rectF.right - rectF.left) * 1.0f) / (rectF.bottom - rectF.top));
        }

        private static final float k(SizeF sizeF) {
            return Math.abs(sizeF.width / sizeF.height);
        }

        private static final float l(Size size) {
            Intrinsics.checkNotNull(size.width);
            float intValue = r0.intValue() * 1.0f;
            Intrinsics.checkNotNull(size.height);
            return Math.abs(intValue / r2.intValue());
        }

        public final boolean e(@Nullable Map<String, ? extends WinkStickerModel> stickerModels, float topLine, float bottomLine) {
            boolean z16;
            boolean z17 = true;
            if (stickerModels != null && (!stickerModels.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Iterator<Map.Entry<String, ? extends WinkStickerModel>> it = stickerModels.entrySet().iterator();
                while (it.hasNext()) {
                    if (d(it.next().getValue(), topLine, bottomLine)) {
                        break;
                    }
                }
            }
            z17 = false;
            w53.b.f("StickerUtils", "isStickersOutside " + z17);
            return z17;
        }

        public final boolean f(@Nullable Map<String, ? extends WinkStickerModel> stickerModels, @Nullable MediaModel video, float renderWidthLocal, float renderHeightLocal, float topLine, float bottomLine) {
            List<MediaClip> list;
            Object orNull;
            ResourceModel resourceModel;
            RectF rectF;
            if (stickerModels != null && !stickerModels.isEmpty()) {
                if (video != null && (list = video.videos) != null) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
                    MediaClip mediaClip = (MediaClip) orNull;
                    if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (rectF = resourceModel.picClipRect) != null) {
                        float f16 = rectF.top;
                        float f17 = rectF.bottom;
                        float f18 = f17 - f16;
                        float f19 = renderHeightLocal / renderWidthLocal;
                        float f26 = rectF.right;
                        float f27 = rectF.left;
                        if (f19 > (f17 - f16) / (f26 - f27)) {
                            float f28 = (renderWidthLocal / (f26 - f27)) * f18;
                            float f29 = 2;
                            float f36 = renderHeightLocal / f29;
                            float f37 = f28 / f29;
                            f16 = f36 - f37;
                            renderHeightLocal = f36 + f37;
                        } else if (f19 <= (f17 - f16) / (f26 - f27)) {
                            f16 = 0.0f;
                        } else {
                            renderHeightLocal = f17;
                        }
                        topLine = RangesKt___RangesKt.coerceAtLeast(f16, topLine);
                        bottomLine = RangesKt___RangesKt.coerceAtMost(renderHeightLocal, bottomLine);
                    }
                }
                Iterator<Map.Entry<String, ? extends WinkStickerModel>> it = stickerModels.entrySet().iterator();
                while (it.hasNext()) {
                    if (d(it.next().getValue(), topLine, bottomLine)) {
                        return true;
                    }
                }
            }
            return false;
        }

        @NotNull
        public final MediaModel g(@NotNull MediaModel mediaModel, float originScaleX, float originScaley, float originTopY, float originWidth, float originHeight, boolean isStretched, float ratio) {
            BackgroundModel backgroundModel;
            MediaModel copy;
            Float f16;
            SizeF sizeF;
            SizeF sizeF2;
            BackgroundModel copy2;
            Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, StickerModel> entry : mediaModel.stickers.entrySet()) {
                String key = entry.getKey();
                StickerModel value = entry.getValue();
                if (isStretched) {
                    float f17 = (originHeight / originWidth) / ratio;
                    float f18 = value.scaleX / f17;
                    float f19 = value.scaleY / f17;
                    float f26 = value.centerY / f17;
                    if (value instanceof WinkStickerModel) {
                        WinkStickerModel winkStickerModel = (WinkStickerModel) value;
                        linkedHashMap.put(key, WinkStickerModel.copyAndUpdate$default(winkStickerModel, null, null, 0L, 0L, 0, f18, f19, 0.0f, 0.0f, f26, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, new com.tencent.mobileqq.wink.editor.model.PointF(winkStickerModel.getOriginPointInView().f320587x, originTopY), null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -609, 1048571, null));
                    } else {
                        linkedHashMap.put(key, StickerModel.copy$default(value, null, null, 0L, 0L, 0, f19, f19, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, null, -97, 1, null));
                    }
                } else {
                    float f27 = value.scaleX / originScaleX;
                    float f28 = value.scaleY / originScaley;
                    float f29 = value.centerY / originScaley;
                    if (value instanceof WinkStickerModel) {
                        WinkStickerModel winkStickerModel2 = (WinkStickerModel) value;
                        linkedHashMap.put(key, WinkStickerModel.copyAndUpdate$default(winkStickerModel2, null, null, 0L, 0L, 0, f27 / winkStickerModel2.getPostCropScale(), f28 / winkStickerModel2.getPostCropScale(), 0.0f, 0.0f, f29 + winkStickerModel2.getPostCropTranslateY(), false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, 0.0f, 0.0f, new com.tencent.mobileqq.wink.editor.model.PointF(winkStickerModel2.getOriginPointInView().f320587x, originTopY), null, null, null, null, null, null, null, null, null, false, null, null, false, 0.0f, 0.0f, null, false, -609, 1048571, null));
                    } else {
                        linkedHashMap.put(key, StickerModel.copy$default(value, null, null, 0L, 0L, 0, f28, f28, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, null, -97, 1, null));
                    }
                }
            }
            BackgroundModel backgroundModel2 = mediaModel.backgroundModel;
            Float f36 = null;
            if (backgroundModel2 != null) {
                copy2 = backgroundModel2.copy((r24 & 1) != 0 ? backgroundModel2.id : null, (r24 & 2) != 0 ? backgroundModel2.renderSize : com.tencent.mobileqq.wink.editor.model.a.d(mediaModel.videos, originWidth, originHeight), (r24 & 4) != 0 ? backgroundModel2.bgFillMode : null, (r24 & 8) != 0 ? backgroundModel2.bgColor : null, (r24 & 16) != 0 ? backgroundModel2.bgPagPath : null, (r24 & 32) != 0 ? backgroundModel2.ratioType : null, (r24 & 64) != 0 ? backgroundModel2.resPack : null, (r24 & 128) != 0 ? backgroundModel2.categoryId : null, (r24 & 256) != 0 ? backgroundModel2.fillScale : 0.0f, (r24 & 512) != 0 ? backgroundModel2.imageEffect : 0, (r24 & 1024) != 0 ? backgroundModel2.unknownFields() : null);
                backgroundModel = copy2;
            } else {
                backgroundModel = null;
            }
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : null, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : linkedHashMap, (r39 & 512) != 0 ? mediaModel.backgroundModel : backgroundModel, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            BackgroundModel backgroundModel3 = copy.backgroundModel;
            if (backgroundModel3 != null && (sizeF2 = backgroundModel3.renderSize) != null) {
                f16 = Float.valueOf(sizeF2.width);
            } else {
                f16 = null;
            }
            BackgroundModel backgroundModel4 = copy.backgroundModel;
            if (backgroundModel4 != null && (sizeF = backgroundModel4.renderSize) != null) {
                f36 = Float.valueOf(sizeF.height);
            }
            ms.a.f("StickerUtils", "unstretchMediaModel :newModel = " + f16 + ", " + f36);
            return copy;
        }

        public final void h(@NotNull dr tavCut, boolean z16) {
            Integer num;
            Size renderSize;
            Integer num2;
            Integer num3;
            int collectionSizeOrDefault;
            float f16;
            BackgroundModel copy;
            MediaModel copy2;
            WinkVideoTavCut winkVideoTavCut;
            float k3;
            RectF rectF;
            ResourceModel copy3;
            Intrinsics.checkNotNullParameter(tavCut, "tavCut");
            try {
                MediaModel V = tavCut.V();
                Size a16 = tavCut.a();
                Integer num4 = a16.width;
                if (num4 != null) {
                    Intrinsics.checkNotNull(num4);
                    if (num4.intValue() != 0 && (num = a16.height) != null) {
                        Intrinsics.checkNotNull(num);
                        if (num.intValue() != 0 && (num2 = (renderSize = tavCut.getRenderSize()).width) != null) {
                            Intrinsics.checkNotNull(num2);
                            if (num2.intValue() != 0 && (num3 = renderSize.height) != null) {
                                Intrinsics.checkNotNull(num3);
                                if (num3.intValue() != 0) {
                                    if ((tavCut instanceof WinkImageTavCut) && ((WinkImageTavCut) tavCut).G()) {
                                        w53.b.f("StickerUtils", " using image template do not crop ");
                                        return;
                                    }
                                    Integer num5 = renderSize.height;
                                    Intrinsics.checkNotNull(num5);
                                    int intValue = num5.intValue();
                                    Integer num6 = a16.height;
                                    Intrinsics.checkNotNull(num6);
                                    if ((intValue > num6.intValue() && l(renderSize) > 0.0f) || z16) {
                                        Intrinsics.checkNotNull(a16.height);
                                        Intrinsics.checkNotNull(a16.width);
                                        float intValue2 = (r4.intValue() * 1.0f) / r6.intValue();
                                        SizeF sizeF = new SizeF(1280.0f / intValue2, 1280.0f, ByteString.EMPTY);
                                        List<MediaClip> list = V.videos;
                                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                        for (MediaClip mediaClip : list) {
                                            ResourceModel resourceModel = mediaClip.resource;
                                            if (resourceModel != null) {
                                                RectF rectF2 = resourceModel.picClipRect;
                                                if (rectF2 != null) {
                                                    k3 = j(rectF2);
                                                } else {
                                                    SizeF sizeF2 = resourceModel.size;
                                                    Intrinsics.checkNotNull(sizeF2);
                                                    k3 = k(sizeF2);
                                                }
                                                if (k3 < l(a16)) {
                                                    RectF rectF3 = mediaClip.resource.picClipRect;
                                                    if (rectF3 == null) {
                                                        float f17 = 2;
                                                        rectF = new RectF(0.0f, (com.tencent.videocut.render.extension.e.o(mediaClip).height - (com.tencent.videocut.render.extension.e.o(mediaClip).width * intValue2)) / f17, com.tencent.videocut.render.extension.e.o(mediaClip).width, (com.tencent.videocut.render.extension.e.o(mediaClip).height + (com.tencent.videocut.render.extension.e.o(mediaClip).width * intValue2)) / f17, null, 16, null);
                                                    } else {
                                                        float f18 = ((rectF3.bottom - rectF3.top) - ((rectF3.right - rectF3.left) * intValue2)) / 2;
                                                        RectF rectF4 = mediaClip.resource.picClipRect;
                                                        rectF = new RectF(rectF4.left, rectF4.top + f18, rectF4.right, rectF4.bottom - f18, null, 16, null);
                                                    }
                                                    copy3 = r5.copy((r35 & 1) != 0 ? r5.id : null, (r35 & 2) != 0 ? r5.path : null, (r35 & 4) != 0 ? Long.valueOf(r5.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(r5.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(r5.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(r5.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(r5.selectDuration) : null, (r35 & 128) != 0 ? r5.type : null, (r35 & 256) != 0 ? r5.size : null, (r35 & 512) != 0 ? Float.valueOf(r5.volume) : null, (r35 & 1024) != 0 ? r5.extras : null, (r35 & 2048) != 0 ? r5.picClipRect : rectF, (r35 & 4096) != 0 ? r5.reversePath : null, (r35 & 8192) != 0 ? r5.normalPath : null, (r35 & 16384) != 0 ? r5.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(r5.deblurScore) : null, (r35 & 65536) != 0 ? mediaClip.resource.unknownFields() : null);
                                                    mediaClip = MediaClip.copy$default(mediaClip, copy3, null, null, null, null, null, null, 126, null);
                                                }
                                            }
                                            arrayList.add(mediaClip);
                                        }
                                        BackgroundModel backgroundModel = V.backgroundModel;
                                        Intrinsics.checkNotNull(backgroundModel);
                                        if (sizeF.width > sizeF.height) {
                                            f16 = 1.0f;
                                        } else {
                                            f16 = 0.0f;
                                        }
                                        copy = backgroundModel.copy((r24 & 1) != 0 ? backgroundModel.id : null, (r24 & 2) != 0 ? backgroundModel.renderSize : sizeF, (r24 & 4) != 0 ? backgroundModel.bgFillMode : null, (r24 & 8) != 0 ? backgroundModel.bgColor : null, (r24 & 16) != 0 ? backgroundModel.bgPagPath : null, (r24 & 32) != 0 ? backgroundModel.ratioType : null, (r24 & 64) != 0 ? backgroundModel.resPack : null, (r24 & 128) != 0 ? backgroundModel.categoryId : null, (r24 & 256) != 0 ? backgroundModel.fillScale : f16, (r24 & 512) != 0 ? backgroundModel.imageEffect : 0, (r24 & 1024) != 0 ? backgroundModel.unknownFields() : null);
                                        copy2 = V.copy((r39 & 1) != 0 ? V.id : null, (r39 & 2) != 0 ? V.name : null, (r39 & 4) != 0 ? V.version : null, (r39 & 8) != 0 ? V.createTime : null, (r39 & 16) != 0 ? V.updateTime : null, (r39 & 32) != 0 ? V.duration : null, (r39 & 64) != 0 ? V.videos : arrayList, (r39 & 128) != 0 ? V.audios : null, (r39 & 256) != 0 ? V.stickers : null, (r39 & 512) != 0 ? V.backgroundModel : copy, (r39 & 1024) != 0 ? V.filterModels : null, (r39 & 2048) != 0 ? V.specialEffects : null, (r39 & 4096) != 0 ? V.transitions : null, (r39 & 8192) != 0 ? V.templateModel : null, (r39 & 16384) != 0 ? V.coverInfo : null, (r39 & 32768) != 0 ? V.exportSetting : null, (r39 & 65536) != 0 ? V.openHDR : null, (r39 & 131072) != 0 ? V.hdrModels : null, (r39 & 262144) != 0 ? V.smoothModels : null, (r39 & 524288) != 0 ? V.openSuperHDR : null, (r39 & 1048576) != 0 ? V.unknownFields() : null);
                                        tavCut.r(copy2);
                                        tavCut.C(a16);
                                        if (tavCut instanceof WinkVideoTavCut) {
                                            winkVideoTavCut = (WinkVideoTavCut) tavCut;
                                        } else {
                                            winkVideoTavCut = null;
                                        }
                                        if (winkVideoTavCut != null) {
                                            winkVideoTavCut.y3();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                w53.b.e("StickerUtils", e16);
            }
        }

        Companion() {
        }
    }
}
