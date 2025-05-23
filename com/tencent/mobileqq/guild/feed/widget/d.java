package com.tencent.mobileqq.guild.feed.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes13.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ List a(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
