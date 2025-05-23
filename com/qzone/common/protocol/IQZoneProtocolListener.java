package com.qzone.common.protocol;

import com.qq.jce.wup.UniAttribute;
import com.qzone.publish.business.process.base.QZoneProcessType;

/* loaded from: classes39.dex */
public interface IQZoneProtocolListener {
    void onProtocolResponse(UniAttribute uniAttribute, int i3, int i16, String str, boolean z16);

    void onProtocolResponse(QZoneProcessType qZoneProcessType, UniAttribute uniAttribute, int i3, int i16, String str, boolean z16);
}
