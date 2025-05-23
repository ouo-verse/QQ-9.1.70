package com.tencent.ecommerce.repo.aftersale.common;

import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ServiceItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/common/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "type", "b", "Ljava/lang/String;", "title", "c", "desc", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.aftersale.common.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECAfterSaleServiceInfo {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String desc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/common/a$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr_sample_data/ECSampleData$ServiceItem;", "info", "Lcom/tencent/ecommerce/repo/aftersale/common/a;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.aftersale.common.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECAfterSaleServiceInfo a(ECSampleData$ServiceItem info) {
            return new ECAfterSaleServiceInfo(info.service_type.get(), info.title.get(), info.desc.get());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECAfterSaleServiceInfo(int i3, String str, String str2) {
        this.type = i3;
        this.title = str;
        this.desc = str2;
    }

    public int hashCode() {
        int i3 = this.type * 31;
        String str = this.title;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.desc;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECAfterSaleServiceInfo(type=" + this.type + ", title=" + this.title + ", desc=" + this.desc + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAfterSaleServiceInfo)) {
            return false;
        }
        ECAfterSaleServiceInfo eCAfterSaleServiceInfo = (ECAfterSaleServiceInfo) other;
        return this.type == eCAfterSaleServiceInfo.type && Intrinsics.areEqual(this.title, eCAfterSaleServiceInfo.title) && Intrinsics.areEqual(this.desc, eCAfterSaleServiceInfo.desc);
    }
}
