package com.tencent.mobileqq.wink.report;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r93.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/report/c;", "", "Landroid/os/Bundle;", "bundle", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f326261a = new c();

    c() {
    }

    public final void a(@Nullable Bundle bundle, @NotNull Map<String, Object> pageParams) {
        String str;
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        if (h.f430993a.g()) {
            String str2 = null;
            if (bundle != null) {
                str = bundle.getString("adId");
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = "adId".toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                pageParams.put(lowerCase, str);
            }
            if (bundle != null) {
                try {
                    str2 = bundle.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_SCHEMA_CLICK_TIME, "");
                } catch (Exception e16) {
                    w53.b.d("WinkQZoneReportHelper", "get schema launch time exception", e16);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                long currentTimeMillis = System.currentTimeMillis();
                Intrinsics.checkNotNull(str2);
                long parseLong = currentTimeMillis - Long.parseLong(str2);
                w53.b.f("WinkQZoneReportHelper", "[schema]:go to templatePreviewController " + parseLong + " ms)");
                pageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SCHEMA_LAUNCH_TIME, Long.valueOf(parseLong));
            }
            pageParams.put(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.QZONE_PUBLISH_ID));
        }
    }
}
