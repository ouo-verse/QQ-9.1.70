package com.tencent.neonlight.clip;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IWinkWeClipApi;
import com.tencent.mobileqq.wink.model.MediaScanForwardResult;
import com.tencent.qphone.base.util.QLog;
import i83.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0086\u0001\u0010\u0012\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022p\u0010\u0011\u001al\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u001b\u0012\u0019\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005J\u0006\u0010\u0013\u001a\u00020\u0010R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/neonlight/clip/a;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "assets", "Lkotlin/Function4;", "Lcom/tencent/neonlight/clip/b;", "Lkotlin/ParameterName;", "name", ForwardMiniChooseFriendOption.RESULT_LIST, "newResult", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "", "isFinished", "", "completion", "b", "a", "Lcom/tencent/mobileqq/wink/api/IWinkWeClipApi;", "Lcom/tencent/mobileqq/wink/api/IWinkWeClipApi;", "winkClipApi", "<init>", "()V", "neonlight-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IWinkWeClipApi winkClipApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/neonlight/clip/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "neonlight-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.neonlight.clip.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/neonlight/clip/a$b", "Li83/c;", "Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult;", "result", "", "a", "", "msg", "onError", "neonlight-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function4<List<com.tencent.neonlight.clip.b>, com.tencent.neonlight.clip.b, Exception, Boolean, Unit> f337890a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<com.tencent.neonlight.clip.b>> f337891b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f337892c;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function4<? super List<com.tencent.neonlight.clip.b>, ? super com.tencent.neonlight.clip.b, ? super Exception, ? super Boolean, Unit> function4, Ref.ObjectRef<List<com.tencent.neonlight.clip.b>> objectRef, a aVar) {
            this.f337890a = function4;
            this.f337891b = objectRef;
            this.f337892c = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, function4, objectRef, aVar);
            }
        }

        @Override // i83.c
        public void a(@NotNull MediaScanForwardResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.isLast()) {
                this.f337890a.invoke(this.f337891b.element, null, null, Boolean.TRUE);
                this.f337892c.a();
            } else {
                com.tencent.neonlight.clip.b bVar = new com.tencent.neonlight.clip.b(result.getPath(), System.currentTimeMillis(), result.getImageFeature());
                this.f337891b.element.add(bVar);
                this.f337890a.invoke(this.f337891b.element, bVar, null, Boolean.FALSE);
            }
        }

        @Override // i83.c
        public void onError(@NotNull String msg2) {
            List<com.tencent.neonlight.clip.b> emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Function4<List<com.tencent.neonlight.clip.b>, com.tencent.neonlight.clip.b, Exception, Boolean, Unit> function4 = this.f337890a;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            function4.invoke(emptyList, null, new Exception(msg2), Boolean.TRUE);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42672);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IWinkWeClipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkWeClipApi::class.java)");
        this.winkClipApi = (IWinkWeClipApi) api;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.winkClipApi.releaseClip();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.util.ArrayList] */
    public final void b(@NotNull List<? extends LocalMediaInfo> assets, @NotNull Function4<? super List<com.tencent.neonlight.clip.b>, ? super com.tencent.neonlight.clip.b, ? super Exception, ? super Boolean, Unit> completion) {
        List emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) assets, (Object) completion);
            return;
        }
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(completion, "completion");
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new ArrayList();
            this.winkClipApi.doClipForward(assets, new b(completion, objectRef, this));
        } catch (Exception e16) {
            QLog.e("NXClipVisualRequest", 1, e16, new Object[0]);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            completion.invoke(emptyList, null, e16, Boolean.TRUE);
        }
    }
}
