package com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.impl;

import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.EmoticonTabNtUtils;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.HotPicSearchTabListener;
import com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/emoticontabs/hotpicsearch/api/impl/HotPicSearchTabListenerImpl;", "Lcom/tencent/mobileqq/emoticonview/emoticontabs/hotpicsearch/api/IHotPicSearchTabListener;", "()V", "build", "Lcom/tencent/mobileqq/emoticon/IEmotionTabCreateListener;", "app", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "isMergeHotPicExperiment", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class HotPicSearchTabListenerImpl implements IHotPicSearchTabListener {
    static IPatchRedirector $redirector_;

    public HotPicSearchTabListenerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabListener
    @NotNull
    public IEmotionTabCreateListener build(@Nullable IEmoticonMainPanelApp app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IEmotionTabCreateListener) iPatchRedirector.redirect((short) 2, (Object) this, (Object) app);
        }
        return new HotPicSearchTabListener(app);
    }

    @Override // com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api.IHotPicSearchTabListener
    public boolean isMergeHotPicExperiment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return EmoticonTabNtUtils.INSTANCE.isMergeHotPicExperiment();
    }
}
