package com.tencent.qqguild.directmessage.service;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.msg.data.FeedsBoxEvent;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0004H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqguild/directmessage/service/IFeedBoxSummaryService;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/qqguild/directmessage/service/IFeedBoxSummaryService$a;", "listener", "", "registerSummaryUpdateListener", "unregisterSummaryUpdateListener", "markRead", "Lcom/tencent/qqnt/msg/data/FeedsBoxEvent;", "latestSummary", "", "switchType", "updateRedPointStatus", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface IFeedBoxSummaryService extends IRuntimeService {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqguild/directmessage/service/IFeedBoxSummaryService$a;", "", "Lcom/tencent/qqnt/msg/data/FeedsBoxEvent;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface a {
        void a(@NotNull FeedsBoxEvent event);
    }

    @Nullable
    FeedsBoxEvent latestSummary();

    void markRead();

    void registerSummaryUpdateListener(@NotNull a listener);

    void unregisterSummaryUpdateListener(@NotNull a listener);

    void updateRedPointStatus(int switchType);
}
