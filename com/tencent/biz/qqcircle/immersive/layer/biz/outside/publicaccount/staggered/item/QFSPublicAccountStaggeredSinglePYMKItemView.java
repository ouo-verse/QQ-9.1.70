package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001EB\u0017\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0003J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J.\u0010\u0012\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0015J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001e0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001e`\u001fH\u0016J\b\u0010!\u001a\u00020\u0005H\u0014J\b\u0010\"\u001a\u00020\u0005H\u0014R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010/R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006F"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredSinglePYMKItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Le30/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initView", "p0", "Lqqcircle/QQCircleDitto$StItemInfo;", "info", "s0", "Landroid/view/View;", "view", "", "elementId", "", "", "params", "v0", "y0", "Lcom/tencent/mobileqq/qcircle/api/event/QCircleFollowUpdateEvent;", "event", "x0", "", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "bindData", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "d", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "getOperator", "()Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", JsonRuleKey.OPERATOR, "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "e", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "mAvatar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mNickname", tl.h.F, "mRecommendReason", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", "i", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", "mFollowBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mFollowNum", "Lqqcircle/QQCircleDitto$StItemContainer;", BdhLogUtil.LogTag.Tag_Conn, "Lqqcircle/QQCircleDitto$StItemContainer;", "mItemContainer", "D", "Lqqcircle/QQCircleDitto$StItemInfo;", "mItemInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;)V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggeredSinglePYMKItemView extends QCircleBaseWidgetView<e30.b> implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QQCircleDitto$StItemContainer mItemContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QQCircleDitto$StItemInfo mItemInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a operator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QCircleAvatarView mAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mNickname;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mRecommendReason;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QFSFollowView mFollowBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mFollowNum;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J)\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/item/QFSPublicAccountStaggeredSinglePYMKItemView$b", "Lcom/tencent/biz/qqcircle/utils/QFSAsyncUtils$Callback;", "Ljava/lang/Void;", "Lqqcircle/QQCircleDitto$StItemContainer;", "", "param", "a", "([Ljava/lang/Void;)Lqqcircle/QQCircleDitto$StItemContainer;", "result", "", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QFSAsyncUtils.Callback<Void, QQCircleDitto$StItemContainer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e30.b f86834a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSPublicAccountStaggeredSinglePYMKItemView f86835b;

        b(e30.b bVar, QFSPublicAccountStaggeredSinglePYMKItemView qFSPublicAccountStaggeredSinglePYMKItemView) {
            this.f86834a = bVar;
            this.f86835b = qFSPublicAccountStaggeredSinglePYMKItemView;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQCircleDitto$StItemContainer doBackgroundAction(@NotNull Void... param) {
            Intrinsics.checkNotNullParameter(param, "param");
            try {
                QLog.d("QFSPublicAccountStaggeredSinglePYMKItemView", 1, "[bindData] get data from merge");
                return new QQCircleDitto$StCircleDittoDataNew().mergeFrom(this.f86834a.g().dittoFeed.dittoDataNew.get().toByteArray()).itemContainter;
            } catch (Exception e16) {
                QLog.e("QFSPublicAccountStaggeredSinglePYMKItemView", 1, "[bindData] Exception " + e16);
                return null;
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void doMainAction(@Nullable QQCircleDitto$StItemContainer result) {
            this.f86835b.mItemContainer = result;
            this.f86835b.p0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountStaggeredSinglePYMKItemView(@NotNull Context context, @NotNull com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a operator) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.operator = operator;
        initView();
    }

    private final void initView() {
        View findViewById = findViewById(R.id.f498523t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_pu\u2026account_pymk_item_avatar)");
        this.mAvatar = (QCircleAvatarView) findViewById;
        View findViewById2 = findViewById(R.id.f4999247);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_pu\u2026c_account_pymk_nick_name)");
        this.mNickname = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f498823w);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_pu\u2026account_pymk_item_reason)");
        this.mRecommendReason = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f498723v);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_pu\u2026account_pymk_item_follow)");
        this.mFollowBtn = (QFSFollowView) findViewById4;
        View findViewById5 = findViewById(R.id.f498423s);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_pu\u2026_account_pymk_follow_num)");
        this.mFollowNum = (TextView) findViewById5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void p0() {
        boolean z16;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo;
        PBRepeatMessageField<QQCircleDitto$StItemInfo> pBRepeatMessageField;
        PBRepeatMessageField<QQCircleDitto$StItemInfo> pBRepeatMessageField2;
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.mItemContainer;
        if (qQCircleDitto$StItemContainer != null && (pBRepeatMessageField2 = qQCircleDitto$StItemContainer.items) != null && !pBRepeatMessageField2.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            setVisibility(8);
            return;
        }
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer2 = this.mItemContainer;
        TextView textView = null;
        if (qQCircleDitto$StItemContainer2 != null && (pBRepeatMessageField = qQCircleDitto$StItemContainer2.items) != null) {
            qQCircleDitto$StItemInfo = pBRepeatMessageField.get(0);
        } else {
            qQCircleDitto$StItemInfo = null;
        }
        this.mItemInfo = qQCircleDitto$StItemInfo;
        if (qQCircleDitto$StItemInfo != null) {
            int i3 = qQCircleDitto$StItemInfo.buttonInfo.buttonValue.get();
            if (i3 != 1 && i3 != 3) {
                String d16 = bh.d(qQCircleDitto$StItemInfo.urlInfo.get(), "user_avatar_url");
                QCircleAvatarView qCircleAvatarView = this.mAvatar;
                if (qCircleAvatarView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
                    qCircleAvatarView = null;
                }
                qCircleAvatarView.setAvatar(d16, qQCircleDitto$StItemInfo.f429300id.get(), com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), 60));
                TextView textView2 = this.mNickname;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickname");
                    textView2 = null;
                }
                textView2.setText(qQCircleDitto$StItemInfo.name.get());
                TextView textView3 = this.mRecommendReason;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecommendReason");
                    textView3 = null;
                }
                textView3.setText(qQCircleDitto$StItemInfo.des.get(0));
                QFSFollowView qFSFollowView = this.mFollowBtn;
                if (qFSFollowView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
                    qFSFollowView = null;
                }
                FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
                feedCloudMeta$StUser.f398463id.set(qQCircleDitto$StItemInfo.f429300id.get());
                feedCloudMeta$StUser.followState.set(i3);
                qFSFollowView.setUserData(feedCloudMeta$StUser);
                String d17 = bh.d(qQCircleDitto$StItemInfo.busiInfo.get(), "fansnum");
                TextView textView4 = this.mFollowNum;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFollowNum");
                    textView4 = null;
                }
                textView4.setText("\u5df2\u6709" + d17 + "\u4eba\u5173\u6ce8");
                QCircleAvatarView qCircleAvatarView2 = this.mAvatar;
                if (qCircleAvatarView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
                    qCircleAvatarView2 = null;
                }
                qCircleAvatarView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QFSPublicAccountStaggeredSinglePYMKItemView.q0(QFSPublicAccountStaggeredSinglePYMKItemView.this, view);
                    }
                });
                TextView textView5 = this.mNickname;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickname");
                } else {
                    textView = textView5;
                }
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.v
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QFSPublicAccountStaggeredSinglePYMKItemView.r0(QFSPublicAccountStaggeredSinglePYMKItemView.this, view);
                    }
                });
                s0(qQCircleDitto$StItemInfo);
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(QFSPublicAccountStaggeredSinglePYMKItemView this$0, View view) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g gVar = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g.f87070a;
        e30.b data = this$0.getData();
        if (data != null) {
            feedCloudMeta$StFeed = data.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        gVar.d(feedCloudMeta$StFeed, 10, this$0.mItemInfo, this$0.getPageId(), 1);
        this$0.y0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(QFSPublicAccountStaggeredSinglePYMKItemView this$0, View view) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g gVar = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g.f87070a;
        e30.b data = this$0.getData();
        if (data != null) {
            feedCloudMeta$StFeed = data.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        gVar.d(feedCloudMeta$StFeed, 11, this$0.mItemInfo, this$0.getPageId(), 1);
        this$0.y0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s0(QQCircleDitto$StItemInfo info) {
        Map<String, ? extends Object> mapOf;
        QCircleAvatarView qCircleAvatarView;
        TextView textView;
        final Map<String, ? extends Object> mapOf2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, info.f429300id.get()), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_INDEX, 1), TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_PYMK_MODULE_TYPE, 3));
        v0(this, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_ITEM, mapOf);
        QCircleAvatarView qCircleAvatarView2 = this.mAvatar;
        QFSFollowView qFSFollowView = null;
        if (qCircleAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            qCircleAvatarView = null;
        } else {
            qCircleAvatarView = qCircleAvatarView2;
        }
        w0(this, qCircleAvatarView, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_AUTHOR_AVATAR, null, 4, null);
        TextView textView2 = this.mNickname;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickname");
            textView = null;
        } else {
            textView = textView2;
        }
        w0(this, textView, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_AUTHOR_NAME, null, 4, null);
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, com.tencent.biz.qqcircle.immersive.utils.r.F(info.buttonInfo.buttonValue.get())), TuplesKt.to("dt_pgid", QCircleDaTongConstant.PageId.PG_XSJ_GZH_DOUBLE_COLUMN_PAGE));
        QFSFollowView qFSFollowView2 = this.mFollowBtn;
        if (qFSFollowView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            qFSFollowView2 = null;
        }
        v0(qFSFollowView2, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON, mapOf2);
        QFSFollowView qFSFollowView3 = this.mFollowBtn;
        if (qFSFollowView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
        } else {
            qFSFollowView = qFSFollowView3;
        }
        qFSFollowView.setFollowStateChangeListener(new QFSFollowView.c() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.w
            @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.c
            public final void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
                QFSPublicAccountStaggeredSinglePYMKItemView.u0(QFSPublicAccountStaggeredSinglePYMKItemView.this, mapOf2, z16, feedCloudMeta$StUser);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(QFSPublicAccountStaggeredSinglePYMKItemView this$0, Map followBtnParam, boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(followBtnParam, "$followBtnParam");
        if (z16) {
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g gVar = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g.f87070a;
            e30.b data = this$0.getData();
            QFSFollowView qFSFollowView = null;
            if (data != null) {
                feedCloudMeta$StFeed = data.g();
            } else {
                feedCloudMeta$StFeed = null;
            }
            gVar.d(feedCloudMeta$StFeed, 2, this$0.mItemInfo, this$0.getPageId(), 1);
            QFSFollowView qFSFollowView2 = this$0.mFollowBtn;
            if (qFSFollowView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            } else {
                qFSFollowView = qFSFollowView2;
            }
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, qFSFollowView, followBtnParam);
        }
    }

    private final void v0(View view, String elementId, Map<String, ? extends Object> params) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(view, params);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void w0(QFSPublicAccountStaggeredSinglePYMKItemView qFSPublicAccountStaggeredSinglePYMKItemView, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        qFSPublicAccountStaggeredSinglePYMKItemView.v0(view, str, map);
    }

    private final void x0(QCircleFollowUpdateEvent event) {
        String str;
        PBStringField pBStringField;
        int i3 = event.mFollowStatus;
        if (i3 != 1 && i3 != 3) {
            return;
        }
        String str2 = event.mUserId;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.mItemInfo;
        if (qQCircleDitto$StItemInfo != null && (pBStringField = qQCircleDitto$StItemInfo.f429300id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (!TextUtils.equals(str2, str)) {
            return;
        }
        this.operator.removeAll(new Function1<e30.b, Boolean>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.item.QFSPublicAccountStaggeredSinglePYMKItemView$handleFollowUpdateEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull e30.b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(QFSPublicAccountStaggeredSinglePYMKItemView.this.getData().g().dittoFeed.dittoId, it.g().dittoFeed.dittoId));
            }
        });
    }

    private final void y0() {
        String str;
        PBStringField pBStringField;
        Context context = getContext();
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.mItemInfo;
        if (qQCircleDitto$StItemInfo != null && (pBStringField = qQCircleDitto$StItemInfo.f429300id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        qCircleInitBean.setUin(str);
        setReportBean(getReportBean());
        com.tencent.biz.qqcircle.launcher.c.d0(context, qCircleInitBean);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleFollowUpdateEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168739go4;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        super.onAttachedToWindow();
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g gVar = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g.f87070a;
        e30.b data = getData();
        if (data != null) {
            feedCloudMeta$StFeed = data.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        gVar.d(feedCloudMeta$StFeed, 1, this.mItemInfo, getPageId(), 1);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QCircleFollowUpdateEvent) {
            x0((QCircleFollowUpdateEvent) event);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @SuppressLint({"SetTextI18n"})
    public void bindData(@Nullable e30.b objData, int pos) {
        FeedCloudMeta$StFeed g16;
        if (objData == null || (g16 = objData.g()) == null) {
            return;
        }
        Object b16 = objData.b(String.valueOf(g16.dittoFeed.dittoId.get()));
        if (b16 instanceof QQCircleDitto$StCircleDittoDataNew) {
            this.mItemContainer = ((QQCircleDitto$StCircleDittoDataNew) b16).itemContainter;
            QLog.d("QFSPublicAccountStaggeredSinglePYMKItemView", 1, "[bindData] get data from blockData");
        }
        if (this.mItemContainer == null) {
            QFSAsyncUtils.executeSub(new b(objData, this), new Void[0]);
        } else {
            p0();
        }
    }
}
