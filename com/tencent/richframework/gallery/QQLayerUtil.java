package com.tencent.richframework.gallery;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.a;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/richframework/gallery/QQLayerUtil;", "", "Landroid/graphics/drawable/Drawable;", "sourceDrawable", "", "color", "tintDrawableSafely", "picWidth", "picHeight", "", "picFileSize", "", "checkFileThumbOverSize", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "data", "Lkotlin/Pair;", "getOriginPicWidthAndHeight", "getCurrentPicWidthAndHeight", "<init>", "()V", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QQLayerUtil {

    @NotNull
    public static final QQLayerUtil INSTANCE = new QQLayerUtil();

    QQLayerUtil() {
    }

    public final boolean checkFileThumbOverSize(int picWidth, int picHeight, long picFileSize) {
        int coerceAtLeast;
        if (picWidth * picHeight < 350000000) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(picWidth, picHeight);
            if (coerceAtLeast > 30000 || picFileSize >= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Pair<Integer, Integer> getCurrentPicWidthAndHeight(@NotNull Option option, @NotNull RFWLayerItemMediaInfo data) {
        int i3;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo2;
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(data, "data");
        Pair<Integer, Integer> g16 = a.f118813a.g(option);
        if (g16.getFirst().intValue() != 0 && g16.getSecond().intValue() != 0) {
            return g16;
        }
        RFWLayerPicInfo layerPicInfo = data.getLayerPicInfo();
        int i16 = 0;
        if (layerPicInfo != null && (currentPicInfo2 = layerPicInfo.getCurrentPicInfo()) != null) {
            i3 = currentPicInfo2.getWidth();
        } else {
            i3 = 0;
        }
        Integer valueOf = Integer.valueOf(i3);
        RFWLayerPicInfo layerPicInfo2 = data.getLayerPicInfo();
        if (layerPicInfo2 != null && (currentPicInfo = layerPicInfo2.getCurrentPicInfo()) != null) {
            i16 = currentPicInfo.getHeight();
        }
        return new Pair<>(valueOf, Integer.valueOf(i16));
    }

    @NotNull
    public final Pair<Integer, Integer> getOriginPicWidthAndHeight(@NotNull Option option, @NotNull RFWLayerItemMediaInfo data) {
        int i3;
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        RFWLayerPicInfo.RFWPicInfo originPicInfo2;
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(data, "data");
        Pair<Integer, Integer> g16 = a.f118813a.g(option);
        if (g16.getFirst().intValue() != 0 && g16.getSecond().intValue() != 0) {
            return g16;
        }
        RFWLayerPicInfo layerPicInfo = data.getLayerPicInfo();
        int i16 = 0;
        if (layerPicInfo != null && (originPicInfo2 = layerPicInfo.getOriginPicInfo()) != null) {
            i3 = originPicInfo2.getWidth();
        } else {
            i3 = 0;
        }
        Integer valueOf = Integer.valueOf(i3);
        RFWLayerPicInfo layerPicInfo2 = data.getLayerPicInfo();
        if (layerPicInfo2 != null && (originPicInfo = layerPicInfo2.getOriginPicInfo()) != null) {
            i16 = originPicInfo.getHeight();
        }
        return new Pair<>(valueOf, Integer.valueOf(i16));
    }

    @Nullable
    public final Drawable tintDrawableSafely(@Nullable Drawable sourceDrawable, @ColorInt int color) {
        if (sourceDrawable != null && color != 0) {
            Drawable mutate = sourceDrawable.mutate();
            if (mutate instanceof SkinnableBitmapDrawable) {
                mutate = ((SkinnableBitmapDrawable) mutate).mutate2();
            }
            if (mutate != null) {
                mutate.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            }
            return mutate;
        }
        return null;
    }
}
