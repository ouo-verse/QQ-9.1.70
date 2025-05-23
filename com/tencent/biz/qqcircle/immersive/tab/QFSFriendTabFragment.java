package com.tencent.biz.qqcircle.immersive.tab;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.helpers.y;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.events.QFSChangePgidEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFriendFooterViewEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSRedPointTipsEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSLayerTabPart;
import com.tencent.biz.qqcircle.immersive.refresh.QFSFriendLayerLoadFooterView;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleCounter$RedPointInfo;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFriendTabFragment extends QFSFolderLayerTabFragment {
    /* JADX INFO: Access modifiers changed from: protected */
    public QFSFriendTabFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
        QFSHodorCollectManager.f84689a.a("qfs_friend_tab_create_cost");
    }

    private void ti() {
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo != null && qCircleTabInfo.getType() == 9) {
            QLog.d(EeveeRedpointUtil.LOG_TAG_PREFIX + getTAG(), 1, "[clearLocalFriendRedPoint");
            QCircleHostRedPointHelper.setFriendRedPointRead(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE, false);
        }
    }

    private void ui(QFSFriendFooterViewEvent qFSFriendFooterViewEvent) {
        if (qFSFriendFooterViewEvent.mIsFinished) {
            if (Rh()) {
                QCircleSelectTabEvent qCircleSelectTabEvent = new QCircleSelectTabEvent(6);
                qCircleSelectTabEvent.needDownOnePage = true;
                SimpleEventBus.getInstance().dispatchEvent(qCircleSelectTabEvent);
            }
            this.R.getLayerPageContainer().o(false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public boolean Kh() {
        return k.a().c("sp_key_friend_tab_show_new_tips", true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void Lh() {
        super.Lh();
        SimpleEventBus.getInstance().dispatchEvent(new QFSRedPointTipsEvent(null, "", 0, false));
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return super.assembleParts();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g_z;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return "pg_xsj_friendtab_explore_page";
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSFriendFooterViewEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSFriendTabFragment";
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 504;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void hi() {
        super.hi();
        ti();
        y.g().y(true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void li(boolean z16) {
        super.li(z16);
        if (!z16) {
            return;
        }
        FeedCloudMeta$StFeed zh5 = zh();
        if (c.f90017a.a() && zh5 != null && zh5.dittoFeed.dittoId.get() == 15) {
            bi(0);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFriendFooterViewEvent) {
            ui((QFSFriendFooterViewEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SimpleEventBus.getInstance().dispatchEvent(new QFSChangePgidEvent(getDaTongPageId()));
        k.a().j("sp_key_friend_tab_show_new_tips", false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment, com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart == null) {
            QLog.w("QFSFriendTabFragment", 1, "[onViewCreatedAfterPartInit] invalid mLayerPagePart");
            return;
        }
        QFSPageTurnContainer layerPageContainer = qFSLayerTabPart.getLayerPageContainer();
        if (layerPageContainer == null) {
            QLog.w("QFSFriendTabFragment", 1, "[onViewCreatedAfterPartInit] invalid container");
            return;
        }
        layerPageContainer.setLoadFooterView(new QFSFriendLayerLoadFooterView(layerPageContainer.getContext()));
        layerPageContainer.setCloseFooterMoveRadio(1.0f);
        QFSHodorCollectManager.f84689a.c("qfs_friend_tab_create_cost");
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void rh() {
        boolean z16;
        QQCircleCounter$RedPointInfo friendRedPointInfoByAppId = QCircleHostRedPointHelper.getFriendRedPointInfoByAppId(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        if (friendRedPointInfoByAppId != null && friendRedPointInfoByAppId.redType.get() == 9 && friendRedPointInfoByAppId.showType.get() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.H = z16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
    }
}
