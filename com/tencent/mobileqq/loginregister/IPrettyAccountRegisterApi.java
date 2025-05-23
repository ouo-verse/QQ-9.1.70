package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/loginregister/IPrettyAccountRegisterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "pwd", PreloadTRTCPlayerParams.KEY_SIG, "Lcom/tencent/mobileqq/login/aa;", "callback", "", "login", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IPrettyAccountRegisterApi extends QRouteApi {
    void login(@NotNull String uin, @NotNull String pwd, @NotNull String sig, @Nullable com.tencent.mobileqq.login.aa callback);
}
