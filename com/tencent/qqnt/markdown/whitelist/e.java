package com.tencent.qqnt.markdown.whitelist;

import android.os.Bundle;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J:\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/markdown/whitelist/e;", "Ltt/a;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", "originUrl", "innerUrl", "altText", "", "elementType", "Landroid/os/Bundle;", "args", "", "a", "Ltt/a;", "delegate", "<init>", "(Ltt/a;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e implements tt.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final tt.a delegate;

    public e(@NotNull tt.a delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) delegate);
        } else {
            this.delegate = delegate;
        }
    }

    @Override // tt.a
    public void a(@Nullable View widget, @NotNull String originUrl, @NotNull String innerUrl, @NotNull String altText, int elementType, @NotNull Bundle args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, widget, originUrl, innerUrl, altText, Integer.valueOf(elementType), args);
            return;
        }
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Intrinsics.checkNotNullParameter(innerUrl, "innerUrl");
        Intrinsics.checkNotNullParameter(altText, "altText");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!((IMarkdownConfigApi) QRoute.api(IMarkdownConfigApi.class)).isWhiteListScheme(innerUrl, true)) {
            b.b();
        } else {
            this.delegate.a(widget, originUrl, innerUrl, altText, elementType, args);
        }
    }
}
