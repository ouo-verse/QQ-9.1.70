package com.tencent.mobileqq.vas.comm.api.impl;

import com.tencent.mobileqq.vas.comm.api.INotifySettingApi;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NotifySettingApiImpl implements INotifySettingApi {
    @Override // com.tencent.mobileqq.vas.comm.api.INotifySettingApi
    public boolean bShowSubItemList(int i3) {
        if (i3 == 3) {
            return true;
        }
        return false;
    }
}
