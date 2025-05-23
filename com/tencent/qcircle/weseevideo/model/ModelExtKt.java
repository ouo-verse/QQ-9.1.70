package com.tencent.qcircle.weseevideo.model;

import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectParameter;
import com.tencent.autotemplate.model.TAVEffectsModel;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFrameModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFramePAGItem;
import com.tencent.qcircle.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002\u001a\u0014\u0010\f\u001a\u00020\u0007*\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0007*\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000e\u00a8\u0006\u0011"}, d2 = {"isAutoTemplate", "", "Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "isImageMode", "isLightTemplate", "isMovieTemplate", "selectNearRatioPagFile", "", "Lcom/tencent/autotemplate/TAVAutomaticTemplate;", "templateModel", "Lcom/tencent/qcircle/weseevideo/model/template/auto/AutomaticMediaTemplateModel;", "mediaModel", "updateFrameColor", "color", "", "updateFrameFillMode", "fillMode", "libtavcut_debug"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class ModelExtKt {
    public static final boolean isAutoTemplate(@Nullable MediaModel mediaModel) {
        MediaTemplateModel mediaTemplateModel;
        if (mediaModel != null && (mediaTemplateModel = mediaModel.getMediaTemplateModel()) != null && !mediaTemplateModel.isAutoTemplateEmpty()) {
            return true;
        }
        return false;
    }

    public static final boolean isImageMode(@Nullable MediaModel mediaModel) {
        MediaResourceModel mediaResourceModel;
        List<MediaClipModel> videos;
        if (mediaModel == null || (mediaResourceModel = mediaModel.getMediaResourceModel()) == null || (videos = mediaResourceModel.getVideos()) == null || videos.size() != 1) {
            return false;
        }
        int type = mediaModel.getMediaResourceModel().getVideos().get(0).getResource().getType();
        if (type != 2 && type != 4) {
            return false;
        }
        return true;
    }

    public static final boolean isLightTemplate(@Nullable MediaModel mediaModel) {
        MediaTemplateModel mediaTemplateModel;
        if (mediaModel != null && (mediaTemplateModel = mediaModel.getMediaTemplateModel()) != null && !mediaTemplateModel.isLightTemplateEmpty()) {
            return true;
        }
        return false;
    }

    public static final boolean isMovieTemplate(@Nullable MediaModel mediaModel) {
        MediaTemplateModel mediaTemplateModel;
        if (mediaModel != null && (mediaTemplateModel = mediaModel.getMediaTemplateModel()) != null && !mediaTemplateModel.isMovieTemplateEmpty()) {
            return true;
        }
        return false;
    }

    public static final void selectNearRatioPagFile(@Nullable TAVAutomaticTemplate tAVAutomaticTemplate, @NotNull AutomaticMediaTemplateModel templateModel, @NotNull MediaModel mediaModel) {
        int i3;
        Object firstOrNull;
        float f16;
        AEFramePAGItem aEFramePAGItem;
        String pagName;
        TAVEffectsModel effectsModel;
        List<TAVEffectAutomaticEffect> list;
        Object firstOrNull2;
        TAVEffectParameter tAVEffectParameter;
        ArrayList<AEFramePAGItem> pagItems;
        VideoResourceModel resource;
        CropConfig cropConfig;
        ArrayList<AEFramePAGItem> pagItems2;
        Intrinsics.checkParameterIsNotNull(templateModel, "templateModel");
        Intrinsics.checkParameterIsNotNull(mediaModel, "mediaModel");
        AEFrameModel aEFrameModel = templateModel.getAEFrameModel();
        if (aEFrameModel != null && (pagItems2 = aEFrameModel.getPagItems()) != null) {
            i3 = pagItems2.size();
        } else {
            i3 = 0;
        }
        String str = "";
        if (i3 > 1) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mediaModel.getMediaResourceModel().getVideos());
            MediaClipModel mediaClipModel = (MediaClipModel) firstOrNull;
            if (mediaClipModel != null && (resource = mediaClipModel.getResource()) != null) {
                CropModel cropModel = mediaModel.getMediaEffectModel().getCropModel();
                if (cropModel != null && (cropConfig = cropModel.getCropConfig()) != null) {
                    f16 = (resource.getWidth() * cropConfig.getWidth()) / (resource.getHeight() * cropConfig.getHeight());
                } else {
                    f16 = resource.getWidth() / resource.getHeight();
                }
            } else {
                f16 = 1.0f;
            }
            float max_value = FloatCompanionObject.INSTANCE.getMAX_VALUE();
            AEFrameModel aEFrameModel2 = templateModel.getAEFrameModel();
            String str2 = null;
            if (aEFrameModel2 != null && (pagItems = aEFrameModel2.getPagItems()) != null) {
                aEFramePAGItem = null;
                for (AEFramePAGItem aEFramePAGItem2 : pagItems) {
                    float abs = Math.abs(aEFramePAGItem2.getVisibleRatio() - f16);
                    if (abs < max_value) {
                        aEFramePAGItem = aEFramePAGItem2;
                        max_value = abs;
                    }
                }
            } else {
                aEFramePAGItem = null;
            }
            if (tAVAutomaticTemplate != null && (effectsModel = tAVAutomaticTemplate.getEffectsModel()) != null && (list = effectsModel.filterEffects) != null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                TAVEffectAutomaticEffect tAVEffectAutomaticEffect = (TAVEffectAutomaticEffect) firstOrNull2;
                if (tAVEffectAutomaticEffect != null && (tAVEffectParameter = tAVEffectAutomaticEffect.parameter) != null) {
                    if (aEFramePAGItem != null) {
                        str2 = aEFramePAGItem.getPagName();
                    }
                    tAVEffectParameter.filePath = str2;
                }
            }
            AEFrameModel aEFrameModel3 = templateModel.getAEFrameModel();
            if (aEFrameModel3 != null) {
                if (aEFramePAGItem != null && (pagName = aEFramePAGItem.getPagName()) != null) {
                    str = pagName;
                }
                aEFrameModel3.setSelectedPAGName(str);
                return;
            }
            return;
        }
        AEFrameModel aEFrameModel4 = templateModel.getAEFrameModel();
        if (aEFrameModel4 != null) {
            aEFrameModel4.setSelectedPAGName("");
        }
    }

    public static final void updateFrameColor(@Nullable MediaModel mediaModel, int i3) {
        MediaTemplateModel mediaTemplateModel;
        AutomaticMediaTemplateModel automaticMediaTemplateModel;
        AEFrameModel aEFrameModel;
        if (mediaModel != null && (mediaTemplateModel = mediaModel.getMediaTemplateModel()) != null && (automaticMediaTemplateModel = mediaTemplateModel.getAutomaticMediaTemplateModel()) != null && (aEFrameModel = automaticMediaTemplateModel.getAEFrameModel()) != null) {
            aEFrameModel.setFrameColor(i3);
        }
    }

    public static final void updateFrameFillMode(@Nullable MediaModel mediaModel, int i3) {
        MediaTemplateModel mediaTemplateModel;
        AutomaticMediaTemplateModel automaticMediaTemplateModel;
        AEFrameModel aEFrameModel;
        if (mediaModel != null && (mediaTemplateModel = mediaModel.getMediaTemplateModel()) != null && (automaticMediaTemplateModel = mediaTemplateModel.getAutomaticMediaTemplateModel()) != null && (aEFrameModel = automaticMediaTemplateModel.getAEFrameModel()) != null) {
            aEFrameModel.setImageFillMode(i3);
        }
    }
}
