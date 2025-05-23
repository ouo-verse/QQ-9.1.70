package com.tencent.mobileqq.vas.toggle;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/toggle/IVasToggleExtApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "toggle", "", "owner", "", "time", "key", "default", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasToggleExtApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class a {
        public static /* synthetic */ boolean a(IVasToggleExtApi iVasToggleExtApi, String str, String str2, String str3, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    z16 = true;
                }
                return iVasToggleExtApi.toggle(str, str2, str3, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggle");
        }
    }

    boolean toggle(@NotNull String owner, @NotNull String time, @NotNull String key, boolean r46);
}
