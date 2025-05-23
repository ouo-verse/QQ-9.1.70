package com.tencent.qqnt.aio.audiopanel;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.utils.RecordParams;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH&J<\u0010\u0016\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0007\u001a\u00020\u0006H&JT\u0010\u001b\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\fH&JR\u0010\u001e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001f\u001a\u00020\bH&J\u0014\u0010!\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006H&J$\u0010#\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010$\u001a\u00020\u0019H&J8\u0010%\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010&\u001a\u00020\u0019H&J\b\u0010'\u001a\u00020\u0002H&J\b\u0010(\u001a\u00020\u0002H&J\u0010\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0002H&J\u0010\u0010+\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0002H&\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/m;", "", "", "H0", "Lcom/tencent/mobileqq/ptt/d$a;", "listener", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "param", "", "s0", "sync", "j", "", "path", "O", "audioPath", "", "totalTime", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioData", "P0", "isVoiceChange", "isAutoConvertText", "", "voiceChangeType", "Z", "text", "sendMessage", "C0", "W0", "recordParam", "I0", "isNoPermission", "g0", "v", "B", "c", "isRecording", "M0", "bEditState", BdhLogUtil.LogTag.Tag_Req, "r", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface m {
    void B(@NotNull String path, float totalTime, @NotNull ArrayList<Byte> audioData, @NotNull RecordParams.RecorderParam param);

    void C0(@Nullable String audioPath, float totalTime, @NotNull ArrayList<Byte> audioData, @NotNull RecordParams.RecorderParam param, boolean isVoiceChange, boolean isAutoConvertText, int voiceChangeType);

    boolean H0();

    void I0(@Nullable RecordParams.RecorderParam recordParam);

    boolean M0();

    void O(@NotNull String path);

    void P0(@Nullable String audioPath, float totalTime, @NotNull ArrayList<Byte> audioData, @NotNull RecordParams.RecorderParam param);

    void R(boolean bEditState);

    void W0();

    void Z(@Nullable String audioPath, float totalTime, @NotNull ArrayList<Byte> audioData, @NotNull RecordParams.RecorderParam param, boolean isVoiceChange, boolean isAutoConvertText, int voiceChangeType);

    int c();

    void g0(@Nullable String path, boolean isNoPermission, @Nullable RecordParams.RecorderParam param);

    boolean isRecording();

    void j(boolean sync);

    void r(boolean bEditState);

    void s0(@NotNull d.a listener, @NotNull RecordParams.RecorderParam param);

    void sendMessage(@NotNull String text);

    int v();
}
