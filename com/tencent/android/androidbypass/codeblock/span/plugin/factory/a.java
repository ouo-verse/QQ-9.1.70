package com.tencent.android.androidbypass.codeblock.span.plugin.factory;

import com.tencent.android.androidbypass.codeblock.span.plugin.CodeBlockBackgroundPlugin;
import com.tencent.android.androidbypass.codeblock.span.plugin.CodeBlockBottomPlugin;
import com.tencent.android.androidbypass.codeblock.span.plugin.CodeBlockHighlightPlugin;
import com.tencent.android.androidbypass.codeblock.span.plugin.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/android/androidbypass/codeblock/span/plugin/factory/a;", "", "", "pluginId", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/b;", "pluginContext", "Lcom/tencent/android/androidbypass/codeblock/span/plugin/a;", "a", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final a f72030a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14003);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f72030a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.android.androidbypass.codeblock.span.plugin.a a(int pluginId, @NotNull b pluginContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.android.androidbypass.codeblock.span.plugin.a) iPatchRedirector.redirect((short) 1, (Object) this, pluginId, (Object) pluginContext);
        }
        Intrinsics.checkNotNullParameter(pluginContext, "pluginContext");
        if (pluginId != 1) {
            if (pluginId != 2) {
                if (pluginId != 3) {
                    return new CodeBlockBackgroundPlugin(pluginContext);
                }
                return new CodeBlockBottomPlugin(pluginContext);
            }
            return new CodeBlockHighlightPlugin(pluginContext);
        }
        return new CodeBlockBackgroundPlugin(pluginContext);
    }
}
