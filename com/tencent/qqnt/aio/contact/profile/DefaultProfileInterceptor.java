package com.tencent.qqnt.aio.contact.profile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/DefaultProfileInterceptor;", "Lcom/tencent/qqnt/aio/contact/profile/f;", "", "peerUid", "peerUin", "Lkotlin/Function1;", "", "callback", "f", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "info", "e", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class DefaultProfileInterceptor implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/DefaultProfileInterceptor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.contact.profile.DefaultProfileInterceptor$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DefaultProfileInterceptor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String e(TroopMemberInfo info, String peerUin) {
        String str;
        if (info != null) {
            str = info.troopnick;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            String H = ac.H((QQAppInterface) peekAppRuntime, peerUin);
            Intrinsics.checkNotNullExpressionValue(H, "getFriendShowName(app, peerUin)");
            return H;
        }
        return str;
    }

    private final void f(String peerUid, final String peerUin, final Function1<? super String, Unit> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        w msgService = ((IKernelService) ((QQAppInterface) peekAppRuntime).getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            return;
        }
        msgService.getTempChatInfo(100, peerUid, new IGetTempChatInfoCallback() { // from class: com.tencent.qqnt.aio.contact.profile.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
            public final void onResult(int i3, String str, TempChatInfo tempChatInfo) {
                DefaultProfileInterceptor.g(peerUin, callback, this, i3, str, tempChatInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final String peerUin, final Function1 callback, final DefaultProfileInterceptor this$0, int i3, String str, final TempChatInfo tmpChatInfo) {
        Intrinsics.checkNotNullParameter(peerUin, "$peerUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tmpChatInfo, "tmpChatInfo");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.contact.profile.c
            @Override // java.lang.Runnable
            public final void run() {
                DefaultProfileInterceptor.h(TempChatInfo.this, peerUin, callback, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TempChatInfo tmpChatInfo, final String peerUin, final Function1 callback, final DefaultProfileInterceptor this$0) {
        Intrinsics.checkNotNullParameter(tmpChatInfo, "$tmpChatInfo");
        Intrinsics.checkNotNullParameter(peerUin, "$peerUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ITroopMemberInfoService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfoAsync(tmpChatInfo.groupCode, peerUin, "DefaultProfileInterceptor", new ITroopMemberInfoService.a() { // from class: com.tencent.qqnt.aio.contact.profile.d
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
            public final void a(TroopMemberInfo troopMemberInfo) {
                DefaultProfileInterceptor.i(Function1.this, this$0, peerUin, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 callback, DefaultProfileInterceptor this$0, String peerUin, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(peerUin, "$peerUin");
        callback.invoke(this$0.e(troopMemberInfo, peerUin));
    }

    @Override // com.tencent.qqnt.aio.contact.profile.f
    public boolean a(@NotNull final Context context, @NotNull AIOMsgItem msgItem) {
        QQAppInterface qQAppInterface;
        AllInOne a16;
        final AllInOne allInOne;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        AppRuntime peekAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return true;
        }
        boolean isSelf = msgItem.isSelf();
        String valueOf = String.valueOf(msgItem.getMsgRecord().senderUin);
        String valueOf2 = String.valueOf(msgItem.getMsgRecord().peerUin);
        String str = msgItem.getMsgRecord().peerName;
        int i3 = msgItem.getMsgRecord().chatType;
        if (TextUtils.isEmpty(valueOf)) {
            return true;
        }
        if (isSelf) {
            allInOne = new AllInOne(qQAppInterface.getCurrentAccountUin(), 0);
            allInOne.nickname = qQAppInterface.getCurrentNickname();
        } else if (com.tencent.qqnt.contact.friends.b.f355778a.c(valueOf, "DefaultProfileInterceptor")) {
            if (i3 == 2) {
                allInOne = new AllInOne(valueOf, 20);
            } else if (i3 == 2) {
                allInOne = new AllInOne(valueOf, 45);
            } else {
                allInOne = new AllInOne(valueOf, 1);
            }
            allInOne.nickname = ac.G(qQAppInterface, valueOf);
        } else {
            if (i3 == 111) {
                a16 = i.a(qQAppInterface, valueOf2, i3, msgItem.getMsgRecord().sendNickName, msgItem.r0());
                Intrinsics.checkNotNullExpressionValue(a16, "{\n                    Ne\u2026PeerId)\n                }");
            } else {
                a16 = i.a(qQAppInterface, valueOf2, i3, str, valueOf);
                Intrinsics.checkNotNullExpressionValue(a16, "{\n                    Ne\u2026derUin)\n                }");
            }
            allInOne = a16;
        }
        allInOne.preWinUin = valueOf2;
        allInOne.preWinType = i3;
        if (i3 == 2) {
            allInOne.troopUin = valueOf2;
            allInOne.troopCode = valueOf2;
        }
        allInOne.lastActivity = 2;
        allInOne.uid = msgItem.getMsgRecord().senderUid;
        if (i3 == 100) {
            String str2 = msgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.peerUid");
            f(str2, valueOf2, new Function1<String, Unit>(context) { // from class: com.tencent.qqnt.aio.contact.profile.DefaultProfileInterceptor$intercept$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AllInOne.this, (Object) context);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                    invoke2(str3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String nick) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) nick);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(nick, "nick");
                    AllInOne allInOne2 = AllInOne.this;
                    allInOne2.nickname = nick;
                    ProfileUtils.openProfileCard(this.$context, allInOne2);
                }
            });
        } else {
            ProfileUtils.openProfileCard(context, allInOne);
        }
        return true;
    }
}
