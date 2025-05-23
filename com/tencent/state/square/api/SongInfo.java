package com.tencent.state.square.api;

import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/api/SongInfo;", "", IOnlineStatusService.SONG_ID, "", "songName", "singerName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSingerName", "()Ljava/lang/String;", "getSongId", "getSongName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class SongInfo {

    @Nullable
    private final String singerName;

    @Nullable
    private final String songId;

    @Nullable
    private final String songName;

    public SongInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SongInfo copy$default(SongInfo songInfo, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = songInfo.songId;
        }
        if ((i3 & 2) != 0) {
            str2 = songInfo.songName;
        }
        if ((i3 & 4) != 0) {
            str3 = songInfo.singerName;
        }
        return songInfo.copy(str, str2, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSongId() {
        return this.songId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getSongName() {
        return this.songName;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSingerName() {
        return this.singerName;
    }

    @NotNull
    public final SongInfo copy(@Nullable String songId, @Nullable String songName, @Nullable String singerName) {
        return new SongInfo(songId, songName, singerName);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SongInfo) {
                SongInfo songInfo = (SongInfo) other;
                if (!Intrinsics.areEqual(this.songId, songInfo.songId) || !Intrinsics.areEqual(this.songName, songInfo.songName) || !Intrinsics.areEqual(this.singerName, songInfo.singerName)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getSingerName() {
        return this.singerName;
    }

    @Nullable
    public final String getSongId() {
        return this.songId;
    }

    @Nullable
    public final String getSongName() {
        return this.songName;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.songId;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str2 = this.songName;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.singerName;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "SongInfo(songId=" + this.songId + ", songName=" + this.songName + ", singerName=" + this.singerName + ")";
    }

    public SongInfo(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.songId = str;
        this.songName = str2;
        this.singerName = str3;
    }

    public /* synthetic */ SongInfo(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3);
    }
}
