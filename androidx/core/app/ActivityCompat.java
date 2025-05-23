package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import com.tencent.qmethod.pandoraex.monitor.PermissionMonitor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    /* compiled from: P */
    /* renamed from: androidx.core.app.ActivityCompat$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ String[] val$permissions;
        final /* synthetic */ int val$requestCode;

        AnonymousClass1(String[] strArr, Activity activity, int i3) {
            this.val$permissions = strArr;
            this.val$activity = activity;
            this.val$requestCode = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.val$permissions.length];
            PackageManager packageManager = this.val$activity.getPackageManager();
            String packageName = this.val$activity.getPackageName();
            int length = this.val$permissions.length;
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = packageManager.checkPermission(this.val$permissions[i3], packageName);
            }
            ((OnRequestPermissionsResultCallback) this.val$activity).onRequestPermissionsResult(this.val$requestCode, this.val$permissions, iArr);
        }
    }

    /* compiled from: P */
    @RequiresApi(30)
    /* loaded from: classes.dex */
    static class Api30Impl {
        Api30Impl() {
        }

        static void setLocusContext(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
            LocusId locusId;
            if (locusIdCompat == null) {
                locusId = null;
            } else {
                locusId = locusIdCompat.toLocusId();
            }
            activity.setLocusContext(locusId, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface PermissionCompatDelegate {
        boolean onActivityResult(@NonNull Activity activity, @IntRange(from = 0) int i3, int i16, @Nullable Intent intent);

        boolean requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i3);
    }

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class SharedElementCallback21Impl extends android.app.SharedElementCallback {
        private final SharedElementCallback mCallback;

        SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.mCallback = sharedElementCallback;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.mCallback.onCreateSnapshotView(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.mCallback.onMapSharedElements(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.mCallback.onRejectSharedElements(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.mCallback.onSharedElementEnd(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.mCallback.onSharedElementStart(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        @RequiresApi(23)
        public void onSharedElementsArrived(List<String> list, List<View> list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.mCallback.onSharedElementsArrived(list, list2, new SharedElementCallback.OnSharedElementsReadyListener() { // from class: androidx.core.app.ActivityCompat.SharedElementCallback21Impl.1
                @Override // androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener
                public void onSharedElementsReady() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    protected ActivityCompat() {
    }

    public static void finishAffinity(@NonNull Activity activity) {
        activity.finishAffinity();
    }

    public static void finishAfterTransition(@NonNull Activity activity) {
        activity.finishAfterTransition();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    @Nullable
    public static Uri getReferrer(@NonNull Activity activity) {
        return activity.getReferrer();
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static void postponeEnterTransition(@NonNull Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void recreate(@NonNull final Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            activity.recreate();
        } else if (i3 <= 23) {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: androidx.core.app.ActivityCompat.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!activity.isFinishing() && !ActivityRecreator.recreate(activity)) {
                        activity.recreate();
                    }
                }
            });
        } else if (!ActivityRecreator.recreate(activity)) {
            activity.recreate();
        }
    }

    @Nullable
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity activity, DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.request(activity, dragEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i3) {
        PermissionCompatDelegate permissionCompatDelegate = sDelegate;
        if (permissionCompatDelegate != null && permissionCompatDelegate.requestPermissions(activity, strArr, i3)) {
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
        }
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i3);
        }
        PermissionMonitor.requestPermissions(activity, strArr, i3);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Activity activity, @IdRes int i3) {
        View requireViewById;
        if (Build.VERSION.SDK_INT >= 28) {
            requireViewById = activity.requireViewById(i3);
            return (T) requireViewById;
        }
        T t16 = (T) activity.findViewById(i3);
        if (t16 != null) {
            return t16;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void setEnterSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        SharedElementCallback21Impl sharedElementCallback21Impl;
        if (sharedElementCallback != null) {
            sharedElementCallback21Impl = new SharedElementCallback21Impl(sharedElementCallback);
        } else {
            sharedElementCallback21Impl = null;
        }
        activity.setEnterSharedElementCallback(sharedElementCallback21Impl);
    }

    public static void setExitSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        SharedElementCallback21Impl sharedElementCallback21Impl;
        if (sharedElementCallback != null) {
            sharedElementCallback21Impl = new SharedElementCallback21Impl(sharedElementCallback);
        } else {
            sharedElementCallback21Impl = null;
        }
        activity.setExitSharedElementCallback(sharedElementCallback21Impl);
    }

    public static void setLocusContext(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setLocusContext(activity, locusIdCompat, bundle);
        }
    }

    public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate permissionCompatDelegate) {
        sDelegate = permissionCompatDelegate;
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity activity, @NonNull String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i3, @Nullable Bundle bundle) {
        activity.startActivityForResult(intent, i3, bundle);
    }

    public static void startIntentSenderForResult(@NonNull Activity activity, @NonNull IntentSender intentSender, int i3, @Nullable Intent intent, int i16, int i17, int i18, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i3, intent, i16, i17, i18, bundle);
    }

    public static void startPostponedEnterTransition(@NonNull Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
