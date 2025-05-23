package com.tencent.mobileqq.search.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchBindView extends QRouteApi {
    public static final String GUILD_SEARCH_ITEM_BOOLEAN_SHOW_GUILD = "guild_search_item_boolean_show_guild";
    public static final String GUILD_SEARCH_ITEM_INT_FROM_TYPE = "guild_search_item_int_from_type";

    void bindNetSearchGameView(Object obj, Object obj2);

    void bindNetSearchGuildItemView(Object obj, Object obj2, Bundle bundle);
}
