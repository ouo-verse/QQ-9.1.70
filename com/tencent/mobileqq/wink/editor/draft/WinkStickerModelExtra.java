package com.tencent.mobileqq.wink.editor.draft;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.mobileqq.wink.editor.tts.source.TTSAudioInfo;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b7\b\u0086\b\u0018\u0000 r2\u00020\u0001:\u0001sB\u00ff\u0001\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\b\b\u0002\u0010(\u001a\u00020\u0005\u0012\b\b\u0002\u0010)\u001a\u00020\u0005\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0005\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0006\u00100\u001a\u00020\u0012\u0012\b\b\u0002\u00101\u001a\u00020\u0005\u0012\b\b\u0002\u00102\u001a\u00020\u0005\u0012\b\b\u0002\u00103\u001a\u00020\u0012\u0012\u001c\b\u0002\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u00106\u001a\u00020\u001d\u0012\u0006\u00107\u001a\u00020\u0012\u0012\b\b\u0002\u00108\u001a\u00020\u0012\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\bp\u0010qJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010\r\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0012H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0012H\u00c6\u0003J\u001d\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u001dH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0012H\u00c6\u0003J\t\u0010 \u001a\u00020\u0012H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010!H\u00c6\u0003J\u0089\u0002\u0010:\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00122\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\u00122\u001c\b\u0002\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00192\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u00106\u001a\u00020\u001d2\b\b\u0002\u00107\u001a\u00020\u00122\b\b\u0002\u00108\u001a\u00020\u00122\n\b\u0002\u00109\u001a\u0004\u0018\u00010!H\u00c6\u0001J\t\u0010;\u001a\u00020\u001bH\u00d6\u0001J\t\u0010<\u001a\u00020\u001dH\u00d6\u0001J\u0013\u0010?\u001a\u00020\u00122\b\u0010>\u001a\u0004\u0018\u00010=H\u00d6\u0003R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bC\u0010BR\u0017\u0010%\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b%\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010&\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b&\u0010D\u001a\u0004\bG\u0010FR\u0017\u0010'\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b'\u0010D\u001a\u0004\bH\u0010FR\u0017\u0010(\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b(\u0010D\u001a\u0004\bI\u0010FR\u0017\u0010)\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b)\u0010D\u001a\u0004\bJ\u0010FR\u0019\u0010*\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b*\u0010K\u001a\u0004\bL\u0010MR\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b+\u0010@\u001a\u0004\bN\u0010BR\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b,\u0010@\u001a\u0004\bO\u0010BR\u0017\u0010-\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b-\u0010@\u001a\u0004\bP\u0010BR\u0017\u0010.\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b.\u0010D\u001a\u0004\bQ\u0010FR\u0017\u0010/\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b/\u0010D\u001a\u0004\bR\u0010FR\u0017\u00100\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b0\u0010S\u001a\u0004\b0\u0010TR\u0017\u00101\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b1\u0010D\u001a\u0004\bU\u0010FR\u0017\u00102\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b2\u0010D\u001a\u0004\bV\u0010FR\"\u00103\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010S\u001a\u0004\b3\u0010T\"\u0004\bW\u0010XR6\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u00105\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u00106\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u00107\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010S\u001a\u0004\b7\u0010T\"\u0004\bh\u0010XR\"\u00108\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010S\u001a\u0004\bi\u0010T\"\u0004\bj\u0010XR$\u00109\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u00a8\u0006t"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/draft/WinkStickerModelExtra;", "Ljava/io/Serializable;", "", "component1", "component2", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "component3", "component4", "component5", "component6", "component7", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "component8", "component9", "component10", "component11", "component12", "component13", "", "component14", "component15", "component16", "component17", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/draft/TrackStickerInfo;", "Lkotlin/collections/ArrayList;", "component18", "", "component19", "", "component20", "component21", "component22", "Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;", "component23", "initStickerScale", "downScaleRecord", "originPointInView", "sizeInView", "centerInView", "leftTopInView", "rightBottomInView", WadlProxyConsts.KEY_MATERIAL, "lastDownScaleX", "lastDownScaleY", "lastDownRotate", "normalizedLeftTopInView", "normalizedRightBottomInView", "isTextSticker", "clickBoundsLeftTopInView", "clickBoundsRightBottomInView", "isTraceSticker", "stickerTrackerResult", "entityName", TemplateParser.KEY_ENTITY_ID, "isTimeRangeChangedByUser", "hasChooseTTS", "ttsAudioInfo", "copy", "toString", "hashCode", "", "other", "equals", UserInfo.SEX_FEMALE, "getInitStickerScale", "()F", "getDownScaleRecord", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "getOriginPointInView", "()Lcom/tencent/mobileqq/wink/editor/model/PointF;", "getSizeInView", "getCenterInView", "getLeftTopInView", "getRightBottomInView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getLastDownScaleX", "getLastDownScaleY", "getLastDownRotate", "getNormalizedLeftTopInView", "getNormalizedRightBottomInView", "Z", "()Z", "getClickBoundsLeftTopInView", "getClickBoundsRightBottomInView", "setTraceSticker", "(Z)V", "Ljava/util/ArrayList;", "getStickerTrackerResult", "()Ljava/util/ArrayList;", "setStickerTrackerResult", "(Ljava/util/ArrayList;)V", "Ljava/lang/String;", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "I", "getEntityId", "()I", "setEntityId", "(I)V", "setTimeRangeChangedByUser", "getHasChooseTTS", "setHasChooseTTS", "Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;", "getTtsAudioInfo", "()Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;", "setTtsAudioInfo", "(Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;)V", "<init>", "(FFLcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;FFFLcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;ZLcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;ZLjava/util/ArrayList;Ljava/lang/String;IZZLcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class WinkStickerModelExtra implements Serializable {
    private static final long serialVersionUID = -503555319113633973L;

    @NotNull
    private final PointF centerInView;

    @NotNull
    private final PointF clickBoundsLeftTopInView;

    @NotNull
    private final PointF clickBoundsRightBottomInView;
    private final float downScaleRecord;
    private int entityId;

    @Nullable
    private String entityName;
    private boolean hasChooseTTS;
    private final float initStickerScale;
    private final boolean isTextSticker;
    private boolean isTimeRangeChangedByUser;
    private boolean isTraceSticker;
    private final float lastDownRotate;
    private final float lastDownScaleX;
    private final float lastDownScaleY;

    @NotNull
    private final PointF leftTopInView;

    @Nullable
    private final MetaMaterial material;

    @NotNull
    private final PointF normalizedLeftTopInView;

    @NotNull
    private final PointF normalizedRightBottomInView;

    @NotNull
    private final PointF originPointInView;

    @NotNull
    private final PointF rightBottomInView;

    @NotNull
    private final PointF sizeInView;

    @Nullable
    private ArrayList<TrackStickerInfo> stickerTrackerResult;

    @Nullable
    private TTSAudioInfo ttsAudioInfo;

    public WinkStickerModelExtra(float f16, float f17, @NotNull PointF originPointInView, @NotNull PointF sizeInView, @NotNull PointF centerInView, @NotNull PointF leftTopInView, @NotNull PointF rightBottomInView, @Nullable MetaMaterial metaMaterial, float f18, float f19, float f26, @NotNull PointF normalizedLeftTopInView, @NotNull PointF normalizedRightBottomInView, boolean z16, @NotNull PointF clickBoundsLeftTopInView, @NotNull PointF clickBoundsRightBottomInView, boolean z17, @Nullable ArrayList<TrackStickerInfo> arrayList, @Nullable String str, int i3, boolean z18, boolean z19, @Nullable TTSAudioInfo tTSAudioInfo) {
        Intrinsics.checkNotNullParameter(originPointInView, "originPointInView");
        Intrinsics.checkNotNullParameter(sizeInView, "sizeInView");
        Intrinsics.checkNotNullParameter(centerInView, "centerInView");
        Intrinsics.checkNotNullParameter(leftTopInView, "leftTopInView");
        Intrinsics.checkNotNullParameter(rightBottomInView, "rightBottomInView");
        Intrinsics.checkNotNullParameter(normalizedLeftTopInView, "normalizedLeftTopInView");
        Intrinsics.checkNotNullParameter(normalizedRightBottomInView, "normalizedRightBottomInView");
        Intrinsics.checkNotNullParameter(clickBoundsLeftTopInView, "clickBoundsLeftTopInView");
        Intrinsics.checkNotNullParameter(clickBoundsRightBottomInView, "clickBoundsRightBottomInView");
        this.initStickerScale = f16;
        this.downScaleRecord = f17;
        this.originPointInView = originPointInView;
        this.sizeInView = sizeInView;
        this.centerInView = centerInView;
        this.leftTopInView = leftTopInView;
        this.rightBottomInView = rightBottomInView;
        this.material = metaMaterial;
        this.lastDownScaleX = f18;
        this.lastDownScaleY = f19;
        this.lastDownRotate = f26;
        this.normalizedLeftTopInView = normalizedLeftTopInView;
        this.normalizedRightBottomInView = normalizedRightBottomInView;
        this.isTextSticker = z16;
        this.clickBoundsLeftTopInView = clickBoundsLeftTopInView;
        this.clickBoundsRightBottomInView = clickBoundsRightBottomInView;
        this.isTraceSticker = z17;
        this.stickerTrackerResult = arrayList;
        this.entityName = str;
        this.entityId = i3;
        this.isTimeRangeChangedByUser = z18;
        this.hasChooseTTS = z19;
        this.ttsAudioInfo = tTSAudioInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final float getInitStickerScale() {
        return this.initStickerScale;
    }

    /* renamed from: component10, reason: from getter */
    public final float getLastDownScaleY() {
        return this.lastDownScaleY;
    }

    /* renamed from: component11, reason: from getter */
    public final float getLastDownRotate() {
        return this.lastDownRotate;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final PointF getNormalizedLeftTopInView() {
        return this.normalizedLeftTopInView;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final PointF getNormalizedRightBottomInView() {
        return this.normalizedRightBottomInView;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsTextSticker() {
        return this.isTextSticker;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final PointF getClickBoundsLeftTopInView() {
        return this.clickBoundsLeftTopInView;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final PointF getClickBoundsRightBottomInView() {
        return this.clickBoundsRightBottomInView;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getIsTraceSticker() {
        return this.isTraceSticker;
    }

    @Nullable
    public final ArrayList<TrackStickerInfo> component18() {
        return this.stickerTrackerResult;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final String getEntityName() {
        return this.entityName;
    }

    /* renamed from: component2, reason: from getter */
    public final float getDownScaleRecord() {
        return this.downScaleRecord;
    }

    /* renamed from: component20, reason: from getter */
    public final int getEntityId() {
        return this.entityId;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getIsTimeRangeChangedByUser() {
        return this.isTimeRangeChangedByUser;
    }

    /* renamed from: component22, reason: from getter */
    public final boolean getHasChooseTTS() {
        return this.hasChooseTTS;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final TTSAudioInfo getTtsAudioInfo() {
        return this.ttsAudioInfo;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final PointF getOriginPointInView() {
        return this.originPointInView;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final PointF getSizeInView() {
        return this.sizeInView;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final PointF getCenterInView() {
        return this.centerInView;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final PointF getLeftTopInView() {
        return this.leftTopInView;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final PointF getRightBottomInView() {
        return this.rightBottomInView;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final MetaMaterial getMaterial() {
        return this.material;
    }

    /* renamed from: component9, reason: from getter */
    public final float getLastDownScaleX() {
        return this.lastDownScaleX;
    }

    @NotNull
    public final WinkStickerModelExtra copy(float initStickerScale, float downScaleRecord, @NotNull PointF originPointInView, @NotNull PointF sizeInView, @NotNull PointF centerInView, @NotNull PointF leftTopInView, @NotNull PointF rightBottomInView, @Nullable MetaMaterial material, float lastDownScaleX, float lastDownScaleY, float lastDownRotate, @NotNull PointF normalizedLeftTopInView, @NotNull PointF normalizedRightBottomInView, boolean isTextSticker, @NotNull PointF clickBoundsLeftTopInView, @NotNull PointF clickBoundsRightBottomInView, boolean isTraceSticker, @Nullable ArrayList<TrackStickerInfo> stickerTrackerResult, @Nullable String entityName, int entityId, boolean isTimeRangeChangedByUser, boolean hasChooseTTS, @Nullable TTSAudioInfo ttsAudioInfo) {
        Intrinsics.checkNotNullParameter(originPointInView, "originPointInView");
        Intrinsics.checkNotNullParameter(sizeInView, "sizeInView");
        Intrinsics.checkNotNullParameter(centerInView, "centerInView");
        Intrinsics.checkNotNullParameter(leftTopInView, "leftTopInView");
        Intrinsics.checkNotNullParameter(rightBottomInView, "rightBottomInView");
        Intrinsics.checkNotNullParameter(normalizedLeftTopInView, "normalizedLeftTopInView");
        Intrinsics.checkNotNullParameter(normalizedRightBottomInView, "normalizedRightBottomInView");
        Intrinsics.checkNotNullParameter(clickBoundsLeftTopInView, "clickBoundsLeftTopInView");
        Intrinsics.checkNotNullParameter(clickBoundsRightBottomInView, "clickBoundsRightBottomInView");
        return new WinkStickerModelExtra(initStickerScale, downScaleRecord, originPointInView, sizeInView, centerInView, leftTopInView, rightBottomInView, material, lastDownScaleX, lastDownScaleY, lastDownRotate, normalizedLeftTopInView, normalizedRightBottomInView, isTextSticker, clickBoundsLeftTopInView, clickBoundsRightBottomInView, isTraceSticker, stickerTrackerResult, entityName, entityId, isTimeRangeChangedByUser, hasChooseTTS, ttsAudioInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkStickerModelExtra)) {
            return false;
        }
        WinkStickerModelExtra winkStickerModelExtra = (WinkStickerModelExtra) other;
        if (Float.compare(this.initStickerScale, winkStickerModelExtra.initStickerScale) == 0 && Float.compare(this.downScaleRecord, winkStickerModelExtra.downScaleRecord) == 0 && Intrinsics.areEqual(this.originPointInView, winkStickerModelExtra.originPointInView) && Intrinsics.areEqual(this.sizeInView, winkStickerModelExtra.sizeInView) && Intrinsics.areEqual(this.centerInView, winkStickerModelExtra.centerInView) && Intrinsics.areEqual(this.leftTopInView, winkStickerModelExtra.leftTopInView) && Intrinsics.areEqual(this.rightBottomInView, winkStickerModelExtra.rightBottomInView) && Intrinsics.areEqual(this.material, winkStickerModelExtra.material) && Float.compare(this.lastDownScaleX, winkStickerModelExtra.lastDownScaleX) == 0 && Float.compare(this.lastDownScaleY, winkStickerModelExtra.lastDownScaleY) == 0 && Float.compare(this.lastDownRotate, winkStickerModelExtra.lastDownRotate) == 0 && Intrinsics.areEqual(this.normalizedLeftTopInView, winkStickerModelExtra.normalizedLeftTopInView) && Intrinsics.areEqual(this.normalizedRightBottomInView, winkStickerModelExtra.normalizedRightBottomInView) && this.isTextSticker == winkStickerModelExtra.isTextSticker && Intrinsics.areEqual(this.clickBoundsLeftTopInView, winkStickerModelExtra.clickBoundsLeftTopInView) && Intrinsics.areEqual(this.clickBoundsRightBottomInView, winkStickerModelExtra.clickBoundsRightBottomInView) && this.isTraceSticker == winkStickerModelExtra.isTraceSticker && Intrinsics.areEqual(this.stickerTrackerResult, winkStickerModelExtra.stickerTrackerResult) && Intrinsics.areEqual(this.entityName, winkStickerModelExtra.entityName) && this.entityId == winkStickerModelExtra.entityId && this.isTimeRangeChangedByUser == winkStickerModelExtra.isTimeRangeChangedByUser && this.hasChooseTTS == winkStickerModelExtra.hasChooseTTS && Intrinsics.areEqual(this.ttsAudioInfo, winkStickerModelExtra.ttsAudioInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final PointF getCenterInView() {
        return this.centerInView;
    }

    @NotNull
    public final PointF getClickBoundsLeftTopInView() {
        return this.clickBoundsLeftTopInView;
    }

    @NotNull
    public final PointF getClickBoundsRightBottomInView() {
        return this.clickBoundsRightBottomInView;
    }

    public final float getDownScaleRecord() {
        return this.downScaleRecord;
    }

    public final int getEntityId() {
        return this.entityId;
    }

    @Nullable
    public final String getEntityName() {
        return this.entityName;
    }

    public final boolean getHasChooseTTS() {
        return this.hasChooseTTS;
    }

    public final float getInitStickerScale() {
        return this.initStickerScale;
    }

    public final float getLastDownRotate() {
        return this.lastDownRotate;
    }

    public final float getLastDownScaleX() {
        return this.lastDownScaleX;
    }

    public final float getLastDownScaleY() {
        return this.lastDownScaleY;
    }

    @NotNull
    public final PointF getLeftTopInView() {
        return this.leftTopInView;
    }

    @Nullable
    public final MetaMaterial getMaterial() {
        return this.material;
    }

    @NotNull
    public final PointF getNormalizedLeftTopInView() {
        return this.normalizedLeftTopInView;
    }

    @NotNull
    public final PointF getNormalizedRightBottomInView() {
        return this.normalizedRightBottomInView;
    }

    @NotNull
    public final PointF getOriginPointInView() {
        return this.originPointInView;
    }

    @NotNull
    public final PointF getRightBottomInView() {
        return this.rightBottomInView;
    }

    @NotNull
    public final PointF getSizeInView() {
        return this.sizeInView;
    }

    @Nullable
    public final ArrayList<TrackStickerInfo> getStickerTrackerResult() {
        return this.stickerTrackerResult;
    }

    @Nullable
    public final TTSAudioInfo getTtsAudioInfo() {
        return this.ttsAudioInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int floatToIntBits = ((((((((((((Float.floatToIntBits(this.initStickerScale) * 31) + Float.floatToIntBits(this.downScaleRecord)) * 31) + this.originPointInView.hashCode()) * 31) + this.sizeInView.hashCode()) * 31) + this.centerInView.hashCode()) * 31) + this.leftTopInView.hashCode()) * 31) + this.rightBottomInView.hashCode()) * 31;
        MetaMaterial metaMaterial = this.material;
        int i3 = 0;
        if (metaMaterial == null) {
            hashCode = 0;
        } else {
            hashCode = metaMaterial.hashCode();
        }
        int floatToIntBits2 = (((((((((((floatToIntBits + hashCode) * 31) + Float.floatToIntBits(this.lastDownScaleX)) * 31) + Float.floatToIntBits(this.lastDownScaleY)) * 31) + Float.floatToIntBits(this.lastDownRotate)) * 31) + this.normalizedLeftTopInView.hashCode()) * 31) + this.normalizedRightBottomInView.hashCode()) * 31;
        boolean z16 = this.isTextSticker;
        int i16 = 1;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int hashCode4 = (((((floatToIntBits2 + i17) * 31) + this.clickBoundsLeftTopInView.hashCode()) * 31) + this.clickBoundsRightBottomInView.hashCode()) * 31;
        boolean z17 = this.isTraceSticker;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (hashCode4 + i18) * 31;
        ArrayList<TrackStickerInfo> arrayList = this.stickerTrackerResult;
        if (arrayList == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = arrayList.hashCode();
        }
        int i26 = (i19 + hashCode2) * 31;
        String str = this.entityName;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int i27 = (((i26 + hashCode3) * 31) + this.entityId) * 31;
        boolean z18 = this.isTimeRangeChangedByUser;
        int i28 = z18;
        if (z18 != 0) {
            i28 = 1;
        }
        int i29 = (i27 + i28) * 31;
        boolean z19 = this.hasChooseTTS;
        if (!z19) {
            i16 = z19 ? 1 : 0;
        }
        int i36 = (i29 + i16) * 31;
        TTSAudioInfo tTSAudioInfo = this.ttsAudioInfo;
        if (tTSAudioInfo != null) {
            i3 = tTSAudioInfo.hashCode();
        }
        return i36 + i3;
    }

    public final boolean isTextSticker() {
        return this.isTextSticker;
    }

    public final boolean isTimeRangeChangedByUser() {
        return this.isTimeRangeChangedByUser;
    }

    public final boolean isTraceSticker() {
        return this.isTraceSticker;
    }

    public final void setEntityId(int i3) {
        this.entityId = i3;
    }

    public final void setEntityName(@Nullable String str) {
        this.entityName = str;
    }

    public final void setHasChooseTTS(boolean z16) {
        this.hasChooseTTS = z16;
    }

    public final void setStickerTrackerResult(@Nullable ArrayList<TrackStickerInfo> arrayList) {
        this.stickerTrackerResult = arrayList;
    }

    public final void setTimeRangeChangedByUser(boolean z16) {
        this.isTimeRangeChangedByUser = z16;
    }

    public final void setTraceSticker(boolean z16) {
        this.isTraceSticker = z16;
    }

    public final void setTtsAudioInfo(@Nullable TTSAudioInfo tTSAudioInfo) {
        this.ttsAudioInfo = tTSAudioInfo;
    }

    @NotNull
    public String toString() {
        return "WinkStickerModelExtra(initStickerScale=" + this.initStickerScale + ", downScaleRecord=" + this.downScaleRecord + ", originPointInView=" + this.originPointInView + ", sizeInView=" + this.sizeInView + ", centerInView=" + this.centerInView + ", leftTopInView=" + this.leftTopInView + ", rightBottomInView=" + this.rightBottomInView + ", material=" + this.material + ", lastDownScaleX=" + this.lastDownScaleX + ", lastDownScaleY=" + this.lastDownScaleY + ", lastDownRotate=" + this.lastDownRotate + ", normalizedLeftTopInView=" + this.normalizedLeftTopInView + ", normalizedRightBottomInView=" + this.normalizedRightBottomInView + ", isTextSticker=" + this.isTextSticker + ", clickBoundsLeftTopInView=" + this.clickBoundsLeftTopInView + ", clickBoundsRightBottomInView=" + this.clickBoundsRightBottomInView + ", isTraceSticker=" + this.isTraceSticker + ", stickerTrackerResult=" + this.stickerTrackerResult + ", entityName=" + this.entityName + ", entityId=" + this.entityId + ", isTimeRangeChangedByUser=" + this.isTimeRangeChangedByUser + ", hasChooseTTS=" + this.hasChooseTTS + ", ttsAudioInfo=" + this.ttsAudioInfo + ")";
    }

    public /* synthetic */ WinkStickerModelExtra(float f16, float f17, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, PointF pointF5, MetaMaterial metaMaterial, float f18, float f19, float f26, PointF pointF6, PointF pointF7, boolean z16, PointF pointF8, PointF pointF9, boolean z17, ArrayList arrayList, String str, int i3, boolean z18, boolean z19, TTSAudioInfo tTSAudioInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0.0f : f16, (i16 & 2) != 0 ? 0.0f : f17, (i16 & 4) != 0 ? new PointF() : pointF, (i16 & 8) != 0 ? new PointF() : pointF2, (i16 & 16) != 0 ? new PointF() : pointF3, (i16 & 32) != 0 ? new PointF() : pointF4, (i16 & 64) != 0 ? new PointF() : pointF5, (i16 & 128) != 0 ? null : metaMaterial, (i16 & 256) != 0 ? 0.0f : f18, (i16 & 512) != 0 ? 0.0f : f19, (i16 & 1024) != 0 ? 0.0f : f26, pointF6, pointF7, z16, (i16 & 16384) != 0 ? new PointF() : pointF8, (32768 & i16) != 0 ? new PointF() : pointF9, (65536 & i16) != 0 ? false : z17, (131072 & i16) != 0 ? null : arrayList, (262144 & i16) != 0 ? null : str, (524288 & i16) != 0 ? 0 : i3, z18, (2097152 & i16) != 0 ? false : z19, (i16 & 4194304) != 0 ? null : tTSAudioInfo);
    }
}
