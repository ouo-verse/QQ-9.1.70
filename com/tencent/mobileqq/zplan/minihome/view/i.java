package com.tencent.mobileqq.zplan.minihome.view;

import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/i;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/minihome/view/i$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[Ljava/lang/String;", "tagUrls", "<init>", "([Ljava/lang/String;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
final class i extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String[] tagUrls;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/i$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "tagImageView", "<init>", "(Landroid/widget/ImageView;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView tagImageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView tagImageView) {
            super(tagImageView);
            Intrinsics.checkNotNullParameter(tagImageView, "tagImageView");
            this.tagImageView = tagImageView;
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getTagImageView() {
            return this.tagImageView;
        }
    }

    public i(String[] tagUrls) {
        Intrinsics.checkNotNullParameter(tagUrls, "tagUrls");
        this.tagUrls = tagUrls;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.tagUrls.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ImageView tagImageView = holder.getTagImageView();
        String str = this.tagUrls[position];
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        Unit unit = Unit.INSTANCE;
        tagImageView.setBackground(URLDrawable.getDrawable(str, obtain));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        a aVar = new a(new ImageView(parent.getContext()));
        ImageView tagImageView = aVar.getTagImageView();
        FlexboxLayoutManager.LayoutParams layoutParams = new FlexboxLayoutManager.LayoutParams(com.tencent.sqshow.zootopia.utils.i.a(53.0f), com.tencent.sqshow.zootopia.utils.i.a(15.0f));
        int a16 = com.tencent.sqshow.zootopia.utils.i.a(2.0f);
        layoutParams.setMargins(a16, a16, a16, a16);
        tagImageView.setLayoutParams(layoutParams);
        return aVar;
    }
}
