package com.tencent.mobileqq.zootopia.ark;

import android.os.Handler;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "startResult", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZootopiaArkNotify$openDetailPage$1$1 extends Lambda implements Function1<EnterModCheckResult, Unit> {
    final /* synthetic */ Ref.ObjectRef<HashMap<String, Object>> $extraParams;
    final /* synthetic */ int $mapId;
    final /* synthetic */ ZootopiaSource $zootopiaSource;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaArkNotify$openDetailPage$1$1(int i3, ZootopiaSource zootopiaSource, Ref.ObjectRef<HashMap<String, Object>> objectRef) {
        super(1);
        this.$mapId = i3;
        this.$zootopiaSource = zootopiaSource;
        this.$extraParams = objectRef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3, ZootopiaSource zootopiaSource, Ref.ObjectRef extraParams) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(zootopiaSource, "$zootopiaSource");
        Intrinsics.checkNotNullParameter(extraParams, "$extraParams");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null || (supportFragmentManager = qBaseActivity.getSupportFragmentManager()) == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaC2CApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaC2CApi::class.java)");
        IZootopiaC2CApi.a.c((IZootopiaC2CApi) api, supportFragmentManager, 0, i3, new FragmentSource(Source.Ark, zootopiaSource), (Map) extraParams.element, 2, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
        invoke2(enterModCheckResult);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(EnterModCheckResult startResult) {
        Intrinsics.checkNotNullParameter(startResult, "startResult");
        if (startResult.isPassed() || startResult.getProcessInner()) {
            return;
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final int i3 = this.$mapId;
        final ZootopiaSource zootopiaSource = this.$zootopiaSource;
        final Ref.ObjectRef<HashMap<String, Object>> objectRef = this.$extraParams;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ark.g
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaArkNotify$openDetailPage$1$1.b(i3, zootopiaSource, objectRef);
            }
        });
    }
}
