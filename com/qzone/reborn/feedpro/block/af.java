package com.qzone.reborn.feedpro.block;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.widget.QzoneUserHomeQuestionPageView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.Questions;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedpro/block/af;", "Lcom/qzone/reborn/base/m;", "", "l0", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewAttachedToWindow", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/Questions;", "questions", "m0", "Lcom/qzone/reborn/feedpro/widget/QzoneUserHomeQuestionPageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedpro/widget/QzoneUserHomeQuestionPageView;", "questionPageView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/Questions;", "<init>", "(Landroid/os/Bundle;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class af extends com.qzone.reborn.base.m {

    /* renamed from: C, reason: from kotlin metadata */
    private Questions questions;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QzoneUserHomeQuestionPageView questionPageView;

    public af(Bundle bundle) {
        super(bundle);
    }

    private final void l0() {
        ViewGroup.LayoutParams layoutParams;
        QzoneUserHomeQuestionPageView qzoneUserHomeQuestionPageView = this.questionPageView;
        if (qzoneUserHomeQuestionPageView == null || (layoutParams = qzoneUserHomeQuestionPageView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = -1;
        layoutParams.height = -2;
        QzoneUserHomeQuestionPageView qzoneUserHomeQuestionPageView2 = this.questionPageView;
        if (qzoneUserHomeQuestionPageView2 == null) {
            return;
        }
        qzoneUserHomeQuestionPageView2.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView<?> createBlockRootView(ViewGroup viewGroup, MultiViewBlock<?> adapter) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QzoneUserHomeQuestionPageView qzoneUserHomeQuestionPageView = new QzoneUserHomeQuestionPageView(context);
        this.questionPageView = qzoneUserHomeQuestionPageView;
        Intrinsics.checkNotNull(qzoneUserHomeQuestionPageView);
        return qzoneUserHomeQuestionPageView;
    }

    public final void m0(Questions questions) {
        this.questions = questions;
        if (questions == null) {
            QzoneUserHomeQuestionPageView qzoneUserHomeQuestionPageView = this.questionPageView;
            if (qzoneUserHomeQuestionPageView == null) {
                return;
            }
            qzoneUserHomeQuestionPageView.setVisibility(8);
            return;
        }
        l0();
        QzoneUserHomeQuestionPageView qzoneUserHomeQuestionPageView2 = this.questionPageView;
        if (qzoneUserHomeQuestionPageView2 != null) {
            qzoneUserHomeQuestionPageView2.setData(questions);
        }
        QzoneUserHomeQuestionPageView qzoneUserHomeQuestionPageView3 = this.questionPageView;
        if (qzoneUserHomeQuestionPageView3 == null) {
            return;
        }
        qzoneUserHomeQuestionPageView3.setVisibility(0);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        Questions questions = this.questions;
        if (questions != null) {
            m0(questions);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle initParams) {
    }
}
