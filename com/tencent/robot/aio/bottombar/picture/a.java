package com.tencent.robot.aio.bottombar.picture;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.robot.aio.bottombar.picture.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B8\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u0012!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\f0\u0016\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0014\u0010\u0011\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R/\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\f0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "getItemCount", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "", "onBindViewHolder", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "newList", "l0", "Lkotlin/Function0;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function0;", "onItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "onDeleteClick", "", "D", "Ljava/util/List;", "dataList", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "E", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<LocalMediaInfo, Unit> onDeleteClick;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onItemClick;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/bottombar/picture/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "data", "", "p", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "imageView", "Landroid/widget/ImageButton;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageButton;", "deleteButton", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/robot/aio/bottombar/picture/a;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView imageView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageButton deleteButton;
        final /* synthetic */ a G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull final a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.G = aVar;
            View findViewById = itemView.findViewById(R.id.f771943p);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.robot_picture_selected)");
            ImageView imageView = (ImageView) findViewById;
            this.imageView = imageView;
            View findViewById2 = itemView.findViewById(R.id.f765041u);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026_delete_picture_selected)");
            ImageButton imageButton = (ImageButton) findViewById2;
            this.deleteButton = imageButton;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.aio.bottombar.picture.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.n(a.b.this, aVar, view);
                }
            });
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.aio.bottombar.picture.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.o(a.b.this, aVar, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(b this$0, a this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int adapterPosition = this$0.getAdapterPosition();
            if (adapterPosition != -1 && adapterPosition < this$1.dataList.size()) {
                this$1.onItemClick.invoke();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(b this$0, a this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int adapterPosition = this$0.getAdapterPosition();
            if (adapterPosition != -1 && adapterPosition < this$1.dataList.size()) {
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) this$1.dataList.get(adapterPosition);
                this$1.dataList.remove(adapterPosition);
                this$1.notifyDataSetChanged();
                this$1.onDeleteClick.invoke(localMediaInfo);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void p(@NotNull LocalMediaInfo data) {
            Intrinsics.checkNotNullParameter(data, "data");
            String path = data.getPath();
            if (path == null) {
                return;
            }
            int dip2px = ViewUtils.dip2px(72.0f);
            ((IPicAIOApi) QRoute.api(IPicAIOApi.class)).loadPic(new com.tencent.mobileqq.pic.option.a(path, this.imageView, true, dip2px, dip2px, null, null, 96, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function0<Unit> onItemClick, @NotNull Function1<? super LocalMediaInfo, Unit> onDeleteClick) {
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onDeleteClick, "onDeleteClick");
        this.onItemClick = onItemClick;
        this.onDeleteClick = onDeleteClick;
        this.dataList = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 0;
    }

    public final void l0(@NotNull List<LocalMediaInfo> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.dataList.clear();
        this.dataList.addAll(newList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof b) {
            ((b) holder).p(this.dataList.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoa, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new b(this, itemView);
        }
        throw new IllegalArgumentException("\u52a0\u8f7d\u56fe\u7247\u5931\u8d25");
    }
}
