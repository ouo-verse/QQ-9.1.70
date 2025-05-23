package com.tencent.mobileqq.winkpublish.report;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/PublishActivityErrorCode;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "errorCode", "", "errorMsg", "", "(JLjava/lang/String;)V", "getErrorCodePrefix", "getTag", "Companion", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class PublishActivityErrorCode extends WinkBaseErrorCode {

    @NotNull
    private static final String TAG = "PublishActivityErrorCode";

    @WinkErrorCode(msg = "assembler\u4e1a\u52a1\u51b2\u7a81")
    @JvmField
    public static final long ERROR_CODE_ASSEMBLER_CONFLICT = Long.parseLong("-18000001");

    @WinkErrorCode(msg = "part\u7684ui\u72b6\u6001\u5f02\u5e38")
    @JvmField
    public static final long ERROR_CODE_PART_STATE_ERROR = Long.parseLong("-18000002");

    @WinkErrorCode(msg = "service\u8fde\u63a5\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_NO_SERVICE_ERROR = Long.parseLong("-18000003");

    @WinkErrorCode(msg = "service\u8fde\u63a5\u6d4b\u8bd5\u542f\u52a8")
    @JvmField
    public static final long ERROR_CODE_TEST_SERVICE_START = Long.parseLong("-18000004");

    @WinkErrorCode(msg = "service\u8fde\u63a5\u6d4b\u8bd5\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_TEST_SERVICE_ERROR = Long.parseLong("-18000005");

    @WinkErrorCode(msg = "service\u8fde\u63a5\u6d4b\u8bd5\u6210\u529f")
    @JvmField
    public static final long ERROR_CODE_TEST_SERVICE_SUCCESS = Long.parseLong("-18000006");

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(PublishActivityErrorCode.class));
    }

    public /* synthetic */ PublishActivityErrorCode(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? null : str);
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 18L;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    @NotNull
    public String getTag() {
        return TAG;
    }

    public PublishActivityErrorCode(long j3, @Nullable String str) {
        super(j3, str);
    }
}
