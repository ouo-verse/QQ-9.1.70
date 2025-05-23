package com.tencent.mobileqq.guild.media.core.logic;

import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.avbiz.Constants;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.guild.heartbeatreport.impl.AvChannelReportHelper;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.media.core.CommonRsp;
import com.tencent.mobileqq.guild.media.core.EnterChannelState;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.widget.user.delegates.MediaInviteItemDelegate;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.security.GuildChannelSwitchManager;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProExitAVChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cv;
import com.tencent.mobileqq.qqguildsdk.data.genc.fa;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0001wB\u000f\u0012\u0006\u0010]\u001a\u00020Z\u00a2\u0006\u0004\bt\u0010uJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J9\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\"\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J$\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f` H\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0017H\u0002J\u001b\u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u0017H\u0002J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u0005H\u0002J\u0013\u0010-\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010\u0015J\u0010\u00101\u001a\u0002002\u0006\u0010/\u001a\u00020.H\u0002J\b\u00102\u001a\u00020\tH\u0002J\u0013\u00103\u001a\u00020$H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0015J\u001b\u00105\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106J#\u00109\u001a\u00020$2\u0006\u00107\u001a\u0002002\u0006\u00108\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010:J\u001a\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010?\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u001bH\u0002J\u001a\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020$2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010D\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0011H\u0002J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u001fH\u0002J\u001a\u0010I\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010J\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010L\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010N\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010MH\u0016J\u001c\u0010Q\u001a\u00020\u00052\b\u0010O\u001a\u0004\u0018\u00010\u001f2\b\u0010P\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010S\u001a\u00020\u0005H\u0016J\b\u0010T\u001a\u00020\u0005H\u0016J\b\u0010U\u001a\u00020\u0005H\u0016J\u0010\u0010W\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\tH\u0016J\b\u0010X\u001a\u00020\u0005H\u0016J\b\u0010Y\u001a\u00020\u0005H\u0016R\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u001b\u0010b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010iR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010s\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006x"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaEnterExitRequestHelper;", "Lcom/tencent/mobileqq/guild/media/core/logic/r;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "Lcom/tencent/mobileqq/guild/media/core/q;", "startParams", "", "b1", "Lcom/tencent/mobileqq/guild/media/core/b;", "callback", "", "k1", "l1", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "startTs", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/media/core/logic/k;", "Z0", "(Lkotlinx/coroutines/CoroutineScope;JLcom/tencent/mobileqq/guild/media/core/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ICustomDataEditor.NUMBER_PARAM_1, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "J0", "", "channelType", "c1", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProEnterAudioLiveChannelRsp;", "igProEnterAudioLiveChannelRsp", "S0", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "M0", "themeType", "g1", "Lcom/tencent/mobileqq/guild/media/core/a;", "m1", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/fa;", "O0", "authMeta", "streamType", "h1", "d1", "f1", "Lcom/tencent/mobileqq/guild/media/core/logic/j;", "params", "Lcom/tencent/mobileqq/guild/media/core/logic/l;", "I0", "W0", "X0", "questEnterChannelTs", "Y0", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "req", "startEnterChannelTs", ICustomDataEditor.STRING_ARRAY_PARAM_1, "(Lcom/tencent/mobileqq/guild/media/core/logic/l;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterChannelRsp", "R0", "code", "msg", "V0", "rsp", "j1", "enterTrtcRsp", "U0", "T0", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "H0", "tag", "Q0", "c", "L0", "Lcom/tencent/mobileqq/guild/media/core/c;", "G0", "Lcom/tencent/mobileqq/guild/media/core/h;", UserInfo.SEX_FEMALE, "showTips", "reasonForLog", "D", "d", "E0", "p", "u", "needReset", "g0", "y", "w", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "f", "Lkotlin/Lazy;", "P0", "()Lkotlinx/coroutines/CoroutineScope;", "exitScope", "Lcom/tencent/mobileqq/guild/media/core/logic/ca;", tl.h.F, "Lcom/tencent/mobileqq/guild/media/core/logic/ca;", "modelTrans", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "i", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "enterChannelJob", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "exitTrtcRoomJob", "Ljava/util/Timer;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Timer;", "exitTRTCRoomCountDownTimer", "Lcom/tencent/mobileqq/guild/heartbeatreport/impl/AvChannelReportHelper;", "Lcom/tencent/mobileqq/guild/heartbeatreport/impl/AvChannelReportHelper;", "mediaChannelStatusReportHelper", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaEnterExitRequestHelper extends h implements r {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Timer exitTRTCRoomCountDownTimer;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AvChannelReportHelper mediaChannelStatusReportHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy exitScope;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ca modelTrans;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b enterChannelJob;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b exitTrtcRoomJob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "code", "", "msg", "", "kotlin.jvm.PlatformType", "onCallback"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class b implements ITRTCAudioRoom.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<CommonRsp> f228278a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MediaEnterExitRequestHelper f228279b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super CommonRsp> cancellableContinuation, MediaEnterExitRequestHelper mediaEnterExitRequestHelper) {
            this.f228278a = cancellableContinuation;
            this.f228279b = mediaEnterExitRequestHelper;
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
        public final void onCallback(int i3, String msg2) {
            if (!this.f228278a.isActive()) {
                return;
            }
            a m06 = this.f228279b.core.m0();
            String guildID = this.f228279b.core.getGuildID();
            String E = this.f228279b.core.E();
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            a.b(m06, "audio_room_trtc_prepare_callback", guildID, E, 3, "", i3, msg2, null, 128, null);
            CancellableContinuation<CommonRsp> cancellableContinuation = this.f228278a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(new CommonRsp(i3, msg2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n\u00a2\u0006\u0004\b\t\u0010\n"}, d2 = {"", "code", "", "msg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "igProSecurityResult", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProEnterAudioLiveChannelRsp;", "igProEnterAudioLiveChannelRsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProEnterAudioLiveChannelRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements wh2.x {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<EnterChannelRsp> f228280a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MediaEnterExitRequestHelper f228281b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqguildsdk.data.genc.ai f228282c;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super EnterChannelRsp> cancellableContinuation, MediaEnterExitRequestHelper mediaEnterExitRequestHelper, com.tencent.mobileqq.qqguildsdk.data.genc.ai aiVar) {
            this.f228280a = cancellableContinuation;
            this.f228281b = mediaEnterExitRequestHelper;
            this.f228282c = aiVar;
        }

        @Override // wh2.x
        public final void a(int i3, @NotNull String msg2, @NotNull IGProSecurityResult igProSecurityResult, @NotNull IGProEnterAudioLiveChannelRsp igProEnterAudioLiveChannelRsp) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(igProSecurityResult, "igProSecurityResult");
            Intrinsics.checkNotNullParameter(igProEnterAudioLiveChannelRsp, "igProEnterAudioLiveChannelRsp");
            Logger logger = Logger.f235387a;
            CancellableContinuation<EnterChannelRsp> cancellableContinuation = this.f228280a;
            logger.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "questEnterChannel, code:" + i3 + ", msg:" + msg2 + ", isActive:" + cancellableContinuation.isActive());
            if (!this.f228280a.isActive()) {
                return;
            }
            a.b(this.f228281b.core.m0(), "audio_room_sdk_join_callback", this.f228281b.core.getGuildID(), this.f228281b.core.E(), 2, "", i3, msg2, null, 128, null);
            if (i3 == 46200) {
                GuildChannelSwitchManager.h(String.valueOf(this.f228282c.d()), null, "enterChannelFailed");
            }
            CancellableContinuation<EnterChannelRsp> cancellableContinuation2 = this.f228280a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(new EnterChannelRsp(i3, msg2, igProSecurityResult, igProEnterAudioLiveChannelRsp)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "code", "", "msg", "", "kotlin.jvm.PlatformType", "onCallback"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class d implements ITRTCAudioRoom.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<CommonRsp> f228283a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MediaEnterExitRequestHelper f228284b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f228285c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f228286d;

        /* JADX WARN: Multi-variable type inference failed */
        d(CancellableContinuation<? super CommonRsp> cancellableContinuation, MediaEnterExitRequestHelper mediaEnterExitRequestHelper, long j3, long j16) {
            this.f228283a = cancellableContinuation;
            this.f228284b = mediaEnterExitRequestHelper;
            this.f228285c = j3;
            this.f228286d = j16;
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
        public final void onCallback(int i3, String msg2) {
            Logger logger = Logger.f235387a;
            CancellableContinuation<CommonRsp> cancellableContinuation = this.f228283a;
            logger.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "enterTrtcRoom, code:" + i3 + ", msg:" + msg2 + ", isActive:" + cancellableContinuation.isActive());
            if (!this.f228283a.isActive()) {
                return;
            }
            HashMap<String, String> d16 = this.f228284b.core.m0().d(i3, this.f228285c, this.f228286d);
            a m06 = this.f228284b.core.m0();
            String guildID = this.f228284b.core.getGuildID();
            String E = this.f228284b.core.E();
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            m06.a("audio_room_trtc_enter_room_callback", guildID, E, 3, "", i3, msg2, d16);
            CancellableContinuation<CommonRsp> cancellableContinuation2 = this.f228283a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(new CommonRsp(i3, msg2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "code", "", "msg", "", "kotlin.jvm.PlatformType", "onCallback"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class e implements ITRTCAudioRoom.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f228287a;

        /* JADX WARN: Multi-variable type inference failed */
        e(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f228287a = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
        public final void onCallback(int i3, String str) {
            boolean z16 = true;
            QLog.i("QGMC.Core.MediaEnterExitRequestHelper", 1, "requestExitTrtcRoom code " + i3 + " msg " + str + ", " + this.f228287a.isActive());
            if (this.f228287a.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation = this.f228287a;
                Result.Companion companion = Result.INSTANCE;
                if (i3 != 0) {
                    z16 = false;
                }
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class f implements em {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f228289b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Continuation<CommonRsp> f228290c;

        /* JADX WARN: Multi-variable type inference failed */
        f(int i3, Continuation<? super CommonRsp> continuation) {
            this.f228289b = i3;
            this.f228290c = continuation;
        }

        @Override // wh2.em
        public final void onResult(int i3, String errMsg) {
            Logger logger = Logger.f235387a;
            int i16 = this.f228289b;
            logger.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "switchChannelTheme:" + i16 + ", result:" + i3 + ", errMsg:" + errMsg);
            com.tencent.mobileqq.guild.performance.report.aa aaVar = com.tencent.mobileqq.guild.performance.report.aa.f230980i;
            Integer value = MediaEnterExitRequestHelper.this.core.o0().M().getValue();
            Intrinsics.checkNotNull(value);
            int intValue = value.intValue();
            int i17 = this.f228289b;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            aaVar.y(intValue, i17, i3, errMsg);
            Continuation<CommonRsp> continuation = this.f228290c;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(new CommonRsp(i3, errMsg)));
            if (i3 != 0) {
                QQToast.makeText(BaseApplication.getContext(), errMsg, 0).show();
                com.tencent.mobileqq.guild.media.core.j.a().W().e(false);
            }
        }
    }

    public MediaEnterExitRequestHelper(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$exitScope$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineScope invoke() {
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
                if (f16 != null) {
                    return f16;
                }
                throw new IllegalStateException("get TaskPoolType.MAIN scope error!");
            }
        });
        this.exitScope = lazy;
        this.modelTrans = new ca(core.o0());
        this.mediaChannelStatusReportHelper = new AvChannelReportHelper(String.valueOf(core.o0().getStartParams().getChannelType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H0(EnterChannelRsp second) {
        return second.getIgProEnterAudioLiveChannelRsp().getEnableStream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EnterTrtcRoomReq I0(j params) {
        return new EnterTrtcRoomReq(1, params.getSdkAppId(), params.getPrivateMapKey(), this.core.E(), params.getUserId(), params.getUserSign(), 21, W0(), false, false, 768, null);
    }

    private final boolean J0(com.tencent.mobileqq.guild.media.core.q startParams, com.tencent.mobileqq.guild.media.core.b callback) {
        if (com.tencent.mobileqq.guild.media.core.m.f(this.core.v0())) {
            String r16 = QQGuildUIUtil.r(R.string.f1492911w);
            if (callback != null) {
                callback.a(false, SecurityTipHelperKt.g(r16, null, 0L, 6, null));
            }
            return false;
        }
        if (com.tencent.mobileqq.guild.media.core.m.h(this.core.v0())) {
            if (Intrinsics.areEqual(startParams, this.core.o0().getStartParams())) {
                this.core.o0().getStartParams().a(startParams);
                this.core.o0().getStartParams().k(startParams.getFromPreView());
                this.core.o0().getStartParams().m(startParams.getSourceType());
                Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "enterChannel: enter channel is current channel.");
                if (Intrinsics.areEqual(startParams.getSourceType(), "functional_qq_little_world_feed")) {
                    QLog.d("QGMC.Core.MediaEnterExitRequestHelper", 1, "enter from qcircle reEnterChannel");
                    this.core.o0().M0(startParams);
                    F(null);
                }
                if (com.tencent.mobileqq.guild.media.core.j.a().K(startParams.getChannelId())) {
                    GuildFloatWindowUtils.o();
                }
                String r17 = QQGuildUIUtil.r(R.string.f1492811v);
                if (callback != null) {
                    callback.a(true, SecurityTipHelperKt.g(r17, null, 0L, 6, null));
                }
                return false;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("enterChannel: switch channel.");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaEnterExitRequestHelper", 1, (String) it.next(), null);
            }
            D("", "enterChannel: switch channel.");
        }
        return true;
    }

    private final HashMap<String, String> M0() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sgrp_stream_pgin_source_name", Q0("sgrp_stream_pgin_source_name"));
        hashMap.put("sgrp_stream_pgin_into_source", Q0("sgrp_stream_pgin_into_source"));
        return hashMap;
    }

    private final fa O0(int themeType) {
        fa faVar = new fa();
        faVar.e(this.core.o0().getAuthMeta());
        faVar.h(Long.parseLong(this.core.getGuildID()));
        faVar.g(Long.parseLong(this.core.E()));
        faVar.f(themeType);
        return faVar;
    }

    private final CoroutineScope P0() {
        return (CoroutineScope) this.exitScope.getValue();
    }

    private final void Q() {
        com.tencent.mobileqq.guild.util.h.b(Constants.Business.QQ_GUILD);
    }

    private final String Q0(String tag) {
        JumpGuildParam jumpGuildParam;
        String str;
        GuildAppReportSourceInfo guildAppReportSourceInfo;
        Map<String, String> reportInfoMap;
        String str2;
        GuildAppReportSourceInfo reportSourceInfo;
        Map<String, String> reportInfoMap2;
        Bundle loadBeanBundle = com.tencent.mobileqq.guild.media.core.j.a().getLoadBeanBundle();
        GuildAppReportSourceInfo guildAppReportSourceInfo2 = null;
        if (loadBeanBundle != null) {
            jumpGuildParam = (JumpGuildParam) loadBeanBundle.getParcelable(JumpGuildParam.KEY_JUMP_GUILD_PARAM);
        } else {
            jumpGuildParam = null;
        }
        if (!(jumpGuildParam instanceof JumpGuildParam)) {
            jumpGuildParam = null;
        }
        if (jumpGuildParam != null && (reportSourceInfo = jumpGuildParam.getReportSourceInfo()) != null && (reportInfoMap2 = reportSourceInfo.getReportInfoMap()) != null) {
            str = reportInfoMap2.get(tag);
        } else {
            str = null;
        }
        if (str != null) {
            String str3 = jumpGuildParam.getReportSourceInfo().getReportInfoMap().get(tag);
            Intrinsics.checkNotNull(str3);
            return str3;
        }
        if (loadBeanBundle != null) {
            guildAppReportSourceInfo = (GuildAppReportSourceInfo) loadBeanBundle.getParcelable("GuildAppReportSourceInfo");
        } else {
            guildAppReportSourceInfo = null;
        }
        if (guildAppReportSourceInfo instanceof GuildAppReportSourceInfo) {
            guildAppReportSourceInfo2 = guildAppReportSourceInfo;
        }
        if (guildAppReportSourceInfo2 == null || (reportInfoMap = guildAppReportSourceInfo2.getReportInfoMap()) == null || (str2 = reportInfoMap.get(tag)) == null) {
            return "";
        }
        return str2;
    }

    private final void R0(EnterChannelRsp enterChannelRsp, com.tencent.mobileqq.guild.media.core.b callback) {
        boolean z16;
        String str;
        int code = enterChannelRsp.getCode();
        IGProSecurityResult igProSecurityResult = enterChannelRsp.getIgProSecurityResult();
        String msg2 = enterChannelRsp.getMsg();
        String strPrompt = igProSecurityResult.getStrPrompt();
        Intrinsics.checkNotNullExpressionValue(strPrompt, "secResult.strPrompt");
        if (strPrompt.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = igProSecurityResult.getStrPrompt();
            Intrinsics.checkNotNullExpressionValue(str, "secResult.strPrompt");
            msg2 = str + ContainerUtils.FIELD_DELIMITER + msg2;
        } else {
            if (StringUtil.isEmpty(msg2)) {
                String a16 = com.tencent.mobileqq.guild.media.core.data.b.a(2, code, msg2, this.core.getGuildID());
                Intrinsics.checkNotNullExpressionValue(a16, "{\n                AudioR\u2026          )\n            }");
                str = a16;
            } else {
                str = msg2;
            }
            igProSecurityResult = SecurityTipHelperKt.e(str);
        }
        QLog.e("QGMC.Core.MediaEnterExitRequestHelper", 1, "onEnterAudioChannel failed result:" + code + ", errMsg:" + str);
        Q();
        com.tencent.mobileqq.guild.performance.report.e.h("biz_enter_err", code, msg2);
        this.core.m0().c();
        if (callback != null) {
            callback.a(false, igProSecurityResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(IGProEnterAudioLiveChannelRsp igProEnterAudioLiveChannelRsp, com.tencent.mobileqq.guild.media.core.b callback, long startTs) {
        GuildAppReportSourceInfo.ExtraInfo extraInfo;
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.o(igProEnterAudioLiveChannelRsp.getAvChannelConfig().getThemeInfo().getThemeType());
        j1(igProEnterAudioLiveChannelRsp);
        AudioNotifyHelper l06 = this.core.l0();
        String guildID = this.core.getGuildID();
        String E = this.core.E();
        String str = this.core.getSelfUserInfo().f228093a;
        Intrinsics.checkNotNullExpressionValue(str, "core.getSelfUserInfo().id");
        l06.h(guildID, E, str, true);
        com.tencent.mobileqq.guild.media.core.f fVar = this.core;
        fVar.C0(fVar.getGuildID(), this.core.E());
        this.core.n0();
        g1(igProEnterAudioLiveChannelRsp.getAvChannelConfig().getThemeInfo().getThemeType());
        this.modelTrans.b(igProEnterAudioLiveChannelRsp);
        this.core.y0().F(this.core.z0());
        f12.f.f397616a.f(CodecParam.PARAM_AUDIO_CHANNEL, true);
        this.core.l0().m("onEnterRoom", this.core.getSelfUserInfo());
        this.core.t0().g();
        this.core.x0().e0();
        com.tencent.mobileqq.guild.media.core.data.b.d();
        com.tencent.mobileqq.guild.media.core.data.b.f(String.valueOf(this.core.o0().getStartParams().getChannelType()));
        com.tencent.mobileqq.guild.media.core.f fVar2 = this.core;
        int sdkAppId = igProEnterAudioLiveChannelRsp.getSdkAppId();
        String privateMapKey = igProEnterAudioLiveChannelRsp.getPrivateMapKey();
        Intrinsics.checkNotNullExpressionValue(privateMapKey, "igProEnterAudioLiveChannelRsp.privateMapKey");
        String valueOf = String.valueOf(igProEnterAudioLiveChannelRsp.getUserTinyId());
        String trtcUserSign = igProEnterAudioLiveChannelRsp.getTrtcUserSign();
        Intrinsics.checkNotNullExpressionValue(trtcUserSign, "igProEnterAudioLiveChannelRsp.trtcUserSign");
        fVar2.s0(new j(sdkAppId, privateMapKey, valueOf, trtcUserSign, igProEnterAudioLiveChannelRsp.getNoStreamDisconnectTrtcSecond(), igProEnterAudioLiveChannelRsp.getSigExpiresSecond() + NetConnInfoCenter.getServerTime(), igProEnterAudioLiveChannelRsp.getAvChannelConfig().getChannelDataVersion()));
        if (callback != null) {
            callback.a(true, SecurityTipHelperKt.g(null, null, 0L, 7, null));
        }
        if (this.core.o0().getStartParams().getFromPreView() == 100) {
            this.core.p();
        } else {
            this.core.K0().a(true, this.core.getGuildInfo(), this.core.getChannelInfo());
            this.core.E0();
        }
        this.modelTrans.e();
        com.tencent.mobileqq.guild.performance.report.e.e(System.currentTimeMillis() - startTs);
        GLiveChannelCore.f226698a.t().d0(false);
        Bundle c06 = this.core.c0();
        GuildAppReportSourceInfo guildAppReportSourceInfo = c06 != null ? (GuildAppReportSourceInfo) c06.getParcelable("GuildAppReportSourceInfo") : null;
        AvChannelReportHelper avChannelReportHelper = this.mediaChannelStatusReportHelper;
        String guildID2 = this.core.getGuildID();
        String E2 = this.core.E();
        Integer valueOf2 = (guildAppReportSourceInfo == null || (extraInfo = guildAppReportSourceInfo.extraInfo) == null) ? null : Integer.valueOf(extraInfo.channelOpenSourceForOnlineReport);
        String pageInSourceName = guildAppReportSourceInfo != null ? guildAppReportSourceInfo.getPageInSourceName() : null;
        if (pageInSourceName == null) {
            pageInSourceName = "";
        }
        avChannelReportHelper.i(guildID2, E2, valueOf2, pageInSourceName, guildAppReportSourceInfo != null ? guildAppReportSourceInfo.getStartFromGuildTab() : false, M0());
    }

    private final void T0(int code, String msg2, com.tencent.mobileqq.guild.media.core.b callback) {
        this.modelTrans.d();
        QLog.e("QGMC.Core.MediaEnterExitRequestHelper", 1, "trtc enterRoom failed result:" + code + ", errMsg:" + msg2);
        com.tencent.mobileqq.guild.performance.report.e.h("trtc_enter_err", code, msg2);
        com.tencent.mobileqq.guild.media.core.data.b.c("trtc_enter_err", code, String.valueOf(this.core.o0().getStartParams().getChannelType()));
        if (callback != null) {
            String a16 = com.tencent.mobileqq.guild.media.core.data.b.a(3, code, msg2, this.core.getGuildID());
            Intrinsics.checkNotNullExpressionValue(a16, "getErrorTypeMsg(\n       \u2026ildID()\n                )");
            callback.a(false, SecurityTipHelperKt.e(a16));
        }
        D(null, "trtc enterRoom failed result:" + code + ", errMsg:" + msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(CommonRsp enterTrtcRsp, com.tencent.mobileqq.guild.media.core.b callback) {
        if (enterTrtcRsp.c()) {
            this.modelTrans.f();
            h1(this.core.o0().getAuthMeta(), 2);
            QLog.d("QGMC.Core.MediaEnterExitRequestHelper", 1, "handleEnterTrtcResult stopExitTRTCRoomCountDownTimer");
            y();
            if (callback != null) {
                callback.a(true, SecurityTipHelperKt.g(enterTrtcRsp.getMsg(), null, 0L, 6, null));
            }
            this.core.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.g());
            return;
        }
        T0(enterTrtcRsp.getCode(), enterTrtcRsp.getMsg(), callback);
    }

    private final void V0(int code, String msg2, com.tencent.mobileqq.guild.media.core.b callback) {
        QLog.e("QGMC.Core.MediaEnterExitRequestHelper", 1, "trtc prepare failed with code:" + code + ", msg:" + msg2);
        Q();
        if (callback != null) {
            String a16 = com.tencent.mobileqq.guild.media.core.data.b.a(3, code, msg2, this.core.getGuildID());
            Intrinsics.checkNotNullExpressionValue(a16, "getErrorTypeMsg(\n       \u2026ildID()\n                )");
            callback.a(false, SecurityTipHelperKt.e(a16));
        }
        com.tencent.mobileqq.guild.performance.report.e.h("trtc_prepare_err", code, msg2);
        this.core.m0().c();
    }

    private final boolean W0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object X0(Continuation<? super CommonRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.t();
        a.b(this.core.m0(), "audio_room_trtc_prepare_start", this.core.getGuildID(), this.core.E(), 0, null, 0, null, null, 248, null);
        this.core.y0().r(this.core.getAppContext(), "", new b(cancellableContinuationImpl, this));
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$prepareTrtcModule$2$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "prepareTrtcModule job cancel.");
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Y0(long j3, Continuation<? super EnterChannelRsp> continuation) {
        Continuation intercepted;
        boolean z16;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        Logger logger = Logger.f235387a;
        logger.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "questEnterChannel, start.");
        a.b(this.core.m0(), "audio_room_sdk_join_start", this.core.getGuildID(), this.core.E(), 0, null, 0, null, null, 248, null);
        com.tencent.mobileqq.qqguildsdk.data.genc.ai aiVar = new com.tencent.mobileqq.qqguildsdk.data.genc.ai();
        aiVar.j(Long.parseLong(this.core.getGuildID()));
        aiVar.g(Long.parseLong(this.core.E()));
        aiVar.k(this.core.o0().getStartParams().getSourceType());
        aiVar.i(true);
        aiVar.l(this.core.o0().getStartParams().getFromPreView());
        aiVar.h(2);
        Logger.a d16 = logger.d();
        if (aiVar.f() == 100) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("QGMC.Core.MediaEnterExitRequestHelper", 1, "fromPreView " + z16);
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).enterAudioLiveChannelAndCallbackDirect(aiVar, new c(cancellableContinuationImpl, this, aiVar));
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$questEnterChannel$2$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "questEnterChannel job cancel.");
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Z0(CoroutineScope coroutineScope, long j3, com.tencent.mobileqq.guild.media.core.b bVar, Continuation<? super Pair<Boolean, EnterChannelRsp>> continuation) {
        MediaEnterExitRequestHelper$questEnterChannelLogic$1 mediaEnterExitRequestHelper$questEnterChannelLogic$1;
        Object coroutine_suspended;
        int i3;
        MediaEnterExitRequestHelper mediaEnterExitRequestHelper;
        com.tencent.mobileqq.guild.media.core.b bVar2;
        Deferred o16;
        com.tencent.mobileqq.guild.media.core.b bVar3;
        MediaEnterExitRequestHelper mediaEnterExitRequestHelper2;
        com.tencent.mobileqq.qcoroutine.api.coroutine.a aVar;
        EnterChannelRsp enterChannelRsp;
        Deferred o17;
        EnterChannelRsp enterChannelRsp2;
        CommonRsp commonRsp;
        if (continuation instanceof MediaEnterExitRequestHelper$questEnterChannelLogic$1) {
            mediaEnterExitRequestHelper$questEnterChannelLogic$1 = (MediaEnterExitRequestHelper$questEnterChannelLogic$1) continuation;
            int i16 = mediaEnterExitRequestHelper$questEnterChannelLogic$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                mediaEnterExitRequestHelper$questEnterChannelLogic$1.label = i16 - Integer.MIN_VALUE;
                Object obj = mediaEnterExitRequestHelper$questEnterChannelLogic$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = mediaEnterExitRequestHelper$questEnterChannelLogic$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                bVar2 = (com.tencent.mobileqq.guild.media.core.b) mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$1;
                                mediaEnterExitRequestHelper = (MediaEnterExitRequestHelper) mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                MediaEnterExitRequestHelper mediaEnterExitRequestHelper3 = mediaEnterExitRequestHelper;
                                bVar3 = bVar2;
                                enterChannelRsp2 = (EnterChannelRsp) obj;
                                mediaEnterExitRequestHelper2 = mediaEnterExitRequestHelper3;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            enterChannelRsp2 = (EnterChannelRsp) mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$2;
                            bVar3 = (com.tencent.mobileqq.guild.media.core.b) mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$1;
                            mediaEnterExitRequestHelper2 = (MediaEnterExitRequestHelper) mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            commonRsp = (CommonRsp) obj;
                            if (commonRsp != null) {
                                if (!commonRsp.c()) {
                                    mediaEnterExitRequestHelper2.modelTrans.d();
                                    mediaEnterExitRequestHelper2.V0(commonRsp.getCode(), commonRsp.getMsg(), bVar3);
                                    return new Pair(Boxing.boxBoolean(false), enterChannelRsp2);
                                }
                            }
                            throw new IllegalStateException("prepareTrtcAsync error!");
                        }
                    } else {
                        aVar = (com.tencent.mobileqq.qcoroutine.api.coroutine.a) mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$2;
                        bVar3 = (com.tencent.mobileqq.guild.media.core.b) mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$1;
                        mediaEnterExitRequestHelper2 = (MediaEnterExitRequestHelper) mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        enterChannelRsp = (EnterChannelRsp) obj;
                        if (enterChannelRsp != null) {
                            if (!enterChannelRsp.e()) {
                                mediaEnterExitRequestHelper2.modelTrans.d();
                                mediaEnterExitRequestHelper2.R0(enterChannelRsp, bVar3);
                                return new Pair(Boxing.boxBoolean(false), enterChannelRsp);
                            }
                            if (aVar != null && (o17 = aVar.o()) != null) {
                                mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$0 = mediaEnterExitRequestHelper2;
                                mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$1 = bVar3;
                                mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$2 = enterChannelRsp;
                                mediaEnterExitRequestHelper$questEnterChannelLogic$1.label = 2;
                                Object await = o17.await(mediaEnterExitRequestHelper$questEnterChannelLogic$1);
                                if (await == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = await;
                                enterChannelRsp2 = enterChannelRsp;
                                commonRsp = (CommonRsp) obj;
                                if (commonRsp != null) {
                                }
                            }
                            throw new IllegalStateException("prepareTrtcAsync error!");
                        }
                        throw new IllegalStateException("enterChannelAsync error!");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (!this.core.y0().getIsInited()) {
                        com.tencent.mobileqq.qcoroutine.api.coroutine.a c16 = CorountineFunKt.c(coroutineScope, "prepareTrtcModule", null, null, new MediaEnterExitRequestHelper$questEnterChannelLogic$prepareTrtcAsync$1(this, null), 6, null);
                        com.tencent.mobileqq.qcoroutine.api.coroutine.a c17 = CorountineFunKt.c(coroutineScope, "questEnterChannel", null, null, new MediaEnterExitRequestHelper$questEnterChannelLogic$enterChannelAsync$1(this, j3, null), 6, null);
                        if (c17 != null && (o16 = c17.o()) != null) {
                            mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$0 = this;
                            mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$1 = bVar;
                            mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$2 = c16;
                            mediaEnterExitRequestHelper$questEnterChannelLogic$1.label = 1;
                            Object await2 = o16.await(mediaEnterExitRequestHelper$questEnterChannelLogic$1);
                            if (await2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            bVar3 = bVar;
                            mediaEnterExitRequestHelper2 = this;
                            obj = await2;
                            aVar = c16;
                            enterChannelRsp = (EnterChannelRsp) obj;
                            if (enterChannelRsp != null) {
                            }
                        }
                        throw new IllegalStateException("enterChannelAsync error!");
                    }
                    this.core.y0().y(this.core.getAppContext());
                    mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$0 = this;
                    mediaEnterExitRequestHelper$questEnterChannelLogic$1.L$1 = bVar;
                    mediaEnterExitRequestHelper$questEnterChannelLogic$1.label = 3;
                    obj = Y0(j3, mediaEnterExitRequestHelper$questEnterChannelLogic$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mediaEnterExitRequestHelper = this;
                    bVar2 = bVar;
                    MediaEnterExitRequestHelper mediaEnterExitRequestHelper32 = mediaEnterExitRequestHelper;
                    bVar3 = bVar2;
                    enterChannelRsp2 = (EnterChannelRsp) obj;
                    mediaEnterExitRequestHelper2 = mediaEnterExitRequestHelper32;
                }
                if (enterChannelRsp2.e()) {
                    mediaEnterExitRequestHelper2.modelTrans.d();
                    mediaEnterExitRequestHelper2.R0(enterChannelRsp2, bVar3);
                    return new Pair(Boxing.boxBoolean(false), enterChannelRsp2);
                }
                return new Pair(Boxing.boxBoolean(true), enterChannelRsp2);
            }
        }
        mediaEnterExitRequestHelper$questEnterChannelLogic$1 = new MediaEnterExitRequestHelper$questEnterChannelLogic$1(this, continuation);
        Object obj2 = mediaEnterExitRequestHelper$questEnterChannelLogic$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = mediaEnterExitRequestHelper$questEnterChannelLogic$1.label;
        if (i3 == 0) {
        }
        if (enterChannelRsp2.e()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a1(EnterTrtcRoomReq enterTrtcRoomReq, long j3, Continuation<? super CommonRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        long currentTimeMillis = System.currentTimeMillis();
        a.b(this.core.m0(), "audio_room_trtc_enter_room_start", this.core.getGuildID(), this.core.E(), 0, null, 0, null, null, 248, null);
        this.core.y0().k(enterTrtcRoomReq, new d(cancellableContinuationImpl, this, j3, currentTimeMillis));
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$questEnterTrtcRoom$2$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "questEnterTrtcRoom job cancel.");
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(com.tencent.mobileqq.guild.media.core.q startParams) {
        com.tencent.mobileqq.guild.performance.report.e.d(startParams.getChannelType());
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.H(startParams.getGuildId(), startParams.getChannelId(), startParams.getChannelType());
        this.core.m0().f(startParams.getGuildId(), startParams.getChannelId(), startParams.getChannelType());
    }

    private final boolean c1(int channelType) {
        return com.tencent.mobileqq.guild.util.h.m(this.core.getQQAppInterface(), Constants.Business.QQ_GUILD, this.core.x0());
    }

    private final void d1() {
        boolean z16;
        boolean z17;
        ArrayList<String> arrayListOf;
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "requestExitChannel start");
        if (this.core.getGuildID().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.core.E().length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                long parseLong = Long.parseLong(this.core.getGuildID());
                long parseLong2 = Long.parseLong(this.core.E());
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.core.E());
                IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
                ((IGPSService) runtimeService).exitAudioLiveChannel(parseLong, parseLong2, 2, arrayListOf, new wh2.y() { // from class: com.tencent.mobileqq.guild.media.core.logic.cc
                    @Override // wh2.y
                    public final void a(int i3, String str, IGProExitAVChannelRsp iGProExitAVChannelRsp) {
                        MediaEnterExitRequestHelper.e1(i3, str, iGProExitAVChannelRsp);
                    }
                });
                return;
            }
        }
        Logger.b bVar = new Logger.b();
        bVar.a().add("id is empty, please check!!!");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.Core.MediaEnterExitRequestHelper", 1, (String) it.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(int i3, String str, IGProExitAVChannelRsp iGProExitAVChannelRsp) {
        QLog.i("QGMC.Core.MediaEnterExitRequestHelper", 1, "requestExitChannel: guildId[" + iGProExitAVChannelRsp.getGuildId() + "] channelId[" + iGProExitAVChannelRsp.getChannelId() + "]errMsg:" + str + ",result:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f1(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        this.core.y0().I(new e(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(int themeType) {
        Integer value = this.core.o0().M().getValue();
        if (value == null || value.intValue() != themeType) {
            com.tencent.mobileqq.guild.media.core.notify.p eventBus = this.core.getEventBus();
            Integer value2 = this.core.o0().M().getValue();
            Intrinsics.checkNotNull(value2);
            eventBus.i(new SwitchThemeEvent(value2.intValue(), themeType));
        }
    }

    private final void h1(String authMeta, final int streamType) {
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        final IGPSService iGPSService = (IGPSService) runtimeService;
        iGPSService.getChannelHeartbeat(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E(), new vh2.aw() { // from class: com.tencent.mobileqq.guild.media.core.logic.cb
            @Override // vh2.aw
            public final void a(int i3, cv cvVar) {
                MediaEnterExitRequestHelper.i1(MediaEnterExitRequestHelper.this, streamType, iGPSService, i3, cvVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(MediaEnterExitRequestHelper this$0, int i3, IGPSService gpsService, int i16, cv cvVar) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gpsService, "$gpsService");
        if (i16 != 0) {
            return;
        }
        cvVar.l(Long.parseLong(this$0.core.getGuildID()));
        cvVar.k(Long.parseLong(this$0.core.E()));
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this$0.core.E());
        cvVar.n(arrayListOf);
        cvVar.o(i3);
        gpsService.setChannelHeartbeat(cvVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(IGProEnterAudioLiveChannelRsp rsp) {
        int i3;
        int i16;
        boolean z16;
        com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = this.core.getSelfUserInfo();
        selfUserInfo.R = true;
        selfUserInfo.P = this.core.getGuildID();
        selfUserInfo.Q = this.core.E();
        selfUserInfo.f228093a = com.tencent.mobileqq.guild.util.ch.f();
        selfUserInfo.f228116x = 1;
        IGProChannelInfo channelInfo = this.core.getChannelInfo();
        boolean z17 = false;
        if (channelInfo != null) {
            i3 = channelInfo.getChannelMemberMax();
        } else {
            i3 = 0;
        }
        selfUserInfo.T = i3;
        IGProGuildInfo guildInfo = this.core.getGuildInfo();
        if (guildInfo != null) {
            i16 = guildInfo.getUserType();
        } else {
            i16 = 0;
        }
        selfUserInfo.f228097e = i16;
        selfUserInfo.f228101i = false;
        selfUserInfo.f228103k = false;
        if (rsp.getGlobalMutedFlag() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        selfUserInfo.f228114v = z16;
        if (rsp.getGlobalMutedFlag() == 2) {
            z17 = true;
        }
        selfUserInfo.f228113u = z17;
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "setSelfUserInfoAfterEnterChannel, " + selfUserInfo);
    }

    private final boolean k1(com.tencent.mobileqq.guild.media.core.q startParams, com.tencent.mobileqq.guild.media.core.b callback) {
        if (!l1(startParams)) {
            if (callback != null) {
                callback.a(false, SecurityTipHelperKt.g("\u97f3\u89c6\u9891\u53c2\u6570\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5\u8fdb\u5165", null, 0L, 6, null));
            }
            return false;
        }
        if (!J0(startParams, callback)) {
            return false;
        }
        if (!c1(startParams.getChannelType())) {
            com.tencent.mobileqq.guild.performance.report.e.g("audio_focus_err", -1);
            String r16 = QQGuildUIUtil.r(R.string.f1493011x);
            if (callback != null) {
                callback.a(false, SecurityTipHelperKt.g(r16, null, 0L, 6, null));
            }
            return false;
        }
        return true;
    }

    private final boolean l1(com.tencent.mobileqq.guild.media.core.q startParams) {
        boolean z16;
        Exception e16;
        try {
            try {
                QLog.i("QGMC.Core.MediaEnterExitRequestHelper", 1, "startParamsIsValid finish, " + Long.parseLong(startParams.getGuildId()) + ", " + Long.parseLong(startParams.getChannelId()));
                return true;
            } catch (Exception e17) {
                e16 = e17;
                z16 = true;
                QLog.e("QGMC.Core.MediaEnterExitRequestHelper", 1, "startParamsIsValid exception:" + e16.getMessage() + ", " + startParams.getGuildId() + ", " + startParams.getChannelId());
                return z16;
            }
        } catch (Exception e18) {
            z16 = false;
            e16 = e18;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m1(int i3, Continuation<? super CommonRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "switchChannelTheme:" + i3 + ", start");
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).updateAudioLiveChannelTheme(O0(i3), new f(i3, safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n1(Continuation<? super Unit> continuation) {
        MediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1 mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1;
        Object coroutine_suspended;
        int i3;
        Job f16;
        Job f17;
        if (continuation instanceof MediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1) {
            mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1 = (MediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1) continuation;
            int i16 = mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1.label = i16 - Integer.MIN_VALUE;
                Object obj = mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.exitTrtcRoomJob;
                    boolean z16 = false;
                    if (bVar != null && (f17 = bVar.f()) != null && f17.isActive()) {
                        z16 = true;
                    }
                    if (z16) {
                        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = this.exitTrtcRoomJob;
                        if (bVar2 != null && (f16 = bVar2.f()) != null) {
                            mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1.label = 1;
                            if (f16.join(mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "wait last exitTrtcRoomJob. finish");
                    }
                    return Unit.INSTANCE;
                }
                Unit unit = Unit.INSTANCE;
                Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "wait last exitTrtcRoomJob. finish");
                return Unit.INSTANCE;
            }
        }
        mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1 = new MediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1(this, continuation);
        Object obj2 = mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = mediaEnterExitRequestHelper$waitExitTrtcRoomJobIfNeed$1.label;
        if (i3 == 0) {
        }
        Unit unit2 = Unit.INSTANCE;
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "wait last exitTrtcRoomJob. finish");
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.r
    public void D(@Nullable String showTips, @Nullable String reasonForLog) {
        String str;
        Job f16;
        EnterChannelState value = this.core.o0().k().getValue();
        if (value == EnterChannelState.IDLE) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "exitChannel, but enterChannelState == IDLE, ignore, reason:" + reasonForLog;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaEnterExitRequestHelper", 1, (String) it.next(), null);
            }
            return;
        }
        if (value == null) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("exitChannel, but enterChannelState is null!");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaEnterExitRequestHelper", 1, (String) it5.next(), null);
            }
        }
        this.mediaChannelStatusReportHelper.g();
        AudioNotifyHelper l06 = this.core.l0();
        String guildID = this.core.getGuildID();
        String E = this.core.E();
        String str3 = this.core.getSelfUserInfo().f228093a;
        Intrinsics.checkNotNullExpressionValue(str3, "core.getSelfUserInfo().id");
        l06.h(guildID, E, str3, false);
        Logger.a d16 = Logger.f235387a.d();
        String stackTraceString = QLog.getStackTraceString(new Throwable("exitChannel start, showTips:" + showTips + ", reason:" + reasonForLog));
        Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(Thro\u2026, reason:$reasonForLog\"))");
        d16.i("QGMC.Core.MediaEnterExitRequestHelper", 1, stackTraceString);
        GLiveChannelCore.f226698a.t().d0(true);
        this.core.q0();
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar3 = this.enterChannelJob;
        if (bVar3 != null && (f16 = bVar3.f()) != null) {
            Job.DefaultImpls.cancel$default(f16, (CancellationException) null, 1, (Object) null);
        }
        this.core.y0().F(null);
        a.b(this.core.m0(), "exit_audio_room", this.core.getGuildID(), this.core.E(), 2, showTips + APLogFileUtil.SEPARATOR_LOG + reasonForLog, 0, "", null, 128, null);
        this.core.W().f();
        com.tencent.mobileqq.guild.media.core.data.b.g();
        this.core.K0().a(false, null, null);
        Q();
        this.core.x0().d0();
        this.core.t0().h();
        this.core.J().setAudioRoute(1);
        this.core.getSelfUserInfo().R = false;
        if (this.core.H0().C()) {
            this.core.W().d(false);
        }
        if (this.core.L() != -1) {
            this.core.p0().T();
        }
        this.core.D0().f228125a.clear();
        this.core.getSelfUserInfo().p();
        this.core.m0().c();
        f12.f.f397616a.f(CodecParam.PARAM_AUDIO_CHANNEL, false);
        this.core.X().O();
        this.core.x0().U();
        AudioNotifyHelper l07 = this.core.l0();
        String guildID2 = this.core.getGuildID();
        String E2 = this.core.E();
        if (showTips == null) {
            str = "";
        } else {
            str = showTips;
        }
        l07.g(guildID2, E2, str);
        this.core.m0().e();
        G0(null);
        d1();
        this.core.u();
        this.modelTrans.g();
        y();
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.G(showTips, reasonForLog);
        MediaInviteItemDelegate.INSTANCE.c();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.r
    public void F(@Nullable com.tencent.mobileqq.guild.media.core.h callback) {
        CorountineFunKt.e(this.core.getCoroutineScope(), "reEnterChannel", null, null, Boolean.TRUE, new MediaEnterExitRequestHelper$reEnterChannel$1(this, callback, null), 6, null);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.r
    public void G0(@Nullable com.tencent.mobileqq.guild.media.core.c callback) {
        if (this.core.o0().l().getValue() == EnterChannelState.IDLE) {
            QLog.d("QGMC.Core.MediaEnterExitRequestHelper", 1, "exitTRTCRoom is IDLE return!");
            return;
        }
        this.modelTrans.h();
        this.exitTrtcRoomJob = CorountineFunKt.e(P0(), "requestExitTrtcRoom", null, null, Boolean.TRUE, new MediaEnterExitRequestHelper$exitTRTCRoom$1(this, callback, null), 6, null);
        h1(this.core.v0().b(), 1);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.r
    public void L0(@Nullable com.tencent.mobileqq.guild.media.core.b callback) {
        if (this.core.o0().l().getValue() == EnterChannelState.ENTER_ING) {
            QLog.d("QGMC.Core.MediaEnterExitRequestHelper", 1, "enterTRTCRoom is running return!");
            return;
        }
        if (this.core.o0().l().getValue() == EnterChannelState.ENTER_SUC) {
            QLog.d("QGMC.Core.MediaEnterExitRequestHelper", 1, "enterTRTCRoom is suc return!");
            return;
        }
        this.modelTrans.j();
        long currentTimeMillis = System.currentTimeMillis();
        CorountineFunKt.e(this.core.getCoroutineScope(), "questEnterTrtcRoom", null, null, Boolean.TRUE, new MediaEnterExitRequestHelper$enterTRTCRoom$1(this, callback, this.core.v0().k(), currentTimeMillis, null), 6, null);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.r
    public void c(@NotNull com.tencent.mobileqq.guild.media.core.q startParams, @Nullable com.tencent.mobileqq.guild.media.core.b callback) {
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        Logger.f235387a.d().i("QGMC.Core.MediaEnterExitRequestHelper", 1, "enterChannel start, " + startParams);
        if (!k1(startParams, callback)) {
            return;
        }
        this.enterChannelJob = CorountineFunKt.e(this.core.getCoroutineScope(), "enterChannel", null, null, Boolean.TRUE, new MediaEnterExitRequestHelper$enterChannel$2(this, startParams, callback, null), 6, null);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.r
    public void d(int themeType) {
        CorountineFunKt.e(this.core.getCoroutineScope(), "switchChannelTheme", null, null, null, new MediaEnterExitRequestHelper$switchChannelTheme$1(this, themeType, null), 14, null);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.r
    public void g0(boolean needReset) {
        if (!needReset && this.exitTRTCRoomCountDownTimer != null) {
            return;
        }
        final long disConnectTRTCSeconds = com.tencent.mobileqq.guild.media.core.j.c().k().getDisConnectTRTCSeconds();
        if (disConnectTRTCSeconds <= 0) {
            QLog.d("QGMC.Core.MediaEnterExitRequestHelper", 1, "startExitTRTCRoomCountDownTimer timeInterval <= 0");
            return;
        }
        final long serverTime = NetConnInfoCenter.getServerTime();
        Timer timer = this.exitTRTCRoomCountDownTimer;
        if (timer != null) {
            timer.cancel();
        }
        BaseTimer baseTimer = new BaseTimer();
        this.exitTRTCRoomCountDownTimer = baseTimer;
        Intrinsics.checkNotNull(baseTimer);
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaEnterExitRequestHelper$startExitTRTCRoomCountDownTimer$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaEnterExitRequestHelper$startExitTRTCRoomCountDownTimer$1$a", "Lcom/tencent/mobileqq/guild/media/core/c;", "", "isSuccess", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class a implements com.tencent.mobileqq.guild.media.core.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ MediaEnterExitRequestHelper f228293a;

                a(MediaEnterExitRequestHelper mediaEnterExitRequestHelper) {
                    this.f228293a = mediaEnterExitRequestHelper;
                }

                @Override // com.tencent.mobileqq.guild.media.core.c
                public void a(boolean isSuccess) {
                    this.f228293a.core.M0().e1(true);
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (NetConnInfoCenter.getServerTime() > disConnectTRTCSeconds + serverTime) {
                    QLog.d("QGMC.Core.MediaEnterExitRequestHelper", 1, "ExitTRTCRoomCountDownTimer call exit");
                    MediaEnterExitRequestHelper mediaEnterExitRequestHelper = this;
                    mediaEnterExitRequestHelper.G0(new a(mediaEnterExitRequestHelper));
                    this.y();
                }
            }
        }, 0L, 10000L);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void p() {
        super.p();
        E0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.r
    public void w() {
        this.mediaChannelStatusReportHelper.k(M0());
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.r
    public void y() {
        Timer timer = this.exitTRTCRoomCountDownTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.exitTRTCRoomCountDownTimer = null;
    }
}
