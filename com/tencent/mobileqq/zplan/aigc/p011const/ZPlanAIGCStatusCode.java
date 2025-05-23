package com.tencent.mobileqq.zplan.aigc.p011const;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/const/ZPlanAIGCStatusCode;", "", "message", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "CREATE_AIGC_PUBLISH_SUCCEED", "CREATE_AIGC_PUBLISH_SUCCEED_V2", "IN_PROCESS_TIP", "FAST_DOUBLE_CLICK_TIP", "CREATE_AIGC_PREVIEW_COLOR_PICKER_TIP", "NORMAL_ERROR", "PUBLISH_RESOURCE_INVALID", "COS_UPLOAD_PREPARE_FAILED", "PRECREATE_AIGC_FAILED", "UPLOAD_TO_COS_FAILED", "CREATE_AIGC_FAILED", "SECURITY_CRACKDOWN", "NETWORK_UNAVAILABLE", "NETWORK_UNAVAILABLE_V2", "SERVICE_SYSTEM_BUSY", "AIGC_PIC_AUDIT_BLOCK", "AIGC_PIC_AUDIT_FAILED", "AIGC_PIC_AUDIT_AUDITING", "CHECK_CURRENCY_FAILED", "GOLD_COIN_NOT_ENOUGH", "SILVER_COIN_NOT_ENOUTH", "COIN_ENOUGH", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum ZPlanAIGCStatusCode {
    CREATE_AIGC_PUBLISH_SUCCEED("\u521b\u4f5c\u6210\u529f\uff0c\u5ba1\u6838\u901a\u8fc7\u540e\u53ef\u4ee5\u88c5\u626e"),
    CREATE_AIGC_PUBLISH_SUCCEED_V2("\u521b\u4f5c\u6210\u529f\uff0c\u53ef\u5728\u80cc\u5305\u91cc\u8fdb\u884c\u88c5\u626e"),
    IN_PROCESS_TIP("\u52a0\u8f7d\u4e2d"),
    FAST_DOUBLE_CLICK_TIP("\u521b\u4f5c\u4e2d\uff0c\u8bf7\u52ff\u9891\u7e41\u70b9\u51fb"),
    CREATE_AIGC_PREVIEW_COLOR_PICKER_TIP("\u8bf7\u5728\u975e\u5168\u8eab\u65b9\u5f0f\u4e0b\u66f4\u6539\u989c\u8272"),
    NORMAL_ERROR("\u52a0\u8f7d\u5931\u8d25\u8bf7\u91cd\u8bd5"),
    PUBLISH_RESOURCE_INVALID("\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002"),
    COS_UPLOAD_PREPARE_FAILED("\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002"),
    PRECREATE_AIGC_FAILED("\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002"),
    UPLOAD_TO_COS_FAILED("\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002"),
    CREATE_AIGC_FAILED("\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002"),
    SECURITY_CRACKDOWN("\u52a0\u8f7d\u5931\u8d25\u8bf7\u91cd\u8bd5"),
    NETWORK_UNAVAILABLE("\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002"),
    NETWORK_UNAVAILABLE_V2("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002"),
    SERVICE_SYSTEM_BUSY("\u7cfb\u7edf\u7e41\u5fd9, \u8bf7\u7b49\u5f852-3s\u540e\u91cd\u8bd5"),
    AIGC_PIC_AUDIT_BLOCK("\u670d\u88c5\u521b\u4f5c\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u521b\u4f5c"),
    AIGC_PIC_AUDIT_FAILED("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"),
    AIGC_PIC_AUDIT_AUDITING("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"),
    CHECK_CURRENCY_FAILED("\u8d2d\u4e70\u5931\u8d25"),
    GOLD_COIN_NOT_ENOUGH("QQ\u91d1\u5e01\u6570\u91cf\u4e0d\u8db3\uff0c\u662f\u5426\u5145\u503c"),
    SILVER_COIN_NOT_ENOUTH("QQ\u94f6\u5e01\u6570\u91cf\u4e0d\u8db3,\u65e0\u6cd5\u8d2d\u4e70"),
    COIN_ENOUGH("");


    @NotNull
    private final String message;

    ZPlanAIGCStatusCode(String str) {
        this.message = str;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }
}
