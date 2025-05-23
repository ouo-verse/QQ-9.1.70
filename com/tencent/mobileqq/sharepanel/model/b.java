package com.tencent.mobileqq.sharepanel.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/model/b;", "", "", "a", "Ljava/lang/String;", "getBizID", "()Ljava/lang/String;", "bizID", "<init>", "(Ljava/lang/String;)V", "Lcom/tencent/mobileqq/sharepanel/model/a;", "Lcom/tencent/mobileqq/sharepanel/model/e;", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String bizID;

    public /* synthetic */ b(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) defaultConstructorMarker);
    }

    b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.bizID = str;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }
}
