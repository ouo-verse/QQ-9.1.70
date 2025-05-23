package com.tencent.mobileqq.troop.troopmemberlevel.level;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberLevelService;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.nick.f;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.n;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmemberlevel/level/b;", "Lcom/tencent/qqnt/aio/msg/b;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "Lcom/tencent/qqnt/aio/nick/f;", "c", "", "troopUin", "memberUin", "memberLevelInfo", "", "e", "", "getBusinessType", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "groupsNotFound", "b", "Ljava/lang/Object;", "placeHolder", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements com.tencent.qqnt.aio.msg.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Object> groupsNotFound;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object placeHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmemberlevel/level/b$a;", "", "", "INVALID_VALUE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopmemberlevel.level.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.groupsNotFound = new ConcurrentHashMap<>();
            this.placeHolder = new Object();
        }
    }

    private final f c(TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        int[] iArr;
        com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(troopInfo, troopMemberInfo);
        if (troopMemberRankItem != null) {
            int i3 = troopMemberRankItem.f300590a;
            int i16 = troopMemberRankItem.f300591b;
            String str = troopMemberRankItem.f300592c;
            Intrinsics.checkNotNullExpressionValue(str, "troopRankItem.rankTitle");
            int[] iArr2 = troopMemberRankItem.f300593d;
            if (iArr2 == null) {
                iArr2 = new int[0];
            }
            int[] iArr3 = iArr2;
            int[] iArr4 = troopMemberRankItem.f300594e;
            if (iArr4 == null) {
                iArr = new int[0];
            } else {
                iArr = iArr4;
            }
            return new f(i3, i16, str, iArr3, iArr, troopMemberRankItem.f300595f, troopMemberRankItem.f300596g, troopMemberRankItem.f300597h, troopMemberRankItem.f300598i, troopMemberRankItem.f300599j);
        }
        return new f(-1, -1, "", new int[0], new int[0], false, false, -1, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0, String troopUin, String memberUin, TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
        if (troopMemberInfo != null) {
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            this$0.e(troopUin, memberUin, this$0.c(troopInfo, troopMemberInfo));
        }
    }

    private final void e(String troopUin, String memberUin, f memberLevelInfo) {
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new n(troopUin, memberUin, memberLevelInfo.f(), memberLevelInfo.i(), memberLevelInfo.h(), memberLevelInfo.e(), memberLevelInfo.b(), memberLevelInfo.l(), memberLevelInfo.m(), memberLevelInfo.g(), memberLevelInfo.c(), memberLevelInfo.j()));
    }

    @Override // com.tencent.qqnt.aio.msg.b
    public void a(@NotNull AIOMsgItem msgItem) {
        AppRuntime peekAppRuntime;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().chatType != 2 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        final String troopUin = msgItem.getMsgRecord().peerUid;
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        boolean z17 = !this.groupsNotFound.contains(troopUin);
        final TroopInfo findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(troopUin, false, z17);
        if (findTroopInfo == null) {
            if (z17) {
                ConcurrentHashMap<String, Object> concurrentHashMap = this.groupsNotFound;
                Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                concurrentHashMap.put(troopUin, this.placeHolder);
                QLog.e("TroopMemberLevelMsgProcessor", 1, "cannot find troopUin=" + troopUin + " in DB");
                return;
            }
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopMemberLevelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        ITroopMemberLevelService iTroopMemberLevelService = (ITroopMemberLevelService) runtimeService;
        iTroopMemberLevelService.checkNeedRefreshAIOWhenProcessMsg();
        boolean isAllowDisplayInAIO = iTroopMemberLevelService.isAllowDisplayInAIO(peekAppRuntime, findTroopInfo, msgItem);
        long j3 = msgItem.getMsgRecord().senderUin;
        if (isAllowDisplayInAIO && j3 != 0) {
            final String valueOf = String.valueOf(j3);
            TroopMemberInfo troopMemberFromCacheOrFetchAsync = ((ITroopMemberInfoService) peekAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberFromCacheOrFetchAsync(troopUin, valueOf, "TroopMemberLevelMsgProcessor", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troop.troopmemberlevel.level.a
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                public final void a(TroopMemberInfo troopMemberInfo) {
                    b.d(b.this, troopUin, valueOf, findTroopInfo, troopMemberInfo);
                }
            });
            if (troopMemberFromCacheOrFetchAsync != null) {
                msgItem.v1(c(findTroopInfo, troopMemberFromCacheOrFetchAsync));
                return;
            }
            return;
        }
        msgItem.v1(c(findTroopInfo, null));
    }

    @Override // com.tencent.qqnt.aio.msg.b
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 3;
    }
}
