package n83;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001f\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\u000b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Ln83/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "itemImageView", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "itemRemoveView", "Landroid/view/View;", "v", "<init>", "(Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final ImageView itemImageView;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView itemRemoveView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View v3) {
        super(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        this.itemImageView = (ImageView) v3.findViewById(R.id.f123137fu);
        this.itemRemoveView = (ImageView) v3.findViewById(R.id.f123147fv);
    }

    /* renamed from: l, reason: from getter */
    public final ImageView getItemImageView() {
        return this.itemImageView;
    }

    /* renamed from: m, reason: from getter */
    public final ImageView getItemRemoveView() {
        return this.itemRemoveView;
    }
}
