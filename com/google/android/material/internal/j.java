package com.google.android.material.internal;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class j extends SubMenuBuilder {
    public j(Context context, h hVar, MenuItemImpl menuItemImpl) {
        super(context, hVar, menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void onItemsChanged(boolean z16) {
        super.onItemsChanged(z16);
        ((MenuBuilder) getParentMenu()).onItemsChanged(z16);
    }
}
