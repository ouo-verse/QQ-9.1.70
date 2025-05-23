package com.tencent.mobileqq.qwallet.pay;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u0000 12\u00020\u0001:\u0002\u001c2Bk\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\"\u001a\u0004\u0018\u00010\t\u0012\b\u0010%\u001a\u0004\u0018\u00010\t\u0012\b\u0010'\u001a\u0004\u0018\u00010\t\u0012\b\u0010*\u001a\u0004\u0018\u00010\t\u0012\b\u0010-\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b.\u0010/B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b.\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0019\u0010\"\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R\u0019\u0010%\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013R\u0019\u0010'\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010*\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013R\u0019\u0010-\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010\u0013\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/FinanceAdInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "e", "getTitle", "title", "f", "g", QQWinkConstants.TAB_SUBTITLE, tl.h.F, "a", "banner", "i", "icon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "brand", BdhLogUtil.LogTag.Tag_Conn, "c", TuxUIConstants.POP_BTN_TEXT, "D", "btnUrl", "E", "j", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, UserInfo.SEX_FEMALE, "getExtInfo", "extInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "EnumAdType", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class FinanceAdInfo implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @Nullable
    private final String btnText;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @Nullable
    private final String btnUrl;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @Nullable
    private final String traceInfo;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @Nullable
    private final String extInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String title;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String subTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String banner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String icon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String brand;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/FinanceAdInfo$EnumAdType;", "", "(Ljava/lang/String;I)V", "NONE", "AMS", "FINANCE", "OP", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum EnumAdType {
        NONE,
        AMS,
        FINANCE,
        OP
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/FinanceAdInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qwallet/pay/FinanceAdInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qwallet/pay/FinanceAdInfo;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pay.FinanceAdInfo$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion implements Parcelable.Creator<FinanceAdInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FinanceAdInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FinanceAdInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FinanceAdInfo[] newArray(int size) {
            return new FinanceAdInfo[size];
        }

        Companion() {
        }
    }

    public FinanceAdInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        this.id = str;
        this.title = str2;
        this.subTitle = str3;
        this.banner = str4;
        this.icon = str5;
        this.brand = str6;
        this.btnText = str7;
        this.btnUrl = str8;
        this.traceInfo = str9;
        this.extInfo = str10;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getBanner() {
        return this.banner;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getBtnText() {
        return this.btnText;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getBtnUrl() {
        return this.btnUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinanceAdInfo)) {
            return false;
        }
        FinanceAdInfo financeAdInfo = (FinanceAdInfo) other;
        if (Intrinsics.areEqual(this.id, financeAdInfo.id) && Intrinsics.areEqual(this.title, financeAdInfo.title) && Intrinsics.areEqual(this.subTitle, financeAdInfo.subTitle) && Intrinsics.areEqual(this.banner, financeAdInfo.banner) && Intrinsics.areEqual(this.icon, financeAdInfo.icon) && Intrinsics.areEqual(this.brand, financeAdInfo.brand) && Intrinsics.areEqual(this.btnText, financeAdInfo.btnText) && Intrinsics.areEqual(this.btnUrl, financeAdInfo.btnUrl) && Intrinsics.areEqual(this.traceInfo, financeAdInfo.traceInfo) && Intrinsics.areEqual(this.extInfo, financeAdInfo.extInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        String str = this.id;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.title;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.subTitle;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.banner;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.icon;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str6 = this.brand;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str7 = this.btnText;
        if (str7 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str7.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        String str8 = this.btnUrl;
        if (str8 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str8.hashCode();
        }
        int i29 = (i28 + hashCode8) * 31;
        String str9 = this.traceInfo;
        if (str9 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str9.hashCode();
        }
        int i36 = (i29 + hashCode9) * 31;
        String str10 = this.extInfo;
        if (str10 != null) {
            i3 = str10.hashCode();
        }
        return i36 + i3;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getTraceInfo() {
        return this.traceInfo;
    }

    @NotNull
    public String toString() {
        return "FinanceAdInfo(id=" + this.id + ", title=" + this.title + ", subTitle=" + this.subTitle + ", banner=" + this.banner + ", icon=" + this.icon + ", brand=" + this.brand + ", btnText=" + this.btnText + ", btnUrl=" + this.btnUrl + ", traceInfo=" + this.traceInfo + ", extInfo=" + this.extInfo + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.banner);
        parcel.writeString(this.icon);
        parcel.writeString(this.brand);
        parcel.writeString(this.btnText);
        parcel.writeString(this.btnUrl);
        parcel.writeString(this.traceInfo);
        parcel.writeString(this.extInfo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FinanceAdInfo(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
