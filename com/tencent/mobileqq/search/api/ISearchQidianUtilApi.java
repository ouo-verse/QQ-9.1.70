package com.tencent.mobileqq.search.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/api/ISearchQidianUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addShowUin", "", "app", "Lcom/tencent/common/app/AppInterface;", "uin", "", "showUin", "isCrmMaster", "", AppConstants.Key.CSPECIAL_FLAG, "", "isQidianMaster", "updateQidianAccountType", "qqsearch-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchQidianUtilApi extends QRouteApi {
    void addShowUin(@Nullable AppInterface app, @Nullable String uin, @Nullable String showUin);

    boolean isCrmMaster(int cSpecialFlag);

    boolean isQidianMaster(int cSpecialFlag);

    void updateQidianAccountType(@NotNull AppInterface app, int cSpecialFlag, @NotNull String uin);
}
