package gk3;

import android.content.Intent;
import android.view.Surface;
import com.tencent.avbiz.IModule;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.zplan.room.impl.trtc.ZPlanTRTCRoomParam;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001>J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J*\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u000e\u001a\u00020\u0004H&J\u0014\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0014\u001a\u00020\u0004H&J\u0014\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0016\u001a\u00020\u0004H&J\u001c\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00102\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0010H&J\u001c\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\t2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\tH&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0010H&J\b\u0010 \u001a\u00020\tH&J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\"H&J\u0012\u0010%\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010&\u001a\u00020\u0004H&J\b\u0010(\u001a\u00020'H&J&\u0010-\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010\u0002H&J6\u00102\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0002H&J6\u00103\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0002H&J\u0012\u00104\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u000bH&J\u0010\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0010H&J\u0010\u00108\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u000207H&J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u000207H&J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020:H&J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020:H&J\b\u0010=\u001a\u00020\u0004H&\u00a8\u0006?"}, d2 = {"Lgk3/b;", "Lvb3/b;", "Lgk3/b$a;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/zplan/room/impl/trtc/a;", "params", "N", "", "sdkAppId", "", "sdkUserSig", "y", "exitRoom", h.F, "", "mute", "v0", "muteAllRemoteAudio", "stopLocalAudio", "p", "c0", "isEnable", "v", "isAnchor", "switchRole", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "z0", "setAudioPlayoutVolume", "useSpeakerphone", V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, "X", "success", "Landroid/content/Intent;", "data", "R0", "k", "stopScreenCapture", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoEncParam;", "y0", "userId", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "remoteView", "callback", "t", "Landroid/view/Surface;", "surface", "width", "height", "r", "H", "stopPlayScreenCapture", "enable", "enableAudioEarMonitoring", "Lcom/tencent/trtc/TRTCCloudListener;", ReportConstant.COSTREPORT_PREFIX, "m0", "Lcom/tencent/avbiz/IModule$FocusChangeListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "f0", "destroy", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface b extends vb3.b {
    void H(String userId, Surface surface, int width, int height, a callback);

    void N(ZPlanTRTCRoomParam params, a listener);

    void R0(boolean success, Intent data);

    int X();

    void c0();

    void destroy();

    void enableAudioEarMonitoring(boolean enable);

    void exitRoom();

    void f0(IModule.FocusChangeListener listener);

    void h(a listener);

    void k(a listener);

    void m0(TRTCCloudListener listener);

    void muteAllRemoteAudio(boolean mute);

    void p(a listener);

    void q(a listener);

    void r(String userId, Surface surface, int width, int height, a callback);

    void s(TRTCCloudListener listener);

    void setAudioPlayoutVolume(int volume);

    void setAudioRoute(boolean useSpeakerphone);

    void stopLocalAudio();

    void stopPlayScreenCapture(String userId);

    void stopScreenCapture();

    void switchRole(boolean isAnchor);

    void t(String userId, TXCloudVideoView remoteView, a callback);

    void v(boolean isEnable, a listener);

    void v0(boolean mute, a listener);

    void y(int sdkAppId, String sdkUserSig, ZPlanTRTCRoomParam params, a listener);

    TRTCCloudDef.TRTCVideoEncParam y0();

    void z(IModule.FocusChangeListener listener);

    void z0(int volume, a listener);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lgk3/b$a;", "", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface a {
        void a(boolean isSuccess, ErrorMessage errorMessage);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: gk3.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        public static final class C10382a {
            public static /* synthetic */ void a(a aVar, boolean z16, ErrorMessage errorMessage, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 2) != 0) {
                        errorMessage = null;
                    }
                    aVar.a(z16, errorMessage);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onComplete");
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: gk3.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10383b {
        public static /* synthetic */ void a(b bVar, ZPlanTRTCRoomParam zPlanTRTCRoomParam, a aVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    aVar = null;
                }
                bVar.N(zPlanTRTCRoomParam, aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterRoom");
        }

        public static /* synthetic */ void b(b bVar, boolean z16, a aVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    aVar = null;
                }
                bVar.v0(z16, aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: muteLocalAudio");
        }

        public static /* synthetic */ void c(b bVar, int i3, a aVar, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    aVar = null;
                }
                bVar.z0(i3, aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAudioCaptureVolume");
        }
    }
}
