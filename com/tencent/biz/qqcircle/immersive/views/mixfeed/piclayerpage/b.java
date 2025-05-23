package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0014J$\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0014J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/b;", "Lcom/tencent/biz/qqcircle/bizparts/c;", "", "getLogTag", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "i", "", "onBindViewHolder", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/a;", "mCommentContainer", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentView;", "D", "Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentView;", "i0", "()Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentView;", "j0", "(Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/QFSNewContentDetailBodyCommentView;)V", "mCommentView", "<init>", "(Landroid/os/Bundle;Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/a;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends com.tencent.biz.qqcircle.bizparts.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final a mCommentContainer;

    /* renamed from: D, reason: from kotlin metadata */
    public QFSNewContentDetailBodyCommentView mCommentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@Nullable Bundle bundle, @NotNull a mCommentContainer) {
        super(bundle);
        Intrinsics.checkNotNullParameter(mCommentContainer, "mCommentContainer");
        this.mCommentContainer = mCommentContainer;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    @Nullable
    protected BaseWidgetView<?> createBlockRootView(@NotNull ViewGroup viewGroup, @Nullable MultiViewBlock<?> adapter) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewGroup.context");
        QFSNewContentDetailBodyCommentView qFSNewContentDetailBodyCommentView = new QFSNewContentDetailBodyCommentView(context, this.mCommentContainer, viewGroup.getHeight());
        qFSNewContentDetailBodyCommentView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        j0(qFSNewContentDetailBodyCommentView);
        return qFSNewContentDetailBodyCommentView;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    @NotNull
    protected String getLogTag() {
        return "QFSNewContentDetailBodyCommentBlock";
    }

    @NotNull
    public final QFSNewContentDetailBodyCommentView i0() {
        QFSNewContentDetailBodyCommentView qFSNewContentDetailBodyCommentView = this.mCommentView;
        if (qFSNewContentDetailBodyCommentView != null) {
            return qFSNewContentDetailBodyCommentView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCommentView");
        return null;
    }

    public final void j0(@NotNull QFSNewContentDetailBodyCommentView qFSNewContentDetailBodyCommentView) {
        Intrinsics.checkNotNullParameter(qFSNewContentDetailBodyCommentView, "<set-?>");
        this.mCommentView = qFSNewContentDetailBodyCommentView;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i3) {
        Object obj;
        Object orNull;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder, i3);
        List<E> list = this.mDataList;
        e30.b bVar = null;
        if (list != 0) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, i3);
            obj = orNull;
        } else {
            obj = null;
        }
        if (obj instanceof e30.b) {
            bVar = (e30.b) obj;
        }
        if (bVar == null) {
            QLog.e(getLogTag(), 1, "[onBindViewHolder] mDataList == null || mDataList.size error, i = " + i3);
            return;
        }
        i0().bindData(bVar.g(), i3);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
    }
}
