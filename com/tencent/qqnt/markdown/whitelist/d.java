package com.tencent.qqnt.markdown.whitelist;

import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u001b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00018\u0001H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/markdown/whitelist/d;", "DispatchContext", "Payload", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "", "a", "(Ljava/lang/Object;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Ljava/lang/Object;)V", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "wrappedListener", "<init>", "(Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d<DispatchContext, Payload> implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<DispatchContext, Payload> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<DispatchContext, Payload> wrappedListener;

    public d(@NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<DispatchContext, Payload> wrappedListener) {
        Intrinsics.checkNotNullParameter(wrappedListener, "wrappedListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) wrappedListener);
        } else {
            this.wrappedListener = wrappedListener;
        }
    }

    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
    public void a(DispatchContext ctx, @NotNull InlineBtnView<DispatchContext, Payload> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable Payload payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, ctx, btnView, btnModel, payload);
            return;
        }
        Intrinsics.checkNotNullParameter(btnView, "btnView");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        if (!((IMarkdownConfigApi) QRoute.api(IMarkdownConfigApi.class)).isWhiteListScheme(btnModel.a().a(), true)) {
            b.b();
        } else {
            this.wrappedListener.a(ctx, btnView, btnModel, payload);
        }
    }
}
