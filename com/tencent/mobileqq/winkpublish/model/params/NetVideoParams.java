package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005BU\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0007H\u00c6\u0003J\t\u0010$\u001a\u00020\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\tH\u00c6\u0003J\t\u0010&\u001a\u00020\tH\u00c6\u0003J\t\u0010'\u001a\u00020\fH\u00c6\u0003J\t\u0010(\u001a\u00020\fH\u00c6\u0003J\t\u0010)\u001a\u00020\u0007H\u00c6\u0003J\t\u0010*\u001a\u00020\tH\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\fH\u00c6\u0003Jm\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0007H\u00c6\u0001J\b\u0010.\u001a\u00020\tH\u0016J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u00d6\u0003J\b\u00103\u001a\u00020\tH\u0016J\t\u00104\u001a\u00020\tH\u00d6\u0001J\t\u00105\u001a\u00020\u0007H\u00d6\u0001J\u0018\u00106\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00108\u001a\u00020\tH\u0016R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/NetVideoParams;", "Lcom/tencent/mobileqq/winkpublish/model/params/MediaParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "vid", "", "width", "", "height", "fileSize", "", "bitrate", "coverUrl", "coverWidth", "coverHeight", "duration", "md5", "(Ljava/lang/String;IIJJLjava/lang/String;IIJLjava/lang/String;)V", "getBitrate", "()J", "getCoverHeight", "()I", "getCoverUrl", "()Ljava/lang/String;", "getCoverWidth", "getDuration", "getFileSize", "getHeight", "getMd5", "type", "getType", "getVid", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "getMediaType", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class NetVideoParams extends MediaParams {
    private final long bitrate;
    private final int coverHeight;

    @NotNull
    private final String coverUrl;
    private final int coverWidth;
    private final long duration;
    private final long fileSize;
    private final int height;

    @NotNull
    private final String md5;
    private final int type;

    @NotNull
    private final String vid;
    private final int width;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<NetVideoParams> CREATOR = new Parcelable.Creator<NetVideoParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.NetVideoParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public NetVideoParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NetVideoParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public NetVideoParams[] newArray(int size) {
            return new NetVideoParams[size];
        }
    };

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/NetVideoParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/params/NetVideoParams;", "getTypeAdapter", "Lcom/google/gson/TypeAdapter;", "gson", "Lcom/google/gson/Gson;", "factory", "Lcom/google/gson/TypeAdapterFactory;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TypeAdapter<NetVideoParams> getTypeAdapter(@NotNull Gson gson, @NotNull TypeAdapterFactory factory) {
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(factory, "factory");
            TypeAdapter<NetVideoParams> delegateAdapter = gson.getDelegateAdapter(factory, TypeToken.get(NetVideoParams.class));
            Intrinsics.checkNotNullExpressionValue(delegateAdapter, "gson.getDelegateAdapter(\u2026VideoParams::class.java))");
            return delegateAdapter;
        }

        Companion() {
        }
    }

    public NetVideoParams(@NotNull String vid, int i3, int i16, long j3, long j16, @NotNull String coverUrl, int i17, int i18, long j17, @NotNull String md5) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.vid = vid;
        this.width = i3;
        this.height = i16;
        this.fileSize = j3;
        this.bitrate = j16;
        this.coverUrl = coverUrl;
        this.coverWidth = i17;
        this.coverHeight = i18;
        this.duration = j17;
        this.md5 = md5;
        this.type = 2;
    }

    public static /* synthetic */ NetVideoParams copy$default(NetVideoParams netVideoParams, String str, int i3, int i16, long j3, long j16, String str2, int i17, int i18, long j17, String str3, int i19, Object obj) {
        String str4;
        int i26;
        int i27;
        long j18;
        long j19;
        String str5;
        int i28;
        int i29;
        long j26;
        String str6;
        if ((i19 & 1) != 0) {
            str4 = netVideoParams.vid;
        } else {
            str4 = str;
        }
        if ((i19 & 2) != 0) {
            i26 = netVideoParams.width;
        } else {
            i26 = i3;
        }
        if ((i19 & 4) != 0) {
            i27 = netVideoParams.height;
        } else {
            i27 = i16;
        }
        if ((i19 & 8) != 0) {
            j18 = netVideoParams.fileSize;
        } else {
            j18 = j3;
        }
        if ((i19 & 16) != 0) {
            j19 = netVideoParams.bitrate;
        } else {
            j19 = j16;
        }
        if ((i19 & 32) != 0) {
            str5 = netVideoParams.coverUrl;
        } else {
            str5 = str2;
        }
        if ((i19 & 64) != 0) {
            i28 = netVideoParams.coverWidth;
        } else {
            i28 = i17;
        }
        if ((i19 & 128) != 0) {
            i29 = netVideoParams.coverHeight;
        } else {
            i29 = i18;
        }
        if ((i19 & 256) != 0) {
            j26 = netVideoParams.duration;
        } else {
            j26 = j17;
        }
        if ((i19 & 512) != 0) {
            str6 = netVideoParams.md5;
        } else {
            str6 = str3;
        }
        return netVideoParams.copy(str4, i26, i27, j18, j19, str5, i28, i29, j26, str6);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getVid() {
        return this.vid;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component4, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component5, reason: from getter */
    public final long getBitrate() {
        return this.bitrate;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: component7, reason: from getter */
    public final int getCoverWidth() {
        return this.coverWidth;
    }

    /* renamed from: component8, reason: from getter */
    public final int getCoverHeight() {
        return this.coverHeight;
    }

    /* renamed from: component9, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final NetVideoParams copy(@NotNull String vid, int width, int height, long fileSize, long bitrate, @NotNull String coverUrl, int coverWidth, int coverHeight, long duration, @NotNull String md5) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(md5, "md5");
        return new NetVideoParams(vid, width, height, fileSize, bitrate, coverUrl, coverWidth, coverHeight, duration, md5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetVideoParams)) {
            return false;
        }
        NetVideoParams netVideoParams = (NetVideoParams) other;
        if (Intrinsics.areEqual(this.vid, netVideoParams.vid) && this.width == netVideoParams.width && this.height == netVideoParams.height && this.fileSize == netVideoParams.fileSize && this.bitrate == netVideoParams.bitrate && Intrinsics.areEqual(this.coverUrl, netVideoParams.coverUrl) && this.coverWidth == netVideoParams.coverWidth && this.coverHeight == netVideoParams.coverHeight && this.duration == netVideoParams.duration && Intrinsics.areEqual(this.md5, netVideoParams.md5)) {
            return true;
        }
        return false;
    }

    public final long getBitrate() {
        return this.bitrate;
    }

    public final int getCoverHeight() {
        return this.coverHeight;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final int getCoverWidth() {
        return this.coverWidth;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }

    @Override // com.tencent.mobileqq.winkpublish.model.params.MediaParams
    /* renamed from: getMediaType, reason: from getter */
    public int getType() {
        return this.type;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getVid() {
        return this.vid;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((((((((((this.vid.hashCode() * 31) + this.width) * 31) + this.height) * 31) + a.a(this.fileSize)) * 31) + a.a(this.bitrate)) * 31) + this.coverUrl.hashCode()) * 31) + this.coverWidth) * 31) + this.coverHeight) * 31) + a.a(this.duration)) * 31) + this.md5.hashCode();
    }

    @NotNull
    public String toString() {
        return "NetVideoParams(vid=" + this.vid + ", width=" + this.width + ", height=" + this.height + ", fileSize=" + this.fileSize + ", bitrate=" + this.bitrate + ", coverUrl=" + this.coverUrl + ", coverWidth=" + this.coverWidth + ", coverHeight=" + this.coverHeight + ", duration=" + this.duration + ", md5=" + this.md5 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.vid);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeLong(this.fileSize);
        parcel.writeLong(this.bitrate);
        parcel.writeString(this.coverUrl);
        parcel.writeInt(this.coverWidth);
        parcel.writeInt(this.coverHeight);
        parcel.writeLong(this.duration);
        parcel.writeString(this.md5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NetVideoParams(@NotNull Parcel parcel) {
        this(r4, r5, r6, r7, r9, r11, r12, r13, r14, r0 == null ? "" : r0);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        long readLong = parcel.readLong();
        long readLong2 = parcel.readLong();
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        long readLong3 = parcel.readLong();
        String readString3 = parcel.readString();
    }
}
