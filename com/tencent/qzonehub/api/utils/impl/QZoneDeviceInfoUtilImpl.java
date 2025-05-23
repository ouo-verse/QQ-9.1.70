package com.tencent.qzonehub.api.utils.impl;

import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.qzonehub.api.utils.IQZoneDeviceInfoUtil;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QZoneDeviceInfoUtilImpl implements IQZoneDeviceInfoUtil {
    @Override // com.tencent.qzonehub.api.utils.IQZoneDeviceInfoUtil
    public String getDeviceInfo() {
        return QZoneRequest.getDeiviceInfoDetailInner(true);
    }
}
