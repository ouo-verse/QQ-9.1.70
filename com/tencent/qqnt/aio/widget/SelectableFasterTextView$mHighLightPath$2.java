package com.tencent.qqnt.aio.widget;

import android.graphics.Path;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Path;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
final class SelectableFasterTextView$mHighLightPath$2 extends Lambda implements Function0<Path> {
    static IPatchRedirector $redirector_;
    public static final SelectableFasterTextView$mHighLightPath$2 INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48059);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new SelectableFasterTextView$mHighLightPath$2();
        }
    }

    SelectableFasterTextView$mHighLightPath$2() {
        super(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Path invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new Path() : (Path) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
