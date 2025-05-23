package d44;

import a44.StyleData;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001e\u001f B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Ld44/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ld44/b$c;", "Landroid/view/ViewGroup;", "viewGroup", "", "viewType", "l0", "styleViewHolder", "position", "", "j0", "getItemCount", "Ld44/b$a;", "onItemClickListener", "m0", "", "La44/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", BdhLogUtil.LogTag.Tag_Conn, "I", "selectedPosition", "D", "tempPosition", "E", "Ld44/b$a;", "<init>", "(Ljava/util/List;)V", "a", "b", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends RecyclerView.Adapter<c> {

    /* renamed from: C, reason: from kotlin metadata */
    private int selectedPosition;

    /* renamed from: D, reason: from kotlin metadata */
    private int tempPosition;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private a onItemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<StyleData> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Ld44/b$a;", "", "La44/f;", "data", "Ld44/b$c;", "holder", "", "position", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
        void a(@Nullable StyleData data, @Nullable c holder, int position);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Ld44/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spacePx", "<init>", "(I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: d44.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C10159b extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int spacePx;

        public C10159b(int i3) {
            this.spacePx = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = this.spacePx;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Ld44/b$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/widget/RoundRectImageView;", "E", "Lcom/tencent/widget/RoundRectImageView;", "l", "()Lcom/tencent/widget/RoundRectImageView;", "imageView", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "maskImageView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final RoundRectImageView imageView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final RoundRectImageView maskImageView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.f898350u);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.style_icon)");
            this.imageView = (RoundRectImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.f898450v);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.style_icon_mask)");
            this.maskImageView = (RoundRectImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.f898850z);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.style_text)");
            this.textView = (TextView) findViewById3;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final RoundRectImageView getImageView() {
            return this.imageView;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final RoundRectImageView getMaskImageView() {
            return this.maskImageView;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    public b(@NotNull List<StyleData> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
        this.selectedPosition = -1;
        this.tempPosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(b this$0, c styleViewHolder, int i3, StyleData data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(styleViewHolder, "$styleViewHolder");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (view.isSelected()) {
            view.setSelected(false);
            this$0.notifyItemChanged(this$0.selectedPosition);
            this$0.selectedPosition = -1;
            a aVar = this$0.onItemClickListener;
            if (aVar != null) {
                aVar.a(null, styleViewHolder, i3);
            }
        } else {
            view.setSelected(true);
            int i16 = this$0.selectedPosition;
            this$0.tempPosition = i16;
            this$0.notifyItemChanged(i16);
            this$0.selectedPosition = i3;
            this$0.notifyItemChanged(i3);
            a aVar2 = this$0.onItemClickListener;
            if (aVar2 != null) {
                aVar2.a(data, styleViewHolder, i3);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull final c styleViewHolder, final int position) {
        boolean z16;
        Intrinsics.checkNotNullParameter(styleViewHolder, "styleViewHolder");
        final StyleData styleData = this.dataList.get(position);
        View view = styleViewHolder.itemView;
        if (position == this.selectedPosition) {
            z16 = true;
        } else {
            z16 = false;
        }
        view.setSelected(z16);
        styleViewHolder.getTextView().setText(styleData.getStyleName());
        String url = styleData.getUrl();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        styleViewHolder.getImageView().setImageDrawable(URLDrawable.getDrawable(url, obtain));
        styleViewHolder.getImageView().setCornerRadiusAndMode(ViewUtils.dpToPx(8.0f), 1);
        if (position == this.selectedPosition) {
            styleViewHolder.getMaskImageView().setVisibility(0);
        } else {
            styleViewHolder.getMaskImageView().setVisibility(4);
        }
        styleViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: d44.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.k0(b.this, styleViewHolder, position, styleData, view2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hnw, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new c(view);
    }

    public final void m0(@Nullable a onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
