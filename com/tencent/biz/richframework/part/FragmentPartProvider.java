package com.tencent.biz.richframework.part;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0006\u0010\"\u001a\u00020\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/tencent/biz/richframework/part/FragmentPartProvider;", "", "host", "Lcom/tencent/biz/richframework/part/IPartFragmentHost;", "(Lcom/tencent/biz/richframework/part/IPartFragmentHost;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "getHost", "()Lcom/tencent/biz/richframework/part/IPartFragmentHost;", "mInnerFragLifecycleCallbacks", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "parentView", "Landroid/view/ViewGroup;", "getParentView", "()Landroid/view/ViewGroup;", "setParentView", "(Landroid/view/ViewGroup;)V", "partManager", "Lcom/tencent/biz/richframework/part/PartManager;", "getPartManager", "()Lcom/tencent/biz/richframework/part/PartManager;", "setPartManager", "(Lcom/tencent/biz/richframework/part/PartManager;)V", "dispatchPartInit", "", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "getInitPartList", "", "Lcom/tencent/biz/richframework/part/Part;", "initProvider", "part-fragment_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class FragmentPartProvider {
    public View contentView;

    @NotNull
    private final IPartFragmentHost host;
    private final FragmentManager.FragmentLifecycleCallbacks mInnerFragLifecycleCallbacks;
    public ViewGroup parentView;

    @Nullable
    private PartManager partManager;

    public FragmentPartProvider(@NotNull IPartFragmentHost host) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.mInnerFragLifecycleCallbacks = new FragmentManager.FragmentLifecycleCallbacks() { // from class: com.tencent.biz.richframework.part.FragmentPartProvider$mInnerFragLifecycleCallbacks$1
            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentDestroyed(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
                Intrinsics.checkNotNullParameter(fm5, "fm");
                Intrinsics.checkNotNullParameter(f16, "f");
                super.onFragmentDestroyed(fm5, f16);
                if (f16 == FragmentPartProvider.this.getHost().getHostFragment()) {
                    FragmentPartProvider.this.getHost().getHostFragment().getParentFragmentManager().unregisterFragmentLifecycleCallbacks(this);
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentPaused(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
                PartManager partManager;
                Intrinsics.checkNotNullParameter(fm5, "fm");
                Intrinsics.checkNotNullParameter(f16, "f");
                super.onFragmentPaused(fm5, f16);
                if (f16 == FragmentPartProvider.this.getHost().getHostFragment() && (partManager = FragmentPartProvider.this.getPartManager()) != null) {
                    partManager.onPartPause(FragmentPartProvider.this.getHost().getHostFragment().requireActivity());
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentResumed(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
                PartManager partManager;
                Intrinsics.checkNotNullParameter(fm5, "fm");
                Intrinsics.checkNotNullParameter(f16, "f");
                super.onFragmentResumed(fm5, f16);
                if (f16 == FragmentPartProvider.this.getHost().getHostFragment() && (partManager = FragmentPartProvider.this.getPartManager()) != null) {
                    partManager.onPartResume(FragmentPartProvider.this.getHost().getHostFragment().requireActivity());
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentSaveInstanceState(@NotNull FragmentManager fm5, @NotNull Fragment f16, @NotNull Bundle outState) {
                PartManager partManager;
                Intrinsics.checkNotNullParameter(fm5, "fm");
                Intrinsics.checkNotNullParameter(f16, "f");
                Intrinsics.checkNotNullParameter(outState, "outState");
                super.onFragmentSaveInstanceState(fm5, f16, outState);
                if (f16 == FragmentPartProvider.this.getHost().getHostFragment() && (partManager = FragmentPartProvider.this.getPartManager()) != null) {
                    partManager.onPartSaveInstanceState(FragmentPartProvider.this.getHost().getHostFragment().requireActivity(), outState);
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentStarted(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
                PartManager partManager;
                Intrinsics.checkNotNullParameter(fm5, "fm");
                Intrinsics.checkNotNullParameter(f16, "f");
                super.onFragmentStarted(fm5, f16);
                if (f16 == FragmentPartProvider.this.getHost().getHostFragment() && (partManager = FragmentPartProvider.this.getPartManager()) != null) {
                    partManager.onPartStart(FragmentPartProvider.this.getHost().getHostFragment().requireActivity());
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentStopped(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
                PartManager partManager;
                Intrinsics.checkNotNullParameter(fm5, "fm");
                Intrinsics.checkNotNullParameter(f16, "f");
                super.onFragmentStopped(fm5, f16);
                if (f16 == FragmentPartProvider.this.getHost().getHostFragment() && (partManager = FragmentPartProvider.this.getPartManager()) != null) {
                    partManager.onPartStop(FragmentPartProvider.this.getHost().getHostFragment().requireActivity());
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewCreated(@NotNull FragmentManager fm5, @NotNull Fragment f16, @NotNull View v3, @Nullable Bundle savedInstanceState) {
                List initPartList;
                Intrinsics.checkNotNullParameter(fm5, "fm");
                Intrinsics.checkNotNullParameter(f16, "f");
                Intrinsics.checkNotNullParameter(v3, "v");
                super.onFragmentViewCreated(fm5, f16, v3, savedInstanceState);
                if (f16 == FragmentPartProvider.this.getHost().getHostFragment()) {
                    FragmentPartProvider.this.setContentView(v3);
                    if (FragmentPartProvider.this.getContentView().getParent() instanceof ViewGroup) {
                        FragmentPartProvider fragmentPartProvider = FragmentPartProvider.this;
                        ViewParent parent = fragmentPartProvider.getContentView().getParent();
                        if (parent != null) {
                            fragmentPartProvider.setParentView((ViewGroup) parent);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    List<Part> it = FragmentPartProvider.this.getHost().assembleParts();
                    if (it != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        arrayList.addAll(it);
                    }
                    initPartList = FragmentPartProvider.this.getInitPartList();
                    arrayList.addAll(initPartList);
                    if (!arrayList.isEmpty()) {
                        FragmentPartProvider fragmentPartProvider2 = FragmentPartProvider.this;
                        PartManager partManager = new PartManager(fragmentPartProvider2.getHost(), FragmentPartProvider.this.getContentView());
                        partManager.registerPart(arrayList);
                        Unit unit = Unit.INSTANCE;
                        fragmentPartProvider2.setPartManager(partManager);
                    }
                    FragmentPartProvider fragmentPartProvider3 = FragmentPartProvider.this;
                    fragmentPartProvider3.dispatchPartInit(fragmentPartProvider3.getContentView(), FragmentPartProvider.this.getParentView(), savedInstanceState);
                }
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewDestroyed(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
                Intrinsics.checkNotNullParameter(fm5, "fm");
                Intrinsics.checkNotNullParameter(f16, "f");
                super.onFragmentViewDestroyed(fm5, f16);
                if (f16 == FragmentPartProvider.this.getHost().getHostFragment()) {
                    PartManager partManager = FragmentPartProvider.this.getPartManager();
                    if (partManager != null) {
                        partManager.onPartDestroy(FragmentPartProvider.this.getHost().getHostFragment().requireActivity());
                    }
                    FragmentPartProvider.this.setPartManager(null);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchPartInit(View contentView, ViewGroup parentView, Bundle savedInstanceState) {
        PartManager partManager = this.partManager;
        if (partManager != null) {
            partManager.setParentView(parentView);
            partManager.setRootView(contentView);
            partManager.onPartCreate(this.host.getHostFragment().requireActivity(), savedInstanceState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Part> getInitPartList() {
        ArrayList<String> stringArrayList;
        ArrayList arrayList = new ArrayList();
        Bundle arguments = this.host.getHostFragment().getArguments();
        if (arguments != null && (stringArrayList = arguments.getStringArrayList(BasePartFragment.INIT_PART_LIST_CLASS_NAME)) != null) {
            Intrinsics.checkNotNullExpressionValue(stringArrayList, "args.getStringArrayList(\u2026   ?: return initPartList");
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    Part instantiate = PartFactory.instantiate(FragmentPartProvider.class.getClassLoader(), next);
                    Intrinsics.checkNotNullExpressionValue(instantiate, "PartFactory.instantiate(\u2026ss.classLoader, partName)");
                    arrayList.add(instantiate);
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final View getContentView() {
        View view = this.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        }
        return view;
    }

    @NotNull
    public final IPartFragmentHost getHost() {
        return this.host;
    }

    @NotNull
    public final ViewGroup getParentView() {
        ViewGroup viewGroup = this.parentView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentView");
        }
        return viewGroup;
    }

    @Nullable
    public final PartManager getPartManager() {
        return this.partManager;
    }

    public final void initProvider() {
        this.host.getHostFragment().getParentFragmentManager().registerFragmentLifecycleCallbacks(this.mInnerFragLifecycleCallbacks, false);
    }

    public final void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.contentView = view;
    }

    public final void setParentView(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.parentView = viewGroup;
    }

    public final void setPartManager(@Nullable PartManager partManager) {
        this.partManager = partManager;
    }
}
