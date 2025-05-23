package com.tencent.mobileqq.winkpublish.report;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkContextErrorCode;", "Lcom/tencent/mobileqq/winkpublish/report/WinkBaseErrorCode;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errorCode", "", "errorMsg", "", "(JLjava/lang/String;)V", "describeContents", "", "getErrorCodePrefix", "getTag", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkContextErrorCode extends WinkBaseErrorCode implements Parcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<WinkContextErrorCode> CREATOR;

    @NotNull
    private static final String TAG = "WinkContextErrorCode";

    @WinkErrorCode(msg = "\u8bbe\u7f6e\u5f53\u524dcontext\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_SET_CURRENT_EMPTY = Long.parseLong("-19000001");

    @WinkErrorCode(msg = "\u83b7\u53d6context\u4e3a\u7a7a")
    @JvmField
    public static final long ERROR_CODE_GET_EMPTY = Long.parseLong("-19000002");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/winkpublish/report/WinkContextErrorCode$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/report/WinkContextErrorCode;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/winkpublish/report/WinkContextErrorCode;", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Parcelable.Creator<WinkContextErrorCode> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkContextErrorCode createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkContextErrorCode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkContextErrorCode[] newArray(int size) {
            return new WinkContextErrorCode[size];
        }
    }

    static {
        WinkBaseErrorCode.INSTANCE.loadPredefinedCode(Reflection.getOrCreateKotlinClass(WinkContextErrorCode.class));
        CREATOR = new a();
    }

    public /* synthetic */ WinkContextErrorCode(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i3 & 2) != 0 ? null : str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCode
    public long getErrorCodePrefix() {
        return 19L;
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

    public WinkContextErrorCode(long j3, @Nullable String str) {
        super(j3, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkContextErrorCode(@NotNull Parcel parcel) {
        this(parcel.readLong(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
