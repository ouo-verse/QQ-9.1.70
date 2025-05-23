package l70;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StBarrage;
import l70.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends b<FeedCloudMeta$StBarrage> {
    public c(com.tencent.rfw.barrage.core.c cVar) {
        super(cVar);
    }

    @Override // l70.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.tencent.rfw.barrage.data.a a(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, int i3) {
        com.tencent.rfw.barrage.data.a aVar;
        if (feedCloudMeta$StBarrage != null && feedCloudMeta$StBarrage.feedPlayTime != null) {
            if (this.f413904a == null) {
                QLog.d("QDM-QFSFakeBarrageRenderDataConvert", 1, "[buildSingleBarrageRenderNone] barrage factory should not be null.");
                return null;
            }
            boolean isQQSVipUser = QCirclePluginUtil.isQQSVipUser(QCirclePluginGlobalInfo.m());
            m70.a aVar2 = new m70.a();
            aVar2.d(feedCloudMeta$StBarrage);
            aVar2.f(isQQSVipUser);
            try {
                aVar = this.f413904a.a(-2147483647, aVar2);
            } catch (Throwable th5) {
                QLog.e("QDM-QFSFakeBarrageRenderDataConvert", 1, "error: ", th5.getMessage());
                aVar = null;
            }
            if (aVar == null) {
                QLog.d("QDM-QFSFakeBarrageRenderDataConvert", 1, "[buildSingleBarrageRenderNone] barrage factory should not be null.");
                return null;
            }
            a.f(new a.C10708a().c(aVar).d(i3).e(this.f413905b), true);
            return aVar;
        }
        QLog.d("QDM-QFSFakeBarrageRenderDataConvert", 1, "[buildSingleBarrageRenderNone] barrage is null or barrage play time is null.");
        return null;
    }
}
