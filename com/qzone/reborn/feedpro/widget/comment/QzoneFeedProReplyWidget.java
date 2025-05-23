package com.qzone.reborn.feedpro.widget.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.reborn.feedpro.bean.QzoneFeedProClickedComment;
import com.qzone.reborn.feedpro.utils.r;
import com.qzone.reborn.feedpro.utils.u;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProReplyWidget;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wd.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProReplyWidget;", "Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProBaseCommentWidget;", "", "z0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "reply", "", "nickName", "y0", "content", "B0", "getLogTag", "", "getLayoutId", "Lwd/a;", "commentReplyInfo", c.G, "x0", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mReplyContent", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProReplyWidget extends QzoneFeedProBaseCommentWidget {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView mReplyContent;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/feedpro/widget/comment/QzoneFeedProReplyWidget$b", "Lcom/qzone/proxy/feedcomponent/text/TextCellLayout$OnCellClickListener;", "Lcom/qzone/proxy/feedcomponent/text/TextCell;", "cell", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "Lcom/qzone/proxy/feedcomponent/text/CellTextView$OnTextOperater;", JsonRuleKey.OPERATOR, "", NodeProps.ON_LONG_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements TextCellLayout.OnCellClickListener {
        b() {
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public void onClick(TextCell cell, View view) {
            Intrinsics.checkNotNullParameter(cell, "cell");
            Intrinsics.checkNotNullParameter(view, "view");
            QZoneRichTextView qZoneRichTextView = QzoneFeedProReplyWidget.this.mReplyContent;
            QZoneRichTextView qZoneRichTextView2 = null;
            if (qZoneRichTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
                qZoneRichTextView = null;
            }
            qZoneRichTextView.k(cell);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Long uin = cell.getUin();
            Intrinsics.checkNotNullExpressionValue(uin, "cell.uin");
            linkedHashMap.put("touin", uin);
            fo.b l3 = new fo.b().l(linkedHashMap);
            QZoneRichTextView qZoneRichTextView3 = QzoneFeedProReplyWidget.this.mReplyContent;
            if (qZoneRichTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            } else {
                qZoneRichTextView2 = qZoneRichTextView3;
            }
            fo.c.b("dt_clck", qZoneRichTextView2, "em_qz_feed_comment_nickname", l3);
        }

        @Override // com.qzone.proxy.feedcomponent.text.TextCellLayout.OnCellClickListener
        public boolean onLongClick(View view, CellTextView.OnTextOperater operator) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(operator, "operator");
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProReplyWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List A0(QzoneFeedProReplyWidget this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return xd.c.f(list, r.f54359a.b(this$0.getContext()), false);
    }

    private final void B0(String content, CommonReply reply) {
        boolean isEmpty = TextUtils.isEmpty(CommonFeedDataUtilKt.msgToString(reply.getContent()));
        QZoneRichTextView qZoneRichTextView = this.mReplyContent;
        if (qZoneRichTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView = null;
        }
        if (isEmpty) {
            content = "";
        }
        qZoneRichTextView.setRichText(content);
    }

    private final String y0(CommonReply reply, String nickName) {
        StringBuilder sb5 = new StringBuilder();
        if (reply.getUser() != null && reply.getTargetUser() != null) {
            sb5.append(nickName);
            CommonUser user = reply.getUser();
            Intrinsics.checkNotNull(user);
            String uin = user.getUin();
            CommonUser targetUser = reply.getTargetUser();
            Intrinsics.checkNotNull(targetUser);
            if (!Intrinsics.areEqual(uin, targetUser.getUin())) {
                sb5.append("{text:");
                sb5.append(" \u56de\u590d ");
                sb5.append(",color:");
                sb5.append(Integer.toHexString(getResources().getColor(R.color.qui_common_text_primary)));
                sb5.append(",useDefaultFont:1,useSuperFont:0}");
                sb5.append(u.f54367a.b(reply.getTargetUser(), false, false));
                sb5.append(MsgSummary.STR_COLON);
            }
            sb5.append(CommonFeedDataUtilKt.msgToString(reply.getContent()));
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "content.toString()");
            return sb6;
        }
        return "";
    }

    private final void z0() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View findViewById = findViewById(R.id.naw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_reply_content)");
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) findViewById;
        this.mReplyContent = qZoneRichTextView;
        QZoneRichTextView qZoneRichTextView2 = null;
        if (qZoneRichTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView = null;
        }
        qZoneRichTextView.setLineSpace(ImmersiveUtils.dpToPx(2.0f));
        QZoneRichTextView qZoneRichTextView3 = this.mReplyContent;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView3 = null;
        }
        r rVar = r.f54359a;
        qZoneRichTextView3.setTextColorLink(rVar.b(getContext()));
        QZoneRichTextView qZoneRichTextView4 = this.mReplyContent;
        if (qZoneRichTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView4 = null;
        }
        qZoneRichTextView4.setTextColorLinkBackground(rVar.a(getContext()));
        QZoneRichTextView qZoneRichTextView5 = this.mReplyContent;
        if (qZoneRichTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView5 = null;
        }
        qZoneRichTextView5.setTextSize(ar.e(14.0f));
        QZoneRichTextView qZoneRichTextView6 = this.mReplyContent;
        if (qZoneRichTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView6 = null;
        }
        qZoneRichTextView6.setMaxCommentLine(2);
        QZoneRichTextView qZoneRichTextView7 = this.mReplyContent;
        if (qZoneRichTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView7 = null;
        }
        qZoneRichTextView7.setDrawBackground(true);
        QZoneRichTextView qZoneRichTextView8 = this.mReplyContent;
        if (qZoneRichTextView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView8 = null;
        }
        qZoneRichTextView8.setEllipsisStr(l.a(R.string.jmx));
        QZoneRichTextView qZoneRichTextView9 = this.mReplyContent;
        if (qZoneRichTextView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView9 = null;
        }
        qZoneRichTextView9.setColorBackground(getResources().getColor(R.color.qui_common_fill_light_secondary_pressed));
        QZoneRichTextView qZoneRichTextView10 = this.mReplyContent;
        if (qZoneRichTextView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView10 = null;
        }
        qZoneRichTextView10.setMoreCellColor(rVar.b(getContext()));
        QZoneRichTextView qZoneRichTextView11 = this.mReplyContent;
        if (qZoneRichTextView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView11 = null;
        }
        qZoneRichTextView11.setPreDecorateListener(new CellTextView.d() { // from class: se.ab
            @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
            public final List a(List list) {
                List A0;
                A0 = QzoneFeedProReplyWidget.A0(QzoneFeedProReplyWidget.this, list);
                return A0;
            }
        });
        QZoneRichTextView qZoneRichTextView12 = this.mReplyContent;
        if (qZoneRichTextView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView12 = null;
        }
        qZoneRichTextView12.setOnCellClickListener(new b());
        QZoneRichTextView qZoneRichTextView13 = this.mReplyContent;
        if (qZoneRichTextView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
        } else {
            qZoneRichTextView2 = qZoneRichTextView13;
        }
        r0(qZoneRichTextView2);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f1298678;
    }

    @Override // com.qzone.reborn.feedpro.widget.comment.QzoneFeedProBaseCommentWidget
    public String getLogTag() {
        return "QzoneFeedProReplyWidget";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void bindData(a commentReplyInfo, int pos) {
        Intrinsics.checkNotNullParameter(commentReplyInfo, "commentReplyInfo");
        CommonReply reply = commentReplyInfo.getReply();
        if (reply == null) {
            return;
        }
        boolean isEmpty = TextUtils.isEmpty(CommonFeedDataUtilKt.msgToString(reply.getContent()));
        QZoneRichTextView qZoneRichTextView = this.mReplyContent;
        QZoneRichTextView qZoneRichTextView2 = null;
        if (qZoneRichTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
            qZoneRichTextView = null;
        }
        qZoneRichTextView.setVisibility(isEmpty ? 8 : 0);
        QzoneFeedProClickedComment qzoneFeedProClickedComment = new QzoneFeedProClickedComment();
        qzoneFeedProClickedComment.setReply(reply);
        QZoneRichTextView qZoneRichTextView3 = this.mReplyContent;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReplyContent");
        } else {
            qZoneRichTextView2 = qZoneRichTextView3;
        }
        qZoneRichTextView2.setTag(qzoneFeedProClickedComment);
        String b16 = u.f54367a.b(reply.getUser(), false, false);
        if (b16 == null) {
            b16 = "";
        }
        B0(y0(reply, b16), reply);
    }
}
