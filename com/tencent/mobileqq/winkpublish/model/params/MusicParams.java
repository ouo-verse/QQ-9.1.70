package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkpublish.model.PublishUploadParams;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\fH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00c6\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\bH\u00c6\u0001J\b\u0010\u001f\u001a\u00020\fH\u0016J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u00d6\u0003J\t\u0010$\u001a\u00020\fH\u00d6\u0001J\t\u0010%\u001a\u00020\bH\u00d6\u0001J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\fH\u0016R\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/MusicParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "mId", "", "name", "startTime", "scene", "", "authorUid", "(JLjava/lang/String;Ljava/lang/String;JILjava/lang/String;)V", "getAuthorUid", "()Ljava/lang/String;", "getId", "()J", "getMId", "getName", "getScene", "()I", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class MusicParams implements Parcelable {

    @NotNull
    private static final String TAG = "MusicParams";

    @NotNull
    private final String authorUid;
    private final long id;

    @NotNull
    private final String mId;

    @NotNull
    private final String name;
    private final int scene;
    private final long startTime;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<MusicParams> CREATOR = new Parcelable.Creator<MusicParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.MusicParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MusicParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MusicParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MusicParams[] newArray(int size) {
            return new MusicParams[size];
        }
    };

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/MusicParams$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/winkpublish/model/params/MusicParams;", "TAG", "", "from", "p", "Lcom/tencent/mobileqq/winkpublish/model/PublishUploadParams;", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final MusicParams from(@Nullable PublishUploadParams p16) {
            boolean z16;
            String str;
            String str2;
            if (p16 != null) {
                String str3 = p16.pubMusicMid;
                if (str3 != null && str3.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    long j3 = p16.pubMusicId;
                    String str4 = p16.pubMusicMid;
                    if (str4 == null) {
                        str = "";
                    } else {
                        str = str4;
                    }
                    String str5 = p16.pubMusicName;
                    if (str5 == null) {
                        str2 = "";
                    } else {
                        str2 = str5;
                    }
                    long j16 = p16.pubStartTime;
                    int i3 = p16.pubMusicScene;
                    String str6 = p16.pubMusicAuthorUid;
                    if (str6 == null) {
                        str6 = "";
                    }
                    MusicParams musicParams = new MusicParams(j3, str, str2, j16, i3, str6);
                    QLog.i(MusicParams.TAG, 1, "[fromPublishUploadParams] " + musicParams);
                    return musicParams;
                }
            }
            QLog.i(MusicParams.TAG, 1, "[fromPublishUploadParams] invalid params");
            return null;
        }

        Companion() {
        }
    }

    public MusicParams(long j3, @NotNull String mId, @NotNull String name, long j16, int i3, @NotNull String authorUid) {
        Intrinsics.checkNotNullParameter(mId, "mId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(authorUid, "authorUid");
        this.id = j3;
        this.mId = mId;
        this.name = name;
        this.startTime = j16;
        this.scene = i3;
        this.authorUid = authorUid;
    }

    public static /* synthetic */ MusicParams copy$default(MusicParams musicParams, long j3, String str, String str2, long j16, int i3, String str3, int i16, Object obj) {
        long j17;
        String str4;
        String str5;
        long j18;
        int i17;
        String str6;
        if ((i16 & 1) != 0) {
            j17 = musicParams.id;
        } else {
            j17 = j3;
        }
        if ((i16 & 2) != 0) {
            str4 = musicParams.mId;
        } else {
            str4 = str;
        }
        if ((i16 & 4) != 0) {
            str5 = musicParams.name;
        } else {
            str5 = str2;
        }
        if ((i16 & 8) != 0) {
            j18 = musicParams.startTime;
        } else {
            j18 = j16;
        }
        if ((i16 & 16) != 0) {
            i17 = musicParams.scene;
        } else {
            i17 = i3;
        }
        if ((i16 & 32) != 0) {
            str6 = musicParams.authorUid;
        } else {
            str6 = str3;
        }
        return musicParams.copy(j17, str4, str5, j18, i17, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMId() {
        return this.mId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component5, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getAuthorUid() {
        return this.authorUid;
    }

    @NotNull
    public final MusicParams copy(long id5, @NotNull String mId, @NotNull String name, long startTime, int scene, @NotNull String authorUid) {
        Intrinsics.checkNotNullParameter(mId, "mId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(authorUid, "authorUid");
        return new MusicParams(id5, mId, name, startTime, scene, authorUid);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MusicParams)) {
            return false;
        }
        MusicParams musicParams = (MusicParams) other;
        if (this.id == musicParams.id && Intrinsics.areEqual(this.mId, musicParams.mId) && Intrinsics.areEqual(this.name, musicParams.name) && this.startTime == musicParams.startTime && this.scene == musicParams.scene && Intrinsics.areEqual(this.authorUid, musicParams.authorUid)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAuthorUid() {
        return this.authorUid;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getMId() {
        return this.mId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getScene() {
        return this.scene;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return (((((((((a.a(this.id) * 31) + this.mId.hashCode()) * 31) + this.name.hashCode()) * 31) + a.a(this.startTime)) * 31) + this.scene) * 31) + this.authorUid.hashCode();
    }

    @NotNull
    public String toString() {
        return "MusicParams(id=" + this.id + ", mId=" + this.mId + ", name=" + this.name + ", startTime=" + this.startTime + ", scene=" + this.scene + ", authorUid=" + this.authorUid + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.mId);
        parcel.writeString(this.name);
        parcel.writeLong(this.startTime);
        parcel.writeInt(this.scene);
        parcel.writeString(this.authorUid);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MusicParams(@NotNull Parcel parcel) {
        this(r2, r4, r5, r6, r8, r11 == null ? "" : r11);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        long readLong = parcel.readLong();
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        long readLong2 = parcel.readLong();
        int readInt = parcel.readInt();
        String readString3 = parcel.readString();
    }
}
