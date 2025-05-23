package com.tencent.qqnt.markdown.click;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import com.qq.e.comm.constants.Constants;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J:\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/markdown/click/a;", "Ltt/a;", "Landroid/content/Context;", "context", "", Constants.KEYS.EXPOSED_CLICK_URL_KEY, "", "c", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "originUrl", "innerUrl", "altText", "", "elementType", "Landroid/os/Bundle;", "args", "", "a", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements tt.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/markdown/click/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.markdown.click.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/markdown/click/a$b", "Ltt/a;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", "originUrl", "innerUrl", "altText", "", "elementType", "Landroid/os/Bundle;", "args", "", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements tt.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // tt.a
        public void a(@Nullable View widget, @NotNull String originUrl, @NotNull String innerUrl, @NotNull String altText, int elementType, @NotNull Bundle args) {
            Context context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, widget, originUrl, innerUrl, altText, Integer.valueOf(elementType), args);
                return;
            }
            Intrinsics.checkNotNullParameter(originUrl, "originUrl");
            Intrinsics.checkNotNullParameter(innerUrl, "innerUrl");
            Intrinsics.checkNotNullParameter(altText, "altText");
            Intrinsics.checkNotNullParameter(args, "args");
            if (widget != null) {
                context = widget.getContext();
            } else {
                context = null;
            }
            if (context != null) {
                a.this.c(context, innerUrl);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31462);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(Context context, String clickUrl) {
        boolean equals;
        boolean z16;
        boolean equals2;
        boolean z17;
        boolean equals3;
        boolean equals4;
        Uri parse = Uri.parse(clickUrl);
        equals = StringsKt__StringsJVMKt.equals("http", parse.getScheme(), true);
        boolean z18 = false;
        if (!equals) {
            equals4 = StringsKt__StringsJVMKt.equals("https", parse.getScheme(), true);
            if (!equals4) {
                z16 = false;
                boolean matches = Patterns.WEB_URL.matcher(clickUrl).matches();
                if (z16 || !matches) {
                    equals2 = StringsKt__StringsJVMKt.equals(SchemaUtils.SCHEMA_MQQAPI, parse.getScheme(), true);
                    if (!equals2) {
                        equals3 = StringsKt__StringsJVMKt.equals("mqqguild", parse.getScheme(), true);
                        if (!equals3) {
                            z17 = false;
                            if (z17) {
                                z18 = ((IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class)).doUrlAction(context, clickUrl);
                            }
                        }
                    }
                    z17 = true;
                    if (z17) {
                    }
                } else {
                    ((IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class)).startUrl(context, clickUrl);
                    z18 = true;
                }
                if (!z18) {
                    QLog.d("DefaultHiddenLinkClickListener", 1, "[handleGenericScheme]: not handle url: " + clickUrl);
                }
                return z18;
            }
        }
        z16 = true;
        boolean matches2 = Patterns.WEB_URL.matcher(clickUrl).matches();
        if (z16) {
        }
        equals2 = StringsKt__StringsJVMKt.equals(SchemaUtils.SCHEMA_MQQAPI, parse.getScheme(), true);
        if (!equals2) {
        }
        z17 = true;
        if (z17) {
        }
        if (!z18) {
        }
        return z18;
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
        ((tt.a) ((IMarkdownConfigApi) QRoute.api(IMarkdownConfigApi.class)).getWhitelistedSchemeClickListener(new b())).a(widget, originUrl, innerUrl, altText, elementType, args);
    }
}
