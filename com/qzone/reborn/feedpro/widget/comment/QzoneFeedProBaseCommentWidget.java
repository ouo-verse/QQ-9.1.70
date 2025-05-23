package com.qzone.reborn.feedpro.widget.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.reborn.feedpro.bean.QzoneFeedProClickedComment;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProBaseCommentWidget;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import wd.a;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)B\u0019\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b(\u0010,J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001d\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/comment/QzoneFeedProBaseCommentWidget;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lwd/a;", "Landroid/view/View;", "v", "", "q0", "", "getLogTag", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "richTextView", "r0", "p0", "Lde/a;", "o0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "getFeedData", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "setFeedData", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", "feedData", "", "f", "I", "getFeedPosition", "()I", "setFeedPosition", "(I)V", "feedPosition", h.F, "Lde/a;", "commentIoc", "i", "getPageType", "setPageType", "pageType", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QzoneFeedProBaseCommentWidget extends QZoneBaseWidgetView<a> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CommonFeed feedData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int feedPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private de.a commentIoc;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int pageType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProBaseCommentWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void q0(View v3) {
        de.a o06;
        if (getData() == null || (o06 = o0()) == null) {
            return;
        }
        o06.P1(v3, this.feedData, getData().getComment(), getData().getReply(), this.dataPosInList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(QzoneFeedProBaseCommentWidget this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u0(QzoneFeedProBaseCommentWidget this$0, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.q0(v3);
        return false;
    }

    public abstract String getLogTag();

    public final de.a o0() {
        if (this.commentIoc == null) {
            this.commentIoc = (de.a) getIocInterface(de.a.class);
        }
        return this.commentIoc;
    }

    public void p0() {
        if (this.feedData != null && getData() != null) {
            QzoneFeedProClickedComment qzoneFeedProClickedComment = new QzoneFeedProClickedComment();
            qzoneFeedProClickedComment.setComment(getData().getReply() == null);
            qzoneFeedProClickedComment.setComment(getData().getComment());
            qzoneFeedProClickedComment.setReply(getData().getReply());
            if (o0() != null) {
                de.a o06 = o0();
                Intrinsics.checkNotNull(o06);
                o06.y6(this.feedData, 0, 0, 0);
                de.a o07 = o0();
                Intrinsics.checkNotNull(o07);
                o07.T2(qzoneFeedProClickedComment);
                de.a o08 = o0();
                Intrinsics.checkNotNull(o08);
                o08.T8(this.feedData, qzoneFeedProClickedComment, this.feedPosition);
                return;
            }
            return;
        }
        QLog.e(getLogTag(), 1, "handleOnClickItem  params error");
    }

    public final void setFeedData(CommonFeed commonFeed) {
        this.feedData = commonFeed;
    }

    public final void setFeedPosition(int i3) {
        this.feedPosition = i3;
    }

    public final void setPageType(int i3) {
        this.pageType = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProBaseCommentWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    public final void r0(QZoneRichTextView richTextView) {
        if (richTextView == null) {
            return;
        }
        richTextView.setOnClickListener(new View.OnClickListener() { // from class: se.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFeedProBaseCommentWidget.s0(QzoneFeedProBaseCommentWidget.this, view);
            }
        });
        richTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: se.k
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean u06;
                u06 = QzoneFeedProBaseCommentWidget.u0(QzoneFeedProBaseCommentWidget.this, view);
                return u06;
            }
        });
    }
}
