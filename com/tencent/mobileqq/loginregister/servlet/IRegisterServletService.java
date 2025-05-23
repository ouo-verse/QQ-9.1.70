package com.tencent.mobileqq.loginregister.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes15.dex */
public interface IRegisterServletService extends IRuntimeService {
    void checkPhoneNumGatewayRegisterAccount(String str, Long l3, String str2, d dVar, Bundle bundle);

    void queryUpSmsStat(d dVar);

    void sendRegisterByCommitSmsVerifyCode(String str, d dVar);

    void sendRegisterByPhoneNumber(String str, byte b16, String str2, String str3, String str4, Long l3, String str5, Bundle bundle, d dVar);

    void sendRegisterByResendSms(d dVar);

    void sendRegisterBySetPass(String str, String str2, String str3, String str4, boolean z16, String str5, Bundle bundle, String str6, d dVar);

    void sendRegisterBySetPassWithLH(String str, String str2, String str3, String str4, boolean z16, String str5, Bundle bundle, d dVar);
}
