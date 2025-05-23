package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.c;
import com.google.android.material.internal.ParcelableSparseArray;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class NavigationBarPresenter implements MenuPresenter {

    /* renamed from: d, reason: collision with root package name */
    private MenuBuilder f33913d;

    /* renamed from: e, reason: collision with root package name */
    private NavigationBarMenuView f33914e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33915f = false;

    /* renamed from: h, reason: collision with root package name */
    private int f33916h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        int f33917d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        ParcelableSparseArray f33918e;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i3) {
            parcel.writeInt(this.f33917d);
            parcel.writeParcelable(this.f33918e, 0);
        }

        SavedState(@NonNull Parcel parcel) {
            this.f33917d = parcel.readInt();
            this.f33918e = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public void a(int i3) {
        this.f33916h = i3;
    }

    public void b(@NonNull NavigationBarMenuView navigationBarMenuView) {
        this.f33914e = navigationBarMenuView;
    }

    public void c(boolean z16) {
        this.f33915f = z16;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(@Nullable MenuBuilder menuBuilder, @Nullable MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(@Nullable MenuBuilder menuBuilder, @Nullable MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f33916h;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @Nullable
    public MenuView getMenuView(@Nullable ViewGroup viewGroup) {
        return this.f33914e;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.f33913d = menuBuilder;
        this.f33914e.initialize(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(@NonNull Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f33914e.t(savedState.f33917d);
            this.f33914e.q(c.d(this.f33914e.getContext(), savedState.f33918e));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f33917d = this.f33914e.l();
        savedState.f33918e = c.e(this.f33914e.g());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(@Nullable SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z16) {
        if (this.f33915f) {
            return;
        }
        if (z16) {
            this.f33914e.c();
        } else {
            this.f33914e.u();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(@Nullable MenuPresenter.Callback callback) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(@Nullable MenuBuilder menuBuilder, boolean z16) {
    }
}
