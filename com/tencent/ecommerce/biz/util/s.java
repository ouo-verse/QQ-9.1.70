package com.tencent.ecommerce.biz.util;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class s {
    public static final int a(String str, int i3) {
        if (str == null) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i3;
        }
    }
}
