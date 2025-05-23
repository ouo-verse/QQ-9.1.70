package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H&J\u001c\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0012\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u000bH&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/IExpandSPUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "canPopDialog", "", "popStateName", "", "getGreetLimitCode", "", "uin", "getGreetLimitString", "getGreetLimitTime", "", "setExtendFriendsConfigTaskId", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "setGreetLimit", "code", "tips", "setUserCategoryPullTime", "time", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IExpandSPUtils extends QRouteApi {
    boolean canPopDialog(@Nullable String popStateName);

    int getGreetLimitCode(@NotNull String uin);

    @Nullable
    String getGreetLimitString(@NotNull String uin);

    long getGreetLimitTime(@NotNull String uin);

    void setExtendFriendsConfigTaskId(@Nullable String uin, @Nullable String taskId);

    void setGreetLimit(@NotNull String uin, int code, @Nullable String tips);

    void setUserCategoryPullTime(@Nullable String uin, long time);
}
