package com.tencent.mobileqq.search.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.model.y;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchActivityJumpFetcher extends QRouteApi {
    void jumpToActiveEntitySearchActivity(Context context, String str, String str2, long[] jArr);

    void jumpToContactSearchActivity(Context context, String str, int i3, int i16);

    void jumpToFavoriteSearchActivity(Context context, String str);

    void jumpToFileSearchActivity(Context context, String str, List<y> list, boolean z16, int i3);

    void jumpToFunctionSearchActivity(Context context, String str);

    void jumpToMessageSearchActivity(Context context, String str);

    void jumpToNtContactSearchActivity(Context context, String str, int i3, int i16);

    void jumpToProfileCardActivity(Activity activity, SearchResultItem searchResultItem, AppInterface appInterface, boolean z16, int i3);

    void jumpToPublicAcntSearchActivity(Context context, String str, int i3);

    void jumpToQQBrowserActivity(Context context, Map<String, String> map);

    void jumpToSearchBaseActivity(Context context, String str, int i3);

    void jumpToTroopInfoActivity(Context context, Bundle bundle, int i3);
}
