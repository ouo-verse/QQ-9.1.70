package com.tencent.guild.api.media.album;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\u0002H&J\b\u0010\u0010\u001a\u00020\u0001H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/api/media/album/e;", "", "", "path", "", "setPath", "getPath", "", "getType", "", "getFileSize", "getVideoDuration", "e", "b", "a", "c", "d", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface e {
    void a(@NotNull String path);

    int b();

    @NotNull
    String c();

    @NotNull
    Object d();

    int e();

    long getFileSize();

    @NotNull
    String getPath();

    int getType();

    long getVideoDuration();

    void setPath(@NotNull String path);
}
