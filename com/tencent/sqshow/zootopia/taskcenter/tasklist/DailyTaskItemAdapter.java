package com.tencent.sqshow.zootopia.taskcenter.tasklist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskRewardInfo;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ae;
import com.tencent.sqshow.zootopia.utils.i;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/DailyTaskItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/DailyTaskItemAdapter$ViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "getItemCount", "holder", "position", "", "j0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "Lcom/tencent/sqshow/zootopia/data/w;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getDatas", "()Ljava/util/List;", "setDatas", "(Ljava/util/List;)V", "datas", "Landroid/graphics/drawable/Drawable;", "D", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "E", "I", "DP_8", UserInfo.SEX_FEMALE, "DP_21", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "G", "a", "ViewHolder", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DailyTaskItemAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int H = R.drawable.iic;

    /* renamed from: C, reason: from kotlin metadata */
    private List<ZootopiaTaskRewardInfo> datas;

    /* renamed from: D, reason: from kotlin metadata */
    private final Drawable errorDrawable;

    /* renamed from: E, reason: from kotlin metadata */
    private final int DP_8;

    /* renamed from: F, reason: from kotlin metadata */
    private final int DP_21;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/tasklist/DailyTaskItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "rewardIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "l", "()Landroid/widget/TextView;", "rewardDesc", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final Lazy rewardIcon;

        /* renamed from: F, reason: from kotlin metadata */
        private final Lazy rewardDesc;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(final View itemView) {
            super(itemView);
            Lazy lazy;
            Lazy lazy2;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.DailyTaskItemAdapter$ViewHolder$rewardIcon$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ImageView invoke() {
                    return (ImageView) itemView.findViewById(R.id.qhk);
                }
            });
            this.rewardIcon = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.DailyTaskItemAdapter$ViewHolder$rewardDesc$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    return (TextView) itemView.findViewById(R.id.qhi);
                }
            });
            this.rewardDesc = lazy2;
        }

        public final TextView l() {
            Object value = this.rewardDesc.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-rewardDesc>(...)");
            return (TextView) value;
        }

        public final ImageView m() {
            Object value = this.rewardIcon.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-rewardIcon>(...)");
            return (ImageView) value;
        }
    }

    public DailyTaskItemAdapter(Context context, List<ZootopiaTaskRewardInfo> datas) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(datas, "datas");
        this.context = context;
        this.datas = datas;
        Resources resources = context.getResources();
        Drawable drawable = resources != null ? resources.getDrawable(H) : null;
        Intrinsics.checkNotNull(drawable);
        this.errorDrawable = drawable;
        this.DP_8 = i.a(8.0f);
        this.DP_21 = i.a(21.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(DailyTaskItemAdapter this$0, ViewHolder holder, ZootopiaTaskRewardInfo zootopiaTaskRewardInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        bc4.c.f28271a.e(this$0.context, holder.itemView, String.valueOf(zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getItemTitle() : null), new int[]{this$0.DP_21, this$0.DP_8});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.datas.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.datas.isEmpty();
        final ZootopiaTaskRewardInfo zootopiaTaskRewardInfo = this.datas.get(position);
        QLog.d("DailyTaskItemAdapter", 1, "onBindViewHolder, position" + position + ", itemData:" + zootopiaTaskRewardInfo);
        holder.l().setVisibility(0);
        holder.l().setText(String.valueOf(zootopiaTaskRewardInfo != null ? Integer.valueOf(zootopiaTaskRewardInfo.getRewardItemCnt()) : null));
        ae.INSTANCE.a(holder.m(), zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getItemIcon() : null, this.errorDrawable, H);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        aa.f(view, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.taskcenter.tasklist.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DailyTaskItemAdapter.k0(DailyTaskItemAdapter.this, holder, zootopiaTaskRewardInfo, view2);
            }
        }, 1000L, "DailyTaskItemAdapter");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dgp, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026item_view, parent, false)");
        return new ViewHolder(inflate);
    }
}
