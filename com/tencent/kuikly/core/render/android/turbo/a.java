package com.tencent.kuikly.core.render.android.turbo;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/a;", "", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;", "a", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;", "()Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;", "setTurboDisplayNode", "(Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;)V", "turboDisplayNode", "", "b", "[B", "()[B", "setTurboDisplayNodeData", "([B)V", "turboDisplayNodeData", "<init>", "(Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;[B)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private KRTurboDisplayNode turboDisplayNode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] turboDisplayNodeData;

    public a(@Nullable KRTurboDisplayNode kRTurboDisplayNode, @Nullable byte[] bArr) {
        this.turboDisplayNode = kRTurboDisplayNode;
        this.turboDisplayNodeData = bArr;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final KRTurboDisplayNode getTurboDisplayNode() {
        return this.turboDisplayNode;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final byte[] getTurboDisplayNodeData() {
        return this.turboDisplayNodeData;
    }
}
