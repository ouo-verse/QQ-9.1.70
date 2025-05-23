package al2;

import al2.h;
import android.graphics.Outline;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.hb.panel.RecommendSkinView;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001f2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002 !B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R?\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lal2/h;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lal2/h$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "hbSkinList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "skinId", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "i0", "()Lkotlin/jvm/functions/Function1;", "l0", "(Lkotlin/jvm/functions/Function1;)V", "callback", "<init>", "(Ljava/util/List;)V", "D", "a", "b", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class h extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<? super Integer, Unit> callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<RedPackSkin$RecommendSkin> hbSkinList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lal2/h$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", "recommendSkin", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qwallet/hb/panel/RecommendSkinView;", "E", "Lcom/tencent/mobileqq/qwallet/hb/panel/RecommendSkinView;", "hbSkinItemView", "Landroid/view/View;", "itemView", "<init>", "(Lal2/h;Landroid/view/View;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final RecommendSkinView hbSkinItemView;
        final /* synthetic */ h F;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"al2/h$b$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final class a extends ViewOutlineProvider {
            a() {
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(@NotNull View view, @NotNull Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getWidth() * 0.095f);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull h hVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.F = hVar;
            View findViewById = itemView.findViewById(R.id.f71483o_);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.recommend_skin_view)");
            RecommendSkinView recommendSkinView = (RecommendSkinView) findViewById;
            this.hbSkinItemView = recommendSkinView;
            recommendSkinView.setOutlineProvider(new a());
            recommendSkinView.setClipToOutline(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(h this$0, RedPackSkin$RecommendSkin recommendSkin, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(recommendSkin, "$recommendSkin");
            Function1<Integer, Unit> i06 = this$0.i0();
            if (i06 != null) {
                i06.invoke(Integer.valueOf(RedPackSkinExt.f(recommendSkin)));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final RedPackSkin$RecommendSkin recommendSkin) {
            Intrinsics.checkNotNullParameter(recommendSkin, "recommendSkin");
            if (QLog.isColorLevel()) {
                QLog.d("HbSkinListAdapter", 2, "onBindViewHolder " + recommendSkin);
            }
            this.hbSkinItemView.setScene(0);
            this.hbSkinItemView.A0(recommendSkin, 2);
            RecommendSkinView recommendSkinView = this.hbSkinItemView;
            final h hVar = this.F;
            recommendSkinView.setOnClickListener(new View.OnClickListener() { // from class: al2.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.b.n(h.this, recommendSkin, view);
                }
            });
        }
    }

    public h(@NotNull List<RedPackSkin$RecommendSkin> hbSkinList) {
        Intrinsics.checkNotNullParameter(hbSkinList, "hbSkinList");
        this.hbSkinList = hbSkinList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.hbSkinList.size();
    }

    @Nullable
    public final Function1<Integer, Unit> i0() {
        return this.callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.m(this.hbSkinList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hj9, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026mend_item, parent, false)");
        return new b(this, inflate);
    }

    public final void l0(@Nullable Function1<? super Integer, Unit> function1) {
        this.callback = function1;
    }
}
