package com.tencent.mobileqq.wink.editor.menu;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/menu/w;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "a", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "b", "()Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "menuType", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "args", "<init>", "(Lcom/tencent/mobileqq/wink/editor/menu/MenuType;Landroid/os/Bundle;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.menu.w, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MenuSwitchAction {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MenuType menuType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bundle args;

    public MenuSwitchAction(@NotNull MenuType menuType, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(menuType, "menuType");
        this.menuType = menuType;
        this.args = bundle;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Bundle getArgs() {
        return this.args;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final MenuType getMenuType() {
        return this.menuType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenuSwitchAction)) {
            return false;
        }
        MenuSwitchAction menuSwitchAction = (MenuSwitchAction) other;
        if (this.menuType == menuSwitchAction.menuType && Intrinsics.areEqual(this.args, menuSwitchAction.args)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.menuType.hashCode() * 31;
        Bundle bundle = this.args;
        if (bundle == null) {
            hashCode = 0;
        } else {
            hashCode = bundle.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "MenuSwitchAction(menuType=" + this.menuType + ", args=" + this.args + ")";
    }
}
