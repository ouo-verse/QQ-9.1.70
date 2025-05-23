package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerArrowDrawable mSlider;
    View.OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int i3);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i3);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class FrameworkActionBarDelegate implements Delegate {
        private final Activity mActivity;
        private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        FrameworkActionBarDelegate(Activity activity) {
            this.mActivity = activity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                return actionBar.getThemedContext();
            }
            return this.mActivity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null && (actionBar.getDisplayOptions() & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i3) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i3);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, int i3) {
            android.app.ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class ToolbarCompatDelegate implements Delegate {
        final CharSequence mDefaultContentDescription;
        final Drawable mDefaultUpIndicator;
        final Toolbar mToolbar;

        ToolbarCompatDelegate(Toolbar toolbar) {
            this.mToolbar = toolbar;
            this.mDefaultUpIndicator = toolbar.getNavigationIcon();
            this.mDefaultContentDescription = toolbar.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.mToolbar.getContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return this.mDefaultUpIndicator;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(@StringRes int i3) {
            if (i3 == 0) {
                this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
            } else {
                this.mToolbar.setNavigationContentDescription(i3);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable drawable, @StringRes int i3) {
            this.mToolbar.setNavigationIcon(drawable);
            setActionBarDescription(i3);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @StringRes int i3, @StringRes int i16) {
        this(activity, null, drawerLayout, null, i3, i16);
    }

    private void setPosition(float f16) {
        if (f16 == 1.0f) {
            this.mSlider.setVerticalMirror(true);
        } else if (f16 == 0.0f) {
            this.mSlider.setVerticalMirror(false);
        }
        this.mSlider.setProgress(f16);
    }

    @NonNull
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f16) {
        if (this.mDrawerSlideAnimationEnabled) {
            setPosition(Math.min(1.0f, Math.max(0.0f, f16)));
        } else {
            setPosition(0.0f);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
            toggle();
            return true;
        }
        return false;
    }

    void setActionBarDescription(int i3) {
        this.mActivityImpl.setActionBarDescription(i3);
    }

    void setActionBarUpIndicator(Drawable drawable, int i3) {
        if (!this.mWarnedForDisplayHomeAsUp && !this.mActivityImpl.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.mWarnedForDisplayHomeAsUp = true;
        }
        this.mActivityImpl.setActionBarUpIndicator(drawable, i3);
    }

    public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable drawerArrowDrawable) {
        this.mSlider = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z16) {
        int i3;
        if (z16 != this.mDrawerIndicatorEnabled) {
            if (z16) {
                DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
                if (this.mDrawerLayout.isDrawerOpen(8388611)) {
                    i3 = this.mCloseDrawerContentDescRes;
                } else {
                    i3 = this.mOpenDrawerContentDescRes;
                }
                setActionBarUpIndicator(drawerArrowDrawable, i3);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z16;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z16) {
        this.mDrawerSlideAnimationEnabled = z16;
        if (!z16) {
            setPosition(0.0f);
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable;
            this.mHasCustomUpIndicator = true;
        }
        if (this.mDrawerIndicatorEnabled) {
            return;
        }
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.mToolbarNavigationClickListener = onClickListener;
    }

    public void syncState() {
        int i3;
        if (this.mDrawerLayout.isDrawerOpen(8388611)) {
            setPosition(1.0f);
        } else {
            setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
            if (this.mDrawerLayout.isDrawerOpen(8388611)) {
                i3 = this.mCloseDrawerContentDescRes;
            } else {
                i3 = this.mOpenDrawerContentDescRes;
            }
            setActionBarUpIndicator(drawerArrowDrawable, i3);
        }
    }

    void toggle() {
        int drawerLockMode = this.mDrawerLayout.getDrawerLockMode(8388611);
        if (this.mDrawerLayout.isDrawerVisible(8388611) && drawerLockMode != 2) {
            this.mDrawerLayout.closeDrawer(8388611);
        } else if (drawerLockMode != 1) {
            this.mDrawerLayout.openDrawer(8388611);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i3, @StringRes int i16) {
        this(activity, toolbar, drawerLayout, null, i3, i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, @StringRes int i3, @StringRes int i16) {
        this.mDrawerSlideAnimationEnabled = true;
        this.mDrawerIndicatorEnabled = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (toolbar != null) {
            this.mActivityImpl = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.app.ActionBarDrawerToggle.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    ActionBarDrawerToggle actionBarDrawerToggle = ActionBarDrawerToggle.this;
                    if (actionBarDrawerToggle.mDrawerIndicatorEnabled) {
                        actionBarDrawerToggle.toggle();
                    } else {
                        View.OnClickListener onClickListener = actionBarDrawerToggle.mToolbarNavigationClickListener;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = new FrameworkActionBarDelegate(activity);
        }
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = i3;
        this.mCloseDrawerContentDescRes = i16;
        if (drawerArrowDrawable == null) {
            this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
        } else {
            this.mSlider = drawerArrowDrawable;
        }
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    }

    public void setHomeAsUpIndicator(int i3) {
        setHomeAsUpIndicator(i3 != 0 ? this.mDrawerLayout.getResources().getDrawable(i3) : null);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i3) {
    }
}
