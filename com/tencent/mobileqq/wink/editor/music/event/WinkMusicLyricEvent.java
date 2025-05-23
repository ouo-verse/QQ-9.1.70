package com.tencent.mobileqq.wink.editor.music.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/event/WinkMusicLyricEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "editorMusicInfo", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "savedMusicStartTimeInMs", "", "videoClipDurationInMs", "", "forceRefreshWaveView", "", "(Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;Ljava/lang/Integer;JZ)V", "getEditorMusicInfo", "()Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "getForceRefreshWaveView", "()Z", "getSavedMusicStartTimeInMs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVideoClipDurationInMs", "()J", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkMusicLyricEvent extends SimpleBaseEvent {

    @NotNull
    private final WinkEditorMusicInfo editorMusicInfo;
    private final boolean forceRefreshWaveView;

    @Nullable
    private final Integer savedMusicStartTimeInMs;
    private final long videoClipDurationInMs;

    public WinkMusicLyricEvent(@NotNull WinkEditorMusicInfo editorMusicInfo, @Nullable Integer num, long j3, boolean z16) {
        Intrinsics.checkNotNullParameter(editorMusicInfo, "editorMusicInfo");
        this.editorMusicInfo = editorMusicInfo;
        this.savedMusicStartTimeInMs = num;
        this.videoClipDurationInMs = j3;
        this.forceRefreshWaveView = z16;
    }

    @NotNull
    public final WinkEditorMusicInfo getEditorMusicInfo() {
        return this.editorMusicInfo;
    }

    public final boolean getForceRefreshWaveView() {
        return this.forceRefreshWaveView;
    }

    @Nullable
    public final Integer getSavedMusicStartTimeInMs() {
        return this.savedMusicStartTimeInMs;
    }

    public final long getVideoClipDurationInMs() {
        return this.videoClipDurationInMs;
    }
}
