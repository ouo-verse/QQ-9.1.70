package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u00c1\u0001\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002\u0012!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\u0002\u00126\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0011\u0012:\b\u0002\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bR2\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR2\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000f\u0010\u000bRG\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\b\u0010\u0017RI\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/g;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/l;", "Lkotlin/ParameterName;", "name", "data", "", "a", "Lkotlin/jvm/functions/Function1;", "d", "()Lkotlin/jvm/functions/Function1;", "updateShowState", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "b", "startDragViewHolder", "Lkotlin/Function2;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "c", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "itemClick", "titleRightBtnClick", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<GuildCategoryChannelItemData, Unit> updateShowState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<RecyclerView.ViewHolder, Unit> startDragViewHolder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<View, b, Unit> itemClick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function2<View, b, Unit> titleRightBtnClick;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull Function1<? super GuildCategoryChannelItemData, Unit> updateShowState, @NotNull Function1<? super RecyclerView.ViewHolder, Unit> startDragViewHolder, @NotNull Function2<? super View, ? super b, Unit> itemClick, @Nullable Function2<? super View, ? super b, Unit> function2) {
        Intrinsics.checkNotNullParameter(updateShowState, "updateShowState");
        Intrinsics.checkNotNullParameter(startDragViewHolder, "startDragViewHolder");
        Intrinsics.checkNotNullParameter(itemClick, "itemClick");
        this.updateShowState = updateShowState;
        this.startDragViewHolder = startDragViewHolder;
        this.itemClick = itemClick;
        this.titleRightBtnClick = function2;
    }

    @NotNull
    public final Function2<View, b, Unit> a() {
        return this.itemClick;
    }

    @NotNull
    public final Function1<RecyclerView.ViewHolder, Unit> b() {
        return this.startDragViewHolder;
    }

    @Nullable
    public final Function2<View, b, Unit> c() {
        return this.titleRightBtnClick;
    }

    @NotNull
    public final Function1<GuildCategoryChannelItemData, Unit> d() {
        return this.updateShowState;
    }

    public /* synthetic */ g(Function1 function1, Function1 function12, Function2 function2, Function2 function22, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function2, (i3 & 8) != 0 ? null : function22);
    }
}
