package com.tencent.mobileqq.login.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import e72.c;
import e72.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000e\u001a\u00020\fH&J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/login/api/IUidService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "initUid", "", "getCurrentUid", "uin", "getUid", "", "timeout", "Le72/c;", "callback", "", "requestUid", "logoutWhenReqUidFail", "Le72/d;", "registerUidCallback", "unregisterUidCallback", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IUidService extends QRouteApi {
    @Nullable
    String getCurrentUid();

    @Nullable
    String getUid(@NotNull String uin);

    boolean initUid();

    void logoutWhenReqUidFail();

    void registerUidCallback(@Nullable d callback);

    void requestUid(@NotNull String uin, int timeout, @Nullable c callback);

    void unregisterUidCallback(@Nullable d callback);
}
