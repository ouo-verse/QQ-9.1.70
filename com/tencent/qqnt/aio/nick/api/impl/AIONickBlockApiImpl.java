package com.tencent.qqnt.aio.nick.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberLevelService;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.qqnt.aio.nick.api.IAIONickBlockApi;
import com.tencent.qqnt.aio.nick.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0002J*\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/nick/api/impl/AIONickBlockApiImpl;", "Lcom/tencent/qqnt/aio/nick/api/IAIONickBlockApi;", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "Lcom/tencent/qqnt/aio/nick/f;", "getTroopMemberLevel", "", "troopUin", "memberUin", "memberLevelInfo", "", "sendMemberLevelUpdateEvent", "", "gradeLevel", "gameCardId", "gameCardSwitch", "Landroid/graphics/drawable/Drawable;", "getGradeLevelDrawable", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "getMemberLevelInfo", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIONickBlockApiImpl implements IAIONickBlockApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int INVALID_VALUE = -1;

    @NotNull
    private static final String TAG = "AIONickBlockApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/nick/api/impl/AIONickBlockApiImpl$a;", "", "", "INVALID_VALUE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.nick.api.impl.AIONickBlockApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63679);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIONickBlockApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMemberLevelInfo$lambda$0(AIONickBlockApiImpl this$0, AppRuntime app, String troopUin, String memberUin, TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
        if (troopMemberInfo != null) {
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            this$0.sendMemberLevelUpdateEvent(app, troopUin, memberUin, this$0.getTroopMemberLevel(app, troopInfo, troopMemberInfo));
        }
    }

    private final f getTroopMemberLevel(AppRuntime appRuntime, TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        return ((ITroopMemberLevelService) appRuntime.getRuntimeService(ITroopMemberLevelService.class, "")).getTroopMemberLevelForAIO(troopInfo, troopMemberInfo);
    }

    private final void sendMemberLevelUpdateEvent(AppRuntime appRuntime, String troopUin, String memberUin, f memberLevelInfo) {
        ((ITroopMemberLevelService) appRuntime.getRuntimeService(ITroopMemberLevelService.class, "")).sendMemberLevelUpdateEvent(troopUin, memberUin, memberLevelInfo);
    }

    @Override // com.tencent.qqnt.aio.nick.api.IAIONickBlockApi
    @Nullable
    public Drawable getGradeLevelDrawable(@NotNull String memberUin, int gradeLevel, int gameCardId, int gameCardSwitch) {
        AppRuntime peekAppRuntime;
        ITroopGameCardService iTroopGameCardService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, this, memberUin, Integer.valueOf(gradeLevel), Integer.valueOf(gameCardId), Integer.valueOf(gameCardSwitch));
        }
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        if (gameCardSwitch <= 0 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (iTroopGameCardService = (ITroopGameCardService) peekAppRuntime.getRuntimeService(ITroopGameCardService.class, "")) == null) {
            return null;
        }
        return iTroopGameCardService.getDrawableByGameGradeLevel(gradeLevel, null);
    }

    @Override // com.tencent.qqnt.aio.nick.api.IAIONickBlockApi
    @Nullable
    public f getMemberLevelInfo(@NotNull AIOMsgItem msgItem) {
        final AppRuntime peekAppRuntime;
        final String str;
        final TroopInfo findTroopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().chatType != 2 || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo((str = msgItem.getMsgRecord().peerUid))) == null) {
            return null;
        }
        long j3 = msgItem.getMsgRecord().senderUin;
        if (j3 != 0 && ((ITroopMemberLevelService) peekAppRuntime.getRuntimeService(ITroopMemberLevelService.class, "")).isAllowDisplayInAIO(peekAppRuntime, findTroopInfo, msgItem)) {
            final String valueOf = String.valueOf(j3);
            TroopMemberInfo troopMemberFromCacheOrFetchAsync = ((ITroopMemberInfoService) peekAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberFromCacheOrFetchAsync(str, valueOf, "AIONickBlockApiImpl-level", new ITroopMemberInfoService.a() { // from class: com.tencent.qqnt.aio.nick.api.impl.a
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                public final void a(TroopMemberInfo troopMemberInfo) {
                    AIONickBlockApiImpl.getMemberLevelInfo$lambda$0(AIONickBlockApiImpl.this, peekAppRuntime, str, valueOf, findTroopInfo, troopMemberInfo);
                }
            });
            if (troopMemberFromCacheOrFetchAsync == null) {
                return null;
            }
            return getTroopMemberLevel(peekAppRuntime, findTroopInfo, troopMemberFromCacheOrFetchAsync);
        }
        return getTroopMemberLevel(peekAppRuntime, findTroopInfo, null);
    }
}
