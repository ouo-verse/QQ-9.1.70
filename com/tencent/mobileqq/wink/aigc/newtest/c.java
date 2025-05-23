package com.tencent.mobileqq.wink.aigc.newtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/newtest/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/aigc/newtest/c$a;", "", "Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;", "data", "", "setData", "Lcom/tencent/mobileqq/wink/aigc/newtest/d;", "l", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "holder", "position", "j0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", IQQGameCommApi.K_ABTEST_MODELS, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/aigc/newtest/d;", "onItemClickListener", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private d onItemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ModelItem> models = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/newtest/c$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;", "model", "", "l", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "cover", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "desc", "", "G", "Ljava/lang/String;", "serverId", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private ImageView cover;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private TextView desc;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private String serverId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.cover = (ImageView) view.findViewById(R.id.f123417gl);
            this.desc = (TextView) view.findViewById(R.id.f123427gm);
            this.serverId = "";
        }

        public final void l(@NotNull ModelItem model) {
            Intrinsics.checkNotNullParameter(model, "model");
            Option obtain = Option.obtain();
            obtain.setTargetView(this.cover);
            obtain.setUrl(model.getCoverUrl());
            QCircleFeedPicLoader.g().loadImage(obtain);
            TextView textView = this.desc;
            if (textView != null) {
                textView.setText(model.getDesc());
            }
            this.serverId = model.getModelName();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(c this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d dVar = this$0.onItemClickListener;
        if (dVar != null) {
            dVar.e3(this$0.models.get(i3));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.models.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.l(this.models.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aigc.newtest.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.k0(c.this, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f169192i63, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(view);
    }

    public final void m0(@Nullable d l3) {
        this.onItemClickListener = l3;
    }

    public final void setData(@NotNull List<ModelItem> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.models.clear();
        this.models.addAll(data);
        notifyDataSetChanged();
    }
}
