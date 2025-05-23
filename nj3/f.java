package nj3;

import com.tencent.filament.zplanservice.pbjava.SchemeChannel$OpenSchemeRequest;
import com.tencent.filament.zplanservice.pbjava.SchemeChannel$OpenSchemeResponse;
import com.tencent.filament.zplanservice.pbjava.ZPlanError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ(\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lnj3/f;", "Lel0/g;", "Lcom/tencent/filament/zplanservice/pbjava/SchemeChannel$OpenSchemeRequest;", "req", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/SchemeChannel$OpenSchemeResponse;", "", "Lcom/tencent/filament/zplanservice/proxy/api/channel/ISchemeChannelResponse;", "callback", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f implements el0.g {
    @Override // el0.g
    public void a(SchemeChannel$OpenSchemeRequest req, Function1<? super SchemeChannel$OpenSchemeResponse, Unit> callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        String str = req.url.get();
        Intrinsics.checkNotNullExpressionValue(str, "req.url.get()");
        boolean launchScheme = iZPlanApi.launchScheme(context, str);
        QLog.i("QQSchemeChannelProxy", 1, "openScheme ret: " + launchScheme);
        SchemeChannel$OpenSchemeResponse schemeChannel$OpenSchemeResponse = new SchemeChannel$OpenSchemeResponse();
        schemeChannel$OpenSchemeResponse.success.set(launchScheme);
        if (!launchScheme) {
            ZPlanError zPlanError = schemeChannel$OpenSchemeResponse.error;
            ZPlanError zPlanError2 = new ZPlanError();
            zPlanError2.message.set("not support " + req.url);
            zPlanError.set(zPlanError2);
        }
        callback.invoke(schemeChannel$OpenSchemeResponse);
    }
}
