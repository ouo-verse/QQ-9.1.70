package com.tencent.mobileqq.loginregister;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.im.login.GetLocalPhone$EncryptPhoneData;
import tencent.im.login.GetLocalPhone$MaskPhoneData;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0002\r\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/loginregister/ILocalPhoneHttpModuleApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "serviceType", "Lcom/tencent/mobileqq/loginregister/ILocalPhoneHttpModuleApi$a;", "maskPhoneCallback", "", "getMaskPhoneNum", "Landroid/os/Bundle;", "extra", "Lcom/tencent/mobileqq/loginregister/ILocalPhoneHttpModuleApi$b;", "phoneNumCallback", "getPhoneToken", "a", "b", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILocalPhoneHttpModuleApi extends QRouteApi {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/loginregister/ILocalPhoneHttpModuleApi$a;", "", "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", "maskPhoneData", "", "b", "", "code", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "a", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface a {
        void a(int code, @Nullable Exception e16);

        void b(@Nullable GetLocalPhone$MaskPhoneData maskPhoneData);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/loginregister/ILocalPhoneHttpModuleApi$b;", "", "Ltencent/im/login/GetLocalPhone$EncryptPhoneData;", "phoneData", "", "b", "", "code", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "a", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void a(int code, @Nullable Exception e16);

        void b(@Nullable GetLocalPhone$EncryptPhoneData phoneData);
    }

    void getMaskPhoneNum(int serviceType, @Nullable a maskPhoneCallback);

    void getPhoneToken(int serviceType, @Nullable Bundle extra, @Nullable b phoneNumCallback);
}
