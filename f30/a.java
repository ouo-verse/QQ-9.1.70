package f30;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StNotice;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    protected Object a(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        try {
            QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData = new QQCircleFeedBase$StNoticeBusiData();
            qQCircleFeedBase$StNoticeBusiData.mergeFrom(feedCloudMeta$StNotice.busiData.get().toByteArray());
            return qQCircleFeedBase$StNoticeBusiData;
        } catch (Exception e16) {
            QLog.e("QFSStNoticeTransformer", 1, "getNoticeBusiData error:", e16);
            return null;
        }
    }

    public void b(b bVar) {
        if (bVar != null && bVar.d() != null) {
            bVar.c("EXTRA_NOTICE_BUSI_DATA", a(bVar.d()));
        }
    }
}
