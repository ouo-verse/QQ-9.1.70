package com.tencent.mobileqq.vas.updatesystem.callback;

import com.tencent.mobileqq.vas.updatesystem.entity.VasUpdateParcelableParams;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IRemoteVasUpdateListener {
    void onLoadFail(VasUpdateParcelableParams vasUpdateParcelableParams);

    void onLoadSuccess(VasUpdateParcelableParams vasUpdateParcelableParams);

    void onProgress(VasUpdateParcelableParams vasUpdateParcelableParams);
}
