package com.tencent.qqnt.chats.data.converter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\u0004\u0005\u0006\u0007\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/data/converter/f;", "", "<init>", "()V", "Lcom/tencent/qqnt/chats/data/converter/a;", "Lcom/tencent/qqnt/chats/data/converter/d;", "Lcom/tencent/qqnt/chats/data/converter/h;", "Lcom/tencent/qqnt/chats/data/converter/i;", "Lcom/tencent/qqnt/chats/data/converter/j;", "Lcom/tencent/qqnt/chats/data/converter/k;", "Lcom/tencent/qqnt/chats/data/converter/l;", "Lcom/tencent/qqnt/chats/data/converter/m;", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class f {
    static IPatchRedirector $redirector_;

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
