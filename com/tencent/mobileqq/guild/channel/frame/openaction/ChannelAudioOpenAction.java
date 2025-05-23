package com.tencent.mobileqq.guild.channel.frame.openaction;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.channel.frame.openaction.i;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\f\u0010\n\u001a\u00020\t*\u00020\u0002H\u0002J\f\u0010\f\u001a\u00020\t*\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/openaction/ChannelAudioOpenAction;", "Lcom/tencent/mobileqq/guild/channel/frame/openaction/i;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Lkotlin/Function0;", "", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "c", "g", "", "d", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "f", "Landroid/content/Context;", "context", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChannelAudioOpenAction implements i {
    private final void c(JumpGuildParam jumpGuildParam, final Function0<Unit> confirm) {
        if (d(jumpGuildParam)) {
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            if (gLiveChannelCore.v()) {
                if (f(gLiveChannelCore)) {
                    g(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.channel.frame.openaction.ChannelAudioOpenAction$checkVideoState$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            GuildFloatWindowUtils.p();
                            GLiveChannelCore.f226698a.b("PUSH\u70b9\u51fb\u97f3\u89c6\u9891\u9700\u8981\u9000\u51fa\u76f4\u64ad");
                            confirm.invoke();
                        }
                    });
                    return;
                }
                GuildFloatWindowUtils.p();
                gLiveChannelCore.b("PUSH\u70b9\u51fb\u97f3\u89c6\u9891\u9700\u8981\u9000\u51fa\u76f4\u64ad");
                confirm.invoke();
                return;
            }
        }
        confirm.invoke();
    }

    private final boolean d(JumpGuildParam jumpGuildParam) {
        if (jumpGuildParam.extras.getInt("openGuildAioFrom", 0) != 10) {
            return false;
        }
        return true;
    }

    private final boolean f(GLiveChannelCore gLiveChannelCore) {
        LiveData<Boolean> D = gLiveChannelCore.t().D();
        Intrinsics.checkNotNullExpressionValue(D, "uiData.selfIsAnchorLiving");
        Object b16 = e12.d.b(D, Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(b16, "uiData.selfIsAnchorLiving.getNonNull(false)");
        if (((Boolean) b16).booleanValue() && gLiveChannelCore.r().d()) {
            return true;
        }
        return false;
    }

    private final void g(final Function0<Unit> confirm) {
        Activity currentTopActivity = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentTopActivity();
        if (currentTopActivity == null) {
            return;
        }
        DialogUtil.createCustomDialog(currentTopActivity, 230, cw.h(R.string.f147650xg), cw.h(R.string.f147630xe), cw.h(R.string.f140850f3), cw.h(R.string.f147640xf), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.frame.openaction.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChannelAudioOpenAction.h(Function0.this, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function0 confirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(confirm, "$confirm");
        confirm.invoke();
    }

    @Override // com.tencent.mobileqq.guild.channel.frame.openaction.i
    public boolean a(@NotNull final Context context, @NotNull final JumpGuildParam jumpGuildParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        String str = jumpGuildParam.guildId;
        String channelId = jumpGuildParam.getChannelId();
        Intrinsics.checkNotNullExpressionValue(channelId, "jumpGuildParam.channelId");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(channelId)) {
            IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
            final IGProChannelInfo channelInfo = iGPSService.getChannelInfo(channelId);
            final IGProGuildInfo guildInfo = iGPSService.getGuildInfo(str);
            if (guildInfo != null && channelInfo != null) {
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                c(jumpGuildParam, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.channel.frame.openaction.ChannelAudioOpenAction$doOpenChannel$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Bundle bundle = new Bundle();
                        JumpGuildParam jumpGuildParam2 = jumpGuildParam;
                        ChannelAudioOpenAction channelAudioOpenAction = this;
                        bundle.putInt("load_key_audio_entrance_type", jumpGuildParam2.getChannelLoadFrom());
                        bundle.putAll(channelAudioOpenAction.e(jumpGuildParam2));
                        bundle.putParcelable("GuildAppReportSourceInfo", jumpGuildParam2.getReportSourceInfo());
                        Ref.BooleanRef.this.element = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchMediaChannel(context, guildInfo, channelInfo, bundle);
                    }
                });
                return booleanRef.element;
            }
            com.tencent.mobileqq.guild.util.qqui.g.b(R.string.f156611ko);
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("launchAudioChannel: guild info or channel info is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildAudioOpenAction", 1, (String) it.next(), null);
            }
            return false;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar2 = new Logger.b();
        bVar2.a().add("handleAction: guildId or channelId is null");
        Iterator<T> it5 = bVar2.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("Guild.jump.GuildAudioOpenAction", 1, (String) it5.next(), null);
        }
        return false;
    }

    @NotNull
    public Bundle e(@NotNull JumpGuildParam jumpGuildParam) {
        return i.a.a(this, jumpGuildParam);
    }
}
