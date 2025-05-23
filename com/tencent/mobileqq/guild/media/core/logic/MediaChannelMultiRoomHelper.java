package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.media.core.CommonRsp;
import com.tencent.mobileqq.guild.media.core.data.MediaRoomStatus;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomAddUpInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProAVRoomOptPushInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVDevOptInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVRoomCtrlOptInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.fc;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\n*\u0003KOS\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0002Z[B\u000f\u0012\u0006\u0010F\u001a\u00020C\u00a2\u0006\u0004\bW\u0010XJ\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\u0013\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0016\u0010\u001e\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0016\u0010 \u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0016\u0010$\u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020)H\u0002J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\"2\u0006\u0010-\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\"H\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\"H\u0002J\u0012\u00103\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u000102H\u0002J\u001a\u00107\u001a\u00020\u00052\u0006\u00105\u001a\u0002042\b\b\u0002\u00106\u001a\u00020\u0005H\u0002J\u0010\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0005H\u0002J\b\u0010:\u001a\u000204H\u0002J\b\u0010;\u001a\u00020'H\u0002J\u001b\u0010=\u001a\u00020,2\u0006\u0010<\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010>J\b\u0010?\u001a\u00020\u0007H\u0002J\b\u0010@\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020\u0007H\u0002J\u0016\u0010B\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010U\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUserAVRspInfo;", "rspInfo", "", "isFromQuery", "", "X0", "b1", "E0", "p", "u", "i1", "f0", "i0", "", "Lcom/tencent/mobileqq/guild/media/core/data/g;", "mediaRoomParamList", "j0", "l0", "F0", "roomStatus", "Lcom/tencent/mobileqq/guild/media/core/logic/l;", "H0", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAVRoomCtrlOptInfo;", "info", "I0", "J0", "severRoomList", "M0", "roomList", "O0", "", "", "delRoomList", "P0", "Luh2/b;", "R0", "", "S0", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/fc;", "T0", "roomId", "Lcom/tencent/mobileqq/guild/media/core/a;", "rsp", "U0", "delRoomId", "V0", "Z0", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProAVRoomOptPushInfo;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "", "micOpt", "isFromEnterRoomQuery", "c1", "canTalk", "e1", "f1", "g1", "req", "h1", "(Lcom/tencent/mobileqq/guild/media/core/logic/l;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j1", "k1", "l1", "m1", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$b;", "f", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$b;", "waitForMainTRTCRoom", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$d", tl.h.F, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$d;", "enterTRTCMainRoomEvent", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$e", "i", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$e;", "observer", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$h", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$h;", "switchThemeObserver", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelMultiRoomHelper extends com.tencent.mobileqq.guild.media.core.logic.h {

    /* renamed from: C */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    /* renamed from: f, reason: from kotlin metadata */
    @Nullable
    private b waitForMainTRTCRoom;

    /* renamed from: h */
    @NotNull
    private final d enterTRTCMainRoomEvent;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private final e observer;

    /* renamed from: m */
    @NotNull
    private final h switchThemeObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$a;", "", "", "MIC_SEAL_VOLUME_VALUE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.core.logic.MediaChannelMultiRoomHelper$a */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$b;", "", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "<init>", "(Lkotlinx/coroutines/channels/Channel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b {

        /* renamed from: a, reason: from kotlin metadata */
        @NotNull
        private final Channel<Unit> com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String;

        public b(@NotNull Channel<Unit> channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String = channel;
        }

        public final void a() {
            try {
                this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String.mo2003trySendJP2dKIU(Unit.INSTANCE);
            } catch (Exception e16) {
                QLog.i("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "MediaChannelMultiRoomHelper offer error:" + e16);
            }
        }

        @Nullable
        public final Object b(@NotNull Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            Object receive = this.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String.receive(continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (receive == coroutine_suspended) {
                return receive;
            }
            return Unit.INSTANCE;
        }

        public /* synthetic */ b(Channel channel, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? ChannelKt.Channel$default(0, null, null, 6, null) : channel);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$c", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.i {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[closeMicrophone] result " + result + ", errMsg " + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$d", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/g;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.g> {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.g event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[EnterTRTCMainRoomEvent.onEventReceive] ");
            b bVar = MediaChannelMultiRoomHelper.this.waitForMainTRTCRoom;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$e", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProAVRoomOptPushInfo;", "info", "", "onPushAVRoomOptChange", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends GPServiceObserver {
        e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
        
            if (r1 != true) goto L61;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void onPushAVRoomOptChange(@Nullable IGProAVRoomOptPushInfo info) {
            Integer num;
            boolean z16;
            String switchRoomId;
            boolean z17;
            String delRoomId;
            boolean z18;
            Logger.a d16 = Logger.f235387a.d();
            if (info != null) {
                num = Integer.valueOf(info.getOptType());
            } else {
                num = null;
            }
            boolean z19 = true;
            d16.d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[onPushAVRoomOptChange] type " + num);
            if (info != null && (delRoomId = info.getDelRoomId()) != null) {
                if (delRoomId.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z16 = true;
                    if (z16) {
                        MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper = MediaChannelMultiRoomHelper.this;
                        String delRoomId2 = info.getDelRoomId();
                        Intrinsics.checkNotNullExpressionValue(delRoomId2, "info.delRoomId");
                        mediaChannelMultiRoomHelper.V0(delRoomId2);
                        MediaChannelMultiRoomHelper.this.k1();
                    }
                    if (info != null && (switchRoomId = info.getSwitchRoomId()) != null) {
                        if (switchRoomId.length() <= 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                    }
                    z19 = false;
                    if (z19) {
                        MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper2 = MediaChannelMultiRoomHelper.this;
                        String switchRoomId2 = info.getSwitchRoomId();
                        Intrinsics.checkNotNullExpressionValue(switchRoomId2, "info.switchRoomId");
                        mediaChannelMultiRoomHelper2.Z0(switchRoomId2);
                        MediaChannelMultiRoomHelper.this.k1();
                    }
                    MediaChannelMultiRoomHelper.this.a1(info);
                    MediaChannelMultiRoomHelper.this.i1();
                }
            }
            z16 = false;
            if (z16) {
            }
            if (info != null) {
                if (switchRoomId.length() <= 0) {
                }
            }
            z19 = false;
            if (z19) {
            }
            MediaChannelMultiRoomHelper.this.a1(info);
            MediaChannelMultiRoomHelper.this.i1();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "code", "", "msg", "", "kotlin.jvm.PlatformType", "onCallback"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class f implements ITRTCAudioRoom.a {

        /* renamed from: a */
        final /* synthetic */ CancellableContinuation<CommonRsp> f228201a;

        /* JADX WARN: Multi-variable type inference failed */
        f(CancellableContinuation<? super CommonRsp> cancellableContinuation) {
            this.f228201a = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
        public final void onCallback(int i3, String msg2) {
            Logger logger = Logger.f235387a;
            CancellableContinuation<CommonRsp> cancellableContinuation = this.f228201a;
            logger.d().i("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "enterSubRoom, code:" + i3 + ", msg:" + msg2 + ", isActive:" + cancellableContinuation.isActive());
            if (!this.f228201a.isActive()) {
                return;
            }
            CancellableContinuation<CommonRsp> cancellableContinuation2 = this.f228201a;
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(new CommonRsp(i3, msg2)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$g", "Lcom/tencent/mobileqq/guild/media/core/b;", "", "isSuccess", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.b {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.b
        public void a(boolean isSuccess, @Nullable IGProSecurityResult securityResult) {
            Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[reEnterTRTC] result " + isSuccess);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelMultiRoomHelper$h", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        h() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a */
        public void D0(@NotNull SwitchThemeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getOldThemeType() == 6 || event.getNewThemeType() == 6) {
                Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[onEventReceive] event " + event);
                MediaChannelMultiRoomHelper.this.k1();
            }
        }
    }

    public MediaChannelMultiRoomHelper(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
        this.enterTRTCMainRoomEvent = new d();
        this.observer = new e();
        this.switchThemeObserver = new h();
    }

    private final List<MediaRoomStatus> F0(IGProUserAVRspInfo rspInfo) {
        List<MediaRoomStatus> arrayList;
        String str;
        ArrayList<IGProAVRoomCtrlOptInfo> roomDevOpts;
        int collectionSizeOrDefault;
        if (rspInfo != null && (roomDevOpts = rspInfo.getRoomDevOpts()) != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(roomDevOpts, 10);
            arrayList = new ArrayList<>(collectionSizeOrDefault);
            for (IGProAVRoomCtrlOptInfo it : roomDevOpts) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(I0(it));
            }
        } else {
            arrayList = new ArrayList<>();
        }
        if (arrayList.isEmpty()) {
            int f16 = f1();
            String E = this.mediaChannelCore.E();
            if (rspInfo != null) {
                str = rspInfo.getTrtcKey();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            arrayList = CollectionsKt__CollectionsJVMKt.listOf(new MediaRoomStatus(E, f16, str, true, false, 16, null));
        }
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[covertToMediaRoomList] mediaRoomParamList " + arrayList);
        return arrayList;
    }

    public final EnterTrtcRoomReq H0(MediaRoomStatus roomStatus) {
        j enterChannelParamsForTRTCRoom = this.mediaChannelCore.o0().getEnterChannelParamsForTRTCRoom();
        return new EnterTrtcRoomReq(1, enterChannelParamsForTRTCRoom.getSdkAppId(), roomStatus.getPrivateMapKey(), roomStatus.getRoomStrId(), enterChannelParamsForTRTCRoom.getUserId(), enterChannelParamsForTRTCRoom.getUserSign(), 21, true, roomStatus.getEnableTRTCPublish(), roomStatus.getIsMicInactive());
    }

    private final MediaRoomStatus I0(IGProAVRoomCtrlOptInfo info) {
        boolean z16;
        boolean z17;
        int numRoomId = info.getNumRoomId();
        String roomId = info.getRoomId();
        if (roomId == null) {
            roomId = "";
        }
        if (roomId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            roomId = String.valueOf(numRoomId);
        }
        String str = roomId;
        String privateMapKey = info.getPrivateMapKey();
        boolean isCurrentRoom = info.getIsCurrentRoom();
        if (info.getDevOpt().getMicOpt() == 15) {
            z17 = true;
        } else {
            z17 = false;
        }
        Intrinsics.checkNotNullExpressionValue(privateMapKey, "privateMapKey");
        return new MediaRoomStatus(str, numRoomId, privateMapKey, isCurrentRoom, z17);
    }

    private final void M0(List<MediaRoomStatus> severRoomList) {
        int collectionSizeOrDefault;
        Set set;
        int collectionSizeOrDefault2;
        Set set2;
        Set minus;
        Set<String> minus2;
        ArrayList<MediaRoomStatus> j3 = this.mediaChannelCore.y0().j();
        Intrinsics.checkNotNullExpressionValue(j3, "mediaChannelCore.getTRTCAudioRoom().roomList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : j3) {
            if (true ^ ((MediaRoomStatus) obj).d()) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((MediaRoomStatus) it.next()).getRoomStrId());
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList2);
        List<MediaRoomStatus> list = severRoomList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (!((MediaRoomStatus) obj2).d()) {
                arrayList3.add(obj2);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            arrayList4.add(((MediaRoomStatus) it5.next()).getRoomStrId());
        }
        set2 = CollectionsKt___CollectionsKt.toSet(arrayList4);
        minus = SetsKt___SetsKt.minus(set2, (Iterable) set);
        minus2 = SetsKt___SetsKt.minus(set, (Iterable) set2);
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[enterOrExitSubRoom] currentRoomIdSet: " + set + ", needUpdateRoomIdSet " + set2 + ", needEnterSubRoomList " + minus + ", needExitRoomIdList " + minus2);
        if (!minus.isEmpty()) {
            ArrayList arrayList5 = new ArrayList();
            for (Object obj3 : list) {
                if (minus.contains(((MediaRoomStatus) obj3).getRoomStrId())) {
                    arrayList5.add(obj3);
                }
            }
            O0(arrayList5);
        }
        if (!minus2.isEmpty()) {
            P0(minus2);
        }
    }

    private final void O0(List<MediaRoomStatus> roomList) {
        CorountineFunKt.e(this.mediaChannelCore.getCoroutineScope(), "enterSubRoomList", null, null, Boolean.TRUE, new MediaChannelMultiRoomHelper$enterSubRoomList$1(this, roomList, null), 6, null);
    }

    private final void P0(Set<String> delRoomList) {
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[handleBatchExitSubRoom] exitSubRoomList " + delRoomList);
        for (final String str : delRoomList) {
            this.mediaChannelCore.y0().f(str, new ITRTCAudioRoom.a() { // from class: com.tencent.mobileqq.guild.media.core.logic.ar
                @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
                public final void onCallback(int i3, String str2) {
                    MediaChannelMultiRoomHelper.Q0(str, i3, str2);
                }
            });
        }
    }

    public static final void Q0(String it, int i3, String str) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[handleBatchExitSubRoom] result roomId[" + it + "] code " + i3 + ", msg " + str);
    }

    public final uh2.b R0() {
        AppInterface l3 = com.tencent.mobileqq.guild.util.ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        IRuntimeService runtimeService = l3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        return (uh2.b) runtimeService;
    }

    private final long S0() {
        try {
            String selfTinyId = ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).getSelfTinyId();
            Intrinsics.checkNotNullExpressionValue(selfTinyId, "gpsService.selfTinyId");
            return Long.parseLong(selfTinyId);
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getSelfTinyId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    public final fc T0() {
        fc fcVar = new fc();
        fcVar.a().e(g1());
        fcVar.a().d(f1());
        fcVar.g(S0());
        return fcVar;
    }

    public final void U0(String roomId, CommonRsp rsp) {
        int code = rsp.getCode();
        String msg2 = rsp.getMsg();
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "[handleEnterTrtcErr] trtc roomId[" + roomId + "] enterRoom failed result:" + code + ", msg " + msg2;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.MediaGroup.MediaSubTRTCRoom", 1, (String) it.next(), null);
        }
        com.tencent.mobileqq.guild.performance.report.e.h("trtc_sub_room_enter_err", code, msg2);
        com.tencent.mobileqq.guild.media.core.data.b.c("trtc_sub_room_enter_err", code, String.valueOf(com.tencent.mobileqq.guild.media.core.j.c().f()));
        String a16 = com.tencent.mobileqq.guild.media.core.data.b.a(3, code, "", com.tencent.mobileqq.guild.media.core.j.c().r());
        com.tencent.mobileqq.guild.media.core.j.a().Q().D(a16, "trtc enterSubRoom roomId[" + roomId + "] failed result:" + code + ", errMsg:" + msg2);
    }

    public final void V0(final String delRoomId) {
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[handleExitSubRoom] delRoomId " + delRoomId);
        if (Intrinsics.areEqual(this.mediaChannelCore.v0().h(), delRoomId)) {
            l0();
        }
        this.mediaChannelCore.y0().f(delRoomId, new ITRTCAudioRoom.a() { // from class: com.tencent.mobileqq.guild.media.core.logic.aq
            @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
            public final void onCallback(int i3, String str) {
                MediaChannelMultiRoomHelper.W0(MediaChannelMultiRoomHelper.this, delRoomId, i3, str);
            }
        });
    }

    public static final void W0(MediaChannelMultiRoomHelper this$0, String delRoomId, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(delRoomId, "$delRoomId");
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[handleOnDeleteGroup] result roomId " + delRoomId + ", code " + i3 + ", msg " + str);
        this$0.k1();
    }

    public static /* synthetic */ void Y0(MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper, IGProUserAVRspInfo iGProUserAVRspInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        mediaChannelMultiRoomHelper.X0(iGProUserAVRspInfo, z16);
    }

    public final void Z0(String roomId) {
        String h16 = this.mediaChannelCore.v0().h();
        boolean z16 = true;
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[handleSwitchRoom] switchRoomId " + roomId + ", anchorRoomId[" + h16 + "]");
        if (h16.length() != 0) {
            z16 = false;
        }
        if (z16 || !Intrinsics.areEqual(h16, roomId)) {
            l0();
            this.mediaChannelCore.y0().l(roomId);
        }
    }

    public final void a1(IGProAVRoomOptPushInfo iGProAVRoomOptPushInfo) {
        IGProAVRoomAddUpInfo roomAddUpInfo;
        boolean z16;
        int h06;
        if (iGProAVRoomOptPushInfo == null || iGProAVRoomOptPushInfo.getOptType() != 1 || (roomAddUpInfo = iGProAVRoomOptPushInfo.getRoomAddUpInfo()) == null) {
            return;
        }
        String roomId = roomAddUpInfo.getRoomId();
        Logger logger = Logger.f235387a;
        logger.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[handleUpdatePush] updateRoomId " + roomId + ", opt dev " + roomAddUpInfo.getAVDevOpt().getMicOpt());
        String h16 = this.mediaChannelCore.v0().h();
        boolean z17 = false;
        if (!Intrinsics.areEqual(h16, roomId)) {
            ArrayList<MediaRoomStatus> audioRoomList = this.mediaChannelCore.y0().j();
            Intrinsics.checkNotNullExpressionValue(audioRoomList, "audioRoomList");
            if (!(audioRoomList instanceof Collection) || !audioRoomList.isEmpty()) {
                Iterator<T> it = audioRoomList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (Intrinsics.areEqual(((MediaRoomStatus) it.next()).getRoomStrId(), roomId)) {
                        z17 = true;
                        break;
                    }
                }
            }
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[handleUpdatePush] currentRoomId[" + h16 + "], updateRoomId[" + roomId + "], exist " + z17;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it5 = bVar.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, (String) it5.next(), null);
            }
            if (!z17) {
                k1();
                return;
            }
            return;
        }
        if (roomAddUpInfo.getAVDevOpt().getMicOpt() == 15) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            h06 = 0;
        } else {
            h06 = com.tencent.mobileqq.guild.util.bw.h0();
        }
        logger.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[handleUpdatePush] setAudioCaptureVolume[" + roomId + "] mic " + h06);
        this.mediaChannelCore.y0().z(roomId, h06);
        e1(d1(this, roomAddUpInfo.getAVDevOpt().getMicOpt(), false, 2, null));
        k1();
    }

    private final boolean c1(int micOpt, boolean isFromEnterRoomQuery) {
        if (isFromEnterRoomQuery) {
            if (micOpt != 12 && micOpt != 14 && micOpt != 15) {
                return false;
            }
        } else if (micOpt != 12 && micOpt != 15) {
            return false;
        }
        return true;
    }

    static /* synthetic */ boolean d1(MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        return mediaChannelMultiRoomHelper.c1(i3, z16);
    }

    private final void e1(boolean canTalk) {
        if (!b1()) {
            return;
        }
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[notifyMultiRoomCanTalk] canTalk " + canTalk);
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.ae(canTalk));
    }

    private final void f0(IGProUserAVRspInfo rspInfo) {
        ArrayList<IGProAVRoomCtrlOptInfo> roomDevOpts;
        boolean z16;
        boolean z17 = false;
        if (rspInfo != null && (roomDevOpts = rspInfo.getRoomDevOpts()) != null && !roomDevOpts.isEmpty()) {
            Iterator<T> it = roomDevOpts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IGProAVRoomCtrlOptInfo iGProAVRoomCtrlOptInfo = (IGProAVRoomCtrlOptInfo) it.next();
                if (iGProAVRoomCtrlOptInfo.getIsCurrentRoom() && iGProAVRoomCtrlOptInfo.getDevOpt().getMicOpt() == 15) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        this.mediaChannelCore.o0().a0().setValue(Boolean.valueOf(z17));
    }

    private final int f1() {
        try {
            return Integer.parseInt(this.mediaChannelCore.E());
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "parseChannelId: parse int error! " + this.mediaChannelCore.E();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, (String) it.next(), null);
            }
            return 0;
        }
    }

    private final long g1() {
        try {
            return Long.parseLong(this.mediaChannelCore.getGuildID());
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("parseGuildId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    public final Object h1(EnterTrtcRoomReq enterTrtcRoomReq, Continuation<? super CommonRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.mediaChannelCore.y0().m(enterTrtcRoomReq, new f(cancellableContinuationImpl));
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelMultiRoomHelper$questEnterTrtcRoom$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().i("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "questEnterTrtcRoom job cancel.");
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
    
        if (r5.getMicOpt() == 12) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void i0(IGProUserAVRspInfo rspInfo, boolean isFromQuery) {
        boolean z16;
        boolean z17;
        ArrayList<IGProAVRoomCtrlOptInfo> roomDevOpts;
        boolean z18 = true;
        if (rspInfo != null && (roomDevOpts = rspInfo.getRoomDevOpts()) != null && (!roomDevOpts.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ArrayList<IGProAVRoomCtrlOptInfo> roomDevOpts2 = rspInfo.getRoomDevOpts();
            Intrinsics.checkNotNullExpressionValue(roomDevOpts2, "rspInfo.roomDevOpts");
            if (!(roomDevOpts2 instanceof Collection) || !roomDevOpts2.isEmpty()) {
                for (IGProAVRoomCtrlOptInfo iGProAVRoomCtrlOptInfo : roomDevOpts2) {
                    if (iGProAVRoomCtrlOptInfo.getIsCurrentRoom() && c1(iGProAVRoomCtrlOptInfo.getDevOpt().getMicOpt(), isFromQuery)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                }
            }
            z18 = false;
        } else {
            if (rspInfo != null) {
                IGProAVDevOptInfo devOpt = rspInfo.getDevOpt();
                if (devOpt != null) {
                }
            }
            z18 = false;
        }
        e1(z18);
    }

    public final void i1() {
        if (com.tencent.mobileqq.guild.media.core.j.a().i0(com.tencent.mobileqq.guild.media.core.m.b(this.mediaChannelCore.v0()))) {
            return;
        }
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[reEnterTRTC] ");
        this.mediaChannelCore.Q().L0(new g());
    }

    private final void j0(List<MediaRoomStatus> mediaRoomParamList) {
        Object obj;
        String str;
        boolean z16;
        com.tencent.mobileqq.guild.media.core.l v06 = this.mediaChannelCore.v0();
        String h16 = v06.h();
        String b16 = com.tencent.mobileqq.guild.media.core.m.b(v06);
        Iterator<T> it = mediaRoomParamList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MediaRoomStatus) obj).getEnableTRTCPublish()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MediaRoomStatus mediaRoomStatus = (MediaRoomStatus) obj;
        if (mediaRoomStatus == null || (str = mediaRoomStatus.getRoomStrId()) == null) {
            str = b16;
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            b16 = str;
        }
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[checkIfNeedCloseMic] currentAnchorRoomId " + h16 + ", newAnchorRoomId " + ((Object) b16));
        if (!Intrinsics.areEqual(h16, b16)) {
            l0();
        }
    }

    private final void j1() {
        this.mediaChannelCore.getEventBus().V(com.tencent.mobileqq.guild.media.core.notify.g.class, this.enterTRTCMainRoomEvent);
        this.mediaChannelCore.getEventBus().V(SwitchThemeEvent.class, this.switchThemeObserver);
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).addObserver(this.observer);
    }

    public final void k1() {
        CorountineFunKt.e(this.mediaChannelCore.getCoroutineScope(), "sendQueryRequest", null, null, Boolean.TRUE, new MediaChannelMultiRoomHelper$sendQueryRequest$1(this, null), 6, null);
    }

    private final void l0() {
        com.tencent.mobileqq.guild.media.core.l v06 = this.mediaChannelCore.v0();
        String h16 = v06.h();
        boolean z16 = v06.getSelfUserInfo().f228101i;
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[closeMicrophone] room[" + h16 + "] isMicOn[" + z16 + "]");
        if (!z16) {
            return;
        }
        this.mediaChannelCore.y0().a();
        com.tencent.mobileqq.guild.media.core.j.a().J().i(false, new c());
    }

    private final void l1() {
        this.mediaChannelCore.getEventBus().j(com.tencent.mobileqq.guild.media.core.notify.g.class, this.enterTRTCMainRoomEvent);
        this.mediaChannelCore.getEventBus().j(SwitchThemeEvent.class, this.switchThemeObserver);
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).deleteObserver(this.observer);
    }

    private final void m1(List<MediaRoomStatus> severRoomList) {
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[updateTRTCRoomList] " + severRoomList);
        this.mediaChannelCore.o0().R().clear();
        this.mediaChannelCore.o0().R().addAll(severRoomList);
        if (b1()) {
            J0();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[onEnterChannel] ");
        j1();
    }

    public final void X0(@Nullable IGProUserAVRspInfo rspInfo, boolean isFromQuery) {
        ArrayList arrayList;
        ArrayList<IGProAVRoomCtrlOptInfo> roomDevOpts;
        int collectionSizeOrDefault;
        Logger.a d16 = Logger.f235387a.d();
        String guildID = this.mediaChannelCore.getGuildID();
        String E = this.mediaChannelCore.E();
        if (rspInfo != null && (roomDevOpts = rspInfo.getRoomDevOpts()) != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(roomDevOpts, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            for (IGProAVRoomCtrlOptInfo iGProAVRoomCtrlOptInfo : roomDevOpts) {
                arrayList.add("numRoomId[" + iGProAVRoomCtrlOptInfo.getNumRoomId() + "] roomId[" + iGProAVRoomCtrlOptInfo.getRoomId() + "], micOpt[" + iGProAVRoomCtrlOptInfo.getDevOpt().getMicOpt() + "], role[" + iGProAVRoomCtrlOptInfo.getIsCurrentRoom() + "]");
            }
        } else {
            arrayList = null;
        }
        d16.d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[handleMultiRoomResp] guildId[" + guildID + "] channelId[" + E + "], rspInfo: " + arrayList);
        List<MediaRoomStatus> F0 = F0(rspInfo);
        j0(F0);
        this.mediaChannelCore.y0().c(F0);
        f0(rspInfo);
        i0(rspInfo, isFromQuery);
        M0(F0);
        m1(F0);
    }

    public final boolean b1() {
        boolean m16 = this.mediaChannelCore.d0().m1();
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[isEnableMultiRoomMode] isEnable[" + m16 + "]");
        return m16;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void p() {
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[onEnterChannelForPreview] ");
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        Logger.f235387a.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[onExitChannel] ");
        l1();
        b bVar = this.waitForMainTRTCRoom;
        if (bVar != null) {
            bVar.a();
        }
    }

    private final void J0() {
    }
}
