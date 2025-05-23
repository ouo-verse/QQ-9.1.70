package com.tencent.mobileqq.zootopia.ueloading.prepare.preparer;

import android.view.View;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchConfig;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess;
import com.tencent.mobileqq.zootopia.space.j;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoadingController;
import com.tencent.mobileqq.zootopia.view.b;
import com.tencent.util.QQToastUtil;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ?\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ:\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/prepare/preparer/HotPatchPreparer;", "Lvd3/a;", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "mapId", "", "needDownloadSize", "Lkotlin/Function1;", "", "", "callback", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;Ljava/lang/Integer;JLkotlin/jvm/functions/Function1;)V", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lorg/json/JSONObject;", "modConfigJson", "Lvd3/c;", "errorCode", "", "errorMessage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "enterJson", "a", "e", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "d", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "ueLoader", "<init>", "(Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class HotPatchPreparer extends vd3.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZPlanUELoaderControllerV2 ueLoader;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/prepare/preparer/HotPatchPreparer$a", "Lcom/tencent/mobileqq/zootopia/view/b;", "Landroid/view/View;", "view", "", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.view.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZootopiaEnterParams f329475b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZootopiaUEActivity f329476c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f329477d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ vd3.c f329478e;

        a(ZootopiaEnterParams zootopiaEnterParams, ZootopiaUEActivity zootopiaUEActivity, JSONObject jSONObject, vd3.c cVar) {
            this.f329475b = zootopiaEnterParams;
            this.f329476c = zootopiaUEActivity;
            this.f329477d = jSONObject;
            this.f329478e = cVar;
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HotPatchPreparer.this.g("handleHotPatchCheckError - " + this.f329475b.getMapId() + ", retry");
            HotPatchPreparer.this.f(this.f329475b, this.f329477d, this.f329478e);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void b(View view) {
            b.a.b(this, view);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void c(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HotPatchPreparer.this.g("handleHotPatchCheckError - " + this.f329475b.getMapId() + ", cancel");
            this.f329476c.finish();
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/prepare/preparer/HotPatchPreparer$b", "Lcom/tencent/mobileqq/zootopia/view/b;", "Landroid/view/View;", "view", "", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.view.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Integer f329480b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f329481c;

        /* JADX WARN: Multi-variable type inference failed */
        b(Integer num, Function1<? super Boolean, Unit> function1) {
            this.f329480b = num;
            this.f329481c = function1;
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HotPatchPreparer.this.g("showHotPatchMobileTipsDialog - " + this.f329480b + ", confirm");
            this.f329481c.invoke(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void b(View view) {
            b.a.b(this, view);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void c(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HotPatchPreparer.this.g("showHotPatchMobileTipsDialog -" + this.f329480b + ", cancel");
            this.f329481c.invoke(Boolean.FALSE);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotPatchPreparer(ZPlanUELoaderControllerV2 ueLoader) {
        super(ueLoader);
        Intrinsics.checkNotNullParameter(ueLoader, "ueLoader");
        this.ueLoader = ueLoader;
    }

    @Override // vd3.a, vd3.b
    public void a(ZootopiaEnterParams enterParams, JSONObject enterJson, vd3.c callback) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(enterJson, "enterJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(enterParams, enterJson, callback);
        ZPlanModHotPatchConfig modHotPatchConfig = ((com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.b) i.INSTANCE.a(com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.b.class)).getModHotPatchConfig(String.valueOf(enterParams.getMapId()));
        if (modHotPatchConfig != null && modHotPatchConfig.getEnableHotPatch()) {
            com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.r(vd3.a.c(this, false, 0L, 3, null));
            ZPlanModHotPatchForModProcess.f328100a.f(e() + " enterScene", String.valueOf(enterParams.getMapId()), new HotPatchPreparer$prepare$1(this, enterParams, modHotPatchConfig, enterJson, callback), true, true);
            return;
        }
        f(enterParams, enterJson, callback);
    }

    @Override // vd3.a
    public String e() {
        return "HotPatchPreparer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(ZootopiaUEActivity activity, Integer mapId, long needDownloadSize, Function1<? super Boolean, Unit> callback) {
        Unit unit;
        ud3.b o16;
        if (activity == null) {
            g("showHotPatchMobileTipsDialog -" + mapId + " - activity is null");
            callback.invoke(Boolean.TRUE);
            return;
        }
        String string = activity.getString(R.string.xw7);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026tpatch_download_4g_title)");
        String string2 = activity.getString(R.string.xw6, j.f329276a.e(needDownloadSize));
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(\n    \u2026wnloadSize)\n            )");
        ZPlanUELoadingController loadingController = this.ueLoader.getLoadingController();
        if (loadingController == null || (o16 = loadingController.o()) == null) {
            unit = null;
        } else {
            String string3 = activity.getString(R.string.xw4);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(R.str\u2026patch_download_4g_cancel)");
            String string4 = activity.getString(R.string.xw5);
            Intrinsics.checkNotNullExpressionValue(string4, "activity.getString(R.str\u2026atch_download_4g_confirm)");
            o16.a(string, string2, string3, string4, new b(mapId, callback));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            g("showHotPatchMobileTipsDialog - dialog null");
            callback.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(final ZootopiaUEActivity activity, final ZootopiaEnterParams enterParams, JSONObject modConfigJson, vd3.c callback, int errorCode, String errorMessage) {
        Unit unit;
        ud3.b o16;
        String string = activity.getString(R.string.xw9);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026patch_download_err_title)");
        final String str = activity.getString(R.string.xw8) + "";
        ZPlanUELoadingController loadingController = this.ueLoader.getLoadingController();
        if (loadingController == null || (o16 = loadingController.o()) == null) {
            unit = null;
        } else {
            String string2 = activity.getString(R.string.xov);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.string.zplan_finsih)");
            String string3 = activity.getString(R.string.xss);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(R.string.zplan_retry)");
            o16.a(string, str, string2, string3, new a(enterParams, activity, modConfigJson, callback));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.prepare.preparer.HotPatchPreparer$handleHotPatchCheckError$2$1
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
                    HotPatchPreparer.this.g("handleHotPatchCheckError - " + enterParams.getMapId() + ", toast");
                    QQToastUtil.showQQToast(1, str);
                    activity.finish();
                }
            });
        }
    }
}
