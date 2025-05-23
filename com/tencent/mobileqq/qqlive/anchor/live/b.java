package com.tencent.mobileqq.qqlive.anchor.live;

import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/b;", "", "", "d", "", "switchCamera", "b", "", "index", "c", "startAudioRecord", "stopAudioRecord", "", "Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType;", "a", "level", "e", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface b {
    @NotNull
    List<ResolutionLevelType> a();

    void b();

    void c(int index);

    boolean d();

    void e(@NotNull ResolutionLevelType level);

    void startAudioRecord();

    void stopAudioRecord();

    void switchCamera();
}
