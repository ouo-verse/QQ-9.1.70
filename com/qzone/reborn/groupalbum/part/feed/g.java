package com.qzone.reborn.groupalbum.part.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.header.QZoneOnlyProgressRefreshView;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupUploadAlbumInitBean;
import com.qzone.reborn.groupalbum.block.GroupAlbumFeedAdapter;
import com.qzone.reborn.groupalbum.event.GroupAlbumMainFragmentRightEvent;
import com.qzone.reborn.groupalbum.event.GroupAlbumStartPublishNotifyEvent;
import com.qzone.reborn.groupalbum.event.GroupAlbumUploadAlbumEvent;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.qzone.util.ToastUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.shadow.dynamic.host.Constant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B#\u0012\u0006\u0010G\u001a\u00020\u0018\u0012\u0012\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010H0\n\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J \u0010\u0015\u001a\u00020\u00072\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001dH\u0014J\u0012\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010&\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010'\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016J$\u0010-\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040+0*j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040+`,H\u0016J\u0012\u0010.\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0018\u00107\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006L"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/g;", "Lcom/qzone/reborn/base/d;", "Lqj/m;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/content/Intent;", "intent", "", "W9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "listUIStateData", "R9", "Z9", "aa", "ba", "T9", "data", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "S9", "Y9", "X9", "", "P9", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumUploadAlbumEvent;", "event", "Q9", "Lwe/b;", "C9", "Landroid/view/View;", "mRootView", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "fa", "W5", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "", "e", "Ljava/lang/String;", "mEmptyMsg", "f", "groupId", tl.h.F, "Ljava/lang/Boolean;", "hasRight", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "i", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "mBlankView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsItemDecorationSetup", "Lcom/qzone/reborn/groupalbum/viewmodel/z;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/groupalbum/viewmodel/z;", "mFeedViewModel", "Lcom/qzone/reborn/groupalbum/block/GroupAlbumFeedAdapter;", "D", "Lcom/qzone/reborn/groupalbum/block/GroupAlbumFeedAdapter;", "mFeedListAdapter", "peerBlockFindViewId", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "peerBlocks", "<init>", "(ILjava/util/List;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends com.qzone.reborn.base.d implements qj.m, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.z mFeedViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private GroupAlbumFeedAdapter mFeedListAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mEmptyMsg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Boolean hasRight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView mBlankView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsItemDecorationSetup;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i3, List<? extends MultiViewBlock<?>> peerBlocks) {
        super(i3, peerBlocks);
        Intrinsics.checkNotNullParameter(peerBlocks, "peerBlocks");
        this.mEmptyMsg = "";
        this.groupId = "";
        for (Object obj : peerBlocks) {
            if (((MultiViewBlock) obj) instanceof GroupAlbumFeedAdapter) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.block.GroupAlbumFeedAdapter");
                this.mFeedListAdapter = (GroupAlbumFeedAdapter) obj;
                String a16 = com.qzone.util.l.a(R.string.f1330553);
                Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.group_alb\u2026feed_empty_message_guest)");
                this.mEmptyMsg = a16;
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int P9() {
        return getActivity().getResources().getColor(R.color.qui_common_border_light);
    }

    private final void Q9(GroupAlbumUploadAlbumEvent event) {
        QLog.d(getTAG(), 1, "handleAlbumUploadSuccessEvent");
        com.qzone.reborn.groupalbum.viewmodel.z zVar = this.mFeedViewModel;
        if (zVar != null) {
            zVar.T1(event.getGroupId(), event.getClientKey());
        }
    }

    private final void R9(UIStateData<List<BusinessFeedData>> listUIStateData) {
        Intrinsics.checkNotNull(listUIStateData);
        int state = listUIStateData.getState();
        if (state == 0) {
            GroupAlbumFeedAdapter groupAlbumFeedAdapter = this.mFeedListAdapter;
            if (groupAlbumFeedAdapter != null) {
                groupAlbumFeedAdapter.notifyLoadingComplete(false);
            }
            if (listUIStateData.getIsLoadMore()) {
                return;
            }
            Z9();
            return;
        }
        if (state == 2 || state == 3) {
            GroupAlbumFeedAdapter groupAlbumFeedAdapter2 = this.mFeedListAdapter;
            if (groupAlbumFeedAdapter2 != null) {
                groupAlbumFeedAdapter2.notifyLoadingComplete(true, listUIStateData.getIsFinish());
            }
            S9(listUIStateData.getData(), listUIStateData.getIsLoadMore());
            return;
        }
        if (state != 4) {
            return;
        }
        GroupAlbumFeedAdapter groupAlbumFeedAdapter3 = this.mFeedListAdapter;
        if (groupAlbumFeedAdapter3 != null) {
            groupAlbumFeedAdapter3.notifyLoadingComplete(false);
        }
        if (!listUIStateData.getIsLoadMore() && listUIStateData.getRetCode() != Constant.FROM_ID_UNINSTALL_PLUGIN) {
            aa();
        }
        if (listUIStateData.getRetCode() == Constant.FROM_ID_UNINSTALL_PLUGIN) {
            ToastUtil.o(R.string.f1338579, 4);
        }
    }

    private final void T9() {
        GroupUploadAlbumInitBean groupUploadAlbumInitBean = new GroupUploadAlbumInitBean(this.groupId, 0, true, null, 7);
        oi.c m3 = ho.i.m();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        m3.n(context, groupUploadAlbumInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(g this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.scrollToTop();
    }

    private final void W9(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        if (serializable instanceof GroupAlbumInitBean) {
            this.groupId = ((GroupAlbumInitBean) serializable).getGroupId();
        }
    }

    private final void X9() {
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(3);
        this.mBlockContainer.getBlockMerger().setNoMoreHint("");
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setRefreshHeader(new QZoneOnlyProgressRefreshView(getActivity()));
        this.mBlockContainer.setEnableRefresh(true);
        this.mBlockContainer.getRecyclerView().setNestedScrollingEnabled(false);
        this.mBlockContainer.getRecyclerView().setOverScrollMode(0);
    }

    private final void Y9() {
        if (this.mIsItemDecorationSetup || getActivity() == null) {
            return;
        }
        this.mIsItemDecorationSetup = true;
        com.qzone.reborn.feedx.widget.g gVar = new com.qzone.reborn.feedx.widget.g(getContext(), 0, DisplayUtil.dip2px(MobileQQ.sMobileQQ, 8.0f), P9());
        gVar.f(false);
        this.mBlockContainer.getRecyclerView().addItemDecoration(gVar);
    }

    private final void Z9() {
        this.mBlockContainer.setVisibility(4);
        ba();
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.s0();
        }
    }

    private final void aa() {
        this.mBlockContainer.setVisibility(4);
        ba();
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.showErrorView();
        }
    }

    private final void ba() {
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView != null) {
            Context context = getContext();
            Boolean bool = this.hasRight;
            qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.d(context, bool != null ? bool.booleanValue() : false, this.mEmptyMsg, new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.feed.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.ca(g.this, view);
                }
            }));
        }
        QLog.d(getTAG(), 1, "[initBlankViewData] emptyMsg = " + this.mEmptyMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.base.d
    protected we.b<?> C9() {
        return this.mFeedListAdapter;
    }

    @Override // qj.m
    public void W5() {
        scrollToTop();
    }

    @Override // qj.m
    public boolean fa() {
        return !com.qzone.reborn.feedx.util.ah.b(this.mBlockContainer != null ? r0.getRecyclerView() : null);
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View mRootView) {
        Intent intent;
        MutableLiveData<UIStateData<List<BusinessFeedData>>> d26;
        super.onInitView(mRootView);
        com.qzone.reborn.groupalbum.viewmodel.z zVar = (com.qzone.reborn.groupalbum.viewmodel.z) getViewModel(com.qzone.reborn.groupalbum.viewmodel.z.class);
        this.mFeedViewModel = zVar;
        if (zVar != null && (d26 = zVar.d2()) != null) {
            d26.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.groupalbum.part.feed.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.U9(g.this, (UIStateData) obj);
                }
            });
        }
        X9();
        this.mBlankView = (QZoneBlankStateView) getPartRootView().findViewById(R.id.jvr);
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return;
        }
        W9(intent);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        QLog.d(getTAG(), 1, "onPartCreate");
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QLog.d(getTAG(), 1, "onPartDestroy");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.qzone.reborn.groupalbum.viewmodel.z zVar = this.mFeedViewModel;
        if (zVar != null) {
            zVar.L1();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        String a16;
        if (event instanceof GroupAlbumUploadAlbumEvent) {
            Q9((GroupAlbumUploadAlbumEvent) event);
            return;
        }
        if (event instanceof GroupAlbumStartPublishNotifyEvent) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.feed.d
                @Override // java.lang.Runnable
                public final void run() {
                    g.V9(g.this);
                }
            });
            return;
        }
        if (event instanceof GroupAlbumMainFragmentRightEvent) {
            GroupAlbumMainFragmentRightEvent groupAlbumMainFragmentRightEvent = (GroupAlbumMainFragmentRightEvent) event;
            if (groupAlbumMainFragmentRightEvent.getFrom() == 0) {
                if (groupAlbumMainFragmentRightEvent.getHasUpLoadRight()) {
                    this.hasRight = Boolean.TRUE;
                    a16 = com.qzone.util.l.a(R.string.f1330654);
                    Intrinsics.checkNotNullExpressionValue(a16, "{\n                    ha\u2026master)\n                }");
                } else {
                    this.hasRight = Boolean.FALSE;
                    a16 = com.qzone.util.l.a(R.string.f1330553);
                    Intrinsics.checkNotNullExpressionValue(a16, "{\n                    ha\u2026_guest)\n                }");
                }
                this.mEmptyMsg = a16;
                QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
                boolean z16 = false;
                if (qZoneBlankStateView != null && qZoneBlankStateView.q0()) {
                    z16 = true;
                }
                if (z16) {
                    Z9();
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumUploadAlbumEvent.class, GroupAlbumStartPublishNotifyEvent.class, GroupAlbumMainFragmentRightEvent.class);
        return arrayListOf;
    }

    private final void S9(List<? extends BusinessFeedData> data, boolean isLoadMore) {
        if (data == null) {
            return;
        }
        this.mBlockContainer.setVisibility(0);
        QZoneBlankStateView qZoneBlankStateView = this.mBlankView;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.o0();
        }
        if (this.mFeedListAdapter == null) {
            this.mFeedListAdapter = new GroupAlbumFeedAdapter(null);
        }
        GroupAlbumFeedAdapter groupAlbumFeedAdapter = this.mFeedListAdapter;
        if (groupAlbumFeedAdapter != null) {
            groupAlbumFeedAdapter.setDatas(data);
        }
        Y9();
    }
}
