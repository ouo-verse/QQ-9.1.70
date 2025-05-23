package com.tencent.qzonehub.api.impl;

import android.content.Intent;
import com.tencent.qzonehub.api.IQZoneEventHandlerProxy;
import cooperation.qzone.util.QZLog;

/* loaded from: classes34.dex */
public class QZoneEventHandlerProxyImpl implements IQZoneEventHandlerProxy {
    private static final String TAG = "QZoneEventHandler";

    @Override // com.tencent.qzonehub.api.IQZoneEventHandlerProxy
    public boolean handleActivityEvent(Object obj, int i3, int i16, Intent intent) {
        QZLog.i(TAG, "handleActivityEvent: " + i3 + " " + i16);
        switch (i3) {
            case 1205:
            case 1206:
            case 1207:
            case 1208:
                return true;
            default:
                return false;
        }
    }
}
