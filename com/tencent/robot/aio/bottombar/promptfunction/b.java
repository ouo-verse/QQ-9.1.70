package com.tencent.robot.aio.bottombar.promptfunction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0001!B\u0015\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d\u00a2\u0006\u0004\b\u001f\u0010 J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J.\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010H\u0016J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/robot/aio/bottombar/promptfunction/b;", "Lw54/a;", "Lcom/tencent/robot/aio/bottombar/promptfunction/a;", "Lb74/a;", "Lcom/tencent/robot/aio/bottombar/promptfunction/b$a;", "Lu54/c;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", "position", "", DomainData.DOMAIN_NAME, "", "desc", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "items", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "p", "", "payloads", "o", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lw64/e;", "mDialogContext", "<init>", "(Lw64/e;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends w54.a<com.tencent.robot.aio.bottombar.promptfunction.a, b74.a, a, u54.c> implements View.OnClickListener {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/bottombar/promptfunction/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "tvDesName", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "l", "()Landroid/view/View;", "dividerView", "itemView", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView tvDesName;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final View dividerView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f108146cb);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_funtion_desc)");
            this.tvDesName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.k7c);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_divider)");
            this.dividerView = findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final View getDividerView() {
            return this.dividerView;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getTvDesName() {
            return this.tvDesName;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull w64.e<u54.c> mDialogContext) {
        super(mDialogContext);
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
    }

    private final void n(com.tencent.robot.aio.bottombar.promptfunction.a item, a holder, int position) {
        holder.itemView.setOnClickListener(this);
        if (position == 0) {
            holder.getDividerView().setVisibility(0);
        } else {
            holder.getDividerView().setVisibility(8);
        }
        q(holder, item.getData().getOptDesc());
    }

    private final void q(a holder, String desc) {
        holder.getTvDesName().setText(desc);
    }

    @Override // v64.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public boolean h(@NotNull b74.a item, @NotNull List<? extends b74.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof com.tencent.robot.aio.bottombar.promptfunction.a;
    }

    @Override // v64.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(@NotNull com.tencent.robot.aio.bottombar.promptfunction.a item, @NotNull a holder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        n(item, holder, position);
    }

    @Override // v64.b
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public a c(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View contentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.h28, parent, false);
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        return new a(contentView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
    }
}
