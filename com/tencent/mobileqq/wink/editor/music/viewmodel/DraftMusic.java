package com.tencent.mobileqq.wink.editor.music.viewmodel;

import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", IOnlineStatusService.SONG_ID, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "songName", "selectMusicMid", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.music.viewmodel.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class DraftMusic {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Long songId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String songName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String selectMusicMid;

    public DraftMusic() {
        this(null, null, null, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getSelectMusicMid() {
        return this.selectMusicMid;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Long getSongId() {
        return this.songId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getSongName() {
        return this.songName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DraftMusic)) {
            return false;
        }
        DraftMusic draftMusic = (DraftMusic) other;
        if (Intrinsics.areEqual(this.songId, draftMusic.songId) && Intrinsics.areEqual(this.songName, draftMusic.songName) && Intrinsics.areEqual(this.selectMusicMid, draftMusic.selectMusicMid)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        Long l3 = this.songId;
        int i3 = 0;
        if (l3 == null) {
            hashCode = 0;
        } else {
            hashCode = l3.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.songName;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.selectMusicMid;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "DraftMusic(songId=" + this.songId + ", songName=" + this.songName + ", selectMusicMid=" + this.selectMusicMid + ")";
    }

    public DraftMusic(@Nullable Long l3, @Nullable String str, @Nullable String str2) {
        this.songId = l3;
        this.songName = str;
        this.selectMusicMid = str2;
    }

    public /* synthetic */ DraftMusic(Long l3, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l3, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
    }
}
