package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
@Navigator.Name("fragment")
/* loaded from: classes.dex */
public class FragmentNavigator extends Navigator<Destination> {
    private static final String KEY_BACK_STACK_IDS = "androidx-nav-fragment:navigator:backStackIds";
    private static final String TAG = "FragmentNavigator";
    private ArrayDeque<Integer> mBackStack = new ArrayDeque<>();
    private final int mContainerId;
    private final Context mContext;
    private final FragmentManager mFragmentManager;

    /* compiled from: P */
    @NavDestination.ClassType(Fragment.class)
    /* loaded from: classes.dex */
    public static class Destination extends NavDestination {
        private String mClassName;

        public Destination(@NonNull NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(FragmentNavigator.class));
        }

        @NonNull
        public final String getClassName() {
            String str = this.mClassName;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set");
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.FragmentNavigator);
            String string = obtainAttributes.getString(R.styleable.FragmentNavigator_android_name);
            if (string != null) {
                setClassName(string);
            }
            obtainAttributes.recycle();
        }

        @NonNull
        public final Destination setClassName(@NonNull String str) {
            this.mClassName = str;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        @NonNull
        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(super.toString());
            sb5.append(" class=");
            String str = this.mClassName;
            if (str == null) {
                sb5.append("null");
            } else {
                sb5.append(str);
            }
            return sb5.toString();
        }

        public Destination(@NonNull Navigator<? extends Destination> navigator) {
            super(navigator);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Extras implements Navigator.Extras {
        private final LinkedHashMap<View, String> mSharedElements;

        /* compiled from: P */
        /* loaded from: classes.dex */
        public static final class Builder {
            private final LinkedHashMap<View, String> mSharedElements = new LinkedHashMap<>();

            @NonNull
            public Builder addSharedElement(@NonNull View view, @NonNull String str) {
                this.mSharedElements.put(view, str);
                return this;
            }

            @NonNull
            public Builder addSharedElements(@NonNull Map<View, String> map) {
                for (Map.Entry<View, String> entry : map.entrySet()) {
                    View key = entry.getKey();
                    String value = entry.getValue();
                    if (key != null && value != null) {
                        addSharedElement(key, value);
                    }
                }
                return this;
            }

            @NonNull
            public Extras build() {
                return new Extras(this.mSharedElements);
            }
        }

        Extras(Map<View, String> map) {
            LinkedHashMap<View, String> linkedHashMap = new LinkedHashMap<>();
            this.mSharedElements = linkedHashMap;
            linkedHashMap.putAll(map);
        }

        @NonNull
        public Map<View, String> getSharedElements() {
            return Collections.unmodifiableMap(this.mSharedElements);
        }
    }

    public FragmentNavigator(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i3) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = i3;
    }

    @NonNull
    private String generateBackStackName(int i3, int i16) {
        return i3 + "-" + i16;
    }

    @NonNull
    @Deprecated
    public Fragment instantiateFragment(@NonNull Context context, @NonNull FragmentManager fragmentManager, @NonNull String str, @Nullable Bundle bundle) {
        return fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), str);
    }

    @Override // androidx.navigation.Navigator
    public void onRestoreState(@Nullable Bundle bundle) {
        int[] intArray;
        if (bundle != null && (intArray = bundle.getIntArray(KEY_BACK_STACK_IDS)) != null) {
            this.mBackStack.clear();
            for (int i3 : intArray) {
                this.mBackStack.add(Integer.valueOf(i3));
            }
        }
    }

    @Override // androidx.navigation.Navigator
    @Nullable
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.mBackStack.size()];
        Iterator<Integer> it = this.mBackStack.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = it.next().intValue();
            i3++;
        }
        bundle.putIntArray(KEY_BACK_STACK_IDS, iArr);
        return bundle;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        if (this.mFragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        this.mFragmentManager.popBackStack(generateBackStackName(this.mBackStack.size(), this.mBackStack.peekLast().intValue()), 1);
        this.mBackStack.removeLast();
        return true;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public Destination createDestination() {
        return new Destination(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0136 A[RETURN] */
    @Override // androidx.navigation.Navigator
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NavDestination navigate(@NonNull Destination destination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        if (this.mFragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String className = destination.getClassName();
        boolean z16 = false;
        if (className.charAt(0) == '.') {
            className = this.mContext.getPackageName() + className;
        }
        Fragment instantiateFragment = instantiateFragment(this.mContext, this.mFragmentManager, className, bundle);
        instantiateFragment.setArguments(bundle);
        FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
        int enterAnim = navOptions != null ? navOptions.getEnterAnim() : -1;
        int exitAnim = navOptions != null ? navOptions.getExitAnim() : -1;
        int popEnterAnim = navOptions != null ? navOptions.getPopEnterAnim() : -1;
        int popExitAnim = navOptions != null ? navOptions.getPopExitAnim() : -1;
        if (enterAnim != -1 || exitAnim != -1 || popEnterAnim != -1 || popExitAnim != -1) {
            if (enterAnim == -1) {
                enterAnim = 0;
            }
            if (exitAnim == -1) {
                exitAnim = 0;
            }
            if (popEnterAnim == -1) {
                popEnterAnim = 0;
            }
            if (popExitAnim == -1) {
                popExitAnim = 0;
            }
            beginTransaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
        }
        beginTransaction.replace(this.mContainerId, instantiateFragment);
        beginTransaction.setPrimaryNavigationFragment(instantiateFragment);
        int id5 = destination.getId();
        boolean isEmpty = this.mBackStack.isEmpty();
        boolean z17 = navOptions != null && !isEmpty && navOptions.shouldLaunchSingleTop() && this.mBackStack.peekLast().intValue() == id5;
        if (!isEmpty) {
            if (z17) {
                if (this.mBackStack.size() > 1) {
                    this.mFragmentManager.popBackStack(generateBackStackName(this.mBackStack.size(), this.mBackStack.peekLast().intValue()), 1);
                    beginTransaction.addToBackStack(generateBackStackName(this.mBackStack.size(), id5));
                }
                if (extras instanceof Extras) {
                    for (Map.Entry<View, String> entry : ((Extras) extras).getSharedElements().entrySet()) {
                        beginTransaction.addSharedElement(entry.getKey(), entry.getValue());
                    }
                }
                beginTransaction.setReorderingAllowed(true);
                beginTransaction.commit();
                if (z16) {
                    return null;
                }
                this.mBackStack.add(Integer.valueOf(id5));
                return destination;
            }
            beginTransaction.addToBackStack(generateBackStackName(this.mBackStack.size() + 1, id5));
        }
        z16 = true;
        if (extras instanceof Extras) {
        }
        beginTransaction.setReorderingAllowed(true);
        beginTransaction.commit();
        if (z16) {
        }
    }
}
