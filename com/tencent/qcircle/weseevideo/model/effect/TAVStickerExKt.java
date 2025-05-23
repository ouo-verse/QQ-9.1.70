package com.tencent.qcircle.weseevideo.model.effect;

import android.os.Bundle;
import com.tencent.qcircle.weseevideo.editor.sticker.constant.WsStickerConstant;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\",\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\",\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\".\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007\",\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007\"\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005\"\u0015\u0010\u0013\u001a\u00020\u0014*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005\u00a8\u0006\u0019"}, d2 = {"value", "", "extraFontId", "Lcom/tencent/tavsticker/model/TAVSticker;", "getExtraFontId", "(Lcom/tencent/tavsticker/model/TAVSticker;)Ljava/lang/String;", "setExtraFontId", "(Lcom/tencent/tavsticker/model/TAVSticker;Ljava/lang/String;)V", "extraMaterialId", "getExtraMaterialId", "setExtraMaterialId", "extraStickerType", "getExtraStickerType", "setExtraStickerType", "extraSubCategory", "getExtraSubCategory", "setExtraSubCategory", "reportLocation", "getReportLocation", "reportStickerType", "", "getReportStickerType", "(Lcom/tencent/tavsticker/model/TAVSticker;)I", "reportTextColor", "getReportTextColor", "libtavcut_debug"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class TAVStickerExKt {
    @Nullable
    public static final String getExtraFontId(@NotNull TAVSticker extraFontId) {
        Intrinsics.checkParameterIsNotNull(extraFontId, "$this$extraFontId");
        return extraFontId.getExtraBundle().getString(WsStickerConstant.KEY_EXTRA_FONT_ID);
    }

    @Nullable
    public static final String getExtraMaterialId(@NotNull TAVSticker extraMaterialId) {
        Intrinsics.checkParameterIsNotNull(extraMaterialId, "$this$extraMaterialId");
        return extraMaterialId.getExtraBundle().getString("key_extra_material_id");
    }

    @Nullable
    public static final String getExtraStickerType(@Nullable TAVSticker tAVSticker) {
        Bundle extraBundle;
        if (tAVSticker != null && (extraBundle = tAVSticker.getExtraBundle()) != null) {
            return extraBundle.getString("key_extra_sticker_type");
        }
        return null;
    }

    @Nullable
    public static final String getExtraSubCategory(@NotNull TAVSticker extraSubCategory) {
        Intrinsics.checkParameterIsNotNull(extraSubCategory, "$this$extraSubCategory");
        return extraSubCategory.getExtraBundle().getString(WsStickerConstant.KEY_EXTRA_SUB_CATEGORY);
    }

    @NotNull
    public static final String getReportLocation(@NotNull TAVSticker reportLocation) {
        Intrinsics.checkParameterIsNotNull(reportLocation, "$this$reportLocation");
        StringBuilder sb5 = new StringBuilder();
        sb5.append('(');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(reportLocation.getCenterX())}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        sb5.append(format);
        sb5.append(',');
        String format2 = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(reportLocation.getCenterY())}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
        sb5.append(format2);
        sb5.append(')');
        return sb5.toString();
    }

    public static final int getReportStickerType(@NotNull TAVSticker reportStickerType) {
        Intrinsics.checkParameterIsNotNull(reportStickerType, "$this$reportStickerType");
        if (Intrinsics.areEqual(getExtraStickerType(reportStickerType), WsStickerConstant.StickerType.STICKER_PLAINTEXT)) {
            return 1;
        }
        if (Intrinsics.areEqual(getExtraStickerType(reportStickerType), WsStickerConstant.StickerType.STICKER_ART_TEXT)) {
            return 2;
        }
        return 0;
    }

    @Nullable
    public static final String getReportTextColor(@NotNull TAVSticker reportTextColor) {
        Object firstOrNull;
        Intrinsics.checkParameterIsNotNull(reportTextColor, "$this$reportTextColor");
        if (getExtraStickerType(reportTextColor) == null || (!Intrinsics.areEqual(r0, WsStickerConstant.StickerType.STICKER_PLAINTEXT))) {
            return "";
        }
        ArrayList<TAVStickerTextItem> stickerTextItems = reportTextColor.getStickerTextItems();
        Intrinsics.checkExpressionValueIsNotNull(stickerTextItems, "stickerTextItems");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) stickerTextItems);
        TAVStickerTextItem tAVStickerTextItem = (TAVStickerTextItem) firstOrNull;
        if (tAVStickerTextItem != null) {
            return Integer.toHexString(tAVStickerTextItem.getTextColor());
        }
        return "";
    }

    public static final void setExtraFontId(@NotNull TAVSticker extraFontId, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(extraFontId, "$this$extraFontId");
        extraFontId.getExtraBundle().putString(WsStickerConstant.KEY_EXTRA_FONT_ID, str);
    }

    public static final void setExtraMaterialId(@NotNull TAVSticker extraMaterialId, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(extraMaterialId, "$this$extraMaterialId");
        extraMaterialId.getExtraBundle().putString("key_extra_material_id", str);
    }

    public static final void setExtraStickerType(@Nullable TAVSticker tAVSticker, @Nullable String str) {
        Bundle extraBundle;
        if (tAVSticker != null && (extraBundle = tAVSticker.getExtraBundle()) != null) {
            extraBundle.putString("key_extra_sticker_type", str);
        }
    }

    public static final void setExtraSubCategory(@NotNull TAVSticker extraSubCategory, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(extraSubCategory, "$this$extraSubCategory");
        extraSubCategory.getExtraBundle().putString(WsStickerConstant.KEY_EXTRA_SUB_CATEGORY, str);
    }
}
