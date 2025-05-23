package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/api/IGroupTabService;", "Lmqq/app/api/IRuntimeService;", "getGroupTabInfoByUin", "", "groupCode", "", "tabKey", "onLogin", "", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public interface IGroupTabService extends IRuntimeService {
    @Nullable
    String getGroupTabInfoByUin(long groupCode, @NotNull String tabKey);

    void onLogin();
}
