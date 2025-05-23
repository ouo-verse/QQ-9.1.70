package com.tencent.biz.qqcircle.fragments;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J(\u0010\u0017\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00140\u0013j\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014`\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/fragments/QFSQRCodeFragment;", "Lcom/tencent/biz/qqcircle/fragments/QCircleBaseFragmentFix;", "Lcom/tencent/biz/qqcircle/events/QCirclePanelStateEvent;", "panelStateEvent", "", "qh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "", "getLogTag", "getPageId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "ph", "event", "onReceiveEvent", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSQRCodeFragment extends QCircleBaseFragmentFix {
    private final void qh(QCirclePanelStateEvent panelStateEvent) {
        if (!panelStateEvent.isShowing()) {
            onFinish();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QFSSharePart());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gss;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSQRCodeFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        super.onReceiveEvent(event);
        if (event instanceof QCirclePanelStateEvent) {
            qh((QCirclePanelStateEvent) event);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        QLog.d(getTAG(), 1, "onResume: showQRCode");
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        qCircleShareInfo.type = 1;
        qCircleShareInfo.isShowReport = false;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.share = new FeedCloudMeta$StShare();
        FeedCloudMeta$StUser stUserInfo = QCircleHostGlobalInfo.getStUserInfo();
        if (stUserInfo == null) {
            stUserInfo = new FeedCloudMeta$StUser();
            stUserInfo.f398463id.set(QCircleCommonUtil.getCurrentAccount());
        }
        feedCloudMeta$StFeed.poster = stUserInfo;
        qCircleShareInfo.feed = feedCloudMeta$StFeed;
        qCircleShareInfo.shareStyleType = 2;
        qCircleShareInfo.isShowPersonalQrcodeDown = true;
        qCircleShareInfo.mainPageUserUin = QCircleCommonUtil.getCurrentAccount();
        qCircleShareInfo.source = -1;
        getPartManager().broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragmentFix
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> ph() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCirclePanelStateEvent.class);
        return arrayListOf;
    }
}
