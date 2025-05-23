package com.tencent.mobileqq.troop.troopcard.reborn.essence;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H&J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\"\u0010\u001c\u001a\u00020\u00158\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceTabBaseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "qh", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "ph", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "rh", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class TroopEssenceTabBaseFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    protected RecyclerView recyclerView;

    public TroopEssenceTabBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    protected final RecyclerView getRecyclerView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    /* renamed from: getViewModelStore */
    public ViewModelStore get_viewModelStore() {
        ViewModelStore viewModelStore;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ViewModelStore) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            viewModelStore = parentFragment.get_viewModelStore();
        } else {
            viewModelStore = null;
        }
        if (viewModelStore == null) {
            ViewModelStore viewModelStore2 = super.get_viewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore2, "super.getViewModelStore()");
            return viewModelStore2;
        }
        return viewModelStore;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            inflate = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.h5y, container, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.f71833p8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_layout)");
        rh((RecyclerView) findViewById);
        RecyclerView recyclerView = getRecyclerView();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        recyclerView.setLayoutManager(qh(context));
        getRecyclerView().setAdapter(ph());
    }

    @NotNull
    public abstract RecyclerView.Adapter<?> ph();

    @NotNull
    public RecyclerView.LayoutManager qh(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RecyclerView.LayoutManager) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new LinearLayoutManager(context);
    }

    protected final void rh(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.recyclerView = recyclerView;
        }
    }
}
