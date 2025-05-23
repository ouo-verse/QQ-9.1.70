package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class i implements MenuPresenter {
    LayoutInflater C;

    @Nullable
    ColorStateList E;
    ColorStateList G;
    ColorStateList H;
    Drawable I;
    RippleDrawable J;
    int K;

    @Px
    int L;
    int M;
    int N;

    @Px
    int P;

    @Px
    int Q;

    @Px
    int R;

    @Px
    int S;
    boolean T;
    private int V;
    private int W;
    int X;

    /* renamed from: d, reason: collision with root package name */
    private NavigationMenuView f33854d;

    /* renamed from: e, reason: collision with root package name */
    LinearLayout f33855e;

    /* renamed from: f, reason: collision with root package name */
    private MenuPresenter.Callback f33856f;

    /* renamed from: h, reason: collision with root package name */
    MenuBuilder f33857h;

    /* renamed from: i, reason: collision with root package name */
    private int f33858i;

    /* renamed from: m, reason: collision with root package name */
    c f33859m;
    int D = 0;
    int F = 0;
    boolean U = true;
    private int Y = -1;
    final View.OnClickListener Z = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            boolean z16 = true;
            i.this.x(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            i iVar = i.this;
            boolean performItemAction = iVar.f33857h.performItemAction(itemData, iVar, 0);
            if (itemData != null && itemData.isCheckable() && performItemAction) {
                i.this.f33859m.q0(itemData);
            } else {
                z16 = false;
            }
            i.this.x(false);
            if (z16) {
                i.this.updateMenuView(false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends RecyclerView.Adapter<l> {
        private MenuItemImpl C;
        private boolean D;

        /* renamed from: m, reason: collision with root package name */
        private final ArrayList<e> f33861m = new ArrayList<>();

        c() {
            o0();
        }

        private void i0(int i3, int i16) {
            while (i3 < i16) {
                ((g) this.f33861m.get(i3)).f33865b = true;
                i3++;
            }
        }

        private void o0() {
            if (this.D) {
                return;
            }
            boolean z16 = true;
            this.D = true;
            this.f33861m.clear();
            this.f33861m.add(new d());
            int size = i.this.f33857h.getVisibleItems().size();
            int i3 = -1;
            int i16 = 0;
            boolean z17 = false;
            int i17 = 0;
            while (i16 < size) {
                MenuItemImpl menuItemImpl = i.this.f33857h.getVisibleItems().get(i16);
                if (menuItemImpl.isChecked()) {
                    q0(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i16 != 0) {
                            this.f33861m.add(new f(i.this.X, 0));
                        }
                        this.f33861m.add(new g(menuItemImpl));
                        int size2 = this.f33861m.size();
                        int size3 = subMenu.size();
                        int i18 = 0;
                        boolean z18 = false;
                        while (i18 < size3) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i18);
                            if (menuItemImpl2.isVisible()) {
                                if (!z18 && menuItemImpl2.getIcon() != null) {
                                    z18 = z16;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    q0(menuItemImpl);
                                }
                                this.f33861m.add(new g(menuItemImpl2));
                            }
                            i18++;
                            z16 = true;
                        }
                        if (z18) {
                            i0(size2, this.f33861m.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i3) {
                        i17 = this.f33861m.size();
                        if (menuItemImpl.getIcon() != null) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (i16 != 0) {
                            i17++;
                            ArrayList<e> arrayList = this.f33861m;
                            int i19 = i.this.X;
                            arrayList.add(new f(i19, i19));
                        }
                    } else if (!z17 && menuItemImpl.getIcon() != null) {
                        i0(i17, this.f33861m.size());
                        z17 = true;
                    }
                    g gVar = new g(menuItemImpl);
                    gVar.f33865b = z17;
                    this.f33861m.add(gVar);
                    i3 = groupId;
                }
                i16++;
                z16 = true;
            }
            this.D = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.f33861m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            e eVar = this.f33861m.get(i3);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                if (((g) eVar).a().hasSubMenu()) {
                    return 1;
                }
                return 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @NonNull
        public Bundle j0() {
            View view;
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.C;
            if (menuItemImpl != null) {
                bundle.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.f33861m.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = this.f33861m.get(i3);
                if (eVar instanceof g) {
                    MenuItemImpl a16 = ((g) eVar).a();
                    if (a16 != null) {
                        view = a16.getActionView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        view.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a16.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        int k0() {
            int i3;
            if (i.this.f33855e.getChildCount() == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            for (int i16 = 0; i16 < i.this.f33859m.getNUM_BACKGOURND_ICON(); i16++) {
                if (i.this.f33859m.getItemViewType(i16) == 0) {
                    i3++;
                }
            }
            return i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull l lVar, int i3) {
            Drawable drawable;
            int itemViewType = getItemViewType(i3);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType == 2) {
                        f fVar = (f) this.f33861m.get(i3);
                        lVar.itemView.setPadding(i.this.P, fVar.b(), i.this.Q, fVar.a());
                        return;
                    }
                    return;
                }
                TextView textView = (TextView) lVar.itemView;
                textView.setText(((g) this.f33861m.get(i3)).a().getTitle());
                int i16 = i.this.D;
                if (i16 != 0) {
                    TextViewCompat.setTextAppearance(textView, i16);
                }
                textView.setPadding(i.this.R, textView.getPaddingTop(), i.this.S, textView.getPaddingBottom());
                ColorStateList colorStateList = i.this.E;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                    return;
                }
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.f(i.this.H);
            int i17 = i.this.F;
            if (i17 != 0) {
                navigationMenuItemView.setTextAppearance(i17);
            }
            ColorStateList colorStateList2 = i.this.G;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable2 = i.this.I;
            if (drawable2 != null) {
                drawable = drawable2.getConstantState().newDrawable();
            } else {
                drawable = null;
            }
            ViewCompat.setBackground(navigationMenuItemView, drawable);
            RippleDrawable rippleDrawable = i.this.J;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) this.f33861m.get(i3);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.f33865b);
            i iVar = i.this;
            int i18 = iVar.K;
            int i19 = iVar.L;
            navigationMenuItemView.setPadding(i18, i19, i18, i19);
            navigationMenuItemView.setIconPadding(i.this.M);
            i iVar2 = i.this;
            if (iVar2.T) {
                navigationMenuItemView.setIconSize(iVar2.N);
            }
            navigationMenuItemView.setMaxLines(i.this.V);
            navigationMenuItemView.initialize(gVar.a(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public l onCreateViewHolder(ViewGroup viewGroup, int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return null;
                        }
                        return new b(i.this.f33855e);
                    }
                    return new j(i.this.C, viewGroup);
                }
                return new k(i.this.C, viewGroup);
            }
            i iVar = i.this;
            return new C0236i(iVar.C, viewGroup, iVar.Z);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof C0236i) {
                ((NavigationMenuItemView) lVar.itemView).d();
            }
        }

        public void p0(@NonNull Bundle bundle) {
            MenuItemImpl a16;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl a17;
            int i3 = bundle.getInt("android:menu:checked", 0);
            if (i3 != 0) {
                this.D = true;
                int size = this.f33861m.size();
                int i16 = 0;
                while (true) {
                    if (i16 >= size) {
                        break;
                    }
                    e eVar = this.f33861m.get(i16);
                    if ((eVar instanceof g) && (a17 = ((g) eVar).a()) != null && a17.getItemId() == i3) {
                        q0(a17);
                        break;
                    }
                    i16++;
                }
                this.D = false;
                o0();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f33861m.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    e eVar2 = this.f33861m.get(i17);
                    if ((eVar2 instanceof g) && (a16 = ((g) eVar2).a()) != null && (actionView = a16.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a16.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void q0(@NonNull MenuItemImpl menuItemImpl) {
            if (this.C != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.C;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.C = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        public void r0(boolean z16) {
            this.D = z16;
        }

        public void s0() {
            o0();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d implements e {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class f implements e {

        /* renamed from: a, reason: collision with root package name */
        private final int f33862a;

        /* renamed from: b, reason: collision with root package name */
        private final int f33863b;

        public f(int i3, int i16) {
            this.f33862a = i3;
            this.f33863b = i16;
        }

        public int a() {
            return this.f33863b;
        }

        public int b() {
            return this.f33862a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class g implements e {

        /* renamed from: a, reason: collision with root package name */
        private final MenuItemImpl f33864a;

        /* renamed from: b, reason: collision with root package name */
        boolean f33865b;

        g(MenuItemImpl menuItemImpl) {
            this.f33864a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.f33864a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class h extends RecyclerViewAccessibilityDelegate {
        h(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i.this.f33859m.k0(), 0, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.google.android.material.internal.i$i, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0236i extends l {
        public C0236i(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.e5p, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class j extends l {
        public j(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.e5r, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class k extends l {
        public k(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.e5s, viewGroup, false));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    private void y() {
        int i3;
        if (this.f33855e.getChildCount() == 0 && this.U) {
            i3 = this.W;
        } else {
            i3 = 0;
        }
        NavigationMenuView navigationMenuView = this.f33854d;
        navigationMenuView.setPadding(0, i3, 0, navigationMenuView.getPaddingBottom());
    }

    public void b(@NonNull View view) {
        this.f33855e.addView(view);
        NavigationMenuView navigationMenuView = this.f33854d;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void c(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.W != systemWindowInsetTop) {
            this.W = systemWindowInsetTop;
            y();
        }
        NavigationMenuView navigationMenuView = this.f33854d;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.f33855e, windowInsetsCompat);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public View d(@LayoutRes int i3) {
        View inflate = this.C.inflate(i3, (ViewGroup) this.f33855e, false);
        b(inflate);
        return inflate;
    }

    public void e(boolean z16) {
        if (this.U != z16) {
            this.U = z16;
            y();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void f(@NonNull MenuItemImpl menuItemImpl) {
        this.f33859m.q0(menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public void g(@Px int i3) {
        this.Q = i3;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f33858i;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f33854d == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.C.inflate(R.layout.e5t, viewGroup, false);
            this.f33854d = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.f33854d));
            if (this.f33859m == null) {
                this.f33859m = new c();
            }
            int i3 = this.Y;
            if (i3 != -1) {
                this.f33854d.setOverScrollMode(i3);
            }
            this.f33855e = (LinearLayout) this.C.inflate(R.layout.e5q, (ViewGroup) this.f33854d, false);
            this.f33854d.setAdapter(this.f33859m);
        }
        return this.f33854d;
    }

    public void h(@Px int i3) {
        this.P = i3;
        updateMenuView(false);
    }

    public void i(int i3) {
        this.f33858i = i3;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.C = LayoutInflater.from(context);
        this.f33857h = menuBuilder;
        this.X = context.getResources().getDimensionPixelOffset(R.dimen.c8y);
    }

    public void j(@Nullable Drawable drawable) {
        this.I = drawable;
        updateMenuView(false);
    }

    public void k(@Nullable RippleDrawable rippleDrawable) {
        this.J = rippleDrawable;
        updateMenuView(false);
    }

    public void l(int i3) {
        this.K = i3;
        updateMenuView(false);
    }

    public void m(int i3) {
        this.M = i3;
        updateMenuView(false);
    }

    public void n(@Dimension int i3) {
        if (this.N != i3) {
            this.N = i3;
            this.T = true;
            updateMenuView(false);
        }
    }

    public void o(@Nullable ColorStateList colorStateList) {
        this.H = colorStateList;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z16) {
        MenuPresenter.Callback callback = this.f33856f;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z16);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(ListMenuPresenter.VIEWS_TAG);
            if (sparseParcelableArray != null) {
                this.f33854d.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f33859m.p0(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f33855e.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.f33854d != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f33854d.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray(ListMenuPresenter.VIEWS_TAG, sparseArray);
        }
        c cVar = this.f33859m;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.j0());
        }
        if (this.f33855e != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.f33855e.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void p(int i3) {
        this.V = i3;
        updateMenuView(false);
    }

    public void q(@StyleRes int i3) {
        this.F = i3;
        updateMenuView(false);
    }

    public void r(@Nullable ColorStateList colorStateList) {
        this.G = colorStateList;
        updateMenuView(false);
    }

    public void s(@Px int i3) {
        this.L = i3;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.f33856f = callback;
    }

    public void t(int i3) {
        this.Y = i3;
        NavigationMenuView navigationMenuView = this.f33854d;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i3);
        }
    }

    public void u(@Nullable ColorStateList colorStateList) {
        this.E = colorStateList;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z16) {
        c cVar = this.f33859m;
        if (cVar != null) {
            cVar.s0();
        }
    }

    public void v(@Px int i3) {
        this.R = i3;
        updateMenuView(false);
    }

    public void w(@StyleRes int i3) {
        this.D = i3;
        updateMenuView(false);
    }

    public void x(boolean z16) {
        c cVar = this.f33859m;
        if (cVar != null) {
            cVar.r0(z16);
        }
    }
}
