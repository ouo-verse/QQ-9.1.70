package com.tencent.timi.game.liveroom.impl.room.input;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageLayout;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.liveroom.impl.room.input.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001#B\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b!\u0010\"J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u001c\u0010\n\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u001c\u0010\r\u001a\u00020\u00052\n\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R6\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/t;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/liveroom/impl/room/input/t$a;", "", "position", "", "n0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "getItemCount", "holder", "k0", "Lcom/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel;", "j0", "()Lcom/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel;", "inputViewModel", BdhLogUtil.LogTag.Tag_Conn, "I", "checkedPosition", "", "Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "value", "D", "Ljava/util/List;", "getBarrageDataSet", "()Ljava/util/List;", "m0", "(Ljava/util/List;)V", "barrageDataSet", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel;)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class t extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private int checkedPosition = -1;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<BarrageData> barrageDataSet = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QQLiveAudienceBarrageViewModel inputViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/t$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "barrageData", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageLayout;", "kotlin.jvm.PlatformType", "E", "Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageLayout;", "barrageLayout", "Landroid/widget/CheckedTextView;", UserInfo.SEX_FEMALE, "Landroid/widget/CheckedTextView;", "checkedIndicator", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "numText", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/input/t;Landroid/view/View;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final GradientBarrageLayout barrageLayout;

        /* renamed from: F, reason: from kotlin metadata */
        private final CheckedTextView checkedIndicator;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView numText;
        final /* synthetic */ t H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull t tVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = tVar;
            GradientBarrageLayout gradientBarrageLayout = (GradientBarrageLayout) itemView.findViewById(R.id.tq7);
            this.barrageLayout = gradientBarrageLayout;
            this.checkedIndicator = (CheckedTextView) itemView.findViewById(R.id.tvy);
            this.numText = (TextView) itemView.findViewById(R.id.zvr);
            gradientBarrageLayout.setTextPadding(wi2.c.b(8), wi2.c.b(3), wi2.c.b(8), wi2.c.b(3));
            gradientBarrageLayout.setTextSizeDp(10.0f);
            gradientBarrageLayout.setSurroundingTextPadding(0, wi2.c.b(2), wi2.c.b(4), wi2.c.b(2));
            gradientBarrageLayout.setSurroundTextSizeDp(6.0f);
            gradientBarrageLayout.setSurroundingTextOffset(wi2.c.d(-5), wi2.c.d(-15));
            ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
            String valueOf = String.valueOf(itemView.hashCode());
            Intrinsics.checkNotNullExpressionValue(aVar, "getService(ILiveReportService::class.java)");
            a.C11346a.a(aVar, itemView, false, valueOf, "em_qqlive_barrage_type", null, 18, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(t this$0, a this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            QQLiveAudienceBarrageViewModel inputViewModel = this$0.getInputViewModel();
            if (inputViewModel != null) {
                inputViewModel.l2(this$1.getLayoutPosition());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map p(BarrageData barrageData, long j3, String payLevel, String str) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(barrageData, "$barrageData");
            Intrinsics.checkNotNullParameter(payLevel, "$payLevel");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("qqlive_barrage_type", barrageData.getConfig().getText()), TuplesKt.to("qqlive_live_visitor", Long.valueOf(j3)), TuplesKt.to("qqlive_user_grade", payLevel));
            return mutableMapOf;
        }

        public final void n(@NotNull final BarrageData barrageData) {
            int coerceAtMost;
            List<String> list;
            final long j3;
            Long payLevel;
            String valueOf;
            Intrinsics.checkNotNullParameter(barrageData, "barrageData");
            BarrageConfig config = barrageData.getConfig();
            String text = config.getText();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(config.getText().length(), 4);
            boolean z16 = false;
            String substring = text.substring(0, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            this.barrageLayout.setText(substring);
            this.barrageLayout.setSurroundText(substring);
            GradientBarrageLayout gradientBarrageLayout = this.barrageLayout;
            List<String> d16 = config.d();
            List<String> b16 = config.b();
            list = CollectionsKt___CollectionsKt.toList(config.a());
            gradientBarrageLayout.setColors(d16, b16, list);
            this.barrageLayout.setSurroundTextColor(config.d());
            this.barrageLayout.setSingleLine(config.getIsSingleLine());
            if (barrageData.h()) {
                this.numText.setVisibility(0);
                if (barrageData.getLeftCount() > 99) {
                    valueOf = "99+";
                } else {
                    valueOf = String.valueOf(barrageData.getLeftCount());
                }
                this.numText.setText(valueOf);
            } else {
                this.numText.setVisibility(4);
            }
            CheckedTextView checkedTextView = this.checkedIndicator;
            if (this.H.checkedPosition == getLayoutPosition()) {
                z16 = true;
            }
            checkedTextView.setChecked(z16);
            View view = this.itemView;
            final t tVar = this.H;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.input.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    t.a.o(t.this, this, view2);
                }
            });
            QQLiveAudienceBarrageViewModel inputViewModel = this.H.getInputViewModel();
            long j16 = 0;
            if (inputViewModel != null) {
                j3 = inputViewModel.X1();
            } else {
                j3 = 0;
            }
            QQLiveAudienceBarrageViewModel inputViewModel2 = this.H.getInputViewModel();
            if (inputViewModel2 != null && (payLevel = inputViewModel2.getPayLevel()) != null) {
                j16 = payLevel.longValue();
            }
            final String valueOf2 = String.valueOf(j16);
            VideoReport.setEventDynamicParams(this.itemView, new IDynamicParams() { // from class: com.tencent.timi.game.liveroom.impl.room.input.s
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map p16;
                    p16 = t.a.p(BarrageData.this, j3, valueOf2, str);
                    return p16;
                }
            });
        }
    }

    public t(@Nullable QQLiveAudienceBarrageViewModel qQLiveAudienceBarrageViewModel) {
        this.inputViewModel = qQLiveAudienceBarrageViewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.barrageDataSet.size();
    }

    @Nullable
    /* renamed from: j0, reason: from getter */
    public final QQLiveAudienceBarrageViewModel getInputViewModel() {
        return this.inputViewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.n(this.barrageDataSet.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.h9i, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026ew_holder, parent, false)");
        return new a(this, inflate);
    }

    public final void m0(@NotNull List<BarrageData> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.barrageDataSet.clear();
        this.barrageDataSet.addAll(value);
        notifyDataSetChanged();
    }

    public final void n0(int position) {
        if (this.checkedPosition == position) {
            return;
        }
        this.checkedPosition = position;
        notifyDataSetChanged();
    }
}
