package com.tencent.mobileqq.guild.channel.joinchannel;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qroute.QRoute;
import jr1.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J@\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u0007J@\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nH\u0007J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/q;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "", "needJump2AIO", "", "entranceId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "", "callback", "d", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "c", "", "guildId", "g", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f215010a = new q();

    q() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void c(@NotNull final Context context, @NotNull JumpGuildParam jumpGuildParam, boolean needJump2AIO, int entranceId, @Nullable final Function1<? super IGProJoinGuildResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        final JumpGuildParam m187clone = jumpGuildParam.m187clone();
        Intrinsics.checkNotNullExpressionValue(m187clone, "jumpGuildParam.clone()");
        m187clone.getJoinInfoParam().setPageEntranceId(entranceId);
        m187clone.getExtras().putBoolean(JumpGuildParam.EXTRA_KEY_IS_FROM_STANDALONE_PAGE, true);
        JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
        jumpParam.c(needJump2AIO);
        jumpParam.a(1);
        jumpParam.d(!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected());
        h.a(context, m187clone, jumpParam, "Guild.join.JoinAfterJumpChannel.StandaloneJoinGuildHelper", new bv() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.o
            @Override // vh2.bv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                q.f(context, m187clone, callback, i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@NotNull final Context context, @NotNull final FacadeArgsData facadeArgsData, boolean needJump2AIO, int entranceId, @Nullable final Function1<? super IGProJoinGuildResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        JumpGuildParam a16 = facadeArgsData.a();
        a16.setDetailPageJumpInfo(facadeArgsData.b());
        a16.getJoinInfoParam().setPageEntranceId(entranceId);
        JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
        jumpParam.c(needJump2AIO);
        jumpParam.a(1);
        jumpParam.d(!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected());
        a16.getExtras().putBoolean(JumpGuildParam.EXTRA_KEY_IS_FROM_STANDALONE_PAGE, true);
        h.a(context, a16, jumpParam, "Guild.join.JoinAfterJumpChannel.StandaloneJoinGuildHelper", new bv() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.p
            @Override // vh2.bv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                q.e(FacadeArgsData.this, context, callback, i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FacadeArgsData facadeArgsData, Context context, Function1 function1, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "$facadeArgsData");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (h.d(i3, iGProSecurityResult)) {
            facadeArgsData.f227655d = 1;
            if (context == QBaseActivity.sTopActivity) {
                q qVar = f215010a;
                String str2 = facadeArgsData.f227656e;
                Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
                qVar.g(str2);
            }
            if (iGProJoinGuildResult != null && function1 != null) {
                function1.invoke(iGProJoinGuildResult);
                return;
            }
            return;
        }
        h.c(context, i3, str, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Context context, JumpGuildParam param, Function1 function1, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(param, "$param");
        if (h.d(i3, iGProSecurityResult)) {
            if (context == QBaseActivity.sTopActivity) {
                q qVar = f215010a;
                String str2 = param.guildId;
                Intrinsics.checkNotNullExpressionValue(str2, "param.guildId");
                qVar.g(str2);
            }
            if (iGProJoinGuildResult != null && function1 != null) {
                function1.invoke(iGProJoinGuildResult);
                return;
            }
            return;
        }
        h.c(context, i3, str, iGProSecurityResult);
    }

    private final void g(String guildId) {
        ((IGPSService) ch.R0(IGPSService.class)).unsubscribePolling(guildId);
        jr1.a.c(new a.AbstractC10609a.GuildStandaloneActive(guildId));
        ((IGPSService) ch.R0(IGPSService.class)).subscribePolling(guildId);
        jr1.a.b(new a.AbstractC10609a.GuildStandaloneActive(guildId));
    }
}
