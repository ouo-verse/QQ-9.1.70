package com.tencent.mobileqq.zootopia.ueloading;

import android.view.View;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc;
import com.tencent.mobileqq.zootopia.view.ZPlanUEDialogView;
import com.tencent.mobileqq.zootopia.view.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.report.SquareReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\rB+\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b&\u0010'J2\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\"\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUEDialogController;", "Lud3/b;", "", "title", "msg", "cancelBtn", "confirmBtn", "Lcom/tencent/mobileqq/zootopia/view/b;", "listener", "", "a", tl.h.F, "i", "b", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "f", "()Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "loadingController", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "d", "()Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "c", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "e", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "g", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "<init>", "(Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUEDialogController implements ud3.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZPlanUELoadingController loadingController;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaUEActivity activity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaEnterParams enterParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZplanViewReportHelper reportHelper;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUEDialogController$a", "Lcom/tencent/mobileqq/zootopia/download/ui/b;", "", "p0", "", "onNetWifi2Mobile", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends com.tencent.mobileqq.zootopia.download.ui.b {
        a() {
        }

        @Override // com.tencent.mobileqq.zootopia.download.ui.b, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String p06) {
            super.onNetWifi2Mobile(p06);
            ZPlanUEDialogController.this.i();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUEDialogController$c", "Lcom/tencent/mobileqq/zootopia/view/b;", "Landroid/view/View;", "view", "", "c", "a", "d", "b", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.view.b {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUEDialogController$c$a", "Lcom/tencent/mobileqq/zootopia/view/a;", "", "errorCode", "", "errorMessage", "", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a extends com.tencent.mobileqq.zootopia.view.a {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ZPlanUEDialogController f329362b;

            a(ZPlanUEDialogController zPlanUEDialogController) {
                this.f329362b = zPlanUEDialogController;
            }

            @Override // com.tencent.mobileqq.zootopia.view.a, com.tencent.mobileqq.zootopia.ipc.ah
            public void onFailed(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                super.onFailed(errorCode, errorMessage);
                if (errorCode == -87604) {
                    this.f329362b.getActivity().finish();
                }
            }
        }

        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.d("ZPlanUEDialogController", 1, "handleDownloadError, click confirm");
            ZplanViewReportHelper.f(ZPlanUEDialogController.this.reportHelper, view, "em_zplan_loading_unusual_pop_retry", null, 4, null);
            if (ZPlanUEDialogController.this.getEnterParams() == null) {
                ZPlanUEDialogController.this.getActivity().finish();
            } else {
                ZootopiaDownloadManagerIpc.f328013a.o(ZPlanUEDialogController.this.getEnterParams().getMapId(), new a(ZPlanUEDialogController.this), ZPlanUEDialogController.this.getActivity());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            b.a.b(this, view);
            ZPlanUEDialogController.this.reportHelper.g(view, "em_zplan_loading_unusual_pop_call", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void c(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.d("ZPlanUEDialogController", 1, "handleDownloadError, click cancel");
            ZplanViewReportHelper.f(ZPlanUEDialogController.this.reportHelper, view, "em_zplan_loading_unusual_pop_call", null, 4, null);
            ZPlanUEDialogController.this.getActivity().finish();
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void d(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ZPlanUEDialogController.this.reportHelper.g(view, "em_zplan_loading_unusual_pop", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void e(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            b.a.c(this, view);
            ZPlanUEDialogController.this.reportHelper.g(view, "em_zplan_loading_unusual_pop_retry", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUEDialogController$d", "Lcom/tencent/mobileqq/zootopia/view/b;", "Landroid/view/View;", "view", "", "c", "a", "d", "b", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.view.b {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUEDialogController$d$a", "Lcom/tencent/mobileqq/zootopia/view/a;", "", "errorCode", "", "errorMessage", "", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a extends com.tencent.mobileqq.zootopia.view.a {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ZPlanUEDialogController f329364b;

            a(ZPlanUEDialogController zPlanUEDialogController) {
                this.f329364b = zPlanUEDialogController;
            }

            @Override // com.tencent.mobileqq.zootopia.view.a, com.tencent.mobileqq.zootopia.ipc.ah
            public void onFailed(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                super.onFailed(errorCode, errorMessage);
                if (errorCode == -87604) {
                    this.f329364b.getActivity().finish();
                }
            }
        }

        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.d("ZPlanUEDialogController", 1, "handleNetworkVolumeWarning, click confirm");
            if (ZPlanUEDialogController.this.getEnterParams() == null) {
                ZPlanUEDialogController.this.getActivity().finish();
            } else {
                ZplanViewReportHelper.f(ZPlanUEDialogController.this.reportHelper, view, "em_zplan_floating_pop_wifi_confirm", null, 4, null);
                ZootopiaDownloadManagerIpc.f328013a.o(ZPlanUEDialogController.this.getEnterParams().getMapId(), new a(ZPlanUEDialogController.this), ZPlanUEDialogController.this.getActivity());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ZPlanUEDialogController.this.reportHelper.g(view, "em_zplan_floating_pop_call", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void c(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.d("ZPlanUEDialogController", 1, "handleNetworkVolumeWarning, click cancel");
            ZplanViewReportHelper.f(ZPlanUEDialogController.this.reportHelper, view, "em_zplan_floating_pop_call", null, 4, null);
            ZPlanUEDialogController.this.getActivity().finish();
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void d(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ZPlanUEDialogController.this.reportHelper.g(view, "em_zplan_floating_wifi_pop", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void e(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ZPlanUEDialogController.this.reportHelper.g(view, "em_zplan_floating_pop_wifi_confirm", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUEDialogController$e", "Lcom/tencent/mobileqq/zootopia/view/b;", "Landroid/view/View;", "view", "", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.view.b {
        e() {
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.i("ZPlanUEDialogController", 1, "showErrorDialog, exit");
            ZPlanUEDialogController.this.getActivity().finish();
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void b(View view) {
            b.a.b(this, view);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void c(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void d(View view) {
            b.a.a(this, view);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void e(View view) {
            b.a.c(this, view);
        }
    }

    public ZPlanUEDialogController(ZPlanUELoadingController loadingController, ZootopiaUEActivity activity, ZootopiaEnterParams zootopiaEnterParams, ZootopiaSource zootopiaSource) {
        Intrinsics.checkNotNullParameter(loadingController, "loadingController");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.loadingController = loadingController;
        this.activity = activity;
        this.enterParams = zootopiaEnterParams;
        this.source = zootopiaSource;
        this.reportHelper = new ZplanViewReportHelper();
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.context, new a());
    }

    @Override // ud3.b
    public void a(final String title, final String msg2, final String cancelBtn, final String confirmBtn, final com.tencent.mobileqq.zootopia.view.b listener) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(cancelBtn, "cancelBtn");
        Intrinsics.checkNotNullParameter(confirmBtn, "confirmBtn");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUEDialogController$showUEDialog$1
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
                Map<String, Object> mutableMapOf;
                ZPlanUEDialogView zPlanUEDialogView = new ZPlanUEDialogView(ZPlanUEDialogController.this.getActivity(), null, ZPlanUEDialogController.this.getSource(), 2, null);
                ZPlanUEDialogController zPlanUEDialogController = ZPlanUEDialogController.this;
                String str = title;
                String str2 = msg2;
                String str3 = cancelBtn;
                String str4 = confirmBtn;
                com.tencent.mobileqq.zootopia.view.b bVar = listener;
                zPlanUEDialogController.getLoadingController().e(zPlanUEDialogView, 2);
                zPlanUEDialogView.e(str, str2, str3, str4, bVar);
                ZplanViewReportHelper zplanViewReportHelper = ZPlanUEDialogController.this.reportHelper;
                ZootopiaUEActivity activity = ZPlanUEDialogController.this.getActivity();
                Pair[] pairArr = new Pair[1];
                ZootopiaSource source = ZPlanUEDialogController.this.getSource();
                if (source == null) {
                    source = ZootopiaSource.INSTANCE.g();
                }
                pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, source);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                zplanViewReportHelper.a(activity, zPlanUEDialogView, "pg_zplan_xiaowo_loading", mutableMapOf);
            }
        });
    }

    @Override // ud3.b
    public void b() {
        a("", "\u5c0f\u7a9d\u8fdb\u7a0b\u5f02\u5e38\uff0c\u65e0\u6cd5\u8fdb\u5165\uff0c\u5c06\u4e3a\u4f60\u5173\u95edloading\u8fdb\u7a0b", "", "\u786e\u8ba4", new e());
    }

    /* renamed from: d, reason: from getter */
    public final ZootopiaUEActivity getActivity() {
        return this.activity;
    }

    /* renamed from: e, reason: from getter */
    public final ZootopiaEnterParams getEnterParams() {
        return this.enterParams;
    }

    /* renamed from: f, reason: from getter */
    public final ZPlanUELoadingController getLoadingController() {
        return this.loadingController;
    }

    /* renamed from: g, reason: from getter */
    public final ZootopiaSource getSource() {
        return this.source;
    }

    public void h() {
        a("", "\u4e0b\u8f7d\u5f02\u5e38\uff0c\u8bf7\u786e\u8ba4\u7f51\u7edc\u72b6\u6001\u540e\u91cd\u8bd5", "\u53d6\u6d88", "\u786e\u8ba4", new c());
    }

    public void i() {
        a("", "\u5f53\u524d\u5904\u4e8e\u975eWi-Fi\u7f51\u7edc", "\u53d6\u6d88", "\u786e\u8ba4", new d());
    }
}
