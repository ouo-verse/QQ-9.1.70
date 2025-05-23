package com.tencent.mobileqq.pic.api.impl;

import com.tencent.libra.request.Option;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/pic/option/a;", "Lcom/tencent/libra/request/Option;", "b", "pic_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Option b(com.tencent.mobileqq.pic.option.a aVar) {
        Option requestHeight = new Option().setUrl(aVar.d()).setLocalPath(aVar.d()).setTargetView(aVar.c()).setPredecode(aVar.b()).setRequestWidth(aVar.e()).setRequestHeight(aVar.a());
        Intrinsics.checkNotNullExpressionValue(requestHeight, "Option().setUrl(url)\n   \u2026.setRequestHeight(height)");
        return requestHeight;
    }
}
