package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {
    private ValueAnimator mAnimator;
    private DrawerArrowDrawable mArrowDrawable;
    private final Context mContext;

    @Nullable
    private final WeakReference<Openable> mOpenableLayoutWeakReference;
    private final Set<Integer> mTopLevelDestinations;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractAppBarOnDestinationChangedListener(@NonNull Context context, @NonNull AppBarConfiguration appBarConfiguration) {
        this.mContext = context;
        this.mTopLevelDestinations = appBarConfiguration.getTopLevelDestinations();
        Openable openableLayout = appBarConfiguration.getOpenableLayout();
        if (openableLayout != null) {
            this.mOpenableLayoutWeakReference = new WeakReference<>(openableLayout);
        } else {
            this.mOpenableLayoutWeakReference = null;
        }
    }

    private void setActionBarUpIndicator(boolean z16) {
        boolean z17;
        int i3;
        float f16;
        if (this.mArrowDrawable == null) {
            this.mArrowDrawable = new DrawerArrowDrawable(this.mContext);
            z17 = false;
        } else {
            z17 = true;
        }
        DrawerArrowDrawable drawerArrowDrawable = this.mArrowDrawable;
        if (z16) {
            i3 = com.tencent.mobileqq.R.string.f169772j9;
        } else {
            i3 = com.tencent.mobileqq.R.string.f169762j8;
        }
        setNavigationIcon(drawerArrowDrawable, i3);
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        if (z17) {
            float progress = this.mArrowDrawable.getProgress();
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mArrowDrawable, "progress", progress, f16);
            this.mAnimator = ofFloat;
            ofFloat.start();
            return;
        }
        this.mArrowDrawable.setProgress(f16);
    }

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
        Openable openable;
        if (navDestination instanceof FloatingWindow) {
            return;
        }
        WeakReference<Openable> weakReference = this.mOpenableLayoutWeakReference;
        if (weakReference != null) {
            openable = weakReference.get();
        } else {
            openable = null;
        }
        if (this.mOpenableLayoutWeakReference != null && openable == null) {
            navController.removeOnDestinationChangedListener(this);
            return;
        }
        CharSequence label = navDestination.getLabel();
        boolean z16 = true;
        if (label != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(label);
            while (matcher.find()) {
                String group = matcher.group(1);
                if (bundle != null && bundle.containsKey(group)) {
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(bundle.get(group).toString());
                } else {
                    throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill label " + ((Object) label));
                }
            }
            matcher.appendTail(stringBuffer);
            setTitle(stringBuffer);
        }
        boolean matchDestinations = NavigationUI.matchDestinations(navDestination, this.mTopLevelDestinations);
        if (openable == null && matchDestinations) {
            setNavigationIcon(null, 0);
            return;
        }
        if (openable == null || !matchDestinations) {
            z16 = false;
        }
        setActionBarUpIndicator(z16);
    }

    protected abstract void setNavigationIcon(Drawable drawable, @StringRes int i3);

    protected abstract void setTitle(CharSequence charSequence);
}
