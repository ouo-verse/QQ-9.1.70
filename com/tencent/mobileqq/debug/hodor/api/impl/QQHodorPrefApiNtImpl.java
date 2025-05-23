package com.tencent.mobileqq.debug.hodor.api.impl;

import com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J$\u0010\n\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/debug/hodor/api/impl/QQHodorPrefApiNtImpl;", "Lcom/tencent/mobileqq/debug/hodor/api/IQQHodorPrefApi;", "()V", "collectNetFlowData", "", "url", "", "size", "", "source", "collectPerfInfo", "prefInfo", "", "", "flag", "collectTrackInfo", "trackInfo", "isHodorMode", "", "reportToHodor", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class QQHodorPrefApiNtImpl implements IQQHodorPrefApi {
    static IPatchRedirector $redirector_;

    public QQHodorPrefApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi
    public void collectNetFlowData(@NotNull String url, long size, @NotNull String source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, url, Long.valueOf(size), source);
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(source, "source");
        }
    }

    @Override // com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi
    public void collectPerfInfo(@NotNull Map<String, ? extends Object> prefInfo, @NotNull String flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) prefInfo, (Object) flag);
        } else {
            Intrinsics.checkNotNullParameter(prefInfo, "prefInfo");
            Intrinsics.checkNotNullParameter(flag, "flag");
        }
    }

    @Override // com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi
    public void collectTrackInfo(@NotNull String trackInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) trackInfo);
        } else {
            Intrinsics.checkNotNullParameter(trackInfo, "trackInfo");
        }
    }

    @Override // com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi
    public boolean isHodorMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi
    public void reportToHodor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
