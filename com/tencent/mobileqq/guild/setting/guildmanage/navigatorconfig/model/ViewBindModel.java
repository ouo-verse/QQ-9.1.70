package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000e\u001a\u00020\t\u00120\b\u0002\u0010\u0017\u001a*\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f\u00a2\u0006\u0002\b\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR?\u0010\u0017\u001a*\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f\u00a2\u0006\u0002\b\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "b", "()Landroid/view/View;", "view", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "color", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "customFun", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ViewBindModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Function2<View, Integer, Unit> customFun;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewBindModel(@NotNull View view, @Nullable Function2<? super View, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.customFun = function2;
    }

    @Nullable
    public final Function2<View, Integer, Unit> a() {
        return this.customFun;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final View getView() {
        return this.view;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewBindModel)) {
            return false;
        }
        ViewBindModel viewBindModel = (ViewBindModel) other;
        if (Intrinsics.areEqual(this.view, viewBindModel.view) && Intrinsics.areEqual(this.customFun, viewBindModel.customFun)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.view.hashCode() * 31;
        Function2<View, Integer, Unit> function2 = this.customFun;
        if (function2 == null) {
            hashCode = 0;
        } else {
            hashCode = function2.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "ViewBindModel(view=" + this.view + ", customFun=" + this.customFun + ")";
    }
}
