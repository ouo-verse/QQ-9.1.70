package com.tencent.rmonitor.manager;

import android.app.Application;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.raft.raftframework.sla.SLAReporter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.meta.BaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/rmonitor/manager/b;", "", "", "b", "", "", "monitorList", "a", "", "[Ljava/lang/String;", "sysPermissionsNeeded", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String[] sysPermissionsNeeded = {SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE"};

    @Nullable
    public List<String> a(@NotNull List<String> monitorList) {
        Intrinsics.checkParameterIsNotNull(monitorList, "monitorList");
        return ConfigProxy.INSTANCE.getConfig().g(monitorList);
    }

    public boolean b() {
        Application application = BaseInfo.app;
        if (application != null) {
            return DeviceInfoUtil.hasPermissions(application, this.sysPermissionsNeeded);
        }
        return false;
    }
}
