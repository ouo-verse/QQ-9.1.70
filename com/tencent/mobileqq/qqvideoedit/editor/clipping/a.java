package com.tencent.mobileqq.qqvideoedit.editor.clipping;

import com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.ThumbAssetModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaType;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ResourceModel;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/g;", "a", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    @NotNull
    public static final ThumbAssetModel a(@NotNull ResourceModel resourceModel) {
        int i3;
        Intrinsics.checkNotNullParameter(resourceModel, "<this>");
        String str = resourceModel.path;
        MediaType mediaType = resourceModel.type;
        if (mediaType != null) {
            i3 = mediaType.ordinal();
        } else {
            i3 = 0;
        }
        return new ThumbAssetModel(str, i3, resourceModel.sourceDuration);
    }
}
