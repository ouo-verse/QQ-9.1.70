package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ai;", "", "", "shouldCheckFloat", "", "stopZPlanService", "startZPlanService", "Lcom/tencent/mobileqq/zootopia/ipc/c;", "callback", "isEngineReady", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZootopiaServiceManagerImpl.class)
/* loaded from: classes35.dex */
public interface ai {
    void isEngineReady(c callback);

    void startZPlanService();

    void stopZPlanService(boolean shouldCheckFloat);
}
