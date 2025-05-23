package com.tencent.mobileqq.qqvideoedit.editor.background;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.editor.background.VideoEditorRatioList;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.k;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0018\u0010\u001eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010\u0010\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/VideoEditorRatioList;", "Landroidx/recyclerview/widget/RecyclerView;", "", "", "H", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/RatioType;", "ratioType", "", "G", "", "ratioList", "selected", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/a;", "listener", "setRatioList", "setSelect", "f", "Ljava/util/List;", h.F, "Lcom/tencent/mobileqq/qqvideoedit/editor/background/RatioType;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditorRatioList extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends RatioType> ratioList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RatioType selected;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\u000b2\u000e\u0010\t\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/VideoEditorRatioList$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/VideoEditorRatioList$a$a;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/VideoEditorRatioList;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "j0", "getItemCount", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/background/VideoEditorRatioList;)V", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    private final class a extends RecyclerView.Adapter<C8433a> {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/VideoEditorRatioList$a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "title", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/background/VideoEditorRatioList$a;Landroid/view/View;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.background.VideoEditorRatioList$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public final class C8433a extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            @NotNull
            private final ImageView icon;

            /* renamed from: F, reason: from kotlin metadata */
            @NotNull
            private final TextView title;
            final /* synthetic */ a G;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8433a(@NotNull a aVar, View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
                this.G = aVar;
                View findViewById = view.findViewById(R.id.icon);
                Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.icon)");
                this.icon = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.title);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
                this.title = (TextView) findViewById2;
            }

            @NotNull
            /* renamed from: l, reason: from getter */
            public final TextView getTitle() {
                return this.title;
            }
        }

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k0(VideoEditorRatioList this$0, RatioType ratioType, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(ratioType, "$ratioType");
            this$0.setSelect(ratioType);
            VideoEditorRatioList.D(this$0);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return VideoEditorRatioList.this.ratioList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull C8433a holder, int position) {
            boolean z16;
            int parseColor;
            Intrinsics.checkNotNullParameter(holder, "holder");
            final RatioType ratioType = (RatioType) VideoEditorRatioList.this.ratioList.get(position);
            if (ratioType == VideoEditorRatioList.this.selected) {
                z16 = true;
            } else {
                z16 = false;
            }
            holder.getTitle().setText(ratioType.label());
            TextView title = holder.getTitle();
            if (z16) {
                parseColor = Color.parseColor("#2EAAFF");
            } else {
                parseColor = Color.parseColor("#FFFFFF");
            }
            title.setTextColor(parseColor);
            View view = holder.itemView;
            final VideoEditorRatioList videoEditorRatioList = VideoEditorRatioList.this;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.background.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VideoEditorRatioList.a.k0(VideoEditorRatioList.this, ratioType, view2);
                }
            });
            VideoEditorRatioList videoEditorRatioList2 = VideoEditorRatioList.this;
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            videoEditorRatioList2.G(view2, ratioType);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public C8433a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(VideoEditorRatioList.this.getContext()).inflate(R.layout.h1i, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new C8433a(this, view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditorRatioList(@NotNull Context context) {
        super(context);
        List<? extends RatioType> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.ratioList = emptyList;
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        addItemDecoration(new k(H(8.0f)));
        setAdapter(new a());
    }

    public static final /* synthetic */ com.tencent.mobileqq.qqvideoedit.editor.background.a D(VideoEditorRatioList videoEditorRatioList) {
        videoEditorRatioList.getClass();
        return null;
    }

    private final int H(float f16) {
        return (int) TypedValue.applyDimension(1, f16, getResources().getDisplayMetrics());
    }

    public static /* synthetic */ void setRatioList$default(VideoEditorRatioList videoEditorRatioList, List list, RatioType ratioType, com.tencent.mobileqq.qqvideoedit.editor.background.a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        videoEditorRatioList.setRatioList(list, ratioType, aVar);
    }

    public final void setRatioList(@NotNull List<? extends RatioType> ratioList, @Nullable RatioType selected, @Nullable com.tencent.mobileqq.qqvideoedit.editor.background.a listener) {
        Intrinsics.checkNotNullParameter(ratioList, "ratioList");
        ms.a.f("VideoEditorRatioList", "set ratio list");
        this.ratioList = ratioList;
        this.selected = selected;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void setSelect(@NotNull RatioType ratioType) {
        Intrinsics.checkNotNullParameter(ratioType, "ratioType");
        this.selected = ratioType;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditorRatioList(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        List<? extends RatioType> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.ratioList = emptyList;
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        addItemDecoration(new k(H(8.0f)));
        setAdapter(new a());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditorRatioList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<? extends RatioType> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.ratioList = emptyList;
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        addItemDecoration(new k(H(8.0f)));
        setAdapter(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(View view, RatioType ratioType) {
    }
}
