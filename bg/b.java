package bg;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.QZoneEmptyItemView;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends nf.a<QZoneEmptyItemView> {
    @Override // nf.a
    public Class<QZoneEmptyItemView> a() {
        return QZoneEmptyItemView.class;
    }

    @Override // nf.a
    public QZoneFeedType b() {
        return QZoneFeedType.UNIQUE_TYPE_UNKNOWN;
    }

    @Override // nf.a
    public boolean c(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getCellSummaryV2() != null) {
            RFWLog.d("QZoneEmptyFeedDetector", RFWLog.USR, "summary: " + businessFeedData.getCellSummaryV2().summary + ", displayStr: " + businessFeedData.getCellSummaryV2().displayStr);
        }
        return true;
    }
}
