package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.adapter.QFSCommentBlock;
import com.tencent.biz.qqcircle.events.QCircleCommentCountUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSCommentInputButNotSendEvent;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cr;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001?\u0018\u0000 H2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u0001IB\u001f\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010E\u001a\u000206\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u0007H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006J"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentView;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "u0", "o0", "", "blockHeight", "s0", "p0", "v0", "commentNum", "w0", "Lcom/tencent/biz/qqcircle/events/QCircleCommentCountUpdateEvent;", "event", "r0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "child", "onViewRemoved", "", "getLogTag", "getLayoutId", "feed", com.tencent.luggage.wxa.c8.c.G, "q0", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mCommentContentView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTvCommentCount", "Lcom/tencent/biz/qqcircle/fragments/QCircleBlockContainer;", "f", "Lcom/tencent/biz/qqcircle/fragments/QCircleBlockContainer;", "mBlockContainer", tl.h.F, "Landroid/view/View;", "mInputAreaAbove", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "i", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "avatarView", "Lcom/tencent/biz/qqcircle/adapter/QFSCommentBlock;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/adapter/QFSCommentBlock;", "mCommentBlock", BdhLogUtil.LogTag.Tag_Conn, "Lfeedcloud/FeedCloudMeta$StFeed;", "mFeed", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/a;", "D", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/a;", "mCommentContainer", "E", "I", "mBlockHeightInPortrait", UserInfo.SEX_FEMALE, "mBlockHeightInLandscape", "com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentView$b", "G", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentView$b;", "eventReceiver", "Landroid/content/Context;", "context", "commentContainer", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/a;I)V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSNewContentDetailBodyCommentView extends QCircleBaseWidgetView<FeedCloudMeta$StFeed> implements View.OnClickListener {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String I;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mFeed;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final a mCommentContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private int mBlockHeightInPortrait;

    /* renamed from: F, reason: from kotlin metadata */
    private int mBlockHeightInLandscape;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b eventReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout mCommentContentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mTvCommentCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleBlockContainer mBlockContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mInputAreaAbove;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleAvatarView avatarView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSCommentBlock mCommentBlock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentView$a;", "", "", "value", "", "a", "TAG", "Ljava/lang/String;", "TEXT_COMMENT", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.QFSNewContentDetailBodyCommentView$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(int value) {
            String str;
            if (value > 0) {
                str = "\u5171" + r.f(value) + "\u6761";
            } else {
                str = "";
            }
            return str + QFSNewContentDetailBodyCommentView.I;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00070\u0006H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentView$b", "Lcom/tencent/biz/qqcircle/utils/cr;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends cr {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.utils.cr
        @NotNull
        protected ArrayList<Class<? extends SimpleBaseEvent>> a() {
            ArrayList<Class<? extends SimpleBaseEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleCommentCountUpdateEvent.class, QCircleConfigChangeEvent.class);
            return arrayListOf;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@NotNull SimpleBaseEvent simpleBaseEvent) {
            Intrinsics.checkNotNullParameter(simpleBaseEvent, "simpleBaseEvent");
            if (simpleBaseEvent instanceof QCircleCommentCountUpdateEvent) {
                QFSNewContentDetailBodyCommentView.this.r0((QCircleCommentCountUpdateEvent) simpleBaseEvent);
            } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
                QFSNewContentDetailBodyCommentView.this.p0();
                QFSNewContentDetailBodyCommentView.this.o0();
            }
        }
    }

    static {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f181813es);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qcircle_comment)");
        I = a16;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSNewContentDetailBodyCommentView(@NotNull Context context, @NotNull a commentContainer, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(commentContainer, "commentContainer");
        View findViewById = findViewById(R.id.f30800pb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qcircle_comment_content_view)");
        this.mCommentContentView = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.b4k);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.comment_list_count)");
        this.mTvCommentCount = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f30820pd);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qcircle_comment_recycleview)");
        QCircleBlockContainer qCircleBlockContainer = (QCircleBlockContainer) findViewById3;
        this.mBlockContainer = qCircleBlockContainer;
        View findViewById4 = findViewById(R.id.f47591xp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_ne\u2026etail_input_above_layout)");
        this.mInputAreaAbove = findViewById4;
        View findViewById5 = findViewById(R.id.f47601xq);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_ne\u2026tent_detail_input_avatar)");
        this.avatarView = (QCircleAvatarView) findViewById5;
        b bVar = new b();
        this.eventReceiver = bVar;
        SimpleEventBus.getInstance().registerReceiver(bVar);
        p0();
        s0(i3);
        QFSCommentBlock commentBlock = commentContainer.getCommentBlock();
        Intrinsics.checkNotNullExpressionValue(commentBlock, "commentContainer.commentBlock");
        this.mCommentBlock = commentBlock;
        qCircleBlockContainer.registerBlock(commentBlock);
        o0();
        qCircleBlockContainer.getRecyclerView().setNestedScrollingEnabled(true);
        qCircleBlockContainer.setEnableLoadMore(true);
        qCircleBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        qCircleBlockContainer.start();
        this.mCommentContainer = commentContainer;
        commentContainer.init();
        u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        int i3;
        ViewGroup.LayoutParams layoutParams = this.mBlockContainer.getLayoutParams();
        layoutParams.width = DisplayUtil.getInstantScreenWidth(getContext());
        if (bz.o()) {
            i3 = this.mBlockHeightInLandscape;
        } else {
            i3 = this.mBlockHeightInPortrait;
        }
        layoutParams.height = i3;
        this.mBlockContainer.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0() {
        if (getQCircleBaseFragment() != null && getQCircleBaseFragment().isAdded()) {
            bz.d(this.mCommentContentView, new Size(DisplayUtil.getInstantScreenWidth(getContext()), -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(QCircleCommentCountUpdateEvent event) {
        String str;
        PBStringField pBStringField;
        String str2 = null;
        if (event != null) {
            str = event.getFeedId();
        } else {
            str = null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str2 = pBStringField.get();
        }
        if (Intrinsics.areEqual(str, str2) && event != null) {
            w0(event.getCount());
        }
    }

    private final void s0(int blockHeight) {
        int i3;
        Context applicationContext = QCircleApplication.getAPP().getApplicationContext();
        int b16 = cx.b(applicationContext) - cx.c(applicationContext);
        if (bz.o()) {
            i3 = blockHeight + b16;
        } else {
            i3 = blockHeight;
        }
        this.mBlockHeightInPortrait = i3;
        if (!bz.o()) {
            blockHeight -= b16;
        }
        this.mBlockHeightInLandscape = blockHeight;
        int i16 = this.mBlockHeightInPortrait;
        QLog.d("QFSNewContentDetailBodyCommentView", 1, "[initBlockHeight] portrait | " + i16 + ", landscape | " + i16);
    }

    private final void u0() {
        this.avatarView.setAvatar(QCirclePluginGlobalInfo.m(), com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.f159392d03));
        this.avatarView.i();
        this.mInputAreaAbove.setOnClickListener(this);
        this.mInputAreaAbove.findViewById(R.id.f47621xs).setOnClickListener(this);
        this.mInputAreaAbove.findViewById(R.id.f47611xr).setOnClickListener(this);
        this.mInputAreaAbove.findViewById(R.id.f47631xt).setOnClickListener(this);
    }

    private final void v0() {
        a aVar = this.mCommentContainer;
        if (aVar instanceof QFSNewContentDetailBodyCommentPart) {
            ((QFSNewContentDetailBodyCommentPart) aVar).requestCommentList(false);
        }
    }

    private final void w0(int commentNum) {
        this.mTvCommentCount.setText(INSTANCE.a(commentNum));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gjq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSNewContentDetailBodyCommentView";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        QFSCommentInputButNotSendEvent qFSCommentInputButNotSendEvent;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (fb0.a.a("QFSNewContentDetailBodyCommentView")) {
            QLog.e(getLogTag(), 1, "[showCommentInputWindow] fast double click");
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f47621xs) {
                qFSCommentInputButNotSendEvent = QFSCommentInputButNotSendEvent.INSTANCE.a();
            } else if (num != null && num.intValue() == R.id.f47611xr) {
                qFSCommentInputButNotSendEvent = QFSCommentInputButNotSendEvent.INSTANCE.b();
            } else if (num != null && num.intValue() == R.id.f47631xt) {
                qFSCommentInputButNotSendEvent = QFSCommentInputButNotSendEvent.INSTANCE.c();
            } else {
                qFSCommentInputButNotSendEvent = new QFSCommentInputButNotSendEvent();
            }
            QLog.d(getLogTag(), 1, "[showCommentInputWindow]");
            SimpleEventBus.getInstance().dispatchEvent(qFSCommentInputButNotSendEvent);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(@Nullable View child) {
        super.onViewRemoved(child);
        SimpleEventBus.getInstance().unRegisterReceiver(this.eventReceiver);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void bindData(@Nullable FeedCloudMeta$StFeed feed, int pos) {
        if (feed == null) {
            return;
        }
        this.mFeed = feed;
        w0(feed.commentCount.get());
        v0();
    }
}
