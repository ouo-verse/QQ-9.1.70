package com.tencent.mobileqq.qqnt.videoplay.api.param;

import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u0002H&J\b\u0010\u0010\u001a\u00020\u0002H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/param/f;", "", "", "createPlayer", "b", ICustomDataEditor.STRING_PARAM_1, "onVideoPrepared", "onFirstFrameRendered", "onBufferStart", "onBufferEnd", "", "code", "", "msg", "a", "c", "onPlayStop", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface f {
    void a(int code, @NotNull String msg2);

    void b();

    void c();

    void createPlayer();

    void onBufferEnd();

    void onBufferStart();

    void onFirstFrameRendered();

    void onPlayStop();

    void onVideoPrepared();

    void s1();
}
