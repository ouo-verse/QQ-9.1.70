package com.tencent.tavcut.core.render.builder.light.model.pag;

import cooperation.qzone.QZoneShareManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\bM\b\u0086\b\u0018\u00002\u00020\u0001B\u00a9\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010 J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010B\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u0010C\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u0010\u0010D\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u0010E\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u0010\u0010F\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u0010G\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u0010H\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010J\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u0010K\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010N\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u0010\u0010O\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u00b2\u0002\u0010Y\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010ZJ\u0013\u0010[\u001a\u00020\u000f2\b\u0010\\\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010]\u001a\u00020\u0003H\u00d6\u0001J\t\u0010^\u001a\u00020\u0005H\u00d6\u0001R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010'\u001a\u0004\b(\u0010&R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b,\u0010\"R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b/\u0010\"R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b0\u0010\"R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\n\n\u0002\u0010+\u001a\u0004\b1\u0010*R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010.R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\n\n\u0002\u0010+\u001a\u0004\b3\u0010*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010'\u001a\u0004\b5\u0010&R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010'\u001a\u0004\b6\u0010&R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010.R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010'\u001a\u0004\b:\u0010&R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\n\n\u0002\u0010+\u001a\u0004\b;\u0010*R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\n\n\u0002\u0010+\u001a\u0004\b<\u0010*R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010'\u001a\u0004\b=\u0010&R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b>\u0010\"R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010'\u001a\u0004\b?\u0010&R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\n\n\u0002\u0010+\u001a\u0004\b@\u0010*\u00a8\u0006_"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/pag/TextLayerData;", "", "layerIndex", "", "layerName", "", "layerType", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "textColor", "fontFamily", "fontStyle", "layerMarkList", "", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/LayerMarkData;", "applyFill", "", "applyStroke", "baselineShift", "", "boxText", "firstBaseLine", "fauxBold", "fauxItalic", "fontSize", "strokeColor", "strokeOverFill", "stokeWidth", "justification", "leading", "tracking", "backgroundColor", "backgroundAlpha", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getApplyFill", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getApplyStroke", "getBackgroundAlpha", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBackgroundColor", "getBaselineShift", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBoxText", "getDefaultText", "()Ljava/lang/String;", "getFauxBold", "getFauxItalic", "getFirstBaseLine", "getFontFamily", "getFontSize", "getFontStyle", "getJustification", "getLayerIndex", "getLayerMarkList", "()Ljava/util/List;", "getLayerName", "getLayerType", "getLeading", "getStokeWidth", "getStrokeColor", "getStrokeOverFill", "getTextColor", "getTracking", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/tavcut/core/render/builder/light/model/pag/TextLayerData;", "equals", "other", "hashCode", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class TextLayerData {

    @Nullable
    private final Boolean applyFill;

    @Nullable
    private final Boolean applyStroke;

    @Nullable
    private final Integer backgroundAlpha;

    @Nullable
    private final Integer backgroundColor;

    @Nullable
    private final Float baselineShift;

    @Nullable
    private final Boolean boxText;

    @Nullable
    private final String defaultText;

    @Nullable
    private final Boolean fauxBold;

    @Nullable
    private final Boolean fauxItalic;

    @Nullable
    private final Float firstBaseLine;

    @Nullable
    private final String fontFamily;

    @Nullable
    private final Float fontSize;

    @Nullable
    private final String fontStyle;

    @Nullable
    private final Integer justification;

    @Nullable
    private final Integer layerIndex;

    @NotNull
    private final List<LayerMarkData> layerMarkList;

    @Nullable
    private final String layerName;

    @Nullable
    private final Integer layerType;

    @Nullable
    private final Float leading;

    @Nullable
    private final Float stokeWidth;

    @Nullable
    private final Integer strokeColor;

    @Nullable
    private final Boolean strokeOverFill;

    @Nullable
    private final Integer textColor;

    @Nullable
    private final Float tracking;

    public TextLayerData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getLayerIndex() {
        return this.layerIndex;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Boolean getApplyStroke() {
        return this.applyStroke;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Float getBaselineShift() {
        return this.baselineShift;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Boolean getBoxText() {
        return this.boxText;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Float getFirstBaseLine() {
        return this.firstBaseLine;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Boolean getFauxBold() {
        return this.fauxBold;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Boolean getFauxItalic() {
        return this.fauxItalic;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Float getFontSize() {
        return this.fontSize;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Integer getStrokeColor() {
        return this.strokeColor;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final Boolean getStrokeOverFill() {
        return this.strokeOverFill;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final Float getStokeWidth() {
        return this.stokeWidth;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getLayerName() {
        return this.layerName;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Integer getJustification() {
        return this.justification;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final Float getLeading() {
        return this.leading;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final Float getTracking() {
        return this.tracking;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final Integer getBackgroundAlpha() {
        return this.backgroundAlpha;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getLayerType() {
        return this.layerType;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getDefaultText() {
        return this.defaultText;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getTextColor() {
        return this.textColor;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getFontStyle() {
        return this.fontStyle;
    }

    @NotNull
    public final List<LayerMarkData> component8() {
        return this.layerMarkList;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Boolean getApplyFill() {
        return this.applyFill;
    }

    @NotNull
    public final TextLayerData copy(@Nullable Integer layerIndex, @Nullable String layerName, @Nullable Integer layerType, @Nullable String defaultText, @Nullable Integer textColor, @Nullable String fontFamily, @Nullable String fontStyle, @NotNull List<LayerMarkData> layerMarkList, @Nullable Boolean applyFill, @Nullable Boolean applyStroke, @Nullable Float baselineShift, @Nullable Boolean boxText, @Nullable Float firstBaseLine, @Nullable Boolean fauxBold, @Nullable Boolean fauxItalic, @Nullable Float fontSize, @Nullable Integer strokeColor, @Nullable Boolean strokeOverFill, @Nullable Float stokeWidth, @Nullable Integer justification, @Nullable Float leading, @Nullable Float tracking, @Nullable Integer backgroundColor, @Nullable Integer backgroundAlpha) {
        Intrinsics.checkParameterIsNotNull(layerMarkList, "layerMarkList");
        return new TextLayerData(layerIndex, layerName, layerType, defaultText, textColor, fontFamily, fontStyle, layerMarkList, applyFill, applyStroke, baselineShift, boxText, firstBaseLine, fauxBold, fauxItalic, fontSize, strokeColor, strokeOverFill, stokeWidth, justification, leading, tracking, backgroundColor, backgroundAlpha);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TextLayerData) {
                TextLayerData textLayerData = (TextLayerData) other;
                if (!Intrinsics.areEqual(this.layerIndex, textLayerData.layerIndex) || !Intrinsics.areEqual(this.layerName, textLayerData.layerName) || !Intrinsics.areEqual(this.layerType, textLayerData.layerType) || !Intrinsics.areEqual(this.defaultText, textLayerData.defaultText) || !Intrinsics.areEqual(this.textColor, textLayerData.textColor) || !Intrinsics.areEqual(this.fontFamily, textLayerData.fontFamily) || !Intrinsics.areEqual(this.fontStyle, textLayerData.fontStyle) || !Intrinsics.areEqual(this.layerMarkList, textLayerData.layerMarkList) || !Intrinsics.areEqual(this.applyFill, textLayerData.applyFill) || !Intrinsics.areEqual(this.applyStroke, textLayerData.applyStroke) || !Intrinsics.areEqual((Object) this.baselineShift, (Object) textLayerData.baselineShift) || !Intrinsics.areEqual(this.boxText, textLayerData.boxText) || !Intrinsics.areEqual((Object) this.firstBaseLine, (Object) textLayerData.firstBaseLine) || !Intrinsics.areEqual(this.fauxBold, textLayerData.fauxBold) || !Intrinsics.areEqual(this.fauxItalic, textLayerData.fauxItalic) || !Intrinsics.areEqual((Object) this.fontSize, (Object) textLayerData.fontSize) || !Intrinsics.areEqual(this.strokeColor, textLayerData.strokeColor) || !Intrinsics.areEqual(this.strokeOverFill, textLayerData.strokeOverFill) || !Intrinsics.areEqual((Object) this.stokeWidth, (Object) textLayerData.stokeWidth) || !Intrinsics.areEqual(this.justification, textLayerData.justification) || !Intrinsics.areEqual((Object) this.leading, (Object) textLayerData.leading) || !Intrinsics.areEqual((Object) this.tracking, (Object) textLayerData.tracking) || !Intrinsics.areEqual(this.backgroundColor, textLayerData.backgroundColor) || !Intrinsics.areEqual(this.backgroundAlpha, textLayerData.backgroundAlpha)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Boolean getApplyFill() {
        return this.applyFill;
    }

    @Nullable
    public final Boolean getApplyStroke() {
        return this.applyStroke;
    }

    @Nullable
    public final Integer getBackgroundAlpha() {
        return this.backgroundAlpha;
    }

    @Nullable
    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final Float getBaselineShift() {
        return this.baselineShift;
    }

    @Nullable
    public final Boolean getBoxText() {
        return this.boxText;
    }

    @Nullable
    public final String getDefaultText() {
        return this.defaultText;
    }

    @Nullable
    public final Boolean getFauxBold() {
        return this.fauxBold;
    }

    @Nullable
    public final Boolean getFauxItalic() {
        return this.fauxItalic;
    }

    @Nullable
    public final Float getFirstBaseLine() {
        return this.firstBaseLine;
    }

    @Nullable
    public final String getFontFamily() {
        return this.fontFamily;
    }

    @Nullable
    public final Float getFontSize() {
        return this.fontSize;
    }

    @Nullable
    public final String getFontStyle() {
        return this.fontStyle;
    }

    @Nullable
    public final Integer getJustification() {
        return this.justification;
    }

    @Nullable
    public final Integer getLayerIndex() {
        return this.layerIndex;
    }

    @NotNull
    public final List<LayerMarkData> getLayerMarkList() {
        return this.layerMarkList;
    }

    @Nullable
    public final String getLayerName() {
        return this.layerName;
    }

    @Nullable
    public final Integer getLayerType() {
        return this.layerType;
    }

    @Nullable
    public final Float getLeading() {
        return this.leading;
    }

    @Nullable
    public final Float getStokeWidth() {
        return this.stokeWidth;
    }

    @Nullable
    public final Integer getStrokeColor() {
        return this.strokeColor;
    }

    @Nullable
    public final Boolean getStrokeOverFill() {
        return this.strokeOverFill;
    }

    @Nullable
    public final Integer getTextColor() {
        return this.textColor;
    }

    @Nullable
    public final Float getTracking() {
        return this.tracking;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66;
        Integer num = this.layerIndex;
        int i67 = 0;
        if (num != null) {
            i3 = num.hashCode();
        } else {
            i3 = 0;
        }
        int i68 = i3 * 31;
        String str = this.layerName;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i69 = (i68 + i16) * 31;
        Integer num2 = this.layerType;
        if (num2 != null) {
            i17 = num2.hashCode();
        } else {
            i17 = 0;
        }
        int i75 = (i69 + i17) * 31;
        String str2 = this.defaultText;
        if (str2 != null) {
            i18 = str2.hashCode();
        } else {
            i18 = 0;
        }
        int i76 = (i75 + i18) * 31;
        Integer num3 = this.textColor;
        if (num3 != null) {
            i19 = num3.hashCode();
        } else {
            i19 = 0;
        }
        int i77 = (i76 + i19) * 31;
        String str3 = this.fontFamily;
        if (str3 != null) {
            i26 = str3.hashCode();
        } else {
            i26 = 0;
        }
        int i78 = (i77 + i26) * 31;
        String str4 = this.fontStyle;
        if (str4 != null) {
            i27 = str4.hashCode();
        } else {
            i27 = 0;
        }
        int i79 = (i78 + i27) * 31;
        List<LayerMarkData> list = this.layerMarkList;
        if (list != null) {
            i28 = list.hashCode();
        } else {
            i28 = 0;
        }
        int i85 = (i79 + i28) * 31;
        Boolean bool = this.applyFill;
        if (bool != null) {
            i29 = bool.hashCode();
        } else {
            i29 = 0;
        }
        int i86 = (i85 + i29) * 31;
        Boolean bool2 = this.applyStroke;
        if (bool2 != null) {
            i36 = bool2.hashCode();
        } else {
            i36 = 0;
        }
        int i87 = (i86 + i36) * 31;
        Float f16 = this.baselineShift;
        if (f16 != null) {
            i37 = f16.hashCode();
        } else {
            i37 = 0;
        }
        int i88 = (i87 + i37) * 31;
        Boolean bool3 = this.boxText;
        if (bool3 != null) {
            i38 = bool3.hashCode();
        } else {
            i38 = 0;
        }
        int i89 = (i88 + i38) * 31;
        Float f17 = this.firstBaseLine;
        if (f17 != null) {
            i39 = f17.hashCode();
        } else {
            i39 = 0;
        }
        int i95 = (i89 + i39) * 31;
        Boolean bool4 = this.fauxBold;
        if (bool4 != null) {
            i46 = bool4.hashCode();
        } else {
            i46 = 0;
        }
        int i96 = (i95 + i46) * 31;
        Boolean bool5 = this.fauxItalic;
        if (bool5 != null) {
            i47 = bool5.hashCode();
        } else {
            i47 = 0;
        }
        int i97 = (i96 + i47) * 31;
        Float f18 = this.fontSize;
        if (f18 != null) {
            i48 = f18.hashCode();
        } else {
            i48 = 0;
        }
        int i98 = (i97 + i48) * 31;
        Integer num4 = this.strokeColor;
        if (num4 != null) {
            i49 = num4.hashCode();
        } else {
            i49 = 0;
        }
        int i99 = (i98 + i49) * 31;
        Boolean bool6 = this.strokeOverFill;
        if (bool6 != null) {
            i56 = bool6.hashCode();
        } else {
            i56 = 0;
        }
        int i100 = (i99 + i56) * 31;
        Float f19 = this.stokeWidth;
        if (f19 != null) {
            i57 = f19.hashCode();
        } else {
            i57 = 0;
        }
        int i101 = (i100 + i57) * 31;
        Integer num5 = this.justification;
        if (num5 != null) {
            i58 = num5.hashCode();
        } else {
            i58 = 0;
        }
        int i102 = (i101 + i58) * 31;
        Float f26 = this.leading;
        if (f26 != null) {
            i59 = f26.hashCode();
        } else {
            i59 = 0;
        }
        int i103 = (i102 + i59) * 31;
        Float f27 = this.tracking;
        if (f27 != null) {
            i65 = f27.hashCode();
        } else {
            i65 = 0;
        }
        int i104 = (i103 + i65) * 31;
        Integer num6 = this.backgroundColor;
        if (num6 != null) {
            i66 = num6.hashCode();
        } else {
            i66 = 0;
        }
        int i105 = (i104 + i66) * 31;
        Integer num7 = this.backgroundAlpha;
        if (num7 != null) {
            i67 = num7.hashCode();
        }
        return i105 + i67;
    }

    @NotNull
    public String toString() {
        return "TextLayerData(layerIndex=" + this.layerIndex + ", layerName=" + this.layerName + ", layerType=" + this.layerType + ", defaultText=" + this.defaultText + ", textColor=" + this.textColor + ", fontFamily=" + this.fontFamily + ", fontStyle=" + this.fontStyle + ", layerMarkList=" + this.layerMarkList + ", applyFill=" + this.applyFill + ", applyStroke=" + this.applyStroke + ", baselineShift=" + this.baselineShift + ", boxText=" + this.boxText + ", firstBaseLine=" + this.firstBaseLine + ", fauxBold=" + this.fauxBold + ", fauxItalic=" + this.fauxItalic + ", fontSize=" + this.fontSize + ", strokeColor=" + this.strokeColor + ", strokeOverFill=" + this.strokeOverFill + ", stokeWidth=" + this.stokeWidth + ", justification=" + this.justification + ", leading=" + this.leading + ", tracking=" + this.tracking + ", backgroundColor=" + this.backgroundColor + ", backgroundAlpha=" + this.backgroundAlpha + ")";
    }

    public TextLayerData(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable String str2, @Nullable Integer num3, @Nullable String str3, @Nullable String str4, @NotNull List<LayerMarkData> layerMarkList, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Float f16, @Nullable Boolean bool3, @Nullable Float f17, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Float f18, @Nullable Integer num4, @Nullable Boolean bool6, @Nullable Float f19, @Nullable Integer num5, @Nullable Float f26, @Nullable Float f27, @Nullable Integer num6, @Nullable Integer num7) {
        Intrinsics.checkParameterIsNotNull(layerMarkList, "layerMarkList");
        this.layerIndex = num;
        this.layerName = str;
        this.layerType = num2;
        this.defaultText = str2;
        this.textColor = num3;
        this.fontFamily = str3;
        this.fontStyle = str4;
        this.layerMarkList = layerMarkList;
        this.applyFill = bool;
        this.applyStroke = bool2;
        this.baselineShift = f16;
        this.boxText = bool3;
        this.firstBaseLine = f17;
        this.fauxBold = bool4;
        this.fauxItalic = bool5;
        this.fontSize = f18;
        this.strokeColor = num4;
        this.strokeOverFill = bool6;
        this.stokeWidth = f19;
        this.justification = num5;
        this.leading = f26;
        this.tracking = f27;
        this.backgroundColor = num6;
        this.backgroundAlpha = num7;
    }

    public /* synthetic */ TextLayerData(Integer num, String str, Integer num2, String str2, Integer num3, String str3, String str4, List list, Boolean bool, Boolean bool2, Float f16, Boolean bool3, Float f17, Boolean bool4, Boolean bool5, Float f18, Integer num4, Boolean bool6, Float f19, Integer num5, Float f26, Float f27, Integer num6, Integer num7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : num3, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 256) != 0 ? null : bool, (i3 & 512) != 0 ? null : bool2, (i3 & 1024) != 0 ? null : f16, (i3 & 2048) != 0 ? null : bool3, (i3 & 4096) != 0 ? null : f17, (i3 & 8192) != 0 ? null : bool4, (i3 & 16384) != 0 ? null : bool5, (i3 & 32768) != 0 ? null : f18, (i3 & 65536) != 0 ? null : num4, (i3 & 131072) != 0 ? null : bool6, (i3 & 262144) != 0 ? null : f19, (i3 & 524288) != 0 ? null : num5, (i3 & 1048576) != 0 ? null : f26, (i3 & 2097152) != 0 ? null : f27, (i3 & 4194304) != 0 ? null : num6, (i3 & 8388608) != 0 ? null : num7);
    }
}
