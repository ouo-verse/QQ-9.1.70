package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J$\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003H&J,\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/manager/IExpandManagerProxy;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getExpandFriendDataCache", "Lcom/tencent/mobileqq/qqexpand/bean/chat/ExpandFriendData;", "appRuntime", "Lmqq/app/AppRuntime;", "uin", "", "loadDbIfNotExist", "", "getExpandFriendDataSingleAttribute", "", "matchUin", "attributeId", "", "getVoiceMaxDuration", "isResourceReady", "setExpandEntry", "", "updateExpandFriendData", "expandFriendData", "updateExpandFriendDataSingleAttribute", "content", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IExpandManagerProxy extends QRouteApi {
    @Nullable
    ExpandFriendData getExpandFriendDataCache(@NotNull AppRuntime appRuntime, @Nullable String uin, boolean loadDbIfNotExist);

    @Nullable
    Object getExpandFriendDataSingleAttribute(@NotNull AppRuntime appRuntime, @Nullable String matchUin, int attributeId);

    int getVoiceMaxDuration(@NotNull AppRuntime appRuntime);

    boolean isResourceReady(@NotNull AppRuntime appRuntime);

    void setExpandEntry(@NotNull AppRuntime appRuntime);

    void updateExpandFriendData(@NotNull AppRuntime appRuntime, @NotNull ExpandFriendData expandFriendData);

    void updateExpandFriendDataSingleAttribute(@NotNull AppRuntime appRuntime, @Nullable String matchUin, int attributeId, @Nullable Object content);
}
