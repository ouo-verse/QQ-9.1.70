package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import androidx.core.view.KeyEventDispatcher;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/b;", "Lcom/tencent/mobileqq/webview/swift/w;", "Landroid/os/Bundle;", "bundle", "", "i", "Lcom/tencent/mobileqq/activity/QQBrowserActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/activity/QQBrowserActivity;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends w {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull QQBrowserActivity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.w
    public void i(@Nullable Bundle bundle) {
        mg2.i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        KeyEventDispatcher.Component component = this.f314832h;
        if (component instanceof mg2.i) {
            iVar = (mg2.i) component;
        } else {
            iVar = null;
        }
        if (iVar != null && !iVar.l0()) {
            super.b();
        }
        super.i(bundle);
    }
}
