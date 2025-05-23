package com.qzone.publish.business.publishqueue.intimate;

import android.os.Handler;
import com.qzone.publish.business.publishqueue.common.CommonPublishQueue;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/publish/business/publishqueue/intimate/i;", "", "", "d", "", "spaceId", "Lcom/qzone/publish/business/publishqueue/common/CommonPublishQueue;", "c", "", "g", "e", "", "b", "Ljava/util/Map;", "publishQueueMap", "Lcom/qzone/publish/business/publishqueue/common/f;", "Lcom/qzone/publish/business/publishqueue/common/f;", "taskManager", "Lcom/qzone/publish/business/publishqueue/common/e;", "Lcom/qzone/publish/business/publishqueue/common/e;", "restoreFilterHelper", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f51168a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, CommonPublishQueue> publishQueueMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final com.qzone.publish.business.publishqueue.common.f taskManager = new com.qzone.publish.business.publishqueue.common.f(1);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final com.qzone.publish.business.publishqueue.common.e restoreFilterHelper = new com.qzone.publish.business.publishqueue.common.e();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Handler handler = new Handler(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper());

    i() {
    }

    private final boolean d() {
        return MobileQQ.PACKAGE_NAME.equals(BaseApplication.processName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        taskManager.r();
        Iterator<Map.Entry<String, CommonPublishQueue>> it = publishQueueMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().N();
        }
        publishQueueMap.clear();
        restoreFilterHelper.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "$spaceId");
        if (taskManager.t()) {
            com.qzone.publish.business.publishqueue.common.e eVar = restoreFilterHelper;
            if (eVar.b(spaceId)) {
                RFWLog.i("QZoneIntimatePublishQueueManager", RFWLog.USR, "restore, has retry, return, spaceId:" + spaceId);
                return;
            }
            eVar.c(spaceId);
            RFWLog.i("QZoneIntimatePublishQueueManager", RFWLog.USR, "restore, repeat, spaceId:" + spaceId);
            f51168a.c(spaceId).O();
        }
    }

    public final CommonPublishQueue c(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Map<String, CommonPublishQueue> map = publishQueueMap;
        CommonPublishQueue commonPublishQueue = map.get(spaceId);
        if (commonPublishQueue == null) {
            RFWLog.i("QZoneIntimatePublishQueueManager", RFWLog.USR, "invoke, spaceId:" + spaceId);
            if (!UploadServiceBuilder.getInstance().isInitialized()) {
                UploadEnv uploadEnv = new UploadEnv();
                UploadServiceBuilder.init(BaseApplication.getContext(), new r7.b(), new r7.d(), new r7.e(), uploadEnv, uploadEnv, null);
                RFWLog.i("QZoneIntimatePublishQueueManager", RFWLog.USR, "initPublishQueue,  again init UploadService");
            }
            com.qzone.publish.business.publishqueue.common.f fVar = taskManager;
            String BUSINESS_FLAG_INTIMATE = eo.d.f396890j;
            Intrinsics.checkNotNullExpressionValue(BUSINESS_FLAG_INTIMATE, "BUSINESS_FLAG_INTIMATE");
            commonPublishQueue = new CommonPublishQueue(spaceId, fVar, BUSINESS_FLAG_INTIMATE);
            map.put(spaceId, commonPublishQueue);
        }
        return commonPublishQueue;
    }

    public final void e() {
        RFWLog.i("QZoneIntimatePublishQueueManager", RFWLog.USR, "onAccountChanged ");
        handler.post(new Runnable() { // from class: com.qzone.publish.business.publishqueue.intimate.h
            @Override // java.lang.Runnable
            public final void run() {
                i.f();
            }
        });
    }

    public final void g(final String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        boolean d16 = d();
        RFWLog.i("QZoneIntimatePublishQueueManager", RFWLog.USR, "restore, start, isMainProcess:" + d16);
        if (d16) {
            handler.post(new Runnable() { // from class: com.qzone.publish.business.publishqueue.intimate.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.h(spaceId);
                }
            });
        }
    }
}
