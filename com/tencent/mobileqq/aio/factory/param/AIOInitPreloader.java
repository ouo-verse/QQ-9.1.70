package com.tencent.mobileqq.aio.factory.param;

import com.tencent.mobileqq.aio.factory.param.AIOInitPreloader;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.NickBlockInject;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqnt.videoplay.api.view.NTAIOBubbleVideoView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.nick.MemberLevelInfoCache;
import com.tencent.qqnt.aio.refresher.an;
import com.tencent.qqnt.pluspanel.api.IPlusPanelApi;
import com.tencent.superplayer.api.SuperPlayerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0006\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/param/AIOInitPreloader;", "", "", "a", "<init>", "()V", "b", "RunOnceJobs", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOInitPreloader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/param/AIOInitPreloader$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.factory.param.AIOInitPreloader$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/param/AIOInitPreloader$b;", "", "", "a", "", "b", "Z", "videoKitInitialized", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f188800a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static boolean videoKitInitialized;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/factory/param/AIOInitPreloader$b$a", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/g;", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes10.dex */
        public static final class a implements com.tencent.mobileqq.qqnt.videoplay.api.param.g {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.g
            public boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return false;
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45920);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f188800a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (videoKitInitialized) {
                return;
            }
            videoKitInitialized = true;
            try {
                StopWatch i3 = new StopWatch("InitVideoKit", false, 2, null).i();
                com.tencent.mobileqq.qqnt.videoplay.api.param.c cVar = new com.tencent.mobileqq.qqnt.videoplay.api.param.c();
                cVar.t(new a());
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                NTAIOBubbleVideoView nTAIOBubbleVideoView = new NTAIOBubbleVideoView(context);
                BaseApplication context2 = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                nTAIOBubbleVideoView.f(context2, cVar, true, CoroutineScopeKt.MainScope(), null);
                SuperPlayerFactory.createMediaPlayer(BaseApplication.context, 0, SuperPlayerFactory.createPlayerVideoView(BaseApplication.context));
                i3.b("init video kit");
            } catch (Exception e16) {
                QLog.i("InitVideoKit", 1, "[initVideoKit] exc=" + e16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45923);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOInitPreloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            RunOnceJobs.f188797a.w();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\u0007\u001a\u00020\u0005R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/param/AIOInitPreloader$RunOnceJobs;", "", "", "Ljava/lang/Runnable;", "l", "", "v", "w", "", "b", "Z", "hasRun", "c", "Lkotlin/Lazy;", "k", "()Ljava/util/List;", "jobs", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    private static final class RunOnceJobs {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final RunOnceJobs f188797a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static boolean hasRun;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Lazy jobs;

        static {
            Lazy lazy;
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45922);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            f188797a = new RunOnceJobs();
            lazy = LazyKt__LazyJVMKt.lazy(AIOInitPreloader$RunOnceJobs$jobs$2.INSTANCE);
            jobs = lazy;
        }

        RunOnceJobs() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final List<Runnable> k() {
            return (List) jobs.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Runnable> l() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Runnable() { // from class: com.tencent.mobileqq.aio.factory.param.a
                @Override // java.lang.Runnable
                public final void run() {
                    AIOInitPreloader.RunOnceJobs.m();
                }
            });
            arrayList.add(new Runnable() { // from class: com.tencent.mobileqq.aio.factory.param.b
                @Override // java.lang.Runnable
                public final void run() {
                    AIOInitPreloader.RunOnceJobs.n();
                }
            });
            arrayList.add(new Runnable() { // from class: com.tencent.mobileqq.aio.factory.param.c
                @Override // java.lang.Runnable
                public final void run() {
                    AIOInitPreloader.RunOnceJobs.o();
                }
            });
            arrayList.add(new Runnable() { // from class: com.tencent.mobileqq.aio.factory.param.d
                @Override // java.lang.Runnable
                public final void run() {
                    AIOInitPreloader.RunOnceJobs.p();
                }
            });
            arrayList.add(new Runnable() { // from class: com.tencent.mobileqq.aio.factory.param.e
                @Override // java.lang.Runnable
                public final void run() {
                    AIOInitPreloader.RunOnceJobs.q();
                }
            });
            arrayList.add(new Runnable() { // from class: com.tencent.mobileqq.aio.factory.param.f
                @Override // java.lang.Runnable
                public final void run() {
                    AIOInitPreloader.RunOnceJobs.r();
                }
            });
            arrayList.add(new Runnable() { // from class: com.tencent.mobileqq.aio.factory.param.g
                @Override // java.lang.Runnable
                public final void run() {
                    AIOInitPreloader.RunOnceJobs.s();
                }
            });
            arrayList.add(new Runnable() { // from class: com.tencent.mobileqq.aio.factory.param.h
                @Override // java.lang.Runnable
                public final void run() {
                    AIOInitPreloader.RunOnceJobs.t();
                }
            });
            arrayList.add(new Runnable() { // from class: com.tencent.mobileqq.aio.factory.param.i
                @Override // java.lang.Runnable
                public final void run() {
                    AIOInitPreloader.RunOnceJobs.u();
                }
            });
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m() {
            com.tencent.mobileqq.aio.msglist.holder.external.a.f192382a.d(an.f351922a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n() {
            f188797a.v();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o() {
            b.f188800a.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p() {
            NickBlockInject.f191343a.g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q() {
            MemberLevelInfoCache.INSTANCE.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r() {
            com.tencent.mobileqq.aio.msglist.holder.component.avatar.d.f190716a.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s() {
            ((IPlusPanelApi) QRoute.api(IPlusPanelApi.class)).loadAppInfoConfigAsync(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t() {
            com.tencent.qui.quiblurview.c cVar = com.tencent.qui.quiblurview.c.f363628c;
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            cVar.b(context);
        }

        private final void v() {
            try {
                Intrinsics.checkNotNull(IVasBusinessManager.class, "null cannot be cast to non-null type java.lang.Class<com.tencent.mobileqq.qroute.QRouteApi>");
                QRoute.api(IVasBusinessManager.class);
            } catch (Exception e16) {
                QLog.i("AIOInitPreloader", 1, "[initVasBusinessManager] exception=" + e16);
            }
        }

        public final void w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (hasRun) {
                    return;
                }
                hasRun = true;
                Iterator<T> it = k().iterator();
                while (it.hasNext()) {
                    ThreadManagerV2.excute((Runnable) it.next(), 16, null, false);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void u() {
        }
    }
}
