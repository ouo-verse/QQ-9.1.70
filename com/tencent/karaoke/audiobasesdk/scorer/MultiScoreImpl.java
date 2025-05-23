package com.tencent.karaoke.audiobasesdk.scorer;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0002\b\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\r\u0010\u0012\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0016J\"\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J:\u0010\u001c\u001a\u00020\n2\u001e\u0010\u001d\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u0001` 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u0010H\u0016J \u0010&\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u0001` H\u0016J\b\u0010'\u001a\u00020\nH\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreImpl;", "Lcom/tencent/karaoke/audiobasesdk/scorer/IMultiScore;", "()V", MosaicConstants$JsProperty.PROP_NATIVE_BRIDGE, "Lcom/tencent/karaoke/audiobasesdk/scorer/ScorerNativeBridge;", "nativeId", "", "version", "", "bindScorerNativeBridge", "", "bridge", "bindScorerNativeBridge$lib_audiobasesdk_release", "getMapMultiScoreFinal", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreResult;", "map", "", "getMultiScoreFinal", "getNativeId", "getNativeId$lib_audiobasesdk_release", "init", "sampleRate", "channels", "initAndLoadResource", "multiJson", "setIsRap", HippyControllerProps.BOOLEAN, "", "setNewTmpDataToMultiScore", "info", "Ljava/util/ArrayList;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreStcInfo;", "Lkotlin/collections/ArrayList;", "pyScores", "", "lyricSize", "setSkillParam", "param", "tryGetMultiScoreTmp", "uninit", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class MultiScoreImpl implements IMultiScore {
    private ScorerNativeBridge nativeBridge;
    private long nativeId;
    private final int version = 1;

    public final void bindScorerNativeBridge$lib_audiobasesdk_release(@Nullable ScorerNativeBridge bridge) {
        this.nativeBridge = bridge;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IMultiScore
    @Nullable
    public MultiScoreResult getMapMultiScoreFinal(@NotNull byte[] map) {
        ScorerNativeBridge scorerNativeBridge;
        Intrinsics.checkParameterIsNotNull(map, "map");
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return null;
        }
        long j3 = this.nativeId;
        if (j3 == 0 || (scorerNativeBridge = this.nativeBridge) == null) {
            return null;
        }
        return scorerNativeBridge.getMapMultiScoreFinalResult(j3, map);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IMultiScore
    @Nullable
    public MultiScoreResult getMultiScoreFinal() {
        ScorerNativeBridge scorerNativeBridge;
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return null;
        }
        long j3 = this.nativeId;
        if (j3 == 0 || (scorerNativeBridge = this.nativeBridge) == null) {
            return null;
        }
        return scorerNativeBridge.getMultiScoreFinalResult(j3);
    }

    /* renamed from: getNativeId$lib_audiobasesdk_release, reason: from getter */
    public final long getNativeId() {
        return this.nativeId;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IMultiScore
    public void init(int sampleRate, int channels) {
        long j3;
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return;
        }
        if (this.nativeBridge == null) {
            this.nativeBridge = new ScorerNativeBridge();
        }
        ScorerNativeBridge scorerNativeBridge = this.nativeBridge;
        if (scorerNativeBridge != null) {
            j3 = scorerNativeBridge.initMultiScore(sampleRate, channels);
        } else {
            j3 = 0;
        }
        this.nativeId = j3;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IMultiScore
    public void initAndLoadResource(int sampleRate, int channels, @Nullable byte[] multiJson) {
        long j3;
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return;
        }
        if (this.nativeBridge == null) {
            this.nativeBridge = new ScorerNativeBridge();
        }
        ScorerNativeBridge scorerNativeBridge = this.nativeBridge;
        if (scorerNativeBridge != null) {
            j3 = scorerNativeBridge.initMultiScoreAndLoadResource(sampleRate, channels, multiJson);
        } else {
            j3 = 0;
        }
        this.nativeId = j3;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IMultiScore
    public void setIsRap(boolean r56) {
        ScorerNativeBridge scorerNativeBridge;
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return;
        }
        long j3 = this.nativeId;
        if (j3 != 0 && (scorerNativeBridge = this.nativeBridge) != null) {
            scorerNativeBridge.setRap(j3, r56);
        }
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IMultiScore
    public void setNewTmpDataToMultiScore(@Nullable ArrayList<MultiScoreStcInfo> info, @Nullable int[] pyScores, int lyricSize) {
        ScorerNativeBridge scorerNativeBridge;
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return;
        }
        long j3 = this.nativeId;
        if (j3 != 0 && (scorerNativeBridge = this.nativeBridge) != null) {
            scorerNativeBridge.setNewTmpDataToMultiScore(j3, info, pyScores, lyricSize);
        }
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IMultiScore
    public boolean setSkillParam(@NotNull byte[] param) {
        ScorerNativeBridge scorerNativeBridge;
        Intrinsics.checkParameterIsNotNull(param, "param");
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return false;
        }
        long j3 = this.nativeId;
        if (j3 == 0 || (scorerNativeBridge = this.nativeBridge) == null) {
            return false;
        }
        return scorerNativeBridge.setSkillParam(j3, param);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IMultiScore
    @Nullable
    public ArrayList<MultiScoreStcInfo> tryGetMultiScoreTmp() {
        ScorerNativeBridge scorerNativeBridge;
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return null;
        }
        long j3 = this.nativeId;
        if (j3 == 0 || (scorerNativeBridge = this.nativeBridge) == null) {
            return null;
        }
        return scorerNativeBridge.tryGetMultiScoreTmp(j3);
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IMultiScore
    public void uninit() {
        if (!ScorerNativeBridge.INSTANCE.isLoaded()) {
            return;
        }
        ScorerNativeBridge scorerNativeBridge = this.nativeBridge;
        if (scorerNativeBridge != null) {
            scorerNativeBridge.unInitMultiScore(this.nativeId);
        }
        this.nativeId = 0L;
    }

    @Override // com.tencent.karaoke.audiobasesdk.scorer.IMultiScore
    /* renamed from: version, reason: from getter */
    public int getVersion() {
        return this.version;
    }
}
