package com.tencent.guild.aio.msglist.markdown.innerkeyboard;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IGuildInnerKeyboardApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ6\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002JT\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u000f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002JF\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u000f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J>\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\u000f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\f\u0010\u0016\u001a\u00020\u0011*\u00020\rH\u0002JN\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u000f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/innerkeyboard/g;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/a;", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "ctx", "", "hasPermission", "Lkotlin/Function0;", "", "onPermissionGranted", "onPermissionDenied", "c", "Lmqq/app/AppRuntime;", "app", "payload", "", "", "roleIds", "g", "e", "f", "i", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/c;", "btnPermissionRequired", "d", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.a<com.tencent.guild.aio.msglist.markdown.inlineboard.a, GuildMsgItem> {
    private final void c(com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, boolean hasPermission, Function0<Unit> onPermissionGranted, Function0<Unit> onPermissionDenied) {
        if (hasPermission) {
            onPermissionGranted.invoke();
        } else if (onPermissionDenied != null) {
            onPermissionDenied.invoke();
        }
    }

    private final void e(com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, AppRuntime app, GuildMsgItem payload, Function0<Unit> onPermissionGranted, Function0<Unit> onPermissionDenied) {
        String str;
        boolean z16;
        boolean z17;
        MsgRecord msgRecord;
        if (payload != null && (msgRecord = payload.getMsgRecord()) != null) {
            str = msgRecord.guildId;
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        IGProGuildInfo guildInfo = ((IGPSService) app.getRuntimeService(IGPSService.class, "")).getGuildInfo(str);
        boolean z18 = true;
        if (guildInfo != null && guildInfo.getUserType() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (guildInfo != null && guildInfo.getUserType() == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z18 = false;
            }
        }
        c(ctx, z18, onPermissionGranted, onPermissionDenied);
    }

    private final void f(com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, GuildMsgItem payload, Function0<Unit> onPermissionGranted, Function0<Unit> onPermissionDenied) {
        String str;
        MsgRecord msgRecord;
        MsgRecord msgRecord2;
        String str2 = null;
        if (payload != null && (msgRecord2 = payload.getMsgRecord()) != null) {
            str = msgRecord2.guildId;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (payload != null && (msgRecord = payload.getMsgRecord()) != null) {
            str2 = msgRecord.channelId;
        }
        if (str2 == null) {
            str2 = "";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(str);
        if (guildInfo != null && iGPSService.isGuest(guildInfo) && !guildInfo.isInteractiveForVisitor()) {
            fq0.a.f400309a.l(str, str2, (JumpGuildParam.JoinInfoParam) ctx.getExtras().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM), (GuildAppReportSourceInfo) ctx.getExtras().getParcelable("GuildAppReportSourceInfo"));
            if (onPermissionDenied != null) {
                onPermissionDenied.invoke();
                return;
            }
            return;
        }
        onPermissionGranted.invoke();
    }

    private final void g(final com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, AppRuntime app, GuildMsgItem payload, List<String> roleIds, final Function0<Unit> onPermissionGranted, final Function0<Unit> onPermissionDenied) {
        if (payload == null) {
            return;
        }
        IGuildInnerKeyboardApi iGuildInnerKeyboardApi = (IGuildInnerKeyboardApi) QRoute.api(IGuildInnerKeyboardApi.class);
        String str = payload.getMsgRecord().guildId;
        String str2 = payload.getMsgRecord().channelId;
        String i3 = i(app);
        Object[] array = roleIds.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        iGuildInnerKeyboardApi.permissionRole(str, str2, i3, (String[]) array, new vw1.b() { // from class: com.tencent.guild.aio.msglist.markdown.innerkeyboard.f
            @Override // vw1.b
            public final void a(boolean z16) {
                g.h(g.this, ctx, onPermissionGranted, onPermissionDenied, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(g this$0, com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, Function0 onPermissionGranted, Function0 function0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ctx, "$ctx");
        Intrinsics.checkNotNullParameter(onPermissionGranted, "$onPermissionGranted");
        this$0.c(ctx, z16, onPermissionGranted, function0);
    }

    private final String i(AppRuntime appRuntime) {
        String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        Intrinsics.checkNotNullExpressionValue(selfTinyId, "getRuntimeService(IGPSSe\u2026Constant.MAIN).selfTinyId");
        return selfTinyId;
    }

    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull com.tencent.guild.aio.msglist.markdown.inlineboard.a ctx, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.c btnPermissionRequired, @Nullable GuildMsgItem payload, @NotNull Function0<Unit> onPermissionGranted, @Nullable Function0<Unit> onPermissionDenied) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        Intrinsics.checkNotNullParameter(btnPermissionRequired, "btnPermissionRequired");
        Intrinsics.checkNotNullParameter(onPermissionGranted, "onPermissionGranted");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        int b16 = btnPermissionRequired.b();
        if (b16 != 0) {
            if (b16 != 1) {
                if (b16 != 3) {
                    f(ctx, payload, onPermissionGranted, onPermissionDenied);
                    return;
                } else {
                    g(ctx, peekAppRuntime, payload, btnPermissionRequired.a(), onPermissionGranted, onPermissionDenied);
                    return;
                }
            }
            e(ctx, peekAppRuntime, payload, onPermissionGranted, onPermissionDenied);
            return;
        }
        c(ctx, btnPermissionRequired.c().contains(i(peekAppRuntime)), onPermissionGranted, onPermissionDenied);
    }
}
