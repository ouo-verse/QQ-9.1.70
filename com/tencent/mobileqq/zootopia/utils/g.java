package com.tencent.mobileqq.zootopia.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.ba;
import uv4.bc;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\r\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\r\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0014\u00a8\u0006\u0016"}, d2 = {"Lpv4/k;", "", "j", DownloadInfo.spKey_Config, "c", "Lpv4/j;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "", "a", tl.h.F, "Luv4/ba;", "f", "Luv4/bc;", "", "e", "g", "Lqu4/h;", "key", "d", "Ldw4/b;", "i", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g {
    public static final void a(pv4.j jVar, pv4.j item) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        jVar.f427619b = item.f427619b;
        jVar.f427618a = item.f427618a;
        jVar.f427620c = item.f427620c;
        jVar.f427623f = item.f427623f;
        jVar.f427621d = item.f427621d;
        jVar.f427622e = item.f427622e;
    }

    public static final boolean b(pv4.j jVar, pv4.j item) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        return Intrinsics.areEqual(jVar.f427619b, item.f427619b) && jVar.f427618a == item.f427618a;
    }

    public static final boolean c(pv4.k kVar, pv4.k config) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        return kVar.f427625a == config.f427625a && kVar.f427627c == config.f427627c;
    }

    public static final boolean d(qu4.h hVar, qu4.h hVar2) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        if (Intrinsics.areEqual(hVar2 != null ? hVar2.f429598b : null, hVar.f429598b)) {
            if (Intrinsics.areEqual(hVar2 != null ? hVar2.f429599c : null, hVar.f429599c)) {
                return true;
            }
        }
        return false;
    }

    public static final int e(bc bcVar) {
        Intrinsics.checkNotNullParameter(bcVar, "<this>");
        int i3 = bcVar.f440315d;
        return i3 > 0 ? i3 : bcVar.f440313b;
    }

    public static final boolean f(ba baVar) {
        Intrinsics.checkNotNullParameter(baVar, "<this>");
        return !TextUtils.isEmpty(baVar.f440302c) || baVar.f440306g;
    }

    public static final boolean g(bc bcVar) {
        Intrinsics.checkNotNullParameter(bcVar, "<this>");
        int i3 = bcVar.f440312a;
        return i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4;
    }

    public static final boolean h(pv4.j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        return jVar.f427618a == 1;
    }

    public static final boolean i(dw4.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        return (bVar.f395115b == null || bVar.f395117d == null || bVar.f395118e == null || bVar.f395121h == null || bVar.f395119f == null || bVar.f395122i == null || bVar.f395120g == null) ? false : true;
    }

    public static final boolean j(pv4.k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        return kVar.f427625a == 1 && kVar.f427627c == 0;
    }
}
