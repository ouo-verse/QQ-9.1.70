package com.tencent.aio.stranger.api.impl;

import com.tencent.aio.stranger.api.IStrangerAIOAdapterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB;
import com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/stranger/api/impl/StrangerAIOAdapterApiNtImpl;", "Lcom/tencent/aio/stranger/api/IStrangerAIOAdapterApi;", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "getInputBarAdornApi", "", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "getExtSectionBarAdapters", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "getExtSectionBarProcessors", "getNearbyProExtProcessors", "getNearbyProExtAdapters", "<init>", "()V", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class StrangerAIOAdapterApiNtImpl implements IStrangerAIOAdapterApi {
    static IPatchRedirector $redirector_;

    public StrangerAIOAdapterApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOAdapterApi
    @NotNull
    public List<b> getExtSectionBarAdapters() {
        List<b> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOAdapterApi
    @NotNull
    public List<BottomSectionBarBaseProcessor> getExtSectionBarProcessors() {
        List<BottomSectionBarBaseProcessor> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOAdapterApi
    @NotNull
    public com.tencent.mobileqq.aio.input.adorn.a<?> getInputBarAdornApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ((IAIOUniversalBusinessVB) QRoute.api(IAIOUniversalBusinessVB.class)).getC2CTempChatAdornApi();
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOAdapterApi
    @NotNull
    public List<b> getNearbyProExtAdapters() {
        List<b> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOAdapterApi
    @NotNull
    public List<BottomSectionBarBaseProcessor> getNearbyProExtProcessors() {
        List<BottomSectionBarBaseProcessor> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}
