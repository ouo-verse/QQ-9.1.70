package com.tencent.mobileqq.troop.qrcode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/af;", "Lzv3/a;", "", "a", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "groupId", "Lcom/tencent/biz/qrcode/mgr/d;", "b", "Lcom/tencent/biz/qrcode/mgr/d;", "()Lcom/tencent/biz/qrcode/mgr/d;", "codeData", "<init>", "(Ljava/lang/String;Lcom/tencent/biz/qrcode/mgr/d;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class af implements zv3.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String groupId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.biz.qrcode.mgr.d codeData;

    public af(@Nullable String str, @Nullable com.tencent.biz.qrcode.mgr.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) dVar);
        } else {
            this.groupId = str;
            this.codeData = dVar;
        }
    }

    @Nullable
    public final com.tencent.biz.qrcode.mgr.d a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.biz.qrcode.mgr.d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.codeData;
    }
}
