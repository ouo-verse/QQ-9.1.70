package mqq.util;

import android.os.Environment;
import android.os.SystemClock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MqqConnRateReport {
    public static final int ERR_MSF_RECV_APPPROCESSMANAGER_APPPROCESSINFO_ISNULL = 8;
    public static final int ERR_MSF_RECV_APPPROCESSMANAGER_HALF_CLOSE = 10;
    public static final int ERR_MSF_RECV_APPPROCESSMANAGER_NEEDBOOT_TIMEOUT = 14;
    public static final int ERR_MSF_RECV_APPPROCESSMANAGER_PROCESSNAME_ISEMPTY = 7;
    public static final int ERR_MSF_RECV_APPPROCESSMANAGER_PROCESS_ISDIED = 9;
    public static final int ERR_MSF_RECV_APPPROCESSMANAGER_RECVRESPONSE_DEAD_OBJECT = 11;
    public static final int ERR_MSF_RECV_APPPROCESSMANAGER_RECVRESPONSE_EXCEPTION = 12;
    public static final int ERR_MSF_RECV_APPPROCESSMANAGER_SENDTIME = 13;
    public static final int ERR_MSF_RECV_FROMSERVICEMSG_NOTSUCCESS = 3;
    public static final int ERR_MSF_RECV_HANDLECMDPUSH_APPPUSH_ISNULL = 6;
    public static final int ERR_MSF_RECV_HANDLECMDPUSH_CMDNOT_FIND = 5;
    public static final int ERR_MSF_RECV_HANDLECMDPUSH_UIN_NOTEQUAL = 4;
    public static final int ERR_MSF_RECV_MSFRESPUTIL_PUSHHANDLER_ISNULL = 18;
    public static final int ERR_MSF_RECV_MSFSERVICEPROXY_ISPUSHCONFIG = 17;
    public static final int ERR_MSF_RECV_MSFSERVICEPROXY_NOTCONNECT_MSF = 16;
    public static final int ERR_MSF_RECV_MSFSERVICEPROXY_TOKENEXPIRED = 15;
    public static final int ERR_MSF_RECV_REASON1 = 1;
    public static final int ERR_MSF_RECV_SERVLETCONTAINER_SERVLET_ISNULL_OR_EQUALSEND = 20;
    public static final int ERR_MSF_RECV_SERVLETCONTAINER_SET_ISNULL = 19;
    public static final int ERR_MSF_RECV_TOSERVICEMSG_NOTNULL = 2;
    public static final int ERR_MSF_SEND_VIDEOACK_REASON1 = 100;
    public static final int ERR_NONE = 0;
    public static final String TAG = "MqqConnRateReport";
    static MqqConnRateReport g_Instance = null;
    static String msfReportLogPath = "";

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum EventType {
        eNone,
        eMSFRecvInviteMsg,
        eMSFTransferInviteMsg,
        eVideoServletCreate,
        eVideoAddMsg,
        eVideoMSFReceiverProcess,
        eVideoRecvInviteMsg,
        eVideoSendACK,
        eMSFSendVideoACK
    }

    public static MqqConnRateReport getInstance() {
        if (g_Instance == null) {
            g_Instance = new MqqConnRateReport();
            msfReportLogPath = MqqInjectorManager.instance().getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/audio/");
        }
        return g_Instance;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x008c, code lost:
    
        if (r1 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0089, code lost:
    
        if (r1 == null) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doReport(EventType eventType, byte[] bArr, int i3) {
        if (bArr == null) {
            return;
        }
        String str = eventType + "_" + SystemClock.elapsedRealtime() + "_" + i3 + ".msf";
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return;
        }
        File file = new File(msfReportLogPath);
        if (!file.exists() && !file.mkdirs()) {
            return;
        }
        File file2 = new File(msfReportLogPath + str);
        boolean z16 = false;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                    z16 = true;
                } catch (IOException unused) {
                }
                if (z16) {
                    return;
                }
            } catch (FileNotFoundException unused2) {
                fileOutputStream = fileOutputStream2;
            } catch (IOException unused3) {
                fileOutputStream = fileOutputStream2;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                        if (z16) {
                            file2.delete();
                            throw th;
                        }
                        throw th;
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
        } catch (FileNotFoundException unused5) {
        } catch (IOException unused6) {
        } catch (Throwable th6) {
            th = th6;
        }
        file2.delete();
    }
}
