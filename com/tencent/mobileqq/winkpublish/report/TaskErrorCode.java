package com.tencent.mobileqq.winkpublish.report;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/TaskErrorCode;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "errorCode", "", "errorMsg", "", "(JLjava/lang/String;)V", "getErrorCodePrefix", "getTag", "Companion", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class TaskErrorCode extends WinkBaseErrorCode {

    @NotNull
    private static final String TAG = "TaskErrorCode";

    @WinkErrorCode(msg = WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN)
    @JvmField
    public static final long ERROR_CODE_UNKNOWN = Long.parseLong("-11");

    @WinkErrorCode(msg = "\u4efb\u52a1\u53d6\u6d88")
    @JvmField
    public static final long ERROR_CODE_CANCEL = Long.parseLong("-11000001");

    @WinkErrorCode(msg = "\u4efb\u52a1\u7c7b\u578b\u4e0d\u652f\u6301")
    @JvmField
    public static final long ERROR_CODE_NO_SUPPORT = Long.parseLong("-11000002");

    @WinkErrorCode(msg = "\u9884\u4e0a\u4f20\u4efb\u52a1\u7b49\u5f85")
    @JvmField
    public static final long ERROR_CODE_PRE_TASK_WAITING = Long.parseLong("-11000003");

    @WinkErrorCode(msg = "\u4efb\u52a1\u8d85\u65f6")
    @JvmField
    public static final long ERROR_CODE_TIMEOUT = Long.parseLong("-11000004");

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(TaskErrorCode.class));
    }

    public /* synthetic */ TaskErrorCode(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? null : str);
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 11L;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    @NotNull
    public String getTag() {
        return TAG;
    }

    public TaskErrorCode(long j3, @Nullable String str) {
        super(j3, str);
    }
}
