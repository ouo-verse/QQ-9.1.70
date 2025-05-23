package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/z;", "", "", AdMetricTag.EVENT_NAME, "param", "", "callN2L", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZootopiaN2LManagerImpl.class)
/* loaded from: classes35.dex */
public interface z {
    void callN2L(String eventName, String param);
}
