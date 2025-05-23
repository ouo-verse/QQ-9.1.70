package com.tencent.rdelivery.net;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.data.DataManager;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.net.e;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import iz3.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rdelivery/net/SendLocalStorageRequestTask;", "Lcom/tencent/raft/standard/task/IRTask$WeakReferenceTask;", "Lcom/tencent/rdelivery/data/DataManager;", "", TencentLocation.RUN_MODE, "Lcom/tencent/rdelivery/net/RDeliveryRequest;", "d", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", "getRequest", "()Lcom/tencent/rdelivery/net/RDeliveryRequest;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/rdelivery/net/e$b;", "e", "Lcom/tencent/rdelivery/net/e$b;", "taskResultListener", "Lcom/tencent/rdelivery/util/c;", "f", "Lcom/tencent/rdelivery/util/c;", "logger", "dataManager", "", "taskName", "<init>", "(Lcom/tencent/rdelivery/net/RDeliveryRequest;Lcom/tencent/rdelivery/data/DataManager;Lcom/tencent/rdelivery/net/e$b;Ljava/lang/String;Lcom/tencent/rdelivery/util/c;)V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class SendLocalStorageRequestTask extends IRTask.WeakReferenceTask<DataManager> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RDeliveryRequest request;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final e.b taskResultListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.rdelivery.util.c logger;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendLocalStorageRequestTask(@NotNull RDeliveryRequest request, @NotNull DataManager dataManager, @NotNull e.b taskResultListener, @NotNull String taskName, @Nullable com.tencent.rdelivery.util.c cVar) {
        super(dataManager, taskName, IRTask.Priority.NORMAL_PRIORITY);
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(dataManager, "dataManager");
        Intrinsics.checkParameterIsNotNull(taskResultListener, "taskResultListener");
        Intrinsics.checkParameterIsNotNull(taskName, "taskName");
        this.request = request;
        this.taskResultListener = taskResultListener;
        this.logger = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataManager ref = getRef();
        if (ref != null) {
            if (ref.k(this.request.getUserId(), "SendLocalStorageRequestTask")) {
                m listener = this.request.getListener();
                if (listener != null) {
                    listener.onFail("userid_changed");
                    return;
                }
                return;
            }
            if (ref.j(this.request.getLogicEnvironment(), "SendLocalStorageRequestTask")) {
                m listener2 = this.request.getListener();
                if (listener2 != null) {
                    listener2.onFail(XWalkReaderBasePlugin.PARAM_KEY_ENV_CHANGED);
                    return;
                }
                return;
            }
            com.tencent.rdelivery.util.c cVar = this.logger;
            if (cVar != null) {
                com.tencent.rdelivery.util.c.b(cVar, "RDelivery_SendNetRequestTask", "SendLocalStorageRequestTask running", false, 4, null);
            }
            try {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                int i3 = j.f364365a[this.request.getPullType().ordinal()];
                if (i3 != 1) {
                    if (i3 == 3) {
                        ref.J();
                    }
                } else {
                    List<String> l3 = this.request.l();
                    if (l3 != null) {
                        Iterator<T> it = l3.iterator();
                        while (it.hasNext()) {
                            RDeliveryData K = ref.K((String) it.next());
                            if (K != null) {
                                arrayList2.add(K);
                            }
                        }
                    }
                }
                m listener3 = this.request.getListener();
                if (listener3 != null) {
                    listener3.a(arrayList, arrayList2, arrayList3);
                }
            } catch (Exception e16) {
                com.tencent.rdelivery.util.c cVar2 = this.logger;
                if (cVar2 != null) {
                    cVar2.d("RDelivery_RequestManager", "SendLocalStorageRequestTask decode fail", e16);
                }
                m listener4 = this.request.getListener();
                if (listener4 != null) {
                    listener4.onFail("decode_fail");
                }
            }
            this.taskResultListener.a(true, this.request, null);
        }
    }
}
