package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;

/* compiled from: P */
/* loaded from: classes.dex */
public class NavHostFragment extends ReportAndroidXFragment implements NavHost {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_DEFAULT_NAV_HOST = "android-support-nav:fragment:defaultHost";
    private static final String KEY_GRAPH_ID = "android-support-nav:fragment:graphId";
    private static final String KEY_NAV_CONTROLLER_STATE = "android-support-nav:fragment:navControllerState";
    private static final String KEY_START_DESTINATION_ARGS = "android-support-nav:fragment:startDestinationArgs";
    private boolean mDefaultNavHost;
    private int mGraphId;
    private Boolean mIsPrimaryBeforeOnCreate;
    private NavHostController mNavController;
    private View mViewParent;

    public NavHostFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsPrimaryBeforeOnCreate = null;
        }
    }

    @NonNull
    public static NavHostFragment create(@NavigationRes int i3) {
        return create(i3, null);
    }

    @NonNull
    public static NavController findNavController(@NonNull Fragment fragment) {
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
            if (fragment2 instanceof NavHostFragment) {
                return ((NavHostFragment) fragment2).getNavController();
            }
            Fragment primaryNavigationFragment = fragment2.getParentFragmentManager().getPrimaryNavigationFragment();
            if (primaryNavigationFragment instanceof NavHostFragment) {
                return ((NavHostFragment) primaryNavigationFragment).getNavController();
            }
        }
        View view = fragment.getView();
        if (view != null) {
            return Navigation.findNavController(view);
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
    }

    private int getContainerId() {
        int id5 = getId();
        if (id5 != 0 && id5 != -1) {
            return id5;
        }
        return com.tencent.mobileqq.R.id.zma;
    }

    @NonNull
    @Deprecated
    protected Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Navigator) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new FragmentNavigator(requireContext(), getChildFragmentManager(), getContainerId());
    }

    @Override // androidx.navigation.NavHost
    @NonNull
    public final NavController getNavController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NavController) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        NavHostController navHostController = this.mNavController;
        if (navHostController != null) {
            return navHostController;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onAttach(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        super.onAttach(context);
        if (this.mDefaultNavHost) {
            getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onCreate(@Nullable Bundle bundle) {
        boolean z16;
        Bundle bundle2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        NavHostController navHostController = new NavHostController(requireContext());
        this.mNavController = navHostController;
        navHostController.setLifecycleOwner(this);
        this.mNavController.setOnBackPressedDispatcher(requireActivity().getOnBackPressedDispatcher());
        NavHostController navHostController2 = this.mNavController;
        Boolean bool = this.mIsPrimaryBeforeOnCreate;
        int i3 = 0;
        if (bool != null && bool.booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        navHostController2.enableOnBackPressed(z16);
        Bundle bundle3 = null;
        this.mIsPrimaryBeforeOnCreate = null;
        this.mNavController.setViewModelStore(get_viewModelStore());
        onCreateNavController(this.mNavController);
        if (bundle != null) {
            bundle2 = bundle.getBundle(KEY_NAV_CONTROLLER_STATE);
            if (bundle.getBoolean(KEY_DEFAULT_NAV_HOST, false)) {
                this.mDefaultNavHost = true;
                getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
            }
            this.mGraphId = bundle.getInt(KEY_GRAPH_ID);
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.mNavController.restoreState(bundle2);
        }
        int i16 = this.mGraphId;
        if (i16 != 0) {
            this.mNavController.setGraph(i16);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            i3 = arguments.getInt(KEY_GRAPH_ID);
        }
        if (arguments != null) {
            bundle3 = arguments.getBundle(KEY_START_DESTINATION_ARGS);
        }
        if (i3 != 0) {
            this.mNavController.setGraph(i3, bundle3);
        }
    }

    @CallSuper
    protected void onCreateNavController(@NonNull NavController navController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) navController);
        } else {
            navController.getNavigatorProvider().addNavigator(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
            navController.getNavigatorProvider().addNavigator(createFragmentNavigator());
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            view = (View) iPatchRedirector.redirect((short) 8, this, layoutInflater, viewGroup, bundle);
        } else {
            FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
            fragmentContainerView.setId(getContainerId());
            view = fragmentContainerView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onDestroyView();
        View view = this.mViewParent;
        if (view != null && Navigation.findNavController(view) == this.mNavController) {
            Navigation.setViewNavController(this.mViewParent, null);
        }
        this.mViewParent = null;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, attributeSet, bundle);
            return;
        }
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.navigation.R.styleable.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(androidx.navigation.R.styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.mGraphId = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.NavHostFragment);
        if (obtainStyledAttributes2.getBoolean(R.styleable.NavHostFragment_defaultNavHost, false)) {
            this.mDefaultNavHost = true;
        }
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onPrimaryNavigationFragmentChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        NavHostController navHostController = this.mNavController;
        if (navHostController != null) {
            navHostController.enableOnBackPressed(z16);
        } else {
            this.mIsPrimaryBeforeOnCreate = Boolean.valueOf(z16);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
            return;
        }
        super.onSaveInstanceState(bundle);
        Bundle saveState = this.mNavController.saveState();
        if (saveState != null) {
            bundle.putBundle(KEY_NAV_CONTROLLER_STATE, saveState);
        }
        if (this.mDefaultNavHost) {
            bundle.putBoolean(KEY_DEFAULT_NAV_HOST, true);
        }
        int i3 = this.mGraphId;
        if (i3 != 0) {
            bundle.putInt(KEY_GRAPH_ID, i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            Navigation.setViewNavController(view, this.mNavController);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.mViewParent = view2;
                if (view2.getId() == getId()) {
                    Navigation.setViewNavController(this.mViewParent, this.mNavController);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }

    @NonNull
    public static NavHostFragment create(@NavigationRes int i3, @Nullable Bundle bundle) {
        Bundle bundle2;
        if (i3 != 0) {
            bundle2 = new Bundle();
            bundle2.putInt(KEY_GRAPH_ID, i3);
        } else {
            bundle2 = null;
        }
        if (bundle != null) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBundle(KEY_START_DESTINATION_ARGS, bundle);
        }
        NavHostFragment navHostFragment = new NavHostFragment();
        if (bundle2 != null) {
            navHostFragment.setArguments(bundle2);
        }
        return navHostFragment;
    }
}
