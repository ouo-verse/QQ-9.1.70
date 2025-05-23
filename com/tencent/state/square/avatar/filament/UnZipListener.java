package com.tencent.state.square.avatar.filament;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/avatar/filament/UnZipListener;", "", "onTaskFailed", "", "errorCode", "", "errorMessage", "", "onTaskStart", "onTaskSuccess", "moodConfig", "Lorg/json/JSONObject;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface UnZipListener {
    void onTaskFailed(int errorCode, String errorMessage);

    void onTaskStart();

    void onTaskSuccess(JSONObject moodConfig);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static void onTaskSuccess(UnZipListener unZipListener, JSONObject moodConfig) {
            Intrinsics.checkNotNullParameter(moodConfig, "moodConfig");
        }

        public static void onTaskStart(UnZipListener unZipListener) {
        }
    }
}
