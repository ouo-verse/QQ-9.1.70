package com.tencent.mobileqq.loginregister.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.login.z;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;
import oicq.wlogin_sdk.request.WFastLoginInfo;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes15.dex */
public interface ILoginServletService extends IRuntimeService {
    int askDevLockSms(String str, h hVar);

    void cancelCode(String str, long j3, byte[] bArr, byte[] bArr2);

    int checkDevLockSms(String str, long j3, String str2, byte[] bArr, h hVar);

    int checkDevLockStatus(String str, long j3, h hVar);

    int checkPictureAndGetSt(String str, byte[] bArr, h hVar);

    int checkSMSAndGetSt(String str, byte[] bArr, h hVar);

    int checkSMSAndGetStExt(String str, byte[] bArr, h hVar);

    int checkSMSVerifyLoginAccount(String str, String str2, int i3, h hVar);

    int checkSMSVerifyLoginAccount(String str, String str2, int i3, boolean z16, byte[] bArr, h hVar);

    void checkWTSigIfExisted();

    int closeCode(String str, long j3, byte[] bArr, int i3, ArrayList<String> arrayList, h hVar, Bundle bundle);

    int closeDevLock(String str, long j3, h hVar);

    void deleteAccount(String str, String str2, b bVar);

    void devLockSmsVerifyLogin(int i3, String str, String str2, Bundle bundle, z zVar);

    int getA1WithA1(String str, long j3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WFastLoginInfo wFastLoginInfo, h hVar);

    void getDevLockSmsVerifyCode(String str, Bundle bundle, z zVar);

    void getKey(b bVar);

    void getStViaGatewayLogin(byte[] bArr, boolean z16, h hVar);

    void getStViaPhonePwdLogin(byte[] bArr, boolean z16, boolean z17, h hVar);

    int getStViaSMSVerifyLogin(String str, String str2, boolean z16, boolean z17, byte[] bArr, h hVar);

    int getStWithPasswd(String str, long j3, String str2, h hVar);

    int getStWithoutPasswd(String str, long j3, long j16, h hVar);

    void getSubAccountKey(String str, String str2, g gVar);

    int quickLoginByGateway(byte[] bArr, boolean z16, h hVar);

    void refreshMemorySigInMsf();

    int refreshPictureData(String str, h hVar);

    int refreshSMSData(String str, h hVar);

    int refreshSMSVerifyLoginCode(String str, String str2, h hVar);

    int regGetSMSVerifyLoginAccount(byte[] bArr, byte[] bArr2, String str, String str2, h hVar);

    int regGetSMSVerifyLoginAccountWithLH(byte[] bArr, byte[] bArr2, String str, String str2, h hVar);

    void setDevLockMobileType(int i3);

    void setRegDevLockFlag(int i3);

    void ssoGetA1WithA1(String str, byte[] bArr, long j3, long j16, long j17, byte[] bArr2, byte[] bArr3, f fVar);

    void ssoGetA1WithA1(String str, byte[] bArr, long j3, long j16, long j17, byte[] bArr2, byte[] bArr3, f fVar, Bundle bundle);

    void ssoGetTicketNoPasswd(String str, int i3, f fVar);

    void ssoGetTicketNoPasswd(String str, int i3, f fVar, Bundle bundle);

    void transformNTSigToWT(String str, int i3, Bundle bundle, h hVar);

    int verifyCode(String str, long j3, boolean z16, byte[] bArr, int[] iArr, int i3, h hVar, Bundle bundle);

    void verifyPasswd(String str, String str2, b bVar);

    void verifyPasswdRefreshImage(String str, b bVar);

    void verifyPasswdSubmitImage(String str, String str2, b bVar);

    int verifySMSVerifyLoginCode(String str, String str2, String str3, h hVar);
}
