package com.tencent.state.square.like;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.TimeFormatUtils;
import com.tencent.state.view.CircleBoarderImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0014\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0006H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/like/LikeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/square/like/LikeViewHolder;", "()V", "list", "Ljava/util/ArrayList;", "Lcom/tencent/state/square/like/LikeData;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "setDataList", "data", "", "setHeadImage", "headView", "Lcom/tencent/state/view/CircleBoarderImageView;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LikeListAdapter extends RecyclerView.Adapter<LikeViewHolder> {
    private final ArrayList<LikeData> list = new ArrayList<>();

    private final void setHeadImage(CircleBoarderImageView headView, LikeData data) {
        boolean startsWith;
        Bitmap bitmapFromCache$default = IFaceDecoder.DefaultImpls.getBitmapFromCache$default(Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder(), String.valueOf(data.getUin()), false, 2, null);
        if (bitmapFromCache$default != null) {
            headView.setImageBitmap(bitmapFromCache$default);
            return;
        }
        Drawable drawable = DrawableUtil.INSTANCE.getDrawable(R.drawable.gu_);
        String head = data.getHead();
        if (!(head == null || head.length() == 0)) {
            startsWith = StringsKt__StringsJVMKt.startsWith(data.getHead(), "http", true);
            if (startsWith) {
                URLDrawable.URLDrawableOptions urlDrawableOptions$default = SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, drawable, null, 2, null);
                urlDrawableOptions$default.mRequestWidth = ViewExtensionsKt.dip(headView.getContext(), 42.0f);
                urlDrawableOptions$default.mRequestHeight = ViewExtensionsKt.dip(headView.getContext(), 42.0f);
                headView.setImageDrawable(URLDrawable.getDrawable(data.getHead(), urlDrawableOptions$default));
                return;
            }
        }
        headView.setImageDrawable(drawable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.list.size();
    }

    public final void setDataList(List<LikeData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.list.clear();
        this.list.addAll(data);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(LikeViewHolder holder, int position) {
        Object orNull;
        String string;
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.list, position);
        LikeData likeData = (LikeData) orNull;
        if (likeData != null) {
            holder.getNick().setText(Square.INSTANCE.getConfig().getCommonUtils().getFriendRemarkName(String.valueOf(likeData.getUin()), likeData.getNick()));
            setHeadImage(holder.getHead(), likeData);
            TextView from = holder.getFrom();
            if (likeData.getScene() == 0) {
                View view = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                string = view.getContext().getString(R.string.xgr);
            } else {
                View view2 = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
                string = view2.getContext().getString(R.string.xgs);
            }
            from.setText(string);
            holder.getIcon().setImageResource(LikeData.INSTANCE.getIconFromType(likeData.getType()));
            holder.getTime().setText(TimeFormatUtils.INSTANCE.formatTimeBaseOnMill(likeData.getTime() * 1000, DateUtil.DATE_FORMAT_HOUR));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LikeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167415d64, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new LikeViewHolder(view);
    }
}
