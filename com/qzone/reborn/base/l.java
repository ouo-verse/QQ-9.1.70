package com.qzone.reborn.base;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.qzone.common.activities.base.QZoneFragmentHolderActivity;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.adapter.section.Section;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class l<T> extends Section<T> {

    /* renamed from: d, reason: collision with root package name */
    private Activity f53569d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public boolean isSectionEnabled() {
        return !lm.a.f414989a.j(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity p() {
        if (this.f53569d == null) {
            this.f53569d = com.qzone.reborn.feedx.widget.i.c(this.mRootView);
        }
        return this.f53569d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <E> E q(Class<E> cls) {
        return (E) RFWIocAbilityProvider.g().getIocInterface(cls, this.mRootView, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePartFragment r() {
        View view = this.mRootView;
        if (view == null) {
            return null;
        }
        if (view.getContext() instanceof QZoneBaseActivity) {
            return ((QZoneBaseActivity) this.mRootView.getContext()).getQZoneBaseFragment();
        }
        if (this.mRootView.getContext() instanceof QZoneFragmentHolderActivity) {
            return ((QZoneFragmentHolderActivity) this.mRootView.getContext()).getQZoneBaseFragment();
        }
        try {
            Fragment findFragment = FragmentManager.findFragment(this.mRootView);
            if (findFragment instanceof BasePartFragment) {
                return (BasePartFragment) findFragment;
            }
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
        return null;
    }

    public String s() {
        return getLogTag();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <V extends ViewModel> V t(Class<V> cls) {
        if (r() != null) {
            return (V) r().getViewModel(cls);
        }
        return null;
    }
}
