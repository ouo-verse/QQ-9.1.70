package com.tencent.mobileqq.config.impl;

import com.tencent.mobileqq.config.IQZoneConfigApi;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QZoneConfigApiImpl implements IQZoneConfigApi {
    @Override // com.tencent.mobileqq.config.IQZoneConfigApi
    public int getConfig(String str, String str2, int i3) {
        return QzoneConfig.getInstance().getConfig(str, str2, i3);
    }
}
