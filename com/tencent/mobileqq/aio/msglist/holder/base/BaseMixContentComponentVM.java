package com.tencent.mobileqq.aio.msglist.holder.base;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.aio.msglist.holder.component.marketface.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.adapter.api.IAIOMarketFaceApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/BaseMixContentComponentVM;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$f;", "requestMarketFaceInfo", "", "B", "Lcom/tencent/mobileqq/aio/msglist/holder/component/marketface/c$a;", "intent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/aio/holder/a;", "o", "<init>", "()V", "f", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class BaseMixContentComponentVM extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/BaseMixContentComponentVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponentVM$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59785);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BaseMixContentComponentVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void A(c.a intent) {
        ((IAIOMarketFaceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOMarketFaceApi.class)).enterMarketFacePreview(intent.a(), intent.c(), intent.b());
    }

    private final void B(c.f requestMarketFaceInfo) {
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new BaseMixContentComponentVM$requestMarketFaceInfo$1(requestMarketFaceInfo.b(), this, requestMarketFaceInfo, null), 3, null);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.f) {
            B((c.f) intent);
        } else if (intent instanceof c.a) {
            A((c.a) intent);
        } else {
            super.handleIntent(intent);
        }
    }
}
