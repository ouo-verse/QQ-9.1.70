package com.tencent.nt.adapter.session;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/nt/adapter/session/e;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "a", "base_proj_nt_ext_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {
    @NotNull
    public static final Contact a(@NotNull e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        return new Contact(eVar.a(), eVar.b(), eVar.b());
    }
}
