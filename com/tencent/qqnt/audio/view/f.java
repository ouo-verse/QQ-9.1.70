package com.tencent.qqnt.audio.view;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&J4\u0010\u0011\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH&J\b\u0010\u0012\u001a\u00020\u0004H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/audio/view/f;", "", "", "getAudioPath", "", "startRecord", "", "sync", "j", "audioPath", "n0", "", "totalTime", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioData", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface f {
    @Nullable
    String getAudioPath();

    void j(boolean sync);

    void n0(@Nullable String audioPath);

    void startRecord();

    void y(@Nullable String audioPath, float totalTime, @NotNull ArrayList<Byte> audioData);

    void z();
}
