package com.tencent.mobileqq.troop.troopgame.processor;

import android.graphics.drawable.Drawable;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J:\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J*\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0002J:\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0002J2\u0010\u0019\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/troopgame/processor/d;", "Lcom/tencent/qqnt/aio/msg/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "f", "", "peerUin", AppConstants.Key.COLUMN_MSG_SENDER_UIN, ViewStickEventHelper.IS_SHOW, h.f248218g, "asyncFlag", tl.h.F, "isGameCardOpen", "e", "troopUin", "memberUin", DomainData.DOMAIN_NAME, "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/troop/troopgame/MemberGradeLevelInfo;", "info", "p", "l", "", "gameCardSwitch", "gradeLevel", "gameCardId", "j", "k", "getBusinessType", "a", "Lcom/tencent/qqnt/bus/api/IBusManager;", "Lcom/tencent/qqnt/bus/api/IBusManager;", "mBusApi", "<init>", "()V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d implements com.tencent.qqnt.aio.msg.b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IBusManager mBusApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopgame/processor/d$a;", "", "", "APP_MESSAGE_UIN", "J", "", "NULL", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopgame.processor.d$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62465);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IBusManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IBusManager::class.java)");
        this.mBusApi = (IBusManager) api;
    }

    private final boolean e(boolean isGameCardOpen) {
        return true;
    }

    private final void f(final AIOMsgItem msg2) {
        final String valueOf = String.valueOf(msg2.getMsgRecord().peerUin);
        final String valueOf2 = String.valueOf(msg2.getMsgRecord().senderUin);
        boolean[] checkShowMsgGameGradeLevel = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).checkShowMsgGameGradeLevel(valueOf, valueOf2, new ITroopGameCardUtilsApi.a() { // from class: com.tencent.mobileqq.troop.troopgame.processor.a
            @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi.a
            public final void a(boolean z16, boolean z17) {
                d.g(d.this, msg2, valueOf, valueOf2, z16, z17);
            }
        });
        if (checkShowMsgGameGradeLevel != null) {
            i(this, msg2, valueOf, valueOf2, checkShowMsgGameGradeLevel[0], checkShowMsgGameGradeLevel[1], false, 32, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(d this$0, AIOMsgItem msg2, String peerUin, String senderUin, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(peerUin, "$peerUin");
        Intrinsics.checkNotNullParameter(senderUin, "$senderUin");
        this$0.h(msg2, peerUin, senderUin, z16, z17, true);
    }

    private final void h(AIOMsgItem msg2, String peerUin, String senderUin, boolean isShow, boolean isOpen, boolean asyncFlag) {
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopGameLevelMsgProcessor", 4, "[fetchOrNotifyBaseOnSwitch] troop=" + peerUin + ", sender=" + senderUin + ", isShow=" + isShow + ", isOpen=" + isOpen + " asyncFlag = " + asyncFlag);
        }
        if (!e(isOpen)) {
            l(asyncFlag, peerUin, senderUin, null, msg2);
        } else if (isShow) {
            n(msg2, peerUin, senderUin, asyncFlag);
        } else {
            l(asyncFlag, peerUin, senderUin, null, msg2);
        }
    }

    static /* synthetic */ void i(d dVar, AIOMsgItem aIOMsgItem, String str, String str2, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z18 = false;
        }
        dVar.h(aIOMsgItem, str, str2, z16, z17, z18);
    }

    private final void j(String troopUin, String senderUin, int gameCardSwitch, int gradeLevel, int gameCardId) {
        this.mBusApi.sendEvent(new j(troopUin, senderUin, gradeLevel, gameCardId, gameCardSwitch));
    }

    private final void k(MemberGradeLevelInfo info, AIOMsgItem msg2) {
        boolean z16;
        com.tencent.qqnt.aio.nick.gradelevel.a E = msg2.E();
        boolean z17 = true;
        if (E != null && E.e() == info.gradeLevel) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.qqnt.aio.nick.gradelevel.a E2 = msg2.E();
            if (E2 == null || E2.d() != info.gameCardSwitch) {
                z17 = false;
            }
            if (z17) {
                return;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopGameLevelMsgProcessor", 4, "saveInfoInMsgItem | msgId = " + msg2.getMsgId() + " senderUin=" + msg2.getMsgRecord().senderUin + ", gradeLevel=" + info.gradeLevel);
        }
        msg2.n1(new com.tencent.qqnt.aio.nick.gradelevel.a(info.gradeLevel, info.gameCardId, info.gameCardSwitch));
    }

    private final void l(boolean asyncFlag, String troopUin, String memberUin, MemberGradeLevelInfo info, AIOMsgItem msg2) {
        int i3;
        int i16;
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopGameLevelMsgProcessor", 4, "[saveInfoOrNotifyBaseOnFlag] troopUin = " + troopUin + " memberUin = " + memberUin + " asyncFlag = " + asyncFlag + " info = " + info);
        }
        if (asyncFlag) {
            int i17 = 0;
            if (info != null) {
                i3 = info.gameCardSwitch;
            } else {
                i3 = 0;
            }
            if (info != null) {
                i16 = info.gradeLevel;
            } else {
                i16 = 0;
            }
            if (info != null) {
                i17 = info.gameCardId;
            }
            j(troopUin, memberUin, i3, i16, i17);
            return;
        }
        if (info != null) {
            k(info, msg2);
        } else {
            msg2.n1(null);
        }
    }

    private final boolean m(AIOMsgItem msg2) {
        if (msg2.getMsgRecord().senderUin != 1000000 && msg2.getMsgRecord().chatType == 2 && !com.tencent.mobileqq.aio.utils.d.s(msg2) && !((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(String.valueOf(msg2.getMsgRecord().senderUin)).isWzryVip()) {
            return false;
        }
        return true;
    }

    private final void n(final AIOMsgItem msg2, final String troopUin, final String memberUin, boolean asyncFlag) {
        MemberGradeLevelInfo tryGetMemberGradeLevelInfo;
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (tryGetMemberGradeLevelInfo = ((ITroopGameCardService) peekAppRuntime.getRuntimeService(ITroopGameCardService.class, "")).tryGetMemberGradeLevelInfo(memberUin, new ITroopGameCardService.a() { // from class: com.tencent.mobileqq.troop.troopgame.processor.b
            @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService.a
            public final void onResult(Object obj) {
                d.o(d.this, peekAppRuntime, troopUin, memberUin, msg2, obj);
            }
        })) != null) {
            tryGetMemberGradeLevelInfo.gameCardSwitch = 1;
            p(peekAppRuntime, troopUin, memberUin, tryGetMemberGradeLevelInfo, msg2, asyncFlag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(d this$0, AppRuntime app, String troopUin, String memberUin, AIOMsgItem msg2, Object obj) {
        MemberGradeLevelInfo memberGradeLevelInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        if (obj instanceof MemberGradeLevelInfo) {
            memberGradeLevelInfo = (MemberGradeLevelInfo) obj;
        } else {
            memberGradeLevelInfo = null;
        }
        MemberGradeLevelInfo memberGradeLevelInfo2 = memberGradeLevelInfo;
        if (memberGradeLevelInfo2 != null) {
            memberGradeLevelInfo2.gameCardSwitch = 1;
            this$0.p(app, troopUin, memberUin, memberGradeLevelInfo2, msg2, true);
        }
    }

    private final void p(AppRuntime app, final String troopUin, final String memberUin, final MemberGradeLevelInfo info, AIOMsgItem msg2, boolean asyncFlag) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameLevelMsgProcessor", 2, "tryGetCorrespondingDrawable: troopUin=" + troopUin + ", memberUin=" + memberUin + ", info=" + info + " asyncFlag = " + asyncFlag);
        }
        if (((ITroopGameCardService) app.getRuntimeService(ITroopGameCardService.class, "")).getDrawableByGameGradeLevel(info.gradeLevel, new Consumer() { // from class: com.tencent.mobileqq.troop.troopgame.processor.c
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                d.q(memberUin, info, this, troopUin, (Drawable) obj);
            }
        }) != null) {
            l(asyncFlag, troopUin, memberUin, info, msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String memberUin, MemberGradeLevelInfo info, d this$0, String troopUin, Drawable drawable) {
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        if (drawable == null) {
            QLog.e("TroopGameLevelMsgProcessor", 1, "async get drawable fail |  sender=" + memberUin + " gradeLevel=" + info.gradeLevel);
            return;
        }
        this$0.j(troopUin, memberUin, info.gameCardSwitch, info.gradeLevel, info.gameCardId);
    }

    @Override // com.tencent.qqnt.aio.msg.b
    public void a(@NotNull AIOMsgItem msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopGameLevelMsgProcessor", 4, "processMsg msgId is " + msg2.getMsgId());
        }
        if (!m(msg2)) {
            f(msg2);
        } else {
            msg2.n1(null);
        }
    }

    @Override // com.tencent.qqnt.aio.msg.b
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 4;
    }
}
