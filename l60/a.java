package l60;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.immersive.events.QFSPersonalUserMedalRefreshEvent;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSRankTagListView;
import com.tencent.biz.qqcircle.manager.QCircleRankListManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StMedalInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends o30.a implements QFSRankTagListView.a, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private QFSRankTagListView f413876d;

    /* renamed from: e, reason: collision with root package name */
    private Context f413877e;

    /* renamed from: f, reason: collision with root package name */
    private w f413878f;

    private List<FeedCloudMeta$StMedalInfo> b(List<QCircleRankListManager.UserMedalBean> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (QCircleRankListManager.UserMedalBean userMedalBean : list) {
                FeedCloudMeta$StMedalInfo feedCloudMeta$StMedalInfo = new FeedCloudMeta$StMedalInfo();
                feedCloudMeta$StMedalInfo.type.set(userMedalBean.type);
                feedCloudMeta$StMedalInfo.jumpUrl.set(userMedalBean.jumpUrl);
                feedCloudMeta$StMedalInfo.iconUrl.set(userMedalBean.iconUrl);
                feedCloudMeta$StMedalInfo.medalName.set(userMedalBean.medalName);
                feedCloudMeta$StMedalInfo.backgroundUrl.set(userMedalBean.backgroundUrl);
                feedCloudMeta$StMedalInfo.describe.set(userMedalBean.describe);
                feedCloudMeta$StMedalInfo.isHighLight.set(userMedalBean.isHighLight);
                feedCloudMeta$StMedalInfo.isNew.set(userMedalBean.isNew);
                feedCloudMeta$StMedalInfo.medalID.set(userMedalBean.medalID);
                feedCloudMeta$StMedalInfo.rank.set(userMedalBean.rank);
                arrayList.add(feedCloudMeta$StMedalInfo);
            }
            return arrayList;
        }
        QLog.d("QFSPersonRankListControl", 1, "[convertMedalInfoList] list not is empty.");
        return null;
    }

    private void c(String str) {
        int size;
        if (this.f413876d == null) {
            QLog.d("QFSPersonRankListControl", 1, "[handlerRankListBroadcastReceiverMsg] rank tag list view should not be null.");
            return;
        }
        List<QCircleRankListManager.UserMedalBean> parseUserMedalSource = QCircleRankListManager.parseUserMedalSource(str);
        if (parseUserMedalSource == null) {
            size = 0;
        } else {
            size = parseUserMedalSource.size();
        }
        QLog.d("QFSPersonRankListControl", 1, "[handlerRankListBroadcastReceiverMsg] json: ", str, " | bean list size: ", Integer.valueOf(size));
        this.f413878f.W(b(parseUserMedalSource));
        this.f413878f.R();
    }

    private void e() {
        QFSRankTagListView qFSRankTagListView = this.f413876d;
        if (qFSRankTagListView == null) {
            QLog.d("QFSPersonRankListControl", 1, "[updateRankListViewInfo] rank tag list view should not be null..");
        } else {
            qFSRankTagListView.setOnQFSRankTagListActionListener(this);
            this.f413876d.setData(this.f413878f);
        }
    }

    public void a(w wVar) {
        boolean z16;
        if (wVar == null) {
            QLog.d("QFSPersonRankListControl", 1, "[bindDataSource] bind data source is null.");
            QFSRankTagListView qFSRankTagListView = this.f413876d;
            if (qFSRankTagListView != null) {
                qFSRankTagListView.setVisibility(8);
                return;
            }
            return;
        }
        this.f413878f = wVar;
        if (!wVar.z() && !this.f413878f.b().medalWall.needShowEntrance.get()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.d("QFSPersonRankListControl", 1, "[bindData] current server obtain no show entrance.");
        } else {
            e();
        }
    }

    public void d(Context context, View view) {
        this.f413877e = context;
        this.f413876d = (QFSRankTagListView) view.findViewById(R.id.f5147287);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPersonalUserMedalRefreshEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPersonalUserMedalRefreshEvent) {
            c(((QFSPersonalUserMedalRefreshEvent) simpleBaseEvent).getJson());
        }
    }
}
