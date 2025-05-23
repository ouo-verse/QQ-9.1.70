package com.tencent.qzonehub.api.impl;

import com.qzone.feed.ui.navigationbar.QZoneUpdateGalleryEntranceRedPointEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qzonehub.api.IQZoneGetQFSRedPointInfoApi;

/* loaded from: classes34.dex */
public class QZoneGetQFSRedPointInfoApiImpl implements IQZoneGetQFSRedPointInfoApi {
    private static final String TAG = "QZoneGetQFSRedPointInfoApiImpl";

    @Override // com.tencent.qzonehub.api.IQZoneGetQFSRedPointInfoApi
    public void updateQFSGalleryRedPointInfo(int i3, int i16) {
        try {
            SimpleEventBus.getInstance().dispatchEvent(new QZoneUpdateGalleryEntranceRedPointEvent(i3, i16), true);
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, "QZoneGetQFSRedPointInfoApiImpl exception is " + e16);
        }
    }
}
