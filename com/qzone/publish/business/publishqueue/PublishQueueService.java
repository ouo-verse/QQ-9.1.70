package com.qzone.publish.business.publishqueue;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.publish.business.publishqueue.h;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QZoneQunUploadPicTask;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppService;

/* loaded from: classes39.dex */
public class PublishQueueService extends AppService implements IObserver.background {

    /* renamed from: m, reason: collision with root package name */
    public static final Set<String> f51080m = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    ArrayList<Integer> f51081d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    com.qzone.publish.business.publishqueue.b f51082e = new a();

    /* renamed from: f, reason: collision with root package name */
    private Handler f51083f = new b(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread));

    /* renamed from: h, reason: collision with root package name */
    private Messenger f51084h = new Messenger(this.f51083f);

    /* renamed from: i, reason: collision with root package name */
    private Messenger f51085i = null;

    /* loaded from: classes39.dex */
    class a implements com.qzone.publish.business.publishqueue.b {
        a() {
        }

        @Override // com.qzone.publish.business.publishqueue.b
        public void H(IQueueTask iQueueTask) {
            PublishQueueService.this.z();
        }

        @Override // com.qzone.publish.business.publishqueue.b
        public void onQueueChanged() {
            PublishQueueService.this.z();
        }
    }

    /* loaded from: classes39.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 998) {
                if (i3 != 999) {
                    return;
                }
                PublishQueueService.this.f51081d.remove(Integer.valueOf(message.arg1));
                if (PublishQueueService.this.f51081d.isEmpty()) {
                    PublishQueueService.this.stopSelf();
                    return;
                }
                return;
            }
            int i16 = message.arg1;
            PublishQueueService.this.f51085i = message.replyTo;
            int w3 = PublishQueueService.this.w(String.valueOf(i16));
            PublishQueueService.this.y(Message.obtain(null, w3 < 0 ? 1003 : w3 == 100 ? 1000 : 1001, i16, w3));
            if (PublishQueueService.this.f51081d.contains(Integer.valueOf(i16))) {
                return;
            }
            PublishQueueService.this.f51081d.add(Integer.valueOf(i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int w(String str) {
        CopyOnWriteArrayList<IQueueTask> a16 = QZonePublishQueue.w().a();
        if (a16 == null) {
            return 100;
        }
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        boolean z16 = false;
        int i18 = 0;
        for (IQueueTask iQueueTask : a16) {
            if (iQueueTask instanceof QZoneQunUploadPicTask) {
                QZoneQunUploadPicTask qZoneQunUploadPicTask = (QZoneQunUploadPicTask) iQueueTask;
                if (qZoneQunUploadPicTask.clientKey.equals(str)) {
                    f51080m.remove(str);
                    com.qzone.publish.business.task.c info = qZoneQunUploadPicTask.getInfo();
                    h.a e16 = h.e(qZoneQunUploadPicTask.batchId);
                    if (e16 != null) {
                        i17 = e16.f51143b;
                        i16 = e16.f51145d;
                    }
                    if (iQueueTask.getState() == 2) {
                        i3++;
                    }
                    i18 += info.f51190f;
                    z16 = true;
                }
            }
        }
        int min = Math.min(i3, i16 - i17);
        if (!z16 && f51080m.contains(str)) {
            QZLog.i("UploadPhoto", 2, "\u5c1a\u672a\u8fdb\u5165\u53d1\u4ef6\u7bb1\u7684\u8ba4\u4e3a\uff0c\u8fdb\u5ea6\u8ba4\u4e3a\u662f0", ",clientKey:", str);
            return 0;
        }
        if (i16 == 0) {
            return 100;
        }
        int i19 = (int) (((i18 / (i16 * 100)) + (i17 / i16)) * 100.0d);
        if (QZLog.isDevelopLevel()) {
            QZLog.d("UploadPhoto", 4, "final progress: " + i18 + " sucessCount: " + i17 + " failCount:" + min + " total: " + i16 + " result: " + i19);
        }
        if (min >= i16) {
            return -1;
        }
        return i19;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(String str) {
        for (IQueueTask iQueueTask : QZonePublishQueue.w().a()) {
            if ((iQueueTask instanceof QZoneQunUploadPicTask) && ((QZoneQunUploadPicTask) iQueueTask).clientKey.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Message message) {
        Messenger messenger = this.f51085i;
        if (messenger != null) {
            try {
                messenger.send(message);
            } catch (RemoteException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.f51083f.post(new Runnable() { // from class: com.qzone.publish.business.publishqueue.PublishQueueService.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<Integer> it = PublishQueueService.this.f51081d.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    int w3 = PublishQueueService.this.w(String.valueOf(intValue));
                    PublishQueueService.this.y(Message.obtain(null, w3 < 0 ? 1003 : w3 == 100 ? 1000 : 1001, intValue, w3));
                }
            }
        });
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f51084h.getBinder();
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        super.onCreate();
        QZonePublishQueue.w().i(this.f51082e);
        EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 13);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        QZonePublishQueue.w().U(this.f51082e);
        this.f51081d.clear();
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        if ("WriteOperation".equals(event.source.getName()) && event.what == 13) {
            this.f51083f.post(new Runnable() { // from class: com.qzone.publish.business.publishqueue.PublishQueueService.4
                @Override // java.lang.Runnable
                public void run() {
                    Iterator<Integer> it = PublishQueueService.this.f51081d.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        int intValue = it.next().intValue();
                        if (!PublishQueueService.this.x(String.valueOf(intValue))) {
                            PublishQueueService.this.y(Message.obtain(null, 1005, intValue, 0));
                            PublishQueueService.this.f51081d.remove(Integer.valueOf(intValue));
                            break;
                        }
                    }
                    if (QZonePublishQueue.w().A() <= 0) {
                        PublishQueueService.this.f51081d.clear();
                        PublishQueueService.this.stopSelf();
                    }
                }
            });
        }
    }
}
