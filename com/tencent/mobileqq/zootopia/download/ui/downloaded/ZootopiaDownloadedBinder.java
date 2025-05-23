package com.tencent.mobileqq.zootopia.download.ui.downloaded;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadViewModel;
import com.tencent.mobileqq.zootopia.download.ui.downloading.DownloadingPayloadData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qv4.v;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/downloaded/ZootopiaDownloadedBinder;", "", "Lcom/tencent/mobileqq/zootopia/download/ui/downloaded/ZootopiaDownloadedFragment;", "fragment", "", "l", "", "mapId", "Landroid/content/Context;", "context", "", "k", "Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadViewModel;", "viewModel", "g", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadedBinder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    public ZootopiaDownloadedBinder(ZootopiaSource sourceCurrent) {
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.sourceCurrent = sourceCurrent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(f downloadedAdapter, ZootopiaDownloadedBinder this$0, ZootopiaDownloadedFragment fragment, List it) {
        Intrinsics.checkNotNullParameter(downloadedAdapter, "$downloadedAdapter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        downloadedAdapter.updateList(it);
        this$0.l(fragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(f downloadedAdapter, ZootopiaDownloadViewModel viewModel, ZootopiaDownloadedBinder this$0, ZootopiaDownloadedFragment fragment, DownloadingPayloadData downloadingPayloadData) {
        Intrinsics.checkNotNullParameter(downloadedAdapter, "$downloadedAdapter");
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        if (downloadingPayloadData.getDownloadStatus() == null) {
            return;
        }
        Integer downloadStatus = downloadingPayloadData.getDownloadStatus();
        if (downloadStatus == null || downloadStatus.intValue() != 5) {
            downloadedAdapter.deleteData(downloadingPayloadData.getId());
        } else {
            com.tencent.mobileqq.zootopia.download.ui.d U1 = viewModel.U1(downloadingPayloadData.getId());
            if (U1 != null) {
                downloadedAdapter.l0(U1, 0);
            }
        }
        this$0.l(fragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(f downloadedAdapter, v it) {
        Intrinsics.checkNotNullParameter(downloadedAdapter, "$downloadedAdapter");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        downloadedAdapter.p0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(int mapId, Context context) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(ZootopiaDownloadedFragment fragment) {
        if (fragment.rh().getItemCount() == 0) {
            fragment.setEmptyView(0);
        } else {
            fragment.setEmptyView(4);
        }
    }

    public final void g(final ZootopiaDownloadedFragment fragment, final ZootopiaDownloadViewModel viewModel) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        final f rh5 = fragment.rh();
        rh5.N0(new ZootopiaDownloadedBinder$bind$1(this, fragment, viewModel, rh5));
        viewModel.getDownloadedDatas().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDownloadedBinder.h(f.this, this, fragment, (List) obj);
            }
        });
        viewModel.getCurChangePayloadData().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDownloadedBinder.i(f.this, viewModel, this, fragment, (DownloadingPayloadData) obj);
            }
        });
        viewModel.W1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDownloadedBinder.j(f.this, (v) obj);
            }
        });
    }
}
