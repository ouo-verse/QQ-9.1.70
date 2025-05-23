package com.tencent.mobileqq.wink.editor.draft;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicDataSerializable;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.SpecialEffectModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\bG\b\u0086\b\u0018\u0000 \u007f2\u00020\u0001:\u0002\u0080\u0001B\u00b9\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\b\u0002\u0010*\u001a\u00020\u0011\u0012\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0017\u0012(\b\u0002\u0010/\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u001a\u0012\b\b\u0002\u00100\u001a\u00020\u0011\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u00104\u001a\u00020\u0011\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b}\u0010~J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u00c6\u0003J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006H\u00c6\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u00c6\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0011H\u00c6\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003J)\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u001aH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0011H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u001fH\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0011H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u00bd\u0002\u00106\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00042\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010*\u001a\u00020\u00112\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00172(\b\u0002\u0010/\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u001a2\b\b\u0002\u00100\u001a\u00020\u00112\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00104\u001a\u00020\u00112\n\b\u0002\u00105\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\t\u00107\u001a\u00020\u0007H\u00d6\u0001J\t\u00109\u001a\u000208H\u00d6\u0001J\u0013\u0010<\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010:H\u00d6\u0003R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010G\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR0\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010G\u001a\u0004\bN\u0010I\"\u0004\bO\u0010KR0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010G\u001a\u0004\bP\u0010I\"\u0004\bQ\u0010KR\"\u0010*\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR0\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010G\u001a\u0004\bW\u0010I\"\u0004\bX\u0010KR$\u0010,\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R0\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010G\u001a\u0004\b^\u0010I\"\u0004\b_\u0010KR$\u0010.\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dRB\u0010/\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u00100\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010R\u001a\u0004\b0\u0010T\"\u0004\bj\u0010VR$\u00101\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u00102\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u00103\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010Y\u001a\u0004\bu\u0010[\"\u0004\bv\u0010]R\"\u00104\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010R\u001a\u0004\b4\u0010T\"\u0004\bw\u0010VR$\u00105\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "Ljava/io/Serializable;", "Lcom/tencent/videocut/model/MediaModel;", "component1", "", "component2", "", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "component3", "Lcom/tencent/videocut/model/FilterModel;", "component4", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "component5", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkStickerModelExtra;", "component6", "", "component7", "Lcom/tencent/videocut/model/SpecialEffectModel;", "component8", "component9", "component10", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditStretchedData;", "component11", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component12", "component13", "Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicDataSerializable;", "component14", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "component15", "component16", "component17", "component18", "mediaModel", "durationUs", "stickerModelMap", "filterModelMap", "filterMaterialMap", "stickerExtraMap", "openHDR", "effectModelMap", "renderModelStr", "templateMaterialMap", "stretchData", "assetData", "isLakData", "mosaicData", "challengeData", "manualDeletedChallengeTag", "isAIElimination", "aiTemplate", "copy", "toString", "", "hashCode", "", "other", "equals", "Lcom/tencent/videocut/model/MediaModel;", "getMediaModel", "()Lcom/tencent/videocut/model/MediaModel;", "setMediaModel", "(Lcom/tencent/videocut/model/MediaModel;)V", "J", "getDurationUs", "()J", "setDurationUs", "(J)V", "Ljava/util/Map;", "getStickerModelMap", "()Ljava/util/Map;", "setStickerModelMap", "(Ljava/util/Map;)V", "getFilterModelMap", "setFilterModelMap", "getFilterMaterialMap", "setFilterMaterialMap", "getStickerExtraMap", "setStickerExtraMap", "Z", "getOpenHDR", "()Z", "setOpenHDR", "(Z)V", "getEffectModelMap", "setEffectModelMap", "Ljava/lang/String;", "getRenderModelStr", "()Ljava/lang/String;", "setRenderModelStr", "(Ljava/lang/String;)V", "getTemplateMaterialMap", "setTemplateMaterialMap", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditStretchedData;", "getStretchData", "()Lcom/tencent/mobileqq/wink/editor/draft/WinkEditStretchedData;", "setStretchData", "(Lcom/tencent/mobileqq/wink/editor/draft/WinkEditStretchedData;)V", "Ljava/util/HashMap;", "getAssetData", "()Ljava/util/HashMap;", "setAssetData", "(Ljava/util/HashMap;)V", "setLakData", "Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicDataSerializable;", "getMosaicData", "()Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicDataSerializable;", "setMosaicData", "(Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicDataSerializable;)V", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "getChallengeData", "()Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "setChallengeData", "(Lcom/tencent/mobileqq/wink/model/InteractiveModel;)V", "getManualDeletedChallengeTag", "setManualDeletedChallengeTag", "setAIElimination", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getAiTemplate", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setAiTemplate", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "<init>", "(Lcom/tencent/videocut/model/MediaModel;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZLjava/util/Map;Ljava/lang/String;Ljava/util/Map;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditStretchedData;Ljava/util/HashMap;ZLcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicDataSerializable;Lcom/tencent/mobileqq/wink/model/InteractiveModel;Ljava/lang/String;ZLcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class WinkEditData implements Serializable {
    private static final long serialVersionUID = 599093938747237758L;

    @Nullable
    private MetaMaterial aiTemplate;

    @Nullable
    private HashMap<String, String> assetData;

    @Nullable
    private InteractiveModel challengeData;
    private long durationUs;

    @Nullable
    private Map<String, SpecialEffectModel> effectModelMap;

    @Nullable
    private Map<String, MetaMaterial> filterMaterialMap;

    @Nullable
    private Map<String, FilterModel> filterModelMap;
    private boolean isAIElimination;
    private boolean isLakData;

    @Nullable
    private String manualDeletedChallengeTag;

    @NotNull
    private MediaModel mediaModel;

    @Nullable
    private MosaicDataSerializable mosaicData;
    private boolean openHDR;

    @Nullable
    private String renderModelStr;

    @Nullable
    private Map<String, WinkStickerModelExtra> stickerExtraMap;

    @Nullable
    private Map<String, WinkStickerModel> stickerModelMap;

    @Nullable
    private WinkEditStretchedData stretchData;

    @Nullable
    private Map<String, MetaMaterial> templateMaterialMap;

    public WinkEditData(@NotNull MediaModel mediaModel, long j3, @Nullable Map<String, WinkStickerModel> map, @Nullable Map<String, FilterModel> map2, @Nullable Map<String, MetaMaterial> map3, @Nullable Map<String, WinkStickerModelExtra> map4, boolean z16, @Nullable Map<String, SpecialEffectModel> map5, @Nullable String str, @Nullable Map<String, MetaMaterial> map6, @Nullable WinkEditStretchedData winkEditStretchedData, @Nullable HashMap<String, String> hashMap, boolean z17, @Nullable MosaicDataSerializable mosaicDataSerializable, @Nullable InteractiveModel interactiveModel, @Nullable String str2, boolean z18, @Nullable MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        this.mediaModel = mediaModel;
        this.durationUs = j3;
        this.stickerModelMap = map;
        this.filterModelMap = map2;
        this.filterMaterialMap = map3;
        this.stickerExtraMap = map4;
        this.openHDR = z16;
        this.effectModelMap = map5;
        this.renderModelStr = str;
        this.templateMaterialMap = map6;
        this.stretchData = winkEditStretchedData;
        this.assetData = hashMap;
        this.isLakData = z17;
        this.mosaicData = mosaicDataSerializable;
        this.challengeData = interactiveModel;
        this.manualDeletedChallengeTag = str2;
        this.isAIElimination = z18;
        this.aiTemplate = metaMaterial;
    }

    public static /* synthetic */ WinkEditData copy$default(WinkEditData winkEditData, MediaModel mediaModel, long j3, Map map, Map map2, Map map3, Map map4, boolean z16, Map map5, String str, Map map6, WinkEditStretchedData winkEditStretchedData, HashMap hashMap, boolean z17, MosaicDataSerializable mosaicDataSerializable, InteractiveModel interactiveModel, String str2, boolean z18, MetaMaterial metaMaterial, int i3, Object obj) {
        return winkEditData.copy((i3 & 1) != 0 ? winkEditData.mediaModel : mediaModel, (i3 & 2) != 0 ? winkEditData.durationUs : j3, (i3 & 4) != 0 ? winkEditData.stickerModelMap : map, (i3 & 8) != 0 ? winkEditData.filterModelMap : map2, (i3 & 16) != 0 ? winkEditData.filterMaterialMap : map3, (i3 & 32) != 0 ? winkEditData.stickerExtraMap : map4, (i3 & 64) != 0 ? winkEditData.openHDR : z16, (i3 & 128) != 0 ? winkEditData.effectModelMap : map5, (i3 & 256) != 0 ? winkEditData.renderModelStr : str, (i3 & 512) != 0 ? winkEditData.templateMaterialMap : map6, (i3 & 1024) != 0 ? winkEditData.stretchData : winkEditStretchedData, (i3 & 2048) != 0 ? winkEditData.assetData : hashMap, (i3 & 4096) != 0 ? winkEditData.isLakData : z17, (i3 & 8192) != 0 ? winkEditData.mosaicData : mosaicDataSerializable, (i3 & 16384) != 0 ? winkEditData.challengeData : interactiveModel, (i3 & 32768) != 0 ? winkEditData.manualDeletedChallengeTag : str2, (i3 & 65536) != 0 ? winkEditData.isAIElimination : z18, (i3 & 131072) != 0 ? winkEditData.aiTemplate : metaMaterial);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final MediaModel getMediaModel() {
        return this.mediaModel;
    }

    @Nullable
    public final Map<String, MetaMaterial> component10() {
        return this.templateMaterialMap;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final WinkEditStretchedData getStretchData() {
        return this.stretchData;
    }

    @Nullable
    public final HashMap<String, String> component12() {
        return this.assetData;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsLakData() {
        return this.isLakData;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final MosaicDataSerializable getMosaicData() {
        return this.mosaicData;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final InteractiveModel getChallengeData() {
        return this.challengeData;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getManualDeletedChallengeTag() {
        return this.manualDeletedChallengeTag;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getIsAIElimination() {
        return this.isAIElimination;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final MetaMaterial getAiTemplate() {
        return this.aiTemplate;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDurationUs() {
        return this.durationUs;
    }

    @Nullable
    public final Map<String, WinkStickerModel> component3() {
        return this.stickerModelMap;
    }

    @Nullable
    public final Map<String, FilterModel> component4() {
        return this.filterModelMap;
    }

    @Nullable
    public final Map<String, MetaMaterial> component5() {
        return this.filterMaterialMap;
    }

    @Nullable
    public final Map<String, WinkStickerModelExtra> component6() {
        return this.stickerExtraMap;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getOpenHDR() {
        return this.openHDR;
    }

    @Nullable
    public final Map<String, SpecialEffectModel> component8() {
        return this.effectModelMap;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getRenderModelStr() {
        return this.renderModelStr;
    }

    @NotNull
    public final WinkEditData copy(@NotNull MediaModel mediaModel, long durationUs, @Nullable Map<String, WinkStickerModel> stickerModelMap, @Nullable Map<String, FilterModel> filterModelMap, @Nullable Map<String, MetaMaterial> filterMaterialMap, @Nullable Map<String, WinkStickerModelExtra> stickerExtraMap, boolean openHDR, @Nullable Map<String, SpecialEffectModel> effectModelMap, @Nullable String renderModelStr, @Nullable Map<String, MetaMaterial> templateMaterialMap, @Nullable WinkEditStretchedData stretchData, @Nullable HashMap<String, String> assetData, boolean isLakData, @Nullable MosaicDataSerializable mosaicData, @Nullable InteractiveModel challengeData, @Nullable String manualDeletedChallengeTag, boolean isAIElimination, @Nullable MetaMaterial aiTemplate) {
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        return new WinkEditData(mediaModel, durationUs, stickerModelMap, filterModelMap, filterMaterialMap, stickerExtraMap, openHDR, effectModelMap, renderModelStr, templateMaterialMap, stretchData, assetData, isLakData, mosaicData, challengeData, manualDeletedChallengeTag, isAIElimination, aiTemplate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkEditData)) {
            return false;
        }
        WinkEditData winkEditData = (WinkEditData) other;
        if (Intrinsics.areEqual(this.mediaModel, winkEditData.mediaModel) && this.durationUs == winkEditData.durationUs && Intrinsics.areEqual(this.stickerModelMap, winkEditData.stickerModelMap) && Intrinsics.areEqual(this.filterModelMap, winkEditData.filterModelMap) && Intrinsics.areEqual(this.filterMaterialMap, winkEditData.filterMaterialMap) && Intrinsics.areEqual(this.stickerExtraMap, winkEditData.stickerExtraMap) && this.openHDR == winkEditData.openHDR && Intrinsics.areEqual(this.effectModelMap, winkEditData.effectModelMap) && Intrinsics.areEqual(this.renderModelStr, winkEditData.renderModelStr) && Intrinsics.areEqual(this.templateMaterialMap, winkEditData.templateMaterialMap) && Intrinsics.areEqual(this.stretchData, winkEditData.stretchData) && Intrinsics.areEqual(this.assetData, winkEditData.assetData) && this.isLakData == winkEditData.isLakData && Intrinsics.areEqual(this.mosaicData, winkEditData.mosaicData) && Intrinsics.areEqual(this.challengeData, winkEditData.challengeData) && Intrinsics.areEqual(this.manualDeletedChallengeTag, winkEditData.manualDeletedChallengeTag) && this.isAIElimination == winkEditData.isAIElimination && Intrinsics.areEqual(this.aiTemplate, winkEditData.aiTemplate)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final MetaMaterial getAiTemplate() {
        return this.aiTemplate;
    }

    @Nullable
    public final HashMap<String, String> getAssetData() {
        return this.assetData;
    }

    @Nullable
    public final InteractiveModel getChallengeData() {
        return this.challengeData;
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    @Nullable
    public final Map<String, SpecialEffectModel> getEffectModelMap() {
        return this.effectModelMap;
    }

    @Nullable
    public final Map<String, MetaMaterial> getFilterMaterialMap() {
        return this.filterMaterialMap;
    }

    @Nullable
    public final Map<String, FilterModel> getFilterModelMap() {
        return this.filterModelMap;
    }

    @Nullable
    public final String getManualDeletedChallengeTag() {
        return this.manualDeletedChallengeTag;
    }

    @NotNull
    public final MediaModel getMediaModel() {
        return this.mediaModel;
    }

    @Nullable
    public final MosaicDataSerializable getMosaicData() {
        return this.mosaicData;
    }

    public final boolean getOpenHDR() {
        return this.openHDR;
    }

    @Nullable
    public final String getRenderModelStr() {
        return this.renderModelStr;
    }

    @Nullable
    public final Map<String, WinkStickerModelExtra> getStickerExtraMap() {
        return this.stickerExtraMap;
    }

    @Nullable
    public final Map<String, WinkStickerModel> getStickerModelMap() {
        return this.stickerModelMap;
    }

    @Nullable
    public final WinkEditStretchedData getStretchData() {
        return this.stretchData;
    }

    @Nullable
    public final Map<String, MetaMaterial> getTemplateMaterialMap() {
        return this.templateMaterialMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        int hashCode13 = ((this.mediaModel.hashCode() * 31) + androidx.fragment.app.a.a(this.durationUs)) * 31;
        Map<String, WinkStickerModel> map = this.stickerModelMap;
        int i3 = 0;
        if (map == null) {
            hashCode = 0;
        } else {
            hashCode = map.hashCode();
        }
        int i16 = (hashCode13 + hashCode) * 31;
        Map<String, FilterModel> map2 = this.filterModelMap;
        if (map2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = map2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Map<String, MetaMaterial> map3 = this.filterMaterialMap;
        if (map3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = map3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Map<String, WinkStickerModelExtra> map4 = this.stickerExtraMap;
        if (map4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = map4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        boolean z16 = this.openHDR;
        int i26 = 1;
        int i27 = z16;
        if (z16 != 0) {
            i27 = 1;
        }
        int i28 = (i19 + i27) * 31;
        Map<String, SpecialEffectModel> map5 = this.effectModelMap;
        if (map5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = map5.hashCode();
        }
        int i29 = (i28 + hashCode5) * 31;
        String str = this.renderModelStr;
        if (str == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str.hashCode();
        }
        int i36 = (i29 + hashCode6) * 31;
        Map<String, MetaMaterial> map6 = this.templateMaterialMap;
        if (map6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = map6.hashCode();
        }
        int i37 = (i36 + hashCode7) * 31;
        WinkEditStretchedData winkEditStretchedData = this.stretchData;
        if (winkEditStretchedData == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = winkEditStretchedData.hashCode();
        }
        int i38 = (i37 + hashCode8) * 31;
        HashMap<String, String> hashMap = this.assetData;
        if (hashMap == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = hashMap.hashCode();
        }
        int i39 = (i38 + hashCode9) * 31;
        boolean z17 = this.isLakData;
        int i46 = z17;
        if (z17 != 0) {
            i46 = 1;
        }
        int i47 = (i39 + i46) * 31;
        MosaicDataSerializable mosaicDataSerializable = this.mosaicData;
        if (mosaicDataSerializable == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = mosaicDataSerializable.hashCode();
        }
        int i48 = (i47 + hashCode10) * 31;
        InteractiveModel interactiveModel = this.challengeData;
        if (interactiveModel == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = interactiveModel.hashCode();
        }
        int i49 = (i48 + hashCode11) * 31;
        String str2 = this.manualDeletedChallengeTag;
        if (str2 == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = str2.hashCode();
        }
        int i56 = (i49 + hashCode12) * 31;
        boolean z18 = this.isAIElimination;
        if (!z18) {
            i26 = z18 ? 1 : 0;
        }
        int i57 = (i56 + i26) * 31;
        MetaMaterial metaMaterial = this.aiTemplate;
        if (metaMaterial != null) {
            i3 = metaMaterial.hashCode();
        }
        return i57 + i3;
    }

    public final boolean isAIElimination() {
        return this.isAIElimination;
    }

    public final boolean isLakData() {
        return this.isLakData;
    }

    public final void setAIElimination(boolean z16) {
        this.isAIElimination = z16;
    }

    public final void setAiTemplate(@Nullable MetaMaterial metaMaterial) {
        this.aiTemplate = metaMaterial;
    }

    public final void setAssetData(@Nullable HashMap<String, String> hashMap) {
        this.assetData = hashMap;
    }

    public final void setChallengeData(@Nullable InteractiveModel interactiveModel) {
        this.challengeData = interactiveModel;
    }

    public final void setDurationUs(long j3) {
        this.durationUs = j3;
    }

    public final void setEffectModelMap(@Nullable Map<String, SpecialEffectModel> map) {
        this.effectModelMap = map;
    }

    public final void setFilterMaterialMap(@Nullable Map<String, MetaMaterial> map) {
        this.filterMaterialMap = map;
    }

    public final void setFilterModelMap(@Nullable Map<String, FilterModel> map) {
        this.filterModelMap = map;
    }

    public final void setLakData(boolean z16) {
        this.isLakData = z16;
    }

    public final void setManualDeletedChallengeTag(@Nullable String str) {
        this.manualDeletedChallengeTag = str;
    }

    public final void setMediaModel(@NotNull MediaModel mediaModel) {
        Intrinsics.checkNotNullParameter(mediaModel, "<set-?>");
        this.mediaModel = mediaModel;
    }

    public final void setMosaicData(@Nullable MosaicDataSerializable mosaicDataSerializable) {
        this.mosaicData = mosaicDataSerializable;
    }

    public final void setOpenHDR(boolean z16) {
        this.openHDR = z16;
    }

    public final void setRenderModelStr(@Nullable String str) {
        this.renderModelStr = str;
    }

    public final void setStickerExtraMap(@Nullable Map<String, WinkStickerModelExtra> map) {
        this.stickerExtraMap = map;
    }

    public final void setStickerModelMap(@Nullable Map<String, WinkStickerModel> map) {
        this.stickerModelMap = map;
    }

    public final void setStretchData(@Nullable WinkEditStretchedData winkEditStretchedData) {
        this.stretchData = winkEditStretchedData;
    }

    public final void setTemplateMaterialMap(@Nullable Map<String, MetaMaterial> map) {
        this.templateMaterialMap = map;
    }

    @NotNull
    public String toString() {
        return "WinkEditData(mediaModel=" + this.mediaModel + ", durationUs=" + this.durationUs + ", stickerModelMap=" + this.stickerModelMap + ", filterModelMap=" + this.filterModelMap + ", filterMaterialMap=" + this.filterMaterialMap + ", stickerExtraMap=" + this.stickerExtraMap + ", openHDR=" + this.openHDR + ", effectModelMap=" + this.effectModelMap + ", renderModelStr=" + this.renderModelStr + ", templateMaterialMap=" + this.templateMaterialMap + ", stretchData=" + this.stretchData + ", assetData=" + this.assetData + ", isLakData=" + this.isLakData + ", mosaicData=" + this.mosaicData + ", challengeData=" + this.challengeData + ", manualDeletedChallengeTag=" + this.manualDeletedChallengeTag + ", isAIElimination=" + this.isAIElimination + ", aiTemplate=" + this.aiTemplate + ")";
    }

    public /* synthetic */ WinkEditData(MediaModel mediaModel, long j3, Map map, Map map2, Map map3, Map map4, boolean z16, Map map5, String str, Map map6, WinkEditStretchedData winkEditStretchedData, HashMap hashMap, boolean z17, MosaicDataSerializable mosaicDataSerializable, InteractiveModel interactiveModel, String str2, boolean z18, MetaMaterial metaMaterial, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(mediaModel, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? null : map, (i3 & 8) != 0 ? null : map2, (i3 & 16) != 0 ? null : map3, (i3 & 32) != 0 ? null : map4, (i3 & 64) != 0 ? false : z16, (i3 & 128) != 0 ? null : map5, (i3 & 256) != 0 ? null : str, (i3 & 512) != 0 ? null : map6, (i3 & 1024) != 0 ? null : winkEditStretchedData, (i3 & 2048) != 0 ? null : hashMap, (i3 & 4096) != 0 ? false : z17, (i3 & 8192) != 0 ? null : mosaicDataSerializable, (i3 & 16384) != 0 ? null : interactiveModel, (i3 & 32768) != 0 ? "" : str2, (i3 & 65536) != 0 ? false : z18, (i3 & 131072) != 0 ? null : metaMaterial);
    }
}
