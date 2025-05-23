package com.qzone.reborn.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001\u0018B+\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R$\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/qzone/reborn/comment/bean/QZoneCommentFontInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "id", "e", "a", "setFontFormatType", "fontFormatType", "f", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setFontUrl", "(Ljava/lang/String;)V", "fontUrl", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class QZoneCommentFontInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private Integer id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private Integer fontFormatType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String fontUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/comment/bean/QZoneCommentFontInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/qzone/reborn/comment/bean/QZoneCommentFontInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/qzone/reborn/comment/bean/QZoneCommentFontInfo;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.comment.bean.QZoneCommentFontInfo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion implements Parcelable.Creator<QZoneCommentFontInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QZoneCommentFontInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZoneCommentFontInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneCommentFontInfo[] newArray(int size) {
            return new QZoneCommentFontInfo[size];
        }

        Companion() {
        }
    }

    public QZoneCommentFontInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final Integer getFontFormatType() {
        return this.fontFormatType;
    }

    /* renamed from: b, reason: from getter */
    public final String getFontUrl() {
        return this.fontUrl;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.fontFormatType;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.fontUrl;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "QZoneCommentFontInfo(id=" + this.id + ", fontFormatType=" + this.fontFormatType + ", fontUrl=" + this.fontUrl + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeValue(this.id);
        parcel.writeValue(this.fontFormatType);
        parcel.writeString(this.fontUrl);
    }

    public QZoneCommentFontInfo(Integer num, Integer num2, String str) {
        this.id = num;
        this.fontFormatType = num2;
        this.fontUrl = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneCommentFontInfo)) {
            return false;
        }
        QZoneCommentFontInfo qZoneCommentFontInfo = (QZoneCommentFontInfo) other;
        return Intrinsics.areEqual(this.id, qZoneCommentFontInfo.id) && Intrinsics.areEqual(this.fontFormatType, qZoneCommentFontInfo.fontFormatType) && Intrinsics.areEqual(this.fontUrl, qZoneCommentFontInfo.fontUrl);
    }

    public /* synthetic */ QZoneCommentFontInfo(Integer num, Integer num2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, (i3 & 4) != 0 ? null : str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QZoneCommentFontInfo(Parcel parcel) {
        this(r1, r0 instanceof Integer ? (Integer) r0 : null, parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Class cls = Integer.TYPE;
        Object readValue = parcel.readValue(cls.getClassLoader());
        Integer num = readValue instanceof Integer ? (Integer) readValue : null;
        Object readValue2 = parcel.readValue(cls.getClassLoader());
    }
}
