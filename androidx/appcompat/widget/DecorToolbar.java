package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface DecorToolbar {
    void animateToVisibility(int i3);

    boolean canShowOverflowMenu();

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getDropdownItemCount();

    int getDropdownSelectedPosition();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getSubtitle();

    CharSequence getTitle();

    ViewGroup getViewGroup();

    int getVisibility();

    boolean hasEmbeddedTabs();

    boolean hasExpandedActionView();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    boolean isTitleTruncated();

    void restoreHierarchyState(SparseArray<Parcelable> sparseArray);

    void saveHierarchyState(SparseArray<Parcelable> sparseArray);

    void setBackgroundDrawable(Drawable drawable);

    void setCollapsible(boolean z16);

    void setCustomView(View view);

    void setDefaultNavigationContentDescription(int i3);

    void setDefaultNavigationIcon(Drawable drawable);

    void setDisplayOptions(int i3);

    void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener);

    void setDropdownSelectedPosition(int i3);

    void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView);

    void setHomeButtonEnabled(boolean z16);

    void setIcon(int i3);

    void setIcon(Drawable drawable);

    void setLogo(int i3);

    void setLogo(Drawable drawable);

    void setMenu(Menu menu, MenuPresenter.Callback callback);

    void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2);

    void setMenuPrepared();

    void setNavigationContentDescription(int i3);

    void setNavigationContentDescription(CharSequence charSequence);

    void setNavigationIcon(int i3);

    void setNavigationIcon(Drawable drawable);

    void setNavigationMode(int i3);

    void setSubtitle(CharSequence charSequence);

    void setTitle(CharSequence charSequence);

    void setVisibility(int i3);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i3, long j3);

    boolean showOverflowMenu();
}
