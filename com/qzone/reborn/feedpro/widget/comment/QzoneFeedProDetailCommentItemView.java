package com.qzone.reborn.feedpro.widget.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.detail.DetailUtil;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.reborn.base.n;
import com.qzone.reborn.feedpro.utils.aa;
import com.qzone.reborn.feedpro.utils.ap;
import com.qzone.reborn.feedpro.utils.r;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailCommentItemView;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.util.l;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonLikeKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import de.a;
import de.d;
import de.e;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rn.h;
import se.m;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001QB\u0013\b\u0007\u0012\b\b\u0001\u0010M\u001a\u00020L\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001a\u0010\u001c\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006R"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProDetailCommentItemView;", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProDetailBaseCommentItemView;", "Landroid/view/View$OnClickListener;", "", "J0", "U0", "F0", "", "", "", "H0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "P0", "N0", "S0", "Q0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "likeInfo", "O0", "T0", "I0", "getLogTag", "", "getLayoutId", "Lwd/c;", "objData", com.tencent.luggage.wxa.c8.c.G, "o0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAvatar", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "mTvNickname", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mTvContent", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "mCommentLikeLayout", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mIvCommentLike", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mTvLikeNum", "G", "mTvTime", "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "mCommentPictureGridView", "I", "Landroid/view/View;", "mTopDividerLineView", "Landroid/widget/FrameLayout;", "J", "Landroid/widget/FrameLayout;", "mFlPicListView", "K", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "mComment", "Lse/m;", "L", "Lse/m;", "mCommentImageAdapter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "M", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProDetailCommentItemView extends QzoneFeedProDetailBaseCommentItemView implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneRichTextView mTvContent;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout mCommentLikeLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mIvCommentLike;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mTvLikeNum;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mTvTime;

    /* renamed from: H, reason: from kotlin metadata */
    private RecyclerView mCommentPictureGridView;

    /* renamed from: I, reason: from kotlin metadata */
    private View mTopDividerLineView;

    /* renamed from: J, reason: from kotlin metadata */
    private FrameLayout mFlPicListView;

    /* renamed from: K, reason: from kotlin metadata */
    private CommonComment mComment;

    /* renamed from: L, reason: from kotlin metadata */
    private m mCommentImageAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mAvatar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView mTvNickname;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QzoneFeedProDetailCommentItemView$b", "Lcom/qzone/reborn/base/n$a;", "", "t", "", "retCode", "", "msg", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<Boolean> {
        b() {
        }

        public void a(boolean t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QzoneFeedProDetailCommentItemView qzoneFeedProDetailCommentItemView = QzoneFeedProDetailCommentItemView.this;
            CommonComment commonComment = qzoneFeedProDetailCommentItemView.mComment;
            qzoneFeedProDetailCommentItemView.O0(commonComment != null ? commonComment.getLike() : null);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            QQToastUtil.showQQToast(0, QzoneFeedProDetailCommentItemView.this.getContext().getString(R.string.f133315s));
            QzoneFeedProDetailCommentItemView qzoneFeedProDetailCommentItemView = QzoneFeedProDetailCommentItemView.this;
            CommonComment commonComment = qzoneFeedProDetailCommentItemView.mComment;
            qzoneFeedProDetailCommentItemView.O0(commonComment != null ? commonComment.getLike() : null);
        }

        @Override // com.qzone.reborn.base.n.a
        public /* bridge */ /* synthetic */ void onSuccess(Boolean bool, long j3, String str, boolean z16) {
            a(bool.booleanValue(), j3, str, z16);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QzoneFeedProDetailCommentItemView$c", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProCommentImageItem$b;", "Landroid/view/View;", "v", "", com.tencent.luggage.wxa.c8.c.G, "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements QzoneFeedProCommentImageItem.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonComment f54513b;

        c(CommonComment commonComment) {
            this.f54513b = commonComment;
        }

        @Override // com.qzone.reborn.feedpro.widget.comment.QzoneFeedProCommentImageItem.b
        public void a(View v3, int pos) {
            Intrinsics.checkNotNullParameter(v3, "v");
            a q06 = QzoneFeedProDetailCommentItemView.this.q0();
            if (q06 != null) {
                q06.P1(v3, QzoneFeedProDetailCommentItemView.this.getMFeedData(), this.f54513b, null, pos);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProDetailCommentItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        J0();
    }

    private final void F0() {
        String str;
        if (getMFeedData() == null) {
            return;
        }
        String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
        CommonComment commonComment = this.mComment;
        if (commonComment == null || (str = commonComment.getId()) == null) {
            str = "";
        }
        final String str2 = feedUniqueKey + str;
        RFWIocAbilityProvider.g().getIoc(e.class).originView(this).done(new OnPromiseResolved() { // from class: se.v
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QzoneFeedProDetailCommentItemView.G0(QzoneFeedProDetailCommentItemView.this, str2, (de.e) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(QzoneFeedProDetailCommentItemView this$0, String reuseKey, e reportIoc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reuseKey, "$reuseKey");
        Intrinsics.checkNotNullParameter(reportIoc, "reportIoc");
        Map<String, ? extends Object> H0 = this$0.H0();
        QZoneRichTextView qZoneRichTextView = this$0.mTvContent;
        if (qZoneRichTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView = null;
        }
        reportIoc.a(qZoneRichTextView, "em_qz_comment_information", reuseKey, H0, this$0.getMFeedData());
    }

    private final void I0() {
        CommonComment commonComment;
        d r06;
        CommonLike like;
        StLike pb5;
        CommonComment commonComment2 = this.mComment;
        CommonLike common2 = (commonComment2 == null || (like = commonComment2.getLike()) == null || (pb5 = CommonLikeKt.toPb(like)) == null) ? null : CommonLikeKt.toCommon(pb5);
        if (common2 == null) {
            common2 = new CommonLike();
        }
        int status = common2.getStatus();
        if (common2.getStatus() == 1) {
            common2.setStatus(0);
            common2.setCount(common2.getCount() - 1);
        } else {
            common2.setStatus(1);
            common2.setCount(common2.getCount() + 1);
        }
        O0(common2);
        b bVar = new b();
        CommonFeed mFeedData = getMFeedData();
        if (mFeedData == null || (commonComment = this.mComment) == null || (r06 = r0()) == null) {
            return;
        }
        r06.R3(mFeedData, commonComment, status, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List K0(QZoneNickNameView this_apply, List list) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        return xd.c.f(list, r.f54359a.b(this_apply.getContext()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List L0(QZoneRichTextView this_apply, List list) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        return xd.c.f(list, r.f54359a.b(this_apply.getContext()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(QzoneFeedProDetailCommentItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N0() {
        CommonUser user;
        QZoneUserAvatarView qZoneUserAvatarView;
        CommonComment commonComment = this.mComment;
        if (commonComment == null || (user = commonComment.getUser()) == null) {
            return;
        }
        QZoneUserAvatarView qZoneUserAvatarView2 = this.mAvatar;
        if (qZoneUserAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            qZoneUserAvatarView2 = null;
        }
        qZoneUserAvatarView2.setUser(ef.d.k(user.getUin()));
        aa aaVar = aa.f54263a;
        QZoneUserAvatarView qZoneUserAvatarView3 = this.mAvatar;
        if (qZoneUserAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            qZoneUserAvatarView = null;
        } else {
            qZoneUserAvatarView = qZoneUserAvatarView3;
        }
        aa.i(aaVar, qZoneUserAvatarView, getContext(), 0, true, 2, null);
    }

    private final void Q0() {
        CommonComment commonComment = this.mComment;
        if (commonComment != null) {
            String msgToString = CommonFeedDataUtilKt.msgToString(commonComment.getContent());
            boolean isEmpty = TextUtils.isEmpty(msgToString);
            QZoneRichTextView qZoneRichTextView = this.mTvContent;
            if (qZoneRichTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
                qZoneRichTextView = null;
            }
            qZoneRichTextView.setVisibility(isEmpty ? 8 : 0);
            qZoneRichTextView.setUrlColorRes(qZoneRichTextView.getResources().getColor(R.color.qui_common_text_secondary));
            String str = "";
            qZoneRichTextView.setRichText(isEmpty ? "" : msgToString);
            if (i.H().S0()) {
                if (!isEmpty) {
                    str = DetailUtil.EmoCode2Text(msgToString);
                }
                qZoneRichTextView.setContentDescription(str);
            }
        }
    }

    private final void S0() {
        CommonUser user;
        CommonComment commonComment = this.mComment;
        if (commonComment == null || (user = commonComment.getUser()) == null) {
            return;
        }
        QZoneNickNameView qZoneNickNameView = this.mTvNickname;
        QZoneUserAvatarView qZoneUserAvatarView = null;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNickname");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setRichText(DetailUtil.buildNicknameString(ef.d.k(user.getUin()), user.getNick()));
        QZoneUserAvatarView qZoneUserAvatarView2 = this.mAvatar;
        if (qZoneUserAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
        } else {
            qZoneUserAvatarView = qZoneUserAvatarView2;
        }
        AccessibilityUtil.s(qZoneUserAvatarView, user.getNick() + l.a(R.string.gqz));
    }

    private final void T0() {
        CommonComment commonComment = this.mComment;
        if (commonComment != null) {
            TextView textView = this.mTvTime;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvTime");
                textView = null;
            }
            textView.setText(CommonFeedDataUtilKt.formatTimestamp(commonComment.getTime()));
        }
    }

    private final void U0() {
        View view = null;
        if (this.dataPosInList == 0) {
            View view2 = this.mTopDividerLineView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTopDividerLineView");
            } else {
                view = view2;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(0);
            layoutParams2.topMargin = ImmersiveUtils.dpToPx(6.0f);
            return;
        }
        View view3 = this.mTopDividerLineView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTopDividerLineView");
        } else {
            view = view3;
        }
        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.setMarginStart(ImmersiveUtils.dpToPx(40.0f));
        layoutParams4.topMargin = ImmersiveUtils.dpToPx(16.0f);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130478v;
    }

    @Override // com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailBaseCommentItemView
    protected String getLogTag() {
        return "QzoneFeedProDetailCommentItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailBaseCommentItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0 */
    public void bindData(wd.c objData, int pos) {
        super.bindData(objData, pos);
        if (objData == null) {
            return;
        }
        this.mComment = objData.getMComment();
        N0();
        S0();
        Q0();
        CommonComment commonComment = this.mComment;
        O0(commonComment != null ? commonComment.getLike() : null);
        T0();
        P0(this.mComment);
        U0();
        F0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.met) {
            I0();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    private final Map<String, Object> H0() {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_HIGHLIGHT, "0"));
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(CommonLike likeInfo) {
        if (likeInfo == null) {
            likeInfo = new CommonLike();
        }
        LinearLayout linearLayout = null;
        if (ap.f54313a.d(getMFeedData())) {
            LinearLayout linearLayout2 = this.mCommentLikeLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentLikeLayout");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(0);
            linearLayout2.setOnClickListener(this);
            p0(linearLayout2);
            ImageView imageView = this.mIvCommentLike;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvCommentLike");
                imageView = null;
            }
            imageView.setSelected(likeInfo.getStatus() == 1);
            ImageView imageView2 = this.mIvCommentLike;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvCommentLike");
                imageView2 = null;
            }
            if (imageView2.isSelected()) {
                ImageView imageView3 = this.mIvCommentLike;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvCommentLike");
                    imageView3 = null;
                }
                h.a(imageView3, "qui_like_filled_qzone", R.color.qui_common_icon_aio_nav_active);
            } else {
                ImageView imageView4 = this.mIvCommentLike;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvCommentLike");
                    imageView4 = null;
                }
                h.a(imageView4, "qui_like", R.color.qui_common_text_primary);
            }
            aa aaVar = aa.f54263a;
            ImageView imageView5 = this.mIvCommentLike;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvCommentLike");
                imageView5 = null;
            }
            aa.c(aaVar, imageView5, 0.0f, 1, null);
            TextView textView = this.mTvLikeNum;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
                textView = null;
            }
            textView.setVisibility(likeInfo.getCount() > 0 ? 0 : 8);
            textView.setText(com.qzone.proxy.feedcomponent.util.d.l(likeInfo.getCount()));
        } else {
            LinearLayout linearLayout3 = this.mCommentLikeLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentLikeLayout");
                linearLayout3 = null;
            }
            linearLayout3.setVisibility(8);
        }
        LinearLayout linearLayout4 = this.mCommentLikeLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentLikeLayout");
        } else {
            linearLayout = linearLayout4;
        }
        AccessibilityUtil.c(linearLayout, getContext().getString(likeInfo.getStatus() == 1 ? R.string.jkb : R.string.f2202368k), Button.class.getName());
    }

    private final void J0() {
        View findViewById = findViewById(R.id.nby);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_user_avatar)");
        this.mAvatar = (QZoneUserAvatarView) findViewById;
        View findViewById2 = findViewById(R.id.mrw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_comment_nickname_view)");
        this.mTvNickname = (QZoneNickNameView) findViewById2;
        View findViewById3 = findViewById(R.id.nbg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_text_content_tv)");
        this.mTvContent = (QZoneRichTextView) findViewById3;
        View findViewById4 = findViewById(R.id.met);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ll_comment_like_layout)");
        this.mCommentLikeLayout = (LinearLayout) findViewById4;
        View findViewById5 = findViewById(R.id.lq8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_qzone_comment_like)");
        this.mIvCommentLike = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.f162959nj4);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_like_num)");
        this.mTvLikeNum = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.nic);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_comment_time)");
        this.mTvTime = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.mt5);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.qzone_comment_top_divider_line)");
        this.mTopDividerLineView = findViewById8;
        final QZoneNickNameView qZoneNickNameView = this.mTvNickname;
        FrameLayout frameLayout = null;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNickname");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setMaxLine(1);
        qZoneNickNameView.setParseUrl(false);
        qZoneNickNameView.setDrawBackground(true);
        qZoneNickNameView.setPreDecorateListener(new CellTextView.d() { // from class: se.s
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List K0;
                K0 = QzoneFeedProDetailCommentItemView.K0(QZoneNickNameView.this, list);
                return K0;
            }
        });
        r rVar = r.f54359a;
        qZoneNickNameView.setTextColorLink(rVar.b(qZoneNickNameView.getContext()));
        qZoneNickNameView.setTextColorLinkBackground(rVar.a(qZoneNickNameView.getContext()));
        final QZoneRichTextView qZoneRichTextView = this.mTvContent;
        if (qZoneRichTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView = null;
        }
        qZoneRichTextView.setPreDecorateListener(new CellTextView.d() { // from class: se.t
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List L0;
                L0 = QzoneFeedProDetailCommentItemView.L0(QZoneRichTextView.this, list);
                return L0;
            }
        });
        qZoneRichTextView.setUrlColorRes(qZoneRichTextView.getContext().getColor(R.color.qui_common_text_secondary));
        qZoneRichTextView.setTextColorLink(rVar.b(qZoneRichTextView.getContext()));
        qZoneRichTextView.setTextColorLinkBackground(rVar.a(qZoneRichTextView.getContext()));
        qZoneRichTextView.setLineSpace(com.qzone.reborn.util.r.f59560a.e(4));
        qZoneRichTextView.setMaxCommentLine(2);
        qZoneRichTextView.setEllipsisStr(l.a(R.string.jmx));
        qZoneRichTextView.setMoreCellColor(rVar.b(qZoneRichTextView.getContext()));
        QZoneRichTextView qZoneRichTextView2 = this.mTvContent;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView2 = null;
        }
        w0(qZoneRichTextView2);
        View findViewById9 = findViewById(R.id.msz);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.qzone_comment_picture_grid)");
        RecyclerView recyclerView = (RecyclerView) findViewById9;
        this.mCommentPictureGridView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentPictureGridView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        View findViewById10 = findViewById(R.id.jil);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.fl_pic_list_view)");
        FrameLayout frameLayout2 = (FrameLayout) findViewById10;
        this.mFlPicListView = frameLayout2;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlPicListView");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: se.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFeedProDetailCommentItemView.M0(QzoneFeedProDetailCommentItemView.this, view);
            }
        });
    }

    private final void P0(CommonComment comment) {
        RecyclerView recyclerView = null;
        List<CommonMedia> mediaItems = comment != null ? comment.getMediaItems() : null;
        if (bl.b(mediaItems)) {
            if (this.mCommentPictureGridView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentPictureGridView");
            }
            RecyclerView recyclerView2 = this.mCommentPictureGridView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentPictureGridView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView3 = this.mCommentPictureGridView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentPictureGridView");
            recyclerView3 = null;
        }
        recyclerView3.setVisibility(0);
        m mVar = this.mCommentImageAdapter;
        if (mVar == null) {
            mVar = new m();
            mVar.j0(new c(comment));
            RecyclerView recyclerView4 = this.mCommentPictureGridView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentPictureGridView");
            } else {
                recyclerView = recyclerView4;
            }
            recyclerView.setAdapter(mVar);
        }
        this.mCommentImageAdapter = mVar;
        mVar.i0(comment);
        mVar.setDatas(mediaItems);
    }
}
