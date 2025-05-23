package com.tencent.mobileqq.winkpublish.report;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/OneClickPublishingFeedErrorCode;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "errorCode", "", "errorMsg", "", "(JLjava/lang/String;)V", "getErrorCodePrefix", "getTag", "Companion", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class OneClickPublishingFeedErrorCode extends WinkBaseErrorCode {

    @NotNull
    private static final String TAG = "OneClickPublishingFeedErrorCode";

    @WinkErrorCode(msg = "missionId\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_MISSION_ID_IS_EMPTY = Long.parseLong("-17000001");

    @WinkErrorCode(msg = "MediaModelForEdit\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_MEDIA_MODEL_FOR_EDIT_IS_NULL = Long.parseLong("-17000002");

    @WinkErrorCode(msg = "MediaModelForExport\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_MEDIA_MODEL_FOR_EXPORT_IS_NULL = Long.parseLong("-17000003");

    @WinkErrorCode(msg = "\u7f16\u8f91\u56fe\u7247\u8def\u5f84\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_EDIT_IMAGE_PATHS_IS_EMPTY = Long.parseLong("-17000004");

    @WinkErrorCode(msg = "\u83b7\u53d6\u5c01\u9762\u65f6\u5a92\u4f53\u5217\u8868\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_FIRST_MEDIA_IS_NULL = Long.parseLong("-17000005");

    @WinkErrorCode(msg = "\u4f20\u5165\u5a92\u4f53\u8def\u5f84\u5217\u8868\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_MEDIA_PATHS_IS_NULL = Long.parseLong("-17000006");

    @WinkErrorCode(msg = "\u5904\u7406\u540e\u5a92\u4f53\u8def\u5f84\u5217\u8868\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_PROCESSED_MEDIA_PATHS_IS_NULL = Long.parseLong("-17000007");

    @WinkErrorCode(msg = "\u4e34\u65f6\u56fe\u7247\u8def\u5f84\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_TEMP_PNG_PATH_IS_EMPTY = Long.parseLong("-17000009");

    @WinkErrorCode(msg = "\u80cc\u666f\u7d20\u6750\u5217\u8868\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_BACKGROUND_MATERIAL_IS_EMPTY = Long.parseLong("-17000010");

    @WinkErrorCode(msg = "\u66f4\u65b0\u6587\u5b57\u5185\u5bb9\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_UPDATE_TEXT_CONTENT_FAILED = Long.parseLong("-17000011");

    @WinkErrorCode(msg = "textEntity\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_TEXT_ENTITY_IS_NULL = Long.parseLong("-17000012");

    @WinkErrorCode(msg = "\u63a8\u8350\u97f3\u4e50\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_RECOMMEND_MUSIC_FAILED = Long.parseLong("-17000014");

    @WinkErrorCode(msg = "\u63a8\u8350\u5361\u70b9\u97f3\u4e50\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_RECOMMEND_STUCK_MUSIC_FAILED = Long.parseLong("-17000015");

    @WinkErrorCode(msg = "\u586b\u5145\u63a8\u8350\u5361\u70b9\u97f3\u4e50\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_FILL_RECOMMEND_STUCK_MUSIC_FAILED = Long.parseLong("-17000016");

    @WinkErrorCode(msg = "path\u8f6clocalMediaInfo\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_PATH_TO_LOCALMEDIAINFO_FAILED = Long.parseLong("-17000017");

    @WinkErrorCode(msg = "\u83b7\u53d6\u5c01\u9762\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_GEN_COVER_FAILED = Long.parseLong("-17000018");

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(OneClickPublishingFeedErrorCode.class));
    }

    public /* synthetic */ OneClickPublishingFeedErrorCode(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? null : str);
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 17L;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    @NotNull
    public String getTag() {
        return TAG;
    }

    public OneClickPublishingFeedErrorCode(long j3, @Nullable String str) {
        super(j3, str);
    }
}
