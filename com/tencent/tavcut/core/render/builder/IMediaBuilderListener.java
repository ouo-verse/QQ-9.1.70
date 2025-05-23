package com.tencent.tavcut.core.render.builder;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/IMediaBuilderListener;", "", "buildCompleted", "", "errorCode", "", "output", "Lcom/tencent/tavcut/core/render/builder/MediaBuilderOutput;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IMediaBuilderListener {
    void buildCompleted(int errorCode, @Nullable MediaBuilderOutput output);
}
