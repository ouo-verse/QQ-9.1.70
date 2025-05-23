package com.tencent.mobileqq.vas.pendant.drawable.interfaces;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantEntity;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface LoadFinishCallback {
    void notifyLoadFinish(AppInterface appInterface, boolean z16, List<? extends DiyPendantEntity> list);
}
