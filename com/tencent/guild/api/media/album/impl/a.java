package com.tencent.guild.api.media.album.impl;

import com.tencent.guild.api.media.album.e;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016R\u0017\u0010\u001a\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/api/media/album/impl/a;", "Lcom/tencent/guild/api/media/album/e;", "", "path", "", "setPath", "getPath", "", "getType", "", "getFileSize", "getVideoDuration", "e", "b", "a", "c", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "g", "", "other", "", "equals", "hashCode", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "f", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "realInfo", "<init>", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LocalMediaInfo realInfo;

    public a(@NotNull LocalMediaInfo realInfo) {
        Intrinsics.checkNotNullParameter(realInfo, "realInfo");
        this.realInfo = realInfo;
    }

    @Override // com.tencent.guild.api.media.album.e
    public void a(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.realInfo.picPathBeforeEdit = path;
    }

    @Override // com.tencent.guild.api.media.album.e
    public int b() {
        return this.realInfo.thumbHeight;
    }

    @Override // com.tencent.guild.api.media.album.e
    @NotNull
    public String c() {
        String str = this.realInfo.picPathBeforeEdit;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.guild.api.media.album.e
    public int e() {
        return this.realInfo.thumbWidth;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(a.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.guild.api.media.album.impl.GuildLocalMediaInfo");
        if (Intrinsics.areEqual(this.realInfo.path, ((a) other).realInfo.path)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final LocalMediaInfo getRealInfo() {
        return this.realInfo;
    }

    @Override // com.tencent.guild.api.media.album.e
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public LocalMediaInfo d() {
        return this.realInfo;
    }

    @Override // com.tencent.guild.api.media.album.e
    public long getFileSize() {
        long j3 = this.realInfo.fileSize;
        if (j3 <= 0) {
            return new File(getPath()).length();
        }
        return j3;
    }

    @Override // com.tencent.guild.api.media.album.e
    @NotNull
    public String getPath() {
        String str = this.realInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "realInfo.path");
        return str;
    }

    @Override // com.tencent.guild.api.media.album.e
    public int getType() {
        return QAlbumUtil.getMediaType(this.realInfo);
    }

    @Override // com.tencent.guild.api.media.album.e
    public long getVideoDuration() {
        return this.realInfo.mDuration;
    }

    public int hashCode() {
        return this.realInfo.path.hashCode();
    }

    @Override // com.tencent.guild.api.media.album.e
    public void setPath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.realInfo.path = path;
    }
}
