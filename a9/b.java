package a9;

import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.configx.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.utils.Const;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"La9/b;", "", "", "b", "Lcom/qzone/publish/business/task/IQueueTask;", "task", "", "a", "Lcom/tencent/upload/network/route/ServerRouteTable$PriorityPolicy;", "c", "", "I", "disconnectCount", "", "[I", "failCodeList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int disconnectCount;

    /* renamed from: a, reason: collision with root package name */
    public static final b f25722a = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int[] failCodeList = {Const.UploadRetCode.DATA_COMPLETE_TIMEOUT.getCode(), Const.UploadRetCode.SESSION_STATE_ERROR.getCode(), Const.UploadRetCode.ALL_IP_FAILED.getCode(), Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode(), Const.UploadRetCode.EAGAIN.getCode(), Const.UploadRetCode.ENETDOWN.getCode(), Const.UploadRetCode.ENETUNREACH.getCode(), Const.UploadRetCode.ECONNABORTED.getCode(), Const.UploadRetCode.ETIMEDOUT.getCode(), Const.UploadRetCode.EHOSTUNREACH.getCode()};

    b() {
    }

    private final boolean b() {
        g gVar = g.f53821a;
        if (gVar.j().s()) {
            QLog.d("QZPublishX_QZPublishXIpRouteRaceManager", 1, "enableSwitch enableSwitchPublic is true");
            return true;
        }
        gVar.j().r();
        return false;
    }

    public final void a(IQueueTask task) {
        boolean contains;
        Intrinsics.checkNotNullParameter(task, "task");
        boolean b16 = b();
        QLog.w("QZPublishX_QZPublishXIpRouteRaceManager", 1, "increaseDisconnectCount  | taskId=" + task.getTaskId() + " | resultCode=" + task.getResultCode() + " | clientKey=" + task.getClientKey() + " | task=" + task + " | enableSwitch=" + b16);
        if (b16) {
            contains = ArraysKt___ArraysKt.contains(failCodeList, task.getResultCode());
            if (contains) {
                int i3 = disconnectCount + 1;
                disconnectCount = i3;
                QLog.e("QZPublishX_QZPublishXIpRouteRaceManager", 1, "increaseDisconnectCount disconnectCount=" + i3);
            }
        }
    }

    public final ServerRouteTable.PriorityPolicy c() {
        ServerRouteTable.PriorityPolicy priorityPolicy;
        boolean b16 = b();
        int u16 = g.f53821a.j().u();
        if (b16 && disconnectCount >= u16) {
            priorityPolicy = ServerRouteTable.PriorityPolicy.IPV4_FIRST;
        } else {
            priorityPolicy = ServerRouteTable.PriorityPolicy.IPV6_FIRST;
        }
        QLog.w("QZPublishX_QZPublishXIpRouteRaceManager", 1, "getUploadIpPriorityPolicy  | enableSwitch=" + b16 + " | maxCount=" + u16 + " | disconnectCount=" + disconnectCount + " | policy=" + priorityPolicy);
        return priorityPolicy;
    }
}
