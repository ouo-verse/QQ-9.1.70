package com.tencent.qcircle.weseevideo.model.template.light;

import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.qcircle.weseevideo.model.utils.FileUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.ClipPlaceHolder;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u00cd\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\u0002\u0010\u001dJ\u0006\u0010K\u001a\u00020LJ\u000b\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u001aH\u00c6\u0003J\t\u0010S\u001a\u00020\u001cH\u00c6\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00c6\u0003J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u00d1\u0001\u0010\\\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u00c6\u0001J\u0006\u0010]\u001a\u00020\u0000J\u0013\u0010^\u001a\u00020\u001c2\b\u0010_\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010`\u001a\u00020aH\u00d6\u0001J\u0006\u0010b\u001a\u00020\u001cJ\t\u0010c\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010'\"\u0004\b@\u0010)R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010#\"\u0004\bF\u0010%R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010#\"\u0004\bH\u0010%R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010%\u00a8\u0006d"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/template/light/LightMediaTemplateModel;", "", "filePath", "", "templateId", WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE, "templateCateId", "clipPlaceHolders", "", "Lorg/light/ClipPlaceHolder;", "segmentModels", "", "Lcom/tencent/qcircle/weseevideo/model/template/movie/MovieSegmentModel;", "segmentInfo", "maxDuration", "Lcom/tencent/tav/coremedia/CMTime;", "minDuration", "lightStickerTextModels", "", "Lcom/tencent/qcircle/weseevideo/model/template/light/LightStickerTextModel;", "aiAbilityModel", "Lcom/tencent/qcircle/weseevideo/model/template/movie/AIAbilityModel;", "templateBean", "Lcom/tencent/qcircle/weishi/module/publisher/entity/TemplateBean;", "backgroundEffectPath", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "isRedTemplate", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;Ljava/util/Map;Lcom/tencent/qcircle/weseevideo/model/template/movie/AIAbilityModel;Lcom/tencent/qcircle/weishi/module/publisher/entity/TemplateBean;Ljava/lang/String;Lcom/tencent/tav/coremedia/CGSize;Z)V", "getAiAbilityModel", "()Lcom/tencent/qcircle/weseevideo/model/template/movie/AIAbilityModel;", "setAiAbilityModel", "(Lcom/tencent/qcircle/weseevideo/model/template/movie/AIAbilityModel;)V", "getBackgroundEffectPath", "()Ljava/lang/String;", "setBackgroundEffectPath", "(Ljava/lang/String;)V", "getClipPlaceHolders", "()Ljava/util/List;", "setClipPlaceHolders", "(Ljava/util/List;)V", "getFilePath", "setFilePath", "()Z", "setRedTemplate", "(Z)V", "isSwitchByUser", "setSwitchByUser", "getLightStickerTextModels", "()Ljava/util/Map;", "getMaxDuration", "()Lcom/tencent/tav/coremedia/CMTime;", "setMaxDuration", "(Lcom/tencent/tav/coremedia/CMTime;)V", "getMinDuration", "setMinDuration", "getRenderSize", "()Lcom/tencent/tav/coremedia/CGSize;", "setRenderSize", "(Lcom/tencent/tav/coremedia/CGSize;)V", "getSegmentInfo", "setSegmentInfo", "getSegmentModels", "setSegmentModels", "getTemplateBean", "()Lcom/tencent/qcircle/weishi/module/publisher/entity/TemplateBean;", "setTemplateBean", "(Lcom/tencent/qcircle/weishi/module/publisher/entity/TemplateBean;)V", "getTemplateCateId", "setTemplateCateId", "getTemplateId", "setTemplateId", "getTemplateType", "setTemplateType", "clearSegmentModels", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "deepCopy", "equals", "other", "hashCode", "", "isEmpty", "toString", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class LightMediaTemplateModel {

    @Nullable
    private AIAbilityModel aiAbilityModel;

    @Nullable
    private String backgroundEffectPath;

    @Nullable
    private List<? extends ClipPlaceHolder> clipPlaceHolders;

    @Nullable
    private String filePath;
    private boolean isRedTemplate;
    private transient boolean isSwitchByUser;

    @NotNull
    private final Map<String, LightStickerTextModel> lightStickerTextModels;

    @Nullable
    private CMTime maxDuration;

    @Nullable
    private CMTime minDuration;

    @Nullable
    private CGSize renderSize;

    @Nullable
    private String segmentInfo;

    @Nullable
    private List<MovieSegmentModel> segmentModels;

    @Nullable
    private TemplateBean templateBean;

    @Nullable
    private String templateCateId;

    @Nullable
    private String templateId;

    @Nullable
    private String templateType;

    public LightMediaTemplateModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 32767, null);
    }

    public static /* synthetic */ LightMediaTemplateModel copy$default(LightMediaTemplateModel lightMediaTemplateModel, String str, String str2, String str3, String str4, List list, List list2, String str5, CMTime cMTime, CMTime cMTime2, Map map, AIAbilityModel aIAbilityModel, TemplateBean templateBean, String str6, CGSize cGSize, boolean z16, int i3, Object obj) {
        return lightMediaTemplateModel.copy((i3 & 1) != 0 ? lightMediaTemplateModel.filePath : str, (i3 & 2) != 0 ? lightMediaTemplateModel.templateId : str2, (i3 & 4) != 0 ? lightMediaTemplateModel.templateType : str3, (i3 & 8) != 0 ? lightMediaTemplateModel.templateCateId : str4, (i3 & 16) != 0 ? lightMediaTemplateModel.clipPlaceHolders : list, (i3 & 32) != 0 ? lightMediaTemplateModel.segmentModels : list2, (i3 & 64) != 0 ? lightMediaTemplateModel.segmentInfo : str5, (i3 & 128) != 0 ? lightMediaTemplateModel.maxDuration : cMTime, (i3 & 256) != 0 ? lightMediaTemplateModel.minDuration : cMTime2, (i3 & 512) != 0 ? lightMediaTemplateModel.lightStickerTextModels : map, (i3 & 1024) != 0 ? lightMediaTemplateModel.aiAbilityModel : aIAbilityModel, (i3 & 2048) != 0 ? lightMediaTemplateModel.templateBean : templateBean, (i3 & 4096) != 0 ? lightMediaTemplateModel.backgroundEffectPath : str6, (i3 & 8192) != 0 ? lightMediaTemplateModel.renderSize : cGSize, (i3 & 16384) != 0 ? lightMediaTemplateModel.isRedTemplate : z16);
    }

    public final void clearSegmentModels() {
        List<MovieSegmentModel> list = this.segmentModels;
        if (list != null) {
            list.clear();
        }
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    @NotNull
    public final Map<String, LightStickerTextModel> component10() {
        return this.lightStickerTextModels;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final AIAbilityModel getAiAbilityModel() {
        return this.aiAbilityModel;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final TemplateBean getTemplateBean() {
        return this.templateBean;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getBackgroundEffectPath() {
        return this.backgroundEffectPath;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final CGSize getRenderSize() {
        return this.renderSize;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getIsRedTemplate() {
        return this.isRedTemplate;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTemplateId() {
        return this.templateId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getTemplateType() {
        return this.templateType;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getTemplateCateId() {
        return this.templateCateId;
    }

    @Nullable
    public final List<ClipPlaceHolder> component5() {
        return this.clipPlaceHolders;
    }

    @Nullable
    public final List<MovieSegmentModel> component6() {
        return this.segmentModels;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getSegmentInfo() {
        return this.segmentInfo;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final CMTime getMaxDuration() {
        return this.maxDuration;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final CMTime getMinDuration() {
        return this.minDuration;
    }

    @NotNull
    public final LightMediaTemplateModel copy(@Nullable String filePath, @Nullable String templateId, @Nullable String templateType, @Nullable String templateCateId, @Nullable List<? extends ClipPlaceHolder> clipPlaceHolders, @Nullable List<MovieSegmentModel> segmentModels, @Nullable String segmentInfo, @Nullable CMTime maxDuration, @Nullable CMTime minDuration, @NotNull Map<String, LightStickerTextModel> lightStickerTextModels, @Nullable AIAbilityModel aiAbilityModel, @Nullable TemplateBean templateBean, @Nullable String backgroundEffectPath, @Nullable CGSize renderSize, boolean isRedTemplate) {
        Intrinsics.checkParameterIsNotNull(lightStickerTextModels, "lightStickerTextModels");
        return new LightMediaTemplateModel(filePath, templateId, templateType, templateCateId, clipPlaceHolders, segmentModels, segmentInfo, maxDuration, minDuration, lightStickerTextModels, aiAbilityModel, templateBean, backgroundEffectPath, renderSize, isRedTemplate);
    }

    @NotNull
    public final LightMediaTemplateModel deepCopy() {
        CMTime cMTime;
        CMTime cMTime2;
        List list;
        CMTime cMTime3;
        ArrayList arrayList;
        int mapCapacity;
        Map mutableMap;
        TemplateBean templateBean;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List mutableList;
        CMTime cMTime4 = this.maxDuration;
        if (cMTime4 != null) {
            cMTime = cMTime4.m259clone();
        } else {
            cMTime = null;
        }
        CMTime cMTime5 = this.minDuration;
        if (cMTime5 != null) {
            cMTime2 = cMTime5.m259clone();
        } else {
            cMTime2 = null;
        }
        List<MovieSegmentModel> list2 = this.segmentModels;
        if (list2 != null) {
            List<MovieSegmentModel> list3 = list2;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList2.add(((MovieSegmentModel) it.next()).m238clone());
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
            list = mutableList;
        } else {
            list = null;
        }
        List<? extends ClipPlaceHolder> list4 = this.clipPlaceHolders;
        if (list4 != null) {
            List<? extends ClipPlaceHolder> list5 = list4;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            for (ClipPlaceHolder clipPlaceHolder : list5) {
                arrayList.add(new ClipPlaceHolder(clipPlaceHolder.contentDuration, clipPlaceHolder.fillMode, clipPlaceHolder.width, clipPlaceHolder.height, clipPlaceHolder.volume));
                cMTime = cMTime;
            }
            cMTime3 = cMTime;
        } else {
            cMTime3 = cMTime;
            arrayList = null;
        }
        Map<String, LightStickerTextModel> map = this.lightStickerTextModels;
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(map.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it5 = map.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it5.next();
            linkedHashMap.put(entry.getKey(), LightStickerTextModel.copy$default((LightStickerTextModel) entry.getValue(), null, 0, 3, null));
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        TemplateBean templateBean2 = this.templateBean;
        if (templateBean2 != null) {
            templateBean = templateBean2.m237clone();
        } else {
            templateBean = null;
        }
        return copy$default(this, null, null, null, null, arrayList, list, null, cMTime3, cMTime2, mutableMap, null, templateBean, null, null, false, 29775, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof LightMediaTemplateModel) {
                LightMediaTemplateModel lightMediaTemplateModel = (LightMediaTemplateModel) other;
                if (!Intrinsics.areEqual(this.filePath, lightMediaTemplateModel.filePath) || !Intrinsics.areEqual(this.templateId, lightMediaTemplateModel.templateId) || !Intrinsics.areEqual(this.templateType, lightMediaTemplateModel.templateType) || !Intrinsics.areEqual(this.templateCateId, lightMediaTemplateModel.templateCateId) || !Intrinsics.areEqual(this.clipPlaceHolders, lightMediaTemplateModel.clipPlaceHolders) || !Intrinsics.areEqual(this.segmentModels, lightMediaTemplateModel.segmentModels) || !Intrinsics.areEqual(this.segmentInfo, lightMediaTemplateModel.segmentInfo) || !Intrinsics.areEqual(this.maxDuration, lightMediaTemplateModel.maxDuration) || !Intrinsics.areEqual(this.minDuration, lightMediaTemplateModel.minDuration) || !Intrinsics.areEqual(this.lightStickerTextModels, lightMediaTemplateModel.lightStickerTextModels) || !Intrinsics.areEqual(this.aiAbilityModel, lightMediaTemplateModel.aiAbilityModel) || !Intrinsics.areEqual(this.templateBean, lightMediaTemplateModel.templateBean) || !Intrinsics.areEqual(this.backgroundEffectPath, lightMediaTemplateModel.backgroundEffectPath) || !Intrinsics.areEqual(this.renderSize, lightMediaTemplateModel.renderSize) || this.isRedTemplate != lightMediaTemplateModel.isRedTemplate) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final AIAbilityModel getAiAbilityModel() {
        return this.aiAbilityModel;
    }

    @Nullable
    public final String getBackgroundEffectPath() {
        return this.backgroundEffectPath;
    }

    @Nullable
    public final List<ClipPlaceHolder> getClipPlaceHolders() {
        return this.clipPlaceHolders;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    @NotNull
    public final Map<String, LightStickerTextModel> getLightStickerTextModels() {
        return this.lightStickerTextModels;
    }

    @Nullable
    public final CMTime getMaxDuration() {
        return this.maxDuration;
    }

    @Nullable
    public final CMTime getMinDuration() {
        return this.minDuration;
    }

    @Nullable
    public final CGSize getRenderSize() {
        return this.renderSize;
    }

    @Nullable
    public final String getSegmentInfo() {
        return this.segmentInfo;
    }

    @Nullable
    public final List<MovieSegmentModel> getSegmentModels() {
        return this.segmentModels;
    }

    @Nullable
    public final TemplateBean getTemplateBean() {
        return this.templateBean;
    }

    @Nullable
    public final String getTemplateCateId() {
        return this.templateCateId;
    }

    @Nullable
    public final String getTemplateId() {
        return this.templateId;
    }

    @Nullable
    public final String getTemplateType() {
        return this.templateType;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        String str = this.filePath;
        int i46 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i47 = i3 * 31;
        String str2 = this.templateId;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i48 = (i47 + i16) * 31;
        String str3 = this.templateType;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i49 = (i48 + i17) * 31;
        String str4 = this.templateCateId;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i56 = (i49 + i18) * 31;
        List<? extends ClipPlaceHolder> list = this.clipPlaceHolders;
        if (list != null) {
            i19 = list.hashCode();
        } else {
            i19 = 0;
        }
        int i57 = (i56 + i19) * 31;
        List<MovieSegmentModel> list2 = this.segmentModels;
        if (list2 != null) {
            i26 = list2.hashCode();
        } else {
            i26 = 0;
        }
        int i58 = (i57 + i26) * 31;
        String str5 = this.segmentInfo;
        if (str5 != null) {
            i27 = str5.hashCode();
        } else {
            i27 = 0;
        }
        int i59 = (i58 + i27) * 31;
        CMTime cMTime = this.maxDuration;
        if (cMTime != null) {
            i28 = cMTime.hashCode();
        } else {
            i28 = 0;
        }
        int i65 = (i59 + i28) * 31;
        CMTime cMTime2 = this.minDuration;
        if (cMTime2 != null) {
            i29 = cMTime2.hashCode();
        } else {
            i29 = 0;
        }
        int i66 = (i65 + i29) * 31;
        Map<String, LightStickerTextModel> map = this.lightStickerTextModels;
        if (map != null) {
            i36 = map.hashCode();
        } else {
            i36 = 0;
        }
        int i67 = (i66 + i36) * 31;
        AIAbilityModel aIAbilityModel = this.aiAbilityModel;
        if (aIAbilityModel != null) {
            i37 = aIAbilityModel.hashCode();
        } else {
            i37 = 0;
        }
        int i68 = (i67 + i37) * 31;
        TemplateBean templateBean = this.templateBean;
        if (templateBean != null) {
            i38 = templateBean.hashCode();
        } else {
            i38 = 0;
        }
        int i69 = (i68 + i38) * 31;
        String str6 = this.backgroundEffectPath;
        if (str6 != null) {
            i39 = str6.hashCode();
        } else {
            i39 = 0;
        }
        int i75 = (i69 + i39) * 31;
        CGSize cGSize = this.renderSize;
        if (cGSize != null) {
            i46 = cGSize.hashCode();
        }
        int i76 = (i75 + i46) * 31;
        boolean z16 = this.isRedTemplate;
        int i77 = z16;
        if (z16 != 0) {
            i77 = 1;
        }
        return i76 + i77;
    }

    public final boolean isEmpty() {
        if (!TextUtils.isEmpty(this.filePath) && FileUtils.exists(this.filePath)) {
            return false;
        }
        return true;
    }

    public final boolean isRedTemplate() {
        return this.isRedTemplate;
    }

    /* renamed from: isSwitchByUser, reason: from getter */
    public final boolean getIsSwitchByUser() {
        return this.isSwitchByUser;
    }

    public final void setAiAbilityModel(@Nullable AIAbilityModel aIAbilityModel) {
        this.aiAbilityModel = aIAbilityModel;
    }

    public final void setBackgroundEffectPath(@Nullable String str) {
        this.backgroundEffectPath = str;
    }

    public final void setClipPlaceHolders(@Nullable List<? extends ClipPlaceHolder> list) {
        this.clipPlaceHolders = list;
    }

    public final void setFilePath(@Nullable String str) {
        this.filePath = str;
    }

    public final void setMaxDuration(@Nullable CMTime cMTime) {
        this.maxDuration = cMTime;
    }

    public final void setMinDuration(@Nullable CMTime cMTime) {
        this.minDuration = cMTime;
    }

    public final void setRedTemplate(boolean z16) {
        this.isRedTemplate = z16;
    }

    public final void setRenderSize(@Nullable CGSize cGSize) {
        this.renderSize = cGSize;
    }

    public final void setSegmentInfo(@Nullable String str) {
        this.segmentInfo = str;
    }

    public final void setSegmentModels(@Nullable List<MovieSegmentModel> list) {
        this.segmentModels = list;
    }

    public final void setSwitchByUser(boolean z16) {
        this.isSwitchByUser = z16;
    }

    public final void setTemplateBean(@Nullable TemplateBean templateBean) {
        this.templateBean = templateBean;
    }

    public final void setTemplateCateId(@Nullable String str) {
        this.templateCateId = str;
    }

    public final void setTemplateId(@Nullable String str) {
        this.templateId = str;
    }

    public final void setTemplateType(@Nullable String str) {
        this.templateType = str;
    }

    @NotNull
    public String toString() {
        return "LightMediaTemplateModel(filePath=" + this.filePath + ", templateId=" + this.templateId + ", templateType=" + this.templateType + ", templateCateId=" + this.templateCateId + ", clipPlaceHolders=" + this.clipPlaceHolders + ", segmentModels=" + this.segmentModels + ", segmentInfo=" + this.segmentInfo + ", maxDuration=" + this.maxDuration + ", minDuration=" + this.minDuration + ", lightStickerTextModels=" + this.lightStickerTextModels + ", aiAbilityModel=" + this.aiAbilityModel + ", templateBean=" + this.templateBean + ", backgroundEffectPath=" + this.backgroundEffectPath + ", renderSize=" + this.renderSize + ", isRedTemplate=" + this.isRedTemplate + ")";
    }

    public LightMediaTemplateModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable List<? extends ClipPlaceHolder> list, @Nullable List<MovieSegmentModel> list2, @Nullable String str5, @Nullable CMTime cMTime, @Nullable CMTime cMTime2, @NotNull Map<String, LightStickerTextModel> lightStickerTextModels, @Nullable AIAbilityModel aIAbilityModel, @Nullable TemplateBean templateBean, @Nullable String str6, @Nullable CGSize cGSize, boolean z16) {
        Intrinsics.checkParameterIsNotNull(lightStickerTextModels, "lightStickerTextModels");
        this.filePath = str;
        this.templateId = str2;
        this.templateType = str3;
        this.templateCateId = str4;
        this.clipPlaceHolders = list;
        this.segmentModels = list2;
        this.segmentInfo = str5;
        this.maxDuration = cMTime;
        this.minDuration = cMTime2;
        this.lightStickerTextModels = lightStickerTextModels;
        this.aiAbilityModel = aIAbilityModel;
        this.templateBean = templateBean;
        this.backgroundEffectPath = str6;
        this.renderSize = cGSize;
        this.isRedTemplate = z16;
    }

    public /* synthetic */ LightMediaTemplateModel(String str, String str2, String str3, String str4, List list, List list2, String str5, CMTime cMTime, CMTime cMTime2, Map map, AIAbilityModel aIAbilityModel, TemplateBean templateBean, String str6, CGSize cGSize, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) == 0 ? str2 : "", (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : list, (i3 & 32) != 0 ? new ArrayList() : list2, (i3 & 64) != 0 ? null : str5, (i3 & 128) != 0 ? null : cMTime, (i3 & 256) != 0 ? null : cMTime2, (i3 & 512) != 0 ? new HashMap() : map, (i3 & 1024) != 0 ? new AIAbilityModel() : aIAbilityModel, (i3 & 2048) != 0 ? null : templateBean, (i3 & 4096) != 0 ? null : str6, (i3 & 8192) == 0 ? cGSize : null, (i3 & 16384) != 0 ? false : z16);
    }
}
