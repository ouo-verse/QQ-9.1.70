package com.tencent.mobileqq.zootopia.helper;

import android.app.Activity;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u00a2\u0006\u0004\b \u0010!J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006JX\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n28\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fR\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zootopia/helper/ZootopiaResidenceHelper;", "", "", "extras", "", "c", "", "b", "", "mapId", "", FavEmoConstant.ROAMING_TYPE_PANEL, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "retCode", "serverCode", "callback", "a", "Landroid/app/Activity;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Lcom/tencent/mobileqq/zootopia/portal/detail/b;", "Lcom/tencent/mobileqq/zootopia/portal/detail/b;", "getRouter", "()Lcom/tencent/mobileqq/zootopia/portal/detail/b;", "setRouter", "(Lcom/tencent/mobileqq/zootopia/portal/detail/b;)V", "router", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Lcom/tencent/mobileqq/zootopia/portal/detail/b;)V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaResidenceHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zootopia.portal.detail.b router;

    public ZootopiaResidenceHelper(Activity activity, ZootopiaSource sourceCurrent, com.tencent.mobileqq.zootopia.portal.detail.b router) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        Intrinsics.checkNotNullParameter(router, "router");
        this.activity = activity;
        this.sourceCurrent = sourceCurrent;
        this.router = router;
    }

    private final Map<String, Object> c(String extras) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(extras);
            while (jSONObject.keys().hasNext()) {
                String key = (String) jSONObject.keys().next();
                String value = jSONObject.optString(key);
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                hashMap.put(key, value);
            }
        } catch (Throwable unused) {
            QLog.e("ZootopiaEnterAvatarSceneHelper", 2, "handleJsonExtras error");
        }
        return hashMap;
    }

    public final void a(int mapId, String extras, boolean needDownload, final Function2<? super Integer, ? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        ((si3.c) vb3.a.f441346a.a(si3.c.class)).u(mapId, this.sourceCurrent, c(extras), new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.helper.ZootopiaResidenceHelper$enterAvatarScene$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                invoke2(enterModCheckResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EnterModCheckResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isPassed()) {
                    Function2<Integer, Integer, Unit> function2 = callback;
                    if (function2 != null) {
                        function2.invoke(0, 0);
                        return;
                    }
                    return;
                }
                Function2<Integer, Integer, Unit> function22 = callback;
                if (function22 != null) {
                    function22.invoke(-1, -1);
                }
            }
        });
    }

    public final void b() {
        a(AdMetricID.Click.SUCCESS, "", true, null);
    }
}
