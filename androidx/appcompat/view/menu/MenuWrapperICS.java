package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.mWrappedObject = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i3, int i16, int i17, ComponentName componentName, Intent[] intentArr, Intent intent, int i18, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        } else {
            menuItemArr2 = null;
        }
        int addIntentOptions = this.mWrappedObject.addIntentOptions(i3, i16, i17, componentName, intentArr, intent, i18, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i19 = 0; i19 < length; i19++) {
                menuItemArr[i19] = getMenuItemWrapper(menuItemArr2[i19]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        internalClear();
        this.mWrappedObject.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.mWrappedObject.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i3) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(i3));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i3) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(i3));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return this.mWrappedObject.isShortcutKey(i3, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i3, int i16) {
        return this.mWrappedObject.performIdentifierAction(i3, i16);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i3, KeyEvent keyEvent, int i16) {
        return this.mWrappedObject.performShortcut(i3, keyEvent, i16);
    }

    @Override // android.view.Menu
    public void removeGroup(int i3) {
        internalRemoveGroup(i3);
        this.mWrappedObject.removeGroup(i3);
    }

    @Override // android.view.Menu
    public void removeItem(int i3) {
        internalRemoveItem(i3);
        this.mWrappedObject.removeItem(i3);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i3, boolean z16, boolean z17) {
        this.mWrappedObject.setGroupCheckable(i3, z16, z17);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i3, boolean z16) {
        this.mWrappedObject.setGroupEnabled(i3, z16);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i3, boolean z16) {
        this.mWrappedObject.setGroupVisible(i3, z16);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z16) {
        this.mWrappedObject.setQwertyMode(z16);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mWrappedObject.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i3) {
        return getMenuItemWrapper(this.mWrappedObject.add(i3));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i3));
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i16, int i17, CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(i3, i16, i17, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i16, int i17, CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i3, i16, i17, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i16, int i17, int i18) {
        return getMenuItemWrapper(this.mWrappedObject.add(i3, i16, i17, i18));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i16, int i17, int i18) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i3, i16, i17, i18));
    }
}
