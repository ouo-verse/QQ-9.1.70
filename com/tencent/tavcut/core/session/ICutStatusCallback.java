package com.tencent.tavcut.core.session;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "", "onLightEntityReload", "", "rootEntity", "Lorg/light/lightAssetKit/Entity;", "onRenderChainReady", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface ICutStatusCallback {
    void onLightEntityReload(@Nullable Entity rootEntity);

    void onRenderChainReady();
}
