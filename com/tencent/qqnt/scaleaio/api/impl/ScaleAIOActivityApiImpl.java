package com.tencent.qqnt.scaleaio.api.impl;

import com.tencent.mobileqq.activity.ScaleAIOActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.scaleaio.api.IScaleAIOActivityApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/scaleaio/api/impl/ScaleAIOActivityApiImpl;", "Lcom/tencent/qqnt/scaleaio/api/IScaleAIOActivityApi;", "()V", "getScaleAIOActivityClassName", "", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class ScaleAIOActivityApiImpl implements IScaleAIOActivityApi {
    static IPatchRedirector $redirector_;

    public ScaleAIOActivityApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.scaleaio.api.IScaleAIOActivityApi
    @NotNull
    public String getScaleAIOActivityClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String name = ScaleAIOActivity.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "ScaleAIOActivity::class.java.name");
        return name;
    }
}
