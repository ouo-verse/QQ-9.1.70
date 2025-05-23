package com.tencent.mobileqq.guild.media.core.logic;

import android.os.CountDownTimer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.fe;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u00019\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0003DEFB\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0014\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0006\u0010\u001b\u001a\u00020\u0003J\u0012\u0010\u001c\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R$\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020,8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R$\u00108\u001a\u0012\u0012\u0004\u0012\u00020403j\b\u0012\u0004\u0012\u000204`58\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", "e0", "", "timeMillis", "F0", "H0", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper$b;", "callback", "Lkotlinx/coroutines/Job;", "i0", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper$c;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUserFreeGiftInfoRsp;", "l0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lct1/a;", "freeGiftInfo", "I0", "durationMillis", "J0", "M0", "f0", "E0", "h0", "u", "c0", "a0", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", "f", "Lkotlinx/coroutines/Job;", "getCheckJob", "()Lkotlinx/coroutines/Job;", "setCheckJob", "(Lkotlinx/coroutines/Job;)V", "checkJob", "Landroid/os/CountDownTimer;", tl.h.F, "Landroid/os/CountDownTimer;", "giftCheckCountDownTimer", "", "<set-?>", "i", UserInfo.SEX_FEMALE, "j0", "()F", "countDownProgressPercent", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "needCheckThemeTypes", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper$g", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper$g;", "switchThemeObserver", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "checkTimerRunnable", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "E", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelFreeGiftTaskHelper extends h {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final g switchThemeObserver;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Runnable checkTimerRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job checkJob;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownTimer giftCheckCountDownTimer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float countDownProgressPercent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Integer> needCheckThemeTypes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper$b;", "", "", "isSuccess", "Lct1/a;", "freeGiftInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public static final class a {
            public static /* synthetic */ void a(b bVar, boolean z16, ct1.a aVar, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 1) != 0) {
                        z16 = true;
                    }
                    if ((i3 & 2) != 0) {
                        aVar = null;
                    }
                    bVar.a(z16, aVar);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
            }
        }

        void a(boolean isSuccess, @Nullable ct1.a freeGiftInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0004\u001a\u00020\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0018\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\f\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper$c;", "T", "", "", "b", "", "toString", "", "hashCode", "other", "equals", "", "a", "J", "getCode", "()J", "code", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "msg", "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "rsp", "<init>", "(JLjava/lang/String;Ljava/lang/Object;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.core.logic.MediaChannelFreeGiftTaskHelper$c, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class SuspendRsp<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long code;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String msg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final T rsp;

        public SuspendRsp(long j3, @NotNull String msg2, @Nullable T t16) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.code = j3;
            this.msg = msg2;
            this.rsp = t16;
        }

        @Nullable
        public final T a() {
            return this.rsp;
        }

        public final boolean b() {
            if (this.code == 0) {
                return true;
            }
            return false;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SuspendRsp)) {
                return false;
            }
            SuspendRsp suspendRsp = (SuspendRsp) other;
            if (this.code == suspendRsp.code && Intrinsics.areEqual(this.msg, suspendRsp.msg) && Intrinsics.areEqual(this.rsp, suspendRsp.rsp)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int a16 = ((androidx.fragment.app.a.a(this.code) * 31) + this.msg.hashCode()) * 31;
            T t16 = this.rsp;
            if (t16 == null) {
                hashCode = 0;
            } else {
                hashCode = t16.hashCode();
            }
            return a16 + hashCode;
        }

        @NotNull
        public String toString() {
            return "SuspendRsp(code=" + this.code + ", msg=" + this.msg + ", rsp=" + this.rsp + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper$d", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper$b;", "", "isSuccess", "Lct1/a;", "freeGiftInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements b {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.MediaChannelFreeGiftTaskHelper.b
        public void a(boolean isSuccess, @Nullable ct1.a freeGiftInfo) {
            if (isSuccess && freeGiftInfo != null) {
                if (!freeGiftInfo.i()) {
                    MediaChannelFreeGiftTaskHelper mediaChannelFreeGiftTaskHelper = MediaChannelFreeGiftTaskHelper.this;
                    mediaChannelFreeGiftTaskHelper.J0(mediaChannelFreeGiftTaskHelper.mediaChannelCore.o0().getFreeGiftInfo().l());
                    return;
                } else {
                    if (freeGiftInfo.getNextCheckTimestampMs() > 0) {
                        Logger.f235387a.d().i("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[checkFreeGiftTimer] reStartCheck");
                        MediaChannelFreeGiftTaskHelper.this.F0(freeGiftInfo.l());
                        return;
                    }
                    return;
                }
            }
            Logger.f235387a.d().w("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[onResult] checkFreeGift failed. isSuccess: " + isSuccess);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUserFreeGiftInfoRsp;", "rsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUserFreeGiftInfoRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements wh2.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<SuspendRsp<IGProUserFreeGiftInfoRsp>> f228182a;

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super SuspendRsp<IGProUserFreeGiftInfoRsp>> continuation) {
            this.f228182a = continuation;
        }

        @Override // wh2.l
        public final void a(int i3, String errMsg, IGProUserFreeGiftInfoRsp iGProUserFreeGiftInfoRsp) {
            Logger.f235387a.d().d("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[getFreeGiftCheckRsp] result " + i3 + ", errMsg " + errMsg);
            Continuation<SuspendRsp<IGProUserFreeGiftInfoRsp>> continuation = this.f228182a;
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            continuation.resumeWith(Result.m476constructorimpl(new SuspendRsp((long) i3, errMsg, iGProUserFreeGiftInfoRsp)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper$f", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f228183a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MediaChannelFreeGiftTaskHelper f228184b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(long j3, MediaChannelFreeGiftTaskHelper mediaChannelFreeGiftTaskHelper) {
            super(j3, 200L);
            this.f228183a = j3;
            this.f228184b = mediaChannelFreeGiftTaskHelper;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.f235387a.d().i("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[run] timer task.");
            this.f228184b.f0();
            this.f228184b.c0();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            MediaChannelFreeGiftTaskHelper mediaChannelFreeGiftTaskHelper = this.f228184b;
            long j3 = this.f228183a;
            float f16 = 0.0f;
            if (j3 != 0) {
                f16 = RangesKt___RangesKt.coerceAtLeast(0.0f, ((float) (j3 - millisUntilFinished)) / ((float) j3));
            }
            mediaChannelFreeGiftTaskHelper.countDownProgressPercent = f16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelFreeGiftTaskHelper$g", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull SwitchThemeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger.f235387a.d().i("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[onEventReceive] SwitchThemeEvent " + event.getOldThemeType() + " --> " + event.getNewThemeType());
            if (!MediaChannelFreeGiftTaskHelper.this.needCheckThemeTypes.contains(Integer.valueOf(event.getOldThemeType())) && !MediaChannelFreeGiftTaskHelper.this.needCheckThemeTypes.contains(Integer.valueOf(event.getNewThemeType()))) {
                return;
            }
            MediaChannelFreeGiftTaskHelper.b0(MediaChannelFreeGiftTaskHelper.this, null, 1, null);
        }
    }

    public MediaChannelFreeGiftTaskHelper(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        ArrayList<Integer> arrayListOf;
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(6);
        this.needCheckThemeTypes = arrayListOf;
        this.switchThemeObserver = new g();
        this.checkTimerRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.ag
            @Override // java.lang.Runnable
            public final void run() {
                MediaChannelFreeGiftTaskHelper.d0(MediaChannelFreeGiftTaskHelper.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(long timeMillis) {
        H0();
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.checkTimerRunnable, timeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.checkTimerRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(ct1.a freeGiftInfo) {
        if (freeGiftInfo.getFreeGiftNumAfterCheck() > 0) {
            boolean decodeBool = com.tencent.mobileqq.guild.util.bw.L().decodeBool("mmkv_key_guild_media_gift_first_get_free_gift", false);
            this.mediaChannelCore.o0().b0().setValue(Boolean.valueOf(!decodeBool));
            com.tencent.mobileqq.guild.util.bw.L().encodeBool("mmkv_key_guild_media_gift_first_get_free_gift", true);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("QGMC.MediaChannelFreeGiftTaskHelper", 2, "[sendNoticeMessage] isTodayFirstGetFreeGift " + decodeBool);
            }
        }
        if (freeGiftInfo.j()) {
            boolean decodeBool2 = com.tencent.mobileqq.guild.util.bw.L().decodeBool("mmkv_key_guild_media_gift_first_get_upper_limit_free_gift", false);
            this.mediaChannelCore.o0().W().setValue(Boolean.valueOf(!decodeBool2));
            com.tencent.mobileqq.guild.util.bw.L().encodeBool("mmkv_key_guild_media_gift_first_get_upper_limit_free_gift", true);
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("QGMC.MediaChannelFreeGiftTaskHelper", 2, "[sendNoticeMessage] isFirstGetUpperLimit " + decodeBool2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(long durationMillis) {
        Logger.f235387a.d().i("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[startGetFreeGiftTimer] duration: " + durationMillis);
        M0();
        f fVar = new f(durationMillis, this);
        this.giftCheckCountDownTimer = fVar;
        fVar.start();
    }

    private final void M0() {
        CountDownTimer countDownTimer = this.giftCheckCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.giftCheckCountDownTimer = null;
        f0();
    }

    public static /* synthetic */ void b0(MediaChannelFreeGiftTaskHelper mediaChannelFreeGiftTaskHelper, b bVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bVar = null;
        }
        mediaChannelFreeGiftTaskHelper.a0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(MediaChannelFreeGiftTaskHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c0();
    }

    private final void e0() {
        this.mediaChannelCore.o0().getFreeGiftInfo().m("");
        M0();
        H0();
        Job job = this.checkJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.mediaChannelCore.getEventBus().j(SwitchThemeEvent.class, this.switchThemeObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        this.countDownProgressPercent = 0.0f;
    }

    private final Job i0(b callback) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.mediaChannelCore.getCoroutineScope(), null, null, new MediaChannelFreeGiftTaskHelper$fetchFreeGiftInfo$1(this, callback, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x005b, code lost:
    
        if (r2 != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object l0(Continuation<? super SuspendRsp<IGProUserFreeGiftInfoRsp>> continuation) {
        Continuation intercepted;
        ArrayList<Integer> arrayListOf;
        Object coroutine_suspended;
        boolean contains;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        fe feVar = new fe();
        feVar.e(com.tencent.mobileqq.guild.util.az.d(this.mediaChannelCore.E(), 0L));
        feVar.g(com.tencent.mobileqq.guild.util.az.d(this.mediaChannelCore.getGuildID(), 0L));
        feVar.f(this.mediaChannelCore.o0().getFreeGiftInfo().getCheckAttachInfo());
        if (this.mediaChannelCore.d0().getThirdAppInfo() == null) {
            contains = CollectionsKt___CollectionsKt.contains(this.needCheckThemeTypes, this.mediaChannelCore.o0().M().getValue());
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.mediaChannelCore.o0().M().getValue());
        feVar.h(arrayListOf);
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).checkUserFreeGiftInfo(feVar, new e(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        Logger.f235387a.d().d("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[onEnterChannel] ");
        c0();
        this.mediaChannelCore.getEventBus().V(SwitchThemeEvent.class, this.switchThemeObserver);
    }

    public final void a0(@Nullable b callback) {
        Logger.f235387a.d().d("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[checkFreeGift] ");
        Job job = this.checkJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.checkJob = i0(callback);
    }

    public final void c0() {
        Logger.f235387a.d().i("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[checkFreeGiftTimer] start");
        a0(new d());
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void h0() {
        e0();
        Logger.f235387a.d().d("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[onReEnterChannel] ");
        c0();
    }

    /* renamed from: j0, reason: from getter */
    public final float getCountDownProgressPercent() {
        return this.countDownProgressPercent;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        Logger.f235387a.d().d("QGMC.MediaChannelFreeGiftTaskHelper", 1, "[onExitChannel] ");
        e0();
    }
}
