package com.tencent.mobileqq.mini.ui;

import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial$AppMaterialInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.common.ui.LoadingMoreRecyclerAdapter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.RoundRectURLImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0007J\u0010\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\tJ\u0010\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u000bR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter;", "Lcom/tencent/mobileqq/mini/common/ui/LoadingMoreRecyclerAdapter;", "Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter$ItemViewHolder;", "()V", "mAppList", "Ljava/util/ArrayList;", "LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;", "Lkotlin/collections/ArrayList;", "mItemClickListener", "Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter$OnItemClickListener;", "mMimeType", "", "addData", "", "appList", "", "doGetItemCount", "", "doOnBindViewHolder", "holder", "position", "doOnCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "getMiniAppConfigForReport", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "data", "onViewAttachedToWindow", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "reportItemClickedOrExposed", "isClick", "", "setData", "setItemClickListener", "listener", "setMimeType", "mimeType", "ItemViewHolder", "OnItemClickListener", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class FileMaterialAppListAdapter extends LoadingMoreRecyclerAdapter<ItemViewHolder> {
    private final ArrayList<MiniAppFileMaterial$AppMaterialInfo> mAppList = new ArrayList<>();
    private OnItemClickListener mItemClickListener;
    private String mMimeType;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "data", "LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;", "getData", "()LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;", "setData", "(LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;)V", "ivExpTips", "Landroid/widget/ImageView;", "getIvExpTips", "()Landroid/widget/ImageView;", "ivIcon", "Lcom/tencent/widget/RoundRectURLImageView;", "getIvIcon", "()Lcom/tencent/widget/RoundRectURLImageView;", "tvDesc", "Landroid/widget/TextView;", "getTvDesc", "()Landroid/widget/TextView;", "tvTitle", "getTvTitle", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public MiniAppFileMaterial$AppMaterialInfo data;
        private final ImageView ivExpTips;
        private final RoundRectURLImageView ivIcon;
        private final TextView tvDesc;
        private final TextView tvTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.rjn);
            RoundRectURLImageView roundRectURLImageView = (RoundRectURLImageView) findViewById;
            roundRectURLImageView.setRadius(view.getResources().getDimensionPixelSize(R.dimen.f130292));
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<RoundR\u2026ius).toFloat())\n        }");
            this.ivIcon = roundRectURLImageView;
            View findViewById2 = view.findViewById(R.id.rgt);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.mini_app_module_title)");
            this.tvTitle = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.rlj);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.tv_desc)");
            this.tvDesc = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.ref);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.iv_exp_tips)");
            this.ivExpTips = (ImageView) findViewById4;
        }

        public final MiniAppFileMaterial$AppMaterialInfo getData() {
            MiniAppFileMaterial$AppMaterialInfo miniAppFileMaterial$AppMaterialInfo = this.data;
            if (miniAppFileMaterial$AppMaterialInfo != null) {
                return miniAppFileMaterial$AppMaterialInfo;
            }
            Intrinsics.throwUninitializedPropertyAccessException("data");
            return null;
        }

        public final ImageView getIvExpTips() {
            return this.ivExpTips;
        }

        public final RoundRectURLImageView getIvIcon() {
            return this.ivIcon;
        }

        public final TextView getTvDesc() {
            return this.tvDesc;
        }

        public final TextView getTvTitle() {
            return this.tvTitle;
        }

        public final void setData(MiniAppFileMaterial$AppMaterialInfo miniAppFileMaterial$AppMaterialInfo) {
            Intrinsics.checkNotNullParameter(miniAppFileMaterial$AppMaterialInfo, "<set-?>");
            this.data = miniAppFileMaterial$AppMaterialInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter$OnItemClickListener;", "", "onItemClicked", "", "data", "LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public interface OnItemClickListener {
        void onItemClicked(MiniAppFileMaterial$AppMaterialInfo data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doOnBindViewHolder$lambda$1(FileMaterialAppListAdapter this$0, ItemViewHolder holder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        OnItemClickListener onItemClickListener = this$0.mItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClicked(holder.getData());
        }
        this$0.reportItemClickedOrExposed(holder.getData(), true);
    }

    private final MiniAppConfig getMiniAppConfigForReport(MiniAppFileMaterial$AppMaterialInfo data) {
        MiniAppConfig miniAppConfig = new MiniAppConfig(new MiniAppInfo());
        miniAppConfig.config.appId = data.appid.get();
        miniAppConfig.launchParam.scene = 1173;
        return miniAppConfig;
    }

    public final void addData(List<MiniAppFileMaterial$AppMaterialInfo> appList) {
        Intrinsics.checkNotNullParameter(appList, "appList");
        this.mAppList.addAll(appList);
        notifyItemRangeInserted(this.mAppList.size() - appList.size(), appList.size());
    }

    @Override // com.tencent.mobileqq.mini.common.ui.RecyclerWrapperAdapter
    public int doGetItemCount() {
        return this.mAppList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (holder instanceof ItemViewHolder) {
            reportItemClickedOrExposed(((ItemViewHolder) holder).getData(), false);
        }
    }

    public final void setData(List<MiniAppFileMaterial$AppMaterialInfo> appList) {
        Intrinsics.checkNotNullParameter(appList, "appList");
        this.mAppList.clear();
        this.mAppList.addAll(appList);
        notifyDataSetChanged();
    }

    public final void setItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public final void setMimeType(String mimeType) {
        this.mMimeType = mimeType;
    }

    @Override // com.tencent.mobileqq.mini.common.ui.RecyclerWrapperAdapter
    public void doOnBindViewHolder(final ItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MiniAppFileMaterial$AppMaterialInfo miniAppFileMaterial$AppMaterialInfo = this.mAppList.get(position);
        Intrinsics.checkNotNullExpressionValue(miniAppFileMaterial$AppMaterialInfo, "mAppList[position]");
        MiniAppFileMaterial$AppMaterialInfo miniAppFileMaterial$AppMaterialInfo2 = miniAppFileMaterial$AppMaterialInfo;
        holder.setData(miniAppFileMaterial$AppMaterialInfo2);
        if (!TextUtils.isEmpty(miniAppFileMaterial$AppMaterialInfo2.icon.get())) {
            holder.getIvIcon().setImageDrawable(URLDrawable.getDrawable(miniAppFileMaterial$AppMaterialInfo2.icon.get(), (URLDrawable.URLDrawableOptions) null));
        }
        holder.getTvTitle().setText(miniAppFileMaterial$AppMaterialInfo2.name.get());
        holder.getTvDesc().setText(miniAppFileMaterial$AppMaterialInfo2.desc.get());
        holder.getIvExpTips().setVisibility(Intrinsics.areEqual(miniAppFileMaterial$AppMaterialInfo2.f24954vt.get(), "1") ? 0 : 8);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileMaterialAppListAdapter.doOnBindViewHolder$lambda$1(FileMaterialAppListAdapter.this, holder, view);
            }
        });
        if (QQTheme.isNowThemeIsNight()) {
            holder.getIvIcon().setForeground(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.iph));
            holder.getTvTitle().setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.f8998g));
            holder.getTvDesc().setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.f8978e));
        } else {
            holder.getIvIcon().setForeground(null);
            holder.getTvTitle().setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.f8988f));
            holder.getTvDesc().setTextColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.f8968d));
        }
    }

    @Override // com.tencent.mobileqq.mini.common.ui.RecyclerWrapperAdapter
    public ItemViewHolder doOnCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dj9, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new ItemViewHolder(view);
    }

    private final void reportItemClickedOrExposed(MiniAppFileMaterial$AppMaterialInfo data, boolean isClick) {
        String str;
        if (isClick) {
            str = "click";
        } else {
            str = "expo";
        }
        MiniProgramLpReportDC04239.reportAsync(getMiniAppConfigForReport(data), MiniProgramLpReportDC04239.FILE_MATERIAL_ACTION_TYPE, MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_LIST, str, this.mMimeType);
    }
}
