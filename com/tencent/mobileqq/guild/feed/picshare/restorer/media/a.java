package com.tencent.mobileqq.guild.feed.picshare.restorer.media;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\t\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/a;", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/b;", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/MediaType;", "getMediaType", "", "a", "b", "", "getVideoDuration", "", "getCoverUrl", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/MediaType;", "getType", "()Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/MediaType;", "type", "I", "getHeight", "()I", "height", "c", "getWidth", "width", "d", "J", "getDuration", "()J", "duration", "e", "Ljava/lang/String;", "getImageUrl", "()Ljava/lang/String;", "imageUrl", "<init>", "(Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/MediaType;IIJLjava/lang/String;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long duration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String imageUrl;

    public a(@NotNull MediaType type, int i3, int i16, long j3, @NotNull String imageUrl) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.type = type;
        this.height = i3;
        this.width = i16;
        this.duration = j3;
        this.imageUrl = imageUrl;
    }

    @Override // com.tencent.mobileqq.guild.feed.picshare.restorer.media.b
    /* renamed from: a, reason: from getter */
    public int getHeight() {
        return this.height;
    }

    @Override // com.tencent.mobileqq.guild.feed.picshare.restorer.media.b
    /* renamed from: b, reason: from getter */
    public int getWidth() {
        return this.width;
    }

    @Override // com.tencent.mobileqq.guild.feed.picshare.restorer.media.b
    @NotNull
    /* renamed from: getCoverUrl, reason: from getter */
    public String getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.tencent.mobileqq.guild.feed.picshare.restorer.media.b
    @NotNull
    /* renamed from: getMediaType, reason: from getter */
    public MediaType getType() {
        return this.type;
    }

    @Override // com.tencent.mobileqq.guild.feed.picshare.restorer.media.b
    /* renamed from: getVideoDuration, reason: from getter */
    public long getDuration() {
        return this.duration;
    }
}
