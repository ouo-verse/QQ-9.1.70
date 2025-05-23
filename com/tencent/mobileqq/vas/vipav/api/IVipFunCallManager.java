package com.tencent.mobileqq.vas.vipav.api;

import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vip.k;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IVipFunCallManager extends IVasManager {
    boolean downloadFCSuit(int i3, int i16, boolean z16, int i17, k kVar);

    void setFunCallData(AppRuntime appRuntime, int i3, String str, int i16, int i17, List<Long> list, long j3);

    void startDownload(int i3, int i16, boolean z16, int i17);
}
