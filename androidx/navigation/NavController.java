package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class NavController {
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";

    @NonNull
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private Activity mActivity;
    private Parcelable[] mBackStackToRestore;
    private final Context mContext;
    private boolean mDeepLinkHandled;
    NavGraph mGraph;
    private NavInflater mInflater;
    private LifecycleOwner mLifecycleOwner;
    private Bundle mNavigatorStateToRestore;
    private NavControllerViewModel mViewModel;
    final Deque<NavBackStackEntry> mBackStack = new ArrayDeque();
    private NavigatorProvider mNavigatorProvider = new NavigatorProvider();
    private final CopyOnWriteArrayList<OnDestinationChangedListener> mOnDestinationChangedListeners = new CopyOnWriteArrayList<>();
    private final LifecycleObserver mLifecycleObserver = new LifecycleEventObserver() { // from class: androidx.navigation.NavController.1
        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            NavController navController = NavController.this;
            if (navController.mGraph != null) {
                Iterator<NavBackStackEntry> it = navController.mBackStack.iterator();
                while (it.hasNext()) {
                    it.next().handleLifecycleEvent(event);
                }
            }
        }
    };
    private final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(false) { // from class: androidx.navigation.NavController.2
        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            NavController.this.popBackStack();
        }
    };
    private boolean mEnableOnBackPressedCallback = true;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnDestinationChangedListener {
        void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle);
    }

    public NavController(@NonNull Context context) {
        this.mContext = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof Activity) {
                this.mActivity = (Activity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        NavigatorProvider navigatorProvider = this.mNavigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this.mNavigatorProvider.addNavigator(new ActivityNavigator(this.mContext));
    }

    private boolean dispatchOnDestinationChanged() {
        NavDestination navDestination;
        while (!this.mBackStack.isEmpty() && (this.mBackStack.peekLast().getDestination() instanceof NavGraph) && popBackStackInternal(this.mBackStack.peekLast().getDestination().getId(), true)) {
        }
        if (!this.mBackStack.isEmpty()) {
            NavDestination destination = this.mBackStack.peekLast().getDestination();
            if (destination instanceof FloatingWindow) {
                Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
                while (descendingIterator.hasNext()) {
                    navDestination = descendingIterator.next().getDestination();
                    if (!(navDestination instanceof NavGraph) && !(navDestination instanceof FloatingWindow)) {
                        break;
                    }
                }
            }
            navDestination = null;
            HashMap hashMap = new HashMap();
            Iterator<NavBackStackEntry> descendingIterator2 = this.mBackStack.descendingIterator();
            while (descendingIterator2.hasNext()) {
                NavBackStackEntry next = descendingIterator2.next();
                Lifecycle.State maxLifecycle = next.getMaxLifecycle();
                NavDestination destination2 = next.getDestination();
                if (destination != null && destination2.getId() == destination.getId()) {
                    Lifecycle.State state = Lifecycle.State.RESUMED;
                    if (maxLifecycle != state) {
                        hashMap.put(next, state);
                    }
                    destination = destination.getParent();
                } else if (navDestination != null && destination2.getId() == navDestination.getId()) {
                    if (maxLifecycle == Lifecycle.State.RESUMED) {
                        next.setMaxLifecycle(Lifecycle.State.STARTED);
                    } else {
                        Lifecycle.State state2 = Lifecycle.State.STARTED;
                        if (maxLifecycle != state2) {
                            hashMap.put(next, state2);
                        }
                    }
                    navDestination = navDestination.getParent();
                } else {
                    next.setMaxLifecycle(Lifecycle.State.CREATED);
                }
            }
            for (NavBackStackEntry navBackStackEntry : this.mBackStack) {
                Lifecycle.State state3 = (Lifecycle.State) hashMap.get(navBackStackEntry);
                if (state3 != null) {
                    navBackStackEntry.setMaxLifecycle(state3);
                } else {
                    navBackStackEntry.updateState();
                }
            }
            NavBackStackEntry peekLast = this.mBackStack.peekLast();
            Iterator<OnDestinationChangedListener> it = this.mOnDestinationChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
            }
            return true;
        }
        return false;
    }

    @Nullable
    private String findInvalidDestinationDisplayNameInDeepLink(@NonNull int[] iArr) {
        NavGraph navGraph;
        NavGraph navGraph2 = this.mGraph;
        int i3 = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i3 >= iArr.length) {
                return null;
            }
            int i16 = iArr[i3];
            if (i3 == 0) {
                if (this.mGraph.getId() == i16) {
                    navDestination = this.mGraph;
                }
            } else {
                navDestination = navGraph2.findNode(i16);
            }
            if (navDestination == null) {
                return NavDestination.getDisplayName(this.mContext, i16);
            }
            if (i3 != iArr.length - 1) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.findNode(navGraph.getStartDestination());
                }
                navGraph2 = navGraph;
            }
            i3++;
        }
    }

    private int getDestinationCountOnBackStack() {
        Iterator<NavBackStackEntry> it = this.mBackStack.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (!(it.next().getDestination() instanceof NavGraph)) {
                i3++;
            }
        }
        return i3;
    }

    private void onGraphCreated(@Nullable Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.mNavigatorStateToRestore;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES)) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Navigator navigator = this.mNavigatorProvider.getNavigator(next);
                Bundle bundle3 = this.mNavigatorStateToRestore.getBundle(next);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.mBackStackToRestore;
        boolean z16 = false;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination findDestination = findDestination(navBackStackEntryState.getDestinationId());
                if (findDestination != null) {
                    Bundle args = navBackStackEntryState.getArgs();
                    if (args != null) {
                        args.setClassLoader(this.mContext.getClassLoader());
                    }
                    this.mBackStack.add(new NavBackStackEntry(this.mContext, findDestination, args, this.mLifecycleOwner, this.mViewModel, navBackStackEntryState.getUUID(), navBackStackEntryState.getSavedState()));
                } else {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.getDisplayName(this.mContext, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.mBackStackToRestore = null;
        }
        if (this.mGraph != null && this.mBackStack.isEmpty()) {
            if (!this.mDeepLinkHandled && (activity = this.mActivity) != null && handleDeepLink(activity.getIntent())) {
                z16 = true;
            }
            if (!z16) {
                navigate(this.mGraph, bundle, (NavOptions) null, (Navigator.Extras) null);
                return;
            }
            return;
        }
        dispatchOnDestinationChanged();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (getDestinationCountOnBackStack() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateOnBackPressedCallbackEnabled() {
        boolean z16;
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (this.mEnableOnBackPressedCallback) {
            z16 = true;
        }
        z16 = false;
        onBackPressedCallback.setEnabled(z16);
    }

    public void addOnDestinationChangedListener(@NonNull OnDestinationChangedListener onDestinationChangedListener) {
        if (!this.mBackStack.isEmpty()) {
            NavBackStackEntry peekLast = this.mBackStack.peekLast();
            onDestinationChangedListener.onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        this.mOnDestinationChangedListeners.add(onDestinationChangedListener);
    }

    @NonNull
    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enableOnBackPressed(boolean z16) {
        this.mEnableOnBackPressedCallback = z16;
        updateOnBackPressedCallbackEnabled();
    }

    NavDestination findDestination(@IdRes int i3) {
        NavGraph destination;
        NavGraph parent;
        NavGraph navGraph = this.mGraph;
        if (navGraph == null) {
            return null;
        }
        if (navGraph.getId() == i3) {
            return this.mGraph;
        }
        if (this.mBackStack.isEmpty()) {
            destination = this.mGraph;
        } else {
            destination = this.mBackStack.getLast().getDestination();
        }
        if (destination instanceof NavGraph) {
            parent = destination;
        } else {
            parent = destination.getParent();
        }
        return parent.findNode(i3);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Deque<NavBackStackEntry> getBackStack() {
        return this.mBackStack;
    }

    @NonNull
    public NavBackStackEntry getBackStackEntry(@IdRes int i3) {
        NavBackStackEntry navBackStackEntry;
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        while (true) {
            if (descendingIterator.hasNext()) {
                navBackStackEntry = descendingIterator.next();
                if (navBackStackEntry.getDestination().getId() == i3) {
                    break;
                }
            } else {
                navBackStackEntry = null;
                break;
            }
        }
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException("No destination with ID " + i3 + " is on the NavController's back stack");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public NavBackStackEntry getCurrentBackStackEntry() {
        if (this.mBackStack.isEmpty()) {
            return null;
        }
        return this.mBackStack.getLast();
    }

    @Nullable
    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    @NonNull
    public NavGraph getGraph() {
        NavGraph navGraph = this.mGraph;
        if (navGraph != null) {
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    @NonNull
    public NavInflater getNavInflater() {
        if (this.mInflater == null) {
            this.mInflater = new NavInflater(this.mContext, this.mNavigatorProvider);
        }
        return this.mInflater;
    }

    @NonNull
    public NavigatorProvider getNavigatorProvider() {
        return this.mNavigatorProvider;
    }

    @Nullable
    public NavBackStackEntry getPreviousBackStackEntry() {
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        if (descendingIterator.hasNext()) {
            descendingIterator.next();
        }
        while (descendingIterator.hasNext()) {
            NavBackStackEntry next = descendingIterator.next();
            if (!(next.getDestination() instanceof NavGraph)) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    public ViewModelStoreOwner getViewModelStoreOwner(@IdRes int i3) {
        if (this.mViewModel != null) {
            NavBackStackEntry backStackEntry = getBackStackEntry(i3);
            if (backStackEntry.getDestination() instanceof NavGraph) {
                return backStackEntry;
            }
            throw new IllegalArgumentException("No NavGraph with ID " + i3 + " is on the NavController's back stack");
        }
        throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
    }

    public boolean handleDeepLink(@Nullable Intent intent) {
        int[] iArr;
        Bundle bundle;
        NavDestination.DeepLinkMatch matchDeepLink;
        NavDestination findNode;
        NavGraph navGraph;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            iArr = extras.getIntArray(KEY_DEEP_LINK_IDS);
        } else {
            iArr = null;
        }
        Bundle bundle2 = new Bundle();
        if (extras != null) {
            bundle = extras.getBundle(KEY_DEEP_LINK_EXTRAS);
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if ((iArr == null || iArr.length == 0) && intent.getData() != null && (matchDeepLink = this.mGraph.matchDeepLink(new NavDeepLinkRequest(intent))) != null) {
            iArr = matchDeepLink.getDestination().buildDeepLinkIds();
            bundle2.putAll(matchDeepLink.getMatchingArgs());
        }
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        String findInvalidDestinationDisplayNameInDeepLink = findInvalidDestinationDisplayNameInDeepLink(iArr);
        if (findInvalidDestinationDisplayNameInDeepLink != null) {
            Log.i(TAG, "Could not find destination " + findInvalidDestinationDisplayNameInDeepLink + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle2.putParcelable(KEY_DEEP_LINK_INTENT, intent);
        int flags = intent.getFlags();
        int i3 = 268435456 & flags;
        if (i3 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            TaskStackBuilder.create(this.mContext).addNextIntentWithParentStack(intent).startActivities();
            Activity activity = this.mActivity;
            if (activity != null) {
                activity.finish();
                this.mActivity.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (i3 != 0) {
            if (!this.mBackStack.isEmpty()) {
                popBackStackInternal(this.mGraph.getId(), true);
            }
            int i16 = 0;
            while (i16 < iArr.length) {
                int i17 = i16 + 1;
                int i18 = iArr[i16];
                NavDestination findDestination = findDestination(i18);
                if (findDestination != null) {
                    navigate(findDestination, bundle2, new NavOptions.Builder().setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
                    i16 = i17;
                } else {
                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.getDisplayName(this.mContext, i18) + " cannot be found from the current destination " + getCurrentDestination());
                }
            }
            return true;
        }
        NavGraph navGraph2 = this.mGraph;
        for (int i19 = 0; i19 < iArr.length; i19++) {
            int i26 = iArr[i19];
            if (i19 == 0) {
                findNode = this.mGraph;
            } else {
                findNode = navGraph2.findNode(i26);
            }
            if (findNode != null) {
                if (i19 != iArr.length - 1) {
                    while (true) {
                        navGraph = (NavGraph) findNode;
                        if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                            break;
                        }
                        findNode = navGraph.findNode(navGraph.getStartDestination());
                    }
                    navGraph2 = navGraph;
                } else {
                    navigate(findNode, findNode.addInDefaultArgs(bundle2), new NavOptions.Builder().setPopUpTo(this.mGraph.getId(), true).setEnterAnim(0).setExitAnim(0).build(), (Navigator.Extras) null);
                }
            } else {
                throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.getDisplayName(this.mContext, i26) + " cannot be found in graph " + navGraph2);
            }
        }
        this.mDeepLinkHandled = true;
        return true;
    }

    public void navigate(@IdRes int i3) {
        navigate(i3, (Bundle) null);
    }

    public boolean navigateUp() {
        if (getDestinationCountOnBackStack() == 1) {
            NavDestination currentDestination = getCurrentDestination();
            int id5 = currentDestination.getId();
            for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
                if (parent.getStartDestination() != id5) {
                    Bundle bundle = new Bundle();
                    Activity activity = this.mActivity;
                    if (activity != null && activity.getIntent() != null && this.mActivity.getIntent().getData() != null) {
                        bundle.putParcelable(KEY_DEEP_LINK_INTENT, this.mActivity.getIntent());
                        NavDestination.DeepLinkMatch matchDeepLink = this.mGraph.matchDeepLink(new NavDeepLinkRequest(this.mActivity.getIntent()));
                        if (matchDeepLink != null) {
                            bundle.putAll(matchDeepLink.getMatchingArgs());
                        }
                    }
                    new NavDeepLinkBuilder(this).setDestination(parent.getId()).setArguments(bundle).createTaskStackBuilder().startActivities();
                    Activity activity2 = this.mActivity;
                    if (activity2 != null) {
                        activity2.finish();
                    }
                    return true;
                }
                id5 = parent.getId();
            }
            return false;
        }
        return popBackStack();
    }

    public boolean popBackStack() {
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        return popBackStack(getCurrentDestination().getId(), true);
    }

    boolean popBackStackInternal(@IdRes int i3, boolean z16) {
        boolean z17;
        boolean z18 = false;
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        while (true) {
            if (descendingIterator.hasNext()) {
                NavDestination destination = descendingIterator.next().getDestination();
                Navigator navigator = this.mNavigatorProvider.getNavigator(destination.getNavigatorName());
                if (z16 || destination.getId() != i3) {
                    arrayList.add(navigator);
                }
                if (destination.getId() == i3) {
                    z17 = true;
                    break;
                }
            } else {
                z17 = false;
                break;
            }
        }
        if (!z17) {
            Log.i(TAG, "Ignoring popBackStack to destination " + NavDestination.getDisplayName(this.mContext, i3) + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((Navigator) it.next()).popBackStack()) {
            NavBackStackEntry removeLast = this.mBackStack.removeLast();
            removeLast.setMaxLifecycle(Lifecycle.State.DESTROYED);
            NavControllerViewModel navControllerViewModel = this.mViewModel;
            if (navControllerViewModel != null) {
                navControllerViewModel.clear(removeLast.mId);
            }
            z18 = true;
        }
        updateOnBackPressedCallbackEnabled();
        return z18;
    }

    public void removeOnDestinationChangedListener(@NonNull OnDestinationChangedListener onDestinationChangedListener) {
        this.mOnDestinationChangedListeners.remove(onDestinationChangedListener);
    }

    @CallSuper
    public void restoreState(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.mContext.getClassLoader());
        this.mNavigatorStateToRestore = bundle.getBundle(KEY_NAVIGATOR_STATE);
        this.mBackStackToRestore = bundle.getParcelableArray(KEY_BACK_STACK);
        this.mDeepLinkHandled = bundle.getBoolean(KEY_DEEP_LINK_HANDLED);
    }

    @Nullable
    @CallSuper
    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this.mNavigatorProvider.getNavigators().entrySet()) {
            String key = entry.getKey();
            Bundle onSaveState = entry.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, onSaveState);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        } else {
            bundle = null;
        }
        if (!this.mBackStack.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.mBackStack.size()];
            Iterator<NavBackStackEntry> it = this.mBackStack.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                parcelableArr[i3] = new NavBackStackEntryState(it.next());
                i3++;
            }
            bundle.putParcelableArray(KEY_BACK_STACK, parcelableArr);
        }
        if (this.mDeepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(KEY_DEEP_LINK_HANDLED, this.mDeepLinkHandled);
        }
        return bundle;
    }

    @CallSuper
    public void setGraph(@NavigationRes int i3) {
        setGraph(i3, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this.mLifecycleObserver);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setNavigatorProvider(@NonNull NavigatorProvider navigatorProvider) {
        if (this.mBackStack.isEmpty()) {
            this.mNavigatorProvider = navigatorProvider;
            return;
        }
        throw new IllegalStateException("NavigatorProvider must be set before setGraph call");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnBackPressedDispatcher(@NonNull OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.mLifecycleOwner != null) {
            this.mOnBackPressedCallback.remove();
            onBackPressedDispatcher.addCallback(this.mLifecycleOwner, this.mOnBackPressedCallback);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setViewModelStore(@NonNull ViewModelStore viewModelStore) {
        if (this.mBackStack.isEmpty()) {
            this.mViewModel = NavControllerViewModel.getInstance(viewModelStore);
            return;
        }
        throw new IllegalStateException("ViewModelStore should be set before setGraph call");
    }

    public void navigate(@IdRes int i3, @Nullable Bundle bundle) {
        navigate(i3, bundle, (NavOptions) null);
    }

    @CallSuper
    public void setGraph(@NavigationRes int i3, @Nullable Bundle bundle) {
        setGraph(getNavInflater().inflate(i3), bundle);
    }

    public void navigate(@IdRes int i3, @Nullable Bundle bundle, @Nullable NavOptions navOptions) {
        navigate(i3, bundle, navOptions, (Navigator.Extras) null);
    }

    public boolean popBackStack(@IdRes int i3, boolean z16) {
        return popBackStackInternal(i3, z16) && dispatchOnDestinationChanged();
    }

    @CallSuper
    public void setGraph(@NonNull NavGraph navGraph) {
        setGraph(navGraph, (Bundle) null);
    }

    public void navigate(@IdRes int i3, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination destination;
        int i16;
        if (this.mBackStack.isEmpty()) {
            destination = this.mGraph;
        } else {
            destination = this.mBackStack.getLast().getDestination();
        }
        if (destination != null) {
            NavAction action = destination.getAction(i3);
            Bundle bundle2 = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                i16 = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(defaultArguments);
                }
            } else {
                i16 = i3;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i16 == 0 && navOptions != null && navOptions.getPopUpTo() != -1) {
                popBackStack(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
                return;
            }
            if (i16 != 0) {
                NavDestination findDestination = findDestination(i16);
                if (findDestination == null) {
                    String displayName = NavDestination.getDisplayName(this.mContext, i16);
                    if (action != null) {
                        throw new IllegalArgumentException("Navigation destination " + displayName + " referenced from action " + NavDestination.getDisplayName(this.mContext, i3) + " cannot be found from the current destination " + destination);
                    }
                    throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + destination);
                }
                navigate(findDestination, bundle2, navOptions, extras);
                return;
            }
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        throw new IllegalStateException("no current navigation node");
    }

    @CallSuper
    public void setGraph(@NonNull NavGraph navGraph, @Nullable Bundle bundle) {
        NavGraph navGraph2 = this.mGraph;
        if (navGraph2 != null) {
            popBackStackInternal(navGraph2.getId(), true);
        }
        this.mGraph = navGraph;
        onGraphCreated(bundle);
    }

    public void navigate(@NonNull Uri uri) {
        navigate(new NavDeepLinkRequest(uri, null, null));
    }

    public void navigate(@NonNull Uri uri, @Nullable NavOptions navOptions) {
        navigate(new NavDeepLinkRequest(uri, null, null), navOptions);
    }

    public void navigate(@NonNull Uri uri, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        navigate(new NavDeepLinkRequest(uri, null, null), navOptions, extras);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        navigate(navDeepLinkRequest, (NavOptions) null);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest, @Nullable NavOptions navOptions) {
        navigate(navDeepLinkRequest, navOptions, (Navigator.Extras) null);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination.DeepLinkMatch matchDeepLink = this.mGraph.matchDeepLink(navDeepLinkRequest);
        if (matchDeepLink != null) {
            navigate(matchDeepLink.getDestination(), matchDeepLink.getMatchingArgs(), navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + navDeepLinkRequest + " cannot be found in the navigation graph " + this.mGraph);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r10.mBackStack.isEmpty() != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if ((r10.mBackStack.peekLast().getDestination() instanceof androidx.navigation.FloatingWindow) == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        if (popBackStackInternal(r10.mBackStack.peekLast().getDestination().getId(), true) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
    
        if (r10.mBackStack.isEmpty() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
    
        r10.mBackStack.add(new androidx.navigation.NavBackStackEntry(r10.mContext, r10.mGraph, r9, r10.mLifecycleOwner, r10.mViewModel));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
    
        r12 = new java.util.ArrayDeque();
        r13 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
    
        if (r13 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
    
        if (findDestination(r13.getId()) != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:
    
        r13 = r13.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
    
        if (r13 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
    
        r12.addFirst(new androidx.navigation.NavBackStackEntry(r10.mContext, r13, r9, r10.mLifecycleOwner, r10.mViewModel));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a6, code lost:
    
        r10.mBackStack.addAll(r12);
        r10.mBackStack.add(new androidx.navigation.NavBackStackEntry(r10.mContext, r11, r11.addInDefaultArgs(r9), r10.mLifecycleOwner, r10.mViewModel));
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
    
        if ((r11 instanceof androidx.navigation.FloatingWindow) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void navigate(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        boolean z16 = false;
        boolean popBackStackInternal = (navOptions == null || navOptions.getPopUpTo() == -1) ? false : popBackStackInternal(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
        Navigator navigator = this.mNavigatorProvider.getNavigator(navDestination.getNavigatorName());
        Bundle addInDefaultArgs = navDestination.addInDefaultArgs(bundle);
        NavDestination navigate = navigator.navigate(navDestination, addInDefaultArgs, navOptions, extras);
        if (navigate == null) {
            if (navOptions != null && navOptions.shouldLaunchSingleTop()) {
                NavBackStackEntry peekLast = this.mBackStack.peekLast();
                if (peekLast != null) {
                    peekLast.replaceArguments(bundle);
                }
                z16 = true;
            }
        }
        updateOnBackPressedCallbackEnabled();
        if (popBackStackInternal || navigate != null || z16) {
            dispatchOnDestinationChanged();
        }
    }

    public void navigate(@NonNull NavDirections navDirections) {
        navigate(navDirections.getActionId(), navDirections.getArguments());
    }

    public void navigate(@NonNull NavDirections navDirections, @Nullable NavOptions navOptions) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    public void navigate(@NonNull NavDirections navDirections, @NonNull Navigator.Extras extras) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null, extras);
    }
}
