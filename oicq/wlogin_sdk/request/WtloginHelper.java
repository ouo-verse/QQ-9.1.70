package oicq.wlogin_sdk.request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.loginsecsdk.ProtocolDet;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.cardcontainer.api.impl.CardContainerDataServiceImpl;
import com.tencent.mobileqq.fe.FEKit;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.open.inner.auth.QQAuth;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tenpay.sdk.download.HttpOp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TimerTask;
import java.util.TreeMap;
import oicq.wlogin_sdk.code2d.fetch_code;
import oicq.wlogin_sdk.contextpersist.DeviceSmsContext;
import oicq.wlogin_sdk.contextpersist.SmsVerifyContext;
import oicq.wlogin_sdk.devicelock.DevlockBase;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.devicelock.DevlockRst;
import oicq.wlogin_sdk.devicelock.TLV_CommRsp;
import oicq.wlogin_sdk.devicelock.TLV_QuerySig;
import oicq.wlogin_sdk.devicelock.TLV_SppKey;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.listener.QimeiListener;
import oicq.wlogin_sdk.listener.ReportListener;
import oicq.wlogin_sdk.listener.SwitchListener;
import oicq.wlogin_sdk.pb.ThirdPartLogin$A1Sig;
import oicq.wlogin_sdk.pb.ThirdPartLogin$RandSalt;
import oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBody;
import oicq.wlogin_sdk.pb.ThirdPartLogin$ReqCmd25;
import oicq.wlogin_sdk.pb.ThirdPartLogin$ReqCommonInfo;
import oicq.wlogin_sdk.pb.ThirdPartLogin$RspBody;
import oicq.wlogin_sdk.pb.ThirdPartLogin$UinInfo;
import oicq.wlogin_sdk.pb.sec_trans$SecTransInfo;
import oicq.wlogin_sdk.pow.ClientPow;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.report.b;
import oicq.wlogin_sdk.report.event.EventConstant;
import oicq.wlogin_sdk.report.report_t;
import oicq.wlogin_sdk.report.report_t2;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t100;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t107;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t109;
import oicq.wlogin_sdk.tlv_type.tlv_t10c;
import oicq.wlogin_sdk.tlv_type.tlv_t112;
import oicq.wlogin_sdk.tlv_type.tlv_t116;
import oicq.wlogin_sdk.tlv_type.tlv_t124;
import oicq.wlogin_sdk.tlv_type.tlv_t126;
import oicq.wlogin_sdk.tlv_type.tlv_t127;
import oicq.wlogin_sdk.tlv_type.tlv_t128;
import oicq.wlogin_sdk.tlv_type.tlv_t141;
import oicq.wlogin_sdk.tlv_type.tlv_t142;
import oicq.wlogin_sdk.tlv_type.tlv_t144;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t147;
import oicq.wlogin_sdk.tlv_type.tlv_t148;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tlv_type.tlv_t153;
import oicq.wlogin_sdk.tlv_type.tlv_t154;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t16e;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t177;
import oicq.wlogin_sdk.tlv_type.tlv_t17a;
import oicq.wlogin_sdk.tlv_type.tlv_t18;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t184;
import oicq.wlogin_sdk.tlv_type.tlv_t187;
import oicq.wlogin_sdk.tlv_type.tlv_t188;
import oicq.wlogin_sdk.tlv_type.tlv_t191;
import oicq.wlogin_sdk.tlv_type.tlv_t193;
import oicq.wlogin_sdk.tlv_type.tlv_t194;
import oicq.wlogin_sdk.tlv_type.tlv_t2;
import oicq.wlogin_sdk.tlv_type.tlv_t202;
import oicq.wlogin_sdk.tlv_type.tlv_t400;
import oicq.wlogin_sdk.tlv_type.tlv_t521;
import oicq.wlogin_sdk.tlv_type.tlv_t52c;
import oicq.wlogin_sdk.tlv_type.tlv_t52d;
import oicq.wlogin_sdk.tlv_type.tlv_t533;
import oicq.wlogin_sdk.tlv_type.tlv_t542;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tlv_type.tlv_t545;
import oicq.wlogin_sdk.tlv_type.tlv_t547;
import oicq.wlogin_sdk.tlv_type.tlv_t548;
import oicq.wlogin_sdk.tlv_type.tlv_t553;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.EcdhCrypt;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WtloginHelper {
    private static final String NT_FLAG_PREFIX = "NTFlag_";
    public static int __top;
    private static IWtDataSender mWtDataSender;
    public static SwitchListener switchListener;
    private boolean isForLocal;
    private long mAysncSeq;
    private Context mContext;
    private long mDevAsyncSeq;
    private u mG;
    private Handler mHelperHandler;
    private WtloginListener mListener;
    private int mMainSigMap;
    private int mMiscBitmap;
    private long mOpenAppid;
    private oicq.wlogin_sdk.register.c mRegStatus;
    private int mSubSigMap;
    public static final Object __sync_top = new Object();
    public static final Object GET_ST_WITHOUT_PASSWORD_LOCK = new Object();
    public static final Object GET_TICKET_LOCK = new Object();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class A1AndNopicSig {

        /* renamed from: a1, reason: collision with root package name */
        public byte[] f422867a1;
        public byte[] noPicSig;

        A1AndNopicSig() {
            this.f422867a1 = null;
            this.noPicSig = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class A1SRC {
        public static final int A1SRC_PASSWORD = 1;
        public static final int A1SRC_PTSIG = 4;
        public static final int A1SRC_QUICKLOGIN = 2;
        public static final int A1SRC_SMS = 3;

        A1SRC() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class HelperThread extends BaseThread {
        public static final String THREAD_NAME_PRE = "Wtlogin_";
        public boolean isSelfLooper;
        public byte[] mAppName2;
        public byte[] mAppSign2;
        public byte[] mAppVer2;
        public long mAppid1;
        public long mAppid2;
        public long mDwAppid;
        public long mDwDstAppPri;
        public long mDwDstAppid;
        public long[] mDwDstSubAppidList;
        public int mDwMainSigMap;
        public long[] mDwSubAppidList;
        public long mDwSubDstAppid;
        public int mEncrypt;
        public byte[] mExtraData;
        public int mExtraFlag;
        public long mExtraUin;
        public WFastLoginInfo mFastLoginInfo;
        public Handler mHandler;
        public WtloginHelper mHelper;
        public boolean mIsSmslogin;
        public String mMsgCode;
        public byte[] mPictureData;
        public WtTicketPromise mPromise;
        public boolean mPwdMd5;
        public int mReportErrType;
        public TransReqContext mReqContext;
        public int mReqType;
        public byte[][] mReserve;
        public long mRole;
        public byte[][] mST;
        public byte[] mST1;
        public byte[] mST1Key;
        public long mSmsAppid;
        public long mSsoVer2;
        public long mSubAppid1;
        public long mSubAppid2;
        public long mUIN;
        public String mUserAccount;
        public byte[] mUserInput;
        public String mUserPasswd;
        public WUserSigInfo mUserSigInfo;
        public byte[] mWxAppid;
        public String ptSig;
        public QuickLoginParam quickLoginParam;
        public byte[] weChatCode;

        public HelperThread(WtloginHelper wtloginHelper, Handler handler) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void quitSelfLooper() {
            try {
                if (this.isSelfLooper) {
                    Looper myLooper = Looper.myLooper();
                    if (myLooper != null) {
                        myLooper.quit();
                    }
                    this.mHandler = null;
                }
            } catch (Exception e16) {
                util.printException(e16, "");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void saveContextCommonDataIntoExtentMap(async_context async_contextVar) {
            if (async_contextVar._t543 != null) {
                util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv543 length " + async_contextVar._t543.get_data_len(), this.mUserAccount);
                this.mUserSigInfo.loginResultTLVMap.put(new Integer(1347), async_contextVar._t543);
            }
            if (async_contextVar.tlv543In119 != null) {
                util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv543In119 length " + async_contextVar.tlv543In119.get_data_len(), this.mUserAccount);
                this.mUserSigInfo.loginResultTLVMap.put(new Integer(util.KEY_TLV543_IN_TLV199), async_contextVar.tlv543In119);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void saveContextDataIntoExtentMap(async_context async_contextVar, int i3) {
            if (i3 == 0 && async_contextVar.tlv528 != null) {
                util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv528 length " + async_contextVar.tlv528.get_data_len(), this.mUserAccount);
                this.mUserSigInfo.loginResultTLVMap.put(new Integer(gdt_analysis_event.EVENT_QUERY_URL_BY_CGI_FAILED), async_contextVar.tlv528);
            }
            if (i3 == 0 && async_contextVar.tlv530 != null) {
                util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv530 length " + async_contextVar.tlv530.get_data_len(), this.mUserAccount);
                this.mUserSigInfo.loginResultTLVMap.put(new Integer(1328), async_contextVar.tlv530);
            }
            if (i3 == 0 && async_contextVar.tlv113 != null) {
                util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv113 length " + async_contextVar.tlv113.get_data_len(), this.mUserAccount);
                this.mUserSigInfo.loginResultTLVMap.put(new Integer(275), async_contextVar.tlv113);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void saveContextSigSessionDataIntoExtentMap(async_context async_contextVar) {
            if (async_contextVar.get_t104() != null) {
                util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv104 length " + async_contextVar.get_t104().get_data_len(), this.mUserAccount);
                this.mUserSigInfo.loginResultTLVMap.put(new Integer(260), async_contextVar.get_t104());
            }
        }

        public void RunReq(int i3) {
            byte[] bArr;
            this.mReqType = i3;
            if (i3 == 7) {
                start();
                return;
            }
            synchronized (WtloginHelper.__sync_top) {
                BaseTimer baseTimer = new BaseTimer();
                TimerTask timerTask = new TimerTask() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        HelperThread.this.start();
                    }
                };
                WtloginHelper.__top = WtloginHelper.__top + 1;
                baseTimer.schedule(timerTask, r2 * 500);
                WUserSigInfo wUserSigInfo = this.mUserSigInfo;
                int i16 = 0;
                if (wUserSigInfo != null && (bArr = wUserSigInfo._reserveData) != null && bArr.length > 3) {
                    i16 = util.buf_to_int32(bArr, 0);
                }
                util.LOGI("push queue " + WtloginHelper.__top + ", ssoSeq = " + i16 + ", reqType = " + this.mReqType, "");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x0459  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0461  */
        /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x03d7  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x03df  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x04b3 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x018b -> B:86:0x0187). Please report as a decompilation issue!!! */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            int i3;
            byte[] bArr;
            final int i16;
            Exception exc;
            int i17;
            byte[] bArr2;
            Handler handler;
            Runnable runnable;
            Throwable th5;
            int i18;
            Handler handler2;
            Runnable runnable2;
            int i19;
            byte[] bArr3;
            if (this.mHelper.mListener == null && this.mPromise == null) {
                return;
            }
            final int i26 = this.mHelper.mG.f422969p;
            if (this.mHandler == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isSelfLooper = z16;
            if (z16) {
                Looper.prepare();
                this.mHandler = WtloginHelper.this.newHelperHandler();
            }
            try {
                try {
                    try {
                        if (this.mHandler != null) {
                            int i27 = this.mReqType;
                            if (i27 == 0) {
                                final int GetStWithPasswd = this.mHelper.GetStWithPasswd(this.mUserAccount, this.mDwAppid, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwSubAppidList, this.mPwdMd5, this.mUserPasswd, this.mUserSigInfo, this.mST, this.mIsSmslogin, 1);
                                handler2 = this.mHandler;
                                runnable2 = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        HelperThread.this.quitSelfLooper();
                                        if (i26 != 0) {
                                            return;
                                        }
                                        async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                        ErrMsg errMsg = b16._last_err_msg;
                                        if (HelperThread.this.mHelper.mListener != null) {
                                            HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                            HelperThread.this.saveContextDataIntoExtentMap(b16, GetStWithPasswd);
                                            HelperThread helperThread = HelperThread.this;
                                            if (helperThread.mDwSubAppidList == null) {
                                                boolean z17 = helperThread.mIsSmslogin;
                                                WtloginHelper wtloginHelper = helperThread.mHelper;
                                                if (z17) {
                                                    WtloginListener wtloginListener = wtloginHelper.mListener;
                                                    HelperThread helperThread2 = HelperThread.this;
                                                    wtloginListener.OnGetStViaSMSVerifyLogin(helperThread2.mUserAccount, helperThread2.mDwAppid, helperThread2.mDwMainSigMap, helperThread2.mDwSubDstAppid, helperThread2.mUserSigInfo, GetStWithPasswd, errMsg);
                                                    return;
                                                } else {
                                                    WtloginListener wtloginListener2 = wtloginHelper.mListener;
                                                    HelperThread helperThread3 = HelperThread.this;
                                                    wtloginListener2.OnGetStWithPasswd(helperThread3.mUserAccount, helperThread3.mDwAppid, helperThread3.mDwMainSigMap, helperThread3.mDwSubDstAppid, helperThread3.mUserPasswd, helperThread3.mUserSigInfo, GetStWithPasswd, errMsg);
                                                    return;
                                                }
                                            }
                                            boolean z18 = helperThread.mIsSmslogin;
                                            WtloginHelper wtloginHelper2 = helperThread.mHelper;
                                            if (z18) {
                                                WtloginListener wtloginListener3 = wtloginHelper2.mListener;
                                                HelperThread helperThread4 = HelperThread.this;
                                                wtloginListener3.OnGetStViaSMSVerifyLogin(helperThread4.mUserAccount, helperThread4.mDwAppid, helperThread4.mDwMainSigMap, helperThread4.mDwSubDstAppid, helperThread4.mDwSubAppidList, helperThread4.mUserSigInfo, helperThread4.mST, GetStWithPasswd, errMsg);
                                                return;
                                            } else {
                                                WtloginListener wtloginListener4 = wtloginHelper2.mListener;
                                                HelperThread helperThread5 = HelperThread.this;
                                                wtloginListener4.OnGetStWithPasswd(helperThread5.mUserAccount, helperThread5.mDwAppid, helperThread5.mDwMainSigMap, helperThread5.mDwSubDstAppid, helperThread5.mDwSubAppidList, helperThread5.mUserPasswd, helperThread5.mUserSigInfo, helperThread5.mST, GetStWithPasswd, errMsg);
                                                return;
                                            }
                                        }
                                        util.LOGW("login helper listener is null", HelperThread.this.mUserAccount);
                                    }
                                };
                            } else {
                                if (i27 == 1) {
                                    final int RefreshPictureData = this.mHelper.RefreshPictureData(this.mUserAccount, this.mUserSigInfo, 1);
                                    this.mHandler.post(new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.3
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            HelperThread.this.quitSelfLooper();
                                            if (i26 != 0) {
                                                return;
                                            }
                                            if (HelperThread.this.mHelper.mListener == null) {
                                                util.LOGW("login helper listener is null", HelperThread.this.mUserAccount);
                                                return;
                                            }
                                            async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                            ErrMsg errMsg = b16._last_err_msg;
                                            HelperThread.this.mPictureData = b16._t105.get_pic();
                                            WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                            HelperThread helperThread = HelperThread.this;
                                            wtloginListener.OnRefreshPictureData(helperThread.mUserAccount, helperThread.mUserSigInfo, helperThread.mPictureData, RefreshPictureData, errMsg);
                                        }
                                    });
                                } else if (i27 == 2) {
                                    final int CheckPictureAndGetSt = this.mHelper.CheckPictureAndGetSt(this.mUserAccount, this.mUserInput, this.mUserSigInfo, this.mST, 1);
                                    handler2 = this.mHandler;
                                    runnable2 = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.4
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            HelperThread.this.quitSelfLooper();
                                            if (i26 != 0) {
                                                return;
                                            }
                                            async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                            HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                            HelperThread.this.saveContextDataIntoExtentMap(b16, CheckPictureAndGetSt);
                                            ErrMsg errMsg = b16._last_err_msg;
                                            if (n.f422900v) {
                                                HelperThread helperThread = HelperThread.this;
                                                byte[][] bArr4 = helperThread.mST;
                                                WtloginListener wtloginListener = helperThread.mHelper.mListener;
                                                HelperThread helperThread2 = HelperThread.this;
                                                String str = helperThread2.mUserAccount;
                                                byte[] bArr5 = helperThread2.mUserInput;
                                                WUserSigInfo wUserSigInfo = helperThread2.mUserSigInfo;
                                                if (bArr4 == null) {
                                                    wtloginListener.OnCheckWebsigAndGetSt(str, bArr5, wUserSigInfo, CheckPictureAndGetSt, errMsg);
                                                    return;
                                                } else {
                                                    wtloginListener.OnCheckWebsigAndGetSt(str, bArr5, wUserSigInfo, helperThread2.mST, CheckPictureAndGetSt, errMsg);
                                                    return;
                                                }
                                            }
                                            HelperThread helperThread3 = HelperThread.this;
                                            byte[][] bArr6 = helperThread3.mST;
                                            WtloginListener wtloginListener2 = helperThread3.mHelper.mListener;
                                            HelperThread helperThread4 = HelperThread.this;
                                            String str2 = helperThread4.mUserAccount;
                                            byte[] bArr7 = helperThread4.mUserInput;
                                            WUserSigInfo wUserSigInfo2 = helperThread4.mUserSigInfo;
                                            if (bArr6 == null) {
                                                wtloginListener2.OnCheckPictureAndGetSt(str2, bArr7, wUserSigInfo2, CheckPictureAndGetSt, errMsg);
                                            } else {
                                                wtloginListener2.OnCheckPictureAndGetSt(str2, bArr7, wUserSigInfo2, helperThread4.mST, CheckPictureAndGetSt, errMsg);
                                            }
                                        }
                                    };
                                } else if (i27 == 3) {
                                    final int RefreshSMSData = this.mHelper.RefreshSMSData(this.mUserAccount, this.mSmsAppid, this.mUserSigInfo, this.mExtraData, 1);
                                    handler2 = this.mHandler;
                                    runnable2 = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.5
                                        /* JADX WARN: Code restructure failed: missing block: B:13:0x0068, code lost:
                                        
                                            if (r1.isSwitchOn(oicq.wlogin_sdk.contextpersist.SmsVerifyContext.MANAGER_ID, true) != false) goto L16;
                                         */
                                        @Override // java.lang.Runnable
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public void run() {
                                            boolean z17;
                                            HelperThread.this.quitSelfLooper();
                                            if (i26 != 0) {
                                                return;
                                            }
                                            async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                            if (b16._t543 != null) {
                                                util.LOGI("context from seq " + HelperThread.this.mUserSigInfo._seqence + " tlv length " + b16._t543.get_data_len(), HelperThread.this.mUserAccount);
                                                HelperThread.this.mUserSigInfo.loginResultTLVMap.put(new Integer(1347), b16._t543);
                                            }
                                            if (RefreshSMSData == 0) {
                                                SwitchListener switchListener = WtloginHelper.switchListener;
                                                if (switchListener != null) {
                                                    z17 = true;
                                                }
                                                z17 = false;
                                                util.LOGI("RefreshSMSData context persist isSwitchOn = " + z17, "");
                                                if (z17) {
                                                    DeviceSmsContext deviceSmsContext = new DeviceSmsContext(b16.get_t104(), b16._t174, b16._t402, b16._t403, b16._msalt, b16._mpasswd, b16._tgtgt_key, b16._sub_appid_list);
                                                    util.LOGI("RefreshSMSData deviceSmsContext = " + deviceSmsContext.toString(), "");
                                                    oicq.wlogin_sdk.contextpersist.a.a(WtloginHelper.this.mContext, deviceSmsContext, DeviceSmsContext.MMKV_KEY_CONTEXT_PERSIST_DEVICE_SMS_VERIFY);
                                                }
                                            }
                                            ErrMsg errMsg = b16._last_err_msg;
                                            int i28 = b16._t17b.get_available_msg_cnt();
                                            int i29 = b16._t17b.get_time_limit();
                                            WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                            HelperThread helperThread = HelperThread.this;
                                            wtloginListener.OnRefreshSMSData(helperThread.mUserAccount, helperThread.mSmsAppid, helperThread.mUserSigInfo, i28, i29, RefreshSMSData, errMsg);
                                        }
                                    };
                                } else if (i27 == 4) {
                                    final int CheckSMSAndGetSt = this.mHelper.CheckSMSAndGetSt(this.mUserAccount, this.mUserInput, this.mUserSigInfo, this.mST, this.mExtraData, 1);
                                    handler2 = this.mHandler;
                                    runnable2 = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.6
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            HelperThread.this.quitSelfLooper();
                                            if (i26 != 0) {
                                                return;
                                            }
                                            async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                            HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                            HelperThread.this.saveContextDataIntoExtentMap(b16, CheckSMSAndGetSt);
                                            ErrMsg errMsg = b16._last_err_msg;
                                            HelperThread helperThread = HelperThread.this;
                                            if (WtloginHelper.this.isGateWay(helperThread.mUserSigInfo)) {
                                                HelperThread helperThread2 = HelperThread.this;
                                                helperThread2.mUserAccount = helperThread2.mUserSigInfo.uin;
                                            }
                                            if (TextUtils.isEmpty(HelperThread.this.mUserAccount) || Objects.equals(HelperThread.this.mUserAccount, "0")) {
                                                util.LOGI("CheckSMSAndGetSt thisContext._uin = " + b16._uin, b16._uin + "");
                                                HelperThread.this.mUserAccount = String.valueOf(b16._uin);
                                            }
                                            HelperThread helperThread3 = HelperThread.this;
                                            byte[][] bArr4 = helperThread3.mST;
                                            WtloginListener wtloginListener = helperThread3.mHelper.mListener;
                                            HelperThread helperThread4 = HelperThread.this;
                                            String str = helperThread4.mUserAccount;
                                            byte[] bArr5 = helperThread4.mUserInput;
                                            WUserSigInfo wUserSigInfo = helperThread4.mUserSigInfo;
                                            if (bArr4 == null) {
                                                wtloginListener.OnCheckSMSAndGetSt(str, bArr5, wUserSigInfo, CheckSMSAndGetSt, errMsg);
                                            } else {
                                                wtloginListener.OnCheckSMSAndGetSt(str, bArr5, wUserSigInfo, helperThread4.mST, CheckSMSAndGetSt, errMsg);
                                            }
                                        }
                                    };
                                } else {
                                    if (i27 == 5) {
                                        synchronized (WtloginHelper.GET_ST_WITHOUT_PASSWORD_LOCK) {
                                            try {
                                            } catch (Throwable th6) {
                                                th = th6;
                                            }
                                            try {
                                                final int GetStWithoutPasswd = this.mHelper.GetStWithoutPasswd(this.mUserAccount, this.mDwAppid, this.mDwDstAppid, this.mDwDstAppPri, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwDstSubAppidList, this.mUserSigInfo, this.mST, this.mReserve, 1, this.mPromise);
                                                if (GetStWithoutPasswd == 20) {
                                                    try {
                                                        util.LOGI("retry ret=0x14", "");
                                                        i18 = GetStWithoutPasswd;
                                                        GetStWithoutPasswd = this.mHelper.GetStWithoutPasswd(this.mUserAccount, this.mDwAppid, this.mDwDstAppid, this.mDwDstAppPri, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwDstSubAppidList, this.mUserSigInfo, this.mST, this.mReserve, 1, this.mPromise);
                                                    } catch (Throwable th7) {
                                                        th5 = th7;
                                                        try {
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            th5 = th;
                                                            throw th5;
                                                        }
                                                        throw th5;
                                                    }
                                                } else {
                                                    i18 = GetStWithoutPasswd;
                                                }
                                                if (GetStWithoutPasswd == 0 && i18 == 20) {
                                                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_A1_SEQ_ERR, "", ""));
                                                }
                                                try {
                                                    handler = this.mHandler;
                                                    runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.7
                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            boolean z17;
                                                            HelperThread.this.quitSelfLooper();
                                                            if (i26 != 0) {
                                                                return;
                                                            }
                                                            async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                            ErrMsg errMsg = b16._last_err_msg;
                                                            u.e(HelperThread.this.mUserSigInfo._seqence);
                                                            HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                            HelperThread.this.saveContextDataIntoExtentMap(b16, GetStWithoutPasswd);
                                                            HelperThread helperThread = HelperThread.this;
                                                            if (helperThread.mDwDstAppid == WtloginHelper.this.mOpenAppid) {
                                                                HelperThread helperThread2 = HelperThread.this;
                                                                helperThread2.mDwDstAppid = helperThread2.mDwSubDstAppid;
                                                                helperThread2.mDwSubDstAppid = 0L;
                                                            }
                                                            HelperThread helperThread3 = HelperThread.this;
                                                            if (helperThread3.mPromise != null) {
                                                                errMsg.setType(GetStWithoutPasswd);
                                                                int i28 = GetStWithoutPasswd;
                                                                if (i28 == 0) {
                                                                    HelperThread.this.mPromise.Done(null);
                                                                    return;
                                                                } else if (i28 == -1000) {
                                                                    HelperThread.this.mPromise.Timeout(errMsg);
                                                                    return;
                                                                } else {
                                                                    HelperThread.this.mPromise.Failed(errMsg);
                                                                    return;
                                                                }
                                                            }
                                                            if (helperThread3.mHelper.mListener == null) {
                                                                return;
                                                            }
                                                            HelperThread helperThread4 = HelperThread.this;
                                                            if (helperThread4.mDwDstSubAppidList == null) {
                                                                if (WtloginHelper.this.mG.f422962i != 0) {
                                                                    z17 = true;
                                                                } else {
                                                                    z17 = false;
                                                                }
                                                                if (!z17) {
                                                                    WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                                    HelperThread helperThread5 = HelperThread.this;
                                                                    wtloginListener.OnGetStWithoutPasswd(helperThread5.mUserAccount, helperThread5.mDwAppid, helperThread5.mDwDstAppid, helperThread5.mDwMainSigMap, helperThread5.mDwSubDstAppid, helperThread5.mUserSigInfo, GetStWithoutPasswd, errMsg);
                                                                    return;
                                                                }
                                                            }
                                                            WtloginListener wtloginListener2 = HelperThread.this.mHelper.mListener;
                                                            HelperThread helperThread6 = HelperThread.this;
                                                            wtloginListener2.OnGetStWithoutPasswd(helperThread6.mUserAccount, helperThread6.mDwAppid, helperThread6.mDwDstAppid, helperThread6.mDwMainSigMap, helperThread6.mDwSubDstAppid, helperThread6.mDwDstSubAppidList, helperThread6.mUserSigInfo, helperThread6.mST, GetStWithoutPasswd, errMsg);
                                                        }
                                                    };
                                                } catch (Exception e16) {
                                                    exc = e16;
                                                    i16 = i26;
                                                    util.printException(exc, "");
                                                    this.mHandler.post(new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.25
                                                        @Override // java.lang.Runnable
                                                        public void run() {
                                                            HelperThread.this.quitSelfLooper();
                                                            if (i16 != 0) {
                                                                return;
                                                            }
                                                            if (HelperThread.this.mHelper.mListener != null) {
                                                                WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                                ErrMsg errMsg = new ErrMsg();
                                                                HelperThread helperThread = HelperThread.this;
                                                                wtloginListener.OnException(errMsg, helperThread.mReqType, helperThread.mUserSigInfo);
                                                                return;
                                                            }
                                                            util.LOGW("login helper listener is null", HelperThread.this.mUserAccount);
                                                        }
                                                    });
                                                    if (this.isSelfLooper) {
                                                    }
                                                    if (this.mReqType == 7) {
                                                    }
                                                }
                                            } catch (Throwable th9) {
                                                th = th9;
                                                th5 = th;
                                                throw th5;
                                            }
                                        }
                                    } else if (i27 == 6) {
                                        try {
                                            final int GetA1WithA1 = this.mHelper.GetA1WithA1(this.mUserAccount, this.mAppid1, this.mSubAppid1, this.mDwMainSigMap, this.mAppName2, this.mSsoVer2, this.mAppid2, this.mSubAppid2, this.mAppVer2, this.mAppSign2, this.mUserSigInfo, this.mFastLoginInfo, 1);
                                            handler = this.mHandler;
                                            runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.8
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    HelperThread.this.quitSelfLooper();
                                                    if (i26 != 0) {
                                                        return;
                                                    }
                                                    ErrMsg errMsg = u.b(HelperThread.this.mUserSigInfo._seqence)._last_err_msg;
                                                    u.e(HelperThread.this.mUserSigInfo._seqence);
                                                    WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                    HelperThread helperThread = HelperThread.this;
                                                    wtloginListener.onGetA1WithA1(helperThread.mUserAccount, helperThread.mAppid1, helperThread.mDwMainSigMap, helperThread.mSubAppid1, helperThread.mAppName2, helperThread.mSsoVer2, helperThread.mAppid2, helperThread.mSubAppid2, helperThread.mAppVer2, helperThread.mAppSign2, helperThread.mUserSigInfo, helperThread.mFastLoginInfo, GetA1WithA1, errMsg);
                                                }
                                            };
                                        } catch (Exception e17) {
                                            e = e17;
                                            i16 = i26;
                                            exc = e;
                                            util.printException(exc, "");
                                            this.mHandler.post(new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.25
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    HelperThread.this.quitSelfLooper();
                                                    if (i16 != 0) {
                                                        return;
                                                    }
                                                    if (HelperThread.this.mHelper.mListener != null) {
                                                        WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                        ErrMsg errMsg = new ErrMsg();
                                                        HelperThread helperThread = HelperThread.this;
                                                        wtloginListener.OnException(errMsg, helperThread.mReqType, helperThread.mUserSigInfo);
                                                        return;
                                                    }
                                                    util.LOGW("login helper listener is null", HelperThread.this.mUserAccount);
                                                }
                                            });
                                            if (this.isSelfLooper) {
                                                Looper.loop();
                                            }
                                            if (this.mReqType == 7) {
                                                synchronized (WtloginHelper.__sync_top) {
                                                    int i28 = WtloginHelper.__top;
                                                    if (i28 > 0) {
                                                        WtloginHelper.__top = i28 - 1;
                                                    }
                                                    WUserSigInfo wUserSigInfo = this.mUserSigInfo;
                                                    if (wUserSigInfo != null && (bArr2 = wUserSigInfo._reserveData) != null && bArr2.length > 3) {
                                                        i17 = util.buf_to_int32(bArr2, 0);
                                                    } else {
                                                        i17 = 0;
                                                    }
                                                    util.LOGI("pop queue " + WtloginHelper.__top + ", ssoSeq = " + i17 + ", reqType = " + this.mReqType, "");
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    } else if (i27 == 7) {
                                        this.mHelper.RequestReport(1, this.mST1, this.mST1Key, this.mUIN, this.mDwAppid);
                                    } else if (i27 == 9) {
                                        final int RequestTransport = this.mHelper.RequestTransport(1, this.mEncrypt, this.mUserAccount, this.mDwAppid, this.mRole, this.mReqContext, this.mUserSigInfo);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.9
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                util.LOGI("RequestTransport handler:ret=" + RequestTransport + "subCmd=" + HelperThread.this.mReqContext._subcmd + "cancel=" + i26, HelperThread.this.mUserAccount);
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mReqContext.is_register_req()) {
                                                    HelperThread helperThread = HelperThread.this;
                                                    helperThread.mHelper.OnRequestRegister(helperThread.mUserAccount, helperThread.mDwAppid, helperThread.mRole, helperThread.mReqContext, helperThread.mUserSigInfo, RequestTransport);
                                                    return;
                                                }
                                                if (HelperThread.this.mReqContext.is_code2d_func_req()) {
                                                    HelperThread helperThread2 = HelperThread.this;
                                                    helperThread2.mHelper.OnRequestCode2d(helperThread2.mUserAccount, helperThread2.mDwAppid, helperThread2.mRole, helperThread2.mReqContext, helperThread2.mUserSigInfo, RequestTransport);
                                                } else if (!HelperThread.this.mReqContext.is_devlock_req()) {
                                                    WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                    HelperThread helperThread3 = HelperThread.this;
                                                    wtloginListener.OnRequestTransport(helperThread3.mUserAccount, helperThread3.mDwAppid, helperThread3.mRole, helperThread3.mReqContext, helperThread3.mUserSigInfo, RequestTransport);
                                                } else {
                                                    HelperThread helperThread4 = HelperThread.this;
                                                    helperThread4.mHelper.OnDeviceLockRequest(helperThread4.mUserAccount, helperThread4.mDwAppid, helperThread4.mRole, helperThread4.mReqContext, helperThread4.mUserSigInfo, RequestTransport);
                                                }
                                            }
                                        };
                                    } else if (i27 == 10) {
                                        final int RequestTransportMsf = this.mHelper.RequestTransportMsf(1, this.mEncrypt, this.mUserAccount, this.mDwAppid, this.mRole, this.mReqContext);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.10
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 == 0) {
                                                    WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                    HelperThread helperThread = HelperThread.this;
                                                    wtloginListener.OnRequestTransport(helperThread.mUserAccount, helperThread.mDwAppid, helperThread.mRole, helperThread.mReqContext, RequestTransportMsf);
                                                }
                                            }
                                        };
                                    } else if (i27 == 12) {
                                        final int CheckSMSVerifyLoginAccount = this.mHelper.CheckSMSVerifyLoginAccount(this.mAppid1, this.mSubAppid1, this.mUserAccount, this.mExtraFlag, this.mExtraUin, this.mUserSigInfo, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.11
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                boolean z17;
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                ErrMsg errMsg = b16._last_err_msg;
                                                if (CheckSMSVerifyLoginAccount == 0) {
                                                    SwitchListener switchListener = WtloginHelper.switchListener;
                                                    if (switchListener != null && switchListener.isSwitchOn(SmsVerifyContext.MANAGER_ID, true)) {
                                                        z17 = true;
                                                    } else {
                                                        z17 = false;
                                                    }
                                                    util.LOGI("CheckSMSVerifyLoginAccount context persist isSwitchOn = " + z17, "");
                                                    if (z17) {
                                                        oicq.wlogin_sdk.contextpersist.a.a(WtloginHelper.this.mContext, new SmsVerifyContext(b16.get_t104(), b16._t126, b16._msalt), SmsVerifyContext.MMKV_KEY_CONTEXT_PERSIST_SMS_VERIFY);
                                                    }
                                                }
                                                HelperThread helperThread = HelperThread.this;
                                                int i29 = helperThread.mExtraFlag;
                                                WtloginListener wtloginListener = helperThread.mHelper.mListener;
                                                if (i29 == 1) {
                                                    HelperThread helperThread2 = HelperThread.this;
                                                    wtloginListener.OnCheckSMSVerifyLoginAccount(helperThread2.mAppid1, helperThread2.mSubAppid1, helperThread2.mUserAccount, b16._smslogin_msg, b16._smslogin_msgcnt, b16._smslogin_timelimit, helperThread2.mUserSigInfo, CheckSMSVerifyLoginAccount, errMsg);
                                                } else {
                                                    HelperThread helperThread3 = HelperThread.this;
                                                    wtloginListener.OnCheckSMSVerifyLoginAccountForReview(helperThread3.mAppid1, helperThread3.mSubAppid1, b16._smslogin_zone, b16._smslogin_hint_mobile, helperThread3.mUserSigInfo, CheckSMSVerifyLoginAccount, errMsg);
                                                }
                                            }
                                        };
                                    } else if (i27 == 13) {
                                        final int VerifySMSVerifyLoginCode = this.mHelper.VerifySMSVerifyLoginCode(this.mUserAccount, this.mMsgCode, this.mUserSigInfo, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.12
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                ErrMsg errMsg = b16._last_err_msg;
                                                HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextSigSessionDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextDataIntoExtentMap(b16, VerifySMSVerifyLoginCode);
                                                WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                HelperThread helperThread = HelperThread.this;
                                                wtloginListener.OnVerifySMSVerifyLoginCode(helperThread.mUserAccount, helperThread.mMsgCode, helperThread.mUserSigInfo, VerifySMSVerifyLoginCode, errMsg);
                                            }
                                        };
                                    } else if (i27 == 14) {
                                        final int RefreshSMSVerifyLoginCode = this.mHelper.RefreshSMSVerifyLoginCode(this.mUserAccount, this.mUserSigInfo, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.13
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                ErrMsg errMsg = b16._last_err_msg;
                                                if (RefreshSMSVerifyLoginCode == 0) {
                                                    util.LOGI("RefreshSMSVerifyLoginCode context persist ", "");
                                                    oicq.wlogin_sdk.contextpersist.a.a(WtloginHelper.this.mContext, new SmsVerifyContext(b16.get_t104(), b16._t126, b16._msalt), SmsVerifyContext.MMKV_KEY_CONTEXT_PERSIST_SMS_VERIFY);
                                                }
                                                WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                HelperThread helperThread = HelperThread.this;
                                                wtloginListener.OnRefreshSMSVerifyLoginCode(helperThread.mUserAccount, b16._smslogin_msg, b16._smslogin_msgcnt, b16._smslogin_timelimit, helperThread.mUserSigInfo, RefreshSMSVerifyLoginCode, errMsg);
                                            }
                                        };
                                    } else if (i27 == 8) {
                                        this.mHelper.RequestReportError(1, this.mST1, this.mST1Key, this.mUIN, this.mDwAppid, this.mReportErrType);
                                        SwitchListener switchListener = WtloginHelper.switchListener;
                                        if (switchListener != null && switchListener.isSwitchOn("wt_request_looper_close", true)) {
                                            this.mHandler.post(new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.14
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    HelperThread.this.quitSelfLooper();
                                                }
                                            });
                                        }
                                    } else if (i27 == 15) {
                                        final int stWithQQSig = this.mHelper.getStWithQQSig(this.mUserAccount, this.quickLoginParam, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.15
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mHelper.mListener == null) {
                                                    util.LOGW("login helper listener is null", HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                ErrMsg errMsg = b16._last_err_msg;
                                                HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextDataIntoExtentMap(b16, stWithQQSig);
                                                util.LOGI("onQuickLogin ret=" + stWithQQSig, HelperThread.this.mUserAccount);
                                                WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                HelperThread helperThread = HelperThread.this;
                                                wtloginListener.onQuickLogin(helperThread.mUserAccount, helperThread.quickLoginParam, stWithQQSig, errMsg);
                                            }
                                        };
                                    } else if (i27 == 16) {
                                        final int stWithPtSig = this.mHelper.getStWithPtSig(this.mUserAccount, this.ptSig, this.quickLoginParam, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.16
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mHelper.mListener == null) {
                                                    util.LOGW("login helper listener is null", HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                ErrMsg errMsg = b16._last_err_msg;
                                                HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextDataIntoExtentMap(b16, stWithPtSig);
                                                WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                HelperThread helperThread = HelperThread.this;
                                                wtloginListener.onQuickLogin(helperThread.mUserAccount, helperThread.quickLoginParam, stWithPtSig, errMsg);
                                            }
                                        };
                                    } else if (i27 == 17) {
                                        final int stWithQrSig = this.mHelper.getStWithQrSig(this.mUserAccount, this.mDwAppid, this.mDwSubDstAppid, this.mDwMainSigMap, this.mUserSigInfo, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.17
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mHelper.mListener == null) {
                                                    util.LOGW("login helper listener is null", HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                ErrMsg errMsg = u.b(HelperThread.this.mUserSigInfo._seqence)._last_err_msg;
                                                WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                HelperThread helperThread = HelperThread.this;
                                                wtloginListener.onGetStWithQrSig(helperThread.mUserAccount, helperThread.mDwAppid, helperThread.mDwMainSigMap, helperThread.mDwSubDstAppid, helperThread.mUserSigInfo, stWithQrSig, errMsg);
                                            }
                                        };
                                    } else if (i27 == 18) {
                                        final int quickLoginByWeChat = this.mHelper.quickLoginByWeChat(this.mWxAppid, this.weChatCode, this.quickLoginParam, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.18
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                byte[] bArr4;
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mHelper.mListener == null) {
                                                    util.LOGW("login helper listener is null", HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                ErrMsg errMsg = b16._last_err_msg;
                                                HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextDataIntoExtentMap(b16, quickLoginByWeChat);
                                                tlv_t tlv_tVar = b16.tlv540;
                                                if (tlv_tVar != null) {
                                                    bArr4 = tlv_tVar.get_data();
                                                } else {
                                                    bArr4 = null;
                                                }
                                                HelperThread.this.mHelper.mListener.onLoginByWeChat(b16._uin, bArr4, HelperThread.this.quickLoginParam, b16._weixinUserFlags, quickLoginByWeChat, errMsg);
                                            }
                                        };
                                    } else if (i27 == 19) {
                                        final int quickLoginByGateway = this.mHelper.quickLoginByGateway(this.mAppid1, this.mSubAppid1, this.mDwMainSigMap, this.mUserSigInfo, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.19
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mHelper.mListener == null) {
                                                    util.LOGW("quickLoginByGateway helper listener is null", HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextDataIntoExtentMap(b16, quickLoginByGateway);
                                                HelperThread.this.saveContextSigSessionDataIntoExtentMap(b16);
                                                util.LOGW("quickLoginByGateway helper listener uin" + HelperThread.this.mUserSigInfo.uin, HelperThread.this.mUserAccount);
                                                WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                int i29 = quickLoginByGateway;
                                                WUserSigInfo wUserSigInfo2 = HelperThread.this.mUserSigInfo;
                                                wtloginListener.onLoginByGateway(i29, wUserSigInfo2, wUserSigInfo2.uin, b16._last_err_msg, null);
                                            }
                                        };
                                    } else if (i27 == 21) {
                                        final int stByGateWay = this.mHelper.getStByGateWay(this.mAppid1, this.mSubAppid1, this.mDwMainSigMap, this.mUserSigInfo, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.20
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mHelper.mListener == null) {
                                                    util.LOGW("getStByGateWay helper listener is null", HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextDataIntoExtentMap(b16, stByGateWay);
                                                HelperThread.this.saveContextSigSessionDataIntoExtentMap(b16);
                                                util.LOGW("getStByGateWay helper listener uin" + HelperThread.this.mUserSigInfo.uin, HelperThread.this.mUserAccount);
                                                WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                int i29 = stByGateWay;
                                                HelperThread helperThread = HelperThread.this;
                                                long j3 = helperThread.mAppid1;
                                                int i36 = helperThread.mDwMainSigMap;
                                                long j16 = helperThread.mSubAppid1;
                                                WUserSigInfo wUserSigInfo2 = helperThread.mUserSigInfo;
                                                wtloginListener.onGetStByGateWay(i29, j3, i36, j16, wUserSigInfo2, wUserSigInfo2.uin, b16._last_err_msg);
                                            }
                                        };
                                    } else if (i27 == 23) {
                                        final int stByPhoneAndPassword = this.mHelper.getStByPhoneAndPassword(this.mAppid1, this.mSubAppid1, this.mDwMainSigMap, this.mUserSigInfo, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.21
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mHelper.mListener == null) {
                                                    util.LOGW("getStByPhoneAndPassword helper listener is null", HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextDataIntoExtentMap(b16, stByPhoneAndPassword);
                                                HelperThread.this.saveContextSigSessionDataIntoExtentMap(b16);
                                                util.LOGW("getStByPhoneAndPassword helper listener uin" + HelperThread.this.mUserSigInfo.uin, HelperThread.this.mUserAccount);
                                                WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                int i29 = stByPhoneAndPassword;
                                                HelperThread helperThread = HelperThread.this;
                                                long j3 = helperThread.mAppid1;
                                                int i36 = helperThread.mDwMainSigMap;
                                                long j16 = helperThread.mSubAppid1;
                                                WUserSigInfo wUserSigInfo2 = helperThread.mUserSigInfo;
                                                wtloginListener.onGetStByGateWay(i29, j3, i36, j16, wUserSigInfo2, wUserSigInfo2.uin, b16._last_err_msg);
                                            }
                                        };
                                    } else if (i27 == 25) {
                                        final int stViaThirdPlatformLogin = this.mHelper.getStViaThirdPlatformLogin(this.mAppid1, this.mSubAppid1, this.mDwMainSigMap, this.mUserSigInfo, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.22
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mHelper.mListener == null) {
                                                    util.LOGW("getStViaThirdPlatformLogin helper listener is null", HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextDataIntoExtentMap(b16, stViaThirdPlatformLogin);
                                                HelperThread.this.saveContextSigSessionDataIntoExtentMap(b16);
                                                util.LOGW("getStViaThirdPlatformLogin helper listener uin" + HelperThread.this.mUserSigInfo.uin, HelperThread.this.mUserAccount);
                                                WtloginListener wtloginListener = HelperThread.this.mHelper.mListener;
                                                int i29 = stViaThirdPlatformLogin;
                                                HelperThread helperThread = HelperThread.this;
                                                long j3 = helperThread.mAppid1;
                                                int i36 = helperThread.mDwMainSigMap;
                                                long j16 = helperThread.mSubAppid1;
                                                WUserSigInfo wUserSigInfo2 = helperThread.mUserSigInfo;
                                                wtloginListener.onGetStByGateWay(i29, j3, i36, j16, wUserSigInfo2, wUserSigInfo2.uin, b16._last_err_msg);
                                            }
                                        };
                                    } else if (i27 == 24) {
                                        final int saltUinList = this.mHelper.getSaltUinList(this.mDwAppid, this.mDwSubDstAppid, this.mUserPasswd, this.mUserSigInfo, this.mDwSubAppidList, this.mIsSmslogin, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.23
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mHelper.mListener == null) {
                                                    util.LOGW("login helper listener is null", HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                ErrMsg errMsg = b16._last_err_msg;
                                                HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextDataIntoExtentMap(b16, saltUinList);
                                                util.LOGW("getSaltUinList helper listener ret = " + saltUinList, HelperThread.this.mUserAccount);
                                                HelperThread.this.mHelper.mListener.onGetSaltUinList(saltUinList, HelperThread.this.mUserSigInfo, errMsg);
                                            }
                                        };
                                    } else if (i27 == 20) {
                                        final int quickLoginByThirdPlatform = this.mHelper.quickLoginByThirdPlatform(this.quickLoginParam, 1);
                                        handler = this.mHandler;
                                        runnable = new Runnable() { // from class: oicq.wlogin_sdk.request.WtloginHelper.HelperThread.24
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HelperThread.this.quitSelfLooper();
                                                if (i26 != 0) {
                                                    return;
                                                }
                                                if (HelperThread.this.mHelper.mListener == null) {
                                                    util.LOGW("login helper listener is null", HelperThread.this.mUserAccount);
                                                    return;
                                                }
                                                async_context b16 = u.b(HelperThread.this.mUserSigInfo._seqence);
                                                ErrMsg errMsg = b16._last_err_msg;
                                                HelperThread.this.saveContextCommonDataIntoExtentMap(b16);
                                                HelperThread.this.saveContextDataIntoExtentMap(b16, quickLoginByThirdPlatform);
                                                HelperThread.this.mHelper.mListener.onLoginByThirdPlatform(b16._uin, HelperThread.this.quickLoginParam, quickLoginByThirdPlatform, errMsg);
                                            }
                                        };
                                    }
                                    handler.post(runnable);
                                }
                                if (this.isSelfLooper) {
                                    Looper.loop();
                                }
                                if (this.mReqType == 7) {
                                    synchronized (WtloginHelper.__sync_top) {
                                        int i29 = WtloginHelper.__top;
                                        if (i29 > 0) {
                                            WtloginHelper.__top = i29 - 1;
                                        }
                                        WUserSigInfo wUserSigInfo2 = this.mUserSigInfo;
                                        if (wUserSigInfo2 != null && (bArr3 = wUserSigInfo2._reserveData) != null && bArr3.length > 3) {
                                            i19 = util.buf_to_int32(bArr3, 0);
                                        } else {
                                            i19 = 0;
                                        }
                                        util.LOGI("pop queue " + WtloginHelper.__top + ", ssoSeq = " + i19 + ", reqType = " + this.mReqType, "");
                                    }
                                    return;
                                }
                                return;
                            }
                            handler2.post(runnable2);
                            if (this.isSelfLooper) {
                            }
                            if (this.mReqType == 7) {
                            }
                        } else {
                            throw new Exception("Handler should not be null!");
                        }
                    } catch (Exception e18) {
                        e = e18;
                    }
                } catch (Throwable th10) {
                    if (this.isSelfLooper) {
                        Looper.loop();
                    }
                    if (this.mReqType != 7) {
                        synchronized (WtloginHelper.__sync_top) {
                            int i36 = WtloginHelper.__top;
                            if (i36 > 0) {
                                WtloginHelper.__top = i36 - 1;
                            }
                            WUserSigInfo wUserSigInfo3 = this.mUserSigInfo;
                            if (wUserSigInfo3 != null && (bArr = wUserSigInfo3._reserveData) != null && bArr.length > 3) {
                                i3 = util.buf_to_int32(bArr, 0);
                            } else {
                                i3 = 0;
                            }
                            util.LOGI("pop queue " + WtloginHelper.__top + ", ssoSeq = " + i3 + ", reqType = " + this.mReqType, "");
                            throw th10;
                        }
                    }
                    throw th10;
                }
            } catch (Exception e19) {
                e = e19;
                i16 = i26;
            }
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, int i3, String str, long j3, long j16, TransReqContext transReqContext, String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mEncrypt = i3;
            this.mUserAccount = str;
            this.mDwAppid = j3;
            this.mRole = j16;
            this.mReqContext = transReqContext;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, int i3, String str, long j3, long j16, TransReqContext transReqContext, WUserSigInfo wUserSigInfo, String str2) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mEncrypt = i3;
            this.mUserAccount = str;
            this.mDwAppid = j3;
            this.mRole = j16;
            this.mReqContext = transReqContext;
            this.mUserSigInfo = wUserSigInfo;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, long j3, long j16, int i3, WUserSigInfo wUserSigInfo, String str) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mAppid1 = j3;
            this.mSubAppid1 = j16;
            this.mUserSigInfo = wUserSigInfo;
            this.mDwMainSigMap = i3;
            setName(THREAD_NAME_PRE + str);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, long j3, long j16, String str, int i3, long j17, WUserSigInfo wUserSigInfo, String str2) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mAppid1 = j3;
            this.mSubAppid1 = j16;
            this.mUserSigInfo = wUserSigInfo;
            this.mExtraFlag = i3;
            this.mExtraUin = j17;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, long j3, String str) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUIN = j3;
            setName(THREAD_NAME_PRE + str);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, long j3, int i3, long j16, WUserSigInfo wUserSigInfo, String str2) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mDwAppid = j3;
            this.mDwMainSigMap = i3;
            this.mDwSubDstAppid = j16;
            this.mUserSigInfo = wUserSigInfo;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, long j3, int i3, long j16, long[] jArr, boolean z16, String str2, WUserSigInfo wUserSigInfo, byte[][] bArr, boolean z17, String str3) {
            this.isSelfLooper = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mDwAppid = j3;
            this.mDwMainSigMap = i3;
            this.mDwSubDstAppid = j16;
            this.mDwSubAppidList = jArr;
            this.mPwdMd5 = z16;
            this.mUserPasswd = str2;
            this.mUserSigInfo = wUserSigInfo;
            this.mST = bArr;
            this.mIsSmslogin = z17;
            setName(THREAD_NAME_PRE + str3);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, long j3, long j16, int i3, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, String str2) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mAppid1 = j3;
            this.mSubAppid1 = j16;
            this.mDwMainSigMap = i3;
            this.mAppName2 = bArr;
            this.mSsoVer2 = j18;
            this.mAppid2 = j18;
            this.mSubAppid2 = j19;
            this.mAppVer2 = bArr2;
            this.mAppSign2 = bArr3;
            this.mUserSigInfo = wUserSigInfo;
            this.mFastLoginInfo = wFastLoginInfo;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, long j3, WUserSigInfo wUserSigInfo, byte[] bArr, String str2) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mSmsAppid = j3;
            this.mUserSigInfo = wUserSigInfo;
            this.mExtraData = bArr;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, String str2, WUserSigInfo wUserSigInfo, String str3) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mMsgCode = str2;
            this.mUserSigInfo = wUserSigInfo;
            setName(THREAD_NAME_PRE + str3);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, String str2, QuickLoginParam quickLoginParam, String str3) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.ptSig = str2;
            this.quickLoginParam = quickLoginParam;
            this.mUserSigInfo = quickLoginParam.userSigInfo;
            setName(THREAD_NAME_PRE + str3);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, WUserSigInfo wUserSigInfo, String str2) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mUserSigInfo = wUserSigInfo;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, QuickLoginParam quickLoginParam, String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.quickLoginParam = quickLoginParam;
            this.mUserSigInfo = quickLoginParam.userSigInfo;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, String str2) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mUserInput = bArr;
            this.mUserSigInfo = wUserSigInfo;
            this.mST = bArr2;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, byte[] bArr3, String str2) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.mUserInput = bArr;
            this.mUserSigInfo = wUserSigInfo;
            this.mST = bArr2;
            this.mExtraData = bArr3;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, String str, byte[] bArr, byte[] bArr2, QuickLoginParam quickLoginParam, String str2) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mUserAccount = str;
            this.weChatCode = bArr2;
            this.mWxAppid = bArr;
            this.quickLoginParam = quickLoginParam;
            this.mUserSigInfo = quickLoginParam.userSigInfo;
            setName(str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, WtTicketPromise wtTicketPromise, String str, long j3, long j16, long j17, int i3, long j18, long[] jArr, WUserSigInfo wUserSigInfo, byte[][] bArr, byte[][] bArr2, String str2) {
            this.isSelfLooper = false;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mPromise = wtTicketPromise;
            this.mUserAccount = str;
            this.mDwAppid = j3;
            this.mDwDstAppid = j16;
            this.mDwDstAppPri = j17;
            this.mDwMainSigMap = i3;
            this.mDwSubDstAppid = j18;
            this.mDwDstSubAppidList = jArr;
            this.mUserSigInfo = wUserSigInfo;
            this.mST = bArr;
            this.mReserve = bArr2;
            setName(THREAD_NAME_PRE + str2);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, byte[] bArr, byte[] bArr2, long j3, long j16, int i3, String str) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mST1 = bArr;
            this.mST1Key = bArr2;
            this.mUIN = j3;
            this.mDwAppid = j16;
            this.mReportErrType = i3;
            setName(THREAD_NAME_PRE + str);
        }

        public HelperThread(WtloginHelper wtloginHelper, Handler handler, byte[] bArr, byte[] bArr2, long j3, long j16, String str) {
            this.isSelfLooper = false;
            this.mUserSigInfo = null;
            this.mIsSmslogin = false;
            this.mExtraUin = -1L;
            this.mExtraFlag = 1;
            this.mHelper = wtloginHelper;
            this.mHandler = handler;
            this.mST1 = bArr;
            this.mST1Key = bArr2;
            this.mUIN = j3;
            this.mDwAppid = j16;
            setName(THREAD_NAME_PRE + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class LoginSourceType {
        public static final int IM = 10;
        public static final int QQConn = 20;
        public static final int QQWallet = 40;
        public static final int unknown = 0;
        public static final int webView = 30;
        public static final int webViewForceRefresh = 31;
        public static final int webViewOnTimeRefresh = 32;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class QuickLoginParam {
        public long appid;
        public long dstAppid;
        public long[] dstSubAppidList;
        public int sigMap;
        public String userAccount;
        public String webViewActivityClassName;
        public boolean forceWebLogin = false;
        public boolean isUserAccountLocked = false;
        public String titleBackgroundColor = "#3F51B5";
        public String titleTextColor = "#FFFFFF";
        public int startAnimEnter = 0;
        public int startAnimExit = 0;
        public int finishAnimEnter = 0;
        public int finishAnimExit = 0;
        public long subAppid = 1;
        public WUserSigInfo userSigInfo = new WUserSigInfo();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class QuickLoginRequestCode {
        public static final int REQUEST_PT_LOGIN = 1202;
        public static final int REQUEST_QQ_LOGIN = 1201;

        public QuickLoginRequestCode() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class RegTLVType {
        public static final int ADDRESS_BOOK = 7;
        public static final int APPID = 2;
        public static final int APPNAME = 14;
        public static final int CALL_BACK_URL = 5;
        public static final int EMAIL_URL = 4;
        public static final int GUID = 10;
        public static final int HAS_ADDRESS_BOOK = 8;
        public static final int ID = 1;
        public static final int LANGUAGE = 3;
        public static final int LIMIT_PHONE_REG = 51;
        public static final int MPASSWD = 11;
        public static final int MSALT = 12;
        public static final int NEW_UIN = 31;
        public static final int NICK_NAME = 6;
        public static final int NOPASSWD_REG = 9;
        public static final int PHONE_NUMBER = 30;
        public static final int PHONE_NUMBER_BOUND_UIN = 36;
        public static final int PICTURE_ID = 17;
        public static final int PICTURE_URL = 40;
        public static final int REGISTER_SIG = 16;
        public static final int REG_SIG = 33;
        public static final int SET_DEVLOCK_FLG = 15;
        public static final int SUBAPPID = 13;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class SigType {
        public static final int WLOGIN_A2 = 64;
        public static final int WLOGIN_A5 = 2;
        public static final int WLOGIN_AQSIG = 2097152;
        public static final int WLOGIN_D2 = 262144;
        public static final int WLOGIN_DA2 = 33554432;
        public static final int WLOGIN_LHSIG = 4194304;
        public static final int WLOGIN_LSKEY = 512;
        public static final int WLOGIN_OPENKEY = 16384;
        public static final int WLOGIN_PAYTOKEN = 8388608;
        public static final int WLOGIN_PF = 16777216;
        public static final int WLOGIN_PSKEY = 1048576;
        public static final int WLOGIN_PT4Token = 134217728;
        public static final int WLOGIN_QRPUSH = 67108864;
        public static final int WLOGIN_RESERVED = 16;
        public static final int WLOGIN_SID = 524288;
        public static final int WLOGIN_SIG64 = 8192;
        public static final int WLOGIN_SKEY = 4096;
        public static final int WLOGIN_ST = 128;
        public static final int WLOGIN_STWEB = 32;
        public static final int WLOGIN_TOKEN = 32768;
        public static final int WLOGIN_VKEY = 131072;
    }

    public WtloginHelper(Context context) {
        this.mG = new u();
        this.mHelperHandler = initHelperHandler();
        this.mContext = null;
        this.mListener = null;
        this.mRegStatus = new oicq.wlogin_sdk.register.c();
        this.mMainSigMap = 16724722;
        this.mSubSigMap = 66560;
        this.mMiscBitmap = 150470524;
        this.mOpenAppid = 715019303L;
        this.mAysncSeq = 0L;
        this.mDevAsyncSeq = 0L;
        this.isForLocal = false;
        this.mContext = context;
        this.mG.a(context);
        RequestInit();
    }

    private void AsyncGenRSAKey() {
        if (this.isForLocal) {
            return;
        }
        new BaseThread("Wtlogin_AsyncGenRSAKey") { // from class: oicq.wlogin_sdk.request.WtloginHelper.3
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                new RSACrypt(WtloginHelper.this.mContext).GenRSAKey();
            }
        }.start();
    }

    private WloginSigInfo FindUserSig(long j3, long j16) {
        return this.mG.d(j3, j16);
    }

    private int GetFastLoginInfo(byte[] bArr, async_context async_contextVar) {
        String str;
        if (bArr == null || bArr.length <= 3 || async_contextVar == null) {
            return -1017;
        }
        tlv_t106 tlv_t106Var = new tlv_t106();
        tlv_t10c tlv_t10cVar = new tlv_t10c();
        tlv_t16a tlv_t16aVar = new tlv_t16a();
        tlv_t145 tlv_t145Var = new tlv_t145();
        int length = bArr.length;
        if (tlv_t106Var.get_tlv(bArr, 3, length) < 0) {
            str = "fast login info no tgtgt data";
        } else if (tlv_t10cVar.get_tlv(bArr, 3, length) < 0) {
            str = "fast login info no gtkey data";
        } else if (tlv_t16aVar.get_tlv(bArr, 3, length) < 0) {
            str = "fast login info no nopicsig data";
        } else {
            if (tlv_t145Var.get_tlv(bArr, 3, length) > 0) {
                byte[] bArr2 = tlv_t145Var.get_data();
                byte[] bArr3 = u.D;
                util.LOGD("new guid:" + util.buf_to_string(bArr2) + " old guid:" + util.buf_to_string(bArr3));
                if (!Arrays.equals(bArr2, bArr3)) {
                    util.LOGI("fast login info guid not equal", "");
                    util.saveGuidToFile(u.f422949w, bArr2);
                    u.D = (byte[]) bArr2.clone();
                    u.E = (byte[]) bArr2.clone();
                }
            }
            async_contextVar._tmp_pwd = oicq_request.a(tlv_t106Var.get_data(), tlv_t10cVar.get_data());
            async_contextVar._tmp_no_pic_sig = tlv_t16aVar.get_data();
            return 0;
        }
        util.LOGI(str, "");
        return -1017;
    }

    public static WFastLoginInfo GetFastLoginUrl(String str, long j3) {
        StringBuilder sb5;
        String str2;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    util.LOGI("packageName:" + str + " uin:" + j3, "");
                    if (j3 == 1689053018) {
                        sb5 = new StringBuilder();
                        sb5.append("https://qqlogin-appinfo-1251316161.file.myqcloud.com/wtlogin");
                        str2 = "/test";
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append("https://qqlogin-appinfo-1251316161.file.myqcloud.com/wtlogin");
                        str2 = "/app";
                    }
                    sb5.append(str2);
                    String sb6 = sb5.toString();
                    for (String str3 : str.split("\\.")) {
                        sb6 = (sb6 + "/") + str3;
                    }
                    WFastLoginInfo wFastLoginInfo = new WFastLoginInfo();
                    wFastLoginInfo.iconUrl = sb6 + "/icon.png";
                    wFastLoginInfo.adUrl = sb6 + "/ad_img.png";
                    wFastLoginInfo.profileUrl = sb6 + "/profile.js";
                    return wFastLoginInfo;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static byte[] GetTicketSig(WUserSigInfo wUserSigInfo, int i3) {
        Ticket GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, i3);
        if (GetUserSigInfoTicket != null) {
            return GetUserSigInfoTicket._sig;
        }
        return new byte[0];
    }

    public static byte[] GetTicketSigKey(WUserSigInfo wUserSigInfo, int i3) {
        if (i3 != 64 && i3 != 262144 && i3 != 128 && i3 != 16384 && i3 != 32768 && i3 != 16777216) {
            throw null;
        }
        Ticket GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, i3);
        if (GetUserSigInfoTicket != null) {
            return GetUserSigInfoTicket._sig_key;
        }
        return new byte[0];
    }

    public static Ticket GetUserSigInfoTicket(WUserSigInfo wUserSigInfo, int i3) {
        if (i3 == 4194304) {
            return new Ticket(4194304, WloginSigInfo._LHSig, (byte[]) null, u.e(), 0L);
        }
        if (i3 == 67108864) {
            return new Ticket(67108864, WloginSigInfo._QRPUSHSig, (byte[]) null, u.e(), 0L);
        }
        if (wUserSigInfo == null) {
            util.LOGI("GetUserSigInfoTicket userInfo is null " + Integer.toHexString(i3), "");
            return null;
        }
        if (wUserSigInfo._tickets == null) {
            util.LOGI("GetUserSigInfoTicket tickets is null " + Integer.toHexString(i3), wUserSigInfo.uin);
            return null;
        }
        for (int i16 = 0; i16 < wUserSigInfo._tickets.size(); i16++) {
            Ticket ticket = wUserSigInfo._tickets.get(i16);
            if (ticket._type == i3) {
                util.LOGI("GetUserSigInfoTicket type:0x" + Integer.toHexString(i3) + " sig:" + util.buf_to_string(ticket._sig, 2) + " sig length = " + util.buf_len(ticket._sig) + " key:" + util.buf_to_string(ticket._sig_key, 2) + " key length = " + util.buf_len(ticket._sig_key) + " create time:" + ticket._create_time + " expire time:" + ticket._expire_time, "");
                util.LOGI(ticket.getContent(), wUserSigInfo.uin);
                return ticket;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnDeviceLockRequest(String str, long j3, long j16, TransReqContext transReqContext, WUserSigInfo wUserSigInfo, int i3) {
        String str2;
        long parseLong;
        DevlockRst devlockRst = DevlockBase.rst;
        devlockRst.commRsp = new TLV_CommRsp();
        DevlockInfo devlockInfo = new DevlockInfo();
        ErrMsg errMsg = new ErrMsg(0, 0, "", "", "");
        if (i3 != 0) {
            util.LOGI("OnDeviceLockRequest ret:" + i3, str);
            errMsg.setMessage(util.get_error_msg(i3));
            errMsg.setTitle(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_5));
        }
        int i16 = transReqContext.get_subcmd();
        if (i16 != 5) {
            if (i16 != 12) {
                if (i16 != 7) {
                    if (i16 == 8) {
                        if (i3 == 0) {
                            i3 = new oicq.wlogin_sdk.devicelock.e().parse_rsp(transReqContext.get_body());
                            util.LOGI("CheckDevLockSms ret:" + i3, str);
                            if (i3 != -1009) {
                                tlvCommRsp2ErrMsg(devlockRst.commRsp, errMsg);
                            }
                        }
                        WtloginListener wtloginListener = this.mListener;
                        if (wtloginListener != null) {
                            wtloginListener.OnCheckDevLockSms(wUserSigInfo, i3, errMsg);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i3 == 0) {
                    i3 = new oicq.wlogin_sdk.devicelock.c().parse_rsp(transReqContext.get_body());
                    util.LOGI("AskDevLockSms ret:" + i3, str);
                    if (i3 != -1009) {
                        tlvCommRsp2ErrMsg(devlockRst.commRsp, errMsg);
                        oicq.wlogin_sdk.devicelock.l lVar = devlockRst.smsInfo;
                        if (lVar != null) {
                            devlockInfo.AvailableMsgCount = lVar.f422779a;
                            devlockInfo.TimeLimit = lVar.f422780b;
                        }
                    }
                }
                WtloginListener wtloginListener2 = this.mListener;
                if (wtloginListener2 != null) {
                    wtloginListener2.OnAskDevLockSms(wUserSigInfo, devlockInfo, i3, errMsg);
                    return;
                }
                return;
            }
            if (i3 == 0) {
                i3 = new oicq.wlogin_sdk.devicelock.b().parse_rsp(transReqContext.get_body());
                util.LOGI("CloseDevLock ret:" + i3, str);
                if (i3 != -1009) {
                    tlvCommRsp2ErrMsg(devlockRst.commRsp, errMsg);
                    try {
                        if (!util.check_uin_account(str).booleanValue()) {
                            parseLong = this.mG.b(str);
                        } else {
                            parseLong = Long.parseLong(str);
                        }
                        this.mG.a(parseLong, j3);
                        for (int i17 = 0; i17 < wUserSigInfo._tickets.size(); i17++) {
                            if (wUserSigInfo._tickets.get(i17)._type == 33554432) {
                                wUserSigInfo._tickets.remove(i17);
                            }
                        }
                    } catch (Exception e16) {
                        util.printException(e16);
                    }
                }
            }
            WtloginListener wtloginListener3 = this.mListener;
            if (wtloginListener3 != null) {
                wtloginListener3.OnCloseDevLock(wUserSigInfo, i3, errMsg);
                return;
            }
            return;
        }
        if (i3 == 0) {
            i3 = new oicq.wlogin_sdk.devicelock.a().parse_rsp(transReqContext.get_body());
            util.LOGI("CheckDevLockStatus ret:" + i3, str);
            if (i3 != -1009) {
                tlvCommRsp2ErrMsg(devlockRst.commRsp, errMsg);
                oicq.wlogin_sdk.devicelock.h hVar = devlockRst.devSetupInfo;
                if (hVar != null && hVar.get_data_len() > 0) {
                    oicq.wlogin_sdk.devicelock.h hVar2 = devlockRst.devSetupInfo;
                    devlockInfo.DevSetup = hVar2.f422763a;
                    devlockInfo.AllowSet = hVar2.f422764b;
                    oicq.wlogin_sdk.devicelock.g gVar = devlockRst.devGuideInfo;
                    if (gVar != null && gVar.get_data_len() > 0) {
                        str2 = new String(devlockRst.devGuideInfo.f422762a);
                    } else {
                        str2 = new String(devlockRst.devSetupInfo.f422766d);
                    }
                    devlockInfo.ProtectIntro = str2;
                    devlockInfo.WarningInfo = new String(devlockRst.devSetupInfo.f422769g);
                    devlockInfo.WarningTitle = new String(devlockRst.devSetupInfo.f422767e);
                    devlockInfo.WarningMsg = new String(devlockRst.devSetupInfo.f422768f);
                    devlockInfo.WarningInfoType = devlockRst.devSetupInfo.f422765c;
                }
                oicq.wlogin_sdk.devicelock.j jVar = devlockRst.mbMobileInfo;
                if (jVar != null && jVar.get_data_len() > 0) {
                    devlockInfo.CountryCode = new String(devlockRst.mbMobileInfo.f422774a);
                    devlockInfo.Mobile = new String(devlockRst.mbMobileInfo.f422775b);
                    oicq.wlogin_sdk.devicelock.j jVar2 = devlockRst.mbMobileInfo;
                    devlockInfo.MbItemSmsCodeStatus = jVar2.f422776c;
                    devlockInfo.AvailableMsgCount = jVar2.f422777d;
                    devlockInfo.TimeLimit = jVar2.f422778e;
                }
                oicq.wlogin_sdk.devicelock.i iVar = devlockRst.mbGuideInfo;
                if (iVar != null && iVar.get_data_len() > 0) {
                    oicq.wlogin_sdk.devicelock.i iVar2 = devlockRst.mbGuideInfo;
                    devlockInfo.MbGuideType = iVar2.f422772c;
                    devlockInfo.MbGuideInfoType = iVar2.f422773d;
                    devlockInfo.MbGuideInfo = new String(iVar2.f422771b);
                    devlockInfo.MbGuideMsg = new String(devlockRst.mbGuideInfo.f422770a);
                }
                oicq.wlogin_sdk.devicelock.d dVar = devlockRst.transferInfo;
                if (dVar != null && dVar.get_data_len() > 0) {
                    devlockInfo.TransferInfo = devlockRst.transferInfo.get_data();
                }
            }
        }
        WtloginListener wtloginListener4 = this.mListener;
        if (wtloginListener4 != null) {
            wtloginListener4.OnCheckDevLockStatus(wUserSigInfo, devlockInfo, i3, errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OnRequestCode2d(String str, long j3, long j16, TransReqContext transReqContext, WUserSigInfo wUserSigInfo, int i3) {
        int i16;
        byte[] bArr;
        String str2;
        StringBuilder sb5;
        boolean z16;
        int i17;
        int buf_to_int16;
        int i18;
        WloginAllSigInfo wloginAllSigInfo;
        WUserSigInfo wUserSigInfo2 = wUserSigInfo;
        int i19 = i3;
        if (this.mListener == null) {
            util.LOGI("OnRequestCode2d mListener is null", str);
            return;
        }
        oicq.wlogin_sdk.code2d.d dVar = oicq.wlogin_sdk.code2d.c._status;
        if (i19 != 0) {
            util.LOGI("OnRequestCode2d ret:" + i19, str);
        }
        int i26 = transReqContext.get_subcmd();
        if (i26 == 49) {
            if (i19 == 0) {
                i19 = new fetch_code().get_response(transReqContext.get_body());
            }
            util.LOGI("FetchCodeSig ret:" + dVar.f422750b, str);
            this.mListener.OnFetchCodeSig(dVar.f422756h, dVar.f422757i, (long) dVar.f422758j, wUserSigInfo, dVar.f422754f, i19);
            return;
        }
        int i27 = -1009;
        byte[] bArr2 = null;
        int i28 = 2;
        switch (i26) {
            case 18:
                if (i19 == 0) {
                    byte[] bArr3 = new oicq.wlogin_sdk.code2d.e().get_response(transReqContext.get_body(), 0);
                    if (bArr3 != null && bArr3.length >= 8) {
                        int buf_to_int162 = util.buf_to_int16(bArr3, 0);
                        long buf_to_int64 = 2 == (buf_to_int162 != 0 ? util.buf_to_int8(bArr3, 2) : 0) ? util.buf_to_int64(bArr3, 3) : 0L;
                        int i29 = buf_to_int162 + 2;
                        util.buf_to_int32(bArr3, i29);
                        int i36 = i29 + 4;
                        i19 = util.buf_to_int8(bArr3, i36);
                        oicq.wlogin_sdk.code2d.d dVar2 = oicq.wlogin_sdk.code2d.c._status;
                        dVar2.f422749a = buf_to_int64;
                        dVar2.f422750b = i19;
                        int i37 = i36 + 1 + 0;
                        if (i19 == 0) {
                            dVar2.f422749a = util.buf_to_int64(bArr3, i37);
                            oicq.wlogin_sdk.code2d.c._status.f422751c = util.buf_to_int32(bArr3, r6);
                            int i38 = i37 + 8 + 4;
                            oicq.wlogin_sdk.code2d.c._status.f422753e = new ArrayList();
                            int buf_to_int163 = util.buf_to_int16(bArr3, i38);
                            int i39 = 2;
                            int i46 = i38 + 2;
                            byte[] bArr4 = null;
                            byte[] bArr5 = null;
                            byte[] bArr6 = null;
                            int i47 = 0;
                            while (i47 < buf_to_int163) {
                                int buf_to_int164 = util.buf_to_int16(bArr3, i46);
                                int i48 = i46 + i39;
                                int buf_to_int165 = util.buf_to_int16(bArr3, i48);
                                int i49 = i48 + i39;
                                if (buf_to_int164 == 24) {
                                    byte[] bArr7 = new byte[buf_to_int165];
                                    System.arraycopy(bArr3, i49, bArr7, 0, buf_to_int165);
                                    i46 = i49 + buf_to_int165;
                                    bArr4 = bArr7;
                                } else if (buf_to_int164 == 25) {
                                    byte[] bArr8 = new byte[buf_to_int165];
                                    System.arraycopy(bArr3, i49, bArr8, 0, buf_to_int165);
                                    i46 = i49 + buf_to_int165;
                                    bArr2 = bArr8;
                                } else if (buf_to_int164 == 30) {
                                    byte[] bArr9 = new byte[buf_to_int165];
                                    System.arraycopy(bArr3, i49, bArr9, 0, buf_to_int165);
                                    i46 = i49 + buf_to_int165;
                                    bArr5 = bArr9;
                                } else if (buf_to_int164 != 101) {
                                    int i56 = buf_to_int165 + 4;
                                    byte[] bArr10 = new byte[i56];
                                    System.arraycopy(bArr3, i49 - 4, bArr10, 0, i56);
                                    oicq.wlogin_sdk.code2d.c._status.f422753e.add(bArr10);
                                    i46 = i49 + buf_to_int165;
                                } else {
                                    byte[] bArr11 = new byte[buf_to_int165];
                                    System.arraycopy(bArr3, i49, bArr11, 0, buf_to_int165);
                                    i46 = i49 + buf_to_int165;
                                    util.LOGI("get tgtQR len " + buf_to_int165, "" + oicq.wlogin_sdk.code2d.c._status.f422749a);
                                    bArr6 = bArr11;
                                }
                                i47++;
                                i39 = 2;
                            }
                            if (bArr4 != null && bArr5 != null && bArr2 != null) {
                                oicq.wlogin_sdk.code2d.d.f422745l = oicq_request.a(bArr4, bArr5);
                                oicq.wlogin_sdk.code2d.d.f422746m = bArr2;
                                oicq.wlogin_sdk.code2d.d.f422747n = bArr6;
                                i19 = oicq.wlogin_sdk.code2d.c._status.f422750b;
                            }
                        }
                        util.LOGI("QueryCodeResult ret:" + dVar.f422750b, str);
                    }
                    i19 = -1009;
                    util.LOGI("QueryCodeResult ret:" + dVar.f422750b, str);
                }
                this.mListener.OnQueryCodeResult(dVar.f422749a, dVar.f422753e, dVar.f422751c, wUserSigInfo, dVar.f422754f, i19);
                return;
            case 19:
                if (i19 != 0) {
                    this.mListener.OnVerifyCode(str, dVar.f422752d, dVar.f422751c, dVar.f422753e, wUserSigInfo, dVar.f422754f, i3);
                    return;
                }
                byte[] bArr12 = new oicq.wlogin_sdk.code2d.f().get_response(transReqContext.get_body(), 0);
                if (bArr12 == null || bArr12.length < 11) {
                    i16 = -1009;
                } else {
                    oicq.wlogin_sdk.code2d.c._status.f422749a = util.buf_to_int64(bArr12, 2);
                    oicq.wlogin_sdk.code2d.c._status.f422750b = util.buf_to_int8(bArr12, 10) & 255;
                    oicq.wlogin_sdk.code2d.d dVar3 = oicq.wlogin_sdk.code2d.c._status;
                    if (dVar3.f422750b != 0) {
                        int buf_to_int166 = util.buf_to_int16(bArr12, 11);
                        byte[] bArr13 = new byte[buf_to_int166];
                        oicq.wlogin_sdk.code2d.c._status.f422754f = bArr13;
                        System.arraycopy(bArr12, 13, bArr13, 0, buf_to_int166);
                    } else {
                        dVar3.f422751c = util.buf_to_int32(bArr12, 11) & 4294967295L;
                        int buf_to_int167 = util.buf_to_int16(bArr12, 15);
                        byte[] bArr14 = new byte[buf_to_int167];
                        oicq.wlogin_sdk.code2d.c._status.f422752d = bArr14;
                        System.arraycopy(bArr12, 17, bArr14, 0, buf_to_int167);
                        int i57 = buf_to_int167 + 17;
                        int buf_to_int168 = util.buf_to_int16(bArr12, i57);
                        int i58 = i57 + 2;
                        oicq.wlogin_sdk.code2d.d dVar4 = oicq.wlogin_sdk.code2d.c._status;
                        dVar4.f422755g = new byte[0];
                        dVar4.f422753e = new ArrayList(buf_to_int168);
                        for (int i59 = 0; i59 < buf_to_int168; i59++) {
                            int buf_to_int169 = util.buf_to_int16(bArr12, i58);
                            int buf_to_int1610 = util.buf_to_int16(bArr12, i58 + 2);
                            if (buf_to_int169 == 13) {
                                byte[] bArr15 = new byte[buf_to_int1610];
                                oicq.wlogin_sdk.code2d.c._status.f422755g = bArr15;
                                System.arraycopy(bArr12, i58 + 4, bArr15, 0, buf_to_int1610);
                            } else if (buf_to_int169 == 26) {
                                oicq.wlogin_sdk.code2d.d.f422748o = util.buf_to_int8(bArr12, i58 + 4) == 1;
                            } else {
                                int i65 = buf_to_int1610 + 4;
                                byte[] bArr16 = new byte[i65];
                                System.arraycopy(bArr12, i58, bArr16, 0, i65);
                                oicq.wlogin_sdk.code2d.c._status.f422753e.add(bArr16);
                            }
                            i58 += buf_to_int1610 + 4;
                        }
                    }
                    i16 = oicq.wlogin_sdk.code2d.c._status.f422750b;
                }
                dVar.f422750b = i16;
                util.LOGI("VerifyCode ret:" + dVar.f422750b, str);
                if (dVar.f422750b == 0 && (bArr = dVar.f422755g) != null && bArr.length > 0) {
                    u uVar = this.mG;
                    long j17 = dVar.f422749a;
                    synchronized (uVar) {
                        c cVar = u.f422934k0;
                        synchronized (cVar) {
                            util.LOGI("start put_randseed " + j3, "" + j17);
                            if (cVar.f422875a != null) {
                                synchronized (c.f422871e) {
                                    TreeMap<Long, WloginAllSigInfo> a16 = c.a(cVar.f422875a, "tk_file", j17);
                                    if (a16 != null) {
                                        WloginAllSigInfo wloginAllSigInfo2 = a16.get(Long.valueOf(j17));
                                        if (wloginAllSigInfo2 == null) {
                                            str2 = "fileInfo is null " + j3;
                                            sb5 = new StringBuilder();
                                            sb5.append("");
                                        } else {
                                            wloginAllSigInfo2.put_randseed(j3, bArr);
                                            int a17 = cVar.a(a16, "tk_file");
                                            if (a17 != 0) {
                                                str2 = "put_randseed refreshTKTreeMap failed ret " + a17 + " appid " + j3;
                                                sb5 = new StringBuilder();
                                                sb5.append("");
                                            } else {
                                                cVar.f422876b = a16;
                                                util.LOGI("end put_randseed", "" + j17);
                                            }
                                        }
                                        sb5.append(j17);
                                        util.LOGI(str2, sb5.toString());
                                    }
                                }
                            }
                        }
                    }
                }
                this.mListener.OnVerifyCode(str, dVar.f422752d, dVar.f422751c, dVar.f422753e, wUserSigInfo, dVar.f422754f, dVar.f422750b);
                return;
            case 20:
                if (i19 != 0) {
                    this.mListener.OnCloseCode(str, dVar.f422752d, dVar.f422751c, wUserSigInfo, dVar.f422754f, i3);
                    return;
                }
                oicq.wlogin_sdk.code2d.b bVar = new oicq.wlogin_sdk.code2d.b();
                if (wUserSigInfo2 == null) {
                    wUserSigInfo2 = new WUserSigInfo();
                }
                byte[] bArr17 = transReqContext.get_body();
                Context context = u.f422949w;
                HashMap<Integer, tlv_t> hashMap = wUserSigInfo2.loginTLVMap;
                byte[] bArr18 = bVar.get_response(bArr17, 0);
                if (bArr18 != null && bArr18.length >= 11) {
                    oicq.wlogin_sdk.code2d.c._status.f422749a = util.buf_to_int64(bArr18, 2);
                    oicq.wlogin_sdk.code2d.c._status.f422750b = util.buf_to_int8(bArr18, 10) & 255;
                    oicq.wlogin_sdk.code2d.d dVar5 = oicq.wlogin_sdk.code2d.c._status;
                    if (dVar5.f422750b == 0) {
                        dVar5.f422751c = util.buf_to_int32(bArr18, 11) & 4294967295L;
                        int buf_to_int1611 = util.buf_to_int16(bArr18, 15);
                        byte[] bArr19 = new byte[buf_to_int1611];
                        oicq.wlogin_sdk.code2d.c._status.f422752d = bArr19;
                        System.arraycopy(bArr18, 17, bArr19, 0, buf_to_int1611);
                        int i66 = buf_to_int1611 + 17;
                        int i67 = i66 + 2;
                        if (i67 + 2 + 1 < bArr18.length && (buf_to_int16 = util.buf_to_int16(bArr18, i66)) != 0) {
                            byte[] decrypt = cryptor.decrypt(bArr18, i67, buf_to_int16, oicq.wlogin_sdk.code2d.b.f422743a);
                            if (decrypt == null || decrypt.length == 0) {
                                z16 = false;
                                i27 = -1014;
                            } else {
                                int i68 = i67 + buf_to_int16;
                                int buf_to_int1612 = util.buf_to_int16(decrypt, 0);
                                byte[] bArr20 = null;
                                byte[] bArr21 = null;
                                int i69 = 0;
                                while (i69 < buf_to_int1612) {
                                    int i75 = buf_to_int1612;
                                    int buf_to_int1613 = util.buf_to_int16(decrypt, i28);
                                    int i76 = i28 + 2;
                                    int buf_to_int1614 = util.buf_to_int16(decrypt, i76);
                                    int i77 = i76 + 2;
                                    if (buf_to_int1613 == 24) {
                                        byte[] bArr22 = new byte[buf_to_int1614];
                                        System.arraycopy(decrypt, i77, bArr22, 0, buf_to_int1614);
                                        bArr20 = bArr22;
                                    } else if (buf_to_int1613 == 25) {
                                        byte[] bArr23 = new byte[buf_to_int1614];
                                        System.arraycopy(decrypt, i77, bArr23, 0, buf_to_int1614);
                                        bArr2 = bArr23;
                                    } else if (buf_to_int1613 == 30) {
                                        byte[] bArr24 = new byte[buf_to_int1614];
                                        System.arraycopy(decrypt, i77, bArr24, 0, buf_to_int1614);
                                        bArr21 = bArr24;
                                    }
                                    i28 = i77 + buf_to_int1614;
                                    i69++;
                                    buf_to_int1612 = i75;
                                }
                                int buf_to_int1615 = util.buf_to_int16(bArr18, i68);
                                int i78 = i68 + 2;
                                int length = bArr18.length - i78;
                                if (bArr18.length != i78 + length) {
                                    i18 = -1;
                                } else {
                                    int i79 = length;
                                    int i85 = 0;
                                    while (i85 < buf_to_int1615 && i79 > 0) {
                                        int buf_to_int1616 = util.buf_to_int16(bArr18, i78);
                                        int i86 = i78 + 2;
                                        int buf_to_int1617 = util.buf_to_int16(bArr18, i86);
                                        int i87 = i86 + 2;
                                        int i88 = (i79 - 2) - 2;
                                        if (i88 < buf_to_int1617) {
                                            i18 = -2;
                                        } else {
                                            tlv_t tlv_tVar = new tlv_t(buf_to_int1616);
                                            tlv_tVar.set_data(bArr18, i87, buf_to_int1617);
                                            hashMap.put(new Integer(buf_to_int1616), tlv_tVar);
                                            i78 = i87 + buf_to_int1617;
                                            i79 = i88 - buf_to_int1617;
                                            i85++;
                                            bArr18 = bArr18;
                                        }
                                    }
                                    i18 = 0;
                                }
                                if (i18 != 0) {
                                    util.LOGI("parseTLV failed " + i18, "");
                                } else if (oicq.wlogin_sdk.code2d.d.f422748o) {
                                    if (bArr2 == null || bArr20 == null || bArr21 == null) {
                                        z16 = false;
                                    } else {
                                        TreeMap a18 = c.a(context, "tk_file", 0L);
                                        if (a18 != null && (wloginAllSigInfo = (WloginAllSigInfo) a18.get(Long.valueOf(oicq.wlogin_sdk.code2d.c._status.f422749a))) != null) {
                                            byte[][] bArr25 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 5, 0);
                                            for (int i89 = 0; i89 < 5; i89++) {
                                                bArr25[i89] = new byte[0];
                                            }
                                            byte[] a19 = oicq_request.a(bArr20, bArr21);
                                            bArr25[0] = a19;
                                            bArr25[1] = bArr2;
                                            if (a19 != null && a19.length > 0) {
                                                util.LOGI("A1_INFO: update A1 Close code: " + MD5.getMD5String(bArr25[0]), "" + oicq.wlogin_sdk.code2d.c._status.f422749a);
                                            }
                                            z16 = false;
                                            wloginAllSigInfo.put_siginfo(j3, bArr25, u.e());
                                            a18.put(Long.valueOf(oicq.wlogin_sdk.code2d.c._status.f422749a), wloginAllSigInfo.get_clone());
                                            u.f422934k0.a(a18, "tk_file");
                                            i17 = oicq.wlogin_sdk.code2d.c._status.f422750b;
                                            dVar.f422750b = i17;
                                            util.LOGI("CloseCode ret:" + dVar.f422750b, str);
                                            oicq.wlogin_sdk.code2d.d.f422748o = z16;
                                            this.mListener.OnCloseCode(str, dVar.f422752d, dVar.f422751c, wUserSigInfo2, dVar.f422754f, dVar.f422750b);
                                            return;
                                        }
                                        i27 = -1004;
                                    }
                                }
                                i17 = i27;
                            }
                        }
                        z16 = false;
                        i17 = oicq.wlogin_sdk.code2d.c._status.f422750b;
                        dVar.f422750b = i17;
                        util.LOGI("CloseCode ret:" + dVar.f422750b, str);
                        oicq.wlogin_sdk.code2d.d.f422748o = z16;
                        this.mListener.OnCloseCode(str, dVar.f422752d, dVar.f422751c, wUserSigInfo2, dVar.f422754f, dVar.f422750b);
                        return;
                    }
                    int buf_to_int1618 = util.buf_to_int16(bArr18, 11);
                    byte[] bArr26 = new byte[buf_to_int1618];
                    oicq.wlogin_sdk.code2d.c._status.f422754f = bArr26;
                    System.arraycopy(bArr18, 13, bArr26, 0, buf_to_int1618);
                    i17 = oicq.wlogin_sdk.code2d.c._status.f422750b;
                    z16 = false;
                    dVar.f422750b = i17;
                    util.LOGI("CloseCode ret:" + dVar.f422750b, str);
                    oicq.wlogin_sdk.code2d.d.f422748o = z16;
                    this.mListener.OnCloseCode(str, dVar.f422752d, dVar.f422751c, wUserSigInfo2, dVar.f422754f, dVar.f422750b);
                    return;
                }
                z16 = false;
                i17 = i27;
                dVar.f422750b = i17;
                util.LOGI("CloseCode ret:" + dVar.f422750b, str);
                oicq.wlogin_sdk.code2d.d.f422748o = z16;
                this.mListener.OnCloseCode(str, dVar.f422752d, dVar.f422751c, wUserSigInfo2, dVar.f422754f, dVar.f422750b);
                return;
            default:
                util.LOGW("OnRequestName unhandle cmd", "", str);
                this.mListener.OnException(new ErrMsg(), 9, wUserSigInfo2);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:116:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0338  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void OnRequestRegister(String str, long j3, long j16, TransReqContext transReqContext, WUserSigInfo wUserSigInfo, int i3) {
        WtloginListener wtloginListener;
        String str2;
        WtloginListener wtloginListener2;
        int buf_to_int8;
        int buf_to_int82;
        int buf_to_int16;
        int buf_to_int162;
        int buf_to_int163;
        int buf_to_int164;
        String str3;
        int buf_to_int83;
        int buf_to_int84;
        int i16;
        int buf_to_int85;
        int i17;
        int buf_to_int165;
        int buf_to_int166;
        String str4;
        int i18;
        int buf_to_int167;
        int buf_to_int168;
        int readShort;
        WtloginListener wtloginListener3;
        int readShort2;
        WtloginListener wtloginListener4;
        byte[] bArr;
        if (this.mListener == null) {
            return;
        }
        String a16 = InternationMsg.a(InternationMsg.MSG_TYPE.MSG_3);
        if (i3 != 0) {
            WtloginListener wtloginListener5 = this.mListener;
            if (wtloginListener5 != null) {
                wtloginListener5.OnRegError(wUserSigInfo, i3, a16.getBytes());
                return;
            }
            return;
        }
        oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
        int i19 = transReqContext.get_subcmd();
        int i26 = 0;
        if (i19 != 10) {
            if (i19 != 1749 && i19 != 2170 && i19 != 2172) {
                if (i19 == 3) {
                    int a17 = oicq.wlogin_sdk.register.a.a(3, transReqContext.get_body(), cVar);
                    if (a17 != 0) {
                        oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_REGISTER_PHONE, "sub_event_0x3", String.valueOf(a17)), 100);
                        WtloginListener wtloginListener6 = this.mListener;
                        if (wtloginListener6 != null) {
                            wtloginListener6.OnRegError(wUserSigInfo, a17, a16.getBytes());
                            return;
                        }
                        return;
                    }
                    util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + cVar.f422822b, "");
                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_REGISTER_PHONE, "sub_event_0x3", String.valueOf(cVar.f422822b)), 100);
                    int i27 = cVar.f422822b;
                    if (i27 == 0 || i27 == 4 || i27 == 31 || i27 == 118) {
                        if (i27 == 0) {
                            wUserSigInfo.regTLVMap = cVar.f422840t;
                            cVar.f422840t = new HashMap<>();
                        }
                        this.mListener.OnRegQueryClientSentMsgStatus(wUserSigInfo, cVar.f422822b, cVar.f422835o, cVar.f422836p, new String(cVar.f422824d));
                        return;
                    }
                    if (i27 == 3) {
                        WtloginListener wtloginListener7 = this.mListener;
                        if (wtloginListener7 != null) {
                            wtloginListener7.OnRegCheckValidUrl(wUserSigInfo, cVar.f422833m);
                            return;
                        }
                        return;
                    }
                    util.LOGW("OnRequestRegister 0x3 return code:", String.valueOf(i27), str);
                    WtloginListener wtloginListener8 = this.mListener;
                    if (wtloginListener8 != null) {
                        wtloginListener8.OnRegError(wUserSigInfo, cVar.f422822b, cVar.f422824d);
                        return;
                    }
                    return;
                }
                if (i19 == 4) {
                    int a18 = oicq.wlogin_sdk.register.a.a(0, transReqContext.get_body(), cVar);
                    if (a18 != 0) {
                        oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_REGISTER_PHONE, "sub_event_0x4", String.valueOf(a18)), 100);
                        WtloginListener wtloginListener9 = this.mListener;
                        if (wtloginListener9 != null) {
                            wtloginListener9.OnRegError(wUserSigInfo, a18, a16.getBytes());
                            return;
                        }
                        return;
                    }
                    util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + cVar.f422822b, "");
                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_REGISTER_PHONE, "sub_event_0x4", String.valueOf(cVar.f422822b)), 100);
                    int i28 = cVar.f422822b;
                    if (i28 == 0) {
                        wtloginListener2 = this.mListener;
                        if (wtloginListener2 == null) {
                            return;
                        }
                    } else if (i28 == 2) {
                        wtloginListener = this.mListener;
                        if (wtloginListener == null) {
                            return;
                        } else {
                            str2 = new String(cVar.f422832l);
                        }
                    } else {
                        if (i28 == 3) {
                            WtloginListener wtloginListener10 = this.mListener;
                            if (wtloginListener10 != null) {
                                wtloginListener10.OnRegCheckValidUrl(wUserSigInfo, cVar.f422833m);
                                return;
                            }
                            return;
                        }
                        if (i28 != 5) {
                            util.LOGW("OnRequestRegister 0x4 return code:", String.valueOf(i28), str);
                            WtloginListener wtloginListener11 = this.mListener;
                            if (wtloginListener11 != null) {
                                wtloginListener11.OnRegError(wUserSigInfo, cVar.f422822b, cVar.f422824d);
                                return;
                            }
                            return;
                        }
                        wtloginListener2 = this.mListener;
                        if (wtloginListener2 == null) {
                            return;
                        }
                    }
                    wtloginListener2.OnRegRequestServerResendMsg(wUserSigInfo, i28, cVar.f422835o, cVar.f422836p);
                    return;
                }
                if (i19 == 5) {
                    byte[] bArr2 = transReqContext.get_body();
                    int[] b16 = oicq.wlogin_sdk.register.a.b(bArr2);
                    int i29 = b16[0];
                    int i36 = b16[1];
                    if (i29 == -1009) {
                        i26 = i29;
                    } else {
                        int i37 = i36 + 2;
                        if (i37 <= bArr2.length) {
                            cVar.f422822b = util.buf_to_int16(bArr2, i36);
                            int i38 = i37 + 1;
                            if (i38 <= bArr2.length && (buf_to_int82 = i38 + (buf_to_int8 = util.buf_to_int8(bArr2, i37))) <= bArr2.length) {
                                byte[] bArr3 = new byte[buf_to_int8];
                                cVar.f422823c = bArr3;
                                System.arraycopy(bArr2, i38, bArr3, 0, buf_to_int8);
                                int i39 = buf_to_int82 + 2;
                                if (i39 <= bArr2.length && (buf_to_int162 = i39 + (buf_to_int16 = util.buf_to_int16(bArr2, buf_to_int82))) <= bArr2.length) {
                                    byte[] bArr4 = new byte[buf_to_int16];
                                    cVar.f422824d = bArr4;
                                    System.arraycopy(bArr2, i39, bArr4, 0, buf_to_int16);
                                    int i46 = buf_to_int162 + 2;
                                    if (i46 <= bArr2.length && (i26 = oicq.wlogin_sdk.contextpersist.a.a(util.buf_to_int16(bArr2, buf_to_int162), bArr2, i46, bArr2.length - i46, cVar.f422840t)) != 0) {
                                        util.LOGI("parser tlv failed " + i26, "");
                                    }
                                }
                            }
                        }
                        i26 = -1009;
                    }
                    if (i26 != 0) {
                        oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_REGISTER_PHONE, "sub_event_0x5", String.valueOf(i26)), 100);
                        WtloginListener wtloginListener12 = this.mListener;
                        if (wtloginListener12 != null) {
                            wtloginListener12.OnRegError(wUserSigInfo, i26, a16.getBytes());
                            return;
                        }
                        return;
                    }
                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_REGISTER_PHONE, "sub_event_0x5", String.valueOf(cVar.f422822b)), 100);
                    wUserSigInfo.regTLVMap = cVar.f422840t;
                    cVar.f422840t = new HashMap<>();
                    util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + cVar.f422822b, "");
                    WtloginListener wtloginListener13 = this.mListener;
                    if (wtloginListener13 != null) {
                        wtloginListener13.OnRegSubmitMsgChk(wUserSigInfo, cVar.f422822b, cVar.f422824d);
                        return;
                    }
                    return;
                }
                if (i19 == 6) {
                    byte[] bArr5 = transReqContext.get_body();
                    int[] b17 = oicq.wlogin_sdk.register.a.b(bArr5);
                    int i47 = b17[0];
                    int i48 = b17[1];
                    if (i47 == -1009) {
                        i16 = i47;
                        str3 = "";
                    } else {
                        int i49 = i48 + 2;
                        if (i49 <= bArr5.length) {
                            cVar.f422822b = util.buf_to_int16(bArr5, i48);
                            int i56 = i49 + 2;
                            if (i56 <= bArr5.length && (buf_to_int164 = i56 + (buf_to_int163 = util.buf_to_int16(bArr5, i49))) <= bArr5.length) {
                                byte[] bArr6 = new byte[buf_to_int163];
                                System.arraycopy(bArr5, i56, bArr6, 0, buf_to_int163);
                                if (cVar.f422822b == 0) {
                                    byte[] bArr7 = cVar.f422826f;
                                    byte[] decrypt = cryptor.decrypt(bArr6, 0, buf_to_int163, (bArr7 == null || bArr7.length <= 0) ? "e75734d01ad9b57f".getBytes() : MD5.toMD5Byte(bArr7));
                                    if (decrypt != null && 1 <= decrypt.length && (buf_to_int85 = util.buf_to_int8(decrypt, 0) + 1) <= decrypt.length && (i17 = buf_to_int85 + 8) <= decrypt.length) {
                                        cVar.f422837q = util.buf_to_int64(decrypt, buf_to_int85);
                                        int i57 = i17 + 2;
                                        if (i57 <= decrypt.length && (buf_to_int166 = i57 + (buf_to_int165 = util.buf_to_int16(decrypt, i17))) <= decrypt.length) {
                                            byte[] bArr8 = new byte[buf_to_int165];
                                            cVar.f422838r = bArr8;
                                            System.arraycopy(decrypt, i57, bArr8, 0, buf_to_int165);
                                            int i58 = buf_to_int166 + 2;
                                            if (i58 <= decrypt.length) {
                                                i47 = oicq.wlogin_sdk.contextpersist.a.a(util.buf_to_int16(decrypt, buf_to_int166), decrypt, i58, decrypt.length - i58, cVar.f422840t);
                                                if (i47 != 0) {
                                                    str3 = "";
                                                    util.LOGI("parse tlv failed " + i47, str3);
                                                    i16 = -1009;
                                                } else {
                                                    str3 = "";
                                                    tlv_t tlv_tVar = cVar.f422840t.get(new Integer(7));
                                                    if (tlv_tVar != null) {
                                                        cVar.f422839s = tlv_tVar.get_data();
                                                    }
                                                    tlv_t tlv_tVar2 = cVar.f422840t.get(new Integer(12));
                                                    if (tlv_tVar2 != null) {
                                                        oicq.wlogin_sdk.register.c.f422819v = util.buf_to_int64(tlv_tVar2.get_data(), 0);
                                                    }
                                                }
                                            }
                                        }
                                        str3 = "";
                                        i16 = -1009;
                                    }
                                } else {
                                    str3 = "";
                                }
                                int i59 = buf_to_int164 + 1;
                                if (i59 <= bArr5.length && (buf_to_int84 = i59 + (buf_to_int83 = util.buf_to_int8(bArr5, buf_to_int164))) <= bArr5.length) {
                                    byte[] bArr9 = new byte[buf_to_int83];
                                    cVar.f422823c = bArr9;
                                    System.arraycopy(bArr5, i59, bArr9, 0, buf_to_int83);
                                    int i65 = buf_to_int84 + 2;
                                    if (i65 <= bArr5.length) {
                                        int buf_to_int169 = util.buf_to_int16(bArr5, buf_to_int84);
                                        if (i65 + buf_to_int169 <= bArr5.length) {
                                            byte[] bArr10 = new byte[buf_to_int169];
                                            cVar.f422824d = bArr10;
                                            System.arraycopy(bArr5, i65, bArr10, 0, buf_to_int169);
                                            i16 = i47;
                                        }
                                    }
                                }
                                i16 = -1009;
                            }
                        }
                        str3 = "";
                        i16 = -1009;
                    }
                    if (i16 != 0) {
                        oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_REGISTER_PHONE, "sub_event_0x6", String.valueOf(i16)), 100);
                        WtloginListener wtloginListener14 = this.mListener;
                        if (wtloginListener14 != null) {
                            wtloginListener14.OnRegError(wUserSigInfo, i16, a16.getBytes());
                            return;
                        }
                        return;
                    }
                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_REGISTER_PHONE, "sub_event_0x6", String.valueOf(cVar.f422822b)), 100);
                    wUserSigInfo.regTLVMap = cVar.f422840t;
                    cVar.f422840t = new HashMap<>();
                    util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + cVar.f422822b, str3);
                    if (this.mListener != null) {
                        String str5 = cVar.f422821a;
                        if (str5 != null && str5.indexOf("-") > 0) {
                            int indexOf = cVar.f422821a.indexOf("-");
                            String substring = cVar.f422821a.substring(0, indexOf);
                            if (substring.equals("86")) {
                                str4 = cVar.f422821a.substring(indexOf + 1);
                            } else {
                                str4 = "00" + substring + cVar.f422821a.substring(indexOf + 1);
                            }
                            cVar.f422821a = str4;
                        }
                        String str6 = cVar.f422821a;
                        if (str6 != null && str6.length() != 0) {
                            this.mG.a(cVar.f422821a);
                            this.mG.a(cVar.f422821a, Long.valueOf(cVar.f422837q));
                        }
                        util.LOGI("reg userAccount: " + cVar.f422821a, cVar.f422837q + str3);
                        if (oicq.wlogin_sdk.register.c.f422820w.length() <= 0 || !oicq.wlogin_sdk.register.c.f422818u) {
                            this.mListener.OnRegGetAccount(wUserSigInfo, cVar.f422822b, cVar.f422837q, cVar.f422838r, cVar.f422839s, cVar.f422824d);
                            return;
                        } else {
                            this.mListener.OnRegGetSMSVerifyLoginAccount(wUserSigInfo, cVar.f422822b, cVar.f422837q, cVar.f422838r, cVar.f422839s, cVar.f422824d);
                            return;
                        }
                    }
                    return;
                }
                if (i19 != 7) {
                    switch (i19) {
                        case 16:
                            byte[] bArr11 = transReqContext.get_body();
                            int[] b18 = oicq.wlogin_sdk.register.a.b(bArr11);
                            int i66 = b18[0];
                            int i67 = b18[1];
                            if (i66 == -1009) {
                                i26 = i66;
                            } else {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr11, i67, bArr11.length - i67);
                                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                                try {
                                    dataInputStream.readByte();
                                    cVar.f422822b = dataInputStream.readShort();
                                    readShort = dataInputStream.readShort();
                                } catch (Exception e16) {
                                    util.LOGI("parse0x10Rsp failed " + e16.getMessage(), "");
                                }
                                if (readShort != 0) {
                                    byte[] bArr12 = new byte[readShort];
                                    dataInputStream.read(bArr12);
                                    byte[] decrypt2 = cryptor.decrypt(bArr12, 0, readShort, cVar.f422827g);
                                    if (decrypt2 == null) {
                                        util.LOGI("no tlv in rsp", "");
                                        i26 = -1;
                                    } else {
                                        int a19 = oicq.wlogin_sdk.contextpersist.a.a(util.buf_to_int16(decrypt2, 0), decrypt2, 2, decrypt2.length - 2, cVar.f422840t);
                                        if (a19 != 0) {
                                            util.LOGI("parser tlv failed " + a19, "");
                                            i26 = -1009;
                                        }
                                    }
                                }
                                byte[] bArr13 = new byte[dataInputStream.readByte()];
                                cVar.f422823c = bArr13;
                                dataInputStream.read(bArr13);
                                int readShort3 = dataInputStream.readShort();
                                if (readShort3 != 0) {
                                    byte[] bArr14 = new byte[readShort3];
                                    cVar.f422824d = bArr14;
                                    if (dataInputStream.read(bArr14) != readShort3) {
                                        throw new Exception("msg len " + readShort3 + " error");
                                    }
                                }
                                dataInputStream.close();
                                byteArrayInputStream.close();
                            }
                            if (i26 != 0 && (wtloginListener3 = this.mListener) != null) {
                                wtloginListener3.OnRegError(wUserSigInfo, i26, a16.getBytes());
                            }
                            util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + cVar.f422822b, "");
                            this.mListener.OnQuickRegisterCheckAccount(wUserSigInfo, cVar.f422822b, cVar.f422824d);
                            return;
                        case 17:
                            byte[] bArr15 = transReqContext.get_body();
                            int[] b19 = oicq.wlogin_sdk.register.a.b(bArr15);
                            int i68 = b19[0];
                            int i69 = b19[1];
                            if (i68 == -1009) {
                                i26 = i68;
                            } else {
                                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr15, i69, bArr15.length - i69);
                                DataInputStream dataInputStream2 = new DataInputStream(byteArrayInputStream2);
                                try {
                                    dataInputStream2.readByte();
                                    cVar.f422822b = dataInputStream2.readShort();
                                    readShort2 = dataInputStream2.readShort();
                                } catch (Exception e17) {
                                    util.LOGI("parse0x11Rsp failed " + e17.getMessage(), "");
                                }
                                if (readShort2 != 0) {
                                    byte[] bArr16 = new byte[readShort2];
                                    dataInputStream2.read(bArr16);
                                    byte[] decrypt3 = cryptor.decrypt(bArr16, 0, readShort2, cVar.f422827g);
                                    if (decrypt3 == null) {
                                        util.LOGI("no tlv in rsp", "");
                                        i26 = -1;
                                    } else {
                                        int a26 = oicq.wlogin_sdk.contextpersist.a.a(util.buf_to_int16(decrypt3, 0), decrypt3, 2, decrypt3.length - 2, cVar.f422840t);
                                        if (a26 != 0) {
                                            util.LOGI("parser tlv failed " + a26, "");
                                            i26 = -1009;
                                        }
                                    }
                                }
                                byte[] bArr17 = new byte[dataInputStream2.readByte()];
                                cVar.f422823c = bArr17;
                                dataInputStream2.read(bArr17);
                                int readShort4 = dataInputStream2.readShort();
                                if (readShort4 != 0) {
                                    byte[] bArr18 = new byte[readShort4];
                                    cVar.f422824d = bArr18;
                                    if (dataInputStream2.read(bArr18) != readShort4) {
                                        throw new Exception("msg len " + readShort4 + " error");
                                    }
                                }
                                dataInputStream2.close();
                                byteArrayInputStream2.close();
                            }
                            if (i26 != 0 && (wtloginListener4 = this.mListener) != null) {
                                wtloginListener4.OnRegError(wUserSigInfo, i26, a16.getBytes());
                            }
                            util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + cVar.f422822b, "");
                            wUserSigInfo.regTLVMap = cVar.f422840t;
                            cVar.f422840t = new HashMap<>();
                            this.mListener.OnQuickRegisterGetAccount(wUserSigInfo, cVar.f422822b, cVar.f422824d);
                            return;
                        case 18:
                        case 19:
                            byte[] bArr19 = transReqContext.get_body();
                            int[] b26 = oicq.wlogin_sdk.register.a.b(bArr19);
                            int i75 = b26[0];
                            int i76 = b26[1];
                            if (i75 == -1009) {
                                bArr = null;
                            } else {
                                byte[] bArr20 = new byte[(bArr19.length - i76) - 1];
                                System.arraycopy(bArr19, i76, bArr20, 0, (bArr19.length - i76) - 1);
                                bArr = bArr20;
                            }
                            this.mListener.onNTRegisterResult(wUserSigInfo, transReqContext.get_subcmd(), bArr);
                            break;
                        default:
                            util.LOGW("OnRequestRegister unhandle cmd:" + transReqContext.get_subcmd(), "", str);
                            WtloginListener wtloginListener15 = this.mListener;
                            if (wtloginListener15 != null) {
                                wtloginListener15.OnRegError(wUserSigInfo, -1010, a16.getBytes());
                                return;
                            }
                            return;
                    }
                } else {
                    byte[] bArr21 = transReqContext.get_body();
                    int[] b27 = oicq.wlogin_sdk.register.a.b(bArr21);
                    int i77 = b27[0];
                    int i78 = b27[1];
                    if (i77 != -1009) {
                        int i79 = i78 + 2;
                        if (i79 <= bArr21.length) {
                            cVar.f422822b = util.buf_to_int16(bArr21, i78);
                            int i85 = i79 + 2;
                            if (i85 <= bArr21.length && (buf_to_int168 = i85 + (buf_to_int167 = util.buf_to_int16(bArr21, i79))) <= bArr21.length) {
                                byte[] bArr22 = new byte[buf_to_int167];
                                cVar.f422824d = bArr22;
                                System.arraycopy(bArr21, i85, bArr22, 0, buf_to_int167);
                                int i86 = buf_to_int168 + 2;
                                if (i86 <= bArr21.length) {
                                    int buf_to_int1610 = util.buf_to_int16(bArr21, buf_to_int168);
                                    if (i86 + buf_to_int1610 <= bArr21.length) {
                                        if (buf_to_int1610 > 0) {
                                            byte[] bArr23 = new byte[buf_to_int1610 + 2];
                                            System.arraycopy(bArr21, i86, bArr23, 1, buf_to_int1610);
                                            bArr23[0] = 40;
                                            bArr23[buf_to_int1610 + 1] = 41;
                                            cVar.f422824d = new String(cVar.f422824d).replace("\u3002", new String(bArr23) + "\u3002").getBytes();
                                        }
                                    }
                                }
                            }
                        }
                        i18 = -1009;
                        if (i18 == 0) {
                            WtloginListener wtloginListener16 = this.mListener;
                            if (wtloginListener16 != null) {
                                wtloginListener16.OnRegError(wUserSigInfo, i18, a16.getBytes());
                                return;
                            }
                            return;
                        }
                        util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + cVar.f422822b, "");
                        WtloginListener wtloginListener17 = this.mListener;
                        if (wtloginListener17 != null) {
                            wtloginListener17.OnRegQueryAccount(wUserSigInfo, cVar.f422822b, cVar.f422824d);
                            return;
                        }
                        return;
                    }
                    i18 = i77;
                    if (i18 == 0) {
                    }
                }
            }
            util.LOGI("reg cmd:" + transReqContext.get_subcmd());
            this.mListener.onModifyQIMPassword(wUserSigInfo, transReqContext.get_subcmd(), transReqContext.get_body());
            return;
        }
        int a27 = oicq.wlogin_sdk.register.a.a(transReqContext.get_subcmd(), transReqContext.get_body(), cVar);
        if (a27 != 0) {
            oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_REGISTER_PHONE, "sub_event_0xA", String.valueOf(a27)), 100);
            WtloginListener wtloginListener18 = this.mListener;
            if (wtloginListener18 != null) {
                wtloginListener18.OnRegError(wUserSigInfo, a27, a16.getBytes());
                return;
            }
            return;
        }
        oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_REGISTER_PHONE, "sub_event_0xA", String.valueOf(cVar.f422822b)), 100);
        util.LOGI("reg cmd:" + transReqContext.get_subcmd() + " ret:" + cVar.f422822b, "");
        wUserSigInfo.regTLVMap = cVar.f422840t;
        cVar.f422840t = new HashMap<>();
        if (getRegTlvValue(wUserSigInfo, 51) != null && this.mListener != null) {
            util.LOGI("reg_request_submit_mobileExt : bind phone over limit", "");
            this.mListener.OnRegError(wUserSigInfo, 61, cVar.f422824d);
            return;
        }
        int i87 = cVar.f422822b;
        if (i87 == 0) {
            WtloginListener wtloginListener19 = this.mListener;
            if (wtloginListener19 != null) {
                wtloginListener19.OnRegCheckDownloadMsg(wUserSigInfo, cVar.f422828h, cVar.f422829i);
                return;
            }
            return;
        }
        if (i87 != 2) {
            if (i87 == 3) {
                WtloginListener wtloginListener20 = this.mListener;
                if (wtloginListener20 != null) {
                    wtloginListener20.OnRegCheckValidUrl(wUserSigInfo, cVar.f422833m);
                    return;
                }
                return;
            }
            if (i87 == 6 || i87 == 44) {
                WtloginListener wtloginListener21 = this.mListener;
                if (wtloginListener21 != null) {
                    wtloginListener21.OnRegCheckWebSig(wUserSigInfo, new String(cVar.f422833m), new String(cVar.f422824d));
                }
                cVar.f422833m = new byte[0];
                return;
            }
            if (i87 == 51) {
                WtloginListener wtloginListener22 = this.mListener;
                if (wtloginListener22 != null) {
                    wtloginListener22.OnGuaranteeCheckValidUrl(wUserSigInfo, cVar.f422833m);
                    return;
                }
                return;
            }
            if (i87 == 58) {
                WtloginListener wtloginListener23 = this.mListener;
                if (wtloginListener23 != null) {
                    wtloginListener23.OnRegCheckIframe(wUserSigInfo, cVar.f422833m, null);
                    return;
                }
                return;
            }
            if (i87 != 59) {
                util.LOGW("OnRequestRegister 0xa return code:", String.valueOf(i87), str);
                WtloginListener wtloginListener24 = this.mListener;
                if (wtloginListener24 != null) {
                    wtloginListener24.OnRegError(wUserSigInfo, cVar.f422822b, cVar.f422824d);
                    return;
                }
                return;
            }
            util.LOGW("OnRegCheckError REG_CHECK_ERROR_FACE regSig= " + util.printByte(cVar.f422834n), "");
            WtloginListener wtloginListener25 = this.mListener;
            if (wtloginListener25 != null) {
                wtloginListener25.OnRegError(wUserSigInfo, 59, cVar.f422834n);
                return;
            }
            return;
        }
        wtloginListener = this.mListener;
        if (wtloginListener == null) {
            return;
        } else {
            str2 = new String(cVar.f422832l);
        }
        wtloginListener.OnRegCheckUploadMsg(wUserSigInfo, str2);
    }

    private void RequestInit() {
        synchronized (this) {
            u.h();
            ShareKeyInit();
            AsyncGenRSAKey();
            FEKit.getInstance().loadSoAsync();
            try {
                String f16 = u.f();
                if (!TextUtils.isEmpty(f16) && f16.endsWith(":MSF")) {
                    c.b.f422998a.f422997a = this.mG;
                    new BaseThread(new c.a(), "PubKeyRotater").start();
                }
            } catch (Throwable th5) {
                util.printThrowable(th5, "RequestInit");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int RequestReport(int i3, byte[] bArr, byte[] bArr2, long j3, long j16) {
        int i16;
        byte[] bArr3;
        byte[] compress;
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, bArr, bArr2, j3, j16, "RequestReport").RunReq(7);
            return -1001;
        }
        u a16 = this.mG.a(0L);
        a16.f422957d = j3;
        util.LOGI("user:" + j3 + " appid:" + j16 + " Seq:" + a16.f422959f + " RequestReport...", "" + j3);
        d0 d0Var = new d0(a16);
        WUserSigInfo wUserSigInfo = new WUserSigInfo();
        synchronized (d0Var) {
            d0Var.f422916l = util.CMD_LOG_REPORT;
            int i17 = u.f422953z;
            long currentTimeMillis = (System.currentTimeMillis() / 1000) + u.f422926c0;
            u.f422936m0.commit(Build.VERSION.RELEASE, new String(u.I), "", util.buf_to_string(util.get_ksid(u.f422949w)), new String(u.G), new String(u.P), new String(oicq.wlogin_sdk.utils.b.b(u.f422949w)), new String(u.J), util.get_release_time(), util.SDK_VERSION);
            i16 = 0;
            try {
                bArr3 = u.f422936m0.toJasonObj().toString().getBytes();
            } catch (Throwable unused) {
                bArr3 = new byte[0];
            }
            if (bArr3 != null && bArr3.length != 0 && (compress = util.compress(bArr3)) != null && compress.length != 0) {
                int length = compress.length + 8;
                byte[] bArr4 = new byte[length];
                util.int64_to_buf32(bArr4, 0, currentTimeMillis);
                util.int8_to_buf(bArr4, 4, 0);
                util.int8_to_buf(bArr4, 5, 1);
                util.int16_to_buf(bArr4, 6, compress.length);
                System.arraycopy(compress, 0, bArr4, 8, compress.length);
                byte[] encrypt = cryptor.encrypt(bArr4, 0, length, bArr2);
                if (encrypt != null && encrypt.length != 0) {
                    report_t.delete_file(u.f422949w);
                    d0Var.a(8001, d0Var.f422914j, d0Var.f422910f, j3, 0, 2, i17, 0, d0Var.a(encrypt, bArr, j16, 85L, 0));
                    int a17 = d0Var.a(String.valueOf(j3), true, wUserSigInfo);
                    if (a17 == 0) {
                        a17 = d0Var.d();
                    }
                    i16 = a17;
                    if (i16 != 0) {
                        report_t.write_tofile(u.f422936m0, u.f422949w);
                    } else {
                        u.f422936m0.clear_t2();
                    }
                }
            }
        }
        a16.c();
        util.LOGI("user:" + j3 + " appid:" + j16 + " Seq:" + a16.f422959f + " RequestReport ret=" + i16, "" + j3);
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int RequestReportError(int i3, byte[] bArr, byte[] bArr2, long j3, long j16, int i16) {
        String str;
        String str2;
        String str3;
        String str4;
        int i17;
        int i18;
        long j17;
        byte b16;
        int i19;
        Calendar calendar;
        int i26;
        SimpleDateFormat simpleDateFormat;
        String str5;
        y yVar;
        byte[] a16;
        y yVar2;
        byte[] bArr3;
        byte[] compress;
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, bArr, bArr2, j3, j16, i16, "RequestReportError").RunReq(8);
            return -1001;
        }
        long j18 = 0;
        u a17 = this.mG.a(0L);
        a17.f422956c = this.mG.f422956c;
        a17.f422957d = j3;
        util.LOGI("user:" + j3 + " appid:" + j16 + " Seq:" + a17.f422959f + " RequestReportError...", "" + j3);
        y yVar3 = new y(a17);
        if (i16 != 0) {
            str = "user:";
            str2 = "";
            y yVar4 = yVar3;
            str3 = " appid:";
            str4 = " Seq:";
            if (i16 == 1) {
                if (yVar4.f422895a.f422956c != null && !u.f422945u.booleanValue()) {
                    u.f422945u = Boolean.TRUE;
                    long currentTimeMillis = System.currentTimeMillis();
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);
                    Calendar calendar2 = Calendar.getInstance();
                    int i27 = yVar4.f422895a.f422956c.get_bitmap();
                    byte b17 = yVar4.f422895a.f422956c.get_network();
                    util.LOGI("bitmap:" + i27 + " network:" + ((int) b17) + " local network:" + util.get_network_type(u.f422949w));
                    int i28 = 0;
                    while (i28 < 32) {
                        if (((1 << i28) & i27) == 0) {
                            b16 = b17;
                            i19 = i28;
                            calendar = calendar2;
                            i26 = i27;
                            j17 = j18;
                            yVar2 = yVar4;
                            simpleDateFormat = simpleDateFormat2;
                        } else {
                            if (b17 != 0) {
                                if (b17 == 1) {
                                    if (util.get_network_type(u.f422949w) != 2) {
                                        b16 = b17;
                                        i19 = i28;
                                        calendar = calendar2;
                                        i26 = i27;
                                        yVar2 = yVar4;
                                        simpleDateFormat = simpleDateFormat2;
                                        j17 = 0;
                                        i28 = i19 + 1;
                                        simpleDateFormat2 = simpleDateFormat;
                                        yVar4 = yVar2;
                                        j18 = j17;
                                        b17 = b16;
                                        calendar2 = calendar;
                                        i27 = i26;
                                    }
                                } else {
                                    b16 = b17;
                                    i19 = i28;
                                    calendar = calendar2;
                                    i26 = i27;
                                    yVar2 = yVar4;
                                    simpleDateFormat = simpleDateFormat2;
                                    j17 = 0;
                                }
                            }
                            long j19 = currentTimeMillis - (86400000 * i28);
                            calendar2.setTimeInMillis(j19);
                            String format = simpleDateFormat2.format(calendar2.getTime());
                            long logModifyTime = util.getLogModifyTime(u.f422949w, format);
                            j17 = 0;
                            if (logModifyTime == 0) {
                                logModifyTime = j19;
                            }
                            byte[] readLog = util.readLog(u.f422949w, format);
                            if (readLog == null) {
                                b16 = b17;
                                i19 = i28;
                                calendar = calendar2;
                                i26 = i27;
                                yVar = yVar4;
                                simpleDateFormat = simpleDateFormat2;
                                a16 = new byte[0];
                                str5 = format;
                            } else {
                                b16 = b17;
                                i19 = i28;
                                calendar = calendar2;
                                i26 = i27;
                                simpleDateFormat = simpleDateFormat2;
                                str5 = format;
                                yVar = yVar4;
                                a16 = yVar4.a(readLog, j3, j16, logModifyTime, 1);
                            }
                            if (a16.length > 0) {
                                yVar2 = yVar;
                                util.LOGI("request_report_error(1) rsp: ret=" + yVar2.b(yVar2.a(yVar.a(j3, a16, bArr, bArr2, j16))) + "(" + str5 + ")");
                            } else {
                                yVar2 = yVar;
                            }
                            i28 = i19 + 1;
                            simpleDateFormat2 = simpleDateFormat;
                            yVar4 = yVar2;
                            j18 = j17;
                            b17 = b16;
                            calendar2 = calendar;
                            i27 = i26;
                        }
                        i28 = i19 + 1;
                        simpleDateFormat2 = simpleDateFormat;
                        yVar4 = yVar2;
                        j18 = j17;
                        b17 = b16;
                        calendar2 = calendar;
                        i27 = i26;
                    }
                }
                i17 = 0;
                yVar4.f422895a.f422956c = null;
                u.f422945u = Boolean.FALSE;
            } else {
                i17 = 0;
            }
            i18 = i17;
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            u.f422936m0.commit(Build.VERSION.RELEASE, new String(u.I), "", util.buf_to_string(util.get_ksid(u.f422949w)), new String(u.G), new String(u.P), new String(oicq.wlogin_sdk.utils.b.b(u.f422949w)), new String(u.J), util.get_release_time(), util.SDK_VERSION);
            try {
                bArr3 = u.f422936m0.toJasonObj().toString().getBytes();
            } catch (Throwable unused) {
                bArr3 = new byte[0];
            }
            if (bArr3 == null || bArr3.length == 0 || (compress = util.compress(bArr3)) == null || compress.length == 0) {
                str = "user:";
                str4 = " Seq:";
                str2 = "";
                str3 = " appid:";
                i18 = 0;
            } else {
                byte[] bArr4 = new byte[compress.length + 4];
                util.int8_to_buf(bArr4, 0, 0);
                util.int8_to_buf(bArr4, 1, 1);
                util.int16_to_buf(bArr4, 2, compress.length);
                System.arraycopy(compress, 0, bArr4, 4, compress.length);
                str2 = "";
                str4 = " Seq:";
                str3 = " appid:";
                str = "user:";
                byte[] a18 = yVar3.a(bArr4, j3, j16, currentTimeMillis2, 0);
                report_t.delete_file(u.f422949w);
                i18 = yVar3.b(yVar3.a(yVar3.a(j3, a18, bArr, bArr2, j16)));
                util.LOGI("request_report_error(0) rsp: ret=" + i18);
                Reporter reporter = u.f422936m0;
                if (i18 != 0) {
                    report_t.write_tofile(reporter, u.f422949w);
                } else {
                    reporter.clear_t2();
                }
            }
        }
        util.LOGI(str + j3 + str3 + j16 + str4 + a17.f422959f + " RequestReportError ret=" + i18, str2 + j3);
        return i18;
    }

    public static void SetWatchQQLicense(WUserSigInfo wUserSigInfo, byte[] bArr) {
        setExtraProductLoginTlvValue(wUserSigInfo, gdt_analysis_event.EVENT_FEEDBACK_CLICK, bArr);
        setExtraRegTlvValue(wUserSigInfo, 38, bArr);
    }

    private int ShareKeyInit() {
        int initShareKey;
        util.LOGI("start ShareKeyInit", "");
        EcdhCrypt ecdhCrypt = new EcdhCrypt(this.mContext);
        if (this.isForLocal) {
            return ecdhCrypt.initShareKeyByDefault();
        }
        try {
            Pair<String, Integer> c16 = c.b.f422998a.c();
            if (c16 != null) {
                ecdhCrypt.setPubKey((String) c16.first, ((Integer) c16.second).intValue());
            }
        } catch (Throwable th5) {
            util.printThrowable(th5, "ShareKeyInit");
        }
        int initKeyTime = util.getInitKeyTime(this.mContext);
        if (initKeyTime > 3) {
            initShareKey = ecdhCrypt.initShareKeyByDefault();
        } else {
            util.saveInitKeyTime(this.mContext, initKeyTime + 1);
            initShareKey = ecdhCrypt.initShareKey();
            if (initShareKey == 0) {
                util.saveInitKeyTime(this.mContext, 0);
            }
        }
        util.LOGI("end ShareKeyInit", "");
        this.mG.f422965l = ecdhCrypt.get_c_pub_key();
        this.mG.f422966m = ecdhCrypt.get_g_share_key();
        this.mG.f422967n = ecdhCrypt.get_pub_key_ver();
        return initShareKey;
    }

    private boolean checkNTSigFlag(Context context, long j3, int i3, byte[] bArr) {
        String buf_to_string = util.buf_to_string(bArr, 4);
        Map<String, String> map = oicq.wlogin_sdk.persistence.a.f422781a;
        String decodeString = QMMKV.from(context, QMMKVFile.FILE_WTLOGIN).decodeString(NT_FLAG_PREFIX + j3 + "_" + i3, "");
        util.LOGI("checkNTSigFlag flag = " + buf_to_string + ",oldFlag = " + decodeString, "");
        return TextUtils.equals(buf_to_string, decodeString);
    }

    public static void customizeLogDir(String str) {
        u.f422941r0 = str;
        util.LOGI("set log dir " + str, "");
    }

    private byte[] generateA1(long j3, long j16, long j17, String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        try {
            bArr2 = (byte[]) str.getBytes("ISO-8859-1").clone();
        } catch (UnsupportedEncodingException e16) {
            util.printException(e16, "");
        }
        byte[] bArr3 = new byte[98];
        util.int16_to_buf(bArr3, 0, 4);
        util.int32_to_buf(bArr3, 2, util.get_rand_32());
        util.int32_to_buf(bArr3, 6, 22);
        util.int32_to_buf(bArr3, 10, (int) j3);
        util.int32_to_buf(bArr3, 14, u.f422953z);
        util.int64_to_buf(bArr3, 18, j17);
        byte[] bArr4 = new byte[4];
        util.int64_to_buf32(bArr4, 0, (System.currentTimeMillis() / 1000) + u.f422926c0);
        System.arraycopy(bArr4, 0, bArr3, 26, 4);
        byte[] bArr5 = u.f422927d0;
        System.arraycopy(bArr5, 0, bArr3, 30, bArr5.length);
        int length = u.f422927d0.length + 30;
        util.int8_to_buf(bArr3, length, 1);
        int i3 = length + 1;
        System.arraycopy(bArr2, 0, bArr3, i3, bArr2.length);
        int length2 = i3 + bArr2.length;
        System.arraycopy(bArr, 0, bArr3, length2, bArr.length);
        int length3 = length2 + bArr.length;
        util.int32_to_buf(bArr3, length3, 0);
        int i16 = length3 + 4;
        util.int8_to_buf(bArr3, i16, u.T);
        int i17 = i16 + 1;
        byte[] bArr6 = u.D;
        System.arraycopy(bArr6, 0, bArr3, i17, bArr6.length);
        int length4 = i17 + u.D.length;
        util.int64_to_buf32(bArr3, length4, j16);
        int i18 = length4 + 4;
        util.int32_to_buf(bArr3, i18, 1);
        int i19 = i18 + 4;
        util.int16_to_buf(bArr3, i19, 0);
        System.arraycopy(new byte[0], 0, bArr3, i19 + 2, 0);
        byte[] bArr7 = new byte[24];
        System.arraycopy(bArr2, 0, bArr7, 0, bArr2.length);
        util.int64_to_buf(bArr7, 16, j17);
        return cryptor.encrypt(bArr3, 0, 98, MD5.toMD5Byte(bArr7));
    }

    private A1AndNopicSig getA1AndNopicSigByAccount(String str, long j3) {
        String str2;
        A1AndNopicSig a1AndNopicSig = new A1AndNopicSig();
        StringBuffer stringBuffer = new StringBuffer("getA1AndNopicSigByAccount,userAccount=");
        stringBuffer.append(str);
        WloginSigInfo sigInfo = getSigInfo(str, j3);
        if (sigInfo != null) {
            byte[] bArr = sigInfo._en_A1;
            if (bArr != null && bArr.length > 0) {
                a1AndNopicSig.f422867a1 = (byte[]) bArr.clone();
                stringBuffer.append(",a1=");
                stringBuffer.append(a1AndNopicSig.f422867a1.length);
            } else {
                stringBuffer.append(",a1=null");
            }
            byte[] bArr2 = sigInfo._noPicSig;
            if (bArr2 != null && bArr2.length > 0) {
                a1AndNopicSig.noPicSig = (byte[]) bArr2.clone();
                stringBuffer.append(",noPicSig=");
                stringBuffer.append(a1AndNopicSig.noPicSig.length);
                util.LOGI(stringBuffer.toString(), "");
                return a1AndNopicSig;
            }
            str2 = ",noPicSig=null";
        } else {
            str2 = ",info == null";
        }
        stringBuffer.append(str2);
        util.LOGI(stringBuffer.toString(), "");
        return a1AndNopicSig;
    }

    public static byte[] getLoginResultData(WUserSigInfo wUserSigInfo, int i3) {
        tlv_t tlv_tVar = wUserSigInfo.loginResultTLVMap.get(new Integer(i3));
        if (tlv_tVar != null) {
            return tlv_tVar.get_data();
        }
        return null;
    }

    public static String getLoginResultField(WUserSigInfo wUserSigInfo) {
        tlv_t tlv_tVar = wUserSigInfo.loginResultTLVMap.get(new Integer(gdt_analysis_event.EVENT_QUERY_URL_BY_CGI_FAILED));
        if (tlv_tVar != null) {
            String str = new String(tlv_tVar.get_data());
            util.LOGI("getLoginResultField get str " + str, wUserSigInfo.uin);
            return str;
        }
        util.LOGI("getLoginResultField get null", wUserSigInfo.uin);
        return "";
    }

    public static String getLoginResultField_S(WUserSigInfo wUserSigInfo) {
        tlv_t tlv_tVar = wUserSigInfo.loginResultTLVMap.get(new Integer(1328));
        if (tlv_tVar != null) {
            String str = new String(tlv_tVar.get_data());
            util.LOGI("getLoginResultField2 get str " + str, wUserSigInfo.uin);
            return str;
        }
        util.LOGI("getLoginResultField2 get null", wUserSigInfo.uin);
        return "";
    }

    public static byte[] getLoginTlvValue(WUserSigInfo wUserSigInfo, int i3) {
        tlv_t tlv_tVar = wUserSigInfo.loginTLVMap.get(new Integer(i3));
        if (tlv_tVar != null) {
            return tlv_tVar.get_data();
        }
        return null;
    }

    public static byte[] getRegTlvValue(WUserSigInfo wUserSigInfo, int i3) {
        tlv_t tlv_tVar = wUserSigInfo.regTLVMap.get(new Integer(i3));
        if (tlv_tVar != null) {
            return tlv_tVar.get_data();
        }
        return null;
    }

    private WloginSigInfo getSigInfo(String str, long j3) {
        long parseLong;
        if (str == null) {
            return null;
        }
        if (!util.check_uin_account(str).booleanValue()) {
            parseLong = this.mG.b(str);
            if (parseLong == 0) {
                return null;
            }
        } else {
            parseLong = Long.parseLong(str);
        }
        return this.mG.d(parseLong, j3);
    }

    private int getStWithPtSig(String str, String str2, QuickLoginParam quickLoginParam) {
        return getStWithPtSig(str, str2, quickLoginParam, 0);
    }

    private int getStWithQQSig(String str, QuickLoginParam quickLoginParam) {
        return getStWithQQSig(str, quickLoginParam, 0);
    }

    private int getTicketByGateway(long j3, long j16, int i3, WUserSigInfo wUserSigInfo, StringBuilder sb5, u uVar, async_context async_contextVar) {
        async_context async_contextVar2;
        u uVar2;
        tlv_t150 tlv_t150Var;
        async_contextVar._tmp_pwd = MD5.toMD5Byte(async_contextVar._mpasswd.getBytes());
        j jVar = new j(uVar, this.mContext);
        jVar.f422919o = true;
        int a16 = jVar.a(j3, j16, uVar.f422957d, 0, u.f422927d0, util.getRequestInitTime(), async_contextVar._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, (long[]) null, i3, j16, u.B, 0, 0, 1, u.f422924a0, wUserSigInfo);
        sb5.append(",retPasswd =");
        sb5.append(a16);
        if (a16 == 204) {
            a16 = new p(uVar).a(this.mMiscBitmap, this.mSubSigMap, (long[]) null, wUserSigInfo);
            sb5.append("\uff0cdevlock = ");
            sb5.append(a16);
        }
        if (a16 != 0) {
            sb5.append(",fail");
            util.LOGI(sb5.toString(), "");
            return -2005;
        }
        WloginSigInfo d16 = uVar.d(uVar.f422957d, j3);
        if (d16 == null) {
            sb5.append(",info == null");
            util.LOGI(sb5.toString(), "");
            return -1004;
        }
        wUserSigInfo.get_clone(d16);
        Ticket GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (GetUserSigInfoTicket == null) {
            GetUserSigInfoTicket = new Ticket();
        }
        Ticket ticket = GetUserSigInfoTicket;
        u.f422936m0.commit_t2(uVar.f422957d, uVar.f422958e, util.format_ret_code(a16), a16);
        if (a16 == 0) {
            byte[] bArr = ticket._sig;
            if (bArr != null && bArr.length != 0) {
                async_contextVar2 = async_contextVar;
                RequestReport(0, bArr, ticket._sig_key, uVar.f422957d, async_contextVar._appid);
            } else {
                async_contextVar2 = async_contextVar;
            }
        } else {
            async_contextVar2 = async_contextVar;
            if (a16 != 2 && a16 != 160) {
                uVar2 = uVar;
                RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, async_contextVar2._appid, 0);
                tlv_t150Var = uVar2.f422956c;
                if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                    this.mG.f422956c = uVar2.f422956c;
                    RequestReportError(0, ticket._sig, ticket._sig_key, uVar2.f422957d, async_contextVar2._appid, 1);
                }
                oicq.wlogin_sdk.report.b.a();
                u.a();
                uVar.b();
                return 0;
            }
        }
        uVar2 = uVar;
        tlv_t150Var = uVar2.f422956c;
        if (tlv_t150Var != null) {
            this.mG.f422956c = uVar2.f422956c;
            RequestReportError(0, ticket._sig, ticket._sig_key, uVar2.f422957d, async_contextVar2._appid, 1);
        }
        oicq.wlogin_sdk.report.b.a();
        u.a();
        uVar.b();
        return 0;
    }

    public static IWtDataSender getWtDataSender() {
        return mWtDataSender;
    }

    private Handler initHelperHandler() {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return null;
            }
            return new Handler();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isGateWay(WUserSigInfo wUserSigInfo) {
        boolean z16;
        if (wUserSigInfo.businessType == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        util.LOGI("quickLoginByGateway isGateWay = " + z16);
        return z16;
    }

    private int isPskeyExpired(int i3, String[] strArr, Ticket ticket, long j3, int i16) {
        boolean z16;
        boolean z17;
        String str;
        String str2;
        String str3;
        boolean z18;
        String str4;
        int i17 = 1048576;
        if (i3 != 1048576 || strArr == null || strArr.length <= 0) {
            return 0;
        }
        int length = strArr.length;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            boolean z19 = true;
            if (i18 >= length) {
                break;
            }
            String str5 = strArr[i18];
            if (str5 != null && str5.length() != 0) {
                int indexOf = str5.indexOf(40);
                int indexOf2 = str5.indexOf(41);
                if (indexOf == 0 && indexOf2 > 0) {
                    int intValue = Integer.valueOf(str5.substring(indexOf + 1, indexOf2)).intValue();
                    if ((intValue & i17) > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if ((intValue & 134217728) > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    str = str5.substring(indexOf2 + 1);
                } else {
                    z16 = false;
                    z17 = true;
                    str = str5;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("isPskeyExpired domain ");
                sb5.append(str);
                sb5.append(" req_pskey:");
                String str6 = "1";
                if (z17) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                sb5.append(str2);
                sb5.append(" req_pt4t:");
                if (z16) {
                    str3 = "1";
                } else {
                    str3 = "0";
                }
                sb5.append(str3);
                util.LOGI(sb5.toString(), "");
                if (z17 && (ticket._pskey_map.get(str) == null || Ticket.isPskeyExpired(ticket._pskey_expire.get(str).longValue()))) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z16 || (ticket._pt4token_map.get(str) != null && !Ticket.isPskeyExpired(ticket._pt4token_expire.get(str).longValue()))) {
                    z19 = false;
                }
                if (z18 || z19) {
                    int i26 = i19 + 1;
                    strArr[i19] = str5;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("PskeyExpired:");
                    sb6.append(str);
                    sb6.append("pskey:");
                    if (z18) {
                        str4 = "1";
                    } else {
                        str4 = "0";
                    }
                    sb6.append(str4);
                    sb6.append(",pt4t:");
                    if (!z19) {
                        str6 = "0";
                    }
                    sb6.append(str6);
                    util.LOGI(sb6.toString(), "");
                    i19 = i26;
                }
            }
            i18++;
            i17 = 1048576;
        }
        if (i19 == 0) {
            return 3;
        }
        while (i19 < strArr.length) {
            util.LOGI("isPskeyExpired domain " + strArr[i19] + " cleared", "");
            strArr[i19] = null;
            i19++;
        }
        if (i16 == 1) {
            return 1;
        }
        RefreshMemorySig();
        return 2;
    }

    private boolean isSaveSuccess(long j3, int i3, WTLoginRecordSnapshot wTLoginRecordSnapshot) {
        StringBuilder sb5 = new StringBuilder();
        WloginSigInfo d16 = this.mG.d(j3, i3);
        boolean z16 = false;
        if (d16 != null && d16._TGT != null && d16._D2 != null) {
            String buf_to_string = util.buf_to_string(wTLoginRecordSnapshot.f422865a2, 4);
            String buf_to_string2 = util.buf_to_string(d16._TGT, 4);
            String buf_to_string3 = util.buf_to_string(wTLoginRecordSnapshot.f422866d2, 4);
            String buf_to_string4 = util.buf_to_string(d16._D2, 4);
            if (TextUtils.equals(buf_to_string, buf_to_string2) && TextUtils.equals(buf_to_string3, buf_to_string4)) {
                z16 = true;
            }
            sb5.append("isSaveSuccess result:");
            sb5.append(z16);
            sb5.append("[A2: snapshotA2=");
            sb5.append(buf_to_string);
            sb5.append(",saveA2=");
            sb5.append(buf_to_string2);
            sb5.append(" ]");
            sb5.append("[D2: snapshotD2=");
            sb5.append(buf_to_string3);
            sb5.append(",saveD2=");
            sb5.append(buf_to_string4);
            sb5.append(" ]");
            util.LOGI("addWTLoginRecordFromNT -> " + sb5.toString(), "");
        }
        return z16;
    }

    private void localInit(Context context, boolean z16) {
        this.isForLocal = z16;
        try {
            this.mContext = context.getApplicationContext();
        } catch (Throwable th5) {
            this.mContext = context;
            util.printThrowable(th5, "");
        }
        u uVar = this.mG;
        uVar.getClass();
        u.f422949w = context;
        byte[] bArr = util.get_rand_16byte(u.f422943t);
        System.arraycopy(bArr, 0, uVar.f422955b, 0, bArr.length);
        RequestInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler newHelperHandler() {
        try {
            if (Looper.myLooper() == null) {
                return null;
            }
            return new Handler();
        } catch (Throwable unused) {
            return null;
        }
    }

    private void printTicket(WloginSigInfo wloginSigInfo) {
        util.LOGI("a1 " + wloginSigInfo._en_A1.length);
        util.LOGI("a1 version " + wloginSigInfo._A1_version);
        util.LOGI("a2 " + wloginSigInfo._TGT.length);
        util.LOGI("skey " + wloginSigInfo._sKey.length);
        util.LOGI("pskey " + wloginSigInfo._psKey.length);
        util.LOGI("superkey " + wloginSigInfo._superKey.length);
        util.LOGI("d2 " + wloginSigInfo._D2.length);
        util.LOGI("d2key " + wloginSigInfo._D2Key.length);
    }

    private void realGetPskeyIgnoreCache(final String str, final long j3, String[] strArr, final WtTicketPromise wtTicketPromise) {
        RefreshMemorySig();
        if (IsNeedLoginWithPasswd(str, j3).booleanValue()) {
            ErrMsg errMsg = new ErrMsg();
            errMsg.setType(-1004);
            wtTicketPromise.Failed(errMsg);
            return;
        }
        WUserSigInfo wUserSigInfo = new WUserSigInfo();
        if (strArr != null) {
            int min = Math.min(20, strArr.length);
            for (int i3 = 0; i3 < min; i3++) {
                String str2 = strArr[i3];
                if (str2 != null && str2.length() > 0) {
                    wUserSigInfo._domains.add(str2);
                }
            }
        }
        GetStWithoutPasswd(str, j3, j3, 1L, 1048576, wUserSigInfo, new WtTicketPromise() { // from class: oicq.wlogin_sdk.request.WtloginHelper.1
            @Override // oicq.wlogin_sdk.request.WtTicketPromise
            public void Done(Ticket ticket) {
                Ticket GetLocalTicket = WtloginHelper.this.GetLocalTicket(str, j3, 1048576);
                util.LOGI("realGetPskeyIgnoreCache Done", str);
                wtTicketPromise.Done(GetLocalTicket);
            }

            @Override // oicq.wlogin_sdk.request.WtTicketPromise
            public void Failed(ErrMsg errMsg2) {
                util.LOGI("realGetPskeyIgnoreCache Failed\uff1a" + errMsg2, str);
                wtTicketPromise.Failed(errMsg2);
            }

            @Override // oicq.wlogin_sdk.request.WtTicketPromise
            public void Timeout(ErrMsg errMsg2) {
                util.LOGI("realGetPskeyIgnoreCache Timeout:" + errMsg2, str);
                wtTicketPromise.Timeout(errMsg2);
            }
        });
    }

    /* JADX WARN: Can't wrap try/catch for region: R(34:1|(1:3)(1:191)|4|(1:6)|7|(1:9)|10|(1:190)(1:14)|15|(2:17|(9:19|20|(1:22)|23|(3:25|(1:39)(1:29)|30)(1:40)|31|(1:35)|36|37))(1:189)|41|(2:43|(1:88)(2:51|(11:86|87|84|20|(0)|23|(0)(0)|31|(2:33|35)|36|37)(12:63|64|(11:66|(2:68|(2:(4:76|(2:78|79)(2:81|82)|80|74)|83))|84|20|(0)|23|(0)(0)|31|(0)|36|37)|85|20|(0)|23|(0)(0)|31|(0)|36|37)))(1:188)|(1:187)(2:96|(12:98|(12:106|64|(0)|85|20|(0)|23|(0)(0)|31|(0)|36|37)|87|84|20|(0)|23|(0)(0)|31|(0)|36|37)(1:107))|108|(1:110)(1:186)|111|112|(18:116|(3:121|122|(5:127|128|129|130|(17:132|133|134|135|136|(2:166|(10:175|84|20|(0)|23|(0)(0)|31|(0)|36|37)(1:174))(9:143|(1:165)(1:147)|148|(1:156)|157|(1:159)|160|(1:162)(1:164)|163)|64|(0)|85|20|(0)|23|(0)(0)|31|(0)|36|37))(1:126))|181|135|136|(1:138)|166|(1:168)|175|84|20|(0)|23|(0)(0)|31|(0)|36|37)|183|136|(0)|166|(0)|175|84|20|(0)|23|(0)(0)|31|(0)|36|37|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0361, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x04e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int realGetStWithoutPasswd(String str, long j3, long j16, long j17, int i3, long j18, long[] jArr, WUserSigInfo wUserSigInfo, byte[][] bArr, byte[][] bArr2, WtTicketPromise wtTicketPromise) {
        String str2;
        long parseLong;
        long j19;
        String str3;
        String str4;
        byte[] bArr3;
        long[] jArr2;
        async_context async_contextVar;
        WloginSigInfo d16;
        byte[] bArr4;
        long j26;
        int a16;
        byte[] bArr5;
        byte[] bArr6;
        String str5;
        byte[] bArr7;
        int i16;
        int i17;
        byte[] bArr8;
        byte[] bArr9;
        byte[] bArr10;
        Ticket GetUserSigInfoTicket;
        Ticket ticket;
        String str6;
        u uVar;
        String str7;
        String str8;
        async_context async_contextVar2;
        tlv_t150 tlv_t150Var;
        u a17 = this.mG.a(0L);
        long j27 = a17.f422959f;
        wUserSigInfo._seqence = j27;
        async_context b16 = u.b(j27);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("start GetStWithoutPasswd: dwSrcAppid:");
        sb5.append(j3);
        sb5.append(" dwDstAppid:");
        sb5.append(j16);
        sb5.append(" dwDstAppPri:");
        sb5.append(j17);
        sb5.append(" dwMainSigMap:0x");
        sb5.append(Integer.toHexString(i3));
        sb5.append(" dwSubDstAppid:");
        sb5.append(j18);
        sb5.append(" Seq:");
        sb5.append(a17.f422959f);
        sb5.append("|");
        sb5.append(wtTicketPromise != null ? "1" : "0");
        sb5.append(" at ");
        sb5.append(u.f());
        util.LOGI(sb5.toString(), str);
        int i18 = util.get_saved_network_type(this.mContext);
        int i19 = util.get_network_type(this.mContext);
        u.F = i19;
        if (i18 != i19) {
            util.set_net_retry_type(this.mContext, 0);
            util.save_network_type(this.mContext, u.F);
        }
        u.H = util.get_apn_string(this.mContext).getBytes();
        a17.f422958e = str;
        a17.f422957d = 0L;
        b16._sappid = j3;
        b16._appid = j16;
        b16._sub_appid = j18;
        b16._main_sigmap = i3;
        b16._last_err_msg = new ErrMsg();
        if (jArr != null) {
            b16._sub_appid_list = (long[]) jArr.clone();
        }
        byte[] bArr11 = wUserSigInfo._reserveData;
        if (bArr11 == null || bArr11.length <= 3) {
            a17.f422960g = 0;
            str2 = "MSF SSO SEQ: 0";
        } else {
            a17.f422960g = util.buf_to_int32(bArr11, 0);
            str2 = "MSF SSO SEQ:" + a17.f422960g;
        }
        util.LOGI(str2, str);
        u.f422936m0.add_t2(new report_t2("exchg", new String(oicq.wlogin_sdk.utils.b.d(this.mContext)), System.currentTimeMillis(), j16, j18, jArr));
        if (util.check_uin_account(str).booleanValue()) {
            parseLong = Long.parseLong(str);
        } else {
            parseLong = a17.b(str);
            if (parseLong == 0) {
                util.LOGI("user:" + str + " have not found uin record.", str);
                i16 = -1003;
                str4 = "";
                async_contextVar = b16;
                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                if (GetUserSigInfoTicket == null) {
                    GetUserSigInfoTicket = new Ticket();
                }
                ticket = GetUserSigInfoTicket;
                u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
                if (i16 == 0) {
                    byte[] bArr12 = ticket._sig;
                    if (bArr12 == null || bArr12.length == 0) {
                        str6 = str4;
                        uVar = a17;
                        str7 = " dwMainSigMap:0x";
                        str8 = " Seq:";
                    } else {
                        str6 = str4;
                        uVar = a17;
                        str7 = " dwMainSigMap:0x";
                        str8 = " Seq:";
                        RequestReport(0, bArr12, ticket._sig_key, a17.f422957d, async_contextVar._appid);
                    }
                    async_contextVar2 = async_contextVar;
                } else {
                    str6 = str4;
                    uVar = a17;
                    str7 = " dwMainSigMap:0x";
                    str8 = " Seq:";
                    async_contextVar2 = async_contextVar;
                    RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, async_contextVar._appid, 0);
                }
                tlv_t150Var = uVar.f422956c;
                if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                    this.mG.f422956c = uVar.f422956c;
                    RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, async_contextVar2._appid, 1);
                }
                oicq.wlogin_sdk.report.b.a();
                u.a();
                uVar.b();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("end GetStWithoutPasswd:user:");
                sb6.append(str);
                sb6.append(" dwSrcAppid:");
                sb6.append(j3);
                sb6.append(" dwDstAppid:");
                sb6.append(j16);
                sb6.append(" dwDstAppPri:");
                sb6.append(j17);
                sb6.append(str7);
                sb6.append(Integer.toHexString(i3));
                sb6.append(" dwSubDstAppid:");
                u uVar2 = uVar;
                sb6.append(j18);
                sb6.append(str8);
                sb6.append(uVar2.f422959f);
                sb6.append(" ret=");
                sb6.append(i16);
                util.LOGI(sb6.toString(), str6 + uVar2.f422957d);
                return i16;
            }
        }
        long j28 = parseLong;
        a17.f422957d = j28;
        wUserSigInfo.uin = "" + j28;
        if (bArr2 == null) {
            j19 = j28;
            str3 = "";
        } else {
            if (bArr2.length == 4 && (bArr8 = bArr2[0]) != null && bArr8.length == 1 && bArr8[0] == 1) {
                util.LOGI("user:" + str + " exchange A2 from A2/D2/KEY.", "" + a17.f422957d);
                byte[] bArr13 = bArr2[1];
                if (bArr13 == null || bArr13.length == 0 || (bArr9 = bArr2[2]) == null || bArr9.length == 0 || (bArr10 = bArr2[3]) == null || bArr10.length == 0) {
                    str5 = "";
                    str4 = str5;
                    async_contextVar = b16;
                    i16 = -1004;
                    GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                    if (GetUserSigInfoTicket == null) {
                    }
                    ticket = GetUserSigInfoTicket;
                    u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
                    if (i16 == 0) {
                    }
                    tlv_t150Var = uVar.f422956c;
                    if (tlv_t150Var != null) {
                        this.mG.f422956c = uVar.f422956c;
                        RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, async_contextVar2._appid, 1);
                    }
                    oicq.wlogin_sdk.report.b.a();
                    u.a();
                    uVar.b();
                    StringBuilder sb62 = new StringBuilder();
                    sb62.append("end GetStWithoutPasswd:user:");
                    sb62.append(str);
                    sb62.append(" dwSrcAppid:");
                    sb62.append(j3);
                    sb62.append(" dwDstAppid:");
                    sb62.append(j16);
                    sb62.append(" dwDstAppPri:");
                    sb62.append(j17);
                    sb62.append(str7);
                    sb62.append(Integer.toHexString(i3));
                    sb62.append(" dwSubDstAppid:");
                    u uVar22 = uVar;
                    sb62.append(j18);
                    sb62.append(str8);
                    sb62.append(uVar22.f422959f);
                    sb62.append(" ret=");
                    sb62.append(i16);
                    util.LOGI(sb62.toString(), str6 + uVar22.f422957d);
                    return i16;
                }
                a17.f422954a = MD5.toMD5Byte(bArr10);
                a16 = new l(a17).a(j28, j16, j18, i3, bArr2[1], this.mMiscBitmap, this.mSubSigMap, jArr, bArr2[2], wUserSigInfo);
                jArr2 = jArr;
                async_contextVar = b16;
                j26 = j28;
                str4 = "";
                if (a16 == 0) {
                    int i26 = 0;
                    WloginSigInfo d17 = a17.d(j26, j16);
                    if (d17 != null) {
                        wUserSigInfo.get_clone(d17);
                        if (jArr2 != null && bArr != null && jArr2.length * 2 == bArr.length) {
                            while (i26 < jArr2.length) {
                                WloginSigInfo d18 = a17.d(j26, jArr2[i26]);
                                if (d18 != null) {
                                    int i27 = i26 * 2;
                                    i17 = a16;
                                    bArr[i27] = (byte[]) d18._userSt_Key.clone();
                                    bArr[i27 + 1] = (byte[]) d18._userStSig.clone();
                                } else {
                                    i17 = a16;
                                }
                                i26++;
                                a16 = i17;
                            }
                        }
                    }
                    i16 = -1004;
                    GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                    if (GetUserSigInfoTicket == null) {
                    }
                    ticket = GetUserSigInfoTicket;
                    u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
                    if (i16 == 0) {
                    }
                    tlv_t150Var = uVar.f422956c;
                    if (tlv_t150Var != null) {
                    }
                    oicq.wlogin_sdk.report.b.a();
                    u.a();
                    uVar.b();
                    StringBuilder sb622 = new StringBuilder();
                    sb622.append("end GetStWithoutPasswd:user:");
                    sb622.append(str);
                    sb622.append(" dwSrcAppid:");
                    sb622.append(j3);
                    sb622.append(" dwDstAppid:");
                    sb622.append(j16);
                    sb622.append(" dwDstAppPri:");
                    sb622.append(j17);
                    sb622.append(str7);
                    sb622.append(Integer.toHexString(i3));
                    sb622.append(" dwSubDstAppid:");
                    u uVar222 = uVar;
                    sb622.append(j18);
                    sb622.append(str8);
                    sb622.append(uVar222.f422959f);
                    sb622.append(" ret=");
                    sb622.append(i16);
                    util.LOGI(sb622.toString(), str6 + uVar222.f422957d);
                    return i16;
                }
                i16 = a16;
                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                if (GetUserSigInfoTicket == null) {
                }
                ticket = GetUserSigInfoTicket;
                u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
                if (i16 == 0) {
                }
                tlv_t150Var = uVar.f422956c;
                if (tlv_t150Var != null) {
                }
                oicq.wlogin_sdk.report.b.a();
                u.a();
                uVar.b();
                StringBuilder sb6222 = new StringBuilder();
                sb6222.append("end GetStWithoutPasswd:user:");
                sb6222.append(str);
                sb6222.append(" dwSrcAppid:");
                sb6222.append(j3);
                sb6222.append(" dwDstAppid:");
                sb6222.append(j16);
                sb6222.append(" dwDstAppPri:");
                sb6222.append(j17);
                sb6222.append(str7);
                sb6222.append(Integer.toHexString(i3));
                sb6222.append(" dwSubDstAppid:");
                u uVar2222 = uVar;
                sb6222.append(j18);
                sb6222.append(str8);
                sb6222.append(uVar2222.f422959f);
                sb6222.append(" ret=");
                sb6222.append(i16);
                util.LOGI(sb6222.toString(), str6 + uVar2222.f422957d);
                return i16;
            }
            str3 = "";
            j19 = j28;
        }
        if (bArr2 == null || bArr2.length != 3 || (bArr6 = bArr2[0]) == null || bArr6.length != 1) {
            str4 = str3;
        } else {
            if (bArr6[0] == 2) {
                StringBuilder sb7 = new StringBuilder();
                str5 = str3;
                sb7.append(str5);
                sb7.append(a17.f422957d);
                util.LOGI("user:" + str + " exchange A2 from A2/A2KEY.", sb7.toString());
                byte[] bArr14 = bArr2[1];
                if (bArr14 != null && bArr14.length != 0 && (bArr7 = bArr2[2]) != null && bArr7.length != 0) {
                    a17.f422954a = bArr7;
                    a16 = new l(a17).a(j19, j16, j18, i3, bArr2[1], this.mMiscBitmap, this.mSubSigMap, jArr, null, wUserSigInfo);
                    str4 = str5;
                    jArr2 = jArr;
                    async_contextVar = b16;
                    j26 = j19;
                    if (a16 == 0) {
                    }
                    i16 = a16;
                    GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                    if (GetUserSigInfoTicket == null) {
                    }
                    ticket = GetUserSigInfoTicket;
                    u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
                    if (i16 == 0) {
                    }
                    tlv_t150Var = uVar.f422956c;
                    if (tlv_t150Var != null) {
                    }
                    oicq.wlogin_sdk.report.b.a();
                    u.a();
                    uVar.b();
                    StringBuilder sb62222 = new StringBuilder();
                    sb62222.append("end GetStWithoutPasswd:user:");
                    sb62222.append(str);
                    sb62222.append(" dwSrcAppid:");
                    sb62222.append(j3);
                    sb62222.append(" dwDstAppid:");
                    sb62222.append(j16);
                    sb62222.append(" dwDstAppPri:");
                    sb62222.append(j17);
                    sb62222.append(str7);
                    sb62222.append(Integer.toHexString(i3));
                    sb62222.append(" dwSubDstAppid:");
                    u uVar22222 = uVar;
                    sb62222.append(j18);
                    sb62222.append(str8);
                    sb62222.append(uVar22222.f422959f);
                    sb62222.append(" ret=");
                    sb62222.append(i16);
                    util.LOGI(sb62222.toString(), str6 + uVar22222.f422957d);
                    return i16;
                }
                str4 = str5;
                async_contextVar = b16;
                i16 = -1004;
                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                if (GetUserSigInfoTicket == null) {
                }
                ticket = GetUserSigInfoTicket;
                u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
                if (i16 == 0) {
                }
                tlv_t150Var = uVar.f422956c;
                if (tlv_t150Var != null) {
                }
                oicq.wlogin_sdk.report.b.a();
                u.a();
                uVar.b();
                StringBuilder sb622222 = new StringBuilder();
                sb622222.append("end GetStWithoutPasswd:user:");
                sb622222.append(str);
                sb622222.append(" dwSrcAppid:");
                sb622222.append(j3);
                sb622222.append(" dwDstAppid:");
                sb622222.append(j16);
                sb622222.append(" dwDstAppPri:");
                sb622222.append(j17);
                sb622222.append(str7);
                sb622222.append(Integer.toHexString(i3));
                sb622222.append(" dwSubDstAppid:");
                u uVar222222 = uVar;
                sb622222.append(j18);
                sb622222.append(str8);
                sb622222.append(uVar222222.f422959f);
                sb622222.append(" ret=");
                sb622222.append(i16);
                util.LOGI(sb622222.toString(), str6 + uVar222222.f422957d);
                return i16;
            }
            str4 = str3;
        }
        a17.i();
        A1AndNopicSig a1AndNopicSigByAccount = getA1AndNopicSigByAccount(String.valueOf(a17.f422957d), j3);
        long j29 = j19;
        WloginSigInfo d19 = a17.d(j29, j3);
        Context context = this.mContext;
        String valueOf = String.valueOf(a17.f422957d);
        byte[] bArr15 = a1AndNopicSigByAccount.f422867a1;
        byte[] bArr16 = d19 == null ? null : d19._TGT;
        if (!TextUtils.isEmpty(valueOf) && context != null) {
            try {
            } catch (Exception e16) {
                e = e16;
            }
            if (bArr16 != null && bArr16.length != 0) {
                Map<String, String> map = oicq.wlogin_sdk.persistence.a.f422781a;
                MMKVOptionEntity from = QMMKV.from(context, QMMKVFile.FILE_WTLOGIN);
                if (bArr15 == null || bArr15.length <= 0) {
                    try {
                    } catch (Exception e17) {
                        e = e17;
                        util.printException(e, valueOf);
                        bArr3 = a1AndNopicSigByAccount.f422867a1;
                        byte[] bArr17 = a1AndNopicSigByAccount.noPicSig;
                        if (bArr3 != null) {
                        }
                        jArr2 = jArr;
                        async_contextVar = b16;
                        util.LOGI("user:" + str + " exchange A2 from A2.", str4 + a17.f422957d);
                        d16 = a17.d(j29, j3);
                        if (d16 != null) {
                        }
                        i16 = -1004;
                        GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                        if (GetUserSigInfoTicket == null) {
                        }
                        ticket = GetUserSigInfoTicket;
                        u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
                        if (i16 == 0) {
                        }
                        tlv_t150Var = uVar.f422956c;
                        if (tlv_t150Var != null) {
                        }
                        oicq.wlogin_sdk.report.b.a();
                        u.a();
                        uVar.b();
                        StringBuilder sb6222222 = new StringBuilder();
                        sb6222222.append("end GetStWithoutPasswd:user:");
                        sb6222222.append(str);
                        sb6222222.append(" dwSrcAppid:");
                        sb6222222.append(j3);
                        sb6222222.append(" dwDstAppid:");
                        sb6222222.append(j16);
                        sb6222222.append(" dwDstAppPri:");
                        sb6222222.append(j17);
                        sb6222222.append(str7);
                        sb6222222.append(Integer.toHexString(i3));
                        sb6222222.append(" dwSubDstAppid:");
                        u uVar2222222 = uVar;
                        sb6222222.append(j18);
                        sb6222222.append(str8);
                        sb6222222.append(uVar2222222.f422959f);
                        sb6222222.append(" ret=");
                        sb6222222.append(i16);
                        util.LOGI(sb6222222.toString(), str6 + uVar2222222.f422957d);
                        return i16;
                    }
                    if (from.decodeBool("A1_LOSE_" + valueOf, false)) {
                        from.encodeBool("A1_LOSE_" + valueOf, false);
                        util.LOGI("a1 sig lost", valueOf);
                        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_A1_SIG_LOSE, "1", str4);
                        aVar.f422860f = valueOf;
                        oicq.wlogin_sdk.report.c.b.a(aVar);
                        bArr3 = a1AndNopicSigByAccount.f422867a1;
                        byte[] bArr172 = a1AndNopicSigByAccount.noPicSig;
                        if (bArr3 != null || bArr3.length <= 0 || bArr172 == null || bArr172.length <= 0) {
                            jArr2 = jArr;
                            async_contextVar = b16;
                            util.LOGI("user:" + str + " exchange A2 from A2.", str4 + a17.f422957d);
                            d16 = a17.d(j29, j3);
                            if (d16 != null || (bArr4 = d16._TGT) == null || bArr4.length == 0 || d16.iSExpireA2(u.e())) {
                                i16 = -1004;
                                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                                if (GetUserSigInfoTicket == null) {
                                }
                                ticket = GetUserSigInfoTicket;
                                u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
                                if (i16 == 0) {
                                }
                                tlv_t150Var = uVar.f422956c;
                                if (tlv_t150Var != null) {
                                }
                                oicq.wlogin_sdk.report.b.a();
                                u.a();
                                uVar.b();
                                StringBuilder sb62222222 = new StringBuilder();
                                sb62222222.append("end GetStWithoutPasswd:user:");
                                sb62222222.append(str);
                                sb62222222.append(" dwSrcAppid:");
                                sb62222222.append(j3);
                                sb62222222.append(" dwDstAppid:");
                                sb62222222.append(j16);
                                sb62222222.append(" dwDstAppPri:");
                                sb62222222.append(j17);
                                sb62222222.append(str7);
                                sb62222222.append(Integer.toHexString(i3));
                                sb62222222.append(" dwSubDstAppid:");
                                u uVar22222222 = uVar;
                                sb62222222.append(j18);
                                sb62222222.append(str8);
                                sb62222222.append(uVar22222222.f422959f);
                                sb62222222.append(" ret=");
                                sb62222222.append(i16);
                                util.LOGI(sb62222222.toString(), str6 + uVar22222222.f422957d);
                                return i16;
                            }
                            util.LOGI("user:" + str + " exchange A2 from A2 without Priority.", str4 + a17.f422957d);
                            printTicket(d16);
                            a17.f422954a = d16._TGTKey;
                            j26 = j29;
                            a16 = new l(a17).a(j29, j16, j18, i3, d16._TGT, this.mMiscBitmap, this.mSubSigMap, jArr, null, wUserSigInfo);
                            oicq.wlogin_sdk.report.c.a aVar2 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CMD11_REQUEST, String.valueOf(a16), str4);
                            aVar2.f422860f = str;
                            oicq.wlogin_sdk.report.c.b.a(aVar2);
                        } else {
                            util.LOGI("user:" + str + " exchange A2 from A1.", str4 + a17.f422957d);
                            async_contextVar = b16;
                            async_contextVar._tmp_pwd = bArr3;
                            async_contextVar._tmp_no_pic_sig = bArr172;
                            byte[] bArr18 = wUserSigInfo._in_ksid;
                            byte[] bArr19 = (bArr18 == null || bArr18.length <= 0) ? u.f422924a0 : (byte[]) bArr18.clone();
                            c0 c0Var = new c0(a17, this.mContext);
                            WloginSigInfo FindUserSig = FindUserSig(j29, j3);
                            if (FindUserSig != null && true != FindUserSig.isWtSessionTicketExpired() && (bArr5 = FindUserSig.wtSessionTicket) != null && FindUserSig.wtSessionTicketKey != null) {
                                c0Var.f422920p = (byte[]) bArr5.clone();
                                c0Var.f422921q = (byte[]) FindUserSig.wtSessionTicketKey.clone();
                            }
                            int i28 = this.mMiscBitmap;
                            if (u.Z) {
                                i28 |= 33554432;
                            }
                            a16 = c0Var.a(j16, a17.f422957d, 0, u.f422927d0, bArr3, bArr172, i28, this.mSubSigMap, jArr, i3, j18, u.B, 0, 0, 1, bArr19, j3, wUserSigInfo);
                            if (a16 == 204) {
                                jArr2 = jArr;
                                a16 = new p(a17).a(this.mMiscBitmap, this.mSubSigMap, jArr2, wUserSigInfo);
                            } else {
                                jArr2 = jArr;
                            }
                            j26 = j29;
                        }
                        if (a16 == 0) {
                        }
                        i16 = a16;
                        GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                        if (GetUserSigInfoTicket == null) {
                        }
                        ticket = GetUserSigInfoTicket;
                        u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
                        if (i16 == 0) {
                        }
                        tlv_t150Var = uVar.f422956c;
                        if (tlv_t150Var != null) {
                        }
                        oicq.wlogin_sdk.report.b.a();
                        u.a();
                        uVar.b();
                        StringBuilder sb622222222 = new StringBuilder();
                        sb622222222.append("end GetStWithoutPasswd:user:");
                        sb622222222.append(str);
                        sb622222222.append(" dwSrcAppid:");
                        sb622222222.append(j3);
                        sb622222222.append(" dwDstAppid:");
                        sb622222222.append(j16);
                        sb622222222.append(" dwDstAppPri:");
                        sb622222222.append(j17);
                        sb622222222.append(str7);
                        sb622222222.append(Integer.toHexString(i3));
                        sb622222222.append(" dwSubDstAppid:");
                        u uVar222222222 = uVar;
                        sb622222222.append(j18);
                        sb622222222.append(str8);
                        sb622222222.append(uVar222222222.f422959f);
                        sb622222222.append(" ret=");
                        sb622222222.append(i16);
                        util.LOGI(sb622222222.toString(), str6 + uVar222222222.f422957d);
                        return i16;
                    }
                } else {
                    from.encodeBool("A1_LOSE_" + valueOf, true);
                }
            }
            util.LOGI("A1SigChecker a2 is null", valueOf);
            bArr3 = a1AndNopicSigByAccount.f422867a1;
            byte[] bArr1722 = a1AndNopicSigByAccount.noPicSig;
            if (bArr3 != null) {
            }
            jArr2 = jArr;
            async_contextVar = b16;
            util.LOGI("user:" + str + " exchange A2 from A2.", str4 + a17.f422957d);
            d16 = a17.d(j29, j3);
            if (d16 != null) {
            }
            i16 = -1004;
            GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
            if (GetUserSigInfoTicket == null) {
            }
            ticket = GetUserSigInfoTicket;
            u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
            if (i16 == 0) {
            }
            tlv_t150Var = uVar.f422956c;
            if (tlv_t150Var != null) {
            }
            oicq.wlogin_sdk.report.b.a();
            u.a();
            uVar.b();
            StringBuilder sb6222222222 = new StringBuilder();
            sb6222222222.append("end GetStWithoutPasswd:user:");
            sb6222222222.append(str);
            sb6222222222.append(" dwSrcAppid:");
            sb6222222222.append(j3);
            sb6222222222.append(" dwDstAppid:");
            sb6222222222.append(j16);
            sb6222222222.append(" dwDstAppPri:");
            sb6222222222.append(j17);
            sb6222222222.append(str7);
            sb6222222222.append(Integer.toHexString(i3));
            sb6222222222.append(" dwSubDstAppid:");
            u uVar2222222222 = uVar;
            sb6222222222.append(j18);
            sb6222222222.append(str8);
            sb6222222222.append(uVar2222222222.f422959f);
            sb6222222222.append(" ret=");
            sb6222222222.append(i16);
            util.LOGI(sb6222222222.toString(), str6 + uVar2222222222.f422957d);
            return i16;
        }
        bArr3 = a1AndNopicSigByAccount.f422867a1;
        byte[] bArr17222 = a1AndNopicSigByAccount.noPicSig;
        if (bArr3 != null) {
        }
        jArr2 = jArr;
        async_contextVar = b16;
        util.LOGI("user:" + str + " exchange A2 from A2.", str4 + a17.f422957d);
        d16 = a17.d(j29, j3);
        if (d16 != null) {
        }
        i16 = -1004;
        GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (GetUserSigInfoTicket == null) {
        }
        ticket = GetUserSigInfoTicket;
        u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i16), i16);
        if (i16 == 0) {
        }
        tlv_t150Var = uVar.f422956c;
        if (tlv_t150Var != null) {
        }
        oicq.wlogin_sdk.report.b.a();
        u.a();
        uVar.b();
        StringBuilder sb62222222222 = new StringBuilder();
        sb62222222222.append("end GetStWithoutPasswd:user:");
        sb62222222222.append(str);
        sb62222222222.append(" dwSrcAppid:");
        sb62222222222.append(j3);
        sb62222222222.append(" dwDstAppid:");
        sb62222222222.append(j16);
        sb62222222222.append(" dwDstAppPri:");
        sb62222222222.append(j17);
        sb62222222222.append(str7);
        sb62222222222.append(Integer.toHexString(i3));
        sb62222222222.append(" dwSubDstAppid:");
        u uVar22222222222 = uVar;
        sb62222222222.append(j18);
        sb62222222222.append(str8);
        sb62222222222.append(uVar22222222222.f422959f);
        sb62222222222.append(" ret=");
        sb62222222222.append(i16);
        util.LOGI(sb62222222222.toString(), str6 + uVar22222222222.f422957d);
        return i16;
    }

    private void saveNTSigFlag(Context context, long j3, int i3, byte[] bArr) {
        String buf_to_string = util.buf_to_string(bArr, 4);
        util.LOGI("saveNTSigFlag flag = " + buf_to_string, "");
        Map<String, String> map = oicq.wlogin_sdk.persistence.a.f422781a;
        QMMKV.from(context, QMMKVFile.FILE_WTLOGIN).encodeString(NT_FLAG_PREFIX + j3 + "_" + i3, buf_to_string);
    }

    public static void setCustomerGuid(Context context, byte[] bArr) {
        util.LOGI("set customer guid " + util.buf_to_string(bArr), "");
        u.f422930g0 = bArr;
        util.saveGuidToFile(context, bArr);
    }

    public static void setExtraLoginTlvValue(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        Integer num = new Integer(i3);
        tlv_t tlv_tVar = new tlv_t(i3);
        tlv_tVar.set_data(bArr, bArr.length);
        wUserSigInfo.extraLoginTLVMap.put(num, tlv_tVar);
        util.LOGI("setExtraLoginTlvValue tag:" + i3 + " value[0]: " + (bArr[0] & 255), wUserSigInfo.uin);
    }

    private static void setExtraProductLoginTlvValue(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        tlv_t tlv_tVar = new tlv_t(i3);
        tlv_tVar.set_data(bArr, bArr.length);
        wUserSigInfo._loginExtraProductTLVMap.put(Integer.valueOf(i3), tlv_tVar);
        util.LOGI("setExtraProductLoginTlvValue tag:" + i3 + " value[0]: " + (bArr[0] & 255), wUserSigInfo.uin);
    }

    public static void setExtraRegTlvValue(WUserSigInfo wUserSigInfo, int i3, byte[] bArr) {
        Integer num = new Integer(i3);
        RegTLV regTLV = new RegTLV(i3);
        regTLV.set_data(bArr, bArr.length);
        wUserSigInfo.extraRegTLVMap.put(num, regTLV);
    }

    @Deprecated
    public static void setExtraRegTlvValueWatchQQLicense(WUserSigInfo wUserSigInfo, byte[] bArr) {
        setExtraRegTlvValue(wUserSigInfo, 38, bArr);
    }

    public static void setLoadEncryptSo(boolean z16) {
        util.loadEncryptSo = z16;
    }

    public static void setLoadSoFlg(boolean z16) {
        SecureRandom secureRandom = u.f422943t;
    }

    public static void setProductType(int i3) {
        u.f422942s0 = i3;
    }

    public static void setQimeiListener(QimeiListener qimeiListener) {
        oicq.wlogin_sdk.utils.b.f423005a = qimeiListener;
    }

    public static void setRegisterFlg(int i3) {
        u.f422929f0 = i3 | u.f422929f0;
    }

    public static void setReportListener(ReportListener reportListener) {
        b.a.f422854a.f422852c = reportListener;
    }

    public static void setSecTransInfo(String str, String str2, int i3, String str3) {
        u.f422944t0 = str;
        u.f422946u0 = str2;
        u.f422948v0 = i3;
        u.f422950w0 = str3;
    }

    public static void setSwitchListener(SwitchListener switchListener2) {
        if (switchListener2 != null) {
            switchListener = switchListener2;
        }
    }

    public static void setWtDataSender(IWtDataSender iWtDataSender) {
        mWtDataSender = iWtDataSender;
    }

    private void tlvCommRsp2ErrMsg(TLV_CommRsp tLV_CommRsp, ErrMsg errMsg) {
        if (tLV_CommRsp != null && tLV_CommRsp.get_data_len() != 0) {
            errMsg.setType(tLV_CommRsp.ErrInfoType);
            errMsg.setOtherinfo(new String(tLV_CommRsp.ErrInfo));
            errMsg.setTitle(new String(tLV_CommRsp.ErrTitle));
            errMsg.setMessage(new String(tLV_CommRsp.ErrMsg));
        }
    }

    public static byte[] updateGuid(Context context) {
        oicq.wlogin_sdk.utils.a.c(context);
        byte[] generateGuid = util.generateGuid(context);
        u.D = (byte[]) generateGuid.clone();
        u.E = (byte[]) generateGuid.clone();
        return (byte[]) generateGuid.clone();
    }

    public int AskDevLockSms(String str, long j3, long j16, WUserSigInfo wUserSigInfo) {
        byte[] bArr;
        if (str == null) {
            return -1017;
        }
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return -1003;
        }
        long j17 = wloginSimpleInfo._uin;
        util.LOGI("AskDevLockSms ...", str);
        oicq.wlogin_sdk.devicelock.c cVar = new oicq.wlogin_sdk.devicelock.c();
        TransReqContext transReqContext = new TransReqContext();
        transReqContext.set_devlock_req();
        transReqContext.set_subcmd(cVar.get_msgType());
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_DEV_LOCK, String.valueOf(DevlockBase.a.f422760b), "");
        aVar.f422860f = String.valueOf(j17);
        oicq.wlogin_sdk.report.c.b.a(aVar);
        TLV_QuerySig tLV_QuerySig = DevlockBase.rst.querySig;
        oicq.wlogin_sdk.devicelock.k kVar = new oicq.wlogin_sdk.devicelock.k();
        kVar.fill_head();
        kVar.fill_body(new byte[4], 4);
        kVar.put_int32(j16, kVar._head_len);
        kVar.get_buf();
        int i3 = tLV_QuerySig.get_size();
        int i16 = kVar.get_size();
        if (i3 != 0 && i16 != 0) {
            int i17 = i3 + 2;
            byte[] bArr2 = new byte[i17 + i16];
            util.int16_to_buf(bArr2, 0, 2);
            System.arraycopy(tLV_QuerySig.get_buf(), 0, bArr2, 2, i3);
            System.arraycopy(kVar.get_buf(), 0, bArr2, i17, i16);
            bArr = cVar._get_request(j17, j3, bArr2);
        } else {
            bArr = new byte[0];
        }
        transReqContext._body = bArr;
        if (bArr == null || bArr.length == 0) {
            return -1017;
        }
        return RequestTransport(0, 1, str, j3, cVar.Role, transReqContext, wUserSigInfo);
    }

    public void CancelRequest() {
        this.mG.f422969p = 1;
    }

    public int CheckDevLockSms(String str, long j3, long j16, String str2, byte[] bArr, WUserSigInfo wUserSigInfo) {
        byte[] bytes;
        TransReqContext transReqContext;
        byte[] bArr2;
        byte[] bArr3;
        if (str == null) {
            return -1017;
        }
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return -1003;
        }
        long j17 = wloginSimpleInfo._uin;
        WloginSigInfo FindUserSig = FindUserSig(j17, j3);
        if (FindUserSig == null) {
            return -1004;
        }
        if (bArr != null && bArr.length > 0) {
            DevlockBase.rst.setSppKey(bArr);
        }
        util.LOGI("CheckDevLockSms ...", str);
        oicq.wlogin_sdk.devicelock.e eVar = new oicq.wlogin_sdk.devicelock.e();
        TransReqContext transReqContext2 = new TransReqContext();
        String str3 = Build.VERSION.RELEASE;
        if (str3 == null) {
            str3 = "";
        }
        transReqContext2.set_devlock_req();
        transReqContext2.set_subcmd(eVar.get_msgType());
        transReqContext2.setSTEncryptMethod();
        transReqContext2.setWtST(FindUserSig);
        byte[] bArr4 = FindUserSig._TGT;
        byte[] bArr5 = u.D;
        byte[] bArr6 = u.G;
        byte[] bytes2 = util.SDK_VERSION.getBytes();
        byte[] bytes3 = "android".getBytes();
        byte[] bytes4 = str3.getBytes();
        if (str2 == null) {
            bytes = null;
        } else {
            bytes = str2.getBytes();
        }
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_DEV_LOCK, String.valueOf(DevlockBase.a.f422761c), "");
        aVar.f422860f = String.valueOf(j17);
        oicq.wlogin_sdk.report.c.b.a(aVar);
        TLV_QuerySig tLV_QuerySig = DevlockBase.rst.querySig;
        if (tLV_QuerySig.get_size() == 0) {
            tLV_QuerySig.set_data(new byte[0], 0);
        }
        byte[] bArr7 = bytes;
        byte[] a16 = new oicq.wlogin_sdk.devicelock.f().a(j3, j16, bArr4, bArr5, bArr6, bytes2, bytes3, bytes4);
        if (a16 != null && a16.length != 0) {
            if (bArr7 != null && bArr7.length > 0) {
                oicq.wlogin_sdk.devicelock.m mVar = new oicq.wlogin_sdk.devicelock.m();
                int length = bArr7.length + 2;
                mVar.fill_head();
                mVar.fill_body(new byte[length], length);
                mVar.put_block(bArr7, mVar._head_len);
                bArr3 = mVar.get_buf();
            } else {
                TLV_SppKey tLV_SppKey = DevlockBase.rst.sppKey;
                if (tLV_SppKey != null && tLV_SppKey.get_data_len() > 0) {
                    bArr3 = DevlockBase.rst.sppKey.get_buf();
                } else {
                    bArr3 = null;
                }
            }
            if (bArr3 != null && bArr3.length != 0) {
                int i3 = tLV_QuerySig.get_size();
                int length2 = a16.length;
                int length3 = bArr3.length;
                int i16 = i3 + 2;
                int i17 = i16 + length2;
                byte[] bArr8 = new byte[i17 + length3];
                util.int16_to_buf(bArr8, 0, 3);
                System.arraycopy(tLV_QuerySig.get_buf(), 0, bArr8, 2, i3);
                System.arraycopy(a16, 0, bArr8, i16, length2);
                System.arraycopy(bArr3, 0, bArr8, i17, length3);
                transReqContext = transReqContext2;
                bArr2 = eVar._get_request(j17, j3, bArr8);
                transReqContext._body = bArr2;
                if (bArr2 == null && bArr2.length != 0) {
                    return RequestTransport(0, 1, str, j3, eVar.Role, transReqContext, wUserSigInfo);
                }
            }
        }
        transReqContext = transReqContext2;
        bArr2 = new byte[0];
        transReqContext._body = bArr2;
        return bArr2 == null ? -1017 : -1017;
    }

    public int CheckDevLockStatus(String str, long j3, long j16, WUserSigInfo wUserSigInfo) {
        TransReqContext transReqContext;
        oicq.wlogin_sdk.devicelock.a aVar;
        byte[] bArr;
        if (str == null) {
            return -1017;
        }
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return -1003;
        }
        long j17 = wloginSimpleInfo._uin;
        WloginSigInfo FindUserSig = FindUserSig(j17, j3);
        if (FindUserSig == null) {
            return -1004;
        }
        util.LOGI("CheckDevLockStatus ...", str);
        DevlockBase.rst = new DevlockRst();
        oicq.wlogin_sdk.devicelock.a aVar2 = new oicq.wlogin_sdk.devicelock.a();
        TransReqContext transReqContext2 = new TransReqContext();
        transReqContext2.set_devlock_req();
        transReqContext2.set_subcmd(aVar2.get_msgType());
        transReqContext2.setSTEncryptMethod();
        transReqContext2.setWtST(FindUserSig);
        byte[] bArr2 = FindUserSig._TGT;
        byte[] bArr3 = u.D;
        byte[] bArr4 = u.G;
        byte[] bytes = util.SDK_VERSION.getBytes();
        byte[] bArr5 = u.L;
        byte[] bArr6 = u.K;
        oicq.wlogin_sdk.report.c.a aVar3 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_DEV_LOCK, String.valueOf(DevlockBase.a.f422759a), "");
        aVar3.f422860f = String.valueOf(j17);
        oicq.wlogin_sdk.report.c.b.a(aVar3);
        byte[] a16 = new oicq.wlogin_sdk.devicelock.f().a(j3, j16, bArr2, bArr3, bArr4, bytes, bArr5, bArr6);
        if (a16 != null && a16.length != 0) {
            byte[] bArr7 = new byte[a16.length + 2];
            util.int16_to_buf(bArr7, 0, 1);
            System.arraycopy(a16, 0, bArr7, 2, a16.length);
            transReqContext = transReqContext2;
            aVar = aVar2;
            bArr = aVar2._get_request(j17, j3, bArr7);
        } else {
            transReqContext = transReqContext2;
            aVar = aVar2;
            bArr = new byte[0];
        }
        transReqContext._body = bArr;
        if (bArr == null || bArr.length == 0) {
            return -1017;
        }
        return RequestTransport(0, 1, str, j3, aVar.Role, transReqContext, wUserSigInfo);
    }

    public int CheckPictureAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo) {
        n.f422900v = false;
        return CheckPictureAndGetSt(str, bArr, wUserSigInfo, null, 0);
    }

    public int CheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo) {
        return CheckSMSAndGetSt(str, bArr, wUserSigInfo, null, null, 0);
    }

    public int CheckSMSVerifyLoginAccount(long j3, long j16, int i3, long j17, WUserSigInfo wUserSigInfo) {
        return CheckSMSVerifyLoginAccount(j3, j16, null, i3, j17, wUserSigInfo, 0);
    }

    public int CheckWebsigAndGetSt(String str, String str2, WUserSigInfo wUserSigInfo) {
        n.f422900v = true;
        return CheckPictureAndGetSt(str, str2.getBytes(), wUserSigInfo, null, 0);
    }

    public void ClearPSkey(String str, long j3) {
        long parseLong;
        util.LOGI("user:" + str + " appid:" + j3 + " ClearPSkey ...", str);
        if (str != null && str.length() > 0) {
            synchronized (this) {
                boolean z16 = true;
                if (!util.check_uin_account(str).booleanValue()) {
                    parseLong = this.mG.b(str);
                    if (parseLong == 0) {
                        z16 = false;
                    }
                } else {
                    parseLong = Long.parseLong(str);
                }
                if (z16) {
                    this.mG.b(parseLong, j3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055 A[Catch: all -> 0x0066, TryCatch #0 {, blocks: (B:7:0x002e, B:9:0x003a, B:13:0x0055, B:14:0x005a, B:19:0x0048, B:21:0x004e), top: B:6:0x002e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean ClearUserLoginData(String str, long j3) {
        long parseLong;
        boolean z16;
        util.LOGI("user:" + str + " appid:" + j3 + " ClearUserLoginData ...", str);
        if (str != null && str.length() > 0) {
            synchronized (this) {
                if (!util.check_uin_account(str).booleanValue()) {
                    parseLong = this.mG.b(str);
                    if (parseLong == 0) {
                        z16 = false;
                        if (z16) {
                            this.mG.c(parseLong, j3);
                        }
                    } else {
                        this.mG.a(str);
                    }
                } else {
                    parseLong = Long.parseLong(str);
                }
                z16 = true;
                if (z16) {
                }
            }
            WloginSigInfo._QRPUSHSig = new byte[0];
            WloginSigInfo._LHSig = new byte[0];
            return Boolean.TRUE;
        }
        return Boolean.TRUE;
    }

    public int CloseCode(String str, long j3, byte[] bArr, int i3, List<byte[]> list, byte[] bArr2, WUserSigInfo wUserSigInfo) {
        byte[] bArr3;
        List<byte[]> list2;
        byte[] bArr4;
        int[] iArr;
        byte[] bArr5;
        long j16;
        byte[] appInfo;
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return -1003;
        }
        if (bArr2 == null) {
            bArr3 = new byte[0];
        } else {
            bArr3 = bArr2;
        }
        long j17 = wloginSimpleInfo._uin;
        this.mG.i();
        WloginSigInfo FindUserSig = FindUserSig(j17, j3);
        if (FindUserSig == null) {
            return -1004;
        }
        util.LOGI("user:" + str + " CloseCode ...", str);
        oicq.wlogin_sdk.code2d.b bVar = new oicq.wlogin_sdk.code2d.b();
        TransReqContext transReqContext = new TransReqContext();
        transReqContext.set_code2d_func_req();
        transReqContext.set_subcmd(bVar.get_cmd());
        transReqContext.setSTEncryptMethod();
        transReqContext.setWtST(FindUserSig);
        byte[] bArr6 = FindUserSig._TGT;
        SecureRandom secureRandom = u.f422943t;
        byte[] bArr7 = FindUserSig._en_A1;
        byte[] bArr8 = FindUserSig._noPicSig;
        long j18 = this.mMiscBitmap;
        if (list == null) {
            list2 = new ArrayList();
        } else {
            list2 = list;
        }
        int[] iArr2 = {22, 24, 25, 29, 104, 300};
        int[] iArr3 = new int[0];
        util.LOGI("code2d_req_status.NeedA1 = " + oicq.wlogin_sdk.code2d.d.f422748o + ", A1A1Key.length " + bArr7.length, "");
        if (oicq.wlogin_sdk.code2d.d.f422748o && bArr7.length > 16) {
            int length = bArr7.length - 16;
            bArr5 = new byte[length];
            bArr4 = bArr3;
            byte[] bArr9 = new byte[16];
            System.arraycopy(bArr7, 0, bArr5, 0, length);
            System.arraycopy(bArr7, length, bArr9, 0, 16);
            oicq.wlogin_sdk.code2d.b.f422743a = bArr9;
            iArr = iArr2;
        } else {
            bArr4 = bArr3;
            iArr = iArr3;
            bArr5 = null;
        }
        tlv_t tlv_tVar = new tlv_t();
        tlv_tVar.fill_head(104);
        byte[] bArr10 = u.D;
        tlv_tVar.fill_body(bArr10, bArr10.length);
        tlv_tVar.set_length();
        List<byte[]> list3 = list2;
        list3.add(tlv_tVar.get_buf());
        int i16 = 0;
        while (i16 < iArr.length) {
            tlv_t tlv_tVar2 = new tlv_t();
            tlv_tVar2.fill_head(iArr[i16]);
            int i17 = iArr[i16];
            int[] iArr4 = iArr;
            if (i17 != 22) {
                if (i17 != 29) {
                    if (i17 != 300) {
                        if (i17 != 24) {
                            j16 = j18;
                            if (i17 != 25) {
                                appInfo = null;
                            } else {
                                appInfo = bArr8;
                            }
                        } else {
                            appInfo = bArr5;
                            j16 = j18;
                        }
                    } else {
                        j16 = j18;
                        appInfo = bArr4;
                    }
                } else {
                    appInfo = new byte[10];
                    util.int8_to_buf(appInfo, 0, 0);
                    util.int64_to_buf32(appInfo, 1, j18);
                    j16 = j18;
                    util.int64_to_buf32(appInfo, 5, 0L);
                    util.int8_to_buf(appInfo, 9, 0);
                }
            } else {
                j16 = j18;
                appInfo = bVar.getAppInfo(j3, 1L);
            }
            if (appInfo != null) {
                tlv_tVar2.fill_body(appInfo, appInfo.length);
                tlv_tVar2.set_length();
                list3.add(tlv_tVar2.get_buf());
            }
            i16++;
            iArr = iArr4;
            j18 = j16;
        }
        int size = list3.size();
        int length2 = bArr.length + 16 + 2 + bArr6.length + 1 + 2;
        for (int i18 = 0; i18 < size; i18++) {
            if (list3.get(i18) != null) {
                length2 += list3.get(i18).length;
            }
        }
        byte[] bArr11 = new byte[length2];
        util.int64_to_buf32(bArr11, 2, j3);
        util.int64_to_buf(bArr11, 6, j17);
        util.int16_to_buf(bArr11, 14, bArr.length);
        System.arraycopy(bArr, 0, bArr11, 16, bArr.length);
        int length3 = bArr.length + 16;
        util.int16_to_buf(bArr11, length3, bArr6.length);
        int i19 = length3 + 2;
        System.arraycopy(bArr6, 0, bArr11, i19, bArr6.length);
        int length4 = i19 + bArr6.length;
        util.int8_to_buf(bArr11, length4, 8);
        int i26 = length4 + 1;
        util.int16_to_buf(bArr11, i26, size);
        int i27 = i26 + 2;
        for (int i28 = 0; i28 < size; i28++) {
            byte[] bArr12 = list3.get(i28);
            if (bArr12 != null) {
                System.arraycopy(bArr12, 0, bArr11, i27, bArr12.length);
                i27 += bArr12.length;
            }
        }
        transReqContext._body = bVar.get_request(j17, true, bArr11);
        return RequestTransport(0, 1, str, j3, bVar._role, transReqContext, wUserSigInfo);
    }

    public int CloseDevLock(String str, long j3, long j16, WUserSigInfo wUserSigInfo) {
        TransReqContext transReqContext;
        oicq.wlogin_sdk.devicelock.b bVar;
        byte[] bArr;
        if (str == null) {
            return -1017;
        }
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return -1003;
        }
        long j17 = wloginSimpleInfo._uin;
        WloginSigInfo FindUserSig = FindUserSig(j17, j3);
        if (FindUserSig == null) {
            return -1004;
        }
        util.LOGI("CloseDevLock ...", str);
        oicq.wlogin_sdk.devicelock.b bVar2 = new oicq.wlogin_sdk.devicelock.b();
        TransReqContext transReqContext2 = new TransReqContext();
        String str2 = Build.VERSION.RELEASE;
        if (str2 == null) {
            str2 = "";
        }
        transReqContext2.set_devlock_req();
        transReqContext2.set_subcmd(bVar2.get_msgType());
        transReqContext2.setSTEncryptMethod();
        transReqContext2.setWtST(FindUserSig);
        byte[] bArr2 = FindUserSig._TGT;
        byte[] bArr3 = u.D;
        byte[] bArr4 = u.G;
        byte[] bytes = util.SDK_VERSION.getBytes();
        byte[] bytes2 = "android".getBytes();
        byte[] bytes3 = str2.getBytes();
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_DEV_LOCK, String.valueOf(12), "");
        aVar.f422860f = String.valueOf(j17);
        oicq.wlogin_sdk.report.c.b.a(aVar);
        byte[] a16 = new oicq.wlogin_sdk.devicelock.f().a(j3, j16, bArr2, bArr3, bArr4, bytes, bytes2, bytes3);
        if (a16 != null && a16.length != 0) {
            byte[] bArr5 = new byte[a16.length + 2];
            util.int16_to_buf(bArr5, 0, 1);
            System.arraycopy(a16, 0, bArr5, 2, a16.length);
            transReqContext = transReqContext2;
            bVar = bVar2;
            bArr = bVar2._get_request(j17, j3, bArr5);
        } else {
            transReqContext = transReqContext2;
            bVar = bVar2;
            bArr = new byte[0];
        }
        transReqContext._body = bArr;
        if (bArr == null || bArr.length == 0) {
            return -1017;
        }
        return RequestTransport(0, 1, str, j3, bVar.Role, transReqContext, wUserSigInfo);
    }

    public int FetchCodeSig(long j3, long j16, fetch_code.QRCodeCustom qRCodeCustom, WUserSigInfo wUserSigInfo) {
        util.LOGI(" FetchCodeSig ...", "");
        fetch_code fetch_codeVar = new fetch_code();
        TransReqContext transReqContext = new TransReqContext();
        transReqContext.set_code2d_func_req();
        transReqContext.set_subcmd(fetch_codeVar.get_cmd());
        transReqContext._body = fetch_codeVar.get_request(0L, j3, j16, new byte[0], qRCodeCustom, this.mMiscBitmap, 0L, WloginSigInfo._QRPUSHSig);
        return RequestTransport(0, 1, null, j3, fetch_codeVar._role, transReqContext, wUserSigInfo);
    }

    public int GetA1WithA1(String str, long j3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo) {
        return GetA1WithA1(str, j3, j16, this.mMainSigMap, bArr, j17, j18, j19, bArr2, bArr3, wUserSigInfo, wFastLoginInfo, 0);
    }

    public byte[] GetA2A2KeyBuf(String str, long j3) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        Ticket GetLocalTicket = GetLocalTicket(str, j3, 64);
        if (GetLocalTicket == null || (bArr = GetLocalTicket._sig) == null || bArr.length <= 0 || (bArr2 = GetLocalTicket._sig_key) == null || bArr2.length <= 0 || (bArr3 = u.E) == null || bArr3.length <= 0) {
            return null;
        }
        int length = str.getBytes().length + 2 + 8 + 2 + GetLocalTicket._sig.length + 2 + GetLocalTicket._sig_key.length;
        byte[] bArr4 = new byte[length];
        util.int16_to_buf(bArr4, 0, str.getBytes().length);
        System.arraycopy(str.getBytes(), 0, bArr4, 2, str.getBytes().length);
        int length2 = str.getBytes().length + 2;
        util.int64_to_buf(bArr4, length2, j3);
        int i3 = length2 + 8;
        util.int16_to_buf(bArr4, i3, GetLocalTicket._sig.length);
        int i16 = i3 + 2;
        byte[] bArr5 = GetLocalTicket._sig;
        System.arraycopy(bArr5, 0, bArr4, i16, bArr5.length);
        int length3 = i16 + GetLocalTicket._sig.length;
        util.int16_to_buf(bArr4, length3, GetLocalTicket._sig_key.length);
        byte[] bArr6 = GetLocalTicket._sig_key;
        System.arraycopy(bArr6, 0, bArr4, length3 + 2, bArr6.length);
        int length4 = GetLocalTicket._sig_key.length;
        return cryptor.encrypt(bArr4, 0, length, u.E);
    }

    public List<WloginLoginInfo> GetAllLoginInfo() {
        return this.mG.d();
    }

    public long GetAppidFromUrl(String str) {
        int indexOf;
        int i3;
        if (str == null || (indexOf = str.indexOf("f=")) == -1 || (i3 = indexOf + 2) >= str.length()) {
            return -1L;
        }
        String str2 = "";
        for (i3 = indexOf + 2; i3 < str.length() && str.charAt(i3) != '&'; i3++) {
            str2 = str2 + str.charAt(i3);
        }
        try {
            return Long.parseLong(str2);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean GetBasicUserInfo(String str, WloginSimpleInfo wloginSimpleInfo) {
        long parseLong;
        boolean z16;
        if (str == null) {
            return Boolean.FALSE;
        }
        boolean z17 = false;
        if (!util.check_uin_account(str).booleanValue()) {
            parseLong = this.mG.b(str);
            if (parseLong == 0) {
                z16 = false;
                if (z16) {
                    WloginSimpleInfo c16 = this.mG.c(parseLong);
                    if (c16 == null) {
                        z16 = false;
                    } else {
                        wloginSimpleInfo.setUin(c16._uin);
                        wloginSimpleInfo.setFace(c16._face);
                        wloginSimpleInfo.setGender(c16._gender);
                        wloginSimpleInfo.setNick(c16._nick);
                        wloginSimpleInfo.setAge(c16._age);
                        wloginSimpleInfo.setImgType(c16._img_type);
                        wloginSimpleInfo.setImgFormat(c16._img_format);
                        wloginSimpleInfo.setImgUrl(c16._img_url);
                        wloginSimpleInfo.setMainDisplayName(c16.mainDisplayName);
                    }
                }
                if (z16) {
                    z17 = true;
                }
                return Boolean.valueOf(z17);
            }
        } else {
            parseLong = Long.parseLong(str);
        }
        z16 = true;
        if (z16) {
        }
        if (z16) {
        }
        return Boolean.valueOf(z17);
    }

    public Boolean GetBasicUserInfoForQQLoginInQimOnly(WUserSigInfo wUserSigInfo, WloginSimpleInfo wloginSimpleInfo) {
        boolean z16;
        WloginSimpleInfo c16 = this.mG.c(Long.parseLong(wUserSigInfo.uin));
        boolean z17 = false;
        if (c16 == null) {
            z16 = false;
        } else {
            wloginSimpleInfo.setUin(c16._uin);
            wloginSimpleInfo.setFace(c16._face);
            wloginSimpleInfo.setGender(c16._gender);
            wloginSimpleInfo.setNick(c16._nick);
            wloginSimpleInfo.setAge(c16._age);
            wloginSimpleInfo.setImgType(c16._img_type);
            wloginSimpleInfo.setImgFormat(c16._img_format);
            wloginSimpleInfo.setImgUrl(c16._img_url);
            wloginSimpleInfo.setMainDisplayName(c16.mainDisplayName);
            z16 = true;
        }
        if (z16) {
            z17 = true;
        }
        return Boolean.valueOf(z17);
    }

    public DevlockInfo GetDevLockInfo(String str) {
        return GetDevLockInfo(str, 0L);
    }

    public byte[] GetGuid() {
        byte[] b16 = u.b(this.mContext);
        if (b16 != null) {
            return b16;
        }
        byte[] bArr = u.D;
        if (bArr != null && bArr.length > 0) {
            b16 = new byte[bArr.length];
            System.arraycopy(bArr, 0, b16, 0, bArr.length);
        }
        util.LOGI("get guid " + util.buf_to_string(b16), "");
        return b16;
    }

    public WloginLastLoginInfo GetLastLoginInfo() {
        Iterator it = ((ArrayList) this.mG.d()).iterator();
        WloginLoginInfo wloginLoginInfo = null;
        while (it.hasNext()) {
            WloginLoginInfo wloginLoginInfo2 = (WloginLoginInfo) it.next();
            if (wloginLoginInfo == null || wloginLoginInfo2.mCreateTime > wloginLoginInfo.mCreateTime) {
                wloginLoginInfo = wloginLoginInfo2;
            }
        }
        if (wloginLoginInfo == null) {
            return null;
        }
        String str = wloginLoginInfo.mAccount;
        if (str != null && str.length() > 0) {
            return new WloginLastLoginInfo(wloginLoginInfo.mAccount, wloginLoginInfo.mUin);
        }
        return new WloginLastLoginInfo(String.valueOf(wloginLoginInfo.mUin), wloginLoginInfo.mUin);
    }

    public WUserSigInfo GetLocalSig(String str, long j3) {
        long parseLong;
        WUserSigInfo wUserSigInfo = null;
        if (str == null) {
            util.LOGI("userAccount null", "");
            return null;
        }
        try {
            if (!util.check_uin_account(str).booleanValue()) {
                parseLong = this.mG.b(str);
                if (parseLong == 0) {
                    return null;
                }
            } else {
                parseLong = Long.parseLong(str);
            }
            WloginSigInfo d16 = this.mG.d(parseLong, j3);
            if (d16 == null) {
                return null;
            }
            WUserSigInfo wUserSigInfo2 = new WUserSigInfo();
            try {
                wUserSigInfo2.uin = str;
                wUserSigInfo2.get_clone(d16);
                util.LOGI("skey in sigInfo " + util.getMaskBytes(d16._sKey, 2, 2), str);
                return wUserSigInfo2;
            } catch (Exception e16) {
                e = e16;
                wUserSigInfo = wUserSigInfo2;
                util.printException(e, str);
                return wUserSigInfo;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public Ticket GetLocalTicket(String str, long j3, int i3) {
        util.LOGI("GetLocalTicket appid " + j3 + " type 0x" + String.format("%x", Integer.valueOf(i3)), str);
        if (str == null) {
            util.LOGI("userAccount null", "");
            return null;
        }
        return GetUserSigInfoTicket(GetLocalSig(str, j3), i3);
    }

    public int GetOpenKeyWithoutPasswd(String str, long j3, long j16, int i3, WUserSigInfo wUserSigInfo) {
        return GetStWithoutPasswd(str, j3, this.mOpenAppid, -1L, i3, j16, null, wUserSigInfo, null, null, 0, null);
    }

    public byte[] GetPictureData(String str) {
        return GetPictureData(str, 0L);
    }

    @Deprecated
    public byte[] GetPicturePrompt(String str) {
        return GetPicturePrompt(str, 0L);
    }

    public String GetPicturePromptValue(String str) {
        return GetPicturePromptValue(str, 0L);
    }

    public Ticket GetPskey(String str, long j3, String[] strArr, WtTicketPromise wtTicketPromise) {
        Ticket GetTicket;
        Bundle bundle = new Bundle();
        bundle.putStringArray("domains", strArr);
        String str2 = "";
        for (String str3 : strArr) {
            str2 = str2 + str3 + ",";
        }
        synchronized (GET_TICKET_LOCK) {
            util.LOGI("GetPskey appid " + j3 + " domains " + str2, str);
            GetTicket = GetTicket(str, j3, 1048576, wtTicketPromise, bundle);
        }
        return GetTicket;
    }

    public Ticket GetSkey(String str, long j3, WtTicketPromise wtTicketPromise) {
        Ticket GetTicket;
        synchronized (GET_TICKET_LOCK) {
            GetTicket = GetTicket(str, j3, 4096, wtTicketPromise, null);
        }
        return GetTicket;
    }

    public int GetStViaSMSVerifyLogin(String str, long j3, long j16, int i3, WUserSigInfo wUserSigInfo) {
        util.LOGI("user:" + str + " GetStViaSMSVerifyLogin ...", str);
        return GetStWithPasswd(str, j3, i3, j16, null, false, oicq.wlogin_sdk.register.c.f422818u ? oicq.wlogin_sdk.register.c.f422820w : "", wUserSigInfo, null, true, 0);
    }

    public int GetStWithPasswd(String str, long j3, int i3, long j16, long[] jArr, boolean z16, String str2, WUserSigInfo wUserSigInfo, byte[][] bArr) {
        return GetStWithPasswd(str, j3, i3, j16, jArr, z16, str2, wUserSigInfo, bArr, false, 0);
    }

    public int GetStWithPasswdMd5(String str, long j3, long j16, int i3, String str2, WUserSigInfo wUserSigInfo) {
        return GetStWithPasswd(str, j3, i3, j16, null, true, str2, wUserSigInfo, null, false, 0);
    }

    public int GetStWithoutPasswd(String str, long j3, long j16, long j17, int i3, long j18, long[] jArr, WUserSigInfo wUserSigInfo, byte[][] bArr, byte[][] bArr2) {
        return GetStWithoutPasswd(str, j3, j16, j17, i3, j18, jArr, wUserSigInfo, bArr, bArr2, 0, null);
    }

    public Ticket GetTicket(final String str, final long j3, final int i3, final WtTicketPromise wtTicketPromise, Bundle bundle) {
        Object valueOf;
        String[] strArr;
        int i16;
        char c16;
        int i17;
        byte[] bArr;
        int i18;
        byte[] byteArray;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GetTicket ");
        sb5.append(str);
        sb5.append(", ");
        sb5.append(j3);
        sb5.append(" sig ");
        sb5.append(Integer.toHexString(i3));
        sb5.append(" ");
        if (bundle == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bundle.size());
        }
        sb5.append(valueOf);
        util.LOGI(sb5.toString(), "");
        if (bundle != null && i3 == 1048576) {
            strArr = bundle.getStringArray("domains");
        } else {
            strArr = null;
        }
        char c17 = 2;
        int i19 = 2;
        while (true) {
            WUserSigInfo GetLocalSig = GetLocalSig(str, j3);
            if (GetLocalSig == null) {
                i16 = 1;
                if (i19 == 1) {
                    break;
                }
                c16 = c17;
                i17 = i19;
                RefreshMemorySig();
            } else {
                Ticket GetUserSigInfoTicket = GetUserSigInfoTicket(GetLocalSig, i3);
                if (GetUserSigInfoTicket != null && (bArr = GetUserSigInfoTicket._sig) != null && bArr.length != 0) {
                    long e16 = u.e();
                    int i26 = i19;
                    i16 = 1;
                    int isPskeyExpired = isPskeyExpired(i3, strArr, GetUserSigInfoTicket, e16, i26);
                    if (isPskeyExpired == 1) {
                        break;
                    }
                    c16 = 2;
                    if (isPskeyExpired == 2) {
                        i17 = i26;
                    } else {
                        i17 = i26;
                        if (isPskeyExpired == 3) {
                            return GetUserSigInfoTicket;
                        }
                        util.LOGI("GetTicket sigType:0x" + Integer.toHexString(i3) + " expires in " + (((GetUserSigInfoTicket._expire_time - e16) / 60) / 60) + tl.h.F, "");
                        if (i3 == 4096) {
                            if (true != Ticket.isSkeyExpired(GetUserSigInfoTicket._expire_time)) {
                                return GetUserSigInfoTicket;
                            }
                            if (i17 == 1) {
                                break;
                            }
                            RefreshMemorySig();
                        } else {
                            if (e16 < GetUserSigInfoTicket._expire_time) {
                                return GetUserSigInfoTicket;
                            }
                            if (i17 == 1) {
                                break;
                            }
                            RefreshMemorySig();
                        }
                    }
                } else {
                    i16 = 1;
                    c16 = c17;
                    i17 = i19;
                    if (i17 == 1) {
                        break;
                    }
                    RefreshMemorySig();
                }
            }
            i19 = i17 - 1;
            if (i19 <= 0) {
                break;
            }
            c17 = c16;
        }
        if (IsNeedLoginWithPasswd(str, j3).booleanValue()) {
            ErrMsg errMsg = new ErrMsg();
            errMsg.setType(-1004);
            if (wtTicketPromise != null) {
                wtTicketPromise.Failed(errMsg);
            }
        } else {
            WUserSigInfo wUserSigInfo = new WUserSigInfo();
            if (bundle != null) {
                i18 = bundle.getInt("subappid", i16);
            } else {
                i18 = i16;
            }
            if (strArr != null) {
                int min = Math.min(20, strArr.length);
                for (int i27 = 0; i27 < min; i27++) {
                    String str2 = strArr[i27];
                    if (str2 != null && str2.length() > 0) {
                        wUserSigInfo._domains.add(str2);
                    }
                }
            }
            if (bundle != null && (byteArray = bundle.getByteArray(AppConstants.Key.KEY_CONNECT_DATA)) != null) {
                setExtraLoginTlvValue(wUserSigInfo, 1346, byteArray);
            }
            GetStWithoutPasswd(str, j3, j3, i18, i3, wUserSigInfo, new WtTicketPromise() { // from class: oicq.wlogin_sdk.request.WtloginHelper.2
                @Override // oicq.wlogin_sdk.request.WtTicketPromise
                public void Done(Ticket ticket) {
                    Ticket GetLocalTicket = WtloginHelper.this.GetLocalTicket(str, j3, i3);
                    WtTicketPromise wtTicketPromise2 = wtTicketPromise;
                    if (wtTicketPromise2 != null) {
                        wtTicketPromise2.Done(GetLocalTicket);
                    }
                }

                @Override // oicq.wlogin_sdk.request.WtTicketPromise
                public void Failed(ErrMsg errMsg2) {
                    WtTicketPromise wtTicketPromise2 = wtTicketPromise;
                    if (wtTicketPromise2 != null) {
                        wtTicketPromise2.Failed(errMsg2);
                    }
                }

                @Override // oicq.wlogin_sdk.request.WtTicketPromise
                public void Timeout(ErrMsg errMsg2) {
                    WtTicketPromise wtTicketPromise2 = wtTicketPromise;
                    if (wtTicketPromise2 != null) {
                        wtTicketPromise2.Timeout(errMsg2);
                    }
                }
            });
        }
        util.LOGI("get null for sigType:0x" + Integer.toHexString(i3), str);
        return null;
    }

    public long GetTimeDifference() {
        return u.f422925b0;
    }

    public Boolean IsNeedLoginWithPasswd(String str, long j3) {
        boolean z16;
        long parseLong;
        int i3;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        if (str == null) {
            return Boolean.TRUE;
        }
        synchronized (this) {
            z16 = true;
            if (!util.check_uin_account(str).booleanValue()) {
                parseLong = this.mG.b(str);
                if (parseLong == 0) {
                    i3 = 1;
                }
            } else {
                parseLong = Long.parseLong(str);
            }
            WloginSigInfo d16 = this.mG.d(parseLong, j3);
            if (d16 != null && (bArr2 = d16._en_A1) != null && bArr2.length != 0 && (bArr3 = d16._noPicSig) != null && bArr3.length != 0) {
                i3 = 2;
                z16 = false;
            } else {
                if (d16 != null && (bArr = d16._TGT) != null && bArr.length != 0 && !d16.iSExpireA2(u.e())) {
                    i3 = 0;
                    z16 = false;
                }
                i3 = 3;
            }
        }
        util.LOGI("NeedLoginWithPasswd:" + z16 + " appid:" + j3 + " flag=" + i3, str);
        return Boolean.valueOf(z16);
    }

    public Boolean IsUserHaveA1(String str, long j3) {
        long parseLong;
        WloginSigInfo d16;
        byte[] bArr;
        if (str == null) {
            return Boolean.FALSE;
        }
        if (!util.check_uin_account(str).booleanValue()) {
            parseLong = this.mG.b(str);
            if (parseLong == 0) {
                d16 = null;
                if (d16 == null && (bArr = d16._en_A1) != null && bArr.length > 0) {
                    util.LOGI("userAccount:" + str + " dwAppid:" + j3 + " IsUserHaveA1 return: not null", str);
                    return Boolean.TRUE;
                }
                util.LOGI("userAccount:" + str + " dwAppid:" + j3 + " IsUserHaveA1 return: null", str);
                return Boolean.FALSE;
            }
        } else {
            parseLong = Long.parseLong(str);
        }
        d16 = this.mG.d(parseLong, j3);
        if (d16 == null) {
        }
        util.LOGI("userAccount:" + str + " dwAppid:" + j3 + " IsUserHaveA1 return: null", str);
        return Boolean.FALSE;
    }

    public boolean IsWtLoginUrl(String str) {
        int indexOf;
        int i3;
        int i16;
        if (str == null || (indexOf = str.indexOf("?k=")) == -1 || (i16 = (i3 = indexOf + 3) + 32) > str.length()) {
            return false;
        }
        String substring = str.substring(i3, i16);
        if (util.base64_decode_url(substring.getBytes(), substring.length()) == null) {
            return false;
        }
        return true;
    }

    public byte[] PickupQRCode(String str) {
        if (str == null || !str.matches(".*[?&]k=([^&$]+).*")) {
            return null;
        }
        String replaceAll = str.replaceAll(".*[?&]k=([^&$]+).*", "$1");
        return util.base64_decode_url(replaceAll.getBytes(), replaceAll.length());
    }

    public Intent PrepareQloginIntent(long j3, long j16, String str) {
        boolean isMQQExist = util.isMQQExist(this.mContext);
        String str2 = "com.tencent.minihd.qq";
        boolean isPackageExist = util.isPackageExist(this.mContext, "com.tencent.minihd.qq");
        if (!isMQQExist) {
            if (!isPackageExist) {
                return null;
            }
        } else {
            str2 = "com.tencent.mobileqq";
        }
        byte[] bArr = util.get_rsa_pubkey(this.mContext);
        if (bArr == null || bArr.length == 0) {
            bArr = util.string_to_buf(RSACrypt.DEFAULT_PUB_KEY);
        }
        Intent intent = new Intent();
        intent.setClassName(str2, QQAuth.ACTIVITY_AGENT);
        Bundle bundle = new Bundle();
        bundle.putLong("dstSsoVer", 1L);
        bundle.putLong("dstAppid", j3);
        bundle.putLong("subDstAppid", j16);
        bundle.putByteArray("dstAppVer", str.getBytes());
        bundle.putByteArray("publickey", bArr);
        intent.putExtra("key_params", bundle);
        intent.putExtra("key_action", "action_quick_login");
        return intent;
    }

    public Intent PrepareQloginResult(String str, long j3, long j16, int i3, WFastLoginInfo wFastLoginInfo) {
        Intent intent = new Intent();
        intent.putExtra("quicklogin_uin", str);
        byte[] bArr = (byte[]) wFastLoginInfo._outA1.clone();
        if (bArr.length > 0) {
            intent.putExtra("quicklogin_buff", new RSACrypt(this.mContext).EncryptData(util.get_cp_pubkey(this.mContext, j3, j16), bArr));
        }
        intent.putExtra("quicklogin_ret", i3);
        intent.putExtra("user_json", wFastLoginInfo.userJson);
        return intent;
    }

    public Intent PrepareSilenceLoginIntent(long j3, long j16, String str) {
        byte[] bArr = util.get_rsa_pubkey(this.mContext);
        if (bArr == null || bArr.length == 0) {
            bArr = util.string_to_buf(RSACrypt.DEFAULT_PUB_KEY);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putLong("dstSsoVer", 1L);
        bundle.putLong("dstAppid", j3);
        bundle.putLong("subDstAppid", j16);
        bundle.putByteArray("dstAppVer", str.getBytes());
        bundle.putByteArray("publickey", bArr);
        intent.putExtra("key_params", bundle);
        intent.putExtra("key_action", "action_quick_login");
        return intent;
    }

    public int QueryCodeResult(long j3, WUserSigInfo wUserSigInfo) {
        util.LOGI(" QueryCodeResult ...", "");
        oicq.wlogin_sdk.code2d.e eVar = new oicq.wlogin_sdk.code2d.e();
        TransReqContext transReqContext = new TransReqContext();
        transReqContext.set_code2d_func_req();
        transReqContext.set_subcmd(eVar.get_cmd());
        util.LOGI("qrsig " + util.buf_to_string(oicq.wlogin_sdk.code2d.d.f422744k));
        byte[] bArr = oicq.wlogin_sdk.code2d.d.f422744k;
        byte[] bArr2 = new byte[bArr.length + 13 + 13];
        util.int16_to_buf(bArr2, 0, 5);
        util.int8_to_buf(bArr2, 2, 1);
        util.int32_to_buf(bArr2, 3, u.f422942s0);
        util.int64_to_buf32(bArr2, 7, j3);
        int fill_staff = eVar.fill_staff(bArr2, bArr, 11);
        util.int64_to_buf(bArr2, fill_staff, 0L);
        int i3 = fill_staff + 8;
        util.int8_to_buf(bArr2, i3, 8);
        eVar.fill_staff(bArr2, new byte[0], i3 + 1);
        transReqContext._body = eVar.get_request(0L, true, bArr2);
        return RequestTransport(0, 1, null, j3, eVar._role, transReqContext, wUserSigInfo);
    }

    public void RefreshMemorySig() {
        this.mG.i();
    }

    public int RefreshPictureData(String str, WUserSigInfo wUserSigInfo) {
        if (wUserSigInfo == null) {
            wUserSigInfo = new WUserSigInfo();
        }
        return RefreshPictureData(str, wUserSigInfo, 0);
    }

    public int RefreshSMSData(String str, long j3, WUserSigInfo wUserSigInfo, byte[] bArr) {
        if (wUserSigInfo == null) {
            wUserSigInfo = new WUserSigInfo();
        }
        return RefreshSMSData(str, j3, wUserSigInfo, bArr, 0);
    }

    public int RefreshSMSVerifyLoginCode(String str, WUserSigInfo wUserSigInfo) {
        return RefreshSMSVerifyLoginCode(str, wUserSigInfo, 0);
    }

    public int RegGetAccount(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i3, WUserSigInfo wUserSigInfo) {
        return RegGetAccount(bArr, bArr2, bArr3, bArr4, bArr5, null, i3, wUserSigInfo);
    }

    public int RegGetSMSVerifyLoginAccount(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, WUserSigInfo wUserSigInfo) {
        util.LOGI("RegGetSMSVerifyLoginAccount ...", "");
        oicq.wlogin_sdk.register.b bVar = new oicq.wlogin_sdk.register.b();
        TransReqContext transReqContext = new TransReqContext();
        oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
        if (bArr != null) {
            cVar.f422826f = (byte[]) bArr.clone();
        } else {
            cVar.f422826f = new byte[0];
        }
        oicq.wlogin_sdk.register.c.f422818u = true;
        oicq.wlogin_sdk.register.c.f422820w = util.get_mpasswd();
        transReqContext.set_register_req();
        transReqContext.set_subcmd(bVar.f422816a);
        transReqContext._body = bVar.a(cVar.f422823c, bArr, oicq.wlogin_sdk.register.c.f422820w.getBytes(), bArr3, 1, cVar.f422821a.getBytes(), bArr2, true, GetGuid(), cVar.f422825e, u.G, bArr4, u.C, null, wUserSigInfo.extraRegTLVMap);
        return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
    }

    public int RegQueryAccount(int i3, byte[] bArr, long j3, WUserSigInfo wUserSigInfo) {
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = new byte[0];
        } else {
            bArr2 = bArr;
        }
        util.LOGI("RegQueryAccount ...", "");
        oicq.wlogin_sdk.register.c cVar = new oicq.wlogin_sdk.register.c();
        this.mRegStatus = cVar;
        cVar.f422821a = new String(bArr2);
        TransReqContext transReqContext = new TransReqContext();
        transReqContext.set_register_req();
        transReqContext.set_subcmd(7);
        int length = bArr2.length + 2 + 4;
        byte[] bArr3 = new byte[length];
        util.int8_to_buf(bArr3, 0, i3);
        util.int8_to_buf(bArr3, 1, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, 2, bArr2.length);
        util.int64_to_buf32(bArr3, bArr2.length + 2, j3);
        byte[] bArr4 = new tlv_t544().get_tlv_544("", "812_7", bArr3);
        int length2 = bArr4.length + length;
        byte[] bArr5 = new byte[length2];
        System.arraycopy(bArr3, 0, bArr5, 0, length);
        System.arraycopy(bArr4, 0, bArr5, length, bArr4.length);
        byte[] bArr6 = new byte[length2 + 13];
        util.int8_to_buf(bArr6, 0, 2);
        util.int16_to_buf(bArr6, 1, length2 + 11 + 2);
        util.int16_to_buf(bArr6, 3, 3);
        util.int16_to_buf(bArr6, 5, 7);
        util.int8_to_buf(bArr6, 7, 4);
        util.int32_to_buf(bArr6, 8, 0);
        System.arraycopy(bArr5, 0, bArr6, 12, length2);
        util.int8_to_buf(bArr6, length2 + 12, 3);
        transReqContext._body = bArr6;
        return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
    }

    public int RegQueryClientSentMsgStatus(WUserSigInfo wUserSigInfo) {
        util.LOGI("RegQueryClientSentMsgStatus ...", "");
        TransReqContext transReqContext = new TransReqContext();
        oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(3);
        byte[] bArr = cVar.f422823c;
        byte[] bArr2 = this.mRegStatus.f422831k;
        int length = bArr.length + 1;
        byte[] bArr3 = new byte[length];
        util.int8_to_buf(bArr3, 0, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        byte[] encrypt = cryptor.encrypt(bArr3, 0, length, MD5.toMD5Byte(bArr2));
        int length2 = bArr.length + 1 + 2 + encrypt.length;
        byte[] bArr4 = new byte[length2];
        util.int8_to_buf(bArr4, 0, bArr.length);
        System.arraycopy(bArr, 0, bArr4, 1, bArr.length);
        int length3 = bArr.length + 1;
        util.int16_to_buf(bArr4, length3, encrypt.length);
        System.arraycopy(encrypt, 0, bArr4, length3 + 2, encrypt.length);
        byte[] bArr5 = new byte[length2 + 13];
        util.int8_to_buf(bArr5, 0, 2);
        util.int16_to_buf(bArr5, 1, length2 + 11 + 2);
        util.int16_to_buf(bArr5, 3, 3);
        util.int16_to_buf(bArr5, 5, 3);
        util.int8_to_buf(bArr5, 7, 4);
        util.int32_to_buf(bArr5, 8, 0);
        System.arraycopy(bArr4, 0, bArr5, 12, length2);
        util.int8_to_buf(bArr5, length2 + 12, 3);
        transReqContext._body = bArr5;
        byte[] bArr6 = cVar.f422823c;
        if (bArr6 == null || bArr6.length == 0) {
            oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_TOKEN_LOST, "0x3", ""));
        }
        return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
    }

    public int RegRequestServerResendMsg(WUserSigInfo wUserSigInfo) {
        util.LOGI("RegRequestServerResendMsg ...", "");
        TransReqContext transReqContext = new TransReqContext();
        oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(4);
        byte[] bArr = cVar.f422823c;
        int length = bArr.length + 1;
        byte[] bArr2 = new byte[length];
        util.int8_to_buf(bArr2, 0, bArr.length);
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        byte[] bArr3 = new byte[length + 13];
        util.int8_to_buf(bArr3, 0, 2);
        util.int16_to_buf(bArr3, 1, length + 11 + 2);
        util.int16_to_buf(bArr3, 3, 3);
        util.int16_to_buf(bArr3, 5, 4);
        util.int8_to_buf(bArr3, 7, 4);
        util.int32_to_buf(bArr3, 8, 0);
        System.arraycopy(bArr2, 0, bArr3, 12, length);
        util.int8_to_buf(bArr3, length + 12, 3);
        transReqContext._body = bArr3;
        return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
    }

    public int RegSubmitMobile(String str, byte[] bArr, byte[] bArr2, int i3, int i16, int i17, long j3, long j16, WUserSigInfo wUserSigInfo, Map<String, Object> map) {
        return RegSubmitMobile(str == null ? new byte[0] : str.getBytes(), bArr, null, bArr2, i3, i16, i17, j3, j16, wUserSigInfo, map);
    }

    public int RegSubmitMsgChk(byte[] bArr, WUserSigInfo wUserSigInfo) {
        if (bArr == null) {
            return -1017;
        }
        util.LOGI("RegSubmitMsgChk ...", "");
        TransReqContext transReqContext = new TransReqContext();
        oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(5);
        byte[] bArr2 = cVar.f422823c;
        int length = bArr2.length + 1;
        byte[] bArr3 = new byte[length];
        util.int8_to_buf(bArr3, 0, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, 1, bArr2.length);
        byte[] encrypt = cryptor.encrypt(bArr3, 0, length, MD5.toMD5Byte(bArr));
        int length2 = bArr2.length + 1 + 2 + encrypt.length;
        byte[] bArr4 = new byte[length2];
        util.int8_to_buf(bArr4, 0, bArr2.length);
        System.arraycopy(bArr2, 0, bArr4, 1, bArr2.length);
        int length3 = bArr2.length + 1;
        util.int16_to_buf(bArr4, length3, encrypt.length);
        System.arraycopy(encrypt, 0, bArr4, length3 + 2, encrypt.length);
        byte[] bArr5 = new tlv_t544().get_tlv_544("", "812_5", bArr4);
        int length4 = bArr5.length + length2;
        byte[] bArr6 = new byte[length4];
        System.arraycopy(bArr4, 0, bArr6, 0, length2);
        System.arraycopy(bArr5, 0, bArr6, length2, bArr5.length);
        byte[] bArr7 = new byte[length4 + 13];
        util.int8_to_buf(bArr7, 0, 2);
        util.int16_to_buf(bArr7, 1, length4 + 11 + 2);
        util.int16_to_buf(bArr7, 3, 3);
        util.int16_to_buf(bArr7, 5, 5);
        util.int8_to_buf(bArr7, 7, 4);
        util.int32_to_buf(bArr7, 8, 0);
        System.arraycopy(bArr6, 0, bArr7, 12, length4);
        util.int8_to_buf(bArr7, length4 + 12, 3);
        transReqContext._body = bArr7;
        byte[] bArr8 = cVar.f422823c;
        if (bArr8 == null || bArr8.length == 0) {
            oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_TOKEN_LOST, "0x5", ""));
        }
        return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
    }

    public int RequestTransport(int i3, int i16, String str, long j3, long j16, TransReqContext transReqContext, WUserSigInfo wUserSigInfo) {
        String str2;
        String str3;
        d0 d0Var;
        byte[] bArr;
        byte[] bArr2;
        long j17;
        TransReqContext transReqContext2;
        long j18;
        long j19;
        int i17;
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, i16, str, j3, j16, transReqContext, wUserSigInfo, "RequestTransport").RunReq(9);
            return -1001;
        }
        u a16 = this.mG.a(0L);
        util.LOGI("encrypt:" + i16 + " appid:" + j3 + " role:" + j16 + " Seq:" + a16.f422959f + "subcmd=" + transReqContext._subcmd + " RequestTransport...", str);
        a16.f422958e = str;
        if (i16 == 0) {
            str2 = " Seq:";
            str3 = " role:";
            a16.f422957d = 0L;
            d0Var = new d0(a16);
            bArr = null;
            bArr2 = null;
            j17 = a16.f422957d;
            transReqContext2 = transReqContext;
            j18 = j3;
            j19 = j16;
        } else {
            if (str != null) {
                str2 = " Seq:";
                str3 = " role:";
                WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
                if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
                    i17 = -1003;
                } else {
                    WloginSigInfo d16 = a16.d(wloginSimpleInfo._uin, j3);
                    if (d16 == null) {
                        i17 = -1004;
                    } else {
                        a16.f422957d = wloginSimpleInfo._uin;
                        i17 = new d0(a16).a(wloginSimpleInfo._uin, transReqContext, d16._userStSig, d16._userSt_Key, j3, j16, wUserSigInfo);
                    }
                }
                a16.c();
                util.LOGI("encrypt:" + i16 + " appid:" + j3 + str3 + j16 + str2 + a16.f422959f + "subcmd=" + transReqContext._subcmd + " RequestTransport ret=" + i17, str);
                return i17;
            }
            a16.f422964k = 0;
            bArr = null;
            bArr2 = null;
            str2 = " Seq:";
            d0Var = new d0(a16);
            str3 = " role:";
            j17 = 0;
            transReqContext2 = transReqContext;
            j18 = j3;
            j19 = j16;
        }
        i17 = d0Var.a(j17, transReqContext2, bArr, bArr2, j18, j19, wUserSigInfo);
        a16.c();
        util.LOGI("encrypt:" + i16 + " appid:" + j3 + str3 + j16 + str2 + a16.f422959f + "subcmd=" + transReqContext._subcmd + " RequestTransport ret=" + i17, str);
        return i17;
    }

    public int RequestTransportMsf(int i3, int i16, String str, long j3, long j16, TransReqContext transReqContext) {
        String str2;
        String str3;
        String str4;
        int a16;
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, i16, str, j3, j16, transReqContext, "RequestTransportMsf").RunReq(10);
            return -1001;
        }
        u a17 = this.mG.a(0L);
        util.LOGI("user:" + str + " encrypt:" + i16 + " appid:" + j3 + " role:" + j16 + " Seq:" + a17.f422959f + " RequestTransportMsf...", str);
        a17.f422958e = str;
        if (i16 == 0) {
            str2 = " Seq:";
            str3 = " appid:";
            str4 = " role:";
            if (util.check_uin_account(str).booleanValue() && Long.parseLong(str) == 0) {
                a17.f422957d = 0L;
                a16 = new d0(a17).a(0L, transReqContext, (byte[]) null, (byte[]) null, new byte[0], j3, j16, new WUserSigInfo());
            } else {
                WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
                if (str != null && GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
                    WloginSigInfo d16 = a17.d(wloginSimpleInfo._uin, j3);
                    if (d16 != null) {
                        a17.f422957d = wloginSimpleInfo._uin;
                        a16 = new d0(a17).a(wloginSimpleInfo._uin, transReqContext, (byte[]) null, (byte[]) null, d16._TGT, j3, j16, new WUserSigInfo());
                    }
                    a16 = -1004;
                }
                a16 = -1003;
            }
        } else {
            WloginSimpleInfo wloginSimpleInfo2 = new WloginSimpleInfo();
            if (str == null || !GetBasicUserInfo(str, wloginSimpleInfo2).booleanValue()) {
                str2 = " Seq:";
                str3 = " appid:";
                str4 = " role:";
                a16 = -1003;
            } else {
                WloginSigInfo d17 = a17.d(wloginSimpleInfo2._uin, j3);
                if (d17 == null) {
                    str2 = " Seq:";
                    str3 = " appid:";
                    str4 = " role:";
                    a16 = -1004;
                } else {
                    a17.f422957d = wloginSimpleInfo2._uin;
                    str2 = " Seq:";
                    str3 = " appid:";
                    str4 = " role:";
                    a16 = new d0(a17).a(wloginSimpleInfo2._uin, transReqContext, d17._userStSig, d17._userSt_Key, d17._TGT, j3, j16, new WUserSigInfo());
                }
            }
        }
        a17.c();
        util.LOGI("user:" + str + " encrypt:" + i16 + str3 + j3 + str4 + j16 + str2 + a17.f422959f + " RequestTransportMsf ret=" + a16, str);
        return a16;
    }

    public WUserSigInfo ResolveQloginIntentReserved(Intent intent) {
        String str;
        if (intent == null) {
            return null;
        }
        if (intent.getExtras().getInt("quicklogin_ret") != 0) {
            str = "ResolveQloginIntentReserved quicklogin_ret is null";
        } else {
            String string = intent.getExtras().getString("quicklogin_uin");
            byte[] byteArray = intent.getExtras().getByteArray("quicklogin_buff");
            if (string != null && byteArray != null) {
                WUserSigInfo wUserSigInfo = new WUserSigInfo();
                byte[] DecryptData = new RSACrypt(this.mContext).DecryptData(null, byteArray);
                wUserSigInfo._fastLoginBuf = DecryptData;
                if (DecryptData == null) {
                    str = "rsa decrypt failed";
                } else {
                    wUserSigInfo.uin = string;
                    return wUserSigInfo;
                }
            } else {
                str = "ResolveQloginIntentReserved uin or buff is null";
            }
        }
        util.LOGI(str, "");
        return null;
    }

    public void SetAppClientVersion(int i3) {
        u.f422953z = i3;
    }

    public void SetCanWebVerify(int i3) {
        j.f422896v = i3;
        util.LOGI("SetCanWebVerify old:" + j.f422896v + " canWebVerify:" + i3, "");
    }

    public void SetDevlockMobileType(int i3) {
        r.f422923v = i3;
    }

    public void SetImgType(int i3) {
        u.A = i3;
        this.mMiscBitmap |= 128;
    }

    public WtloginListener SetListener(WtloginListener wtloginListener) {
        WtloginListener wtloginListener2 = this.mListener;
        this.mListener = wtloginListener;
        return wtloginListener2;
    }

    public void SetLocalId(int i3) {
        u.f422951x = i3;
    }

    public void SetMsfTransportFlag(int i3) {
        u uVar = this.mG;
        uVar.f422962i = i3;
        if (i3 != 0) {
            u.f422927d0 = new byte[4];
            u.f422926c0 = 0L;
            uVar.f422963j = HttpOp.HTTP_READTIMEOUT;
        }
    }

    public int SetNeedForPayToken(String str, String str2, byte[] bArr) {
        if (str != null && str.length() > 0) {
            j.f422897w = str.getBytes();
            if (bArr != null) {
                j.f422899y = bArr;
            }
            if (str2 == null || str2.length() == 0) {
                str2 = util.getChannelId(this.mContext, null);
            }
            j.f422898x = str2.getBytes();
            if (str2.length() == 0) {
                return -2;
            }
            return 0;
        }
        return -1;
    }

    public void SetPicType(int i3) {
        u.B = i3;
    }

    public void SetRegDevLockFlag(int i3) {
        u.C = i3;
    }

    public void SetSigMap(int i3) {
        this.mMainSigMap = i3 | 192;
    }

    public void SetTestHost(int i3, String str) {
        oicq_request.f422902s = i3;
        oicq_request.f422903t = str;
    }

    public void SetTimeOut(int i3) {
        this.mG.f422963j = i3;
    }

    public void SetUinDeviceToken(boolean z16) {
        u.Z = z16;
    }

    public int VerifyCode(String str, long j3, boolean z16, byte[] bArr, int[] iArr, int i3, byte[] bArr2, WUserSigInfo wUserSigInfo) {
        byte[] bArr3;
        int[] iArr2;
        byte[] bArr4;
        int length;
        int length2;
        int i16;
        int i17;
        byte[] bArr5;
        byte[] bArr6;
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return -1003;
        }
        long j16 = wloginSimpleInfo._uin;
        WloginSigInfo FindUserSig = FindUserSig(j16, j3);
        if (FindUserSig == null) {
            return -1004;
        }
        tlv_t400 tlv_t400Var = new tlv_t400();
        byte[] bArr7 = new byte[0];
        byte[] bArr8 = FindUserSig._G;
        if (bArr8 != null && bArr8.length > 0 && (bArr5 = FindUserSig._dpwd) != null && bArr5.length > 0 && (bArr6 = FindUserSig._randseed) != null && bArr6.length > 0) {
            tlv_t400Var.get_tlv_400(bArr8, j16, u.D, bArr5, j3, 1L, bArr6);
            bArr7 = tlv_t400Var.get_data();
        }
        util.LOGI("user:" + str + " VerifyCode ...", str);
        oicq.wlogin_sdk.code2d.f fVar = new oicq.wlogin_sdk.code2d.f();
        TransReqContext transReqContext = new TransReqContext();
        transReqContext.set_code2d_func_req();
        transReqContext.set_subcmd(fVar.get_cmd());
        transReqContext.setSTEncryptMethod();
        transReqContext.setWtST(FindUserSig);
        byte[] bArr9 = FindUserSig._TGT;
        byte[] bArr10 = u.D;
        byte[] bArr11 = u.G;
        if (bArr == null) {
            bArr3 = new byte[0];
        } else {
            bArr3 = bArr;
        }
        if (iArr == null) {
            iArr2 = new int[0];
        } else {
            iArr2 = iArr;
        }
        if (bArr9 == null) {
            bArr9 = new byte[0];
        }
        if (bArr10 == null) {
            bArr10 = new byte[0];
        }
        if (bArr11 == null) {
            bArr11 = new byte[0];
        }
        if (bArr7 == null) {
            bArr7 = new byte[0];
        }
        if (bArr2 == null) {
            bArr4 = new byte[0];
        } else {
            bArr4 = bArr2;
        }
        util.LOGI("extraDeviceInfo length = " + bArr4.length, "");
        if (bArr7.length > 0) {
            length = bArr3.length + 16 + 2 + bArr9.length + 16 + 1 + 2 + 1 + 2 + (iArr2.length * 2) + 2 + 4 + bArr11.length + 4 + 4 + 4 + bArr4.length + 4;
            length2 = bArr7.length;
        } else {
            length = bArr3.length + 16 + 2 + bArr9.length + 16 + 1 + 2 + 1 + 2 + (iArr2.length * 2) + 2 + 4 + bArr11.length + 4 + 4 + 4;
            length2 = bArr4.length;
        }
        byte[] bArr12 = new byte[length + length2];
        util.int64_to_buf32(bArr12, 2, j3);
        util.int64_to_buf(bArr12, 6, j16);
        util.int16_to_buf(bArr12, 14, bArr3.length);
        System.arraycopy(bArr3, 0, bArr12, 16, bArr3.length);
        int length3 = bArr3.length + 16;
        util.int16_to_buf(bArr12, length3, bArr9.length);
        int i18 = length3 + 2;
        System.arraycopy(bArr9, 0, bArr12, i18, bArr9.length);
        int length4 = i18 + bArr9.length;
        if (bArr10.length == 16) {
            System.arraycopy(bArr10, 0, bArr12, length4, 16);
        }
        int i19 = length4 + 16;
        util.int8_to_buf(bArr12, i19, 1);
        int i26 = i19 + 1;
        util.int16_to_buf(bArr12, i26, i3);
        int i27 = i26 + 2;
        util.int8_to_buf(bArr12, i27, 8);
        int i28 = i27 + 1;
        util.int16_to_buf(bArr12, i28, iArr2.length);
        int i29 = i28 + 2;
        for (int i36 : iArr2) {
            util.int16_to_buf(bArr12, i29, i36);
            i29 += 2;
        }
        if (bArr7.length > 0) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        util.int16_to_buf(bArr12, i29, i16 + 1 + 1);
        int i37 = i29 + 2;
        util.int16_to_buf(bArr12, i37, 9);
        int i38 = i37 + 2;
        util.int16_to_buf(bArr12, i38, bArr11.length);
        int i39 = i38 + 2;
        System.arraycopy(bArr11, 0, bArr12, i39, bArr11.length);
        int length5 = i39 + bArr11.length;
        util.int16_to_buf(bArr12, length5, 300);
        int i46 = length5 + 2;
        util.int16_to_buf(bArr12, i46, bArr4.length);
        int i47 = i46 + 2;
        System.arraycopy(bArr4, 0, bArr12, i47, bArr4.length);
        int length6 = i47 + bArr4.length;
        if (bArr7.length > 0) {
            util.int16_to_buf(bArr12, length6, 12);
            int i48 = length6 + 2;
            util.int16_to_buf(bArr12, i48, bArr7.length);
            i17 = 2;
            int i49 = i48 + 2;
            System.arraycopy(bArr7, 0, bArr12, i49, bArr7.length);
            length6 = i49 + bArr7.length;
        } else {
            i17 = 2;
        }
        util.int16_to_buf(bArr12, length6, 57);
        int i56 = length6 + i17;
        util.int16_to_buf(bArr12, i56, 4);
        util.int32_to_buf(bArr12, i56 + i17, 1);
        transReqContext._body = fVar.get_request(j16, z16, bArr12);
        return RequestTransport(0, 1, str, j3, fVar._role, transReqContext, wUserSigInfo);
    }

    public int VerifySMSVerifyLoginCode(String str, String str2, WUserSigInfo wUserSigInfo) {
        return VerifySMSVerifyLoginCode(str, str2, wUserSigInfo, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.StringBuilder] */
    public int addWTLoginRecordFromNT(WTLoginRecordSnapshot wTLoginRecordSnapshot) {
        ?? r06;
        if (wTLoginRecordSnapshot == null) {
            return 0;
        }
        util.LOGI("addWTLoginRecordFromNT " + wTLoginRecordSnapshot, "");
        RefreshMemorySig();
        synchronized (this) {
            String str = wTLoginRecordSnapshot.account;
            long j3 = wTLoginRecordSnapshot.uin;
            int i3 = wTLoginRecordSnapshot.appid;
            if (!TextUtils.isEmpty(str) && j3 != 0) {
                this.mG.a(str, Long.valueOf(j3));
            }
            long j16 = i3;
            boolean booleanValue = IsNeedLoginWithPasswd(String.valueOf(j3), j16).booleanValue();
            WloginSigInfo d16 = this.mG.d(j3, j16);
            r06 = booleanValue;
            if (d16 != null) {
                byte[] bArr = d16._TGT;
                r06 = booleanValue;
                if (bArr != null) {
                    r06 = booleanValue;
                    if (checkNTSigFlag(this.mContext, j3, i3, bArr)) {
                        r06 = 2;
                    }
                }
            }
            if (r06 != 0) {
                this.mG.a(wTLoginRecordSnapshot);
                RefreshMemorySig();
                if (isSaveSuccess(j3, i3, wTLoginRecordSnapshot)) {
                    saveNTSigFlag(this.mContext, j3, i3, wTLoginRecordSnapshot.f422865a2);
                } else {
                    r06 = 3;
                }
            }
            util.LOGI("addWTLoginRecordFromNT result = " + r06, "");
        }
        return r06;
    }

    public int cancelCode(String str, long j3, byte[] bArr, byte[] bArr2, WUserSigInfo wUserSigInfo) {
        byte[] bArr3;
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        if (!GetBasicUserInfo(str, wloginSimpleInfo).booleanValue()) {
            return -1003;
        }
        long j16 = wloginSimpleInfo._uin;
        this.mG.i();
        WloginSigInfo FindUserSig = FindUserSig(j16, j3);
        if (FindUserSig == null) {
            return -1004;
        }
        util.LOGI("user:" + str + " CancelCode ...", str);
        oicq.wlogin_sdk.code2d.a aVar = new oicq.wlogin_sdk.code2d.a();
        TransReqContext transReqContext = new TransReqContext();
        transReqContext.set_code2d_func_req();
        transReqContext.set_subcmd(aVar.get_cmd());
        transReqContext.setSTEncryptMethod();
        transReqContext.setWtST(FindUserSig);
        byte[] bArr4 = FindUserSig._TGT;
        if (bArr4 == null) {
            bArr4 = new byte[0];
        }
        if (bArr2 == null) {
            bArr3 = new byte[0];
        } else {
            bArr3 = bArr2;
        }
        byte[] bArr5 = new byte[bArr.length + 8 + 8 + 1 + 2 + bArr4.length + 2 + 2 + 4 + bArr3.length];
        util.int64_to_buf32(bArr5, 2, j3);
        util.int16_to_buf(bArr5, 6, bArr.length);
        System.arraycopy(bArr, 0, bArr5, 8, bArr.length);
        int length = bArr.length + 8;
        util.int64_to_buf(bArr5, length, j16);
        int i3 = length + 8;
        util.int8_to_buf(bArr5, i3, 8);
        int i16 = i3 + 1;
        util.int16_to_buf(bArr5, i16, bArr4.length);
        int i17 = i16 + 2;
        System.arraycopy(bArr4, 0, bArr5, i17, bArr4.length);
        int length2 = i17 + bArr4.length;
        util.int16_to_buf(bArr5, length2, 0);
        int i18 = length2 + 2;
        util.int16_to_buf(bArr5, i18, 1);
        int i19 = i18 + 2;
        util.int16_to_buf(bArr5, i19, 300);
        int i26 = i19 + 2;
        util.int16_to_buf(bArr5, i26, bArr3.length);
        System.arraycopy(bArr3, 0, bArr5, i26 + 2, bArr3.length);
        transReqContext._body = aVar.get_request(j16, true, bArr5);
        return RequestTransport(0, 1, str, j3, aVar._role, transReqContext, wUserSigInfo);
    }

    public int checkSMSAndGetStForGateWay(u uVar, async_context async_contextVar, String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[] bArr2) {
        StringBuilder sb5 = new StringBuilder("checkSMSAndGetStForGateWay");
        sb5.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
        sb5.append(",seq=");
        sb5.append(uVar.f422959f);
        sb5.append(",_mpasswd=");
        sb5.append(async_contextVar._mpasswd);
        sb5.append(",_msalt=");
        sb5.append(Long.toHexString(async_contextVar._msalt));
        sb5.append(",_appid=");
        sb5.append(async_contextVar._appid);
        sb5.append(",_sub_appid=");
        sb5.append(async_contextVar._sappid);
        sb5.append(",_sappid=");
        sb5.append(async_contextVar._sub_appid);
        sb5.append(",dwMainSigMap=");
        sb5.append(async_contextVar._main_sigmap);
        uVar.f422957d = 0L;
        wUserSigInfo.uin = "";
        o oVar = new o(uVar);
        oVar.f422901v = 2;
        int a16 = oVar.a(bArr, this.mMiscBitmap, this.mSubSigMap, async_contextVar._sub_appid_list, wUserSigInfo, bArr2);
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x7", String.valueOf(a16));
        aVar.f422861g.put("isGateway", "1");
        oicq.wlogin_sdk.report.c.b.a(aVar, 100);
        if (async_contextVar.get_t104() == null || async_contextVar.get_t104().get_data_len() == 0) {
            oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_TOKEN_LOST, "0x7", String.valueOf(a16)));
        }
        if (a16 != 0) {
            sb5.append("\uff0crequest_checksms fail ret = ");
            sb5.append(a16);
        } else {
            long j3 = async_contextVar._sappid;
            int i3 = async_contextVar._main_sigmap;
            sb5.append("\uff0c_ui=");
            sb5.append(uVar.f422957d);
            wUserSigInfo.uin = String.valueOf(uVar.f422957d);
            a16 = getTicketByGateway(j3, j3, i3, wUserSigInfo, sb5, uVar, async_contextVar);
        }
        util.LOGI(sb5.toString(), "");
        return a16;
    }

    public void clearAllSigAndUpdateGuid() {
        try {
            oicq.wlogin_sdk.utils.a.c(this.mContext);
            byte[] generateGuid = util.generateGuid(this.mContext);
            if (!Arrays.equals(generateGuid, util.getGuidFromFile(this.mContext))) {
                c.a(this.mContext, (TreeMap) null, "tk_file", generateGuid);
                c.a(this.mContext, (TreeMap) null, "name_file", generateGuid);
                util.saveGuidToFile(this.mContext, generateGuid);
                u.D = (byte[]) generateGuid.clone();
                u.E = (byte[]) generateGuid.clone();
                util.buf_to_string(generateGuid, generateGuid.length);
            }
        } catch (Exception e16) {
            util.printException(e16);
        }
    }

    public void clear_a1(long j3, int i3) {
        WloginSigInfo wloginSigInfo;
        util.LOGI("clear_a1 " + i3, "" + j3);
        long j16 = (long) i3;
        this.mG.getClass();
        c cVar = u.f422934k0;
        synchronized (cVar) {
            WloginAllSigInfo wloginAllSigInfo = cVar.f422876b.get(Long.valueOf(j3));
            if (wloginAllSigInfo != null && (wloginSigInfo = wloginAllSigInfo._tk_map.get(Long.valueOf(j16))) != null) {
                wloginSigInfo._en_A1 = new byte[0];
                wloginSigInfo._noPicSig = new byte[0];
                wloginAllSigInfo._tk_map.put(Long.valueOf(j3), wloginSigInfo);
                if (cVar.f422875a != null) {
                    synchronized (c.f422871e) {
                        TreeMap<Long, WloginAllSigInfo> a16 = c.a(cVar.f422875a, "tk_file", j3);
                        if (a16 != null) {
                            a16.put(Long.valueOf(j3), wloginAllSigInfo);
                            cVar.a(a16, "tk_file");
                            cVar.f422876b = a16;
                        }
                    }
                }
            }
        }
    }

    public byte[] getA1(long j3, long j16, byte[] bArr) {
        String str;
        String str2;
        RefreshMemorySig();
        WloginSigInfo FindUserSig = FindUserSig(j3, j16);
        if (FindUserSig == null) {
            str = j3 + "";
            str2 = "getA1 sigInfo is null";
        } else {
            byte[] bArr2 = FindUserSig._en_A1;
            if (bArr2 != null && bArr2.length != 0) {
                byte[] bArr3 = FindUserSig._noPicSig;
                if (bArr3 != null && bArr3.length != 0) {
                    int length = bArr2.length - 16;
                    byte[] bArr4 = new byte[length];
                    System.arraycopy(bArr2, 0, bArr4, 0, length);
                    return bArr4;
                }
                str = j3 + "";
                str2 = "getA1 noPicSig is null";
            } else {
                str = j3 + "";
                str2 = "getA1 A1 is null";
            }
        }
        util.LOGI(str2, str);
        return new byte[0];
    }

    public boolean getHasPassword(long j3) {
        UinInfo a16;
        String d16 = this.mG.d(j3);
        util.LOGI("getHasPasswd ..." + String.valueOf(d16), "" + j3);
        if (d16 == null) {
            return true;
        }
        synchronized (this.mG) {
            a16 = u.f422934k0.a(d16, false);
        }
        if (a16 == null) {
            return true;
        }
        boolean hasPassword = a16.getHasPassword();
        util.LOGI("getHasPasswd userAccount: " + d16 + ", uin: " + j3 + " hasPasswd: " + hasPassword, "");
        return hasPassword;
    }

    public void getPskeyIgnoreCache(String str, long j3, String[] strArr, WtTicketPromise wtTicketPromise) {
        util.LOGI("getPskeyIgnoreLocalCache appid " + j3 + " domains " + Arrays.toString(strArr), str);
        if (strArr != null && strArr.length != 0 && wtTicketPromise != null && !TextUtils.isEmpty(str)) {
            synchronized (GET_TICKET_LOCK) {
                realGetPskeyIgnoreCache(str, j3, strArr, wtTicketPromise);
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x00df. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0739  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0744  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getSaltUinList(long j3, long j16, String str, WUserSigInfo wUserSigInfo, long[] jArr, boolean z16, int i3) {
        WtloginHelper wtloginHelper;
        u a16;
        int i16;
        async_context async_contextVar;
        WUserSigInfo wUserSigInfo2;
        u uVar;
        int i17;
        int a17;
        byte[] bArr;
        int i18;
        async_context async_contextVar2;
        StringBuilder sb5;
        s sVar;
        u uVar2;
        int i19;
        int i26;
        int i27;
        async_context async_contextVar3;
        WUserSigInfo wUserSigInfo3;
        int i28;
        ArrayList arrayList;
        byte[] bArr2;
        async_context async_contextVar4;
        byte[] bArr3;
        byte[] bArr4;
        async_context async_contextVar5;
        byte[] bArr5;
        byte[] bArr6;
        byte[] bArr7;
        s sVar2;
        async_context async_contextVar6;
        tlv_t tlv_tVar;
        byte[] loginExtraData;
        byte[] bArr8;
        tlv_t tlv_tVar2;
        int length;
        byte[] bArr9;
        int i29;
        byte[] bArr10;
        ArrayList arrayList2;
        long j17 = j3;
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, "0", j3, 0, j16, jArr, true, str, wUserSigInfo, null, z16, "getSaltUinList").RunReq(24);
            return -1001;
        }
        WUserSigInfo wUserSigInfo4 = wUserSigInfo == null ? new WUserSigInfo() : wUserSigInfo;
        if (z16) {
            wtloginHelper = this;
            if (wUserSigInfo4._seqence == 0) {
                wUserSigInfo4._seqence = wtloginHelper.mAysncSeq;
            }
            a16 = wtloginHelper.mG.a(wUserSigInfo4._seqence);
        } else {
            wtloginHelper = this;
            a16 = wtloginHelper.mG.a(0L);
        }
        u uVar3 = a16;
        long j18 = uVar3.f422959f;
        wUserSigInfo4._seqence = j18;
        wtloginHelper.mAysncSeq = j18;
        async_context b16 = u.b(j18);
        b16._appid = j17;
        b16._sub_appid = j16;
        b16._isSmslogin = false;
        b16._uin = 0L;
        int i36 = wtloginHelper.mMiscBitmap;
        if (u.Z) {
            i36 |= 33554432;
        }
        s sVar3 = new s(uVar3, wtloginHelper.mContext);
        int i37 = wtloginHelper.mSubSigMap;
        int i38 = i36;
        int i39 = 0;
        while (true) {
            byte[] bArr11 = u.f422924a0;
            int[] iArr = {256, 264, 292, 296, 1325, 278, 340, 8, 283, 1313, CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID, 1348, QidPagView.DESIGN_PAG_WIDTH, 322, 327, 325, 514, 1024, 1349, 1317, 370, 24, 265, 366, tlv_t553.CMD_553};
            ArrayList arrayList3 = new ArrayList();
            StringBuilder sb6 = new StringBuilder("request_getSaltUinList");
            sb6.append(" getRequestBody");
            s sVar4 = sVar3;
            async_context b17 = u.b(sVar3.f422917m.f422959f);
            if (b17.get_t104().get_data().length > 0) {
                i16 = 25;
                iArr = new int[]{256, 264, 292, 296, 1325, 278, 340, 8, 283, 1313, CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID, 1348, QidPagView.DESIGN_PAG_WIDTH, 322, 327, 325, 514, 1024, 1349, 1317, 370, 24, 265, 366, 260};
            } else {
                i16 = 25;
            }
            int[] iArr2 = iArr;
            u uVar4 = uVar3;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            while (i46 < i16) {
                int i49 = i39;
                byte[] bArr12 = new byte[0];
                int i56 = i46;
                switch (iArr2[i46]) {
                    case 8:
                        bArr = bArr11;
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        async_contextVar3 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList4 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList4;
                        bArr2 = new tlv_t8().get_tlv_8(0, u.f422951x, 0);
                        bArr3 = bArr2;
                        break;
                    case 24:
                        bArr = bArr11;
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        async_contextVar3 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList5 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList5;
                        bArr2 = new tlv_t18().get_tlv_18(j3, u.f422953z, 0L, 0);
                        bArr3 = bArr2;
                        break;
                    case 256:
                        bArr = bArr11;
                        i18 = i37;
                        async_contextVar2 = b16;
                        async_context async_contextVar7 = b17;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList6 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList6;
                        async_contextVar3 = async_contextVar7;
                        bArr2 = new tlv_t100().get_tlv_100(async_contextVar7._appid, async_contextVar7._sub_appid, 0, async_contextVar7._main_sigmap);
                        bArr3 = bArr2;
                        break;
                    case 260:
                        bArr = bArr11;
                        i18 = i37;
                        async_contextVar2 = b16;
                        async_contextVar4 = b17;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList7 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList7;
                        bArr2 = new tlv_t104().get_tlv_104(async_contextVar4.get_t104().get_data());
                        async_contextVar3 = async_contextVar4;
                        bArr3 = bArr2;
                        break;
                    case 264:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        byte[] bArr13 = bArr11;
                        async_contextVar4 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList8 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList8;
                        bArr = bArr13;
                        bArr2 = new tlv_t108().get_tlv_108(bArr);
                        async_contextVar3 = async_contextVar4;
                        bArr3 = bArr2;
                        break;
                    case 265:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList9 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList9;
                        bArr5 = new tlv_t109().get_tlv_109(oicq.wlogin_sdk.utils.a.a(u.f422949w));
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 278:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList10 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList10;
                        bArr5 = new tlv_t116().get_tlv_116(i28, i18, jArr);
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 283:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList11 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList11;
                        tlv_t tlv_tVar3 = new tlv_t(283);
                        tlv_tVar3.set_data(new byte[]{2}, 1);
                        bArr5 = tlv_tVar3.get_buf();
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 292:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList12 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList12;
                        bArr5 = new tlv_t124().get_tlv_124(util.get_os_type(), util.get_os_version(), u.F, oicq.wlogin_sdk.utils.b.d(sVar.f422905a), new byte[0], u.H);
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 296:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList13 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList13;
                        bArr5 = new tlv_t128().get_tlv_128(u.S, u.T, u.U, u.X, oicq.wlogin_sdk.utils.b.b(u.f422949w), u.D, u.O);
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 322:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList14 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList14;
                        bArr5 = new tlv_t142().get_tlv_142(u.G);
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 325:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList15 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList15;
                        bArr5 = new tlv_t145().get_tlv_145(u.D);
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 327:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList16 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList16;
                        j17 = j3;
                        bArr5 = new tlv_t147().get_tlv_147(j17, u.I, u.J);
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 340:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList17 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList17;
                        bArr5 = new tlv_t154().get_tlv_154(sVar.f422917m.f422960g);
                        j17 = j3;
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 366:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList18 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList18;
                        bArr5 = new tlv_t16e().get_tlv_16e(oicq.wlogin_sdk.utils.b.b(u.f422949w));
                        j17 = j3;
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 370:
                        bArr6 = bArr12;
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList19 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList19;
                        byte[] bArr14 = sVar.f422917m.f422968o;
                        if (bArr14 != null && bArr14.length != 0) {
                            bArr5 = new tlv_t172().get_tlv_172(sVar.f422917m.f422968o);
                            j17 = j3;
                            bArr3 = bArr5;
                            bArr = bArr4;
                            async_contextVar3 = async_contextVar5;
                            break;
                        }
                        j17 = j3;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        bArr3 = bArr6;
                        break;
                    case QidPagView.DESIGN_PAG_WIDTH /* 375 */:
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList20 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList20;
                        bArr5 = new tlv_t177().get_tlv_177(util.BUILD_TIME, util.SDK_VERSION);
                        j17 = j3;
                        bArr3 = bArr5;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        break;
                    case 514:
                        bArr6 = bArr12;
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        bArr4 = bArr11;
                        async_contextVar5 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList21 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList21;
                        byte[] bArr15 = u.Q;
                        if (bArr15 != null && bArr15.length != 0) {
                            bArr5 = new tlv_t202().get_tlv_202(u.Q, u.R);
                            j17 = j3;
                            bArr3 = bArr5;
                            bArr = bArr4;
                            async_contextVar3 = async_contextVar5;
                            break;
                        }
                        j17 = j3;
                        bArr = bArr4;
                        async_contextVar3 = async_contextVar5;
                        bArr3 = bArr6;
                        break;
                    case 1024:
                        bArr6 = bArr12;
                        async_context async_contextVar8 = b16;
                        s sVar5 = sVar4;
                        int i57 = i37;
                        WloginSigInfo d16 = sVar5.f422917m.d(0L, j17);
                        if (d16 != null && (bArr7 = d16._G) != null) {
                            if (bArr7.length != 0) {
                                byte[] bArr16 = d16._dpwd;
                                if (bArr16 != null) {
                                    if (bArr16.length != 0) {
                                        byte[] bArr17 = d16._randseed;
                                        if (bArr17 != null) {
                                            if (bArr17.length != 0) {
                                                i18 = i57;
                                                wUserSigInfo3 = wUserSigInfo4;
                                                sb5 = sb6;
                                                i26 = i56;
                                                i27 = 25;
                                                byte[] bArr18 = bArr11;
                                                sVar = sVar5;
                                                ArrayList arrayList22 = arrayList3;
                                                i28 = i38;
                                                arrayList = arrayList22;
                                                i19 = i49;
                                                async_contextVar5 = b17;
                                                async_contextVar2 = async_contextVar8;
                                                uVar2 = uVar4;
                                                bArr4 = bArr18;
                                                bArr5 = new tlv_t400().get_tlv_400(d16._G, 0L, u.D, d16._dpwd, j3, j16, d16._randseed);
                                                j17 = j3;
                                                bArr3 = bArr5;
                                                bArr = bArr4;
                                                async_contextVar3 = async_contextVar5;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            bArr = bArr11;
                            sb5 = sb6;
                            i18 = i57;
                            uVar2 = uVar4;
                            i19 = i49;
                            i26 = i56;
                            async_contextVar2 = async_contextVar8;
                            i27 = 25;
                            sVar = sVar5;
                            async_contextVar3 = b17;
                            wUserSigInfo3 = wUserSigInfo4;
                            ArrayList arrayList23 = arrayList3;
                            i28 = i38;
                            arrayList = arrayList23;
                            bArr3 = bArr6;
                            break;
                        }
                        sb5 = sb6;
                        i18 = i57;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        async_contextVar2 = async_contextVar8;
                        i27 = 25;
                        sVar = sVar5;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList24 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList24;
                        j17 = j3;
                        bArr = bArr11;
                        async_contextVar3 = b17;
                        bArr3 = bArr6;
                        break;
                    case 1313:
                        s sVar6 = sVar4;
                        int i58 = i37;
                        tlv_t tlv_tVar4 = new tlv_t(1313);
                        byte[] bArr19 = new byte[6];
                        util.int32_to_buf(bArr19, 0, u.f422942s0);
                        util.int16_to_buf(bArr19, 4, 0);
                        tlv_tVar4.set_data(bArr19, 6);
                        bArr = bArr11;
                        bArr3 = tlv_tVar4.get_buf();
                        sb5 = sb6;
                        i18 = i58;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        async_contextVar2 = b16;
                        i27 = 25;
                        sVar = sVar6;
                        async_contextVar3 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList25 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList25;
                        break;
                    case 1317:
                        sVar2 = sVar4;
                        int i59 = i37;
                        try {
                            tlv_tVar = new tlv_t(1334);
                            loginExtraData = ProtocolDet.getLoginExtraData(sVar2.f422905a);
                        } catch (Exception e16) {
                            e = e16;
                            bArr6 = bArr12;
                            async_contextVar6 = b16;
                        }
                        if (loginExtraData == null || loginExtraData.length <= 0) {
                            bArr6 = bArr12;
                            async_contextVar6 = b16;
                            util.LOGI("TGTGT 0x536:null", "0");
                            bArr = bArr11;
                            sb5 = sb6;
                            i18 = i59;
                            uVar2 = uVar4;
                            i19 = i49;
                            i26 = i56;
                            async_contextVar2 = async_contextVar6;
                            i27 = 25;
                            sVar = sVar2;
                            async_contextVar3 = b17;
                            wUserSigInfo3 = wUserSigInfo4;
                            ArrayList arrayList232 = arrayList3;
                            i28 = i38;
                            arrayList = arrayList232;
                            bArr3 = bArr6;
                        } else {
                            String str2 = "TGTGT 0x536:" + loginExtraData.length + ":" + util.buf_to_string(loginExtraData);
                            StringBuilder sb7 = new StringBuilder();
                            async_contextVar6 = b16;
                            try {
                                sb7.append(0L);
                                sb7.append("");
                                util.LOGI(str2, sb7.toString());
                                tlv_tVar.set_data(loginExtraData, loginExtraData.length);
                                bArr8 = tlv_tVar.get_buf();
                                tlv_tVar2 = new tlv_t(1317);
                                length = bArr8.length + 2;
                                bArr9 = new byte[length];
                                util.int16_to_buf(bArr9, 0, 1);
                                bArr6 = bArr12;
                            } catch (Exception e17) {
                                e = e17;
                                bArr6 = bArr12;
                            }
                            try {
                                System.arraycopy(bArr8, 0, bArr9, 2, bArr8.length);
                                tlv_tVar2.set_data(bArr9, length);
                                bArr = bArr11;
                                bArr3 = tlv_tVar2.get_buf();
                                sb5 = sb6;
                                i18 = i59;
                                uVar2 = uVar4;
                                i19 = i49;
                                i26 = i56;
                                async_contextVar2 = async_contextVar6;
                                i27 = 25;
                                sVar = sVar2;
                                async_contextVar3 = b17;
                                wUserSigInfo3 = wUserSigInfo4;
                                ArrayList arrayList252 = arrayList3;
                                i28 = i38;
                                arrayList = arrayList252;
                            } catch (Exception e18) {
                                e = e18;
                                util.printException(e, "");
                                bArr = bArr11;
                                sb5 = sb6;
                                i18 = i59;
                                uVar2 = uVar4;
                                i19 = i49;
                                i26 = i56;
                                async_contextVar2 = async_contextVar6;
                                i27 = 25;
                                sVar = sVar2;
                                async_contextVar3 = b17;
                                wUserSigInfo3 = wUserSigInfo4;
                                ArrayList arrayList2322 = arrayList3;
                                i28 = i38;
                                arrayList = arrayList2322;
                                bArr3 = bArr6;
                                if (bArr3.length <= 4) {
                                }
                                i46 = i26 + 1;
                                bArr11 = bArr;
                                i38 = i28;
                                wUserSigInfo4 = wUserSigInfo3;
                                b17 = async_contextVar3;
                                i16 = i27;
                                i39 = i19;
                                b16 = async_contextVar2;
                                uVar4 = uVar2;
                                arrayList3 = arrayList2;
                                sVar4 = sVar;
                                i37 = i18;
                                sb6 = sb5;
                            }
                        }
                        break;
                    case 1325:
                        sVar2 = sVar4;
                        i29 = i37;
                        bArr10 = new tlv_t52d().get_tlv_52d(sVar2.f422905a);
                        bArr = bArr11;
                        bArr3 = bArr10;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        i18 = i29;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        sVar = sVar2;
                        async_contextVar3 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList2522 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList2522;
                        break;
                    case 1348:
                        sVar2 = sVar4;
                        i29 = i37;
                        byte[] bytes = util.SDK_VERSION.getBytes();
                        byte[] bArr20 = new byte[u.D.length + 10 + 2 + bytes.length + 4];
                        util.int64_to_buf(bArr20, 0, (int) 0);
                        util.int16_to_buf(bArr20, 8, u.D.length);
                        byte[] bArr21 = u.D;
                        System.arraycopy(bArr21, 0, bArr20, 10, bArr21.length);
                        int length2 = u.D.length + 10;
                        util.int16_to_buf(bArr20, length2, bytes.length);
                        int i65 = length2 + 2;
                        System.arraycopy(bytes, 0, bArr20, i65, bytes.length);
                        util.int32_to_buf(bArr20, i65 + bytes.length, sVar2.f422915k);
                        bArr10 = new tlv_t544().get_tlv_544(String.valueOf(0L), "810_24", bArr20);
                        bArr = bArr11;
                        bArr3 = bArr10;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        i18 = i29;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        sVar = sVar2;
                        async_contextVar3 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList25222 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList25222;
                        break;
                    case 1349:
                        sVar2 = sVar4;
                        i29 = i37;
                        bArr10 = new tlv_t545().get_tlv_545(oicq.wlogin_sdk.utils.b.c(u.f422949w));
                        bArr = bArr11;
                        bArr3 = bArr10;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        i18 = i29;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        sVar = sVar2;
                        async_contextVar3 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList252222 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList252222;
                        break;
                    case CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID /* 1352 */:
                        sVar2 = sVar4;
                        i29 = i37;
                        tlv_t548 tlv_t548Var = new tlv_t548();
                        byte[] bArr22 = new byte[0];
                        byte[] bArr23 = u.f422933j0;
                        if (bArr23 == null || bArr23.length <= 0) {
                            bArr = bArr11;
                            bArr3 = bArr22;
                            async_contextVar2 = b16;
                            sb5 = sb6;
                            i18 = i29;
                            uVar2 = uVar4;
                            i19 = i49;
                            i26 = i56;
                            i27 = 25;
                            sVar = sVar2;
                            async_contextVar3 = b17;
                            wUserSigInfo3 = wUserSigInfo4;
                            ArrayList arrayList2522222 = arrayList3;
                            i28 = i38;
                            arrayList = arrayList2522222;
                            break;
                        } else {
                            bArr10 = tlv_t548Var.get_tlv_548(bArr23);
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("t548 len:");
                            sb8.append(bArr10 == null ? 0 : bArr10.length);
                            util.LOGI(sb8.toString(), "");
                            bArr = bArr11;
                            bArr3 = bArr10;
                            async_contextVar2 = b16;
                            sb5 = sb6;
                            i18 = i29;
                            uVar2 = uVar4;
                            i19 = i49;
                            i26 = i56;
                            i27 = 25;
                            sVar = sVar2;
                            async_contextVar3 = b17;
                            wUserSigInfo3 = wUserSigInfo4;
                            ArrayList arrayList25222222 = arrayList3;
                            i28 = i38;
                            arrayList = arrayList25222222;
                        }
                        break;
                    case tlv_t553.CMD_553 /* 1363 */:
                        sVar2 = sVar4;
                        i29 = i37;
                        bArr10 = new tlv_t553().get_tlv_t553(QSec.getInstance().getFeKitAttach(sVar2.f422905a, String.valueOf(0L), "0x810", "0x18"));
                        bArr = bArr11;
                        bArr3 = bArr10;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        i18 = i29;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        sVar = sVar2;
                        async_contextVar3 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList252222222 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList252222222;
                        break;
                    default:
                        bArr = bArr11;
                        bArr6 = bArr12;
                        i18 = i37;
                        async_contextVar2 = b16;
                        sb5 = sb6;
                        sVar = sVar4;
                        uVar2 = uVar4;
                        i19 = i49;
                        i26 = i56;
                        i27 = 25;
                        async_contextVar3 = b17;
                        wUserSigInfo3 = wUserSigInfo4;
                        ArrayList arrayList23222 = arrayList3;
                        i28 = i38;
                        arrayList = arrayList23222;
                        bArr3 = bArr6;
                        break;
                }
                if (bArr3.length <= 4) {
                    i47++;
                    i48 += bArr3.length;
                    arrayList2 = arrayList;
                    arrayList2.add(bArr3);
                } else {
                    arrayList2 = arrayList;
                }
                i46 = i26 + 1;
                bArr11 = bArr;
                i38 = i28;
                wUserSigInfo4 = wUserSigInfo3;
                b17 = async_contextVar3;
                i16 = i27;
                i39 = i19;
                b16 = async_contextVar2;
                uVar4 = uVar2;
                arrayList3 = arrayList2;
                sVar4 = sVar;
                i37 = i18;
                sb6 = sb5;
            }
            int i66 = i39;
            int i67 = i37;
            async_contextVar = b16;
            wUserSigInfo2 = wUserSigInfo4;
            ArrayList arrayList26 = arrayList3;
            StringBuilder sb9 = sb6;
            s sVar7 = sVar4;
            uVar = uVar4;
            i17 = i38;
            HashMap<Integer, tlv_t> hashMap = wUserSigInfo2.extraLoginTLVMap;
            if (hashMap != null) {
                for (Integer num : hashMap.keySet()) {
                    tlv_t tlv_tVar5 = wUserSigInfo2.extraLoginTLVMap.get(num);
                    if (tlv_tVar5 != null) {
                        byte[] bArr24 = tlv_tVar5.get_buf();
                        i47++;
                        arrayList26.add(bArr24);
                        i48 += bArr24.length;
                        sb9.append(",key=");
                        sb9.append(num);
                        sb9.append(",Buff=");
                        sb9.append(bArr24.length);
                    }
                }
            }
            int i68 = i47;
            byte[] bArr25 = new byte[i48];
            int i69 = 0;
            int i75 = 0;
            while (i69 < i68) {
                byte[] bArr26 = (byte[]) arrayList26.get(i69);
                System.arraycopy(bArr26, 0, bArr25, i75, bArr26.length);
                i75 += bArr26.length;
                i69++;
                arrayList26 = arrayList26;
            }
            sb9.append(",tlvCnt=");
            sb9.append(i68);
            util.LOGI(sb9.toString(), "");
            sVar7.a(sVar7.f422917m.f422957d, sVar7.a(bArr25, sVar7.f422915k, i68), sVar7.f422918n);
            a17 = sVar7.a(String.valueOf(sVar7.f422917m.f422957d), false, wUserSigInfo2);
            if (a17 == 0) {
                a17 = sVar7.d();
                util.LOGI("request_getSaltUinList,retry num:" + i66 + ",ret:" + a17, "" + sVar7.f422917m.f422957d);
                if (a17 == 180) {
                    i39 = i66 + 1;
                    if (i66 < 1) {
                        j17 = j3;
                        i38 = i17;
                        sVar3 = sVar7;
                        i37 = i67;
                        b16 = async_contextVar;
                        uVar3 = uVar;
                        wUserSigInfo4 = wUserSigInfo2;
                    }
                }
            }
        }
        util.LOGI("request_getSaltUinList ret = " + a17, "");
        if (a17 != 0) {
            return a17;
        }
        async_context async_contextVar9 = async_contextVar;
        async_contextVar9._tgtgt_key = util.get_rand_16byte(u.E);
        byte[] bArr27 = async_contextVar9._t543.get_data();
        ThirdPartLogin$RspBody thirdPartLogin$RspBody = new ThirdPartLogin$RspBody();
        ThirdPartLogin$ReqBody thirdPartLogin$ReqBody = new ThirdPartLogin$ReqBody();
        try {
            thirdPartLogin$RspBody.mergeFrom(bArr27);
            if (!thirdPartLogin$RspBody.has() || !thirdPartLogin$RspBody.msg_rsp_cmd_24.has()) {
                return -1000;
            }
            ThirdPartLogin$ReqCmd25 thirdPartLogin$ReqCmd25 = new ThirdPartLogin$ReqCmd25();
            List<ThirdPartLogin$RandSalt> list = thirdPartLogin$RspBody.msg_rsp_cmd_24.rpt_salt_list.get();
            if (list == null || list.isEmpty()) {
                return -1000;
            }
            for (ThirdPartLogin$RandSalt thirdPartLogin$RandSalt : list) {
                util.LOGI("randSalt uint64_salt = " + thirdPartLogin$RandSalt.uint64_salt.get(), "");
                ThirdPartLogin$A1Sig thirdPartLogin$A1Sig = new ThirdPartLogin$A1Sig();
                thirdPartLogin$A1Sig.bytes_encrypt_uin.set(thirdPartLogin$RandSalt.bytes_encrypt_uin.get());
                thirdPartLogin$A1Sig.bytes_a1_sig.set(ByteStringMicro.copyFrom(generateA1(j3, j16, thirdPartLogin$RandSalt.uint64_salt.get(), str, async_contextVar9._tgtgt_key)));
                thirdPartLogin$ReqCmd25.rpt_a1_list.add(thirdPartLogin$A1Sig);
                wUserSigInfo2 = wUserSigInfo2;
                async_contextVar9 = async_contextVar9;
            }
            WUserSigInfo wUserSigInfo5 = wUserSigInfo2;
            async_context async_contextVar10 = async_contextVar9;
            thirdPartLogin$ReqBody.msg_req_cmd_25.set(thirdPartLogin$ReqCmd25);
            thirdPartLogin$ReqBody.msg_req_cmd_25.setHasFlag(true);
            ThirdPartLogin$ReqCommonInfo thirdPartLogin$ReqCommonInfo = new ThirdPartLogin$ReqCommonInfo();
            thirdPartLogin$ReqCommonInfo.bool_req_passwd_err_support_identity_verify.set(true);
            thirdPartLogin$ReqCommonInfo.bool_req_support_diff_passwd_can_verify.set(true);
            thirdPartLogin$ReqBody.msg_req_common_info.set(thirdPartLogin$ReqCommonInfo);
            thirdPartLogin$ReqBody.setHasFlag(true);
            setExtraLoginTlvValue(wUserSigInfo5, 1346, thirdPartLogin$ReqBody.toByteArray());
            int a18 = new m(uVar, this.mContext).a(wUserSigInfo5, j3, j16, i17, this.mSubSigMap, jArr);
            util.LOGI("request_checkA1List ret = " + a18, "");
            if (a18 == 0) {
                async_contextVar10.a1List = async_contextVar10._t543;
            }
            return a18;
        } catch (Exception e19) {
            util.printException(e19, "");
            return -1000;
        }
    }

    public int getStByGateWay(long j3, long j16, int i3, WUserSigInfo wUserSigInfo, int i16) {
        async_context async_contextVar;
        tlv_t150 tlv_t150Var;
        if (i16 == 0) {
            new HelperThread(this, this.mHelperHandler, j3, j16, i3, wUserSigInfo, "getStByGateWay").RunReq(21);
            return -1001;
        }
        int i17 = i3 | 262336;
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        u a16 = this.mG.a(wUserSigInfo._seqence);
        long j17 = a16.f422959f;
        wUserSigInfo._seqence = j17;
        async_context b16 = u.b(j17);
        b16._appid = j3;
        b16._sub_appid = j16;
        b16._sappid = j3;
        a16.f422957d = b16._uin;
        b16._tmp_pwd = MD5.toMD5Byte(b16._mpasswd.getBytes());
        j jVar = new j(a16, this.mContext);
        jVar.f422919o = true;
        int a17 = jVar.a(j3, j16, a16.f422957d, 0, u.f422927d0, util.getRequestInitTime(), b16._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, (long[]) null, i17, j16, u.B, 0, 0, 1, u.f422924a0, wUserSigInfo);
        if (a17 == 204) {
            a17 = new p(a16).a(this.mMiscBitmap, this.mSubSigMap, (long[]) null, wUserSigInfo);
        }
        int i18 = a17;
        if (i18 != 0) {
            return i18;
        }
        wUserSigInfo.uin = b16._uin + "";
        WloginSigInfo d16 = a16.d(a16.f422957d, j3);
        if (d16 == null) {
            return -1004;
        }
        wUserSigInfo.get_clone(d16);
        Ticket GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (GetUserSigInfoTicket == null) {
            GetUserSigInfoTicket = new Ticket();
        }
        Ticket ticket = GetUserSigInfoTicket;
        u.f422936m0.commit_t2(a16.f422957d, a16.f422958e, util.format_ret_code(i18), i18);
        if (i18 == 0) {
            byte[] bArr = ticket._sig;
            if (bArr != null && bArr.length != 0) {
                RequestReport(0, bArr, ticket._sig_key, a16.f422957d, b16._appid);
            }
        } else if (i18 != 2 && i18 != 160) {
            async_contextVar = b16;
            RequestReportError(0, ticket._sig, ticket._sig_key, a16.f422957d, b16._appid, 0);
            tlv_t150Var = a16.f422956c;
            if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                this.mG.f422956c = a16.f422956c;
                RequestReportError(0, ticket._sig, ticket._sig_key, a16.f422957d, async_contextVar._appid, 1);
            }
            oicq.wlogin_sdk.report.b.a();
            u.a();
            a16.b();
            return i18;
        }
        async_contextVar = b16;
        tlv_t150Var = a16.f422956c;
        if (tlv_t150Var != null) {
            this.mG.f422956c = a16.f422956c;
            RequestReportError(0, ticket._sig, ticket._sig_key, a16.f422957d, async_contextVar._appid, 1);
        }
        oicq.wlogin_sdk.report.b.a();
        u.a();
        a16.b();
        return i18;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d8, code lost:
    
        r3 = r13.bytes_a1_sig.get().toByteArray();
        oicq.wlogin_sdk.tools.util.LOGI("getStByPhoneAndPassword has a1" + r3.length, "");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getStByPhoneAndPassword(long j3, long j16, int i3, WUserSigInfo wUserSigInfo, int i16) {
        if (i16 == 0) {
            new HelperThread(this, this.mHelperHandler, j3, j16, i3, wUserSigInfo, "getStByPhoneAndPassword").RunReq(23);
            return -1001;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        int i17 = i3 | 262336;
        u a16 = this.mG.a(wUserSigInfo._seqence);
        long j17 = a16.f422959f;
        wUserSigInfo._seqence = j17;
        async_context b16 = u.b(j17);
        b16._appid = j3;
        b16._sub_appid = j16;
        b16._sappid = j3;
        byte[] bArr = new byte[0];
        if (!wUserSigInfo.extraLoginTLVMap.containsKey(1346)) {
            util.LOGI("getStByPhoneAndPassword no 542 ", "");
            return -1000;
        }
        byte[] bArr2 = wUserSigInfo.extraLoginTLVMap.get(1346).get_data();
        tlv_t543 tlv_t543Var = b16.a1List;
        if (tlv_t543Var == null) {
            return -1000;
        }
        byte[] bArr3 = tlv_t543Var.get_data();
        ThirdPartLogin$ReqBody thirdPartLogin$ReqBody = new ThirdPartLogin$ReqBody();
        ThirdPartLogin$RspBody thirdPartLogin$RspBody = new ThirdPartLogin$RspBody();
        try {
            thirdPartLogin$ReqBody.mergeFrom(bArr2);
            String stringUtf8 = thirdPartLogin$ReqBody.msg_req_mask_qq_login.bytes_encrypt_uin_info.get().toStringUtf8();
            util.LOGI("getStByPhoneAndPassword uinToken =  " + stringUtf8, "");
            thirdPartLogin$RspBody.mergeFrom(bArr3);
            Iterator<ThirdPartLogin$UinInfo> it = thirdPartLogin$RspBody.msg_rsp_cmd_25.rpt_bind_uin_info.get().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ThirdPartLogin$UinInfo next = it.next();
                if (next.bytes_encrypt_uin.get().toStringUtf8().equals(stringUtf8)) {
                    break;
                }
            }
            if (bArr.length <= 0) {
                return -1000;
            }
            j jVar = new j(a16, this.mContext);
            jVar.f422919o = true;
            int a17 = jVar.a(j3, j16, a16.f422957d, 0, u.f422927d0, bArr, (byte[]) null, this.mMiscBitmap, this.mSubSigMap, (long[]) null, i17, j16, u.B, 0, 0, 1, u.f422924a0, wUserSigInfo, false);
            util.LOGI("getStByPhoneAndPassword ret = " + a17, "");
            if (a17 == 204) {
                a17 = new p(a16).a(this.mMiscBitmap, this.mSubSigMap, (long[]) null, wUserSigInfo);
            }
            int i18 = a17;
            if (i18 != 0) {
                return i18;
            }
            wUserSigInfo.uin = b16._uin + "";
            WloginSigInfo d16 = a16.d(a16.f422957d, j3);
            if (d16 == null) {
                return -1004;
            }
            wUserSigInfo.get_clone(d16);
            Ticket GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
            if (GetUserSigInfoTicket == null) {
                GetUserSigInfoTicket = new Ticket();
            }
            u.f422936m0.commit_t2(a16.f422957d, a16.f422958e, util.format_ret_code(i18), i18);
            if (i18 == 0) {
                byte[] bArr4 = GetUserSigInfoTicket._sig;
                if (bArr4 != null && bArr4.length != 0) {
                    RequestReport(0, bArr4, GetUserSigInfoTicket._sig_key, a16.f422957d, b16._appid);
                }
            } else if (i18 != 2 && i18 != 160) {
                RequestReportError(0, GetUserSigInfoTicket._sig, GetUserSigInfoTicket._sig_key, a16.f422957d, b16._appid, 0);
            }
            tlv_t150 tlv_t150Var = a16.f422956c;
            if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                this.mG.f422956c = a16.f422956c;
                RequestReportError(0, GetUserSigInfoTicket._sig, GetUserSigInfoTicket._sig_key, a16.f422957d, b16._appid, 1);
            }
            oicq.wlogin_sdk.report.b.a();
            u.a();
            a16.b();
            return i18;
        } catch (InvalidProtocolBufferMicroException e16) {
            util.printException(e16, "");
            return -1000;
        }
    }

    public int getStViaThirdPlatformLogin(long j3, long j16, int i3, WUserSigInfo wUserSigInfo, int i16) {
        async_context async_contextVar;
        tlv_t150 tlv_t150Var;
        if (i16 == 0) {
            new HelperThread(this, this.mHelperHandler, j3, j16, i3, wUserSigInfo, "getStViaThirdPlatformLogin").RunReq(25);
            return -1001;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        u a16 = this.mG.a(wUserSigInfo._seqence);
        long j17 = a16.f422959f;
        wUserSigInfo._seqence = j17;
        async_context b16 = u.b(j17);
        a16.f422957d = b16._uin;
        b16._appid = j3;
        b16._sub_appid = j16;
        b16._sappid = j3;
        b16._tmp_pwd = MD5.toMD5Byte(b16._mpasswd.getBytes());
        j jVar = new j(a16, this.mContext);
        jVar.f422919o = true;
        int a17 = jVar.a(j3, j16, b16._uin, 0, u.f422927d0, util.getRequestInitTime(), b16._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, (long[]) null, i3 | 262336, j16, u.B, 0, 0, 1, u.f422924a0, wUserSigInfo);
        if (a17 == 204) {
            util.LOGI("quickLoginByThirdPlatform seq:" + a16.f422959f + " ret:SEC_GUID", "");
            a17 = new p(a16).a(this.mMiscBitmap, this.mSubSigMap, (long[]) null, wUserSigInfo);
        }
        int i17 = a17;
        wUserSigInfo.uin = b16._uin + "";
        if (i17 != 0) {
            return i17;
        }
        WloginSigInfo d16 = a16.d(a16.f422957d, j3);
        if (d16 == null) {
            return -1004;
        }
        wUserSigInfo.get_clone(d16);
        Ticket GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (GetUserSigInfoTicket == null) {
            GetUserSigInfoTicket = new Ticket();
        }
        Ticket ticket = GetUserSigInfoTicket;
        u.f422936m0.commit_t2(a16.f422957d, a16.f422958e, util.format_ret_code(i17), i17);
        if (i17 == 0) {
            byte[] bArr = ticket._sig;
            if (bArr != null && bArr.length != 0) {
                RequestReport(0, bArr, ticket._sig_key, a16.f422957d, b16._appid);
            }
        } else if (i17 != 2 && i17 != 160) {
            async_contextVar = b16;
            RequestReportError(0, ticket._sig, ticket._sig_key, a16.f422957d, b16._appid, 0);
            tlv_t150Var = a16.f422956c;
            if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                this.mG.f422956c = a16.f422956c;
                RequestReportError(0, ticket._sig, ticket._sig_key, a16.f422957d, async_contextVar._appid, 1);
            }
            oicq.wlogin_sdk.report.b.a();
            u.a();
            a16.b();
            return i17;
        }
        async_contextVar = b16;
        tlv_t150Var = a16.f422956c;
        if (tlv_t150Var != null) {
            this.mG.f422956c = a16.f422956c;
            RequestReportError(0, ticket._sig, ticket._sig_key, a16.f422957d, async_contextVar._appid, 1);
        }
        oicq.wlogin_sdk.report.b.a();
        u.a();
        a16.b();
        return i17;
    }

    public int getStWithQrSig(String str, long j3, long j16, int i3, WUserSigInfo wUserSigInfo) {
        return getStWithQrSig(str, j3, j16, i3, wUserSigInfo, 0);
    }

    public String getUserAccountFromQuickLoginResultData(Intent intent) {
        return "";
    }

    public String getUserInputFromQuickLoginResultData(Intent intent) {
        return "";
    }

    public WTLoginRecordSnapshot getWTLoginRecordSnapshot(long j3, int i3) {
        byte[] bArr;
        RefreshMemorySig();
        util.LOGI("getWTLoginRecordSnapshot, uin is " + j3 + ", appid is " + i3, "");
        WloginSigInfo FindUserSig = FindUserSig(j3, (long) i3);
        if (FindUserSig == null) {
            util.LOGI("getWTLoginRecordSnapshot sigInfo is null", "");
            return null;
        }
        WTLoginRecordSnapshot wTLoginRecordSnapshot = new WTLoginRecordSnapshot();
        wTLoginRecordSnapshot.uin = j3;
        wTLoginRecordSnapshot.appid = i3;
        byte[] bArr2 = FindUserSig._en_A1;
        if (bArr2 != null && bArr2.length > 0 && (bArr = FindUserSig._noPicSig) != null && bArr.length > 0) {
            int length = bArr2.length - 16;
            byte[] bArr3 = new byte[length];
            byte[] bArr4 = new byte[16];
            System.arraycopy(bArr2, 0, bArr3, 0, length);
            byte[] bArr5 = FindUserSig._en_A1;
            System.arraycopy(bArr5, bArr5.length - 16, bArr4, 0, 16);
            wTLoginRecordSnapshot.f422864a1 = bArr3;
            wTLoginRecordSnapshot.a1Key = bArr4;
            wTLoginRecordSnapshot.noPicSig = FindUserSig._noPicSig;
        }
        wTLoginRecordSnapshot.f422865a2 = FindUserSig._TGT;
        wTLoginRecordSnapshot.a2Key = FindUserSig._TGTKey;
        wTLoginRecordSnapshot.f422866d2 = FindUserSig._D2;
        wTLoginRecordSnapshot.d2Key = FindUserSig._D2Key;
        String d16 = this.mG.d(j3);
        if (TextUtils.isEmpty(d16)) {
            d16 = String.valueOf(j3);
        }
        wTLoginRecordSnapshot.account = String.valueOf(d16);
        wTLoginRecordSnapshot.a2GenerateTime = FindUserSig._A2_create_time;
        wTLoginRecordSnapshot.expireTime = FindUserSig._A2_expire_time;
        return wTLoginRecordSnapshot;
    }

    public boolean isQQNTSignToWTRefreshSuccess(long j3) {
        byte[] bArr;
        byte[] bArr2;
        RefreshMemorySig();
        WloginSigInfo d16 = this.mG.d(j3, 16L);
        boolean z16 = false;
        if (d16 != null && (bArr = d16._TGT) != null && bArr.length != 0 && (bArr2 = d16._D2) != null && bArr2.length != 0) {
            if (!checkNTSigFlag(this.mContext, j3, 16, bArr)) {
                z16 = true;
            }
        } else {
            util.LOGI("isQQNTSignToWTRefreshSuccess uin: " + j3 + " sign empty!");
        }
        util.LOGI("isQQNTSignToWTRefreshSuccess uin: " + j3 + ",success:" + z16, "");
        return z16;
    }

    public int modifyQIMPassword(int i3, byte[] bArr, WUserSigInfo wUserSigInfo) {
        int i16;
        if (bArr != null && bArr.length > 0) {
            util.LOGI("modifyQIMPassword : cmd=" + i3);
            TransReqContext transReqContext = new TransReqContext();
            transReqContext.set_register_req();
            transReqContext.set_subcmd(i3);
            transReqContext._body = bArr;
            if (i3 == 1749) {
                i16 = 5063;
            } else {
                i16 = 6084;
            }
            return RequestTransport(0, 1, null, 16L, i16, transReqContext, wUserSigInfo);
        }
        return -1017;
    }

    public int ntRegisterCheckNick(long j3, int i3, byte[] bArr, WUserSigInfo wUserSigInfo) {
        TransReqContext transReqContext = new TransReqContext();
        oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
        cVar.getClass();
        cVar.f422825e = i3;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(19);
        byte[] bArr2 = new byte[bArr.length + 13];
        util.int8_to_buf(bArr2, 0, 2);
        util.int16_to_buf(bArr2, 1, bArr.length + 11 + 2);
        util.int16_to_buf(bArr2, 3, 3);
        util.int16_to_buf(bArr2, 5, 19);
        util.int8_to_buf(bArr2, 7, 4);
        util.int32_to_buf(bArr2, 8, 0);
        System.arraycopy(bArr, 0, bArr2, 12, bArr.length);
        util.int8_to_buf(bArr2, bArr.length + 12, 3);
        transReqContext._body = bArr2;
        return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
    }

    public int ntRegisterProfile(long j3, int i3, byte[] bArr, WUserSigInfo wUserSigInfo) {
        TransReqContext transReqContext = new TransReqContext();
        oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
        cVar.getClass();
        cVar.f422825e = i3;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(18);
        byte[] bArr2 = new byte[bArr.length + 13];
        util.int8_to_buf(bArr2, 0, 2);
        util.int16_to_buf(bArr2, 1, bArr.length + 11 + 2);
        util.int16_to_buf(bArr2, 3, 3);
        util.int16_to_buf(bArr2, 5, 18);
        util.int8_to_buf(bArr2, 7, 4);
        util.int32_to_buf(bArr2, 8, 0);
        System.arraycopy(bArr, 0, bArr2, 12, bArr.length);
        util.int8_to_buf(bArr2, bArr.length + 12, 3);
        transReqContext._body = bArr2;
        return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
    }

    public int onQuickLoginActivityResultData(QuickLoginParam quickLoginParam, Intent intent) {
        return 0;
    }

    public int quickLogin(Activity activity, long j3, long j16, String str, QuickLoginParam quickLoginParam) {
        util.LOGI("quickLogin start " + System.currentTimeMillis(), "");
        return 0;
    }

    public int quickLoginByGateway(long j3, long j16, int i3, WUserSigInfo wUserSigInfo) {
        return quickLoginByGateway(j3, j16, i3, wUserSigInfo, 0);
    }

    public int quickLoginByThirdPlatform(QuickLoginParam quickLoginParam, int i3) {
        int[] iArr;
        int a16;
        Object valueOf;
        int[] iArr2;
        int i16;
        int i17;
        Integer valueOf2;
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, "", quickLoginParam, "quickLoginByThirdPlatform").RunReq(20);
            return -1001;
        }
        WUserSigInfo wUserSigInfo = quickLoginParam.userSigInfo;
        u a17 = this.mG.a(0L);
        a17.f422958e = quickLoginParam.userAccount;
        long j3 = a17.f422959f;
        wUserSigInfo._seqence = j3;
        this.mAysncSeq = j3;
        async_context b16 = u.b(j3);
        util.LOGI("quickLoginByThirdPlatform seq:" + a17.f422959f, "");
        b16._last_err_msg = new ErrMsg();
        quickLoginParam.sigMap = quickLoginParam.sigMap | 262336;
        b16._mpasswd = util.get_mpasswd();
        b16._msalt = util.constructSalt();
        long j16 = quickLoginParam.appid;
        b16._sappid = j16;
        b16._appid = j16;
        b16._sub_appid = quickLoginParam.subAppid;
        b16._main_sigmap = quickLoginParam.sigMap;
        b16._sub_appid_list = quickLoginParam.dstSubAppidList;
        tlv_t tlv_tVar = wUserSigInfo.extraLoginTLVMap.get(1346);
        int i18 = -1;
        if (tlv_tVar != null) {
            byte[] bArr = tlv_tVar.get_data();
            ThirdPartLogin$ReqBody thirdPartLogin$ReqBody = new ThirdPartLogin$ReqBody();
            try {
                thirdPartLogin$ReqBody.mergeFrom(bArr);
                if (thirdPartLogin$ReqBody.has() && thirdPartLogin$ReqBody.msg_req_third_login.has()) {
                    i18 = thirdPartLogin$ReqBody.msg_req_third_login.uint32_service_type.get();
                    String str = thirdPartLogin$ReqBody.msg_req_third_login.msg_req_wechat.str_code.get();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("quickLoginByThirdPlatform wxCode length = ");
                    if (str == null) {
                        valueOf2 = null;
                    } else {
                        valueOf2 = Integer.valueOf(str.length());
                    }
                    sb5.append(valueOf2);
                    util.LOGI(sb5.toString(), "");
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                util.printException(e16, "");
            }
        }
        w wVar = new w(a17);
        int i19 = this.mMiscBitmap;
        int i26 = this.mSubSigMap;
        int i27 = 0;
        int i28 = 0;
        while (true) {
            HashMap<Integer, tlv_t> hashMap = wUserSigInfo.extraLoginTLVMap;
            async_context b17 = u.b(wVar.f422917m.f422959f);
            if (b17.get_t104().get_data().length > 0) {
                iArr = new int[]{256, 322, 325, tlv_t183.CMD_183, 388, 1313, 278, 260, tlv_t553.CMD_553};
            } else {
                iArr = new int[]{256, 322, 325, tlv_t183.CMD_183, 388, 1313, 278, tlv_t553.CMD_553};
            }
            ArrayList arrayList = new ArrayList();
            int length = iArr.length;
            int i29 = i27;
            int i36 = i29;
            int i37 = i36;
            while (i29 < length) {
                int i38 = iArr[i29];
                byte[] bArr2 = new byte[i27];
                if (i38 != 256) {
                    if (i38 != 260) {
                        if (i38 != 278) {
                            if (i38 != 322) {
                                if (i38 != 325) {
                                    if (i38 != 1313) {
                                        if (i38 != 1363) {
                                            if (i38 != 387) {
                                                if (i38 != 388) {
                                                    i17 = i26;
                                                    iArr2 = iArr;
                                                    i16 = i19;
                                                } else {
                                                    iArr2 = iArr;
                                                    bArr2 = new tlv_t184().get_tlv_184(b17._msalt, b17._mpasswd);
                                                }
                                            } else {
                                                iArr2 = iArr;
                                                bArr2 = new tlv_t183().get_tlv_183(b17._msalt);
                                            }
                                        } else {
                                            iArr2 = iArr;
                                            QSec qSec = QSec.getInstance();
                                            wVar.f422917m.getClass();
                                            bArr2 = new tlv_t553().get_tlv_t553(qSec.getFeKitAttach(u.f422949w, "", "0x810", "0x17"));
                                        }
                                    } else {
                                        iArr2 = iArr;
                                        bArr2 = new tlv_t521().get_tlv_521(u.f422942s0);
                                    }
                                } else {
                                    iArr2 = iArr;
                                    bArr2 = new tlv_t145().get_tlv_145(u.D);
                                }
                            } else {
                                iArr2 = iArr;
                                bArr2 = new tlv_t142().get_tlv_142(u.G);
                            }
                        } else {
                            iArr2 = iArr;
                            bArr2 = new tlv_t116().get_tlv_116(i19, i26, null);
                        }
                    } else {
                        iArr2 = iArr;
                        bArr2 = new tlv_t104().get_tlv_104(b17.get_t104().get_data());
                    }
                    i16 = i19;
                    i17 = i26;
                } else {
                    iArr2 = iArr;
                    i16 = i19;
                    i17 = i26;
                    bArr2 = new tlv_t100().get_tlv_100(b17._appid, b17._sub_appid, 0, b17._main_sigmap);
                }
                if (bArr2.length > 4) {
                    i36++;
                    i37 += bArr2.length;
                    arrayList.add(bArr2);
                }
                i29++;
                i19 = i16;
                iArr = iArr2;
                i26 = i17;
                i27 = 0;
            }
            int i39 = i19;
            int i46 = i26;
            if (hashMap != null) {
                Iterator<Integer> it = hashMap.keySet().iterator();
                while (it.hasNext()) {
                    tlv_t tlv_tVar2 = hashMap.get(it.next());
                    if (tlv_tVar2 != null) {
                        byte[] bArr3 = tlv_tVar2.get_buf();
                        i36++;
                        arrayList.add(bArr3);
                        i37 += bArr3.length;
                    }
                }
            }
            int i47 = i36;
            byte[] bArr4 = new byte[i37];
            int i48 = 0;
            for (int i49 = 0; i49 < i47; i49++) {
                byte[] bArr5 = (byte[]) arrayList.get(i49);
                System.arraycopy(bArr5, 0, bArr4, i48, bArr5.length);
                i48 += bArr5.length;
            }
            wVar.a(wVar.f422917m.f422957d, wVar.a(bArr4, wVar.f422915k, i47), wVar.f422918n);
            a16 = wVar.a(String.valueOf(wVar.f422917m.f422957d), false, wUserSigInfo);
            if (a16 != 0) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("request_login_by_third_platform fail,  ret:");
                if (a16 > 0) {
                    valueOf = RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(a16);
                } else {
                    valueOf = Integer.valueOf(a16);
                }
                sb6.append(valueOf);
                util.LOGI(sb6.toString(), "" + wVar.f422917m.f422957d);
            } else {
                a16 = wVar.d();
                util.LOGI("retry num:" + i28 + " ret:" + a16, "" + wVar.f422917m.f422957d);
                if (a16 != 180) {
                    break;
                }
                int i56 = i28 + 1;
                if (i28 >= 1) {
                    break;
                }
                i27 = 0;
                i28 = i56;
                i19 = i39;
                i26 = i46;
            }
        }
        util.LOGI("quickLoginByThirdPlatform ret" + a16, "");
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_THIRD_PLATFORM, "sub_event_0x17", String.valueOf(a16));
        aVar.f422861g.put("serviceType", String.valueOf(i18));
        oicq.wlogin_sdk.report.c.b.a(aVar, 100);
        return a16;
    }

    public int quickLoginByWeChat(byte[] bArr, byte[] bArr2, QuickLoginParam quickLoginParam, int i3) {
        async_context async_contextVar;
        int a16;
        String str;
        async_context async_contextVar2;
        String str2;
        String str3;
        int i16;
        Ticket ticket;
        u uVar;
        tlv_t150 tlv_t150Var;
        ArrayList arrayList;
        async_context async_contextVar3;
        byte[] bArr3;
        ArrayList arrayList2;
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, "", bArr, bArr2, quickLoginParam, "quickLoginByWeChat").RunReq(18);
            return -1001;
        }
        WUserSigInfo wUserSigInfo = quickLoginParam.userSigInfo;
        u a17 = this.mG.a(0L);
        a17.f422958e = quickLoginParam.userAccount;
        long j3 = a17.f422959f;
        wUserSigInfo._seqence = j3;
        this.mAysncSeq = j3;
        async_context b16 = u.b(j3);
        util.LOGI("quickLoginByWeChat seq:" + a17.f422959f, "");
        b16._last_err_msg = new ErrMsg();
        quickLoginParam.sigMap = quickLoginParam.sigMap | 192;
        b16._mpasswd = util.get_mpasswd();
        b16._msalt = util.constructSalt();
        long j16 = quickLoginParam.appid;
        b16._sappid = j16;
        b16._appid = j16;
        b16._sub_appid = quickLoginParam.subAppid;
        b16._main_sigmap = quickLoginParam.sigMap;
        b16._sub_appid_list = quickLoginParam.dstSubAppidList;
        x xVar = new x(a17);
        int i17 = 0;
        int i18 = 0;
        while (true) {
            HashMap<Integer, tlv_t> hashMap = wUserSigInfo.extraLoginTLVMap;
            int[] iArr = {256, 322, 325, tlv_t183.CMD_183, 388, gdt_analysis_event.CONFIG_REPORT_FOR_MSG, 1313, tlv_t553.CMD_553};
            ArrayList arrayList3 = new ArrayList();
            async_context b17 = u.b(xVar.f422917m.f422959f);
            int i19 = i17;
            int i26 = i19;
            int i27 = i26;
            for (int i28 = 8; i19 < i28; i28 = 8) {
                byte[] bArr4 = new byte[i17];
                int i29 = iArr[i19];
                int[] iArr2 = iArr;
                if (i29 != 256) {
                    if (i29 != 322) {
                        if (i29 != 325) {
                            if (i29 != 1313) {
                                if (i29 != 1331) {
                                    if (i29 != 1363) {
                                        if (i29 != 387) {
                                            if (i29 != 388) {
                                                async_contextVar3 = b16;
                                                bArr3 = bArr4;
                                                arrayList = arrayList3;
                                            } else {
                                                arrayList = arrayList3;
                                                bArr3 = new tlv_t184().get_tlv_184(b17._msalt, b17._mpasswd);
                                            }
                                        } else {
                                            arrayList = arrayList3;
                                            bArr3 = new tlv_t183().get_tlv_183(b17._msalt);
                                        }
                                    } else {
                                        arrayList = arrayList3;
                                        QSec qSec = QSec.getInstance();
                                        xVar.f422917m.getClass();
                                        bArr3 = new tlv_t553().get_tlv_t553(qSec.getFeKitAttach(u.f422949w, "", "0x810", "0x17"));
                                    }
                                } else {
                                    arrayList = arrayList3;
                                    bArr3 = new tlv_t533().get_tlv_533(bArr, bArr2);
                                }
                            } else {
                                arrayList = arrayList3;
                                tlv_t tlv_tVar = new tlv_t(1313);
                                byte[] bArr5 = new byte[6];
                                util.int32_to_buf(bArr5, 0, u.f422942s0);
                                util.int16_to_buf(bArr5, 4, 0);
                                tlv_tVar.set_data(bArr5, 6);
                                bArr3 = tlv_tVar.get_buf();
                            }
                        } else {
                            arrayList = arrayList3;
                            bArr3 = new tlv_t145().get_tlv_145(u.D);
                        }
                    } else {
                        arrayList = arrayList3;
                        bArr3 = new tlv_t142().get_tlv_142(u.G);
                    }
                    async_contextVar3 = b16;
                } else {
                    arrayList = arrayList3;
                    async_contextVar3 = b16;
                    bArr3 = new tlv_t100().get_tlv_100(b17._appid, b17._sub_appid, 0, b17._main_sigmap);
                }
                if (bArr3.length > 4) {
                    i27++;
                    i26 += bArr3.length;
                    arrayList2 = arrayList;
                    arrayList2.add(bArr3);
                } else {
                    arrayList2 = arrayList;
                }
                i19++;
                arrayList3 = arrayList2;
                iArr = iArr2;
                b16 = async_contextVar3;
                i17 = 0;
            }
            async_contextVar = b16;
            ArrayList arrayList4 = arrayList3;
            if (hashMap != null) {
                Iterator<Integer> it = hashMap.keySet().iterator();
                while (it.hasNext()) {
                    tlv_t tlv_tVar2 = hashMap.get(it.next());
                    if (tlv_tVar2 != null) {
                        byte[] bArr6 = tlv_tVar2.get_buf();
                        i27++;
                        arrayList4.add(bArr6);
                        i26 += bArr6.length;
                    }
                }
            }
            int i36 = i27;
            byte[] bArr7 = new byte[i26];
            int i37 = 0;
            for (int i38 = 0; i38 < i36; i38++) {
                byte[] bArr8 = (byte[]) arrayList4.get(i38);
                System.arraycopy(bArr8, 0, bArr7, i37, bArr8.length);
                i37 += bArr8.length;
            }
            xVar.a(xVar.f422917m.f422957d, xVar.a(bArr7, xVar.f422915k, i36), xVar.f422918n);
            a16 = xVar.a(String.valueOf(xVar.f422917m.f422957d), false, wUserSigInfo);
            if (a16 != 0) {
                break;
            }
            a16 = xVar.d();
            util.LOGI("retry num:" + i18 + " ret:" + a16, "" + xVar.f422917m.f422957d);
            if (a16 != 180) {
                break;
            }
            int i39 = i18 + 1;
            if (i18 >= 1) {
                break;
            }
            i17 = 0;
            i18 = i39;
            b16 = async_contextVar;
        }
        util.LOGI("quickLoginByWeChat request_login_by_wechat ret" + a16);
        if (a16 != 0) {
            util.LOGI("quickLoginByWeChat seq " + a17.f422959f + " ret " + a16);
            return a16;
        }
        async_contextVar._tmp_pwd = MD5.toMD5Byte(async_contextVar._mpasswd.getBytes());
        j jVar = new j(a17, this.mContext);
        jVar.f422919o = true;
        int a18 = jVar.a(quickLoginParam.appid, quickLoginParam.subAppid, a17.f422957d, 0, u.f422927d0, util.getRequestInitTime(), async_contextVar._tmp_pwd, 4, this.mMiscBitmap, this.mSubSigMap, quickLoginParam.dstSubAppidList, quickLoginParam.sigMap, quickLoginParam.subAppid, u.B, 0, 0, 1, u.f422924a0, wUserSigInfo);
        if (a18 == 204) {
            util.LOGI("quickLoginByWeChat seq:" + a17.f422959f + " ret:SEC_GUID", "");
            a18 = new p(a17).a(this.mMiscBitmap, this.mSubSigMap, quickLoginParam.dstSubAppidList, wUserSigInfo);
        }
        int i46 = a18;
        if (i46 != 0) {
            util.LOGI("quickLoginByWeChat seq:" + a17.f422959f + " ret:" + i46, "");
            return i46;
        }
        WloginSigInfo d16 = a17.d(a17.f422957d, quickLoginParam.appid);
        if (d16 == null) {
            util.LOGI("quickLoginByWeChat WloginSigInfo is null", "");
            return -1004;
        }
        wUserSigInfo.get_clone(d16);
        Ticket GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (GetUserSigInfoTicket == null) {
            GetUserSigInfoTicket = new Ticket();
        }
        Ticket ticket2 = GetUserSigInfoTicket;
        u.f422936m0.commit_t2(a17.f422957d, a17.f422958e, util.format_ret_code(i46), i46);
        if (i46 != 0) {
            str = " ret ";
            async_contextVar2 = async_contextVar;
            str2 = "quickLoginByWeChat seq:";
            str3 = "";
            i16 = i46;
            ticket = ticket2;
            if (i16 != 2 && i16 != 160) {
                uVar = a17;
                RequestReportError(0, ticket._sig, ticket._sig_key, a17.f422957d, async_contextVar2._appid, 0);
                tlv_t150Var = uVar.f422956c;
                if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                    this.mG.f422956c = uVar.f422956c;
                    RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, async_contextVar2._appid, 1);
                }
                oicq.wlogin_sdk.report.b.a();
                u.a();
                uVar.b();
                util.LOGI(str2 + uVar.f422959f + str + i16, str3);
                return i16;
            }
        } else {
            byte[] bArr9 = ticket2._sig;
            if (bArr9 != null && bArr9.length != 0) {
                str2 = "quickLoginByWeChat seq:";
                str3 = "";
                str = " ret ";
                i16 = i46;
                async_contextVar2 = async_contextVar;
                ticket = ticket2;
                RequestReport(0, bArr9, ticket2._sig_key, a17.f422957d, async_contextVar._appid);
            } else {
                str = " ret ";
                async_contextVar2 = async_contextVar;
                str2 = "quickLoginByWeChat seq:";
                str3 = "";
                i16 = i46;
                ticket = ticket2;
            }
        }
        uVar = a17;
        tlv_t150Var = uVar.f422956c;
        if (tlv_t150Var != null) {
            this.mG.f422956c = uVar.f422956c;
            RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, async_contextVar2._appid, 1);
        }
        oicq.wlogin_sdk.report.b.a();
        u.a();
        uVar.b();
        util.LOGI(str2 + uVar.f422959f + str + i16, str3);
        return i16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0195 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0282  */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object, byte[]] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int quickRegisterCheckAccount(long j3, long j16, int i3, int i16, byte[] bArr, WUserSigInfo wUserSigInfo) {
        RegTLV regTLV;
        byte[] buf;
        RegTLV regTLV2;
        byte[] bArr2 = bArr;
        if (bArr2 != null && wUserSigInfo != null) {
            util.LOGI("quickRegisterCheckAccount " + j3 + " appid " + j16, "" + j3);
            Ticket GetLocalTicket = GetLocalTicket("" + j3, j16, 64);
            if (GetLocalTicket == null) {
                util.LOGI("quickRegisterCheckAccount no key", "" + j3);
                return -1004;
            }
            byte[] bArr3 = GetLocalTicket._sig;
            if (bArr3 != null && bArr3.length != 0) {
                byte[] bArr4 = GetLocalTicket._sig_key;
                if (bArr4 != null && bArr4.length != 0) {
                    TransReqContext transReqContext = new TransReqContext();
                    oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
                    cVar.f422827g = GetLocalTicket._sig_key;
                    cVar.f422825e = i16;
                    transReqContext.set_register_req();
                    transReqContext.set_subcmd(16);
                    WloginSigInfo FindUserSig = FindUserSig(j3, j16);
                    transReqContext.setSTEncryptMethod();
                    transReqContext.setWtST(FindUserSig);
                    int i17 = (int) j16;
                    byte[] bArr5 = GetLocalTicket._sig;
                    byte[] bArr6 = GetLocalTicket._sig_key;
                    byte b16 = (byte) i3;
                    byte[] GetGuid = GetGuid();
                    byte[] bArr7 = u.G;
                    byte[] generateGuid = util.generateGuid(this.mContext);
                    byte[] _imsi = util.get_IMSI(this.mContext);
                    int[] iArr = {2, 3, 10, 13, 14, 18, 19, 20, 23, 24, 37};
                    ArrayList arrayList = new ArrayList();
                    int i18 = 0;
                    int i19 = 0;
                    int i26 = 0;
                    while (true) {
                        byte[] bArr8 = bArr5;
                        if (i19 < 11) {
                            byte[] bArr9 = new byte[0];
                            int i27 = iArr[i19];
                            if (i27 != 2) {
                                if (i27 != 3) {
                                    if (i27 != 10) {
                                        if (i27 != 37) {
                                            if (i27 != 13) {
                                                if (i27 != 14) {
                                                    if (i27 != 23) {
                                                        if (i27 != 24) {
                                                            switch (i27) {
                                                                case 18:
                                                                    regTLV = new RegTLV(18);
                                                                    regTLV.setData(bArr2, bArr2.length);
                                                                    break;
                                                                case 19:
                                                                    regTLV = new RegTLV(19);
                                                                    regTLV.setData(generateGuid, generateGuid.length);
                                                                    break;
                                                                case 20:
                                                                    regTLV = new RegTLV(20);
                                                                    regTLV.setData(_imsi, _imsi.length);
                                                                    break;
                                                                default:
                                                                    buf = bArr9;
                                                                    break;
                                                            }
                                                        } else {
                                                            RegTLV regTLV3 = new RegTLV(24);
                                                            byte[] bArr10 = u.K;
                                                            regTLV3.setData(bArr10, bArr10.length);
                                                            buf = regTLV3.getBuf();
                                                        }
                                                        if (buf.length > 4) {
                                                            i18++;
                                                            i26 += buf.length;
                                                            arrayList.add(buf);
                                                        }
                                                        i19++;
                                                        bArr2 = bArr;
                                                        bArr5 = bArr8;
                                                    } else {
                                                        regTLV2 = new RegTLV(23);
                                                        regTLV2.setByte((byte) 5);
                                                    }
                                                } else {
                                                    regTLV2 = new RegTLV(14);
                                                    regTLV2.setData(bArr7, bArr7.length);
                                                }
                                            } else {
                                                regTLV = new RegTLV(13);
                                                regTLV.setInt(i16);
                                            }
                                        } else {
                                            regTLV = new RegTLV(37);
                                            regTLV.setShort(u.f422942s0);
                                        }
                                    } else {
                                        regTLV2 = new RegTLV(10);
                                        regTLV2.setData(GetGuid, GetGuid.length);
                                    }
                                    buf = regTLV2.getBuf();
                                    if (buf.length > 4) {
                                    }
                                    i19++;
                                    bArr2 = bArr;
                                    bArr5 = bArr8;
                                } else {
                                    regTLV = new RegTLV(3);
                                    regTLV.setByte(b16);
                                }
                            } else {
                                regTLV = new RegTLV(2);
                                regTLV.setInt(i17);
                            }
                            buf = regTLV.getBuf();
                            if (buf.length > 4) {
                            }
                            i19++;
                            bArr2 = bArr;
                            bArr5 = bArr8;
                        } else {
                            int i28 = i26 + 2;
                            ?? r46 = new byte[i28];
                            int i29 = 0;
                            util.int16_to_buf(r46, 0, (short) i18);
                            int i36 = 0;
                            int i37 = 2;
                            while (i36 < i18) {
                                byte[] bArr11 = (byte[]) arrayList.get(i36);
                                System.arraycopy(bArr11, i29, r46, i37, bArr11.length);
                                i37 += bArr11.length;
                                i36++;
                                i29 = 0;
                            }
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                            byte[] bArr12 = null;
                            try {
                                dataOutputStream.writeByte(1);
                                dataOutputStream.writeLong(j3);
                                dataOutputStream.writeInt(i17);
                                dataOutputStream.writeByte(8);
                                dataOutputStream.writeShort(bArr8.length);
                                dataOutputStream.write(bArr8);
                                byte[] encrypt = cryptor.encrypt(r46, 0, i28, bArr6);
                                try {
                                    if (encrypt == null) {
                                        String str = "";
                                        util.LOGI("encrypt failed", str);
                                        r46 = str;
                                    } else {
                                        r46 = "";
                                        dataOutputStream.writeShort(encrypt.length);
                                        dataOutputStream.write(encrypt);
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        dataOutputStream.close();
                                        byteArrayOutputStream.close();
                                        byte[] bArr13 = new byte[byteArray.length + 13];
                                        util.int8_to_buf(bArr13, 0, 2);
                                        util.int16_to_buf(bArr13, 1, byteArray.length + 11 + 2);
                                        util.int16_to_buf(bArr13, 3, 3);
                                        util.int16_to_buf(bArr13, 5, 16);
                                        util.int8_to_buf(bArr13, 7, 4);
                                        util.int32_to_buf(bArr13, 8, 0);
                                        System.arraycopy(byteArray, 0, bArr13, 12, byteArray.length);
                                        util.int8_to_buf(bArr13, byteArray.length + 12, 3);
                                        bArr12 = bArr13;
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    String str2 = "getRequest failed " + e.getMessage();
                                    ?? sb5 = new StringBuilder();
                                    sb5.append(r46);
                                    sb5.append(j3);
                                    util.LOGI(str2, sb5.toString());
                                    transReqContext._body = bArr12;
                                    if (bArr12 != null) {
                                    }
                                }
                            } catch (Exception e17) {
                                e = e17;
                                r46 = "";
                            }
                            transReqContext._body = bArr12;
                            if (bArr12 != null) {
                                ?? sb6 = new StringBuilder();
                                sb6.append(r46);
                                sb6.append(j3);
                                util.LOGI("req_con._body is null", sb6.toString());
                                return -1017;
                            }
                            return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
                        }
                    }
                } else {
                    util.LOGI("quickRegisterCheckAccount no key", "" + j3);
                    return -1004;
                }
            } else {
                util.LOGI("quickRegisterCheckAccount no key", "" + j3);
                return -1004;
            }
        } else {
            return -1017;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02f2  */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, byte[]] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int quickRegisterGetAccount(long j3, long j16, int i3, int i16, byte[] bArr, byte[] bArr2, String str, WUserSigInfo wUserSigInfo) {
        long j17;
        TransReqContext transReqContext;
        String str2;
        byte[] bArr3;
        String str3;
        byte[] encrypt;
        RegTLV regTLV;
        if (bArr2 == null || bArr == null || str == null || wUserSigInfo == null) {
            return -1017;
        }
        if (6 > str.length()) {
            return -1017;
        }
        util.LOGI("quickRegisterGetAccount " + j3 + " appid " + j16, "" + j3);
        Ticket GetLocalTicket = GetLocalTicket("" + j3, j16, 64);
        if (GetLocalTicket == null) {
            util.LOGI("quickRegisterCheckAccount " + j3 + " appid " + j16 + " no key", "" + j3);
            return -1004;
        }
        byte[] bArr4 = GetLocalTicket._sig;
        if (bArr4 != null && bArr4.length != 0) {
            byte[] bArr5 = GetLocalTicket._sig_key;
            if (bArr5 != null && bArr5.length != 0) {
                TransReqContext transReqContext2 = new TransReqContext();
                oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
                cVar.f422827g = GetLocalTicket._sig_key;
                cVar.f422825e = i16;
                transReqContext2.set_register_req();
                transReqContext2.set_subcmd(17);
                WloginSigInfo FindUserSig = FindUserSig(j3, j16);
                transReqContext2.setSTEncryptMethod();
                transReqContext2.setWtST(FindUserSig);
                int i17 = (int) j16;
                byte[] bArr6 = GetLocalTicket._sig;
                byte[] bArr7 = GetLocalTicket._sig_key;
                byte b16 = (byte) i3;
                byte[] GetGuid = GetGuid();
                byte[] bArr8 = u.G;
                byte[] generateGuid = util.generateGuid(this.mContext);
                byte[] _imsi = util.get_IMSI(this.mContext);
                byte[] bytes = str.getBytes();
                byte[] bArr9 = this.mRegStatus.f422823c;
                if (bArr9 != null && bArr9.length != 0) {
                    int[] iArr = {2, 3, 6, 10, 13, 14, 18, 19, 20, 23, 24, 32, 37};
                    ArrayList arrayList = new ArrayList();
                    int i18 = 0;
                    int i19 = 0;
                    int i26 = 0;
                    while (true) {
                        byte[] bArr10 = bArr9;
                        if (i19 < 13) {
                            byte[] bArr11 = new byte[0];
                            int i27 = iArr[i19];
                            int[] iArr2 = iArr;
                            if (i27 != 2) {
                                if (i27 != 3) {
                                    if (i27 != 6) {
                                        if (i27 != 10) {
                                            if (i27 != 32) {
                                                if (i27 != 37) {
                                                    if (i27 != 13) {
                                                        if (i27 != 14) {
                                                            if (i27 != 23) {
                                                                if (i27 != 24) {
                                                                    switch (i27) {
                                                                        case 18:
                                                                            regTLV = new RegTLV(18);
                                                                            regTLV.setData(bArr, bArr.length);
                                                                            break;
                                                                        case 19:
                                                                            regTLV = new RegTLV(19);
                                                                            regTLV.setData(generateGuid, generateGuid.length);
                                                                            break;
                                                                        case 20:
                                                                            regTLV = new RegTLV(20);
                                                                            regTLV.setData(_imsi, _imsi.length);
                                                                            break;
                                                                    }
                                                                } else {
                                                                    regTLV = new RegTLV(24);
                                                                    byte[] bArr12 = u.K;
                                                                    regTLV.setData(bArr12, bArr12.length);
                                                                }
                                                            } else {
                                                                regTLV = new RegTLV(23);
                                                                regTLV.setByte((byte) 5);
                                                            }
                                                        } else {
                                                            regTLV = new RegTLV(14);
                                                            regTLV.setData(bArr8, bArr8.length);
                                                        }
                                                    } else {
                                                        regTLV = new RegTLV(13);
                                                        regTLV.setInt(i16);
                                                    }
                                                } else {
                                                    regTLV = new RegTLV(37);
                                                    regTLV.setShort(u.f422942s0);
                                                }
                                            } else {
                                                regTLV = new RegTLV(32);
                                                regTLV.setData(bytes, bytes.length);
                                            }
                                        } else {
                                            regTLV = new RegTLV(10);
                                            regTLV.setData(GetGuid, GetGuid.length);
                                        }
                                    } else {
                                        regTLV = new RegTLV(6);
                                        regTLV.setData(bArr2, bArr2.length);
                                    }
                                } else {
                                    regTLV = new RegTLV(3);
                                    regTLV.setByte(b16);
                                }
                            } else {
                                regTLV = new RegTLV(2);
                                regTLV.setInt(i17);
                            }
                            bArr11 = regTLV.getBuf();
                            if (bArr11.length > 4) {
                                i18++;
                                i26 += bArr11.length;
                                arrayList.add(bArr11);
                            }
                            i19++;
                            bArr9 = bArr10;
                            iArr = iArr2;
                        } else {
                            int i28 = i26 + 2;
                            String str4 = new byte[i28];
                            int i29 = 0;
                            util.int16_to_buf(str4, 0, i18);
                            int i36 = 0;
                            int i37 = 2;
                            while (i36 < i18) {
                                byte[] bArr13 = (byte[]) arrayList.get(i36);
                                System.arraycopy(bArr13, i29, str4, i37, bArr13.length);
                                i37 += bArr13.length;
                                i36++;
                                i29 = 0;
                            }
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                            try {
                                dataOutputStream.writeByte(bArr10.length);
                                dataOutputStream.write(bArr10);
                                dataOutputStream.writeByte(1);
                                j17 = j3;
                                try {
                                    dataOutputStream.writeLong(j17);
                                    dataOutputStream.writeInt(i17);
                                    dataOutputStream.writeByte(8);
                                    dataOutputStream.writeShort(bArr6.length);
                                    dataOutputStream.write(bArr6);
                                    encrypt = cryptor.encrypt(str4, 0, i28, bArr7);
                                    try {
                                    } catch (Exception e16) {
                                        e = e16;
                                        util.LOGI("getRequest failed " + e.getMessage(), str4 + j17);
                                        str3 = str4;
                                        transReqContext = transReqContext2;
                                        bArr3 = null;
                                        str2 = str3;
                                        transReqContext._body = bArr3;
                                        if (bArr3 != null) {
                                        }
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    str4 = "";
                                    util.LOGI("getRequest failed " + e.getMessage(), str4 + j17);
                                    str3 = str4;
                                    transReqContext = transReqContext2;
                                    bArr3 = null;
                                    str2 = str3;
                                    transReqContext._body = bArr3;
                                    if (bArr3 != null) {
                                    }
                                }
                            } catch (Exception e18) {
                                e = e18;
                                j17 = j3;
                            }
                            if (encrypt == null) {
                                String str5 = "";
                                util.LOGI("encrypt failed", str5);
                                str3 = str5;
                            } else {
                                str2 = "";
                                dataOutputStream.writeShort(encrypt.length);
                                dataOutputStream.write(encrypt);
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                dataOutputStream.close();
                                byteArrayOutputStream.close();
                                bArr3 = new byte[byteArray.length + 13];
                                util.int8_to_buf(bArr3, 0, 2);
                                util.int16_to_buf(bArr3, 1, byteArray.length + 11 + 2);
                                util.int16_to_buf(bArr3, 3, 3);
                                util.int16_to_buf(bArr3, 5, 17);
                                util.int8_to_buf(bArr3, 7, 4);
                                util.int32_to_buf(bArr3, 8, 0);
                                System.arraycopy(byteArray, 0, bArr3, 12, byteArray.length);
                                util.int8_to_buf(bArr3, byteArray.length + 12, 3);
                                transReqContext = transReqContext2;
                                transReqContext._body = bArr3;
                                if (bArr3 != null) {
                                    util.LOGI("req_con._body is null", str2 + j17);
                                    return -1017;
                                }
                                return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
                            }
                        }
                    }
                } else {
                    j17 = j3;
                    String str6 = "";
                    util.LOGI("token is null", str6);
                    str3 = str6;
                }
                transReqContext = transReqContext2;
                bArr3 = null;
                str2 = str3;
                transReqContext._body = bArr3;
                if (bArr3 != null) {
                }
            } else {
                util.LOGI("quickRegisterCheckAccount no key", "" + j3);
                return -1004;
            }
        } else {
            util.LOGI("quickRegisterCheckAccount no key", "" + j3);
            return -1004;
        }
    }

    public void setBabyQFlg(boolean z16) {
        u.f422928e0 = z16;
    }

    public void setCallSource(int i3) {
        SecureRandom secureRandom = u.f422943t;
    }

    public void setForQCall() {
        u.f422940q0 = true;
        WtloginMsfListener.CLIENT_CLASSNAME = "com.tencent.lightalk.msf.core.auth.WtProvider";
    }

    public void setHasPassword(long j3, boolean z16) {
        String d16 = this.mG.d(j3);
        util.LOGI("setHasPasswd ..." + String.valueOf(d16), "");
        if (d16 == null) {
            return;
        }
        u uVar = this.mG;
        Long valueOf = Long.valueOf(j3);
        synchronized (uVar) {
            u.f422934k0.a(d16, valueOf, z16);
        }
        util.LOGI("setHasPasswd userAccount: " + d16 + ", uin: " + j3 + " hasPassword:" + z16, "");
    }

    public void setMsgType(int i3, int i16, int i17) {
        DevlockBase.a.f422759a = i3;
        DevlockBase.a.f422760b = i16;
        DevlockBase.a.f422761c = i17;
    }

    public WtloginHelper(Context context, Object obj) {
        this.mG = new u();
        this.mHelperHandler = initHelperHandler();
        this.mContext = null;
        this.mListener = null;
        this.mRegStatus = new oicq.wlogin_sdk.register.c();
        this.mMainSigMap = 16724722;
        this.mSubSigMap = 66560;
        this.mMiscBitmap = 150470524;
        this.mOpenAppid = 715019303L;
        this.mAysncSeq = 0L;
        this.mDevAsyncSeq = 0L;
        this.isForLocal = false;
        WtloginMsfListener.ticketManager = new WeakReference<>(obj);
        localInit(context, this.isForLocal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x069a, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0654 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0719  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x057c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int GetA1WithA1(String str, long j3, long j16, int i3, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16) {
        long parseLong;
        String str2;
        String str3;
        String str4;
        int i17;
        long j26;
        String str5;
        String str6;
        String str7;
        String str8;
        WUserSigInfo wUserSigInfo2;
        u uVar;
        String str9;
        int i18;
        int i19;
        u uVar2;
        byte[] bArr4;
        byte[] bArr5;
        int i26;
        String str10;
        byte[] bArr6;
        byte[] bArr7;
        byte[] bArr8;
        byte[] bArr9;
        byte[] bArr10;
        byte[] bArr11;
        byte[] bArr12;
        byte[] bArr13;
        byte[] bArr14;
        byte[] bArr15;
        byte[] bArr16;
        byte[] bArr17;
        byte[] bArr18;
        byte[] bArr19;
        byte[] bArr20;
        byte[] bArr21;
        byte[] bArr22;
        byte[] bArr23;
        int i27;
        int a16;
        long j27;
        Ticket GetUserSigInfoTicket;
        Ticket ticket;
        int i28;
        WtloginHelper wtloginHelper;
        String str11;
        tlv_t150 tlv_t150Var;
        if (str == null || bArr == null || bArr2 == null || bArr3 == null || wUserSigInfo == null || wFastLoginInfo == null) {
            return -1017;
        }
        int i29 = i3 | 192;
        if (i16 == 0) {
            new HelperThread(this, this.mHelperHandler, str, j3, j16, i29, bArr, j17, j18, j19, bArr2, bArr3, wUserSigInfo, wFastLoginInfo, "GetA1WithA1").RunReq(6);
            return -1001;
        }
        u a17 = this.mG.a(0L);
        long j28 = a17.f422959f;
        wUserSigInfo._seqence = j28;
        async_context b16 = u.b(j28);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("wtlogin login with GetA1WithA1:");
        sb5.append(str);
        sb5.append(" dwSrcAppid:");
        sb5.append(j3);
        sb5.append(" dwMainSigMap:");
        int i36 = i29;
        sb5.append(i36);
        sb5.append(" dwSubSrcAppid:");
        sb5.append(j16);
        String str12 = " dwSubSrcAppid:";
        sb5.append(" dstAppName:");
        String str13 = "wtlogin login with GetA1WithA1:";
        sb5.append(new String(bArr));
        String str14 = " dwDstAppid:";
        sb5.append(" dwDstAppid:");
        sb5.append(j18);
        sb5.append(" dwSubDstAppid:");
        sb5.append(j19);
        String str15 = " dwSubDstAppid:";
        sb5.append(" Seq:");
        String str16 = " dstAppName:";
        sb5.append(a17.f422959f);
        sb5.append(" ...");
        util.LOGI(sb5.toString(), str);
        int i37 = util.get_saved_network_type(this.mContext);
        int i38 = util.get_network_type(this.mContext);
        u.F = i38;
        if (i37 != i38) {
            util.set_net_retry_type(this.mContext, 0);
            util.save_network_type(this.mContext, u.F);
        }
        u.H = util.get_apn_string(this.mContext).getBytes();
        a17.f422958e = str;
        a17.f422957d = 0L;
        b16._sappid = j3;
        b16._appid = j3;
        b16._sub_appid = j16;
        b16._main_sigmap = i36;
        b16._last_err_msg = new ErrMsg();
        String str17 = " dwSrcAppid:";
        u.f422936m0.add_t2(new report_t2("login", new String(oicq.wlogin_sdk.utils.b.d(this.mContext)), System.currentTimeMillis(), j18, j19, null));
        if (util.check_uin_account(str).booleanValue()) {
            parseLong = Long.parseLong(str);
        } else {
            parseLong = a17.b(str);
            if (parseLong == 0) {
                util.LOGI("user:" + str + " have not found uin record.", str);
                str2 = str12;
                i19 = -1003;
                str3 = " dwDstAppid:";
                str4 = str17;
                i17 = i36;
                str9 = str;
                j26 = j3;
                str5 = " Seq:";
                str6 = str13;
                str7 = str15;
                str8 = str16;
                wUserSigInfo2 = wUserSigInfo;
                uVar = a17;
                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
                if (GetUserSigInfoTicket == null) {
                    GetUserSigInfoTicket = new Ticket();
                }
                ticket = GetUserSigInfoTicket;
                u.f422936m0.commit_t2(uVar.f422957d, uVar.f422958e, util.format_ret_code(i19), i19);
                if (i19 != 0) {
                    byte[] bArr24 = ticket._sig;
                    if (bArr24 == null || bArr24.length == 0) {
                        i28 = i19;
                        str11 = " dwMainSigMap:";
                        wtloginHelper = this;
                    } else {
                        RequestReport(0, bArr24, ticket._sig_key, uVar.f422957d, j3);
                        i28 = i19;
                        wtloginHelper = this;
                        str11 = " dwMainSigMap:";
                    }
                } else {
                    i28 = i19;
                    wtloginHelper = this;
                    str11 = " dwMainSigMap:";
                    RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, j3, 0);
                }
                tlv_t150Var = uVar.f422956c;
                if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                    wtloginHelper.mG.f422956c = uVar.f422956c;
                    RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, j3, 1);
                }
                u.a();
                uVar.b();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str6);
                sb6.append(str9);
                sb6.append(str4);
                sb6.append(j26);
                sb6.append(str11);
                sb6.append(i17);
                sb6.append(str2);
                sb6.append(j16);
                sb6.append(str8);
                sb6.append(new String(bArr));
                sb6.append(str3);
                sb6.append(j18);
                sb6.append(str7);
                sb6.append(j19);
                sb6.append(str5);
                sb6.append(uVar.f422959f);
                sb6.append(" ret=");
                int i39 = i28;
                sb6.append(i39);
                util.LOGI(sb6.toString(), str9);
                return i39;
            }
        }
        long j29 = parseLong;
        a17.f422957d = j29;
        a17.i();
        A1AndNopicSig a1AndNopicSigByAccount = getA1AndNopicSigByAccount(str, j3);
        byte[] bArr25 = a1AndNopicSigByAccount.f422867a1;
        byte[] bArr26 = a1AndNopicSigByAccount.noPicSig;
        if (bArr25 == null || bArr25.length <= 0) {
            str2 = str12;
            str3 = " dwDstAppid:";
            str4 = str17;
            i17 = i36;
            j26 = j3;
            str5 = " Seq:";
            str6 = str13;
            str7 = str15;
            str8 = str16;
            wUserSigInfo2 = wUserSigInfo;
            uVar = a17;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("user:");
            str9 = str;
            sb7.append(str9);
            sb7.append(" have no a1 or pic_sig.");
            util.LOGI(sb7.toString(), str9);
            i18 = -1016;
        } else {
            util.LOGI("user:" + str + " login with A1 exchange A1.", str);
            k kVar = new k(a17);
            int i46 = this.mMiscBitmap;
            int i47 = this.mSubSigMap;
            int i48 = u.f422953z;
            byte[] a18 = kVar.a(bArr25);
            if (a18 == null) {
                i18 = -1014;
                str2 = str12;
                str3 = " dwDstAppid:";
                uVar2 = a17;
                str4 = str17;
                i17 = i36;
                j27 = j29;
                str5 = " Seq:";
                str6 = str13;
                str7 = str15;
                str8 = str16;
                wUserSigInfo2 = wUserSigInfo;
            } else {
                int i49 = 0;
                String str18 = " Seq:";
                while (true) {
                    byte[] bArr27 = u.f422924a0;
                    tlv_t106 tlv_t106Var = new tlv_t106();
                    tlv_t144 tlv_t144Var = new tlv_t144();
                    tlv_t100 tlv_t100Var = new tlv_t100();
                    int i56 = i49;
                    tlv_t108 tlv_t108Var = new tlv_t108();
                    byte[] bArr28 = bArr26;
                    tlv_t116 tlv_t116Var = new tlv_t116();
                    tlv_t112 tlv_t112Var = new tlv_t112();
                    tlv_t142 tlv_t142Var = new tlv_t142();
                    tlv_t145 tlv_t145Var = new tlv_t145();
                    tlv_t16a tlv_t16aVar = new tlv_t16a();
                    tlv_t18 tlv_t18Var = new tlv_t18();
                    tlv_t141 tlv_t141Var = new tlv_t141();
                    tlv_t8 tlv_t8Var = new tlv_t8();
                    tlv_t109 tlv_t109Var = new tlv_t109();
                    tlv_t52d tlv_t52dVar = new tlv_t52d();
                    tlv_t124 tlv_t124Var = new tlv_t124();
                    tlv_t128 tlv_t128Var = new tlv_t128();
                    tlv_t147 tlv_t147Var = new tlv_t147();
                    tlv_t148 tlv_t148Var = new tlv_t148();
                    tlv_t153 tlv_t153Var = new tlv_t153();
                    tlv_t16e tlv_t16eVar = new tlv_t16e();
                    tlv_t172 tlv_t172Var = new tlv_t172();
                    tlv_t177 tlv_t177Var = new tlv_t177();
                    tlv_t187 tlv_t187Var = new tlv_t187();
                    tlv_t188 tlv_t188Var = new tlv_t188();
                    tlv_t194 tlv_t194Var = new tlv_t194();
                    tlv_t202 tlv_t202Var = new tlv_t202();
                    tlv_t544 tlv_t544Var = new tlv_t544();
                    tlv_t553 tlv_t553Var = new tlv_t553();
                    int i57 = i46;
                    tlv_t106Var.set_data(a18, a18.length);
                    byte[] bArr29 = tlv_t106Var.get_buf();
                    k kVar2 = kVar;
                    str3 = str14;
                    str6 = str13;
                    str2 = str12;
                    uVar2 = a17;
                    byte[] bArr30 = a18;
                    str8 = str16;
                    str4 = str17;
                    byte[] bArr31 = tlv_t100Var.get_tlv_100(j18, j19, i48, i36);
                    byte[] bArr32 = tlv_t116Var.get_tlv_116(i57, i47, null);
                    byte[] bArr33 = tlv_t142Var.get_tlv_142(u.G);
                    byte[] bArr34 = tlv_t145Var.get_tlv_145(u.D);
                    byte[] bArr35 = tlv_t18Var.get_tlv_18(j3, i48, j29, 0);
                    byte[] bArr36 = tlv_t141Var.get_tlv_141(oicq.wlogin_sdk.utils.b.d(kVar2.f422905a), u.F, u.H);
                    byte[] bArr37 = tlv_t8Var.get_tlv_8(0, u.f422951x, 0);
                    int i58 = i47;
                    byte[] bArr38 = tlv_t147Var.get_tlv_147(j3, u.I, u.J);
                    i17 = i36;
                    byte[] bArr39 = tlv_t177Var.get_tlv_177(util.BUILD_TIME, util.SDK_VERSION);
                    byte[] bArr40 = new byte[0];
                    byte[] bArr41 = new byte[0];
                    byte[] bArr42 = new byte[0];
                    byte[] bArr43 = new byte[0];
                    byte[] bArr44 = new byte[0];
                    byte[] bArr45 = new byte[0];
                    byte[] bArr46 = new byte[0];
                    byte[] bArr47 = new byte[0];
                    byte[] bArr48 = new byte[0];
                    if (bArr27 != null) {
                        bArr4 = bArr48;
                        if (bArr27.length > 0) {
                            bArr5 = tlv_t108Var.get_tlv_108(bArr27);
                            i26 = 11;
                            str10 = kVar2.f422917m.f422958e;
                            if (str10 != null || util.check_uin_account(str10).booleanValue()) {
                                bArr6 = bArr32;
                                bArr7 = bArr41;
                            } else {
                                bArr6 = bArr32;
                                i26++;
                                bArr7 = tlv_t112Var.get_tlv_112(kVar2.f422917m.f422958e.getBytes());
                            }
                            byte[] bArr49 = bArr7;
                            if (bArr28 != null || bArr28.length <= 0) {
                                bArr8 = bArr28;
                                bArr9 = bArr43;
                            } else {
                                bArr9 = tlv_t16aVar.get_tlv_16a(bArr28);
                                i26++;
                                bArr8 = bArr28;
                            }
                            bArr10 = kVar2.f422917m.f422968o;
                            byte[] bArr50 = bArr9;
                            if (bArr10 != null || bArr10.length <= 0) {
                                bArr11 = bArr44;
                            } else {
                                byte[] bArr51 = tlv_t172Var.get_tlv_172(bArr10);
                                i26++;
                                bArr11 = bArr51;
                            }
                            bArr12 = u.N;
                            byte[] bArr52 = bArr11;
                            if (bArr12 != null || bArr12.length <= 0) {
                                bArr13 = bArr45;
                            } else {
                                byte[] bArr53 = tlv_t187Var.get_tlv_187(bArr12);
                                i26++;
                                bArr13 = bArr53;
                            }
                            if (oicq.wlogin_sdk.utils.a.a(u.f422949w) != null || oicq.wlogin_sdk.utils.a.a(u.f422949w).length <= 0) {
                                bArr14 = bArr13;
                                bArr15 = bArr46;
                            } else {
                                bArr14 = bArr13;
                                byte[] bArr54 = tlv_t188Var.get_tlv_188(oicq.wlogin_sdk.utils.a.a(u.f422949w));
                                i26++;
                                bArr15 = bArr54;
                            }
                            bArr16 = u.M;
                            byte[] bArr55 = bArr15;
                            if (bArr16 != null || bArr16.length <= 0) {
                                bArr17 = bArr47;
                            } else {
                                byte[] bArr56 = tlv_t194Var.get_tlv_194(bArr16);
                                i26++;
                                bArr17 = bArr56;
                            }
                            bArr18 = u.Q;
                            if (bArr18 == null) {
                                bArr20 = bArr17;
                                if (bArr18.length > 0) {
                                    bArr19 = bArr39;
                                    bArr21 = tlv_t202Var.get_tlv_202(bArr18, u.R);
                                    i26++;
                                    str5 = str18;
                                    byte[] bArr57 = bArr8;
                                    str7 = str15;
                                    byte[] bArr58 = bArr21;
                                    byte[] bArr59 = bArr6;
                                    byte[] bArr60 = bArr14;
                                    byte[] bArr61 = bArr20;
                                    byte[] bArr62 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.utils.a.a(u.f422949w)), tlv_t52dVar.get_tlv_52d(kVar2.f422905a), tlv_t124Var.get_tlv_124(util.get_os_type(), util.get_os_version(), u.F, oicq.wlogin_sdk.utils.b.d(kVar2.f422905a), new byte[0], u.H), tlv_t128Var.get_tlv_128(u.S, u.T, u.U, 0, oicq.wlogin_sdk.utils.b.b(u.f422949w), u.D, u.O), tlv_t148Var.get_tlv_148(bArr, j17, j18, j19, bArr2, bArr3), bArr42, tlv_t153Var.get_tlv_153(u.Y), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.utils.b.b(u.f422949w)), u.b(kVar2.f422917m.f422959f)._tgtgt_key);
                                    int i59 = i26 + 1;
                                    byte[] bytes = util.SDK_VERSION.getBytes();
                                    byte[] bArr63 = new byte[u.D.length + 10 + 2 + bytes.length + 4];
                                    util.int64_to_buf(bArr63, 0, (int) j29);
                                    util.int16_to_buf(bArr63, 4, u.D.length);
                                    byte[] bArr64 = u.D;
                                    System.arraycopy(bArr64, 0, bArr63, 6, bArr64.length);
                                    int length = u.D.length + 6;
                                    util.int16_to_buf(bArr63, length, bytes.length);
                                    int i65 = length + 2;
                                    System.arraycopy(bytes, 0, bArr63, i65, bytes.length);
                                    util.int32_to_buf(bArr63, i65 + bytes.length, kVar2.f422915k);
                                    bArr22 = tlv_t544Var.get_tlv_544(String.valueOf(j29), "810_d", bArr63);
                                    bArr23 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(kVar2.f422905a, String.valueOf(j29), "0x810", "0xd"));
                                    long j36 = j29;
                                    int length2 = bArr29.length + bArr31.length + bArr5.length + bArr59.length + bArr49.length + bArr33.length + bArr34.length + bArr62.length + bArr50.length + bArr35.length + bArr36.length + bArr37.length + bArr38.length + bArr52.length + bArr19.length + bArr60.length + bArr55.length + bArr61.length + bArr58.length;
                                    if (bArr22 != null) {
                                        length2 += bArr22.length;
                                        i27 = i59 + 1;
                                    } else {
                                        i27 = i59;
                                    }
                                    if (bArr23 != null) {
                                        length2 += bArr23.length;
                                        i27++;
                                    }
                                    byte[] bArr65 = new byte[length2];
                                    int i66 = i27;
                                    System.arraycopy(bArr29, 0, bArr65, 0, bArr29.length);
                                    int length3 = bArr29.length + 0;
                                    System.arraycopy(bArr31, 0, bArr65, length3, bArr31.length);
                                    int length4 = length3 + bArr31.length;
                                    System.arraycopy(bArr5, 0, bArr65, length4, bArr5.length);
                                    int length5 = length4 + bArr5.length;
                                    System.arraycopy(bArr59, 0, bArr65, length5, bArr59.length);
                                    int length6 = length5 + bArr59.length;
                                    System.arraycopy(bArr49, 0, bArr65, length6, bArr49.length);
                                    int length7 = length6 + bArr49.length;
                                    System.arraycopy(bArr33, 0, bArr65, length7, bArr33.length);
                                    int length8 = length7 + bArr33.length;
                                    System.arraycopy(bArr34, 0, bArr65, length8, bArr34.length);
                                    int length9 = length8 + bArr34.length;
                                    System.arraycopy(bArr62, 0, bArr65, length9, bArr62.length);
                                    int length10 = length9 + bArr62.length;
                                    System.arraycopy(bArr50, 0, bArr65, length10, bArr50.length);
                                    int length11 = length10 + bArr50.length;
                                    System.arraycopy(bArr35, 0, bArr65, length11, bArr35.length);
                                    int length12 = length11 + bArr35.length;
                                    System.arraycopy(bArr36, 0, bArr65, length12, bArr36.length);
                                    int length13 = length12 + bArr36.length;
                                    System.arraycopy(bArr37, 0, bArr65, length13, bArr37.length);
                                    int length14 = length13 + bArr37.length;
                                    System.arraycopy(bArr38, 0, bArr65, length14, bArr38.length);
                                    int length15 = length14 + bArr38.length;
                                    System.arraycopy(bArr52, 0, bArr65, length15, bArr52.length);
                                    int length16 = length15 + bArr52.length;
                                    byte[] bArr66 = bArr19;
                                    System.arraycopy(bArr66, 0, bArr65, length16, bArr66.length);
                                    int length17 = length16 + bArr66.length;
                                    System.arraycopy(bArr60, 0, bArr65, length17, bArr60.length);
                                    int length18 = length17 + bArr60.length;
                                    System.arraycopy(bArr55, 0, bArr65, length18, bArr55.length);
                                    int length19 = length18 + bArr55.length;
                                    System.arraycopy(bArr61, 0, bArr65, length19, bArr61.length);
                                    int length20 = length19 + bArr61.length;
                                    System.arraycopy(bArr58, 0, bArr65, length20, bArr58.length);
                                    int length21 = length20 + bArr58.length;
                                    if (bArr22 != null) {
                                        System.arraycopy(bArr22, 0, bArr65, length21, bArr22.length);
                                        length21 += bArr22.length;
                                    }
                                    if (bArr23 != null) {
                                        System.arraycopy(bArr23, 0, bArr65, length21, bArr23.length);
                                    }
                                    kVar2.a(8001, kVar2.f422914j, kVar2.f422910f, j36, 0, 2, i48, 0, kVar2.a(bArr65, kVar2.f422915k, i66));
                                    wUserSigInfo2 = wUserSigInfo;
                                    a16 = kVar2.a(String.valueOf(kVar2.f422917m.f422957d), false, wUserSigInfo2);
                                    if (a16 != 0) {
                                        i18 = a16;
                                        j27 = j36;
                                        break;
                                    }
                                    int d16 = kVar2.d();
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append("");
                                    j27 = j36;
                                    sb8.append(j27);
                                    util.LOGI("retry num:" + i56 + " ret:" + d16, sb8.toString());
                                    if (d16 != 180) {
                                        break;
                                    }
                                    int i67 = i56 + 1;
                                    if (i56 >= 1) {
                                        break;
                                    }
                                    kVar = kVar2;
                                    j29 = j27;
                                    i47 = i58;
                                    bArr26 = bArr57;
                                    i46 = i57;
                                    str14 = str3;
                                    a17 = uVar2;
                                    str16 = str8;
                                    str17 = str4;
                                    str18 = str5;
                                    str15 = str7;
                                    i36 = i17;
                                    i49 = i67;
                                    a18 = bArr30;
                                    str13 = str6;
                                    str12 = str2;
                                } else {
                                    bArr19 = bArr39;
                                }
                            } else {
                                bArr19 = bArr39;
                                bArr20 = bArr17;
                            }
                            bArr21 = bArr4;
                            str5 = str18;
                            byte[] bArr572 = bArr8;
                            str7 = str15;
                            byte[] bArr582 = bArr21;
                            byte[] bArr592 = bArr6;
                            byte[] bArr602 = bArr14;
                            byte[] bArr612 = bArr20;
                            byte[] bArr622 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.utils.a.a(u.f422949w)), tlv_t52dVar.get_tlv_52d(kVar2.f422905a), tlv_t124Var.get_tlv_124(util.get_os_type(), util.get_os_version(), u.F, oicq.wlogin_sdk.utils.b.d(kVar2.f422905a), new byte[0], u.H), tlv_t128Var.get_tlv_128(u.S, u.T, u.U, 0, oicq.wlogin_sdk.utils.b.b(u.f422949w), u.D, u.O), tlv_t148Var.get_tlv_148(bArr, j17, j18, j19, bArr2, bArr3), bArr42, tlv_t153Var.get_tlv_153(u.Y), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.utils.b.b(u.f422949w)), u.b(kVar2.f422917m.f422959f)._tgtgt_key);
                            int i592 = i26 + 1;
                            byte[] bytes2 = util.SDK_VERSION.getBytes();
                            byte[] bArr632 = new byte[u.D.length + 10 + 2 + bytes2.length + 4];
                            util.int64_to_buf(bArr632, 0, (int) j29);
                            util.int16_to_buf(bArr632, 4, u.D.length);
                            byte[] bArr642 = u.D;
                            System.arraycopy(bArr642, 0, bArr632, 6, bArr642.length);
                            int length22 = u.D.length + 6;
                            util.int16_to_buf(bArr632, length22, bytes2.length);
                            int i652 = length22 + 2;
                            System.arraycopy(bytes2, 0, bArr632, i652, bytes2.length);
                            util.int32_to_buf(bArr632, i652 + bytes2.length, kVar2.f422915k);
                            bArr22 = tlv_t544Var.get_tlv_544(String.valueOf(j29), "810_d", bArr632);
                            bArr23 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(kVar2.f422905a, String.valueOf(j29), "0x810", "0xd"));
                            long j362 = j29;
                            int length23 = bArr29.length + bArr31.length + bArr5.length + bArr592.length + bArr49.length + bArr33.length + bArr34.length + bArr622.length + bArr50.length + bArr35.length + bArr36.length + bArr37.length + bArr38.length + bArr52.length + bArr19.length + bArr602.length + bArr55.length + bArr612.length + bArr582.length;
                            if (bArr22 != null) {
                            }
                            if (bArr23 != null) {
                            }
                            byte[] bArr652 = new byte[length23];
                            int i662 = i27;
                            System.arraycopy(bArr29, 0, bArr652, 0, bArr29.length);
                            int length32 = bArr29.length + 0;
                            System.arraycopy(bArr31, 0, bArr652, length32, bArr31.length);
                            int length42 = length32 + bArr31.length;
                            System.arraycopy(bArr5, 0, bArr652, length42, bArr5.length);
                            int length52 = length42 + bArr5.length;
                            System.arraycopy(bArr592, 0, bArr652, length52, bArr592.length);
                            int length62 = length52 + bArr592.length;
                            System.arraycopy(bArr49, 0, bArr652, length62, bArr49.length);
                            int length72 = length62 + bArr49.length;
                            System.arraycopy(bArr33, 0, bArr652, length72, bArr33.length);
                            int length82 = length72 + bArr33.length;
                            System.arraycopy(bArr34, 0, bArr652, length82, bArr34.length);
                            int length92 = length82 + bArr34.length;
                            System.arraycopy(bArr622, 0, bArr652, length92, bArr622.length);
                            int length102 = length92 + bArr622.length;
                            System.arraycopy(bArr50, 0, bArr652, length102, bArr50.length);
                            int length112 = length102 + bArr50.length;
                            System.arraycopy(bArr35, 0, bArr652, length112, bArr35.length);
                            int length122 = length112 + bArr35.length;
                            System.arraycopy(bArr36, 0, bArr652, length122, bArr36.length);
                            int length132 = length122 + bArr36.length;
                            System.arraycopy(bArr37, 0, bArr652, length132, bArr37.length);
                            int length142 = length132 + bArr37.length;
                            System.arraycopy(bArr38, 0, bArr652, length142, bArr38.length);
                            int length152 = length142 + bArr38.length;
                            System.arraycopy(bArr52, 0, bArr652, length152, bArr52.length);
                            int length162 = length152 + bArr52.length;
                            byte[] bArr662 = bArr19;
                            System.arraycopy(bArr662, 0, bArr652, length162, bArr662.length);
                            int length172 = length162 + bArr662.length;
                            System.arraycopy(bArr602, 0, bArr652, length172, bArr602.length);
                            int length182 = length172 + bArr602.length;
                            System.arraycopy(bArr55, 0, bArr652, length182, bArr55.length);
                            int length192 = length182 + bArr55.length;
                            System.arraycopy(bArr612, 0, bArr652, length192, bArr612.length);
                            int length202 = length192 + bArr612.length;
                            System.arraycopy(bArr582, 0, bArr652, length202, bArr582.length);
                            int length212 = length202 + bArr582.length;
                            if (bArr22 != null) {
                            }
                            if (bArr23 != null) {
                            }
                            kVar2.a(8001, kVar2.f422914j, kVar2.f422910f, j362, 0, 2, i48, 0, kVar2.a(bArr652, kVar2.f422915k, i662));
                            wUserSigInfo2 = wUserSigInfo;
                            a16 = kVar2.a(String.valueOf(kVar2.f422917m.f422957d), false, wUserSigInfo2);
                            if (a16 != 0) {
                            }
                        }
                    } else {
                        bArr4 = bArr48;
                    }
                    bArr5 = bArr40;
                    i26 = 10;
                    str10 = kVar2.f422917m.f422958e;
                    if (str10 != null) {
                    }
                    bArr6 = bArr32;
                    bArr7 = bArr41;
                    byte[] bArr492 = bArr7;
                    if (bArr28 != null) {
                    }
                    bArr8 = bArr28;
                    bArr9 = bArr43;
                    bArr10 = kVar2.f422917m.f422968o;
                    byte[] bArr502 = bArr9;
                    if (bArr10 != null) {
                    }
                    bArr11 = bArr44;
                    bArr12 = u.N;
                    byte[] bArr522 = bArr11;
                    if (bArr12 != null) {
                    }
                    bArr13 = bArr45;
                    if (oicq.wlogin_sdk.utils.a.a(u.f422949w) != null) {
                    }
                    bArr14 = bArr13;
                    bArr15 = bArr46;
                    bArr16 = u.M;
                    byte[] bArr552 = bArr15;
                    if (bArr16 != null) {
                    }
                    bArr17 = bArr47;
                    bArr18 = u.Q;
                    if (bArr18 == null) {
                    }
                    bArr21 = bArr4;
                    str5 = str18;
                    byte[] bArr5722 = bArr8;
                    str7 = str15;
                    byte[] bArr5822 = bArr21;
                    byte[] bArr5922 = bArr6;
                    byte[] bArr6022 = bArr14;
                    byte[] bArr6122 = bArr20;
                    byte[] bArr6222 = tlv_t144Var.get_tlv_144(tlv_t109Var.get_tlv_109(oicq.wlogin_sdk.utils.a.a(u.f422949w)), tlv_t52dVar.get_tlv_52d(kVar2.f422905a), tlv_t124Var.get_tlv_124(util.get_os_type(), util.get_os_version(), u.F, oicq.wlogin_sdk.utils.b.d(kVar2.f422905a), new byte[0], u.H), tlv_t128Var.get_tlv_128(u.S, u.T, u.U, 0, oicq.wlogin_sdk.utils.b.b(u.f422949w), u.D, u.O), tlv_t148Var.get_tlv_148(bArr, j17, j18, j19, bArr2, bArr3), bArr42, tlv_t153Var.get_tlv_153(u.Y), tlv_t16eVar.get_tlv_16e(oicq.wlogin_sdk.utils.b.b(u.f422949w)), u.b(kVar2.f422917m.f422959f)._tgtgt_key);
                    int i5922 = i26 + 1;
                    byte[] bytes22 = util.SDK_VERSION.getBytes();
                    byte[] bArr6322 = new byte[u.D.length + 10 + 2 + bytes22.length + 4];
                    util.int64_to_buf(bArr6322, 0, (int) j29);
                    util.int16_to_buf(bArr6322, 4, u.D.length);
                    byte[] bArr6422 = u.D;
                    System.arraycopy(bArr6422, 0, bArr6322, 6, bArr6422.length);
                    int length222 = u.D.length + 6;
                    util.int16_to_buf(bArr6322, length222, bytes22.length);
                    int i6522 = length222 + 2;
                    System.arraycopy(bytes22, 0, bArr6322, i6522, bytes22.length);
                    util.int32_to_buf(bArr6322, i6522 + bytes22.length, kVar2.f422915k);
                    bArr22 = tlv_t544Var.get_tlv_544(String.valueOf(j29), "810_d", bArr6322);
                    bArr23 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(kVar2.f422905a, String.valueOf(j29), "0x810", "0xd"));
                    long j3622 = j29;
                    int length232 = bArr29.length + bArr31.length + bArr5.length + bArr5922.length + bArr492.length + bArr33.length + bArr34.length + bArr6222.length + bArr502.length + bArr35.length + bArr36.length + bArr37.length + bArr38.length + bArr522.length + bArr19.length + bArr6022.length + bArr552.length + bArr6122.length + bArr5822.length;
                    if (bArr22 != null) {
                    }
                    if (bArr23 != null) {
                    }
                    byte[] bArr6522 = new byte[length232];
                    int i6622 = i27;
                    System.arraycopy(bArr29, 0, bArr6522, 0, bArr29.length);
                    int length322 = bArr29.length + 0;
                    System.arraycopy(bArr31, 0, bArr6522, length322, bArr31.length);
                    int length422 = length322 + bArr31.length;
                    System.arraycopy(bArr5, 0, bArr6522, length422, bArr5.length);
                    int length522 = length422 + bArr5.length;
                    System.arraycopy(bArr5922, 0, bArr6522, length522, bArr5922.length);
                    int length622 = length522 + bArr5922.length;
                    System.arraycopy(bArr492, 0, bArr6522, length622, bArr492.length);
                    int length722 = length622 + bArr492.length;
                    System.arraycopy(bArr33, 0, bArr6522, length722, bArr33.length);
                    int length822 = length722 + bArr33.length;
                    System.arraycopy(bArr34, 0, bArr6522, length822, bArr34.length);
                    int length922 = length822 + bArr34.length;
                    System.arraycopy(bArr6222, 0, bArr6522, length922, bArr6222.length);
                    int length1022 = length922 + bArr6222.length;
                    System.arraycopy(bArr502, 0, bArr6522, length1022, bArr502.length);
                    int length1122 = length1022 + bArr502.length;
                    System.arraycopy(bArr35, 0, bArr6522, length1122, bArr35.length);
                    int length1222 = length1122 + bArr35.length;
                    System.arraycopy(bArr36, 0, bArr6522, length1222, bArr36.length);
                    int length1322 = length1222 + bArr36.length;
                    System.arraycopy(bArr37, 0, bArr6522, length1322, bArr37.length);
                    int length1422 = length1322 + bArr37.length;
                    System.arraycopy(bArr38, 0, bArr6522, length1422, bArr38.length);
                    int length1522 = length1422 + bArr38.length;
                    System.arraycopy(bArr522, 0, bArr6522, length1522, bArr522.length);
                    int length1622 = length1522 + bArr522.length;
                    byte[] bArr6622 = bArr19;
                    System.arraycopy(bArr6622, 0, bArr6522, length1622, bArr6622.length);
                    int length1722 = length1622 + bArr6622.length;
                    System.arraycopy(bArr6022, 0, bArr6522, length1722, bArr6022.length);
                    int length1822 = length1722 + bArr6022.length;
                    System.arraycopy(bArr552, 0, bArr6522, length1822, bArr552.length);
                    int length1922 = length1822 + bArr552.length;
                    System.arraycopy(bArr6122, 0, bArr6522, length1922, bArr6122.length);
                    int length2022 = length1922 + bArr6122.length;
                    System.arraycopy(bArr5822, 0, bArr6522, length2022, bArr5822.length);
                    int length2122 = length2022 + bArr5822.length;
                    if (bArr22 != null) {
                    }
                    if (bArr23 != null) {
                    }
                    kVar2.a(8001, kVar2.f422914j, kVar2.f422910f, j3622, 0, 2, i48, 0, kVar2.a(bArr6522, kVar2.f422915k, i6622));
                    wUserSigInfo2 = wUserSigInfo;
                    a16 = kVar2.a(String.valueOf(kVar2.f422917m.f422957d), false, wUserSigInfo2);
                    if (a16 != 0) {
                    }
                }
            }
            if (i18 != 0) {
                j26 = j3;
                uVar = uVar2;
            } else {
                j26 = j3;
                uVar = uVar2;
                WloginSigInfo d17 = uVar.d(j27, j26);
                if (d17 == null) {
                    i18 = -1004;
                } else {
                    wUserSigInfo2.get_clone(d17);
                    wFastLoginInfo.get_clone(uVar.f422961h);
                }
            }
            str9 = str;
        }
        i19 = i18;
        GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
        if (GetUserSigInfoTicket == null) {
        }
        ticket = GetUserSigInfoTicket;
        u.f422936m0.commit_t2(uVar.f422957d, uVar.f422958e, util.format_ret_code(i19), i19);
        if (i19 != 0) {
        }
        tlv_t150Var = uVar.f422956c;
        if (tlv_t150Var != null) {
            wtloginHelper.mG.f422956c = uVar.f422956c;
            RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, j3, 1);
        }
        u.a();
        uVar.b();
        StringBuilder sb62 = new StringBuilder();
        sb62.append(str6);
        sb62.append(str9);
        sb62.append(str4);
        sb62.append(j26);
        sb62.append(str11);
        sb62.append(i17);
        sb62.append(str2);
        sb62.append(j16);
        sb62.append(str8);
        sb62.append(new String(bArr));
        sb62.append(str3);
        sb62.append(j18);
        sb62.append(str7);
        sb62.append(j19);
        sb62.append(str5);
        sb62.append(uVar.f422959f);
        sb62.append(" ret=");
        int i392 = i28;
        sb62.append(i392);
        util.LOGI(sb62.toString(), str9);
        return i392;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a7 A[EDGE_INSN: B:38:0x01a7->B:31:0x01a7 BREAK  A[LOOP:0: B:23:0x00c4->B:29:0x01e6], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int RefreshPictureData(String str, WUserSigInfo wUserSigInfo, int i3) {
        long parseLong;
        boolean z16;
        q qVar;
        int i16;
        int i17;
        long[] jArr;
        int i18;
        tlv_t104 tlv_t104Var;
        int i19;
        u uVar;
        String str2;
        int a16;
        if (str == null || wUserSigInfo == null) {
            return -1017;
        }
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, str, wUserSigInfo, "RefreshPictureData").RunReq(1);
            return -1001;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        u a17 = this.mG.a(wUserSigInfo._seqence);
        long j3 = a17.f422959f;
        wUserSigInfo._seqence = j3;
        async_context b16 = u.b(j3);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("user:");
        sb5.append(str);
        String str3 = " Seq:";
        sb5.append(" Seq:");
        sb5.append(a17.f422959f);
        sb5.append(" RefreshPictureData ...");
        util.LOGI(sb5.toString(), "" + str);
        a17.f422958e = str;
        b16._last_err_msg = new ErrMsg();
        if (util.check_uin_account(str).booleanValue()) {
            parseLong = Long.parseLong(str);
        } else {
            parseLong = a17.b(str);
            if (parseLong == 0) {
                z16 = false;
                if (z16) {
                    a17.f422957d = parseLong;
                }
                qVar = new q(a17);
                i16 = this.mMiscBitmap;
                i17 = this.mSubSigMap;
                jArr = b16._sub_appid_list;
                i18 = u.f422953z;
                tlv_t104Var = u.b(qVar.f422917m.f422959f).get_t104();
                if (tlv_t104Var == null) {
                    tlv_t104Var = new tlv_t104();
                }
                i19 = 0;
                while (true) {
                    byte[] bArr = tlv_t104Var.get_data();
                    tlv_t8 tlv_t8Var = new tlv_t8();
                    tlv_t104 tlv_t104Var2 = new tlv_t104();
                    tlv_t104 tlv_t104Var3 = tlv_t104Var;
                    tlv_t116 tlv_t116Var = new tlv_t116();
                    int i26 = i19;
                    tlv_t553 tlv_t553Var = new tlv_t553();
                    uVar = a17;
                    str2 = str3;
                    byte[] bArr2 = tlv_t8Var.get_tlv_8(0, u.f422951x, 0);
                    byte[] bArr3 = tlv_t104Var2.get_tlv_104(bArr);
                    byte[] bArr4 = tlv_t116Var.get_tlv_116(i16, i17, jArr);
                    int i27 = i16;
                    byte[] bArr5 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(qVar.f422905a, String.valueOf(qVar.f422917m.f422957d), "0x810", "0x3"));
                    byte[] bArr6 = new byte[bArr2.length + bArr3.length + bArr4.length + bArr5.length];
                    System.arraycopy(bArr2, 0, bArr6, 0, bArr2.length);
                    int length = bArr2.length + 0;
                    System.arraycopy(bArr3, 0, bArr6, length, bArr3.length);
                    int length2 = length + bArr3.length;
                    System.arraycopy(bArr4, 0, bArr6, length2, bArr4.length);
                    System.arraycopy(bArr5, 0, bArr6, length2 + bArr4.length, bArr5.length);
                    qVar.a(8001, qVar.f422914j, qVar.f422910f, qVar.f422917m.f422957d, 0, 2, i18, 0, qVar.a(bArr6, qVar.f422915k, 4));
                    a16 = qVar.a(String.valueOf(qVar.f422917m.f422957d), false, wUserSigInfo);
                    if (a16 == 0) {
                        break;
                    }
                    a16 = qVar.d();
                    util.LOGI("retry num:" + i26 + " ret:" + a16, "" + qVar.f422917m.f422957d);
                    if (a16 != 180) {
                        break;
                    }
                    i19 = i26 + 1;
                    if (i26 >= 1) {
                        break;
                    }
                    tlv_t104Var = tlv_t104Var3;
                    a17 = uVar;
                    str3 = str2;
                    i16 = i27;
                }
                int i28 = a16 != 2 ? 0 : a16;
                util.LOGI("user:" + str + str2 + uVar.f422959f + " RefreshPictureData ret=" + i28, "" + str);
                return i28;
            }
        }
        z16 = true;
        if (z16) {
        }
        qVar = new q(a17);
        i16 = this.mMiscBitmap;
        i17 = this.mSubSigMap;
        jArr = b16._sub_appid_list;
        i18 = u.f422953z;
        tlv_t104Var = u.b(qVar.f422917m.f422959f).get_t104();
        if (tlv_t104Var == null) {
        }
        i19 = 0;
        while (true) {
            byte[] bArr7 = tlv_t104Var.get_data();
            tlv_t8 tlv_t8Var2 = new tlv_t8();
            tlv_t104 tlv_t104Var22 = new tlv_t104();
            tlv_t104 tlv_t104Var32 = tlv_t104Var;
            tlv_t116 tlv_t116Var2 = new tlv_t116();
            int i262 = i19;
            tlv_t553 tlv_t553Var2 = new tlv_t553();
            uVar = a17;
            str2 = str3;
            byte[] bArr22 = tlv_t8Var2.get_tlv_8(0, u.f422951x, 0);
            byte[] bArr32 = tlv_t104Var22.get_tlv_104(bArr7);
            byte[] bArr42 = tlv_t116Var2.get_tlv_116(i16, i17, jArr);
            int i272 = i16;
            byte[] bArr52 = tlv_t553Var2.get_tlv_t553(QSec.getInstance().getFeKitAttach(qVar.f422905a, String.valueOf(qVar.f422917m.f422957d), "0x810", "0x3"));
            byte[] bArr62 = new byte[bArr22.length + bArr32.length + bArr42.length + bArr52.length];
            System.arraycopy(bArr22, 0, bArr62, 0, bArr22.length);
            int length3 = bArr22.length + 0;
            System.arraycopy(bArr32, 0, bArr62, length3, bArr32.length);
            int length22 = length3 + bArr32.length;
            System.arraycopy(bArr42, 0, bArr62, length22, bArr42.length);
            System.arraycopy(bArr52, 0, bArr62, length22 + bArr42.length, bArr52.length);
            qVar.a(8001, qVar.f422914j, qVar.f422910f, qVar.f422917m.f422957d, 0, 2, i18, 0, qVar.a(bArr62, qVar.f422915k, 4));
            a16 = qVar.a(String.valueOf(qVar.f422917m.f422957d), false, wUserSigInfo);
            if (a16 == 0) {
            }
            tlv_t104Var = tlv_t104Var32;
            a17 = uVar;
            str3 = str2;
            i16 = i272;
        }
        if (a16 != 2) {
        }
        util.LOGI("user:" + str + str2 + uVar.f422959f + " RefreshPictureData ret=" + i28, "" + str);
        return i28;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0219 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int RefreshSMSData(String str, long j3, WUserSigInfo wUserSigInfo, byte[] bArr, int i3) {
        long parseLong;
        boolean z16;
        long j16;
        r rVar;
        int i16;
        int i17;
        long[] jArr;
        int i18;
        tlv_t104 tlv_t104Var;
        tlv_t174 tlv_t174Var;
        int i19;
        u uVar;
        String str2;
        String str3;
        int a16;
        String str4;
        if (str == null || wUserSigInfo == null) {
            return -1017;
        }
        String str5 = "";
        util.LOGI(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV + "RefreshSMSData _seqence:" + wUserSigInfo._seqence + " mAysncSeq:" + this.mAysncSeq, "");
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, str, j3, wUserSigInfo, bArr, "RefreshSMSData").RunReq(3);
            return -1001;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        u a17 = this.mG.a(wUserSigInfo._seqence);
        long j17 = a17.f422959f;
        wUserSigInfo._seqence = j17;
        async_context b16 = u.b(j17);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
        sb5.append("RefreshSMSData user:");
        sb5.append(str);
        String str6 = " smsAppid:";
        sb5.append(" smsAppid:");
        sb5.append(j3);
        String str7 = " Seq:";
        sb5.append(" Seq:");
        sb5.append(a17.f422959f);
        sb5.append(" RefreshSMSData ...");
        util.LOGI(sb5.toString(), "" + str);
        a17.f422958e = str;
        b16._last_err_msg = new ErrMsg();
        if (util.check_uin_account(str).booleanValue()) {
            parseLong = Long.parseLong(str);
        } else {
            parseLong = a17.b(str);
            if (parseLong == 0) {
                j16 = parseLong;
                z16 = false;
                if (z16) {
                    a17.f422957d = j16;
                }
                rVar = new r(a17);
                i16 = this.mMiscBitmap;
                i17 = this.mSubSigMap;
                jArr = b16._sub_appid_list;
                i18 = u.f422953z;
                async_context b17 = u.b(rVar.f422917m.f422959f);
                tlv_t104Var = b17.get_t104();
                if (tlv_t104Var == null) {
                    tlv_t104Var = new tlv_t104();
                }
                tlv_t174Var = b17._t174;
                if (tlv_t174Var == null) {
                    tlv_t174Var = new tlv_t174();
                }
                i19 = 0;
                while (true) {
                    byte[] bArr2 = tlv_t104Var.get_data();
                    tlv_t104 tlv_t104Var2 = tlv_t104Var;
                    byte[] bArr3 = tlv_t174Var.get_data();
                    tlv_t174 tlv_t174Var2 = tlv_t174Var;
                    tlv_t8 tlv_t8Var = new tlv_t8();
                    int i26 = i19;
                    tlv_t104 tlv_t104Var3 = new tlv_t104();
                    uVar = a17;
                    tlv_t116 tlv_t116Var = new tlv_t116();
                    str2 = str7;
                    tlv_t174 tlv_t174Var3 = new tlv_t174();
                    str3 = str6;
                    tlv_t17a tlv_t17aVar = new tlv_t17a();
                    String str8 = str5;
                    tlv_t tlv_tVar = new tlv_t(407);
                    tlv_t542 tlv_t542Var = new tlv_t542();
                    tlv_t553 tlv_t553Var = new tlv_t553();
                    byte[] bArr4 = tlv_t8Var.get_tlv_8(0, u.f422951x, 0);
                    byte[] bArr5 = tlv_t104Var3.get_tlv_104(bArr2);
                    byte[] bArr6 = tlv_t116Var.get_tlv_116(i16, i17, jArr);
                    byte[] bArr7 = tlv_t174Var3.get_tlv_174(bArr3);
                    byte[] bArr8 = tlv_t17aVar.get_tlv_17a(j3);
                    byte[] bArr9 = tlv_t542Var.get_tlv_542(bArr);
                    int i27 = i16;
                    int i28 = i17;
                    byte[] bArr10 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(rVar.f422905a, String.valueOf(rVar.f422917m.f422957d), "0x810", "0x8"));
                    tlv_tVar.set_data(new byte[]{(byte) r.f422923v}, 1);
                    byte[] bArr11 = tlv_tVar.get_buf();
                    byte[] bArr12 = new byte[bArr4.length + bArr5.length + bArr6.length + bArr7.length + bArr8.length + bArr11.length + bArr9.length + bArr10.length];
                    System.arraycopy(bArr4, 0, bArr12, 0, bArr4.length);
                    int length = bArr4.length + 0;
                    System.arraycopy(bArr5, 0, bArr12, length, bArr5.length);
                    int length2 = length + bArr5.length;
                    System.arraycopy(bArr6, 0, bArr12, length2, bArr6.length);
                    int length3 = length2 + bArr6.length;
                    System.arraycopy(bArr7, 0, bArr12, length3, bArr7.length);
                    int length4 = length3 + bArr7.length;
                    System.arraycopy(bArr8, 0, bArr12, length4, bArr8.length);
                    int length5 = length4 + bArr8.length;
                    System.arraycopy(bArr11, 0, bArr12, length5, bArr11.length);
                    int length6 = length5 + bArr11.length;
                    System.arraycopy(bArr9, 0, bArr12, length6, bArr9.length);
                    System.arraycopy(bArr10, 0, bArr12, length6 + bArr9.length, bArr10.length);
                    rVar.a(8001, rVar.f422914j, rVar.f422910f, rVar.f422917m.f422957d, 0, 2, i18, 0, rVar.a(bArr12, rVar.f422915k, 8));
                    a16 = rVar.a(String.valueOf(rVar.f422917m.f422957d), false, wUserSigInfo);
                    if (a16 == 0) {
                        str4 = str8;
                        break;
                    }
                    a16 = rVar.d();
                    StringBuilder sb6 = new StringBuilder();
                    str4 = str8;
                    sb6.append(str4);
                    sb6.append(rVar.f422917m.f422957d);
                    util.LOGI("retry num:" + i26 + " ret:" + a16, sb6.toString());
                    if (a16 != 180) {
                        break;
                    }
                    i19 = i26 + 1;
                    if (i26 >= 1) {
                        break;
                    }
                    str5 = str4;
                    tlv_t104Var = tlv_t104Var2;
                    tlv_t174Var = tlv_t174Var2;
                    a17 = uVar;
                    str7 = str2;
                    str6 = str3;
                    i16 = i27;
                    i17 = i28;
                }
                int i29 = a16 != 160 ? 0 : a16;
                util.LOGI("user:" + str + str3 + j3 + str2 + uVar.f422959f + " RefreshSMSData ret=" + i29, str4 + str);
                return i29;
            }
        }
        z16 = true;
        j16 = parseLong;
        if (z16) {
        }
        rVar = new r(a17);
        i16 = this.mMiscBitmap;
        i17 = this.mSubSigMap;
        jArr = b16._sub_appid_list;
        i18 = u.f422953z;
        async_context b172 = u.b(rVar.f422917m.f422959f);
        tlv_t104Var = b172.get_t104();
        if (tlv_t104Var == null) {
        }
        tlv_t174Var = b172._t174;
        if (tlv_t174Var == null) {
        }
        i19 = 0;
        while (true) {
            byte[] bArr22 = tlv_t104Var.get_data();
            tlv_t104 tlv_t104Var22 = tlv_t104Var;
            byte[] bArr32 = tlv_t174Var.get_data();
            tlv_t174 tlv_t174Var22 = tlv_t174Var;
            tlv_t8 tlv_t8Var2 = new tlv_t8();
            int i262 = i19;
            tlv_t104 tlv_t104Var32 = new tlv_t104();
            uVar = a17;
            tlv_t116 tlv_t116Var2 = new tlv_t116();
            str2 = str7;
            tlv_t174 tlv_t174Var32 = new tlv_t174();
            str3 = str6;
            tlv_t17a tlv_t17aVar2 = new tlv_t17a();
            String str82 = str5;
            tlv_t tlv_tVar2 = new tlv_t(407);
            tlv_t542 tlv_t542Var2 = new tlv_t542();
            tlv_t553 tlv_t553Var2 = new tlv_t553();
            byte[] bArr42 = tlv_t8Var2.get_tlv_8(0, u.f422951x, 0);
            byte[] bArr52 = tlv_t104Var32.get_tlv_104(bArr22);
            byte[] bArr62 = tlv_t116Var2.get_tlv_116(i16, i17, jArr);
            byte[] bArr72 = tlv_t174Var32.get_tlv_174(bArr32);
            byte[] bArr82 = tlv_t17aVar2.get_tlv_17a(j3);
            byte[] bArr92 = tlv_t542Var2.get_tlv_542(bArr);
            int i272 = i16;
            int i282 = i17;
            byte[] bArr102 = tlv_t553Var2.get_tlv_t553(QSec.getInstance().getFeKitAttach(rVar.f422905a, String.valueOf(rVar.f422917m.f422957d), "0x810", "0x8"));
            tlv_tVar2.set_data(new byte[]{(byte) r.f422923v}, 1);
            byte[] bArr112 = tlv_tVar2.get_buf();
            byte[] bArr122 = new byte[bArr42.length + bArr52.length + bArr62.length + bArr72.length + bArr82.length + bArr112.length + bArr92.length + bArr102.length];
            System.arraycopy(bArr42, 0, bArr122, 0, bArr42.length);
            int length7 = bArr42.length + 0;
            System.arraycopy(bArr52, 0, bArr122, length7, bArr52.length);
            int length22 = length7 + bArr52.length;
            System.arraycopy(bArr62, 0, bArr122, length22, bArr62.length);
            int length32 = length22 + bArr62.length;
            System.arraycopy(bArr72, 0, bArr122, length32, bArr72.length);
            int length42 = length32 + bArr72.length;
            System.arraycopy(bArr82, 0, bArr122, length42, bArr82.length);
            int length52 = length42 + bArr82.length;
            System.arraycopy(bArr112, 0, bArr122, length52, bArr112.length);
            int length62 = length52 + bArr112.length;
            System.arraycopy(bArr92, 0, bArr122, length62, bArr92.length);
            System.arraycopy(bArr102, 0, bArr122, length62 + bArr92.length, bArr102.length);
            rVar.a(8001, rVar.f422914j, rVar.f422910f, rVar.f422917m.f422957d, 0, 2, i18, 0, rVar.a(bArr122, rVar.f422915k, 8));
            a16 = rVar.a(String.valueOf(rVar.f422917m.f422957d), false, wUserSigInfo);
            if (a16 == 0) {
            }
            str5 = str4;
            tlv_t104Var = tlv_t104Var22;
            tlv_t174Var = tlv_t174Var22;
            a17 = uVar;
            str7 = str2;
            str6 = str3;
            i16 = i272;
            i17 = i282;
        }
        if (a16 != 160) {
        }
        util.LOGI("user:" + str + str3 + j3 + str2 + uVar.f422959f + " RefreshSMSData ret=" + i29, str4 + str);
        return i29;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int RefreshSMSVerifyLoginCode(String str, WUserSigInfo wUserSigInfo, int i3) {
        String str2;
        int a16;
        String str3;
        int i16;
        byte[] bArr;
        byte[] bArr2;
        if (str == null || str.length() == 0) {
            return -1017;
        }
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, str, wUserSigInfo, "RefreshSMSVerifyLoginCode").RunReq(14);
            return -1001;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        u a17 = this.mG.a(wUserSigInfo._seqence);
        long j3 = a17.f422959f;
        wUserSigInfo._seqence = j3;
        async_context b16 = u.b(j3);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("user:");
        sb5.append(str);
        String str4 = " Seq:";
        sb5.append(" Seq:");
        sb5.append(a17.f422959f);
        sb5.append(" RefreshSMSVerifyLoginCode ...");
        util.LOGI(sb5.toString(), str);
        a17.f422958e = str;
        b16._last_err_msg = new ErrMsg();
        a0 a0Var = new a0(a17);
        int i17 = this.mMiscBitmap;
        int i18 = this.mSubSigMap;
        int i19 = u.f422953z;
        int i26 = 0;
        while (true) {
            int[] iArr = {260, 8, 278, 1313, tlv_t553.CMD_553};
            ArrayList arrayList = new ArrayList();
            int i27 = i18;
            async_context b17 = u.b(a0Var.f422917m.f422959f);
            int i28 = 0;
            int i29 = 0;
            int i36 = 0;
            for (int i37 = 5; i28 < i37; i37 = 5) {
                int i38 = i26;
                byte[] bArr3 = new byte[0];
                int i39 = iArr[i28];
                int[] iArr2 = iArr;
                if (i39 == 8) {
                    str3 = str4;
                    i16 = i27;
                    bArr = new tlv_t8().get_tlv_8(0, u.f422951x, 0);
                } else if (i39 == 260) {
                    str3 = str4;
                    i16 = i27;
                    bArr = b17.get_t104().get_buf();
                } else if (i39 != 278) {
                    if (i39 == 1313) {
                        str3 = str4;
                        tlv_t tlv_tVar = new tlv_t(1313);
                        byte[] bArr4 = new byte[6];
                        util.int32_to_buf(bArr4, 0, u.f422942s0);
                        util.int16_to_buf(bArr4, 4, 0);
                        tlv_tVar.set_data(bArr4, 6);
                        bArr2 = tlv_tVar.get_buf();
                    } else if (i39 != 1363) {
                        str3 = str4;
                        i16 = i27;
                        bArr = bArr3;
                    } else {
                        QSec qSec = QSec.getInstance();
                        a0Var.f422917m.getClass();
                        str3 = str4;
                        bArr2 = new tlv_t553().get_tlv_t553(qSec.getFeKitAttach(u.f422949w, "", "0x810", "0x13"));
                    }
                    bArr = bArr2;
                    i16 = i27;
                } else {
                    str3 = str4;
                    i16 = i27;
                    bArr = new tlv_t116().get_tlv_116(i17, i16, null);
                }
                if (bArr.length > 4) {
                    i36++;
                    i29 += bArr.length;
                    arrayList.add(bArr);
                }
                i28++;
                i27 = i16;
                i26 = i38;
                iArr = iArr2;
                str4 = str3;
            }
            str2 = str4;
            int i46 = i26;
            int i47 = i27;
            tlv_t tlv_tVar2 = wUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(gdt_analysis_event.EVENT_FEEDBACK_CLICK));
            if (tlv_tVar2 != null) {
                byte[] bArr5 = tlv_tVar2.get_buf();
                i36++;
                i29 += bArr5.length;
                arrayList.add(bArr5);
            }
            byte[] bArr6 = new byte[i29];
            int i48 = 0;
            for (int i49 = 0; i49 < i36; i49++) {
                byte[] bArr7 = (byte[]) arrayList.get(i49);
                System.arraycopy(bArr7, 0, bArr6, i48, bArr7.length);
                i48 += bArr7.length;
            }
            a0Var.a(8001, a0Var.f422914j, a0Var.f422910f, a0Var.f422917m.f422957d, 0, 2, i19, 0, a0Var.a(bArr6, a0Var.f422915k, i36));
            a16 = a0Var.a(String.valueOf(a0Var.f422917m.f422957d), false, wUserSigInfo);
            if (a16 != 0) {
                break;
            }
            a16 = a0Var.d();
            util.LOGI("retry num:" + i46 + " ret:" + a16, "" + a0Var.f422917m.f422957d);
            if (a16 != 180) {
                break;
            }
            i26 = i46 + 1;
            if (i46 >= 1) {
                break;
            }
            i18 = i47;
            str4 = str2;
        }
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PHONE, "sub_event_0x13", String.valueOf(a16));
        aVar.f422860f = str;
        oicq.wlogin_sdk.report.c.b.a(aVar, 100);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("user:");
        sb6.append(a17.f422958e);
        sb6.append(str2);
        sb6.append(a17.f422959f);
        sb6.append(" RefreshSMSVerifyLoginCode ret=");
        sb6.append(a16 > 0 ? Integer.toHexString(a16) : Integer.valueOf(a16));
        util.LOGI(sb6.toString(), str);
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int VerifySMSVerifyLoginCode(String str, String str2, WUserSigInfo wUserSigInfo, int i3) {
        u uVar;
        String str3;
        String str4;
        String str5;
        int a16;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return -1017;
        }
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, str, str2, wUserSigInfo, "VerifySMSVerifyLoginCode").RunReq(13);
            return -1001;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        u a17 = this.mG.a(wUserSigInfo._seqence);
        long j3 = a17.f422959f;
        wUserSigInfo._seqence = j3;
        async_context b16 = u.b(j3);
        StringBuilder sb5 = new StringBuilder();
        String str6 = "user:";
        sb5.append("user:");
        sb5.append(a17.f422958e);
        String str7 = " code:";
        sb5.append(" code:");
        sb5.append(str2);
        String str8 = " Seq:";
        sb5.append(" Seq:");
        sb5.append(a17.f422959f);
        sb5.append(" VerifySMSVerifyLoginCode ...");
        util.LOGI(sb5.toString(), str);
        a17.f422958e = str;
        b16._last_err_msg = new ErrMsg();
        b16._mpasswd = util.get_mpasswd();
        tlv_t104 tlv_t104Var = b16.get_t104();
        boolean z16 = tlv_t104Var == null || tlv_t104Var.get_data_len() == 0;
        util.LOGI("VerifySMSVerifyLoginCode tokenLost = " + z16, "");
        if (z16) {
            SmsVerifyContext smsVerifyContext = (SmsVerifyContext) oicq.wlogin_sdk.contextpersist.a.a(this.mContext, SmsVerifyContext.MMKV_KEY_CONTEXT_PERSIST_SMS_VERIFY);
            util.LOGI("VerifySMSVerifyLoginCode mAysncSeq = " + this.mAysncSeq + ", smsVerifyContext = " + smsVerifyContext, "");
            if (smsVerifyContext != null) {
                b16.set_t104(smsVerifyContext.getTlv_t104());
                b16._t126 = smsVerifyContext.getTlv_t126();
                b16._msalt = smsVerifyContext.getSalt();
            }
            if (this.mAysncSeq == 0) {
                this.mAysncSeq = a17.f422959f;
            }
        }
        b0 b0Var = new b0(a17);
        int i16 = this.mMiscBitmap;
        int i17 = this.mSubSigMap;
        int i18 = u.f422953z;
        int i19 = 0;
        while (true) {
            byte[] bytes = str2.getBytes();
            uVar = a17;
            int[] iArr = {260, 8, 295, 388, 278, 1313, 322, tlv_t553.CMD_553};
            ArrayList arrayList = new ArrayList();
            str3 = str8;
            str4 = str7;
            async_context b17 = u.b(b0Var.f422917m.f422959f);
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            while (true) {
                str5 = str6;
                if (i26 >= 8) {
                    break;
                }
                byte[] bArr = new byte[0];
                int i29 = iArr[i26];
                int[] iArr2 = iArr;
                if (i29 == 8) {
                    bArr = new tlv_t8().get_tlv_8(0, u.f422951x, 0);
                } else if (i29 == 260) {
                    bArr = b17.get_t104().get_buf();
                } else if (i29 == 278) {
                    bArr = new tlv_t116().get_tlv_116(i16, i17, null);
                } else if (i29 == 295) {
                    bArr = new tlv_t127().get_tlv_127(bytes, b17._t126.get_random());
                } else if (i29 == 322) {
                    bArr = new tlv_t142().get_tlv_142(u.G);
                    util.LOGI("cmd 0x12 add apk name:" + Arrays.toString(u.G));
                } else if (i29 == 388) {
                    bArr = new tlv_t184().get_tlv_184(b17._msalt, b17._mpasswd);
                } else if (i29 == 1313) {
                    tlv_t tlv_tVar = new tlv_t(1313);
                    byte[] bArr2 = new byte[6];
                    util.int32_to_buf(bArr2, 0, u.f422942s0);
                    util.int16_to_buf(bArr2, 4, 0);
                    tlv_tVar.set_data(bArr2, 6);
                    bArr = tlv_tVar.get_buf();
                } else if (i29 == 1363) {
                    QSec qSec = QSec.getInstance();
                    b0Var.f422917m.getClass();
                    bArr = new tlv_t553().get_tlv_t553(qSec.getFeKitAttach(u.f422949w, "", "0x810", "0x12"));
                }
                if (bArr.length > 4) {
                    i28++;
                    i27 += bArr.length;
                    arrayList.add(bArr);
                }
                i26++;
                iArr = iArr2;
                str6 = str5;
            }
            tlv_t tlv_tVar2 = wUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(gdt_analysis_event.EVENT_FEEDBACK_CLICK));
            if (tlv_tVar2 != null) {
                byte[] bArr3 = tlv_tVar2.get_buf();
                i28++;
                i27 += bArr3.length;
                arrayList.add(bArr3);
            }
            int i36 = i27;
            int i37 = i28;
            for (Integer num : wUserSigInfo.extraLoginTLVMap.keySet()) {
                byte[] bArr4 = wUserSigInfo.extraLoginTLVMap.get(num).get_buf();
                i36 += bArr4.length;
                arrayList.add(bArr4);
                i37++;
                util.LOGI("Extra Tlv from user\uff1a0x" + num);
            }
            byte[] bArr5 = new byte[i36];
            int i38 = 0;
            int i39 = 0;
            while (i38 < i37) {
                byte[] bArr6 = (byte[]) arrayList.get(i38);
                System.arraycopy(bArr6, 0, bArr5, i39, bArr6.length);
                i39 += bArr6.length;
                i38++;
                i16 = i16;
            }
            int i46 = i16;
            b0Var.a(8001, b0Var.f422914j, b0Var.f422910f, b0Var.f422917m.f422957d, 0, 2, i18, 0, b0Var.a(bArr5, b0Var.f422915k, i37));
            a16 = b0Var.a(String.valueOf(b0Var.f422917m.f422957d), false, wUserSigInfo);
            if (a16 != 0) {
                break;
            }
            a16 = b0Var.d();
            util.LOGI("retry num:" + i19 + " ret:" + a16, "" + b0Var.f422917m.f422957d);
            if (a16 != 180) {
                break;
            }
            int i47 = i19 + 1;
            if (i19 >= 1) {
                break;
            }
            i19 = i47;
            a17 = uVar;
            str8 = str3;
            str7 = str4;
            str6 = str5;
            i16 = i46;
        }
        if (z16) {
            oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_TOKEN_LOST, "0x12", String.valueOf(a16)));
        }
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PHONE, "sub_event_0x12", String.valueOf(a16));
        aVar.f422860f = str;
        oicq.wlogin_sdk.report.c.b.a(aVar, 100);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str5);
        sb6.append(str);
        sb6.append(str4);
        sb6.append(str2);
        sb6.append(str3);
        sb6.append(uVar.f422959f);
        sb6.append(" VerifySMSVerifyLoginAccount ret=");
        sb6.append(a16 > 0 ? Integer.toHexString(a16) : Integer.valueOf(a16));
        util.LOGI(sb6.toString(), str);
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStWithPtSig(String str, String str2, QuickLoginParam quickLoginParam, int i3) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStWithQQSig(String str, QuickLoginParam quickLoginParam, int i3) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getStWithQrSig(String str, long j3, long j16, int i3, WUserSigInfo wUserSigInfo, int i16) {
        String str2;
        byte[] bArr;
        byte[] bArr2;
        int i17;
        int i18;
        Ticket GetUserSigInfoTicket;
        String str3;
        String str4;
        Ticket ticket;
        u uVar;
        int i19;
        int i26;
        String str5;
        String str6;
        String str7;
        async_context async_contextVar;
        Ticket ticket2;
        int i27;
        int i28;
        async_context async_contextVar2;
        tlv_t150 tlv_t150Var;
        byte[] bArr3;
        String str8;
        if (str == null || wUserSigInfo == null) {
            return -1017;
        }
        int i29 = i3 | 192;
        if (i16 == 0) {
            new HelperThread(this, this.mHelperHandler, str, j3, i29, j16, wUserSigInfo, "getStWithQrSig").RunReq(17);
            return -1001;
        }
        u a16 = this.mG.a(0L);
        long j17 = a16.f422959f;
        wUserSigInfo._seqence = j17;
        this.mAysncSeq = j17;
        oicq.wlogin_sdk.register.c.f422820w = "";
        async_context b16 = u.b(j17);
        util.LOGI("start getStWithQrSig:user:" + str + " appid:" + j3 + " sigMap:0x" + Integer.toHexString(i29) + " subAppid:" + j16 + " Seq:" + a16.f422959f, str);
        int i36 = util.get_saved_network_type(this.mContext);
        int i37 = util.get_network_type(this.mContext);
        u.F = i37;
        if (i36 != i37) {
            util.set_net_retry_type(this.mContext, 0);
            util.save_network_type(this.mContext, u.F);
        }
        u.H = util.get_apn_string(this.mContext).getBytes();
        if (!util.check_uin_account(str).booleanValue()) {
            util.LOGI("userAccount " + str + " isn't valid", "");
            return -1017;
        }
        long parseLong = Long.parseLong(str);
        wUserSigInfo.uin = str;
        a16.f422958e = str;
        a16.f422957d = parseLong;
        b16._sappid = j3;
        b16._appid = j3;
        b16._sub_appid_list = null;
        b16._sub_appid = j16;
        b16._main_sigmap = i29;
        b16._login_bitmap = wUserSigInfo._login_bitmap;
        b16._last_err_msg = new ErrMsg();
        byte[] bArr4 = wUserSigInfo._reserveData;
        if (bArr4 != null) {
            str2 = " appid:";
            if (bArr4.length > 3) {
                a16.f422960g = util.buf_to_int32(bArr4, 0);
                util.LOGI("MSF SSO SEQ:" + a16.f422960g, str);
                u.f422936m0.add_t2(new report_t2("login", new String(oicq.wlogin_sdk.utils.b.d(this.mContext)), System.currentTimeMillis(), j3, j16, null));
                bArr = oicq.wlogin_sdk.code2d.d.f422745l;
                if (bArr != null && bArr.length > 0) {
                    b16._tmp_pwd = bArr;
                    bArr3 = oicq.wlogin_sdk.code2d.d.f422746m;
                    b16._tmp_no_pic_sig = bArr3;
                    if (bArr3 != null || bArr3.length == 0) {
                        str8 = "no pic sig length is 0";
                    } else {
                        str8 = "no pic sig length " + b16._tmp_no_pic_sig.length;
                    }
                    util.LOGI(str8, str);
                    b16.tgtQR = oicq.wlogin_sdk.code2d.d.f422747n;
                    oicq.wlogin_sdk.code2d.d.f422745l = null;
                    oicq.wlogin_sdk.code2d.d.f422746m = null;
                    oicq.wlogin_sdk.code2d.d.f422747n = null;
                }
                bArr2 = b16._tmp_pwd;
                if (bArr2 != null || bArr2.length < 16) {
                    i17 = -1016;
                } else {
                    b16._tmp_pwd_type = 1;
                    byte[] bArr5 = wUserSigInfo._in_ksid;
                    byte[] bArr6 = (bArr5 == null || bArr5.length <= 0) ? u.f422924a0 : (byte[]) bArr5.clone();
                    if (b16._tmp_pwd_type != 0) {
                        util.LOGI("user:" + str + " login with qrsig", str);
                        j jVar = new j(a16, this.mContext);
                        jVar.f422919o = true;
                        i17 = jVar.a(j3, j16, a16.f422957d, 0, u.f422927d0, b16._tmp_pwd, b16._tmp_no_pic_sig, this.mMiscBitmap, this.mSubSigMap, (long[]) null, i29, j16, u.B, 0, 0, 1, bArr6, wUserSigInfo, true);
                    } else {
                        i17 = 0;
                    }
                    if (i17 == 204) {
                        i17 = new p(a16).a(this.mMiscBitmap, this.mSubSigMap, (long[]) null, wUserSigInfo);
                    }
                    if (i17 == 0 || i17 == 160) {
                        WloginSigInfo d16 = a16.d(parseLong, j3);
                        if (d16 == null) {
                            i17 = -1004;
                        } else {
                            wUserSigInfo.get_clone(d16);
                        }
                    }
                }
                i18 = i17;
                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                if (GetUserSigInfoTicket == null) {
                    GetUserSigInfoTicket = new Ticket();
                }
                Ticket ticket3 = GetUserSigInfoTicket;
                u.f422936m0.commit_t2(a16.f422957d, a16.f422958e, util.format_ret_code(i18), i18);
                if (i18 == 0) {
                    str3 = " sigMap:0x";
                    str4 = " subAppid:";
                    ticket = ticket3;
                    uVar = a16;
                    i19 = i18;
                    i26 = i29;
                    str5 = " Seq:";
                    str6 = str2;
                    str7 = "";
                    async_contextVar = b16;
                    if (i19 != 2 && i19 != 160) {
                        ticket2 = ticket;
                        i27 = i26;
                        i28 = i19;
                        async_contextVar2 = async_contextVar;
                        RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, async_contextVar._appid, 0);
                        tlv_t150Var = uVar.f422956c;
                        if (tlv_t150Var != null) {
                        }
                        oicq.wlogin_sdk.report.b.a();
                        u.a();
                        uVar.b();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("end getStWithQrSig user:");
                        sb5.append(str);
                        sb5.append(str6);
                        sb5.append(j3);
                        sb5.append(str3);
                        sb5.append(Integer.toHexString(i27));
                        sb5.append(str4);
                        sb5.append(j16);
                        sb5.append(str5);
                        sb5.append(uVar.f422959f);
                        sb5.append(" ret=");
                        int i38 = i28;
                        sb5.append(i38);
                        util.LOGI(sb5.toString(), str7 + uVar.f422957d);
                        return i38;
                    }
                    i27 = i26;
                    ticket2 = ticket;
                    i28 = i19;
                    async_contextVar2 = async_contextVar;
                    tlv_t150Var = uVar.f422956c;
                    if (tlv_t150Var != null) {
                    }
                    oicq.wlogin_sdk.report.b.a();
                    u.a();
                    uVar.b();
                    StringBuilder sb52 = new StringBuilder();
                    sb52.append("end getStWithQrSig user:");
                    sb52.append(str);
                    sb52.append(str6);
                    sb52.append(j3);
                    sb52.append(str3);
                    sb52.append(Integer.toHexString(i27));
                    sb52.append(str4);
                    sb52.append(j16);
                    sb52.append(str5);
                    sb52.append(uVar.f422959f);
                    sb52.append(" ret=");
                    int i382 = i28;
                    sb52.append(i382);
                    util.LOGI(sb52.toString(), str7 + uVar.f422957d);
                    return i382;
                }
                byte[] bArr7 = ticket3._sig;
                if (bArr7 == null || bArr7.length == 0) {
                    str3 = " sigMap:0x";
                    str4 = " subAppid:";
                    uVar = a16;
                    str5 = " Seq:";
                    str6 = str2;
                    str7 = "";
                    async_contextVar2 = b16;
                    ticket2 = ticket3;
                    i27 = i29;
                    i28 = i18;
                    tlv_t150Var = uVar.f422956c;
                    if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                        this.mG.f422956c = uVar.f422956c;
                        Ticket ticket4 = ticket2;
                        RequestReportError(0, ticket4._sig, ticket4._sig_key, uVar.f422957d, async_contextVar2._appid, 1);
                    }
                    oicq.wlogin_sdk.report.b.a();
                    u.a();
                    uVar.b();
                    StringBuilder sb522 = new StringBuilder();
                    sb522.append("end getStWithQrSig user:");
                    sb522.append(str);
                    sb522.append(str6);
                    sb522.append(j3);
                    sb522.append(str3);
                    sb522.append(Integer.toHexString(i27));
                    sb522.append(str4);
                    sb522.append(j16);
                    sb522.append(str5);
                    sb522.append(uVar.f422959f);
                    sb522.append(" ret=");
                    int i3822 = i28;
                    sb522.append(i3822);
                    util.LOGI(sb522.toString(), str7 + uVar.f422957d);
                    return i3822;
                }
                str5 = " Seq:";
                str4 = " subAppid:";
                str3 = " sigMap:0x";
                ticket = ticket3;
                i26 = i29;
                str6 = str2;
                async_contextVar = b16;
                uVar = a16;
                i19 = i18;
                str7 = "";
                RequestReport(0, bArr7, ticket3._sig_key, a16.f422957d, b16._appid);
                i27 = i26;
                ticket2 = ticket;
                i28 = i19;
                async_contextVar2 = async_contextVar;
                tlv_t150Var = uVar.f422956c;
                if (tlv_t150Var != null) {
                    this.mG.f422956c = uVar.f422956c;
                    Ticket ticket42 = ticket2;
                    RequestReportError(0, ticket42._sig, ticket42._sig_key, uVar.f422957d, async_contextVar2._appid, 1);
                }
                oicq.wlogin_sdk.report.b.a();
                u.a();
                uVar.b();
                StringBuilder sb5222 = new StringBuilder();
                sb5222.append("end getStWithQrSig user:");
                sb5222.append(str);
                sb5222.append(str6);
                sb5222.append(j3);
                sb5222.append(str3);
                sb5222.append(Integer.toHexString(i27));
                sb5222.append(str4);
                sb5222.append(j16);
                sb5222.append(str5);
                sb5222.append(uVar.f422959f);
                sb5222.append(" ret=");
                int i38222 = i28;
                sb5222.append(i38222);
                util.LOGI(sb5222.toString(), str7 + uVar.f422957d);
                return i38222;
            }
        } else {
            str2 = " appid:";
        }
        a16.f422960g = 0;
        u.f422936m0.add_t2(new report_t2("login", new String(oicq.wlogin_sdk.utils.b.d(this.mContext)), System.currentTimeMillis(), j3, j16, null));
        bArr = oicq.wlogin_sdk.code2d.d.f422745l;
        if (bArr != null) {
            b16._tmp_pwd = bArr;
            bArr3 = oicq.wlogin_sdk.code2d.d.f422746m;
            b16._tmp_no_pic_sig = bArr3;
            if (bArr3 != null) {
            }
            str8 = "no pic sig length is 0";
            util.LOGI(str8, str);
            b16.tgtQR = oicq.wlogin_sdk.code2d.d.f422747n;
            oicq.wlogin_sdk.code2d.d.f422745l = null;
            oicq.wlogin_sdk.code2d.d.f422746m = null;
            oicq.wlogin_sdk.code2d.d.f422747n = null;
        }
        bArr2 = b16._tmp_pwd;
        if (bArr2 != null) {
        }
        i17 = -1016;
        i18 = i17;
        GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (GetUserSigInfoTicket == null) {
        }
        Ticket ticket32 = GetUserSigInfoTicket;
        u.f422936m0.commit_t2(a16.f422957d, a16.f422958e, util.format_ret_code(i18), i18);
        if (i18 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int quickLoginByGateway(long j3, long j16, int i3, WUserSigInfo wUserSigInfo, int i16) {
        WUserSigInfo wUserSigInfo2;
        int a16;
        ArrayList arrayList;
        byte[] bArr;
        long j17;
        ArrayList arrayList2;
        String str;
        int i17;
        if (i16 == 0) {
            new HelperThread(this, this.mHelperHandler, j3, j16, i3, wUserSigInfo, "quickLoginByWeChat").RunReq(19);
            return -1001;
        }
        StringBuilder sb5 = new StringBuilder("quickLoginByGateway ");
        sb5.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
        if (wUserSigInfo == null) {
            sb5.append(",userSigInfo == null");
            wUserSigInfo2 = new WUserSigInfo();
        } else {
            wUserSigInfo2 = wUserSigInfo;
        }
        u a17 = this.mG.a(0L);
        long j18 = a17.f422959f;
        wUserSigInfo2._seqence = j18;
        this.mAysncSeq = j18;
        async_context b16 = u.b(j18);
        b16._mpasswd = util.get_mpasswd();
        b16._msalt = util.constructSalt();
        b16._sappid = j3;
        b16._appid = j3;
        b16._sub_appid = j16;
        b16._main_sigmap = i3 | 262336;
        sb5.append(",seq=");
        sb5.append(a17.f422959f);
        sb5.append(",_mpasswd=");
        sb5.append(b16._mpasswd);
        sb5.append(",_msalt=");
        sb5.append(Long.toHexString(b16._msalt));
        sb5.append(",_appid=");
        sb5.append(b16._appid);
        sb5.append(",_sub_appid=");
        sb5.append(b16._sappid);
        sb5.append(",_sappid=");
        sb5.append(b16._sub_appid);
        sb5.append(",dwMainSigMap=");
        sb5.append(b16._main_sigmap);
        v vVar = new v(a17);
        int i18 = 0;
        int i19 = 0;
        while (true) {
            HashMap<Integer, tlv_t> hashMap = wUserSigInfo2.extraLoginTLVMap;
            int[] iArr = {256, 322, 325, tlv_t183.CMD_183, 388, gdt_analysis_event.CONFIG_REPORT_FOR_MSG, 1313, tlv_t553.CMD_553};
            ArrayList arrayList3 = new ArrayList();
            StringBuilder sb6 = new StringBuilder("quickLoginByGateway.request_login_by_gateway");
            sb6.append(" getRequestBody");
            async_context b17 = u.b(vVar.f422917m.f422959f);
            int i26 = i18;
            int i27 = i26;
            int i28 = i27;
            for (int i29 = 8; i26 < i29; i29 = 8) {
                byte[] bArr2 = new byte[i18];
                int i36 = iArr[i26];
                int[] iArr2 = iArr;
                if (i36 != 256) {
                    if (i36 == 322) {
                        arrayList = arrayList3;
                        bArr = new tlv_t142().get_tlv_142(u.G);
                        sb6.append(",apk_id=");
                        str = new String(u.G);
                    } else if (i36 != 325) {
                        if (i36 != 1313) {
                            if (i36 == 1363) {
                                arrayList = arrayList3;
                                QSec qSec = QSec.getInstance();
                                vVar.f422917m.getClass();
                                bArr = new tlv_t553().get_tlv_t553(qSec.getFeKitAttach(u.f422949w, "", "0x810", "0x17"));
                            } else if (i36 == 387) {
                                arrayList = arrayList3;
                                bArr = new tlv_t183().get_tlv_183(b17._msalt);
                                sb6.append(",_msalt=");
                                j17 = b17._msalt;
                            } else if (i36 != 388) {
                                bArr = bArr2;
                                arrayList = arrayList3;
                            } else {
                                tlv_t184 tlv_t184Var = new tlv_t184();
                                arrayList = arrayList3;
                                bArr = tlv_t184Var.get_tlv_184(b17._msalt, b17._mpasswd);
                                sb6.append(",_mS2=");
                                i17 = tlv_t184Var.get_data_len();
                            }
                            if (bArr.length <= 4) {
                                i27++;
                                i28 += bArr.length;
                                arrayList2 = arrayList;
                                arrayList2.add(bArr);
                            } else {
                                arrayList2 = arrayList;
                            }
                            i26++;
                            iArr = iArr2;
                            arrayList3 = arrayList2;
                            i18 = 0;
                        } else {
                            arrayList = arrayList3;
                            tlv_t tlv_tVar = new tlv_t(1313);
                            byte[] bArr3 = new byte[6];
                            util.int32_to_buf(bArr3, 0, u.f422942s0);
                            util.int16_to_buf(bArr3, 4, 0);
                            tlv_tVar.set_data(bArr3, 6);
                            bArr = tlv_tVar.get_buf();
                            sb6.append(",_productType=");
                            i17 = u.f422942s0;
                        }
                        sb6.append(i17);
                        if (bArr.length <= 4) {
                        }
                        i26++;
                        iArr = iArr2;
                        arrayList3 = arrayList2;
                        i18 = 0;
                    } else {
                        arrayList = arrayList3;
                        bArr = new tlv_t145().get_tlv_145(u.D);
                        sb6.append(",guid=");
                        str = new String(u.D);
                    }
                    sb6.append(str);
                    if (bArr.length <= 4) {
                    }
                    i26++;
                    iArr = iArr2;
                    arrayList3 = arrayList2;
                    i18 = 0;
                } else {
                    arrayList = arrayList3;
                    bArr = new tlv_t100().get_tlv_100(b17._appid, b17._sub_appid, 0, b17._main_sigmap);
                    sb6.append(",appid=");
                    sb6.append(b17._appid);
                    sb6.append(",subAppid=");
                    j17 = b17._sub_appid;
                }
                sb6.append(j17);
                if (bArr.length <= 4) {
                }
                i26++;
                iArr = iArr2;
                arrayList3 = arrayList2;
                i18 = 0;
            }
            ArrayList arrayList4 = arrayList3;
            if (hashMap != null) {
                for (Integer num : hashMap.keySet()) {
                    tlv_t tlv_tVar2 = hashMap.get(num);
                    if (tlv_tVar2 != null) {
                        byte[] bArr4 = tlv_tVar2.get_buf();
                        i27++;
                        arrayList4.add(bArr4);
                        i28 += bArr4.length;
                        sb6.append(",key=");
                        sb6.append(num);
                        sb6.append(",Buff=");
                        sb6.append(bArr4.length);
                    }
                }
            }
            byte[] bArr5 = new byte[i28];
            int i37 = 0;
            for (int i38 = 0; i38 < i27; i38++) {
                byte[] bArr6 = (byte[]) arrayList4.get(i38);
                System.arraycopy(bArr6, 0, bArr5, i37, bArr6.length);
                i37 += bArr6.length;
            }
            sb6.append(",tlvCnt=");
            sb6.append(i27);
            util.LOGI(sb6.toString(), "");
            vVar.a(vVar.f422917m.f422957d, vVar.a(bArr5, vVar.f422915k, i27), vVar.f422918n);
            a16 = vVar.a(String.valueOf(vVar.f422917m.f422957d), false, wUserSigInfo2);
            if (a16 != 0) {
                break;
            }
            a16 = vVar.d();
            util.LOGI("quickLoginByGateway.request_login_by_gateway,retry num:" + i19 + ",ret:" + a16, "" + vVar.f422917m.f422957d);
            if (a16 != 180) {
                break;
            }
            int i39 = i19 + 1;
            if (i19 >= 1) {
                break;
            }
            i18 = 0;
            i19 = i39;
        }
        oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PHONE, "sub_event_0x17", String.valueOf(a16)), 100);
        sb5.append(",tlv104=");
        sb5.append(b16.get_t104().get_data_len());
        sb5.append(",ret=");
        sb5.append(a16);
        util.LOGI(sb5.toString(), "");
        return a16;
    }

    public int CheckPictureAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2) {
        n.f422900v = false;
        return CheckPictureAndGetSt(str, bArr, wUserSigInfo, bArr2, 0);
    }

    public int CheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, byte[] bArr3) {
        return CheckSMSAndGetSt(str, bArr, wUserSigInfo, bArr2, bArr3, 0);
    }

    public int CheckSMSVerifyLoginAccount(long j3, long j16, String str, WUserSigInfo wUserSigInfo) {
        return CheckSMSVerifyLoginAccount(j3, j16, str, 1, -1L, wUserSigInfo, 0);
    }

    public int CheckWebsigAndGetSt(String str, String str2, WUserSigInfo wUserSigInfo, byte[][] bArr) {
        n.f422900v = true;
        return CheckPictureAndGetSt(str, str2.getBytes(), wUserSigInfo, bArr, 0);
    }

    public DevlockInfo GetDevLockInfo(String str, long j3) {
        if (j3 <= 0) {
            j3 = this.mAysncSeq;
        }
        return u.b(j3)._devlock_info;
    }

    public byte[] GetPictureData(String str, long j3) {
        if (j3 <= 0) {
            j3 = this.mAysncSeq;
        }
        return u.b(j3)._t105.get_pic();
    }

    @Deprecated
    public byte[] GetPicturePrompt(String str, long j3) {
        if (j3 <= 0) {
            j3 = this.mAysncSeq;
        }
        return u.b(j3)._t165.get_data();
    }

    public String GetPicturePromptValue(String str, long j3) {
        int buf_to_int8;
        int buf_to_int82;
        int buf_to_int32;
        int i3;
        int buf_to_int322;
        byte[] GetPicturePrompt = GetPicturePrompt(str, j3);
        if (GetPicturePrompt != null && GetPicturePrompt.length > 3) {
            int i16 = 0;
            int buf_to_int323 = util.buf_to_int32(GetPicturePrompt, 0);
            int i17 = 4;
            while (i16 < buf_to_int323) {
                int i18 = i17 + 1;
                if (GetPicturePrompt.length < i18 || GetPicturePrompt.length < (buf_to_int82 = i18 + (buf_to_int8 = util.buf_to_int8(GetPicturePrompt, i17)))) {
                    break;
                }
                String str2 = new String(GetPicturePrompt, i18, buf_to_int8);
                if (GetPicturePrompt.length < buf_to_int82 + 2 || GetPicturePrompt.length < (buf_to_int322 = (i3 = buf_to_int82 + 4) + (buf_to_int32 = util.buf_to_int32(GetPicturePrompt, buf_to_int82)))) {
                    break;
                }
                String str3 = new String(GetPicturePrompt, i3, buf_to_int32);
                if (str2.equals("pic_reason")) {
                    return str3;
                }
                i16++;
                i17 = buf_to_int322;
            }
        }
        return "";
    }

    public Ticket GetPskey(String str, long j3, String[] strArr, byte[] bArr, WtTicketPromise wtTicketPromise) {
        Ticket GetTicket;
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0 || bArr == null || bArr.length == 0) {
            util.LOGI("Get open Pskey, invalid parameter", str);
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("domains", strArr);
        bundle.putByteArray(AppConstants.Key.KEY_CONNECT_DATA, bArr);
        bundle.putInt("subappid", 0);
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : strArr) {
            sb5.append(str2);
            sb5.append(",");
        }
        synchronized (GET_TICKET_LOCK) {
            util.LOGI("Get open Pskey appid " + j3 + " domains " + ((Object) sb5), str);
            GetTicket = GetTicket(str, j3, 1048576, wtTicketPromise, bundle);
        }
        return GetTicket;
    }

    public int GetStViaSMSVerifyLogin(String str, long j3, long j16, long[] jArr, int i3, WUserSigInfo wUserSigInfo) {
        byte[][] bArr = (jArr == null || jArr.length <= 0) ? null : (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, jArr.length, 0);
        util.LOGI("user:" + str + " GetStViaSMSVerifyLogin ...", str);
        return GetStWithPasswd(str, j3, i3, j16, jArr, false, oicq.wlogin_sdk.register.c.f422818u ? oicq.wlogin_sdk.register.c.f422820w : "", wUserSigInfo, bArr, true, 0);
    }

    public int GetStWithPasswd(String str, long j3, long j16, int i3, String str2, WUserSigInfo wUserSigInfo) {
        return GetStWithPasswd(str, j3, i3, j16, null, false, str2, wUserSigInfo, null, false, 0);
    }

    @Deprecated
    public int GetStWithPasswdMd5(String str, long j3, String str2, WUserSigInfo wUserSigInfo) {
        return GetStWithPasswd(str, j3, this.mMainSigMap, 1L, null, true, str2, wUserSigInfo, null, false, 0);
    }

    public int GetStWithoutPasswd(String str, long j3, long j16, long j17, int i3, WUserSigInfo wUserSigInfo) {
        return GetStWithoutPasswd(str, j3, j16, -1L, i3, j17, null, wUserSigInfo, null, null, 0, null);
    }

    public int RegGetAccount(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, int i3, WUserSigInfo wUserSigInfo) {
        if (bArr3 == null || bArr3.length <= 0) {
            return -1017;
        }
        util.LOGI("RegGetAccount ...", "");
        oicq.wlogin_sdk.register.b bVar = new oicq.wlogin_sdk.register.b();
        TransReqContext transReqContext = new TransReqContext();
        oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
        if (bArr != null) {
            cVar.f422826f = (byte[]) bArr.clone();
        } else {
            cVar.f422826f = new byte[0];
        }
        if (i3 == 4 || i3 == 5) {
            cVar.f422821a = "";
        }
        oicq.wlogin_sdk.register.c.f422818u = false;
        oicq.wlogin_sdk.register.c.f422819v = 0L;
        transReqContext.set_register_req();
        transReqContext.set_subcmd(bVar.f422816a);
        transReqContext._body = bVar.a(cVar.f422823c, bArr, bArr3, bArr4, i3, cVar.f422821a.getBytes(), bArr2, false, GetGuid(), 0L, u.G, bArr5, u.C, bArr6, wUserSigInfo.extraRegTLVMap);
        return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
    }

    public int RegSubmitMobile(byte[] bArr, byte[] bArr2, byte[] bArr3, int i3, int i16, int i17, long j3, long j16, WUserSigInfo wUserSigInfo) {
        return RegSubmitMobile(null, bArr, bArr2, bArr3, i3, i16, i17, j3, j16, wUserSigInfo, null);
    }

    public WtloginHelper(Context context, Object obj, PrivacyListener privacyListener) {
        this.mG = new u();
        this.mHelperHandler = initHelperHandler();
        this.mContext = null;
        this.mListener = null;
        this.mRegStatus = new oicq.wlogin_sdk.register.c();
        this.mMainSigMap = 16724722;
        this.mSubSigMap = 66560;
        this.mMiscBitmap = 150470524;
        this.mOpenAppid = 715019303L;
        this.mAysncSeq = 0L;
        this.mDevAsyncSeq = 0L;
        this.isForLocal = false;
        WtloginMsfListener.ticketManager = new WeakReference<>(obj);
        util.privacyListener = privacyListener;
        localInit(context, this.isForLocal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(42:200|(2:202|17)|18|(2:20|(24:22|23|(1:25)|26|(6:185|186|187|(1:195)(1:191)|192|193)|30|(1:32)|33|(1:35)|36|(14:37|(1:39)(1:184)|40|41|42|43|44|(2:47|45)|48|49|(2:52|50)|53|54|(1:180)(2:56|(1:179)(2:58|(1:61)(1:60))))|62|(1:64)(1:178)|65|(5:89|(1:91)(1:177)|176|93|(2:97|(13:99|(2:101|(11:103|104|(3:106|(2:112|(2:113|(3:117|(2:119|120)(1:122)|121)(2:123|124)))(0)|125)(6:126|(1:173)(1:130)|131|(1:133)(3:168|(1:170)(1:172)|171)|(1:135)|(4:139|(1:141)(1:167)|142|(2:144|(1:146)(3:147|(2:152|(2:153|(3:157|(2:159|160)(2:162|163)|161)(2:165|164)))(0)|166))))|69|(1:71)|72|(3:74|(1:87)(1:78)|79)(1:88)|80|(1:84)|85|86))(1:175)|174|104|(0)(0)|69|(0)|72|(0)(0)|80|(2:82|84)|85|86))(1:96))|68|69|(0)|72|(0)(0)|80|(0)|85|86))(1:199)|198|23|(0)|26|(1:28)|185|186|187|(1:189)|195|192|193|30|(0)|33|(0)|36|(15:37|(0)(0)|40|41|42|43|44|(1:45)|48|49|(1:50)|53|54|(0)(0)|60)|62|(0)(0)|65|(0)|89|(0)(0)|176|93|(0)|97|(0)|68|69|(0)|72|(0)(0)|80|(0)|85|86) */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x00f0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x00f1, code lost:
    
        oicq.wlogin_sdk.tools.util.LOGI("syncCalcPow error " + android.util.Log.getStackTraceString(r0), "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0366, code lost:
    
        if (r3 != 0) goto L95;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0315 A[EDGE_INSN: B:180:0x0315->B:62:0x0315 BREAK  A[LOOP:0: B:37:0x0143->B:60:0x062c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00e3 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:187:0x00d8, B:189:0x00e3, B:191:0x00e6, B:195:0x00e9), top: B:186:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01fa A[LOOP:1: B:45:0x01f4->B:47:0x01fa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0270 A[LOOP:2: B:50:0x026a->B:52:0x0270, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0351 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0377 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0397  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int CheckPictureAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, int i3) {
        long j3;
        u a16;
        async_context b16;
        long parseLong;
        boolean z16;
        long j16;
        String str2;
        byte[] bArr3;
        byte[] a17;
        n nVar;
        int i16;
        int i17;
        long[] jArr;
        int i18;
        boolean z17;
        tlv_t104 tlv_t104Var;
        tlv_t105 tlv_t105Var;
        tlv_t105 tlv_t105Var2;
        byte[] bArr4;
        int i19;
        async_context async_contextVar;
        u uVar;
        n nVar2;
        String str3;
        String str4;
        long j17;
        int a18;
        WtloginHelper wtloginHelper;
        async_context async_contextVar2;
        u uVar2;
        long j18;
        long parseLong2;
        int i26;
        WloginSigInfo d16;
        String str5;
        String str6;
        int i27;
        Ticket GetUserSigInfoTicket;
        Ticket ticket;
        String str7;
        WtloginHelper wtloginHelper2;
        String str8;
        async_context async_contextVar3;
        String str9;
        u uVar3;
        tlv_t150 tlv_t150Var;
        byte[] bArr5 = bArr;
        if (str == null || bArr5 == null || wUserSigInfo == null) {
            return -1017;
        }
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, str, bArr, wUserSigInfo, bArr2, "CheckPictureAndGetSt").RunReq(2);
            return -1001;
        }
        if (isGateWay(wUserSigInfo) || wUserSigInfo.businessType == 3) {
            if (wUserSigInfo._seqence == 0) {
                j3 = this.mDevAsyncSeq;
                wUserSigInfo._seqence = j3;
            }
            a16 = this.mG.a(wUserSigInfo._seqence);
            long j19 = a16.f422959f;
            wUserSigInfo._seqence = j19;
            b16 = u.b(j19);
            util.LOGI("user:" + str + " CheckPictureAndGetSt Seq:" + a16.f422959f + " ...", str);
            a16.f422958e = str;
            b16._last_err_msg = new ErrMsg();
            if (util.check_uin_account(str).booleanValue()) {
                parseLong = a16.b(str);
                if (parseLong == 0) {
                    j16 = parseLong;
                    z16 = false;
                    str2 = "";
                    if (z16) {
                        a16.f422957d = j16;
                        wUserSigInfo.uin = j16 + "";
                    }
                    bArr3 = u.f422932i0;
                    if (bArr3 != null || bArr3.length == 0) {
                        a17 = new ClientPow().a(b16._t546.get_data());
                        if (a17 != null || a17.length == 0) {
                            util.LOGI("outBuf is null", "");
                        } else {
                            u.f422932i0 = a17;
                        }
                        util.LOGI("syncCalcPow", "");
                    }
                    nVar = new n(a16);
                    i16 = this.mMiscBitmap;
                    i17 = this.mSubSigMap;
                    jArr = b16._sub_appid_list;
                    i18 = u.f422953z;
                    z17 = z16;
                    async_context b17 = u.b(nVar.f422917m.f422959f);
                    tlv_t104Var = b17.get_t104();
                    if (tlv_t104Var == null) {
                        tlv_t104Var = new tlv_t104();
                    }
                    tlv_t105Var = b17._t105;
                    if (tlv_t105Var == null) {
                        tlv_t105Var = new tlv_t105();
                    }
                    tlv_t105Var2 = tlv_t105Var;
                    bArr4 = u.f422932i0;
                    i19 = 0;
                    while (true) {
                        byte[] bArr6 = tlv_t104Var.get_data();
                        tlv_t104 tlv_t104Var2 = tlv_t104Var;
                        byte[] bArr7 = tlv_t105Var2.get_sign();
                        tlv_t105 tlv_t105Var3 = tlv_t105Var2;
                        tlv_t2 tlv_t2Var = new tlv_t2();
                        async_contextVar = b16;
                        tlv_t8 tlv_t8Var = new tlv_t8();
                        tlv_t104 tlv_t104Var3 = new tlv_t104();
                        uVar = a16;
                        tlv_t116 tlv_t116Var = new tlv_t116();
                        tlv_t193 tlv_t193Var = new tlv_t193();
                        int i28 = i19;
                        tlv_t547 tlv_t547Var = new tlv_t547();
                        nVar2 = nVar;
                        str3 = str2;
                        byte[] bArr8 = tlv_t8Var.get_tlv_8(0, u.f422951x, 0);
                        byte[] bArr9 = tlv_t104Var3.get_tlv_104(bArr6);
                        byte[] bArr10 = tlv_t116Var.get_tlv_116(i16, i17, jArr);
                        byte[] bArr11 = tlv_t547Var.get_tlv_547(bArr4);
                        byte[] bArr12 = n.f422900v ? tlv_t193Var.get_tlv_193(bArr5) : tlv_t2Var.get_tlv_2(bArr5, bArr7);
                        try {
                            j17 = Long.parseLong(wUserSigInfo.uin);
                            str4 = str3;
                        } catch (Exception e16) {
                            str4 = str3;
                            util.printException(e16, str4);
                            j17 = 0;
                        }
                        long[] jArr2 = jArr;
                        int i29 = i16;
                        byte[] bArr13 = new tlv_t544().get_tlv_544(j17, "810_2", nVar2.f422915k);
                        byte[] bArr14 = bArr4;
                        byte[] bArr15 = new tlv_t553().get_tlv_t553(QSec.getInstance().getFeKitAttach(nVar2.f422905a, String.valueOf(j17), "0x810", "0x2"));
                        int length = bArr12.length + bArr8.length + bArr9.length + bArr10.length + bArr11.length + bArr13.length + bArr15.length;
                        for (Integer num : wUserSigInfo.extraLoginTLVMap.keySet()) {
                            byte[] bArr16 = wUserSigInfo.extraLoginTLVMap.get(num).get_buf();
                            int length2 = length + bArr16.length;
                            util.LOGI("Extra Tlv key\uff1a0x" + num + " len:" + bArr16.length, str4);
                            length = length2;
                        }
                        byte[] bArr17 = new byte[length];
                        System.arraycopy(bArr12, 0, bArr17, 0, bArr12.length);
                        int length3 = bArr12.length + 0;
                        System.arraycopy(bArr8, 0, bArr17, length3, bArr8.length);
                        int length4 = length3 + bArr8.length;
                        System.arraycopy(bArr9, 0, bArr17, length4, bArr9.length);
                        int length5 = length4 + bArr9.length;
                        System.arraycopy(bArr10, 0, bArr17, length5, bArr10.length);
                        int length6 = length5 + bArr10.length;
                        System.arraycopy(bArr11, 0, bArr17, length6, bArr11.length);
                        int length7 = length6 + bArr11.length;
                        System.arraycopy(bArr13, 0, bArr17, length7, bArr13.length);
                        int length8 = length7 + bArr13.length;
                        System.arraycopy(bArr15, 0, bArr17, length8, bArr15.length);
                        int length9 = length8 + bArr15.length;
                        int i36 = 7;
                        for (Integer num2 : wUserSigInfo.extraLoginTLVMap.keySet()) {
                            byte[] bArr18 = wUserSigInfo.extraLoginTLVMap.get(num2).get_buf();
                            System.arraycopy(bArr18, 0, bArr17, length9, bArr18.length);
                            length9 += bArr18.length;
                            i36++;
                            util.LOGI("Extra Tlv from user\uff1a0x" + num2);
                        }
                        nVar2.a(8001, nVar2.f422914j, nVar2.f422910f, nVar2.f422917m.f422957d, 0, 2, i18, 0, nVar2.a(bArr17, nVar2.f422915k, i36));
                        a18 = nVar2.a(String.valueOf(nVar2.f422917m.f422957d), false, wUserSigInfo);
                        if (a18 != 0) {
                            break;
                        }
                        a18 = nVar2.d();
                        util.LOGI("retry num:" + i28 + " ret:" + a18, str4 + nVar2.f422917m.f422957d);
                        if (a18 != 180) {
                            break;
                        }
                        i19 = i28 + 1;
                        if (i28 >= 1) {
                            break;
                        }
                        bArr5 = bArr;
                        b16 = async_contextVar;
                        nVar = nVar2;
                        tlv_t104Var = tlv_t104Var2;
                        tlv_t105Var2 = tlv_t105Var3;
                        a16 = uVar;
                        jArr = jArr2;
                        i16 = i29;
                        bArr4 = bArr14;
                        str2 = str4;
                    }
                    oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x2", String.valueOf(a18));
                    aVar.f422860f = str;
                    oicq.wlogin_sdk.report.c.b.a(aVar, 100);
                    if (a18 == 204) {
                        uVar2 = uVar;
                        wtloginHelper = this;
                        async_contextVar2 = async_contextVar;
                        a18 = new p(uVar2).a(wtloginHelper.mMiscBitmap, wtloginHelper.mSubSigMap, async_contextVar2._sub_appid_list, wUserSigInfo);
                    } else {
                        wtloginHelper = this;
                        async_contextVar2 = async_contextVar;
                        uVar2 = uVar;
                    }
                    if (a18 != 0 || a18 == 160) {
                        if (util.check_uin_account(str).booleanValue()) {
                            j18 = 0;
                            parseLong2 = Long.parseLong(str);
                        } else {
                            parseLong2 = uVar2.b(str);
                            j18 = 0;
                        }
                        z17 = true;
                        if (async_contextVar2._msalt == j18 || z17) {
                            uVar2.f422957d = parseLong2;
                            wUserSigInfo.uin = parseLong2 + str4;
                            if (a18 != 160) {
                                byte[] bArr19 = wUserSigInfo._reserveData;
                                if (bArr19 != null) {
                                    i26 = 3;
                                    if (bArr19.length > 3) {
                                        uVar2.f422960g = util.buf_to_int32(bArr19, 0);
                                        util.LOGI("MSF SSO SEQ:" + uVar2.f422960g, str);
                                        d16 = uVar2.d(parseLong2, async_contextVar2._appid);
                                        if (d16 == null) {
                                            wUserSigInfo.get_clone(d16);
                                            long[] jArr3 = async_contextVar2._sub_appid_list;
                                            if (jArr3 != null && bArr2 != null && jArr3.length * 2 == bArr2.length) {
                                                int i37 = 0;
                                                while (true) {
                                                    long[] jArr4 = async_contextVar2._sub_appid_list;
                                                    if (jArr4 == null || i37 >= jArr4.length) {
                                                        break;
                                                    }
                                                    WloginSigInfo d17 = uVar2.d(parseLong2, jArr4[i37]);
                                                    if (d17 != null) {
                                                        int i38 = i37 * 2;
                                                        bArr2[i38] = (byte[]) d17._userSt_Key.clone();
                                                        bArr2[i38 + 1] = (byte[]) d17._userStSig.clone();
                                                    }
                                                    i37++;
                                                }
                                            }
                                            str5 = str4;
                                            str6 = " CheckPictureAndGetSt Seq:";
                                            a18 = 0;
                                        } else {
                                            byte[] bArr20 = wUserSigInfo._in_ksid;
                                            byte[] bArr21 = (bArr20 == null || bArr20.length <= 0) ? u.f422924a0 : (byte[]) bArr20.clone();
                                            if (async_contextVar2._tmp_pwd_type != 0) {
                                                j jVar = new j(uVar2, wtloginHelper.mContext);
                                                jVar.f422919o = true;
                                                long j26 = async_contextVar2._appid;
                                                str5 = str4;
                                                str6 = " CheckPictureAndGetSt Seq:";
                                                long j27 = async_contextVar2._sub_appid;
                                                a18 = jVar.a(j26, j27, uVar2.f422957d, 0, u.f422927d0, async_contextVar2._tmp_pwd, (byte[]) null, wtloginHelper.mMiscBitmap, wtloginHelper.mSubSigMap, async_contextVar2._sub_appid_list, async_contextVar2._main_sigmap, j27, u.B, 0, 0, 1, bArr21, wUserSigInfo, true);
                                                i27 = 0;
                                            } else {
                                                str5 = str4;
                                                str6 = " CheckPictureAndGetSt Seq:";
                                                byte[] bArr22 = new byte[4];
                                                util.int64_to_buf32(bArr22, 0, (System.currentTimeMillis() / 1000) + u.f422926c0);
                                                int i39 = async_contextVar2._isSmslogin ? i26 : 1;
                                                j jVar2 = new j(uVar2, wtloginHelper.mContext);
                                                jVar2.f422919o = true;
                                                long j28 = async_contextVar2._appid;
                                                long j29 = async_contextVar2._sub_appid;
                                                i27 = 0;
                                                a18 = jVar2.a(j28, j29, uVar2.f422957d, 0, u.f422927d0, bArr22, async_contextVar2._tmp_pwd, i39, wtloginHelper.mMiscBitmap, wtloginHelper.mSubSigMap, async_contextVar2._sub_appid_list, async_contextVar2._main_sigmap, j29, u.B, 0, 0, 1, bArr21, wUserSigInfo);
                                            }
                                            if (a18 == 204) {
                                                a18 = new p(uVar2).a(wtloginHelper.mMiscBitmap, wtloginHelper.mSubSigMap, async_contextVar2._sub_appid_list, wUserSigInfo);
                                            }
                                            if (a18 == 0 || a18 == 160) {
                                                long b18 = async_contextVar2.ifQQLoginInQim((long) u.f422942s0) ? async_contextVar2._uin : uVar2.b(str);
                                                wUserSigInfo.uin = b18 + str5;
                                                if (a18 != 160) {
                                                    WloginSigInfo d18 = uVar2.d(b18, async_contextVar2._appid);
                                                    if (d18 == null) {
                                                        a18 = -1004;
                                                    } else {
                                                        wUserSigInfo.get_clone(d18);
                                                        long[] jArr5 = async_contextVar2._sub_appid_list;
                                                        if (jArr5 != null && bArr2 != null && jArr5.length * 2 == bArr2.length) {
                                                            int i46 = i27;
                                                            while (true) {
                                                                long[] jArr6 = async_contextVar2._sub_appid_list;
                                                                if (jArr6 == null || i46 >= jArr6.length) {
                                                                    break;
                                                                }
                                                                WloginSigInfo d19 = uVar2.d(b18, jArr6[i46]);
                                                                if (d19 != null) {
                                                                    int i47 = i46 * 2;
                                                                    bArr2[i47] = (byte[]) d19._userSt_Key.clone();
                                                                    bArr2[i47 + 1] = (byte[]) d19._userStSig.clone();
                                                                }
                                                                i46++;
                                                            }
                                                        }
                                                        a18 = i27;
                                                    }
                                                }
                                            }
                                        }
                                        GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                                        if (GetUserSigInfoTicket == null) {
                                            GetUserSigInfoTicket = new Ticket();
                                        }
                                        ticket = GetUserSigInfoTicket;
                                        u.f422936m0.commit_t2(uVar2.f422957d, uVar2.f422958e, util.format_ret_code(a18), a18);
                                        if (a18 == 0) {
                                            byte[] bArr23 = ticket._sig;
                                            if (bArr23 == null || bArr23.length == 0) {
                                                str7 = str5;
                                                wtloginHelper2 = wtloginHelper;
                                                str8 = "user:";
                                                async_contextVar3 = async_contextVar2;
                                                str9 = str6;
                                            } else {
                                                str7 = str5;
                                                str8 = "user:";
                                                wtloginHelper2 = wtloginHelper;
                                                RequestReport(0, bArr23, ticket._sig_key, uVar2.f422957d, async_contextVar2._appid);
                                                str9 = str6;
                                                async_contextVar3 = async_contextVar2;
                                            }
                                            uVar3 = uVar2;
                                        } else {
                                            str7 = str5;
                                            wtloginHelper2 = wtloginHelper;
                                            str8 = "user:";
                                            async_contextVar3 = async_contextVar2;
                                            str9 = str6;
                                            uVar3 = uVar2;
                                            RequestReportError(0, ticket._sig, ticket._sig_key, uVar2.f422957d, async_contextVar3._appid, 0);
                                        }
                                        tlv_t150Var = uVar3.f422956c;
                                        if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                                            wtloginHelper2.mG.f422956c = uVar3.f422956c;
                                            RequestReportError(0, ticket._sig, ticket._sig_key, uVar3.f422957d, async_contextVar3._appid, 1);
                                        }
                                        oicq.wlogin_sdk.report.b.a();
                                        u.a();
                                        uVar3.b();
                                        util.LOGI(str8 + str + str9 + uVar3.f422959f + " ret=" + a18, str7 + uVar3.f422957d);
                                        return a18;
                                    }
                                } else {
                                    i26 = 3;
                                }
                                uVar2.f422960g = 0;
                                d16 = uVar2.d(parseLong2, async_contextVar2._appid);
                                if (d16 == null) {
                                }
                                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                                if (GetUserSigInfoTicket == null) {
                                }
                                ticket = GetUserSigInfoTicket;
                                u.f422936m0.commit_t2(uVar2.f422957d, uVar2.f422958e, util.format_ret_code(a18), a18);
                                if (a18 == 0) {
                                }
                                tlv_t150Var = uVar3.f422956c;
                                if (tlv_t150Var != null) {
                                    wtloginHelper2.mG.f422956c = uVar3.f422956c;
                                    RequestReportError(0, ticket._sig, ticket._sig_key, uVar3.f422957d, async_contextVar3._appid, 1);
                                }
                                oicq.wlogin_sdk.report.b.a();
                                u.a();
                                uVar3.b();
                                util.LOGI(str8 + str + str9 + uVar3.f422959f + " ret=" + a18, str7 + uVar3.f422957d);
                                return a18;
                            }
                        } else {
                            a18 = -1003;
                        }
                    }
                    str5 = str4;
                    str6 = " CheckPictureAndGetSt Seq:";
                    GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
                    if (GetUserSigInfoTicket == null) {
                    }
                    ticket = GetUserSigInfoTicket;
                    u.f422936m0.commit_t2(uVar2.f422957d, uVar2.f422958e, util.format_ret_code(a18), a18);
                    if (a18 == 0) {
                    }
                    tlv_t150Var = uVar3.f422956c;
                    if (tlv_t150Var != null) {
                    }
                    oicq.wlogin_sdk.report.b.a();
                    u.a();
                    uVar3.b();
                    util.LOGI(str8 + str + str9 + uVar3.f422959f + " ret=" + a18, str7 + uVar3.f422957d);
                    return a18;
                }
            } else {
                parseLong = Long.parseLong(str);
            }
            z16 = true;
            j16 = parseLong;
            str2 = "";
            if (z16) {
            }
            bArr3 = u.f422932i0;
            if (bArr3 != null) {
            }
            a17 = new ClientPow().a(b16._t546.get_data());
            if (a17 != null) {
            }
            util.LOGI("outBuf is null", "");
            util.LOGI("syncCalcPow", "");
            nVar = new n(a16);
            i16 = this.mMiscBitmap;
            i17 = this.mSubSigMap;
            jArr = b16._sub_appid_list;
            i18 = u.f422953z;
            z17 = z16;
            async_context b172 = u.b(nVar.f422917m.f422959f);
            tlv_t104Var = b172.get_t104();
            if (tlv_t104Var == null) {
            }
            tlv_t105Var = b172._t105;
            if (tlv_t105Var == null) {
            }
            tlv_t105Var2 = tlv_t105Var;
            bArr4 = u.f422932i0;
            i19 = 0;
            while (true) {
                byte[] bArr62 = tlv_t104Var.get_data();
                tlv_t104 tlv_t104Var22 = tlv_t104Var;
                byte[] bArr72 = tlv_t105Var2.get_sign();
                tlv_t105 tlv_t105Var32 = tlv_t105Var2;
                tlv_t2 tlv_t2Var2 = new tlv_t2();
                async_contextVar = b16;
                tlv_t8 tlv_t8Var2 = new tlv_t8();
                tlv_t104 tlv_t104Var32 = new tlv_t104();
                uVar = a16;
                tlv_t116 tlv_t116Var2 = new tlv_t116();
                tlv_t193 tlv_t193Var2 = new tlv_t193();
                int i282 = i19;
                tlv_t547 tlv_t547Var2 = new tlv_t547();
                nVar2 = nVar;
                str3 = str2;
                byte[] bArr82 = tlv_t8Var2.get_tlv_8(0, u.f422951x, 0);
                byte[] bArr92 = tlv_t104Var32.get_tlv_104(bArr62);
                byte[] bArr102 = tlv_t116Var2.get_tlv_116(i16, i17, jArr);
                byte[] bArr112 = tlv_t547Var2.get_tlv_547(bArr4);
                byte[] bArr122 = n.f422900v ? tlv_t193Var2.get_tlv_193(bArr5) : tlv_t2Var2.get_tlv_2(bArr5, bArr72);
                j17 = Long.parseLong(wUserSigInfo.uin);
                str4 = str3;
                long[] jArr22 = jArr;
                int i292 = i16;
                byte[] bArr132 = new tlv_t544().get_tlv_544(j17, "810_2", nVar2.f422915k);
                byte[] bArr142 = bArr4;
                byte[] bArr152 = new tlv_t553().get_tlv_t553(QSec.getInstance().getFeKitAttach(nVar2.f422905a, String.valueOf(j17), "0x810", "0x2"));
                int length10 = bArr122.length + bArr82.length + bArr92.length + bArr102.length + bArr112.length + bArr132.length + bArr152.length;
                while (r4.hasNext()) {
                }
                byte[] bArr172 = new byte[length10];
                System.arraycopy(bArr122, 0, bArr172, 0, bArr122.length);
                int length32 = bArr122.length + 0;
                System.arraycopy(bArr82, 0, bArr172, length32, bArr82.length);
                int length42 = length32 + bArr82.length;
                System.arraycopy(bArr92, 0, bArr172, length42, bArr92.length);
                int length52 = length42 + bArr92.length;
                System.arraycopy(bArr102, 0, bArr172, length52, bArr102.length);
                int length62 = length52 + bArr102.length;
                System.arraycopy(bArr112, 0, bArr172, length62, bArr112.length);
                int length72 = length62 + bArr112.length;
                System.arraycopy(bArr132, 0, bArr172, length72, bArr132.length);
                int length82 = length72 + bArr132.length;
                System.arraycopy(bArr152, 0, bArr172, length82, bArr152.length);
                int length92 = length82 + bArr152.length;
                int i362 = 7;
                while (r0.hasNext()) {
                }
                nVar2.a(8001, nVar2.f422914j, nVar2.f422910f, nVar2.f422917m.f422957d, 0, 2, i18, 0, nVar2.a(bArr172, nVar2.f422915k, i362));
                a18 = nVar2.a(String.valueOf(nVar2.f422917m.f422957d), false, wUserSigInfo);
                if (a18 != 0) {
                }
                bArr5 = bArr;
                b16 = async_contextVar;
                nVar = nVar2;
                tlv_t104Var = tlv_t104Var22;
                tlv_t105Var2 = tlv_t105Var32;
                a16 = uVar;
                jArr = jArr22;
                i16 = i292;
                bArr4 = bArr142;
                str2 = str4;
            }
            oicq.wlogin_sdk.report.c.a aVar2 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x2", String.valueOf(a18));
            aVar2.f422860f = str;
            oicq.wlogin_sdk.report.c.b.a(aVar2, 100);
            if (a18 == 204) {
            }
            if (a18 != 0) {
            }
            if (util.check_uin_account(str).booleanValue()) {
            }
            z17 = true;
            if (async_contextVar2._msalt == j18) {
            }
            uVar2.f422957d = parseLong2;
            wUserSigInfo.uin = parseLong2 + str4;
            if (a18 != 160) {
            }
            str5 = str4;
            str6 = " CheckPictureAndGetSt Seq:";
            GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
            if (GetUserSigInfoTicket == null) {
            }
            ticket = GetUserSigInfoTicket;
            u.f422936m0.commit_t2(uVar2.f422957d, uVar2.f422958e, util.format_ret_code(a18), a18);
            if (a18 == 0) {
            }
            tlv_t150Var = uVar3.f422956c;
            if (tlv_t150Var != null) {
            }
            oicq.wlogin_sdk.report.b.a();
            u.a();
            uVar3.b();
            util.LOGI(str8 + str + str9 + uVar3.f422959f + " ret=" + a18, str7 + uVar3.f422957d);
            return a18;
        }
        if (wUserSigInfo._seqence == 0) {
            j3 = this.mAysncSeq;
            wUserSigInfo._seqence = j3;
        }
        a16 = this.mG.a(wUserSigInfo._seqence);
        long j192 = a16.f422959f;
        wUserSigInfo._seqence = j192;
        b16 = u.b(j192);
        util.LOGI("user:" + str + " CheckPictureAndGetSt Seq:" + a16.f422959f + " ...", str);
        a16.f422958e = str;
        b16._last_err_msg = new ErrMsg();
        if (util.check_uin_account(str).booleanValue()) {
        }
        z16 = true;
        j16 = parseLong;
        str2 = "";
        if (z16) {
        }
        bArr3 = u.f422932i0;
        if (bArr3 != null) {
        }
        a17 = new ClientPow().a(b16._t546.get_data());
        if (a17 != null) {
        }
        util.LOGI("outBuf is null", "");
        util.LOGI("syncCalcPow", "");
        nVar = new n(a16);
        i16 = this.mMiscBitmap;
        i17 = this.mSubSigMap;
        jArr = b16._sub_appid_list;
        i18 = u.f422953z;
        z17 = z16;
        async_context b1722 = u.b(nVar.f422917m.f422959f);
        tlv_t104Var = b1722.get_t104();
        if (tlv_t104Var == null) {
        }
        tlv_t105Var = b1722._t105;
        if (tlv_t105Var == null) {
        }
        tlv_t105Var2 = tlv_t105Var;
        bArr4 = u.f422932i0;
        i19 = 0;
        while (true) {
            byte[] bArr622 = tlv_t104Var.get_data();
            tlv_t104 tlv_t104Var222 = tlv_t104Var;
            byte[] bArr722 = tlv_t105Var2.get_sign();
            tlv_t105 tlv_t105Var322 = tlv_t105Var2;
            tlv_t2 tlv_t2Var22 = new tlv_t2();
            async_contextVar = b16;
            tlv_t8 tlv_t8Var22 = new tlv_t8();
            tlv_t104 tlv_t104Var322 = new tlv_t104();
            uVar = a16;
            tlv_t116 tlv_t116Var22 = new tlv_t116();
            tlv_t193 tlv_t193Var22 = new tlv_t193();
            int i2822 = i19;
            tlv_t547 tlv_t547Var22 = new tlv_t547();
            nVar2 = nVar;
            str3 = str2;
            byte[] bArr822 = tlv_t8Var22.get_tlv_8(0, u.f422951x, 0);
            byte[] bArr922 = tlv_t104Var322.get_tlv_104(bArr622);
            byte[] bArr1022 = tlv_t116Var22.get_tlv_116(i16, i17, jArr);
            byte[] bArr1122 = tlv_t547Var22.get_tlv_547(bArr4);
            byte[] bArr1222 = n.f422900v ? tlv_t193Var22.get_tlv_193(bArr5) : tlv_t2Var22.get_tlv_2(bArr5, bArr722);
            j17 = Long.parseLong(wUserSigInfo.uin);
            str4 = str3;
            long[] jArr222 = jArr;
            int i2922 = i16;
            byte[] bArr1322 = new tlv_t544().get_tlv_544(j17, "810_2", nVar2.f422915k);
            byte[] bArr1422 = bArr4;
            byte[] bArr1522 = new tlv_t553().get_tlv_t553(QSec.getInstance().getFeKitAttach(nVar2.f422905a, String.valueOf(j17), "0x810", "0x2"));
            int length102 = bArr1222.length + bArr822.length + bArr922.length + bArr1022.length + bArr1122.length + bArr1322.length + bArr1522.length;
            while (r4.hasNext()) {
            }
            byte[] bArr1722 = new byte[length102];
            System.arraycopy(bArr1222, 0, bArr1722, 0, bArr1222.length);
            int length322 = bArr1222.length + 0;
            System.arraycopy(bArr822, 0, bArr1722, length322, bArr822.length);
            int length422 = length322 + bArr822.length;
            System.arraycopy(bArr922, 0, bArr1722, length422, bArr922.length);
            int length522 = length422 + bArr922.length;
            System.arraycopy(bArr1022, 0, bArr1722, length522, bArr1022.length);
            int length622 = length522 + bArr1022.length;
            System.arraycopy(bArr1122, 0, bArr1722, length622, bArr1122.length);
            int length722 = length622 + bArr1122.length;
            System.arraycopy(bArr1322, 0, bArr1722, length722, bArr1322.length);
            int length822 = length722 + bArr1322.length;
            System.arraycopy(bArr1522, 0, bArr1722, length822, bArr1522.length);
            int length922 = length822 + bArr1522.length;
            int i3622 = 7;
            while (r0.hasNext()) {
            }
            nVar2.a(8001, nVar2.f422914j, nVar2.f422910f, nVar2.f422917m.f422957d, 0, 2, i18, 0, nVar2.a(bArr1722, nVar2.f422915k, i3622));
            a18 = nVar2.a(String.valueOf(nVar2.f422917m.f422957d), false, wUserSigInfo);
            if (a18 != 0) {
            }
            bArr5 = bArr;
            b16 = async_contextVar;
            nVar = nVar2;
            tlv_t104Var = tlv_t104Var222;
            tlv_t105Var2 = tlv_t105Var322;
            a16 = uVar;
            jArr = jArr222;
            i16 = i2922;
            bArr4 = bArr1422;
            str2 = str4;
        }
        oicq.wlogin_sdk.report.c.a aVar22 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x2", String.valueOf(a18));
        aVar22.f422860f = str;
        oicq.wlogin_sdk.report.c.b.a(aVar22, 100);
        if (a18 == 204) {
        }
        if (a18 != 0) {
        }
        if (util.check_uin_account(str).booleanValue()) {
        }
        z17 = true;
        if (async_contextVar2._msalt == j18) {
        }
        uVar2.f422957d = parseLong2;
        wUserSigInfo.uin = parseLong2 + str4;
        if (a18 != 160) {
        }
        str5 = str4;
        str6 = " CheckPictureAndGetSt Seq:";
        GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo, 128);
        if (GetUserSigInfoTicket == null) {
        }
        ticket = GetUserSigInfoTicket;
        u.f422936m0.commit_t2(uVar2.f422957d, uVar2.f422958e, util.format_ret_code(a18), a18);
        if (a18 == 0) {
        }
        tlv_t150Var = uVar3.f422956c;
        if (tlv_t150Var != null) {
        }
        oicq.wlogin_sdk.report.b.a();
        u.a();
        uVar3.b();
        util.LOGI(str8 + str + str9 + uVar3.f422959f + " ret=" + a18, str7 + uVar3.f422957d);
        return a18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0296  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int CheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo, byte[][] bArr2, byte[] bArr3, int i3) {
        WUserSigInfo wUserSigInfo2;
        int i16;
        Ticket GetUserSigInfoTicket;
        String str2;
        Ticket ticket;
        tlv_t150 tlv_t150Var;
        SwitchListener switchListener2;
        if (str == null || bArr == null || wUserSigInfo == null) {
            return -1017;
        }
        if (i3 == 0) {
            new HelperThread(this, this.mHelperHandler, str, bArr, wUserSigInfo, bArr2, bArr3, "CheckSMSAndGetSt").RunReq(4);
            return -1001;
        }
        if (wUserSigInfo._seqence == 0) {
            wUserSigInfo._seqence = this.mAysncSeq;
        }
        u a16 = this.mG.a(wUserSigInfo._seqence);
        long j3 = a16.f422959f;
        wUserSigInfo._seqence = j3;
        async_context b16 = u.b(j3);
        util.LOGI(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV + "user:" + str + " CheckSMSAndGetSt Seq:" + a16.f422959f + "_msalt" + Long.toHexString(b16._msalt) + " ...", str);
        a16.f422958e = str;
        a16.f422957d = 0L;
        b16._last_err_msg = new ErrMsg();
        byte[] bArr4 = wUserSigInfo._reserveData;
        if (bArr4 == null || bArr4.length <= 3) {
            a16.f422960g = 0;
        } else {
            a16.f422960g = util.buf_to_int32(bArr4, 0);
            util.LOGI("MSF SSO SEQ:" + a16.f422960g, str);
        }
        if (isGateWay(wUserSigInfo)) {
            return checkSMSAndGetStForGateWay(a16, b16, str, bArr, wUserSigInfo, bArr3);
        }
        long b17 = !util.check_uin_account(str).booleanValue() ? a16.b(str) : Long.parseLong(str);
        a16.f422957d = b17;
        wUserSigInfo.uin = b17 + "";
        tlv_t104 tlv_t104Var = b16.get_t104();
        boolean z16 = tlv_t104Var == null || tlv_t104Var.get_data_len() == 0;
        util.LOGI("CheckSMSAndGetSt tokenLost = " + z16, "");
        if (z16 && (switchListener2 = switchListener) != null && switchListener2.isSwitchOn(SmsVerifyContext.MANAGER_ID, true)) {
            DeviceSmsContext deviceSmsContext = (DeviceSmsContext) oicq.wlogin_sdk.contextpersist.a.a(this.mContext, DeviceSmsContext.MMKV_KEY_CONTEXT_PERSIST_DEVICE_SMS_VERIFY);
            util.LOGI("CheckSMSAndGetSt deviceSmsContext = " + deviceSmsContext.toString(), "");
            b16.set_t104(deviceSmsContext.getTlv_t104());
            b16._t174 = deviceSmsContext.get_t174();
            b16._t402 = deviceSmsContext.get_t402();
            b16._t403 = deviceSmsContext.get_t403();
            b16._msalt = deviceSmsContext.getSalt();
            b16._mpasswd = deviceSmsContext.getpasswd();
            b16._tgtgt_key = deviceSmsContext.get_tgtgt_key();
            b16._sub_appid_list = deviceSmsContext.get_sub_appid_list();
            if (this.mAysncSeq == 0) {
                this.mAysncSeq = a16.f422959f;
            }
        }
        int a17 = new o(a16).a(bArr, this.mMiscBitmap, this.mSubSigMap, b16._sub_appid_list, wUserSigInfo, bArr3);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(util.LOG_TAG_GATEWAY_LOGIN_NEW_DOV);
        sb5.append("user:");
        sb5.append(str);
        sb5.append("ret");
        sb5.append(a17);
        sb5.append(",uin:");
        sb5.append(b17);
        sb5.append("CheckSMSAndGetSt extraData:");
        sb5.append(bArr3 != null ? bArr3.length : 0);
        util.LOGI(sb5.toString(), "");
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x7", String.valueOf(a17));
        aVar.f422861g.put("isGateway", "0");
        oicq.wlogin_sdk.report.c.b.a(aVar, 100);
        if (a17 == 0) {
            WloginSigInfo d16 = a16.d(a16.f422957d, b16._appid);
            if (d16 != null) {
                wUserSigInfo2 = wUserSigInfo;
                wUserSigInfo2.get_clone(d16);
                long[] jArr = b16._sub_appid_list;
                if (jArr != null && bArr2 != null && jArr.length * 2 == bArr2.length) {
                    int i17 = 0;
                    while (true) {
                        long[] jArr2 = b16._sub_appid_list;
                        if (jArr2 == null || i17 >= jArr2.length) {
                            break;
                        }
                        WloginSigInfo d17 = a16.d(a16.f422957d, jArr2[i17]);
                        if (d17 != null) {
                            int i18 = i17 * 2;
                            bArr2[i18] = (byte[]) d17._userSt_Key.clone();
                            bArr2[i18 + 1] = (byte[]) d17._userStSig.clone();
                        }
                        i17++;
                    }
                }
                i16 = 0;
                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
                if (GetUserSigInfoTicket == null) {
                    GetUserSigInfoTicket = new Ticket();
                }
                Ticket ticket2 = GetUserSigInfoTicket;
                u.f422936m0.commit_t2(a16.f422957d, a16.f422958e, util.format_ret_code(i16), i16);
                byte[] bArr5 = ticket2._sig;
                if (i16 != 0) {
                    if (bArr5 != null && bArr5.length != 0) {
                        RequestReport(0, bArr5, ticket2._sig_key, a16.f422957d, b16._appid);
                    }
                    str2 = "";
                    ticket = ticket2;
                } else {
                    str2 = "";
                    ticket = ticket2;
                    RequestReportError(0, bArr5, ticket2._sig_key, a16.f422957d, b16._appid, 0);
                }
                tlv_t150Var = a16.f422956c;
                if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                    this.mG.f422956c = a16.f422956c;
                    RequestReportError(0, ticket._sig, ticket._sig_key, a16.f422957d, b16._appid, 1);
                }
                u.a();
                a16.b();
                util.LOGI("user:" + str + " CheckSMSAndGetSt Seq:" + a16.f422959f + " ret=" + i16, str2 + a16.f422957d);
                return i16;
            }
            a17 = -1004;
        }
        wUserSigInfo2 = wUserSigInfo;
        i16 = a17;
        GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
        if (GetUserSigInfoTicket == null) {
        }
        Ticket ticket22 = GetUserSigInfoTicket;
        u.f422936m0.commit_t2(a16.f422957d, a16.f422958e, util.format_ret_code(i16), i16);
        byte[] bArr52 = ticket22._sig;
        if (i16 != 0) {
        }
        tlv_t150Var = a16.f422956c;
        if (tlv_t150Var != null) {
            this.mG.f422956c = a16.f422956c;
            RequestReportError(0, ticket._sig, ticket._sig_key, a16.f422957d, b16._appid, 1);
        }
        u.a();
        a16.b();
        util.LOGI("user:" + str + " CheckSMSAndGetSt Seq:" + a16.f422959f + " ret=" + i16, str2 + a16.f422957d);
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int CheckSMSVerifyLoginAccount(long j3, long j16, String str, int i3, long j17, WUserSigInfo wUserSigInfo, int i16) {
        String str2;
        u uVar;
        String str3;
        int a16;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        String str4 = str;
        oicq.wlogin_sdk.register.c.f422818u = false;
        oicq.wlogin_sdk.register.c.f422819v = 0L;
        if ((j17 == -1 && str4 == null) || wUserSigInfo == null) {
            return -1017;
        }
        if (i16 == 0) {
            new HelperThread(this, this.mHelperHandler, j3, j16, str, i3, j17, wUserSigInfo, "CheckSMSVerifyLoginAccount").RunReq(12);
            return -1001;
        }
        u a17 = this.mG.a(0L);
        long j18 = a17.f422959f;
        wUserSigInfo._seqence = j18;
        this.mAysncSeq = j18;
        async_context b16 = u.b(j18);
        a17.f422958e = str4;
        StringBuilder sb5 = new StringBuilder();
        String str5 = "user:";
        sb5.append("user:");
        sb5.append(str4);
        String str6 = " Seq:";
        sb5.append(" Seq:");
        sb5.append(a17.f422959f);
        sb5.append(" CheckSMSVerifyLoginAccount ...");
        util.LOGI(sb5.toString(), str4);
        b16._login_bitmap = wUserSigInfo._login_bitmap;
        b16._last_err_msg = new ErrMsg();
        z zVar = new z(a17);
        int i17 = this.mMainSigMap;
        byte[] bArr5 = u.f422924a0;
        int i18 = this.mMiscBitmap;
        int i19 = this.mSubSigMap;
        int i26 = u.f422953z;
        int i27 = 1;
        byte[] bArr6 = (str4 == null && i3 == 1) ? u.f422931h0 : null;
        int i28 = 0;
        while (true) {
            byte[] bytes = str4 == null ? null : str.getBytes();
            int[] iArr = bytes == null ? i3 == i27 ? new int[]{256, 260, 264, 265, 1325, 8, 322, 325, 340, 1324, 278, 1313, tlv_t553.CMD_553} : new int[]{256, 264, 265, 1325, 8, 322, 325, 340, 1324, 278, 1313, tlv_t553.CMD_553} : new int[]{256, 264, 265, 1325, 8, 322, 325, 340, 274, 278, 1313, tlv_t553.CMD_553};
            ArrayList arrayList = new ArrayList();
            str2 = str6;
            int length = iArr.length;
            uVar = a17;
            str3 = str5;
            int i29 = 0;
            int i36 = 0;
            int i37 = 0;
            while (i29 < length) {
                int i38 = length;
                byte[] bArr7 = new byte[0];
                int i39 = iArr[i29];
                int[] iArr2 = iArr;
                if (i39 == 8) {
                    bArr = bArr5;
                    bArr2 = bArr6;
                    bArr3 = new tlv_t8().get_tlv_8(0, u.f422951x, 0);
                } else if (i39 == 256) {
                    bArr = bArr5;
                    bArr2 = bArr6;
                    bArr3 = new tlv_t100().get_tlv_100(j3, j16, i26, i17);
                } else if (i39 != 260) {
                    if (i39 == 274) {
                        bArr = bArr5;
                        bArr3 = new tlv_t112().get_tlv_112(bytes);
                    } else if (i39 != 278) {
                        if (i39 == 322) {
                            bArr = bArr5;
                            bArr3 = new tlv_t142().get_tlv_142(u.G);
                        } else if (i39 == 325) {
                            bArr = bArr5;
                            bArr3 = new tlv_t145().get_tlv_145(u.D);
                        } else if (i39 == 340) {
                            bArr = bArr5;
                            bArr3 = new tlv_t154().get_tlv_154(zVar.f422917m.f422960g);
                        } else if (i39 == 1313) {
                            bArr = bArr5;
                            tlv_t tlv_tVar = new tlv_t(1313);
                            byte[] bArr8 = new byte[6];
                            util.int32_to_buf(bArr8, 0, u.f422942s0);
                            util.int16_to_buf(bArr8, 4, 0);
                            tlv_tVar.set_data(bArr8, 6);
                            bArr3 = tlv_tVar.get_buf();
                        } else if (i39 == 1363) {
                            QSec qSec = QSec.getInstance();
                            zVar.f422917m.getClass();
                            bArr = bArr5;
                            bArr3 = new tlv_t553().get_tlv_t553(qSec.getFeKitAttach(u.f422949w, "", "0x810", "0x11"));
                        } else if (i39 == 264) {
                            if (bArr5 != null && bArr5.length > 0) {
                                bArr4 = new tlv_t108().get_tlv_108(bArr5);
                                bArr3 = bArr4;
                                bArr = bArr5;
                            }
                            bArr = bArr5;
                            bArr3 = bArr7;
                        } else if (i39 != 265) {
                            if (i39 != 1324) {
                                if (i39 == 1325) {
                                    bArr4 = new tlv_t52d().get_tlv_52d(zVar.f422905a);
                                }
                                bArr = bArr5;
                                bArr3 = bArr7;
                            } else {
                                bArr4 = new tlv_t52c().get_tlv_52c(i3, j17);
                            }
                            bArr3 = bArr4;
                            bArr = bArr5;
                        } else {
                            if (oicq.wlogin_sdk.utils.a.a(u.f422949w) != null && oicq.wlogin_sdk.utils.a.a(u.f422949w).length > 0) {
                                bArr4 = new tlv_t109().get_tlv_109(oicq.wlogin_sdk.utils.a.a(u.f422949w));
                                bArr3 = bArr4;
                                bArr = bArr5;
                            }
                            bArr = bArr5;
                            bArr3 = bArr7;
                        }
                        bArr2 = bArr6;
                    } else {
                        bArr = bArr5;
                        bArr3 = new tlv_t116().get_tlv_116(i18, i19, null);
                    }
                    bArr2 = bArr6;
                } else {
                    bArr = bArr5;
                    bArr2 = bArr6;
                    bArr3 = new tlv_t104().get_tlv_104(bArr2);
                }
                if (bArr3.length > 4) {
                    i37++;
                    i36 += bArr3.length;
                    arrayList.add(bArr3);
                }
                i29++;
                bArr6 = bArr2;
                length = i38;
                iArr = iArr2;
                bArr5 = bArr;
            }
            byte[] bArr9 = bArr5;
            byte[] bArr10 = bArr6;
            tlv_t tlv_tVar2 = wUserSigInfo._loginExtraProductTLVMap.get(Integer.valueOf(gdt_analysis_event.EVENT_FEEDBACK_CLICK));
            if (tlv_tVar2 != null) {
                byte[] bArr11 = tlv_tVar2.get_buf();
                i37++;
                i36 += bArr11.length;
                arrayList.add(bArr11);
            }
            int i46 = i36;
            int i47 = i37;
            for (Iterator<Integer> it = wUserSigInfo.extraLoginTLVMap.keySet().iterator(); it.hasNext(); it = it) {
                Integer next = it.next();
                byte[] bArr12 = wUserSigInfo.extraLoginTLVMap.get(next).get_buf();
                i46 += bArr12.length;
                arrayList.add(bArr12);
                i47++;
                util.LOGI("Extra Tlv from user\uff1a0x" + next);
            }
            byte[] bArr13 = new byte[i46];
            int i48 = 0;
            int i49 = 0;
            while (i49 < i47) {
                byte[] bArr14 = (byte[]) arrayList.get(i49);
                System.arraycopy(bArr14, 0, bArr13, i48, bArr14.length);
                i48 += bArr14.length;
                i49++;
                arrayList = arrayList;
                i17 = i17;
            }
            int i56 = i17;
            zVar.a(8001, zVar.f422914j, zVar.f422910f, zVar.f422917m.f422957d, 0, 2, i26, 0, zVar.a(bArr13, zVar.f422915k, i47));
            a16 = zVar.a(String.valueOf(zVar.f422917m.f422957d), false, wUserSigInfo);
            if (a16 != 0) {
                break;
            }
            a16 = zVar.d();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("retry num:");
            int i57 = i28;
            sb6.append(i57);
            sb6.append(" extra:");
            sb6.append(j17);
            sb6.append(" ret:");
            sb6.append(a16);
            String sb7 = sb6.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append("");
            z zVar2 = zVar;
            sb8.append(zVar.f422917m.f422957d);
            util.LOGI(sb7, sb8.toString());
            if (a16 != 180) {
                break;
            }
            i28 = i57 + 1;
            if (i57 >= 1) {
                break;
            }
            i27 = 1;
            zVar = zVar2;
            i17 = i56;
            str6 = str2;
            a17 = uVar;
            str5 = str3;
            str4 = str;
            bArr6 = bArr10;
            bArr5 = bArr9;
        }
        if (a16 == 208) {
            a16 = 0;
        }
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PHONE, "sub_event_0x11", String.valueOf(a16));
        aVar.f422860f = str;
        oicq.wlogin_sdk.report.c.b.a(aVar, 100);
        StringBuilder sb9 = new StringBuilder();
        sb9.append(str3);
        sb9.append(uVar.f422958e);
        sb9.append(str2);
        sb9.append(uVar.f422959f);
        sb9.append(" CheckSMSVerifyLoginAccount ret=");
        sb9.append(a16 > 0 ? Integer.toHexString(a16) : Integer.valueOf(a16));
        util.LOGI(sb9.toString(), str);
        return a16;
    }

    private int GetStWithoutPasswd(String str, long j3, long j16, long j17, int i3, WUserSigInfo wUserSigInfo, WtTicketPromise wtTicketPromise) {
        return GetStWithoutPasswd(str, j3, j16, -1L, i3, j17, null, wUserSigInfo, null, null, 0, wtTicketPromise);
    }

    private int RegSubmitMobile(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3, int i16, int i17, long j3, long j16, WUserSigInfo wUserSigInfo, Map<String, Object> map) {
        long j17;
        byte[] bArr5;
        byte[] bArr6;
        HashMap<Integer, RegTLV> hashMap;
        byte[] bArr7;
        TransReqContext transReqContext;
        byte[] bArr8;
        int i18;
        byte[] bArr9;
        int[] iArr;
        byte[] bArr10;
        byte[] buf;
        ArrayList arrayList;
        RegTLV regTLV;
        RegTLV regTLV2;
        byte[] bArr11;
        long j18 = j16;
        if (bArr2 == null || bArr2.length <= 0 || bArr4 == null) {
            return -1017;
        }
        byte[] bArr12 = bArr == null ? new byte[0] : bArr;
        byte[] bArr13 = u.G;
        byte[] bArr14 = new byte[0];
        WloginLastLoginInfo GetLastLoginInfo = GetLastLoginInfo();
        if (GetLastLoginInfo != null) {
            j17 = GetLastLoginInfo.mUin;
            Ticket GetLocalTicket = GetLocalTicket(GetLastLoginInfo.mAccount, j3, 64);
            if (GetLocalTicket != null && (bArr11 = GetLocalTicket._sig) != null) {
                bArr14 = bArr11;
            }
        } else {
            j17 = 0;
        }
        util.LOGI("has uin? " + j17 + ", a2: " + bArr14.length);
        util.LOGI("RegSubmitMobile mobile ..." + new String(bArr2) + " appname: " + new String(bArr13) + MiniBoxNoticeInfo.APPNAME_SUFFIX, "");
        oicq.wlogin_sdk.register.c cVar = this.mRegStatus;
        new String(bArr2);
        cVar.getClass();
        TransReqContext transReqContext2 = new TransReqContext();
        oicq.wlogin_sdk.register.c cVar2 = this.mRegStatus;
        cVar2.getClass();
        cVar2.f422825e = j18;
        transReqContext2.set_register_req();
        transReqContext2.set_subcmd(10);
        byte[] generateGuid = util.generateGuid(this.mContext);
        byte[] _imsi = util.get_IMSI(this.mContext);
        byte[] bArr15 = u.f422924a0;
        byte[] GetGuid = GetGuid();
        HashMap<Integer, RegTLV> hashMap2 = wUserSigInfo.extraRegTLVMap;
        String str = Build.VERSION.RELEASE;
        byte[] bArr16 = bArr15 == null ? new byte[0] : bArr15;
        StringBuilder sb5 = new StringBuilder("reg_request_submit_mobile analysisExtraMap");
        if (map == null) {
            sb5.append(" extraMap == null");
            bArr6 = bArr13;
            hashMap = hashMap2;
            bArr7 = null;
            bArr5 = null;
        } else {
            bArr5 = (byte[]) map.get("country_english_name");
            bArr6 = bArr13;
            sb5.append("\uff0cstCountryCodeTwo = ");
            if (bArr5 == null) {
                sb5.append("null");
                hashMap = hashMap2;
            } else {
                hashMap = hashMap2;
                sb5.append(new String(bArr5));
            }
            bArr7 = (byte[]) map.get("captcha_verify_info");
            sb5.append("\uff0cstCaptchaVerifyInfo = ");
            if (bArr7 == null) {
                sb5.append("null");
            } else {
                sb5.append(bArr7.length);
            }
            util.LOGI(sb5.toString(), "");
        }
        StringBuilder sb6 = new StringBuilder("reg_request_submit_mobile");
        int[] iArr2 = {1, 2, 3, 4, 13, 6, 7, 18, 37, 50, 52, 53, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE, 29};
        ArrayList arrayList2 = new ArrayList();
        int i19 = 0;
        int i26 = 0;
        while (i19 < 14) {
            byte[] bArr17 = bArr16;
            byte[] bArr18 = new byte[0];
            int i27 = iArr2[i19];
            if (i27 != 1) {
                if (i27 == 2) {
                    i18 = i19;
                    bArr9 = bArr7;
                    iArr = iArr2;
                    regTLV = new RegTLV(2);
                    regTLV.setLong(j17);
                } else if (i27 == 3) {
                    i18 = i19;
                    bArr9 = bArr7;
                    iArr = iArr2;
                    regTLV = new RegTLV(3);
                    regTLV.setData(bArr14, bArr14.length);
                } else if (i27 == 4) {
                    i18 = i19;
                    bArr9 = bArr7;
                    iArr = iArr2;
                    regTLV = new RegTLV(4);
                    regTLV.setData(GetGuid, GetGuid.length);
                } else if (i27 == 6) {
                    i18 = i19;
                    bArr9 = bArr7;
                    iArr = iArr2;
                    regTLV = new RegTLV(6);
                    int length = bArr12.length + 3;
                    byte[] bArr19 = new byte[length];
                    util.int8_to_buf(bArr19, 0, bArr12.length == 0 ? 1 : 2);
                    util.int16_to_buf(bArr19, 1, bArr12.length);
                    System.arraycopy(bArr12, 0, bArr19, 3, bArr12.length);
                    regTLV.setData(bArr19, length);
                } else if (i27 == 7) {
                    i18 = i19;
                    bArr9 = bArr7;
                    iArr = iArr2;
                    regTLV = new RegTLV(7);
                    int i28 = u.f422929f0 | 0;
                    if (true == u.f422928e0) {
                        i28 |= 2;
                    }
                    int i29 = i28 | 8 | 16;
                    regTLV.setInt(i29);
                    util.LOGI("reg_request_submit_mobile tlv7 " + i29, "");
                } else if (i27 != 13) {
                    if (i27 == 18) {
                        i18 = i19;
                        bArr9 = bArr7;
                        iArr = iArr2;
                        regTLV2 = new RegTLV(18);
                        regTLV2.setData(bArr4, bArr4.length);
                    } else if (i27 == 29) {
                        i18 = i19;
                        bArr9 = bArr7;
                        iArr = iArr2;
                        if (bArr5 != null) {
                            RegTLV regTLV3 = new RegTLV(29);
                            regTLV3.setData(bArr5, bArr5.length);
                            buf = regTLV3.getBuf();
                            util.LOGI("tlv29 len:" + bArr5.length, "");
                            bArr10 = bArr17;
                        } else {
                            util.LOGI("tlv29 byteCountryCode is null", "");
                            bArr10 = bArr17;
                            buf = bArr18;
                        }
                    } else if (i27 != 37) {
                        if (i27 == 50) {
                            i18 = i19;
                            bArr9 = bArr7;
                            iArr = iArr2;
                            StringBuilder sb7 = new StringBuilder(23);
                            sec_trans$SecTransInfo sec_trans_sectransinfo = new sec_trans$SecTransInfo();
                            PBStringField pBStringField = sec_trans_sectransinfo.str_phone_brand;
                            String str2 = Build.BRAND;
                            pBStringField.set(str2);
                            sb7.append("brand:");
                            sb7.append(str2);
                            String a16 = oicq.wlogin_sdk.utils.b.a(u.f422949w);
                            sec_trans_sectransinfo.str_model_type.set(a16);
                            sb7.append(" model:");
                            sb7.append(a16);
                            PBStringField pBStringField2 = sec_trans_sectransinfo.str_wifi_mac;
                            String str3 = u.f422944t0;
                            if (str3 == null) {
                                str3 = "";
                            }
                            pBStringField2.set(str3);
                            sb7.append(" regMacAddress:");
                            sb7.append(u.f422944t0);
                            PBStringField pBStringField3 = sec_trans_sectransinfo.str_gps_location;
                            String str4 = u.f422950w0;
                            if (str4 == null) {
                                str4 = "";
                            }
                            pBStringField3.set(str4);
                            sb7.append(" regLocation:");
                            sb7.append(u.f422950w0);
                            PBStringField pBStringField4 = sec_trans_sectransinfo.str_os_language;
                            String str5 = u.f422946u0;
                            if (str5 == null) {
                                str5 = "";
                            }
                            pBStringField4.set(str5);
                            sb7.append(" regOSLanguage:");
                            sb7.append(u.f422946u0);
                            sec_trans_sectransinfo.uint32_qq_language.set(u.f422948v0);
                            sb7.append(" regQQLanguage:");
                            sb7.append(u.f422948v0);
                            util.LOGI(sb7.toString(), "");
                            byte[] byteArray = sec_trans_sectransinfo.toByteArray();
                            RegTLV regTLV4 = new RegTLV(50);
                            regTLV4.setData(byteArray, byteArray.length);
                            util.LOGI("tlv50 len:" + byteArray.length, "");
                            buf = regTLV4.getBuf();
                        } else if (i27 == 544) {
                            i18 = i19;
                            bArr9 = bArr7;
                            iArr = iArr2;
                            byte[] bArr20 = new byte[bArr2.length + bArr4.length + bArr12.length + 6];
                            util.int16_to_buf(bArr20, 0, bArr2.length);
                            System.arraycopy(bArr2, 0, bArr20, 0, bArr2.length);
                            int length2 = bArr2.length + 2;
                            util.int16_to_buf(bArr20, length2, bArr4.length);
                            int i36 = length2 + 2;
                            System.arraycopy(bArr4, 0, bArr20, i36, bArr4.length);
                            int length3 = i36 + bArr4.length;
                            util.int16_to_buf(bArr20, length3, bArr12.length);
                            System.arraycopy(bArr12, 0, bArr20, length3 + 2, bArr12.length);
                            buf = new tlv_t544().get_tlv_544("", "812_a", bArr20);
                        } else if (i27 != 52) {
                            if (i27 != 53) {
                                i18 = i19;
                                bArr9 = bArr7;
                                iArr = iArr2;
                            } else if (bArr7 != null) {
                                RegTLV regTLV5 = new RegTLV(53);
                                regTLV5.setData(bArr7, bArr7.length);
                                buf = regTLV5.getBuf();
                                StringBuilder sb8 = new StringBuilder();
                                iArr = iArr2;
                                sb8.append("tlv53 len:");
                                sb8.append(bArr7.length);
                                sb8.append("\uff0c");
                                sb8.append(buf.length);
                                util.LOGI(sb8.toString(), "");
                                i18 = i19;
                                bArr9 = bArr7;
                            } else {
                                iArr = iArr2;
                                util.LOGI("tlv53 byteCaptchaVerifyInfo is null", "");
                                i18 = i19;
                                bArr9 = bArr7;
                            }
                            bArr10 = bArr17;
                            buf = bArr18;
                        } else {
                            iArr = iArr2;
                            RegTLV regTLV6 = new RegTLV(52);
                            byte[] bArr21 = new byte[4];
                            bArr9 = bArr7;
                            i18 = i19;
                            util.int32_to_buf(bArr21, 0, 22);
                            regTLV6.setData(bArr21, 4);
                            byte[] buf2 = regTLV6.getBuf();
                            util.LOGI("tlv52 len:4", "");
                            buf = buf2;
                        }
                        bArr10 = bArr17;
                    } else {
                        i18 = i19;
                        bArr9 = bArr7;
                        iArr = iArr2;
                        regTLV2 = new RegTLV(37);
                        regTLV2.setShort(u.f422942s0);
                    }
                    buf = regTLV2.getBuf();
                    bArr10 = bArr17;
                } else {
                    i18 = i19;
                    bArr9 = bArr7;
                    iArr = iArr2;
                    regTLV = new RegTLV(13);
                    regTLV.setInt((int) j18);
                }
                buf = regTLV.getBuf();
                bArr10 = bArr17;
            } else {
                i18 = i19;
                bArr9 = bArr7;
                iArr = iArr2;
                RegTLV regTLV7 = new RegTLV(1);
                bArr10 = bArr17;
                regTLV7.setData(bArr10, bArr10.length);
                buf = regTLV7.getBuf();
            }
            if (buf.length > 4) {
                i26 += buf.length;
                arrayList = arrayList2;
                arrayList.add(buf);
            } else {
                arrayList = arrayList2;
            }
            arrayList2 = arrayList;
            iArr2 = iArr;
            bArr7 = bArr9;
            j18 = j16;
            byte[] bArr22 = bArr10;
            i19 = i18 + 1;
            bArr16 = bArr22;
        }
        ArrayList arrayList3 = arrayList2;
        for (Integer num : hashMap.keySet()) {
            byte[] buf3 = hashMap.get(num).getBuf();
            arrayList3.add(buf3);
            i26 += buf3.length;
            sb6.append(",key=");
            sb6.append(num);
            sb6.append(",value=");
            sb6.append(buf3.length);
        }
        util.LOGI(sb6.toString(), "");
        int size = arrayList3.size();
        byte[] bArr23 = new byte[i26 + 2];
        int i37 = 0;
        util.int16_to_buf(bArr23, 0, (byte) size);
        int i38 = 0;
        int i39 = 2;
        while (i38 < size) {
            byte[] bArr24 = (byte[]) arrayList3.get(i38);
            System.arraycopy(bArr24, i37, bArr23, i39, bArr24.length);
            i39 += bArr24.length;
            i38++;
            i37 = 0;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(bArr2.length);
            dataOutputStream.write(bArr2);
            dataOutputStream.writeByte(5);
            dataOutputStream.writeByte(str.length());
            dataOutputStream.write(str.getBytes());
            byte[] bArr25 = bArr6;
            dataOutputStream.writeByte(bArr25.length);
            dataOutputStream.write(bArr25);
            dataOutputStream.writeByte(bArr4.length);
            dataOutputStream.write(bArr4);
            dataOutputStream.writeByte(i3);
            dataOutputStream.writeByte(i16);
            dataOutputStream.writeByte(i17);
            dataOutputStream.writeInt((int) j3);
            dataOutputStream.writeInt(0);
            dataOutputStream.writeByte(generateGuid.length);
            dataOutputStream.write(generateGuid);
            dataOutputStream.writeByte(_imsi.length);
            dataOutputStream.write(_imsi);
            dataOutputStream.write(bArr23);
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            byte[] bArr26 = new byte[byteArray2.length + 13];
            util.int8_to_buf(bArr26, 0, 2);
            util.int16_to_buf(bArr26, 1, byteArray2.length + 11 + 2);
            util.int16_to_buf(bArr26, 3, 3);
            util.int16_to_buf(bArr26, 5, 10);
            util.int8_to_buf(bArr26, 7, 4);
            util.int32_to_buf(bArr26, 8, 0);
            System.arraycopy(byteArray2, 0, bArr26, 12, byteArray2.length);
            util.int8_to_buf(bArr26, byteArray2.length + 12, 3);
            bArr8 = bArr26;
            transReqContext = transReqContext2;
        } catch (Exception e16) {
            util.LOGI("get account failed " + e16.getMessage(), "");
            transReqContext = transReqContext2;
            bArr8 = null;
        }
        transReqContext._body = bArr8;
        return RequestTransport(0, 1, null, 0L, 95, transReqContext, wUserSigInfo);
    }

    @Deprecated
    public int GetStWithPasswd(String str, long j3, String str2, WUserSigInfo wUserSigInfo) {
        return GetStWithPasswd(str, j3, this.mMainSigMap, 1L, null, false, str2, wUserSigInfo, null, false, 0);
    }

    public WtloginHelper(Context context, PrivacyListener privacyListener) {
        this.mG = new u();
        this.mHelperHandler = initHelperHandler();
        this.mContext = null;
        this.mListener = null;
        this.mRegStatus = new oicq.wlogin_sdk.register.c();
        this.mMainSigMap = 16724722;
        this.mSubSigMap = 66560;
        this.mMiscBitmap = 150470524;
        this.mOpenAppid = 715019303L;
        this.mAysncSeq = 0L;
        this.mDevAsyncSeq = 0L;
        this.isForLocal = false;
        util.privacyListener = privacyListener;
        localInit(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:105:0x04f3 A[LOOP:1: B:103:0x04ed->B:105:0x04f3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x064c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0724  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x075f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x085b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x087e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x089f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x086b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x07d5  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x064a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0941  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x095b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x099f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x097c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int GetStWithPasswd(String str, long j3, int i3, long j16, long[] jArr, boolean z16, String str2, WUserSigInfo wUserSigInfo, byte[][] bArr, boolean z17, int i16) {
        int i17;
        WtloginHelper wtloginHelper;
        u a16;
        tlv_t126 tlv_t126Var;
        u uVar;
        String str3;
        int i18;
        int i19;
        byte[] bArr2;
        String str4;
        String str5;
        long parseLong;
        boolean z18;
        int i26;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        int i27;
        WUserSigInfo wUserSigInfo2;
        async_context async_contextVar;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i28;
        Ticket GetUserSigInfoTicket;
        WtloginHelper wtloginHelper2;
        async_context async_contextVar2;
        String str11;
        u uVar2;
        tlv_t150 tlv_t150Var;
        int i29;
        WUserSigInfo wUserSigInfo3;
        int i36;
        StringBuilder sb5;
        int i37;
        char c16;
        long j17;
        long j18;
        String str12;
        StringBuilder sb6;
        int i38;
        WtloginHelper wtloginHelper3;
        int i39;
        int i46;
        int a17;
        long[] jArr2;
        int i47;
        StringBuilder sb7;
        WloginSigInfo d16;
        u uVar3;
        async_context async_contextVar3;
        StringBuilder sb8;
        byte[] bArr6;
        byte[] bArr7;
        byte[] bArr8;
        byte[] bArr9;
        int length;
        byte[] bArr10;
        Iterator<Integer> it;
        byte[] bArr11;
        int i48;
        int length2;
        int i49;
        int a18;
        int i56;
        int d17;
        String str13 = str;
        if (str13 == null || wUserSigInfo == null) {
            return -1017;
        }
        int i57 = i3 | 192;
        int i58 = this.mMiscBitmap;
        if (u.Z) {
            i58 |= 33554432;
        }
        int i59 = i58;
        if (i16 == 0) {
            new HelperThread(this, this.mHelperHandler, str, j3, i57, j16, jArr, z16, str2, wUserSigInfo, bArr, z17, "GetStWithPasswd").RunReq(0);
            return -1001;
        }
        if (!z17 || oicq.wlogin_sdk.register.c.f422818u) {
            i17 = i59;
            wtloginHelper = this;
            if (!wtloginHelper.isGateWay(wUserSigInfo) && wUserSigInfo.businessType != 3) {
                if (wUserSigInfo._seqence == 0) {
                    wUserSigInfo._seqence = wtloginHelper.mAysncSeq;
                }
                tlv_t126Var = u.b(wUserSigInfo._seqence)._t126;
                u a19 = wtloginHelper.mG.a(0L);
                long j19 = a19.f422959f;
                wUserSigInfo._seqence = j19;
                wtloginHelper.mAysncSeq = j19;
                uVar = a19;
                async_context b16 = u.b(uVar.f422959f);
                if (tlv_t126Var != null) {
                    util.LOGI("tempContext._t126 = " + tlv_t126Var.get_random().length, "");
                    b16._t126 = tlv_t126Var;
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append("start GetStWithPasswd:user:");
                sb9.append(str13);
                sb9.append(" dwAppid:");
                sb9.append(j3);
                sb9.append(" dwMainSigMap:0x");
                String str14 = " dwAppid:";
                sb9.append(Integer.toHexString(i57));
                sb9.append(" dwSubAppid:");
                sb9.append(j16);
                sb9.append(" Seq:");
                String str15 = " dwSubAppid:";
                String str16 = " dwMainSigMap:0x";
                sb9.append(uVar.f422959f);
                sb9.append(" ...");
                util.LOGI(sb9.toString(), str13);
                StringBuilder sb10 = new StringBuilder("GetStWithPasswd");
                b16._isSmslogin = z17;
                str3 = (z17 || str2.length() != 0) ? str2 : b16._mpasswd;
                oicq.wlogin_sdk.register.c.f422818u = false;
                oicq.wlogin_sdk.register.c.f422820w = "";
                StringBuilder sb11 = sb10;
                if (str3 != null && str3.length() > 16) {
                    str3 = str3.substring(0, 16);
                }
                i18 = util.get_saved_network_type(wtloginHelper.mContext);
                i19 = util.get_network_type(wtloginHelper.mContext);
                u.F = i19;
                if (i18 != i19) {
                    util.set_net_retry_type(wtloginHelper.mContext, 0);
                    util.save_network_type(wtloginHelper.mContext, u.F);
                }
                u.H = util.get_apn_string(wtloginHelper.mContext).getBytes();
                uVar.f422958e = str13;
                uVar.f422957d = 0L;
                b16._sappid = j3;
                b16._appid = j3;
                b16._sub_appid_list = null;
                b16._sub_appid = j16;
                b16._main_sigmap = i57;
                b16._login_bitmap = wUserSigInfo._login_bitmap;
                b16._last_err_msg = new ErrMsg();
                if (jArr != null) {
                    b16._sub_appid_list = (long[]) jArr.clone();
                }
                bArr2 = wUserSigInfo._reserveData;
                int i65 = i57;
                if (bArr2 == null) {
                    str4 = " Seq:";
                    if (bArr2.length > 3) {
                        uVar.f422960g = util.buf_to_int32(bArr2, 0);
                        util.LOGI("MSF SSO SEQ:" + uVar.f422960g, str13);
                        str5 = "";
                        u.f422936m0.add_t2(new report_t2("login", new String(oicq.wlogin_sdk.utils.b.d(wtloginHelper.mContext)), System.currentTimeMillis(), j3, j16, jArr));
                        if (util.check_uin_account(str).booleanValue()) {
                            parseLong = Long.parseLong(str);
                            z18 = true;
                        } else {
                            parseLong = 0;
                            z18 = false;
                        }
                        if (str3 != null || str3.length() <= 0) {
                            i26 = 0;
                            bArr3 = wUserSigInfo._fastLoginBuf;
                            if (bArr3 != null || bArr3.length <= 0) {
                                bArr4 = oicq.wlogin_sdk.code2d.d.f422745l;
                                if (bArr4 != null || bArr4.length <= 0) {
                                    A1AndNopicSig a1AndNopicSigByAccount = getA1AndNopicSigByAccount(str, j3);
                                    b16._tmp_pwd = a1AndNopicSigByAccount.f422867a1;
                                    b16._tmp_no_pic_sig = a1AndNopicSigByAccount.noPicSig;
                                } else {
                                    b16._tmp_pwd = bArr4;
                                    b16._tmp_no_pic_sig = oicq.wlogin_sdk.code2d.d.f422746m;
                                    oicq.wlogin_sdk.code2d.d.f422745l = null;
                                    oicq.wlogin_sdk.code2d.d.f422746m = null;
                                }
                            } else {
                                util.LOGI("GetFastLoginInfo ...", str13);
                                if (wtloginHelper.GetFastLoginInfo(wUserSigInfo._fastLoginBuf, b16) < 0) {
                                    util.LOGI("GetFastLoginInfo failed", str13);
                                    i27 = i65;
                                    wUserSigInfo2 = wUserSigInfo;
                                    async_contextVar = b16;
                                    str6 = str14;
                                    str7 = str16;
                                    str8 = str15;
                                    str9 = str4;
                                    str10 = str5;
                                    i28 = -1017;
                                    GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
                                    if (GetUserSigInfoTicket == null) {
                                        GetUserSigInfoTicket = new Ticket();
                                    }
                                    Ticket ticket = GetUserSigInfoTicket;
                                    u.f422936m0.commit_t2(uVar.f422957d, uVar.f422958e, util.format_ret_code(i28), i28);
                                    if (i28 == 0) {
                                        byte[] bArr12 = ticket._sig;
                                        if (bArr12 == null || bArr12.length == 0) {
                                            wtloginHelper2 = this;
                                            async_contextVar2 = async_contextVar;
                                            str11 = str10;
                                        } else {
                                            str11 = str10;
                                            async_contextVar2 = async_contextVar;
                                            wtloginHelper2 = this;
                                            RequestReport(0, bArr12, ticket._sig_key, uVar.f422957d, async_contextVar._appid);
                                        }
                                    } else {
                                        wtloginHelper2 = this;
                                        async_contextVar2 = async_contextVar;
                                        str11 = str10;
                                        if (i28 != 2 && i28 != 160) {
                                            uVar2 = uVar;
                                            RequestReportError(0, ticket._sig, ticket._sig_key, uVar.f422957d, async_contextVar2._appid, 0);
                                            tlv_t150Var = uVar2.f422956c;
                                            if (tlv_t150Var != null && tlv_t150Var.get_bitmap() != 0) {
                                                wtloginHelper2.mG.f422956c = uVar2.f422956c;
                                                RequestReportError(0, ticket._sig, ticket._sig_key, uVar2.f422957d, async_contextVar2._appid, 1);
                                            }
                                            oicq.wlogin_sdk.report.b.a();
                                            u.a();
                                            uVar2.b();
                                            oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x9", String.valueOf(i28));
                                            aVar.f422860f = str13;
                                            aVar.f422861g.put("isSmsLogin", String.valueOf(z17));
                                            oicq.wlogin_sdk.report.c.b.a(aVar, 500);
                                            util.LOGI("end GetStWithPasswd:user:" + str13 + str6 + j3 + str7 + Integer.toHexString(i27) + str8 + j16 + str9 + uVar2.f422959f + " ret=" + i28, str11 + uVar2.f422957d);
                                            return i28;
                                        }
                                    }
                                    uVar2 = uVar;
                                    tlv_t150Var = uVar2.f422956c;
                                    if (tlv_t150Var != null) {
                                        wtloginHelper2.mG.f422956c = uVar2.f422956c;
                                        RequestReportError(0, ticket._sig, ticket._sig_key, uVar2.f422957d, async_contextVar2._appid, 1);
                                    }
                                    oicq.wlogin_sdk.report.b.a();
                                    u.a();
                                    uVar2.b();
                                    oicq.wlogin_sdk.report.c.a aVar2 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x9", String.valueOf(i28));
                                    aVar2.f422860f = str13;
                                    aVar2.f422861g.put("isSmsLogin", String.valueOf(z17));
                                    oicq.wlogin_sdk.report.c.b.a(aVar2, 500);
                                    util.LOGI("end GetStWithPasswd:user:" + str13 + str6 + j3 + str7 + Integer.toHexString(i27) + str8 + j16 + str9 + uVar2.f422959f + " ret=" + i28, str11 + uVar2.f422957d);
                                    return i28;
                                }
                                if (str13.matches("([0-9]{5,10})@qq\\.com")) {
                                    parseLong = Long.valueOf(str13.replaceAll("([0-9]{5,10})@qq\\.com", "$1")).longValue();
                                    uVar.a(str13, Long.valueOf(parseLong));
                                    z18 = true;
                                }
                            }
                            bArr5 = b16._tmp_pwd;
                            if (bArr5 != null || bArr5.length < 16) {
                                i27 = i65;
                                wUserSigInfo2 = wUserSigInfo;
                                async_contextVar = b16;
                                str6 = str14;
                                str7 = str16;
                                str8 = str15;
                                str9 = str4;
                                str10 = str5;
                                i28 = -1016;
                                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
                                if (GetUserSigInfoTicket == null) {
                                }
                                Ticket ticket2 = GetUserSigInfoTicket;
                                u.f422936m0.commit_t2(uVar.f422957d, uVar.f422958e, util.format_ret_code(i28), i28);
                                if (i28 == 0) {
                                }
                                uVar2 = uVar;
                                tlv_t150Var = uVar2.f422956c;
                                if (tlv_t150Var != null) {
                                }
                                oicq.wlogin_sdk.report.b.a();
                                u.a();
                                uVar2.b();
                                oicq.wlogin_sdk.report.c.a aVar22 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x9", String.valueOf(i28));
                                aVar22.f422860f = str13;
                                aVar22.f422861g.put("isSmsLogin", String.valueOf(z17));
                                oicq.wlogin_sdk.report.c.b.a(aVar22, 500);
                                util.LOGI("end GetStWithPasswd:user:" + str13 + str6 + j3 + str7 + Integer.toHexString(i27) + str8 + j16 + str9 + uVar2.f422959f + " ret=" + i28, str11 + uVar2.f422957d);
                                return i28;
                            }
                            b16._tmp_pwd_type = 1;
                        } else {
                            if (z16) {
                                try {
                                    b16._tmp_pwd = (byte[]) str3.getBytes("ISO-8859-1").clone();
                                } catch (Exception unused) {
                                    i29 = -1013;
                                }
                            } else {
                                b16._tmp_pwd = MD5.toMD5Byte(str3);
                            }
                            i26 = 0;
                            b16._tmp_pwd_type = 0;
                        }
                        if (!z18) {
                            if (str.length() <= util.MAX_NAME_LEN) {
                                t tVar = new t(uVar);
                                byte[] bytes = str.getBytes();
                                int i66 = u.B;
                                int i67 = wtloginHelper.mSubSigMap;
                                int i68 = u.f422953z;
                                tVar.f422917m.f422958e = new String(bytes);
                                int i69 = i26;
                                while (true) {
                                    byte[] bArr13 = u.f422924a0;
                                    tlv_t100 tlv_t100Var = new tlv_t100();
                                    tlv_t112 tlv_t112Var = new tlv_t112();
                                    tlv_t107 tlv_t107Var = new tlv_t107();
                                    tlv_t108 tlv_t108Var = new tlv_t108();
                                    tlv_t124 tlv_t124Var = new tlv_t124();
                                    tlv_t128 tlv_t128Var = new tlv_t128();
                                    tlv_t52d tlv_t52dVar = new tlv_t52d();
                                    uVar3 = uVar;
                                    tlv_t116 tlv_t116Var = new tlv_t116();
                                    tlv_t154 tlv_t154Var = new tlv_t154();
                                    async_contextVar3 = b16;
                                    tlv_t8 tlv_t8Var = new tlv_t8();
                                    tlv_t tlv_tVar = new tlv_t(283);
                                    int i75 = i69;
                                    tlv_t tlv_tVar2 = new tlv_t(1313);
                                    tlv_t548 tlv_t548Var = new tlv_t548();
                                    tlv_t553 tlv_t553Var = new tlv_t553();
                                    tlv_t191 tlv_t191Var = new tlv_t191();
                                    i27 = i65;
                                    str6 = str14;
                                    str7 = str16;
                                    str8 = str15;
                                    sb8 = sb11;
                                    i37 = 3;
                                    int i76 = i67;
                                    str9 = str4;
                                    int i77 = i66;
                                    int i78 = i17;
                                    t tVar2 = tVar;
                                    String str17 = str5;
                                    byte[] bArr14 = tlv_t100Var.get_tlv_100(j3, j16, i68, i27);
                                    byte[] bArr15 = tlv_t112Var.get_tlv_112(bytes);
                                    byte[] bArr16 = tlv_t107Var.get_tlv_107(i77, 0, 0, 1);
                                    byte[] bArr17 = tlv_t108Var.get_tlv_108(bArr13);
                                    byte[] bArr18 = tlv_t116Var.get_tlv_116(i78, i76, jArr);
                                    byte[] bArr19 = tlv_t154Var.get_tlv_154(tVar2.f422917m.f422960g);
                                    byte[] bArr20 = tlv_t8Var.get_tlv_8(0, u.f422951x, 0);
                                    byte[] bArr21 = tlv_t191Var.get_tlv_191(j.f422896v);
                                    util.LOGI("request_getuin canWebVerify" + j.f422896v, str17);
                                    i36 = i78;
                                    c16 = 2;
                                    tlv_t tlv_tVar3 = tlv_tVar;
                                    tlv_tVar3.set_data(new byte[]{2}, 1);
                                    byte[] bArr22 = tlv_t124Var.get_tlv_124(util.get_os_type(), util.get_os_version(), u.F, oicq.wlogin_sdk.utils.b.d(tVar2.f422905a), new byte[0], u.H);
                                    byte[] bArr23 = tlv_t128Var.get_tlv_128(u.S, u.T, u.U, u.X, oicq.wlogin_sdk.utils.b.b(u.f422949w), u.D, u.O);
                                    byte[] bArr24 = bytes;
                                    byte[] bArr25 = tlv_t52dVar.get_tlv_52d(tVar2.f422905a);
                                    byte[] bArr26 = new byte[0];
                                    byte[] bArr27 = u.f422933j0;
                                    if (bArr27 != null) {
                                        bArr7 = bArr26;
                                        if (bArr27.length > 0) {
                                            bArr8 = tlv_t548Var.get_tlv_548(bArr27);
                                            StringBuilder sb12 = new StringBuilder();
                                            bArr6 = bArr25;
                                            sb12.append("t548 len:");
                                            sb12.append(bArr8 == null ? 0 : bArr8.length);
                                            util.LOGI(sb12.toString(), str17);
                                            byte[] bArr28 = new byte[6];
                                            str10 = str17;
                                            util.int32_to_buf(bArr28, 0, u.f422942s0);
                                            util.int16_to_buf(bArr28, 4, 0);
                                            tlv_tVar2.set_data(bArr28, 6);
                                            byte[] bArr29 = tlv_tVar2.get_buf();
                                            bArr9 = bArr8;
                                            byte[] bArr30 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(tVar2.f422905a, String.valueOf(tVar2.f422917m.f422957d), "0x810", "0x4"));
                                            length = bArr14.length + bArr15.length + bArr16.length + bArr17.length + bArr22.length + bArr23.length + bArr29.length + bArr30.length + bArr18.length + bArr19.length + bArr20.length + bArr21.length + tlv_tVar3.get_buf().length;
                                            bArr10 = bArr6;
                                            if (bArr6 != null && bArr10.length > 0) {
                                                length += bArr10.length;
                                            }
                                            if (bArr9 != null && bArr9.length > 0) {
                                                length += bArr9.length;
                                            }
                                            WUserSigInfo wUserSigInfo4 = wUserSigInfo;
                                            int i79 = length;
                                            it = wUserSigInfo4.extraLoginTLVMap.keySet().iterator();
                                            int i85 = i79;
                                            while (it.hasNext()) {
                                                Iterator<Integer> it5 = it;
                                                Integer next = it.next();
                                                tlv_t tlv_tVar4 = tlv_tVar3;
                                                byte[] bArr31 = wUserSigInfo4.extraLoginTLVMap.get(next).get_buf();
                                                int length3 = i85 + bArr31.length;
                                                util.LOGI("add length Tlv from user\uff1a0x" + next + " body_len:" + bArr31.length, str10);
                                                i85 = length3;
                                                it = it5;
                                                tlv_tVar3 = tlv_tVar4;
                                                wUserSigInfo4 = wUserSigInfo;
                                            }
                                            tlv_t tlv_tVar5 = tlv_tVar3;
                                            int i86 = i85 + 1024;
                                            bArr11 = new byte[i86];
                                            System.arraycopy(bArr14, 0, bArr11, 0, bArr14.length);
                                            int length4 = bArr14.length + 0;
                                            System.arraycopy(bArr15, 0, bArr11, length4, bArr15.length);
                                            int length5 = length4 + bArr15.length;
                                            System.arraycopy(bArr16, 0, bArr11, length5, bArr16.length);
                                            int length6 = length5 + bArr16.length;
                                            System.arraycopy(bArr19, 0, bArr11, length6, bArr19.length);
                                            int length7 = length6 + bArr19.length;
                                            System.arraycopy(bArr20, 0, bArr11, length7, bArr20.length);
                                            int length8 = length7 + bArr20.length;
                                            System.arraycopy(bArr30, 0, bArr11, length8, bArr30.length);
                                            int length9 = length8 + bArr30.length;
                                            if (bArr13 != null || bArr13.length <= 0) {
                                                i48 = 6;
                                            } else {
                                                System.arraycopy(bArr17, 0, bArr11, length9, bArr17.length);
                                                length9 += bArr17.length;
                                                i48 = 7;
                                            }
                                            System.arraycopy(bArr29, 0, bArr11, length9, bArr29.length);
                                            int length10 = length9 + bArr29.length;
                                            System.arraycopy(bArr22, 0, bArr11, length10, bArr22.length);
                                            int length11 = length10 + bArr22.length;
                                            System.arraycopy(bArr23, 0, bArr11, length11, bArr23.length);
                                            int length12 = length11 + bArr23.length;
                                            System.arraycopy(bArr18, 0, bArr11, length12, bArr18.length);
                                            int length13 = length12 + bArr18.length;
                                            System.arraycopy(bArr21, 0, bArr11, length13, bArr21.length);
                                            int length14 = length13 + bArr21.length;
                                            System.arraycopy(tlv_tVar5.get_buf(), 0, bArr11, length14, tlv_tVar5.get_buf().length);
                                            length2 = length14 + tlv_tVar5.get_buf().length;
                                            i49 = i48 + 1 + 3 + 1 + 1;
                                            if (bArr10 != null && bArr10.length > 0) {
                                                System.arraycopy(bArr10, 0, bArr11, length2, bArr10.length);
                                                length2 += bArr10.length;
                                                i49++;
                                            }
                                            if (bArr9 != null && bArr9.length > 0) {
                                                System.arraycopy(bArr9, 0, bArr11, length2, bArr9.length);
                                                length2 += bArr9.length;
                                                i49++;
                                            }
                                            wUserSigInfo3 = wUserSigInfo;
                                            for (Integer num : wUserSigInfo3.extraLoginTLVMap.keySet()) {
                                                byte[] bArr32 = wUserSigInfo3.extraLoginTLVMap.get(num).get_buf();
                                                if (length2 <= i86 - bArr32.length) {
                                                    System.arraycopy(bArr32, 0, bArr11, length2, bArr32.length);
                                                    length2 += bArr32.length;
                                                    i49++;
                                                    util.LOGI("Extra Tlv from user\uff1a0x" + num);
                                                }
                                            }
                                            byte[] bArr33 = new byte[length2];
                                            System.arraycopy(bArr11, 0, bArr33, 0, length2);
                                            tVar2.a(8001, tVar2.f422914j, tVar2.f422910f, 0L, 0, 2, i68, 0, tVar2.a(bArr33, tVar2.f422915k, i49));
                                            String valueOf = String.valueOf(tVar2.f422917m.f422957d);
                                            a18 = tVar2.a(valueOf, false, wUserSigInfo3);
                                            if (a18 == 0) {
                                                i56 = a18;
                                                break;
                                            }
                                            d17 = tVar2.d();
                                            util.LOGI("retry num:" + i75 + " ret:" + d17 + " uin: " + valueOf, tVar2.f422917m.f422958e);
                                            if (d17 != 180) {
                                                break;
                                            }
                                            int i87 = i75 + 1;
                                            if (i75 >= 1) {
                                                break;
                                            }
                                            bytes = bArr24;
                                            tVar = tVar2;
                                            i69 = i87;
                                            i66 = i77;
                                            i67 = i76;
                                            i17 = i36;
                                            uVar = uVar3;
                                            b16 = async_contextVar3;
                                            i65 = i27;
                                            sb11 = sb8;
                                            str15 = str8;
                                            str16 = str7;
                                            str14 = str6;
                                            str4 = str9;
                                            str5 = str10;
                                        } else {
                                            bArr6 = bArr25;
                                        }
                                    } else {
                                        bArr6 = bArr25;
                                        bArr7 = bArr26;
                                    }
                                    bArr8 = bArr7;
                                    byte[] bArr282 = new byte[6];
                                    str10 = str17;
                                    util.int32_to_buf(bArr282, 0, u.f422942s0);
                                    util.int16_to_buf(bArr282, 4, 0);
                                    tlv_tVar2.set_data(bArr282, 6);
                                    byte[] bArr292 = tlv_tVar2.get_buf();
                                    bArr9 = bArr8;
                                    byte[] bArr302 = tlv_t553Var.get_tlv_t553(QSec.getInstance().getFeKitAttach(tVar2.f422905a, String.valueOf(tVar2.f422917m.f422957d), "0x810", "0x4"));
                                    length = bArr14.length + bArr15.length + bArr16.length + bArr17.length + bArr22.length + bArr23.length + bArr292.length + bArr302.length + bArr18.length + bArr19.length + bArr20.length + bArr21.length + tlv_tVar3.get_buf().length;
                                    bArr10 = bArr6;
                                    if (bArr6 != null) {
                                        length += bArr10.length;
                                    }
                                    if (bArr9 != null) {
                                        length += bArr9.length;
                                    }
                                    WUserSigInfo wUserSigInfo42 = wUserSigInfo;
                                    int i792 = length;
                                    it = wUserSigInfo42.extraLoginTLVMap.keySet().iterator();
                                    int i852 = i792;
                                    while (it.hasNext()) {
                                    }
                                    tlv_t tlv_tVar52 = tlv_tVar3;
                                    int i862 = i852 + 1024;
                                    bArr11 = new byte[i862];
                                    System.arraycopy(bArr14, 0, bArr11, 0, bArr14.length);
                                    int length42 = bArr14.length + 0;
                                    System.arraycopy(bArr15, 0, bArr11, length42, bArr15.length);
                                    int length52 = length42 + bArr15.length;
                                    System.arraycopy(bArr16, 0, bArr11, length52, bArr16.length);
                                    int length62 = length52 + bArr16.length;
                                    System.arraycopy(bArr19, 0, bArr11, length62, bArr19.length);
                                    int length72 = length62 + bArr19.length;
                                    System.arraycopy(bArr20, 0, bArr11, length72, bArr20.length);
                                    int length82 = length72 + bArr20.length;
                                    System.arraycopy(bArr302, 0, bArr11, length82, bArr302.length);
                                    int length92 = length82 + bArr302.length;
                                    if (bArr13 != null) {
                                    }
                                    i48 = 6;
                                    System.arraycopy(bArr292, 0, bArr11, length92, bArr292.length);
                                    int length102 = length92 + bArr292.length;
                                    System.arraycopy(bArr22, 0, bArr11, length102, bArr22.length);
                                    int length112 = length102 + bArr22.length;
                                    System.arraycopy(bArr23, 0, bArr11, length112, bArr23.length);
                                    int length122 = length112 + bArr23.length;
                                    System.arraycopy(bArr18, 0, bArr11, length122, bArr18.length);
                                    int length132 = length122 + bArr18.length;
                                    System.arraycopy(bArr21, 0, bArr11, length132, bArr21.length);
                                    int length142 = length132 + bArr21.length;
                                    System.arraycopy(tlv_tVar52.get_buf(), 0, bArr11, length142, tlv_tVar52.get_buf().length);
                                    length2 = length142 + tlv_tVar52.get_buf().length;
                                    i49 = i48 + 1 + 3 + 1 + 1;
                                    if (bArr10 != null) {
                                        System.arraycopy(bArr10, 0, bArr11, length2, bArr10.length);
                                        length2 += bArr10.length;
                                        i49++;
                                    }
                                    if (bArr9 != null) {
                                        System.arraycopy(bArr9, 0, bArr11, length2, bArr9.length);
                                        length2 += bArr9.length;
                                        i49++;
                                    }
                                    wUserSigInfo3 = wUserSigInfo;
                                    while (r2.hasNext()) {
                                    }
                                    byte[] bArr332 = new byte[length2];
                                    System.arraycopy(bArr11, 0, bArr332, 0, length2);
                                    tVar2.a(8001, tVar2.f422914j, tVar2.f422910f, 0L, 0, 2, i68, 0, tVar2.a(bArr332, tVar2.f422915k, i49));
                                    String valueOf2 = String.valueOf(tVar2.f422917m.f422957d);
                                    a18 = tVar2.a(valueOf2, false, wUserSigInfo3);
                                    if (a18 == 0) {
                                    }
                                }
                                i56 = d17;
                                if (i56 != 0) {
                                    str13 = str;
                                    i28 = i56;
                                    wUserSigInfo2 = wUserSigInfo3;
                                    uVar = uVar3;
                                    async_contextVar = async_contextVar3;
                                } else {
                                    async_contextVar = async_contextVar3;
                                    if (async_contextVar._msalt != 0) {
                                        sb5 = sb8;
                                        sb5.append(",Name2Salt uin = 0");
                                        str13 = str;
                                        uVar = uVar3;
                                        j17 = 0;
                                        j18 = oicq.wlogin_sdk.register.c.f422819v;
                                        if (j18 != 0) {
                                            async_contextVar._msalt = j18;
                                            oicq.wlogin_sdk.register.c.f422819v = 0L;
                                        }
                                        uVar.f422957d = j17;
                                        StringBuilder sb13 = new StringBuilder();
                                        str12 = str10;
                                        sb13.append(str12);
                                        sb13.append(j17);
                                        wUserSigInfo3.uin = sb13.toString();
                                        sb5.append(",thisG uin =");
                                        sb5.append(j17);
                                        byte[] bArr34 = wUserSigInfo3._in_ksid;
                                        byte[] bArr35 = (bArr34 != null || bArr34.length <= 0) ? u.f422924a0 : (byte[]) bArr34.clone();
                                        if (async_contextVar._tmp_pwd_type == 0) {
                                            util.LOGI("user:" + str13 + " login with saved A1.", str12 + uVar.f422957d);
                                            int i88 = i36;
                                            j jVar = new j(uVar, this.mContext);
                                            jVar.f422919o = true;
                                            wUserSigInfo2 = wUserSigInfo3;
                                            sb6 = sb5;
                                            wtloginHelper3 = this;
                                            i38 = 1;
                                            a17 = jVar.a(j3, j16, uVar.f422957d, 0, u.f422927d0, async_contextVar._tmp_pwd, async_contextVar._tmp_no_pic_sig, i88, this.mSubSigMap, jArr, i27, j16, u.B, 0, 0, 1, bArr35, wUserSigInfo, true);
                                            i39 = i88;
                                            i46 = 0;
                                        } else {
                                            wUserSigInfo2 = wUserSigInfo3;
                                            sb6 = sb5;
                                            int i89 = i36;
                                            i38 = 1;
                                            wtloginHelper3 = this;
                                            util.LOGI("user:" + str13 + " login with input password.", str12 + uVar.f422957d);
                                            byte[] bArr36 = new byte[4];
                                            util.int64_to_buf32(bArr36, 0, (System.currentTimeMillis() / 1000) + u.f422926c0);
                                            int i95 = z17 ? i37 : 1;
                                            j jVar2 = new j(uVar, wtloginHelper3.mContext);
                                            jVar2.f422919o = true;
                                            i39 = i89;
                                            i46 = 0;
                                            a17 = jVar2.a(j3, j16, uVar.f422957d, 0, u.f422927d0, bArr36, async_contextVar._tmp_pwd, i95, i39, wtloginHelper3.mSubSigMap, jArr, i27, j16, u.B, 0, 0, 1, bArr35, wUserSigInfo);
                                        }
                                        if (a17 != 204) {
                                            jArr2 = jArr;
                                            i47 = new p(uVar).a(i39, wtloginHelper3.mSubSigMap, jArr2, wUserSigInfo2);
                                        } else {
                                            jArr2 = jArr;
                                            i47 = a17;
                                        }
                                        if (i47 != 0 || i47 == 160 || i47 == 239) {
                                            if (j17 != 0) {
                                                j17 = async_contextVar._uin;
                                                uVar.f422957d = j17;
                                                wUserSigInfo2.uin = str12 + j17;
                                                sb7 = sb6;
                                                sb7.append(",uin == 0 reset ");
                                                sb7.append(j17);
                                            } else {
                                                sb7 = sb6;
                                            }
                                            if (i47 != 160 && i47 != 239) {
                                                util.LOGI(sb7.toString(), str12);
                                                d16 = uVar.d(j17, j3);
                                                if (d16 != null) {
                                                    util.LOGI("get_siginfo failed, AppID: " + j3, str12 + uVar.f422957d);
                                                    str10 = str12;
                                                    i28 = -1004;
                                                } else {
                                                    wUserSigInfo2.get_clone(d16);
                                                    if (jArr2 != null && bArr != null && jArr2.length * 2 == bArr.length) {
                                                        int i96 = i46;
                                                        while (i96 < jArr2.length) {
                                                            String str18 = str12;
                                                            WloginSigInfo d18 = uVar.d(j17, jArr2[i96]);
                                                            if (d18 != null) {
                                                                int i97 = i96 * 2;
                                                                bArr[i97] = (byte[]) d18._userSt_Key.clone();
                                                                bArr[i97 + i38] = (byte[]) d18._userStSig.clone();
                                                            }
                                                            i96++;
                                                            str12 = str18;
                                                        }
                                                    }
                                                    str10 = str12;
                                                    i28 = i47;
                                                }
                                            }
                                        }
                                        str10 = str12;
                                        i28 = i47;
                                    } else {
                                        sb5 = sb8;
                                        if (async_contextVar.ifQQLoginInQim(u.f422942s0)) {
                                            str13 = str;
                                            parseLong = async_contextVar._uin;
                                            uVar = uVar3;
                                        } else {
                                            str13 = str;
                                            uVar = uVar3;
                                            parseLong = uVar.b(str13);
                                        }
                                        if (parseLong == 0) {
                                            i28 = -1003;
                                            wUserSigInfo2 = wUserSigInfo3;
                                        } else {
                                            sb5.append(",Name2Uin uin =");
                                            sb5.append(parseLong);
                                        }
                                    }
                                }
                                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
                                if (GetUserSigInfoTicket == null) {
                                }
                                Ticket ticket22 = GetUserSigInfoTicket;
                                u.f422936m0.commit_t2(uVar.f422957d, uVar.f422958e, util.format_ret_code(i28), i28);
                                if (i28 == 0) {
                                }
                                uVar2 = uVar;
                                tlv_t150Var = uVar2.f422956c;
                                if (tlv_t150Var != null) {
                                }
                                oicq.wlogin_sdk.report.b.a();
                                u.a();
                                uVar2.b();
                                oicq.wlogin_sdk.report.c.a aVar222 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x9", String.valueOf(i28));
                                aVar222.f422860f = str13;
                                aVar222.f422861g.put("isSmsLogin", String.valueOf(z17));
                                oicq.wlogin_sdk.report.c.b.a(aVar222, 500);
                                util.LOGI("end GetStWithPasswd:user:" + str13 + str6 + j3 + str7 + Integer.toHexString(i27) + str8 + j16 + str9 + uVar2.f422959f + " ret=" + i28, str11 + uVar2.f422957d);
                                return i28;
                            }
                            i29 = -1008;
                            i27 = i65;
                            i28 = i29;
                            wUserSigInfo2 = wUserSigInfo;
                            async_contextVar = b16;
                            str6 = str14;
                            str7 = str16;
                            str8 = str15;
                            str9 = str4;
                            str10 = str5;
                            GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
                            if (GetUserSigInfoTicket == null) {
                            }
                            Ticket ticket222 = GetUserSigInfoTicket;
                            u.f422936m0.commit_t2(uVar.f422957d, uVar.f422958e, util.format_ret_code(i28), i28);
                            if (i28 == 0) {
                            }
                            uVar2 = uVar;
                            tlv_t150Var = uVar2.f422956c;
                            if (tlv_t150Var != null) {
                            }
                            oicq.wlogin_sdk.report.b.a();
                            u.a();
                            uVar2.b();
                            oicq.wlogin_sdk.report.c.a aVar2222 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x9", String.valueOf(i28));
                            aVar2222.f422860f = str13;
                            aVar2222.f422861g.put("isSmsLogin", String.valueOf(z17));
                            oicq.wlogin_sdk.report.c.b.a(aVar2222, 500);
                            util.LOGI("end GetStWithPasswd:user:" + str13 + str6 + j3 + str7 + Integer.toHexString(i27) + str8 + j16 + str9 + uVar2.f422959f + " ret=" + i28, str11 + uVar2.f422957d);
                            return i28;
                        }
                        i27 = i65;
                        wUserSigInfo3 = wUserSigInfo;
                        async_contextVar = b16;
                        i36 = i17;
                        str6 = str14;
                        str7 = str16;
                        str8 = str15;
                        sb5 = sb11;
                        str9 = str4;
                        str10 = str5;
                        i37 = 3;
                        c16 = 2;
                        j17 = parseLong;
                        j18 = oicq.wlogin_sdk.register.c.f422819v;
                        if (j18 != 0) {
                        }
                        uVar.f422957d = j17;
                        StringBuilder sb132 = new StringBuilder();
                        str12 = str10;
                        sb132.append(str12);
                        sb132.append(j17);
                        wUserSigInfo3.uin = sb132.toString();
                        sb5.append(",thisG uin =");
                        sb5.append(j17);
                        byte[] bArr342 = wUserSigInfo3._in_ksid;
                        byte[] bArr352 = (bArr342 != null || bArr342.length <= 0) ? u.f422924a0 : (byte[]) bArr342.clone();
                        if (async_contextVar._tmp_pwd_type == 0) {
                        }
                        if (a17 != 204) {
                        }
                        if (i47 != 0) {
                        }
                        if (j17 != 0) {
                        }
                        if (i47 != 160) {
                            util.LOGI(sb7.toString(), str12);
                            d16 = uVar.d(j17, j3);
                            if (d16 != null) {
                            }
                        }
                        str10 = str12;
                        i28 = i47;
                        GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
                        if (GetUserSigInfoTicket == null) {
                        }
                        Ticket ticket2222 = GetUserSigInfoTicket;
                        u.f422936m0.commit_t2(uVar.f422957d, uVar.f422958e, util.format_ret_code(i28), i28);
                        if (i28 == 0) {
                        }
                        uVar2 = uVar;
                        tlv_t150Var = uVar2.f422956c;
                        if (tlv_t150Var != null) {
                        }
                        oicq.wlogin_sdk.report.b.a();
                        u.a();
                        uVar2.b();
                        oicq.wlogin_sdk.report.c.a aVar22222 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x9", String.valueOf(i28));
                        aVar22222.f422860f = str13;
                        aVar22222.f422861g.put("isSmsLogin", String.valueOf(z17));
                        oicq.wlogin_sdk.report.c.b.a(aVar22222, 500);
                        util.LOGI("end GetStWithPasswd:user:" + str13 + str6 + j3 + str7 + Integer.toHexString(i27) + str8 + j16 + str9 + uVar2.f422959f + " ret=" + i28, str11 + uVar2.f422957d);
                        return i28;
                    }
                } else {
                    str4 = " Seq:";
                }
                uVar.f422960g = 0;
                str5 = "";
                u.f422936m0.add_t2(new report_t2("login", new String(oicq.wlogin_sdk.utils.b.d(wtloginHelper.mContext)), System.currentTimeMillis(), j3, j16, jArr));
                if (util.check_uin_account(str).booleanValue()) {
                }
                if (str3 != null) {
                }
                i26 = 0;
                bArr3 = wUserSigInfo._fastLoginBuf;
                if (bArr3 != null) {
                }
                bArr4 = oicq.wlogin_sdk.code2d.d.f422745l;
                if (bArr4 != null) {
                }
                A1AndNopicSig a1AndNopicSigByAccount2 = getA1AndNopicSigByAccount(str, j3);
                b16._tmp_pwd = a1AndNopicSigByAccount2.f422867a1;
                b16._tmp_no_pic_sig = a1AndNopicSigByAccount2.noPicSig;
                bArr5 = b16._tmp_pwd;
                if (bArr5 != null) {
                }
                i27 = i65;
                wUserSigInfo2 = wUserSigInfo;
                async_contextVar = b16;
                str6 = str14;
                str7 = str16;
                str8 = str15;
                str9 = str4;
                str10 = str5;
                i28 = -1016;
                GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
                if (GetUserSigInfoTicket == null) {
                }
                Ticket ticket22222 = GetUserSigInfoTicket;
                u.f422936m0.commit_t2(uVar.f422957d, uVar.f422958e, util.format_ret_code(i28), i28);
                if (i28 == 0) {
                }
                uVar2 = uVar;
                tlv_t150Var = uVar2.f422956c;
                if (tlv_t150Var != null) {
                }
                oicq.wlogin_sdk.report.b.a();
                u.a();
                uVar2.b();
                oicq.wlogin_sdk.report.c.a aVar222222 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x9", String.valueOf(i28));
                aVar222222.f422860f = str13;
                aVar222222.f422861g.put("isSmsLogin", String.valueOf(z17));
                oicq.wlogin_sdk.report.c.b.a(aVar222222, 500);
                util.LOGI("end GetStWithPasswd:user:" + str13 + str6 + j3 + str7 + Integer.toHexString(i27) + str8 + j16 + str9 + uVar2.f422959f + " ret=" + i28, str11 + uVar2.f422957d);
                return i28;
            }
            a16 = wtloginHelper.mG.a(0L);
            long j26 = a16.f422959f;
            wUserSigInfo._seqence = j26;
            wtloginHelper.mDevAsyncSeq = j26;
        } else {
            i17 = i59;
            wtloginHelper = this;
            if (wUserSigInfo._seqence == 0) {
                wUserSigInfo._seqence = wtloginHelper.mAysncSeq;
            }
            a16 = wtloginHelper.mG.a(wUserSigInfo._seqence);
            wUserSigInfo._seqence = a16.f422959f;
        }
        uVar = a16;
        tlv_t126Var = null;
        async_context b162 = u.b(uVar.f422959f);
        if (tlv_t126Var != null) {
        }
        StringBuilder sb92 = new StringBuilder();
        sb92.append("start GetStWithPasswd:user:");
        sb92.append(str13);
        sb92.append(" dwAppid:");
        sb92.append(j3);
        sb92.append(" dwMainSigMap:0x");
        String str142 = " dwAppid:";
        sb92.append(Integer.toHexString(i57));
        sb92.append(" dwSubAppid:");
        sb92.append(j16);
        sb92.append(" Seq:");
        String str152 = " dwSubAppid:";
        String str162 = " dwMainSigMap:0x";
        sb92.append(uVar.f422959f);
        sb92.append(" ...");
        util.LOGI(sb92.toString(), str13);
        StringBuilder sb102 = new StringBuilder("GetStWithPasswd");
        b162._isSmslogin = z17;
        if (z17) {
        }
        oicq.wlogin_sdk.register.c.f422818u = false;
        oicq.wlogin_sdk.register.c.f422820w = "";
        StringBuilder sb112 = sb102;
        if (str3 != null) {
            str3 = str3.substring(0, 16);
        }
        i18 = util.get_saved_network_type(wtloginHelper.mContext);
        i19 = util.get_network_type(wtloginHelper.mContext);
        u.F = i19;
        if (i18 != i19) {
        }
        u.H = util.get_apn_string(wtloginHelper.mContext).getBytes();
        uVar.f422958e = str13;
        uVar.f422957d = 0L;
        b162._sappid = j3;
        b162._appid = j3;
        b162._sub_appid_list = null;
        b162._sub_appid = j16;
        b162._main_sigmap = i57;
        b162._login_bitmap = wUserSigInfo._login_bitmap;
        b162._last_err_msg = new ErrMsg();
        if (jArr != null) {
        }
        bArr2 = wUserSigInfo._reserveData;
        int i652 = i57;
        if (bArr2 == null) {
        }
        uVar.f422960g = 0;
        str5 = "";
        u.f422936m0.add_t2(new report_t2("login", new String(oicq.wlogin_sdk.utils.b.d(wtloginHelper.mContext)), System.currentTimeMillis(), j3, j16, jArr));
        if (util.check_uin_account(str).booleanValue()) {
        }
        if (str3 != null) {
        }
        i26 = 0;
        bArr3 = wUserSigInfo._fastLoginBuf;
        if (bArr3 != null) {
        }
        bArr4 = oicq.wlogin_sdk.code2d.d.f422745l;
        if (bArr4 != null) {
        }
        A1AndNopicSig a1AndNopicSigByAccount22 = getA1AndNopicSigByAccount(str, j3);
        b162._tmp_pwd = a1AndNopicSigByAccount22.f422867a1;
        b162._tmp_no_pic_sig = a1AndNopicSigByAccount22.noPicSig;
        bArr5 = b162._tmp_pwd;
        if (bArr5 != null) {
        }
        i27 = i652;
        wUserSigInfo2 = wUserSigInfo;
        async_contextVar = b162;
        str6 = str142;
        str7 = str162;
        str8 = str152;
        str9 = str4;
        str10 = str5;
        i28 = -1016;
        GetUserSigInfoTicket = GetUserSigInfoTicket(wUserSigInfo2, 128);
        if (GetUserSigInfoTicket == null) {
        }
        Ticket ticket222222 = GetUserSigInfoTicket;
        u.f422936m0.commit_t2(uVar.f422957d, uVar.f422958e, util.format_ret_code(i28), i28);
        if (i28 == 0) {
        }
        uVar2 = uVar;
        tlv_t150Var = uVar2.f422956c;
        if (tlv_t150Var != null) {
        }
        oicq.wlogin_sdk.report.b.a();
        u.a();
        uVar2.b();
        oicq.wlogin_sdk.report.c.a aVar2222222 = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_LOGIN_PASSWORD, "sub_event_0x9", String.valueOf(i28));
        aVar2222222.f422860f = str13;
        aVar2222222.f422861g.put("isSmsLogin", String.valueOf(z17));
        oicq.wlogin_sdk.report.c.b.a(aVar2222222, 500);
        util.LOGI("end GetStWithPasswd:user:" + str13 + str6 + j3 + str7 + Integer.toHexString(i27) + str8 + j16 + str9 + uVar2.f422959f + " ret=" + i28, str11 + uVar2.f422957d);
        return i28;
    }

    public int GetStWithoutPasswd(String str, long j3, long j16, long j17, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo) {
        return GetStWithoutPasswd(str, j3, j16, -1L, i3, j17, null, wUserSigInfo, null, new byte[][]{new byte[]{1}, bArr, bArr2, bArr3}, 0, null);
    }

    public WtloginHelper(Context context, boolean z16) {
        this.mG = new u();
        this.mHelperHandler = initHelperHandler();
        this.mContext = null;
        this.mListener = null;
        this.mRegStatus = new oicq.wlogin_sdk.register.c();
        this.mMainSigMap = 16724722;
        this.mSubSigMap = 66560;
        this.mMiscBitmap = 150470524;
        this.mOpenAppid = 715019303L;
        this.mAysncSeq = 0L;
        this.mDevAsyncSeq = 0L;
        this.isForLocal = false;
        localInit(context, z16);
    }

    @Deprecated
    public int GetStWithoutPasswd(String str, long j3, long j16, WUserSigInfo wUserSigInfo) {
        return GetStWithoutPasswd(str, j3, j16, -1L, this.mMainSigMap, 1L, null, wUserSigInfo, null, null, 0, null);
    }

    public WtloginHelper(Context context, boolean z16, PrivacyListener privacyListener) {
        this.mG = new u();
        this.mHelperHandler = initHelperHandler();
        this.mContext = null;
        this.mListener = null;
        this.mRegStatus = new oicq.wlogin_sdk.register.c();
        this.mMainSigMap = 16724722;
        this.mSubSigMap = 66560;
        this.mMiscBitmap = 150470524;
        this.mOpenAppid = 715019303L;
        this.mAysncSeq = 0L;
        this.mDevAsyncSeq = 0L;
        this.isForLocal = false;
        util.privacyListener = privacyListener;
        localInit(context, z16);
    }

    public int GetStWithoutPasswd(byte[] bArr, long j3, int i3, WUserSigInfo wUserSigInfo) {
        byte[] decrypt;
        int buf_to_int16;
        int i16;
        int buf_to_int162;
        int i17;
        int buf_to_int163;
        if (bArr != null && bArr.length > 0 && (decrypt = cryptor.decrypt(bArr, 0, bArr.length, u.E)) != null && decrypt.length > 0 && 2 <= decrypt.length && (buf_to_int16 = util.buf_to_int16(decrypt, 0)) > 0 && (i16 = buf_to_int16 + 2) <= decrypt.length) {
            String str = new String(decrypt, 2, buf_to_int16);
            int i18 = i16 + 8;
            if (i18 > decrypt.length) {
                return -1017;
            }
            long buf_to_int64 = util.buf_to_int64(decrypt, i16);
            int i19 = i18 + 2;
            if (i19 <= decrypt.length && (buf_to_int162 = util.buf_to_int16(decrypt, i18)) > 0 && (i17 = i19 + buf_to_int162) <= decrypt.length) {
                byte[] bArr2 = new byte[buf_to_int162];
                System.arraycopy(decrypt, i19, bArr2, 0, buf_to_int162);
                int i26 = i17 + 2;
                if (i26 <= decrypt.length && (buf_to_int163 = util.buf_to_int16(decrypt, i17)) > 0 && i26 + buf_to_int163 <= decrypt.length) {
                    byte[] bArr3 = new byte[buf_to_int163];
                    System.arraycopy(decrypt, i26, bArr3, 0, buf_to_int163);
                    return GetStWithoutPasswd(str, buf_to_int64, j3, -1L, i3, 1L, null, wUserSigInfo, null, new byte[][]{new byte[]{2}, bArr2, bArr3}, 0, null);
                }
            }
        }
        return -1017;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int GetStWithoutPasswd(String str, long j3, long j16, long j17, int i3, long j18, long[] jArr, WUserSigInfo wUserSigInfo, byte[][] bArr, byte[][] bArr2, int i16, WtTicketPromise wtTicketPromise) {
        if (str == null || wUserSigInfo == null) {
            return -1017;
        }
        int i17 = i3 | 192;
        if (2 == j18) {
            i17 &= -33554433;
        }
        int i18 = i17;
        if (i16 == 0) {
            new HelperThread(this, this.mHelperHandler, wtTicketPromise, str, j3, j16, j17, i18, j18, jArr, wUserSigInfo, bArr, bArr2, "GetStWithoutPasswd").RunReq(5);
            return -1001;
        }
        int realGetStWithoutPasswd = realGetStWithoutPasswd(str, j3, j16, j17, i18, j18, jArr, wUserSigInfo, bArr, bArr2, wtTicketPromise);
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_CHANGE_TICKET_ERROR, String.valueOf(realGetStWithoutPasswd), "");
        aVar.f422860f = str;
        oicq.wlogin_sdk.report.c.b.a(aVar, 10000);
        return realGetStWithoutPasswd;
    }
}
