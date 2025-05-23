package com.tencent.biz.qqcircle.widgets;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\"\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "", "d", "", "b", "(Lcom/tencent/mobileqq/winkpublish/TaskInfo;)Ljava/lang/String;", "missionIdCompat", "a", "(Lcom/tencent/mobileqq/winkpublish/TaskInfo;)Z", "doNotShowProgress", "c", "needFakeProgress", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class p {
    public static final boolean a(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "<this>");
        Bundle transParams = taskInfo.getTransParams();
        if (transParams == null || transParams.getInt(com.tencent.mobileqq.qcircle.api.constant.a.f261590o, 0) != 1) {
            return false;
        }
        return true;
    }

    @Nullable
    public static final String b(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "<this>");
        if (TextUtils.isEmpty(taskInfo.getMissionId())) {
            Bundle transParams = taskInfo.getTransParams();
            if (transParams != null) {
                return transParams.getString(QQWinkConstants.MISSION_ID);
            }
            return null;
        }
        return taskInfo.getMissionId();
    }

    public static final boolean c(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "<this>");
        Bundle transParams = taskInfo.getTransParams();
        if (transParams == null) {
            return true;
        }
        return transParams.getBoolean("qcircle_publish_need_fake_progress", true);
    }

    public static final boolean d(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "<this>");
        if (!taskInfo.isFinish() && !taskInfo.isCancelled()) {
            return false;
        }
        return true;
    }
}
