package com.tencent.mobileqq.wink.editor.sticker;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.utils.w;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.tavcut.core.render.builder.light.model.pag.TextLayerData;
import com.tencent.videocut.model.Size;
import cooperation.qzone.QZoneShareManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\ba\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00b9\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010!J\t\u0010c\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010e\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u00101J\u0010\u0010f\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010g\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u00101J\u0010\u0010h\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010i\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010j\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u00101J\u0010\u0010k\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u0010\u0010l\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010m\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u00101J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u0010\u0010p\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u00101J\u0010\u0010q\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u00101J\u0010\u0010r\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u0010\u0010s\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u000b\u0010t\u001a\u0004\u0018\u00010\u001fH\u00c6\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u0010\u0010w\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010y\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010*J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u00c4\u0002\u0010}\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010~J\u0015\u0010\u007f\u001a\u00020\r2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u00d6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0006H\u00d6\u0001J\u0014\u0010\u0083\u0001\u001a\u00030\u0084\u00012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001J\n\u0010\u0087\u0001\u001a\u00020\u0003H\u00d6\u0001R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b5\u0010#\"\u0004\b6\u0010%R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R\"\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%R\"\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b?\u0010#\"\u0004\b@\u0010%R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00104\u001a\u0004\bA\u00101\"\u0004\bB\u00103R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u00108\"\u0004\bD\u0010:R \u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u00108\"\u0004\bF\u0010:R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00104\u001a\u0004\bG\u00101\"\u0004\bH\u00103R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u00108\"\u0004\bJ\u0010:R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\bK\u0010*\"\u0004\bL\u0010,R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\bM\u0010*\"\u0004\bN\u0010,R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u00108\"\u0004\bP\u0010:R \u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\bU\u0010*\"\u0004\bV\u0010,R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00104\u001a\u0004\bW\u00101\"\u0004\bX\u00103R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00104\u001a\u0004\bY\u00101\"\u0004\bZ\u00103R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\b[\u0010*\"\u0004\b\\\u0010,R\"\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b]\u0010#\"\u0004\b^\u0010%R\"\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010-\u001a\u0004\b_\u0010*\"\u0004\b`\u0010,R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00104\u001a\u0004\ba\u00101\"\u0004\bb\u00103\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContent;", "Ljava/io/Serializable;", "content", "", "layerName", "layerIndex", "", "layerType", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "textColor", "fontFamily", "fontStyle", "applyFill", "", "applyStroke", "baselineShift", "", "boxText", "firstBaseLine", "fauxBold", "fauxItalic", "fontSize", "strokeColor", "strokeOverFill", "stokeWidth", "justification", "leading", "tracking", "backgroundColor", "backgroundAlpha", "layerSize", "Lcom/tencent/videocut/model/Size;", "fontPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/videocut/model/Size;Ljava/lang/String;)V", "getApplyFill", "()Ljava/lang/Boolean;", "setApplyFill", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getApplyStroke", "setApplyStroke", "getBackgroundAlpha", "()Ljava/lang/Integer;", "setBackgroundAlpha", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBackgroundColor", "setBackgroundColor", "getBaselineShift", "()Ljava/lang/Float;", "setBaselineShift", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getBoxText", "setBoxText", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getDefaultText", "setDefaultText", "getFauxBold", "setFauxBold", "getFauxItalic", "setFauxItalic", "getFirstBaseLine", "setFirstBaseLine", "getFontFamily", CanvasView.ACTION_SET_FONT_FAMILY, "getFontPath", "setFontPath", "getFontSize", CanvasView.ACTION_SET_FONT_SIZE, "getFontStyle", CanvasView.ACTION_SET_FONT_STYLE, "getJustification", "setJustification", "getLayerIndex", "setLayerIndex", "getLayerName", "setLayerName", "getLayerSize", "()Lcom/tencent/videocut/model/Size;", "setLayerSize", "(Lcom/tencent/videocut/model/Size;)V", "getLayerType", "setLayerType", "getLeading", "setLeading", "getStokeWidth", "setStokeWidth", "getStrokeColor", "setStrokeColor", "getStrokeOverFill", "setStrokeOverFill", "getTextColor", "setTextColor", "getTracking", "setTracking", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/videocut/model/Size;Ljava/lang/String;)Lcom/tencent/mobileqq/wink/editor/sticker/MetaMaterialContent;", "equals", "other", "", "hashCode", "resetData", "", "textLayer", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/TextLayerData;", "toString", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class MetaMaterialContent implements Serializable {

    @SerializedName("applyFill")
    @Nullable
    private Boolean applyFill;

    @SerializedName("applyStroke")
    @Nullable
    private Boolean applyStroke;

    @SerializedName("backgroundAlpha")
    @Nullable
    private Integer backgroundAlpha;

    @SerializedName("backgroundColor")
    @Nullable
    private Integer backgroundColor;

    @SerializedName("baselineShift")
    @Nullable
    private Float baselineShift;

    @SerializedName("boxText")
    @Nullable
    private Boolean boxText;

    @SerializedName("content")
    @NotNull
    private String content;

    @SerializedName(QZoneShareManager.QZONE_SHARE_VIDEO_TEXT)
    @Nullable
    private String defaultText;

    @SerializedName("fauxBold")
    @Nullable
    private Boolean fauxBold;

    @SerializedName("fauxItalic")
    @Nullable
    private Boolean fauxItalic;

    @SerializedName("firstBaseLine")
    @Nullable
    private Float firstBaseLine;

    @SerializedName("fontFamily")
    @Nullable
    private String fontFamily;

    @SerializedName("fontPath")
    @Nullable
    private String fontPath;

    @SerializedName("fontSize")
    @Nullable
    private Float fontSize;

    @SerializedName("fontStyle")
    @Nullable
    private String fontStyle;

    @SerializedName("justification")
    @Nullable
    private Integer justification;

    @SerializedName("layerIndex")
    @Nullable
    private Integer layerIndex;

    @SerializedName("layerName")
    @Nullable
    private String layerName;

    @SerializedName("layerSize")
    @Nullable
    private Size layerSize;

    @SerializedName("layerType")
    @Nullable
    private Integer layerType;

    @SerializedName("leading")
    @Nullable
    private Float leading;

    @SerializedName("stokeWidth")
    @Nullable
    private Float stokeWidth;

    @SerializedName("strokeColor")
    @Nullable
    private Integer strokeColor;

    @SerializedName("strokeOverFill")
    @Nullable
    private Boolean strokeOverFill;

    @SerializedName("textColor")
    @Nullable
    private Integer textColor;

    @SerializedName("tracking")
    @Nullable
    private Float tracking;

    public MetaMaterialContent(@NotNull String content, @Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2, @Nullable Integer num3, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Float f16, @Nullable Boolean bool3, @Nullable Float f17, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Float f18, @Nullable Integer num4, @Nullable Boolean bool6, @Nullable Float f19, @Nullable Integer num5, @Nullable Float f26, @Nullable Float f27, @Nullable Integer num6, @Nullable Integer num7, @Nullable Size size, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.layerName = str;
        this.layerIndex = num;
        this.layerType = num2;
        this.defaultText = str2;
        this.textColor = num3;
        this.fontFamily = str3;
        this.fontStyle = str4;
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
        this.layerSize = size;
        this.fontPath = str5;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
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
    /* renamed from: component25, reason: from getter */
    public final Size getLayerSize() {
        return this.layerSize;
    }

    @Nullable
    /* renamed from: component26, reason: from getter */
    public final String getFontPath() {
        return this.fontPath;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getLayerIndex() {
        return this.layerIndex;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getLayerType() {
        return this.layerType;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getDefaultText() {
        return this.defaultText;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getTextColor() {
        return this.textColor;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getFontStyle() {
        return this.fontStyle;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Boolean getApplyFill() {
        return this.applyFill;
    }

    @NotNull
    public final MetaMaterialContent copy(@NotNull String content, @Nullable String layerName, @Nullable Integer layerIndex, @Nullable Integer layerType, @Nullable String defaultText, @Nullable Integer textColor, @Nullable String fontFamily, @Nullable String fontStyle, @Nullable Boolean applyFill, @Nullable Boolean applyStroke, @Nullable Float baselineShift, @Nullable Boolean boxText, @Nullable Float firstBaseLine, @Nullable Boolean fauxBold, @Nullable Boolean fauxItalic, @Nullable Float fontSize, @Nullable Integer strokeColor, @Nullable Boolean strokeOverFill, @Nullable Float stokeWidth, @Nullable Integer justification, @Nullable Float leading, @Nullable Float tracking, @Nullable Integer backgroundColor, @Nullable Integer backgroundAlpha, @Nullable Size layerSize, @Nullable String fontPath) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new MetaMaterialContent(content, layerName, layerIndex, layerType, defaultText, textColor, fontFamily, fontStyle, applyFill, applyStroke, baselineShift, boxText, firstBaseLine, fauxBold, fauxItalic, fontSize, strokeColor, strokeOverFill, stokeWidth, justification, leading, tracking, backgroundColor, backgroundAlpha, layerSize, fontPath);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaMaterialContent)) {
            return false;
        }
        MetaMaterialContent metaMaterialContent = (MetaMaterialContent) other;
        if (Intrinsics.areEqual(this.content, metaMaterialContent.content) && Intrinsics.areEqual(this.layerName, metaMaterialContent.layerName) && Intrinsics.areEqual(this.layerIndex, metaMaterialContent.layerIndex) && Intrinsics.areEqual(this.layerType, metaMaterialContent.layerType) && Intrinsics.areEqual(this.defaultText, metaMaterialContent.defaultText) && Intrinsics.areEqual(this.textColor, metaMaterialContent.textColor) && Intrinsics.areEqual(this.fontFamily, metaMaterialContent.fontFamily) && Intrinsics.areEqual(this.fontStyle, metaMaterialContent.fontStyle) && Intrinsics.areEqual(this.applyFill, metaMaterialContent.applyFill) && Intrinsics.areEqual(this.applyStroke, metaMaterialContent.applyStroke) && Intrinsics.areEqual((Object) this.baselineShift, (Object) metaMaterialContent.baselineShift) && Intrinsics.areEqual(this.boxText, metaMaterialContent.boxText) && Intrinsics.areEqual((Object) this.firstBaseLine, (Object) metaMaterialContent.firstBaseLine) && Intrinsics.areEqual(this.fauxBold, metaMaterialContent.fauxBold) && Intrinsics.areEqual(this.fauxItalic, metaMaterialContent.fauxItalic) && Intrinsics.areEqual((Object) this.fontSize, (Object) metaMaterialContent.fontSize) && Intrinsics.areEqual(this.strokeColor, metaMaterialContent.strokeColor) && Intrinsics.areEqual(this.strokeOverFill, metaMaterialContent.strokeOverFill) && Intrinsics.areEqual((Object) this.stokeWidth, (Object) metaMaterialContent.stokeWidth) && Intrinsics.areEqual(this.justification, metaMaterialContent.justification) && Intrinsics.areEqual((Object) this.leading, (Object) metaMaterialContent.leading) && Intrinsics.areEqual((Object) this.tracking, (Object) metaMaterialContent.tracking) && Intrinsics.areEqual(this.backgroundColor, metaMaterialContent.backgroundColor) && Intrinsics.areEqual(this.backgroundAlpha, metaMaterialContent.backgroundAlpha) && Intrinsics.areEqual(this.layerSize, metaMaterialContent.layerSize) && Intrinsics.areEqual(this.fontPath, metaMaterialContent.fontPath)) {
            return true;
        }
        return false;
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

    @NotNull
    public final String getContent() {
        return this.content;
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
    public final String getFontPath() {
        return this.fontPath;
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

    @Nullable
    public final String getLayerName() {
        return this.layerName;
    }

    @Nullable
    public final Size getLayerSize() {
        return this.layerSize;
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
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int hashCode13;
        int hashCode14;
        int hashCode15;
        int hashCode16;
        int hashCode17;
        int hashCode18;
        int hashCode19;
        int hashCode20;
        int hashCode21;
        int hashCode22;
        int hashCode23;
        int hashCode24;
        int hashCode25 = this.content.hashCode() * 31;
        String str = this.layerName;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode25 + hashCode) * 31;
        Integer num = this.layerIndex;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Integer num2 = this.layerType;
        if (num2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str2 = this.defaultText;
        if (str2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Integer num3 = this.textColor;
        if (num3 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = num3.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str3 = this.fontFamily;
        if (str3 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str3.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str4 = this.fontStyle;
        if (str4 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str4.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        Boolean bool = this.applyFill;
        if (bool == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = bool.hashCode();
        }
        int i29 = (i28 + hashCode8) * 31;
        Boolean bool2 = this.applyStroke;
        if (bool2 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = bool2.hashCode();
        }
        int i36 = (i29 + hashCode9) * 31;
        Float f16 = this.baselineShift;
        if (f16 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = f16.hashCode();
        }
        int i37 = (i36 + hashCode10) * 31;
        Boolean bool3 = this.boxText;
        if (bool3 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = bool3.hashCode();
        }
        int i38 = (i37 + hashCode11) * 31;
        Float f17 = this.firstBaseLine;
        if (f17 == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = f17.hashCode();
        }
        int i39 = (i38 + hashCode12) * 31;
        Boolean bool4 = this.fauxBold;
        if (bool4 == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = bool4.hashCode();
        }
        int i46 = (i39 + hashCode13) * 31;
        Boolean bool5 = this.fauxItalic;
        if (bool5 == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = bool5.hashCode();
        }
        int i47 = (i46 + hashCode14) * 31;
        Float f18 = this.fontSize;
        if (f18 == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = f18.hashCode();
        }
        int i48 = (i47 + hashCode15) * 31;
        Integer num4 = this.strokeColor;
        if (num4 == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = num4.hashCode();
        }
        int i49 = (i48 + hashCode16) * 31;
        Boolean bool6 = this.strokeOverFill;
        if (bool6 == null) {
            hashCode17 = 0;
        } else {
            hashCode17 = bool6.hashCode();
        }
        int i56 = (i49 + hashCode17) * 31;
        Float f19 = this.stokeWidth;
        if (f19 == null) {
            hashCode18 = 0;
        } else {
            hashCode18 = f19.hashCode();
        }
        int i57 = (i56 + hashCode18) * 31;
        Integer num5 = this.justification;
        if (num5 == null) {
            hashCode19 = 0;
        } else {
            hashCode19 = num5.hashCode();
        }
        int i58 = (i57 + hashCode19) * 31;
        Float f26 = this.leading;
        if (f26 == null) {
            hashCode20 = 0;
        } else {
            hashCode20 = f26.hashCode();
        }
        int i59 = (i58 + hashCode20) * 31;
        Float f27 = this.tracking;
        if (f27 == null) {
            hashCode21 = 0;
        } else {
            hashCode21 = f27.hashCode();
        }
        int i65 = (i59 + hashCode21) * 31;
        Integer num6 = this.backgroundColor;
        if (num6 == null) {
            hashCode22 = 0;
        } else {
            hashCode22 = num6.hashCode();
        }
        int i66 = (i65 + hashCode22) * 31;
        Integer num7 = this.backgroundAlpha;
        if (num7 == null) {
            hashCode23 = 0;
        } else {
            hashCode23 = num7.hashCode();
        }
        int i67 = (i66 + hashCode23) * 31;
        Size size = this.layerSize;
        if (size == null) {
            hashCode24 = 0;
        } else {
            hashCode24 = size.hashCode();
        }
        int i68 = (i67 + hashCode24) * 31;
        String str5 = this.fontPath;
        if (str5 != null) {
            i3 = str5.hashCode();
        }
        return i68 + i3;
    }

    public final void resetData(@Nullable TextLayerData textLayer) {
        w.a d16;
        String fontId;
        if (textLayer == null) {
            return;
        }
        String fontFamily = textLayer.getFontFamily();
        if (fontFamily != null && (d16 = w.e().d(fontFamily)) != null && (fontId = d16.f326733a) != null) {
            Intrinsics.checkNotNullExpressionValue(fontId, "fontId");
            this.fontPath = WinkEditorResourceManager.a1().U0(fontId, 0);
        }
        this.layerIndex = textLayer.getLayerIndex();
        this.layerType = textLayer.getLayerType();
        this.defaultText = textLayer.getDefaultText();
        this.textColor = textLayer.getTextColor();
        this.fontFamily = textLayer.getFontFamily();
        this.fontStyle = textLayer.getFontStyle();
        this.applyFill = textLayer.getApplyFill();
        this.applyStroke = textLayer.getApplyStroke();
        this.baselineShift = textLayer.getBaselineShift();
        this.boxText = textLayer.getBoxText();
        this.firstBaseLine = textLayer.getFirstBaseLine();
        this.fauxBold = textLayer.getFauxBold();
        this.fauxItalic = textLayer.getFauxItalic();
        this.fontSize = textLayer.getFontSize();
        this.strokeColor = textLayer.getStrokeColor();
        this.strokeOverFill = textLayer.getStrokeOverFill();
        this.stokeWidth = textLayer.getStokeWidth();
        this.justification = textLayer.getJustification();
        this.leading = textLayer.getLeading();
        this.tracking = textLayer.getTracking();
        this.backgroundColor = textLayer.getBackgroundColor();
        this.backgroundAlpha = textLayer.getBackgroundAlpha();
    }

    public final void setApplyFill(@Nullable Boolean bool) {
        this.applyFill = bool;
    }

    public final void setApplyStroke(@Nullable Boolean bool) {
        this.applyStroke = bool;
    }

    public final void setBackgroundAlpha(@Nullable Integer num) {
        this.backgroundAlpha = num;
    }

    public final void setBackgroundColor(@Nullable Integer num) {
        this.backgroundColor = num;
    }

    public final void setBaselineShift(@Nullable Float f16) {
        this.baselineShift = f16;
    }

    public final void setBoxText(@Nullable Boolean bool) {
        this.boxText = bool;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setDefaultText(@Nullable String str) {
        this.defaultText = str;
    }

    public final void setFauxBold(@Nullable Boolean bool) {
        this.fauxBold = bool;
    }

    public final void setFauxItalic(@Nullable Boolean bool) {
        this.fauxItalic = bool;
    }

    public final void setFirstBaseLine(@Nullable Float f16) {
        this.firstBaseLine = f16;
    }

    public final void setFontFamily(@Nullable String str) {
        this.fontFamily = str;
    }

    public final void setFontPath(@Nullable String str) {
        this.fontPath = str;
    }

    public final void setFontSize(@Nullable Float f16) {
        this.fontSize = f16;
    }

    public final void setFontStyle(@Nullable String str) {
        this.fontStyle = str;
    }

    public final void setJustification(@Nullable Integer num) {
        this.justification = num;
    }

    public final void setLayerIndex(@Nullable Integer num) {
        this.layerIndex = num;
    }

    public final void setLayerName(@Nullable String str) {
        this.layerName = str;
    }

    public final void setLayerSize(@Nullable Size size) {
        this.layerSize = size;
    }

    public final void setLayerType(@Nullable Integer num) {
        this.layerType = num;
    }

    public final void setLeading(@Nullable Float f16) {
        this.leading = f16;
    }

    public final void setStokeWidth(@Nullable Float f16) {
        this.stokeWidth = f16;
    }

    public final void setStrokeColor(@Nullable Integer num) {
        this.strokeColor = num;
    }

    public final void setStrokeOverFill(@Nullable Boolean bool) {
        this.strokeOverFill = bool;
    }

    public final void setTextColor(@Nullable Integer num) {
        this.textColor = num;
    }

    public final void setTracking(@Nullable Float f16) {
        this.tracking = f16;
    }

    @NotNull
    public String toString() {
        return "MetaMaterialContent(content=" + this.content + ", layerName=" + this.layerName + ", layerIndex=" + this.layerIndex + ", layerType=" + this.layerType + ", defaultText=" + this.defaultText + ", textColor=" + this.textColor + ", fontFamily=" + this.fontFamily + ", fontStyle=" + this.fontStyle + ", applyFill=" + this.applyFill + ", applyStroke=" + this.applyStroke + ", baselineShift=" + this.baselineShift + ", boxText=" + this.boxText + ", firstBaseLine=" + this.firstBaseLine + ", fauxBold=" + this.fauxBold + ", fauxItalic=" + this.fauxItalic + ", fontSize=" + this.fontSize + ", strokeColor=" + this.strokeColor + ", strokeOverFill=" + this.strokeOverFill + ", stokeWidth=" + this.stokeWidth + ", justification=" + this.justification + ", leading=" + this.leading + ", tracking=" + this.tracking + ", backgroundColor=" + this.backgroundColor + ", backgroundAlpha=" + this.backgroundAlpha + ", layerSize=" + this.layerSize + ", fontPath=" + this.fontPath + ")";
    }

    public /* synthetic */ MetaMaterialContent(String str, String str2, Integer num, Integer num2, String str3, Integer num3, String str4, String str5, Boolean bool, Boolean bool2, Float f16, Boolean bool3, Float f17, Boolean bool4, Boolean bool5, Float f18, Integer num4, Boolean bool6, Float f19, Integer num5, Float f26, Float f27, Integer num6, Integer num7, Size size, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? null : num2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : num3, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? null : str5, (i3 & 256) != 0 ? null : bool, (i3 & 512) != 0 ? null : bool2, (i3 & 1024) != 0 ? null : f16, (i3 & 2048) != 0 ? null : bool3, (i3 & 4096) != 0 ? null : f17, (i3 & 8192) != 0 ? null : bool4, (i3 & 16384) != 0 ? null : bool5, (i3 & 32768) != 0 ? null : f18, (i3 & 65536) != 0 ? null : num4, (i3 & 131072) != 0 ? null : bool6, (i3 & 262144) != 0 ? null : f19, (i3 & 524288) != 0 ? null : num5, (i3 & 1048576) != 0 ? null : f26, (i3 & 2097152) != 0 ? null : f27, (i3 & 4194304) != 0 ? null : num6, (i3 & 8388608) != 0 ? null : num7, (i3 & 16777216) != 0 ? null : size, (i3 & 33554432) == 0 ? str6 : null);
    }
}
