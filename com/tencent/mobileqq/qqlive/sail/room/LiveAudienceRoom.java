package com.tencent.mobileqq.qqlive.sail.room;

import android.util.Size;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYa;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.push.LivePushRepository;
import com.tencent.mobileqq.qqlive.sail.error.a;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.WindowMode;
import com.tencent.mobileqq.qqlive.sso.request.LiveAudienceEnterRoomRequest;
import com.tencent.mobileqq.qqlive.sso.request.LiveAudienceExitHuYaRoomRequest;
import com.tencent.mobileqq.qqlive.sso.request.LiveAudienceExitRoomRequest;
import com.tencent.mobileqq.qqlive.sso.request.LiveAudienceHuYaEnterRoomRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt3.p;
import rt3.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B+\u0012\u0006\u0010f\u001a\u00020\u0018\u0012\u0006\u0010i\u001a\u00020\b\u0012\u0006\u0010l\u001a\u00020j\u0012\b\u0010m\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001B%\b\u0016\u0012\u0006\u0010s\u001a\u00020Z\u0012\u0006\u0010l\u001a\u00020j\u0012\b\u0010m\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0006\b\u0088\u0001\u0010\u008a\u0001J\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0007J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0001J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\u000b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0096\u0001J\u000b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0001J\t\u0010$\u001a\u00020#H\u0096\u0001J\u0011\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020#H\u0096\u0001J\t\u0010'\u001a\u00020\u000bH\u0096\u0001J\u0015\u0010)\u001a\u00020\u000b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0018H\u0096\u0001J\u0011\u0010*\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0018H\u0096\u0001J\u0013\u0010-\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010+H\u0096\u0001J\u0013\u0010/\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010.H\u0096\u0001J\u0013\u00101\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u000100H\u0096\u0001J\u0013\u00103\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u000102H\u0096\u0001J\u0013\u00105\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u000104H\u0096\u0001J\u0013\u00107\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u000106H\u0096\u0001J\u0013\u00109\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u000108H\u0096\u0001J\t\u0010:\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010=\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020;H\u0096\u0001J\t\u0010>\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010?\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0018H\u0096\u0001J\u0013\u0010@\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010+H\u0096\u0001J\u0013\u0010A\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010.H\u0096\u0001J\u0013\u0010B\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u000100H\u0096\u0001J\u0013\u0010C\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u000102H\u0096\u0001J\u0013\u0010D\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u000104H\u0096\u0001J\u0013\u0010E\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u000106H\u0096\u0001J\u0013\u0010F\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u000108H\u0096\u0001J\u0016\u0010J\u001a\u00020\u000b2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020H0GH\u0016J;\u0010Q\u001a\u00020\u000b21\u0010P\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020#0\u0004\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\u000b0Kj\b\u0012\u0004\u0012\u00020#`OH\u0016J\b\u0010R\u001a\u00020\u000bH\u0016J\b\u0010S\u001a\u00020\u000bH\u0016J\b\u0010T\u001a\u00020\u000bH\u0016J\b\u0010U\u001a\u00020\u000bH\u0016J\u0010\u0010X\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020VH\u0016J\b\u0010Y\u001a\u00020VH\u0016J\b\u0010[\u001a\u00020ZH\u0016J\b\u0010\\\u001a\u00020\bH\u0016J\b\u0010]\u001a\u00020\u0018H\u0016J\b\u0010^\u001a\u00020#H\u0016J\n\u0010`\u001a\u0004\u0018\u00010_H\u0016J\u001a\u0010b\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010aH\u0016J\u0012\u0010c\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010aH\u0016J\b\u0010d\u001a\u00020#H\u0016R\u0014\u0010f\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010eR\u0014\u0010i\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010l\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010kR\u0016\u0010m\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010eR\u0014\u0010p\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010oR\u0016\u0010s\u001a\u00020Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010v\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u001b\u0010{\u001a\u00020_8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR\u001c\u0010\u0080\u0001\u001a\u00020|8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b}\u0010x\u001a\u0004\b~\u0010\u007fR+\u0010\u0085\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020a0\u0082\u00010\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R$\u0010\u0087\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0084\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/LiveAudienceRoom;", "Lcom/tencent/mobileqq/qqlive/sail/room/m;", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "Lcom/tencent/mobileqq/qqlive/sail/room/h;", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "Lrt3/f;", "P", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "uid", "Lkotlin/Function0;", "", "success", "failed", "M", "Lrt3/h;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "", "cmd", "V", "Lkotlinx/coroutines/Job;", "O", "N", "", "U", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "newPlayer", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqlive/sail/model/player/a;", "getPlayerQuality", "Landroid/util/Size;", "getVideoSize", "Landroid/view/View;", "getVideoView", "", "isPlaying", "mute", "y", "pauseVideo", "url", "k", "prepare", "Lmi2/a;", "listener", "registerBufferListener", "Lmi2/d;", "registerFirstFrameRenderedListener", "Lmi2/c;", HippyTKDListViewAdapter.X, "Lmi2/e;", "registerSeiInfoListener", "Lmi2/f;", "registerSwitchDefinitionListener", "Lmi2/g;", "registerVideoPreparedListener", "Lmi2/h;", "registerVideoSizeChangedListener", "a", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer$XYAxis;", "axis", "setXYAxis", "stopVideo", "switchStream", "w", "u", "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", "newStreams", "i", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mobileqq/qqlive/sail/room/Resulter;", "callback", "v", "resume", "pause", "stop", "destroy", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/WindowMode;", "mode", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "b", "getRoomId", "getAppID", "isDestroyed", "Lcom/tencent/mobileqq/qqlive/sail/room/LiveRoomInteractive;", "o", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "p", "e", tl.h.F, "Ljava/lang/String;", "appId", "f", "J", "roomId", "Lcom/tencent/mobileqq/qqlive/sail/room/n;", "Lcom/tencent/mobileqq/qqlive/sail/room/n;", "playerProxy", "platform", "Lcom/tencent/mobileqq/qqlive/sail/room/b;", "Lcom/tencent/mobileqq/qqlive/sail/room/b;", "roomState", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "roomInfo", "D", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/WindowMode;", "prevWindowMode", "E", "Lkotlin/Lazy;", ExifInterface.LATITUDE_SOUTH, "()Lcom/tencent/mobileqq/qqlive/sail/room/LiveRoomInteractive;", "interactive", "Lcom/tencent/mobileqq/qqlive/push/LivePushRepository;", UserInfo.SEX_FEMALE, "T", "()Lcom/tencent/mobileqq/qqlive/push/LivePushRepository;", "push", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "G", "Ljava/util/concurrent/ConcurrentHashMap;", "pushCmdToListeners", "H", "pushCmdToJob", "<init>", "(Ljava/lang/String;JLcom/tencent/mobileqq/qqlive/sail/room/n;Ljava/lang/String;)V", "(Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;Lcom/tencent/mobileqq/qqlive/sail/room/n;Ljava/lang/String;)V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveAudienceRoom extends m implements e, h {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private AudienceRoomInfo roomInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private WindowMode prevWindowMode;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy interactive;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy push;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, CopyOnWriteArraySet<g>> pushCmdToListeners;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Job> pushCmdToJob;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n playerProxy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String platform;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b roomState;

    public LiveAudienceRoom(@NotNull String appId, long j3, @NotNull n playerProxy, @Nullable String str) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(playerProxy, "playerProxy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appId, Long.valueOf(j3), playerProxy, str);
            return;
        }
        this.appId = appId;
        this.roomId = j3;
        this.playerProxy = playerProxy;
        this.platform = str;
        this.roomState = new b();
        this.roomInfo = new AudienceRoomInfo(null, null, null, null, null, null, null, 0L, null, null, null, null, 4095, null);
        this.prevWindowMode = WindowMode.NORMAL;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LiveRoomInteractive>() { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveAudienceRoom$interactive$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveAudienceRoom.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveRoomInteractive invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new LiveRoomInteractive(LiveAudienceRoom.this) : (LiveRoomInteractive) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.interactive = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LiveAudienceRoom$push$2.INSTANCE);
        this.push = lazy2;
        this.pushCmdToListeners = new ConcurrentHashMap<>();
        this.pushCmdToJob = new ConcurrentHashMap<>();
        this.roomInfo.D(appId);
    }

    private final void M(long uid, Function0<Unit> success, Function0<Unit> failed) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAudienceRoom$callHuyaJoinRoom$1(uid, success, failed, null), 3, null);
    }

    private final void N() {
        T().c();
        Iterator<Map.Entry<Integer, CopyOnWriteArraySet<g>>> it = this.pushCmdToListeners.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clear();
        }
        this.pushCmdToListeners.clear();
        Iterator<Map.Entry<Integer, Job>> it5 = this.pushCmdToJob.entrySet().iterator();
        while (it5.hasNext()) {
            Job.DefaultImpls.cancel$default(it5.next().getValue(), (CancellationException) null, 1, (Object) null);
        }
        this.pushCmdToJob.clear();
    }

    private final Job O(final int cmd) {
        Job launch$default;
        if (T().e()) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAudienceRoom$createSubscribePushJob$job$1(this, cmd, null), 3, null);
            launch$default.invokeOnCompletion(new Function1<Throwable, Unit>(cmd) { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveAudienceRoom$createSubscribePushJob$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $cmd;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$cmd = cmd;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveAudienceRoom.this, cmd);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    String U;
                    long j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) th5);
                        return;
                    }
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    U = LiveAudienceRoom.this.U();
                    j3 = LiveAudienceRoom.this.roomId;
                    companion.i(U, "subscribePush", "roomId=" + j3 + ", complete, cmd=" + this.$cmd + ", roomId=" + LiveAudienceRoom.this.getRoomId());
                }
            });
            return launch$default;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.e(U(), "createSubscribePushJob", "roomId=" + this.roomId + ", cmd=" + cmd + ", push not opened", new IllegalStateException());
        } else {
            companion.e(U(), "createSubscribePushJob", "roomId=" + this.roomId + ", cmd=" + cmd + ", push not opened");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object P(Continuation<? super l<rt3.f>> continuation) {
        LiveAudienceRoom$enterHuYaRoom$1 liveAudienceRoom$enterHuYaRoom$1;
        Object coroutine_suspended;
        int i3;
        final LiveAudienceRoom liveAudienceRoom;
        l<rt3.f> h16;
        if (continuation instanceof LiveAudienceRoom$enterHuYaRoom$1) {
            liveAudienceRoom$enterHuYaRoom$1 = (LiveAudienceRoom$enterHuYaRoom$1) continuation;
            int i16 = liveAudienceRoom$enterHuYaRoom$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                liveAudienceRoom$enterHuYaRoom$1.label = i16 - Integer.MIN_VALUE;
                Object obj = liveAudienceRoom$enterHuYaRoom$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveAudienceRoom$enterHuYaRoom$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        liveAudienceRoom = (LiveAudienceRoom) liveAudienceRoom$enterHuYaRoom$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    QLog.d(U(), 4, "enterHuYaRoom");
                    LiveAudienceHuYaEnterRoomRequest liveAudienceHuYaEnterRoomRequest = new LiveAudienceHuYaEnterRoomRequest(this.appId, this.roomId);
                    ILiveNetRequest iLiveNetRequest = (ILiveNetRequest) QRoute.api(ILiveNetRequest.class);
                    liveAudienceRoom$enterHuYaRoom$1.L$0 = this;
                    liveAudienceRoom$enterHuYaRoom$1.label = 1;
                    obj = iLiveNetRequest.sendRequestOnSuspend(liveAudienceHuYaEnterRoomRequest, liveAudienceRoom$enterHuYaRoom$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveAudienceRoom = this;
                }
                h16 = com.tencent.mobileqq.qqlive.sail.model.a.h((QQLiveResponse) obj);
                QLog.d(liveAudienceRoom.U(), 2, "enterHuYaRoom reply");
                long j3 = 0;
                if (h16.b() != 0) {
                    rt3.f d16 = h16.d();
                    Intrinsics.checkNotNull(d16);
                    p pVar = d16.f432284b;
                    if (pVar != null) {
                        j3 = pVar.f432336d;
                    }
                    liveAudienceRoom.M(j3, LiveAudienceRoom$enterHuYaRoom$2$1.INSTANCE, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveAudienceRoom$enterHuYaRoom$2$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveAudienceRoom.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                LiveAudienceRoom.this.R();
                            } else {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                    AudienceRoomInfo audienceRoomInfo = liveAudienceRoom.roomInfo;
                    rt3.f d17 = h16.d();
                    Intrinsics.checkNotNull(d17);
                    audienceRoomInfo.A(d17);
                    liveAudienceRoom.T().f(liveAudienceRoom.appId, liveAudienceRoom.roomId, "huya");
                } else {
                    QLog.e(liveAudienceRoom.U(), 1, "enterHuYaRoom roomId=" + liveAudienceRoom.roomId + ", enter room failed, result=" + h16);
                    liveAudienceRoom.R();
                }
                return h16;
            }
        }
        liveAudienceRoom$enterHuYaRoom$1 = new LiveAudienceRoom$enterHuYaRoom$1(this, continuation);
        Object obj2 = liveAudienceRoom$enterHuYaRoom$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveAudienceRoom$enterHuYaRoom$1.label;
        if (i3 == 0) {
        }
        h16 = com.tencent.mobileqq.qqlive.sail.model.a.h((QQLiveResponse) obj2);
        QLog.d(liveAudienceRoom.U(), 2, "enterHuYaRoom reply");
        long j36 = 0;
        if (h16.b() != 0) {
        }
        return h16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Q(Continuation<? super l<rt3.h>> continuation) {
        LiveAudienceRoom$enterRoom$1 liveAudienceRoom$enterRoom$1;
        Object coroutine_suspended;
        int i3;
        LiveAudienceRoom liveAudienceRoom;
        if (continuation instanceof LiveAudienceRoom$enterRoom$1) {
            liveAudienceRoom$enterRoom$1 = (LiveAudienceRoom$enterRoom$1) continuation;
            int i16 = liveAudienceRoom$enterRoom$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                liveAudienceRoom$enterRoom$1.label = i16 - Integer.MIN_VALUE;
                Object obj = liveAudienceRoom$enterRoom$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveAudienceRoom$enterRoom$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        liveAudienceRoom = (LiveAudienceRoom) liveAudienceRoom$enterRoom$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    LiveAudienceEnterRoomRequest liveAudienceEnterRoomRequest = new LiveAudienceEnterRoomRequest(this.appId, this.roomId, new String[]{this.playerProxy.e().f().getValue()});
                    ILiveNetRequest iLiveNetRequest = (ILiveNetRequest) QRoute.api(ILiveNetRequest.class);
                    liveAudienceRoom$enterRoom$1.L$0 = this;
                    liveAudienceRoom$enterRoom$1.label = 1;
                    obj = iLiveNetRequest.sendRequestOnSuspend(liveAudienceEnterRoomRequest, liveAudienceRoom$enterRoom$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveAudienceRoom = this;
                }
                l<rt3.h> g16 = com.tencent.mobileqq.qqlive.sail.model.a.g((QQLiveResponse) obj);
                if (liveAudienceRoom.roomState.c() == 70 && liveAudienceRoom.roomState.c() != 80) {
                    if (g16.b() == 0) {
                        AudienceRoomInfo audienceRoomInfo = liveAudienceRoom.roomInfo;
                        rt3.h d16 = g16.d();
                        Intrinsics.checkNotNull(d16);
                        audienceRoomInfo.B(d16);
                        LivePushRepository.g(liveAudienceRoom.T(), liveAudienceRoom.appId, liveAudienceRoom.roomId, null, 4, null);
                    } else {
                        AegisLogger.INSTANCE.e(liveAudienceRoom.U(), "enterRoom", "roomId=" + liveAudienceRoom.roomId + ", enter room failed, result=" + g16);
                    }
                    return g16;
                }
                AegisLogger.INSTANCE.e(liveAudienceRoom.U(), "enterRoom", "roomId=" + liveAudienceRoom.roomId + ", enter success but room state is " + liveAudienceRoom.roomState);
                liveAudienceRoom.R();
                return a.Companion.c(com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE, -10000003L, null, null, 4, null);
            }
        }
        liveAudienceRoom$enterRoom$1 = new LiveAudienceRoom$enterRoom$1(this, continuation);
        Object obj2 = liveAudienceRoom$enterRoom$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveAudienceRoom$enterRoom$1.label;
        if (i3 == 0) {
        }
        l<rt3.h> g162 = com.tencent.mobileqq.qqlive.sail.model.a.g((QQLiveResponse) obj2);
        if (liveAudienceRoom.roomState.c() == 70) {
        }
        AegisLogger.INSTANCE.e(liveAudienceRoom.U(), "enterRoom", "roomId=" + liveAudienceRoom.roomId + ", enter success but room state is " + liveAudienceRoom.roomState);
        liveAudienceRoom.R();
        return a.Companion.c(com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE, -10000003L, null, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        this.roomInfo.E(0L);
        N();
        if (this.roomInfo.x()) {
            QQLiveHuYa.f271333a.g();
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new LiveAudienceExitHuYaRoomRequest(this.appId, this.roomId), new Function1<QQLiveResponse<s>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveAudienceRoom$exitRoom$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveAudienceRoom.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<s> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<s> it) {
                    String U;
                    long j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isFailed()) {
                        AegisLogger.Companion companion = AegisLogger.INSTANCE;
                        U = LiveAudienceRoom.this.U();
                        j3 = LiveAudienceRoom.this.roomId;
                        companion.w(U, "exitHuYaRoom", "roomId=" + j3 + ", exit huya room failed, result=" + it);
                    }
                }
            });
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new LiveAudienceExitRoomRequest(this.appId, this.roomId, 0L), new Function1<QQLiveResponse<it3.f>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.room.LiveAudienceRoom$exitRoom$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveAudienceRoom.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<it3.f> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<it3.f> it) {
                    String U;
                    long j3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isFailed()) {
                        AegisLogger.Companion companion = AegisLogger.INSTANCE;
                        U = LiveAudienceRoom.this.U();
                        j3 = LiveAudienceRoom.this.roomId;
                        companion.w(U, "exitRoom", "roomId=" + j3 + ", exit room failed, result=" + it);
                    }
                }
            });
        }
    }

    private final LiveRoomInteractive S() {
        return (LiveRoomInteractive) this.interactive.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LivePushRepository T() {
        return (LivePushRepository) this.push.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String U() {
        return "Audience|LiveAudienceRoom";
    }

    private final void V(int cmd) {
        Job O;
        if (!this.pushCmdToJob.containsKey(Integer.valueOf(cmd)) && (O = O(cmd)) != null) {
            this.pushCmdToJob.put(Integer.valueOf(cmd), O);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void A(@Nullable mi2.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) listener);
        } else {
            this.playerProxy.A(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.playerProxy.a();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.e
    public void d(@NotNull WindowMode mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) mode);
            return;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (this.roomInfo.v() == mode) {
            return;
        }
        this.prevWindowMode = this.roomInfo.v();
        this.roomInfo.G(mode);
        this.roomInfo.M(String.valueOf(System.currentTimeMillis()));
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAudienceRoom$destroy$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 37, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void e(@Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) listener);
        } else if (listener != null) {
            Iterator<Map.Entry<Integer, CopyOnWriteArraySet<g>>> it = this.pushCmdToListeners.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().remove(listener);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    @NotNull
    public String getAppID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.appId;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    @Nullable
    public com.tencent.mobileqq.qqlive.sail.model.player.a getPlayerQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.qqlive.sail.model.player.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.playerProxy.getPlayerQuality();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Long) iPatchRedirector.redirect((short) 41, (Object) this)).longValue();
        }
        return this.roomId;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    @Nullable
    public Size getVideoSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Size) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.playerProxy.getVideoSize();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    @Nullable
    public View getVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.playerProxy.getVideoView();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.e
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        return this.roomInfo.x();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.e
    public void i(@NotNull List<com.tencent.mobileqq.qqlive.sail.model.audience.a> newStreams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) newStreams);
            return;
        }
        Intrinsics.checkNotNullParameter(newStreams, "newStreams");
        for (com.tencent.mobileqq.qqlive.sail.model.audience.a aVar : newStreams) {
            AegisLogger.INSTANCE.i(U(), "updateStreamInfo", "roomId=" + this.roomId + ", " + aVar);
        }
        this.roomInfo.N(newStreams);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public boolean isDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this)).booleanValue();
        }
        if (this.roomState.c() == 80) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.playerProxy.isPlaying();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void k(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) url);
        } else {
            this.playerProxy.k(url);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void m(@Nullable mi2.h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) listener);
        } else {
            this.playerProxy.m(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void n(@Nullable IQQLivePlayer newPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) newPlayer);
        } else {
            this.playerProxy.n(newPlayer);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    @Nullable
    public LiveRoomInteractive o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (LiveRoomInteractive) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        if (this.roomId <= 0) {
            AegisLogger.INSTANCE.w(U(), "asInteractive", "invalid room id");
            return null;
        }
        return S();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void p(int cmd, @Nullable g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, cmd, (Object) listener);
            return;
        }
        if (listener != null) {
            if (this.pushCmdToListeners.get(Integer.valueOf(cmd)) == null) {
                this.pushCmdToListeners.put(Integer.valueOf(cmd), new CopyOnWriteArraySet<>());
            }
            CopyOnWriteArraySet<g> copyOnWriteArraySet = this.pushCmdToListeners.get(Integer.valueOf(cmd));
            if (copyOnWriteArraySet != null) {
                copyOnWriteArraySet.add(listener);
            }
            V(cmd);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAudienceRoom$pause$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 35, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void pauseVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.playerProxy.pauseVideo();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void prepare(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) url);
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            this.playerProxy.prepare(url);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.e
    @NotNull
    public WindowMode q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (WindowMode) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.prevWindowMode;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void r(@Nullable mi2.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) listener);
        } else {
            this.playerProxy.r(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerBufferListener(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
        } else {
            this.playerProxy.registerBufferListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerFirstFrameRenderedListener(@Nullable mi2.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
        } else {
            this.playerProxy.registerFirstFrameRenderedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerSeiInfoListener(@Nullable mi2.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) listener);
        } else {
            this.playerProxy.registerSeiInfoListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerSwitchDefinitionListener(@Nullable mi2.f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) listener);
        } else {
            this.playerProxy.registerSwitchDefinitionListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerVideoPreparedListener(@Nullable mi2.g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) listener);
        } else {
            this.playerProxy.registerVideoPreparedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void registerVideoSizeChangedListener(@Nullable mi2.h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
        } else {
            this.playerProxy.registerVideoSizeChangedListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAudienceRoom$resume$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 34, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void s(@Nullable mi2.f listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) listener);
        } else {
            this.playerProxy.s(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void setXYAxis(@NotNull IQQLivePlayer.XYAxis axis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) axis);
        } else {
            Intrinsics.checkNotNullParameter(axis, "axis");
            this.playerProxy.setXYAxis(axis);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAudienceRoom$stop$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 36, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void stopVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.playerProxy.stopVideo();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void switchStream(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) url);
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            this.playerProxy.switchStream(url);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void u(@Nullable mi2.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) listener);
        } else {
            this.playerProxy.u(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void v(@NotNull Function1<? super l<Boolean>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAudienceRoom$start$1(this, callback, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void w(@Nullable mi2.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) listener);
        } else {
            this.playerProxy.w(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void x(@Nullable mi2.c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) listener);
        } else {
            this.playerProxy.x(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void y(boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, mute);
        } else {
            this.playerProxy.y(mute);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.h
    public void z(@Nullable mi2.g listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) listener);
        } else {
            this.playerProxy.z(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    @NotNull
    public AudienceRoomInfo b() {
        AudienceRoomInfo a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (AudienceRoomInfo) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        a16 = r2.a((r28 & 1) != 0 ? r2.basicInfo : null, (r28 & 2) != 0 ? r2.settingInfo : null, (r28 & 4) != 0 ? r2.anchorInfo : null, (r28 & 8) != 0 ? r2.avInfo : null, (r28 & 16) != 0 ? r2.ecomInfo : null, (r28 & 32) != 0 ? r2.gameTaskInfo : null, (r28 & 64) != 0 ? r2.appId : null, (r28 & 128) != 0 ? r2.enterRoomTime : 0L, (r28 & 256) != 0 ? r2.windowMode : null, (r28 & 512) != 0 ? r2.windowModeSeq : null, (r28 & 1024) != 0 ? r2.roomEnterSetting : null, (r28 & 2048) != 0 ? this.roomInfo.platform : null);
        return a16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveAudienceRoom(@NotNull AudienceRoomInfo roomInfo, @NotNull n playerProxy, @Nullable String str) {
        this(roomInfo.l(), roomInfo.getRoomId(), playerProxy, str);
        AudienceRoomInfo a16;
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(playerProxy, "playerProxy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, roomInfo, playerProxy, str);
            return;
        }
        a16 = roomInfo.a((r28 & 1) != 0 ? roomInfo.basicInfo : null, (r28 & 2) != 0 ? roomInfo.settingInfo : null, (r28 & 4) != 0 ? roomInfo.anchorInfo : null, (r28 & 8) != 0 ? roomInfo.avInfo : null, (r28 & 16) != 0 ? roomInfo.ecomInfo : null, (r28 & 32) != 0 ? roomInfo.gameTaskInfo : null, (r28 & 64) != 0 ? roomInfo.appId : null, (r28 & 128) != 0 ? roomInfo.enterRoomTime : 0L, (r28 & 256) != 0 ? roomInfo.windowMode : null, (r28 & 512) != 0 ? roomInfo.windowModeSeq : null, (r28 & 1024) != 0 ? roomInfo.roomEnterSetting : null, (r28 & 2048) != 0 ? roomInfo.platform : null);
        this.roomInfo = a16;
        a16.E(0L);
    }
}
