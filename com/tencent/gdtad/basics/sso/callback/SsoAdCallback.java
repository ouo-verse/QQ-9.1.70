package com.tencent.gdtad.basics.sso.callback;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/gdtad/basics/sso/callback/SsoAdCallback;", "", "onRsp", "", "retCode", "", "adRsp", "Ltencent/gdt/access$AdGetRsp;", "msg", "", "qqad-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface SsoAdCallback {
    void onRsp(int retCode, @Nullable access.AdGetRsp adRsp, @Nullable String msg2);
}
