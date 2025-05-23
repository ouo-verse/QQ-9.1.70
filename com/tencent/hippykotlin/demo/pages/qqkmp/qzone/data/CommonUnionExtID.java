package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.ark.ark;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionExtID;", "", "()V", "extIdType", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/UnionExtIDType;", "getExtIdType", "()Ljava/lang/Integer;", "setExtIdType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "numeric", "", "getNumeric", "()J", "setNumeric", "(J)V", "str", "", "getStr", "()Ljava/lang/String;", "setStr", "(Ljava/lang/String;)V", "unsignedNumeric", "getUnsignedNumeric", "setUnsignedNumeric", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonUnionExtID {
    private Integer extIdType;
    private long numeric;
    private String str;
    private long unsignedNumeric;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionExtID$Companion;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", ark.ARKMETADATA_JSON, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionExtID;", "fromJson", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CommonUnionExtID fromJson(e json) {
            CommonUnionExtID commonUnionExtID = new CommonUnionExtID();
            commonUnionExtID.setExtIdType(Integer.valueOf(json.j("extIdType")));
            commonUnionExtID.setNumeric(json.n("numeric"));
            commonUnionExtID.setStr(json.p("str"));
            commonUnionExtID.setUnsignedNumeric(json.n("unsignedNumeric"));
            return commonUnionExtID;
        }

        Companion() {
        }
    }

    public final Integer getExtIdType() {
        return this.extIdType;
    }

    public final long getNumeric() {
        return this.numeric;
    }

    public final String getStr() {
        return this.str;
    }

    public final long getUnsignedNumeric() {
        return this.unsignedNumeric;
    }

    public final void setExtIdType(Integer num) {
        this.extIdType = num;
    }

    public final void setNumeric(long j3) {
        this.numeric = j3;
    }

    public final void setStr(String str) {
        this.str = str;
    }

    public final void setUnsignedNumeric(long j3) {
        this.unsignedNumeric = j3;
    }
}
