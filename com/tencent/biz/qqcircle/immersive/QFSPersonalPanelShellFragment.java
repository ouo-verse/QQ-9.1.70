package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPersonalPanelEvent;
import com.tencent.biz.qqcircle.immersive.search.QFSPersonalPanelPart;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSPersonalPanelShellFragment extends QCircleBaseFragment implements QUSBaseHalfScreenFloatingView.l {
    private FeedCloudMeta$StFeed C;
    private FeedCloudMeta$StUser D;
    private QCircleInitBean E;

    private void ph(Intent intent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (intent != null && intent.hasExtra("key_bundle_common_init_bean")) {
            Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
            if (!(serializableExtra instanceof QCircleInitBean)) {
                QLog.i("QFSPersonalPanelShellFragment", 1, "[initIntentData] InitBean is not QCircleInitBean");
                return;
            }
            QCircleInitBean qCircleInitBean = (QCircleInitBean) serializableExtra;
            if (qCircleInitBean.getFeed().has()) {
                feedCloudMeta$StFeed = qCircleInitBean.getFeed();
            } else {
                feedCloudMeta$StFeed = this.C;
            }
            this.C = feedCloudMeta$StFeed;
            if (qCircleInitBean.getUser().has()) {
                feedCloudMeta$StUser = qCircleInitBean.getUser();
            } else {
                feedCloudMeta$StUser = this.D;
            }
            this.D = feedCloudMeta$StUser;
            this.E = qCircleInitBean;
            if (QLog.isDevelopLevel()) {
                QLog.d(getTAG(), 1, "[initIntentData] hashCode:" + hashCode());
                return;
            }
            return;
        }
        QLog.i("QFSPersonalPanelShellFragment", 1, "[initIntentData] InitBean is null");
    }

    private void qh() {
        if (this.D == null) {
            QLog.e(getTAG(), 1, "[openPersonalPanel] user is null");
            return;
        }
        Context context = getContext();
        if (context == null) {
            QLog.e(getTAG(), 1, "[openPersonalPanel] context is null");
            return;
        }
        QLog.d(getTAG(), 1, "[openPersonalPanel] dispatch event");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.C;
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        }
        feedCloudMeta$StFeed.poster.set(this.D);
        QFSShowPersonalPanelEvent qFSShowPersonalPanelEvent = new QFSShowPersonalPanelEvent(feedCloudMeta$StFeed, true, context.hashCode());
        qFSShowPersonalPanelEvent.setNeedMaskView(true);
        SimpleEventBus.getInstance().dispatchEvent(qFSShowPersonalPanelEvent);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QFSPersonalPanelPart qFSPersonalPanelPart = new QFSPersonalPanelPart();
        qFSPersonalPanelPart.da(this);
        qFSPersonalPanelPart.ca(2);
        arrayList.add(qFSPersonalPanelPart);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gmr;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalPanelShellFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        qh();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity != null) {
            ph(activity.getIntent());
        }
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
    public void onDismiss() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
