package com.tencent.shadow.core.runtime;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IContainerFragment {
    Fragment asFragment();

    void bindPluginFragment(ShadowFragment shadowFragment);

    Activity getActivity();

    Bundle getArguments();

    FragmentManager getChildFragmentManager();

    Context getContext();

    int getId();

    ShadowFragment getPluginFragment();

    String getTag();

    boolean getUserVisibleHint();

    View getView();

    boolean isAdded();

    boolean isDetached();

    boolean isHidden();

    boolean isInLayout();

    boolean isRemoving();

    boolean isResumed();

    boolean isVisible();

    void requestPermissions(String[] strArr, int i3);

    void setArguments(Bundle bundle);

    void superOnHiddenChanged(boolean z16);

    void superSetHasOptionsMenu(boolean z16);

    void superSetMenuVisibility(boolean z16);

    void superSetRetainInstance(boolean z16);

    void superSetUserVisibleHint(boolean z16);

    void unbindPluginFragment();
}
