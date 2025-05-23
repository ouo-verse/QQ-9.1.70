package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.ItemTouchHelper;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.ReorderContainerView;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 82\u00020\u0001:\u00039:;B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020'\u00a2\u0006\u0004\b6\u00107J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\fR\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ReorderContainerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", "provider", "", "O", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "data", "P", "", "f", "Ljava/lang/String;", "TAG", tl.h.F, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ReorderContainerView$b;", "i", "Lkotlin/Lazy;", "L", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ReorderContainerView$b;", "adapter", "Landroidx/recyclerview/widget/LinearLayoutManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/g;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/g;", "M", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/g;", "setReorderListener", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/g;)V", "reorderListener", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ItemTouchHelper;", "D", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ItemTouchHelper;", "itemTouchHelper", "", "E", "I", "targetIndex", UserInfo.SEX_FEMALE, "dragUUID", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "G", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dragViewHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "b", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ReorderContainerView extends RecyclerView {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private g reorderListener;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ItemTouchHelper itemTouchHelper;

    /* renamed from: E, reason: from kotlin metadata */
    private int targetIndex;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String dragUUID;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private RecyclerView.ViewHolder dragViewHolder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayoutManager linearLayoutManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ReorderContainerView$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "context", "", "i0", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/a;", "data", "", "submitList", "src", "dest", "j0", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "getItemCount", "holder", "onBindViewHolder", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", "getThumbnailProvider", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/d;)V", "D", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private List<ClipModel> data;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;

        public b(@NotNull com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d thumbnailProvider) {
            Intrinsics.checkNotNullParameter(thumbnailProvider, "thumbnailProvider");
            this.thumbnailProvider = thumbnailProvider;
            this.data = new ArrayList();
        }

        private final int i0(Context context) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.data.size() + 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position != 0 && position != this.data.size() + 1) {
                return 11;
            }
            return 12;
        }

        public final void j0(int src, int dest) {
            ClipModel clipModel = this.data.get(src);
            List<ClipModel> list = this.data;
            list.set(src, list.get(dest));
            this.data.set(dest, clipModel);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof h) {
                ClipModel clipModel = this.data.get(position - 1);
                h hVar = (h) holder;
                hVar.getThumbClipView().setClipUrl(clipModel.getUuid(), clipModel.getPath(), clipModel.getTimeData().getSelectStartTimeUs());
                int a16 = i.f275383a.a(clipModel.getUuid());
                if (a16 != -1) {
                    hVar.getThumbClipView().setId(a16);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (viewType == 12) {
                View view = new View(parent.getContext());
                com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
                int a16 = eVar.a(56.0f);
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                view.setLayoutParams(new ViewGroup.LayoutParams(i0(context) - eVar.a(5.0f), a16));
                return new c(view);
            }
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            ThumbClipView thumbClipView = new ThumbClipView(context2, null, 0, 6, null);
            thumbClipView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            int a17 = com.tencent.videocut.utils.e.f384236a.a(56.0f);
            thumbClipView.setLayoutParams(new ViewGroup.LayoutParams(a17, a17));
            thumbClipView.setThumbnailProvider(this.thumbnailProvider);
            return new h(thumbClipView);
        }

        public final void submitList(@NotNull List<ClipModel> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ReorderContainerView$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u001a\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ReorderContainerView$d", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ItemTouchHelper$f;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "target", "", "y", "r", "", "actionState", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "direction", "B", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d extends ItemTouchHelper.f {
        d() {
            super(51, 0);
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.ItemTouchHelper.c
        public void A(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
            View view;
            ReorderContainerView reorderContainerView;
            g reorderListener;
            View view2;
            super.A(viewHolder, actionState);
            View view3 = null;
            if (actionState == 0) {
                RecyclerView.ViewHolder viewHolder2 = ReorderContainerView.this.dragViewHolder;
                if (viewHolder2 != null) {
                    view = viewHolder2.itemView;
                } else {
                    view = null;
                }
                if (view != null) {
                    view.setSelected(false);
                }
                ReorderContainerView.this.dragViewHolder = null;
                String str = ReorderContainerView.this.dragUUID;
                if (str != null && (reorderListener = (reorderContainerView = ReorderContainerView.this).getReorderListener()) != null) {
                    reorderListener.a(str, reorderContainerView.targetIndex);
                }
                ReorderContainerView.this.dragUUID = null;
                ReorderContainerView.this.targetIndex = -1;
                return;
            }
            if (actionState == 2) {
                ReorderContainerView.this.dragViewHolder = viewHolder;
                RecyclerView.ViewHolder viewHolder3 = ReorderContainerView.this.dragViewHolder;
                if (viewHolder3 != null) {
                    view3 = viewHolder3.itemView;
                }
                if (view3 != null) {
                    view3.setSelected(true);
                }
                RecyclerView.ViewHolder viewHolder4 = ReorderContainerView.this.dragViewHolder;
                if (viewHolder4 != null && (view2 = viewHolder4.itemView) != null) {
                    view2.performHapticFeedback(0, 2);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.ItemTouchHelper.c
        public void B(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.ItemTouchHelper.c
        public boolean r() {
            return false;
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.ItemTouchHelper.c
        public boolean y(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            if (adapterPosition2 == 0 || (target instanceof c) || adapterPosition2 == ReorderContainerView.this.L().getNUM_BACKGOURND_ICON() - 1) {
                return false;
            }
            int i3 = adapterPosition2 - 1;
            ReorderContainerView.this.L().j0(adapterPosition - 1, i3);
            ReorderContainerView.this.L().notifyItemMoved(adapterPosition, adapterPosition2);
            ReorderContainerView.this.targetIndex = i3;
            viewHolder.itemView.performHapticFeedback(0, 2);
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReorderContainerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b L() {
        return (b) this.adapter.getValue();
    }

    @Nullable
    /* renamed from: M, reason: from getter */
    public final g getReorderListener() {
        return this.reorderListener;
    }

    public final void O(@NotNull com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.thumbnailProvider = provider;
        setLayoutManager(this.linearLayoutManager);
        setAdapter(L());
        addItemDecoration(new k(com.tencent.videocut.utils.e.f384236a.a(2.0f)));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new d());
        this.itemTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this);
    }

    public final void P(@NotNull List<ClipModel> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        L().submitList(data);
    }

    public final void setReorderListener(@Nullable g gVar) {
        this.reorderListener = gVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReorderContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ReorderContainerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReorderContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ReorderContainerView";
        this.thumbnailProvider = new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.c();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.ReorderContainerView$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ReorderContainerView.b invoke() {
                com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.d dVar;
                dVar = ReorderContainerView.this.thumbnailProvider;
                return new ReorderContainerView.b(dVar);
            }
        });
        this.adapter = lazy;
        this.linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.targetIndex = -1;
    }
}
