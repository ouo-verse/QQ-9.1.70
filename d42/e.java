package d42;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t\u001a \u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u001a\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u001a\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0017\u001a\u00020\u0002\u001a\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0004\u001a\u0006\u0010\u001d\u001a\u00020\u0002\u001a\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010!\u001a\u00020\u0002\u001a\u0006\u0010\"\u001a\u00020\u0002\u001a\u0006\u0010#\u001a\u00020\u0002\u001a\u000e\u0010$\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010%\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010&\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001e\u0010(\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0006\u0010)\u001a\u00020\u0002\u001a\u001e\u0010*\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0006\u0010+\u001a\u00020\u0002\u001a\u001e\u0010,\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001e\u0010.\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0006\u0010/\u001a\u00020\u0002\u001a\u0006\u00100\u001a\u00020\u0002\u001a\u0016\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u0000\"\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00104\u00a8\u00066"}, d2 = {"", "roomId", "", UserInfo.SEX_FEMALE, "", "isPageIn", "isActivityPaused", "d", "l", "", "width", "height", "y", "errorCode", "", "msg", "j", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "url", ReportConstant.COSTREPORT_PREFIX, "w", HippyTKDListViewAdapter.X, "o", "B", "p", "playVideoOnSwitchRoom", tl.h.F, "i", "b", "c", "k", "e", "u", "t", BdhLogUtil.LogTag.Tag_Conn, "D", "E", "isPlaying", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "G", "H", "I", "f", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "xyAxis", "a", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "ic-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final IAegisLogApi f392785a;

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        f392785a = (IAegisLogApi) api;
    }

    public static final void A() {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "gameLiveView.pause");
    }

    public static final void B(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "pauseOnPageOut: " + j3);
    }

    public static final void C(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "play: " + j3);
    }

    public static final void D(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "play: " + j3 + ", networkAvailable");
    }

    public static final void E(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "play: " + j3 + ", networkNotAvailable");
    }

    public static final void F(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "setVideoPlayer, roomId:" + j3);
    }

    public static final void G(long j3, boolean z16, boolean z17) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "resume: " + j3 + ", " + z16 + ", " + z17);
    }

    public static final void H() {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "resume, addVideoView");
    }

    public static final void I(long j3, boolean z16, boolean z17) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "stop: " + j3 + ", " + z16 + ", " + z17);
    }

    public static final void a(int i3, long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "setXYAxis " + i3 + ", " + j3);
    }

    public static final void b(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "doAddVideoView, add: " + j3);
    }

    public static final void c(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "doAddVideoView, has: " + j3);
    }

    public static final void d(boolean z16, boolean z17) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "doPlay, isPageIn " + z16 + ", isActivityPaused " + z17);
    }

    public static final void e() {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "gameLiveView onClick");
    }

    public static final void f(long j3, boolean z16, boolean z17) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onAttachedToWindow: " + j3 + ", " + z16 + ", " + z17);
    }

    public static final void g(long j3, boolean z16, boolean z17) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onDetachedFromWindow: " + j3 + ", " + z16 + ", " + z17);
    }

    public static final void h(long j3, boolean z16) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onEnterRoom: " + j3 + ", playVideoOnSwitchRoom " + z16);
    }

    public static final void i() {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "play video in onEnterRoom...");
    }

    public static final void j(long j3, int i3, @Nullable String str) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onError: " + i3 + " " + str + ", " + j3);
    }

    public static final void k(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onExitRoom: " + j3);
    }

    public static final void l(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onFirstFrameCome, roomId:" + j3);
    }

    public static final void m() {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "not playing, pause");
    }

    public static final void n() {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "isPlaying, pause");
    }

    public static final void o(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onPageIn: " + j3);
    }

    public static final void p(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onPageOut: " + j3);
    }

    public static final void q(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onPause: " + j3);
    }

    public static final void r(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onPlay: " + j3);
    }

    public static final void s(long j3, @Nullable String str) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onPreload: " + j3 + ", videoUrl " + str);
    }

    public static final void t() {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onRealActivityPaused");
    }

    public static final void u() {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onRealActivityResume");
    }

    public static final void v(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onResume: " + j3);
    }

    public static final void w(long j3) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "play video in onSwitchRoom..." + j3);
    }

    public static final void x() {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "cannot get preloadRoom in onSwitchRoom...");
    }

    public static final void y(int i3, int i16) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "onVideoSizeChanged width " + i3 + ", height " + i16);
    }

    public static final void z(long j3, boolean z16, boolean z17) {
        f392785a.i("ICGameIvLiveRoomDisplayView", 1, "pause: " + j3 + ", " + z16 + ", " + z17);
    }
}
