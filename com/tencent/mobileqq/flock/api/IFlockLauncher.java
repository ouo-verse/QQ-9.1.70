package com.tencent.mobileqq.flock.api;

import android.content.Context;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001JP\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H&J&\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0016\u001a\u00020\u0015H&J<\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0019j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u001aH&J(\u0010 \u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u000bH&J)\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0004\b\"\u0010#\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/flock/api/IFlockLauncher;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "userId", "feedId", "", WadlProxyConsts.CREATE_TIME, "troopId", "eUid", "", "subSourceId", "sourceEntranceType", "", "launchFeedDetailPage", "launchFlockDebugPage", "launchGroupFeedListPage", "", "Ly45/b;", "feedDatas", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "scene", "launchSearchRecomFeedListPage", "actionName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "launchFlockBySchemeAction", "feed", "Lcom/tencent/mobileqq/flock/api/a;", "callback", "addFlockAndJoinTroop", "from", "launchFlockPublishPage", "(Landroid/content/Context;ILjava/lang/Long;)V", "qq-flock-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFlockLauncher extends QRouteApi {
    void addFlockAndJoinTroop(@NotNull Context context, @NotNull b feed, @NotNull a callback, int subSourceId);

    void launchFeedDetailPage(@NotNull Context context, @Nullable String userId, @NotNull String feedId, long createTime, long troopId, @Nullable String eUid, int subSourceId, int sourceEntranceType);

    void launchFlockBySchemeAction(@NotNull Context context, @NotNull String actionName, @NotNull HashMap<String, String> params);

    void launchFlockDebugPage(@NotNull Context context);

    void launchFlockPublishPage(@NotNull Context context, int from, @Nullable Long troopId);

    void launchGroupFeedListPage(@NotNull Context context, long troopId);

    void launchSearchRecomFeedListPage(@NotNull Context context, @NotNull List<b> feedDatas, @NotNull FlockConstants$FlockListScene scene);
}
