package ib4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lib4/l;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setOperateView", "(Landroid/widget/ImageView;)V", "operateView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class l extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final ImageView iconView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView textView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView operateView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.r6s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026n_multi_select_item_icon)");
        this.iconView = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.r6u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026n_multi_select_item_text)");
        this.textView = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.r6t);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026lect_item_operation_icon)");
        this.operateView = (ImageView) findViewById3;
    }

    /* renamed from: l, reason: from getter */
    public final ImageView getIconView() {
        return this.iconView;
    }

    /* renamed from: m, reason: from getter */
    public final ImageView getOperateView() {
        return this.operateView;
    }

    /* renamed from: o, reason: from getter */
    public final TextView getTextView() {
        return this.textView;
    }
}
