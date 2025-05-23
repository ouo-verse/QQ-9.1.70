package com.tencent.biz.qqcircle.wink;

import android.os.Bundle;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "", "a", "(Lcom/tencent/mobileqq/winkpublish/TaskInfo;)Z", "showNotification", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class d {
    public static final boolean a(@NotNull TaskInfo taskInfo) {
        Intrinsics.checkNotNullParameter(taskInfo, "<this>");
        Bundle transParams = taskInfo.getTransParams();
        if (transParams == null) {
            return false;
        }
        return transParams.getBoolean("qcircle_publish_show_notification", false);
    }
}
