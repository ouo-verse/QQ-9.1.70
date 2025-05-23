package com.tencent.mobileqq.vas.troop.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.mobileqq.vas.troop.api.ITroopGameInfo;
import com.tencent.mobileqq.vas.troop.api.impl.TroopGameInfoImpl;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/api/impl/TroopGameInfoImpl;", "Lcom/tencent/mobileqq/vas/troop/api/ITroopGameInfo;", "()V", "dataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/vas/troop/api/ITroopGameInfo$GameInfo;", "toggleCache", "", "fetchCardInfo", "", "uin", "callback", "Lcom/tencent/mobileqq/vas/troop/api/ITroopGameInfo$ResultCallback;", "getGameInfo", "troopUin", "needSave", "info", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class TroopGameInfoImpl implements ITroopGameInfo {

    @NotNull
    private final ConcurrentHashMap<String, ITroopGameInfo.GameInfo> dataCache = new ConcurrentHashMap<>();

    @NotNull
    private final ConcurrentHashMap<String, Boolean> toggleCache = new ConcurrentHashMap<>();

    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.Object] */
    private final void fetchCardInfo(final String uin, final ITroopGameInfo.ResultCallback callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopGameCardService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        MemberGradeLevelInfo tryGetMemberGradeLevelInfo = ((ITroopGameCardService) runtimeService).tryGetMemberGradeLevelInfo(uin, new ITroopGameCardService.a() { // from class: m33.b
            @Override // com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService.a
            public final void onResult(Object obj) {
                TroopGameInfoImpl.fetchCardInfo$lambda$2(TroopGameInfoImpl.this, objectRef, uin, callback, obj);
            }
        });
        if (tryGetMemberGradeLevelInfo == null) {
            ?? r56 = this.dataCache.get(uin);
            objectRef.element = r56;
            if (r56 != 0) {
                callback.onGetSync((ITroopGameInfo.GameInfo) r56);
                return;
            } else {
                callback.onGetSync(new ITroopGameInfo.GameInfo(0, true));
                return;
            }
        }
        callback.onGetSync(new ITroopGameInfo.GameInfo(tryGetMemberGradeLevelInfo.gradeLevel, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchCardInfo$lambda$2(TroopGameInfoImpl this$0, Ref.ObjectRef cacheInfo, String uin, ITroopGameInfo.ResultCallback callback, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cacheInfo, "$cacheInfo");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (obj instanceof MemberGradeLevelInfo) {
            ITroopGameInfo.GameInfo gameInfo = new ITroopGameInfo.GameInfo(((MemberGradeLevelInfo) obj).gradeLevel, true);
            if (this$0.needSave(gameInfo)) {
                if (!Intrinsics.areEqual(gameInfo, cacheInfo.element)) {
                    this$0.dataCache.put(uin, gameInfo);
                }
            } else if (cacheInfo.element != 0) {
                this$0.dataCache.remove(uin);
            }
            callback.onGetASync(gameInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGameInfo$lambda$0(TroopGameInfoImpl this$0, String uin, ITroopGameInfo.ResultCallback callback, Ref.ObjectRef cacheToggle, String troopUin, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(cacheToggle, "$cacheToggle");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        if (z16 && z17) {
            this$0.fetchCardInfo(uin, callback);
            T t16 = cacheToggle.element;
            Boolean bool = Boolean.TRUE;
            if (!Intrinsics.areEqual(t16, bool)) {
                this$0.toggleCache.put(troopUin, bool);
                return;
            }
            return;
        }
        if (cacheToggle.element != 0) {
            this$0.toggleCache.remove(troopUin);
        }
    }

    private final boolean needSave(ITroopGameInfo.GameInfo info) {
        return info.getGameCardSwitch();
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [T, java.lang.Object] */
    @Override // com.tencent.mobileqq.vas.troop.api.ITroopGameInfo
    public void getGameInfo(@NotNull final String troopUin, @NotNull final String uin, @NotNull final ITroopGameInfo.ResultCallback callback) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        boolean[] checkShowMsgGameGradeLevel = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).checkShowMsgGameGradeLevel(troopUin, uin, new ITroopGameCardUtilsApi.a() { // from class: m33.a
            @Override // com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi.a
            public final void a(boolean z16, boolean z17) {
                TroopGameInfoImpl.getGameInfo$lambda$0(TroopGameInfoImpl.this, uin, callback, objectRef, troopUin, z16, z17);
            }
        });
        if (checkShowMsgGameGradeLevel == null) {
            ?? r102 = this.toggleCache.get(troopUin);
            objectRef.element = r102;
            Boolean bool = (Boolean) r102;
            if (bool != null && bool.booleanValue()) {
                fetchCardInfo(uin, callback);
                return;
            }
            return;
        }
        if (checkShowMsgGameGradeLevel[0] && checkShowMsgGameGradeLevel[1]) {
            fetchCardInfo(uin, callback);
        }
    }
}
