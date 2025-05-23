package com.tencent.mobileqq.guild.media.core.logic;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.CommonRsp;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u00013B\u000f\u0012\u0006\u00105\u001a\u000202\u00a2\u0006\u0004\b6\u00107J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\"\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J3\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\rH\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\rH\u0016J\u001a\u0010*\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010+\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010/\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\rH\u0016J2\u00100\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u00101\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelSpeakerHelper;", "Lcom/tencent/mobileqq/guild/media/core/logic/o;", "", "enable", "isMute", "Lcom/tencent/mobileqq/guild/media/core/i;", "cb", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/media/core/a;", "rsp", "t", ReportConstant.COSTREPORT_PREFIX, "", "result", "", "errMsg", "v", "u", "permissionCb", "y", HippyTKDListViewAdapter.X, "", "guildId", "channelId", "tinyId", "bAllow", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(JJJZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bVoiceless", "B", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w", "modeType", "b", "audioIsOpen", "d", "getAudioRoute", "route", V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, "i", "c", "g", "userId", "volumeToMe", tl.h.F, "f", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "a", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelSpeakerHelper implements o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelSpeakerHelper$b", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.core.i f228233b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CommonRsp f228234c;

        b(com.tencent.mobileqq.guild.media.core.i iVar, CommonRsp commonRsp) {
            this.f228233b = iVar;
            this.f228234c = commonRsp;
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (result != 0) {
                MediaChannelSpeakerHelper.this.v(result, errMsg, this.f228233b);
                return;
            }
            com.tencent.mobileqq.guild.media.core.i iVar = this.f228233b;
            if (iVar != null) {
                iVar.onResult(this.f228234c.getCode(), this.f228234c.getMsg());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelSpeakerHelper$c", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.core.i f228236b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CommonRsp f228237c;

        c(com.tencent.mobileqq.guild.media.core.i iVar, CommonRsp commonRsp) {
            this.f228236b = iVar;
            this.f228237c = commonRsp;
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (result != 0) {
                MediaChannelSpeakerHelper.this.v(result, errMsg, this.f228236b);
                MediaChannelSpeakerHelper.this.core.Q().G0(null);
            } else {
                com.tencent.mobileqq.guild.media.core.i iVar = this.f228236b;
                if (iVar != null) {
                    iVar.onResult(this.f228237c.getCode(), this.f228237c.getMsg());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "secResult", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements dv {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f228239b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f228240c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<CommonRsp> f228241d;

        /* JADX WARN: Multi-variable type inference failed */
        d(long j3, boolean z16, Continuation<? super CommonRsp> continuation) {
            this.f228239b = j3;
            this.f228240c = z16;
            this.f228241d = continuation;
        }

        @Override // wh2.dv
        public final void a(int i3, @Nullable String str, @Nullable IGProSecurityResult iGProSecurityResult) {
            Long l3;
            String str2;
            com.tencent.mobileqq.guild.media.core.data.p g16;
            Logger logger = Logger.f235387a;
            boolean z16 = this.f228240c;
            Logger.a d16 = logger.d();
            String str3 = null;
            if (iGProSecurityResult != null) {
                l3 = Long.valueOf(iGProSecurityResult.get$actionCode());
            } else {
                l3 = null;
            }
            if (iGProSecurityResult != null) {
                str2 = iGProSecurityResult.getStrPrompt();
            } else {
                str2 = null;
            }
            if (iGProSecurityResult != null) {
                str3 = iGProSecurityResult.getStrDetail();
            }
            int i16 = 1;
            d16.d("QGMC.Core.MediaChannelSpeakerHelper", 1, "suspendSetUserPermissionInGuild, bAllow " + z16 + ", code " + i3 + ", msg " + str + ", securityTips=[code(" + l3 + "), strPrompt(" + str2 + "), detail(" + str3 + ")]");
            if (i3 == 0 && MediaChannelSpeakerHelper.this.core.isInChannel() && (g16 = MediaChannelSpeakerHelper.this.core.D0().g(String.valueOf(this.f228239b))) != null) {
                boolean z17 = this.f228240c;
                g16.f228113u = !z17;
                if (!z17) {
                    i16 = 2;
                }
                g16.f228105m = i16;
                MediaChannelSpeakerHelper.this.core.l0().m("setUserMuteSeatInGuild", MediaChannelSpeakerHelper.this.core.getSelfUserInfo());
            }
            Continuation<CommonRsp> continuation = this.f228241d;
            Result.Companion companion = Result.INSTANCE;
            if (str == null) {
                str = "";
            }
            continuation.resumeWith(Result.m476constructorimpl(new CommonRsp(i3, str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class e implements vh2.cc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f228242a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f228243b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MediaChannelSpeakerHelper f228244c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<CommonRsp> f228245d;

        /* JADX WARN: Multi-variable type inference failed */
        e(String str, boolean z16, MediaChannelSpeakerHelper mediaChannelSpeakerHelper, Continuation<? super CommonRsp> continuation) {
            this.f228242a = str;
            this.f228243b = z16;
            this.f228244c = mediaChannelSpeakerHelper;
            this.f228245d = continuation;
        }

        @Override // vh2.cc
        public final void onResult(int i3, String errMsg) {
            if (i3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("QGMC.Core.MediaChannelSpeakerHelper", 2, "setUserVoicelessToMe success, tinyId[" + this.f228242a + "], bVoiceless[" + this.f228243b + "], inRoom[" + this.f228244c.core.isInChannel() + "]");
                }
                if (this.f228244c.core.isInChannel()) {
                    this.f228244c.core.y0().muteRemoteAudio(this.f228242a, this.f228243b);
                    com.tencent.mobileqq.guild.media.core.data.p g16 = this.f228244c.core.D0().g(this.f228242a);
                    if (g16 == null) {
                        g16 = MediaChannelCore.INSTANCE.a().o0().getTotalUserInfoList().g(this.f228242a);
                    }
                    if (this.f228243b) {
                        this.f228244c.core.o0().r().add(Long.valueOf(Long.parseLong(this.f228242a)));
                    } else {
                        this.f228244c.core.o0().r().remove(Long.valueOf(Long.parseLong(this.f228242a)));
                    }
                    if (g16 != null) {
                        g16.f228112t = this.f228243b;
                        this.f228244c.core.l0().m("setUserVoicelessToMe", this.f228244c.core.getSelfUserInfo());
                        this.f228244c.core.l0().r("setUserVoicelessToMe", this.f228242a, this.f228243b);
                        if (!this.f228243b) {
                            this.f228244c.core.y0().setRemoteAudioVolume(g16.f228093a, g16.f228110r);
                        }
                    }
                }
            }
            Continuation<CommonRsp> continuation = this.f228245d;
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            continuation.resumeWith(Result.m476constructorimpl(new CommonRsp(i3, errMsg)));
        }
    }

    public MediaChannelSpeakerHelper(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object A(long j3, long j16, long j17, boolean z16, Continuation<? super CommonRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).setUserPermissionInGuild(j3, j16, j17, z16, new d(j17, z16, safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object B(String str, boolean z16, Continuation<? super CommonRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).setUserVoicelessToMe(str, z16, new e(str, z16, this, safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(boolean z16, Continuation<? super CommonRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        bh.S(this.core.u0(), z16, false, false, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelSpeakerHelper$checkMicState$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String retMsg) {
                Intrinsics.checkNotNullParameter(retMsg, "retMsg");
                Continuation<CommonRsp> continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(new CommonRsp(i3, retMsg)));
            }
        }, 6, null);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.media.core.i s(com.tencent.mobileqq.guild.media.core.i cb5, CommonRsp rsp) {
        return new b(cb5, rsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.media.core.i t(com.tencent.mobileqq.guild.media.core.i cb5, CommonRsp rsp) {
        return new c(cb5, rsp);
    }

    private final void u(boolean enable) {
        com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = this.core.getSelfUserInfo();
        selfUserInfo.f228101i = enable;
        Iterator<com.tencent.mobileqq.guild.media.core.data.p> it = this.core.D0().f228125a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mobileqq.guild.media.core.data.p next = it.next();
            if (Intrinsics.areEqual(next.f228093a, selfUserInfo.f228093a)) {
                QLog.i("QGMC.Core.MediaChannelSpeakerHelper", 1, "notifySetSelfMicrophone " + enable);
                next.f228101i = enable;
                break;
            }
        }
        this.core.l0().m("setSelfMicrophone", this.core.getSelfUserInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int result, String errMsg, com.tencent.mobileqq.guild.media.core.i cb5) {
        u(false);
        if (cb5 != null) {
            cb5.onResult(result, errMsg);
        }
        w(false, false);
    }

    private final void w(boolean enable, boolean isMute) {
        int i3;
        if (isMute) {
            i3 = 3;
        } else if (enable) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        bi.W(this.core.p0(), i3, 0, 0, false, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(boolean enable, boolean isMute) {
        if (enable) {
            this.core.y0().K();
            this.core.o0().I0(true);
        } else {
            this.core.y0().a();
        }
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.A(enable);
        w(enable, isMute);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(final boolean enable, final boolean isMute, final com.tencent.mobileqq.guild.media.core.i permissionCb) {
        if (!this.core.isInChannel()) {
            QLog.i("QGMC.Core.MediaChannelSpeakerHelper", 1, "setAvRoomMicrophone when not in room!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QGMC.Core.MediaChannelSpeakerHelper", 2, QLog.getStackTraceString(new Throwable("setMicrophone[" + enable + "]")));
        }
        if (enable) {
            MediaChannelUtils.O(new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.core.logic.MediaChannelSpeakerHelper$setAvRoomMicroPhoneInner$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                    return invoke(bool.booleanValue(), bool2.booleanValue());
                }

                @Nullable
                public final Unit invoke(boolean z16, boolean z17) {
                    if (z16) {
                        MediaChannelSpeakerHelper.this.x(enable, isMute);
                        com.tencent.mobileqq.guild.media.core.i iVar = permissionCb;
                        if (iVar == null) {
                            return null;
                        }
                        iVar.onResult(0, "");
                        return Unit.INSTANCE;
                    }
                    QLog.i("QGMC.Core.MediaChannelSpeakerHelper", 1, "[setAvRoomMicroPhoneInner] request permission failed");
                    String msg2 = QQGuildUIUtil.r(R.string.f152841ah);
                    com.tencent.mobileqq.guild.media.core.i iVar2 = permissionCb;
                    if (iVar2 == null) {
                        return null;
                    }
                    Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                    iVar2.onResult(-1, msg2);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        x(enable, isMute);
        if (permissionCb != null) {
            permissionCb.onResult(0, "");
        }
    }

    private final void z(boolean enable, boolean isMute, com.tencent.mobileqq.guild.media.core.i cb5) {
        if (!this.core.isInChannel()) {
            QLog.i("QGMC.Core.MediaChannelSpeakerHelper", 1, "setMicrophone when not in room!");
            if (cb5 != null) {
                cb5.onResult(-1, "");
                return;
            }
            return;
        }
        u(enable);
        if (enable) {
            CorountineFunKt.e(this.core.getCoroutineScope(), "setMicroPhoneInner", null, null, Boolean.TRUE, new MediaChannelSpeakerHelper$setMicroPhoneInner$1(this, enable, isMute, cb5, null), 6, null);
            return;
        }
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.D(enable, 0, "");
        y(enable, isMute, null);
        if (cb5 != null) {
            cb5.onResult(0, "");
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.o
    public void b(int modeType) {
        QLog.d("QGMC.Core.MediaChannelSpeakerHelper", 1, "[setAudioMode] " + modeType);
        com.tencent.mobileqq.guild.util.bw.L0(modeType);
        if (this.core.isInChannel()) {
            this.core.y0().b(modeType);
        }
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.m(modeType);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.o
    public void c(boolean enable, boolean isMute, @Nullable com.tencent.mobileqq.guild.media.core.i cb5) {
        z(enable, isMute, cb5);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.o
    public void d(boolean audioIsOpen) {
        if (this.core.isInChannel()) {
            this.core.y0().i(audioIsOpen);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.o
    public void e(@NotNull String tinyId, boolean bVoiceless, @Nullable com.tencent.mobileqq.guild.media.core.i cb5) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        CorountineFunKt.e(this.core.getCoroutineScope(), "setUserVoicelessToMe", null, null, null, new MediaChannelSpeakerHelper$setUserVoicelessToMe$1(this, tinyId, bVoiceless, cb5, null), 14, null);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.o
    public void f(long guildId, long channelId, long tinyId, boolean bAllow, @Nullable com.tencent.mobileqq.guild.media.core.i cb5) {
        CorountineFunKt.e(this.core.getCoroutineScope(), "setUserMuteSeatInGuild", null, null, null, new MediaChannelSpeakerHelper$setUserPermissionInGuild$1(this, guildId, channelId, tinyId, bAllow, cb5, null), 14, null);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.o
    public void g(boolean enable) {
        y(enable, false, null);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.o
    public int getAudioRoute() {
        return this.core.t0().d();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.o
    public void h(@NotNull String userId, int volumeToMe) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        com.tencent.mobileqq.guild.util.bw.Y1(userId, volumeToMe);
        com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(userId);
        if (g16 == null) {
            g16 = MediaChannelCore.INSTANCE.a().o0().getTotalUserInfoList().g(userId);
        }
        if (g16 != null) {
            g16.f228110r = volumeToMe;
            com.tencent.mobileqq.guild.media.core.j.a().l0().m("setUserVoiceVolumeToMe", this.core.getSelfUserInfo());
            int k3 = g16.k();
            Logger.f235387a.d().i("QGMC.Core.MediaChannelSpeakerHelper", 1, "[setVoiceVolumeToMe] " + userId + " volumeToMe: " + volumeToMe + ", volumePercent:" + g16.f228111s + ", realVolume:" + k3);
            this.core.y0().setRemoteAudioVolume(userId, k3);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.o
    public void i(boolean enable, @Nullable com.tencent.mobileqq.guild.media.core.i cb5) {
        z(enable, false, cb5);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.o
    public void setAudioRoute(int route) {
        if (!this.core.isInChannel()) {
            QLog.w("QGMC.Core.MediaChannelSpeakerHelper", 1, "setAudioRoute when not in room!");
            return;
        }
        QLog.i("QGMC.Core.MediaChannelSpeakerHelper", 1, "setAudioRoute[" + route + "]");
        if (route != 0) {
            if (route == 1) {
                this.core.y0().d();
            }
        } else {
            this.core.y0().B();
        }
        com.tencent.mobileqq.guild.performance.report.aa.f230980i.F(route);
    }
}
