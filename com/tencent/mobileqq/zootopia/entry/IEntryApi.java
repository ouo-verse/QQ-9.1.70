package com.tencent.mobileqq.zootopia.entry;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J.\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J0\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH&J$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\"\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J$\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J4\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00132\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&JP\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00072\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010$H&J$\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J2\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\tH&J$\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\"\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020\tH&J$\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010,\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\"\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J$\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\"\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/zootopia/entry/IEntryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "startAIGCCreationPage", "", "context", "Landroid/content/Context;", "from", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "bundle", "Landroid/os/Bundle;", "startAigcPreviewActivity", "source", "localUgcPaths", "", "startAvatarOutfitFragment", "startAvatarSubSceneFragment", "startBrandListFragment", "startCloudModFragment", "mapId", "", "pageBundle", "ueBundle", "startCommonCardFeedsFragment", "startCreateRoleFragment", "startDetailFragment", "startDownloadManagerFragment", "startDressDetailFragment", "startFriendListFragment", "uin", "tabType", "startFriendsDressUpFragment", "startMap", "ueParams", "", "", "callback", "Lkotlin/Function1;", "startMapListFragment", "startMapWithDetail", "startPortalActivity", "startProfileCustomerFragment", "startSameStyleFragment", "params", "startSeparateSceneFragment", "startSimpleAvatarFragment", "startSuitCustomColorFragment", "startTaskSystemFragment", "startThirdPage", "startUEWithHippyFragment", "startUserCenterFragment", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IEntryApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(IEntryApi iEntryApi, Context context, ZootopiaSource zootopiaSource, String str, int i3, Bundle bundle, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    bundle = null;
                }
                iEntryApi.startFriendListFragment(context, zootopiaSource, str, i3, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startFriendListFragment");
        }

        public static /* synthetic */ void b(IEntryApi iEntryApi, Context context, int i3, ZootopiaSource zootopiaSource, Map map, Function1 function1, int i16, Object obj) {
            Map map2;
            Function1 function12;
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    map2 = null;
                } else {
                    map2 = map;
                }
                if ((i16 & 16) != 0) {
                    function12 = null;
                } else {
                    function12 = function1;
                }
                iEntryApi.startMap(context, i3, zootopiaSource, map2, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startMap");
        }

        public static /* synthetic */ void c(IEntryApi iEntryApi, Context context, ZootopiaSource zootopiaSource, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bundle = null;
                }
                iEntryApi.startMapListFragment(context, zootopiaSource, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startMapListFragment");
        }

        public static /* synthetic */ void d(IEntryApi iEntryApi, Context context, ZootopiaSource zootopiaSource, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bundle = null;
                }
                iEntryApi.startPortalActivity(context, zootopiaSource, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startPortalActivity");
        }
    }

    void startAIGCCreationPage(@NotNull Context context, @NotNull ZootopiaSource from, @NotNull Bundle bundle);

    void startAigcPreviewActivity(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle, @Nullable String localUgcPaths);

    void startAvatarOutfitFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startAvatarSubSceneFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startBrandListFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startCloudModFragment(@NotNull Context context, @NotNull ZootopiaSource source, int mapId, @NotNull Bundle pageBundle, @NotNull Bundle ueBundle);

    void startCommonCardFeedsFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startCreateRoleFragment(@NotNull Context context, @NotNull ZootopiaSource from, @NotNull Bundle bundle);

    void startDetailFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startDownloadManagerFragment(@NotNull Context context, @NotNull ZootopiaSource from, @Nullable Bundle bundle);

    void startDressDetailFragment(@NotNull Context context, @NotNull ZootopiaSource from, @Nullable Bundle bundle);

    void startFriendListFragment(@NotNull Context context, @NotNull ZootopiaSource source, @NotNull String uin, int tabType, @Nullable Bundle bundle);

    void startFriendsDressUpFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startMap(@NotNull Context context, int mapId, @NotNull ZootopiaSource source, @Nullable Map<String, ? extends Object> ueParams, @Nullable Function1<? super Integer, Unit> callback);

    void startMapListFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startMapWithDetail(@NotNull Context context, int mapId, @NotNull ZootopiaSource source, @NotNull Bundle pageBundle, @Nullable Bundle ueBundle);

    void startPortalActivity(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startProfileCustomerFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startSameStyleFragment(@NotNull Context context, @NotNull ZootopiaSource source, @NotNull Bundle params);

    void startSeparateSceneFragment(@NotNull Context context, @NotNull ZootopiaSource from, @Nullable Bundle bundle);

    void startSimpleAvatarFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startSuitCustomColorFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startTaskSystemFragment(@NotNull Context context, @NotNull ZootopiaSource from, @Nullable Bundle bundle);

    void startThirdPage(@NotNull Context context, @NotNull ZootopiaSource from, @NotNull Bundle bundle);

    void startUEWithHippyFragment(@NotNull Context context, @NotNull ZootopiaSource source, @Nullable Bundle bundle);

    void startUserCenterFragment(@NotNull Context context, @NotNull ZootopiaSource source, @NotNull Bundle bundle);
}
