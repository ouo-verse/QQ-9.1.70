package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOJumpActionNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOJumpAction;", "Landroid/content/Context;", "context", "", "url", "Lgv3/a;", "aioAbility", "", "doUrlAction", "", "openBrowser", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "preLoadBrowser", "jumpAccountOnlineStateActivity", "isMiniAppUrl", MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "openBrowserWithParam", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOJumpActionNtImpl implements IAIOJumpAction {
    static IPatchRedirector $redirector_;

    public AIOJumpActionNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public boolean doUrlAction(@NotNull Context context, @NotNull String url, @Nullable gv3.a aioAbility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, context, url, aioAbility)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Toast.makeText(context, "doUrlAction " + url, 0).show();
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public boolean isMiniAppUrl(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public void jumpAccountOnlineStateActivity(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            Toast.makeText(context, "jumpAccountOnlineStateActivity", 0).show();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public void openBrowser(@NotNull Context context, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Toast.makeText(context, "openBrowser " + url, 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public void openBrowserDelegate(@NotNull Context context, @NotNull String str, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, str, bundle);
        } else {
            IAIOJumpAction.a.a(this, context, str, bundle);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public void openBrowserWithParam(@NotNull Context context, @NotNull String url, @NotNull Bundle extraData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, url, extraData);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Toast.makeText(context, "openBrowserWithParam " + url, 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public boolean openMiniApp(@NotNull Context context, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Toast.makeText(context, "open mini app", 0).show();
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public void preLoadBrowser(@NotNull BaseQQAppInterface app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) app);
        } else {
            Intrinsics.checkNotNullParameter(app, "app");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public boolean doUrlAction(@NotNull Context context, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        return doUrlAction(context, url, null);
    }
}
