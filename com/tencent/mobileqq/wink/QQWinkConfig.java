package com.tencent.mobileqq.wink;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.QCircleInitBean;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001\u0013B9\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J;\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000e\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\u001d\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/QQWinkConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "pages", "initPage", "Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;", "mediaPickerInitBean", "Lcom/tencent/mobileqq/wink/picker/Config;", "mediaPickerConfig", "a", "hashCode", "", "other", "", "equals", "d", "Ljava/util/List;", "g", "()Ljava/util/List;", "e", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "c", "()Lcom/tencent/mobileqq/wink/QQWinkPage;", "f", "Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;", "()Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;", tl.h.F, "Lcom/tencent/mobileqq/wink/picker/Config;", "()Lcom/tencent/mobileqq/wink/picker/Config;", "<init>", "(Ljava/util/List;Lcom/tencent/mobileqq/wink/QQWinkPage;Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;Lcom/tencent/mobileqq/wink/picker/Config;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class QQWinkConfig implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<QQWinkPage> pages;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final QQWinkPage initPage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final QCircleInitBean mediaPickerInitBean;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Config mediaPickerConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/QQWinkConfig$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/QQWinkConfig;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/QQWinkConfig;", "<init>", "()V", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.QQWinkConfig$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<QQWinkConfig> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQWinkConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QQWinkConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQWinkConfig[] newArray(int size) {
            return new QQWinkConfig[size];
        }

        Companion() {
        }
    }

    public QQWinkConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QQWinkConfig b(QQWinkConfig qQWinkConfig, List list, QQWinkPage qQWinkPage, QCircleInitBean qCircleInitBean, Config config, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = qQWinkConfig.pages;
        }
        if ((i3 & 2) != 0) {
            qQWinkPage = qQWinkConfig.initPage;
        }
        if ((i3 & 4) != 0) {
            qCircleInitBean = qQWinkConfig.mediaPickerInitBean;
        }
        if ((i3 & 8) != 0) {
            config = qQWinkConfig.mediaPickerConfig;
        }
        return qQWinkConfig.a(list, qQWinkPage, qCircleInitBean, config);
    }

    @NotNull
    public final QQWinkConfig a(@NotNull List<? extends QQWinkPage> pages, @NotNull QQWinkPage initPage, @Nullable QCircleInitBean mediaPickerInitBean, @Nullable Config mediaPickerConfig) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(initPage, "initPage");
        return new QQWinkConfig(pages, initPage, mediaPickerInitBean, mediaPickerConfig);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final QQWinkPage getInitPage() {
        return this.initPage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Config getMediaPickerConfig() {
        return this.mediaPickerConfig;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQWinkConfig)) {
            return false;
        }
        QQWinkConfig qQWinkConfig = (QQWinkConfig) other;
        if (Intrinsics.areEqual(this.pages, qQWinkConfig.pages) && this.initPage == qQWinkConfig.initPage && Intrinsics.areEqual(this.mediaPickerInitBean, qQWinkConfig.mediaPickerInitBean) && Intrinsics.areEqual(this.mediaPickerConfig, qQWinkConfig.mediaPickerConfig)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final QCircleInitBean getMediaPickerInitBean() {
        return this.mediaPickerInitBean;
    }

    @NotNull
    public final List<QQWinkPage> g() {
        return this.pages;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.pages.hashCode() * 31) + this.initPage.hashCode()) * 31;
        QCircleInitBean qCircleInitBean = this.mediaPickerInitBean;
        int i3 = 0;
        if (qCircleInitBean == null) {
            hashCode = 0;
        } else {
            hashCode = qCircleInitBean.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        Config config = this.mediaPickerConfig;
        if (config != null) {
            i3 = config.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "QQWinkConfig(pages=" + this.pages + ", initPage=" + this.initPage + ", mediaPickerInitBean=" + this.mediaPickerInitBean + ", mediaPickerConfig=" + this.mediaPickerConfig + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeTypedList(this.pages);
        this.initPage.writeToParcel(parcel, flags);
        parcel.writeSerializable(this.mediaPickerInitBean);
        parcel.writeSerializable(this.mediaPickerConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QQWinkConfig(@NotNull List<? extends QQWinkPage> pages, @NotNull QQWinkPage initPage, @Nullable QCircleInitBean qCircleInitBean, @Nullable Config config) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(initPage, "initPage");
        this.pages = pages;
        this.initPage = initPage;
        this.mediaPickerInitBean = qCircleInitBean;
        this.mediaPickerConfig = config;
    }

    public /* synthetic */ QQWinkConfig(List list, QQWinkPage qQWinkPage, QCircleInitBean qCircleInitBean, Config config, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new QQWinkPage[]{QQWinkPage.Capture, QQWinkPage.MediaPicker, QQWinkPage.Inspiration}) : list, (i3 & 2) != 0 ? QQWinkPage.MediaPicker : qQWinkPage, (i3 & 4) != 0 ? null : qCircleInitBean, (i3 & 8) != 0 ? null : config);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QQWinkConfig(@NotNull Parcel parcel) {
        this(r1, r0, r2, r6 instanceof Config ? (Config) r6 : null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        QQWinkPage.Companion companion = QQWinkPage.INSTANCE;
        List createTypedArrayList = parcel.createTypedArrayList(companion);
        createTypedArrayList = createTypedArrayList == null ? CollectionsKt__CollectionsKt.emptyList() : createTypedArrayList;
        QQWinkPage createFromParcel = companion.createFromParcel(parcel);
        Serializable readSerializable = parcel.readSerializable();
        QCircleInitBean qCircleInitBean = readSerializable instanceof QCircleInitBean ? (QCircleInitBean) readSerializable : null;
        Serializable readSerializable2 = parcel.readSerializable();
    }
}
