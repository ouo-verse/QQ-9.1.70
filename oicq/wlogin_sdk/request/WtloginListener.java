package oicq.wlogin_sdk.request;

import java.util.HashMap;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WtloginListener {
    public void OnCheckPictureAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
    }

    public void OnCheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
    }

    public void OnCheckWebsigAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
    }

    public void OnGetStViaSMSVerifyLogin(String str, long j3, int i3, long j16, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
    }

    public void OnGetStWithPasswd(String str, long j3, int i3, long j16, String str2, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
    }

    public void OnGetStWithoutPasswd(String str, long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
    }

    public void OnRequestTransport(String str, long j3, long j16, TransReqContext transReqContext, int i3) {
    }

    public void OnCheckPictureAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, int i3, ErrMsg errMsg) {
    }

    public void OnCheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, int i3, ErrMsg errMsg) {
    }

    public void OnCheckWebsigAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, int i3, ErrMsg errMsg) {
    }

    public void OnGetStViaSMSVerifyLogin(String str, long j3, int i3, long j16, long[] jArr, WUserSigInfo wUserSigInfo, byte[][] bArr, int i16, ErrMsg errMsg) {
    }

    public void OnGetStWithPasswd(String str, long j3, int i3, long j16, long[] jArr, String str2, WUserSigInfo wUserSigInfo, byte[][] bArr, int i16, ErrMsg errMsg) {
    }

    public void OnGetStWithoutPasswd(String str, long j3, long j16, int i3, long j17, long[] jArr, WUserSigInfo wUserSigInfo, byte[][] bArr, int i16, ErrMsg errMsg) {
    }

    public void OnRequestTransport(String str, long j3, long j16, TransReqContext transReqContext, WUserSigInfo wUserSigInfo, int i3) {
    }

    public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) {
    }

    public void OnInit(int i3) {
    }

    public void OnGuaranteeCheckValidUrl(WUserSigInfo wUserSigInfo, byte[] bArr) {
    }

    public void OnRegCheckUploadMsg(WUserSigInfo wUserSigInfo, String str) {
    }

    public void OnRegCheckValidUrl(WUserSigInfo wUserSigInfo, byte[] bArr) {
    }

    public void OnCheckDevLockSms(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
    }

    public void OnCloseDevLock(WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
    }

    public void OnException(ErrMsg errMsg, int i3, WUserSigInfo wUserSigInfo) {
    }

    public void OnQuickRegisterCheckAccount(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
    }

    public void OnQuickRegisterGetAccount(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
    }

    public void OnRegCheckDownloadMsg(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
    }

    public void OnRegCheckIframe(WUserSigInfo wUserSigInfo, byte[] bArr, Object obj) {
    }

    public void OnRegCheckWebSig(WUserSigInfo wUserSigInfo, String str, String str2) {
    }

    public void OnRegError(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
    }

    public void OnRegQueryAccount(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
    }

    public void OnRegSubmitMsgChk(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
    }

    public void onGetSaltUinList(int i3, WUserSigInfo wUserSigInfo, ErrMsg errMsg) {
    }

    public void onModifyQIMPassword(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
    }

    public void onNTRegisterResult(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
    }

    public void OnAskDevLockSms(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
    }

    public void OnCheckDevLockStatus(WUserSigInfo wUserSigInfo, DevlockInfo devlockInfo, int i3, ErrMsg errMsg) {
    }

    public void OnRegCheckError(int i3, WUserSigInfo wUserSigInfo, byte[] bArr, Object obj) {
    }

    public void OnRegRequestServerResendMsg(WUserSigInfo wUserSigInfo, int i3, int i16, int i17) {
    }

    public void onLoginByThirdPlatform(long j3, WtloginHelper.QuickLoginParam quickLoginParam, int i3, ErrMsg errMsg) {
    }

    public void onQuickLogin(String str, WtloginHelper.QuickLoginParam quickLoginParam, int i3, ErrMsg errMsg) {
    }

    public void OnRefreshPictureData(String str, WUserSigInfo wUserSigInfo, byte[] bArr, int i3, ErrMsg errMsg) {
    }

    public void OnRegQueryClientSentMsgStatus(WUserSigInfo wUserSigInfo, int i3, int i16, int i17, String str) {
    }

    public void OnVerifySMSVerifyLoginCode(String str, String str2, WUserSigInfo wUserSigInfo, int i3, ErrMsg errMsg) {
    }

    public void onLoginByGateway(int i3, WUserSigInfo wUserSigInfo, String str, ErrMsg errMsg, HashMap<String, Object> hashMap) {
    }

    public void OnCheckSMSVerifyLoginAccount(long j3, long j16, String str, String str2, int i3, int i16, WUserSigInfo wUserSigInfo, int i17, ErrMsg errMsg) {
    }

    public void OnCheckSMSVerifyLoginAccountForReview(long j3, long j16, int i3, String str, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
    }

    public void OnRefreshSMSData(String str, long j3, WUserSigInfo wUserSigInfo, int i3, int i16, int i17, ErrMsg errMsg) {
    }

    public void OnRefreshSMSVerifyLoginCode(String str, String str2, int i3, int i16, WUserSigInfo wUserSigInfo, int i17, ErrMsg errMsg) {
    }

    public void OnVerifyCode(String str, byte[] bArr, long j3, List<byte[]> list, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3) {
    }

    public void onGetStByGateWay(int i3, long j3, int i16, long j16, WUserSigInfo wUserSigInfo, String str, ErrMsg errMsg) {
    }

    public void onGetStByPhoneAndPassword(int i3, long j3, int i16, long j16, WUserSigInfo wUserSigInfo, String str, ErrMsg errMsg) {
    }

    public void onGetStWithQrSig(String str, long j3, int i3, long j16, WUserSigInfo wUserSigInfo, int i16, ErrMsg errMsg) {
    }

    public void OnCloseCode(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3) {
    }

    public void OnFetchCodeSig(byte[] bArr, long j3, long j16, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3) {
    }

    public void OnQueryCodeResult(long j3, List<byte[]> list, long j16, WUserSigInfo wUserSigInfo, byte[] bArr, int i3) {
    }

    public void OnRegGetAccount(WUserSigInfo wUserSigInfo, int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
    }

    public void OnRegGetSMSVerifyLoginAccount(WUserSigInfo wUserSigInfo, int i3, long j3, byte[] bArr, byte[] bArr2, byte[] bArr3) {
    }

    public void onLoginByWeChat(long j3, byte[] bArr, WtloginHelper.QuickLoginParam quickLoginParam, int i3, int i16, ErrMsg errMsg) {
    }
}
