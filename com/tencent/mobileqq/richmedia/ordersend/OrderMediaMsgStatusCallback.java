package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.r;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class OrderMediaMsgStatusCallback implements r {

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<Long, a> f281597d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentLinkedQueue<Long> f281598e = new ConcurrentLinkedQueue<>();

    /* renamed from: f, reason: collision with root package name */
    private b f281599f;

    /* renamed from: h, reason: collision with root package name */
    private String f281600h;

    /* renamed from: i, reason: collision with root package name */
    private Long f281601i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<View> f281605a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<r> f281606b;

        /* renamed from: c, reason: collision with root package name */
        WeakReference<FileMsg> f281607c;

        public a(View view, r rVar) {
            this.f281605a = new WeakReference<>(view);
            this.f281606b = new WeakReference<>(rVar);
        }

        public r a() {
            return this.f281606b.get();
        }

        public FileMsg b() {
            WeakReference<FileMsg> weakReference = this.f281607c;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public View c() {
            return this.f281605a.get();
        }

        public void d(FileMsg fileMsg) {
            this.f281607c = new WeakReference<>(fileMsg);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(long j3, int i3);

        void b(long j3);
    }

    public OrderMediaMsgStatusCallback(String str) {
        this.f281600h = str;
    }

    private FileMsg e() {
        a aVar;
        if (!this.f281598e.isEmpty()) {
            Long peek = this.f281598e.peek();
            this.f281601i = peek;
            if (peek != null && this.f281597d.containsKey(peek) && (aVar = this.f281597d.get(this.f281601i)) != null) {
                return aVar.b();
            }
        }
        return null;
    }

    private boolean g(long j3, int i3) {
        boolean z16;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && ((IOrderMediaMsgService) waitAppRuntime.getRuntimeService(IOrderMediaMsgService.class, "")).getMsgController().j(i3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.f281598e.remove(Long.valueOf(j3));
            b bVar = this.f281599f;
            if (bVar != null) {
                bVar.a(j3, i3);
            }
            if (QLog.isColorLevel()) {
                QLog.d("OrderMediaMsgStatusCallback", 2, "handleErrorMessage status:" + i3 + " ,uniseq:" + j3);
            }
        }
        return z16;
    }

    private void h(FileMsg fileMsg, boolean z16) {
        a aVar;
        if (fileMsg == null) {
            return;
        }
        Long peek = this.f281598e.peek();
        this.f281601i = peek;
        if (peek != null && fileMsg.uniseq == peek.longValue()) {
            j(fileMsg);
            if (fileMsg.status == 1003) {
                this.f281598e.remove(this.f281601i);
                this.f281597d.remove(this.f281601i);
                if (QLog.isColorLevel()) {
                    QLog.d("OrderMediaMsgStatusCallback", 2, "remove callback:" + this.f281601i);
                }
                h(e(), false);
                return;
            }
            return;
        }
        if (z16 && this.f281597d.containsKey(Long.valueOf(fileMsg.uniseq)) && (aVar = this.f281597d.get(Long.valueOf(fileMsg.uniseq))) != null) {
            aVar.d(fileMsg);
            if (QLog.isColorLevel()) {
                QLog.d("OrderMediaMsgStatusCallback", 2, "needCache fileStatus:" + fileMsg.status + " ,uniseq:" + fileMsg.uniseq);
            }
        }
    }

    private void i(long j3) {
        ConcurrentHashMap<Long, a> concurrentHashMap = this.f281597d;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Long.valueOf(j3))) {
            a aVar = this.f281597d.get(Long.valueOf(j3));
            if (aVar != null) {
                final View c16 = aVar.c();
                final r a16 = aVar.a();
                final FileMsg b16 = aVar.b();
                if (c16 != null && a16 != null && b16 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OrderMediaMsgStatusCallback", 2, "realHandleMessage2 status:" + b16.status + " ,uniseq:" + b16.uniseq);
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1
                        @Override // java.lang.Runnable
                        public void run() {
                            r rVar = a16;
                            View view = c16;
                            FileMsg fileMsg = b16;
                            rVar.handleMessage(view, fileMsg, fileMsg.status, fileMsg.errorCode);
                        }
                    });
                    return;
                }
                return;
            }
            this.f281597d.remove(Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OrderMediaMsgStatusCallback", 2, "CallbackWrapperMap not contain:" + j3);
        }
    }

    private void j(FileMsg fileMsg) {
        ConcurrentHashMap<Long, a> concurrentHashMap = this.f281597d;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Long.valueOf(fileMsg.uniseq))) {
            a aVar = this.f281597d.get(Long.valueOf(fileMsg.uniseq));
            if (aVar != null) {
                View c16 = aVar.c();
                r a16 = aVar.a();
                if (c16 != null && a16 != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("OrderMediaMsgStatusCallback", 2, "realHandleMessage1 status:" + fileMsg.status + " ,uniseq" + fileMsg.uniseq);
                    }
                    a16.handleMessage(c16, fileMsg, fileMsg.status, fileMsg.errorCode);
                    return;
                }
                this.f281597d.remove(Long.valueOf(fileMsg.uniseq));
                return;
            }
            this.f281597d.remove(Long.valueOf(fileMsg.uniseq));
        }
    }

    public boolean a(AppRuntime appRuntime, long j3, View view, r rVar) {
        ConcurrentLinkedQueue<Long> concurrentLinkedQueue;
        String view2;
        if (appRuntime != null && (concurrentLinkedQueue = this.f281598e) != null && concurrentLinkedQueue.contains(Long.valueOf(j3))) {
            if (this.f281597d == null) {
                this.f281597d = new ConcurrentHashMap<>();
            }
            String str = "";
            ((IOrderMediaMsgService) appRuntime.getRuntimeService(IOrderMediaMsgService.class, "")).getMsgController().b(view, this);
            int i3 = -1;
            if (!this.f281597d.containsKey(Long.valueOf(j3))) {
                this.f281597d.put(Long.valueOf(j3), new a(view, rVar));
                if (QLog.isColorLevel()) {
                    QLog.d("OrderMediaMsgStatusCallback", 2, "callback add success:" + j3);
                }
                IHttpCommunicatorListener findProcessor = ((ITransFileController) appRuntime.getRuntimeService(ITransFileController.class, "")).findProcessor(this.f281600h, j3);
                if (findProcessor == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("OrderMediaMsgStatusCallback", 2, "addCallback processor is null " + j3);
                    }
                    b bVar = this.f281599f;
                    if (bVar != null) {
                        bVar.b(j3);
                    }
                } else if (findProcessor instanceof BaseTransProcessor) {
                    BaseTransProcessor baseTransProcessor = (BaseTransProcessor) findProcessor;
                    int fileStatus = (int) baseTransProcessor.getFileStatus();
                    if (!g(j3, fileStatus)) {
                        Long peek = this.f281598e.peek();
                        this.f281601i = peek;
                        if (j3 != 0 && peek != null && j3 != peek.longValue()) {
                            if (rVar != null) {
                                rVar.handleMessage(view, baseTransProcessor.getFileMsg(), fileStatus, baseTransProcessor.mProcessorReport.errCode);
                                a aVar = this.f281597d.get(Long.valueOf(j3));
                                if (aVar != null) {
                                    aVar.d(baseTransProcessor.getFileMsg());
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("OrderMediaMsgStatusCallback", 2, "Not the first! status:" + fileStatus + " ,uniseq:" + j3);
                            }
                        }
                    }
                    i3 = fileStatus;
                }
            } else {
                a aVar2 = this.f281597d.get(Long.valueOf(j3));
                aVar2.f281605a = new WeakReference<>(view);
                aVar2.f281606b = new WeakReference<>(rVar);
            }
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("addCallback uniseq:");
                sb5.append(j3);
                sb5.append(" ,status:");
                sb5.append(i3);
                sb5.append(" ,view:");
                if (view == null) {
                    view2 = "";
                } else {
                    view2 = view.toString();
                }
                sb5.append(view2);
                sb5.append(" ,callback:");
                if (rVar != null) {
                    str = rVar.toString();
                }
                sb5.append(str);
                QLog.d("OrderMediaMsgStatusCallback", 2, sb5.toString());
                return true;
            }
            return true;
        }
        return false;
    }

    public void b(b bVar) {
        this.f281599f = bVar;
    }

    public void c(long j3) {
        if (!this.f281598e.contains(Long.valueOf(j3))) {
            this.f281598e.offer(Long.valueOf(j3));
        }
    }

    public void d() {
        ConcurrentHashMap<Long, a> concurrentHashMap = this.f281597d;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.f281597d = null;
        }
        this.f281598e.clear();
        this.f281599f = null;
    }

    public int f(long j3) {
        if (this.f281598e.contains(Long.valueOf(j3))) {
            if (this.f281598e.peek().longValue() == j3) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.aio.r
    public void handleMessage(View view, FileMsg fileMsg, int i3, int i16) {
        boolean z16;
        if (!this.f281598e.contains(Long.valueOf(fileMsg.uniseq))) {
            j(fileMsg);
            if (QLog.isColorLevel()) {
                QLog.d("OrderMediaMsgStatusCallback", 2, "not exist in uniseqlist:" + fileMsg.uniseq);
                return;
            }
            return;
        }
        if (g(fileMsg.uniseq, i3)) {
            j(fileMsg);
            fileMsg = e();
            z16 = false;
        } else {
            z16 = true;
        }
        h(fileMsg, z16);
    }

    public void k(long j3) {
        if (this.f281598e.contains(Long.valueOf(j3))) {
            this.f281598e.remove(Long.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.d("OrderMediaMsgStatusCallback", 2, "removeUniseqFromOrderList " + j3);
            }
            i(j3);
        }
    }
}
