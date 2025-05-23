package com.tencent.mobileqq.guild.jump;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.home.fragments.ban.GuildVisitorExceptionFragment;
import com.tencent.mobileqq.guild.jump.GuildJumpLoadingFragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.QQToastUtil;
import dq1.k;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\bJ(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J#\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\bJ2\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildJumpHelper;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "", "i", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "", "extCode", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "f", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "d", "result", "", "errMsg", "g", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildJumpHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildJumpHelper f226371a = new GuildJumpHelper();

    GuildJumpHelper() {
    }

    private final void e(Context context) {
        GuildJumpLoadingFragment.INSTANCE.a();
        Bundle bundle = new Bundle();
        bundle.putInt("titleBarStyle", 10);
        cx.b(context, "https://qun.qq.com/guild/h5/guild-internal-test/index.html", bundle);
        Logger.f235387a.d().d("Guild.jump.GuildJumpHelper", 1, "gotoH5InnerTestPage");
    }

    private final boolean f(Context context, JumpGuildParam param, int extCode, IGProGuildInfo guildInfo) {
        if (!guildInfo.getIsValid()) {
            Logger.f235387a.d().w("Guild.jump.GuildJumpHelper", 1, "handleInfoIntercept guild is dissolve. ");
            GuildVisitorExceptionFragment.INSTANCE.a(context, param, 4, guildInfo);
            return true;
        }
        if (!guildInfo.getIsBanned() && !guildInfo.getIsFrozen()) {
            if (extCode != 784017) {
                return false;
            }
            Logger.f235387a.d().w("Guild.jump.GuildJumpHelper", 1, "handleInfoIntercept user banned ");
            GuildVisitorExceptionFragment.INSTANCE.a(context, param, 1, guildInfo);
            return true;
        }
        Logger.f235387a.d().w("Guild.jump.GuildJumpHelper", 1, "handleInfoIntercept guild is banned. ");
        GuildVisitorExceptionFragment.INSTANCE.a(context, param, 0, guildInfo);
        return true;
    }

    public static /* synthetic */ boolean h(GuildJumpHelper guildJumpHelper, Context context, int i3, String str, JumpGuildParam jumpGuildParam, IGProGuildInfo iGProGuildInfo, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            iGProGuildInfo = null;
        }
        return guildJumpHelper.g(context, i3, str, jumpGuildParam, iGProGuildInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(Context context, JumpGuildParam jumpGuildParam, Continuation<? super Unit> continuation) {
        GuildJumpHelper$jumpByGuildId$1 guildJumpHelper$jumpByGuildId$1;
        Object coroutine_suspended;
        int i3;
        IPerformanceReportTask stageCode;
        boolean isBlank;
        int i16;
        GuildJumpHelper guildJumpHelper;
        Object obj;
        Context context2;
        GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp;
        boolean isBlank2;
        JumpGuildParam jumpGuildParam2 = jumpGuildParam;
        if (continuation instanceof GuildJumpHelper$jumpByGuildId$1) {
            guildJumpHelper$jumpByGuildId$1 = (GuildJumpHelper$jumpByGuildId$1) continuation;
            int i17 = guildJumpHelper$jumpByGuildId$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                guildJumpHelper$jumpByGuildId$1.label = i17 - Integer.MIN_VALUE;
                GuildJumpHelper$jumpByGuildId$1 guildJumpHelper$jumpByGuildId$12 = guildJumpHelper$jumpByGuildId$1;
                Object obj2 = guildJumpHelper$jumpByGuildId$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildJumpHelper$jumpByGuildId$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        IPerformanceReportTask iPerformanceReportTask = (IPerformanceReportTask) guildJumpHelper$jumpByGuildId$12.L$3;
                        JumpGuildParam jumpGuildParam3 = (JumpGuildParam) guildJumpHelper$jumpByGuildId$12.L$2;
                        context2 = (Context) guildJumpHelper$jumpByGuildId$12.L$1;
                        guildJumpHelper = (GuildJumpHelper) guildJumpHelper$jumpByGuildId$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        stageCode = iPerformanceReportTask;
                        jumpGuildParam2 = jumpGuildParam3;
                        obj = obj2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    boolean j06 = ch.j0(jumpGuildParam2.guildId);
                    Logger.f235387a.d().i("Guild.jump.GuildJumpHelper", 1, "jumpByGuildId isGuest:" + j06 + " param:" + jumpGuildParam2);
                    m(jumpGuildParam2);
                    if (!j06) {
                        l(context, jumpGuildParam);
                        return Unit.INSTANCE;
                    }
                    GuildJumpLoadingFragment.Companion.c(GuildJumpLoadingFragment.INSTANCE, context, jumpGuildParam2.businessType, false, 4, null);
                    jumpGuildParam2.extras.putBoolean("jumpGuildFromLoadingPage", true);
                    stageCode = qw1.b.f(jumpGuildParam2.extras, JumpGuildParam.EXTRA_JUMP_REPORT_TASK).duplicate("guild_id").setStageCode("stage_get_guild_info");
                    GuildMainFrameUtils guildMainFrameUtils = GuildMainFrameUtils.f227682a;
                    String str = jumpGuildParam2.guildId;
                    Intrinsics.checkNotNullExpressionValue(str, "param.guildId");
                    String channelId = jumpGuildParam.getChannelId();
                    Intrinsics.checkNotNullExpressionValue(channelId, "param.channelId");
                    String joinSignature = jumpGuildParam.getJoinSignature();
                    Intrinsics.checkNotNullExpressionValue(joinSignature, "param.joinSignature");
                    isBlank = StringsKt__StringsJVMKt.isBlank(joinSignature);
                    if (isBlank) {
                        i16 = jumpGuildParam2.businessType;
                    } else {
                        i16 = 0;
                    }
                    String str2 = jumpGuildParam2.inviteCode;
                    Intrinsics.checkNotNullExpressionValue(str2, "param.inviteCode");
                    guildJumpHelper$jumpByGuildId$12.L$0 = this;
                    guildJumpHelper$jumpByGuildId$12.L$1 = context;
                    guildJumpHelper$jumpByGuildId$12.L$2 = jumpGuildParam2;
                    guildJumpHelper$jumpByGuildId$12.L$3 = stageCode;
                    guildJumpHelper$jumpByGuildId$12.label = 1;
                    Object f16 = guildMainFrameUtils.f(str, channelId, i16, str2, guildJumpHelper$jumpByGuildId$12);
                    if (f16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    guildJumpHelper = this;
                    obj = f16;
                    context2 = context;
                }
                guildAndChannelInfoRsp = (GuildMainFrameUtils.GuildAndChannelInfoRsp) obj;
                qw1.b.b(stageCode, guildAndChannelInfoRsp.k(), guildAndChannelInfoRsp.e());
                if (!guildAndChannelInfoRsp.l() && guildAndChannelInfoRsp.h() != null && guildJumpHelper.f(context2, jumpGuildParam2, guildAndChannelInfoRsp.getExtCode(), guildAndChannelInfoRsp.h())) {
                    Logger.f235387a.d().w("Guild.jump.GuildJumpHelper", 1, "handleBannedStatus error:" + guildAndChannelInfoRsp.k() + "-" + guildAndChannelInfoRsp.getExtCode());
                    GuildJumpLoadingFragment.INSTANCE.a();
                    return Unit.INSTANCE;
                }
                if (h(guildJumpHelper, context2, guildAndChannelInfoRsp.k(), guildAndChannelInfoRsp.e(), jumpGuildParam2, null, 16, null)) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(guildAndChannelInfoRsp.getJoinSig());
                    if (!isBlank2) {
                        jumpGuildParam2.setJoinSignature(guildAndChannelInfoRsp.getJoinSig());
                    }
                    jumpGuildParam2.extras.putString("jump_guild_guest_inviter_name", guildAndChannelInfoRsp.getInviterName());
                    jumpGuildParam2.extras.putInt("jump_guild_guest_feed_num", guildAndChannelInfoRsp.getFeedNum());
                    guildJumpHelper.l(context2, jumpGuildParam2);
                    return Unit.INSTANCE;
                }
                Logger.f235387a.d().w("Guild.jump.GuildJumpHelper", 1, "jumpByGuildId error:" + guildAndChannelInfoRsp.k() + "-" + guildAndChannelInfoRsp.e());
                GuildJumpLoadingFragment.INSTANCE.a();
                return Unit.INSTANCE;
            }
        }
        guildJumpHelper$jumpByGuildId$1 = new GuildJumpHelper$jumpByGuildId$1(this, continuation);
        GuildJumpHelper$jumpByGuildId$1 guildJumpHelper$jumpByGuildId$122 = guildJumpHelper$jumpByGuildId$1;
        Object obj22 = guildJumpHelper$jumpByGuildId$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildJumpHelper$jumpByGuildId$122.label;
        if (i3 == 0) {
        }
        guildAndChannelInfoRsp = (GuildMainFrameUtils.GuildAndChannelInfoRsp) obj;
        qw1.b.b(stageCode, guildAndChannelInfoRsp.k(), guildAndChannelInfoRsp.e());
        if (!guildAndChannelInfoRsp.l()) {
        }
        if (h(guildJumpHelper, context2, guildAndChannelInfoRsp.k(), guildAndChannelInfoRsp.e(), jumpGuildParam2, null, 16, null)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(Context context, JumpGuildParam jumpGuildParam, Continuation<? super Unit> continuation) {
        GuildJumpHelper$jumpByGuildNumber$1 guildJumpHelper$jumpByGuildNumber$1;
        Object coroutine_suspended;
        int i3;
        JumpGuildParam jumpGuildParam2;
        IPerformanceReportTask iPerformanceReportTask;
        Context context2;
        GuildJumpHelper guildJumpHelper;
        GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp;
        boolean isBlank;
        if (continuation instanceof GuildJumpHelper$jumpByGuildNumber$1) {
            guildJumpHelper$jumpByGuildNumber$1 = (GuildJumpHelper$jumpByGuildNumber$1) continuation;
            int i16 = guildJumpHelper$jumpByGuildNumber$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildJumpHelper$jumpByGuildNumber$1.label = i16 - Integer.MIN_VALUE;
                GuildJumpHelper$jumpByGuildNumber$1 guildJumpHelper$jumpByGuildNumber$12 = guildJumpHelper$jumpByGuildNumber$1;
                Object obj = guildJumpHelper$jumpByGuildNumber$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildJumpHelper$jumpByGuildNumber$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        iPerformanceReportTask = (IPerformanceReportTask) guildJumpHelper$jumpByGuildNumber$12.L$3;
                        JumpGuildParam jumpGuildParam3 = (JumpGuildParam) guildJumpHelper$jumpByGuildNumber$12.L$2;
                        Context context3 = (Context) guildJumpHelper$jumpByGuildNumber$12.L$1;
                        GuildJumpHelper guildJumpHelper2 = (GuildJumpHelper) guildJumpHelper$jumpByGuildNumber$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        jumpGuildParam2 = jumpGuildParam3;
                        context2 = context3;
                        guildJumpHelper = guildJumpHelper2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    GuildJumpLoadingFragment.Companion.c(GuildJumpLoadingFragment.INSTANCE, context, jumpGuildParam.businessType, false, 4, null);
                    jumpGuildParam.extras.putBoolean("jumpGuildFromLoadingPage", true);
                    IPerformanceReportTask stageCode = qw1.b.f(jumpGuildParam.extras, JumpGuildParam.EXTRA_JUMP_REPORT_TASK).setExtra("guildNum", jumpGuildParam.guildNumber).setStageCode("stage_get_guild_info");
                    GuildMainFrameUtils guildMainFrameUtils = GuildMainFrameUtils.f227682a;
                    String str = jumpGuildParam.guildNumber;
                    Intrinsics.checkNotNullExpressionValue(str, "param.guildNumber");
                    guildJumpHelper$jumpByGuildNumber$12.L$0 = this;
                    guildJumpHelper$jumpByGuildNumber$12.L$1 = context;
                    guildJumpHelper$jumpByGuildNumber$12.L$2 = jumpGuildParam;
                    guildJumpHelper$jumpByGuildNumber$12.L$3 = stageCode;
                    guildJumpHelper$jumpByGuildNumber$12.label = 1;
                    Object n3 = GuildMainFrameUtils.n(guildMainFrameUtils, str, null, guildJumpHelper$jumpByGuildNumber$12, 2, null);
                    if (n3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jumpGuildParam2 = jumpGuildParam;
                    iPerformanceReportTask = stageCode;
                    obj = n3;
                    context2 = context;
                    guildJumpHelper = this;
                }
                guildAndChannelInfoRsp = (GuildMainFrameUtils.GuildAndChannelInfoRsp) obj;
                qw1.b.b(iPerformanceReportTask, guildAndChannelInfoRsp.k(), guildAndChannelInfoRsp.e());
                if (!guildAndChannelInfoRsp.l() && guildAndChannelInfoRsp.h() != null && guildJumpHelper.f(context2, jumpGuildParam2, guildAndChannelInfoRsp.getExtCode(), guildAndChannelInfoRsp.h())) {
                    Logger.f235387a.d().w("Guild.jump.GuildJumpHelper", 1, "handleBannedStatus error:" + guildAndChannelInfoRsp.k() + "-" + guildAndChannelInfoRsp.getExtCode());
                    GuildJumpLoadingFragment.INSTANCE.a();
                    return Unit.INSTANCE;
                }
                if (guildAndChannelInfoRsp.l()) {
                    h(guildJumpHelper, context2, guildAndChannelInfoRsp.k(), guildAndChannelInfoRsp.e(), jumpGuildParam2, null, 16, null);
                    Logger.f235387a.d().w("Guild.jump.GuildJumpHelper", 1, "jumpByGuildNumber error:" + guildAndChannelInfoRsp.k() + "-" + guildAndChannelInfoRsp.e());
                    if (guildAndChannelInfoRsp.k() == 95004) {
                        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.jump.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                GuildJumpHelper.k();
                            }
                        }, 700L);
                    } else {
                        GuildJumpLoadingFragment.INSTANCE.a();
                    }
                    return Unit.INSTANCE;
                }
                if (guildAndChannelInfoRsp.h() != null) {
                    guildJumpHelper.m(jumpGuildParam2);
                    jumpGuildParam2.guildId = guildAndChannelInfoRsp.h().getGuildID();
                    isBlank = StringsKt__StringsJVMKt.isBlank(guildAndChannelInfoRsp.getJoinSig());
                    if (!isBlank) {
                        jumpGuildParam2.setJoinSignature(guildAndChannelInfoRsp.getJoinSig());
                    }
                    guildJumpHelper.l(context2, jumpGuildParam2);
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        guildJumpHelper$jumpByGuildNumber$1 = new GuildJumpHelper$jumpByGuildNumber$1(this, continuation);
        GuildJumpHelper$jumpByGuildNumber$1 guildJumpHelper$jumpByGuildNumber$122 = guildJumpHelper$jumpByGuildNumber$1;
        Object obj2 = guildJumpHelper$jumpByGuildNumber$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildJumpHelper$jumpByGuildNumber$122.label;
        if (i3 == 0) {
        }
        guildAndChannelInfoRsp = (GuildMainFrameUtils.GuildAndChannelInfoRsp) obj2;
        qw1.b.b(iPerformanceReportTask, guildAndChannelInfoRsp.k(), guildAndChannelInfoRsp.e());
        if (!guildAndChannelInfoRsp.l()) {
        }
        if (guildAndChannelInfoRsp.l()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k() {
        GuildJumpLoadingFragment.INSTANCE.a();
    }

    private final void l(Context context, JumpGuildParam param) {
        Logger.f235387a.d().i("Guild.jump.GuildJumpHelper", 1, "openGuildPageInner param:" + param);
        dq1.c a16 = k.f394610a.a(param);
        if (a16 != null) {
            a16.jump(context);
            GuildJumpLoadingFragment.INSTANCE.a();
        } else {
            a.INSTANCE.e(context, param);
            GuildJumpLoadingFragment.INSTANCE.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m(JumpGuildParam param) {
        String str;
        boolean z16;
        boolean isBlank;
        Bundle bundle = param.extras;
        if (bundle != null) {
            str = bundle.getString("PGIN_SOURCE_REPORT_KEY");
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    com.tencent.mobileqq.guild.report.b.g(str, "Guild.jump.GuildJumpHelper");
                    return;
                } else {
                    if (param.extras.getInt("openGuildAioFrom") == 10) {
                        com.tencent.mobileqq.guild.report.b.g("qq_push", "Guild.jump.GuildJumpHelper");
                        return;
                    }
                    return;
                }
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    @Nullable
    public final Object d(@NotNull Context context, @NotNull JumpGuildParam jumpGuildParam, @NotNull Continuation<? super Unit> continuation) {
        boolean isBlank;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        if (!GuildMainFrameUtils.q(jumpGuildParam.guildId)) {
            Object i3 = i(context, jumpGuildParam, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (i3 == coroutine_suspended2) {
                return i3;
            }
            return Unit.INSTANCE;
        }
        String str = jumpGuildParam.guildNumber;
        Intrinsics.checkNotNullExpressionValue(str, "param.guildNumber");
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            Object j3 = j(context, jumpGuildParam, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (j3 == coroutine_suspended) {
                return j3;
            }
            return Unit.INSTANCE;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = "jump error " + jumpGuildParam;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.jump.GuildJumpHelper", 1, (String) it.next(), null);
        }
        return Unit.INSTANCE;
    }

    public final boolean g(@NotNull Context context, int result, @NotNull String errMsg, @NotNull JumpGuildParam param, @Nullable IGProGuildInfo guildInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(param, "param");
        if (result == 0) {
            return false;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "handleErrorResult result:" + result + " , errMsg:" + errMsg + " " + param;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.jump.GuildJumpHelper", 1, (String) it.next(), null);
        }
        if (NetworkUtil.isNetworkAvailable() && result != 1002 && result != 1013) {
            if (result == 784015) {
                QQToastUtil.showQQToast(1, R.string.f146830v9);
                return true;
            }
            if (result != 300122 && result != 780004 && result != 4000013) {
                if (result != 300137 && result != 784017) {
                    if (result != 300117 && result != 784011) {
                        switch (result) {
                            case 300132:
                            case 300133:
                            case 300134:
                                break;
                            default:
                                switch (result) {
                                    case 95004:
                                        QQToast.makeText(context, 0, errMsg, 1).show();
                                        return true;
                                    case 300103:
                                    case 300127:
                                        ch.L0(context, param.guildId, param.getChannelId(), 9, "Guild.jump.GuildJumpHelper", result);
                                        return true;
                                    case 300116:
                                    case 300129:
                                    case 300130:
                                    case 300131:
                                    case 784010:
                                        GuildVisitorExceptionFragment.INSTANCE.a(context, param, 4, guildInfo);
                                        return true;
                                    default:
                                        com.tencent.mobileqq.guild.util.security.b.c(context, result, errMsg, QQGuildUIUtil.r(R.string.f15162187));
                                        return true;
                                }
                        }
                    }
                    Logger.f235387a.d().i("Guild.jump.GuildJumpHelper", 1, "handleErrorResult show GuildVisitorBanFragment ban view");
                    GuildJumpLoadingFragment.INSTANCE.a();
                    GuildVisitorExceptionFragment.Companion.b(GuildVisitorExceptionFragment.INSTANCE, context, param, 0, guildInfo, 4, null);
                    return true;
                }
                GuildVisitorExceptionFragment.INSTANCE.a(context, param, 1, guildInfo);
                return true;
            }
            e(context);
            return true;
        }
        QQToastUtil.showQQToast(1, R.string.cib);
        return true;
    }
}
