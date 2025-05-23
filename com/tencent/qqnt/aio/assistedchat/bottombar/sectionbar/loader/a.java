package com.tencent.qqnt.aio.assistedchat.bottombar.sectionbar.loader;

import com.tencent.aio.stranger.api.IStrangerAIOAdapterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.h;
import com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor;
import com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.RecommendTopicProcessor;
import com.tencent.qqnt.aio.bottombar.sectionbar.loader.c;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/bottombar/sectionbar/loader/a;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/loader/c;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "Lkotlin/collections/ArrayList;", "a", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "c", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/report/b;", "b", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.loader.c
    @NotNull
    public ArrayList<BottomSectionBarBaseProcessor> a() {
        ArrayList<BottomSectionBarBaseProcessor> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new WriteWhilePolishingProcessor(), new RecommendTopicProcessor());
            arrayListOf.addAll(((IStrangerAIOAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAIOAdapterApi.class)).getExtSectionBarProcessors());
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.loader.c
    @NotNull
    public com.tencent.qqnt.aio.bottombar.sectionbar.report.b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.aio.bottombar.sectionbar.report.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.qqnt.aio.assistedchat.bottombar.sectionbar.report.a();
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.loader.c
    @NotNull
    public ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b> c() {
        ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new h(), new com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.c());
            arrayListOf.addAll(((IStrangerAIOAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAIOAdapterApi.class)).getExtSectionBarAdapters());
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
