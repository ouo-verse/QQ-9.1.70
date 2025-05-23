package com.tencent.timi.game.live.impl.danmuku.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.PremadesTeamServerOuterClass$TextShowInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0003\u0017\u0005\u0006B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView;", "Landroid/widget/LinearLayout;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "", "b", "c", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "danmakuSelectorRv", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$b;", "e", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$b;", "danmakuEffectsSelectorAdapter", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class DanmakuSelectorView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView danmakuSelectorRv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b danmakuEffectsSelectorAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Ltrpc/yes/common/PremadesTeamServerOuterClass$TextShowInfo;", "textShowInfoList", "", "selectShowType", "", "k0", "Landroid/view/ViewGroup;", "p0", "p1", "onCreateViewHolder", "onBindViewHolder", "getItemCount", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView;", "danmakuChooserView", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$c;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/AsyncListDiffer;", "danmakuShowTypeDiff", "<init>", "(Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final AsyncListDiffer<c> danmakuShowTypeDiff;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final DanmakuSelectorView danmakuChooserView;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$c;", "p0", "p1", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes26.dex */
        public static final class a extends DiffUtil.ItemCallback<c> {
            a() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull c p06, @NotNull c p16) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                Intrinsics.checkNotNullParameter(p16, "p1");
                if (p06.getSelect() == p16.getSelect() && p06.getData().show_type.get() == p16.getData().show_type.get()) {
                    return true;
                }
                return false;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull c p06, @NotNull c p16) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                Intrinsics.checkNotNullParameter(p16, "p1");
                return true;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$b$b", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorView$b$b, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C9930b extends RecyclerView.ViewHolder {
            C9930b(DanmakuSelectorItemView danmakuSelectorItemView) {
                super(danmakuSelectorItemView);
            }
        }

        public b(@NotNull DanmakuSelectorView danmakuChooserView) {
            Intrinsics.checkNotNullParameter(danmakuChooserView, "danmakuChooserView");
            this.danmakuChooserView = danmakuChooserView;
            this.danmakuShowTypeDiff = new AsyncListDiffer<>(this, new a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j0(b this$0, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.danmakuChooserView.b(this$0.danmakuShowTypeDiff.getCurrentList().get(i3).getData().show_type.get());
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.danmakuShowTypeDiff.getCurrentList().size();
        }

        public final void k0(@NotNull List<PremadesTeamServerOuterClass$TextShowInfo> textShowInfoList, int selectShowType) {
            int collectionSizeOrDefault;
            boolean z16;
            Object firstOrNull;
            PBInt32Field pBInt32Field;
            boolean z17;
            Intrinsics.checkNotNullParameter(textShowInfoList, "textShowInfoList");
            Iterator<PremadesTeamServerOuterClass$TextShowInfo> it = textShowInfoList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (it.next().show_type.get() == selectShowType) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 == -1) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) textShowInfoList);
                PremadesTeamServerOuterClass$TextShowInfo premadesTeamServerOuterClass$TextShowInfo = (PremadesTeamServerOuterClass$TextShowInfo) firstOrNull;
                if (premadesTeamServerOuterClass$TextShowInfo != null && (pBInt32Field = premadesTeamServerOuterClass$TextShowInfo.show_type) != null) {
                    selectShowType = pBInt32Field.get();
                } else {
                    selectShowType = -1;
                }
            }
            AsyncListDiffer<c> asyncListDiffer = this.danmakuShowTypeDiff;
            List<PremadesTeamServerOuterClass$TextShowInfo> list = textShowInfoList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (PremadesTeamServerOuterClass$TextShowInfo premadesTeamServerOuterClass$TextShowInfo2 : list) {
                if (premadesTeamServerOuterClass$TextShowInfo2.show_type.get() == selectShowType) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                arrayList.add(new c(z16, premadesTeamServerOuterClass$TextShowInfo2));
            }
            asyncListDiffer.submitList(arrayList);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder p06, final int p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            c cVar = this.danmakuShowTypeDiff.getCurrentList().get(p16);
            View view = p06.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorItemView");
            ((DanmakuSelectorItemView) view).a(cVar.getSelect(), cVar.getData().show_type.get());
            p06.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.live.impl.danmuku.selector.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DanmakuSelectorView.b.j0(DanmakuSelectorView.b.this, p16, view2);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup p06, int p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Context context = p06.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "p0.context");
            return new C9930b(new DanmakuSelectorItemView(context, null, 0, 6, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$c;", "", "", "a", "Z", "b", "()Z", "setSelect", "(Z)V", "select", "Ltrpc/yes/common/PremadesTeamServerOuterClass$TextShowInfo;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$TextShowInfo;", "()Ltrpc/yes/common/PremadesTeamServerOuterClass$TextShowInfo;", "data", "<init>", "(ZLtrpc/yes/common/PremadesTeamServerOuterClass$TextShowInfo;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean select;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PremadesTeamServerOuterClass$TextShowInfo data;

        public c(boolean z16, @NotNull PremadesTeamServerOuterClass$TextShowInfo data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.select = z16;
            this.data = data;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final PremadesTeamServerOuterClass$TextShowInfo getData() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getSelect() {
            return this.select;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DanmakuSelectorView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int showType) {
        c();
    }

    private final void c() {
        List<PremadesTeamServerOuterClass$TextShowInfo> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.danmakuEffectsSelectorAdapter.k0(emptyList, -1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DanmakuSelectorView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ DanmakuSelectorView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DanmakuSelectorView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.danmakuEffectsSelectorAdapter = new b(this);
        setOrientation(0);
        setBackgroundResource(R.drawable.lrd);
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fh4.b.b(24), fh4.b.b(36));
        layoutParams.topMargin = fh4.b.b(12);
        layoutParams.leftMargin = fh4.b.b(12);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.f162551o74);
        addView(imageView);
        RecyclerView recyclerView = new RecyclerView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.rightMargin = fh4.b.b(12);
        recyclerView.setLayoutParams(layoutParams2);
        this.danmakuSelectorRv = recyclerView;
        recyclerView.setClipChildren(false);
        addView(recyclerView);
    }
}
