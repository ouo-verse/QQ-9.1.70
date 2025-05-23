package com.tencent.nativepreview.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/nativepreview/service/b;", "Lcom/tencent/nativepreview/service/IReporter;", "", "tag", "name", "", "time", QCircleWeakNetReporter.KEY_COST, "extraInfo", "", "report", "<init>", "()V", "native_preview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes21.dex */
public final class b implements IReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f337874a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f337874a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.nativepreview.service.IReporter
    public void report(@NotNull String tag, @NotNull String name, long time, long cost, @NotNull String extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, tag, name, Long.valueOf(time), Long.valueOf(cost), extraInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        android.util.Log.i("DefaultReporter", "tag: " + tag + ", name: " + name + ", time: " + time + ", cost: " + cost + ", extra_info: " + extraInfo);
    }
}
