package com.tencent.qqnt.troopmemberlist;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J6\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&J6\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&JF\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&JF\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&JF\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&J@\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0014H&J@\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0014H&J:\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0014H&J0\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H&J6\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\u001d\u001a\u00020\u001cH&JQ\u0010$\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001f\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001ej\u0004\u0018\u0001`#H&J[\u0010$\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001f\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001ej\u0004\u0018\u0001`#H&J2\u0010&\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H'J:\u0010&\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H'J2\u0010)\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H'JN\u0010.\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u00022:\u0010\n\u001a6\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0+j\u0002`-H&JN\u00101\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022:\u0010\n\u001a6\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000b0+j\u0002`0H&J^\u0010.\u001a\u00020\u000b2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2F\u0010\n\u001aB\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(,\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000203\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u000b0+j\u0002`5H&J^\u00101\u001a\u00020\u000b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2F\u0010\n\u001aB\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(,\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000203\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u000b0+j\u0002`8H&J:\u00109\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010:\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010;\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010<\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/ITroopMemberListRepoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "forceNet", "from", "Lcom/tencent/qqnt/troopmemberlist/f;", "callback", "", "fetchTroopMemberList", "fetchTroopMemberListWithExtInfo", "", SquareJSConst.Params.PARAMS_UIN_LIST, "fetchTroopMemberUinListInfo", "preLoadTroopMemberUinListInfo", "fetchTroopMemberUinListInfoWithExtInfo", "uin", "Lcom/tencent/qqnt/troopmemberlist/g;", "fetchTroopMemberInfo", "fetchTroopMemberInfoWithExtInfo", "memberUin", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "getTroopMemberFromCacheOrFetchAsync", "getTroopMemberFromCache", "fetchGagTroopMemberInfo", "", "getTroopMemberInfoDBVersion", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "Lkotlin/ParameterName;", "name", "nickInfo", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberNameCallback;", "fetchTroopMemberName", "lifecycleOwner", "getTroopMemberInfoSync", "", "timeoutMs", "getTroopMemberWithExtInfoSync", "memberUid", "Lkotlin/Function2;", "isSuccess", "Lcom/tencent/qqnt/troopmemberlist/FetchSingleTroopMemberUinCallback;", "fetchTroopMemberUin", "uid", "Lcom/tencent/qqnt/troopmemberlist/FetchSingleTroopMemberUidCallback;", "fetchTroopMemberUid", "memberUidList", "", "uid2UinMap", "Lcom/tencent/qqnt/troopmemberlist/FetchMultiTroopMemberUinCallback;", "memberUinList", "uin2UidMap", "Lcom/tencent/qqnt/troopmemberlist/FetchMultiTroopMemberUidCallback;", "getTroopMemberWithExtFromCacheOrFetchAsync", "isTroopMemberInfoDBInited", "isTroopMemberListExpired", "updateMemberDBVersionAfterNetRsp", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ITroopMemberListRepoApi extends QRouteApi {
    void fetchGagTroopMemberInfo(@Nullable String troopUin, @Nullable LifecycleOwner owner, boolean forceNet, @NotNull String from, @Nullable f callback);

    void fetchTroopMemberInfo(@Nullable String troopUin, @Nullable String uin, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback);

    void fetchTroopMemberInfoWithExtInfo(@Nullable String troopUin, @Nullable String uin, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback);

    void fetchTroopMemberList(@Nullable String troopUin, @Nullable LifecycleOwner owner, boolean forceNet, @NotNull String from, @Nullable f callback);

    void fetchTroopMemberListWithExtInfo(@Nullable String troopUin, @Nullable LifecycleOwner owner, boolean forceNet, @NotNull String from, @Nullable f callback);

    void fetchTroopMemberName(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner lifecycleOwner, @NotNull String from, @Nullable Function1<? super TroopMemberNickInfo, Unit> callback);

    void fetchTroopMemberName(@Nullable String troopUin, @Nullable String memberUin, @NotNull String from, @Nullable Function1<? super TroopMemberNickInfo, Unit> callback);

    void fetchTroopMemberUid(@Nullable String memberUin, @NotNull Function2<? super Boolean, ? super String, Unit> callback);

    void fetchTroopMemberUid(@NotNull List<String> memberUinList, @NotNull Function2<? super Boolean, ? super Map<String, String>, Unit> callback);

    void fetchTroopMemberUin(@Nullable String memberUid, @NotNull Function2<? super Boolean, ? super String, Unit> callback);

    void fetchTroopMemberUin(@NotNull List<String> memberUidList, @NotNull Function2<? super Boolean, ? super Map<String, String>, Unit> callback);

    void fetchTroopMemberUinListInfo(@Nullable String troopUin, @Nullable List<String> uinList, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable f callback);

    void fetchTroopMemberUinListInfoWithExtInfo(@Nullable String troopUin, @Nullable List<String> uinList, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable f callback);

    @Nullable
    TroopMemberInfo getTroopMemberFromCache(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from);

    @Nullable
    TroopMemberInfo getTroopMemberFromCacheOrFetchAsync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback);

    int getTroopMemberInfoDBVersion();

    @Deprecated(message = "\u517c\u5bb9\u65e7\u903b\u8f91\uff0c\u8fc7\u6e21\u7528\uff0c\u65b0\u903b\u8f91\u4e0d\u8981\u4f7f\u7528")
    @Nullable
    TroopMemberInfo getTroopMemberInfoSync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from);

    @Deprecated(message = "\u517c\u5bb9\u65e7\u903b\u8f91\uff0c\u8fc7\u6e21\u7528\uff0c\u65b0\u903b\u8f91\u4e0d\u8981\u4f7f\u7528")
    @Nullable
    TroopMemberInfo getTroopMemberInfoSync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from, long timeoutMs);

    @Nullable
    TroopMemberInfo getTroopMemberWithExtFromCacheOrFetchAsync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable g callback);

    @Deprecated(message = "\u517c\u5bb9\u65e7\u903b\u8f91\uff0c\u8fc7\u6e21\u7528\uff0c\u65b0\u903b\u8f91\u4e0d\u8981\u4f7f\u7528")
    @Nullable
    TroopMemberInfo getTroopMemberWithExtInfoSync(@Nullable String troopUin, @Nullable String memberUin, @Nullable LifecycleOwner owner, @NotNull String from);

    boolean isTroopMemberInfoDBInited(@NotNull String troopUin);

    boolean isTroopMemberListExpired(@Nullable String troopUin);

    void preLoadTroopMemberUinListInfo(@Nullable String troopUin, @Nullable List<String> uinList, boolean forceNet, @Nullable LifecycleOwner owner, @NotNull String from, @Nullable f callback);

    void updateMemberDBVersionAfterNetRsp(@NotNull String troopUin);
}
