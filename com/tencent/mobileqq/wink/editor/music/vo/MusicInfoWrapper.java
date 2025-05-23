package com.tencent.mobileqq.wink.editor.music.vo;

import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicInfo;
import com.tencent.videocut.model.AudioModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\b\b\u0002\u0010\u001d\u001a\u00020\n\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u0010\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "", "Lcom/tencent/videocut/model/AudioModel;", "e", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "stuckPointInfo", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", "f", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "a", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "c", "()Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "musicInfo", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "localPath", "I", "d", "()I", "startTime", "durationMs", "Z", "isAutoMusic", "()Z", "<init>", "(Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;Ljava/lang/String;IIZ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.music.vo.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MusicInfoWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final WinkEditorMusicInfo musicInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String localPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int startTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int durationMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAutoMusic;

    public MusicInfoWrapper(@Nullable WinkEditorMusicInfo winkEditorMusicInfo, @NotNull String localPath, int i3, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        this.musicInfo = winkEditorMusicInfo;
        this.localPath = localPath;
        this.startTime = i3;
        this.durationMs = i16;
        this.isAutoMusic = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getDurationMs() {
        return this.durationMs;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final WinkEditorMusicInfo getMusicInfo() {
        return this.musicInfo;
    }

    /* renamed from: d, reason: from getter */
    public final int getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final AudioModel e() {
        if (this.musicInfo == null) {
            return new AudioModel.Builder().build();
        }
        String l3 = this.musicInfo.l();
        Intrinsics.checkNotNullExpressionValue(l3, "musicInfo.lyricFormat");
        String k3 = this.musicInfo.k();
        Intrinsics.checkNotNullExpressionValue(k3, "musicInfo.lyric");
        return new AudioModel.Builder().id(this.musicInfo.p()).name(this.musicInfo.q()).path(this.localPath).speed(Float.valueOf(1.0f)).type(AudioModel.Type.MUSIC).lyricInfo(new AudioModel.LyricInfo(l3, k3, null, null, 12, null)).selectStartTime(Long.valueOf(this.startTime * 1000)).selectDuration(Long.valueOf(this.durationMs * 1000)).sourceDuration(Long.valueOf(this.musicInfo.n() * 1000)).volume(Float.valueOf(0.5f)).build();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MusicInfoWrapper)) {
            return false;
        }
        MusicInfoWrapper musicInfoWrapper = (MusicInfoWrapper) other;
        if (Intrinsics.areEqual(this.musicInfo, musicInfoWrapper.musicInfo) && Intrinsics.areEqual(this.localPath, musicInfoWrapper.localPath) && this.startTime == musicInfoWrapper.startTime && this.durationMs == musicInfoWrapper.durationMs && this.isAutoMusic == musicInfoWrapper.isAutoMusic) {
            return true;
        }
        return false;
    }

    @NotNull
    public final MusicInfo f(@NotNull QQCircleSmartMatchMusic$MusicStuckPointInfo stuckPointInfo) {
        int i3;
        Intrinsics.checkNotNullParameter(stuckPointInfo, "stuckPointInfo");
        int i16 = this.startTime;
        WinkEditorMusicInfo winkEditorMusicInfo = this.musicInfo;
        if (winkEditorMusicInfo != null) {
            i3 = winkEditorMusicInfo.n();
        } else {
            i3 = 0;
        }
        return new MusicInfo(i16, i3 - i16, com.tencent.mobileqq.wink.editor.smartclip.c.p(stuckPointInfo));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        WinkEditorMusicInfo winkEditorMusicInfo = this.musicInfo;
        if (winkEditorMusicInfo == null) {
            hashCode = 0;
        } else {
            hashCode = winkEditorMusicInfo.hashCode();
        }
        int hashCode2 = ((((((hashCode * 31) + this.localPath.hashCode()) * 31) + this.startTime) * 31) + this.durationMs) * 31;
        boolean z16 = this.isAutoMusic;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode2 + i3;
    }

    @NotNull
    public String toString() {
        return "MusicInfoWrapper(musicInfo=" + this.musicInfo + ", localPath=" + this.localPath + ", startTime=" + this.startTime + ", durationMs=" + this.durationMs + ", isAutoMusic=" + this.isAutoMusic + ")";
    }

    public /* synthetic */ MusicInfoWrapper(WinkEditorMusicInfo winkEditorMusicInfo, String str, int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(winkEditorMusicInfo, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16, (i17 & 16) != 0 ? false : z16);
    }
}
