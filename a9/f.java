package a9;

import android.os.Handler;
import com.qzone.common.account.LoginData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"La9/f;", "", "", "d", "La9/c;", "c", "", "g", "e", "Lcom/qzone/publish/business/publishqueue/common/f;", "b", "Lcom/qzone/publish/business/publishqueue/common/f;", "taskManager", "Lcom/qzone/publish/business/publishqueue/common/e;", "Lcom/qzone/publish/business/publishqueue/common/e;", "restoreFilterHelper", "La9/c;", "publishQueue", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class f {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static c publishQueue;

    /* renamed from: a, reason: collision with root package name */
    public static final f f25725a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final com.qzone.publish.business.publishqueue.common.f taskManager = new com.qzone.publish.business.publishqueue.common.f(3);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final com.qzone.publish.business.publishqueue.common.e restoreFilterHelper = new com.qzone.publish.business.publishqueue.common.e();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Handler handler = new Handler(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper());

    f() {
    }

    private final boolean d() {
        return MobileQQ.PACKAGE_NAME.equals(BaseApplication.processName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        taskManager.r();
        c cVar = publishQueue;
        if (cVar != null) {
            cVar.N();
        }
        publishQueue = null;
        restoreFilterHelper.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        if (taskManager.t()) {
            f25725a.c().O();
        }
    }

    public final c c() {
        c cVar = publishQueue;
        if (cVar == null) {
            String uinString = LoginData.getInstance().getUinString();
            Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
            com.qzone.publish.business.publishqueue.common.f fVar = taskManager;
            String BUSINESS_FLAG_QZONE_ALBUMX = eo.d.f396892l;
            Intrinsics.checkNotNullExpressionValue(BUSINESS_FLAG_QZONE_ALBUMX, "BUSINESS_FLAG_QZONE_ALBUMX");
            cVar = new c(uinString, fVar, BUSINESS_FLAG_QZONE_ALBUMX);
            RFWLog.i("QZPublishX_QZPublishXQueueManager", RFWLog.USR, "initPublishQueue, uin:" + LoginData.getInstance().getUinString());
            if (!UploadServiceBuilder.getInstance().isInitialized()) {
                UploadEnv uploadEnv = new UploadEnv();
                UploadServiceBuilder.init(BaseApplication.getContext(), new r7.b(), new r7.d(), new r7.e(), uploadEnv, uploadEnv, null);
                RFWLog.i("QZPublishX_QZPublishXQueueManager", RFWLog.USR, "initPublishQueue,  again init UploadService");
            }
            publishQueue = cVar;
        }
        return cVar;
    }

    public final void e() {
        RFWLog.i("QZPublishX_QZPublishXQueueManager", RFWLog.USR, "onAccountChanged ");
        handler.post(new Runnable() { // from class: a9.e
            @Override // java.lang.Runnable
            public final void run() {
                f.f();
            }
        });
    }

    public final void g() {
        boolean d16 = d();
        RFWLog.i("QZPublishX_QZPublishXQueueManager", RFWLog.USR, "restore, start, isMainProcess:" + d16);
        if (d16) {
            handler.post(new Runnable() { // from class: a9.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.h();
                }
            });
        }
    }
}
