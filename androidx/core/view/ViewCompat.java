package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;

    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;

    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;

    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;

    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;

    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;

    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;

    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;

    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;

    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;

    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static Field sAccessibilityDelegateField;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap = null;
    private static boolean sAccessibilityDelegateCheckFailed = false;
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = {R.id.s6u, R.id.s6v, R.id.s76, R.id.s7g, R.id.s7j, R.id.s7k, R.id.s7l, R.id.s7m, R.id.s7n, R.id.s7o, R.id.s6w, R.id.s6x, R.id.s6y, R.id.s6z, R.id.f163842s70, R.id.f163843s71, R.id.f163844s72, R.id.f163845s73, R.id.f163846s74, R.id.s75, R.id.s77, R.id.s78, R.id.s79, R.id.s7_, R.id.s7a, R.id.s7b, R.id.s7c, R.id.s7d, R.id.s7e, R.id.s7f, R.id.s7h, R.id.s7i};
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new OnReceiveContentViewBehavior() { // from class: androidx.core.view.ViewCompat.1
        @Override // androidx.core.view.OnReceiveContentViewBehavior
        public ContentInfoCompat onReceiveContent(@NonNull ContentInfoCompat contentInfoCompat) {
            return contentInfoCompat;
        }
    };
    private static AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class AccessibilityViewProperty<T> {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        AccessibilityViewProperty(int i3, Class<T> cls, int i16) {
            this(i3, cls, 0, i16);
        }

        private boolean extrasAvailable() {
            return true;
        }

        private boolean frameworkAvailable() {
            if (Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk) {
                return true;
            }
            return false;
        }

        boolean booleanNullToFalseEquals(Boolean bool, Boolean bool2) {
            boolean booleanValue;
            boolean booleanValue2;
            if (bool == null) {
                booleanValue = false;
            } else {
                booleanValue = bool.booleanValue();
            }
            if (bool2 == null) {
                booleanValue2 = false;
            } else {
                booleanValue2 = bool2.booleanValue();
            }
            if (booleanValue != booleanValue2) {
                return false;
            }
            return true;
        }

        abstract T frameworkGet(View view);

        abstract void frameworkSet(View view, T t16);

        T get(View view) {
            if (frameworkAvailable()) {
                return frameworkGet(view);
            }
            if (extrasAvailable()) {
                T t16 = (T) view.getTag(this.mTagKey);
                if (this.mType.isInstance(t16)) {
                    return t16;
                }
                return null;
            }
            return null;
        }

        void set(View view, T t16) {
            if (frameworkAvailable()) {
                frameworkSet(view, t16);
            } else if (extrasAvailable() && shouldUpdate(get(view), t16)) {
                ViewCompat.getOrCreateAccessibilityDelegateCompat(view);
                view.setTag(this.mTagKey, t16);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.mContentChangeType);
            }
        }

        boolean shouldUpdate(T t16, T t17) {
            return !t17.equals(t16);
        }

        AccessibilityViewProperty(int i3, Class<T> cls, int i16, int i17) {
            this.mTagKey = i3;
            this.mType = cls;
            this.mContentChangeType = i16;
            this.mFrameworkMinimumSdk = i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class Api21Impl {
        Api21Impl() {
        }

        static void callCompatInsetAnimationCallback(@NonNull WindowInsets windowInsets, @NonNull View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.f924557x);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
            return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(view);
        }

        static void setOnApplyWindowInsetsListener(@NonNull final View view, @Nullable final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.f922757f, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.f924557x));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.Api21Impl.1
                    WindowInsetsCompat mLastInsets = null;

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view2);
                        int i3 = Build.VERSION.SDK_INT;
                        if (i3 < 30) {
                            Api21Impl.callCompatInsetAnimationCallback(windowInsets, view);
                            if (windowInsetsCompat.equals(this.mLastInsets)) {
                                return onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsetsCompat).toWindowInsets();
                            }
                        }
                        this.mLastInsets = windowInsetsCompat;
                        WindowInsetsCompat onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsetsCompat);
                        if (i3 >= 30) {
                            return onApplyWindowInsets.toWindowInsets();
                        }
                        ViewCompat.requestApplyInsets(view2);
                        return onApplyWindowInsets.toWindowInsets();
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @RequiresApi(23)
    /* loaded from: classes.dex */
    private static class Api23Impl {
        Api23Impl() {
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
            windowInsetsCompat.setRootWindowInsets(windowInsetsCompat);
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
            return windowInsetsCompat;
        }
    }

    /* compiled from: P */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    private static class Api29Impl {
        Api29Impl() {
        }

        static void saveAttributeDataForStyleable(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i3, int i16) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i3, i16);
        }
    }

    /* compiled from: P */
    @RequiresApi(30)
    /* loaded from: classes.dex */
    private static class Api30Impl {
        Api30Impl() {
        }

        @Nullable
        public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View view) {
            WindowInsetsController windowInsetsController;
            windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(windowInsetsController);
            }
            return null;
        }
    }

    /* compiled from: P */
    @RequiresApi(28)
    /* loaded from: classes.dex */
    static class CompatImplApi28 {
        CompatImplApi28() {
        }

        static void addOnUnhandledKeyEventListener(@NonNull View view, @NonNull final OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.f924157t);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(R.id.f924157t, simpleArrayMap);
            }
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.view.ViewCompat.CompatImplApi28.1
                @Override // android.view.View.OnUnhandledKeyEventListener
                public boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return OnUnhandledKeyEventListenerCompat.this.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static void removeOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.f924157t);
            if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface FocusDirection {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface FocusRealDirection {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface FocusRelativeDirection {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface NestedScrollType {
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ScrollAxis {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ScrollIndicators {
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList<>();

        @Nullable
        private WeakHashMap<View, Boolean> mViewsContainingListeners = null;
        private SparseArray<WeakReference<View>> mCapturedKeys = null;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;

        UnhandledKeyEventManager() {
        }

        static UnhandledKeyEventManager at(View view) {
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R.id.f924057s);
            if (unhandledKeyEventManager == null) {
                UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
                view.setTag(R.id.f924057s, unhandledKeyEventManager2);
                return unhandledKeyEventManager2;
            }
            return unhandledKeyEventManager;
        }

        @Nullable
        private View dispatchInOrder(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                        if (dispatchInOrder != null) {
                            return dispatchInOrder;
                        }
                    }
                }
                if (onUnhandledKeyEvent(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys == null) {
                this.mCapturedKeys = new SparseArray<>();
            }
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.f924157t);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.mViewsContainingListeners == null) {
                    this.mViewsContainingListeners = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = sViewsWithListeners;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.mViewsContainingListeners.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        static void registerListeningView(View view) {
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            synchronized (arrayList) {
                Iterator<WeakReference<View>> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == view) {
                        return;
                    }
                }
                sViewsWithListeners.add(new WeakReference<>(view));
            }
        }

        static void unregisterListeningView(View view) {
            synchronized (sViewsWithListeners) {
                int i3 = 0;
                while (true) {
                    ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
                    if (i3 < arrayList.size()) {
                        if (arrayList.get(i3).get() == view) {
                            arrayList.remove(i3);
                            return;
                        }
                        i3++;
                    } else {
                        return;
                    }
                }
            }
        }

        boolean dispatch(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                recalcViewsWithUnhandled();
            }
            View dispatchInOrder = dispatchInOrder(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (dispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                    getCapturedKeys().put(keyCode, new WeakReference<>(dispatchInOrder));
                }
            }
            if (dispatchInOrder != null) {
                return true;
            }
            return false;
        }

        boolean preDispatch(KeyEvent keyEvent) {
            WeakReference<View> weakReference;
            int indexOfKey;
            WeakReference<KeyEvent> weakReference2 = this.mLastDispatchedPreViewKeyEvent;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.mLastDispatchedPreViewKeyEvent = new WeakReference<>(keyEvent);
            SparseArray<WeakReference<View>> capturedKeys = getCapturedKeys();
            if (keyEvent.getAction() == 1 && (indexOfKey = capturedKeys.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference = capturedKeys.valueAt(indexOfKey);
                capturedKeys.removeAt(indexOfKey);
            } else {
                weakReference = null;
            }
            if (weakReference == null) {
                weakReference = capturedKeys.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = weakReference.get();
            if (view != null && ViewCompat.isAttachedToWindow(view)) {
                onUnhandledKeyEvent(view, keyEvent);
            }
            return true;
        }
    }

    @Deprecated
    protected ViewCompat() {
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        return new AccessibilityViewProperty<Boolean>(R.id.f9213572, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public Boolean frameworkGet(View view) {
                boolean isAccessibilityHeading;
                isAccessibilityHeading = view.isAccessibilityHeading();
                return Boolean.valueOf(isAccessibilityHeading);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view, Boolean bool) {
                view.setAccessibilityHeading(bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                return !booleanNullToFalseEquals(bool, bool2);
            }
        };
    }

    public static int addAccessibilityAction(@NonNull View view, @NonNull CharSequence charSequence, @NonNull AccessibilityViewCommand accessibilityViewCommand) {
        int availableActionIdFromResources = getAvailableActionIdFromResources(view, charSequence);
        if (availableActionIdFromResources != -1) {
            addAccessibilityAction(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(availableActionIdFromResources, charSequence, accessibilityViewCommand));
        }
        return availableActionIdFromResources;
    }

    public static void addKeyboardNavigationClusters(@NonNull View view, @NonNull Collection<View> collection, int i3) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.addKeyboardNavigationClusters(collection, i3);
        }
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            CompatImplApi28.addOnUnhandledKeyEventListener(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.f924157t);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(R.id.f924157t, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            UnhandledKeyEventManager.registerListeningView(view);
        }
    }

    @NonNull
    public static ViewPropertyAnimatorCompat animate(@NonNull View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat == null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
            return viewPropertyAnimatorCompat2;
        }
        return viewPropertyAnimatorCompat;
    }

    private static void bindTempDetach() {
        try {
            sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (NoSuchMethodException e16) {
            Log.e("ViewCompat", "Couldn't find method", e16);
        }
        sTempDetachBound = true;
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int i3) {
        return view.canScrollHorizontally(i3);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int i3) {
        return view.canScrollVertically(i3);
    }

    public static void cancelDragAndDrop(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.cancelDragAndDrop();
        }
    }

    @Deprecated
    public static int combineMeasuredStates(int i3, int i16) {
        return View.combineMeasuredStates(i3, i16);
    }

    private static void compatOffsetLeftAndRight(View view, int i3) {
        view.offsetLeftAndRight(i3);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    private static void compatOffsetTopAndBottom(View view, int i3) {
        view.offsetTopAndBottom(i3);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        return Api21Impl.computeSystemWindowInsets(view, windowInsetsCompat, rect);
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (!dispatchApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(dispatchApplyWindowInsets, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.dispatchFinishTemporaryDetach();
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchFinishTemporaryDetach;
        if (method != null) {
            try {
                method.invoke(view, new Object[0]);
                return;
            } catch (Exception e16) {
                Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", e16);
                return;
            }
        }
        view.onFinishTemporaryDetach();
    }

    public static boolean dispatchNestedFling(@NonNull View view, float f16, float f17, boolean z16) {
        return view.dispatchNestedFling(f16, f17, z16);
    }

    public static boolean dispatchNestedPreFling(@NonNull View view, float f16, float f17) {
        return view.dispatchNestedPreFling(f16, f17);
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i3, int i16, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return view.dispatchNestedPreScroll(i3, i16, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, @Nullable int[] iArr) {
        return view.dispatchNestedScroll(i3, i16, i17, i18, iArr);
    }

    public static void dispatchStartTemporaryDetach(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.dispatchStartTemporaryDetach();
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchStartTemporaryDetach;
        if (method != null) {
            try {
                method.invoke(view, new Object[0]);
                return;
            } catch (Exception e16) {
                Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", e16);
                return;
            }
        }
        view.onStartTemporaryDetach();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.at(view).dispatch(view, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.at(view).preDispatch(keyEvent);
    }

    public static void enableAccessibleClickableSpanSupport(View view) {
        getOrCreateAccessibilityDelegateCompat(view);
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View view) {
        View.AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view);
        if (accessibilityDelegateInternal == null) {
            return null;
        }
        if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
            return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
        }
        return new AccessibilityDelegateCompat(accessibilityDelegateInternal);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
            return accessibilityDelegate;
        }
        return getAccessibilityDelegateThroughReflection(view);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@NonNull View view) {
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                sAccessibilityDelegateField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            Object obj = sAccessibilityDelegateField.get(view);
            if (!(obj instanceof View.AccessibilityDelegate)) {
                return null;
            }
            return (View.AccessibilityDelegate) obj;
        } catch (Throwable unused2) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    public static int getAccessibilityLiveRegion(@NonNull View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    @UiThread
    public static CharSequence getAccessibilityPaneTitle(View view) {
        return paneTitleProperty().get(view);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.f9211570);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(R.id.f9211570, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    private static int getAvailableActionIdFromResources(View view, @NonNull CharSequence charSequence) {
        boolean z16;
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        for (int i3 = 0; i3 < actionList.size(); i3++) {
            if (TextUtils.equals(charSequence, actionList.get(i3).getLabel())) {
                return actionList.get(i3).getId();
            }
        }
        int i16 = -1;
        int i17 = 0;
        while (true) {
            int[] iArr = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
            if (i17 >= iArr.length || i16 != -1) {
                break;
            }
            int i18 = iArr[i17];
            boolean z17 = true;
            for (int i19 = 0; i19 < actionList.size(); i19++) {
                if (actionList.get(i19).getId() != i18) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                z17 &= z16;
            }
            if (z17) {
                i16 = i18;
            }
            i17++;
        }
        return i16;
    }

    public static ColorStateList getBackgroundTintList(@NonNull View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View view) {
        return view.getBackgroundTintMode();
    }

    @Nullable
    public static Rect getClipBounds(@NonNull View view) {
        return view.getClipBounds();
    }

    @Nullable
    public static Display getDisplay(@NonNull View view) {
        return view.getDisplay();
    }

    public static float getElevation(@NonNull View view) {
        return view.getElevation();
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal<>();
        }
        Rect rect = sThreadLocalRect.get();
        if (rect == null) {
            rect = new Rect();
            sThreadLocalRect.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static OnReceiveContentViewBehavior getFallback(@NonNull View view) {
        if (view instanceof OnReceiveContentViewBehavior) {
            return (OnReceiveContentViewBehavior) view;
        }
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    public static boolean getFitsSystemWindows(@NonNull View view) {
        return view.getFitsSystemWindows();
    }

    public static int getImportantForAccessibility(@NonNull View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View view) {
        int importantForAutofill;
        if (Build.VERSION.SDK_INT >= 26) {
            importantForAutofill = view.getImportantForAutofill();
            return importantForAutofill;
        }
        return 0;
    }

    public static int getLabelFor(@NonNull View view) {
        return view.getLabelFor();
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    public static int getLayoutDirection(@NonNull View view) {
        return view.getLayoutDirection();
    }

    @Nullable
    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(@NonNull View view) {
        return view.getMinimumHeight();
    }

    public static int getMinimumWidth(@NonNull View view) {
        return view.getMinimumWidth();
    }

    public static int getNextClusterForwardId(@NonNull View view) {
        int nextClusterForwardId;
        if (Build.VERSION.SDK_INT >= 26) {
            nextClusterForwardId = view.getNextClusterForwardId();
            return nextClusterForwardId;
        }
        return -1;
    }

    @Nullable
    public static String[] getOnReceiveContentMimeTypes(@NonNull View view) {
        return (String[]) view.getTag(R.id.f922957h);
    }

    static AccessibilityDelegateCompat getOrCreateAccessibilityDelegateCompat(@NonNull View view) {
        AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view, accessibilityDelegate);
        return accessibilityDelegate;
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    @Px
    public static int getPaddingEnd(@NonNull View view) {
        return view.getPaddingEnd();
    }

    @Px
    public static int getPaddingStart(@NonNull View view) {
        return view.getPaddingStart();
    }

    public static ViewParent getParentForAccessibility(@NonNull View view) {
        return view.getParentForAccessibility();
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        return Api23Impl.getRootWindowInsets(view);
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(@NonNull View view) {
        return view.getScrollIndicators();
    }

    @Nullable
    @UiThread
    public static final CharSequence getStateDescription(@NonNull View view) {
        return stateDescriptionProperty().get(view);
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View view) {
        List<Rect> systemGestureExclusionRects;
        if (Build.VERSION.SDK_INT >= 29) {
            systemGestureExclusionRects = view.getSystemGestureExclusionRects();
            return systemGestureExclusionRects;
        }
        return Collections.emptyList();
    }

    @Nullable
    public static String getTransitionName(@NonNull View view) {
        return view.getTransitionName();
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(@NonNull View view) {
        return view.getTranslationZ();
    }

    @Nullable
    public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getWindowInsetsController(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window == null) {
                    return null;
                }
                return WindowCompat.getInsetsController(window, view);
            }
        }
        return null;
    }

    public static int getWindowSystemUiVisibility(@NonNull View view) {
        return view.getWindowSystemUiVisibility();
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(@NonNull View view) {
        return view.getZ();
    }

    public static boolean hasAccessibilityDelegate(@NonNull View view) {
        if (getAccessibilityDelegateInternal(view) != null) {
            return true;
        }
        return false;
    }

    public static boolean hasExplicitFocusable(@NonNull View view) {
        boolean hasExplicitFocusable;
        if (Build.VERSION.SDK_INT >= 26) {
            hasExplicitFocusable = view.hasExplicitFocusable();
            return hasExplicitFocusable;
        }
        return view.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(@NonNull View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean hasOnClickListeners(@NonNull View view) {
        return view.hasOnClickListeners();
    }

    public static boolean hasOverlappingRendering(@NonNull View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean hasTransientState(@NonNull View view) {
        return view.hasTransientState();
    }

    @UiThread
    public static boolean isAccessibilityHeading(View view) {
        Boolean bool = accessibilityHeadingProperty().get(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean isAttachedToWindow(@NonNull View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(@NonNull View view) {
        boolean isFocusedByDefault;
        if (Build.VERSION.SDK_INT >= 26) {
            isFocusedByDefault = view.isFocusedByDefault();
            return isFocusedByDefault;
        }
        return false;
    }

    public static boolean isImportantForAccessibility(@NonNull View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean isImportantForAutofill(@NonNull View view) {
        boolean isImportantForAutofill;
        if (Build.VERSION.SDK_INT >= 26) {
            isImportantForAutofill = view.isImportantForAutofill();
            return isImportantForAutofill;
        }
        return true;
    }

    public static boolean isInLayout(@NonNull View view) {
        return view.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View view) {
        boolean isKeyboardNavigationCluster;
        if (Build.VERSION.SDK_INT >= 26) {
            isKeyboardNavigationCluster = view.isKeyboardNavigationCluster();
            return isKeyboardNavigationCluster;
        }
        return false;
    }

    public static boolean isLaidOut(@NonNull View view) {
        return view.isLaidOut();
    }

    public static boolean isLayoutDirectionResolved(@NonNull View view) {
        return view.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(@NonNull View view) {
        return view.isNestedScrollingEnabled();
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    public static boolean isPaddingRelative(@NonNull View view) {
        return view.isPaddingRelative();
    }

    @UiThread
    public static boolean isScreenReaderFocusable(View view) {
        Boolean bool = screenReaderFocusableProperty().get(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(@NonNull View view, View view2, int i3) {
        View keyboardNavigationClusterSearch;
        if (Build.VERSION.SDK_INT >= 26) {
            keyboardNavigationClusterSearch = view.keyboardNavigationClusterSearch(view2, i3);
            return keyboardNavigationClusterSearch;
        }
        return null;
    }

    @RequiresApi(19)
    static void notifyViewAccessibilityStateChangedIfNeeded(View view, int i3) {
        boolean z16;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        if (getAccessibilityPaneTitle(view) != null && view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i16 = 32;
        if (getAccessibilityLiveRegion(view) == 0 && !z16) {
            if (i3 == 32) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                obtain.setContentChangeTypes(i3);
                obtain.setSource(view);
                view.onPopulateAccessibilityEvent(obtain);
                obtain.getText().add(getAccessibilityPaneTitle(view));
                accessibilityManager.sendAccessibilityEvent(obtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i3);
                    return;
                } catch (AbstractMethodError e16) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e16);
                    return;
                }
            }
            return;
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
        if (!z16) {
            i16 = 2048;
        }
        obtain2.setEventType(i16);
        obtain2.setContentChangeTypes(i3);
        if (z16) {
            obtain2.getText().add(getAccessibilityPaneTitle(view));
            setViewImportanceForAccessibilityIfNeeded(view);
        }
        view.sendAccessibilityEventUnchecked(obtain2);
    }

    public static void offsetLeftAndRight(@NonNull View view, int i3) {
        view.offsetLeftAndRight(i3);
    }

    public static void offsetTopAndBottom(@NonNull View view, int i3) {
        view.offsetTopAndBottom(i3);
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (!onApplyWindowInsets.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(onApplyWindowInsets, view);
            }
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(@NonNull View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        return new AccessibilityViewProperty<CharSequence>(R.id.f9214573, CharSequence.class, 8, 28) { // from class: androidx.core.view.ViewCompat.3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public CharSequence frameworkGet(View view) {
                CharSequence accessibilityPaneTitle;
                accessibilityPaneTitle = view.getAccessibilityPaneTitle();
                return accessibilityPaneTitle;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view, CharSequence charSequence) {
                view.setAccessibilityPaneTitle(charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static boolean performAccessibilityAction(@NonNull View view, int i3, Bundle bundle) {
        return view.performAccessibilityAction(i3, bundle);
    }

    @Nullable
    public static ContentInfoCompat performReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.f922857g);
        if (onReceiveContentListener != null) {
            ContentInfoCompat onReceiveContent = onReceiveContentListener.onReceiveContent(view, contentInfoCompat);
            if (onReceiveContent == null) {
                return null;
            }
            return getFallback(view).onReceiveContent(onReceiveContent);
        }
        return getFallback(view).onReceiveContent(contentInfoCompat);
    }

    public static void postInvalidateOnAnimation(@NonNull View view) {
        view.postInvalidateOnAnimation();
    }

    public static void postOnAnimation(@NonNull View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void postOnAnimationDelayed(@NonNull View view, Runnable runnable, long j3) {
        view.postOnAnimationDelayed(runnable, j3);
    }

    public static void removeAccessibilityAction(@NonNull View view, int i3) {
        removeActionWithId(i3, view);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    private static void removeActionWithId(int i3, View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        for (int i16 = 0; i16 < actionList.size(); i16++) {
            if (actionList.get(i16).getId() == i3) {
                actionList.remove(i16);
                return;
            }
        }
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            CompatImplApi28.removeOnUnhandledKeyEventListener(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.f924157t);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                UnhandledKeyEventManager.unregisterListeningView(view);
            }
        }
    }

    public static void replaceAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, @Nullable CharSequence charSequence, @Nullable AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            removeAccessibilityAction(view, accessibilityActionCompat.getId());
        } else {
            addAccessibilityAction(view, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
        }
    }

    public static void requestApplyInsets(@NonNull View view) {
        view.requestApplyInsets();
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View view, @IdRes int i3) {
        View requireViewById;
        if (Build.VERSION.SDK_INT >= 28) {
            requireViewById = view.requireViewById(i3);
            return (T) requireViewById;
        }
        T t16 = (T) view.findViewById(i3);
        if (t16 != null) {
            return t16;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated
    public static int resolveSizeAndState(int i3, int i16, int i17) {
        return View.resolveSizeAndState(i3, i16, i17);
    }

    public static boolean restoreDefaultFocus(@NonNull View view) {
        boolean restoreDefaultFocus;
        if (Build.VERSION.SDK_INT >= 26) {
            restoreDefaultFocus = view.restoreDefaultFocus();
            return restoreDefaultFocus;
        }
        return view.requestFocus();
    }

    public static void saveAttributeDataForStyleable(@NonNull View view, @NonNull @SuppressLint({"ContextFirst"}) Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i3, int i16) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(view, context, iArr, attributeSet, typedArray, i3, i16);
        }
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        return new AccessibilityViewProperty<Boolean>(R.id.f923557n, Boolean.class, 28) { // from class: androidx.core.view.ViewCompat.2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public Boolean frameworkGet(View view) {
                boolean isScreenReaderFocusable;
                isScreenReaderFocusable = view.isScreenReaderFocusable();
                return Boolean.valueOf(isScreenReaderFocusable);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(28)
            public void frameworkSet(View view, Boolean bool) {
                view.setScreenReaderFocusable(bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(Boolean bool, Boolean bool2) {
                return !booleanNullToFalseEquals(bool, bool2);
            }
        };
    }

    public static void setAccessibilityDelegate(@NonNull View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        View.AccessibilityDelegate bridge;
        if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (accessibilityDelegateCompat == null) {
            bridge = null;
        } else {
            bridge = accessibilityDelegateCompat.getBridge();
        }
        view.setAccessibilityDelegate(bridge);
    }

    @UiThread
    public static void setAccessibilityHeading(View view, boolean z16) {
        accessibilityHeadingProperty().set(view, Boolean.valueOf(z16));
    }

    public static void setAccessibilityLiveRegion(@NonNull View view, int i3) {
        view.setAccessibilityLiveRegion(i3);
    }

    @UiThread
    public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
        paneTitleProperty().set(view, charSequence);
        if (charSequence != null) {
            sAccessibilityPaneVisibilityManager.addAccessibilityPane(view);
        } else {
            sAccessibilityPaneVisibilityManager.removeAccessibilityPane(view);
        }
    }

    @Deprecated
    public static void setActivated(View view, boolean z16) {
        view.setActivated(z16);
    }

    @Deprecated
    public static void setAlpha(View view, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        view.setAlpha(f16);
    }

    public static void setAutofillHints(@NonNull View view, @Nullable String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setAutofillHints(strArr);
        }
    }

    public static void setBackground(@NonNull View view, @Nullable Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void setBackgroundTintList(@NonNull View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void setBackgroundTintMode(@NonNull View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z16) {
        if (sChildrenDrawingOrderMethod == null) {
            try {
                sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e16) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e16);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke(viewGroup, Boolean.valueOf(z16));
        } catch (IllegalAccessException e17) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e17);
        } catch (IllegalArgumentException e18) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e18);
        } catch (InvocationTargetException e19) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e19);
        }
    }

    public static void setClipBounds(@NonNull View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void setElevation(@NonNull View view, float f16) {
        view.setElevation(f16);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z16) {
        view.setFitsSystemWindows(z16);
    }

    public static void setFocusedByDefault(@NonNull View view, boolean z16) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setFocusedByDefault(z16);
        }
    }

    public static void setHasTransientState(@NonNull View view, boolean z16) {
        view.setHasTransientState(z16);
    }

    public static void setImportantForAccessibility(@NonNull View view, int i3) {
        view.setImportantForAccessibility(i3);
    }

    public static void setImportantForAutofill(@NonNull View view, int i3) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i3);
        }
    }

    public static void setKeyboardNavigationCluster(@NonNull View view, boolean z16) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setKeyboardNavigationCluster(z16);
        }
    }

    public static void setLabelFor(@NonNull View view, @IdRes int i3) {
        view.setLabelFor(i3);
    }

    public static void setLayerPaint(@NonNull View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    @Deprecated
    public static void setLayerType(View view, int i3, Paint paint) {
        view.setLayerType(i3, paint);
    }

    public static void setLayoutDirection(@NonNull View view, int i3) {
        view.setLayoutDirection(i3);
    }

    public static void setNestedScrollingEnabled(@NonNull View view, boolean z16) {
        view.setNestedScrollingEnabled(z16);
    }

    public static void setNextClusterForwardId(@NonNull View view, int i3) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setNextClusterForwardId(i3);
        }
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View view, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Api21Impl.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    public static void setOnReceiveContentListener(@NonNull View view, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
        boolean z16;
        if (strArr == null || strArr.length == 0) {
            strArr = null;
        }
        boolean z17 = false;
        if (onReceiveContentListener != null) {
            if (strArr != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            Preconditions.checkArgument(z16, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (strArr[i3].startsWith("*")) {
                    z17 = true;
                    break;
                }
                i3++;
            }
            Preconditions.checkArgument(!z17, "A MIME type set here must not start with *: " + Arrays.toString(strArr));
        }
        view.setTag(R.id.f922957h, strArr);
        view.setTag(R.id.f922857g, onReceiveContentListener);
    }

    @Deprecated
    public static void setOverScrollMode(View view, int i3) {
        view.setOverScrollMode(i3);
    }

    public static void setPaddingRelative(@NonNull View view, @Px int i3, @Px int i16, @Px int i17, @Px int i18) {
        view.setPaddingRelative(i3, i16, i17, i18);
    }

    @Deprecated
    public static void setPivotX(View view, float f16) {
        view.setPivotX(f16);
    }

    @Deprecated
    public static void setPivotY(View view, float f16) {
        view.setPivotY(f16);
    }

    public static void setPointerIcon(@NonNull View view, PointerIconCompat pointerIconCompat) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (pointerIconCompat != null) {
                obj = pointerIconCompat.getPointerIcon();
            } else {
                obj = null;
            }
            view.setPointerIcon((PointerIcon) obj);
        }
    }

    @Deprecated
    public static void setRotation(View view, float f16) {
        view.setRotation(f16);
    }

    @Deprecated
    public static void setRotationX(View view, float f16) {
        view.setRotationX(f16);
    }

    @Deprecated
    public static void setRotationY(View view, float f16) {
        view.setRotationY(f16);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z16) {
        view.setSaveFromParentEnabled(z16);
    }

    @Deprecated
    public static void setScaleX(View view, float f16) {
        view.setScaleX(f16);
    }

    @Deprecated
    public static void setScaleY(View view, float f16) {
        view.setScaleY(f16);
    }

    @UiThread
    public static void setScreenReaderFocusable(View view, boolean z16) {
        screenReaderFocusableProperty().set(view, Boolean.valueOf(z16));
    }

    public static void setScrollIndicators(@NonNull View view, int i3) {
        view.setScrollIndicators(i3);
    }

    @UiThread
    public static void setStateDescription(@NonNull View view, @Nullable CharSequence charSequence) {
        stateDescriptionProperty().set(view, charSequence);
    }

    public static void setSystemGestureExclusionRects(@NonNull View view, @NonNull List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        }
    }

    public static void setTransitionName(@NonNull View view, String str) {
        view.setTransitionName(str);
    }

    @Deprecated
    public static void setTranslationX(View view, float f16) {
        view.setTranslationX(f16);
    }

    @Deprecated
    public static void setTranslationY(View view, float f16) {
        view.setTranslationY(f16);
    }

    public static void setTranslationZ(@NonNull View view, float f16) {
        view.setTranslationZ(f16);
    }

    private static void setViewImportanceForAccessibilityIfNeeded(View view) {
        if (getImportantForAccessibility(view) == 0) {
            setImportantForAccessibility(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (getImportantForAccessibility((View) parent) == 4) {
                setImportantForAccessibility(view, 2);
                return;
            }
        }
    }

    public static void setWindowInsetsAnimationCallback(@NonNull View view, @Nullable WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.setCallback(view, callback);
    }

    @Deprecated
    public static void setX(View view, float f16) {
        view.setX(f16);
    }

    @Deprecated
    public static void setY(View view, float f16) {
        view.setY(f16);
    }

    public static void setZ(@NonNull View view, float f16) {
        view.setZ(f16);
    }

    public static boolean startDragAndDrop(@NonNull View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i3) {
        boolean startDragAndDrop;
        if (Build.VERSION.SDK_INT >= 24) {
            startDragAndDrop = view.startDragAndDrop(clipData, dragShadowBuilder, obj, i3);
            return startDragAndDrop;
        }
        return view.startDrag(clipData, dragShadowBuilder, obj, i3);
    }

    public static boolean startNestedScroll(@NonNull View view, int i3) {
        return view.startNestedScroll(i3);
    }

    private static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        return new AccessibilityViewProperty<CharSequence>(R.id.f923657o, CharSequence.class, 64, 30) { // from class: androidx.core.view.ViewCompat.4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(30)
            public CharSequence frameworkGet(View view) {
                CharSequence stateDescription;
                stateDescription = view.getStateDescription();
                return stateDescription;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            @RequiresApi(30)
            public void frameworkSet(View view, CharSequence charSequence) {
                view.setStateDescription(charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.view.ViewCompat.AccessibilityViewProperty
            public boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static void stopNestedScroll(@NonNull View view) {
        view.stopNestedScroll();
    }

    private static void tickleInvalidationFlag(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void updateDragShadow(@NonNull View view, View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(@NonNull View view, int i3, int i16, @Nullable int[] iArr, @Nullable int[] iArr2, int i17) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedPreScroll(i3, i16, iArr, iArr2, i17);
        }
        if (i17 == 0) {
            return dispatchNestedPreScroll(view, i3, i16, iArr, iArr2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dispatchNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19, @NonNull int[] iArr2) {
        if (view instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3) view).dispatchNestedScroll(i3, i16, i17, i18, iArr, i19, iArr2);
        } else {
            dispatchNestedScroll(view, i3, i16, i17, i18, iArr, i19);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(@NonNull View view, int i3) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).hasNestedScrollingParent(i3);
            return false;
        }
        if (i3 == 0) {
            return hasNestedScrollingParent(view);
        }
        return false;
    }

    public static void postInvalidateOnAnimation(@NonNull View view, int i3, int i16, int i17, int i18) {
        view.postInvalidateOnAnimation(i3, i16, i17, i18);
    }

    public static void setScrollIndicators(@NonNull View view, int i3, int i16) {
        view.setScrollIndicators(i3, i16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(@NonNull View view, int i3, int i16) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).startNestedScroll(i3, i16);
        }
        if (i16 == 0) {
            return startNestedScroll(view, i3);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(@NonNull View view, int i3) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i3);
        } else if (i3 == 0) {
            stopNestedScroll(view);
        }
    }

    private static void addAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        getOrCreateAccessibilityDelegateCompat(view);
        removeActionWithId(accessibilityActionCompat.getId(), view);
        getActionList(view).add(accessibilityActionCompat);
        notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedScroll(i3, i16, i17, i18, iArr, i19);
        }
        if (i19 == 0) {
            return dispatchNestedScroll(view, i3, i16, i17, i18, iArr);
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap<>();

        AccessibilityPaneVisibilityManager() {
        }

        @RequiresApi(19)
        private void checkPaneVisibility(View view, boolean z16) {
            boolean z17;
            int i3;
            if (view.getVisibility() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16 != z17) {
                if (z17) {
                    i3 = 16;
                } else {
                    i3 = 32;
                }
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, i3);
                this.mPanesToVisible.put(view, Boolean.valueOf(z17));
            }
        }

        @RequiresApi(19)
        private void registerForLayoutCallback(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        private void unregisterForLayoutCallback(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        void addAccessibilityPane(View view) {
            boolean z16;
            WeakHashMap<View, Boolean> weakHashMap = this.mPanesToVisible;
            if (view.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            weakHashMap.put(view, Boolean.valueOf(z16));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                registerForLayoutCallback(view);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(19)
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.mPanesToVisible.entrySet()) {
                    checkPaneVisibility(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @RequiresApi(19)
        public void onViewAttachedToWindow(View view) {
            registerForLayoutCallback(view);
        }

        @RequiresApi(19)
        void removeAccessibilityPane(View view) {
            this.mPanesToVisible.remove(view);
            view.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
