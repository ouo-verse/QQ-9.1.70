package com.tencent.aegiskmm.bean;

import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/aegiskmm/bean/AegisLogLevel;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "INFO", RLog.ERROR, "SDK_ERROR", "PROMISE_ERROR", "AJAX_ERROR", "SCRIPT_ERROR", "WEBSOCKET_ERROR", "IMAGE_ERROR", "CSS_ERROR", "MEDIA_ERROR", "REPORT", "RET_ERROR", "NATIVE_ENGINE_ERROR", "NULL", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public enum AegisLogLevel {
    INFO("info"),
    ERROR("error"),
    SDK_ERROR("sdk_error"),
    PROMISE_ERROR("promise_error"),
    AJAX_ERROR("ajax_error"),
    SCRIPT_ERROR("script_error"),
    WEBSOCKET_ERROR("websocket_error"),
    IMAGE_ERROR("image_error"),
    CSS_ERROR("css_error"),
    MEDIA_ERROR("media_error"),
    REPORT("report"),
    RET_ERROR("ret_error"),
    NATIVE_ENGINE_ERROR("native_engine_error"),
    NULL("");

    AegisLogLevel(String str) {
    }
}
