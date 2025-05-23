package com.tencent.mobileqq.springhb.preload.res;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/springhb/preload/res/c;", "Lcom/tencent/mobileqq/springhb/interf/b;", "Landroid/graphics/drawable/Drawable;", "b", "", "Ljava/lang/String;", "url", "Landroid/os/Bundle;", "c", "Landroid/os/Bundle;", "bundle", "defaultDrawable", "<init>", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/os/Bundle;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends com.tencent.mobileqq.springhb.interf.b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle bundle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String url, @NotNull Drawable defaultDrawable, @NotNull Bundle bundle) {
        super(defaultDrawable);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(defaultDrawable, "defaultDrawable");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, url, defaultDrawable, bundle);
        } else {
            this.url = url;
            this.bundle = bundle;
        }
    }

    @Override // com.tencent.mobileqq.springhb.interf.b
    @NotNull
    public Drawable b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return a();
        }
        URLDrawable netDrawableForQWallet = QWalletPicHelper.getNetDrawableForQWallet(this.url, a(), a(), this.bundle);
        Intrinsics.checkNotNullExpressionValue(netDrawableForQWallet, "getNetDrawableForQWallet\u2026         bundle\n        )");
        return netDrawableForQWallet;
    }
}
