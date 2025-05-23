package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface MenuView {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl menuItemImpl, int i3);

        boolean prefersCondensedTitle();

        void setCheckable(boolean z16);

        void setChecked(boolean z16);

        void setEnabled(boolean z16);

        void setIcon(Drawable drawable);

        void setShortcut(boolean z16, char c16);

        void setTitle(CharSequence charSequence);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder menuBuilder);
}
