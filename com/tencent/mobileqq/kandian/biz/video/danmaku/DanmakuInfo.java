package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import i62.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00013BG\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010(\u001a\u00020\t\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020\u0004\u00a2\u0006\u0004\b/\u00100B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010(\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013R\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018R\u0017\u0010.\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "e", "I", "getType", "()I", "type", "f", "getSource", "source", h.F, "getContent", "content", "", "i", "J", "getTime", "()J", "time", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getRowkey", "rowkey", BdhLogUtil.LogTag.Tag_Conn, "getColor", "color", "D", "getPosition", "position", "<init>", "(Ljava/lang/String;IILjava/lang/String;JLjava/lang/String;II)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final /* data */ class DanmakuInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private final int color;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private final int position;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int source;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String content;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final long time;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final String rowkey;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuInfo$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion implements Parcelable.Creator<DanmakuInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DanmakuInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DanmakuInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DanmakuInfo[] newArray(int size) {
            return new DanmakuInfo[size];
        }

        Companion() {
        }
    }

    public DanmakuInfo(String id5, int i3, int i16, String content, long j3, String rowkey, int i17, int i18) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(rowkey, "rowkey");
        this.id = id5;
        this.type = i3;
        this.source = i16;
        this.content = content;
        this.time = j3;
        this.rowkey = rowkey;
        this.color = i17;
        this.position = i18;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.type) * 31) + this.source) * 31) + this.content.hashCode()) * 31) + a.a(this.time)) * 31) + this.rowkey.hashCode()) * 31) + this.color) * 31) + this.position;
    }

    public String toString() {
        return "DanmakuInfo(id='" + this.id + "', content='" + this.content + "', time=" + this.time + ", rowkey=" + this.rowkey + "), color=" + this.color + ", position=" + this.position + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.type);
        parcel.writeInt(this.source);
        parcel.writeString(this.content);
        parcel.writeLong(this.time);
        parcel.writeString(this.rowkey);
        parcel.writeInt(this.color);
        parcel.writeInt(this.position);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DanmakuInfo(Parcel parcel) {
        this(r2, r3, r4, r5, r6, r8, parcel.readInt(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        long readLong = parcel.readLong();
        String readString3 = parcel.readString();
        Intrinsics.checkNotNull(readString3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DanmakuInfo)) {
            return false;
        }
        DanmakuInfo danmakuInfo = (DanmakuInfo) other;
        return Intrinsics.areEqual(this.id, danmakuInfo.id) && this.type == danmakuInfo.type && this.source == danmakuInfo.source && Intrinsics.areEqual(this.content, danmakuInfo.content) && this.time == danmakuInfo.time && Intrinsics.areEqual(this.rowkey, danmakuInfo.rowkey) && this.color == danmakuInfo.color && this.position == danmakuInfo.position;
    }
}
