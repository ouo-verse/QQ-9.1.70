package com.tencent.biz.richframework.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class BasePartFragment extends CompatPublicFragment implements IPartHost {
    public static final String INIT_PART_LIST_CLASS_NAME = "init_part_list";
    private View mContentView;
    private final FragmentManager.FragmentLifecycleCallbacks mInnerFragLifecycleCallbacks;
    private boolean mLazyLoadDone;
    protected ViewGroup mParentView;
    protected PartManager mPartManager;

    public BasePartFragment() {
        this.mLazyLoadDone = false;
        this.mInnerFragLifecycleCallbacks = new FragmentManager.FragmentLifecycleCallbacks() { // from class: com.tencent.biz.richframework.part.BasePartFragment.1
            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
                super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
                BasePartFragment basePartFragment = BasePartFragment.this;
                if (fragment == basePartFragment) {
                    basePartFragment.mContentView = view;
                    BasePartFragment.this.mContentView.setTag(TagData.TAG_DATA_ID, BasePartFragment.this.createViewTagData());
                    if (BasePartFragment.this.mContentView.getParent() instanceof ViewGroup) {
                        BasePartFragment basePartFragment2 = BasePartFragment.this;
                        basePartFragment2.mParentView = (ViewGroup) basePartFragment2.mContentView.getParent();
                    }
                    ArrayList arrayList = new ArrayList();
                    List<Part> assembleParts = BasePartFragment.this.assembleParts();
                    if (assembleParts != null) {
                        arrayList.addAll(assembleParts);
                    }
                    arrayList.addAll(BasePartFragment.this.getInitPartList());
                    if (arrayList.size() > 0) {
                        BasePartFragment basePartFragment3 = BasePartFragment.this;
                        basePartFragment3.mPartManager = basePartFragment3.getPartManager();
                        BasePartFragment.this.mPartManager.registerPart(arrayList);
                    }
                    BasePartFragment basePartFragment4 = BasePartFragment.this;
                    basePartFragment4.dispatchPartInit(basePartFragment4.mContentView, BasePartFragment.this.mParentView, bundle);
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
                BasePartFragment basePartFragment = BasePartFragment.this;
                if (fragment == basePartFragment) {
                    basePartFragment.dispatchPartDestroy();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPartDestroy() {
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onPartDestroy(requireActivity());
            this.mPartManager = null;
        }
        onFragmentViewDestroyed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPartInit(View view, ViewGroup viewGroup, @Nullable Bundle bundle) {
        onViewCreatedBeforePartInit(view, bundle);
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.setParentView(viewGroup);
            this.mPartManager.setRootView(view);
            this.mPartManager.onPartCreate(requireActivity(), bundle);
        }
        onViewCreatedAfterPartInit(view, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<Part> getInitPartList() {
        ArrayList arrayList = new ArrayList();
        Bundle arguments = getArguments();
        if (arguments == null) {
            return arrayList;
        }
        ArrayList<String> stringArrayList = arguments.getStringArrayList(INIT_PART_LIST_CLASS_NAME);
        if (stringArrayList == null) {
            return arrayList;
        }
        for (String str : stringArrayList) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(PartFactory.instantiate(getClass().getClassLoader(), str));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.beforeFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object createViewTagData() {
        return new Object();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doPause() {
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onPartPause(requireActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doResume() {
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onPartResume(requireActivity());
        }
    }

    protected void doStart() {
        try {
            PartManager partManager = this.mPartManager;
            if (partManager != null) {
                partManager.onPartStart(requireActivity());
            }
        } catch (Throwable th5) {
            RFWLog.fatal(getLogTag(), RFWLog.USR, th5);
        }
    }

    protected void doStop() {
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onPartStop(requireActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public abstract int getContentLayoutId();

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFragmentContentView() {
        return this.mContentView;
    }

    public Activity getHostActivity() {
        return getActivity();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public Context getHostContext() {
        return getContext();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public LifecycleOwner getHostLifecycleOwner() {
        return getViewLifecycleOwner();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLogTag() {
        return getClass().getName();
    }

    public PartManager getPartManager() {
        if (this.mPartManager == null) {
            this.mPartManager = new PartManager(this, this.mContentView);
        }
        return this.mPartManager;
    }

    public /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public Object getViewTagData() {
        View view = this.mContentView;
        if (view != null) {
            return view.getTag(TagData.TAG_DATA_ID);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void makeSureInit(boolean z16) {
        if (!(this instanceof ILazyLoader) || this.mLazyLoadDone) {
            return;
        }
        ILazyLoader iLazyLoader = (ILazyLoader) this;
        if (z16 || !iLazyLoader.isLazyLoad()) {
            iLazyLoader.load();
            this.mLazyLoadDone = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        makeSureInit(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onActivityResult(i3, i16, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        getParentFragmentManager().registerFragmentLifecycleCallbacks(this.mInnerFragLifecycleCallbacks, false);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getPartManager() != null && getPartManager().onBackEvent()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (onCreateView == null && getContentLayoutId() != 0) {
            onCreateView = layoutInflater.inflate(getContentLayoutId(), viewGroup, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onDetach() {
        super.onDetach();
        getParentFragmentManager().unregisterFragmentLifecycleCallbacks(this.mInnerFragLifecycleCallbacks);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
        if (this.mPartManager != null && useArgusLifecycle()) {
            if (z16) {
                this.mPartManager.onPartPause(requireActivity());
            } else {
                this.mPartManager.onPartResume(requireActivity());
            }
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onNewIntent(intent);
        }
    }

    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        doPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        makeSureInit(true);
        doResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        PartManager partManager;
        super.onSaveInstanceState(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && (partManager = this.mPartManager) != null) {
            partManager.onPartSaveInstanceState(activity, bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        doStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        doStop();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onWindowFocusChanged(z16);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.setUserVisibleHint(z16);
        }
    }

    public /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    public /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    public <T extends ViewModel> T getViewModel(Class<T> cls) {
        return (T) getViewModel(null, cls);
    }

    public BasePartFragment(int i3) {
        super(i3);
        this.mLazyLoadDone = false;
        this.mInnerFragLifecycleCallbacks = new FragmentManager.FragmentLifecycleCallbacks() { // from class: com.tencent.biz.richframework.part.BasePartFragment.1
            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
                super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
                BasePartFragment basePartFragment = BasePartFragment.this;
                if (fragment == basePartFragment) {
                    basePartFragment.mContentView = view;
                    BasePartFragment.this.mContentView.setTag(TagData.TAG_DATA_ID, BasePartFragment.this.createViewTagData());
                    if (BasePartFragment.this.mContentView.getParent() instanceof ViewGroup) {
                        BasePartFragment basePartFragment2 = BasePartFragment.this;
                        basePartFragment2.mParentView = (ViewGroup) basePartFragment2.mContentView.getParent();
                    }
                    ArrayList arrayList = new ArrayList();
                    List<Part> assembleParts = BasePartFragment.this.assembleParts();
                    if (assembleParts != null) {
                        arrayList.addAll(assembleParts);
                    }
                    arrayList.addAll(BasePartFragment.this.getInitPartList());
                    if (arrayList.size() > 0) {
                        BasePartFragment basePartFragment3 = BasePartFragment.this;
                        basePartFragment3.mPartManager = basePartFragment3.getPartManager();
                        BasePartFragment.this.mPartManager.registerPart(arrayList);
                    }
                    BasePartFragment basePartFragment4 = BasePartFragment.this;
                    basePartFragment4.dispatchPartInit(basePartFragment4.mContentView, BasePartFragment.this.mParentView, bundle);
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
                BasePartFragment basePartFragment = BasePartFragment.this;
                if (fragment == basePartFragment) {
                    basePartFragment.dispatchPartDestroy();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFragmentViewDestroyed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewCreatedAfterPartInit(@NonNull View view, @Nullable Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewCreatedBeforePartInit(View view, @Nullable Bundle bundle) {
    }
}
