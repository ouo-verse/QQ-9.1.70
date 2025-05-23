package com.tencent.timi.game.gift.impl.timi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yh4.ReceiverInfoModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\"\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002./B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0014\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\nH\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\"\u0010*\u001a\u0010\u0012\f\u0012\n '*\u0004\u0018\u00010\u00040\u00040&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/ReceiverAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/gift/impl/timi/e;", "", "Lyh4/b;", "chosenReceiverInfo", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "holder", "position", "l0", "Lcom/tencent/timi/game/gift/impl/timi/ReceiverAdapter$b;", "listener", "o0", "getItemCount", "", "newReceiverInfoList", "k0", "themeColor", "p0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "ctx", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/gift/impl/timi/ReceiverAdapter$b;", "onClickListener", "D", "I", "com/tencent/timi/game/gift/impl/timi/ReceiverAdapter$c", "E", "Lcom/tencent/timi/game/gift/impl/timi/ReceiverAdapter$c;", "diffCallback", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/AsyncListDiffer;", "receiverDiff", "<init>", "(Landroid/content/Context;)V", "G", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ReceiverAdapter extends RecyclerView.Adapter<e> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b onClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    private int themeColor;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c diffCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final AsyncListDiffer<ReceiverInfoModel> receiverDiff;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context ctx;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/ReceiverAdapter$b;", "", "Lyh4/b;", "receiverInfo", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@NotNull ReceiverInfoModel receiverInfo);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/gift/impl/timi/ReceiverAdapter$c", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lyh4/b;", "p0", "p1", "", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends DiffUtil.ItemCallback<ReceiverInfoModel> {
        c() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull ReceiverInfoModel p06, @NotNull ReceiverInfoModel p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            if (Intrinsics.areEqual(p06.getDesc(), p16.getDesc()) && p06.getPriority() == p16.getPriority() && p06.getUid().uid.get() == p16.getUid().uid.get() && p06.getChosen() == p16.getChosen() && p06.getIsCertain() == p16.getIsCertain() && p06.getFake() == p16.getFake()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull ReceiverInfoModel p06, @NotNull ReceiverInfoModel p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return true;
        }
    }

    public ReceiverAdapter(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.ctx = ctx;
        this.themeColor = 2;
        c cVar = new c();
        this.diffCallback = cVar;
        this.receiverDiff = new AsyncListDiffer<>(this, cVar);
    }

    private final void j0(ReceiverInfoModel chosenReceiverInfo) {
        b bVar = this.onClickListener;
        if (bVar != null) {
            bVar.a(chosenReceiverInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(ReceiverAdapter this$0, ReceiverInfoModel receiverInfoModel, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(receiverInfoModel, "receiverInfoModel");
        this$0.j0(receiverInfoModel);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.receiverDiff.getCurrentList().size();
    }

    public final void k0(@NotNull List<ReceiverInfoModel> newReceiverInfoList) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(newReceiverInfoList, "newReceiverInfoList");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(newReceiverInfoList, null, null, null, 0, null, new Function1<ReceiverInfoModel, CharSequence>() { // from class: com.tencent.timi.game.gift.impl.timi.ReceiverAdapter$notifyDiff$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull ReceiverInfoModel it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it);
            }
        }, 31, null);
        com.tencent.timi.game.utils.l.b("ReceiverAdapter", joinToString$default);
        this.receiverDiff.submitList(newReceiverInfoList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull e holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final ReceiverInfoModel receiverInfoModel = this.receiverDiff.getCurrentList().get(position);
        Intrinsics.checkNotNullExpressionValue(receiverInfoModel, "receiverInfoModel");
        holder.l(receiverInfoModel, receiverInfoModel.getChosen(), this.themeColor);
        holder.getClickView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.gift.impl.timi.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReceiverAdapter.m0(ReceiverAdapter.this, receiverInfoModel, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public e onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.ctx).inflate(R.layout.hua, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(ctx).inflate(R.layo\u2026iver_view, parent, false)");
        return new e(inflate);
    }

    public final void o0(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onClickListener = listener;
    }

    public void p0(int themeColor) {
        this.themeColor = themeColor;
    }
}
