package com.tencent.mobileqq.qwallet.pay.recommend;

import com.tencent.mobileqq.qwallet.pay.AdPositionEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.qqwallet.Mall$CardInfo;
import tencent.im.qqwallet.PaySuccessAd$QpayAd;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0005B\u001b\b\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u0082\u0001\u0002\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "title", "Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;", "Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;", "()Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;", "positionEnum", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;)V", "Lcom/tencent/mobileqq/qwallet/pay/recommend/b$a;", "Lcom/tencent/mobileqq/qwallet/pay/recommend/b$b;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AdPositionEnum positionEnum;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/b$a;", "Lcom/tencent/mobileqq/qwallet/pay/recommend/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ltencent/im/qqwallet/Mall$CardInfo;", "c", "Ltencent/im/qqwallet/Mall$CardInfo;", "()Ltencent/im/qqwallet/Mall$CardInfo;", "cardInfo", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "title", "Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;", "e", "Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;", "a", "()Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;", "positionEnum", "<init>", "(Ltencent/im/qqwallet/Mall$CardInfo;Ljava/lang/String;Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pay.recommend.b$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Card extends b {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Mall$CardInfo cardInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String title;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AdPositionEnum positionEnum;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Card(@Nullable Mall$CardInfo mall$CardInfo, @Nullable String str, @NotNull AdPositionEnum positionEnum) {
            super(str, positionEnum, null);
            Intrinsics.checkNotNullParameter(positionEnum, "positionEnum");
            this.cardInfo = mall$CardInfo;
            this.title = str;
            this.positionEnum = positionEnum;
        }

        @Override // com.tencent.mobileqq.qwallet.pay.recommend.b
        @NotNull
        /* renamed from: a, reason: from getter */
        public AdPositionEnum getPositionEnum() {
            return this.positionEnum;
        }

        @Override // com.tencent.mobileqq.qwallet.pay.recommend.b
        @Nullable
        /* renamed from: b, reason: from getter */
        public String getTitle() {
            return this.title;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Mall$CardInfo getCardInfo() {
            return this.cardInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Card)) {
                return false;
            }
            Card card = (Card) other;
            if (Intrinsics.areEqual(this.cardInfo, card.cardInfo) && Intrinsics.areEqual(getTitle(), card.getTitle()) && getPositionEnum() == card.getPositionEnum()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Mall$CardInfo mall$CardInfo = this.cardInfo;
            int i3 = 0;
            if (mall$CardInfo == null) {
                hashCode = 0;
            } else {
                hashCode = mall$CardInfo.hashCode();
            }
            int i16 = hashCode * 31;
            if (getTitle() != null) {
                i3 = getTitle().hashCode();
            }
            return ((i16 + i3) * 31) + getPositionEnum().hashCode();
        }

        @NotNull
        public String toString() {
            return "Card(cardInfo=" + this.cardInfo + ", title=" + getTitle() + ", positionEnum=" + getPositionEnum() + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/b$b;", "Lcom/tencent/mobileqq/qwallet/pay/recommend/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ltencent/im/qqwallet/PaySuccessAd$QpayAd;", "c", "Ltencent/im/qqwallet/PaySuccessAd$QpayAd;", "()Ltencent/im/qqwallet/PaySuccessAd$QpayAd;", "qpayAd", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "title", "Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;", "e", "Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;", "a", "()Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;", "positionEnum", "<init>", "(Ltencent/im/qqwallet/PaySuccessAd$QpayAd;Ljava/lang/String;Lcom/tencent/mobileqq/qwallet/pay/AdPositionEnum;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pay.recommend.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class OpAd extends b {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final PaySuccessAd$QpayAd qpayAd;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String title;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AdPositionEnum positionEnum;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpAd(@Nullable PaySuccessAd$QpayAd paySuccessAd$QpayAd, @Nullable String str, @NotNull AdPositionEnum positionEnum) {
            super(str, positionEnum, null);
            Intrinsics.checkNotNullParameter(positionEnum, "positionEnum");
            this.qpayAd = paySuccessAd$QpayAd;
            this.title = str;
            this.positionEnum = positionEnum;
        }

        @Override // com.tencent.mobileqq.qwallet.pay.recommend.b
        @NotNull
        /* renamed from: a, reason: from getter */
        public AdPositionEnum getPositionEnum() {
            return this.positionEnum;
        }

        @Override // com.tencent.mobileqq.qwallet.pay.recommend.b
        @Nullable
        /* renamed from: b, reason: from getter */
        public String getTitle() {
            return this.title;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final PaySuccessAd$QpayAd getQpayAd() {
            return this.qpayAd;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpAd)) {
                return false;
            }
            OpAd opAd = (OpAd) other;
            if (Intrinsics.areEqual(this.qpayAd, opAd.qpayAd) && Intrinsics.areEqual(getTitle(), opAd.getTitle()) && getPositionEnum() == opAd.getPositionEnum()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            PaySuccessAd$QpayAd paySuccessAd$QpayAd = this.qpayAd;
            int i3 = 0;
            if (paySuccessAd$QpayAd == null) {
                hashCode = 0;
            } else {
                hashCode = paySuccessAd$QpayAd.hashCode();
            }
            int i16 = hashCode * 31;
            if (getTitle() != null) {
                i3 = getTitle().hashCode();
            }
            return ((i16 + i3) * 31) + getPositionEnum().hashCode();
        }

        @NotNull
        public String toString() {
            return "OpAd(qpayAd=" + this.qpayAd + ", title=" + getTitle() + ", positionEnum=" + getPositionEnum() + ")";
        }
    }

    public /* synthetic */ b(String str, AdPositionEnum adPositionEnum, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, adPositionEnum);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public AdPositionEnum getPositionEnum() {
        return this.positionEnum;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public String getTitle() {
        return this.title;
    }

    b(String str, AdPositionEnum adPositionEnum) {
        this.title = str;
        this.positionEnum = adPositionEnum;
    }
}
