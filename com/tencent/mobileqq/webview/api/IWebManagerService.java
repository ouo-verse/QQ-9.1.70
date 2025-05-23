package com.tencent.mobileqq.webview.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.service.profile.a;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/webview/api/IWebManagerService;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/mobileqq/service/profile/a;", "getOfflineCheckUpdateItemInterface", "webview_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface IWebManagerService extends IRuntimeService {
    @NotNull
    a getOfflineCheckUpdateItemInterface();
}
