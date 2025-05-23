package com.qzone.reborn.feedpro.widget.comment;

import android.content.Context;
import android.view.View;
import com.qzone.reborn.feedpro.bean.QzoneFeedProClickedComment;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailBaseCommentItemView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import de.a;
import de.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H$J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0004J\b\u0010\f\u001a\u00020\u0005H\u0004J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0004J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0004J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0004R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProDetailBaseCommentItemView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lwd/c;", "Landroid/view/View;", "v", "", "v0", "", "getLogTag", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "richTextView", "w0", "u0", "Lde/a;", "q0", "Lde/d;", "r0", "objData", "", c.G, "o0", "view", "p0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "s0", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "setMFeedData", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", "mFeedData", "f", "Lde/a;", "mCommentIoc", h.F, "Lde/d;", "mCommentLikeIoc", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QzoneFeedProDetailBaseCommentItemView extends QZoneBaseWidgetView<wd.c> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CommonFeed mFeedData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a mCommentIoc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private d mCommentLikeIoc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProDetailBaseCommentItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void v0(View v3) {
        int mCommentPos;
        wd.c data = getData();
        if (data == null) {
            return;
        }
        if (data.getMItemType() == 102) {
            mCommentPos = data.getMReplyPos();
        } else {
            mCommentPos = data.getMCommentPos();
        }
        int i3 = mCommentPos;
        a q06 = q0();
        if (q06 != null) {
            q06.P1(v3, this.mFeedData, data.getMComment(), data.getMReply(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(QzoneFeedProDetailBaseCommentItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y0(QzoneFeedProDetailBaseCommentItemView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.v0(it);
        return true;
    }

    protected abstract String getLogTag();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int dpToPx = ImmersiveUtils.dpToPx(10.0f);
        QZoneFeedxViewUtils.a(view, dpToPx, dpToPx, dpToPx, dpToPx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a q0() {
        a aVar = this.mCommentIoc;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = (a) getIocInterface(a.class);
        this.mCommentIoc = aVar2;
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final d r0() {
        d dVar = this.mCommentLikeIoc;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = (d) getIocInterface(d.class);
        this.mCommentLikeIoc = dVar2;
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s0, reason: from getter */
    public final CommonFeed getMFeedData() {
        return this.mFeedData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u0() {
        if (this.mFeedData != null && getData() != null) {
            QzoneFeedProClickedComment qzoneFeedProClickedComment = new QzoneFeedProClickedComment();
            qzoneFeedProClickedComment.setComment(getData().getMReply() == null);
            qzoneFeedProClickedComment.setComment(getData().getMComment());
            qzoneFeedProClickedComment.setReply(getData().getMReply());
            a q06 = q0();
            if (q06 != null) {
                q06.T2(qzoneFeedProClickedComment);
                q06.T8(this.mFeedData, qzoneFeedProClickedComment, -1);
                return;
            }
            return;
        }
        QLog.e(getLogTag(), 1, "handleOnClickItem  params error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w0(QZoneRichTextView richTextView) {
        if (richTextView != null) {
            richTextView.setOnClickListener(new View.OnClickListener() { // from class: se.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzoneFeedProDetailBaseCommentItemView.x0(QzoneFeedProDetailBaseCommentItemView.this, view);
                }
            });
            richTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: se.r
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean y06;
                    y06 = QzoneFeedProDetailBaseCommentItemView.y0(QzoneFeedProDetailBaseCommentItemView.this, view);
                    return y06;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(wd.c objData, int pos) {
        if (objData == null) {
            return;
        }
        this.mFeedData = objData.getFeedData();
    }
}
