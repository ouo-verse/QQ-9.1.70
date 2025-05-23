package com.tencent.mobileqq.wink.picker.core.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import e93.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/adapter/f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "l", "Lcom/tencent/mobileqq/widget/SquareImageView;", "E", "Lcom/tencent/mobileqq/widget/SquareImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/widget/SquareImageView;", "selectedThumbImg", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "selectedVideoDurationText", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final SquareImageView selectedThumbImg;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView selectedVideoDurationText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.f82594ha);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.selectedThumbImg)");
        this.selectedThumbImg = (SquareImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f82604hb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026electedVideoDurationText)");
        this.selectedVideoDurationText = (TextView) findViewById2;
    }

    public final void l(@NotNull LocalMediaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ViewExKt.n(this.selectedThumbImg, info);
        this.selectedThumbImg.setContentDescription(i.i(info));
        if (i.I(info)) {
            if (!i.E(info) && (!info.isSystemMeidaStore || info.mDuration < 0)) {
                this.selectedVideoDurationText.setVisibility(4);
                return;
            } else {
                this.selectedVideoDurationText.setVisibility(0);
                this.selectedVideoDurationText.setText(QAlbumUtil.formatTimeToString(info.mDuration));
                return;
            }
        }
        this.selectedVideoDurationText.setVisibility(4);
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final SquareImageView getSelectedThumbImg() {
        return this.selectedThumbImg;
    }
}
