package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0015J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u001e\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u000f\u001a\u00020\u000eH&J*\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0012H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIONickIconServiceApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "memberUin", "Lcom/tencent/qqnt/aio/adapter/api/IAIONickIconServiceApi$b;", "callback", "", "getTmInfoIconDataAsync", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "getStaticIconDataList", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/c;", "getIdentityDataFromCacheOrFetchAsync", "", "isGlobalSwitchOpen", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "openTroopIdentityWearPage", "b", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIONickIconServiceApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(IAIONickIconServiceApi iAIONickIconServiceApi, Context context, String str, String str2, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    bundle = new Bundle();
                }
                iAIONickIconServiceApi.openTroopIdentityWearPage(context, str, str2, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openTroopIdentityWearPage");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIONickIconServiceApi$b;", "", "", "fetchedFromLruCache", "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/blockgroup/b;", "nickIconData", "", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface b {
        void a(boolean fetchedFromLruCache, @NotNull List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> nickIconData);
    }

    @Nullable
    com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.c getIdentityDataFromCacheOrFetchAsync(@Nullable String troopUin, @Nullable String memberUin);

    @NotNull
    List<com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.b> getStaticIconDataList();

    void getTmInfoIconDataAsync(@NotNull String troopUin, @NotNull String memberUin, @NotNull b callback);

    boolean isGlobalSwitchOpen();

    void openTroopIdentityWearPage(@NotNull Context context, @NotNull String troopUin, @NotNull String memberUin, @NotNull Bundle bundle);
}
