package com.tencent.qqnt.aio.adapter.api.impl;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.popanim.IPopOutEmoticonAnim;
import com.tencent.mobileqq.popanim.NTAioPopOutAnimConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0016J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000eH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPEPanelApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOPEPanelApi;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "checkPEResDownloaded", "", QQSysAndEmojiResInfo.EMO_ID, "Landroid/graphics/drawable/Drawable;", "getAsyncEmoDrawable", "Landroid/graphics/Typeface;", "getTypeFace", "", "isPeResDownloaded", "isTypefaceLoading", "loadFontTypeface", "emoid", "count", "playPokeEmoAnimation", "emoIndex", "playPopEmoAnimation", "flag", "setTypefaceLoading", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOPEPanelApiImpl implements IAIOPEPanelApi {
    static IPatchRedirector $redirector_;

    public AIOPEPanelApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public void checkPEResDownloaded(@NotNull AppRuntime app, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) app, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        com.tencent.mobileqq.poke.f.b(app, aioContext);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    @NotNull
    public Drawable getAsyncEmoDrawable(int emoId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, emoId);
        }
        return com.tencent.mobileqq.poke.c.f258994a.b(emoId);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    @Nullable
    public Typeface getTypeFace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Typeface) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return com.tencent.mobileqq.poke.c.f258994a.g();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public boolean isPeResDownloaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.poke.f.O;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public boolean isTypefaceLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.poke.c.f258994a.f();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public void loadFontTypeface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            com.tencent.mobileqq.poke.c.f258994a.k();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public void playPokeEmoAnimation(@NotNull com.tencent.aio.api.runtime.a aioContext, int emoid, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, aioContext, Integer.valueOf(emoid), Integer.valueOf(count));
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        String j3 = com.tencent.mobileqq.poke.c.f258994a.j(emoid);
        View requireView = aioContext.c().requireView();
        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        ((IPopOutEmoticonAnim) QRoute.api(IPopOutEmoticonAnim.class)).playPokeEmoAnimation((AppInterface) peekAppRuntime, count, (ViewGroup) requireView, j3);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public void playPopEmoAnimation(@NotNull com.tencent.aio.api.runtime.a aioContext, int emoIndex, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, aioContext, Integer.valueOf(emoIndex), Integer.valueOf(count));
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        NTAioPopOutAnimConfig nTAioPopOutAnimConfig = new NTAioPopOutAnimConfig(aioContext);
        View requireView = aioContext.c().requireView();
        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((IPopOutEmoticonAnim) QRoute.api(IPopOutEmoticonAnim.class)).playPopEmoAnimation((ViewGroup) requireView, nTAioPopOutAnimConfig, emoIndex, count);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public void setTypefaceLoading(boolean flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, flag);
        } else {
            com.tencent.mobileqq.poke.c.f258994a.n(flag);
        }
    }
}
