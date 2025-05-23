package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaN2LManagerImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/z;", "", AdMetricTag.EVENT_NAME, "param", "", "callN2L", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaN2LManagerImpl implements z {
    public static final String TAG = "ZootopiaN2LManagerImpl";

    @Override // com.tencent.mobileqq.zootopia.ipc.z
    public void callN2L(String eventName, String param) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.i(TAG, 1, "callN2L :: eventName == " + eventName + " , param == " + param);
        com.tencent.mobileqq.zootopia.lua.ar.f328509a.a(eventName, param);
    }
}
