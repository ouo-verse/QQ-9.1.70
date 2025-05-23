package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;

/* compiled from: P */
/* loaded from: classes.dex */
public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    /* compiled from: P */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    private static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
            this.mActivityOptions = activityOptions;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            Rect launchBounds;
            if (Build.VERSION.SDK_INT >= 24) {
                launchBounds = this.mActivityOptions.getLaunchBounds();
                return launchBounds;
            }
            return null;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(@NonNull PendingIntent pendingIntent) {
            this.mActivityOptions.requestUsageTimeReport(pendingIntent);
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        @NonNull
        public ActivityOptionsCompat setLaunchBounds(@Nullable Rect rect) {
            ActivityOptions launchBounds;
            if (Build.VERSION.SDK_INT >= 24) {
                launchBounds = this.mActivityOptions.setLaunchBounds(rect);
                return new ActivityOptionsCompatImpl(launchBounds);
            }
            return this;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void update(@NonNull ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsCompatImpl) {
                this.mActivityOptions.update(((ActivityOptionsCompatImpl) activityOptionsCompat).mActivityOptions);
            }
        }
    }

    protected ActivityOptionsCompat() {
    }

    @NonNull
    public static ActivityOptionsCompat makeBasic() {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeBasic());
    }

    @NonNull
    public static ActivityOptionsCompat makeClipRevealAnimation(@NonNull View view, int i3, int i16, int i17, int i18) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeClipRevealAnimation(view, i3, i16, i17, i18));
    }

    @NonNull
    public static ActivityOptionsCompat makeCustomAnimation(@NonNull Context context, int i3, int i16) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(context, i3, i16));
    }

    @NonNull
    public static ActivityOptionsCompat makeScaleUpAnimation(@NonNull View view, int i3, int i16, int i17, int i18) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation(view, i3, i16, i17, i18));
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity activity, @NonNull View view, @NonNull String str) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
    }

    @NonNull
    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeTaskLaunchBehind());
    }

    @NonNull
    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(@NonNull View view, @NonNull Bitmap bitmap, int i3, int i16) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i3, i16));
    }

    @Nullable
    public Rect getLaunchBounds() {
        return null;
    }

    @Nullable
    public Bundle toBundle() {
        return null;
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity activity, Pair<View, String>... pairArr) {
        android.util.Pair[] pairArr2;
        if (pairArr != null) {
            pairArr2 = new android.util.Pair[pairArr.length];
            for (int i3 = 0; i3 < pairArr.length; i3++) {
                Pair<View, String> pair = pairArr[i3];
                pairArr2[i3] = android.util.Pair.create(pair.first, pair.second);
            }
        } else {
            pairArr2 = null;
        }
        return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr2));
    }

    public void requestUsageTimeReport(@NonNull PendingIntent pendingIntent) {
    }

    @NonNull
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect rect) {
        return this;
    }

    public void update(@NonNull ActivityOptionsCompat activityOptionsCompat) {
    }
}
