package com.gcloudsdk.apollo;

import android.content.Context;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NetInterfaceHelper {
    private static String LOGTAG = "NetInterfaceHelper";
    private static MsgWorker mMsgWorker;

    public static void init(Context context) {
        if (mMsgWorker != null) {
            return;
        }
        mMsgWorker = new MsgWorker(context);
        new BaseThread(mMsgWorker).start();
    }

    public static void pushMsg(int i3, int i16, int i17, String str) {
        mMsgWorker.sendMessage(new EventMsg(i3, i16, i17, str));
    }
}
