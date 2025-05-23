package com.tencent.mobileqq.qqlive.sail.room;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.anchor.AvConfig;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.mobileqq.qqlive.utils.r;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.raft.raftframework.sla.SLAReporter;
import gr4.w;
import gr4.z;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 B2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0002H\u0016J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0018H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0016J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*2\u0006\u0010$\u001a\u00020*H\u0016J\u0010\u0010/\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010-J\u0006\u00100\u001a\u00020\u0007J\u001b\u00103\u001a\u00020*2\u0006\u00102\u001a\u000201H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u00104J#\u00108\u001a\u00020\u00182\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u00109J\u0006\u0010:\u001a\u00020\u0018J\u000e\u0010<\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0018J\u0006\u0010=\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020\u0007J\u0006\u0010?\u001a\u00020\u0007R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010A\u001a\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010J\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/RoomTrtcProxyImpl;", "Lcom/tencent/mobileqq/qqlive/sail/room/i;", "", "trtcStr", "b", "Landroid/graphics/Bitmap;", "bmp", "", "g", "Lcom/tencent/mobileqq/qqlive/data/trtc/TRTCVideoQualityParams;", "params", "setVideoQuality", "getVideoQuality", "Landroid/widget/FrameLayout;", tl.h.F, "switchCamera", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setAudioVolume", "Lcom/tencent/mobileqq/qqlive/trtc/video/videoprocess/a;", "process", "l", "Lcom/tencent/mobileqq/qqlive/data/trtc/RTCCameraDefine$RTCMirrorType;", "type", "", "mirror", "setCameraMirror", "Lcom/tencent/mobileqq/qqlive/api/audio/audioeffect/IRTCMusicAccompany;", "createMusicAccompany", "openMic", "closeMic", "disconnectRemote", "uid", "videoView", "startRemoteView", "stopRemoteView", "userId", "mute", "muteRemoteAudio", "Lcom/tencent/mobileqq/qqlive/trtc/encoder/a;", "qosParam", "c", "", "roomId", "connectRemote", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;", "avConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "roomInfo", "d", "(Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "appId", "k", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "resumeAudio", "p", DomainData.DOMAIN_NAME, "e", "o", "Lcom/tencent/mobileqq/qqlive/sail/trtc/a;", "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/qqlive/sail/trtc/a;", "trtcBridge", "Landroid/widget/FrameLayout;", "previewContainer", "f", "Landroid/graphics/Bitmap;", "pauseBmp", "I", "streamRecordType", "<init>", "()V", "a", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RoomTrtcProxyImpl implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final String[] f272414m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy trtcBridge;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout previewContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap pauseBmp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int streamRecordType;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/RoomTrtcProxyImpl$a;", "", "", "", "TRTC_REQUEST_PERMISSIONS", "[Ljava/lang/String;", "a", "()[Ljava/lang/String;", "TAG", "Ljava/lang/String;", "TRTC_RECORD_BUSINESS_FORMAT_STR", "", "USER_VOLUME_CHANGE_INTERVAL", "I", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.room.RoomTrtcProxyImpl$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String[] a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return RoomTrtcProxyImpl.f272414m;
            }
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
            f272414m = new String[]{SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.MODIFY_AUDIO_SETTINGS", "android.permission.BLUETOOTH", QQPermissionConstants.Permission.CAMERA};
        }
    }

    public RoomTrtcProxyImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(RoomTrtcProxyImpl$trtcBridge$2.INSTANCE);
            this.trtcBridge = lazy;
            this.streamRecordType = -1;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String b(String trtcStr) {
        boolean z16;
        boolean isBlank;
        if (trtcStr != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(trtcStr);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return "";
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("{\"Str_uc_params\":{\"userdefine_push_args\":\"%s\"}}", Arrays.copyOf(new Object[]{trtcStr}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final com.tencent.mobileqq.qqlive.sail.trtc.a i() {
        return (com.tencent.mobileqq.qqlive.sail.trtc.a) this.trtcBridge.getValue();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void c(@NotNull com.tencent.mobileqq.qqlive.trtc.encoder.a qosParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) qosParam);
        } else {
            Intrinsics.checkNotNullParameter(qosParam, "qosParam");
            i().c(qosParam);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void closeMic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            i().closeMic();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void connectRemote(long roomId, long userId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(roomId), Long.valueOf(userId));
        } else {
            i().connectRemote(roomId, userId);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    @Nullable
    public IRTCMusicAccompany createMusicAccompany() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IRTCMusicAccompany) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return i().createMusicAccompany();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(@NotNull AnchorRoomInfo anchorRoomInfo, @NotNull Continuation<? super Long> continuation) {
        RoomTrtcProxyImpl$enterTrtcRoom$1 roomTrtcProxyImpl$enterTrtcRoom$1;
        Object coroutine_suspended;
        int i3;
        String str;
        String str2;
        String str3;
        w wVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return iPatchRedirector.redirect((short) 22, (Object) this, (Object) anchorRoomInfo, (Object) continuation);
        }
        if (continuation instanceof RoomTrtcProxyImpl$enterTrtcRoom$1) {
            roomTrtcProxyImpl$enterTrtcRoom$1 = (RoomTrtcProxyImpl$enterTrtcRoom$1) continuation;
            int i16 = roomTrtcProxyImpl$enterTrtcRoom$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                roomTrtcProxyImpl$enterTrtcRoom$1.label = i16 - Integer.MIN_VALUE;
                Object obj = roomTrtcProxyImpl$enterTrtcRoom$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = roomTrtcProxyImpl$enterTrtcRoom$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QQLiveRoomParams.Builder builder = new QQLiveRoomParams.Builder();
                    UserInfo k3 = anchorRoomInfo.k();
                    String str4 = null;
                    if (k3 != null) {
                        str = Boxing.boxLong(k3.f()).toString();
                    } else {
                        str = null;
                    }
                    builder.setUserId(str);
                    builder.setRoomId(anchorRoomInfo.p().g());
                    builder.setRoleType(0);
                    builder.setScene(1);
                    z t16 = anchorRoomInfo.t();
                    if (t16 != null) {
                        str2 = t16.f403246a;
                    } else {
                        str2 = null;
                    }
                    builder.setUserSig(str2);
                    z t17 = anchorRoomInfo.t();
                    if (t17 != null && (wVar = t17.f403248c) != null) {
                        str3 = wVar.f403232c;
                    } else {
                        str3 = null;
                    }
                    builder.setStreamId(str3);
                    z t18 = anchorRoomInfo.t();
                    if (t18 != null) {
                        str4 = t18.f403250e;
                    }
                    builder.setBussinessInfo(b(str4));
                    QQLiveRoomParams params = builder.build();
                    com.tencent.mobileqq.qqlive.sail.trtc.a i17 = i();
                    Intrinsics.checkNotNullExpressionValue(params, "params");
                    roomTrtcProxyImpl$enterTrtcRoom$1.label = 1;
                    obj = i17.h(params, roomTrtcProxyImpl$enterTrtcRoom$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                long longValue = ((Number) obj).longValue();
                AegisLogger.INSTANCE.i("Open_Live|RoomTrtcProxyImpl", "enterTrtcRoom", "errCode=" + longValue);
                return Boxing.boxLong(longValue);
            }
        }
        roomTrtcProxyImpl$enterTrtcRoom$1 = new RoomTrtcProxyImpl$enterTrtcRoom$1(this, continuation);
        Object obj2 = roomTrtcProxyImpl$enterTrtcRoom$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = roomTrtcProxyImpl$enterTrtcRoom$1.label;
        if (i3 == 0) {
        }
        long longValue2 = ((Number) obj2).longValue();
        AegisLogger.INSTANCE.i("Open_Live|RoomTrtcProxyImpl", "enterTrtcRoom", "errCode=" + longValue2);
        return Boxing.boxLong(longValue2);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void disconnectRemote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            i().disconnectRemote();
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|RoomTrtcProxyImpl", "exitTrtcRoom", "streamRecordType=" + this.streamRecordType);
        i().exitRoom();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void g(@Nullable Bitmap bmp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bmp);
        } else {
            this.pauseBmp = bmp;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    @Nullable
    public TRTCVideoQualityParams getVideoQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        int i3 = this.streamRecordType;
        if (i3 != 0 && i3 != 1) {
            AegisLogger.INSTANCE.w("Open_Live|RoomTrtcProxyImpl", "getVideoQuality", "invalid streamRecordType, " + i3);
            return null;
        }
        return i().getVideoQuality();
    }

    @Nullable
    public FrameLayout h() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        FrameLayout frameLayout = this.previewContainer;
        if (frameLayout != null) {
            num = Integer.valueOf(frameLayout.hashCode());
        } else {
            num = null;
        }
        companion.i("Open_Live|RoomTrtcProxyImpl", "getDisplayView", "previewContainer=" + num);
        return this.previewContainer;
    }

    @Nullable
    public final Object k(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return iPatchRedirector.redirect((short) 23, this, context, str, continuation);
        }
        return i().n(context, str, continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void l(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a process) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) process);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (process != null) {
            num = Integer.valueOf(process.hashCode());
        } else {
            num = null;
        }
        companion.i("Open_Live|RoomTrtcProxyImpl", "setVideoProcessor", "process=" + num);
        i().i(process);
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return i().isEngineReady();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void muteRemoteAudio(@NotNull String userId, boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, userId, Boolean.valueOf(mute));
        } else {
            Intrinsics.checkNotNullParameter(userId, "userId");
            i().muteRemoteAudio(userId, mute);
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|RoomTrtcProxyImpl", "pauseStream", "streamRecordType=" + this.streamRecordType);
        i().o(-1, true, this.pauseBmp);
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            AegisLogger.INSTANCE.i("Open_Live|RoomTrtcProxyImpl", "releaseTrtcEngine");
            i().a();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void openMic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            i().m(3);
        }
    }

    public final void p(boolean resumeAudio) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, resumeAudio);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|RoomTrtcProxyImpl", "resumeStream", "streamRecordType=" + this.streamRecordType);
        i().j(resumeAudio);
    }

    public final void q(@Nullable AvConfig avConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) avConfig);
            return;
        }
        if (avConfig == null) {
            AegisLogger.INSTANCE.w("Open_Live|RoomTrtcProxyImpl", "startPreview", "invalid avConfig");
            return;
        }
        if (avConfig.k() != 0 && avConfig.k() != 1) {
            AegisLogger.INSTANCE.w("Open_Live|RoomTrtcProxyImpl", "startPreview", "invalid streamRecordType, " + avConfig.k());
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|RoomTrtcProxyImpl", "startPreview", "streamRecordType=" + avConfig.k());
        if (avConfig.k() == 0) {
            if (this.previewContainer == null) {
                this.previewContainer = new FrameLayout(BaseApplication.context);
            }
            i().g(this.previewContainer);
            i().f();
            i().setMirror(avConfig.e());
        } else {
            i().b(r.f(BaseApplication.context, true, false));
        }
        if (avConfig.j()) {
            if (avConfig.f()) {
                i().enableAudioVolumeEvaluation(300);
            }
            i().m(3);
        }
        this.streamRecordType = avConfig.k();
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        int i3 = this.streamRecordType;
        if (i3 != 0 && i3 != 1) {
            AegisLogger.INSTANCE.w("Open_Live|RoomTrtcProxyImpl", "stopPreview", "invalid streamRecordType, " + i3);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|RoomTrtcProxyImpl", "stopPreview", "streamRecordType=" + i3);
        if (this.streamRecordType == 0) {
            i().i(null);
            i().k();
            this.previewContainer = null;
        } else {
            i().l();
        }
        i().closeMic();
        i().e(false);
        this.streamRecordType = -1;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void setAudioVolume(int volume) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, volume);
        } else {
            i().setAudioVolume(volume);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void setCameraMirror(@NotNull RTCCameraDefine.RTCMirrorType type, boolean mirror) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, type, Boolean.valueOf(mirror));
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = this.streamRecordType;
        if (i3 != 0) {
            AegisLogger.INSTANCE.w("Open_Live|RoomTrtcProxyImpl", "setCameraMirror", "invalid streamRecordType, " + i3);
            return;
        }
        i().d(type, mirror);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void setVideoQuality(@NotNull TRTCVideoQualityParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        int i3 = this.streamRecordType;
        if (i3 != 0 && i3 != 1) {
            AegisLogger.INSTANCE.w("Open_Live|RoomTrtcProxyImpl", "setVideoQuality", "invalid streamRecordType, " + i3);
            return;
        }
        i().setVideoQuality(params);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void startRemoteView(@NotNull String uid, @NotNull FrameLayout videoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) uid, (Object) videoView);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        i().startRemoteView(uid, videoView);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void stopRemoteView(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) uid);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            i().stopRemoteView(uid);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void switchCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        int i3 = this.streamRecordType;
        if (i3 != 0) {
            AegisLogger.INSTANCE.w("Open_Live|RoomTrtcProxyImpl", "switchCamera", "invalid streamRecordType, " + i3);
            return;
        }
        i().switchCamera();
    }
}
