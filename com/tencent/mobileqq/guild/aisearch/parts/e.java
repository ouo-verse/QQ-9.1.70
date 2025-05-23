package com.tencent.mobileqq.guild.aisearch.parts;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/parts/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "titleLayout", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "titleText", "H", "l", "subTitleText", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup titleLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ImageView icon;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView titleText;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView subTitleText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        ViewGroup viewGroup = (ViewGroup) itemView;
        View childAt = viewGroup.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) childAt;
        this.titleLayout = viewGroup2;
        View childAt2 = viewGroup2.getChildAt(0);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.ImageView");
        this.icon = (ImageView) childAt2;
        View childAt3 = viewGroup2.getChildAt(1);
        Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type android.widget.TextView");
        this.titleText = (TextView) childAt3;
        View childAt4 = viewGroup.getChildAt(1);
        Intrinsics.checkNotNull(childAt4, "null cannot be cast to non-null type android.widget.TextView");
        this.subTitleText = (TextView) childAt4;
    }

    @NotNull
    public final ImageView getIcon() {
        return this.icon;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final TextView getSubTitleText() {
        return this.subTitleText;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final TextView getTitleText() {
        return this.titleText;
    }
}
