package com.tencent.mobileqq.onlinestatus.utils;

import android.text.format.DateUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.CommonMMKVUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/y;", "", "", "b", "isRedShown", "", "a", "<init>", "()V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final y f256382a = new y();

    y() {
    }

    @JvmStatic
    public static final void a(boolean isRedShown) {
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusRedHelper", 2, "[addUpdateHintViewRemovedCount] call. isRedShown=" + isRedShown);
        }
        if (!isRedShown) {
            return;
        }
        if (!DateUtils.isToday(CommonMMKVUtils.getLong$default("qq_status_update_hint_last_time", 0L, false, 4, null))) {
            CommonMMKVUtils.putInt$default("qq_status_update_hint_removed_count", 1, false, 4, null);
        } else {
            CommonMMKVUtils.putInt$default("qq_status_update_hint_removed_count", CommonMMKVUtils.getInt$default("qq_status_update_hint_removed_count", 0, false, 4, null) + 1, false, 4, null);
        }
        CommonMMKVUtils.putLong$default("qq_status_update_hint_last_time", System.currentTimeMillis(), false, 4, null);
    }

    @JvmStatic
    public static final boolean b() {
        if (!DateUtils.isToday(CommonMMKVUtils.getLong$default("qq_status_update_hint_last_time", 0L, false, 4, null))) {
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusRedHelper", 2, "[canShowOnUpdateHintView] last removed not today");
            }
            return true;
        }
        int int$default = CommonMMKVUtils.getInt$default("qq_status_update_hint_removed_count", 0, false, 4, null);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusRedHelper", 2, "[canShowOnUpdateHintView] today removed count : " + int$default);
        }
        if (int$default < 5) {
            return true;
        }
        return false;
    }
}
