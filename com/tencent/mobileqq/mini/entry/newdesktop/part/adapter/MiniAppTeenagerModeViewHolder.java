package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.utils.MiniAppWnsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppTeenagerModeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mTeenagerModeIv", "Landroid/widget/ImageView;", "mTeenagerModeTv", "Landroid/widget/TextView;", "bindView", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppTeenagerModeViewHolder extends RecyclerView.ViewHolder {
    private ImageView mTeenagerModeIv;
    private TextView mTeenagerModeTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppTeenagerModeViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.rlb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.teen_mode_desc)");
        this.mTeenagerModeTv = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.rhw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026mini_app_teen_empty_view)");
        this.mTeenagerModeIv = (ImageView) findViewById2;
    }

    public final void bindView() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = this.mTeenagerModeIv.getContext().getDrawable(R.drawable.ojv);
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(MiniAppWnsConfig.getMiniDesktopTeenModelEmptyImage(), obtain);
        drawable2.setColorFilter(this.mTeenagerModeIv.getContext().getColor(R.color.qui_common_icon_primary), PorterDuff.Mode.SRC_IN);
        this.mTeenagerModeIv.setImageDrawable(drawable2);
        this.mTeenagerModeTv.setText(MiniAppWnsConfig.getMiniDesktopTeenModelDesc());
    }
}
