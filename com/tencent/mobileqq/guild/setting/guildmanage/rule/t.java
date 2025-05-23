package com.tencent.mobileqq.guild.setting.guildmanage.rule;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rz1.RuleData;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0093\u0001\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002\u00126\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\f\u0012!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00070\u0002\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dR2\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nRG\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\f8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R2\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00070\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0016\u0010\nR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u000f\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/t;", "", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "a", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "addRule", "Lkotlin/Function2;", "Lrz1/d;", "ruleData", "b", "Lkotlin/jvm/functions/Function2;", "c", "()Lkotlin/jvm/functions/Function2;", "deleteRule", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "d", "startDrag", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "checkDataChanged", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, Unit> addRule;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<View, RuleData, Unit> deleteRule;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<RecyclerView.ViewHolder, Unit> startDrag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> checkDataChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public t(@NotNull Function1<? super View, Unit> addRule, @NotNull Function2<? super View, ? super RuleData, Unit> deleteRule, @NotNull Function1<? super RecyclerView.ViewHolder, Unit> startDrag, @NotNull Function0<Unit> checkDataChanged) {
        Intrinsics.checkNotNullParameter(addRule, "addRule");
        Intrinsics.checkNotNullParameter(deleteRule, "deleteRule");
        Intrinsics.checkNotNullParameter(startDrag, "startDrag");
        Intrinsics.checkNotNullParameter(checkDataChanged, "checkDataChanged");
        this.addRule = addRule;
        this.deleteRule = deleteRule;
        this.startDrag = startDrag;
        this.checkDataChanged = checkDataChanged;
    }

    @NotNull
    public final Function1<View, Unit> a() {
        return this.addRule;
    }

    @NotNull
    public final Function0<Unit> b() {
        return this.checkDataChanged;
    }

    @NotNull
    public final Function2<View, RuleData, Unit> c() {
        return this.deleteRule;
    }

    @NotNull
    public final Function1<RecyclerView.ViewHolder, Unit> d() {
        return this.startDrag;
    }
}
