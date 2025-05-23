package com.tencent.qcircle.shadow.core.runtime;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ShadowFragment {
    private static Map<String, Constructor<?>> constructorMap = new HashMap();
    private Context mAttachedContext;
    private PluginFragmentManager mChildPluginFragmentManager;
    private int mChildPluginFragmentManagerHash;
    protected IContainerFragment mContainerFragment;
    protected boolean mIsAppCreateFragment;
    PluginFragmentManager mPluginFragmentManager;

    public ShadowFragment() {
        IContainerFragment instantiateContainerFragment = instantiateContainerFragment(this);
        this.mContainerFragment = instantiateContainerFragment;
        instantiateContainerFragment.bindPluginFragment(this);
        this.mIsAppCreateFragment = true;
    }

    private static IContainerFragment instantiateContainerFragment(ShadowFragment shadowFragment) {
        String substring = shadowFragment.getClass().getName().substring(0, r0.length() - 1);
        Constructor<?> constructor = constructorMap.get(substring);
        if (constructor == null) {
            try {
                constructor = shadowFragment.getClass().getClassLoader().loadClass(substring).getConstructor(new Class[0]);
                constructorMap.put(substring, constructor);
            } catch (Exception e16) {
                throw new Fragment.InstantiationException("\u65e0\u6cd5\u6784\u9020" + substring, e16);
            }
        }
        try {
            return (IContainerFragment) IContainerFragment.class.cast(constructor.newInstance(new Object[0]));
        } catch (Exception e17) {
            throw new Fragment.InstantiationException("\u65e0\u6cd5\u6784\u9020" + substring, e17);
        }
    }

    public final ShadowActivity getActivity() {
        Context context = this.mAttachedContext;
        if (context == null) {
            return null;
        }
        if (context instanceof ShadowActivity) {
            return (ShadowActivity) context;
        }
        return (ShadowActivity) ((PluginContainerActivity) this.mContainerFragment.getActivity()).getPluginActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        return false;
    }

    public boolean getAllowReturnTransitionOverlap() {
        return false;
    }

    public final Bundle getArguments() {
        return this.mContainerFragment.getArguments();
    }

    public PluginFragmentManager getChildFragmentManager() {
        FragmentManager childFragmentManager = this.mContainerFragment.getChildFragmentManager();
        int identityHashCode = System.identityHashCode(childFragmentManager);
        if (identityHashCode != this.mChildPluginFragmentManagerHash) {
            this.mChildPluginFragmentManagerHash = identityHashCode;
            this.mChildPluginFragmentManager = new PluginFragmentManager(childFragmentManager);
        }
        return this.mChildPluginFragmentManager;
    }

    public IContainerFragment getContainerFragment() {
        IContainerFragment iContainerFragment = this.mContainerFragment;
        if (iContainerFragment != null) {
            return iContainerFragment;
        }
        throw new NullPointerException(getClass().getName() + " mContainerFragment == null");
    }

    public Context getContext() {
        return this.mAttachedContext;
    }

    public Transition getEnterTransition() {
        return null;
    }

    public Transition getExitTransition() {
        return null;
    }

    public PluginFragmentManager getFragmentManager() {
        if (this.mPluginFragmentManager == null && getActivity() != null) {
            this.mPluginFragmentManager = getActivity().getFragmentManager();
        }
        return this.mPluginFragmentManager;
    }

    public final int getId() {
        return this.mContainerFragment.getId();
    }

    public LoaderManager getLoaderManager() {
        return null;
    }

    public Transition getReenterTransition() {
        return null;
    }

    public final Resources getResources() {
        Context context = this.mAttachedContext;
        if (context != null) {
            return context.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public Transition getReturnTransition() {
        return null;
    }

    public Transition getSharedElementEnterTransition() {
        return null;
    }

    public Transition getSharedElementReturnTransition() {
        return null;
    }

    public final String getString(int i3) {
        return getResources().getString(i3);
    }

    public final String getTag() {
        return this.mContainerFragment.getTag();
    }

    public final CharSequence getText(int i3) {
        return getResources().getText(i3);
    }

    public boolean getUserVisibleHint() {
        return this.mContainerFragment.getUserVisibleHint();
    }

    public View getView() {
        return this.mContainerFragment.getView();
    }

    public final boolean isAdded() {
        return this.mContainerFragment.isAdded();
    }

    public final boolean isDetached() {
        return this.mContainerFragment.isDetached();
    }

    public final boolean isHidden() {
        return this.mContainerFragment.isHidden();
    }

    public final boolean isInLayout() {
        return this.mContainerFragment.isInLayout();
    }

    public final boolean isRemoving() {
        return this.mContainerFragment.isRemoving();
    }

    public final boolean isResumed() {
        return this.mContainerFragment.isResumed();
    }

    public final boolean isVisible() {
        return this.mContainerFragment.isVisible();
    }

    public void onAttach(Context context) {
        this.mAttachedContext = context;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public Animator onCreateAnimator(int i3, boolean z16, int i16) {
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return null;
    }

    public void onHiddenChanged(boolean z16) {
        this.mContainerFragment.superOnHiddenChanged(z16);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
    }

    public void onMultiWindowModeChanged(boolean z16) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPictureInPictureModeChanged(boolean z16) {
    }

    public final void requestPermissions(String[] strArr, int i3) {
        this.mContainerFragment.requestPermissions(strArr, i3);
    }

    public void setArguments(Bundle bundle) {
        if (this.mIsAppCreateFragment) {
            this.mContainerFragment.setArguments(bundle);
        }
    }

    public void setContainerFragment(IContainerFragment iContainerFragment) {
        this.mIsAppCreateFragment = false;
        this.mContainerFragment.unbindPluginFragment();
        this.mContainerFragment = iContainerFragment;
    }

    public void setHasOptionsMenu(boolean z16) {
        this.mContainerFragment.superSetHasOptionsMenu(z16);
    }

    public void setMenuVisibility(boolean z16) {
        this.mContainerFragment.superSetMenuVisibility(z16);
    }

    public void setRetainInstance(boolean z16) {
        this.mContainerFragment.superSetRetainInstance(z16);
    }

    public void setUserVisibleHint(boolean z16) {
        this.mContainerFragment.superSetUserVisibleHint(z16);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return false;
    }

    public void startActivity(Intent intent) {
        this.mAttachedContext.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i3) {
    }

    public final String getString(int i3, Object... objArr) {
        return getResources().getString(i3, objArr);
    }

    public void onAttach(ShadowActivity shadowActivity) {
        this.mAttachedContext = shadowActivity;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
    }

    public void onMultiWindowModeChanged(boolean z16, Configuration configuration) {
    }

    public void onPictureInPictureModeChanged(boolean z16, Configuration configuration) {
    }

    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        this.mAttachedContext.startActivity(intent, bundle);
    }

    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
    }

    public void onInflate(AttributeSet attributeSet, Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
    }

    public void onDetach() {
    }

    public void onLowMemory() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void postponeEnterTransition() {
    }

    public void startPostponedEnterTransition() {
    }

    public void onActivityCreated(Bundle bundle) {
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onTrimMemory(int i3) {
    }

    public void onViewStateRestored(Bundle bundle) {
    }

    public void registerForContextMenu(View view) {
    }

    public void setAllowEnterTransitionOverlap(boolean z16) {
    }

    public void setAllowReturnTransitionOverlap(boolean z16) {
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
    }

    public void setEnterTransition(Transition transition) {
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
    }

    public void setExitTransition(Transition transition) {
    }

    public void setInitialSavedState(Fragment.SavedState savedState) {
    }

    public void setReenterTransition(Transition transition) {
    }

    public void setReturnTransition(Transition transition) {
    }

    public void setSharedElementEnterTransition(Transition transition) {
    }

    public void setSharedElementReturnTransition(Transition transition) {
    }

    public void unregisterForContextMenu(View view) {
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void setTargetFragment(Fragment fragment, int i3) {
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
    }

    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i3, Intent intent, int i16, int i17, int i18, Bundle bundle) throws IntentSender.SendIntentException {
    }
}
