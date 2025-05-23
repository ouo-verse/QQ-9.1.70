package com.tencent.qcircle.weseevideo.model.effect;

import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/effect/SubtitleModel;", "Lcom/tencent/qcircle/weseevideo/model/effect/StickerModel;", "()V", "effectId", "", "getEffectId", "()Ljava/lang/String;", "setEffectId", "(Ljava/lang/String;)V", "effectPath", "getEffectPath", "setEffectPath", "fontPath", "getFontPath", "setFontPath", "loopEnd", "", "getLoopEnd", "()J", "setLoopEnd", "(J)V", "loopStart", "getLoopStart", "setLoopStart", "loopType", "", "getLoopType", "()I", "setLoopType", "(I)V", "lyric", "getLyric", "setLyric", "lyricFormatIsQRC", "", "getLyricFormatIsQRC", "()Z", "setLyricFormatIsQRC", "(Z)V", "musicStartTime", "getMusicStartTime", "setMusicStartTime", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class SubtitleModel extends StickerModel {
    private long loopEnd;
    private long loopStart;
    private int loopType;
    private boolean lyricFormatIsQRC;
    private int musicStartTime;

    @NotNull
    private String effectId = "";

    @NotNull
    private String effectPath = "";

    @NotNull
    private String lyric = "";

    @NotNull
    private String fontPath = "";

    public SubtitleModel() {
        this.effectType = VideoEffectType.TYPE_SUBTITLE.value;
        this.scale = 1.0f;
        this.minScale = 1.0f;
        this.maxScale = 1.0f;
        this.rotate = 0.0f;
        this.editable = false;
    }

    @NotNull
    public final String getEffectId() {
        return this.effectId;
    }

    @NotNull
    public final String getEffectPath() {
        return this.effectPath;
    }

    @NotNull
    public final String getFontPath() {
        return this.fontPath;
    }

    public final long getLoopEnd() {
        return this.loopEnd;
    }

    public final long getLoopStart() {
        return this.loopStart;
    }

    public final int getLoopType() {
        return this.loopType;
    }

    @NotNull
    public final String getLyric() {
        return this.lyric;
    }

    public final boolean getLyricFormatIsQRC() {
        return this.lyricFormatIsQRC;
    }

    public final int getMusicStartTime() {
        return this.musicStartTime;
    }

    public final void setEffectId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.effectId = str;
    }

    public final void setEffectPath(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.effectPath = str;
    }

    public final void setFontPath(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.fontPath = str;
    }

    public final void setLoopEnd(long j3) {
        this.loopEnd = j3;
    }

    public final void setLoopStart(long j3) {
        this.loopStart = j3;
    }

    public final void setLoopType(int i3) {
        this.loopType = i3;
    }

    public final void setLyric(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.lyric = str;
    }

    public final void setLyricFormatIsQRC(boolean z16) {
        this.lyricFormatIsQRC = z16;
    }

    public final void setMusicStartTime(int i3) {
        this.musicStartTime = i3;
    }
}
