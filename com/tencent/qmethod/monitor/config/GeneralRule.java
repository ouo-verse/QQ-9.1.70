package com.tencent.qmethod.monitor.config;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qmethod/monitor/config/GeneralRule;", "", "value", "", "back", "front", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBack", "()Ljava/lang/String;", "getFront", HippyTextInputController.COMMAND_getValue, "BACK_STORAGE_AND_FRONT_STORAGE", "BACK_BAN_AND_FRONT_STORAGE", "BACK_BAN_AND_FRONT_BAN", "BACK_BAN_AND_FRONT_NORMAL", "BACK_BAN_AND_FRONT_CACHE", "BACK_CACHE_ONLY_AND_FRONT_CACHE", "BACK_CACHE_ONLY_AND_FRONT_STORAGE", "BACK_CACHE_ONLY_AND_FRONT_NORMAL", "BACK_CACHE_AND_FRONT_CACHE", "BACK_CACHE_AND_FRONT_NORMAL", "BACK_NORMAL_AND_FRONT_NORMAL", "BACK_CACHE_ONLY_AND_FRONT_CACHE_ONLY", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public enum GeneralRule {
    BACK_STORAGE_AND_FRONT_STORAGE("storage_storage", QQPermissionConstants.Permission.STORAGE_GROUP, QQPermissionConstants.Permission.STORAGE_GROUP),
    BACK_BAN_AND_FRONT_STORAGE("ban_storage", "ban", QQPermissionConstants.Permission.STORAGE_GROUP),
    BACK_BAN_AND_FRONT_BAN("ban_ban", "ban", "ban"),
    BACK_BAN_AND_FRONT_NORMAL("ban_normal", "ban", "normal"),
    BACK_BAN_AND_FRONT_CACHE("ban_cache", "ban", "memory"),
    BACK_CACHE_ONLY_AND_FRONT_CACHE("cacheOnly_cache", "cache_only", "memory"),
    BACK_CACHE_ONLY_AND_FRONT_STORAGE("cacheOnly_storage", "cache_only", QQPermissionConstants.Permission.STORAGE_GROUP),
    BACK_CACHE_ONLY_AND_FRONT_NORMAL("cacheOnly_normal", "cache_only", "normal"),
    BACK_CACHE_AND_FRONT_CACHE("cache_cache", "memory", "memory"),
    BACK_CACHE_AND_FRONT_NORMAL("cache_normal", "memory", "normal"),
    BACK_NORMAL_AND_FRONT_NORMAL("normal_normal", "normal", "normal"),
    BACK_CACHE_ONLY_AND_FRONT_CACHE_ONLY("cacheOnly_cacheOnly", "cache_only", "cache_only");


    @NotNull
    private final String back;

    @NotNull
    private final String front;

    @NotNull
    private final String value;

    GeneralRule(String str, String str2, String str3) {
        this.value = str;
        this.back = str2;
        this.front = str3;
    }

    @NotNull
    public final String getBack() {
        return this.back;
    }

    @NotNull
    public final String getFront() {
        return this.front;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
