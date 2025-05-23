package com.tencent.qqnt.aio.adapter.api.impl;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOPEPanelApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOPEPanelApi;", "", "isPeResDownloaded", "isTypefaceLoading", "flag", "", "setTypefaceLoading", "Landroid/graphics/Typeface;", "getTypeFace", "loadFontTypeface", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "checkPEResDownloaded", "", QQSysAndEmojiResInfo.EMO_ID, "Landroid/graphics/drawable/Drawable;", "getAsyncEmoDrawable", "emoIndex", "count", "playPopEmoAnimation", "emoid", "playPokeEmoAnimation", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOPEPanelApiNtImpl implements IAIOPEPanelApi {
    static IPatchRedirector $redirector_;

    public AIOPEPanelApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public void checkPEResDownloaded(@NotNull AppRuntime app, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) app, (Object) aioContext);
        } else {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    @Nullable
    public Drawable getAsyncEmoDrawable(int emoId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, (Object) this, emoId);
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    @NotNull
    public Typeface getTypeFace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Typeface) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        return DEFAULT;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public boolean isPeResDownloaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public boolean isTypefaceLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public void loadFontTypeface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public void playPokeEmoAnimation(@NotNull com.tencent.aio.api.runtime.a aioContext, int emoid, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, aioContext, Integer.valueOf(emoid), Integer.valueOf(count));
        } else {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public void playPopEmoAnimation(@NotNull com.tencent.aio.api.runtime.a aioContext, int emoIndex, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, aioContext, Integer.valueOf(emoIndex), Integer.valueOf(count));
        } else {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi
    public void setTypefaceLoading(boolean flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, flag);
        }
    }
}
