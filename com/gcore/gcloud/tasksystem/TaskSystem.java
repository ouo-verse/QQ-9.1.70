package com.gcore.gcloud.tasksystem;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TaskSystem {
    public static TaskSystem Instance = new TaskSystem();
    private static Method transceiverManagerInit;
    private static Object transceiverManagerInstance;
    private static Method transceiverManagerSetTaskConfig;
    private static Method transceiverManagerStart;
    private static Method transceiverManagerStop;
    private Context mContext = null;

    private boolean checkTaskValid() {
        try {
            Class<?> cls = Class.forName("com.enq.transceiver.TransceiverManager");
            transceiverManagerInstance = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            transceiverManagerInit = cls.getMethod("init", String.class, String.class, Context.class);
            transceiverManagerStart = cls.getMethod("start", new Class[0]);
            transceiverManagerStop = cls.getMethod("stop", new Class[0]);
            transceiverManagerSetTaskConfig = cls.getMethod("setTaskConfig", String.class);
            try {
                transceiverManagerSetTaskConfig = cls.getMethod("setTaskConfig", String.class);
            } catch (Exception e16) {
                Log.w("ENQSDK", String.format("checkTaskValid error:%s", e16.toString()));
            }
            return true;
        } catch (Exception e17) {
            Log.e("ENQSDK", String.format("checkTaskValid error:%s", e17.toString()));
            return false;
        }
    }

    public void init(Context context) {
        this.mContext = context;
        checkTaskValid();
    }

    public void setTaskConfig(String str) {
        Method method;
        Object obj = transceiverManagerInstance;
        if (obj != null && (method = transceiverManagerSetTaskConfig) != null) {
            try {
                method.invoke(obj, str);
                return;
            } catch (Exception e16) {
                Log.e("ENQSDK", String.format("setTaskConfig error:%s", e16.toString()));
                return;
            }
        }
        Log.e("ENQSDK", "can not find TransceiverManager");
    }

    public void start(String str, String str2) {
        Method method;
        Object obj = transceiverManagerInstance;
        if (obj != null && (method = transceiverManagerInit) != null && transceiverManagerStart != null) {
            try {
                method.invoke(obj, str, str2, this.mContext);
                transceiverManagerStart.invoke(transceiverManagerInstance, new Object[0]);
                return;
            } catch (Exception e16) {
                Log.e("ENQSDK", String.format("start error:%s", e16.toString()));
                return;
            }
        }
        Log.e("ENQSDK", "can not find TransceiverManager");
    }

    public void stop() {
        Method method;
        Object obj = transceiverManagerInstance;
        if (obj != null && (method = transceiverManagerStop) != null) {
            try {
                method.invoke(obj, new Object[0]);
                return;
            } catch (Exception e16) {
                Log.e("ENQSDK", String.format("stop error:%s", e16.toString()));
                return;
            }
        }
        Log.e("ENQSDK", "can not find TransceiverManager");
    }
}
