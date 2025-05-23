package com.tencent.qqnt.compress.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.compress.api.IVideoManagerConfigApi;
import com.tencent.qqnt.compress.video.config.a;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/compress/api/impl/VideoManagerConfigApiNtImpl;", "Lcom/tencent/qqnt/compress/api/IVideoManagerConfigApi;", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/compress/video/config/a$a;", "getConfig", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class VideoManagerConfigApiNtImpl implements IVideoManagerConfigApi {
    static IPatchRedirector $redirector_;

    public VideoManagerConfigApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.compress.api.IVideoManagerConfigApi
    @NotNull
    public a.C9606a getConfig(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a.C9606a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        return new a.C9606a(0, 0.0d, 0.0d, 0L, 0L, 0L, 0, 127, null);
    }
}
