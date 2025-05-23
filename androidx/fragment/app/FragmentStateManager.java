package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class FragmentStateManager {
    private static final String TAG = "FragmentManager";
    private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final String TARGET_STATE_TAG = "android:target_state";
    private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final String VIEW_REGISTRY_STATE_TAG = "android:view_registry_state";
    private static final String VIEW_STATE_TAG = "android:view_state";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;

    @NonNull
    private final Fragment mFragment;
    private final FragmentStore mFragmentStore;
    private boolean mMovingToState = false;
    private int mFragmentManagerState = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: androidx.fragment.app.FragmentStateManager$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull Fragment fragment) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
    }

    private boolean isFragmentViewChild(@NonNull View view) {
        if (view == this.mFragment.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.mFragment.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle saveBasicState() {
        Bundle bundle = new Bundle();
        this.mFragment.performSaveInstanceState(bundle);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.mFragment.mView != null) {
            saveViewState();
        }
        if (this.mFragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, this.mFragment.mSavedViewState);
        }
        if (this.mFragment.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle(VIEW_REGISTRY_STATE_TAG, this.mFragment.mSavedViewRegistryState);
        }
        if (!this.mFragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, this.mFragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto ACTIVITY_CREATED: " + this.mFragment);
        }
        Fragment fragment = this.mFragment;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        Fragment fragment2 = this.mFragment;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addViewToContainer() {
        int findFragmentIndexInContainer = this.mFragmentStore.findFragmentIndexInContainer(this.mFragment);
        Fragment fragment = this.mFragment;
        fragment.mContainer.addView(fragment.mView, findFragmentIndexInContainer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attach() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto ATTACHED: " + this.mFragment);
        }
        Fragment fragment = this.mFragment;
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManager = null;
        if (fragment2 != null) {
            FragmentStateManager fragmentStateManager2 = this.mFragmentStore.getFragmentStateManager(fragment2.mWho);
            if (fragmentStateManager2 != null) {
                Fragment fragment3 = this.mFragment;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                fragmentStateManager = fragmentStateManager2;
            } else {
                throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManager = this.mFragmentStore.getFragmentStateManager(str)) == null) {
                throw new IllegalStateException("Fragment " + this.mFragment + " declared target fragment " + this.mFragment.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (fragmentStateManager != null && (FragmentManager.USE_STATE_MANAGER || fragmentStateManager.getFragment().mState < 1)) {
            fragmentStateManager.moveToExpectedState();
        }
        Fragment fragment4 = this.mFragment;
        fragment4.mHost = fragment4.mFragmentManager.getHost();
        Fragment fragment5 = this.mFragment;
        fragment5.mParentFragment = fragment5.mFragmentManager.getParent();
        this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, false);
        this.mFragment.performAttach();
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int computeExpectedState() {
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact;
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.mFragment;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i3 = this.mFragmentManagerState;
        int i16 = AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$State[fragment2.mMaxState.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        i3 = Math.min(i3, -1);
                    } else {
                        i3 = Math.min(i3, 0);
                    }
                } else {
                    i3 = Math.min(i3, 1);
                }
            } else {
                i3 = Math.min(i3, 5);
            }
        }
        Fragment fragment3 = this.mFragment;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i3 = Math.max(this.mFragmentManagerState, 2);
                View view = this.mFragment.mView;
                if (view != null && view.getParent() == null) {
                    i3 = Math.min(i3, 2);
                }
            } else {
                i3 = this.mFragmentManagerState < 4 ? Math.min(i3, fragment3.mState) : Math.min(i3, 1);
            }
        }
        if (!this.mFragment.mAdded) {
            i3 = Math.min(i3, 1);
        }
        if (FragmentManager.USE_STATE_MANAGER && (viewGroup = (fragment = this.mFragment).mContainer) != null) {
            lifecycleImpact = SpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager()).getAwaitingCompletionLifecycleImpact(this);
        } else {
            lifecycleImpact = null;
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i3 = Math.min(i3, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i3 = Math.max(i3, 3);
        } else {
            Fragment fragment4 = this.mFragment;
            if (fragment4.mRemoving) {
                if (fragment4.isInBackStack()) {
                    i3 = Math.min(i3, 1);
                } else {
                    i3 = Math.min(i3, -1);
                }
            }
        }
        Fragment fragment5 = this.mFragment;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i3 = Math.min(i3, 4);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(TAG, "computeExpectedState() of " + i3 + " for " + this.mFragment);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void create() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto CREATED: " + this.mFragment);
        }
        Fragment fragment = this.mFragment;
        if (!fragment.mIsCreated) {
            this.mDispatcher.dispatchOnFragmentPreCreated(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.mFragment;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
            Fragment fragment3 = this.mFragment;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.mFragment.mState = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createView() {
        String str;
        if (this.mFragment.mFromLayout) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto CREATE_VIEW: " + this.mFragment);
        }
        Fragment fragment = this.mFragment;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        Fragment fragment2 = this.mFragment;
        ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup == null) {
            int i3 = fragment2.mContainerId;
            if (i3 != 0) {
                if (i3 != -1) {
                    viewGroup = (ViewGroup) fragment2.mFragmentManager.getContainer().onFindViewById(this.mFragment.mContainerId);
                    if (viewGroup == null) {
                        Fragment fragment3 = this.mFragment;
                        if (!fragment3.mRestored) {
                            try {
                                str = fragment3.getResources().getResourceName(this.mFragment.mContainerId);
                            } catch (Resources.NotFoundException unused) {
                                str = "unknown";
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + str + ") for fragment " + this.mFragment);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
                }
            } else {
                viewGroup = null;
            }
        }
        Fragment fragment4 = this.mFragment;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.mFragment.mView;
        if (view != null) {
            boolean z16 = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.mFragment;
            fragment5.mView.setTag(R.id.ve5, fragment5);
            if (viewGroup != null) {
                addViewToContainer();
            }
            Fragment fragment6 = this.mFragment;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (ViewCompat.isAttachedToWindow(this.mFragment.mView)) {
                ViewCompat.requestApplyInsets(this.mFragment.mView);
            } else {
                final View view2 = this.mFragment.mView;
                view2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentStateManager.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view3) {
                        view2.removeOnAttachStateChangeListener(this);
                        ViewCompat.requestApplyInsets(view2);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view3) {
                    }
                });
            }
            this.mFragment.performViewCreated();
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
            Fragment fragment7 = this.mFragment;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.mFragment.mView.getVisibility();
            float alpha = this.mFragment.mView.getAlpha();
            if (FragmentManager.USE_STATE_MANAGER) {
                this.mFragment.setPostOnViewCreatedAlpha(alpha);
                Fragment fragment8 = this.mFragment;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.mFragment.setFocusedView(findFocus);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(TAG, "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.mFragment);
                        }
                    }
                    this.mFragment.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.mFragment;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z16 = true;
                }
                fragment9.mIsNewlyAdded = z16;
            }
        }
        this.mFragment.mState = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        boolean z16;
        boolean z17;
        Fragment findActiveFragment;
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "movefrom CREATED: " + this.mFragment);
        }
        Fragment fragment = this.mFragment;
        boolean z18 = true;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            FragmentHostCallback<?> fragmentHostCallback = this.mFragment.mHost;
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z18 = this.mFragmentStore.getNonConfig().isCleared();
            } else if (fragmentHostCallback.getContext() instanceof Activity) {
                z18 = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
            }
            if (z16 || z18) {
                this.mFragmentStore.getNonConfig().clearNonConfigState(this.mFragment);
            }
            this.mFragment.performDestroy();
            this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
            for (FragmentStateManager fragmentStateManager : this.mFragmentStore.getActiveFragmentStateManagers()) {
                if (fragmentStateManager != null) {
                    Fragment fragment2 = fragmentStateManager.getFragment();
                    if (this.mFragment.mWho.equals(fragment2.mTargetWho)) {
                        fragment2.mTarget = this.mFragment;
                        fragment2.mTargetWho = null;
                    }
                }
            }
            Fragment fragment3 = this.mFragment;
            String str = fragment3.mTargetWho;
            if (str != null) {
                fragment3.mTarget = this.mFragmentStore.findActiveFragment(str);
            }
            this.mFragmentStore.makeInactive(this);
            return;
        }
        String str2 = this.mFragment.mTargetWho;
        if (str2 != null && (findActiveFragment = this.mFragmentStore.findActiveFragment(str2)) != null && findActiveFragment.mRetainInstance) {
            this.mFragment.mTarget = findActiveFragment;
        }
        this.mFragment.mState = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroyFragmentView() {
        View view;
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "movefrom CREATE_VIEW: " + this.mFragment);
        }
        Fragment fragment = this.mFragment;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.mFragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(this.mFragment, false);
        Fragment fragment2 = this.mFragment;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.setValue(null);
        this.mFragment.mInLayout = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detach() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "movefrom ATTACHED: " + this.mFragment);
        }
        this.mFragment.performDetach();
        boolean z16 = false;
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        Fragment fragment = this.mFragment;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z16 = true;
        }
        if (z16 || this.mFragmentStore.getNonConfig().shouldDestroy(this.mFragment)) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(TAG, "initState called for fragment: " + this.mFragment);
            }
            this.mFragment.initState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureInflatedView() {
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d(TAG, "moveto CREATE_VIEW: " + this.mFragment);
            }
            Fragment fragment2 = this.mFragment;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
            View view = this.mFragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.mFragment;
                fragment3.mView.setTag(R.id.ve5, fragment3);
                Fragment fragment4 = this.mFragment;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.mFragment.performViewCreated();
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
                Fragment fragment5 = this.mFragment;
                fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.mFragment.mState = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Fragment getFragment() {
        return this.mFragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void moveToExpectedState() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.mMovingToState) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(TAG, "Ignoring re-entrant call to moveToExpectedState() for " + getFragment());
                return;
            }
            return;
        }
        try {
            this.mMovingToState = true;
            while (true) {
                int computeExpectedState = computeExpectedState();
                Fragment fragment = this.mFragment;
                int i3 = fragment.mState;
                if (computeExpectedState != i3) {
                    if (computeExpectedState > i3) {
                        switch (i3 + 1) {
                            case 0:
                                attach();
                                break;
                            case 1:
                                create();
                                break;
                            case 2:
                                ensureInflatedView();
                                createView();
                                break;
                            case 3:
                                activityCreated();
                                break;
                            case 4:
                                if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                    SpecialEffectsController.getOrCreateController(viewGroup2, fragment.getParentFragmentManager()).enqueueAdd(SpecialEffectsController.Operation.State.from(this.mFragment.mView.getVisibility()), this);
                                }
                                this.mFragment.mState = 4;
                                break;
                            case 5:
                                start();
                                break;
                            case 6:
                                fragment.mState = 6;
                                break;
                            case 7:
                                resume();
                                break;
                        }
                    } else {
                        switch (i3 - 1) {
                            case -1:
                                detach();
                                break;
                            case 0:
                                destroy();
                                break;
                            case 1:
                                destroyFragmentView();
                                this.mFragment.mState = 1;
                                break;
                            case 2:
                                fragment.mInLayout = false;
                                fragment.mState = 2;
                                break;
                            case 3:
                                if (FragmentManager.isLoggingEnabled(3)) {
                                    Log.d(TAG, "movefrom ACTIVITY_CREATED: " + this.mFragment);
                                }
                                Fragment fragment2 = this.mFragment;
                                if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                    saveViewState();
                                }
                                Fragment fragment3 = this.mFragment;
                                if (fragment3.mView != null && (viewGroup3 = fragment3.mContainer) != null) {
                                    SpecialEffectsController.getOrCreateController(viewGroup3, fragment3.getParentFragmentManager()).enqueueRemove(this);
                                }
                                this.mFragment.mState = 3;
                                break;
                            case 4:
                                stop();
                                break;
                            case 5:
                                fragment.mState = 5;
                                break;
                            case 6:
                                pause();
                                break;
                        }
                    }
                } else {
                    if (FragmentManager.USE_STATE_MANAGER && fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            SpecialEffectsController orCreateController = SpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
                            if (this.mFragment.mHidden) {
                                orCreateController.enqueueHide(this);
                            } else {
                                orCreateController.enqueueShow(this);
                            }
                        }
                        Fragment fragment4 = this.mFragment;
                        FragmentManager fragmentManager = fragment4.mFragmentManager;
                        if (fragmentManager != null) {
                            fragmentManager.invalidateMenuForFragment(fragment4);
                        }
                        Fragment fragment5 = this.mFragment;
                        fragment5.mHiddenChanged = false;
                        fragment5.onHiddenChanged(fragment5.mHidden);
                    }
                    return;
                }
            }
        } finally {
            this.mMovingToState = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "movefrom RESUMED: " + this.mFragment);
        }
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restoreState(@NonNull ClassLoader classLoader) {
        Bundle bundle = this.mFragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.mFragment;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
        Fragment fragment2 = this.mFragment;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle(VIEW_REGISTRY_STATE_TAG);
        Fragment fragment3 = this.mFragment;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString(TARGET_STATE_TAG);
        Fragment fragment4 = this.mFragment;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
        }
        Fragment fragment5 = this.mFragment;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.mFragment.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
        }
        Fragment fragment6 = this.mFragment;
        if (!fragment6.mUserVisibleHint) {
            fragment6.mDeferStart = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        String str;
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto RESUMED: " + this.mFragment);
        }
        View focusedView = this.mFragment.getFocusedView();
        if (focusedView != null && isFragmentViewChild(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("requestFocus: Restoring focused view ");
                sb5.append(focusedView);
                sb5.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = "failed";
                }
                sb5.append(str);
                sb5.append(" on Fragment ");
                sb5.append(this.mFragment);
                sb5.append(" resulting in focused view ");
                sb5.append(this.mFragment.mView.findFocus());
                Log.v(TAG, sb5.toString());
            }
        }
        this.mFragment.setFocusedView(null);
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        Fragment fragment = this.mFragment;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Fragment.SavedState saveInstanceState() {
        Bundle saveBasicState;
        if (this.mFragment.mState <= -1 || (saveBasicState = saveBasicState()) == null) {
            return null;
        }
        return new Fragment.SavedState(saveBasicState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public FragmentState saveState() {
        FragmentState fragmentState = new FragmentState(this.mFragment);
        Fragment fragment = this.mFragment;
        if (fragment.mState > -1 && fragmentState.mSavedFragmentState == null) {
            Bundle saveBasicState = saveBasicState();
            fragmentState.mSavedFragmentState = saveBasicState;
            if (this.mFragment.mTargetWho != null) {
                if (saveBasicState == null) {
                    fragmentState.mSavedFragmentState = new Bundle();
                }
                fragmentState.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
                int i3 = this.mFragment.mTargetRequestCode;
                if (i3 != 0) {
                    fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, i3);
                }
            }
        } else {
            fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
        }
        return fragmentState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void saveViewState() {
        if (this.mFragment.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.mFragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.mFragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.mFragment.mViewLifecycleOwner.performSave(bundle);
        if (!bundle.isEmpty()) {
            this.mFragment.mSavedViewRegistryState = bundle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFragmentManagerState(int i3) {
        this.mFragmentManagerState = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "moveto STARTED: " + this.mFragment);
        }
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(TAG, "movefrom STARTED: " + this.mFragment);
        }
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory, @NonNull FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        Fragment instantiate = fragmentFactory.instantiate(classLoader, fragmentState.mClassName);
        this.mFragment = instantiate;
        Bundle bundle = fragmentState.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(fragmentState.mArguments);
        instantiate.mWho = fragmentState.mWho;
        instantiate.mFromLayout = fragmentState.mFromLayout;
        instantiate.mRestored = true;
        instantiate.mFragmentId = fragmentState.mFragmentId;
        instantiate.mContainerId = fragmentState.mContainerId;
        instantiate.mTag = fragmentState.mTag;
        instantiate.mRetainInstance = fragmentState.mRetainInstance;
        instantiate.mRemoving = fragmentState.mRemoving;
        instantiate.mDetached = fragmentState.mDetached;
        instantiate.mHidden = fragmentState.mHidden;
        instantiate.mMaxState = Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        Bundle bundle2 = fragmentState.mSavedFragmentState;
        if (bundle2 != null) {
            instantiate.mSavedFragmentState = bundle2;
        } else {
            instantiate.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(TAG, "Instantiated fragment " + instantiate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull FragmentStore fragmentStore, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.mSavedFragmentState;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
