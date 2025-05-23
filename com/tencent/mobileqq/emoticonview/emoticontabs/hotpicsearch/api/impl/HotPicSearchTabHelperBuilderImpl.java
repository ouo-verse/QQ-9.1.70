package com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.impl;

import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.HotPicSearchTabHelper;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabHelperBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/emoticontabs/hotpicsearch/api/impl/HotPicSearchTabHelperBuilderImpl;", "Lcom/tencent/mobileqq/emoticonview/emoticontabs/hotpicsearch/api/IHotPicSearchTabHelperBuilder;", "()V", "build", "Lcom/tencent/mobileqq/emoticonview/AbsEmoticonPanelLifecycleObserver;", "providerID", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class HotPicSearchTabHelperBuilderImpl implements IHotPicSearchTabHelperBuilder {
    static IPatchRedirector $redirector_;

    public HotPicSearchTabHelperBuilderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabHelperBuilder
    @NotNull
    public AbsEmoticonPanelLifecycleObserver build(int providerID) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbsEmoticonPanelLifecycleObserver) iPatchRedirector.redirect((short) 2, (Object) this, providerID);
        }
        return new HotPicSearchTabHelper(providerID);
    }
}
