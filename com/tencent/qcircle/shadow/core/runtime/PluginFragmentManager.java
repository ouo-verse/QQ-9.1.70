package com.tencent.qcircle.shadow.core.runtime;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.content.ComponentCallbacks2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes22.dex */
public class PluginFragmentManager {
    FragmentManager mBase;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PluginFragmentManager(FragmentManager fragmentManager) {
        this.mBase = fragmentManager;
    }

    @SuppressLint({"CommitTransaction"})
    public PluginFragmentTransaction beginTransaction() {
        return new PluginFragmentTransaction(this, this.mBase.beginTransaction());
    }

    public boolean executePendingTransactions() {
        return this.mBase.executePendingTransactions();
    }

    public ShadowFragment findFragmentByTag(String str) {
        ComponentCallbacks2 findFragmentByTag = this.mBase.findFragmentByTag(str);
        if (findFragmentByTag instanceof IContainerFragment) {
            return ((IContainerFragment) findFragmentByTag).getPluginFragment();
        }
        return null;
    }

    @TargetApi(26)
    public List<ShadowFragment> getFragments() {
        List<ComponentCallbacks2> fragments;
        fragments = this.mBase.getFragments();
        ArrayList arrayList = new ArrayList();
        if (fragments != null && fragments.size() > 0) {
            for (ComponentCallbacks2 componentCallbacks2 : fragments) {
                if (componentCallbacks2 instanceof IContainerFragment) {
                    arrayList.add(((IContainerFragment) componentCallbacks2).getPluginFragment());
                }
            }
        }
        if (arrayList.size() <= 0) {
            return Collections.EMPTY_LIST;
        }
        return arrayList;
    }
}
