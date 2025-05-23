package com.tencent.mobileqq.login.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J2\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001e\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/login/api/IDirectLoginService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "", "canDirectLogin", "", "loginEntrance", "isNestedLogin", "Le72/a;", "callback", "", "directLogin", "switchAccount", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IDirectLoginService extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static /* synthetic */ void a(IDirectLoginService iDirectLoginService, String str, int i3, boolean z16, e72.a aVar, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                if ((i16 & 4) != 0) {
                    z16 = false;
                }
                if ((i16 & 8) != 0) {
                    aVar = null;
                }
                iDirectLoginService.directLogin(str, i3, z16, aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: directLogin");
        }
    }

    boolean canDirectLogin(@Nullable String uin);

    void directLogin(@Nullable String uin, int loginEntrance, boolean isNestedLogin, @Nullable e72.a callback);

    void switchAccount(@Nullable String uin, @Nullable e72.a callback);
}
