package com.tencent.qqnt.troop;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002H&J\u0016\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\bH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\tH&JU\u0010\u001f\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022)\u0010\u001e\u001a%\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0019j\u0004\u0018\u0001`\u001dH&J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0002H&J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u001a\u0010$\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\"H&J\u001a\u0010%\u001a\u0014\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\"H&J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH&J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\nH&J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\b\u0010+\u001a\u00020\u0002H&J$\u0010.\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u0002H&\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/troop/ITroopListRepoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isTroopListInited", "", "preloadTroopList", "forceNet", "fetchTroopList", "Lfx3/a;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "getTroopListLiveData", "getFetchTroopListResultLiveData", "getTroopListFromCache", "", "troopUin", "getTroopInfoFromCache", "getSortedJoinedTroopInfoFromCache", "getTopTroopListFromCache", "getSortedJoinedTopTroopInfoFromCache", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", IProfileProtocolConst.PARAM_TROOP_CODE, "isTop", "needToast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/qqnt/troop/SetTroopTopCallback;", "callback", "requestSetTroopTop", "fetchTroopLevelInfo", "getJoinedTroopInfoFromCache", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "getTroopListWithMsgMask", "getTroopUinListWithMsgMask", "getTroopUinByTroopCode", "deleteTroopInCache", "troopInfo", "saveTroopInCache", "getSortedJoinedValidTroopInfoFromCache", "isTroopListCacheAllInited", "from", "printLog", "isExit", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ITroopListRepoApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(ITroopListRepoApi iTroopListRepoApi, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                iTroopListRepoApi.fetchTroopList(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchTroopList");
        }

        public static /* synthetic */ boolean b(ITroopListRepoApi iTroopListRepoApi, String str, String str2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = true;
                }
                return iTroopListRepoApi.isExit(str, str2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isExit");
        }
    }

    void deleteTroopInCache(@NotNull String troopUin);

    void fetchTroopLevelInfo(@NotNull String troopUin, boolean forceNet);

    void fetchTroopList(boolean forceNet);

    @NotNull
    fx3.a<Boolean> getFetchTroopListResultLiveData();

    @NotNull
    List<TroopInfo> getJoinedTroopInfoFromCache();

    @NotNull
    List<TroopInfo> getSortedJoinedTopTroopInfoFromCache();

    @NotNull
    List<TroopInfo> getSortedJoinedTroopInfoFromCache();

    @NotNull
    List<TroopInfo> getSortedJoinedValidTroopInfoFromCache();

    @NotNull
    List<TroopInfo> getTopTroopListFromCache();

    @Nullable
    TroopInfo getTroopInfoFromCache(@Nullable String troopUin);

    @NotNull
    List<TroopInfo> getTroopListFromCache();

    @Nullable
    fx3.a<List<TroopInfo>> getTroopListLiveData();

    @NotNull
    Map<GroupMsgMask, List<TroopInfo>> getTroopListWithMsgMask();

    @NotNull
    String getTroopUinByTroopCode(@NotNull String troopCode);

    @NotNull
    Map<GroupMsgMask, List<String>> getTroopUinListWithMsgMask();

    boolean isExit(@Nullable String troopUin, @NotNull String from, boolean printLog);

    boolean isTroopListCacheAllInited();

    boolean isTroopListInited();

    void preloadTroopList();

    void requestSetTroopTop(@Nullable LifecycleOwner lifecycleOwner, @NotNull String troopCode, boolean isTop, boolean needToast, @Nullable Function1<? super Boolean, Unit> callback);

    void saveTroopInCache(@NotNull TroopInfo troopInfo);
}
