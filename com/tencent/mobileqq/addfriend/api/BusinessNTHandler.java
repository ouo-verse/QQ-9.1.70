package com.tencent.mobileqq.addfriend.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/addfriend/api/BusinessNTHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "qqaddfriend-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class BusinessNTHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public BusinessNTHandler(@Nullable AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }
}
