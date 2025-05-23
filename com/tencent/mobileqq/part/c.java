package com.tencent.mobileqq.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/part/c;", "Lcom/tencent/biz/richframework/part/PartManager;", "", "e", "c", "b", "d", "a", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "fragment", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "drawer-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c extends PartManager {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull IPartHost fragment, @Nullable View view) {
        super(fragment, view);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment, (Object) view);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        for (Part part : this.mParts.values()) {
            if (part instanceof a) {
                try {
                    ((a) part).onAccountChanged();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        for (Part part : this.mParts.values()) {
            if (part instanceof a) {
                try {
                    ((a) part).z9();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        for (Part part : this.mParts.values()) {
            if (part instanceof a) {
                try {
                    ((a) part).A9();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        for (Part part : this.mParts.values()) {
            if (part instanceof a) {
                try {
                    ((a) part).onPostThemeChanged();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        for (Part part : this.mParts.values()) {
            if (part instanceof a) {
                try {
                    ((a) part).B9();
                } catch (Throwable unused) {
                }
            }
        }
    }
}
