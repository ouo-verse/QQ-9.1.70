package com.tencent.mobileqq.winkpublish.report;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/PublishFeedErrorCode;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "errorCode", "", "errorMsg", "", "(JLjava/lang/String;)V", "getErrorCodePrefix", "getTag", "Companion", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class PublishFeedErrorCode extends WinkBaseErrorCode {

    @NotNull
    private static final String TAG = "PublishFeedErrorCode";

    @WinkErrorCode(msg = "\u975e\u6cd5\u89c6\u9891\u65f6\u957f")
    @JvmField
    public static final long ERROR_CODE_INVALID_DURATION = Long.parseLong("-14000001");

    @WinkErrorCode(msg = "\u975e\u6cd5vid")
    @JvmField
    public static final long ERROR_CODE_INVALID_VID = Long.parseLong("-14000002");

    @WinkErrorCode(msg = "\u68c0\u67e5feed\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_CHECK_COMPLETE_FAIL = Long.parseLong("-14000003");

    @WinkErrorCode(msg = "\u975e\u6cd5FeedParams\u53c2\u6570")
    @JvmField
    public static final long ERROR_CODE_INVALID_PARAMS = Long.parseLong("-14000004");

    @WinkErrorCode(msg = "\u975e\u6cd5\u89c6\u9891\u5c01\u9762")
    @JvmField
    public static final long ERROR_CODE_INVALID_VIDEO_COVER = Long.parseLong("-14000005");

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(PublishFeedErrorCode.class));
    }

    public /* synthetic */ PublishFeedErrorCode(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? null : str);
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 14L;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    @NotNull
    public String getTag() {
        return TAG;
    }

    public PublishFeedErrorCode(long j3, @Nullable String str) {
        super(j3, str);
    }
}
