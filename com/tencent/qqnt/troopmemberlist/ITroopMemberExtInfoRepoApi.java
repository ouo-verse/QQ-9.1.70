package com.tencent.qqnt.troopmemberlist;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberIllegalInfoResult;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u007f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072a\b\u0002\u0010\b\u001a[\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\u0012H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\\\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072@\u0010\b\u001a<\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0004\u0018\u0001`\u001aH&Jd\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072F\b\u0002\u0010\b\u001a@\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u001c\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0004\u0018\u0001`\u001eH&J\u007f\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072a\b\u0002\u0010\b\u001a[\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\u0012H&Jl\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072@\u0010\b\u001a<\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010#\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0004\u0018\u0001`%H&JQ\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072+\b\u0002\u0010\b\u001a%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0003\u0018\u00010(j\u0004\u0018\u0001`)H&Jj\u0010*\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072L\b\u0002\u0010\b\u001aF\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020+0\u000f\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0004\u0018\u0001`-H&J^\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072@\b\u0002\u0010\b\u001a:\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0004\u0018\u0001`0H&J\u001e\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cH&J\u008a\u0001\u00102\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\u0006\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072L\b\u0002\u0010\b\u001aF\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0004\u0018\u0001`7H&Jr\u00108\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072F\b\u0002\u0010\b\u001a@\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002090\u001c\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0004\u0018\u0001`;H&Jh\u0010<\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072D\u0010\b\u001a@\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u001c\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0004\u0018\u0001`\u001eH&Jd\u0010>\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072F\b\u0002\u0010\b\u001a@\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u001c\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017j\u0004\u0018\u0001`\u001eH&J\u0012\u0010?\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J \u0010@\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010A\u001a\u00020BH&J \u0010C\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0010H&\u00a8\u0006E"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/ITroopMemberExtInfoRepoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "fetchCanTransferTroopMember", "", "troopUin", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", "", "", "uin2flagMap", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberFlagCallback;", "fetchMemberIllegalInfoFromCache", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberIllegalInfoResult;", "fetchNewTroopHeadUinList", "fetchSelfTroopLevelInfo", "Lkotlin/Function2;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "extInfo", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberExtInfoCallback;", "fetchTroopAdmin", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberUinCallback;", "fetchTroopAdminFlagEx", "fetchTroopMemberForBatch", "isMember", "flag", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonListResult;", "memberCommonListResult", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberCommonInfoCallback;", "fetchTroopMemberGameInfo", "memberUin", "Lkotlin/Function1;", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberGameInfoCallback;", "fetchTroopMemberGapInfo", "", "uin2ShuntUpTimeMap", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberGapInfoCallback;", "fetchTroopMemberIllegalUinList", "result", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberIllegalUinCallback;", "fetchTroopMemberNickIconInfo", "fetchTroopMemberNickName", "needRemarkFirst", "extProcessParam", "Landroid/os/Bundle;", "uin2NameMap", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberNickNameCallback;", "fetchTroopMemberSpecialTitle", "Lcom/tencent/mobileqq/data/troop/TroopMemberSpecialTitleInfo;", "titleInfoList", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberSpecialTitleInfoCallback;", "fetchTroopMemberUin", "memberCount", "fetchTroopOwner", "preloadMemberIllegalInfoFromLocal", "updateTroopMemberHonor", "honorInfo", "", "updateTroopMemberSpecialTitle", "titleId", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ITroopMemberExtInfoRepoApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(ITroopMemberExtInfoRepoApi iTroopMemberExtInfoRepoApi, String str, List list, boolean z16, Bundle bundle, LifecycleOwner lifecycleOwner, Function2 function2, int i3, Object obj) {
            LifecycleOwner lifecycleOwner2;
            Function2 function22;
            if (obj == null) {
                if ((i3 & 16) != 0) {
                    lifecycleOwner2 = null;
                } else {
                    lifecycleOwner2 = lifecycleOwner;
                }
                if ((i3 & 32) != 0) {
                    function22 = null;
                } else {
                    function22 = function2;
                }
                iTroopMemberExtInfoRepoApi.fetchTroopMemberNickName(str, list, z16, bundle, lifecycleOwner2, function22);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchTroopMemberNickName");
        }
    }

    void fetchCanTransferTroopMember(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function3<? super Boolean, ? super String, ? super Map<String, Integer>, Unit> callback);

    @Nullable
    GroupMemberIllegalInfoResult fetchMemberIllegalInfoFromCache(@NotNull String troopUin);

    void fetchNewTroopHeadUinList(@NotNull String troopUin);

    void fetchSelfTroopLevelInfo(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super GroupMemberExtListResult, Unit> callback);

    void fetchTroopAdmin(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super List<String>, Unit> callback);

    void fetchTroopAdminFlagEx(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function3<? super Boolean, ? super String, ? super Map<String, Integer>, Unit> callback);

    void fetchTroopMemberForBatch(@NotNull String troopUin, boolean isMember, @NotNull String flag, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super GroupMemberCommonListResult, Unit> callback);

    void fetchTroopMemberGameInfo(@NotNull String troopUin, @NotNull String memberUin, @Nullable LifecycleOwner owner, @Nullable Function1<? super Boolean, Unit> callback);

    void fetchTroopMemberGapInfo(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super Map<String, Long>, Unit> callback);

    void fetchTroopMemberIllegalUinList(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super GroupMemberIllegalInfoResult, Unit> callback);

    void fetchTroopMemberNickIconInfo(@NotNull String troopUin, @NotNull List<String> uinList);

    void fetchTroopMemberNickName(@NotNull String troopUin, @NotNull List<String> uinList, boolean needRemarkFirst, @Nullable Bundle extProcessParam, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super Map<String, String>, Unit> callback);

    void fetchTroopMemberSpecialTitle(@NotNull String troopUin, @NotNull List<String> uinList, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super List<TroopMemberSpecialTitleInfo>, Unit> callback);

    void fetchTroopMemberUin(@NotNull String troopUin, int memberCount, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super List<String>, Unit> callback);

    void fetchTroopOwner(@NotNull String troopUin, @Nullable LifecycleOwner owner, @Nullable Function2<? super Boolean, ? super List<String>, Unit> callback);

    void preloadMemberIllegalInfoFromLocal(@Nullable String troopUin);

    void updateTroopMemberHonor(@NotNull String troopUin, @NotNull String memberUin, @NotNull byte[] honorInfo);

    void updateTroopMemberSpecialTitle(@NotNull String troopUin, @NotNull String memberUin, int titleId);
}
