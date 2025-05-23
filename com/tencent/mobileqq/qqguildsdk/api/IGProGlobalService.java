package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(needUin = false, process = {"all"})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "Lmqq/app/api/IRuntimeService;", "addObserver", "", "observer", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "deleteObserver", "initSdk", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public interface IGProGlobalService extends IRuntimeService {
    void addObserver(@NotNull GPServiceObserver observer);

    void deleteObserver(@NotNull GPServiceObserver observer);

    void initSdk();
}
