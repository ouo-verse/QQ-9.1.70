package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionExtID;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/UnionExtID;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionExtID;", "toCommon", "toPb", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJson", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonUnionExtIDKt {
    public static final CommonUnionExtID toCommon(UnionExtID unionExtID) {
        CommonUnionExtID commonUnionExtID = new CommonUnionExtID();
        commonUnionExtID.setExtIdType(unionExtID.extIdType);
        Long l3 = unionExtID.numeric;
        commonUnionExtID.setNumeric(l3 != null ? l3.longValue() : 0L);
        commonUnionExtID.setStr(unionExtID.str);
        Long l16 = unionExtID.unsignedNumeric;
        commonUnionExtID.setUnsignedNumeric(l16 != null ? l16.longValue() : 0L);
        return commonUnionExtID;
    }

    public static final e toJson(CommonUnionExtID commonUnionExtID) {
        e eVar = new e();
        eVar.z("extIdType", commonUnionExtID.getExtIdType());
        eVar.z("numeric", Long.valueOf(commonUnionExtID.getNumeric()));
        eVar.z("str", commonUnionExtID.getStr());
        eVar.z("unsignedNumeric", Long.valueOf(commonUnionExtID.getUnsignedNumeric()));
        return eVar;
    }

    public static final UnionExtID toPb(CommonUnionExtID commonUnionExtID) {
        return new UnionExtID(commonUnionExtID.getExtIdType(), Long.valueOf(commonUnionExtID.getNumeric()), commonUnionExtID.getStr(), Long.valueOf(commonUnionExtID.getUnsignedNumeric()));
    }
}
