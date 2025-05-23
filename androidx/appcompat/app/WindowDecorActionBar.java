package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    private static final long FADE_IN_DURATION_MS = 200;
    private static final long FADE_OUT_DURATION_MS = 100;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator sHideInterpolator = new AccelerateInterpolator();
    private static final Interpolator sShowInterpolator = new DecelerateInterpolator();
    ActionModeImpl mActionMode;
    private Activity mActivity;
    ActionBarContainer mContainerView;
    View mContentView;
    Context mContext;
    ActionBarContextView mContextView;
    ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    DecorToolbar mDecorToolbar;
    ActionMode mDeferredDestroyActionMode;
    ActionMode.Callback mDeferredModeDestroyCallback;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    boolean mHiddenByApp;
    boolean mHiddenBySystem;
    boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    ActionBarOverlayLayout mOverlayLayout;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    private boolean mShowingForMode;
    ScrollingTabContainerView mTabScrollView;
    private Context mThemedContext;
    private ArrayList<TabImpl> mTabs = new ArrayList<>();
    private int mSavedTabPosition = -1;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
    private int mCurWindowVisibility = 0;
    boolean mContentAnimations = true;
    private boolean mNowShowing = true;
    final ViewPropertyAnimatorListener mHideListener = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.WindowDecorActionBar.1
        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mContentAnimations && (view2 = windowDecorActionBar.mContentView) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.mContainerView.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.mContainerView.setVisibility(8);
            WindowDecorActionBar.this.mContainerView.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.mCurrentShowAnim = null;
            windowDecorActionBar2.completeDeferredDestroyActionMode();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                ViewCompat.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    };
    final ViewPropertyAnimatorListener mShowListener = new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.WindowDecorActionBar.2
        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.mCurrentShowAnim = null;
            windowDecorActionBar.mContainerView.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener mUpdateListener = new ViewPropertyAnimatorUpdateListener() { // from class: androidx.appcompat.app.WindowDecorActionBar.3
        @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
        public void onAnimationUpdate(View view) {
            ((View) WindowDecorActionBar.this.mContainerView.getParent()).invalidate();
        }
    };

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private final Context mActionModeContext;
        private ActionMode.Callback mCallback;
        private WeakReference<View> mCustomView;
        private final MenuBuilder mMenu;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.mActionModeContext = context;
            this.mCallback = callback;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.mMenu = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                return this.mCallback.onCreateActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mActionMode != this) {
                return;
            }
            if (!WindowDecorActionBar.checkShowingFlags(windowDecorActionBar.mHiddenByApp, windowDecorActionBar.mHiddenBySystem, false)) {
                WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                windowDecorActionBar2.mDeferredDestroyActionMode = this;
                windowDecorActionBar2.mDeferredModeDestroyCallback = this.mCallback;
            } else {
                this.mCallback.onDestroyActionMode(this);
            }
            this.mCallback = null;
            WindowDecorActionBar.this.animateToMode(false);
            WindowDecorActionBar.this.mContextView.closeMode();
            WindowDecorActionBar.this.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
            WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
            windowDecorActionBar3.mOverlayLayout.setHideOnContentScrollEnabled(windowDecorActionBar3.mHideOnContentScroll);
            WindowDecorActionBar.this.mActionMode = null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public View getCustomView() {
            WeakReference<View> weakReference = this.mCustomView;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public Menu getMenu() {
            return this.mMenu;
        }

        @Override // androidx.appcompat.view.ActionMode
        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getSubtitle() {
            return WindowDecorActionBar.this.mContextView.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public CharSequence getTitle() {
            return WindowDecorActionBar.this.mContextView.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public void invalidate() {
            if (WindowDecorActionBar.this.mActionMode != this) {
                return;
            }
            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, this.mMenu);
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public boolean isTitleOptional() {
            return WindowDecorActionBar.this.mContextView.isTitleOptional();
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            ActionMode.Callback callback = this.mCallback;
            if (callback != null) {
                return callback.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
            if (this.mCallback == null) {
                return;
            }
            invalidate();
            WindowDecorActionBar.this.mContextView.showOverflowMenu();
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (this.mCallback == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.getThemedContext(), subMenuBuilder).show();
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setCustomView(View view) {
            WindowDecorActionBar.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitleOptionalHint(boolean z16) {
            super.setTitleOptionalHint(z16);
            WindowDecorActionBar.this.mContextView.setTitleOptional(z16);
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setSubtitle(int i3) {
            setSubtitle(WindowDecorActionBar.this.mContext.getResources().getString(i3));
        }

        @Override // androidx.appcompat.view.ActionMode
        public void setTitle(int i3) {
            setTitle(WindowDecorActionBar.this.mContext.getResources().getString(i3));
        }

        public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z16) {
        }
    }

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public class TabImpl extends ActionBar.Tab {
        private ActionBar.TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private Object mTag;
        private CharSequence mText;

        public TabImpl() {
        }

        public ActionBar.TabListener getCallback() {
            return this.mCallback;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public View getCustomView() {
            return this.mCustomView;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Drawable getIcon() {
            return this.mIcon;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public int getPosition() {
            return this.mPosition;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public Object getTag() {
            return this.mTag;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public CharSequence getText() {
            return this.mText;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public void select() {
            WindowDecorActionBar.this.selectTab(this);
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(int i3) {
            return setContentDescription(WindowDecorActionBar.this.mContext.getResources().getText(i3));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(View view) {
            this.mCustomView = view;
            int i3 = this.mPosition;
            if (i3 >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(i3);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(Drawable drawable) {
            this.mIcon = drawable;
            int i3 = this.mPosition;
            if (i3 >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(i3);
            }
            return this;
        }

        public void setPosition(int i3) {
            this.mPosition = i3;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTabListener(ActionBar.TabListener tabListener) {
            this.mCallback = tabListener;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setTag(Object obj) {
            this.mTag = obj;
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(CharSequence charSequence) {
            this.mText = charSequence;
            int i3 = this.mPosition;
            if (i3 >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(i3);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setContentDescription(CharSequence charSequence) {
            this.mContentDesc = charSequence;
            int i3 = this.mPosition;
            if (i3 >= 0) {
                WindowDecorActionBar.this.mTabScrollView.updateTab(i3);
            }
            return this;
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setCustomView(int i3) {
            return setCustomView(LayoutInflater.from(WindowDecorActionBar.this.getThemedContext()).inflate(i3, (ViewGroup) null));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setIcon(int i3) {
            return setIcon(AppCompatResources.getDrawable(WindowDecorActionBar.this.mContext, i3));
        }

        @Override // androidx.appcompat.app.ActionBar.Tab
        public ActionBar.Tab setText(int i3) {
            return setText(WindowDecorActionBar.this.mContext.getResources().getText(i3));
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z16) {
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (z16) {
            return;
        }
        this.mContentView = decorView.findViewById(R.id.content);
    }

    static boolean checkShowingFlags(boolean z16, boolean z17, boolean z18) {
        if (z18) {
            return true;
        }
        if (!z16 && !z17) {
            return true;
        }
        return false;
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab(null);
        }
        this.mTabs.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar.Tab tab, int i3) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.getCallback() != null) {
            tabImpl.setPosition(i3);
            this.mTabs.add(i3, tabImpl);
            int size = this.mTabs.size();
            while (true) {
                i3++;
                if (i3 < size) {
                    this.mTabs.get(i3).setPosition(i3);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
    }

    private void ensureTabsExist() {
        if (this.mTabScrollView != null) {
            return;
        }
        ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
        if (this.mHasEmbeddedTabs) {
            scrollingTabContainerView.setVisibility(0);
            this.mDecorToolbar.setEmbeddedTabView(scrollingTabContainerView);
        } else {
            if (getNavigationMode() == 2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
            this.mContainerView.setTabContainer(scrollingTabContainerView);
        }
        this.mTabScrollView = scrollingTabContainerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar getDecorToolbar(View view) {
        String str;
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Can't make a decor toolbar out of ");
        if (view != 0) {
            str = view.getClass().getSimpleName();
        } else {
            str = "null";
        }
        sb5.append(str);
        throw new IllegalStateException(sb5.toString());
    }

    private void hideForActionMode() {
        if (this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
    }

    private void init(View view) {
        boolean z16;
        boolean z17;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.tencent.mobileqq.R.id.ufe);
        this.mOverlayLayout = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.mDecorToolbar = getDecorToolbar(view.findViewById(com.tencent.mobileqq.R.id.f163913s91));
        this.mContextView = (ActionBarContextView) view.findViewById(com.tencent.mobileqq.R.id.s9a);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.tencent.mobileqq.R.id.f163915s93);
        this.mContainerView = actionBarContainer;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar != null && this.mContextView != null && actionBarContainer != null) {
            this.mContext = decorToolbar.getContext();
            if ((this.mDecorToolbar.getDisplayOptions() & 4) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.mDisplayHomeAsUpSet = true;
            }
            ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(this.mContext);
            if (!actionBarPolicy.enableHomeButtonByDefault() && !z16) {
                z17 = false;
            } else {
                z17 = true;
            }
            setHomeButtonEnabled(z17);
            setHasEmbeddedTabs(actionBarPolicy.hasEmbeddedTabs());
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, com.tencent.mobileqq.R.attr.f4195u, 0);
            if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
                setHideOnContentScrollEnabled(true);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
            if (dimensionPixelSize != 0) {
                setElevation(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
    }

    private void setHasEmbeddedTabs(boolean z16) {
        boolean z17;
        boolean z18;
        this.mHasEmbeddedTabs = z16;
        if (!z16) {
            this.mDecorToolbar.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        } else {
            this.mContainerView.setTabContainer(null);
            this.mDecorToolbar.setEmbeddedTabView(this.mTabScrollView);
        }
        boolean z19 = true;
        if (getNavigationMode() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            if (z17) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (!this.mHasEmbeddedTabs && z17) {
            z18 = true;
        } else {
            z18 = false;
        }
        decorToolbar.setCollapsible(z18);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
        if (this.mHasEmbeddedTabs || !z17) {
            z19 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z19);
    }

    private boolean shouldAnimateContextView() {
        return ViewCompat.isLaidOut(this.mContainerView);
    }

    private void showForActionMode() {
        if (!this.mShowingForMode) {
            this.mShowingForMode = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            updateVisibility(false);
        }
    }

    private void updateVisibility(boolean z16) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                doShow(z16);
                return;
            }
            return;
        }
        if (this.mNowShowing) {
            this.mNowShowing = false;
            doHide(z16);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(onMenuVisibilityListener);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void animateToMode(boolean z16) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z16) {
            showForActionMode();
        } else {
            hideForActionMode();
        }
        if (shouldAnimateContextView()) {
            if (z16) {
                viewPropertyAnimatorCompat2 = this.mDecorToolbar.setupAnimatorToVisibility(4, 100L);
                viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(0, FADE_IN_DURATION_MS);
            } else {
                viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(0, FADE_IN_DURATION_MS);
                viewPropertyAnimatorCompat2 = this.mContextView.setupAnimatorToVisibility(8, 100L);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompatSet.start();
            return;
        }
        if (z16) {
            this.mDecorToolbar.setVisibility(4);
            this.mContextView.setVisibility(0);
        } else {
            this.mDecorToolbar.setVisibility(0);
            this.mContextView.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar != null && decorToolbar.hasExpandedActionView()) {
            this.mDecorToolbar.collapseActionView();
            return true;
        }
        return false;
    }

    void completeDeferredDestroyActionMode() {
        ActionMode.Callback callback = this.mDeferredModeDestroyCallback;
        if (callback != null) {
            callback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void dispatchMenuVisibilityChanged(boolean z16) {
        if (z16 == this.mLastMenuVisibility) {
            return;
        }
        this.mLastMenuVisibility = z16;
        int size = this.mMenuVisibilityListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mMenuVisibilityListeners.get(i3).onMenuVisibilityChanged(z16);
        }
    }

    public void doHide(boolean z16) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        if (this.mCurWindowVisibility == 0 && (this.mShowHideAnimationEnabled || z16)) {
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTransitioning(true);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            float f16 = -this.mContainerView.getHeight();
            if (z16) {
                this.mContainerView.getLocationInWindow(new int[]{0, 0});
                f16 -= r5[1];
            }
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.mContainerView).translationY(f16);
            translationY.setUpdateListener(this.mUpdateListener);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.mContentAnimations && (view = this.mContentView) != null) {
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(view).translationY(f16));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(sHideInterpolator);
            viewPropertyAnimatorCompatSet2.setDuration(250L);
            viewPropertyAnimatorCompatSet2.setListener(this.mHideListener);
            this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
            return;
        }
        this.mHideListener.onAnimationEnd(null);
    }

    public void doShow(boolean z16) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
        this.mContainerView.setVisibility(0);
        if (this.mCurWindowVisibility == 0 && (this.mShowHideAnimationEnabled || z16)) {
            this.mContainerView.setTranslationY(0.0f);
            float f16 = -this.mContainerView.getHeight();
            if (z16) {
                this.mContainerView.getLocationInWindow(new int[]{0, 0});
                f16 -= r5[1];
            }
            this.mContainerView.setTranslationY(f16);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.mContainerView).translationY(0.0f);
            translationY.setUpdateListener(this.mUpdateListener);
            viewPropertyAnimatorCompatSet2.play(translationY);
            if (this.mContentAnimations && (view2 = this.mContentView) != null) {
                view2.setTranslationY(f16);
                viewPropertyAnimatorCompatSet2.play(ViewCompat.animate(this.mContentView).translationY(0.0f));
            }
            viewPropertyAnimatorCompatSet2.setInterpolator(sShowInterpolator);
            viewPropertyAnimatorCompatSet2.setDuration(250L);
            viewPropertyAnimatorCompatSet2.setListener(this.mShowListener);
            this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.start();
        } else {
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTranslationY(0.0f);
            if (this.mContentAnimations && (view = this.mContentView) != null) {
                view.setTranslationY(0.0f);
            }
            this.mShowListener.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void enableContentAnimations(boolean z16) {
        this.mContentAnimations = z16;
    }

    @Override // androidx.appcompat.app.ActionBar
    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    @Override // androidx.appcompat.app.ActionBar
    public float getElevation() {
        return ViewCompat.getElevation(this.mContainerView);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getHideOffset() {
        return this.mOverlayLayout.getActionBarHideOffset();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationItemCount() {
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode != 1) {
            if (navigationMode != 2) {
                return 0;
            }
            return this.mTabs.size();
        }
        return this.mDecorToolbar.getDropdownItemCount();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getNavigationMode() {
        return this.mDecorToolbar.getNavigationMode();
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getSelectedNavigationIndex() {
        TabImpl tabImpl;
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode != 1) {
            if (navigationMode != 2 || (tabImpl = this.mSelectedTab) == null) {
                return -1;
            }
            return tabImpl.getPosition();
        }
        return this.mDecorToolbar.getDropdownSelectedPosition();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab getTabAt(int i3) {
        return this.mTabs.get(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public int getTabCount() {
        return this.mTabs.size();
    }

    @Override // androidx.appcompat.app.ActionBar
    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(com.tencent.mobileqq.R.attr.f4245z, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, i3);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    @Override // androidx.appcompat.app.ActionBar
    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public boolean hasIcon() {
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        return this.mDecorToolbar.hasLogo();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void hide() {
        if (!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void hideForSystem() {
        if (!this.mHiddenBySystem) {
            this.mHiddenBySystem = true;
            updateVisibility(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isHideOnContentScrollEnabled() {
        return this.mOverlayLayout.isHideOnContentScrollEnabled();
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isShowing() {
        int height = getHeight();
        if (this.mNowShowing && (height == 0 || getHideOffset() < height)) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean isTitleTruncated() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar != null && decorToolbar.isTitleTruncated()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void onConfigurationChanged(Configuration configuration) {
        setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
            this.mCurrentShowAnim = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean onKeyShortcut(int i3, KeyEvent keyEvent) {
        Menu menu;
        int i16;
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl == null || (menu = actionModeImpl.getMenu()) == null) {
            return false;
        }
        if (keyEvent != null) {
            i16 = keyEvent.getDeviceId();
        } else {
            i16 = -1;
        }
        boolean z16 = true;
        if (KeyCharacterMap.load(i16).getKeyboardType() == 1) {
            z16 = false;
        }
        menu.setQwertyMode(z16);
        return menu.performShortcut(i3, keyEvent, 0);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onWindowVisibilityChanged(int i3) {
        this.mCurWindowVisibility = i3;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeAllTabs() {
        cleanupTabs();
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(onMenuVisibilityListener);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.getPosition());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void removeTabAt(int i3) {
        int i16;
        TabImpl tabImpl;
        if (this.mTabScrollView == null) {
            return;
        }
        TabImpl tabImpl2 = this.mSelectedTab;
        if (tabImpl2 != null) {
            i16 = tabImpl2.getPosition();
        } else {
            i16 = this.mSavedTabPosition;
        }
        this.mTabScrollView.removeTabAt(i3);
        TabImpl remove = this.mTabs.remove(i3);
        if (remove != null) {
            remove.setPosition(-1);
        }
        int size = this.mTabs.size();
        for (int i17 = i3; i17 < size; i17++) {
            this.mTabs.get(i17).setPosition(i17);
        }
        if (i16 == i3) {
            if (this.mTabs.isEmpty()) {
                tabImpl = null;
            } else {
                tabImpl = this.mTabs.get(Math.max(0, i3 - 1));
            }
            selectTab(tabImpl);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public boolean requestFocus() {
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup != null && !viewGroup.hasFocus()) {
            viewGroup.requestFocus();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void selectTab(ActionBar.Tab tab) {
        FragmentTransaction fragmentTransaction;
        int i3 = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i3 = tab.getPosition();
            }
            this.mSavedTabPosition = i3;
            return;
        }
        if ((this.mActivity instanceof FragmentActivity) && !this.mDecorToolbar.getViewGroup().isInEditMode()) {
            fragmentTransaction = ((FragmentActivity) this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        } else {
            fragmentTransaction = null;
        }
        TabImpl tabImpl = this.mSelectedTab;
        if (tabImpl == tab) {
            if (tabImpl != null) {
                tabImpl.getCallback().onTabReselected(this.mSelectedTab, fragmentTransaction);
                this.mTabScrollView.animateToTab(tab.getPosition());
            }
        } else {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (tab != null) {
                i3 = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i3);
            TabImpl tabImpl2 = this.mSelectedTab;
            if (tabImpl2 != null) {
                tabImpl2.getCallback().onTabUnselected(this.mSelectedTab, fragmentTransaction);
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.mSelectedTab = tabImpl3;
            if (tabImpl3 != null) {
                tabImpl3.getCallback().onTabSelected(this.mSelectedTab, fragmentTransaction);
            }
        }
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setPrimaryBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(int i3) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i3, this.mDecorToolbar.getViewGroup(), false));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDefaultDisplayHomeAsUpEnabled(boolean z16) {
        if (!this.mDisplayHomeAsUpSet) {
            setDisplayHomeAsUpEnabled(z16);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayHomeAsUpEnabled(boolean z16) {
        int i3;
        if (z16) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        setDisplayOptions(i3, 4);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i3) {
        if ((i3 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowCustomEnabled(boolean z16) {
        int i3;
        if (z16) {
            i3 = 16;
        } else {
            i3 = 0;
        }
        setDisplayOptions(i3, 16);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowHomeEnabled(boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        setDisplayOptions(i3, 2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayShowTitleEnabled(boolean z16) {
        int i3;
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        setDisplayOptions(i3, 8);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayUseLogoEnabled(boolean z16) {
        setDisplayOptions(z16 ? 1 : 0, 1);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setElevation(float f16) {
        ViewCompat.setElevation(this.mContainerView, f16);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOffset(int i3) {
        if (i3 != 0 && !this.mOverlayLayout.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
        }
        this.mOverlayLayout.setActionBarHideOffset(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHideOnContentScrollEnabled(boolean z16) {
        if (z16 && !this.mOverlayLayout.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.mHideOnContentScroll = z16;
        this.mOverlayLayout.setHideOnContentScrollEnabled(z16);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeButtonEnabled(boolean z16) {
        this.mDecorToolbar.setHomeButtonEnabled(z16);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(int i3) {
        this.mDecorToolbar.setIcon(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.mDecorToolbar.setDropdownParams(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(int i3) {
        this.mDecorToolbar.setLogo(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setNavigationMode(int i3) {
        boolean z16;
        ActionBarOverlayLayout actionBarOverlayLayout;
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode == 2) {
            this.mSavedTabPosition = getSelectedNavigationIndex();
            selectTab(null);
            this.mTabScrollView.setVisibility(8);
        }
        if (navigationMode != i3 && !this.mHasEmbeddedTabs && (actionBarOverlayLayout = this.mOverlayLayout) != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
        this.mDecorToolbar.setNavigationMode(i3);
        boolean z17 = false;
        if (i3 == 2) {
            ensureTabsExist();
            this.mTabScrollView.setVisibility(0);
            int i16 = this.mSavedTabPosition;
            if (i16 != -1) {
                setSelectedNavigationItem(i16);
                this.mSavedTabPosition = -1;
            }
        }
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (i3 == 2 && !this.mHasEmbeddedTabs) {
            z16 = true;
        } else {
            z16 = false;
        }
        decorToolbar.setCollapsible(z16);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
        if (i3 == 2 && !this.mHasEmbeddedTabs) {
            z17 = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z17);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSelectedNavigationItem(int i3) {
        int navigationMode = this.mDecorToolbar.getNavigationMode();
        if (navigationMode != 1) {
            if (navigationMode == 2) {
                selectTab(this.mTabs.get(i3));
                return;
            }
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
        this.mDecorToolbar.setDropdownSelectedPosition(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setShowHideAnimationEnabled(boolean z16) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mShowHideAnimationEnabled = z16;
        if (!z16 && (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setStackedBackground(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(int i3) {
        setSubtitle(this.mContext.getString(i3));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(int i3) {
        setTitle(this.mContext.getString(i3));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void show() {
        if (this.mHiddenByApp) {
            this.mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void showForSystem() {
        if (this.mHiddenBySystem) {
            this.mHiddenBySystem = false;
            updateVisibility(true);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.mContextView.getContext(), callback);
        if (actionModeImpl2.dispatchOnCreate()) {
            this.mActionMode = actionModeImpl2;
            actionModeImpl2.invalidate();
            this.mContextView.initForMode(actionModeImpl2);
            animateToMode(true);
            this.mContextView.sendAccessibilityEvent(32);
            return actionModeImpl2;
        }
        return null;
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i3) {
        addTab(tab, i3, this.mTabs.isEmpty());
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeActionContentDescription(int i3) {
        this.mDecorToolbar.setNavigationContentDescription(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setHomeAsUpIndicator(int i3) {
        this.mDecorToolbar.setNavigationIcon(i3);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setIcon(Drawable drawable) {
        this.mDecorToolbar.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setLogo(Drawable drawable) {
        this.mDecorToolbar.setLogo(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, boolean z16) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, z16);
        configureTab(tab, this.mTabs.size());
        if (z16) {
            selectTab(tab);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setDisplayOptions(int i3, int i16) {
        int displayOptions = this.mDecorToolbar.getDisplayOptions();
        if ((i16 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.setDisplayOptions((i3 & i16) | ((~i16) & displayOptions));
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view) {
        this.mDecorToolbar.setCustomView(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mDecorToolbar.setCustomView(view);
    }

    @Override // androidx.appcompat.app.ActionBar
    public void addTab(ActionBar.Tab tab, int i3, boolean z16) {
        ensureTabsExist();
        this.mTabScrollView.addTab(tab, i3, z16);
        configureTab(tab, i3);
        if (z16) {
            selectTab(tab);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        init(dialog.getWindow().getDecorView());
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public void onContentScrollStopped() {
    }

    @Override // androidx.appcompat.app.ActionBar
    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View view) {
        init(view);
    }
}
