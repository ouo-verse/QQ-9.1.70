package com.tencent.gdtad.util;

import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/gdtad/util/f;", "", "Landroid/view/View;", "view", "", "reportLogType", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "appId", "", "a", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f109553a = new f();

    f() {
    }

    public final void a(@Nullable View view, int reportLogType, @Nullable GdtAd gdtAd, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (gdtAd != null) {
            h hVar = h.f109554a;
            if (!hVar.a()) {
                HashMap hashMap = new HashMap();
                hashMap.put("opername", "qq");
                hashMap.put("module", "mini_ad");
                hashMap.put("action", "anti_spam");
                hashMap.put("event_code", "qq#mini_ad#anti_spam");
                hashMap.put("ext1", String.valueOf(gdtAd.getTraceId()));
                hashMap.put("ext2", String.valueOf(gdtAd.getAId()));
                hashMap.put("ext3", String.valueOf(gdtAd.getAdvertiserId()));
                hashMap.put("ext4", String.valueOf(gdtAd.getCreativeSize()));
                hashMap.put("ext5", appId);
                hashMap.put("ext6", String.valueOf(gdtAd.getPosId()));
                hashMap.put("ext7", hVar.h(view));
                hashMap.put("ext8", hVar.e(view));
                hashMap.put("ext9", hVar.c(view));
                hashMap.put("ext10", String.valueOf(reportLogType));
                ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report(hashMap);
                QLog.d("GdtAntiSpamAttaReportHelper", 2, "report:", hashMap.toString());
            }
        }
    }
}
