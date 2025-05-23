package com.qzone.publish.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QZoneUploadH5VideoTask;
import com.qzone.publish.business.task.compress.VideoCompressEngine;
import com.qzone.publish.business.task.compress.VideoCompressTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RemoteVideoServiceHandler {

    /* renamed from: k, reason: collision with root package name */
    private static RemoteVideoServiceHandler f51327k;

    /* renamed from: f, reason: collision with root package name */
    private String f51333f;

    /* renamed from: a, reason: collision with root package name */
    protected Object f51328a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private HashSet<String> f51329b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private int f51330c = 0;

    /* renamed from: d, reason: collision with root package name */
    protected ConcurrentLinkedQueue<Message> f51331d = new ConcurrentLinkedQueue<>();

    /* renamed from: e, reason: collision with root package name */
    protected volatile long f51332e = -1;

    /* renamed from: g, reason: collision with root package name */
    private Handler f51334g = new a(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.BackGroundThread));

    /* renamed from: h, reason: collision with root package name */
    private Messenger f51335h = null;

    /* renamed from: i, reason: collision with root package name */
    private Messenger f51336i = new Messenger(this.f51334g);

    /* renamed from: j, reason: collision with root package name */
    protected ServiceConnection f51337j = new b();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            VideoCompressTask f16;
            String str2;
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "RemoteVideoServiceHandler handleMessage, what=" + message.what);
            int i3 = message.what;
            String str3 = "";
            if (i3 != 1000) {
                if (i3 == 1002) {
                    Object obj = message.obj;
                    if (obj != null && (obj instanceof Intent)) {
                        RemoteVideoServiceHandler.this.f51333f = ((Intent) obj).getStringExtra("video_dest_file");
                        return;
                    } else {
                        QZLog.w(QZLog.PUBLISH_QUEUE_TAG, "RemoteVideoServiceHandler handleMessage 1002, message.obj is not valid");
                        return;
                    }
                }
                if (i3 != 1003) {
                    return;
                }
                String stringExtra = ((Intent) message.obj).getStringExtra("client_key");
                if (TextUtils.isEmpty(stringExtra) || (f16 = VideoCompressEngine.e().f(stringExtra)) == null) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("RemoteVideoServiceHandler start compress video, video path:");
                ShuoshuoVideoInfo shuoshuoVideoInfo = f16.videoInfo;
                if (shuoshuoVideoInfo != null && (str2 = shuoshuoVideoInfo.mVideoPath) != null) {
                    str3 = str2;
                }
                sb5.append(str3);
                QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, sb5.toString());
                VideoCompressEngine.e().g(stringExtra);
                return;
            }
            Object obj2 = message.obj;
            if (obj2 != null && (obj2 instanceof Intent)) {
                RemoteVideoServiceHandler.this.f51333f = null;
                Intent intent = (Intent) message.obj;
                String stringExtra2 = intent.getStringExtra("client_key");
                QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "clientKey=" + stringExtra2);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    if (QZoneWriteOperationService.v0().f45609m.containsKey(stringExtra2) && RemoteVideoServiceHandler.this.f51329b.contains(stringExtra2)) {
                        QZoneWriteOperationService.v0().p1(intent);
                        RemoteVideoServiceHandler.this.i(stringExtra2);
                        return;
                    }
                    IQueueTask z16 = QZonePublishQueue.w().z(stringExtra2);
                    VideoCompressTask f17 = VideoCompressEngine.e().f(stringExtra2);
                    if (z16 != null && RemoteVideoServiceHandler.this.f51329b.contains(z16.getCommentUniKey())) {
                        if (z16.getExactType() == 18) {
                            ((QZoneUploadH5VideoTask) z16).handleVideoComplete(intent);
                        }
                        RemoteVideoServiceHandler.this.i(z16.getCommentUniKey());
                        return;
                    }
                    if (f17 != null) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("RemoteVideoServiceHandler compress video finish, video path:");
                        ShuoshuoVideoInfo shuoshuoVideoInfo2 = f17.videoInfo;
                        if (shuoshuoVideoInfo2 != null && (str = shuoshuoVideoInfo2.mVideoPath) != null) {
                            str3 = str;
                        }
                        sb6.append(str3);
                        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, sb6.toString());
                        VideoCompressEngine.e().h(stringExtra2, intent);
                        return;
                    }
                    QZLog.w(QZLog.PUBLISH_QUEUE_TAG, "RemoteVideoServiceHandler handleMessage, clientkey not in sessions, clientkey=" + stringExtra2);
                    return;
                }
                QZLog.w(QZLog.PUBLISH_QUEUE_TAG, "RemoteVideoServiceHandler handleMessage, clientkey not in sessions, clientkey=" + stringExtra2);
                return;
            }
            QZLog.w(QZLog.PUBLISH_QUEUE_TAG, "RemoteVideoServiceHandler handleMessage 1000, message.obj is not valid");
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "RemoteVideoServiceHandler onServiceDisconnected");
            RemoteVideoServiceHandler.this.f51335h = null;
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadVideoServerLost", "\u89c6\u9891\u5408\u6210\u670d\u52a1\u8fde\u63a5\u4e22\u5931");
            Collection collection = (Collection) RemoteVideoServiceHandler.this.f51329b.clone();
            RemoteVideoServiceHandler.this.f51329b.clear();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                RemoteVideoServiceHandler.this.m((String) it.next(), config, 1);
            }
            collection.clear();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "RemoteVideoServiceHandler onServiceConnected");
            RemoteVideoServiceHandler.this.f51335h = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.what = 1000;
            obtain.replyTo = RemoteVideoServiceHandler.this.f51336i;
            RemoteVideoServiceHandler.this.n(obtain);
            RemoteVideoServiceHandler.this.l();
        }
    }

    RemoteVideoServiceHandler() {
    }

    public static RemoteVideoServiceHandler j() {
        if (f51327k == null) {
            synchronized (RemoteVideoServiceHandler.class) {
                if (f51327k == null) {
                    f51327k = new RemoteVideoServiceHandler();
                }
            }
        }
        return f51327k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, String str2, int i3) {
        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "RemoteVideoServiceHandler sendFailedRespToTask clientkey:" + str + ",msg:" + str2);
        Intent intent = new Intent();
        intent.putExtra(VideoCompressTask.KEY_HANDLE_RESULT, false);
        intent.putExtra(VideoCompressTask.KEY_ERR_MSG, str2);
        intent.putExtra("video_error_code", i3);
        intent.putExtra(VideoCompressTask.KEY_ERR_FILE_NAME, this.f51333f);
        if (QZoneWriteOperationService.v0().f45609m.containsKey(str) && this.f51329b.contains(str)) {
            QZoneWriteOperationService.v0().p1(intent);
            return;
        }
        IQueueTask z16 = QZonePublishQueue.w().z(str);
        VideoCompressTask f16 = VideoCompressEngine.e().f(str);
        if (z16 != null) {
            if (z16.getExactType() == 18) {
                ((QZoneUploadH5VideoTask) z16).handleVideoComplete(intent);
            }
        } else if (f16 != null) {
            VideoCompressEngine.e().h(str, intent);
        }
    }

    protected void f(Message message) {
        this.f51331d.add(message);
    }

    public void g(String str) {
        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "RemoteVideoServiceHandler attach clientKey=" + str);
        synchronized (this) {
            if (this.f51329b.add(str)) {
                this.f51330c++;
            }
        }
    }

    void h() {
        try {
            QZoneHelper.bindQzoneVideoService(BaseApplication.getContext(), LoginData.getInstance().getUinString(), this.f51337j);
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "RemoteVideoServiceHandler bind service finish");
        } catch (Exception e16) {
            QZLog.e(QZLog.PUBLISH_QUEUE_TAG, "RemoteVideoServiceHandler bind service error", e16);
        }
    }

    public void i(String str) {
        boolean z16;
        boolean z17 = true;
        QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "RemoteVideoServiceHandler detach clientKey=" + str);
        synchronized (this) {
            z16 = false;
            if (this.f51329b.remove(str)) {
                int i3 = this.f51330c - 1;
                this.f51330c = i3;
                if (i3 != 0) {
                    z17 = false;
                }
                z16 = z17;
            }
        }
        if (z16) {
            q();
        }
    }

    public boolean k() {
        return this.f51335h != null;
    }

    protected void l() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.publish.service.RemoteVideoServiceHandler.3
            @Override // java.lang.Runnable
            public void run() {
                while (!RemoteVideoServiceHandler.this.f51331d.isEmpty()) {
                    Message poll = RemoteVideoServiceHandler.this.f51331d.poll();
                    if (poll != null) {
                        try {
                            RemoteVideoServiceHandler.this.o(poll);
                        } catch (Exception e16) {
                            QZLog.w(e16);
                            Intent intent = (Intent) poll.obj;
                            if (intent == null) {
                                return;
                            }
                            String stringExtra = intent.getStringExtra("client_key");
                            RemoteVideoServiceHandler.this.m(stringExtra, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadVideoComposeFail", "\u89c6\u9891\u5408\u6210\u5931\u8d25"), 2);
                            RemoteVideoServiceHandler.this.i(stringExtra);
                        }
                    }
                }
            }
        });
    }

    public void n(Message message) {
        try {
            synchronized (this.f51328a) {
                if (k()) {
                    o(message);
                } else {
                    f(message);
                    p();
                }
            }
        } catch (DeadObjectException unused) {
            f(message);
        } catch (Exception e16) {
            if (this.f51335h == null) {
                f(message);
            } else {
                e16.printStackTrace();
            }
        }
    }

    protected void o(Message message) throws RemoteException {
        this.f51335h.send(message);
    }

    public void p() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f51332e != -1 && currentTimeMillis - this.f51332e <= 1000) {
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "RemoteVideoServiceHandler wait start service result, skiped...");
        } else {
            this.f51332e = currentTimeMillis;
            h();
        }
    }

    public void q() {
        try {
            BaseApplication.getContext().unbindService(this.f51337j);
            this.f51335h = null;
            QZLog.i(QZLog.PUBLISH_QUEUE_TAG, 1, "RemoteVideoServiceHandler unbindService service finished");
        } catch (Exception e16) {
            QZLog.e(QZLog.PUBLISH_QUEUE_TAG, "RemoteVideoServiceHandler unbindService service error", e16);
        }
    }
}
