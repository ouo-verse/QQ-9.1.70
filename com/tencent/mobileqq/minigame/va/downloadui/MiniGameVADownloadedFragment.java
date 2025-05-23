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
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.databinding.MiniGameDownloadedBinding;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u0012H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadedFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "binding", "Lcom/tencent/mobileqq/mini/databinding/MiniGameDownloadedBinding;", "downloadedAdapter", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadedAdapter;", "getDownloadedAdapter", "()Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadedAdapter;", "downloadedAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadViewModel;", "viewModel$delegate", "getAdapter", "init", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDestroyView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "setEmptyView", "visibility", "", "showEmptyViewIfNeed", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVADownloadedFragment extends QPublicBaseFragment {
    private MiniGameDownloadedBinding binding;

    /* renamed from: downloadedAdapter$delegate, reason: from kotlin metadata */
    private final Lazy downloadedAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public MiniGameVADownloadedFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniGameVADownloadViewModel>() { // from class: com.tencent.mobileqq.minigame.va.downloadui.MiniGameVADownloadedFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniGameVADownloadViewModel invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(MiniGameVADownloadedFragment.this.getQBaseActivity()).get(MiniGameVADownloadViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(qBas\u2026oadViewModel::class.java)");
                return (MiniGameVADownloadViewModel) viewModel;
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MiniGameDownloadedAdapter>() { // from class: com.tencent.mobileqq.minigame.va.downloadui.MiniGameVADownloadedFragment$downloadedAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniGameDownloadedAdapter invoke() {
                QBaseActivity qBaseActivity = MiniGameVADownloadedFragment.this.getQBaseActivity();
                Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
                return new MiniGameDownloadedAdapter(qBaseActivity);
            }
        });
        this.downloadedAdapter = lazy2;
    }

    private final MiniGameDownloadedAdapter getDownloadedAdapter() {
        return (MiniGameDownloadedAdapter) this.downloadedAdapter.getValue();
    }

    private final void init() {
        MiniGameDownloadedBinding miniGameDownloadedBinding = this.binding;
        if (miniGameDownloadedBinding == null) {
            return;
        }
        RecyclerView recyclerView = miniGameDownloadedBinding.list;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getDownloadedAdapter());
        getDownloadedAdapter().setOnItemClickListener(new DownloadedItemClickListener() { // from class: com.tencent.mobileqq.minigame.va.downloadui.MiniGameVADownloadedFragment$init$2
            @Override // com.tencent.mobileqq.minigame.va.downloadui.DownloadedItemClickListener
            public void onItemDeleteClick(MiniGameDownloadDataWrapper data) {
                MiniGameVADownloadViewModel viewModel;
                Intrinsics.checkNotNullParameter(data, "data");
                viewModel = MiniGameVADownloadedFragment.this.getViewModel();
                viewModel.deleteVAGame(data);
                MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929239", "20", data.getData().getGameId(), null);
            }

            @Override // com.tencent.mobileqq.minigame.va.downloadui.DownloadedItemClickListener
            public void onOpenMiniGameClick(MiniGameDownloadDataWrapper data) {
                MiniGameVADownloadViewModel viewModel;
                Map mapOf;
                Intrinsics.checkNotNullParameter(data, "data");
                viewModel = MiniGameVADownloadedFragment.this.getViewModel();
                viewModel.openVAGame(data);
                String versionCode = data.getData().getVersionCode();
                if (versionCode == null) {
                    versionCode = "";
                }
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ext6", versionCode));
                MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929240", "20", data.getData().getGameId(), mapOf);
            }
        });
        getViewModel().getDownloadedDatas().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.minigame.va.downloadui.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniGameVADownloadedFragment.init$lambda$1(MiniGameVADownloadedFragment.this, (List) obj);
            }
        });
        getViewModel().getCurChangePayloadData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.minigame.va.downloadui.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniGameVADownloadedFragment.init$lambda$2(MiniGameVADownloadedFragment.this, (MiniGameDownloadDataWrapper) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(MiniGameVADownloadedFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiniGameDownloadedAdapter downloadedAdapter = this$0.getDownloadedAdapter();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        downloadedAdapter.updateList(it);
        this$0.showEmptyViewIfNeed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(MiniGameVADownloadedFragment this$0, MiniGameDownloadDataWrapper it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.getDownloadStatus();
        if (it.getDownloadStatus() != 9) {
            this$0.getDownloadedAdapter().deleteData(it.getData().getGameId());
        } else {
            MiniGameDownloadedAdapter downloadedAdapter = this$0.getDownloadedAdapter();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            downloadedAdapter.insert(it, 0);
        }
        this$0.showEmptyViewIfNeed();
    }

    private final void showEmptyViewIfNeed() {
        if (getAdapter().getItemCount() == 0) {
            setEmptyView(0);
        } else {
            setEmptyView(4);
        }
    }

    public final MiniGameDownloadedAdapter getAdapter() {
        return getDownloadedAdapter();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MiniGameDownloadedBinding inflate = MiniGameDownloadedBinding.inflate(inflater, container, false);
        this.binding = inflate;
        if (inflate != null) {
            return inflate.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
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
        MiniGameDownloadedBinding miniGameDownloadedBinding = this.binding;
        LinearLayout linearLayout = miniGameDownloadedBinding != null ? miniGameDownloadedBinding.emptyView : null;
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
