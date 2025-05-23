package com.tencent.mobileqq.wink.editor.aielimination.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u000f\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\u0013\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/model/b;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "oriMediaPath", "b", "getMaskMediaPath", "maskMediaPath", "dstMediaPath", "", "d", "Ljava/util/Map;", "()Ljava/util/Map;", "g", "(Ljava/util/Map;)V", "shareUrl", "e", "getOriMediaUrl", "f", "(Ljava/lang/String;)V", "oriMediaUrl", "dstMediaUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String oriMediaPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String maskMediaPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String dstMediaPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, String> shareUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String oriMediaUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String dstMediaUrl;

    public b(@NotNull String oriMediaPath, @Nullable String str, @NotNull String dstMediaPath) {
        Intrinsics.checkNotNullParameter(oriMediaPath, "oriMediaPath");
        Intrinsics.checkNotNullParameter(dstMediaPath, "dstMediaPath");
        this.oriMediaPath = oriMediaPath;
        this.maskMediaPath = str;
        this.dstMediaPath = dstMediaPath;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDstMediaPath() {
        return this.dstMediaPath;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getDstMediaUrl() {
        return this.dstMediaUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getOriMediaPath() {
        return this.oriMediaPath;
    }

    @Nullable
    public final Map<String, String> d() {
        return this.shareUrl;
    }

    public final void e(@Nullable String str) {
        this.dstMediaUrl = str;
    }

    public final void f(@Nullable String str) {
        this.oriMediaUrl = str;
    }

    public final void g(@Nullable Map<String, String> map) {
        this.shareUrl = map;
    }
}
