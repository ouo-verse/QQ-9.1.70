package com.tencent.mobileqq.zootopia.download.ui.downloading;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaSpaceApi;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaBaseDownloadFragment;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadViewModel;
import fi3.o;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/downloading/ZootopiaDownloadingFragment;", "Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaBaseDownloadFragment;", "", "init", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "id", "ph", "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/e;", "qh", "", "visibility", "setEmptyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "D", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSourceCurrent", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sh", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "sourceCurrent", "Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadViewModel;", "E", "Lkotlin/Lazy;", "rh", "()Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadViewModel;", "viewModel", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/e;", "downloadingAdapter", "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/ZootopiaDownloadingBinder;", "G", "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/ZootopiaDownloadingBinder;", "binder", "Lfi3/o;", "H", "Lfi3/o;", "binding", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadingFragment extends ZootopiaBaseDownloadFragment {

    /* renamed from: D, reason: from kotlin metadata */
    private ZootopiaSource sourceCurrent = ZootopiaSource.INSTANCE.i();

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private final e downloadingAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private final ZootopiaDownloadingBinder binder;

    /* renamed from: H, reason: from kotlin metadata */
    private o binding;

    public ZootopiaDownloadingFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaDownloadViewModel>() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloading.ZootopiaDownloadingFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaDownloadViewModel invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(ZootopiaDownloadingFragment.this.getQBaseActivity()).get(ZootopiaDownloadViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(qBas\u2026oadViewModel::class.java)");
                return (ZootopiaDownloadViewModel) viewModel;
            }
        });
        this.viewModel = lazy;
        this.downloadingAdapter = new e();
        this.binder = new ZootopiaDownloadingBinder();
    }

    private final void init() {
        o oVar = this.binding;
        if (oVar == null) {
            return;
        }
        RecyclerView recyclerView = oVar.f399314c;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.downloadingAdapter);
        this.binder.f(this, rh());
    }

    private final ZootopiaDownloadViewModel rh() {
        return (ZootopiaDownloadViewModel) this.viewModel.getValue();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        o g16 = o.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zootopia.download.ui.ZootopiaBaseDownloadFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override // com.tencent.mobileqq.zootopia.download.ui.ZootopiaBaseDownloadFragment
    public void ph(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        getDownloadingAdapter().deleteData(id5);
        ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).onTaskDelete(id5, this.sourceCurrent);
    }

    /* renamed from: qh, reason: from getter */
    public final e getDownloadingAdapter() {
        return this.downloadingAdapter;
    }

    public final void setEmptyView(int visibility) {
        o oVar = this.binding;
        LinearLayout linearLayout = oVar != null ? oVar.f399313b : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(visibility);
    }

    public final void sh(ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(zootopiaSource, "<set-?>");
        this.sourceCurrent = zootopiaSource;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
    }
}
