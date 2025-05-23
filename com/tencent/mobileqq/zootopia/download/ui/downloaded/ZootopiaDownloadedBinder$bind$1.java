package com.tencent.mobileqq.zootopia.download.ui.downloaded;

import android.app.Activity;
import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.download.DownloadDialogUtils;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadViewModel;
import com.tencent.mobileqq.zootopia.space.MapOccupiedSpaceManager;
import com.tencent.mobileqq.zootopia.space.MapSpaceInfo;
import com.tencent.mobileqq.zplan.smallhome.floatwindow.ZPlanFloatWindowManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import si3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/zootopia/download/ui/downloaded/ZootopiaDownloadedBinder$bind$1", "Lcom/tencent/mobileqq/zootopia/download/ui/downloaded/a;", "Lcom/tencent/mobileqq/zootopia/download/ui/d;", "data", "", tl.h.F, "", "resId", "Landroid/app/Dialog;", "i", "e", "d", "b", "a", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadedBinder$bind$1 implements a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ZootopiaDownloadedBinder f328233a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ZootopiaDownloadedFragment f328234b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ZootopiaDownloadViewModel f328235c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ f f328236d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZootopiaDownloadedBinder$bind$1(ZootopiaDownloadedBinder zootopiaDownloadedBinder, ZootopiaDownloadedFragment zootopiaDownloadedFragment, ZootopiaDownloadViewModel zootopiaDownloadViewModel, f fVar) {
        this.f328233a = zootopiaDownloadedBinder;
        this.f328234b = zootopiaDownloadedFragment;
        this.f328235c = zootopiaDownloadViewModel;
        this.f328236d = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(com.tencent.mobileqq.zootopia.download.ui.d data) {
        ZPlanFloatWindowManager.f335646d.b(data.getData().getSummaryData().getId());
        final Dialog i3 = i(R.string.xin);
        MapOccupiedSpaceManager.f329259b.u(data.getData().getSummaryData().getId(), new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.ZootopiaDownloadedBinder$bind$1$cleanCacheOnly$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Dialog dialog = i3;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog i(int resId) {
        QBaseActivity qBaseActivity = this.f328234b.getQBaseActivity();
        QBaseActivity qBaseActivity2 = qBaseActivity instanceof Activity ? qBaseActivity : null;
        if (!((qBaseActivity2 == null || qBaseActivity2.isFinishing()) ? false : true)) {
            return null;
        }
        Dialog showLoadingDialog = DialogUtil.showLoadingDialog(qBaseActivity, qBaseActivity.getResources().getString(resId), false);
        showLoadingDialog.show();
        return showLoadingDialog;
    }

    @Override // com.tencent.mobileqq.zootopia.download.ui.downloaded.a
    public void a(final com.tencent.mobileqq.zootopia.download.ui.d data) {
        Map<String, String> mutableMapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("ZootopiaDownloadedBinder", 1, "onItemAutoCleanCache - " + data.getData().getSummaryData().getId() + " - " + data.getData().getSummaryData().getTitle());
        MapSpaceInfo value = MapOccupiedSpaceManager.f329259b.A(data.getData().getSummaryData().getId()).getValue();
        long cacheOccupiedSize = value != null ? value.getCacheOccupiedSize() : 0L;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_map_id", data.getData().getSummaryData().getId()));
        DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
        QBaseActivity qBaseActivity = this.f328234b.getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "fragment.qBaseActivity");
        downloadDialogUtils.j(qBaseActivity, data.getData().getSummaryData().getTitle(), cacheOccupiedSize, mutableMapOf, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.ZootopiaDownloadedBinder$bind$1$onItemAutoCleanCache$1
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
                    ZootopiaDownloadedBinder$bind$1.this.h(data);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.download.ui.downloaded.a
    public void c(com.tencent.mobileqq.zootopia.download.ui.d data) {
        boolean k3;
        ZootopiaSource zootopiaSource;
        Intrinsics.checkNotNullParameter(data, "data");
        k3 = this.f328233a.k(data.getData().getResData().getId(), this.f328234b.getContext());
        if (k3) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaApi::class.java)");
        FragmentActivity requireActivity = this.f328234b.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        int id5 = data.getData().getResData().getId();
        zootopiaSource = this.f328233a.sourceCurrent;
        IZootopiaApi.a.a((IZootopiaApi) api, requireActivity, id5, zootopiaSource, false, null, 24, null);
    }

    @Override // com.tencent.mobileqq.zootopia.download.ui.downloaded.a
    public void d(com.tencent.mobileqq.zootopia.download.ui.d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("ZootopiaDownloadedBinder", 1, "onItemUpdateClick - " + data.getData().getSummaryData().getId() + " - " + data.getData().getSummaryData().getTitle());
        data.k(null);
        data.m(null);
        if (data.getStatus() == MapStatus.MAP_STATUS_UPDATE) {
            data.o(null);
        }
        this.f328235c.f2(data);
    }

    @Override // com.tencent.mobileqq.zootopia.download.ui.downloaded.a
    public void e(com.tencent.mobileqq.zootopia.download.ui.d data) {
        boolean k3;
        ZootopiaSource zootopiaSource;
        Intrinsics.checkNotNullParameter(data, "data");
        k3 = this.f328233a.k(data.getData().getResData().getId(), this.f328234b.getContext());
        if (k3) {
            return;
        }
        si3.c cVar = (si3.c) vb3.a.f441346a.a(si3.c.class);
        int id5 = data.getData().getResData().getId();
        zootopiaSource = this.f328233a.sourceCurrent;
        c.a.a(cVar, id5, zootopiaSource, null, null, 12, null);
    }

    @Override // com.tencent.mobileqq.zootopia.download.ui.downloaded.a
    public void b(final com.tencent.mobileqq.zootopia.download.ui.d data) {
        Map<String, String> mutableMapOf;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("ZootopiaDownloadedBinder", 1, "onItemDeleteClick - " + data.getData().getSummaryData().getId() + " - " + data.getData().getSummaryData().getTitle());
        MapSpaceInfo value = MapOccupiedSpaceManager.f329259b.A(data.getData().getSummaryData().getId()).getValue();
        long cacheOccupiedSize = value != null ? value.getCacheOccupiedSize() : 0L;
        long mainOccupiedSize = value != null ? value.getMainOccupiedSize() : 0L;
        if (mainOccupiedSize == 0) {
            mainOccupiedSize = data.getData().getResData().getSize();
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_map_id", data.getData().getSummaryData().getId()));
        DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
        QBaseActivity qBaseActivity = this.f328234b.getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "fragment.qBaseActivity");
        final ZootopiaDownloadViewModel zootopiaDownloadViewModel = this.f328235c;
        final f fVar = this.f328236d;
        final ZootopiaDownloadedBinder zootopiaDownloadedBinder = this.f328233a;
        final ZootopiaDownloadedFragment zootopiaDownloadedFragment = this.f328234b;
        downloadDialogUtils.i(qBaseActivity, mainOccupiedSize + cacheOccupiedSize, cacheOccupiedSize, mutableMapOf, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.ZootopiaDownloadedBinder$bind$1$onItemDeleteClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                final Dialog i16;
                QLog.i("ZootopiaDownloadedBinder", 1, "onItemDeleteClick#ask - " + com.tencent.mobileqq.zootopia.download.ui.d.this.getData().getSummaryData().getId() + " - " + com.tencent.mobileqq.zootopia.download.ui.d.this.getData().getSummaryData().getTitle() + ", choose " + i3);
                if (i3 != 0) {
                    if (i3 != 1) {
                        return;
                    }
                    this.h(com.tencent.mobileqq.zootopia.download.ui.d.this);
                } else {
                    i16 = this.i(R.string.xio);
                    zootopiaDownloadViewModel.S1(com.tencent.mobileqq.zootopia.download.ui.d.this);
                    fVar.deleteData(com.tencent.mobileqq.zootopia.download.ui.d.this.getData().getSummaryData().getId());
                    zootopiaDownloadedBinder.l(zootopiaDownloadedFragment);
                    MapOccupiedSpaceManager.f329259b.s(com.tencent.mobileqq.zootopia.download.ui.d.this.getData().getSummaryData().getId(), new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.ZootopiaDownloadedBinder$bind$1$onItemDeleteClick$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Dialog dialog = i16;
                            if (dialog != null) {
                                dialog.dismiss();
                            }
                        }
                    });
                }
            }
        });
    }
}
