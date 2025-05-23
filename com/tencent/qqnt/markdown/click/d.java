package com.tencent.qqnt.markdown.click;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.android.androidbypass.enhance.scheme.matcher.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/markdown/click/d;", "Lcom/tencent/android/androidbypass/parser/api/b;", "", "url", "e", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "", "chatType", "c", "paramName", "newValue", "d", "Lcom/tencent/android/androidbypass/enhance/scheme/matcher/f;", "Lcom/tencent/android/androidbypass/enhance/scheme/matcher/f;", "schemeMatcher", "I", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d implements com.tencent.android.androidbypass.parser.api.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f schemeMatcher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int chatType;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.schemeMatcher = new f();
        }
    }

    private final String e(String url) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "mqqrouter://flash_transfer/open_fileset", false, 2, null);
        if (!startsWith$default) {
            return url;
        }
        return d(url, VRReportDefine$ReportParam.SCENE_TYPE, String.valueOf(this.chatType));
    }

    @Override // com.tencent.android.androidbypass.parser.api.a
    public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, url, parsedResult, clickText)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
        if (!this.schemeMatcher.a(url, parsedResult, clickText) || !((IMarkdownConfigApi) QRoute.api(IMarkdownConfigApi.class)).isWhiteListScheme(url, false)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.android.androidbypass.enhance.j
    public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, clickableSpan, url);
            return;
        }
        if (!b.b(b.f359330a, 0L, 1, null) && view != null && url != null) {
            Context context = view.getContext();
            IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class);
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iAIOJumpAction.doUrlAction(context, e(url));
        }
    }

    public final void c(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, chatType);
        } else {
            this.chatType = chatType;
        }
    }

    @NotNull
    public final String d(@NotNull String url, @NotNull String paramName, @NotNull String newValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, url, paramName, newValue);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        Regex regex = new Regex('(' + paramName + "=)[^&]*");
        if (regex.containsMatchIn(url)) {
            return regex.replace(url, "$1" + newValue);
        }
        return url;
    }
}
