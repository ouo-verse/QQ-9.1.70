package com.tencent.mobileqq.zplan.proxy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.activity.ZplanHostActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/af;", "Lzx4/u;", "", "page", "", "b", "a", "url", "openUrl", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class af implements zx4.u {
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[Catch: Exception -> 0x0042, TRY_LEAVE, TryCatch #0 {Exception -> 0x0042, blocks: (B:9:0x0021, B:11:0x002f, B:16:0x003b), top: B:8:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b(String page) {
        String substringAfter;
        boolean z16;
        Bundle bundle = new Bundle();
        bundle.putInt("biz", 0);
        substringAfter = StringsKt__StringsKt.substringAfter(page, '#', "");
        if (substringAfter.length() > 0) {
            try {
                String optString = new JSONObject(substringAfter).optString("Url");
                if (optString != null && optString.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        bundle.putString("pak_download_url_prefix", optString);
                    }
                }
                z16 = true;
                if (!z16) {
                }
            } catch (Exception e16) {
                QLog.e("QQZplanOpenProxy", 1, e16, new Object[0]);
            }
        }
        ZplanHostActivity.Companion companion = ZplanHostActivity.INSTANCE;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ZplanHostActivity.Companion.c(companion, context, com.tencent.sqshow.zootopia.samestyle.a.class, bundle, 0, 8, null);
    }

    @Override // zx4.u
    public void a(String page) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(page, "page");
        if (Intrinsics.areEqual(page, "setting")) {
            ZPlanApiImpl zPlanApiImpl = new ZPlanApiImpl();
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            zPlanApiImpl.startSettingActivity(context, IZPlanApi.FROM_ZPLAN_STORE);
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(page, "sameStyle", false, 2, null);
        if (startsWith$default) {
            b(page);
        }
    }

    @Override // zx4.u
    public void openUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        QLog.d("QQZplanOpenProxy", 1, "openUrl " + url);
        Intent intent = new Intent();
        intent.putExtra("url", url);
        intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
        RouteUtils.startActivity(BaseApplication.context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }
}
