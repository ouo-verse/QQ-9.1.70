package com.tencent.mobileqq.filebrowser.toogle;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002J\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/toogle/NTFileTransferMgrOpt;", "", "Landroid/content/Intent;", "", "a", "b", "", "Lkotlin/Lazy;", "c", "()Z", "isOptToggle", "<init>", "()V", "qqfile-filebrowser-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class NTFileTransferMgrOpt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NTFileTransferMgrOpt f206055a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isOptToggle;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f206055a = new NTFileTransferMgrOpt();
        lazy = LazyKt__LazyJVMKt.lazy(NTFileTransferMgrOpt$isOptToggle$2.INSTANCE);
        isOptToggle = lazy;
    }

    NTFileTransferMgrOpt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final long[] a(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (long[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return intent.getLongArrayExtra("forward_root_msg_ids");
    }

    @NotNull
    public final long[] b(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (long[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "<this>");
        long longExtra = intent.getLongExtra("forward_cur_msg_id", -1L);
        if (longExtra == -1) {
            return new long[0];
        }
        return new long[]{longExtra};
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((Boolean) isOptToggle.getValue()).booleanValue();
    }
}
