package com.tencent.tavcut.core.render.builder;

import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.listener.OnClipAssetListener;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001Jd\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2(\b\u0002\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/IMediaBuilder;", "", "buildComposition", "Lcom/tencent/tavcut/core/render/builder/MediaBuilderOutput;", "templatePath", "", "renderModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "loadFromJson", "", "isUE4Template", "listener", "Lorg/light/listener/OnClipAssetListener;", "assetData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IMediaBuilder {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ MediaBuilderOutput buildComposition$default(IMediaBuilder iMediaBuilder, String str, LAKRenderModel lAKRenderModel, boolean z16, boolean z17, OnClipAssetListener onClipAssetListener, HashMap hashMap, int i3, Object obj) {
            boolean z18;
            boolean z19;
            OnClipAssetListener onClipAssetListener2;
            HashMap hashMap2;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z18 = false;
                } else {
                    z18 = z16;
                }
                if ((i3 & 8) != 0) {
                    z19 = false;
                } else {
                    z19 = z17;
                }
                if ((i3 & 16) != 0) {
                    onClipAssetListener2 = null;
                } else {
                    onClipAssetListener2 = onClipAssetListener;
                }
                if ((i3 & 32) != 0) {
                    hashMap2 = null;
                } else {
                    hashMap2 = hashMap;
                }
                return iMediaBuilder.buildComposition(str, lAKRenderModel, z18, z19, onClipAssetListener2, hashMap2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildComposition");
        }
    }

    @Nullable
    MediaBuilderOutput buildComposition(@NotNull String templatePath, @NotNull LAKRenderModel renderModel, boolean loadFromJson, boolean isUE4Template, @Nullable OnClipAssetListener listener, @Nullable HashMap<String, String> assetData);
}
