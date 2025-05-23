package com.tenpay.bank.quick;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002)*BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u00c6\u0003JQ\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u00c6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u001dH\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006+"}, d2 = {"Lcom/tenpay/bank/quick/BankItemData;", "Landroid/os/Parcelable;", "name", "", "logoUrl", "bankId", "promotion", "cardTypes", "", "Lcom/tenpay/bank/quick/BankItemData$CardType;", "protoList", "Lcom/tenpay/bank/quick/BankItemData$Proto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getBankId", "()Ljava/lang/String;", "getCardTypes", "()Ljava/util/List;", "getLogoUrl", "getName", "getPromotion", "getProtoList", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "CardType", "Proto", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class BankItemData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BankItemData> CREATOR = new Creator();

    @NotNull
    private final String bankId;

    @NotNull
    private final List<CardType> cardTypes;

    @NotNull
    private final String logoUrl;

    @NotNull
    private final String name;

    @NotNull
    private final String promotion;

    @NotNull
    private final List<Proto> protoList;

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/tenpay/bank/quick/BankItemData$CardType;", "Landroid/os/Parcelable;", "name", "", "bankType", "(Ljava/lang/String;Ljava/lang/String;)V", "getBankType", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class CardType implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<CardType> CREATOR = new Creator();

        @NotNull
        private final String bankType;

        @NotNull
        private final String name;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<CardType> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CardType createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CardType(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CardType[] newArray(int i3) {
                return new CardType[i3];
            }
        }

        public CardType(@NotNull String name, @NotNull String bankType) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bankType, "bankType");
            this.name = name;
            this.bankType = bankType;
        }

        public static /* synthetic */ CardType copy$default(CardType cardType, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = cardType.name;
            }
            if ((i3 & 2) != 0) {
                str2 = cardType.bankType;
            }
            return cardType.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getBankType() {
            return this.bankType;
        }

        @NotNull
        public final CardType copy(@NotNull String name, @NotNull String bankType) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(bankType, "bankType");
            return new CardType(name, bankType);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CardType)) {
                return false;
            }
            CardType cardType = (CardType) other;
            if (Intrinsics.areEqual(this.name, cardType.name) && Intrinsics.areEqual(this.bankType, cardType.bankType)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getBankType() {
            return this.bankType;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.bankType.hashCode();
        }

        @NotNull
        public String toString() {
            return "CardType(name=" + this.name + ", bankType=" + this.bankType + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.name);
            parcel.writeString(this.bankType);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Creator implements Parcelable.Creator<BankItemData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BankItemData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i3 = 0; i3 != readInt; i3++) {
                arrayList.add(CardType.CREATOR.createFromParcel(parcel));
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            for (int i16 = 0; i16 != readInt2; i16++) {
                arrayList2.add(Proto.CREATOR.createFromParcel(parcel));
            }
            return new BankItemData(readString, readString2, readString3, readString4, arrayList, arrayList2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BankItemData[] newArray(int i3) {
            return new BankItemData[i3];
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/tenpay/bank/quick/BankItemData$Proto;", "Landroid/os/Parcelable;", "name", "", "url", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "getVersion", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class Proto implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<Proto> CREATOR = new Creator();

        @NotNull
        private final String name;

        @NotNull
        private final String url;

        @NotNull
        private final String version;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<Proto> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Proto createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Proto(parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Proto[] newArray(int i3) {
                return new Proto[i3];
            }
        }

        public Proto(@NotNull String name, @NotNull String url, @NotNull String version) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(version, "version");
            this.name = name;
            this.url = url;
            this.version = version;
        }

        public static /* synthetic */ Proto copy$default(Proto proto, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = proto.name;
            }
            if ((i3 & 2) != 0) {
                str2 = proto.url;
            }
            if ((i3 & 4) != 0) {
                str3 = proto.version;
            }
            return proto.copy(str, str2, str3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        @NotNull
        public final Proto copy(@NotNull String name, @NotNull String url, @NotNull String version) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(version, "version");
            return new Proto(name, url, version);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Proto)) {
                return false;
            }
            Proto proto = (Proto) other;
            if (Intrinsics.areEqual(this.name, proto.name) && Intrinsics.areEqual(this.url, proto.url) && Intrinsics.areEqual(this.version, proto.version)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.url.hashCode()) * 31) + this.version.hashCode();
        }

        @NotNull
        public String toString() {
            return "Proto(name=" + this.name + ", url=" + this.url + ", version=" + this.version + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.name);
            parcel.writeString(this.url);
            parcel.writeString(this.version);
        }
    }

    public BankItemData(@NotNull String name, @NotNull String logoUrl, @NotNull String bankId, @NotNull String promotion, @NotNull List<CardType> cardTypes, @NotNull List<Proto> protoList) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(bankId, "bankId");
        Intrinsics.checkNotNullParameter(promotion, "promotion");
        Intrinsics.checkNotNullParameter(cardTypes, "cardTypes");
        Intrinsics.checkNotNullParameter(protoList, "protoList");
        this.name = name;
        this.logoUrl = logoUrl;
        this.bankId = bankId;
        this.promotion = promotion;
        this.cardTypes = cardTypes;
        this.protoList = protoList;
    }

    public static /* synthetic */ BankItemData copy$default(BankItemData bankItemData, String str, String str2, String str3, String str4, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bankItemData.name;
        }
        if ((i3 & 2) != 0) {
            str2 = bankItemData.logoUrl;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = bankItemData.bankId;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = bankItemData.promotion;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            list = bankItemData.cardTypes;
        }
        List list3 = list;
        if ((i3 & 32) != 0) {
            list2 = bankItemData.protoList;
        }
        return bankItemData.copy(str, str5, str6, str7, list3, list2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getBankId() {
        return this.bankId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getPromotion() {
        return this.promotion;
    }

    @NotNull
    public final List<CardType> component5() {
        return this.cardTypes;
    }

    @NotNull
    public final List<Proto> component6() {
        return this.protoList;
    }

    @NotNull
    public final BankItemData copy(@NotNull String name, @NotNull String logoUrl, @NotNull String bankId, @NotNull String promotion, @NotNull List<CardType> cardTypes, @NotNull List<Proto> protoList) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        Intrinsics.checkNotNullParameter(bankId, "bankId");
        Intrinsics.checkNotNullParameter(promotion, "promotion");
        Intrinsics.checkNotNullParameter(cardTypes, "cardTypes");
        Intrinsics.checkNotNullParameter(protoList, "protoList");
        return new BankItemData(name, logoUrl, bankId, promotion, cardTypes, protoList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BankItemData)) {
            return false;
        }
        BankItemData bankItemData = (BankItemData) other;
        if (Intrinsics.areEqual(this.name, bankItemData.name) && Intrinsics.areEqual(this.logoUrl, bankItemData.logoUrl) && Intrinsics.areEqual(this.bankId, bankItemData.bankId) && Intrinsics.areEqual(this.promotion, bankItemData.promotion) && Intrinsics.areEqual(this.cardTypes, bankItemData.cardTypes) && Intrinsics.areEqual(this.protoList, bankItemData.protoList)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getBankId() {
        return this.bankId;
    }

    @NotNull
    public final List<CardType> getCardTypes() {
        return this.cardTypes;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPromotion() {
        return this.promotion;
    }

    @NotNull
    public final List<Proto> getProtoList() {
        return this.protoList;
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.logoUrl.hashCode()) * 31) + this.bankId.hashCode()) * 31) + this.promotion.hashCode()) * 31) + this.cardTypes.hashCode()) * 31) + this.protoList.hashCode();
    }

    @NotNull
    public String toString() {
        return "BankItemData(name=" + this.name + ", logoUrl=" + this.logoUrl + ", bankId=" + this.bankId + ", promotion=" + this.promotion + ", cardTypes=" + this.cardTypes + ", protoList=" + this.protoList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.logoUrl);
        parcel.writeString(this.bankId);
        parcel.writeString(this.promotion);
        List<CardType> list = this.cardTypes;
        parcel.writeInt(list.size());
        Iterator<CardType> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        List<Proto> list2 = this.protoList;
        parcel.writeInt(list2.size());
        Iterator<Proto> it5 = list2.iterator();
        while (it5.hasNext()) {
            it5.next().writeToParcel(parcel, flags);
        }
    }
}
