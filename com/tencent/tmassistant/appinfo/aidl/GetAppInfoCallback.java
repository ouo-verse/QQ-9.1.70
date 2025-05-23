package com.tencent.tmassistant.appinfo.aidl;

import com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class GetAppInfoCallback extends IGetAppInfoCallback.Stub {
    public abstract void onGetAppInfoResponse(int i3, int i16, List<AppDetail> list);
}
