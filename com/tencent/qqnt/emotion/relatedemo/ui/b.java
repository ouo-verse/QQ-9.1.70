package com.tencent.qqnt.emotion.relatedemo.ui;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.relatedemo.c;
import com.tencent.qqnt.emotion.relatedemo.d;
import com.tencent.qqnt.emotion.relatedemo.logic.NTAIORelatedEmotionPanelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/ui/b;", "Lcom/tencent/qqnt/emotion/relatedemo/c;", "", "a", "Lcom/tencent/aio/api/runtime/a;", "context", "b", "Landroid/content/Context;", "Landroid/content/Context;", "Lcom/tencent/qqnt/emotion/relatedemo/d;", "Lcom/tencent/qqnt/emotion/relatedemo/d;", "vm", "Lww3/a;", "c", "Lww3/a;", "panelProvider", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/emotion/relatedemo/d;)V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d vm;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ww3.a panelProvider;

    public b(@NotNull Context context, @NotNull d vm5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) vm5);
        } else {
            this.context = context;
            this.vm = vm5;
        }
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.panelProvider = new NTAIORelatedEmotionPanelProvider(this.context);
        }
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.c
    public void b(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        d dVar = this.vm;
        ww3.a aVar = this.panelProvider;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelProvider");
            aVar = null;
        }
        dVar.c(context, aVar);
    }
}
