package com.qzone.reborn.message.section;

import android.view.View;
import android.widget.Button;
import androidx.core.content.res.ResourcesCompat;
import bl.CommonNoticeBean;
import com.qzone.reborn.widget.QZoneSwipeMenuLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J*\u0010\u0010\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/message/section/ak;", "Lcom/qzone/reborn/message/section/y;", "", "G", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lbl/a;", "data", "", "position", "", "", "payload", "H", "Lcom/qzone/reborn/widget/QZoneSwipeMenuLayout;", "i", "Lcom/qzone/reborn/widget/QZoneSwipeMenuLayout;", "swipeMenuLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "contentRootLayout", "Landroid/widget/Button;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/Button;", "deleteButton", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ak extends y {

    /* renamed from: C, reason: from kotlin metadata */
    private Button deleteButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneSwipeMenuLayout swipeMenuLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View contentRootLayout;

    /* JADX WARN: Multi-variable type inference failed */
    private final void G() {
        QZoneSwipeMenuLayout qZoneSwipeMenuLayout = this.swipeMenuLayout;
        if (qZoneSwipeMenuLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeMenuLayout");
            qZoneSwipeMenuLayout = null;
        }
        qZoneSwipeMenuLayout.g();
        dl.e eVar = (dl.e) q(dl.e.class);
        if (eVar != null) {
            eVar.o9((CommonNoticeBean) this.mData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ak this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.z(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(ak this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n7d);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026e_item_swipe_menu_layout)");
        this.swipeMenuLayout = (QZoneSwipeMenuLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n7c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026message_item_root_layout)");
        this.contentRootLayout = findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n8v);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026_message_item_delete_btn)");
        Button button = (Button) findViewById3;
        this.deleteButton = button;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
            button = null;
        }
        button.setBackgroundColor(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_feedback_error, null));
        View view = this.contentRootLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRootLayout");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ak.J(ak.this, view2);
            }
        });
        View view2 = this.contentRootLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentRootLayout");
            view2 = null;
        }
        view2.setOnLongClickListener(getLongClickListener());
        Button button3 = this.deleteButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
        } else {
            button2 = button3;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ak.K(ak.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        Button button = null;
        if (data != null) {
            gl.b bVar = gl.b.f402374a;
            View view = this.contentRootLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentRootLayout");
                view = null;
            }
            bVar.e(view, data);
        }
        Button button2 = this.deleteButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteButton");
        } else {
            button = button2;
        }
        w(button, WinkDaTongReportConstant.ElementId.EM_QZ_HISTORY_DELETE);
    }
}
