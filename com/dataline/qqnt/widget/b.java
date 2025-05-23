package com.dataline.qqnt.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.dataline.qqnt.activities.MultiPicViewerActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000e\u001a\u00020\u00052\n\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0014\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/dataline/qqnt/widget/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/dataline/qqnt/widget/b$a;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "k0", "getItemCount", "", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$MultiPicElement;", "newList", "setDataList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "dataList", "<init>", "()V", "a", "qq_nt_dataline_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<AIOElementType.MultiPicElement> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/dataline/qqnt/widget/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ldb1/a;", "E", "Ldb1/a;", "l", "()Ldb1/a;", "binding", "", UserInfo.SEX_FEMALE, "I", "o", "()I", "width", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "height", "<init>", "(Lcom/dataline/qqnt/widget/b;Ldb1/a;)V", "qq_nt_dataline_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes2.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final db1.a binding;

        /* renamed from: F, reason: from kotlin metadata */
        private final int width;

        /* renamed from: G, reason: from kotlin metadata */
        private final int height;
        final /* synthetic */ b H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull b bVar, db1.a binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.H = bVar;
            this.binding = binding;
            RecyclerView recyclerView = bVar.recyclerView;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
            int spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
            RecyclerView recyclerView3 = bVar.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView3 = null;
            }
            int instantScreenWidth = ScreenUtil.getInstantScreenWidth(recyclerView3.getContext());
            int i3 = spanCount + 1;
            RecyclerView recyclerView4 = bVar.recyclerView;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView4;
            }
            int dimensionPixelOffset = (instantScreenWidth - ((i3 * recyclerView2.getResources().getDimensionPixelOffset(R.dimen.c7s)) * 2)) / spanCount;
            this.width = dimensionPixelOffset;
            this.height = dimensionPixelOffset;
            binding.f393503c.setLayoutParams(new ConstraintLayout.LayoutParams(-1, dimensionPixelOffset));
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final db1.a getBinding() {
            return this.binding;
        }

        /* renamed from: m, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: o, reason: from getter */
        public final int getWidth() {
            return this.width;
        }
    }

    public b() {
        List<AIOElementType.MultiPicElement> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.dataList = emptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(b this$0, int i3, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.dataline.qqnt.activities.MultiPicViewerActivity");
        MsgRecord U2 = ((MultiPicViewerActivity) context).U2();
        Intrinsics.checkNotNull(U2);
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        iRichMediaBrowserApi.enterMultiImagePreviewWithPath(it, i3, U2);
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, final int position) {
        int i3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        RecyclerView recyclerView = null;
        holder.getBinding().f393503c.setBackgroundColor(holder.getBinding().getRoot().getResources().getColor(R.color.qui_common_overlay_light, null));
        IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
        String b16 = this.dataList.get(position).b();
        ImageView ivImage = holder.getBinding().f393503c;
        int width = holder.getWidth();
        int height = holder.getHeight();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        Drawable drawable = ContextCompat.getDrawable(recyclerView.getContext(), R.drawable.m8h);
        Intrinsics.checkNotNullExpressionValue(ivImage, "ivImage");
        iPicAIOApi.loadPic(new com.tencent.mobileqq.pic.option.a(b16, ivImage, true, width, height, null, drawable, 32, null));
        if (this.dataList.get(position).e() != 4) {
            holder.getBinding().f393503c.setColorFilter(Color.parseColor("#20000000"), PorterDuff.Mode.SRC_ATOP);
        } else {
            holder.getBinding().f393503c.setOnClickListener(new View.OnClickListener() { // from class: com.dataline.qqnt.widget.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.l0(b.this, position, view);
                }
            });
        }
        View view = holder.getBinding().f393502b;
        if (this.dataList.get(position).e() != 5 && this.dataList.get(position).e() != 6) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        db1.a g16 = db1.a.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new a(this, g16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    public final void setDataList(@NotNull List<AIOElementType.MultiPicElement> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.dataList = newList;
        notifyDataSetChanged();
    }
}
