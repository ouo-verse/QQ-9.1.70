package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class a extends MenuBuilder {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Class<?> f33931a;

    /* renamed from: b, reason: collision with root package name */
    private final int f33932b;

    public a(@NonNull Context context, @NonNull Class<?> cls, int i3) {
        super(context);
        this.f33931a = cls;
        this.f33932b = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.view.menu.MenuBuilder
    @NonNull
    public MenuItem addInternal(int i3, int i16, int i17, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.f33932b) {
            stopDispatchingItemsChanged();
            MenuItem addInternal = super.addInternal(i3, i16, i17, charSequence);
            if (addInternal instanceof MenuItemImpl) {
                ((MenuItemImpl) addInternal).setExclusiveCheckable(true);
            }
            startDispatchingItemsChanged();
            return addInternal;
        }
        String simpleName = this.f33931a.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.f33932b + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int i3, int i16, int i17, @NonNull CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f33931a.getSimpleName() + " does not support submenus");
    }
}
