package com.tencent.luggage.wxa.mo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h implements ContextMenu {

    /* renamed from: a, reason: collision with root package name */
    public List f134826a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f134827b;

    /* renamed from: c, reason: collision with root package name */
    public Context f134828c;

    public h(Context context) {
        this.f134828c = context;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i16, int i17, int i18) {
        i iVar = new i(this.f134828c, i16, i3);
        iVar.setTitle(i18);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem addInSecondLine(int i3, CharSequence charSequence, int i16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.setIcon(i16);
        iVar.a(true);
        this.f134826a.add(iVar);
        return iVar;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i3, int i16, int i17, ComponentName componentName, Intent[] intentArr, Intent intent, int i18, MenuItem[] menuItemArr) {
        return 0;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3) {
        return null;
    }

    public MenuItem addWithTempHighLight(int i3, CharSequence charSequence, int i16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.setIcon(i16);
        iVar.f(true);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem addWithTitleColor(int i3, int i16, int i17) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.b(i16, i17);
        this.f134826a.add(iVar);
        return iVar;
    }

    @Override // android.view.Menu
    public void clear() {
        Iterator it = this.f134826a.iterator();
        while (it.hasNext()) {
            i iVar = (i) ((MenuItem) it.next());
            iVar.a((ContextMenu.ContextMenuInfo) null);
            iVar.setOnMenuItemClickListener(null);
        }
        this.f134826a.clear();
        this.f134827b = null;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i3) {
        for (MenuItem menuItem : this.f134826a) {
            if (menuItem.getItemId() == i3) {
                return menuItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i3) {
        Iterator it = this.f134826a.iterator();
        int i16 = -1;
        while (it.hasNext()) {
            i16++;
            if (((MenuItem) it.next()).getItemId() == i3) {
                return i16;
            }
        }
        return -1;
    }

    public CharSequence getHeaderTitle() {
        return this.f134827b;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i3) {
        return (MenuItem) this.f134826a.get(i3);
    }

    public List<MenuItem> getItemList() {
        return this.f134826a;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return false;
    }

    public boolean isMenuEmpty() {
        if (this.f134826a.size() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i3, int i16) {
        return false;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i3, KeyEvent keyEvent, int i16) {
        return false;
    }

    @Override // android.view.Menu
    public void removeItem(int i3) {
        ArrayList arrayList = new ArrayList();
        for (MenuItem menuItem : this.f134826a) {
            if (menuItem.getItemId() == i3) {
                arrayList.add(menuItem);
            }
        }
        this.f134826a.removeAll(arrayList);
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderIcon(int i3) {
        return this;
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderTitle(int i3) {
        return i3 > 0 ? setHeaderTitle(this.f134828c.getString(i3)) : this;
    }

    @Override // android.view.Menu
    public int size() {
        List list = this.f134826a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i16, int i17, int i18) {
        return null;
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderIcon(Drawable drawable) {
        return this;
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderTitle(CharSequence charSequence) {
        if (charSequence == null) {
            return this;
        }
        this.f134827b = charSequence;
        return this;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i16, int i17, CharSequence charSequence) {
        return null;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i16, int i17, CharSequence charSequence) {
        i iVar = new i(this.f134828c, i16, i3);
        iVar.setTitle(charSequence);
        this.f134826a.add(iVar);
        return iVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    public MenuItem addWithTempHighLight(int i3, CharSequence charSequence, int i16, int i17, boolean z16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(i16, i17);
        iVar.b(z16);
        iVar.f(true);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, int i16, int i17, CharSequence charSequence, int i18) {
        i iVar = new i(this.f134828c, i16, i3);
        iVar.setTitle(charSequence);
        iVar.setIcon(i18);
        this.f134826a.add(iVar);
        return iVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3) {
        i iVar = new i(this.f134828c, 0, 0);
        iVar.setTitle(i3);
        this.f134826a.add(iVar);
        return iVar;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        i iVar = new i(this.f134828c, 0, 0);
        iVar.setTitle(charSequence);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, int i16, int i17) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(i16);
        iVar.setIcon(i17);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, Drawable drawable) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.setIcon(drawable);
        this.f134826a.add(iVar);
        return iVar;
    }

    @Override // android.view.ContextMenu
    public void clearHeader() {
    }

    @Override // android.view.Menu
    public void close() {
    }

    public MenuItem add(int i3, CharSequence charSequence, Drawable drawable, int i16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.setIcon(drawable);
        iVar.a(drawable, i16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, boolean z16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(charSequence2);
        iVar.setIcon(drawable);
        iVar.b(z16);
        this.f134826a.add(iVar);
        return iVar;
    }

    @Override // android.view.Menu
    public void removeGroup(int i3) {
    }

    @Override // android.view.ContextMenu
    public ContextMenu setHeaderView(View view) {
        return this;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z16) {
    }

    public MenuItem add(int i3, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, int i16, boolean z16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(charSequence2);
        iVar.a(drawable, i16);
        iVar.b(z16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, int i16, boolean z16, int i17) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(charSequence2);
        iVar.a(drawable, i16);
        iVar.b(z16);
        iVar.a(i17);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, boolean z16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.b(z16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, int i16, boolean z16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.setIcon(i16);
        iVar.b(z16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, CharSequence charSequence2, int i16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(charSequence2);
        iVar.setIcon(i16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, int i16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(i16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, int i16, boolean z16, boolean z17) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.d(z16);
        iVar.e(z17);
        iVar.setTitle(i16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, boolean z16, boolean z17) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.d(z16);
        iVar.e(z17);
        iVar.setTitle(charSequence);
        this.f134826a.add(iVar);
        return iVar;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i3, boolean z16) {
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i3, boolean z16) {
    }

    public MenuItem add(int i3, CharSequence charSequence, CharSequence charSequence2, boolean z16, boolean z17) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.d(z16);
        iVar.e(z17);
        iVar.setTitle(charSequence);
        iVar.a(charSequence2);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, int i16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.setIcon(i16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, boolean z16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.c(z16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, int i16, int i17) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(i16, i17);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, int i16, int i17, boolean z16, boolean z17) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(i16, i17);
        iVar.d(z16);
        iVar.e(z17);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, int i16, int i17, int i18) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.a(charSequence, i16);
        iVar.a(i17, i18);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, int i16, int i17, int i18, boolean z16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.a(charSequence, i16);
        iVar.a(i17, i18);
        iVar.b(z16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, CharSequence charSequence2, int i16, int i17) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(charSequence2);
        iVar.a(i16, i17);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, CharSequence charSequence2) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(charSequence2);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, int i16, int i17, CharSequence charSequence2, int i18) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(i16, i17);
        iVar.a(charSequence2);
        iVar.a(i18);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, int i16, CharSequence charSequence2, int i17) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.setIcon(i16);
        iVar.a(charSequence2);
        iVar.a(i17);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, int i16, int i17, boolean z16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(i16, i17);
        iVar.b(z16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, int i16, CharSequence charSequence, int i17, int i18, boolean z16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.setTitle(charSequence);
        iVar.a(i17, i18);
        iVar.b(z16);
        this.f134826a.add(i16, iVar);
        return iVar;
    }

    public MenuItem add(int i3, CharSequence charSequence, String str, boolean z16) {
        i iVar = new i(this.f134828c, i3, 0);
        iVar.b(charSequence);
        iVar.a(str);
        iVar.b(z16);
        this.f134826a.add(iVar);
        return iVar;
    }

    public MenuItem add(int i3, int i16, CharSequence charSequence) {
        i iVar = new i(this.f134828c, i3, 0);
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i16), 0, spannableString.length(), 0);
        iVar.setTitle(spannableString);
        this.f134826a.add(iVar);
        return iVar;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i3, boolean z16, boolean z17) {
    }

    public MenuItem add(MenuItem menuItem) {
        if (menuItem == null) {
            return null;
        }
        this.f134826a.add(menuItem);
        return null;
    }
}
