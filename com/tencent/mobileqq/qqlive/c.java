package com.tencent.mobileqq.qqlive;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.common.api.IAegisLogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\b\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006\u0006"}, d2 = {"Landroid/content/Context;", "context", "", "b", "", "a", "qq-live-accompany-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    private static final String a() {
        return ht3.a.d("qqlive_accompaniment_url", "https://qlive.qq.com/cos/app/live-room-new/index.html?bgColor=ff06011c&loading=dark&_bid=5620");
    }

    public static final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        IAegisLogApi iAegisLogApi = (IAegisLogApi) api;
        if (!com.tencent.falco.base.downloader.utils.a.a()) {
            QQToast.makeText(context, "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u3002", 0).show();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("height_web_dialog", 444);
        bundle.putBoolean("transparent_web_bg", false);
        String a16 = a();
        iAegisLogApi.i("OpenAccompanyWebWebApiImpl", 1, "url=" + a16);
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(context, a16, bundle);
    }
}
