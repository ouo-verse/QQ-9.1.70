package com.tencent.qqnt.aio.mycomputer.sectionbar.loader;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.bottombar.sectionbar.loader.c;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import com.tencent.qqnt.aio.bottombar.sectionbar.report.b;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/mycomputer/sectionbar/loader/a;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/loader/c;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "Lkotlin/collections/ArrayList;", "a", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "c", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/report/b;", "b", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/aio/mycomputer/sectionbar/loader/a$a", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/report/b;", "Landroid/view/View;", "containerView", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "b", "", "visibility", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.mycomputer.sectionbar.loader.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C9490a implements b {
        static IPatchRedirector $redirector_;

        C9490a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.bottombar.sectionbar.report.b
        public void a(@NotNull View containerView, int visibility) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView, visibility);
            } else {
                Intrinsics.checkNotNullParameter(containerView, "containerView");
            }
        }

        @Override // com.tencent.qqnt.aio.bottombar.sectionbar.report.b
        public void b(@NotNull View containerView, @NotNull com.tencent.aio.api.runtime.a aioContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) containerView, (Object) aioContext);
            } else {
                Intrinsics.checkNotNullParameter(containerView, "containerView");
                Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.loader.c
    @NotNull
    public ArrayList<BottomSectionBarBaseProcessor> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            ArrayList<BottomSectionBarBaseProcessor> arrayList = new ArrayList<>();
            arrayList.addAll(((IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class)).getExtSectionBarProcessors());
            return arrayList;
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.loader.c
    @NotNull
    public b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new C9490a();
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.loader.c
    @NotNull
    public ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        try {
            ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b> arrayList = new ArrayList<>();
            arrayList.addAll(((IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class)).getExtSectionBarAdapters());
            return arrayList;
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }
}
