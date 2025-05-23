package com.tencent.qqnt.multi;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.SplashAIOFragment;
import com.tencent.qqnt.aio.activity.MultiDetailDelegate;
import com.tencent.qqnt.aio.activity.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/multi/MultiforwardFragment;", "Lcom/tencent/qqnt/aio/SplashAIOFragment;", "", "type", "Lcom/tencent/qqnt/aio/activity/j;", "Ch", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MultiforwardFragment extends SplashAIOFragment {
    static IPatchRedirector $redirector_;

    public MultiforwardFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.SplashAIOFragment
    @NotNull
    protected j Ch(@NotNull String type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (j) iPatchRedirector.redirect((short) 2, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        return new MultiDetailDelegate(this);
    }
}
