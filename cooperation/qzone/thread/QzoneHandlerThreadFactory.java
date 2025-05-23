package cooperation.qzone.thread;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneHandlerThreadFactory {
    public static final String BackGroundThread = "BackGround_HandlerThread";
    public static final String BusinessThread = "Business_HandlerThread";
    public static final String FeedDeleteOnTimeThread = "FeedDeleteOnTime_HandlerThread";
    public static final String FloatItemThread = "FloatItem_HandlerThread";
    public static final String IpcProxyThread = "QZone_IpcProxyThread";
    public static final String LocalPhotoThread = "QZone_LocalPhotoThread";
    public static final String NormalThread = "Normal_HandlerThread";
    public static final String ParticleThread = "Particle_HandlerThread";
    public static final String PreLoadThread = "Preload_HandlerThread";
    public static final String RealTimeThread = "RealTime_HandlerThread";
    public static final String ReportThread = "Report_HandlerThread";
    public static final String TAG = "QzoneThread";
    public static final String VideoThread = "Video_HandlerThread";
    public static final String YellowVipThread = "YellowVip_HandlerThread";
    public static volatile Handler mMainHandler;
    public static final Object mMainHandlerLock = new Object();
    static final Map<String, QzoneBaseThread> mHandlerThreadMap = new HashMap();

    public static QzoneBaseThread getHandlerThread(String str, boolean z16) {
        QzoneBaseThread qzoneBaseThread;
        Map<String, QzoneBaseThread> map = mHandlerThreadMap;
        synchronized (map) {
            qzoneBaseThread = map.get(str);
            if (qzoneBaseThread == null) {
                qzoneBaseThread = new QzoneBaseThread(str, getPriority(str));
                if (z16) {
                    qzoneBaseThread.setDaemon(z16);
                }
                map.put(str, qzoneBaseThread);
            } else {
                try {
                    if (!qzoneBaseThread.isAlive()) {
                        qzoneBaseThread.start();
                    }
                } catch (IllegalThreadStateException e16) {
                    QLog.e(TAG, 1, e16.getStackTrace().toString());
                }
            }
        }
        return qzoneBaseThread;
    }

    public static Looper getHandlerThreadLooper(String str) {
        return getHandlerThread(str).getLooper();
    }

    public static Handler getMainHandler() {
        Handler handler;
        synchronized (mMainHandlerLock) {
            if (mMainHandler == null) {
                mMainHandler = new Handler(Looper.getMainLooper());
            }
            handler = mMainHandler;
        }
        return handler;
    }

    private static int getPriority(String str) {
        if (BackGroundThread.equalsIgnoreCase(str)) {
            return 10;
        }
        if (RealTimeThread.equalsIgnoreCase(str)) {
            return -1;
        }
        if (VideoThread.equalsIgnoreCase(str)) {
            return 0;
        }
        if (ReportThread.equalsIgnoreCase(str)) {
            return 10;
        }
        if (PreLoadThread.equalsIgnoreCase(str)) {
            return 1;
        }
        if (!LocalPhotoThread.equalsIgnoreCase(str) && IpcProxyThread.equalsIgnoreCase(str)) {
            return 10;
        }
        return 0;
    }

    public static QzoneBaseThread getHandlerThread(String str) {
        return getHandlerThread(str, false);
    }
}
