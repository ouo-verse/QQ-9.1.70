package com.tencent.mobileqq.leba.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/leba/view/LebaFeedItemPreLoader;", "", "Lcom/tencent/mobileqq/leba/view/f;", "preInflateHelper", "", "d", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "e", "f", "viewGroup", "", "layoutResId", "Landroid/view/View;", "c", "b", "I", "itemLayoutRes", "Lcom/tencent/mobileqq/leba/view/f;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaFeedItemPreLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LebaFeedItemPreLoader f240776a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int itemLayoutRes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static f preInflateHelper;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19392);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f240776a = new LebaFeedItemPreLoader();
            itemLayoutRes = R.layout.gxf;
        }
    }

    LebaFeedItemPreLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final synchronized void d(@NotNull f preInflateHelper2) {
        synchronized (LebaFeedItemPreLoader.class) {
            Intrinsics.checkNotNullParameter(preInflateHelper2, "preInflateHelper");
            preInflateHelper = preInflateHelper2;
        }
    }

    @JvmStatic
    public static final void e(@NotNull final ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (com.tencent.mobileqq.leba.util.a.f240763a.a()) {
            f fVar = preInflateHelper;
            if (fVar != null) {
                fVar.f(rootView, itemLayoutRes, 10, 10);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(rootView) { // from class: com.tencent.mobileqq.leba.view.LebaFeedItemPreLoader$preLoadItems$$inlined$runOnMainThread$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ViewGroup f240779d;

            {
                this.f240779d = rootView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) rootView);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    f fVar2 = LebaFeedItemPreLoader.preInflateHelper;
                    if (fVar2 != null) {
                        fVar2.f(this.f240779d, LebaFeedItemPreLoader.itemLayoutRes, 10, 10);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    @JvmStatic
    public static final synchronized void f(@Nullable f preInflateHelper2) {
        synchronized (LebaFeedItemPreLoader.class) {
            if (Intrinsics.areEqual(preInflateHelper, preInflateHelper2)) {
                preInflateHelper = null;
            }
            QLog.i("LebaFeedItemPreLoader", 1, "release. " + preInflateHelper);
        }
    }

    @NotNull
    public final View c(@NotNull ViewGroup viewGroup, int layoutResId) {
        View c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, layoutResId);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        f fVar = preInflateHelper;
        if (fVar == null || (c16 = fVar.c(viewGroup, layoutResId)) == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(layoutResId, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(viewGroup.context).\u2026tResId, viewGroup, false)");
            return inflate;
        }
        return c16;
    }
}
