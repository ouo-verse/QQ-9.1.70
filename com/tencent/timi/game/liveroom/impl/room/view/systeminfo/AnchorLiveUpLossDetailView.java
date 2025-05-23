package com.tencent.timi.game.liveroom.impl.room.view.systeminfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import ht3.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yn4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0003\"#$B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001a\u0010\u001eB#\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001a\u0010 J \u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR)\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveUpLossDetailView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Landroid/util/Pair;", "", "", "upLossRecord", "", "setUpLossRecord", "Lnr2/b;", "d", "Lnr2/b;", "z0", "()Lnr2/b;", "setBinding", "(Lnr2/b;)V", "binding", "Lkotlin/Pair;", "", "e", "Ljava/util/List;", "A0", "()Ljava/util/List;", "upLossList", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "a", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorLiveUpLossDetailView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private nr2.b binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, String>> upLossList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveUpLossDetailView$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveUpLossDetailView$c;", "Lcom/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveUpLossDetailView;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveUpLossDetailView;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class b extends RecyclerView.Adapter<c> {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return AnchorLiveUpLossDetailView.this.A0().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull c holder, int position) {
            Object orNull;
            Intrinsics.checkNotNullParameter(holder, "holder");
            orNull = CollectionsKt___CollectionsKt.getOrNull(AnchorLiveUpLossDetailView.this.A0(), position);
            Pair pair = (Pair) orNull;
            if (pair != null) {
                AnchorLiveUpLossDetailView anchorLiveUpLossDetailView = AnchorLiveUpLossDetailView.this;
                holder.getUpLossTime().setText((CharSequence) pair.getFirst());
                TextView upLossValue = holder.getUpLossValue();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = anchorLiveUpLossDetailView.getResources().getString(R.string.f2310370r);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026ve_status_up_source_loss)");
                String format = String.format(string, Arrays.copyOf(new Object[]{pair.getSecond()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                upLossValue.setText(format);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dx7, parent, false);
            AnchorLiveUpLossDetailView anchorLiveUpLossDetailView = AnchorLiveUpLossDetailView.this;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new c(anchorLiveUpLossDetailView, itemView);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveUpLossDetailView$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "upLossTime", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "upLossValue", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/view/systeminfo/AnchorLiveUpLossDetailView;Landroid/view/View;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView upLossTime;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView upLossValue;
        final /* synthetic */ AnchorLiveUpLossDetailView G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull AnchorLiveUpLossDetailView anchorLiveUpLossDetailView, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.G = anchorLiveUpLossDetailView;
            View findViewById = itemView.findViewById(R.id.f114436tb);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.upLossTime)");
            this.upLossTime = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f114446tc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.upLossValue)");
            this.upLossValue = (TextView) findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getUpLossTime() {
            return this.upLossTime;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final TextView getUpLossValue() {
            return this.upLossValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorLiveUpLossDetailView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        nr2.b g16 = nr2.b.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.upLossList = new ArrayList();
        RecyclerView recyclerView = this.binding.f420972f;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.binding.f420972f.setAdapter(new b());
        TextView textView = this.binding.f420969c;
        String string = getResources().getString(R.string.yvv);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026or_live_up_loss_solution)");
        textView.setText(a.d("qqlive_default_detail_text", string));
    }

    @NotNull
    public final List<Pair<String, String>> A0() {
        return this.upLossList;
    }

    public final void setBinding(@NotNull nr2.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.binding = bVar;
    }

    public final void setUpLossRecord(@NotNull List<android.util.Pair<Long, Integer>> upLossRecord) {
        List<android.util.Pair> takeLast;
        Intrinsics.checkNotNullParameter(upLossRecord, "upLossRecord");
        takeLast = CollectionsKt___CollectionsKt.takeLast(upLossRecord, 30);
        for (android.util.Pair pair : takeLast) {
            List<Pair<String, String>> list = this.upLossList;
            Object obj = pair.first;
            Intrinsics.checkNotNullExpressionValue(obj, "it.first");
            list.add(new Pair<>(d.a(((Number) obj).longValue(), DateUtil.DATE_FORMAT_HOUR), String.valueOf(pair.second)));
        }
    }

    @NotNull
    /* renamed from: z0, reason: from getter */
    public final nr2.b getBinding() {
        return this.binding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorLiveUpLossDetailView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        nr2.b g16 = nr2.b.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.upLossList = new ArrayList();
        RecyclerView recyclerView = this.binding.f420972f;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.binding.f420972f.setAdapter(new b());
        TextView textView = this.binding.f420969c;
        String string = getResources().getString(R.string.yvv);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026or_live_up_loss_solution)");
        textView.setText(a.d("qqlive_default_detail_text", string));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorLiveUpLossDetailView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        nr2.b g16 = nr2.b.g(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.upLossList = new ArrayList();
        RecyclerView recyclerView = this.binding.f420972f;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.binding.f420972f.setAdapter(new b());
        TextView textView = this.binding.f420969c;
        String string = getResources().getString(R.string.yvv);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026or_live_up_loss_solution)");
        textView.setText(a.d("qqlive_default_detail_text", string));
    }
}
