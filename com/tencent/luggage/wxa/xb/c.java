package com.tencent.luggage.wxa.xb;

import com.tencent.luggage.wxa.ka.f;
import com.tencent.luggage.wxa.ka.i;
import com.tencent.luggage.wxa.va.e;
import com.tencent.mm.msgsubscription.voice.MsgSubscriptionVoicePlayHelperMM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/luggage/wxa/xb/c;", "Lcom/tencent/luggage/wxa/ka/f;", "Lcom/tencent/luggage/wxa/xb/b;", "Lcom/tencent/luggage/wxa/va/e;", "data", "Lcom/tencent/luggage/wxa/ka/i;", "callback", "", "a", "<init>", "()V", "wxbiz-msgsubscription-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class c implements f {
    @Override // com.tencent.luggage.wxa.ka.f
    public void a(b data, i callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.a() == 0) {
            MsgSubscriptionVoicePlayHelperMM.f151758a.b(data.c(), data.b());
        } else if (data.a() == 1) {
            MsgSubscriptionVoicePlayHelperMM.f151758a.a(data.b());
        }
        if (callback != null) {
            callback.a(new e());
        }
    }
}
