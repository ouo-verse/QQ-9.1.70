package com.tencent.mobileqq.openapi;

import android.content.ContentProvider;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.ark.ark;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.api.IQQGameProviderService;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.ad;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.n;
import com.tencent.mobileqq.activity.aio.r;
import com.tencent.mobileqq.activity.aio.y;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.openapi.a;
import com.tencent.mobileqq.openapi.sdk.c;
import com.tencent.mobileqq.openapi.sdk.e;
import com.tencent.mobileqq.openapi.sdk.f;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.cm;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.YybDownloadSdkCallBack;
import com.tencent.open.downloadnew.d;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import common.config.service.QzoneConfig;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OpenApiManager {
    static IPatchRedirector $redirector_ = null;
    public static final int AUTO_CLEAR_BUFFER_SIZE = 200;
    private static final boolean DEBUG_MSG = true;
    public static final int NOTICE_BUFFER_SZIE = 50;
    private static final String TAG = "OpenApi.Manager";
    private static OpenApiManager sInstance;
    private String mLastGetPayCodePermission;
    private String mLastGetPayCodePkgName;
    private QQAppInterface mLoginSucApp;
    private bs mMsgObserver;
    private final Queue<f> mPayMsgRspQueue;
    private View mPttHolderView;
    private r mPttTransferCallback;
    private ConcurrentHashMap<Long, String> mSendingMsgMap;
    private ConcurrentHashMap<String, com.tencent.mobileqq.openapi.entity.a> mThirdAppMap;
    private int msgTypeFilterOfApps;
    private int uinTypeFilterOfApps;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends bs {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OpenApiManager.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendResult(boolean z16, String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Long.valueOf(j3));
                return;
            }
            if (OpenApiManager.this.mSendingMsgMap.containsKey(Long.valueOf(j3))) {
                if (QLog.isColorLevel()) {
                    QLog.d(OpenApiManager.TAG, 2, "onSendResult, isSuccess = " + z16 + ", uniseq = " + j3);
                }
                com.tencent.mobileqq.openapi.entity.a aVar = (com.tencent.mobileqq.openapi.entity.a) OpenApiManager.this.mThirdAppMap.get((String) OpenApiManager.this.mSendingMsgMap.remove(Long.valueOf(j3)));
                if (aVar != null) {
                    Intent intent = new Intent("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED." + aVar.f256913b);
                    intent.putExtra("msgid", aVar.d(String.valueOf(j3)));
                    if (!z16) {
                        i3 = -9;
                    }
                    intent.putExtra(IQQGameProviderService.COLUMN_NAME_RS_CODE, i3);
                    BaseApplicationImpl.sApplication.sendBroadcast(intent, aVar.f256924m);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onUpdateSendMsgError(String str, int i3, int i16, SendMessageHandler sendMessageHandler, long j3, long j16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16), sendMessageHandler, Long.valueOf(j3), Long.valueOf(j16), str2);
            } else {
                onSendResult(false, str, j16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements r {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OpenApiManager.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.r
        public void handleMessage(View view, FileMsg fileMsg, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, fileMsg, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                OpenApiManager.this.onFileTransStatusChanged(fileMsg, i3, i16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            sInstance = null;
        }
    }

    OpenApiManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mThirdAppMap = new ConcurrentHashMap<>();
        this.mSendingMsgMap = new ConcurrentHashMap<>();
        this.msgTypeFilterOfApps = 0;
        this.uinTypeFilterOfApps = 0;
        this.mMsgObserver = new a();
        this.mPttHolderView = null;
        this.mPttTransferCallback = null;
        this.mPayMsgRspQueue = new LinkedList();
    }

    private static Runnable buildInitYybSdkCallbackRunnable() {
        return new Runnable() { // from class: com.tencent.mobileqq.openapi.OpenApiManager.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (d.e()) {
                    YybDownloadSdkCallBack.getInstance();
                }
            }
        };
    }

    private void checkDownloadPtt(QQAppInterface qQAppInterface, String str, int i3, long j3) {
        checkDownloadPtt(qQAppInterface, qQAppInterface.getMessageFacade().w0(str, i3, j3), false);
    }

    private boolean checkNeedPayAuth(f fVar) {
        if (fVar != null && fVar.f256972a == 3) {
            try {
                if (new JSONObject(fVar.f256974c).optInt("retcode") != 10001) {
                    return false;
                }
                try {
                    QQAppInterface qQAppInterface = this.mLoginSucApp;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("userId", qQAppInterface.getCurrentAccountUin());
                    jSONObject.put(HippyHeaderListViewController.VIEW_TAG, "showWearPayAuthor");
                    jSONObject.put(j.T0, "appInfo");
                    jSONObject.put("come_from", 2);
                    jSONObject.put("extra_data", "{}");
                    Bundle bundle = new Bundle();
                    bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
                    bundle.putString("callbackSn", "0");
                    Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(qQAppInterface.getApplicationContext());
                    payBridgeIntent.putExtras(bundle);
                    payBridgeIntent.addFlags(268435456);
                    payBridgeIntent.putExtra("pay_requestcode", 5);
                    qQAppInterface.getApplication().startActivity(payBridgeIntent);
                    return true;
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        e16.printStackTrace();
                        return true;
                    }
                    return true;
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    @Deprecated
    private void cleanupPttCallback() {
        this.mPttHolderView = null;
        this.mPttTransferCallback = null;
    }

    private com.tencent.mobileqq.openapi.sdk.d copyMsgFromMessageRecord(MessageRecord messageRecord, String str, int i3) {
        return null;
    }

    public static synchronized OpenApiManager getInstance() {
        OpenApiManager openApiManager;
        synchronized (OpenApiManager.class) {
            if (sInstance == null) {
                sInstance = new OpenApiManager();
            }
            openApiManager = sInstance;
        }
        return openApiManager;
    }

    static /* bridge */ /* synthetic */ Runnable h() {
        return buildInitYybSdkCallbackRunnable();
    }

    public static boolean isGameCenterCode(int i3) {
        if (i3 != 12 && i3 != 13) {
            return false;
        }
        return true;
    }

    private void onRuntimeDisactive(QQAppInterface qQAppInterface, boolean z16) {
        ThreadManager.getSubThreadHandler().post(new Runnable(qQAppInterface, z16) { // from class: com.tencent.mobileqq.openapi.OpenApiManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f256891d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f256892e;

            {
                this.f256891d = qQAppInterface;
                this.f256892e = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, OpenApiManager.this, qQAppInterface, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(OpenApiManager.TAG, 2, "onRuntimeDisactive, app = " + this.f256891d + ", current = " + OpenApiManager.this.mLoginSucApp + ", " + this.f256892e);
                }
                if (OpenApiManager.this.mLoginSucApp != null && this.f256891d == OpenApiManager.this.mLoginSucApp) {
                    OpenApiManager.this.mLoginSucApp.removeObserver(OpenApiManager.this.mMsgObserver);
                    OpenApiManager.this.mThirdAppMap.clear();
                    OpenApiManager.this.mSendingMsgMap.clear();
                    OpenApiManager.this.msgTypeFilterOfApps = 0;
                    OpenApiManager.this.uinTypeFilterOfApps = 0;
                    OpenApiManager.this.mLoginSucApp = null;
                    BaseApplicationImpl.sApplication.sendBroadcast(new Intent("com.tencent.mobileqq.openapi.ACTION_LOGOUT"));
                }
                try {
                    MyAppApi.I();
                    ThreadManager.getSubThreadHandler().postDelayed(OpenApiManager.h(), 2000L);
                } catch (Exception e16) {
                    com.tencent.open.base.f.c("TAMST_WAKE", "init Config:" + e16);
                }
            }
        });
    }

    private void resetFilters() {
        int i3 = 0;
        int i16 = 0;
        for (com.tencent.mobileqq.openapi.entity.a aVar : this.mThirdAppMap.values()) {
            i3 |= aVar.e();
            i16 |= aVar.f();
        }
        this.msgTypeFilterOfApps = i3;
        this.uinTypeFilterOfApps = i16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "resetFilters | " + this.msgTypeFilterOfApps + APLogFileUtil.SEPARATOR_LOG + this.uinTypeFilterOfApps);
        }
    }

    @Deprecated
    private void setupPttTransferCallback() {
        if (this.mPttHolderView != null) {
            return;
        }
        this.mPttHolderView = new View(BaseApplicationImpl.sApplication);
        this.mPttTransferCallback = new b();
        y.d(this.mLoginSucApp).a(this.mPttHolderView, this.mPttTransferCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x01b3 A[Catch: all -> 0x01d8, TryCatch #23 {all -> 0x01d8, blocks: (B:136:0x01ad, B:138:0x01b3, B:139:0x01b9), top: B:135:0x01ad }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<Integer, Integer> decodePtt(String str, String str2, String str3, int i3, String str4, String str5, String str6) {
        long j3;
        FileOutputStream fileOutputStream;
        SilkCodecWrapper silkCodecWrapper;
        int c16;
        byte[] bArr;
        byte[] bArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Pair) iPatchRedirector.redirect((short) 20, this, str, str2, str3, Integer.valueOf(i3), str4, str5, str6);
        }
        QQAppInterface qQAppInterface = this.mLoginSucApp;
        if (qQAppInterface == null) {
            return new Pair<>(-1, 0);
        }
        com.tencent.mobileqq.openapi.entity.a aVar = this.mThirdAppMap.get(str);
        if (aVar == null) {
            return new Pair<>(-2, 0);
        }
        if (!aVar.f256913b.equals(str2)) {
            return new Pair<>(-7, 0);
        }
        if (!aVar.i(256)) {
            return new Pair<>(-4, 0);
        }
        String b16 = aVar.b(str3);
        String b17 = aVar.b(str4);
        try {
            j3 = Long.parseLong(b17);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parse msgId", e16);
            }
            j3 = 0;
        }
        if (!TextUtils.isEmpty(b16) && !TextUtils.isEmpty(b17) && j3 != 0) {
            if (i3 == 1) {
                String str7 = AppConstants.SDCARD_ROOT;
                if (!str5.startsWith(str7) && !str6.startsWith(str7)) {
                    return new Pair<>(-16, 0);
                }
                if (!FileUtils.fileExists(str5)) {
                    return new Pair<>(-10, 0);
                }
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(str5);
                    try {
                        byte f16 = QQAudioUtils.f(fileInputStream2);
                        if (f16 < 0) {
                            Pair<Integer, Integer> pair = new Pair<>(-5, 0);
                            try {
                                fileInputStream2.close();
                            } catch (Exception unused) {
                            }
                            return pair;
                        }
                        FileUtils.createFile(str6);
                        fileOutputStream = new FileOutputStream(str6);
                        try {
                            int d16 = QQAudioUtils.d(f16);
                            try {
                                c16 = QQAudioUtils.c(d16);
                                bArr = new byte[c16];
                                bArr2 = new byte[c16];
                                silkCodecWrapper = new SilkCodecWrapper(qQAppInterface.getApp(), false);
                            } catch (Throwable th5) {
                                th = th5;
                                silkCodecWrapper = null;
                            }
                            try {
                                silkCodecWrapper.b(d16, 0, 1);
                                byte[] bArr3 = new byte[2];
                                while (fileInputStream2.read(bArr3) != -1) {
                                    int b18 = QQAudioUtils.b(bArr3);
                                    if (b18 <= 0) {
                                        Pair<Integer, Integer> pair2 = new Pair<>(-15, 0);
                                        try {
                                            fileInputStream2.close();
                                        } catch (Exception unused2) {
                                        }
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                        try {
                                            silkCodecWrapper.release();
                                        } catch (Throwable unused4) {
                                        }
                                        return pair2;
                                    }
                                    if (fileInputStream2.read(bArr, 0, b18) == 0) {
                                        Pair<Integer, Integer> pair3 = new Pair<>(-15, 0);
                                        try {
                                            fileInputStream2.close();
                                        } catch (Exception unused5) {
                                        }
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception unused6) {
                                        }
                                        try {
                                            silkCodecWrapper.release();
                                        } catch (Throwable unused7) {
                                        }
                                        return pair3;
                                    }
                                    if (silkCodecWrapper.f(bArr, bArr2, b18, c16) == 0) {
                                        Pair<Integer, Integer> pair4 = new Pair<>(-17, 0);
                                        try {
                                            fileInputStream2.close();
                                        } catch (Exception unused8) {
                                        }
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception unused9) {
                                        }
                                        try {
                                            silkCodecWrapper.release();
                                        } catch (Throwable unused10) {
                                        }
                                        return pair4;
                                    }
                                    fileOutputStream.write(bArr2);
                                }
                                try {
                                    fileInputStream2.close();
                                } catch (Exception unused11) {
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused12) {
                                }
                                try {
                                    silkCodecWrapper.release();
                                } catch (Throwable unused13) {
                                }
                                return new Pair<>(0, Integer.valueOf(d16));
                            } catch (Throwable th6) {
                                th = th6;
                                fileInputStream = fileInputStream2;
                                i16 = d16;
                                try {
                                    if (QLog.isColorLevel()) {
                                    }
                                    Pair<Integer, Integer> pair5 = new Pair<>(-12, Integer.valueOf(i16));
                                    if (fileInputStream != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    if (silkCodecWrapper != null) {
                                    }
                                    return pair5;
                                } finally {
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            silkCodecWrapper = null;
                            fileInputStream = fileInputStream2;
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "decode silk", th);
                            }
                            Pair<Integer, Integer> pair52 = new Pair<>(-12, Integer.valueOf(i16));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception unused14) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused15) {
                                }
                            }
                            if (silkCodecWrapper != null) {
                                try {
                                    silkCodecWrapper.release();
                                } catch (Throwable unused16) {
                                }
                            }
                            return pair52;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        fileOutputStream = null;
                        silkCodecWrapper = null;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    fileOutputStream = null;
                    silkCodecWrapper = null;
                }
            } else {
                return new Pair<>(-5, 0);
            }
        } else {
            return new Pair<>(-6, 0);
        }
    }

    public Pair<Integer, Integer> downloadMedia(String str, String str2, String str3, int i3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Pair) iPatchRedirector.redirect((short) 19, this, str, str2, str3, Integer.valueOf(i3), str4);
        }
        QQAppInterface qQAppInterface = this.mLoginSucApp;
        if (qQAppInterface == null) {
            return new Pair<>(-1, 0);
        }
        com.tencent.mobileqq.openapi.entity.a aVar = this.mThirdAppMap.get(str);
        if (aVar == null) {
            return new Pair<>(-2, 0);
        }
        if (!aVar.f256913b.equals(str2)) {
            return new Pair<>(-7, 0);
        }
        if (!aVar.i(512)) {
            return new Pair<>(-4, 0);
        }
        String b16 = aVar.b(str3);
        String b17 = aVar.b(str4);
        if (!TextUtils.isEmpty(b16) && !TextUtils.isEmpty(b17)) {
            try {
                long parseLong = Long.parseLong(b17);
                if (i3 == 1 && !c.c(qQAppInterface, b16)) {
                    return new Pair<>(-11, 0);
                }
                if (i3 != 2 && i3 != 1 && i3 != 4) {
                    return new Pair<>(-5, 0);
                }
                MessageRecord w06 = qQAppInterface.getMessageFacade().w0(b16, com.tencent.mobileqq.openapi.utils.a.c(i3), parseLong);
                if (w06 != null && !w06.isSendFromLocal()) {
                    checkDownloadPtt(qQAppInterface, w06, true);
                    return new Pair<>(0, Integer.valueOf(com.tencent.mobileqq.openapi.utils.a.e(qQAppInterface, (MessageForPtt) w06)));
                }
                return new Pair<>(-14, 0);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "downMedia", e16);
                }
                return new Pair<>(-6, 0);
            }
        }
        return new Pair<>(-6, 0);
    }

    public f[] exchangeUins(String str, String str2, long j3, long j16, String[] strArr) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (f[]) iPatchRedirector.redirect((short) 9, this, str, str2, Long.valueOf(j3), Long.valueOf(j16), strArr);
        }
        f[] fVarArr = {new f(0, null)};
        a.C8192a b16 = com.tencent.mobileqq.openapi.a.b(BaseApplicationImpl.sApplication, str);
        if (b16 == null) {
            return fVarArr;
        }
        if (b16.f256911l != j16) {
            fVarArr[0].f256973b = -20;
            return fVarArr;
        }
        if (b16.f256908i != j3) {
            fVarArr[0].f256973b = -19;
            return fVarArr;
        }
        com.tencent.mobileqq.openapi.entity.a aVar = new com.tencent.mobileqq.openapi.entity.a(b16);
        if (!aVar.i(4)) {
            fVarArr[0].f256973b = -4;
            return fVarArr;
        }
        f[] fVarArr2 = new f[strArr.length];
        for (int i16 = 0; i16 < strArr.length; i16++) {
            f fVar = new f(0, null);
            fVarArr2[i16] = fVar;
            try {
                fVar.f256974c = aVar.d(aVar.c(strArr[i16]));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "", e16);
                }
            }
            f fVar2 = fVarArr2[i16];
            if (TextUtils.isEmpty(fVar2.f256974c)) {
                i3 = -6;
            } else {
                i3 = 0;
            }
            fVar2.f256973b = i3;
        }
        return fVarArr2;
    }

    public f getAvatarPath(String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (f) iPatchRedirector.redirect((short) 14, this, str, str2, str3, Integer.valueOf(i3));
        }
        QQAppInterface qQAppInterface = this.mLoginSucApp;
        if (qQAppInterface == null) {
            return new f(-1, null);
        }
        com.tencent.mobileqq.openapi.entity.a aVar = this.mThirdAppMap.get(str);
        if (aVar == null) {
            return new f(-2, null);
        }
        if (!aVar.f256913b.equals(str2)) {
            return new f(-7, null);
        }
        if (!aVar.i(4)) {
            return new f(-4, null);
        }
        String b16 = aVar.b(str3);
        if (TextUtils.isEmpty(b16)) {
            return new f(-6, null);
        }
        if (i3 == 2) {
            i16 = 101;
        } else if (i3 == 4) {
            i16 = 4;
        }
        return new f(0, qQAppInterface.getCustomFaceFilePath(i16, b16, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getLastMessages(List<com.tencent.mobileqq.openapi.sdk.d> list, String str, String str2, String str3, int i3, int i16, boolean z16, boolean z17) {
        int i17;
        List<MessageRecord> list2;
        com.tencent.mobileqq.openapi.entity.a aVar;
        QQAppInterface qQAppInterface;
        boolean z18;
        int i18;
        int i19;
        int i26;
        char c16;
        int i27;
        String str4;
        String str5;
        int i28;
        String plainText;
        String str6;
        String d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c17 = '\b';
        int i29 = 4;
        int i36 = 3;
        int i37 = 2;
        boolean z19 = false;
        int i38 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, this, list, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17))).intValue();
        }
        QQAppInterface qQAppInterface2 = this.mLoginSucApp;
        if (qQAppInterface2 == null) {
            return -1;
        }
        if (!c.d(i3)) {
            return -5;
        }
        com.tencent.mobileqq.openapi.entity.a aVar2 = this.mThirdAppMap.get(str);
        if (aVar2 == null) {
            return -2;
        }
        if (!aVar2.f256913b.equals(str2)) {
            return -7;
        }
        String b16 = aVar2.b(str3);
        if (TextUtils.isEmpty(b16)) {
            return -6;
        }
        if (!aVar2.i(2)) {
            return -4;
        }
        List<MessageRecord> N = qQAppInterface2.getMessageFacade().N(b16, com.tencent.mobileqq.openapi.utils.a.c(i3), i16);
        ad.P(b16, com.tencent.mobileqq.openapi.utils.a.c(i3), N, qQAppInterface2.getMsgCache());
        int i39 = 0;
        while (i39 < N.size()) {
            MessageRecord messageRecord = N.get(i39);
            if ((z16 && messageRecord.isSend()) || (z17 && messageRecord.isread)) {
                i17 = i39;
                list2 = N;
                aVar = aVar2;
                qQAppInterface = qQAppInterface2;
                z18 = z19;
                i27 = i38;
                i18 = i37;
                i19 = i36;
                i26 = i29;
                c16 = c17;
            } else {
                if (messageRecord instanceof ChatMessage) {
                    ((ChatMessage) messageRecord).parse();
                }
                int a16 = com.tencent.mobileqq.openapi.utils.a.a(messageRecord.msgtype);
                String d17 = aVar2.d(String.valueOf(messageRecord.uniseq));
                if (a16 == i38 && aVar2.j(i3, i38)) {
                    plainText = new QQText(messageRecord.f203106msg, i36).toPlainText();
                } else if (a16 == i37 && (messageRecord instanceof MessageForPtt) && aVar2.j(i3, i37)) {
                    checkDownloadPtt(qQAppInterface2, messageRecord, z19);
                    MessageForPtt messageForPtt = (MessageForPtt) messageRecord;
                    String localFilePath = messageForPtt.getLocalFilePath();
                    i28 = com.tencent.mobileqq.openapi.utils.a.e(qQAppInterface2, messageForPtt);
                    str6 = localFilePath;
                    str5 = null;
                    int i46 = a16;
                    if (i3 == 1) {
                    }
                    i17 = i39;
                    list2 = N;
                    String str7 = d16;
                    aVar = aVar2;
                    qQAppInterface = qQAppInterface2;
                    i27 = 1;
                    z18 = z19;
                    i18 = 2;
                    i19 = 3;
                    String str8 = str5;
                    i26 = i29;
                    String str9 = str6;
                    c16 = '\b';
                    list.add(new com.tencent.mobileqq.openapi.sdk.d(str3, i3, str7, i46, d17, messageRecord.time, messageRecord.isSend(), str8, str9, i28));
                } else if (a16 == i29 && aVar2.j(i3, i29)) {
                    plainText = new QQText(messageRecord.f203106msg, i36).toPlainText();
                } else {
                    if (a16 == 8 && aVar2.j(i3, 8)) {
                        str4 = com.tencent.mobileqq.openapi.sdk.d.f256953l;
                    } else if (a16 == 16 && aVar2.j(i3, 16)) {
                        str4 = com.tencent.mobileqq.openapi.sdk.d.f256954m;
                    } else if (a16 == 32 && aVar2.j(i3, 32)) {
                        str4 = com.tencent.mobileqq.openapi.sdk.d.f256955n;
                    } else if (a16 == 64 && aVar2.j(i3, 64)) {
                        str4 = com.tencent.mobileqq.openapi.sdk.d.f256956o;
                    } else {
                        a16 = 1073741824;
                        if (aVar2.j(i3, 1073741824)) {
                            str4 = com.tencent.mobileqq.openapi.sdk.d.f256957p;
                        } else {
                            i17 = i39;
                            list2 = N;
                            aVar = aVar2;
                            qQAppInterface = qQAppInterface2;
                            z18 = z19;
                            i18 = i37;
                            i19 = i36;
                            i26 = i29;
                            c16 = '\b';
                            i27 = 1;
                        }
                    }
                    str5 = str4;
                    i28 = 1007;
                    str6 = null;
                    int i462 = a16;
                    if (i3 == 1) {
                        d16 = "";
                    } else {
                        d16 = aVar2.d(messageRecord.senderuin);
                    }
                    i17 = i39;
                    list2 = N;
                    String str72 = d16;
                    aVar = aVar2;
                    qQAppInterface = qQAppInterface2;
                    i27 = 1;
                    z18 = z19;
                    i18 = 2;
                    i19 = 3;
                    String str82 = str5;
                    i26 = i29;
                    String str92 = str6;
                    c16 = '\b';
                    list.add(new com.tencent.mobileqq.openapi.sdk.d(str3, i3, str72, i462, d17, messageRecord.time, messageRecord.isSend(), str82, str92, i28));
                }
                str5 = plainText;
                i28 = 1007;
                str6 = null;
                int i4622 = a16;
                if (i3 == 1) {
                }
                i17 = i39;
                list2 = N;
                String str722 = d16;
                aVar = aVar2;
                qQAppInterface = qQAppInterface2;
                i27 = 1;
                z18 = z19;
                i18 = 2;
                i19 = 3;
                String str822 = str5;
                i26 = i29;
                String str922 = str6;
                c16 = '\b';
                list.add(new com.tencent.mobileqq.openapi.sdk.d(str3, i3, str722, i4622, d17, messageRecord.time, messageRecord.isSend(), str822, str922, i28));
            }
            i39 = i17 + 1;
            i29 = i26;
            c17 = c16;
            z19 = z18;
            aVar2 = aVar;
            i36 = i19;
            i37 = i18;
            N = list2;
            qQAppInterface2 = qQAppInterface;
            i38 = i27;
        }
        return z19 ? 1 : 0;
    }

    public f getNickName(String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (f) iPatchRedirector.redirect((short) 15, this, str, str2, str3, Integer.valueOf(i3));
        }
        if (this.mLoginSucApp == null) {
            return new f(-1, null);
        }
        com.tencent.mobileqq.openapi.entity.a aVar = this.mThirdAppMap.get(str);
        if (aVar == null) {
            return new f(-2, null);
        }
        if (!aVar.f256913b.equals(str2)) {
            return new f(-7, null);
        }
        if (!aVar.i(8)) {
            return new f(-4, null);
        }
        if (!c.d(i3)) {
            return new f(-5, null);
        }
        String b16 = aVar.b(str3);
        if (TextUtils.isEmpty(b16)) {
            return new f(-6, null);
        }
        return new f(0, ac.Q(this.mLoginSucApp, b16, com.tencent.mobileqq.openapi.utils.a.c(i3)));
    }

    public List<f> handlePayMsgReq(String str, String str2, String str3, int i3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, this, str, str2, str3, Integer.valueOf(i3), str4);
        }
        QQAppInterface qQAppInterface = this.mLoginSucApp;
        if (qQAppInterface == null) {
            return handlePayMsgRsp(new f(i3, -1, str4));
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            a.C8192a b16 = com.tencent.mobileqq.openapi.a.b(BaseApplicationImpl.sApplication, str);
            if (b16 == null) {
                return handlePayMsgRsp(new f(i3, -8, str4));
            }
            if (!b16.f256902c.equals(str2)) {
                return handlePayMsgRsp(new f(i3, -7, str4));
            }
            if (!com.tencent.mobileqq.openapi.a.e(BaseApplicationImpl.sApplication, str2, b16.f256903d)) {
                return handlePayMsgRsp(new f(i3, -7, str4));
            }
            this.mLastGetPayCodePkgName = str2;
            this.mLastGetPayCodePermission = str3;
            Bundle bundle = new Bundle();
            bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 15);
            HashMap hashMap = new HashMap();
            hashMap.put(PushClientConstants.TAG_PKG_NAME, b16.f256902c);
            hashMap.put("businessType", String.valueOf(i3));
            hashMap.put("reqData", str4);
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            bundle.putString("uin", currentAccountUin);
            bundle.putSerializable("map", hashMap);
            QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, bundle);
            SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(IQWalletHelper.PREF_NAME_MULTI_PROCESS, 4);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putLong(IQWalletHelper.PREF_KEY_MULTI_TENWATCH_REQ_TIME_PREFIX + currentAccountUin, NetConnInfoCenter.getServerTimeMillis() / 1000).commit();
            }
            return handlePayMsgRsp(null);
        }
        return handlePayMsgRsp(new f(i3, -6, str4));
    }

    public List<f> handlePayMsgRsp(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, (Object) this, (Object) fVar);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.mPayMsgRspQueue) {
            while (!this.mPayMsgRspQueue.isEmpty()) {
                arrayList.add(this.mPayMsgRspQueue.poll());
            }
            this.mPayMsgRspQueue.clear();
        }
        if (fVar != null) {
            arrayList.add(fVar);
        }
        return arrayList;
    }

    public boolean isSDKEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.openapi_switch.name(), null);
        if (featureValue == null) {
            return true;
        }
        if (featureValue.length() > 1) {
            featureValue = featureValue.substring(0, 1);
        }
        return featureValue.equals("0");
    }

    public void onFileTransStatusChanged(FileMsg fileMsg, int i3, int i16) {
        int i17;
        QQAppInterface qQAppInterface;
        QQMessageFacade messageFacade;
        MessageRecord w06;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 4;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, fileMsg, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (fileMsg.fileType == 2 && i3 != 2002 && i3 != 1002 && i3 != 2001 && this.mThirdAppMap.size() != 0 && isSDKEnable()) {
            if (this.mSendingMsgMap.contains(Long.valueOf(fileMsg.uniseq)) && (i3 == 1004 || i3 == 1005 || i3 == 1003)) {
                com.tencent.mobileqq.openapi.entity.a aVar = this.mThirdAppMap.get(this.mSendingMsgMap.remove(Long.valueOf(fileMsg.uniseq)));
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onPttStateChange, thirdApp = " + aVar + ", status = " + i3);
                }
                if (aVar != null) {
                    Intent intent = new Intent("com.tencent.mobileqq.openapi.ACTION_MSG_SENDED." + aVar.f256913b);
                    intent.putExtra("msgid", aVar.d(String.valueOf(fileMsg.uniseq)));
                    if (i3 == 1003) {
                        i18 = 0;
                    } else {
                        i18 = -9;
                    }
                    intent.putExtra(IQQGameProviderService.COLUMN_NAME_RS_CODE, i18);
                    BaseApplicationImpl.sApplication.sendBroadcast(intent, aVar.f256924m);
                }
            }
            int i26 = fileMsg.uinType;
            if (i26 == 0) {
                i19 = 1;
                i17 = 0;
            } else if (i26 == 2) {
                i17 = 3000;
                i19 = 2;
            } else if (i26 == 1) {
                i17 = 1;
            } else {
                i17 = 0;
                i19 = 0;
            }
            if ((this.msgTypeFilterOfApps & 2) > 0 && (this.uinTypeFilterOfApps & i19) > 0) {
                String str = fileMsg.friendUin;
                QQAppInterface qQAppInterface2 = this.mLoginSucApp;
                if (fileMsg.actionType != 0) {
                    z16 = false;
                }
                int d16 = com.tencent.mobileqq.openapi.utils.a.d(qQAppInterface2, i3, z16);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onPttStateChange, uin = " + str + ", extStatus = " + d16);
                }
                Intent intent2 = null;
                for (com.tencent.mobileqq.openapi.entity.a aVar2 : this.mThirdAppMap.values()) {
                    if (intent2 == null) {
                        intent2 = new Intent();
                        intent2.putExtra(IPublicAccountBrowser.KEY_UIN_TYPE, i19);
                        intent2.putExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, 2);
                        intent2.putExtra("mediaStatus", d16);
                    }
                    if (d16 == 1003 && (qQAppInterface = this.mLoginSucApp) != null && (messageFacade = qQAppInterface.getMessageFacade()) != null && (w06 = messageFacade.w0(str, i17, fileMsg.uniseq)) != null) {
                        intent2.putExtra("media_path", ((MessageForPtt) w06).getLocalFilePath());
                    }
                    if (aVar2.g(i19, 2)) {
                        intent2.putExtra("msgid", aVar2.d(String.valueOf(fileMsg.uniseq)));
                        intent2.setAction("com.tencent.mobileqq.openapi.ACTION_MSG_STATUS_UPDATE." + aVar2.f256913b);
                        BaseApplicationImpl.sApplication.sendBroadcast(intent2, aVar2.f256924m);
                    }
                }
            }
        }
    }

    public void onMessageReaded(String str, int i3, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        if (this.mThirdAppMap.size() != 0 && this.mLoginSucApp != null && isSDKEnable()) {
            if (i3 == 0 || i3 == 3000 || i3 == 1) {
                int b16 = com.tencent.mobileqq.openapi.utils.a.b(i3);
                if ((this.uinTypeFilterOfApps & b16) > 0) {
                    Intent intent = null;
                    for (com.tencent.mobileqq.openapi.entity.a aVar : this.mThirdAppMap.values()) {
                        if (intent == null) {
                            intent = new Intent();
                            intent.putExtra(IPublicAccountBrowser.KEY_UIN_TYPE, b16);
                            intent.putExtra("is_all", z16);
                            intent.putExtra("msgTime", j3);
                        }
                        if (aVar.k(b16)) {
                            intent.putExtra("uin", aVar.d(str));
                            intent.setAction("com.tencent.mobileqq.openapi.ACTION_MSG_READED." + aVar.f256913b);
                            BaseApplicationImpl.sApplication.sendBroadcast(intent, aVar.f256924m);
                        }
                    }
                }
            }
        }
    }

    public final void onPayMsgRsp(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) fVar);
            return;
        }
        if (checkNeedPayAuth(fVar)) {
            return;
        }
        synchronized (this.mPayMsgRspQueue) {
            int size = this.mPayMsgRspQueue.size();
            if (size > 200) {
                this.mPayMsgRspQueue.clear();
            } else if (size > 50 && QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "Pay rsp queue size:" + size);
            }
            this.mPayMsgRspQueue.add(fVar);
        }
        if (this.mLoginSucApp != null && isSDKEnable()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mobileqq.openapi.ACTION_PAYMSG_RCV." + this.mLastGetPayCodePkgName);
            BaseApplicationImpl.sApplication.sendBroadcast(intent, this.mLastGetPayCodePermission);
        }
    }

    public void onReceiveNewMsg(Message message) {
        int i3;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) message);
            return;
        }
        QQAppInterface qQAppInterface = this.mLoginSucApp;
        if (this.mThirdAppMap.size() != 0 && qQAppInterface != null && isSDKEnable()) {
            int i16 = message.istroop;
            if (i16 == 0 || i16 == 3000 || i16 == 1) {
                int a16 = com.tencent.mobileqq.openapi.utils.a.a(message.msgtype);
                int b16 = com.tencent.mobileqq.openapi.utils.a.b(message.istroop);
                int i17 = this.msgTypeFilterOfApps;
                if (((i17 & a16) > 0 || (i17 & 1073741824) > 0) && (this.uinTypeFilterOfApps & b16) > 0) {
                    String str = message.frienduin;
                    String str2 = message.senderuin;
                    int R = qQAppInterface.getConversationFacade().R(message.frienduin, message.istroop);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "new msg, uin = " + StringUtil.getSimpleUinForPrint(str));
                    }
                    Intent intent2 = null;
                    boolean z16 = false;
                    for (com.tencent.mobileqq.openapi.entity.a aVar : this.mThirdAppMap.values()) {
                        if (intent2 == null) {
                            intent2 = new Intent();
                            intent2.putExtra(IPublicAccountBrowser.KEY_UIN_TYPE, b16);
                            intent2.putExtra("unreadCount", R);
                        }
                        Intent intent3 = intent2;
                        boolean g16 = aVar.g(b16, a16);
                        if (g16 || aVar.h(b16)) {
                            if (g16) {
                                i3 = a16;
                            } else {
                                i3 = 0;
                            }
                            intent3.putExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, i3);
                            intent3.putExtra("uin", aVar.d(str));
                            intent3.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, aVar.d(str2));
                            intent3.setAction("com.tencent.mobileqq.openapi.ACTION_NEW_MSG." + aVar.f256913b);
                            BaseApplicationImpl.sApplication.sendBroadcast(intent3, aVar.f256924m);
                            if (message.msgtype == -2002 && !z16) {
                                intent = intent3;
                                checkDownloadPtt(qQAppInterface, message.frienduin, message.istroop, message.uniseq);
                                z16 = true;
                                intent2 = intent;
                            }
                        }
                        intent = intent3;
                        intent2 = intent;
                    }
                }
            }
        }
    }

    public void onRuntimeActive(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.openapi.OpenApiManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f256890d;

                {
                    this.f256890d = qQAppInterface;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OpenApiManager.this, (Object) qQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(OpenApiManager.TAG, 2, "onRuntimeCreate, app = " + this.f256890d + ", current = " + OpenApiManager.this.mLoginSucApp + ", bg = " + BaseApplicationImpl.sIsBgStartup);
                    }
                    OpenApiManager openApiManager = OpenApiManager.this;
                    openApiManager.onRuntimeDestroy(openApiManager.mLoginSucApp);
                    OpenApiManager.this.mLoginSucApp = this.f256890d;
                    Intent intent = new Intent("com.tencent.mobileqq.openapi.ACTION_LOGIN");
                    if (BaseApplicationImpl.sIsBgStartup) {
                        intent.putExtra("imm_reg", true);
                    }
                    BaseApplicationImpl.sApplication.sendBroadcast(intent);
                    OpenApiManager.this.mLoginSucApp.addObserver(OpenApiManager.this.mMsgObserver, true);
                }
            });
        }
    }

    public void onRuntimeDestroy(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface);
        } else {
            onRuntimeDisactive(qQAppInterface, false);
        }
    }

    public void onUserLogout(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface);
        } else {
            onRuntimeDisactive(qQAppInterface, true);
        }
    }

    public int openAIO(String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, str, str2, str3, Integer.valueOf(i3))).intValue();
        }
        QQAppInterface qQAppInterface = this.mLoginSucApp;
        if (qQAppInterface == null) {
            return -1;
        }
        com.tencent.mobileqq.openapi.entity.a aVar = this.mThirdAppMap.get(str);
        if (aVar == null) {
            return -2;
        }
        if (!aVar.f256913b.equals(str2)) {
            return -7;
        }
        if (!aVar.i(64)) {
            return -4;
        }
        String b16 = aVar.b(str3);
        if (TextUtils.isEmpty(b16)) {
            return -6;
        }
        if (i3 == 1) {
            c.a aVar2 = new c.a(qQAppInterface, b16);
            if (!aVar2.c()) {
                return -11;
            }
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(BaseApplicationImpl.sApplication), new int[]{2});
            m3.addFlags(268435456);
            m3.putExtra("uin", b16);
            m3.putExtra(AppConstants.Key.CSPECIAL_FLAG, aVar2.a());
            m3.putExtra("uinname", aVar2.b());
            if (CrmUtils.s(aVar2.a()) || QidianManager.O(aVar2.a())) {
                m3.setComponent(SplashActivity.getAliasComponent(BaseApplicationImpl.sApplication));
                m3.putExtra("chat_subType", 1);
            }
            m3.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0);
            m3.putExtra("uintype", 0);
            BaseApplicationImpl.sApplication.startActivity(m3);
            return 0;
        }
        return -5;
    }

    public e registerThirdApp(String str, String str2, long j3, int i3, int i16, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str3);
        }
        QQAppInterface qQAppInterface = this.mLoginSucApp;
        if (qQAppInterface == null) {
            return new e(-1, 0L, null);
        }
        com.tencent.mobileqq.openapi.entity.a aVar = this.mThirdAppMap.get(str);
        if (aVar == null) {
            a.C8192a b16 = com.tencent.mobileqq.openapi.a.b(BaseApplicationImpl.sApplication, str);
            if (b16 == null) {
                return new e(-8, 0L, null);
            }
            if (!b16.f256902c.equals(str2)) {
                return new e(-7, 0L, null);
            }
            if (!com.tencent.mobileqq.openapi.a.e(BaseApplicationImpl.sApplication, str2, b16.f256903d)) {
                return new e(-7, 0L, null);
            }
            boolean z16 = b16.f256909j;
            if (z16) {
                long j16 = b16.f256911l;
                if (j3 != j16) {
                    return new e(-18, j16, null);
                }
            }
            if (!z16) {
                long j17 = b16.f256908i;
                if (j3 != j17) {
                    return new e(-18, j17, null);
                }
            }
            if (z16) {
                com.tencent.mobileqq.openapi.a.d(BaseApplicationImpl.sApplication, b16);
            }
            com.tencent.mobileqq.openapi.entity.a aVar2 = new com.tencent.mobileqq.openapi.entity.a(b16);
            aVar2.f256924m = str3;
            this.mThirdAppMap.put(str, aVar2);
            aVar = aVar2;
        } else if (!aVar.f256913b.equals(str2)) {
            return new e(-7, 0L, null);
        }
        if (j3 != aVar.f256915d) {
            this.mThirdAppMap.remove(str);
            resetFilters();
            return new e(-18, aVar.f256915d, null);
        }
        aVar.l(i3, i16);
        resetFilters();
        return new e(0, 0L, aVar.d(qQAppInterface.getCurrentAccountUin()));
    }

    public f sendMessage(String str, String str2, String str3, int i3, int i16, String str4, String str5) {
        com.tencent.mobileqq.openapi.entity.a aVar;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (f) iPatchRedirector.redirect((short) 16, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), str4, str5);
        }
        QQAppInterface qQAppInterface = this.mLoginSucApp;
        if (qQAppInterface == null) {
            return new f(-1, null);
        }
        com.tencent.mobileqq.openapi.entity.a aVar2 = this.mThirdAppMap.get(str);
        if (aVar2 == null) {
            return new f(-2, null);
        }
        if (!aVar2.f256913b.equals(str2)) {
            return new f(-7, null);
        }
        if (!aVar2.i(8)) {
            return new f(-4, null);
        }
        String b16 = aVar2.b(str3);
        if (TextUtils.isEmpty(b16)) {
            return new f(-6, null);
        }
        if (i3 == 1) {
            if (!c.c(qQAppInterface, b16)) {
                return new f(-11, null);
            }
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179557e = b16;
            sessionInfo.f179555d = 0;
            sessionInfo.f179563i = ac.H(qQAppInterface, b16);
            if (i16 == 1) {
                if (TextUtils.isEmpty(str4)) {
                    return new f(-6, null);
                }
                aVar = aVar2;
                long[] M0 = ChatActivityFacade.M0(qQAppInterface, qQAppInterface.getApp(), sessionInfo, str4, null, new ChatActivityFacade.d());
                if (M0 != null && M0.length != 0) {
                    j3 = M0[M0.length - 1];
                } else {
                    return new f(-9, null);
                }
            } else {
                aVar = aVar2;
                if (i16 == 2) {
                    if (TextUtils.isEmpty(str5)) {
                        return new f(-6, null);
                    }
                    File file = new File(str5);
                    if (file.exists() && file.length() >= 700 && file.length() <= 42000) {
                        if (!cm.e(str5, com.tencent.mobileqq.openapi.sdk.b.f256949a)) {
                            return new f(-13, null);
                        }
                        String localFilePath = MessageForPtt.getLocalFilePath(2, TransFileUtil.getTransferFilePath(qQAppInterface.getCurrentAccountUin(), null, 2, null));
                        FileUtils.copyFile(str5, localFilePath);
                        MessageRecord K = ChatActivityFacade.K(qQAppInterface, localFilePath, sessionInfo, -3, 0);
                        if (K != null) {
                            ((MessageForPtt) K).c2cViaOffline = true;
                            j3 = K.uniseq;
                            Bundle bundle = new Bundle();
                            bundle.putInt("DiyTextId", K.vipBubbleDiyTextId);
                            ChatActivityFacade.b1(qQAppInterface, sessionInfo.f179555d, sessionInfo.f179557e, localFilePath, j3, true, (int) (((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getFilePlayTime(localFilePath) * 1000), 0, true, 0, 0, true, K.vipSubBubbleId, bundle);
                        }
                    } else {
                        return new f(-6, null);
                    }
                }
                j3 = 0;
            }
            this.mSendingMsgMap.put(Long.valueOf(j3), str);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "send message: " + j3);
            }
            return new f(0, aVar.d(String.valueOf(j3)));
        }
        return new f(-5, null);
    }

    public int setMessageReaded(String str, String str2, String str3, int i3, String str4) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, this, str, str2, str3, Integer.valueOf(i3), str4)).intValue();
        }
        QQAppInterface qQAppInterface = this.mLoginSucApp;
        if (qQAppInterface == null) {
            return -1;
        }
        com.tencent.mobileqq.openapi.entity.a aVar = this.mThirdAppMap.get(str);
        if (aVar == null) {
            return -2;
        }
        if (!aVar.f256913b.equals(str2)) {
            return -7;
        }
        if (!aVar.i(16)) {
            return -4;
        }
        String b16 = aVar.b(str3);
        String b17 = aVar.b(str4);
        try {
            j3 = Long.parseLong(b17);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setMsgReaded, id = " + b17, e16);
            }
            j3 = 0;
        }
        if (!TextUtils.isEmpty(b16) && !TextUtils.isEmpty(b17) && j3 != 0) {
            if (i3 == 1) {
                QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                MessageRecord w06 = messageFacade.w0(b16, 0, j3);
                if (w06 == null) {
                    return -14;
                }
                messageFacade.M0(b16, 0, w06.time);
                return 0;
            }
            return -5;
        }
        return -6;
    }

    public int unregisterThirdApp(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "unregister, appid = " + str);
        }
        com.tencent.mobileqq.openapi.entity.a aVar = this.mThirdAppMap.get(str);
        if (aVar != null && !aVar.f256913b.equals(str2)) {
            return -7;
        }
        this.mThirdAppMap.remove(str);
        return 0;
    }

    public boolean verifyCallingPackage(ContentProvider contentProvider, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) contentProvider, (Object) str)).booleanValue();
        }
        try {
            int callingUid = Binder.getCallingUid();
            if (callingUid == 0) {
                return false;
            }
            for (String str2 : BaseApplicationImpl.sApplication.getPackageManager().getPackagesForUid(callingUid)) {
                if (str2.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "verifyPackage " + str, e16);
            }
            return false;
        }
    }

    private void checkDownloadPtt(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16) {
        if (messageRecord == null || !(messageRecord instanceof MessageForPtt)) {
            return;
        }
        MessageForPtt messageForPtt = (MessageForPtt) messageRecord;
        int f16 = n.f(qQAppInterface, messageForPtt);
        if (f16 == -1) {
            ChatActivityFacade.O(qQAppInterface, messageRecord.frienduin, messageForPtt, true, 3, 0, true);
        } else if (z16) {
            if (f16 == 2005 || f16 == 2004) {
                ChatActivityFacade.O(qQAppInterface, messageRecord.frienduin, messageForPtt, true, 2, 0, false);
            }
        }
    }
}
