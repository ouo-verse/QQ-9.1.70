package com.tencent.tavcut.core.render.builder;

import com.tencent.tavcut.core.render.builder.light.LightMediaBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/MediaBuildFactory;", "", "()V", "getMediaBuilder", "Lcom/tencent/tavcut/core/render/builder/IMediaBuilder;", "renderType", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class MediaBuildFactory {
    public static final MediaBuildFactory INSTANCE = new MediaBuildFactory();

    MediaBuildFactory() {
    }

    @NotNull
    public final IMediaBuilder getMediaBuilder(int renderType) {
        return LightMediaBuilder.INSTANCE;
    }
}
