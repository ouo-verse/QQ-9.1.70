package com.tencent.mobileqq.matchfriend.reborn.content.signal.api;

import com.tencent.mobileqq.matchfriend.reborn.content.signal.a;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u0007H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/api/IQQStrangerSelfSignalInfoService;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/a;", "listener", "", "addListener", "removeListener", "", "loadCacheFirst", "refreshSelfSignalInfo", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "signalInfo", "justNowPublish", "upsetSelfSignalInfo", "getSelfSignalInfoCache", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface IQQStrangerSelfSignalInfoService extends IRuntimeService {
    void addListener(@NotNull a listener);

    @Nullable
    SignalPlazaSvrPB$SignalInfo getSelfSignalInfoCache();

    void refreshSelfSignalInfo(boolean loadCacheFirst);

    void removeListener(@NotNull a listener);

    void upsetSelfSignalInfo(@Nullable SignalPlazaSvrPB$SignalInfo signalInfo, boolean justNowPublish);
}
