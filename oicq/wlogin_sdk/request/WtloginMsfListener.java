package oicq.wlogin_sdk.request;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Semaphore;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WtloginMsfListener implements Runnable {
    public static String CLIENT_CLASSNAME = "com.tencent.mobileqq.msf.core.auth.WtProvider";
    private static long __seq;
    public static WeakReference<Object> ticketManager;
    private byte[] data;
    private boolean flag;
    private int ret;
    private String ret_serviceCmd;
    private String ret_uin;
    private String serviceCmd;
    private int timeout;
    private String uin;
    private WUserSigInfo userSigInfo;
    private static final Object __SyncSeq = new Object();
    private static final Object __SyncCB = new Object();
    private static Map<Long, WtloginMsfListener> __cbs = new HashMap();
    private final Semaphore semp = new Semaphore(1);
    private byte[] ret_data = null;
    private boolean ret_success = false;

    public WtloginMsfListener(String str, String str2, byte[] bArr, int i3, boolean z16, WUserSigInfo wUserSigInfo) {
        this.uin = str == null ? "0" : str;
        this.serviceCmd = str2 == null ? "" : str2;
        this.data = bArr == null ? new byte[0] : bArr;
        this.timeout = i3 <= 0 ? 5000 : i3;
        this.flag = z16;
        this.userSigInfo = wUserSigInfo;
    }

    private static long allocateSeq() {
        long j3;
        synchronized (__SyncSeq) {
            long j16 = __seq + 1;
            __seq = j16;
            j3 = j16 % TTL.MAX_VALUE;
        }
        return j3;
    }

    public static void onAsyncReceive(String str, String str2, long j3, byte[] bArr) {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("rpc receive ");
        sb5.append(str2);
        sb5.append(" seq: ");
        sb5.append(j3);
        sb5.append(" data:");
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        sb5.append(valueOf);
        util.LOGI(sb5.toString(), str);
        WtloginMsfListener pickSeq = pickSeq(j3);
        if (pickSeq != null) {
            pickSeq.onReceiveData(str, str2, bArr);
        }
    }

    public static void onAsyncReceiveFail(String str, String str2, long j3, int i3) {
        util.LOGI("rpc receive " + str2 + " seq: " + j3 + " fail:" + i3, str);
        WtloginMsfListener pickSeq = pickSeq(j3);
        if (pickSeq != null) {
            pickSeq.onReceiveFail(str, str2, i3);
        }
    }

    private static WtloginMsfListener pickSeq(long j3) {
        WtloginMsfListener wtloginMsfListener;
        synchronized (__SyncCB) {
            wtloginMsfListener = __cbs.get(Long.valueOf(j3));
            __cbs.remove(Long.valueOf(j3));
        }
        return wtloginMsfListener;
    }

    private Object sendDataByReflectMqq(byte[] bArr, int i3, long j3) {
        Object invoke;
        WeakReference<Object> weakReference = ticketManager;
        if (weakReference == null || weakReference.get() == null) {
            String str = BaseApplicationImpl.sQQAppInterfaceEscapedMsg;
            Locale locale = BaseActivity.locale;
            int i16 = AppRuntime.ACCOUNT_MANAGER;
            Method method = BaseApplicationImpl.class.getMethod("getApplication", new Class[0]);
            Method method2 = BaseApplicationImpl.class.getMethod("waitAppRuntime", BaseActivity.class);
            Method method3 = AppRuntime.class.getMethod("getManager", Integer.TYPE);
            Field field = AppRuntime.class.getField("TICKET_MANAGER");
            Object invoke2 = method.invoke(null, new Object[0]);
            if (invoke2 != null && (invoke = method2.invoke(invoke2, null)) != null) {
                ticketManager = new WeakReference<>(method3.invoke(invoke, field.get(AppRuntime.class)));
            }
        }
        return TicketManager.class.getMethod("sendRPCData", Long.TYPE, String.class, String.class, byte[].class, Integer.TYPE).invoke(ticketManager.get(), Long.valueOf(j3), this.uin, this.serviceCmd, bArr.clone(), Integer.valueOf(i3));
    }

    private int sendRPCData(byte[] bArr, int i3) {
        int sendData;
        long allocateSeq = allocateSeq();
        util.LOGI("sendRPCData seq: " + allocateSeq, "");
        try {
            if (WtloginHelper.getWtDataSender() == null) {
                sendData = Integer.parseInt(sendDataByReflectMqq(bArr, i3, allocateSeq).toString());
            } else {
                sendData = WtloginHelper.getWtDataSender().sendData(allocateSeq, this.uin, this.serviceCmd, (byte[]) bArr.clone(), i3);
            }
            if (sendData == 0) {
                synchronized (__SyncCB) {
                    __cbs.put(Long.valueOf(allocateSeq), this);
                }
                this.semp.acquire();
                return 99;
            }
            return sendData;
        } catch (Exception e16) {
            util.printException(e16, this.uin);
            return -1000;
        }
    }

    public void Cancel() {
        try {
            Class<?> cls = Class.forName(CLIENT_CLASSNAME);
            cls.getMethod("cancel", WUserSigInfo.class).invoke(cls, this.userSigInfo);
        } catch (Exception e16) {
            util.printException(e16, this.uin);
        }
    }

    public byte[] RecvData() {
        try {
            this.semp.acquire();
            if (!this.ret_success) {
                return null;
            }
            String str = this.ret_uin;
            String str2 = "null";
            if (str != null && str.equals(this.uin)) {
                String str3 = this.ret_serviceCmd;
                if (str3 != null && str3.equals(this.serviceCmd)) {
                    this.semp.release();
                    return this.ret_data;
                }
                this.ret = -1009;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("ret_serviceCmd: ");
                String str4 = this.ret_serviceCmd;
                if (str4 == null) {
                    str4 = "null";
                }
                sb5.append(str4);
                sb5.append(", serviceCmd:");
                String str5 = this.serviceCmd;
                if (str5 != null) {
                    str2 = str5;
                }
                sb5.append(str2);
                util.LOGI(sb5.toString(), "");
                return null;
            }
            this.ret = -1009;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("ret_uin: ");
            String str6 = this.ret_uin;
            if (str6 == null) {
                str6 = "null";
            }
            sb6.append(str6);
            sb6.append(", uin: ");
            String str7 = this.uin;
            if (str7 != null) {
                str2 = str7;
            }
            sb6.append(str2);
            util.LOGI(sb6.toString(), "");
            return null;
        } catch (InterruptedException e16) {
            util.printException(e16, this.uin);
            return null;
        }
    }

    public int SendData(byte[] bArr, int i3) {
        if (!u.f422940q0) {
            String f16 = u.f();
            util.LOGI("mqq process: " + f16, "");
            if (!f16.endsWith(":MSF")) {
                return sendRPCData(bArr, i3);
            }
        }
        try {
            util.LOGI("msf sendData", "");
            Class<?> cls = Class.forName(CLIENT_CLASSNAME);
            int intValue = Integer.valueOf(cls.getMethod("sendData", WUserSigInfo.class, String.class, String.class, byte[].class, Integer.TYPE, Boolean.TYPE, WtloginMsfListener.class).invoke(cls, this.userSigInfo, this.uin, this.serviceCmd, bArr.clone(), Integer.valueOf(i3), Boolean.valueOf(this.flag), this).toString()).intValue();
            if (intValue > 0) {
                this.semp.acquire();
                return intValue;
            }
            return intValue;
        } catch (Exception e16) {
            util.printException(e16, this.uin);
            return -1000;
        }
    }

    public int getRet() {
        return this.ret;
    }

    public byte[] getRetData() {
        return this.ret_data;
    }

    public void onReceiveData(String str, String str2, byte[] bArr) {
        this.ret_success = true;
        this.ret_uin = str;
        this.ret_serviceCmd = str2;
        this.ret = 0;
        this.ret_data = bArr;
        this.semp.release();
    }

    public void onReceiveFail(String str, String str2, int i3) {
        this.ret_success = false;
        this.ret_uin = str;
        this.ret_serviceCmd = str2;
        this.ret = i3;
        this.semp.release();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            int SendData = SendData(this.data, this.timeout);
            this.ret = SendData;
            if (SendData <= 0) {
                util.LOGI("msf request send data failed, ret=" + this.ret, "");
                return;
            }
            if (RecvData() == null) {
                this.ret_data = null;
            }
        } catch (Exception unused) {
        }
    }
}
