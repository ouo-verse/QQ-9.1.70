package com.tencent.mobileqq.wink;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/QQWinkPage;", "", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CREATOR", "a", "Capture", "MediaPicker", "Inspiration", "Live", "AIGC_TEST", "WangZheReport", "MemoryAlbum", "MagicStudio", "ZShow", "TextVideo", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public enum QQWinkPage implements Parcelable {
    Capture("\u62cd\u6444"),
    MediaPicker(QzoneConfig.DefaultValue.DEFAULT_HOME_PAGE_ALBUM_TITLE),
    Inspiration("\u7075\u611f\u5e93\u2728"),
    Live("\u5f00\u76f4\u64ad"),
    AIGC_TEST("AI \u521b\u4f5c"),
    WangZheReport("\u738b\u8005\u6218\u62a5"),
    MemoryAlbum("\u56de\u5fc6\u5f71\u96c6"),
    MagicStudio("\u9b54\u6cd5\u753b\u5ba4"),
    ZShow("\u5fc3\u60c5\u65e5\u8bb0"),
    TextVideo("\u6587\u5b57\u89c6\u9891");


    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String pageName;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/QQWinkPage$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/QQWinkPage;", "<init>", "()V", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.QQWinkPage$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<QQWinkPage> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQWinkPage createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            if (readString == null) {
                readString = "";
            }
            return QQWinkPage.valueOf(readString);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQWinkPage[] newArray(int size) {
            return new QQWinkPage[size];
        }

        Companion() {
        }
    }

    QQWinkPage(String str) {
        this.pageName = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getPageName() {
        return this.pageName;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return "'" + this.pageName + "'";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(name());
    }
}
