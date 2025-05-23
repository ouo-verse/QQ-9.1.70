package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "url", "e", "f", "token", "successURL", tl.h.F, "c", "protocolText", "i", "b", "moreURL", "", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/GuideParamItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "a", "()Ljava/util/List;", "guideItems", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class ChsiCertificationParams implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ChsiCertificationParams> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String token;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String successURL;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String protocolText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String moreURL;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<GuideParamItem> guideItems;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a implements Parcelable.Creator<ChsiCertificationParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ChsiCertificationParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i3 = 0; i3 != readInt; i3++) {
                arrayList.add(GuideParamItem.CREATOR.createFromParcel(parcel));
            }
            return new ChsiCertificationParams(readString, readString2, readString3, readString4, readString5, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ChsiCertificationParams[] newArray(int i3) {
            return new ChsiCertificationParams[i3];
        }
    }

    public ChsiCertificationParams(@NotNull String url, @NotNull String token, @NotNull String successURL, @Nullable String str, @Nullable String str2, @NotNull List<GuideParamItem> guideItems) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(successURL, "successURL");
        Intrinsics.checkNotNullParameter(guideItems, "guideItems");
        this.url = url;
        this.token = token;
        this.successURL = successURL;
        this.protocolText = str;
        this.moreURL = str2;
        this.guideItems = guideItems;
    }

    @NotNull
    public final List<GuideParamItem> a() {
        return this.guideItems;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getMoreURL() {
        return this.moreURL;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getProtocolText() {
        return this.protocolText;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSuccessURL() {
        return this.successURL;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChsiCertificationParams)) {
            return false;
        }
        ChsiCertificationParams chsiCertificationParams = (ChsiCertificationParams) other;
        if (Intrinsics.areEqual(this.url, chsiCertificationParams.url) && Intrinsics.areEqual(this.token, chsiCertificationParams.token) && Intrinsics.areEqual(this.successURL, chsiCertificationParams.successURL) && Intrinsics.areEqual(this.protocolText, chsiCertificationParams.protocolText) && Intrinsics.areEqual(this.moreURL, chsiCertificationParams.moreURL) && Intrinsics.areEqual(this.guideItems, chsiCertificationParams.guideItems)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.url.hashCode() * 31) + this.token.hashCode()) * 31) + this.successURL.hashCode()) * 31;
        String str = this.protocolText;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str2 = this.moreURL;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((i16 + i3) * 31) + this.guideItems.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChsiCertificationParams(url=" + this.url + ", token=" + this.token + ", successURL=" + this.successURL + ", protocolText=" + this.protocolText + ", moreURL=" + this.moreURL + ", guideItems=" + this.guideItems + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.url);
        parcel.writeString(this.token);
        parcel.writeString(this.successURL);
        parcel.writeString(this.protocolText);
        parcel.writeString(this.moreURL);
        List<GuideParamItem> list = this.guideItems;
        parcel.writeInt(list.size());
        Iterator<GuideParamItem> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }
}
