package com.tencent.mobileqq.qqlivehall.iv.api.hippy.module;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.IQQLiveCookieApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@HippyNativeModule(name = VasLiveHippyCookieModule.TAG)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/api/hippy/module/VasLiveHippyCookieModule;", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "Lcom/tencent/mtt/hippy/common/HippyMap;", "params", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "", "getCookie", "setCookie", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "hippyEngineContext", "<init>", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "Companion", "a", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VasLiveHippyCookieModule extends HippyNativeModuleBase {
    private static final int ERR_COOKIES_IS_EMPTY = -2;
    private static final int ERR_URL_IS_EMPTY = -1;

    @NotNull
    private static final String TAG = "VasLiveHippyCookieModule";

    public VasLiveHippyCookieModule(@Nullable HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "getCookie")
    public final void getCookie(@NotNull HippyMap params, @NotNull Promise promise) {
        int i3;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        String url = params.getString("url");
        QLog.i(TAG, 1, "getCookie->url:" + url);
        HippyMap hippyMap = new HippyMap();
        String str = "";
        if (TextUtils.isEmpty(url)) {
            i3 = -1;
        } else {
            IQQLiveCookieApi iQQLiveCookieApi = (IQQLiveCookieApi) QRoute.api(IQQLiveCookieApi.class);
            Intrinsics.checkNotNullExpressionValue(url, "url");
            String sysCookie = iQQLiveCookieApi.getSysCookie(url);
            if (sysCookie != null) {
                str = sysCookie;
            }
            i3 = 0;
        }
        hippyMap.pushInt("retCode", i3);
        HippyMap hippyMap2 = new HippyMap();
        hippyMap.pushObject("data", hippyMap2);
        hippyMap2.pushString("cookie", str);
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = "setCookie")
    public final void setCookie(@NotNull HippyMap params, @NotNull Promise promise) {
        int i3;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        String url = params.getString("url");
        HippyArray array = params.getArray("cookies");
        QLog.i(TAG, 1, "setCookie->url:" + url);
        HippyMap hippyMap = new HippyMap();
        if (TextUtils.isEmpty(url)) {
            i3 = -1;
        } else if (array.size() > 0) {
            ((IQQLiveCookieApi) QRoute.api(IQQLiveCookieApi.class)).setAcceptCookie(true);
            int size = array.size();
            for (int i16 = 0; i16 < size; i16++) {
                IQQLiveCookieApi iQQLiveCookieApi = (IQQLiveCookieApi) QRoute.api(IQQLiveCookieApi.class);
                Intrinsics.checkNotNullExpressionValue(url, "url");
                String string = array.getString(i16);
                Intrinsics.checkNotNullExpressionValue(string, "cookies.getString(i)");
                iQQLiveCookieApi.setCookie(url, string);
            }
            ((IQQLiveCookieApi) QRoute.api(IQQLiveCookieApi.class)).sync();
            i3 = 0;
        } else {
            i3 = -2;
        }
        hippyMap.pushInt("retCode", i3);
        promise.resolve(hippyMap);
    }
}
