package com.tencent.qcircle.shadow.core.runtime;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.LoaderManager;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ContainerDialogFragment extends ReportDialogFragment implements IContainerDialogFragment {
    private static Map<String, Constructor<?>> constructorMap = new HashMap();
    private boolean mDestroyed;
    private OnInflateParams mOnInflateParams;
    private ShadowDialogFragment mPluginFragment;
    private boolean init = false;
    private boolean mIsAppCreateFragment = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class OnInflateParams {
        final AttributeSet attrs;
        final Bundle savedInstanceState;

        OnInflateParams(AttributeSet attributeSet, Bundle bundle) {
            this.attrs = attributeSet;
            this.savedInstanceState = bundle;
        }
    }

    private void initPluginFragment(Context context) {
        if (this.init) {
            return;
        }
        this.init = true;
        onBindPluginFragment(context);
        OnInflateParams onInflateParams = this.mOnInflateParams;
        if (onInflateParams != null) {
            this.mPluginFragment.onInflate(onInflateParams.attrs, onInflateParams.savedInstanceState);
            this.mOnInflateParams = null;
        }
    }

    private static ShadowDialogFragment instantiatePluginFragment(ContainerDialogFragment containerDialogFragment, Context context) {
        String str = containerDialogFragment.getClass().getName() + "_";
        Constructor<?> constructor = constructorMap.get(str);
        if (constructor == null) {
            try {
                constructor = ((PluginActivity) ((PluginContainerActivity) context).getPluginActivity()).getClassLoader().loadClass(str).getConstructor(new Class[0]);
                constructorMap.put(str, constructor);
            } catch (Exception e16) {
                throw new Fragment.InstantiationException("\u65e0\u6cd5\u6784\u9020" + str, e16);
            }
        }
        try {
            return (ShadowDialogFragment) ShadowDialogFragment.class.cast(constructor.newInstance(new Object[0]));
        } catch (Exception e17) {
            throw new Fragment.InstantiationException("\u65e0\u6cd5\u6784\u9020" + str, e17);
        }
    }

    private void onBindPluginFragment(Context context) {
        ShadowDialogFragment instantiatePluginFragment = instantiatePluginFragment(this, context);
        this.mPluginFragment = instantiatePluginFragment;
        instantiatePluginFragment.setContainerFragment(this);
    }

    private void onUnbindPluginFragment() {
        this.mPluginFragment.setContainerFragment(null);
        this.mPluginFragment = null;
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public void bindPluginFragment(ShadowFragment shadowFragment) {
        this.init = true;
        this.mIsAppCreateFragment = true;
        this.mPluginFragment = (ShadowDialogFragment) shadowFragment;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mPluginFragment.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Fragment
    public boolean getAllowEnterTransitionOverlap() {
        return this.mPluginFragment.getAllowEnterTransitionOverlap();
    }

    @Override // android.app.Fragment
    public boolean getAllowReturnTransitionOverlap() {
        return this.mPluginFragment.getAllowReturnTransitionOverlap();
    }

    @Override // android.app.Fragment, com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public Context getContext() {
        return this.mPluginFragment.getContext();
    }

    @Override // android.app.Fragment
    public Transition getEnterTransition() {
        return this.mPluginFragment.getEnterTransition();
    }

    @Override // android.app.Fragment
    public Transition getExitTransition() {
        return this.mPluginFragment.getExitTransition();
    }

    @Override // android.app.Fragment
    public LoaderManager getLoaderManager() {
        return this.mPluginFragment.getLoaderManager();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public ShadowFragment getPluginFragment() {
        return this.mPluginFragment;
    }

    @Override // android.app.Fragment
    public Transition getReenterTransition() {
        return this.mPluginFragment.getReenterTransition();
    }

    @Override // android.app.Fragment
    public Transition getReturnTransition() {
        return this.mPluginFragment.getReturnTransition();
    }

    @Override // android.app.Fragment
    public Transition getSharedElementEnterTransition() {
        return this.mPluginFragment.getSharedElementEnterTransition();
    }

    @Override // android.app.Fragment
    public Transition getSharedElementReturnTransition() {
        return this.mPluginFragment.getSharedElementReturnTransition();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mPluginFragment.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        this.mPluginFragment.onActivityResult(i3, i16, intent);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        initPluginFragment(context);
        super.onAttach(context);
        if (context instanceof PluginContainerActivity) {
            this.mPluginFragment.onAttach((Context) ((PluginContainerActivity) context).getPluginActivity());
        }
    }

    @Override // android.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        this.mPluginFragment.onAttachFragment(fragment);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.mPluginFragment.onCancel(dialogInterface);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mPluginFragment.onConfigurationChanged(configuration);
    }

    @Override // android.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        return this.mPluginFragment.onContextItemSelected(menuItem);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPluginFragment.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public Animator onCreateAnimator(int i3, boolean z16, int i16) {
        return this.mPluginFragment.onCreateAnimator(i3, z16, i16);
    }

    @Override // android.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mPluginFragment.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment, android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return this.mPluginFragment.onCreateDialog(bundle);
    }

    @Override // android.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        this.mPluginFragment.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.mPluginFragment.onCreateView(layoutInflater, viewGroup, bundle);
        FragmentCollector.onFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mPluginFragment.onDestroy();
        this.mDestroyed = true;
    }

    @Override // android.app.Fragment
    public void onDestroyOptionsMenu() {
        this.mPluginFragment.onDestroyOptionsMenu();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mPluginFragment.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mPluginFragment.onDetach();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener, com.tencent.qcircle.shadow.core.runtime.IContainerDialogFragment
    public void onDismiss(DialogInterface dialogInterface) {
        this.mPluginFragment.onDismiss(dialogInterface);
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
        this.mPluginFragment.onHiddenChanged(z16);
    }

    @Override // android.app.Fragment
    @Deprecated
    public void onInflate(AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(attributeSet, bundle);
        this.mOnInflateParams = new OnInflateParams(attributeSet, bundle);
        ShadowDialogFragment shadowDialogFragment = this.mPluginFragment;
        if (shadowDialogFragment != null) {
            shadowDialogFragment.onInflate(attributeSet, bundle);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mPluginFragment.onLowMemory();
    }

    @Override // android.app.Fragment
    public void onMultiWindowModeChanged(boolean z16, Configuration configuration) {
        this.mPluginFragment.onMultiWindowModeChanged(z16, configuration);
    }

    @Override // android.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mPluginFragment.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Fragment
    public void onOptionsMenuClosed(Menu menu) {
        this.mPluginFragment.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mPluginFragment.onPause();
    }

    @Override // android.app.Fragment
    public void onPictureInPictureModeChanged(boolean z16, Configuration configuration) {
        this.mPluginFragment.onPictureInPictureModeChanged(z16, configuration);
    }

    @Override // android.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        this.mPluginFragment.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.mPluginFragment.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPluginFragment.onResume();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        this.mPluginFragment.onSaveInstanceState(bundle);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        this.mPluginFragment.onStart();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStop() {
        super.onStop();
        this.mPluginFragment.onStop();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        this.mPluginFragment.onTrimMemory(i3);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mPluginFragment.onViewCreated(view, bundle);
    }

    @Override // android.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        this.mPluginFragment.onViewStateRestored(bundle);
    }

    @Override // android.app.Fragment
    public void postponeEnterTransition() {
        this.mPluginFragment.postponeEnterTransition();
    }

    @Override // android.app.Fragment
    public void registerForContextMenu(View view) {
        this.mPluginFragment.registerForContextMenu(view);
    }

    @Override // android.app.Fragment
    public void setAllowEnterTransitionOverlap(boolean z16) {
        this.mPluginFragment.setAllowEnterTransitionOverlap(z16);
    }

    @Override // android.app.Fragment
    public void setAllowReturnTransitionOverlap(boolean z16) {
        this.mPluginFragment.setAllowReturnTransitionOverlap(z16);
    }

    @Override // android.app.Fragment, com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public void setArguments(Bundle bundle) {
        if (!this.mIsAppCreateFragment) {
            this.mPluginFragment.setArguments(bundle);
        } else {
            super.setArguments(bundle);
        }
    }

    @Override // android.app.Fragment
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.mPluginFragment.setEnterSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Fragment
    public void setEnterTransition(Transition transition) {
        this.mPluginFragment.setEnterTransition(transition);
    }

    @Override // android.app.Fragment
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.mPluginFragment.setExitSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Fragment
    public void setExitTransition(Transition transition) {
        this.mPluginFragment.setExitTransition(transition);
    }

    @Override // android.app.Fragment
    public void setHasOptionsMenu(boolean z16) {
        this.mPluginFragment.setHasOptionsMenu(z16);
    }

    @Override // android.app.Fragment
    public void setInitialSavedState(Fragment.SavedState savedState) {
        this.mPluginFragment.setInitialSavedState(savedState);
    }

    @Override // android.app.Fragment
    public void setMenuVisibility(boolean z16) {
        this.mPluginFragment.setMenuVisibility(z16);
    }

    @Override // android.app.Fragment
    public void setReenterTransition(Transition transition) {
        this.mPluginFragment.setReenterTransition(transition);
    }

    @Override // android.app.Fragment
    public void setRetainInstance(boolean z16) {
        this.mPluginFragment.setRetainInstance(z16);
    }

    @Override // android.app.Fragment
    public void setReturnTransition(Transition transition) {
        this.mPluginFragment.setReturnTransition(transition);
    }

    @Override // android.app.Fragment
    public void setSharedElementEnterTransition(Transition transition) {
        this.mPluginFragment.setSharedElementEnterTransition(transition);
    }

    @Override // android.app.Fragment
    public void setSharedElementReturnTransition(Transition transition) {
        this.mPluginFragment.setSharedElementReturnTransition(transition);
    }

    @Override // android.app.Fragment
    public void setTargetFragment(Fragment fragment, int i3) {
        this.mPluginFragment.setTargetFragment(fragment, i3);
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        this.mPluginFragment.setUserVisibleHint(z16);
    }

    @Override // android.app.Fragment
    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.mPluginFragment.shouldShowRequestPermissionRationale(str);
    }

    @Override // android.app.Fragment
    public void startActivity(Intent intent) {
        this.mPluginFragment.startActivity(intent);
    }

    @Override // android.app.Fragment
    public void startActivityForResult(Intent intent, int i3) {
        this.mPluginFragment.startActivityForResult(intent, i3);
    }

    @Override // android.app.Fragment
    public void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException {
        this.mPluginFragment.startIntentSenderForResult(intentSender, i3, intent, i16, i17, i18, bundle);
    }

    @Override // android.app.Fragment
    public void startPostponedEnterTransition() {
        this.mPluginFragment.startPostponedEnterTransition();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.IContainerDialogFragment
    public void superOnDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public void superOnHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public void superSetHasOptionsMenu(boolean z16) {
        super.setHasOptionsMenu(z16);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public void superSetMenuVisibility(boolean z16) {
        super.setMenuVisibility(z16);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public void superSetRetainInstance(boolean z16) {
        super.setRetainInstance(z16);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public void superSetUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
    }

    @Override // android.app.Fragment
    public String toString() {
        return this.mPluginFragment.toString();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public void unbindPluginFragment() {
        this.init = false;
        this.mPluginFragment = null;
    }

    @Override // android.app.Fragment
    public void unregisterForContextMenu(View view) {
        this.mPluginFragment.unregisterForContextMenu(view);
    }

    @Override // android.app.Fragment
    @Deprecated
    public void onMultiWindowModeChanged(boolean z16) {
        this.mPluginFragment.onMultiWindowModeChanged(z16);
    }

    @Override // android.app.Fragment
    @Deprecated
    public void onPictureInPictureModeChanged(boolean z16) {
        this.mPluginFragment.onPictureInPictureModeChanged(z16);
    }

    @Override // android.app.Fragment
    public void startActivity(Intent intent, Bundle bundle) {
        this.mPluginFragment.startActivity(intent, bundle);
    }

    @Override // android.app.Fragment
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        this.mPluginFragment.startActivityForResult(intent, i3, bundle);
    }

    @Override // android.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        initPluginFragment(context);
        super.onInflate(context, attributeSet, bundle);
        this.mPluginFragment.onInflate(context, attributeSet, bundle);
    }

    @Override // android.app.Fragment
    @Deprecated
    public void onAttach(Activity activity) {
        initPluginFragment(activity);
        super.onAttach(activity);
        if (activity instanceof PluginContainerActivity) {
            this.mPluginFragment.onAttach((ShadowActivity) ((Context) ((PluginContainerActivity) activity).getPluginActivity()));
        }
    }

    @Override // android.app.Fragment
    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.mPluginFragment.onInflate(activity, attributeSet, bundle);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.IContainerFragment
    public Fragment asFragment() {
        return this;
    }
}
