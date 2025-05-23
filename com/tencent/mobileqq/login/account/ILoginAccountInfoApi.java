package com.tencent.mobileqq.login.account;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/login/account/ILoginAccountInfoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "account2Uin", "", "account", "", "def", "getNick", "uin", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILoginAccountInfoApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static /* synthetic */ long a(ILoginAccountInfoApi iLoginAccountInfoApi, String str, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = 0;
                }
                return iLoginAccountInfoApi.account2Uin(str, j3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: account2Uin");
        }
    }

    long account2Uin(@Nullable String account, long def);

    @NotNull
    String getNick(long uin);

    @NotNull
    String getNick(@Nullable String uin);
}
