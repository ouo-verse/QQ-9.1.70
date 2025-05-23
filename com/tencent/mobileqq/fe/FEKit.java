package com.tencent.mobileqq.fe;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.channel.ChannelManager;
import com.tencent.mobileqq.channel.ChannelProxy;
import com.tencent.mobileqq.dt.Dtn;
import com.tencent.mobileqq.dt.app.Dtc;
import com.tencent.mobileqq.fe.utils.DeepSleepDetector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.mobileqq.qsec.qsecurity.utils.ByteConvert;
import com.tencent.mobileqq.sign.QQSecuritySign;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FEKit {
    static IPatchRedirector $redirector_ = null;
    public static final String QMMKV_FILE = "common_mmkv_configurations";
    public static final String QMMKV_FILE_QSEC = "qsec_mmkv_configurations";
    private static final String TAG = "FEKit_Main";
    private static volatile FEKit instance;
    public String initErrorMsg;
    public long initTime;
    private boolean isSafeMode;
    private g mAppEventDispatcher;
    private Context mFEContext;
    public boolean mInit;
    private AtomicBoolean mMainProcessInit;
    private String mNotifyProcessId;
    private int mNotifySeq;
    private String mUin;
    public String sleepCheckResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements EventCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FEKit.this);
            }
        }

        @Override // com.tencent.mobileqq.fe.EventCallback
        public void onResult(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
            } else if (FEKit.this.mAppEventDispatcher != null) {
                FEKit.this.mAppEventDispatcher.dispatchEventToApp("socialError", bArr);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements EventCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FEKit.this);
            }
        }

        @Override // com.tencent.mobileqq.fe.EventCallback
        public void onResult(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
            }
        }
    }

    public FEKit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mUin = "0";
        this.mNotifySeq = Integer.MIN_VALUE;
        this.mNotifyProcessId = "";
        this.isSafeMode = false;
        this.mMainProcessInit = new AtomicBoolean(false);
        this.initTime = 0L;
        this.sleepCheckResult = "-1";
        this.initErrorMsg = "0";
        this.mInit = false;
    }

    private void checkResetSafeMode() {
        try {
            if (d.n()) {
                this.isSafeMode = false;
                initContext(this.mFEContext, this.mUin);
                ChannelManager.getInstance().setNativeChannel();
                initSafeMode();
                startTaskSystem();
            }
        } catch (Throwable unused) {
            c.a(TAG, 1, "safe mode checkResetSafeMode error!");
        }
    }

    private void checkSafeMode() {
        try {
            if (d.b() && d.e()) {
                this.isSafeMode = true;
            }
            c.c(TAG, 1, "s m " + this.isSafeMode);
        } catch (Throwable th5) {
            c.a(TAG, 1, "safe mode error!,info:" + th5.getMessage());
        }
    }

    public static FEKit getInstance() {
        if (instance == null) {
            synchronized (FEKit.class) {
                if (instance == null) {
                    instance = new FEKit();
                }
            }
        }
        return instance;
    }

    private void initSafeMode() {
        if (soLoaded()) {
            QQSecuritySign.getInstance().initSafeMode(this.isSafeMode);
        }
    }

    private synchronized void onNotifyAccountChanged(String str, EventCallback eventCallback) {
        c.c(TAG, 1, "notifyAccountChange " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("account", "0");
            int optInt = jSONObject.optInt("seq", 0);
            String optString2 = jSONObject.optString("process", "");
            if (!optString2.equals(this.mNotifyProcessId) || optInt > this.mNotifySeq) {
                this.mNotifySeq = optInt;
                this.mNotifyProcessId = optString2;
                if (!optString.equals(this.mUin)) {
                    onAccountChange(optString);
                    com.tencent.mobileqq.fe.utils.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.fe.FEKit.4
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FEKit.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                FEKit.this.requestToken();
                            }
                        }
                    });
                }
            }
        } catch (JSONException unused) {
            c.c(TAG, 1, "notifyAccountChange error " + str);
        }
        eventCallback.onResult(0, new byte[0]);
    }

    private boolean soLoaded() {
        return e.b().e();
    }

    private void startTaskSystem() {
        if (checkStatus()) {
            QSec.getInstance().execTasks(this.mFEContext, 1);
        }
    }

    public boolean checkStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (soLoaded() && !this.isSafeMode) {
            return true;
        }
        return false;
    }

    public void dispatchEvent(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            dispatchEvent(str, str2, new b());
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) str2);
        }
    }

    public List<String> getCmdWhiteList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (soLoaded()) {
            return ChannelManager.getInstance().getCmdWhiteList();
        }
        return new ArrayList();
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mFEContext;
    }

    public String getCurUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mUin;
    }

    public byte[] getFeKitAttach(Context context, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (byte[]) iPatchRedirector.redirect((short) 24, this, context, str, str2, str3);
        }
        return QSec.getInstance().getFeKitAttach(context, str, str2, str3);
    }

    public QQSecuritySign.SignResult getSign(String str, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? getSign(str, bArr, i3, this.mUin) : (QQSecuritySign.SignResult) iPatchRedirector.redirect((short) 14, this, str, bArr, Integer.valueOf(i3));
    }

    public synchronized void init(Context context, String str, String str2, String str3, String str4, String str5) {
        String str6;
        String str7;
        String str8;
        String str9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, str, str2, str3, str4, str5);
            return;
        }
        if (!this.mInit) {
            if (str2 == null) {
                str6 = "";
            } else {
                str6 = str2;
            }
            if (str4 == null) {
                str7 = "";
            } else {
                str7 = str4;
            }
            if (str5 == null) {
                str8 = "";
            } else {
                str8 = str5;
            }
            DeepSleepDetector.startCheck();
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mFEContext = context;
            Dtc.setQ36(str7);
            com.tencent.mobileqq.fe.utils.a.a().c(new Runnable(context) { // from class: com.tencent.mobileqq.fe.FEKit.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f205808d;

                {
                    this.f205808d = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FEKit.this, (Object) context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        Process.setThreadPriority(10);
                        Dtc.retportAccessibilityServiceList(this.f205808d);
                    }
                }
            }, 10000L);
            String g16 = f.a().g("mainAccount");
            if (TextUtils.isEmpty(g16)) {
                c.c(TAG, 1, "sdk init local uin empty");
                str9 = str;
            } else {
                str9 = g16;
            }
            if (!str9.equals(str)) {
                this.initErrorMsg = str9 + ":" + str;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("sdk init uin notMatch ");
                sb5.append(this.initErrorMsg);
                c.a(TAG, 1, sb5.toString());
            }
            this.mUin = str9;
            e.b().i();
            checkSafeMode();
            initSafeMode();
            com.tencent.mobileqq.fe.b.a(str8, str6, str7, str9);
            initContext(context, str9);
            QSec.getInstance().init(context, str9, str6, str3, str7, str8);
            QQSecuritySign.getInstance().init(str8);
            startTaskSystem();
            this.mInit = true;
            this.initTime = SystemClock.uptimeMillis() - uptimeMillis;
            this.sleepCheckResult = DeepSleepDetector.getCheckResult();
            c.c(TAG, 1, "cost " + this.initTime);
        }
    }

    public void initContext(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) context, (Object) str);
            return;
        }
        if (checkStatus()) {
            File file = new File(context.getFilesDir(), "5463306EE50FE3AA");
            if (!file.exists()) {
                file.mkdirs();
            }
            Dtn.a().initLog(c.b());
            Dtn.a().initContext(context, file.getAbsolutePath());
            Dtn.a().initUin(str);
        }
        c.c(TAG, 1, "i c");
    }

    public void initLog(IFEKitLog iFEKitLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iFEKitLog);
            return;
        }
        c.d(iFEKitLog);
        if (checkStatus()) {
            Dtn.a().initLog(c.b());
        }
    }

    public synchronized void initM(Context context, String str, String str2, String str3, String str4, ChannelProxy channelProxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, str, str2, str3, str4, channelProxy);
            return;
        }
        if (this.mMainProcessInit.compareAndSet(false, true)) {
            this.mFEContext = context;
            this.mUin = str;
            e.b().i();
            if (checkStatus()) {
                if (str4 == null) {
                    str4 = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                if (str3 == null) {
                    str3 = "";
                }
                if (str == null) {
                    str = "";
                }
                com.tencent.mobileqq.fe.b.a(str4, str2, str3, str);
                Dtn.a().initLog(c.b());
                Dtn.a().initMainProcess(context, channelProxy);
            }
        }
    }

    public boolean loadSo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return e.b().i();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadSoAsync() {
        String processName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                processName = Application.getProcessName();
            } catch (Throwable unused) {
            }
            c.a(TAG, 1, "load so ProcessName:" + processName);
            if (!processName.contains(":tool")) {
                return;
            }
            e.b().i();
            return;
        }
        processName = "";
        c.a(TAG, 1, "load so ProcessName:" + processName);
        if (!processName.contains(":tool")) {
        }
    }

    public boolean needSign(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).booleanValue();
        }
        List<String> cmdWhiteList = getCmdWhiteList();
        if (cmdWhiteList != null && cmdWhiteList.contains(str)) {
            return true;
        }
        return false;
    }

    public synchronized void onAccountChange(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        this.mUin = str;
        if (checkStatus()) {
            Dtn.a().initUin(str);
        }
        QSec.getInstance().updateUserID(str);
    }

    public void onConnOpened() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else if (!soLoaded()) {
            c.a(TAG, 1, "connected on sdk not init");
        } else {
            com.tencent.mobileqq.fe.utils.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.fe.FEKit.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FEKit.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ChannelManager.getInstance().onMsfConnected();
                    }
                }
            });
        }
    }

    public synchronized void onReceiveSecError(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        c.a(TAG, 1, "onReceiveSecError " + str + " seq:" + j3 + " code:" + j16);
        if (!this.mInit) {
            c.a(TAG, 1, "onReceiveSecError but sdk not init ");
        } else {
            dispatchEvent("getSocialConfig", String.valueOf(j16), new a());
        }
    }

    public void requestToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (checkStatus()) {
            QQSecuritySign.getInstance().requestToken();
        }
    }

    public void setAppEventDispatcher(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) gVar);
        } else {
            this.mAppEventDispatcher = gVar;
        }
    }

    public void setCmdWhiteListChangeCallback(CmdWhiteListChangeCallback cmdWhiteListChangeCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) cmdWhiteListChangeCallback);
        } else if (soLoaded()) {
            ChannelManager.getInstance().setCmdWhiteListChangeCallback(cmdWhiteListChangeCallback);
        }
    }

    public void setContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            this.mFEContext = context;
        }
    }

    public synchronized void stopM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (this.mMainProcessInit.compareAndSet(true, false)) {
                Dtn.a().finitMainProcess();
            }
        }
    }

    public void dispatchEvent(String str, String str2, EventCallback eventCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, str2, eventCallback);
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (!checkStatus()) {
            c.a(TAG, 1, "dispatchEvent: " + str + ",so not load");
            eventCallback.onResult(907, new byte[0]);
            return;
        }
        if ("onAccountChanged".equals(str)) {
            onNotifyAccountChanged(str2, eventCallback);
            return;
        }
        if ("requestToken".equals(str)) {
            requestToken();
            eventCallback.onResult(0, new byte[0]);
            return;
        }
        if ("onKicked".equals(str)) {
            c.c(TAG, 1, "onKicked " + str2);
            if (str2.equals(this.mUin)) {
                onAccountChange("0");
            }
        }
        if ("recError".equals(str)) {
            try {
                onReceiveSecError("", 0L, Long.parseLong(str2));
                return;
            } catch (Exception e16) {
                c.a(TAG, 1, "EVENT_CMD_REC_ERROR error " + e16.toString());
                return;
            }
        }
        if ("sendRequestPB".equals(str)) {
            h.d(str, str2, eventCallback);
            return;
        }
        if ("notify".equals(str)) {
            h.a(str, str2, eventCallback);
            return;
        }
        if ("sendRequestPBJava".equals(str)) {
            h.e(str, str2, eventCallback);
            return;
        }
        QQSecuritySign.getInstance().dispatchEvent(str, str2, eventCallback);
        if ("updateModuleConfig".equals(str) || "onAppForeground".equals(str) || "onAppBackground".equals(str)) {
            eventCallback.onResult(0, new byte[0]);
        }
    }

    public QQSecuritySign.SignResult getSign(String str, byte[] bArr, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (QQSecuritySign.SignResult) iPatchRedirector.redirect((short) 15, this, str, bArr, Integer.valueOf(i3), str2);
        }
        if (this.isSafeMode) {
            checkResetSafeMode();
        }
        if (!soLoaded()) {
            return new QQSecuritySign.SignResult();
        }
        if (com.tencent.mobileqq.fe.a.INSTANCE.c(str)) {
            return new QQSecuritySign.SignResult();
        }
        if (!needSign(str)) {
            QQSecuritySign.SignResult signResult = new QQSecuritySign.SignResult();
            signResult.sign = new byte[0];
            return signResult;
        }
        byte[] bArr2 = new byte[4];
        ByteConvert.int32_to_buf(bArr2, 0, i3);
        return QQSecuritySign.getInstance().getSign(QSec.getInstance(), str, bArr, bArr2, str2);
    }
}
