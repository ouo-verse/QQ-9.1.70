package com.tencent.mobileqq.winkpublish.report;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/UploadErrorCode;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "errorCode", "", "errorMsg", "", "(JLjava/lang/String;)V", "getErrorCodePrefix", "getTag", "Companion", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class UploadErrorCode extends WinkBaseErrorCode {

    @NotNull
    private static final String TAG = "UploadErrorCode";

    @WinkErrorCode(msg = "\u767b\u9646\u6001\u4e22\u5931")
    @JvmField
    public static final long ERROR_CODE_NO_LOGIN_DATA = Long.parseLong("-12000001");

    @WinkErrorCode(msg = "\u4e0a\u4f20\u6587\u4ef6\u4e0d\u5b58\u5728")
    @JvmField
    public static final long ERROR_CODE_FILE_NOT_EXIST = Long.parseLong("-12000002");

    @WinkErrorCode(msg = "\u89c6\u9891\u5c01\u9762\u4e0d\u5b58\u5728")
    @JvmField
    public static final long ERROR_CODE_VIDEO_COVER_NOT_FOUND = Long.parseLong("-12000003");

    @WinkErrorCode(msg = "\u975e\u6cd5ImageParams\u53c2\u6570")
    @JvmField
    public static final long ERROR_CODE_INVALID_IMAGE_PARAMS = Long.parseLong("-12000004");

    @WinkErrorCode(msg = "\u975e\u6cd5VideoParams\u53c2\u6570")
    @JvmField
    public static final long ERROR_CODE_INVALID_VIDEO_PARAMS = Long.parseLong("-12000005");

    @WinkErrorCode(msg = "\u4e0a\u4f20\u53d6\u6d88")
    @JvmField
    public static final long ERROR_CODE_UPLOAD_CANCELED = Long.parseLong("-12000006");

    @WinkErrorCode(msg = "\u8fb9\u5408\u8fc7\u7a0b\u4e2d\u5bfc\u51fa\u8fd4\u56de\u539f\u89c6\u9891\u4e0a\u4f20")
    @JvmField
    public static final long ERROR_CODE_UWE_MEET_ORIGINAL_EXPORT = Long.parseLong("-12000007");

    @WinkErrorCode(msg = "\u8fb9\u5408\u6ca1\u6709\u4e0a\u4f20task")
    @JvmField
    public static final long ERROR_CODE_UWE_NO_TASK = Long.parseLong("-12000008");

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(UploadErrorCode.class));
    }

    public /* synthetic */ UploadErrorCode(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? null : str);
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 12L;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    @NotNull
    public String getTag() {
        return TAG;
    }

    public UploadErrorCode(long j3, @Nullable String str) {
        super(j3, str);
    }
}
