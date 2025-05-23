package com.tencent.mobileqq.minigame.va.downloadui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.databinding.MiniGameDownloadingBinding;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "binding", "Lcom/tencent/mobileqq/mini/databinding/MiniGameDownloadingBinding;", "downloadingAdapter", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadingAdapter;", "viewModel", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getAdapter", "init", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "setEmptyView", "visibility", "", "showEmptyViewIfNeed", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVADownloadingFragment extends QPublicBaseFragment {
    private MiniGameDownloadingBinding binding;
    private final MiniGameDownloadingAdapter downloadingAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public MiniGameVADownloadingFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniGameVADownloadViewModel>() { // from class: com.tencent.mobileqq.minigame.va.downloadui.MiniGameVADownloadingFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniGameVADownloadViewModel invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(MiniGameVADownloadingFragment.this.getQBaseActivity()).get(MiniGameVADownloadViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(qBas\u2026oadViewModel::class.java)");
                return (MiniGameVADownloadViewModel) viewModel;
            }
        });
        this.viewModel = lazy;
        this.downloadingAdapter = new MiniGameDownloadingAdapter();
    }

    private final void init() {
        MiniGameDownloadingBinding miniGameDownloadingBinding = this.binding;
        if (miniGameDownloadingBinding == null) {
            return;
        }
        RecyclerView recyclerView = miniGameDownloadingBinding.list;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.downloadingAdapter);
        this.downloadingAdapter.setItemClickListener(new DownloadingItemClickListener() { // from class: com.tencent.mobileqq.minigame.va.downloadui.MiniGameVADownloadingFragment$init$2
            @Override // com.tencent.mobileqq.minigame.va.downloadui.DownloadingItemClickListener
            public void onItemCancelDownloadClick(MiniGameDownloadDataWrapper data) {
                MiniGameVADownloadViewModel viewModel;
                Intrinsics.checkNotNullParameter(data, "data");
                viewModel = MiniGameVADownloadingFragment.this.getViewModel();
                viewModel.cancelDownload(data);
            }

            @Override // com.tencent.mobileqq.minigame.va.downloadui.DownloadingItemClickListener
            public void onItemPauseDownloadClick(MiniGameDownloadDataWrapper data) {
                MiniGameVADownloadViewModel viewModel;
                Intrinsics.checkNotNullParameter(data, "data");
                viewModel = MiniGameVADownloadingFragment.this.getViewModel();
                viewModel.pauseDownload(data);
            }

            @Override // com.tencent.mobileqq.minigame.va.downloadui.DownloadingItemClickListener
            public void onItemStartDownloadClick(MiniGameDownloadDataWrapper data) {
                MiniGameVADownloadViewModel viewModel;
                Intrinsics.checkNotNullParameter(data, "data");
                viewModel = MiniGameVADownloadingFragment.this.getViewModel();
                viewModel.startDownload(data);
            }
        });
        getViewModel().getDownloadingDatas().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.minigame.va.downloadui.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniGameVADownloadingFragment.init$lambda$1(MiniGameVADownloadingFragment.this, (List) obj);
            }
        });
        getViewModel().getCurChangePayloadData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.minigame.va.downloadui.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniGameVADownloadingFragment.init$lambda$2(MiniGameVADownloadingFragment.this, (MiniGameDownloadDataWrapper) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(MiniGameVADownloadingFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiniGameDownloadingAdapter miniGameDownloadingAdapter = this$0.downloadingAdapter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        miniGameDownloadingAdapter.updateList(it);
        this$0.showEmptyViewIfNeed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(MiniGameVADownloadingFragment this$0, MiniGameDownloadDataWrapper it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it.getDownloadStatus() != 9 && it.getDownloadStatus() != 10) {
            MiniGameDownloadingAdapter miniGameDownloadingAdapter = this$0.downloadingAdapter;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            miniGameDownloadingAdapter.updateData(it);
        } else {
            this$0.downloadingAdapter.deleteData(it.getData().getGameId());
            this$0.showEmptyViewIfNeed();
        }
    }

    private final void showEmptyViewIfNeed() {
        if (getDownloadingAdapter().getItemCount() == 0) {
            setEmptyView(0);
        } else {
            setEmptyView(4);
        }
    }

    /* renamed from: getAdapter, reason: from getter */
    public final MiniGameDownloadingAdapter getDownloadingAdapter() {
        return this.downloadingAdapter;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MiniGameDownloadingBinding inflate = MiniGameDownloadingBinding.inflate(inflater, container, false);
        this.binding = inflate;
        if (inflate != null) {
            return inflate.getRoot();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    public final void setEmptyView(int visibility) {
        MiniGameDownloadingBinding miniGameDownloadingBinding = this.binding;
        LinearLayout linearLayout = miniGameDownloadingBinding != null ? miniGameDownloadingBinding.emptyView : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(visibility);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniGameVADownloadViewModel getViewModel() {
        return (MiniGameVADownloadViewModel) this.viewModel.getValue();
    }
}
