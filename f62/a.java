package f62;

import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.base.video.player.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J4\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u000fH&J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0016\u001a\u00020\u0004H&J\b\u0010\u0017\u001a\u00020\u0004H&J\b\u0010\u0018\u001a\u00020\u0004H&J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000fH&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0006H&J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000fH&J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000fH&J\b\u0010$\u001a\u00020\u000bH&J\b\u0010%\u001a\u00020\u000bH&J\b\u0010&\u001a\u00020\u0006H&J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0006H&J\b\u0010)\u001a\u00020\u0004H&J\b\u0010*\u001a\u00020\u0004H&J\b\u0010+\u001a\u00020\u000fH&J\b\u0010,\u001a\u00020\u000fH&J\b\u0010-\u001a\u00020\u000fH&J\b\u0010.\u001a\u00020\u0006H&J\b\u0010/\u001a\u00020\u0006H&J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0006H&J\b\u00102\u001a\u00020\u0004H&J\b\u00103\u001a\u00020\u0004H&J\b\u00104\u001a\u00020\u0004H&\u00a8\u00065"}, d2 = {"Lf62/a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", h.F, "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "vid", AppConstants.Key.KEY_QZONE_VIDEO_URL, "", "position", "duration", "k", "", "coverFrame", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "Lf62/b;", "mgr", "f", "start", "pause", "stop", "Lcom/tencent/mobileqq/kandian/base/video/player/f;", "listener", "i", "isKeep", "d", "xyAxis", QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, "isLoop", "setLoopback", "mute", "setMute", "getDuration", "getCurrentPosition", "getCurrentState", com.tencent.luggage.wxa.c8.c.G, "seekTo", DomainData.DOMAIN_NAME, "j", "g", "b", "isPlaying", "getVideoWidth", "getVideoHeight", "time", "e", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface a {
    boolean b();

    boolean c();

    void d(boolean isKeep);

    void e(int time);

    void f(@Nullable b mgr);

    boolean g();

    long getCurrentPosition();

    int getCurrentState();

    long getDuration();

    int getVideoHeight();

    int getVideoWidth();

    void h(@NotNull ViewGroup parent);

    void i(@Nullable f listener);

    boolean isPlaying();

    void j();

    void k(int busiType, @Nullable String vid, @Nullable String videoUrl, long position, int duration);

    void m(boolean coverFrame);

    void n();

    void onDestroy();

    void onPause();

    void onResume();

    void pause();

    void seekTo(int pos);

    void setLoopback(boolean isLoop);

    void setMute(boolean mute);

    void setXYaxis(int xyAxis);

    void start();

    void stop();
}
