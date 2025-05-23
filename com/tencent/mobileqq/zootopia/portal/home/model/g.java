package com.tencent.mobileqq.zootopia.portal.home.model;

import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zb3.ZootopiaSameStyleData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "msg", "", "a", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g {
    public static final int a(Object msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2 instanceof ZootopiaMapSimpleInfo) {
            return 1;
        }
        if (msg2 instanceof ZootopiaSameStyleData) {
            return 3;
        }
        return msg2 instanceof zb3.c ? 2 : 1;
    }
}
