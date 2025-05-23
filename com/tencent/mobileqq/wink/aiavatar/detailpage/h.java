package com.tencent.mobileqq.wink.aiavatar.detailpage;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0017\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010\f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u00072\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/detailpage/h;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/h$a;", "Landroid/widget/ImageView;", "imageView", "", "imageUrl", "", "i0", "", "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/a;", "newData", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "j0", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "<init>", "(Ljava/util/List;)V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<AIAvatarImgPickGuideDataItem> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/detailpage/h$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "suggestImg", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "suggestText", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/aiavatar/detailpage/h;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView suggestImg;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView suggestText;
        final /* synthetic */ h G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull h hVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.G = hVar;
            View findViewById = itemView.findViewById(R.id.f9067534);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.suggest_img)");
            this.suggestImg = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f9068535);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.suggest_text)");
            this.suggestText = (TextView) findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getSuggestImg() {
            return this.suggestImg;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getSuggestText() {
            return this.suggestText;
        }
    }

    public h(@NotNull List<AIAvatarImgPickGuideDataItem> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
    }

    private final void i0(ImageView imageView, String imageUrl) {
        boolean z16;
        if (imageView != null) {
            if (imageUrl != null && imageUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                ColorDrawable colorDrawable = new ColorDrawable(imageView.getContext().getColor(R.color.qui_common_bg_nav_bottom));
                Option obtain = Option.obtain();
                obtain.setLoadingDrawable(colorDrawable);
                obtain.setFailedDrawable(colorDrawable);
                obtain.setTargetView(imageView);
                obtain.setUrl(imageUrl);
                QQPicLoader.f201806a.d().loadImage(obtain, null);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        AIAvatarImgPickGuideDataItem aIAvatarImgPickGuideDataItem = this.dataList.get(position);
        i0(holder.getSuggestImg(), aIAvatarImgPickGuideDataItem.getIconUrl());
        holder.getSuggestText().setText(aIAvatarImgPickGuideDataItem.getIconTitle());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.i4u, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(this, view);
    }

    public final void setData(@NotNull List<AIAvatarImgPickGuideDataItem> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.dataList = newData;
        notifyDataSetChanged();
    }
}
