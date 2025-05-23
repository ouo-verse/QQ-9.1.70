package com.tencent.qcircle.weseevideo.model;

import com.tencent.qcircle.weseevideo.common.utils.GsonUtils;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "", "()V", "mediaEffectModel", "Lcom/tencent/qcircle/weseevideo/model/effect/MediaEffectModel;", "getMediaEffectModel", "()Lcom/tencent/qcircle/weseevideo/model/effect/MediaEffectModel;", "setMediaEffectModel", "(Lcom/tencent/qcircle/weseevideo/model/effect/MediaEffectModel;)V", "mediaResourceModel", "Lcom/tencent/qcircle/weseevideo/model/resource/MediaResourceModel;", "getMediaResourceModel", "()Lcom/tencent/qcircle/weseevideo/model/resource/MediaResourceModel;", "setMediaResourceModel", "(Lcom/tencent/qcircle/weseevideo/model/resource/MediaResourceModel;)V", "mediaTemplateModel", "Lcom/tencent/qcircle/weseevideo/model/template/MediaTemplateModel;", "getMediaTemplateModel", "()Lcom/tencent/qcircle/weseevideo/model/template/MediaTemplateModel;", "setMediaTemplateModel", "(Lcom/tencent/qcircle/weseevideo/model/template/MediaTemplateModel;)V", "toString", "", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class MediaModel {

    @NotNull
    private MediaEffectModel mediaEffectModel = new MediaEffectModel();

    @NotNull
    private MediaResourceModel mediaResourceModel = new MediaResourceModel();

    @NotNull
    private MediaTemplateModel mediaTemplateModel = new MediaTemplateModel();

    @NotNull
    public final MediaEffectModel getMediaEffectModel() {
        return this.mediaEffectModel;
    }

    @NotNull
    public final MediaResourceModel getMediaResourceModel() {
        return this.mediaResourceModel;
    }

    @NotNull
    public final MediaTemplateModel getMediaTemplateModel() {
        return this.mediaTemplateModel;
    }

    public final void setMediaEffectModel(@NotNull MediaEffectModel mediaEffectModel) {
        Intrinsics.checkParameterIsNotNull(mediaEffectModel, "<set-?>");
        this.mediaEffectModel = mediaEffectModel;
    }

    public final void setMediaResourceModel(@NotNull MediaResourceModel mediaResourceModel) {
        Intrinsics.checkParameterIsNotNull(mediaResourceModel, "<set-?>");
        this.mediaResourceModel = mediaResourceModel;
    }

    public final void setMediaTemplateModel(@NotNull MediaTemplateModel mediaTemplateModel) {
        Intrinsics.checkParameterIsNotNull(mediaTemplateModel, "<set-?>");
        this.mediaTemplateModel = mediaTemplateModel;
    }

    @NotNull
    public String toString() {
        String obj2Json = GsonUtils.obj2Json(this);
        Intrinsics.checkExpressionValueIsNotNull(obj2Json, "GsonUtils.obj2Json(this)");
        return obj2Json;
    }
}
