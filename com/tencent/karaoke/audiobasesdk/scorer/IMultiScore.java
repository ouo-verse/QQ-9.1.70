package com.tencent.karaoke.audiobasesdk.scorer;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\"\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H&J:\u0010\u0011\u001a\u00020\b2\u001e\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\nH&J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0005H&J \u0010\u001b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u0001`\u0015H&J\b\u0010\u001c\u001a\u00020\bH&J\b\u0010\u001d\u001a\u00020\nH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/scorer/IMultiScore;", "", "getMapMultiScoreFinal", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreResult;", "map", "", "getMultiScoreFinal", "init", "", "sampleRate", "", "channels", "initAndLoadResource", "multiJson", "setIsRap", HippyControllerProps.BOOLEAN, "", "setNewTmpDataToMultiScore", "info", "Ljava/util/ArrayList;", "Lcom/tencent/karaoke/audiobasesdk/scorer/MultiScoreStcInfo;", "Lkotlin/collections/ArrayList;", "pyScores", "", "lyricSize", "setSkillParam", "param", "tryGetMultiScoreTmp", "uninit", "version", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface IMultiScore {
    @Nullable
    MultiScoreResult getMapMultiScoreFinal(@NotNull byte[] map);

    @Nullable
    MultiScoreResult getMultiScoreFinal();

    void init(int sampleRate, int channels);

    void initAndLoadResource(int sampleRate, int channels, @Nullable byte[] multiJson);

    void setIsRap(boolean r16);

    void setNewTmpDataToMultiScore(@Nullable ArrayList<MultiScoreStcInfo> info, @Nullable int[] pyScores, int lyricSize);

    boolean setSkillParam(@NotNull byte[] param);

    @Nullable
    ArrayList<MultiScoreStcInfo> tryGetMultiScoreTmp();

    void uninit();

    int version();
}
