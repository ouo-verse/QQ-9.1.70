package com.qzone.reborn.feedpro.widget.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.detail.DetailUtil;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.reborn.base.n;
import com.qzone.reborn.feedpro.utils.aa;
import com.qzone.reborn.feedpro.utils.ap;
import com.qzone.reborn.feedpro.utils.r;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailReplyItemView;
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
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import de.d;
import de.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rn.h;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BB\u0011\b\u0007\u0012\u0006\u0010>\u001a\u00020=\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001a\u0010\u001c\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010<\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006C"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProDetailReplyItemView;", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProDetailBaseCommentItemView;", "Landroid/view/View$OnClickListener;", "", "J0", "F0", "", "", "", "H0", "M0", "O0", "content", "P0", "nickName", "E0", "N0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "likeInfo", "Q0", "S0", "I0", "getLogTag", "", "getLayoutId", "Lwd/c;", "objData", c.G, "o0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAvatar", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "mTvNickname", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mTvContent", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "mCommentLikeLayout", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mIvCommentLike", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mTvLikeNum", "G", "mTvTime", "H", "Lwd/c;", "mReplyInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProDetailReplyItemView extends QzoneFeedProDetailBaseCommentItemView implements View.OnClickListener {

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
    private wd.c mReplyInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mAvatar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView mTvNickname;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QzoneFeedProDetailReplyItemView$b", "Lcom/qzone/reborn/base/n$a;", "", "t", "", "retCode", "", "msg", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<Boolean> {
        b() {
        }

        public void a(boolean t16, long retCode, String msg2, boolean isFinish) {
            CommonReply mReply;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QzoneFeedProDetailReplyItemView qzoneFeedProDetailReplyItemView = QzoneFeedProDetailReplyItemView.this;
            wd.c cVar = qzoneFeedProDetailReplyItemView.mReplyInfo;
            qzoneFeedProDetailReplyItemView.Q0((cVar == null || (mReply = cVar.getMReply()) == null) ? null : mReply.getLike());
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            CommonReply mReply;
            QQToastUtil.showQQToast(0, QzoneFeedProDetailReplyItemView.this.getContext().getString(R.string.f133315s));
            QzoneFeedProDetailReplyItemView qzoneFeedProDetailReplyItemView = QzoneFeedProDetailReplyItemView.this;
            wd.c cVar = qzoneFeedProDetailReplyItemView.mReplyInfo;
            qzoneFeedProDetailReplyItemView.Q0((cVar == null || (mReply = cVar.getMReply()) == null) ? null : mReply.getLike());
        }

        @Override // com.qzone.reborn.base.n.a
        public /* bridge */ /* synthetic */ void onSuccess(Boolean bool, long j3, String str, boolean z16) {
            a(bool.booleanValue(), j3, str, z16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProDetailReplyItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        J0();
    }

    private final String E0(String nickName) {
        CommonReply mReply;
        StringBuilder sb5 = new StringBuilder();
        wd.c cVar = this.mReplyInfo;
        if (cVar != null && (mReply = cVar.getMReply()) != null) {
            CommonUser targetUser = mReply.getTargetUser();
            String uin = targetUser != null ? targetUser.getUin() : null;
            CommonUser user = mReply.getUser();
            if (!Intrinsics.areEqual(uin, user != null ? user.getUin() : null)) {
                sb5.append(nickName);
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    private final void F0() {
        String str;
        CommonReply mReply;
        String id5;
        CommonComment mComment;
        if (getMFeedData() == null) {
            return;
        }
        String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
        wd.c cVar = this.mReplyInfo;
        String str2 = "";
        if (cVar == null || (mComment = cVar.getMComment()) == null || (str = mComment.getId()) == null) {
            str = "";
        }
        wd.c cVar2 = this.mReplyInfo;
        if (cVar2 != null && (mReply = cVar2.getMReply()) != null && (id5 = mReply.getId()) != null) {
            str2 = id5;
        }
        final String str3 = feedUniqueKey + str + str2;
        RFWIocAbilityProvider.g().getIoc(e.class).originView(this).done(new OnPromiseResolved() { // from class: se.y
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                QzoneFeedProDetailReplyItemView.G0(QzoneFeedProDetailReplyItemView.this, str3, (de.e) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(QzoneFeedProDetailReplyItemView this$0, String reuseKey, e reportIoc) {
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

    private final Map<String, Object> H0() {
        HashMap hashMap = new HashMap();
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_HIGHLIGHT, "0");
        return hashMap;
    }

    private final void I0() {
        CommonReply mReply;
        CommonLike like;
        StLike pb5;
        if (getMFeedData() != null) {
            wd.c cVar = this.mReplyInfo;
            if ((cVar != null ? cVar.getMComment() : null) != null) {
                wd.c cVar2 = this.mReplyInfo;
                if ((cVar2 != null ? cVar2.getMReply() : null) != null) {
                    wd.c cVar3 = this.mReplyInfo;
                    CommonLike common2 = (cVar3 == null || (mReply = cVar3.getMReply()) == null || (like = mReply.getLike()) == null || (pb5 = CommonLikeKt.toPb(like)) == null) ? null : CommonLikeKt.toCommon(pb5);
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
                    Q0(common2);
                    b bVar = new b();
                    d r06 = r0();
                    if (r06 != null) {
                        CommonFeed mFeedData = getMFeedData();
                        Intrinsics.checkNotNull(mFeedData);
                        wd.c cVar4 = this.mReplyInfo;
                        CommonComment mComment = cVar4 != null ? cVar4.getMComment() : null;
                        Intrinsics.checkNotNull(mComment);
                        wd.c cVar5 = this.mReplyInfo;
                        CommonReply mReply2 = cVar5 != null ? cVar5.getMReply() : null;
                        Intrinsics.checkNotNull(mReply2);
                        r06.F4(mFeedData, mComment, mReply2, status, bVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List K0(QzoneFeedProDetailReplyItemView this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return xd.c.f(list, r.f54359a.b(this$0.getContext()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List L0(QZoneRichTextView this_apply, List list) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        return xd.c.f(list, r.f54359a.b(this_apply.getContext()), false);
    }

    private final void M0() {
        CommonReply mReply;
        CommonUser user;
        QZoneUserAvatarView qZoneUserAvatarView;
        wd.c cVar = this.mReplyInfo;
        if (cVar == null || (mReply = cVar.getMReply()) == null || (user = mReply.getUser()) == null) {
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

    private final void N0() {
        CommonReply mReply;
        String str;
        wd.c cVar = this.mReplyInfo;
        if (cVar == null || (mReply = cVar.getMReply()) == null) {
            return;
        }
        wd.c cVar2 = this.mReplyInfo;
        QZoneRichTextView qZoneRichTextView = null;
        CommonComment mComment = cVar2 != null ? cVar2.getMComment() : null;
        String msgToString = CommonFeedDataUtilKt.msgToString(mReply.getContent());
        boolean isEmpty = TextUtils.isEmpty(msgToString);
        QZoneRichTextView qZoneRichTextView2 = this.mTvContent;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView2 = null;
        }
        qZoneRichTextView2.setVisibility(isEmpty ? 8 : 0);
        QZoneRichTextView qZoneRichTextView3 = this.mTvContent;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView3 = null;
        }
        qZoneRichTextView3.setUrlColorRes(getResources().getColor(R.color.qui_common_text_secondary));
        StringBuilder sb5 = new StringBuilder();
        String str2 = "";
        if (mComment != null) {
            sb5.append("\u56de\u590d");
            CommonUser targetUser = mReply.getTargetUser();
            long k3 = ef.d.k(targetUser != null ? targetUser.getUin() : null);
            CommonUser targetUser2 = mReply.getTargetUser();
            if (targetUser2 == null || (str = targetUser2.getNick()) == null) {
                str = "";
            }
            sb5.append(DetailUtil.buildNicknameString(k3, str));
            sb5.append(MsgSummary.STR_COLON);
        }
        sb5.append(msgToString);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        QZoneRichTextView qZoneRichTextView4 = this.mTvContent;
        if (qZoneRichTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView4 = null;
        }
        qZoneRichTextView4.setDrawBackground(true);
        QZoneRichTextView qZoneRichTextView5 = this.mTvContent;
        if (qZoneRichTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView5 = null;
        }
        qZoneRichTextView5.setColorBackground(getResources().getColor(R.color.qui_common_fill_light_secondary_pressed));
        QZoneRichTextView qZoneRichTextView6 = this.mTvContent;
        if (qZoneRichTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView6 = null;
        }
        if (isEmpty) {
            sb6 = "";
        }
        qZoneRichTextView6.setRichText(sb6);
        if (i.H().S0()) {
            QZoneRichTextView qZoneRichTextView7 = this.mTvContent;
            if (qZoneRichTextView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            } else {
                qZoneRichTextView = qZoneRichTextView7;
            }
            if (!isEmpty) {
                str2 = DetailUtil.EmoCode2Text(msgToString);
            }
            qZoneRichTextView.setContentDescription(str2);
        }
    }

    private final void O0() {
        CommonReply mReply;
        CommonUser user;
        wd.c cVar = this.mReplyInfo;
        if (cVar == null || (mReply = cVar.getMReply()) == null || (user = mReply.getUser()) == null) {
            return;
        }
        String nickName = DetailUtil.buildNicknameString(ef.d.k(user.getUin()), user.getNick());
        Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
        P0(E0(nickName));
    }

    private final void P0(String content) {
        String str;
        CommonReply mReply;
        QZoneNickNameView qZoneNickNameView = this.mTvNickname;
        QZoneNickNameView qZoneNickNameView2 = null;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNickname");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setRichText(content);
        if (i.H().S0()) {
            wd.c cVar = this.mReplyInfo;
            if (cVar == null || (mReply = cVar.getMReply()) == null) {
                str = null;
            } else {
                CommonUser user = mReply.getUser();
                String nick = user != null ? user.getNick() : null;
                CommonUser targetUser = mReply.getTargetUser();
                str = DetailUtil.EmoCode2Text(nick + "\u56de\u590d" + (targetUser != null ? targetUser.getNick() : null));
            }
            if (str == null) {
                str = "";
            }
            QZoneNickNameView qZoneNickNameView3 = this.mTvNickname;
            if (qZoneNickNameView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvNickname");
            } else {
                qZoneNickNameView2 = qZoneNickNameView3;
            }
            qZoneNickNameView2.setContentDescription(str);
        }
    }

    private final void S0() {
        CommonReply mReply;
        TextView textView = this.mTvTime;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvTime");
            textView = null;
        }
        wd.c cVar = this.mReplyInfo;
        textView.setText(CommonFeedDataUtilKt.formatTimestamp((cVar == null || (mReply = cVar.getMReply()) == null) ? 0L : mReply.getTime()));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f130498x;
    }

    @Override // com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailBaseCommentItemView
    protected String getLogTag() {
        return "QzoneFeedProDetailReplyItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailBaseCommentItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0 */
    public void bindData(wd.c objData, int pos) {
        CommonReply mReply;
        super.bindData(objData, pos);
        if (objData == null) {
            return;
        }
        this.mReplyInfo = objData;
        M0();
        O0();
        N0();
        wd.c cVar = this.mReplyInfo;
        Q0((cVar == null || (mReply = cVar.getMReply()) == null) ? null : mReply.getLike());
        S0();
        F0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.met) {
            I0();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(CommonLike likeInfo) {
        String string;
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
            LinearLayout linearLayout3 = this.mCommentLikeLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentLikeLayout");
                linearLayout3 = null;
            }
            linearLayout3.setOnClickListener(this);
            LinearLayout linearLayout4 = this.mCommentLikeLayout;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentLikeLayout");
                linearLayout4 = null;
            }
            p0(linearLayout4);
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
                h.a(imageView3, "qui_like_filled_qzone_new", R.color.qui_common_icon_aio_nav_active);
            } else {
                ImageView imageView4 = this.mIvCommentLike;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvCommentLike");
                    imageView4 = null;
                }
                h.a(imageView4, "qui_like_qzone_new", R.color.qui_common_text_primary);
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
            textView.setText(com.qzone.proxy.feedcomponent.util.d.l(likeInfo.getCount()));
            TextView textView2 = this.mTvLikeNum;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLikeNum");
                textView2 = null;
            }
            textView2.setVisibility(likeInfo.getCount() > 0 ? 0 : 8);
        } else {
            LinearLayout linearLayout5 = this.mCommentLikeLayout;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommentLikeLayout");
                linearLayout5 = null;
            }
            linearLayout5.setVisibility(8);
        }
        LinearLayout linearLayout6 = this.mCommentLikeLayout;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentLikeLayout");
        } else {
            linearLayout = linearLayout6;
        }
        if (likeInfo.getStatus() == 1) {
            string = getResources().getString(R.string.jkb);
        } else {
            string = getResources().getString(R.string.f2202368k);
        }
        AccessibilityUtil.c(linearLayout, string, Button.class.getName());
    }

    private final void J0() {
        View findViewById = findViewById(R.id.nby);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_user_avatar)");
        this.mAvatar = (QZoneUserAvatarView) findViewById;
        View findViewById2 = findViewById(R.id.n87);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_nike_name_tv)");
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
        QZoneNickNameView qZoneNickNameView = this.mTvNickname;
        QZoneRichTextView qZoneRichTextView = null;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNickname");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setMaxLine(1);
        QZoneNickNameView qZoneNickNameView2 = this.mTvNickname;
        if (qZoneNickNameView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNickname");
            qZoneNickNameView2 = null;
        }
        qZoneNickNameView2.setParseUrl(false);
        QZoneNickNameView qZoneNickNameView3 = this.mTvNickname;
        if (qZoneNickNameView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNickname");
            qZoneNickNameView3 = null;
        }
        qZoneNickNameView3.setDrawBackground(true);
        QZoneNickNameView qZoneNickNameView4 = this.mTvNickname;
        if (qZoneNickNameView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNickname");
            qZoneNickNameView4 = null;
        }
        r rVar = r.f54359a;
        qZoneNickNameView4.setTextColorLink(rVar.b(getContext()));
        QZoneNickNameView qZoneNickNameView5 = this.mTvNickname;
        if (qZoneNickNameView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNickname");
            qZoneNickNameView5 = null;
        }
        qZoneNickNameView5.setTextColorLinkBackground(rVar.a(getContext()));
        QZoneNickNameView qZoneNickNameView6 = this.mTvNickname;
        if (qZoneNickNameView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNickname");
            qZoneNickNameView6 = null;
        }
        qZoneNickNameView6.setPreDecorateListener(new CellTextView.d() { // from class: se.z
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List K0;
                K0 = QzoneFeedProDetailReplyItemView.K0(QzoneFeedProDetailReplyItemView.this, list);
                return K0;
            }
        });
        final QZoneRichTextView qZoneRichTextView2 = this.mTvContent;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView2 = null;
        }
        qZoneRichTextView2.setPreDecorateListener(new CellTextView.d() { // from class: se.aa
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List L0;
                L0 = QzoneFeedProDetailReplyItemView.L0(QZoneRichTextView.this, list);
                return L0;
            }
        });
        QZoneRichTextView qZoneRichTextView3 = this.mTvContent;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView3 = null;
        }
        qZoneRichTextView3.setTextColorLink(rVar.b(getContext()));
        QZoneRichTextView qZoneRichTextView4 = this.mTvContent;
        if (qZoneRichTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView4 = null;
        }
        qZoneRichTextView4.setTextColorLinkBackground(rVar.a(getContext()));
        QZoneRichTextView qZoneRichTextView5 = this.mTvContent;
        if (qZoneRichTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView5 = null;
        }
        qZoneRichTextView5.setLineSpace(com.qzone.reborn.util.r.f59560a.e(4));
        QZoneRichTextView qZoneRichTextView6 = this.mTvContent;
        if (qZoneRichTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView6 = null;
        }
        qZoneRichTextView6.setMaxCommentLine(2);
        QZoneRichTextView qZoneRichTextView7 = this.mTvContent;
        if (qZoneRichTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView7 = null;
        }
        qZoneRichTextView7.setEllipsisStr(l.a(R.string.jmx));
        QZoneRichTextView qZoneRichTextView8 = this.mTvContent;
        if (qZoneRichTextView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            qZoneRichTextView8 = null;
        }
        qZoneRichTextView8.setMoreCellColor(rVar.b(getContext()));
        QZoneRichTextView qZoneRichTextView9 = this.mTvContent;
        if (qZoneRichTextView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
        } else {
            qZoneRichTextView = qZoneRichTextView9;
        }
        w0(qZoneRichTextView);
    }
}
