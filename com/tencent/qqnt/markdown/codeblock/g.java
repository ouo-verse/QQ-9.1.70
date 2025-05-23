package com.tencent.qqnt.markdown.codeblock;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.markdown.api.IMarkdownCodeBlockConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/markdown/codeblock/g;", "Lst/a;", "", "c", "Landroid/content/Context;", "context", "", IjkMediaMeta.IJKM_KEY_LANGUAGE, "Lcom/tencent/android/androidbypass/codeblock/config/c;", "d", "", "a", "Landroidx/lifecycle/LifecycleOwner;", "b", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class g implements st.a {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // st.a
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return ((IMarkdownCodeBlockConfigApi) QRoute.api(IMarkdownCodeBlockConfigApi.class)).getCodeBlockMaxLineCountInAIO();
    }

    @Override // st.a
    @Nullable
    public LifecycleOwner b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // st.a
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((IMarkdownCodeBlockConfigApi) QRoute.api(IMarkdownCodeBlockConfigApi.class)).isEnableCodeBlockHighlight();
    }

    @Override // st.a
    @NotNull
    public com.tencent.android.androidbypass.codeblock.config.c d(@NotNull Context context, @NotNull String language) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.android.androidbypass.codeblock.config.c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) language);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(language, "language");
        return ((IMarkdownCodeBlockConfigApi) QRoute.api(IMarkdownCodeBlockConfigApi.class)).buildCodeBlockConfigForAIO(context);
    }
}
