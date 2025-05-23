package com.tencent.mobileqq.zplan.scheme.impl;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zootopia.ipc.ai;
import com.tencent.mobileqq.zootopia.minors.util.LoadingDialogHelperFragment;
import com.tencent.mobileqq.zootopia.view.z;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPageFrom;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import k74.i;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nv4.m;
import rc3.TargetTask;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J4\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J@\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J>\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J*\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/scheme/impl/c;", "", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lnv4/m;", "template", "Ljava/util/HashMap;", "", "shareExtraParams", "", "isDressAutoPublish", "", "i", "l", "Lcom/tencent/mobileqq/zplan/scheme/impl/c$a;", "cb", "j", "forceStopEngineOnDestroy", DomainData.DOMAIN_NAME, "msg", "o", "Landroid/os/Bundle;", ISchemeApi.KEY_PAGE_DATA, "params", h.F, "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "b", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "engineListener", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f335324a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ZPlanEngineStatusUpdateListener engineListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/scheme/impl/c$a;", "", "", "onFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void onFinish();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/scheme/impl/c$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lnv4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<nv4.c> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f335326d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap<String, Object> f335327e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f335328f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f335329h;

        b(ZootopiaSource zootopiaSource, HashMap<String, Object> hashMap, boolean z16, int i3) {
            this.f335326d = zootopiaSource;
            this.f335327e = hashMap;
            this.f335328f = z16;
            this.f335329h = i3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(nv4.c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZplanSameStyleSchemeHelper_", 1, "onResultSuccess result:" + result);
            m[] mVarArr = result.f421390a;
            m mVar = null;
            if (mVarArr != null) {
                int i3 = this.f335329h;
                int length = mVarArr.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length) {
                        break;
                    }
                    m mVar2 = mVarArr[i16];
                    if (mVar2.f421416a == i3) {
                        mVar = mVar2;
                        break;
                    }
                    i16++;
                }
            }
            if (mVar != null) {
                c.f335324a.i(this.f335326d, mVar, this.f335327e, this.f335328f);
                return;
            }
            QLog.e("ZplanSameStyleSchemeHelper_", 1, "onResultSuccess template is null!");
            c cVar = c.f335324a;
            String string = BaseApplication.context.getString(R.string.f169825xt2);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026samestyle_template_empty)");
            cVar.o(string);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZplanSameStyleSchemeHelper_", 1, "onResultFailure error:" + error + ", message:" + message);
            c cVar = c.f335324a;
            if (message == null) {
                message = BaseApplication.context.getString(R.string.xt6);
                Intrinsics.checkNotNullExpressionValue(message, "context.getString(com.te\u2026_template_request_failed)");
            }
            cVar.o(message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/scheme/impl/c$c", "Lcom/tencent/mobileqq/zootopia/ipc/c;", "", "isReady", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.scheme.impl.c$c, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9196c implements com.tencent.mobileqq.zootopia.ipc.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f335330a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f335331b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ HashMap<String, Object> f335332c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f335333d;

        C9196c(ZootopiaSource zootopiaSource, m mVar, HashMap<String, Object> hashMap, boolean z16) {
            this.f335330a = zootopiaSource;
            this.f335331b = mVar;
            this.f335332c = hashMap;
            this.f335333d = z16;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.c
        public void a(boolean isReady) {
            QLog.i("ZplanSameStyleSchemeHelper_", 1, "launchSameStyleDetailPage isReady:" + isReady);
            if (!isReady) {
                c.f335324a.l(this.f335330a, this.f335331b, this.f335332c, this.f335333d);
            } else {
                c.f335324a.n(this.f335331b, this.f335332c, this.f335333d, this.f335330a, false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/scheme/impl/c$d", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "success", "", "engineInitFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements ZPlanEngineStatusUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ m f335334d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap<String, Object> f335335e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f335336f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f335337h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f335338i;

        d(m mVar, HashMap<String, Object> hashMap, boolean z16, ZootopiaSource zootopiaSource, a aVar) {
            this.f335334d = mVar;
            this.f335335e = hashMap;
            this.f335336f = z16;
            this.f335337h = zootopiaSource;
            this.f335338i = aVar;
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineDestroy() {
            ZPlanEngineStatusUpdateListener.a.a(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public void engineFirstFrame() {
            ZPlanEngineStatusUpdateListener.a.b(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInitFinish(boolean success) {
            QLog.i("ZplanSameStyleSchemeHelper_", 1, "engineInitFinish success:" + success);
            c.f335324a.n(this.f335334d, this.f335335e, this.f335336f, this.f335337h, true);
            a aVar = this.f335338i;
            if (aVar != null) {
                aVar.onFinish();
            }
            ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener = c.engineListener;
            if (zPlanEngineStatusUpdateListener != null) {
                ZPlanServiceHelper.I.a1(zPlanEngineStatusUpdateListener);
            }
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInversePurged() {
            ZPlanEngineStatusUpdateListener.a.d(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurged() {
            ZPlanEngineStatusUpdateListener.a.e(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurging() {
            ZPlanEngineStatusUpdateListener.a.f(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineSuspended() {
            ZPlanEngineStatusUpdateListener.a.g(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, String str) {
            ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean z16) {
            ZPlanEngineStatusUpdateListener.a.i(this, z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/scheme/impl/c$e", "Lcom/tencent/mobileqq/zplan/scheme/impl/c$a;", "", "onFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ z f335339a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f335340b;

        e(z zVar, String str) {
            this.f335339a = zVar;
            this.f335340b = str;
        }

        @Override // com.tencent.mobileqq.zplan.scheme.impl.c.a
        public void onFinish() {
            try {
                this.f335339a.dismiss();
            } catch (Exception e16) {
                QLog.e("ZplanSameStyleSchemeHelper_", 1, "loadingDialog dismiss failed", e16);
            }
            LoadingDialogHelperFragment.INSTANCE.b(this.f335340b);
        }
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(ZootopiaSource source, m template, HashMap<String, Object> shareExtraParams, boolean isDressAutoPublish) {
        ((ai) i.INSTANCE.a(ai.class)).isEngineReady(new C9196c(source, template, shareExtraParams, isDressAutoPublish));
    }

    private final void j(ZootopiaSource source, m template, HashMap<String, Object> shareExtraParams, boolean isDressAutoPublish, a cb5) {
        QRouteApi api = QRoute.api(IZPlanApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
        IZPlanApi.b.c((IZPlanApi) api, null, "sameStyle", 1, null);
        QLog.i("ZplanSameStyleSchemeHelper_", 1, "realLaunchSameStyleDetailPageEngineNotReady");
        ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener = engineListener;
        if (zPlanEngineStatusUpdateListener != null) {
            ZPlanServiceHelper.I.a1(zPlanEngineStatusUpdateListener);
        }
        d dVar = new d(template, shareExtraParams, isDressAutoPublish, source, cb5);
        engineListener = dVar;
        ZPlanServiceHelper.I.E0(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final ZootopiaSource source, final m template, final HashMap<String, Object> shareExtraParams, final boolean isDressAutoPublish) {
        final String str = "launchSameStyleDetailPageWithLoading" + System.currentTimeMillis();
        LoadingDialogHelperFragment.Companion.e(LoadingDialogHelperFragment.INSTANCE, new TargetTask(new Runnable() { // from class: com.tencent.mobileqq.zplan.scheme.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                c.m(ZootopiaSource.this, template, shareExtraParams, isDressAutoPublish, str);
            }
        }, str), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(m template, HashMap<String, Object> shareExtraParams, boolean isDressAutoPublish, ZootopiaSource source, boolean forceStopEngineOnDestroy) {
        IEntryApi iEntryApi = (IEntryApi) QRoute.api(IEntryApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Bundle bundle = new Bundle();
        bundle.putSerializable("template", rb4.a.a(template));
        bundle.putInt("biz", 1);
        bundle.putSerializable("share_extra_params", shareExtraParams);
        bundle.putSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, source);
        bundle.putBoolean("key_force_stop_engine_on_destroy", forceStopEngineOnDestroy);
        if (isDressAutoPublish) {
            bundle.putString("KEY_FROM", SameStyleContentPageFrom.FROM_CONTENT_PUBLISH);
            com.tencent.sqshow.zootopia.samestyle.b.f372897a.a(bundle, true);
        }
        Unit unit = Unit.INSTANCE;
        iEntryApi.startSameStyleFragment(context, source, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(final String msg2) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.scheme.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                c.p(msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(BaseApplication.context, 1, msg2, 0).show();
    }

    public final void h(Bundle pageData, HashMap<String, String> params, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(source, "source");
        HashMap<String, Object> p16 = xb4.b.f447772a.p(params.get("extData"));
        int i3 = pageData.getInt("templateId");
        boolean z16 = pageData.getInt("embedInOutfit") == 1;
        QLog.i("ZplanSameStyleSchemeHelper_", 1, "templateId: " + i3 + ", isDressAutoPublish: " + z16);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i3));
        ub4.a.b(ub4.a.f438773a, arrayList, new b(source, p16, z16, i3), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ZootopiaSource source, m template, HashMap shareExtraParams, boolean z16, String tasId) {
        Intrinsics.checkNotNullParameter(source, "$source");
        Intrinsics.checkNotNullParameter(template, "$template");
        Intrinsics.checkNotNullParameter(shareExtraParams, "$shareExtraParams");
        Intrinsics.checkNotNullParameter(tasId, "$tasId");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            k(f335324a, source, template, shareExtraParams, z16, null, 16, null);
            LoadingDialogHelperFragment.INSTANCE.b(tasId);
        } else {
            z zVar = new z(qBaseActivity, false, false, 6, null);
            e eVar = new e(zVar, tasId);
            zVar.show();
            f335324a.j(source, template, shareExtraParams, z16, eVar);
        }
    }

    static /* synthetic */ void k(c cVar, ZootopiaSource zootopiaSource, m mVar, HashMap hashMap, boolean z16, a aVar, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            aVar = null;
        }
        cVar.j(zootopiaSource, mVar, hashMap, z16, aVar);
    }
}
