package com.tencent.qqnt.aio.refresher;

import android.graphics.drawable.Drawable;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/at;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "", "mixedBubbleAndTextId", "", "k", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", Const.BUNDLE_KEY_REQUEST, "", "c", tl.h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "helper", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/external/e;)V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class at extends com.tencent.mobileqq.aio.msglist.holder.external.c {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/at$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.refresher.at$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60554);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.e helper) {
        super(helper);
        Intrinsics.checkNotNullParameter(helper, "helper");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) helper);
        }
    }

    private final int k(long mixedBubbleAndTextId) {
        return (int) (mixedBubbleAndTextId & (-1));
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public void c(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        Long longOrNull;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(request instanceof ar)) {
            return;
        }
        QRouteApi api = QRoute.api(IBubbleManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IBubbleManager::class.java)");
        IBubbleManager iBubbleManager = (IBubbleManager) api;
        ar arVar = (ar) request;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(arVar.a());
        if (longOrNull != null) {
            i3 = k(longOrNull.longValue());
        } else {
            i3 = 0;
        }
        if (!iBubbleManager.checkBubbleFile(i3)) {
            return;
        }
        Drawable shootAnimDrawable = iBubbleManager.getShootAnimDrawable(String.valueOf(i3), arVar.c(), arVar.b(), !arVar.g());
        if (shootAnimDrawable == null) {
            return;
        }
        arVar.h(new as(arVar.d(), arVar.f(), new com.tencent.mobileqq.aio.msglist.holder.skin.a(shootAnimDrawable, false, 2, null)));
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.h();
            QLog.i("VasAvatarRefresher", 1, "onDestory");
        }
    }
}
