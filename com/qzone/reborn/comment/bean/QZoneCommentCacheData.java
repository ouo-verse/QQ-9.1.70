package com.qzone.reborn.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import v4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001\u001eB?\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u0012\u0010\u0017R\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\u0019\u0010\u000f\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "J", "getUin", "()J", "setUin", "(J)V", "uin", "", "e", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setUnikey", "(Ljava/lang/String;)V", b.UNIKEY, "f", "getSecondarykey", "setSecondarykey", "secondarykey", h.F, "a", "inputContent", "i", "b", "timestamp", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentCacheData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String unikey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String secondarykey;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String inputContent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long timestamp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.comment.bean.QZoneCommentCacheData$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZoneCommentCacheData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZoneCommentCacheData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZoneCommentCacheData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneCommentCacheData[] newArray(int size) {
            return new QZoneCommentCacheData[size];
        }

        Companion() {
        }
    }

    public QZoneCommentCacheData() {
        this(0L, null, null, null, 0L, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getInputContent() {
        return this.inputContent;
    }

    /* renamed from: b, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: c, reason: from getter */
    public final String getUnikey() {
        return this.unikey;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(String str) {
        this.inputContent = str;
    }

    public final void f(long j3) {
        this.timestamp = j3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.uin);
        parcel.writeString(this.unikey);
        parcel.writeString(this.secondarykey);
        parcel.writeString(this.inputContent);
        parcel.writeLong(this.timestamp);
    }

    public QZoneCommentCacheData(long j3, String str, String str2, String str3, long j16) {
        this.uin = j3;
        this.unikey = str;
        this.secondarykey = str2;
        this.inputContent = str3;
        this.timestamp = j16;
    }

    public /* synthetic */ QZoneCommentCacheData(long j3, String str, String str2, String str3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? 0L : j16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneCommentCacheData(Parcel parcel) {
        this(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
