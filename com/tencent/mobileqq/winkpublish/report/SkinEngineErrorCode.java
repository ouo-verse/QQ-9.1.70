package com.tencent.mobileqq.winkpublish.report;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/SkinEngineErrorCode;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "errorCode", "", "errorMsg", "", "(JLjava/lang/String;)V", "getErrorCodePrefix", "getTag", "Companion", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class SkinEngineErrorCode extends WinkBaseErrorCode {

    @NotNull
    private static final String TAG = "SkinEngineErrorCode";

    @WinkErrorCode(msg = "\u5f15\u64ce\u52a0\u8f7d\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_SET_UP_ENGINE = Long.parseLong("-16000001");

    @WinkErrorCode(msg = "\u52a0\u8f7d\u8d44\u6e90\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_LOAD_RESOURCE = Long.parseLong("-16000002");

    @WinkErrorCode(msg = "\u4e0b\u8f7d\u76ae\u80a4\u5305\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_DOWNLOAD_PACKAGE = Long.parseLong("-16000003");

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(SkinEngineErrorCode.class));
    }

    public /* synthetic */ SkinEngineErrorCode(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? null : str);
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 16L;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    @NotNull
    public String getTag() {
        return TAG;
    }

    public SkinEngineErrorCode(long j3, @Nullable String str) {
        super(j3, str);
    }
}
