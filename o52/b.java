package o52;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t52.PlayerVideoInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u001c\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\u0004H&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\u0004H&J*\u0010\u0018\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u0004H&J\b\u0010\u001a\u001a\u00020\u0004H&J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH&J\n\u0010\"\u001a\u0004\u0018\u00010!H&J\n\u0010#\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010&\u001a\u00020\u00042\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0$H&J\u0012\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010!H&J\b\u0010)\u001a\u00020\u0004H&R\u001c\u0010/\u001a\u00020*8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u00104\u001a\u00020\u001e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00105\u001a\u00020\u001e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00101R\u0014\u00106\u001a\u00020\u001e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00101R\u0014\u00108\u001a\u00020\u001e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u00101R\u0014\u00109\u001a\u00020\u001e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u00101R\u0014\u0010;\u001a\u00020\u001e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u00101R\u0014\u0010>\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010=R\u0014\u0010C\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010E\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010B\u00a8\u0006F"}, d2 = {"Lo52/b;", "", "Lo52/a;", "listener", "", "c", "Lo52/d;", "videoView", "b", "", "type", QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, "start", "pause", "stop", "release", "Landroid/content/Context;", "context", "Lt52/f;", QCircleScheme.AttrDetail.VIDEO_INFO, "", ITVKPlayerEventListener.KEY_START_POSITION_MILSEC, "Lcom/tencent/superplayer/api/SuperPlayerOption;", "playerOption", "f", "pauseDownload", "resumeDownload", "positionMilsec", "mode", "seekTo", "", "isLoopback", "setLoopback", "", "getStreamDumpInfo", "getVideoView", "", "data", "addExtReportData", "rowkey", "setReportContentId", "setPlayerActive", "", "getSpeedRatio", "()F", "d", "(F)V", "speedRatio", "getOutputMute", "()Z", "setOutputMute", "(Z)V", "outputMute", "isPlaying", "isBuffering", "e", "isPrepareing", "isPrepared", "a", "isPauseing", "getDurationMs", "()J", "durationMs", "getCurrentPositionMs", "currentPositionMs", "getVideoWidth", "()I", "videoWidth", "getVideoHeight", "videoHeight", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface b {
    boolean a();

    void addExtReportData(@NotNull Map<String, String> data);

    void b(@Nullable d videoView);

    void c(@Nullable a listener);

    void d(float f16);

    boolean e();

    void f(@Nullable Context context, @NotNull PlayerVideoInfo videoInfo, long startPositionMilsec, @NotNull SuperPlayerOption playerOption);

    long getCurrentPositionMs();

    long getDurationMs();

    boolean getOutputMute();

    @Nullable
    String getStreamDumpInfo();

    int getVideoHeight();

    @Nullable
    d getVideoView();

    int getVideoWidth();

    boolean isBuffering();

    boolean isPlaying();

    boolean isPrepared();

    void pause();

    void pauseDownload();

    void release();

    void resumeDownload();

    void seekTo(int positionMilsec, int mode);

    void setLoopback(boolean isLoopback);

    void setOutputMute(boolean z16);

    void setPlayerActive();

    void setReportContentId(@Nullable String rowkey);

    void setXYaxis(int type);

    void start();

    void stop();
}
