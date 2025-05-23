package com.tencent.qqnt.aio.contact.profile;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00052\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/e;", "Lcom/tencent/qqnt/aio/contact/profile/f;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "b", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "a", "", "J", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "lastClickTime", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/contact/profile/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.contact.profile.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63337);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(MsgRecord msgRecord) {
        String str;
        String str2;
        try {
            if (Math.abs(System.currentTimeMillis() - this.lastClickTime) < 500) {
                return;
            }
            this.lastClickTime = System.currentTimeMillis();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGameMsgManagerService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026ava, ProcessConstant.ALL)");
            IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) runtimeService;
            TempChatGameSession gameSessionFromMsg = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromMsg(msgRecord);
            if (gameSessionFromMsg == null) {
                QLog.w("GameMsgProfileIntercept", 1, "GameUsrAvatarClickLis, session is null");
                return;
            }
            if (MsgExtKt.S(msgRecord)) {
                str = gameSessionFromMsg.selfRoleId;
            } else {
                str = gameSessionFromMsg.peerRoleId;
            }
            QLog.i("GameMsgProfileIntercept", 2, "[goToPlayerInfoPage] isSelf:" + MsgExtKt.S(msgRecord) + ",roleId:" + str);
            iGameMsgManagerService.gotoPlayerInfoPage(peekAppRuntime, MobileQQ.sMobileQQ, String.valueOf(gameSessionFromMsg.gameAppId), str);
            IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
            String valueOf = String.valueOf(gameSessionFromMsg.gameAppId);
            if (MsgExtKt.S(msgRecord)) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            iGameMsgHelperApi.reportForGameMsg(valueOf, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "206352", "", "", "20", str2);
        } catch (Throwable th5) {
            QLog.e("GameMsgProfileIntercept", 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.qqnt.aio.contact.profile.f
    public boolean a(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgRecord msgRecord = msgItem.getMsgRecord();
        if (msgRecord.chatType != 105) {
            return false;
        }
        b(msgRecord);
        return true;
    }
}
