package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class h extends MenuBuilder {
    public h(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int i3, int i16, int i17, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i3, i16, i17, charSequence);
        j jVar = new j(getContext(), this, menuItemImpl);
        menuItemImpl.setSubMenu(jVar);
        return jVar;
    }
}
