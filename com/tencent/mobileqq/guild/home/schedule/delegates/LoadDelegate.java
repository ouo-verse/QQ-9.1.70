package com.tencent.mobileqq.guild.home.schedule.delegates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.home.schedule.models.d;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001 B#\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J4\u0010\u0012\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/LoadDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "items", "", "position", "", "j", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", "", "k", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnLoadPrevious", "()Lkotlin/jvm/functions/Function0;", "setOnLoadPrevious", "(Lkotlin/jvm/functions/Function0;)V", "onLoadPrevious", "e", "getOnLoadNext", "setOnLoadNext", "onLoadNext", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LoadDelegate extends com.tencent.mobileqq.guild.widget.adapterdelegates.b<List<? extends d>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<Unit> onLoadPrevious;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<Unit> onLoadNext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/LoadDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    public LoadDelegate(@NotNull Function0<Unit> onLoadPrevious, @NotNull Function0<Unit> onLoadNext) {
        Intrinsics.checkNotNullParameter(onLoadPrevious, "onLoadPrevious");
        Intrinsics.checkNotNullParameter(onLoadNext, "onLoadNext");
        this.onLoadPrevious = onLoadPrevious;
        this.onLoadNext = onLoadNext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Space space = new Space(parent.getContext());
        space.setLayoutParams(new RecyclerView.LayoutParams(-1, 1));
        return new a(space);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends d> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (items.get(position).getType() != 2 && items.get(position).getType() != 3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull List<? extends d> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (items.get(position).getType() == 3) {
            this.onLoadPrevious.invoke();
        } else {
            this.onLoadNext.invoke();
        }
    }
}
