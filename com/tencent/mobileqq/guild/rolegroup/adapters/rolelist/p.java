package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001By\u00128\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002\u00126\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014RI\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rRG\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/p;", "", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "v", "", "a", "Lkotlin/jvm/functions/Function2;", "b", "()Lkotlin/jvm/functions/Function2;", "itemClickCallback", "", "position", "", "dragStartCallback", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<r, View, Unit> itemClickCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<r, Integer, Boolean> dragStartCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull Function2<? super r, ? super View, Unit> itemClickCallback, @NotNull Function2<? super r, ? super Integer, Boolean> dragStartCallback) {
        Intrinsics.checkNotNullParameter(itemClickCallback, "itemClickCallback");
        Intrinsics.checkNotNullParameter(dragStartCallback, "dragStartCallback");
        this.itemClickCallback = itemClickCallback;
        this.dragStartCallback = dragStartCallback;
    }

    @NotNull
    public final Function2<r, Integer, Boolean> a() {
        return this.dragStartCallback;
    }

    @NotNull
    public final Function2<r, View, Unit> b() {
        return this.itemClickCallback;
    }
}
