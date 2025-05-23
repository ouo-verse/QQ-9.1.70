package o50;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QFSLayerFloatShowEvent;
import com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import p40.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends u {

    /* renamed from: d, reason: collision with root package name */
    private QCircleInitBean f422077d;

    /* renamed from: e, reason: collision with root package name */
    private FeedCloudMeta$StFeed f422078e;

    public a(QCircleInitBean qCircleInitBean) {
        this.f422077d = qCircleInitBean;
    }

    private boolean A9() {
        return TextUtils.equals(x9(), QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE);
    }

    private String x9() {
        QCircleReportBean fromReportBean;
        QCircleInitBean qCircleInitBean = this.f422077d;
        if (qCircleInitBean == null) {
            fromReportBean = null;
        } else {
            fromReportBean = qCircleInitBean.getFromReportBean();
        }
        if (fromReportBean == null) {
            return null;
        }
        return fromReportBean.getDtPageId();
    }

    private FeedCloudMeta$StFeed z9() {
        QFSLayerPageFragment E9;
        Part part;
        Part part2 = getPartManager().getPart(b.class.getName());
        if (!(part2 instanceof b) || (E9 = ((b) part2).E9()) == null) {
            return null;
        }
        PartManager partManager = E9.getPartManager();
        if (partManager == null) {
            part = null;
        } else {
            part = partManager.getPart(z40.b.class.getName());
        }
        if (!(part instanceof z40.b)) {
            return null;
        }
        z40.b bVar = (z40.b) part;
        e30.b bVar2 = (e30.b) RFSafeListUtils.get(bVar.getFeedList(), bVar.G9());
        if (bVar2 == null) {
            return null;
        }
        return bVar2.g();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (o.d(QCirclePluginUtil.getQCircleInitBean(getContext())) && uq3.o.g()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSLayerFloatShowEvent(QFSLayerFloatShowEvent.EVENT_TYPE_AUTO_TRIGGER));
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        QLog.d("QFSLayerAutoTriggerFloatingPart", 1, "[onPartCreate] part create...");
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QLog.d("QFSLayerAutoTriggerFloatingPart", 1, "[onPartDestroy] part destroy...");
        this.f422078e = null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        String str;
        QCircleInitBean qCircleInitBean;
        super.onPartPause(activity);
        if (A9()) {
            this.f422078e = z9();
        }
        if (this.f422078e == null && (qCircleInitBean = this.f422077d) != null) {
            this.f422078e = qCircleInitBean.getFeed();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onPartPause] feed: ");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f422078e;
        if (feedCloudMeta$StFeed == null) {
            str = "null";
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        sb5.append(str);
        QLog.d("QFSLayerAutoTriggerFloatingPart", 1, sb5.toString());
    }
}
