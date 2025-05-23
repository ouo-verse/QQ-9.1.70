package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation;

import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECExtraJumpInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailGoodsOperateState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderPromoInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000e\u0003\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u0082\u0001\u000e\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "", "a", "I", "viewType", "<init>", "(I)V", "b", "c", "d", "e", "f", "g", h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$g;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$m;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$i;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$l;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$c;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$h;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$d;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$k;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$j;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$a;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$n;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$f;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int viewType;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\b\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000bR\u0014\u0010!\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u000bR\u0017\u0010%\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$d;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "c", "J", "orderCreateTimestampMs", "d", "contactPhone", "e", "Z", "enableShowPayDetail", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "f", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "g", "payTimestampMs", h.F, "orderNoteTitle", "i", "orderNote", "j", "orderNoteFromSeller", "k", "a", "()Z", "showSnapshot", "<init>", "(Ljava/lang/String;JLjava/lang/String;ZLcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$d, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class DetailInfoData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String orderId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final long orderCreateTimestampMs;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String contactPhone;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean enableShowPayDetail;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final PayType payType;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final long payTimestampMs;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        public final String orderNoteTitle;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        public final String orderNote;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        public final String orderNoteFromSeller;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean showSnapshot;

        public /* synthetic */ DetailInfoData(String str, long j3, String str2, boolean z16, PayType payType, long j16, String str3, String str4, String str5, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j3, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? null : payType, (i3 & 32) != 0 ? 0L : j16, str3, str4, (i3 & 256) != 0 ? "" : str5, z17);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShowSnapshot() {
            return this.showSnapshot;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.orderId;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.orderCreateTimestampMs)) * 31;
            String str2 = this.contactPhone;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z16 = this.enableShowPayDetail;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode2 + i3) * 31;
            PayType payType = this.payType;
            int hashCode3 = (((i16 + (payType != null ? payType.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.payTimestampMs)) * 31;
            String str3 = this.orderNoteTitle;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.orderNote;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.orderNoteFromSeller;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            boolean z17 = this.showSnapshot;
            return hashCode6 + (z17 ? 1 : z17 ? 1 : 0);
        }

        public String toString() {
            return "DetailInfoData(orderId=" + this.orderId + ", orderCreateTimestampMs=" + this.orderCreateTimestampMs + ", contactPhone=" + this.contactPhone + ", enableShowPayDetail=" + this.enableShowPayDetail + ", payType=" + this.payType + ", payTimestampMs=" + this.payTimestampMs + ", orderNoteTitle=" + this.orderNoteTitle + ", orderNote=" + this.orderNote + ", orderNoteFromSeller=" + this.orderNoteFromSeller + ", showSnapshot=" + this.showSnapshot + ")";
        }

        public DetailInfoData(String str, long j3, String str2, boolean z16, PayType payType, long j16, String str3, String str4, String str5, boolean z17) {
            super(7, null);
            this.orderId = str;
            this.orderCreateTimestampMs = j3;
            this.contactPhone = str2;
            this.enableShowPayDetail = z16;
            this.payType = payType;
            this.payTimestampMs = j16;
            this.orderNoteTitle = str3;
            this.orderNote = str4;
            this.orderNoteFromSeller = str5;
            this.showSnapshot = z17;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetailInfoData)) {
                return false;
            }
            DetailInfoData detailInfoData = (DetailInfoData) other;
            return Intrinsics.areEqual(this.orderId, detailInfoData.orderId) && this.orderCreateTimestampMs == detailInfoData.orderCreateTimestampMs && Intrinsics.areEqual(this.contactPhone, detailInfoData.contactPhone) && this.enableShowPayDetail == detailInfoData.enableShowPayDetail && Intrinsics.areEqual(this.payType, detailInfoData.payType) && this.payTimestampMs == detailInfoData.payTimestampMs && Intrinsics.areEqual(this.orderNoteTitle, detailInfoData.orderNoteTitle) && Intrinsics.areEqual(this.orderNote, detailInfoData.orderNote) && Intrinsics.areEqual(this.orderNoteFromSeller, detailInfoData.orderNoteFromSeller) && this.showSnapshot == detailInfoData.showSnapshot;
        }
    }

    f(int i3) {
        this.viewType = i3;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$a;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "type", "c", "Ljava/lang/String;", "title", "d", "accountId", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class AccountInfoData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int type;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String title;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String accountId;

        public int hashCode() {
            int i3 = this.type * 31;
            String str = this.title;
            int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.accountId;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "AccountInfoData(type=" + this.type + ", title=" + this.title + ", accountId=" + this.accountId + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AccountInfoData)) {
                return false;
            }
            AccountInfoData accountInfoData = (AccountInfoData) other;
            return this.type == accountInfoData.type && Intrinsics.areEqual(this.title, accountInfoData.title) && Intrinsics.areEqual(this.accountId, accountInfoData.accountId);
        }

        public AccountInfoData(int i3, String str, String str2) {
            super(11, null);
            this.type = i3;
            this.title = str;
            this.accountId = str2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$b;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "title", "c", "content", "d", "storeId", "e", "spuId", "f", "a", "()Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class BulletinInfoData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String content;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String storeId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final String spuId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final String orderId;

        /* renamed from: a, reason: from getter */
        public final String getOrderId() {
            return this.orderId;
        }

        public int hashCode() {
            String str = this.title;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.content;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.storeId;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.spuId;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.orderId;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "BulletinInfoData(title=" + this.title + ", content=" + this.content + ", storeId=" + this.storeId + ", spuId=" + this.spuId + ", orderId=" + this.orderId + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BulletinInfoData)) {
                return false;
            }
            BulletinInfoData bulletinInfoData = (BulletinInfoData) other;
            return Intrinsics.areEqual(this.title, bulletinInfoData.title) && Intrinsics.areEqual(this.content, bulletinInfoData.content) && Intrinsics.areEqual(this.storeId, bulletinInfoData.storeId) && Intrinsics.areEqual(this.spuId, bulletinInfoData.spuId) && Intrinsics.areEqual(this.orderId, bulletinInfoData.orderId);
        }

        public BulletinInfoData(String str, String str2, String str3, String str4, String str5) {
            super(12, null);
            this.title = str;
            this.content = str2;
            this.storeId = str3;
            this.spuId = str4;
            this.orderId = str5;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$c;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$c, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ContactCustomerServiceData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String orderId;

        public int hashCode() {
            String str = this.orderId;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "ContactCustomerServiceData(orderId=" + this.orderId + ")";
        }

        public ContactCustomerServiceData(String str) {
            super(5, null);
            this.orderId = str;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ContactCustomerServiceData) && Intrinsics.areEqual(this.orderId, ((ContactCustomerServiceData) other).orderId);
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$f;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/a;", "b", "Ljava/util/List;", "a", "()Ljava/util/List;", "jumpInfoList", "<init>", "(Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$f, reason: collision with other inner class name and from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ExtraJumpInfoData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<ECExtraJumpInfo> jumpInfoList;

        public final List<ECExtraJumpInfo> a() {
            return this.jumpInfoList;
        }

        public int hashCode() {
            List<ECExtraJumpInfo> list = this.jumpInfoList;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "ExtraJumpInfoData(jumpInfoList=" + this.jumpInfoList + ")";
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ExtraJumpInfoData) && Intrinsics.areEqual(this.jumpInfoList, ((ExtraJumpInfoData) other).jumpInfoList);
            }
            return true;
        }

        public ExtraJumpInfoData(List<ECExtraJumpInfo> list) {
            super(14, null);
            this.jumpInfoList = list;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$g;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "stateKey", "c", "titleTextColor", "d", "Ljava/lang/String;", "stateTitleStr", "e", "stateDescStr", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$g, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class OrderStateData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int stateKey;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int titleTextColor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String stateTitleStr;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final String stateDescStr;

        public int hashCode() {
            int i3 = ((this.stateKey * 31) + this.titleTextColor) * 31;
            String str = this.stateTitleStr;
            int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.stateDescStr;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "OrderStateData(stateKey=" + this.stateKey + ", titleTextColor=" + this.titleTextColor + ", stateTitleStr=" + this.stateTitleStr + ", stateDescStr=" + this.stateDescStr + ")";
        }

        public OrderStateData(int i3, int i16, String str, String str2) {
            super(1, null);
            this.stateKey = i3;
            this.titleTextColor = i16;
            this.stateTitleStr = str;
            this.stateDescStr = str2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OrderStateData)) {
                return false;
            }
            OrderStateData orderStateData = (OrderStateData) other;
            return this.stateKey == orderStateData.stateKey && this.titleTextColor == orderStateData.titleTextColor && Intrinsics.areEqual(this.stateTitleStr, orderStateData.stateTitleStr) && Intrinsics.areEqual(this.stateDescStr, orderStateData.stateDescStr);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0010#\u001a\u00020\b\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0017\u00a8\u0006&"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$h;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "payStateStr", "c", "I", "totalQuantity", "", "d", "J", "orderPrice", "e", "originalPrice", "f", "Z", "showFreight", "g", "freight", "", "Lcom/tencent/ecommerce/biz/orders/common/j;", h.F, "Ljava/util/List;", "a", "()Ljava/util/List;", "promoInfos", "i", "showWarningInCoupon", "<init>", "(Ljava/lang/String;IJJZLjava/lang/String;Ljava/util/List;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$h, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class PriceDetailData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String payStateStr;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int totalQuantity;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final long orderPrice;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final long originalPrice;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean showFreight;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final String freight;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<QShopOrderPromoInfo> promoInfos;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean showWarningInCoupon;

        public final List<QShopOrderPromoInfo> a() {
            return this.promoInfos;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.payStateStr;
            int hashCode = (((((((str != null ? str.hashCode() : 0) * 31) + this.totalQuantity) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.orderPrice)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.originalPrice)) * 31;
            boolean z16 = this.showFreight;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode + i3) * 31;
            String str2 = this.freight;
            int hashCode2 = (i16 + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<QShopOrderPromoInfo> list = this.promoInfos;
            int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z17 = this.showWarningInCoupon;
            return hashCode3 + (z17 ? 1 : z17 ? 1 : 0);
        }

        public String toString() {
            return "PriceDetailData(payStateStr=" + this.payStateStr + ", totalQuantity=" + this.totalQuantity + ", orderPrice=" + this.orderPrice + ", originalPrice=" + this.originalPrice + ", showFreight=" + this.showFreight + ", freight=" + this.freight + ", promoInfos=" + this.promoInfos + ", showWarningInCoupon=" + this.showWarningInCoupon + ")";
        }

        public PriceDetailData(String str, int i3, long j3, long j16, boolean z16, String str2, List<QShopOrderPromoInfo> list, boolean z17) {
            super(6, null);
            this.payStateStr = str;
            this.totalQuantity = i3;
            this.orderPrice = j3;
            this.originalPrice = j16;
            this.showFreight = z16;
            this.freight = str2;
            this.promoInfos = list;
            this.showWarningInCoupon = z17;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PriceDetailData)) {
                return false;
            }
            PriceDetailData priceDetailData = (PriceDetailData) other;
            return Intrinsics.areEqual(this.payStateStr, priceDetailData.payStateStr) && this.totalQuantity == priceDetailData.totalQuantity && this.orderPrice == priceDetailData.orderPrice && this.originalPrice == priceDetailData.originalPrice && this.showFreight == priceDetailData.showFreight && Intrinsics.areEqual(this.freight, priceDetailData.freight) && Intrinsics.areEqual(this.promoInfos, priceDetailData.promoInfos) && this.showWarningInCoupon == priceDetailData.showWarningInCoupon;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$i;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "b", "Ljava/util/List;", "orderSkuInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "c", "orderSpuInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/e;", "d", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/e;", "refundOrAfterSalesState", "e", "Ljava/lang/String;", "deliverMessage", "f", "Z", "showPrice", "g", "isQQVipCard", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/e;Ljava/lang/String;ZZ)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$i, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class QShopGoodsDetailData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<OrderSkuDetail> orderSkuInfo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<OrderSpuDetail> orderSpuInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECOrderDetailGoodsOperateState refundOrAfterSalesState;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final String deliverMessage;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean showPrice;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isQQVipCard;

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<OrderSkuDetail> list = this.orderSkuInfo;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List<OrderSpuDetail> list2 = this.orderSpuInfo;
            int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            ECOrderDetailGoodsOperateState eCOrderDetailGoodsOperateState = this.refundOrAfterSalesState;
            int hashCode3 = (hashCode2 + (eCOrderDetailGoodsOperateState != null ? eCOrderDetailGoodsOperateState.hashCode() : 0)) * 31;
            String str = this.deliverMessage;
            int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
            boolean z16 = this.showPrice;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode4 + i3) * 31;
            boolean z17 = this.isQQVipCard;
            return i16 + (z17 ? 1 : z17 ? 1 : 0);
        }

        public String toString() {
            return "QShopGoodsDetailData(orderSkuInfo=" + this.orderSkuInfo + ", orderSpuInfo=" + this.orderSpuInfo + ", refundOrAfterSalesState=" + this.refundOrAfterSalesState + ", deliverMessage=" + this.deliverMessage + ", showPrice=" + this.showPrice + ", isQQVipCard=" + this.isQQVipCard + ")";
        }

        public QShopGoodsDetailData(List<OrderSkuDetail> list, List<OrderSpuDetail> list2, ECOrderDetailGoodsOperateState eCOrderDetailGoodsOperateState, String str, boolean z16, boolean z17) {
            super(3, null);
            this.orderSkuInfo = list;
            this.orderSpuInfo = list2;
            this.refundOrAfterSalesState = eCOrderDetailGoodsOperateState;
            this.deliverMessage = str;
            this.showPrice = z16;
            this.isQQVipCard = z17;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QShopGoodsDetailData)) {
                return false;
            }
            QShopGoodsDetailData qShopGoodsDetailData = (QShopGoodsDetailData) other;
            return Intrinsics.areEqual(this.orderSkuInfo, qShopGoodsDetailData.orderSkuInfo) && Intrinsics.areEqual(this.orderSpuInfo, qShopGoodsDetailData.orderSpuInfo) && Intrinsics.areEqual(this.refundOrAfterSalesState, qShopGoodsDetailData.refundOrAfterSalesState) && Intrinsics.areEqual(this.deliverMessage, qShopGoodsDetailData.deliverMessage) && this.showPrice == qShopGoodsDetailData.showPrice && this.isQQVipCard == qShopGoodsDetailData.isQQVipCard;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$j;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "id", "c", "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$j, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class RecommendGoodsData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String id;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String data;

        public int hashCode() {
            String str = this.id;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.data;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "RecommendGoodsData(id=" + this.id + ", data=" + this.data + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecommendGoodsData)) {
                return false;
            }
            RecommendGoodsData recommendGoodsData = (RecommendGoodsData) other;
            return Intrinsics.areEqual(this.id, recommendGoodsData.id) && Intrinsics.areEqual(this.data, recommendGoodsData.data);
        }

        public RecommendGoodsData(String str, String str2) {
            super(9, null);
            this.id = str;
            this.data = str2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$l;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "orderSkuInfo", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "orderSpuInfo", "d", "Ljava/lang/String;", "sellerPhoneNum", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$l, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class SampleGoodsDetailData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final OrderSkuDetail orderSkuInfo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final OrderSpuDetail orderSpuInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String sellerPhoneNum;

        public int hashCode() {
            OrderSkuDetail orderSkuDetail = this.orderSkuInfo;
            int hashCode = (orderSkuDetail != null ? orderSkuDetail.hashCode() : 0) * 31;
            OrderSpuDetail orderSpuDetail = this.orderSpuInfo;
            int hashCode2 = (hashCode + (orderSpuDetail != null ? orderSpuDetail.hashCode() : 0)) * 31;
            String str = this.sellerPhoneNum;
            return hashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "SampleGoodsDetailData(orderSkuInfo=" + this.orderSkuInfo + ", orderSpuInfo=" + this.orderSpuInfo + ", sellerPhoneNum=" + this.sellerPhoneNum + ")";
        }

        public SampleGoodsDetailData(OrderSkuDetail orderSkuDetail, OrderSpuDetail orderSpuDetail, String str) {
            super(4, null);
            this.orderSkuInfo = orderSkuDetail;
            this.orderSpuInfo = orderSpuDetail;
            this.sellerPhoneNum = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SampleGoodsDetailData)) {
                return false;
            }
            SampleGoodsDetailData sampleGoodsDetailData = (SampleGoodsDetailData) other;
            return Intrinsics.areEqual(this.orderSkuInfo, sampleGoodsDetailData.orderSkuInfo) && Intrinsics.areEqual(this.orderSpuInfo, sampleGoodsDetailData.orderSpuInfo) && Intrinsics.areEqual(this.sellerPhoneNum, sampleGoodsDetailData.sellerPhoneNum);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\b\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\u001a8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000b\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$m;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Z", "a", "()Z", "showing", "c", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "d", "enableShowLogistics", "Lcom/tencent/ecommerce/biz/orders/common/e;", "e", "Lcom/tencent/ecommerce/biz/orders/common/e;", "logisticsInfo", "f", "enableShowAddress", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "g", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "addressInfo", h.F, "enableModifyAddress", "<init>", "(Ljava/lang/String;ZLcom/tencent/ecommerce/biz/orders/common/e;ZLcom/tencent/ecommerce/biz/orders/address/ECAddress;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$m, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ShippingAndLocationData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean showing;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String orderId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean enableShowLogistics;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final LogisticsInfo logisticsInfo;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean enableShowAddress;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECAddress addressInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean enableModifyAddress;

        /* renamed from: a, reason: from getter */
        public final boolean getShowing() {
            return this.showing;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.orderId;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z16 = this.enableShowLogistics;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode + i3) * 31;
            LogisticsInfo logisticsInfo = this.logisticsInfo;
            int hashCode2 = (i16 + (logisticsInfo != null ? logisticsInfo.hashCode() : 0)) * 31;
            boolean z17 = this.enableShowAddress;
            int i17 = z17;
            if (z17 != 0) {
                i17 = 1;
            }
            int i18 = (hashCode2 + i17) * 31;
            ECAddress eCAddress = this.addressInfo;
            int hashCode3 = (i18 + (eCAddress != null ? eCAddress.hashCode() : 0)) * 31;
            boolean z18 = this.enableModifyAddress;
            return hashCode3 + (z18 ? 1 : z18 ? 1 : 0);
        }

        public String toString() {
            return "ShippingAndLocationData(orderId=" + this.orderId + ", enableShowLogistics=" + this.enableShowLogistics + ", logisticsInfo=" + this.logisticsInfo + ", enableShowAddress=" + this.enableShowAddress + ", addressInfo=" + this.addressInfo + ", enableModifyAddress=" + this.enableModifyAddress + ")";
        }

        public ShippingAndLocationData(String str, boolean z16, LogisticsInfo logisticsInfo, boolean z17, ECAddress eCAddress, boolean z18) {
            super(2, null);
            this.orderId = str;
            this.enableShowLogistics = z16;
            this.logisticsInfo = logisticsInfo;
            this.enableShowAddress = z17;
            this.addressInfo = eCAddress;
            this.enableModifyAddress = z18;
            this.showing = z16 || z17;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShippingAndLocationData)) {
                return false;
            }
            ShippingAndLocationData shippingAndLocationData = (ShippingAndLocationData) other;
            return Intrinsics.areEqual(this.orderId, shippingAndLocationData.orderId) && this.enableShowLogistics == shippingAndLocationData.enableShowLogistics && Intrinsics.areEqual(this.logisticsInfo, shippingAndLocationData.logisticsInfo) && this.enableShowAddress == shippingAndLocationData.enableShowAddress && Intrinsics.areEqual(this.addressInfo, shippingAndLocationData.addressInfo) && this.enableModifyAddress == shippingAndLocationData.enableModifyAddress;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u000b0\n\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R!\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$n;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/TicketIdentifier;", "b", "Ljava/util/List;", "a", "()Ljava/util/List;", "tickets", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "detail", "<init>", "(Ljava/util/List;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f$n, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class TicketInfoData extends f {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<String> tickets;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final TicketDetail detail;

        public final List<String> a() {
            return this.tickets;
        }

        public int hashCode() {
            List<String> list = this.tickets;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            TicketDetail ticketDetail = this.detail;
            return hashCode + (ticketDetail != null ? ticketDetail.hashCode() : 0);
        }

        public String toString() {
            return "TicketInfoData(tickets=" + this.tickets + ", detail=" + this.detail + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TicketInfoData)) {
                return false;
            }
            TicketInfoData ticketInfoData = (TicketInfoData) other;
            return Intrinsics.areEqual(this.tickets, ticketInfoData.tickets) && Intrinsics.areEqual(this.detail, ticketInfoData.detail);
        }

        public TicketInfoData(List<String> list, TicketDetail ticketDetail) {
            super(13, null);
            this.tickets = list;
            this.detail = ticketDetail;
        }
    }

    public /* synthetic */ f(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e extends f {

        /* renamed from: b, reason: collision with root package name */
        public static final e f103256b = new e();

        e() {
            super(10, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$k;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k extends f {

        /* renamed from: b, reason: collision with root package name */
        public static final k f103278b = new k();

        k() {
            super(8, null);
        }
    }
}
