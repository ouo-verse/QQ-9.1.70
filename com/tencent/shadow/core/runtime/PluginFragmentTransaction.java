package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.View;

/* loaded from: classes25.dex */
public class PluginFragmentTransaction {
    final FragmentTransaction mBase;
    final PluginFragmentManager mPluginFragmentManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PluginFragmentTransaction(PluginFragmentManager pluginFragmentManager, FragmentTransaction fragmentTransaction) {
        this.mPluginFragmentManager = pluginFragmentManager;
        this.mBase = fragmentTransaction;
    }

    private Fragment getContainerFragment(ShadowFragment shadowFragment) {
        return shadowFragment.getContainerFragment().asFragment();
    }

    public PluginFragmentTransaction add(ShadowFragment shadowFragment, String str) {
        this.mBase.add(getContainerFragment(shadowFragment), str);
        return this;
    }

    @TargetApi(21)
    public PluginFragmentTransaction addSharedElement(View view, String str) {
        this.mBase.addSharedElement(view, str);
        return this;
    }

    public PluginFragmentTransaction addToBackStack(String str) {
        this.mBase.addToBackStack(str);
        return this;
    }

    public PluginFragmentTransaction attach(ShadowFragment shadowFragment) {
        this.mBase.attach(getContainerFragment(shadowFragment));
        return this;
    }

    public int commit() {
        return this.mBase.commit();
    }

    public int commitAllowingStateLoss() {
        return this.mBase.commitAllowingStateLoss();
    }

    @TargetApi(24)
    public void commitNow() {
        this.mBase.commitNow();
    }

    @TargetApi(24)
    public void commitNowAllowingStateLoss() {
        this.mBase.commitNowAllowingStateLoss();
    }

    public PluginFragmentTransaction detach(ShadowFragment shadowFragment) {
        this.mBase.detach(getContainerFragment(shadowFragment));
        return this;
    }

    public PluginFragmentTransaction disallowAddToBackStack() {
        this.mBase.disallowAddToBackStack();
        return this;
    }

    public PluginFragmentTransaction hide(ShadowFragment shadowFragment) {
        this.mBase.hide(getContainerFragment(shadowFragment));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mBase.isAddToBackStackAllowed();
    }

    public boolean isEmpty() {
        return this.mBase.isEmpty();
    }

    public PluginFragmentTransaction remove(ShadowFragment shadowFragment) {
        this.mBase.remove(getContainerFragment(shadowFragment));
        return this;
    }

    public PluginFragmentTransaction replace(int i3, ShadowFragment shadowFragment) {
        this.mBase.replace(i3, getContainerFragment(shadowFragment));
        return this;
    }

    @TargetApi(26)
    public PluginFragmentTransaction runOnCommit(Runnable runnable) {
        this.mBase.runOnCommit(runnable);
        return this;
    }

    public PluginFragmentTransaction setBreadCrumbShortTitle(int i3) {
        this.mBase.setBreadCrumbShortTitle(i3);
        return this;
    }

    public PluginFragmentTransaction setBreadCrumbTitle(int i3) {
        this.mBase.setBreadCrumbTitle(i3);
        return this;
    }

    public PluginFragmentTransaction setCustomAnimations(int i3, int i16) {
        this.mBase.setCustomAnimations(i3, i16);
        return this;
    }

    @TargetApi(26)
    public PluginFragmentTransaction setPrimaryNavigationFragment(ShadowFragment shadowFragment) {
        this.mBase.setPrimaryNavigationFragment(getContainerFragment(shadowFragment));
        return this;
    }

    @TargetApi(26)
    public PluginFragmentTransaction setReorderingAllowed(boolean z16) {
        this.mBase.setReorderingAllowed(z16);
        return this;
    }

    public PluginFragmentTransaction setTransition(int i3) {
        this.mBase.setTransition(i3);
        return this;
    }

    public PluginFragmentTransaction setTransitionStyle(int i3) {
        this.mBase.setTransitionStyle(i3);
        return this;
    }

    public PluginFragmentTransaction show(ShadowFragment shadowFragment) {
        this.mBase.show(getContainerFragment(shadowFragment));
        return this;
    }

    public PluginFragmentTransaction add(int i3, ShadowFragment shadowFragment) {
        this.mBase.add(i3, getContainerFragment(shadowFragment));
        return this;
    }

    public PluginFragmentTransaction replace(int i3, ShadowFragment shadowFragment, String str) {
        this.mBase.replace(i3, getContainerFragment(shadowFragment), str);
        return this;
    }

    public PluginFragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.mBase.setBreadCrumbShortTitle(charSequence);
        return this;
    }

    public PluginFragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.mBase.setBreadCrumbTitle(charSequence);
        return this;
    }

    public PluginFragmentTransaction setCustomAnimations(int i3, int i16, int i17, int i18) {
        this.mBase.setCustomAnimations(i3, i16, i17, i18);
        return this;
    }

    public PluginFragmentTransaction add(int i3, ShadowFragment shadowFragment, String str) {
        this.mBase.add(i3, getContainerFragment(shadowFragment), str);
        return this;
    }
}
