package com.tencent.luggage.wxa.n3;

import android.content.Context;
import com.tencent.luggage.ui.WxaAlertActivity;
import com.tencent.luggage.wxa.n3.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/luggage/wxa/n3/r0;", "Lcom/tencent/luggage/wxa/eo/d;", "Lcom/tencent/luggage/wxa/n3/q;", "Landroid/content/Context;", "context", "Lcom/tencent/luggage/wxa/n3/q$a;", "alertInfo", "", "a", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class r0 extends com.tencent.luggage.wxa.eo.d implements q {
    @Override // com.tencent.luggage.wxa.n3.q
    public void a(Context context, q.a alertInfo) {
        Intrinsics.checkNotNullParameter(alertInfo, "alertInfo");
        WxaAlertActivity.INSTANCE.a(context, alertInfo);
    }
}
