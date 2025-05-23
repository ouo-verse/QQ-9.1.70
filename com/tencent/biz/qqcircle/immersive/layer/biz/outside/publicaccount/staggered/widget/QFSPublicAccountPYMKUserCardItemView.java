package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.widget.QFSPublicAccountPYMKUserCardItemView;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleDitto$StItemInfo;
import tl.h;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u00109\u001a\u000208\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J.\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001c\u00107\u001a\b\u0012\u0004\u0012\u000204038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/widget/QFSPublicAccountPYMKUserCardItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "Lqqcircle/QQCircleDitto$StItemInfo;", "", "initView", "w0", "r0", "q0", "u0", "Landroid/view/View;", "view", "", "elementId", "", "", "params", "o0", NodeProps.ON_ATTACHED_TO_WINDOW, "", "getLayoutId", "objData", c.G, "n0", "Lfeedcloud/FeedCloudMeta$StFeed;", "d", "Lfeedcloud/FeedCloudMeta$StFeed;", "getMFeed", "()Lfeedcloud/FeedCloudMeta$StFeed;", "setMFeed", "(Lfeedcloud/FeedCloudMeta$StFeed;)V", "mFeed", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "e", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "mAvatar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mNickname", h.F, "mRecommendReason", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", "i", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", "mFollowBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqqcircle/QQCircleDitto$StItemInfo;", "mUser", BdhLogUtil.LogTag.Tag_Conn, "I", "mPos", "", "Lfeedcloud/FeedCloudCommon$Entry;", "D", "Ljava/util/List;", "mUserUrlInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountPYMKUserCardItemView extends QCircleBaseWidgetView<QQCircleDitto$StItemInfo> {

    /* renamed from: C, reason: from kotlin metadata */
    private int mPos;

    /* renamed from: D, reason: from kotlin metadata */
    private List<FeedCloudCommon$Entry> mUserUrlInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mFeed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QCircleAvatarView mAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mNickname;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mRecommendReason;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QFSFollowView mFollowBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QQCircleDitto$StItemInfo mUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPublicAccountPYMKUserCardItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    private final void initView() {
        View findViewById = findViewById(R.id.f498923x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_pu\u2026nt_pymk_list_item_avatar)");
        this.mAvatar = (QCircleAvatarView) findViewById;
        View findViewById2 = findViewById(R.id.f4992240);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_pu\u2026_pymk_list_item_nickname)");
        this.mNickname = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f4993241);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_pu\u2026k_list_item_recom_reason)");
        this.mRecommendReason = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f499123z);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_pu\u2026nt_pymk_list_item_follow)");
        this.mFollowBtn = (QFSFollowView) findViewById4;
    }

    private final void o0(View view, String elementId, Map<String, ? extends Object> params) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(view, params);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void p0(QFSPublicAccountPYMKUserCardItemView qFSPublicAccountPYMKUserCardItemView, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        qFSPublicAccountPYMKUserCardItemView.o0(view, str, map);
    }

    private final void q0() {
        Context context = getContext();
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.mUser;
        if (qQCircleDitto$StItemInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUser");
            qQCircleDitto$StItemInfo = null;
        }
        qCircleInitBean.setUin(qQCircleDitto$StItemInfo.f429300id.get());
        setReportBean(getReportBean());
        com.tencent.biz.qqcircle.launcher.c.d0(context, qCircleInitBean);
    }

    private final void r0() {
        QCircleAvatarView qCircleAvatarView;
        List<FeedCloudCommon$Entry> list = this.mUserUrlInfo;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserUrlInfo");
            list = null;
        }
        String d16 = bh.d(list, "user_avatar_url");
        QCircleAvatarView qCircleAvatarView2 = this.mAvatar;
        if (qCircleAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            qCircleAvatarView2 = null;
        }
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.mUser;
        if (qQCircleDitto$StItemInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUser");
            qQCircleDitto$StItemInfo = null;
        }
        qCircleAvatarView2.setAvatar(d16, qQCircleDitto$StItemInfo.f429300id.get(), n.a(getContext(), 36));
        QCircleAvatarView qCircleAvatarView3 = this.mAvatar;
        if (qCircleAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            qCircleAvatarView3 = null;
        }
        qCircleAvatarView3.setOnClickListener(new View.OnClickListener() { // from class: k50.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountPYMKUserCardItemView.s0(QFSPublicAccountPYMKUserCardItemView.this, view);
            }
        });
        QCircleAvatarView qCircleAvatarView4 = this.mAvatar;
        if (qCircleAvatarView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            qCircleAvatarView = null;
        } else {
            qCircleAvatarView = qCircleAvatarView4;
        }
        p0(this, qCircleAvatarView, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_AUTHOR_AVATAR, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(QFSPublicAccountPYMKUserCardItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g gVar = g.f87070a;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.mFeed;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this$0.mUser;
        if (qQCircleDitto$StItemInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUser");
            qQCircleDitto$StItemInfo = null;
        }
        gVar.d(feedCloudMeta$StFeed, 10, qQCircleDitto$StItemInfo, this$0.getPageId(), this$0.mPos);
        this$0.q0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u0() {
        final Map<String, ? extends Object> mapOf;
        QFSFollowView qFSFollowView = this.mFollowBtn;
        QFSFollowView qFSFollowView2 = null;
        if (qFSFollowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            qFSFollowView = null;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        PBStringField pBStringField = feedCloudMeta$StUser.f398463id;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.mUser;
        if (qQCircleDitto$StItemInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUser");
            qQCircleDitto$StItemInfo = null;
        }
        pBStringField.set(qQCircleDitto$StItemInfo.f429300id.get());
        PBUInt32Field pBUInt32Field = feedCloudMeta$StUser.followState;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo2 = this.mUser;
        if (qQCircleDitto$StItemInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUser");
            qQCircleDitto$StItemInfo2 = null;
        }
        pBUInt32Field.set(qQCircleDitto$StItemInfo2.buttonInfo.buttonValue.get());
        qFSFollowView.setUserData(feedCloudMeta$StUser);
        Pair[] pairArr = new Pair[2];
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo3 = this.mUser;
        if (qQCircleDitto$StItemInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUser");
            qQCircleDitto$StItemInfo3 = null;
        }
        pairArr[0] = TuplesKt.to(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, r.F(qQCircleDitto$StItemInfo3.buttonInfo.buttonValue.get()));
        pairArr[1] = TuplesKt.to("dt_pgid", QCircleDaTongConstant.PageId.PG_XSJ_GZH_DOUBLE_COLUMN_PAGE);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        QFSFollowView qFSFollowView3 = this.mFollowBtn;
        if (qFSFollowView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            qFSFollowView3 = null;
        }
        o0(qFSFollowView3, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON, mapOf);
        QFSFollowView qFSFollowView4 = this.mFollowBtn;
        if (qFSFollowView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
        } else {
            qFSFollowView2 = qFSFollowView4;
        }
        qFSFollowView2.setFollowStateChangeListener(new QFSFollowView.c() { // from class: k50.a
            @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.c
            public final void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser2) {
                QFSPublicAccountPYMKUserCardItemView.v0(QFSPublicAccountPYMKUserCardItemView.this, mapOf, z16, feedCloudMeta$StUser2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(QFSPublicAccountPYMKUserCardItemView this$0, Map followBtnParam, boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(followBtnParam, "$followBtnParam");
        if (z16) {
            g gVar = g.f87070a;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.mFeed;
            QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo2 = this$0.mUser;
            QFSFollowView qFSFollowView = null;
            if (qQCircleDitto$StItemInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUser");
                qQCircleDitto$StItemInfo = null;
            } else {
                qQCircleDitto$StItemInfo = qQCircleDitto$StItemInfo2;
            }
            gVar.d(feedCloudMeta$StFeed, 2, qQCircleDitto$StItemInfo, this$0.getPageId(), this$0.mPos);
            QFSFollowView qFSFollowView2 = this$0.mFollowBtn;
            if (qFSFollowView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            } else {
                qFSFollowView = qFSFollowView2;
            }
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, qFSFollowView, followBtnParam);
        }
    }

    private final void w0() {
        TextView textView;
        TextView textView2 = this.mNickname;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickname");
            textView2 = null;
        }
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.mUser;
        if (qQCircleDitto$StItemInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUser");
            qQCircleDitto$StItemInfo = null;
        }
        textView2.setText(qQCircleDitto$StItemInfo.name.get());
        TextView textView3 = this.mNickname;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickname");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: k50.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountPYMKUserCardItemView.x0(QFSPublicAccountPYMKUserCardItemView.this, view);
            }
        });
        TextView textView4 = this.mNickname;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickname");
            textView = null;
        } else {
            textView = textView4;
        }
        p0(this, textView, QCircleDaTongConstant.ElementId.EM_XSJ_PYMK_AUTHOR_NAME, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(QFSPublicAccountPYMKUserCardItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g gVar = g.f87070a;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.mFeed;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this$0.mUser;
        if (qQCircleDitto$StItemInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUser");
            qQCircleDitto$StItemInfo = null;
        }
        gVar.d(feedCloudMeta$StFeed, 11, qQCircleDitto$StItemInfo, this$0.getPageId(), this$0.mPos);
        this$0.q0();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.go5;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(@NotNull QQCircleDitto$StItemInfo objData, int pos) {
        String str;
        Intrinsics.checkNotNullParameter(objData, "objData");
        this.mUser = objData;
        this.mPos = pos;
        List<FeedCloudCommon$Entry> list = objData.urlInfo.get();
        Intrinsics.checkNotNullExpressionValue(list, "objData.urlInfo.get()");
        this.mUserUrlInfo = list;
        TextView textView = this.mRecommendReason;
        List<String> list2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendReason");
            textView = null;
        }
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.mUser;
        if (qQCircleDitto$StItemInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUser");
            qQCircleDitto$StItemInfo = null;
        }
        List<String> it = qQCircleDitto$StItemInfo.des.get();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!it.isEmpty()) {
            list2 = it;
        }
        if (list2 == null || (str = list2.get(0)) == null) {
            str = "";
        }
        textView.setText(str);
        w0();
        r0();
        u0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g gVar = g.f87070a;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.mUser;
        if (qQCircleDitto$StItemInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUser");
            qQCircleDitto$StItemInfo = null;
        }
        gVar.d(feedCloudMeta$StFeed, 1, qQCircleDitto$StItemInfo, getPageId(), this.mPos);
    }

    public final void setMFeed(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mFeed = feedCloudMeta$StFeed;
    }
}
