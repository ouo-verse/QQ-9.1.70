package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper;
import com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0003>?@B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u000e\u00a2\u0006\u0004\b<\u0010=J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eR\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u0013R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "provider", "", "P", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "data", "T", "", "uuid", "Landroid/graphics/Point;", "point", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "index", ExifInterface.LATITUDE_SOUTH, "f", "Ljava/lang/String;", "TAG", tl.h.F, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView$b;", "i", "Lkotlin/Lazy;", "M", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView$b;", "adapter", "Landroidx/recyclerview/widget/LinearLayoutManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/k;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/k;", "O", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/k;", "setReorderListener", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/k;)V", "reorderListener", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ItemTouchHelper;", "D", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ItemTouchHelper;", "itemTouchHelper", "E", "I", "targetIndex", UserInfo.SEX_FEMALE, "dragUUID", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "G", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dragViewHolder", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ReorderContainerView extends RecyclerView {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private k reorderListener;

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

    @NotNull
    public Map<Integer, View> H;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayoutManager linearLayoutManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "context", "", "j0", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "data", "", "submitList", "src", "dest", "k0", "", "uuid", "i0", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "getItemCount", "holder", "onBindViewHolder", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "getThumbnailProvider", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "thumbnailProvider", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;)V", "D", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private List<ClipModel> data;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d thumbnailProvider;

        public b(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d thumbnailProvider) {
            Intrinsics.checkNotNullParameter(thumbnailProvider, "thumbnailProvider");
            this.thumbnailProvider = thumbnailProvider;
            this.data = new ArrayList();
        }

        private final int j0(Context context) {
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

        public final int i0(@NotNull String uuid) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            Iterator<ClipModel> it = this.data.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (!Intrinsics.areEqual(it.next().getUuid(), uuid)) {
                    i3++;
                } else {
                    return i3;
                }
            }
            return -1;
        }

        public final void k0(int src, int dest) {
            ClipModel clipModel = this.data.get(src);
            List<ClipModel> list = this.data;
            list.set(src, list.get(dest));
            this.data.set(dest, clipModel);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder instanceof m) {
                ClipModel clipModel = this.data.get(position - 1);
                m mVar = (m) holder;
                mVar.getThumbClipView().setClipUrl(clipModel.getUuid(), clipModel.getPath(), clipModel.getTimeData().getSelectStartTimeUs());
                int a16 = n.f319317a.a(clipModel.getUuid());
                if (a16 != -1) {
                    mVar.getThumbClipView().setId(a16);
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
                view.setLayoutParams(new ViewGroup.LayoutParams(j0(context) - eVar.a(5.0f), a16));
                return new c(view);
            }
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            ThumbClipView thumbClipView = new ThumbClipView(context2, null, 0, 6, null);
            thumbClipView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            int a17 = com.tencent.videocut.utils.e.f384236a.a(56.0f);
            thumbClipView.setLayoutParams(new ViewGroup.LayoutParams(a17, a17));
            thumbClipView.setThumbnailProvider(this.thumbnailProvider);
            return new m(thumbClipView);
        }

        public final void submitList(@NotNull List<ClipModel> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u001a\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderContainerView$d", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ItemTouchHelper$f;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "target", "", "y", "r", "", "actionState", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "direction", "B", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends ItemTouchHelper.f {
        d() {
            super(51, 0);
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper.c
        public void A(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
            View view;
            ReorderContainerView reorderContainerView;
            k reorderListener;
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

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper.c
        public void B(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper.c
        public boolean r() {
            return false;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ItemTouchHelper.c
        public boolean y(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            if (adapterPosition2 == 0 || (target instanceof c) || adapterPosition2 == ReorderContainerView.this.M().getNUM_BACKGOURND_ICON() - 1) {
                return false;
            }
            int i3 = adapterPosition2 - 1;
            ReorderContainerView.this.M().k0(adapterPosition - 1, i3);
            ReorderContainerView.this.M().notifyItemMoved(adapterPosition, adapterPosition2);
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
    public final b M() {
        return (b) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(ReorderContainerView this$0, int i3, Point point) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(point, "$point");
        View childAt = this$0.linearLayoutManager.getChildAt((i3 + 1) - this$0.linearLayoutManager.findFirstVisibleItemPosition());
        if (childAt != null) {
            int[] iArr = new int[2];
            childAt.getLocationOnScreen(iArr);
            this$0.scrollBy(iArr[0] - point.x, 0);
        }
    }

    @Nullable
    /* renamed from: O, reason: from getter */
    public final k getReorderListener() {
        return this.reorderListener;
    }

    public final void P(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.thumbnailProvider = provider;
        setLayoutManager(this.linearLayoutManager);
        setAdapter(M());
        addItemDecoration(new p(com.tencent.videocut.utils.e.f384236a.a(2.0f)));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new d());
        this.itemTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this);
    }

    public final int Q(@NotNull String uuid, @NotNull final Point point) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(point, "point");
        this.dragUUID = uuid;
        final int i06 = M().i0(uuid);
        this.linearLayoutManager.scrollToPosition(i06 + 1);
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.j
            @Override // java.lang.Runnable
            public final void run() {
                ReorderContainerView.R(ReorderContainerView.this, i06, point);
            }
        });
        return i06;
    }

    public final void S(int index) {
        ItemTouchHelper itemTouchHelper;
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = findViewHolderForLayoutPosition(index + 1);
        if (findViewHolderForLayoutPosition != null && (itemTouchHelper = this.itemTouchHelper) != null) {
            itemTouchHelper.startDrag(findViewHolderForLayoutPosition);
        }
    }

    public final void T(@NotNull List<ClipModel> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        M().submitList(data);
    }

    public final void setReorderListener(@Nullable k kVar) {
        this.reorderListener = kVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReorderContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReorderContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.H = new LinkedHashMap();
        this.TAG = "ReorderContainerView";
        this.thumbnailProvider = new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.c();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderContainerView$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ReorderContainerView.b invoke() {
                com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d dVar;
                dVar = ReorderContainerView.this.thumbnailProvider;
                return new ReorderContainerView.b(dVar);
            }
        });
        this.adapter = lazy;
        this.linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.targetIndex = -1;
    }

    public /* synthetic */ ReorderContainerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
