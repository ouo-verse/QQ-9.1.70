package com.tencent.luggage.wxa.mo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i implements MenuItem {

    /* renamed from: a, reason: collision with root package name */
    public boolean f134829a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f134830b;

    /* renamed from: d, reason: collision with root package name */
    public int f134832d;

    /* renamed from: e, reason: collision with root package name */
    public int f134833e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f134834f;

    /* renamed from: g, reason: collision with root package name */
    public int f134835g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f134836h;

    /* renamed from: i, reason: collision with root package name */
    public TextUtils.TruncateAt f134837i;

    /* renamed from: k, reason: collision with root package name */
    public int f134839k;

    /* renamed from: m, reason: collision with root package name */
    public int f134841m;

    /* renamed from: n, reason: collision with root package name */
    public int f134842n;

    /* renamed from: o, reason: collision with root package name */
    public int f134843o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f134844p;

    /* renamed from: r, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f134846r;

    /* renamed from: s, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f134847s;

    /* renamed from: t, reason: collision with root package name */
    public String f134848t;

    /* renamed from: u, reason: collision with root package name */
    public Intent f134849u;

    /* renamed from: v, reason: collision with root package name */
    public Context f134850v;

    /* renamed from: c, reason: collision with root package name */
    public boolean f134831c = false;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f134838j = null;

    /* renamed from: l, reason: collision with root package name */
    public boolean f134840l = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f134845q = true;

    /* renamed from: w, reason: collision with root package name */
    public boolean f134851w = false;

    /* renamed from: x, reason: collision with root package name */
    public Boolean f134852x = Boolean.FALSE;

    /* renamed from: y, reason: collision with root package name */
    public n f134853y = null;

    public i(Context context, int i3, int i16) {
        this.f134850v = context;
        this.f134832d = i3;
        this.f134833e = i16;
        this.f134843o = context.getResources().getColor(R.color.ar9);
    }

    public void a(boolean z16) {
        this.f134851w = z16;
    }

    public MenuItem b(int i3, int i16) {
        this.f134841m = i3;
        this.f134835g = i16;
        return this;
    }

    public MenuItem c(boolean z16) {
        this.f134831c = z16;
        return this;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    public MenuItem d(boolean z16) {
        this.f134829a = z16;
        return this;
    }

    public MenuItem e(boolean z16) {
        this.f134830b = z16;
        return this;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    public CharSequence f() {
        return this.f134836h;
    }

    public v g() {
        return null;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return (char) 0;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f134833e;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Context context;
        Drawable drawable = this.f134844p;
        if (drawable == null) {
            if (this.f134842n != 0 && (context = this.f134850v) != null) {
                return context.getResources().getDrawable(this.f134842n);
            }
            return null;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f134849u;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f134832d;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f134846r;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return (char) 0;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        Context context;
        CharSequence charSequence = this.f134834f;
        if (charSequence == null) {
            int i3 = this.f134841m;
            if (i3 != 0 && (context = this.f134850v) != null) {
                return context.getString(i3);
            }
            return null;
        }
        return charSequence;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return null;
    }

    public w h() {
        return null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    public boolean i() {
        return this.f134831c;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return true;
    }

    public boolean j() {
        return this.f134829a;
    }

    public boolean k() {
        return this.f134830b;
    }

    public int l() {
        return this.f134835g;
    }

    public TextUtils.TruncateAt m() {
        return this.f134837i;
    }

    public String n() {
        return this.f134848t;
    }

    public boolean o() {
        return this.f134852x.booleanValue();
    }

    public boolean p() {
        return this.f134851w;
    }

    public boolean q() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f134847s;
        if (onMenuItemClickListener != null) {
            return onMenuItemClickListener.onMenuItemClick(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i3) {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f134844p = drawable;
        n nVar = this.f134853y;
        if (nVar != null) {
            nVar.onIconSet(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f134849u = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f134847s = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i3) {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f134834f = charSequence;
        return this;
    }

    public void a(n nVar) {
        this.f134853y = nVar;
    }

    public boolean c() {
        return this.f134840l;
    }

    public int d() {
        return this.f134843o;
    }

    public boolean e() {
        return this.f134845q;
    }

    public MenuItem f(boolean z16) {
        this.f134852x = Boolean.valueOf(z16);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        this.f134841m = i3;
        return this;
    }

    public MenuItem a(CharSequence charSequence, int i3) {
        this.f134834f = charSequence;
        this.f134835g = i3;
        return this;
    }

    public int b() {
        return this.f134839k;
    }

    public MenuItem b(boolean z16) {
        this.f134840l = z16;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.f134842n = i3;
        n nVar = this.f134853y;
        if (nVar != null) {
            nVar.onIconSet(this);
        }
        return this;
    }

    public void a(TextUtils.TruncateAt truncateAt) {
        this.f134837i = truncateAt;
    }

    public MenuItem b(CharSequence charSequence) {
        this.f134836h = charSequence;
        return this;
    }

    public MenuItem a(CharSequence charSequence) {
        this.f134838j = charSequence;
        return this;
    }

    public CharSequence a() {
        return this.f134838j;
    }

    public MenuItem a(int i3) {
        this.f134839k = i3;
        return this;
    }

    public MenuItem a(Drawable drawable, int i3) {
        this.f134844p = drawable;
        this.f134843o = i3;
        n nVar = this.f134853y;
        if (nVar != null) {
            nVar.onIconSet(this);
        }
        return this;
    }

    public MenuItem a(int i3, int i16) {
        this.f134842n = i3;
        this.f134843o = i16;
        n nVar = this.f134853y;
        if (nVar != null) {
            nVar.onIconSet(this);
        }
        return this;
    }

    public MenuItem a(String str) {
        this.f134848t = str;
        return this;
    }

    public void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f134846r = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c16) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z16) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z16) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z16) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c16) {
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i3) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z16) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c16, char c17) {
        return this;
    }
}
