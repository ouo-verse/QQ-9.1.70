package com.tencent.ecommerce.biz.comment;

import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "kotlin.jvm.PlatformType", "mediaInfo1", "mediaInfo2", "", "a", "(Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;)I"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a<T> implements Comparator<ECMediaInfo> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f101420d;

    public a(List list) {
        this.f101420d = list;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compare(ECMediaInfo eCMediaInfo, ECMediaInfo eCMediaInfo2) {
        int i3;
        Iterator it = this.f101420d.iterator();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            i3 = -1;
            if (!it.hasNext()) {
                i17 = -1;
                break;
            }
            if (Intrinsics.areEqual((ECMediaInfo) it.next(), eCMediaInfo)) {
                break;
            }
            i17++;
        }
        Iterator it5 = this.f101420d.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            if (Intrinsics.areEqual((ECMediaInfo) it5.next(), eCMediaInfo2)) {
                i3 = i16;
                break;
            }
            i16++;
        }
        return i17 - i3;
    }
}
