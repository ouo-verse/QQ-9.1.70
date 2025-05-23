package com.tencent.mobileqq.addfriend.handler.receiver;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.handler.NTDelFriendHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.delfriend.api.INTDelFriendRspDeal;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/receiver/e;", "Lcom/tencent/mobileqq/addfriend/handler/receiver/a;", "Lcom/tencent/mobileqq/addfriend/handler/NTDelFriendHandler;", "", "b", "Lcom/tencent/qqnt/remote/d;", "toNTMsg", "Lcom/tencent/qqnt/remote/b;", "fromNTMsg", "", "d", "Lcom/tencent/common/app/AppInterface;", "appRuntime", "handler", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/addfriend/handler/NTDelFriendHandler;)V", "c", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e extends a<NTDelFriendHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/receiver/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.handler.receiver.e$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull AppInterface appRuntime, @NotNull NTDelFriendHandler handler) {
        super(appRuntime, handler);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(handler, "handler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(BaseApplication baseApplication) {
        QQToast.makeText(baseApplication, 2, baseApplication.getString(R.string.ajl), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(BaseApplication baseApplication) {
        QQToast.makeText(baseApplication, 2, baseApplication.getString(R.string.ajl), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(BaseApplication baseApplication) {
        QQToast.makeText(baseApplication, 2, baseApplication.getString(R.string.ajm), 0).show();
    }

    @Override // com.tencent.mobileqq.addfriend.handler.receiver.a
    @NotNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.addfriend.api.a.INSTANCE.e();
    }

    @Override // com.tencent.mobileqq.addfriend.handler.receiver.a
    public void d(@NotNull com.tencent.qqnt.remote.d toNTMsg, @NotNull com.tencent.qqnt.remote.b fromNTMsg) {
        AppRuntime peekAppRuntime;
        IPhoneContactService iPhoneContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toNTMsg, (Object) fromNTMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(toNTMsg, "toNTMsg");
        Intrinsics.checkNotNullParameter(fromNTMsg, "fromNTMsg");
        final BaseApplication context = BaseApplication.getContext();
        if (fromNTMsg.b() != com.tencent.mobileqq.addfriend.api.a.INSTANCE.j()) {
            c().notifyUI(15, false, null);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.addfriend.handler.receiver.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.h(BaseApplication.this);
                }
            });
            return;
        }
        String string = toNTMsg.a().getString("uid");
        if (string == null) {
            string = "";
        }
        if (StringUtil.isEmpty(string)) {
            QLog.e("NTDelFriendReceiver", 1, "receive fail, delUid is empty");
            c().notifyUI(15, false, null);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.addfriend.handler.receiver.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.i(BaseApplication.this);
                }
            });
            return;
        }
        String delUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(string);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null && (iPhoneContactService = (IPhoneContactService) peekAppRuntime.getRuntimeService(IPhoneContactService.class, "")) != null) {
            iPhoneContactService.onFriendListChanged();
        }
        INTDelFriendRspDeal iNTDelFriendRspDeal = (INTDelFriendRspDeal) QRoute.api(INTDelFriendRspDeal.class);
        Intrinsics.checkNotNullExpressionValue(delUin, "delUin");
        iNTDelFriendRspDeal.onIceBreakingDelFrd(delUin);
        ((INTDelFriendRspDeal) QRoute.api(INTDelFriendRspDeal.class)).onTofuDelFriend(delUin);
        ((INTDelFriendRspDeal) QRoute.api(INTDelFriendRspDeal.class)).onNearByDelFriend(delUin);
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).deleteNTFriendSimpleInfo(string, "", null);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.addfriend.handler.receiver.d
            @Override // java.lang.Runnable
            public final void run() {
                e.j(BaseApplication.this);
            }
        });
        NTDelFriendHandler c16 = c();
        if (c16 != null) {
            c16.notifyUI(15, true, delUin);
        }
    }
}
