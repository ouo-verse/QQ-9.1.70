package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/gallery/af;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/image/URLImageView;", "E", "Lcom/tencent/image/URLImageView;", "l", "()Lcom/tencent/image/URLImageView;", "img", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "loadingIcon", "Landroid/view/View;", "G", "Landroid/view/View;", "o", "()Landroid/view/View;", "selectFrame", "view", "<init>", "(Landroid/view/View;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class af extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final URLImageView img;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView loadingIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private final View selectFrame;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = this.itemView.findViewById(R.id.f163765rw2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_pic)");
        this.img = (URLImageView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.rwu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.loading_icon)");
        this.loadingIcon = (ImageView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.s0m);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.select_frame)");
        this.selectFrame = findViewById3;
    }

    /* renamed from: l, reason: from getter */
    public final URLImageView getImg() {
        return this.img;
    }

    /* renamed from: m, reason: from getter */
    public final ImageView getLoadingIcon() {
        return this.loadingIcon;
    }

    /* renamed from: o, reason: from getter */
    public final View getSelectFrame() {
        return this.selectFrame;
    }
}
