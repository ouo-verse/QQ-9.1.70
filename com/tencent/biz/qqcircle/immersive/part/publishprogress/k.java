package com.tencent.biz.qqcircle.immersive.part.publishprogress;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/publishprogress/k;", "", "", "a", "", "c", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "", "e", "d", "startTimeMs", "b", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f88273a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TaskInfo taskInfo;

    k() {
    }

    public final long a() {
        boolean z16;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_publish_progress_bubble_min_duration_ms", "");
        if (loadAsString.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        long j3 = 4000;
        if (z16) {
            try {
                j3 = new JSONObject(loadAsString).optLong("qqcircle_publish_progress_bubble_min_duration_ms", 4000L);
            } catch (Exception e16) {
                QLog.e("WinkPublish-Progress-QFSRectBoxFirstPublishMgr", 1, "getProgressBubbleMinDurationMs error:" + e16);
            }
        }
        QLog.d("WinkPublish-Progress-QFSRectBoxFirstPublishMgr", 1, "getProgressBubbleMinDurationMs, ret:" + j3);
        return j3;
    }

    public final long b(long startTimeMs) {
        long j3;
        long a16 = a();
        if (startTimeMs > 0) {
            j3 = a16 - (System.currentTimeMillis() - startTimeMs);
        } else {
            j3 = a16;
        }
        boolean z16 = false;
        if (0 <= j3 && j3 <= a16) {
            z16 = true;
        }
        if (!z16) {
            return 0L;
        }
        return j3;
    }

    public final boolean c() {
        return uq3.k.a().c(QQWinkConstants.WINK_USER_HAVE_NO_PUBLISH, false);
    }

    public final boolean d(@NotNull TaskInfo taskInfo2) {
        Intrinsics.checkNotNullParameter(taskInfo2, "taskInfo");
        TaskInfo taskInfo3 = taskInfo;
        if (taskInfo3 == null || taskInfo2.getTaskId() != taskInfo3.getTaskId()) {
            return false;
        }
        return true;
    }

    public final void e(@NotNull TaskInfo taskInfo2) {
        Intrinsics.checkNotNullParameter(taskInfo2, "taskInfo");
        taskInfo = taskInfo2;
    }
}
