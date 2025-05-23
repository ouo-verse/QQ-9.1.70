package com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSRecyclerViewScrollEvent;
import com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryDetailViewModel;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.QFSNewContentDetailBodyCommentView;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.e;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.cr;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0001Y\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001aB'\u0012\u0006\u0010]\u001a\u00020\"\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010L\u001a\u000207\u00a2\u0006\u0004\b^\u0010_J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J \u0010\u0010\u001a\u00020\u00052\u0016\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r0\fH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J \u0010\u0013\u001a\u00020\u00052\u0016\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r0\fH\u0002J\u001a\u0010\u0015\u001a\u00020\u00052\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J \u0010\u0017\u001a\u00020\u00052\u0016\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r0\fH\u0002J\u001a\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010$\u001a\u00020\"2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u0005H\u0002J\u001c\u0010*\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u00100\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u001aH\u0016J\u001a\u00105\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u000e2\u0006\u00104\u001a\u00020\"H\u0016J\u0012\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0016J\n\u00108\u001a\u0004\u0018\u000107H\u0016J\b\u00109\u001a\u00020\u0018H\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016J1\u0010@\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\u001a2\u0016\u0010?\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010>0=\"\u0004\u0018\u00010>H\u0016\u00a2\u0006\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010L\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/b;", "Lcom/tencent/biz/qqcircle/bizparts/QCircleBaseBlockPart;", "Lt40/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "N9", "P9", "showLoadingView", "hideLoadingView", "Q9", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", "uiStateData", "L9", "I9", "R9", "J9", "blockDataList", "D9", "G9", "H9", "", "showEmpty", "", "errorMsg", "T9", "S9", "M9", "O9", "Lfeedcloud/FeedCloudMeta$StFeed;", "mData", "", "targetW", "F9", "K9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "getLogTag", "onInitView", "onPartDestroy", "getFeedPosition", "getViewModelKey", "blockData", "feedPosInLayer", "triggerFeedReplace", "getFeedList", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getInitBean", "isContainerOnScreen", "Landroid/graphics/drawable/Drawable;", "getTransitionLoadingDrawable", "event", "", "", "args", "onHandlerMessage", "(Ljava/lang/String;[Ljava/lang/Object;)V", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/e;", "d", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/e;", "mPicBlock", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/b;", "e", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/b;", "mCommentBlock", "f", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "mInitBean", "Lcom/tencent/biz/qqcircle/immersive/gallery/viewmodel/QFSGalleryDetailViewModel;", h.F, "Lcom/tencent/biz/qqcircle/immersive/gallery/viewmodel/QFSGalleryDetailViewModel;", "mViewModel", "Lcom/tencent/biz/qqcircle/widgets/QCircleStatusView;", "i", "Lcom/tencent/biz/qqcircle/widgets/QCircleStatusView;", "mStatusView", "Lcom/tencent/biz/qqcircle/widgets/QCirclePanelLoadingView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/widgets/QCirclePanelLoadingView;", "mLoadingView", "com/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/b$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/b$b;", "eventReceiver", "peerBlockFindViewId", "<init>", "(ILcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/e;Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/b;Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends QCircleBaseBlockPart implements t40.a {
    private static final int E = cx.a(470.0f);
    private static final int F = cx.a(242.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final C0916b eventReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mPicBlock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.b mCommentBlock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleInitBean mInitBean;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QFSGalleryDetailViewModel mViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QCircleStatusView mStatusView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QCirclePanelLoadingView mLoadingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0006\u001a*\u0012\u0010\u0012\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0002j\u0014\u0012\u0010\u0012\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003`\u0005H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/b$b", "Lcom/tencent/biz/qqcircle/utils/cr;", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "a", "simpleBaseEvent", "", "onReceiveEvent", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0916b extends cr {
        C0916b() {
        }

        @Override // com.tencent.biz.qqcircle.utils.cr
        @NotNull
        protected ArrayList<Class<? extends SimpleBaseEvent>> a() {
            ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSRecyclerViewScrollEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
            if (simpleBaseEvent instanceof QFSRecyclerViewScrollEvent) {
                b.this.K9();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/b$c", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            QCircleStatusView qCircleStatusView = b.this.mStatusView;
            if (qCircleStatusView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusView");
                qCircleStatusView = null;
            }
            qCircleStatusView.setVisibility(8);
            b.this.S9();
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piccontentdetail/b$d", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", "listUIStateData", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements Observer<UIStateData<List<e30.b>>> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable UIStateData<List<e30.b>> listUIStateData) {
            if (listUIStateData != null) {
                b.this.L9(listUIStateData);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(int i3, @NotNull e mPicBlock, @NotNull com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.b mCommentBlock, @NotNull QCircleInitBean mInitBean) {
        super(i3, r0, 1, 1);
        List listOf;
        Intrinsics.checkNotNullParameter(mPicBlock, "mPicBlock");
        Intrinsics.checkNotNullParameter(mCommentBlock, "mCommentBlock");
        Intrinsics.checkNotNullParameter(mInitBean, "mInitBean");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.biz.qqcircle.bizparts.c[]{mPicBlock, mCommentBlock});
        this.mPicBlock = mPicBlock;
        this.mCommentBlock = mCommentBlock;
        this.mInitBean = mInitBean;
        this.eventReceiver = new C0916b();
    }

    private final void D9(List<e30.b> blockDataList) {
        this.mPicBlock.setDatas(blockDataList);
        this.mBlockContainer.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piccontentdetail.a
            @Override // java.lang.Runnable
            public final void run() {
                b.E9(b.this);
            }
        });
        this.mCommentBlock.setDatas(blockDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9();
    }

    private final int F9(FeedCloudMeta$StFeed mData, int targetW) {
        FeedCloudMeta$StImage feedCloudMeta$StImage = mData.images.get().get(0);
        int i3 = (feedCloudMeta$StImage.height.get() * targetW) / feedCloudMeta$StImage.width.get();
        int i16 = E;
        if (i3 > i16 || i3 < (i16 = F)) {
            return i16;
        }
        return i3;
    }

    private final void G9() {
        T9(true, "");
    }

    private final void H9(UIStateData<List<e30.b>> uiStateData) {
        String msg2 = uiStateData.getMsg();
        if (msg2 == null) {
            msg2 = com.tencent.biz.qqcircle.utils.h.a(R.string.f184743mp);
        }
        cj.b(false, uiStateData.getRetCode(), msg2);
        T9(true, msg2);
    }

    private final void I9() {
        getBlockContainer().getBlockMerger().k0();
    }

    private final void J9(UIStateData<List<e30.b>> uiStateData) {
        T9(false, "");
        D9(uiStateData.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        NestScrollRecyclerView recyclerView = this.mBlockContainer.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBlockContainer.recyclerView");
        recyclerView.smoothScrollToPosition(0);
        View childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
        if (!(childAt instanceof QFSNewContentDetailBodyCommentView)) {
            QLog.e(getTAG(), 1, "[handleRecyclerViewScrollEvent] commentView is not QFSNewContentDetailBodyCommentView");
            return;
        }
        QFSNewContentDetailBodyCommentView qFSNewContentDetailBodyCommentView = (QFSNewContentDetailBodyCommentView) childAt;
        if (qFSNewContentDetailBodyCommentView.getChildCount() <= 0 || !(qFSNewContentDetailBodyCommentView.getChildAt(0) instanceof LinearLayout)) {
            return;
        }
        View childAt2 = qFSNewContentDetailBodyCommentView.getChildAt(0);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) childAt2;
        if ((linearLayout.getChildAt(2) instanceof QCircleBlockContainer) && linearLayout.getChildCount() > 2) {
            View childAt3 = linearLayout.getChildAt(2);
            Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type com.tencent.biz.qqcircle.fragments.QCircleBlockContainer");
            ((QCircleBlockContainer) childAt3).getRecyclerView().smoothScrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(UIStateData<List<e30.b>> uiStateData) {
        int state = uiStateData.getState();
        QLog.d(getTAG(), 1, "[handleUiStatus] state = " + state);
        switch (uiStateData.getState()) {
            case 0:
                G9();
                return;
            case 1:
                showLoadingView();
                return;
            case 2:
            case 3:
                J9(uiStateData);
                return;
            case 4:
                H9(uiStateData);
                return;
            case 5:
            default:
                return;
            case 6:
            case 7:
            case 8:
                I9();
                return;
        }
    }

    private final void M9(View rootView) {
        QCircleBlockContainer qCircleBlockContainer = (QCircleBlockContainer) rootView.findViewById(R.id.f47241wr);
        qCircleBlockContainer.setPadding(0, ImmersiveUtils.getStatusBarHeight(rootView.getContext()), 0, 0);
        qCircleBlockContainer.setParentFragment(getHostFragment());
        qCircleBlockContainer.setEnableRefresh(false);
        qCircleBlockContainer.setEnableLoadMore(false);
    }

    private final void N9(View rootView) {
        if (this.mInitBean.isForceFromNetwork()) {
            P9(rootView);
            Q9();
            S9();
            return;
        }
        R9();
    }

    private final void O9() {
        FeedCloudMeta$StFeed feed = this.mInitBean.getFeed();
        Intrinsics.checkNotNullExpressionValue(feed, "mInitBean.getFeed()");
        int F9 = F9(feed, ViewUtils.getScreenWidth());
        int screenHeight = ViewUtils.getScreenHeight();
        QLog.d(getTAG(), 1, "height: " + F9 + " screenHeight: " + screenHeight + " containerHeight: " + this.mBlockContainer.getHeight());
        int i3 = F9 * 2;
        if (i3 > screenHeight) {
            this.mBlockContainer.getRecyclerView().scrollBy(0, i3 - screenHeight);
        }
    }

    private final void P9(View rootView) {
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.f42891l0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<QC\u2026lery_detail_loading_view)");
        QCirclePanelLoadingView qCirclePanelLoadingView = (QCirclePanelLoadingView) findViewById;
        this.mLoadingView = qCirclePanelLoadingView;
        if (qCirclePanelLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
            qCirclePanelLoadingView = null;
        }
        qCirclePanelLoadingView.setHintText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1918345v));
    }

    private final void Q9() {
        IStatusViewProvider statusViewProvider = getStatusViewProvider();
        if (!(statusViewProvider instanceof QCircleStatusView)) {
            return;
        }
        QCircleStatusView qCircleStatusView = (QCircleStatusView) statusViewProvider;
        this.mStatusView = qCircleStatusView;
        if (qCircleStatusView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStatusView");
            qCircleStatusView = null;
        }
        qCircleStatusView.setOnRetryClickListener(new c());
    }

    private final void R9() {
        e30.b bVar = new e30.b(this.mInitBean.getFeed());
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        D9(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        QLog.d(getTAG(), 1, "[requestData]");
        QFSGalleryDetailViewModel qFSGalleryDetailViewModel = this.mViewModel;
        if (qFSGalleryDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qFSGalleryDetailViewModel = null;
        }
        qFSGalleryDetailViewModel.Q1(this.mInitBean);
    }

    private final void T9(boolean showEmpty, String errorMsg) {
        hideLoadingView();
        QCircleStatusView qCircleStatusView = null;
        if (!TextUtils.isEmpty(errorMsg)) {
            QCircleStatusView qCircleStatusView2 = this.mStatusView;
            if (qCircleStatusView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusView");
            } else {
                qCircleStatusView = qCircleStatusView2;
            }
            qCircleStatusView.x0(errorMsg);
            return;
        }
        if (showEmpty) {
            QCircleStatusView qCircleStatusView3 = this.mStatusView;
            if (qCircleStatusView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusView");
            } else {
                qCircleStatusView = qCircleStatusView3;
            }
            qCircleStatusView.w0();
            return;
        }
        QCircleStatusView qCircleStatusView4 = this.mStatusView;
        if (qCircleStatusView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStatusView");
        } else {
            qCircleStatusView = qCircleStatusView4;
        }
        qCircleStatusView.o0();
    }

    private final void hideLoadingView() {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.mLoadingView;
        QCirclePanelLoadingView qCirclePanelLoadingView2 = null;
        if (qCirclePanelLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
            qCirclePanelLoadingView = null;
        }
        qCirclePanelLoadingView.setVisibility(8);
        QCirclePanelLoadingView qCirclePanelLoadingView3 = this.mLoadingView;
        if (qCirclePanelLoadingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        } else {
            qCirclePanelLoadingView2 = qCirclePanelLoadingView3;
        }
        qCirclePanelLoadingView2.k0();
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QFSGalleryDetailViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel<QFSGalleryD\u2026ailViewModel::class.java)");
        QFSGalleryDetailViewModel qFSGalleryDetailViewModel = (QFSGalleryDetailViewModel) viewModel;
        this.mViewModel = qFSGalleryDetailViewModel;
        if (qFSGalleryDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qFSGalleryDetailViewModel = null;
        }
        qFSGalleryDetailViewModel.j().observe(getHostFragment(), new d());
    }

    private final void showLoadingView() {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.mLoadingView;
        QCirclePanelLoadingView qCirclePanelLoadingView2 = null;
        if (qCirclePanelLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
            qCirclePanelLoadingView = null;
        }
        qCirclePanelLoadingView.setVisibility(0);
        QCirclePanelLoadingView qCirclePanelLoadingView3 = this.mLoadingView;
        if (qCirclePanelLoadingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        } else {
            qCirclePanelLoadingView2 = qCirclePanelLoadingView3;
        }
        qCirclePanelLoadingView2.n0();
    }

    @Override // t40.a
    @Nullable
    public List<e30.b> getFeedList() {
        return null;
    }

    @Override // t40.a
    public int getFeedPosition() {
        return 0;
    }

    @Override // t40.a
    @Nullable
    /* renamed from: getInitBean, reason: from getter */
    public QCircleInitBean getMInitBean() {
        return this.mInitBean;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSNewContentDetailBodyPart";
    }

    @Override // t40.a
    @Nullable
    public Drawable getTransitionLoadingDrawable() {
        return null;
    }

    @Override // t40.a
    @NotNull
    public String getViewModelKey() {
        return "";
    }

    @Override // t40.a
    public boolean isContainerOnScreen() {
        if (getHostFragment() != null) {
            return getHostFragment().isResumed();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mPicBlock.i0(configuration);
    }

    @Override // t40.b
    public void onHandlerMessage(@Nullable String event, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        PartManager partManager = getPartManager();
        if (partManager == null) {
            QLog.d(getTAG(), 1, "[onHandlerMessage] manager should not be null.");
        } else if (TextUtils.equals(event, "event_open_friend_push_panel")) {
            partManager.broadcastMessage("light_interact_list_show", args[0]);
        } else if (TextUtils.equals(event, "event_open_share")) {
            partManager.broadcastMessage("share_action_show_share_sheet", args[0]);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        M9(rootView);
        super.onInitView(rootView);
        initViewModel();
        N9(rootView);
        SimpleEventBus.getInstance().registerReceiver(this.eventReceiver);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        registerIoc(this, t40.a.class);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this.eventReceiver);
    }

    @Override // t40.a
    public void triggerFeedReplace(@Nullable e30.b blockData, int feedPosInLayer) {
    }
}
