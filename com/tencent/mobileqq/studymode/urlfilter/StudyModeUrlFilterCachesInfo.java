package com.tencent.mobileqq.studymode.urlfilter;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import hr2.g;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u0000 .2\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010*\u001a\u00020\u001b\u00a2\u0006\u0004\b+\u0010,B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b+\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0000J\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u001a\u0010\u0014\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/studymode/urlfilter/StudyModeUrlFilterCachesInfo;", "Landroid/os/Parcelable;", "", "f", "", "l", "otherInfo", "a", "", "k", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "d", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "e", "I", "InvalidDay", "setUrl", "(Ljava/lang/String;)V", "url", "", h.F, "J", "b", "()J", "g", "(J)V", "invalidTime", "i", "Z", "c", "()Z", "j", "(Z)V", "needStoreKernel", "time", "<init>", "(Ljava/lang/String;J)V", "(Landroid/os/Parcel;)V", "CREATOR", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class StudyModeUrlFilterCachesInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int InvalidDay;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String url;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long invalidTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needStoreKernel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/studymode/urlfilter/StudyModeUrlFilterCachesInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/studymode/urlfilter/StudyModeUrlFilterCachesInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/studymode/urlfilter/StudyModeUrlFilterCachesInfo;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.studymode.urlfilter.StudyModeUrlFilterCachesInfo$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion implements Parcelable.Creator<StudyModeUrlFilterCachesInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StudyModeUrlFilterCachesInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StudyModeUrlFilterCachesInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public StudyModeUrlFilterCachesInfo[] newArray(int size) {
            return new StudyModeUrlFilterCachesInfo[size];
        }

        Companion() {
        }
    }

    public StudyModeUrlFilterCachesInfo(String url, long j3) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.TAG = "StudyModeUrlFilterCachesInfo";
        this.InvalidDay = 1;
        this.url = url;
        this.invalidTime = j3;
        this.needStoreKernel = true;
    }

    public final boolean a(StudyModeUrlFilterCachesInfo otherInfo) {
        Intrinsics.checkNotNullParameter(otherInfo, "otherInfo");
        return otherInfo.url.equals(this.url) && otherInfo.invalidTime == this.invalidTime;
    }

    /* renamed from: b, reason: from getter */
    public final long getInvalidTime() {
        return this.invalidTime;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getNeedStoreKernel() {
        return this.needStoreKernel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final boolean f() {
        long j3 = this.invalidTime;
        Date date = new Date(NetConnInfoCenter.getServerTimeMillis());
        Date date2 = new Date(j3);
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        calendar.setTime(date);
        int i3 = calendar.get(5);
        Calendar calendar2 = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar2, "getInstance()");
        calendar2.setTime(date2);
        int i16 = calendar2.get(5);
        QLog.d(g.f406087a.c(), 1, "urlfilter invalid cur=" + i3 + " time=" + i16 + " trans=" + k());
        return i3 - i16 < this.InvalidDay;
    }

    public final void g(long j3) {
        this.invalidTime = j3;
    }

    public final void j(boolean z16) {
        this.needStoreKernel = z16;
    }

    public final String k() {
        return (this.TAG + "url=" + this.url + " ") + "time=" + this.invalidTime + " ";
    }

    public final void l() {
        this.invalidTime = NetConnInfoCenter.getServerTimeMillis();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeLong(this.invalidTime);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public StudyModeUrlFilterCachesInfo(Parcel parcel) {
        this(r0 == null ? "" : r0, parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
    }
}
