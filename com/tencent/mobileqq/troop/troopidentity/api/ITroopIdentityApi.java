package com.tencent.mobileqq.troop.troopidentity.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J*\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\"\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0012H&J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J=\u0010\u001d\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2)\u0010\u001c\u001a%\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018j\u0004\u0018\u0001`\u001bH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/api/ITroopIdentityApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "memberUin", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;", "getIdentityDataFromCacheOrFetchAsync", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "openTroopIdentityWearPage", "Ljava/lang/Class;", "", "getJumpParser", "appIconBindData", "sendAppIconBindDataUpdateEvent", "", "newSwitchStatus", "onGetGlobalSwitch", "getGlobalSwitch", "Lorg/json/JSONObject;", "getCachedIdentityTitleInfo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/mobileqq/troop/troopidentity/api/TroopMemberRankTitleCallback;", "callback", "getTroopMemberRankTitleForWeb", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopIdentityApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class a {
        public static /* synthetic */ void a(ITroopIdentityApi iTroopIdentityApi, Context context, String str, String str2, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    bundle = new Bundle();
                }
                iTroopIdentityApi.openTroopIdentityWearPage(context, str, str2, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openTroopIdentityWearPage");
        }
    }

    @NotNull
    JSONObject getCachedIdentityTitleInfo(@NotNull String troopUin, @NotNull String memberUin);

    boolean getGlobalSwitch();

    @Nullable
    c getIdentityDataFromCacheOrFetchAsync(@Nullable String troopUin, @Nullable String memberUin);

    @NotNull
    Class<Object> getJumpParser();

    void getTroopMemberRankTitleForWeb(@Nullable Bundle bundle, @Nullable Function1<? super Bundle, Unit> callback);

    void onGetGlobalSwitch(boolean newSwitchStatus);

    void openTroopIdentityWearPage(@NotNull Context context, @NotNull String troopUin, @NotNull String memberUin, @NotNull Bundle bundle);

    void sendAppIconBindDataUpdateEvent(@NotNull String troopUin, @NotNull String memberUin, @Nullable c appIconBindData);
}
