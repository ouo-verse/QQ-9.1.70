package com.tencent.mobileqq.activity.aio;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.IScribblePicDownloadProcessor;
import com.tencent.mobileqq.transfile.IScribblePicUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class y implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<QQAppInterface> f180286d;

    /* renamed from: e, reason: collision with root package name */
    private final TransProcessorHandler f180287e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<b> f180288f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends TransProcessorHandler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            y.this.c(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<View> f180290a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<r> f180291b;

        public b(View view, r rVar) {
            this.f180290a = new WeakReference<>(view);
            this.f180291b = new WeakReference<>(rVar);
        }

        public r a() {
            return this.f180291b.get();
        }

        public View b() {
            return this.f180290a.get();
        }
    }

    public y(QQAppInterface qQAppInterface) {
        a aVar = new a(Looper.getMainLooper());
        this.f180287e = aVar;
        this.f180288f = new ArrayList<>();
        aVar.addFilter(BuddyTransfileProcessor.class, ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getC2CPttDownloadProcessorClass(), ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getC2CPttUpProcessorClass(), ((IPicTransFile) qQAppInterface.getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPicTransFile) qQAppInterface.getRuntimeService(IPicTransFile.class)).getGroupUploadProClass(), ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getGroupPttDownloadProcessorClass(), ((IPicTransFile) qQAppInterface.getRuntimeService(IPicTransFile.class)).getGuildDownloadProClass(), ((IPicTransFile) qQAppInterface.getRuntimeService(IPicTransFile.class)).getGuildUploadProClass(), ((IPicTransFile) qQAppInterface.getRuntimeService(IPicTransFile.class)).getC2CPicDownloadProClass(), ((IPicTransFile) qQAppInterface.getRuntimeService(IPicTransFile.class)).getGroupDownloadProClass(), ((IPicTransFile) qQAppInterface.getRuntimeService(IPicTransFile.class)).getZPlanUploadProClass(), ForwardImageProcessor.class, ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getShortVideoUploadProcessorClass(), ShortVideoDownloadProcessor.class, ((IShortVideoFactory) QRoute.api(IShortVideoFactory.class)).getShortVideoForwardProcessorClass(), ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getPAAudioDownloadProcessorClass(), ((IScribblePicDownloadProcessor) QRoute.api(IScribblePicDownloadProcessor.class)).getProcessorClazz(), ((IScribblePicUploadProcessor) QRoute.api(IScribblePicUploadProcessor.class)).getProcessorClazz(), ForwardSdkShareProcessor.class, ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getGroupPttUpProcessorClass(), ((IPttTransProcessorHelper) QRoute.api(IPttTransProcessorHelper.class)).getSlicePttUpProcessorClass());
        b(qQAppInterface);
    }

    private void b(QQAppInterface qQAppInterface) {
        WeakReference<QQAppInterface> weakReference = this.f180286d;
        if (weakReference != null && weakReference.get() == qQAppInterface) {
            return;
        }
        WeakReference<QQAppInterface> weakReference2 = this.f180286d;
        if (weakReference2 != null && weakReference2.get() != null) {
            e();
        }
        this.f180286d = new WeakReference<>(qQAppInterface);
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.f180287e);
    }

    public static y d(QQAppInterface qQAppInterface) {
        return (y) qQAppInterface.getManager(QQManagerFactory.MGR_FILE_TRANS);
    }

    public synchronized void a(View view, r rVar) {
        Iterator<b> it = this.f180288f.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.b() == view) {
                next.f180291b = new WeakReference<>(rVar);
                return;
            }
        }
        this.f180288f.add(new b(view, rVar));
    }

    synchronized void c(Message message) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferManager", 2, "handleMessage" + ((FileMsg) message.obj).uniseq + " status " + message.what + "retCode " + message.arg1);
        }
        int i3 = 0;
        while (i3 < this.f180288f.size()) {
            b bVar = this.f180288f.get(i3);
            if (bVar != null) {
                View b16 = bVar.b();
                r a16 = bVar.a();
                if (b16 != null && a16 != null) {
                    a16.handleMessage(b16, (FileMsg) message.obj, message.what, message.arg1);
                } else {
                    this.f180288f.remove(i3);
                    i3--;
                }
            }
            i3++;
        }
        OpenApiManager.getInstance().onFileTransStatusChanged((FileMsg) message.obj, message.what, message.arg1);
    }

    public void e() {
        this.f180288f.clear();
        WeakReference<QQAppInterface> weakReference = this.f180286d;
        if (weakReference != null && weakReference.get() != null) {
            ((ITransFileController) this.f180286d.get().getRuntimeService(ITransFileController.class)).removeHandle(this.f180287e);
            ((IProtoReqManager) this.f180286d.get().getRuntimeService(IProtoReqManager.class, "")).onDestroy();
            this.f180286d = null;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        e();
    }
}
