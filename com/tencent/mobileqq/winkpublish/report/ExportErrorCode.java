package com.tencent.mobileqq.winkpublish.report;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errorCode", "", "errorMsg", "", "(JLjava/lang/String;)V", "describeContents", "", "getErrorCodePrefix", "getTag", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class ExportErrorCode extends WinkBaseErrorCode implements Parcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ExportErrorCode> CREATOR;

    @NotNull
    private static final String TAG = "ExportErrorCode";

    @WinkErrorCode(msg = "\u6ca1\u6709missionID")
    @JvmField
    public static final long ERROR_CODE_NO_MISSION_ID = Long.parseLong("-13000001");

    @WinkErrorCode(msg = "\u7ba1\u7406\u5668\u4fa7\u89c6\u9891\u5bfc\u51fa\u8d85\u65f6")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_TIMEOUT = Long.parseLong("-13000002");

    @WinkErrorCode(msg = "\u5bfc\u51fa\u53d6\u6d88")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_CANCEL = Long.parseLong("-13000003");

    @WinkErrorCode(msg = "\u89c6\u9891\u5bfc\u51fa\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_FAIL = Long.parseLong("-13000004");

    @WinkErrorCode(msg = "\u89c6\u9891\u5bfc\u51fa\u56de\u8c03\u53d6\u6d88")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_CANCEL_CALLBACK = Long.parseLong("-13000005");

    @WinkErrorCode(msg = "\u89c6\u9891\u5bfc\u51fa\u6587\u4ef6\u957f\u5ea6\u4e3a0")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_FILE_SIZE_INVALID = Long.parseLong("-13000006");

    @WinkErrorCode(msg = "\u89c6\u9891\u5bfc\u51fa\u6587\u4ef6\u7801\u7387\u592a\u5c0f")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_FILE_BITRATE_INVALID = Long.parseLong("-13000007");

    @WinkErrorCode(msg = "\u89c6\u9891\u5bfc\u51fa\u6587\u4ef6\u7801\u7387\u4e3a0")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_FILE_BITRATE_ZERO = Long.parseLong("-13000008");

    @WinkErrorCode(msg = "\u539f\u89c6\u9891\u6587\u4ef6\u65e0\u6548")
    @JvmField
    public static final long ERROR_CODE_VIDEO_ORIGIN_FILE_INVALID = Long.parseLong("-13000009");

    @WinkErrorCode(msg = "\u6ca1\u6709\u89c6\u9891\u53c2\u6570")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_NO_PARAMS = Long.parseLong("-130000010");

    @WinkErrorCode(msg = "\u83b7\u53d6\u5c01\u9762\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_COVER_EXTRACT_FAILED = Long.parseLong("-130000011");

    @WinkErrorCode(msg = "\u5bfc\u51fa\u53c2\u6570\u9519\u8bef")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_PARAMS_ERROR = Long.parseLong("-130000012");

    @WinkErrorCode(msg = "\u89c6\u9891\u538b\u7f29so\u52a0\u8f7d\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_SO_LOAD_FAIL = Long.parseLong("-130000013");

    @WinkErrorCode(msg = "\u7ba1\u7406\u5668\u6dfb\u52a0\u4efb\u52a1\u53c2\u6570\u975e\u6cd5")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_ADD_TASK_ILLEGAL_PARAM = Long.parseLong("-130000014");

    @WinkErrorCode(msg = "\u7ba1\u7406\u5668\u8de8\u8fdb\u7a0b\u901a\u77e5\u5f02\u5e38")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_TO_CORE_ERROR = Long.parseLong("-130000015");

    @WinkErrorCode(msg = "\u53d1\u8868\u4efb\u52a1\u4fa7\u89c6\u9891\u5bfc\u51fa\u8d85\u65f6")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_TIMEOUT_BY_TASK = Long.parseLong("-130000016");

    @WinkErrorCode(msg = "\u89c6\u9891\u5408\u5e76\u5143\u6570\u636e\u975e\u6cd5")
    @JvmField
    public static final long ERROR_CODE_VIDEO_MERGE_INVALID_METADATA = Long.parseLong("-130000017");

    @WinkErrorCode(msg = "\u89c6\u9891\u5408\u5e76\u521b\u5efa\u89e3\u6790\u5668\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_VIDEO_MERGE_SETUP_EXTRACTOR = Long.parseLong("-130000018");

    @WinkErrorCode(msg = "\u89c6\u9891\u5408\u5e76\u5f00\u59cbmuxer\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_VIDEO_MERGE_START_MUXER = Long.parseLong("-130000019");

    @WinkErrorCode(msg = "\u89c6\u9891\u5408\u5e76\u6ca1\u6709\u8f68\u9053\u6570\u636e")
    @JvmField
    public static final long ERROR_CODE_VIDEO_MERGE_NO_TRACK_FORMAT_DATA = Long.parseLong("-130000020");

    @WinkErrorCode(msg = "\u89c6\u9891\u5408\u5e76\u53d6\u6d88")
    @JvmField
    public static final long ERROR_CODE_VIDEO_MERGE_CANCEL = Long.parseLong("-130000021");

    @WinkErrorCode(msg = "\u89c6\u9891\u5408\u5e76\u672a\u77e5\u9519\u8bef")
    @JvmField
    public static final long ERROR_CODE_VIDEO_MERGE_FAILED_UNKNOWN = Long.parseLong("-130000022");

    @WinkErrorCode(msg = "\u89c6\u9891\u538b\u7f29\u6ca1\u6709\u8f68\u9053\u6570\u636e")
    @JvmField
    public static final long ERROR_CODE_VIDEO_COMPRESS_NO_TRACK_FORMAT_DATA = Long.parseLong("-130000023");

    @WinkErrorCode(msg = "\u89c6\u9891\u538b\u7f29\u672a\u77e5\u9519\u8bef")
    @JvmField
    public static final long ERROR_CODE_VIDEO_COMPRESS_FAILED_UNKNOWN = Long.parseLong("-130000024");

    @WinkErrorCode(msg = "\u89c6\u9891\u538b\u7f29\u53c2\u6570\u975e\u6cd5")
    @JvmField
    public static final long ERROR_CODE_VIDEO_COMPRESS_INVALID_METADATA = Long.parseLong("-130000025");

    @WinkErrorCode(msg = "\u89c6\u9891\u5408\u5e76\u5f02\u5e38")
    @JvmField
    public static final long ERROR_CODE_VIDEO_MERGE_ERROR = Long.parseLong("-130000026");

    @WinkErrorCode(msg = "\u65b0\u538b\u7f29\u89c6\u9891\u65f6\u957f\u83b7\u53d6\u4e3a0")
    @JvmField
    public static final long ERROR_CODE_NEW_VIDEO_COMPRESS_TIME_ZERO = Long.parseLong("-130000027");

    @WinkErrorCode(msg = "\u65b0\u538b\u7f29\u89c6\u9891\u7f16\u89e3\u7801\u9519\u8bef")
    @JvmField
    public static final long ERROR_CODE_NEW_VIDEO_COMPRESS_ENCODE = Long.parseLong("-130000028");

    @WinkErrorCode(msg = "\u65b0\u538b\u7f29\u7ebf\u7a0b\u542f\u52a8\u9519\u8bef")
    @JvmField
    public static final long ERROR_CODE_NEW_VIDEO_COMPRESS_START_THREAD = Long.parseLong("-130000029");

    @WinkErrorCode(msg = "\u65b0\u538b\u7f29\u89c6\u9891\u8d44\u6e90\u91ca\u653e\u9519\u8bef")
    @JvmField
    public static final long ERROR_CODE_NEW_VIDEO_COMPRESS_RELEASE = Long.parseLong("-130000030");

    @WinkErrorCode(msg = "\u7eed\u5408\u89c6\u9891\u65f6\u957f\u6709\u8bef")
    @JvmField
    public static final long ERROR_CODE_MERGE_ERROR_DURATION = Long.parseLong("-130000031");

    @WinkErrorCode(msg = ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC)
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_FILE_NOT_EXIST = Long.parseLong("-130000032");

    @WinkErrorCode(msg = "localMediaInfo is null")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_RESULT_NULL = Long.parseLong("-130000033");

    @WinkErrorCode(msg = "video is black")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_RESULT_BLACK = Long.parseLong("-130000034");

    @WinkErrorCode(msg = "\u9ed1\u5c4f\u68c0\u6d4b\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_RESULT_BLACK_ERROR = Long.parseLong("-130000035");

    @WinkErrorCode(msg = "\u8f6f\u7f16\u538b\u7f29\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_RESULT_SOFT_COMPRESS_ERROR = Long.parseLong("-130000036");

    @WinkErrorCode(msg = "debug\u538b\u7f29\u5931\u8d25")
    @JvmField
    public static final long ERROR_CODE_VIDEO_EXPORT_RESULT_SOFT_COMPRESS_ERROR_TEST = Long.parseLong("-130000037");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/winkpublish/report/ExportErrorCode$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Parcelable.Creator<ExportErrorCode> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExportErrorCode createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExportErrorCode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExportErrorCode[] newArray(int size) {
            return new ExportErrorCode[size];
        }
    }

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(ExportErrorCode.class));
        CREATOR = new a();
    }

    public /* synthetic */ ExportErrorCode(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? null : str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 13L;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(getErrorCode());
        parcel.writeString(getErrorMsg());
    }

    public ExportErrorCode(long j3, @Nullable String str) {
        super(j3, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExportErrorCode(@NotNull Parcel parcel) {
        this(parcel.readLong(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
