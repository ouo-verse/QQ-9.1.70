package com.tencent.mobileqq.aio.helper.api.impl;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.helper.StickerRecHelper;
import com.tencent.mobileqq.aio.helper.api.IStickerRecHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/api/impl/StickerRecHelperApiImpl;", "Lcom/tencent/mobileqq/aio/helper/api/IStickerRecHelperApi;", "Lcom/tencent/aio/main/businesshelper/h;", "createLifeCycleHelper", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class StickerRecHelperApiImpl implements IStickerRecHelperApi {
    static IPatchRedirector $redirector_;

    public StickerRecHelperApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.helper.api.IStickerRecHelperApi
    @NotNull
    public h createLifeCycleHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new StickerRecHelper();
    }
}
