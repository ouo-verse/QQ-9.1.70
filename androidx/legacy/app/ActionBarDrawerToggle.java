package androidx.legacy.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Method;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = {R.attr.homeAsUpIndicator};
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private SetIndicatorInfo mSetIndicatorInfo;
    private SlideDrawable mSlider;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes.dex */
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int i3);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i3);
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes.dex */
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class SetIndicatorInfo {
        Method mSetHomeActionContentDescription;
        Method mSetHomeAsUpIndicator;
        ImageView mUpIndicatorView;

        SetIndicatorInfo(Activity activity) {
            try {
                this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
                this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById == null) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                if (viewGroup.getChildCount() != 2) {
                    return;
                }
                View childAt = viewGroup.getChildAt(0);
                childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                if (childAt instanceof ImageView) {
                    this.mUpIndicatorView = (ImageView) childAt;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;

        SlideDrawable(Drawable drawable) {
            super(drawable, 0);
            this.mHasMirroring = true;
            this.mTmpRect = new Rect();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            boolean z16;
            copyBounds(this.mTmpRect);
            canvas.save();
            int i3 = 1;
            if (ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = -1;
            }
            float width = this.mTmpRect.width();
            canvas.translate((-this.mOffset) * width * this.mPosition * i3, 0.0f);
            if (z16 && !this.mHasMirroring) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float f16) {
            this.mOffset = f16;
            invalidateSelf();
        }

        public void setPosition(float f16) {
            this.mPosition = f16;
            invalidateSelf();
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @DrawableRes int i3, @StringRes int i16, @StringRes int i17) {
        this(activity, drawerLayout, !assumeMaterial(activity), i3, i16, i17);
    }

    private static boolean assumeMaterial(Context context) {
        if (context.getApplicationInfo().targetSdkVersion >= 21) {
            return true;
        }
        return false;
    }

    private Drawable getThemeUpIndicator() {
        Context context;
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            return delegate.getThemeUpIndicator();
        }
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            context = actionBar.getThemedContext();
        } else {
            context = this.mActivity;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, THEME_ATTRS, R.attr.actionBarStyle, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    private void setActionBarDescription(int i3) {
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarDescription(i3);
            return;
        }
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i3);
        }
    }

    private void setActionBarUpIndicator(Drawable drawable, int i3) {
        Delegate delegate = this.mActivityImpl;
        if (delegate != null) {
            delegate.setActionBarUpIndicator(drawable, i3);
            return;
        }
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i3);
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mHasCustomUpIndicator) {
            this.mHomeAsUpIndicator = getThemeUpIndicator();
        }
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled) {
            setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f16) {
        float min;
        float position = this.mSlider.getPosition();
        if (f16 > 0.5f) {
            min = Math.max(position, Math.max(0.0f, f16 - 0.5f) * 2.0f);
        } else {
            min = Math.min(position, f16 * 2.0f);
        }
        this.mSlider.setPosition(min);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
            if (this.mDrawerLayout.isDrawerVisible(8388611)) {
                this.mDrawerLayout.closeDrawer(8388611);
                return true;
            }
            this.mDrawerLayout.openDrawer(8388611);
            return true;
        }
        return false;
    }

    public void setDrawerIndicatorEnabled(boolean z16) {
        int i3;
        if (z16 != this.mDrawerIndicatorEnabled) {
            if (z16) {
                SlideDrawable slideDrawable = this.mSlider;
                if (this.mDrawerLayout.isDrawerOpen(8388611)) {
                    i3 = this.mCloseDrawerContentDescRes;
                } else {
                    i3 = this.mOpenDrawerContentDescRes;
                }
                setActionBarUpIndicator(slideDrawable, i3);
            } else {
                setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
            }
            this.mDrawerIndicatorEnabled = z16;
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

    public void syncState() {
        int i3;
        if (this.mDrawerLayout.isDrawerOpen(8388611)) {
            this.mSlider.setPosition(1.0f);
        } else {
            this.mSlider.setPosition(0.0f);
        }
        if (this.mDrawerIndicatorEnabled) {
            SlideDrawable slideDrawable = this.mSlider;
            if (this.mDrawerLayout.isDrawerOpen(8388611)) {
                i3 = this.mCloseDrawerContentDescRes;
            } else {
                i3 = this.mOpenDrawerContentDescRes;
            }
            setActionBarUpIndicator(slideDrawable, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z16, @DrawableRes int i3, @StringRes int i16, @StringRes int i17) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = activity;
        if (activity instanceof DelegateProvider) {
            this.mActivityImpl = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = drawerLayout;
        this.mDrawerImageResource = i3;
        this.mOpenDrawerContentDescRes = i16;
        this.mCloseDrawerContentDescRes = i17;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(activity, i3);
        SlideDrawable slideDrawable = new SlideDrawable(this.mDrawerImage);
        this.mSlider = slideDrawable;
        slideDrawable.setOffset(z16 ? TOGGLE_DRAWABLE_OFFSET : 0.0f);
    }

    public void setHomeAsUpIndicator(int i3) {
        setHomeAsUpIndicator(i3 != 0 ? ContextCompat.getDrawable(this.mActivity, i3) : null);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i3) {
    }
}
