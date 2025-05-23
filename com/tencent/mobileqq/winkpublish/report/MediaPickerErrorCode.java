package com.tencent.mobileqq.winkpublish.report;

import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/MediaPickerErrorCode;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "errorCode", "", "errorMsg", "", "(JLjava/lang/String;)V", "getErrorCodePrefix", "getTag", "Companion", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class MediaPickerErrorCode extends WinkBaseErrorCode {

    @WinkErrorCode(msg = WinkBaseErrorCodeKt.ERROR_MSG_UNKNOWN)
    public static final long ERROR_CODE_UNKNOWN = 15;

    @NotNull
    private static final String TAG = "MediaPickerErrorCode";

    @WinkErrorCode(msg = ShareJsPlugin.ERRMSG_INVITE_CANCEL)
    @JvmField
    public static final long ERROR_CODE_USER_CANCEL = Long.parseLong("-15000001");

    @WinkErrorCode(msg = "\u9009\u62e9\u5a92\u4f53\u5217\u8868\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_EMPTY_SELECTED_MEDIA = Long.parseLong("-15000002");

    @WinkErrorCode(msg = "\u65e0\u7f51\u7edc")
    @JvmField
    public static final long ERROR_CODE_NO_NETWORK = Long.parseLong("-15000003");

    @WinkErrorCode(msg = "\u7a7a\u95f4\u56fe\u7247\u4e0b\u8f7d\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_QZONE_IMAGE_DOWNLOAD_FAILED = Long.parseLong("-15000004");

    @WinkErrorCode(msg = "\u7a7a\u95f4\u89c6\u9891\u4e0b\u8f7d\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_QZONE_VIDEO_DOWNLOAD_FAILED = Long.parseLong("-15000005");

    @WinkErrorCode(msg = "\u7075\u611f\u5e93\u4eba\u8138\u8bc6\u522b\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_TEMPLATE_LIB_FACE_DETECTION_FAILED = Long.parseLong("-15000006");

    @WinkErrorCode(msg = "\u7075\u611f\u5e93\u4e0a\u4f20\u539f\u5a92\u4f53\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_TEMPLATE_LIB_UPLOAD_IMAGES_FAILED = Long.parseLong("-15000007");

    @WinkErrorCode(msg = "\u7075\u611f\u5e93\u5904\u7406\u5a92\u4f53\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_TEMPLATE_LIB_PROCESS_IMAGES_FAILED = Long.parseLong("-15000008");

    @WinkErrorCode(msg = "\u7075\u611f\u5e93\u66ff\u6362\u5a92\u4f53\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_TEMPLATE_LIB_REPLACE_MEDIA_FAILED = Long.parseLong("-15000009");

    @WinkErrorCode(msg = "\u7075\u611f\u5e93\u5bfc\u51fa\u89c6\u9891\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_TEMPLATE_LIB_EXPORT_MEDIA_FAILED = Long.parseLong("-150000010");

    @WinkErrorCode(msg = "\u538b\u7f29\u89c6\u9891\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_COMPRESS_VIDEO_FAILED = Long.parseLong("-150000011");

    @WinkErrorCode(msg = "\u538b\u7f29\u56fe\u7247\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_COMPRESS_IMAGE_FAILED = Long.parseLong("-150000012");

    @WinkErrorCode(msg = "\u9009\u62e9\u5a92\u4f53\u5217\u8868\u4e3a\u7a7a, \u6570\u636e\u5ef6\u8fdf")
    @JvmField
    public static final long ERROR_CODE_EMPTY_SELECTED_MEDIA_DATA_DELAY = Long.parseLong("-150000013");

    @WinkErrorCode(msg = "\u9009\u62e9\u5a92\u4f53\u5217\u8868\u4e3a\u7a7a, \u672c\u5730\u6587\u4ef6\u4e0d\u5b58\u5728")
    @JvmField
    public static final long ERROR_CODE_EMPTY_SELECTED_MEDIA_INVALID_FILE = Long.parseLong("-150000014");

    @WinkErrorCode(msg = "\u7075\u611f\u5e93\u5f02\u5e38\u4fe1\u606f")
    @JvmField
    public static final long ERROR_CODE_TEMPLATE_LIB_DETAIL_ERROR_MSG = Long.parseLong("-150000015");

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(MediaPickerErrorCode.class));
    }

    public /* synthetic */ MediaPickerErrorCode(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? null : str);
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 15L;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    @NotNull
    public String getTag() {
        return TAG;
    }

    public MediaPickerErrorCode(long j3, @Nullable String str) {
        super(j3, str);
    }
}
