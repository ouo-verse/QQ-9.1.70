package com.tencent.mobileqq.aio.api.impl;

import com.tencent.mobileqq.aio.api.IQQTabApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/api/impl/QQTabApiNtImpl;", "Lcom/tencent/mobileqq/aio/api/IQQTabApi;", "", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "", "needReport", "Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "getExpEntity", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QQTabApiNtImpl implements IQQTabApi {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/api/impl/QQTabApiNtImpl$a", "Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "", "experimentGroupId", "", "isExperiment", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements IQQTabApi.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.aio.api.IQQTabApi.a
        public boolean isExperiment(@NotNull String experimentGroupId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) experimentGroupId)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(experimentGroupId, "experimentGroupId");
            return false;
        }
    }

    public QQTabApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.api.IQQTabApi
    @NotNull
    public IQQTabApi.a getExpEntity(@NotNull String expName, boolean needReport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IQQTabApi.a) iPatchRedirector.redirect((short) 2, this, expName, Boolean.valueOf(needReport));
        }
        Intrinsics.checkNotNullParameter(expName, "expName");
        return new a();
    }
}
