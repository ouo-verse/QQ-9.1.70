package com.tencent.mobileqq.wink.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.model.params.ExportParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\bH\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/p;", "", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "serviceProxy2", "Lcom/tencent/mobileqq/winkpublish/model/params/WinkPublishParams;", "publishParams", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "a", "", "b", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f326725a = new p();

    p() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:0: B:6:0x0020->B:22:?, LOOP_END, SYNTHETIC] */
    @JvmStatic
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final TaskInfo a(@NotNull WinkPublishServiceProxy2 serviceProxy2, @NotNull WinkPublishParams publishParams) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(serviceProxy2, "serviceProxy2");
        Intrinsics.checkNotNullParameter(publishParams, "publishParams");
        Object obj = null;
        if (!f326725a.b()) {
            return null;
        }
        Iterator<T> it = serviceProxy2.getRunningTasks().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TaskInfo taskInfo = (TaskInfo) next;
            if (Intrinsics.areEqual(taskInfo.getTraceId(), publishParams.getTraceId())) {
                String missionId = taskInfo.getMissionId();
                ExportParams exportParams = publishParams.getExportParams();
                if (exportParams != null) {
                    str = exportParams.getMissionId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(missionId, str)) {
                    z16 = true;
                    if (!z16) {
                        obj = next;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return (TaskInfo) obj;
    }

    private final boolean b() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_publish_feed_filter_repeat", true);
        QLog.d("PublishFeedFilter", 1, "isEnableFilter, ret:" + isSwitchOn);
        return isSwitchOn;
    }
}
