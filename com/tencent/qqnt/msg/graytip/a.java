package com.tencent.qqnt.msg.graytip;

import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.matchfriend.graytips.handler.InteractiveMarkActionHandler;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.troop.essence.api.ITroopEssenceMsgApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanClassObjectFactory;
import com.tencent.qqnt.graytips.d;
import java.util.Map;
import jv.e;
import jv.g;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0002H\u0016J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002H\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0002H\u0016R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/msg/graytip/a;", "Lcom/tencent/qqnt/graytips/d;", "", "", "Ljava/lang/Class;", "Lcom/tencent/qqnt/graytips/handler/b;", "a", "", "Lcom/tencent/qqnt/graytips/handler/c;", "b", "c", "Lcom/tencent/qqnt/msg/graytip/ntactionhandler/troop/b;", "Ljava/util/Map;", "mNtServerHandlerMap", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, com.tencent.qqnt.msg.graytip.ntactionhandler.troop.b> mNtServerHandlerMap;

    public a() {
        Map<Long, com.tencent.qqnt.msg.graytip.ntactionhandler.troop.b> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(2407L, new com.tencent.qqnt.msg.graytip.ntactionhandler.troop.b()));
            this.mNtServerHandlerMap = mapOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.graytips.d
    @NotNull
    public Map<Integer, Class<? extends com.tencent.qqnt.graytips.handler.b>> a() {
        Map<Integer, Class<? extends com.tencent.qqnt.graytips.handler.b>> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(58, com.tencent.mobileqq.troop.essencemsg.graytip.a.class), TuplesKt.to(75, com.tencent.mobileqq.troop.essencemsg.graytip.b.class), TuplesKt.to(95, ((ITroopEssenceMsgApi) QRoute.api(ITroopEssenceMsgApi.class)).getEssenceMsgHandlerClz()), TuplesKt.to(59, ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).getListenTogetherActionHandler()), TuplesKt.to(81, jv.c.class), TuplesKt.to(83, e.class), TuplesKt.to(89, g.class), TuplesKt.to(71, ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).getZPlanOpenPanelHandlerClass()), TuplesKt.to(76, ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).getZPlanCreateRoleHandlerClass()), TuplesKt.to(56, b.class), TuplesKt.to(68, ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGrayTipsJumpSettingHandlerClz()), TuplesKt.to(69, ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGrayTipsAddFriendHandlerClz()), TuplesKt.to(87, com.tencent.mobileqq.managers.PushNotification.c.class), TuplesKt.to(88, ((IZPlanClassObjectFactory) QRoute.api(IZPlanClassObjectFactory.class)).getZPlanAIOOpenGuideClass()), TuplesKt.to(92, ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getSpecialCareGrayTipActionHandler()), TuplesKt.to(94, com.tencent.mobileqq.matchfriend.graytips.handler.a.class), TuplesKt.to(96, com.tencent.mobileqq.matchfriend.graytips.handler.b.class), TuplesKt.to(97, InteractiveMarkActionHandler.class), TuplesKt.to(98, va2.a.class), TuplesKt.to(99, com.tencent.mobileqq.troop.flame.api.impl.a.class), TuplesKt.to(72, com.tencent.mobileqq.troop.icebreak.graytip.handler.a.class));
            return mapOf;
        }
        return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.qqnt.graytips.d
    @Nullable
    public Map<Long, com.tencent.qqnt.graytips.handler.c> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mNtServerHandlerMap;
    }

    @Override // com.tencent.qqnt.graytips.d
    @NotNull
    public Map<Long, com.tencent.qqnt.graytips.handler.c> c() {
        Map<Long, com.tencent.qqnt.graytips.handler.c> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(81L, ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).getGrayTipActionHandler()));
            return mapOf;
        }
        return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
    }
}
