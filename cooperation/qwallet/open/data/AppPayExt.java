package cooperation.qwallet.open.data;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b15.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.openpay.data.pay.PayApiV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001&BO\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015\u00a8\u0006,"}, d2 = {"Lcooperation/qwallet/open/data/AppPayExt;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setInPackageName", "(Ljava/lang/String;)V", "inPackageName", "f", "setQqSign", "qqSign", "g", "setQqSignType", "qqSignType", h.F, "c", "setHostPackageName", "hostPackageName", "i", "b", "setApkVersion", "apkVersion", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "setApkFingerPrint", "apkFingerPrint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final /* data */ class AppPayExt implements Parcelable {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<AppPayExt> CREATOR = new b();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String inPackageName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String qqSign;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String qqSignType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String hostPackageName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String apkVersion;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String apkFingerPrint;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcooperation/qwallet/open/data/AppPayExt$a;", "", "Landroid/content/Intent;", "intent", "", "c", "Landroid/content/Context;", "context", "Lcooperation/qwallet/open/data/AppPayExt;", "a", "Lcom/tencent/mobileqq/openpay/data/pay/PayApiV2;", "payApiV2", "b", "KEY_HOST_PACKAGE_NAME", "Ljava/lang/String;", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cooperation.qwallet.open.data.AppPayExt$a, reason: from kotlin metadata */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final AppPayExt a(@NotNull Context context, @Nullable Intent intent) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(context, "context");
            String c16 = c(intent);
            Pair<String, String> a16 = a.f27745a.a(context, c16);
            String str3 = null;
            String str4 = null;
            String str5 = null;
            if (a16 != null) {
                str = a16.getFirst();
            } else {
                str = null;
            }
            if (a16 != null) {
                str2 = a16.getSecond();
            } else {
                str2 = null;
            }
            return new AppPayExt(str3, str4, str5, c16, str, str2, 7, null);
        }

        @JvmStatic
        @NotNull
        public final AppPayExt b(@NotNull Context context, @Nullable Intent intent, @NotNull PayApiV2 payApiV2) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(payApiV2, "payApiV2");
            String c16 = c(intent);
            Pair<String, String> a16 = a.f27745a.a(context, c16);
            String str3 = payApiV2.packageName;
            String str4 = payApiV2.qqSign;
            String str5 = payApiV2.qqSignType;
            if (a16 != null) {
                str = a16.getFirst();
            } else {
                str = null;
            }
            if (a16 != null) {
                str2 = a16.getSecond();
            } else {
                str2 = null;
            }
            return new AppPayExt(str3, str4, str5, c16, str, str2);
        }

        @JvmStatic
        @Nullable
        public final String c(@Nullable Intent intent) {
            Bundle extras;
            if (intent != null && (extras = intent.getExtras()) != null) {
                return extras.getString("_mqqpay_payapi_packageName");
            }
            return null;
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class b implements Parcelable.Creator<AppPayExt> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppPayExt createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AppPayExt(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AppPayExt[] newArray(int i3) {
            return new AppPayExt[i3];
        }
    }

    public AppPayExt() {
        this(null, null, null, null, null, null, 63, null);
    }

    @JvmStatic
    @Nullable
    public static final String j(@Nullable Intent intent) {
        return INSTANCE.c(intent);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getApkFingerPrint() {
        return this.apkFingerPrint;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getApkVersion() {
        return this.apkVersion;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getHostPackageName() {
        return this.hostPackageName;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getInPackageName() {
        return this.inPackageName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppPayExt)) {
            return false;
        }
        AppPayExt appPayExt = (AppPayExt) other;
        if (Intrinsics.areEqual(this.inPackageName, appPayExt.inPackageName) && Intrinsics.areEqual(this.qqSign, appPayExt.qqSign) && Intrinsics.areEqual(this.qqSignType, appPayExt.qqSignType) && Intrinsics.areEqual(this.hostPackageName, appPayExt.hostPackageName) && Intrinsics.areEqual(this.apkVersion, appPayExt.apkVersion) && Intrinsics.areEqual(this.apkFingerPrint, appPayExt.apkFingerPrint)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getQqSign() {
        return this.qqSign;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getQqSignType() {
        return this.qqSignType;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        String str = this.inPackageName;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.qqSign;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.qqSignType;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.hostPackageName;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.apkVersion;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str6 = this.apkFingerPrint;
        if (str6 != null) {
            i3 = str6.hashCode();
        }
        return i26 + i3;
    }

    @NotNull
    public String toString() {
        return "AppPayExt(inPackageName=" + this.inPackageName + ", qqSign=" + this.qqSign + ", qqSignType=" + this.qqSignType + ", hostPackageName=" + this.hostPackageName + ", apkVersion=" + this.apkVersion + ", apkFingerPrint=" + this.apkFingerPrint + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.inPackageName);
        parcel.writeString(this.qqSign);
        parcel.writeString(this.qqSignType);
        parcel.writeString(this.hostPackageName);
        parcel.writeString(this.apkVersion);
        parcel.writeString(this.apkFingerPrint);
    }

    public AppPayExt(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.inPackageName = str;
        this.qqSign = str2;
        this.qqSignType = str3;
        this.hostPackageName = str4;
        this.apkVersion = str5;
        this.apkFingerPrint = str6;
    }

    public /* synthetic */ AppPayExt(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? null : str6);
    }
}
