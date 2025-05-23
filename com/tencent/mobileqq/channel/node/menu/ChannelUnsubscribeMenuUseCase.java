package com.tencent.mobileqq.channel.node.menu;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.GuildChatUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.meun.a;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cc;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/channel/node/menu/ChannelUnsubscribeMenuUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "sendCancelSubScribeReqToSvr", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a$a;", "params", "", "interestedIn", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "invoke", "", "getProcessType", "()I", "processType", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "Companion", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ChannelUnsubscribeMenuUseCase extends com.tencent.qqnt.chats.main.vm.usecase.meun.a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "ChannelUnsubscribeMenuUseCase";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/channel/node/menu/ChannelUnsubscribeMenuUseCase$Companion;", "", "()V", "TAG", "", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22811);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelUnsubscribeMenuUseCase(@NotNull IRecentContactRepo repo) {
        super(repo);
        Intrinsics.checkNotNullParameter(repo, "repo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) repo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3$lambda$2$lambda$1(ChannelUnsubscribeMenuUseCase this$0, Context context, g chatItem, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(chatItem, "$chatItem");
        this$0.sendCancelSubScribeReqToSvr(context, chatItem);
    }

    private final void sendCancelSubScribeReqToSvr(final Context context, g item) {
        boolean z16;
        AppRuntime peekAppRuntime;
        boolean z17;
        final GuildContactInfo guildContactInfo = item.s().guildContactInfo;
        if (guildContactInfo != null) {
            String str = guildContactInfo.guildId;
            boolean z18 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str2 = guildContactInfo.channelId;
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    z18 = true;
                }
            }
            IRuntimeService iRuntimeService = null;
            if (!z18) {
                guildContactInfo = null;
            }
            if (guildContactInfo != null) {
                QLog.i(TAG, 1, "sendCancelSubScribeReqToSvr channelId = " + guildContactInfo.channelId);
                GuildChatUtils guildChatUtils = GuildChatUtils.f213838a;
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                    iRuntimeService = peekAppRuntime.getRuntimeService(IGPSService.class, "");
                }
                IGPSService iGPSService = (IGPSService) iRuntimeService;
                if (iGPSService != null) {
                    String str3 = guildContactInfo.guildId;
                    Intrinsics.checkNotNullExpressionValue(str3, "contactInfo.guildId");
                    String str4 = guildContactInfo.channelId;
                    Intrinsics.checkNotNullExpressionValue(str4, "contactInfo.channelId");
                    iGPSService.setQQMsgListChannel(str3, str4, 2, new cc() { // from class: com.tencent.mobileqq.channel.node.menu.c
                        @Override // vh2.cc
                        public final void onResult(int i3, String str5) {
                            ChannelUnsubscribeMenuUseCase.sendCancelSubScribeReqToSvr$lambda$7$lambda$6$lambda$5(context, guildContactInfo, i3, str5);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendCancelSubScribeReqToSvr$lambda$7$lambda$6$lambda$5(Context context, GuildContactInfo contactInfo, int i3, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(contactInfo, "$contactInfo");
        if (i3 == 0) {
            QQToast.makeText(context, 2, R.string.f2205369d, 0).show();
            return;
        }
        QLog.i(TAG, 1, "sendCancelSubScribeReqToSvr channelId = " + contactInfo.channelId + " result = " + i3 + " errorMsg = " + str);
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public int getProcessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.z3n;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public boolean interestedIn(@NotNull a.C9600a params) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar == null || gVar.n() != 4) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    @Nullable
    public Flow<com.tencent.qqnt.chats.main.vm.usecase.result.a> invoke(@NotNull a.C9600a params) {
        final g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Flow) iPatchRedirector.redirect((short) 4, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            final Context a16 = params.a();
            if (a16 == null) {
                return FlowKt.flow(new ChannelUnsubscribeMenuUseCase$invoke$1$context$1(null));
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(a16, 230);
            createCustomDialog.setMessage(a16.getString(R.string.f2205469e));
            createCustomDialog.setNegativeButton(a16.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.channel.node.menu.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ChannelUnsubscribeMenuUseCase.invoke$lambda$3$lambda$2$lambda$0(dialogInterface, i3);
                }
            });
            createCustomDialog.setPositiveButton(a16.getString(R.string.f220946_h), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.channel.node.menu.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ChannelUnsubscribeMenuUseCase.invoke$lambda$3$lambda$2$lambda$1(ChannelUnsubscribeMenuUseCase.this, a16, gVar, dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(conte\u2026      }\n                }");
            try {
                createCustomDialog.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return FlowKt.flow(new ChannelUnsubscribeMenuUseCase$invoke$2(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3$lambda$2$lambda$0(DialogInterface dialogInterface, int i3) {
    }
}
