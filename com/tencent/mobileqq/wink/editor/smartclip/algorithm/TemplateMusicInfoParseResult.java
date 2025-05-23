package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", "a", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", "b", "()Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;", "musicInfo", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;", "()Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;", "fixedClipConfig", "<init>", "(Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/f;Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/g;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.smartclip.algorithm.h, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class TemplateMusicInfoParseResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MusicInfo musicInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TemplateFixedClipConfig fixedClipConfig;

    public TemplateMusicInfoParseResult(@NotNull MusicInfo musicInfo, @NotNull TemplateFixedClipConfig fixedClipConfig) {
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        Intrinsics.checkNotNullParameter(fixedClipConfig, "fixedClipConfig");
        this.musicInfo = musicInfo;
        this.fixedClipConfig = fixedClipConfig;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final TemplateFixedClipConfig getFixedClipConfig() {
        return this.fixedClipConfig;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final MusicInfo getMusicInfo() {
        return this.musicInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateMusicInfoParseResult)) {
            return false;
        }
        TemplateMusicInfoParseResult templateMusicInfoParseResult = (TemplateMusicInfoParseResult) other;
        if (Intrinsics.areEqual(this.musicInfo, templateMusicInfoParseResult.musicInfo) && Intrinsics.areEqual(this.fixedClipConfig, templateMusicInfoParseResult.fixedClipConfig)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.musicInfo.hashCode() * 31) + this.fixedClipConfig.hashCode();
    }

    @NotNull
    public String toString() {
        return "TemplateMusicInfoParseResult(musicInfo=" + this.musicInfo + ", fixedClipConfig=" + this.fixedClipConfig + ")";
    }
}
