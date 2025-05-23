package com.tencent.aelight.camera.zplan.api.impl;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aelight.camera.zplan.api.impl.c;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000 \u00192\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\u001d\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/c;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/zplan/api/impl/c$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", ReportConstant.COSTREPORT_PREFIX, "holder", "position", "", "r", "getItemViewType", "getItemCount", "Lcom/tencent/aelight/camera/zplan/api/impl/e;", "d", "Lcom/tencent/aelight/camera/zplan/api/impl/e;", "listener", "", "Lcom/tencent/aelight/camera/zplan/api/impl/f;", "e", "Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "<init>", "(Lcom/tencent/aelight/camera/zplan/api/impl/e;Ljava/util/List;)V", "f", "a", "b", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c extends RecyclerView.Adapter<b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final e listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<f> itemList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/c$b;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "", "colorInt", "Landroid/graphics/drawable/GradientDrawable;", "d", "Landroid/graphics/drawable/Drawable;", "e", "Lcom/tencent/aelight/camera/zplan/api/impl/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "f", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/aelight/camera/zplan/api/impl/c;Landroid/view/View;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f69099d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(final c cVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f69099d = cVar;
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.zplan.api.impl.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.b.c(c.this, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(c this$0, b this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.listener.a0((f) this$0.itemList.get(this$1.getAdapterPosition()));
            EventCollector.getInstance().onViewClicked(view);
        }

        private final GradientDrawable d(int colorInt) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.mutate();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(4.0f);
            gradientDrawable.setColor(colorInt);
            gradientDrawable.setSize(ViewUtils.dip2px(18.0f), ViewUtils.dip2px(18.0f));
            return gradientDrawable;
        }

        private final Drawable e() {
            return ResourcesCompat.getDrawable(this.itemView.getContext().getResources(), R.drawable.izh, null);
        }

        public final void f(f item) {
            Drawable d16;
            Intrinsics.checkNotNullParameter(item, "item");
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.f165938y52);
            if (item instanceof i) {
                d16 = e();
            } else if (item instanceof ColorPreset) {
                d16 = d(((ColorPreset) item).getColorInt());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            imageView.setImageDrawable(d16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(e listener, List<? extends f> itemList) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.listener = listener;
        this.itemList = itemList;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        f fVar = this.itemList.get(position);
        if (fVar instanceof i) {
            return 1;
        }
        if (fVar instanceof ColorPreset) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.f(this.itemList.get(position));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dtf, parent, false);
        ((ImageView) view.findViewById(R.id.y8u)).setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new b(this, view);
    }
}
