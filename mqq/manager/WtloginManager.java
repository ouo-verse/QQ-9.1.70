package mqq.manager;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface WtloginManager extends Manager {
    @Deprecated
    int askDevLockSms(String str, WtloginObserver wtloginObserver);

    @Deprecated
    void cancelCode(String str, long j3, byte[] bArr);

    @Deprecated
    int checkDevLockSms(String str, long j3, String str2, byte[] bArr, WtloginObserver wtloginObserver);

    @Deprecated
    int checkDevLockStatus(String str, long j3, WtloginObserver wtloginObserver);

    @Deprecated
    int checkPictureAndGetSt(String str, byte[] bArr, WtloginObserver wtloginObserver);

    @Deprecated
    int checkSMSAndGetSt(String str, byte[] bArr, WtloginObserver wtloginObserver);

    @Deprecated
    int checkSMSAndGetStExt(String str, byte[] bArr, WtloginObserver wtloginObserver);

    @Deprecated
    int checkSMSVerifyLoginAccount(String str, String str2, int i3, WtloginObserver wtloginObserver);

    @Deprecated
    int checkSMSVerifyLoginAccount(String str, String str2, int i3, byte[] bArr, WtloginObserver wtloginObserver);

    Boolean clearUserFastLoginData(String str, long j3);

    @Deprecated
    int closeCode(String str, long j3, byte[] bArr, int i3, ArrayList<String> arrayList, WtloginObserver wtloginObserver);

    @Deprecated
    int closeDevLock(String str, long j3, WtloginObserver wtloginObserver);

    @Deprecated
    int getA1WithA1(String str, long j3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WFastLoginInfo wFastLoginInfo, WtloginObserver wtloginObserver);

    List<WloginLoginInfo> getAllLoginInfo();

    Boolean getBasicUserInfo(String str, WloginSimpleInfo wloginSimpleInfo);

    byte[] getGUID();

    boolean getHasPwd(String str);

    WUserSigInfo getLocalSig(String str, long j3);

    Ticket getLocalTicket(String str, long j3, int i3);

    @Deprecated
    int getOpenKeyWithoutPasswd(String str, long j3, long j16, WtloginObserver wtloginObserver);

    byte[] getPkgSigFromApkName(Context context, String str);

    @Deprecated
    int getStViaSMSVerifyLogin(String str, String str2, int i3, WtloginObserver wtloginObserver);

    @Deprecated
    int getStWithPasswd(String str, long j3, String str2, WtloginObserver wtloginObserver);

    @Deprecated
    int getStWithoutPasswd(String str, long j3, long j16, WtloginObserver wtloginObserver);

    @Deprecated
    int getSubAccountStViaSMSVerifyLogin(String str, String str2, String str3, int i3, WtloginObserver wtloginObserver);

    boolean isNeedLoginWithPasswd(String str, int i3);

    boolean isUserHaveA1(String str, long j3);

    boolean isWtLoginUrl(String str);

    @Deprecated
    int quickLoginByGateway(byte[] bArr, WtloginObserver wtloginObserver);

    void refreLocalHelper(Context context);

    void refreshMemorySig();

    @Deprecated
    int refreshPictureData(String str, WtloginObserver wtloginObserver);

    @Deprecated
    int refreshSMSData(String str, WtloginObserver wtloginObserver);

    @Deprecated
    int refreshSMSVerifyLoginCode(String str, String str2, WtloginObserver wtloginObserver);

    @Deprecated
    int regGetSMSVerifyLoginAccount(byte[] bArr, byte[] bArr2, String str, String str2, WtloginObserver wtloginObserver);

    @Deprecated
    int regGetSMSVerifyLoginAccountWithLH(byte[] bArr, byte[] bArr2, String str, String str2, WtloginObserver wtloginObserver);

    @Deprecated
    void setDevLockMobileType(int i3);

    void setHasPwd(String str, boolean z16);

    @Deprecated
    void setRegDevLockFlag(int i3);

    @Deprecated
    int verifyCode(String str, long j3, boolean z16, byte[] bArr, int[] iArr, int i3, WtloginObserver wtloginObserver);

    @Deprecated
    int verifySMSVerifyLoginCode(String str, String str2, String str3, WtloginObserver wtloginObserver);
}
