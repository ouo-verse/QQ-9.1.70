package com.tencent.mobileqq.zootopia.download.ui.downloading;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.zootopia.download.DownloadDialogUtils;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadViewModel;
import com.tencent.mobileqq.zootopia.space.MapOccupiedSpaceManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qv4.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/downloading/ZootopiaDownloadingBinder;", "", "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/ZootopiaDownloadingFragment;", "fragment", "", "k", "Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadViewModel;", "viewModel", "f", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadingBinder {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e downloadingAdapter, ZootopiaDownloadingBinder this$0, ZootopiaDownloadingFragment fragment, List it) {
        Intrinsics.checkNotNullParameter(downloadingAdapter, "$downloadingAdapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        downloadingAdapter.updateList(it);
        this$0.k(fragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(e downloadingAdapter, ZootopiaDownloadingBinder this$0, ZootopiaDownloadingFragment fragment, DownloadingPayloadData it) {
        Intrinsics.checkNotNullParameter(downloadingAdapter, "$downloadingAdapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Integer downloadStatus = it.getDownloadStatus();
        if (downloadStatus != null && downloadStatus.intValue() == 5) {
            downloadingAdapter.deleteData(it.getId());
            this$0.k(fragment);
        } else {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            downloadingAdapter.o0(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(e downloadingAdapter, ZootopiaDownloadingBinder this$0, ZootopiaDownloadingFragment fragment, com.tencent.mobileqq.zootopia.download.ui.d it) {
        Intrinsics.checkNotNullParameter(downloadingAdapter, "$downloadingAdapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.zootopia.download.ui.a.m0(downloadingAdapter, it, null, 2, null);
        this$0.k(fragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(e downloadingAdapter, v it) {
        Intrinsics.checkNotNullParameter(downloadingAdapter, "$downloadingAdapter");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        downloadingAdapter.p0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(ZootopiaDownloadingFragment fragment) {
        if (fragment.getDownloadingAdapter().getNUM_BACKGOURND_ICON() == 0) {
            fragment.setEmptyView(0);
        } else {
            fragment.setEmptyView(4);
        }
    }

    public final void f(final ZootopiaDownloadingFragment fragment, final ZootopiaDownloadViewModel viewModel) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        final e downloadingAdapter = fragment.getDownloadingAdapter();
        downloadingAdapter.F0(new b() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloading.ZootopiaDownloadingBinder$bind$1
            @Override // com.tencent.mobileqq.zootopia.download.ui.downloading.b
            public void a(com.tencent.mobileqq.zootopia.download.ui.d data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ZootopiaDownloadViewModel.this.f2(data);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ui.downloading.b
            public void b(final com.tencent.mobileqq.zootopia.download.ui.d data) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
                QBaseActivity qBaseActivity = fragment.getQBaseActivity();
                Intrinsics.checkNotNullExpressionValue(qBaseActivity, "fragment.qBaseActivity");
                final ZootopiaDownloadViewModel zootopiaDownloadViewModel = ZootopiaDownloadViewModel.this;
                final e eVar = downloadingAdapter;
                final ZootopiaDownloadingBinder zootopiaDownloadingBinder = this;
                final ZootopiaDownloadingFragment zootopiaDownloadingFragment = fragment;
                downloadDialogUtils.h(qBaseActivity, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloading.ZootopiaDownloadingBinder$bind$1$onItemCancelDownloadClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        if (z16) {
                            QLog.i("ZootopiaDownloadingBinder", 1, "cancelDownload " + com.tencent.mobileqq.zootopia.download.ui.d.this.getData().getSummaryData().getId());
                            zootopiaDownloadViewModel.R1(com.tencent.mobileqq.zootopia.download.ui.d.this);
                            eVar.deleteData(com.tencent.mobileqq.zootopia.download.ui.d.this.getData().getSummaryData().getId());
                            zootopiaDownloadingBinder.k(zootopiaDownloadingFragment);
                            MapOccupiedSpaceManager.t(MapOccupiedSpaceManager.f329259b, com.tencent.mobileqq.zootopia.download.ui.d.this.getData().getSummaryData().getId(), null, 2, null);
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.download.ui.downloading.b
            public void c(com.tencent.mobileqq.zootopia.download.ui.d data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ZootopiaDownloadViewModel.this.b2(data);
            }
        });
        viewModel.getDownloadingDatas().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloading.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDownloadingBinder.g(e.this, this, fragment, (List) obj);
            }
        });
        viewModel.getCurChangePayloadData().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloading.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDownloadingBinder.h(e.this, this, fragment, (DownloadingPayloadData) obj);
            }
        });
        viewModel.T1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloading.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDownloadingBinder.i(e.this, this, fragment, (com.tencent.mobileqq.zootopia.download.ui.d) obj);
            }
        });
        viewModel.W1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloading.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDownloadingBinder.j(e.this, (v) obj);
            }
        });
    }
}
