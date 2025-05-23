package com.tencent.mobileqq.guild.feed.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/n;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "url", "", "b", "I", "()I", "type", "d", "width", "height", "<init>", "(Ljava/lang/String;III)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int height;

    public n(@NotNull String url, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.type = i3;
        this.width = i16;
        this.height = i17;
    }

    /* renamed from: a, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: d, reason: from getter */
    public final int getWidth() {
        return this.width;
    }
}
