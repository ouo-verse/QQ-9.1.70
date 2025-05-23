package com.tencent.state.square.flower.data;

import hs4.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ot4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0003\u00a8\u0006\u0005"}, d2 = {"Lot4/b;", "Lcom/tencent/state/square/flower/data/FlowerDisplayData;", "parse", "Lhs4/k;", "Lcom/tencent/state/square/flower/data/MedalData;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FlowerDataConvertersKt {
    public static final FlowerDisplayData parse(b parse) {
        List emptyList;
        List list;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String str = parse.f424044a;
        String str2 = str != null ? str : "";
        String str3 = parse.f424045b;
        String str4 = str3 != null ? str3 : "";
        boolean z16 = parse.f424046c;
        String str5 = parse.f424047d;
        String str6 = str5 != null ? str5 : "";
        int i3 = parse.f424048e;
        int i16 = parse.f424049f;
        k kVar = parse.f424050g;
        MedalData parse2 = kVar != null ? parse(kVar) : null;
        k[] kVarArr = parse.f424051h;
        if (kVarArr == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            ArrayList arrayList = new ArrayList();
            for (k kVar2 : kVarArr) {
                MedalData parse3 = parse(kVar2);
                if (parse3 != null) {
                    arrayList.add(parse3);
                }
            }
            list = arrayList;
        }
        return new FlowerDisplayData(str2, str4, z16, str6, i3, i16, parse2, list);
    }

    public static final MedalData parse(k kVar) {
        int i3;
        if (kVar == null || (i3 = kVar.f406159a) == 0) {
            return null;
        }
        int i16 = kVar.f406160b;
        String str = kVar.f406161c;
        String str2 = str != null ? str : "";
        String str3 = kVar.f406162d;
        String str4 = str3 != null ? str3 : "";
        String str5 = kVar.f406164f;
        String str6 = str5 != null ? str5 : "";
        long j3 = kVar.f406163e;
        String str7 = kVar.f406165g;
        if (str7 == null) {
            str7 = "";
        }
        return new MedalData(i3, i16, str2, str4, str6, j3, str7);
    }
}
