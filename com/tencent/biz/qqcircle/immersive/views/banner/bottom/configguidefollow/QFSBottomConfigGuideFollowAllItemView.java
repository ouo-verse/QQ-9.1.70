package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.o;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleMultiFollowUpdateEvent;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomConfigGuideFollowAllItemView extends QCircleBaseWidgetView<d> implements View.OnClickListener, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarListView f90620d;

    /* renamed from: e, reason: collision with root package name */
    private Button f90621e;

    /* renamed from: f, reason: collision with root package name */
    private int f90622f;

    /* renamed from: h, reason: collision with root package name */
    private e30.b f90623h;

    /* renamed from: i, reason: collision with root package name */
    private List<FeedCloudMeta$StUser> f90624i;

    public QFSBottomConfigGuideFollowAllItemView(@NonNull @NotNull Context context) {
        super(context);
        SimpleEventBus.getInstance().registerReceiver(this);
        o0();
    }

    private void l0() {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_SHOW_STYLE, IndividuationUrlHelper.UrlId.CARD_HOME);
        e30.b bVar = this.f90623h;
        if (bVar != null && bVar.g() != null) {
            buildElementParams.put("xsj_feed_id", this.f90623h.g().f398449id.get());
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_QQ_GROUP, r.M(this.f90624i));
        if (r.k0(this.f90624i)) {
            str = QCircleDaTongConstant.ElementParamValue.FOLLOWED;
        } else {
            str = "total";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, str);
        buildElementParams.put("xsj_item_index", Integer.valueOf(this.f90622f + 1));
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementId(this.f90621e, QCircleDaTongConstant.ElementId.EM_XSJ_TOTAL_FOLLOW_GUIDE_BUTTON);
        VideoReport.setElementParams(this.f90621e, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.f90621e, String.valueOf(this.f90622f));
    }

    private void m0(int i3) {
        String str;
        for (FeedCloudMeta$StUser feedCloudMeta$StUser : this.f90624i) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
            dataBuilder.setActionType(80).setSubActionType(i3).setPosition(this.f90622f).setExt2(feedCloudMeta$StUser.f398463id.get()).setPageId(getPageId()).setFirstFeedId(w20.a.j().h());
            e30.b bVar = this.f90623h;
            if (bVar != null && bVar.g() != null) {
                if (this.f90623h.g().type.get() == 2) {
                    str = "1";
                } else {
                    str = "2";
                }
                dataBuilder.setExt1(str);
            }
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    private void n0() {
        if (fb0.a.a("QFSBottomConfigGuideFollowAllItemViewhandleClickFollowAllUserBtn")) {
            return;
        }
        p0();
        m0(11);
    }

    private void o0() {
        this.f90620d = (QCircleAvatarListView) findViewById(R.id.f39601c4);
        Button button = (Button) findViewById(R.id.f39611c5);
        this.f90621e = button;
        button.setOnClickListener(this);
    }

    private void p0() {
        HashMap hashMap = new HashMap();
        for (FeedCloudMeta$StUser feedCloudMeta$StUser : this.f90624i) {
            if (feedCloudMeta$StUser != null && !QCircleFollowManager.getInstance().isUinFollowed(feedCloudMeta$StUser.f398463id.get())) {
                hashMap.put(feedCloudMeta$StUser.f398463id.get(), 1);
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleMultiFollowUpdateEvent(hashMap));
    }

    private void q0(boolean z16) {
        QLog.d("QFSBottomConfigGuideFollowAllItemView", 1, "[updateFollowAllUserBtnStyle] isAllFollowed =" + z16);
        Button button = this.f90621e;
        if (button == null) {
            QLog.e("QFSBottomConfigGuideFollowAllItemView", 1, "[updateFollowAllUserBtnStyle] mFollowAllBtn should not be null");
            return;
        }
        if (z16) {
            button.setText(R.string.f1905342c);
            this.f90621e.setBackground(null);
            this.f90621e.setTextColor(getContext().getResources().getColor(R.color.cli));
            this.f90621e.setClickable(false);
            return;
        }
        button.setText(R.string.f1912444_);
        this.f90621e.setBackgroundResource(R.drawable.kml);
        this.f90621e.setTextColor(getContext().getResources().getColor(R.color.cla));
        this.f90621e.setClickable(true);
    }

    private void r0(QCircleFollowUpdateEvent qCircleFollowUpdateEvent) {
        QLog.d("QFSBottomConfigGuideFollowAllItemView", 1, "[updateShowUserFollowStatus] follow uin :" + qCircleFollowUpdateEvent.mUserId + ", follow state : " + qCircleFollowUpdateEvent.mFollowStatus);
        QCircleFollowManager.getInstance().setUinFollowed(qCircleFollowUpdateEvent.mUserId, qCircleFollowUpdateEvent.mFollowStatus);
        q0(r.k0(this.f90624i));
    }

    private void s0(List<FeedCloudMeta$StUser> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("QFSBottomConfigGuideFollowAllItemView", 1, "[updateUserAvatarList] stUserList should not be null");
        } else {
            this.f90620d.setData(o.c(list, 3));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFollowUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        if (i.f90684a.b()) {
            return R.layout.g8a;
        }
        return R.layout.g8_;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(d dVar, int i3) {
        if (dVar == null) {
            QLog.e("QFSBottomConfigGuideFollowAllItemView", 1, "[bindData] followAllItemInfo should not be null");
            return;
        }
        QLog.d("QFSBottomConfigGuideFollowAllItemView", 1, "[bindData] followAllItemInfo =" + dVar);
        this.f90622f = i3;
        this.f90624i = dVar.f();
        this.f90623h = dVar.c();
        s0(this.f90624i);
        q0(r.k0(this.f90624i));
        l0();
        m0(10);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f39611c5) {
            n0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFollowUpdateEvent) {
            r0((QCircleFollowUpdateEvent) simpleBaseEvent);
        }
    }
}
