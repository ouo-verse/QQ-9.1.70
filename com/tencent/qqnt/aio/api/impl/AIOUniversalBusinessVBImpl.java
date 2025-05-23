package com.tencent.qqnt.aio.api.impl;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.mobileqq.aio.bottombar.GroupAIOBottomBarVB;
import com.tencent.mobileqq.aio.factory.AIOThirdLevelFactory;
import com.tencent.mobileqq.aio.factory.GroupAIOThirdLevelFactory;
import com.tencent.mobileqq.aio.input.AIOInputContainerVB;
import com.tencent.mobileqq.aio.shortcurtbar.AIOShortcutBarVB;
import com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVB;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016J,\u0010\n\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\f\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016J\u0018\u0010\u000e\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u0006\b\u0001\u0012\u00020\r0\u0002H\u0016J\u0018\u0010\u000f\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u0006\b\u0001\u0012\u00020\f0\u0002H\u0016J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\f\u0012\u0006\b\u0001\u0012\u00020\f0\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOUniversalBusinessVBImpl;", "Lcom/tencent/qqnt/aio/api/IAIOUniversalBusinessVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "getInputContainerVB", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "inputAdornApi", "", "enableExpandable", "getInputContainerVBWithAdornApi", "getC2CTempChatAdornApi", "", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "getTitleVB", "getShortcutBarVB", "inputBarAdornApi", "Lcom/tencent/aio/api/factory/f;", "getDefaultBusinessLevel", "getGroupAIOThirdLevelFactory", "getGroupAIOBottomBarVB", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOUniversalBusinessVBImpl implements IAIOUniversalBusinessVB {
    static IPatchRedirector $redirector_;

    public AIOUniversalBusinessVBImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB
    @NotNull
    public com.tencent.mobileqq.aio.input.adorn.a<?> getC2CTempChatAdornApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.input.adorn.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.mobileqq.aio.factory.inputadorn.b();
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB
    @NotNull
    public com.tencent.aio.api.factory.f getDefaultBusinessLevel(@Nullable com.tencent.mobileqq.aio.input.adorn.a<?> inputBarAdornApi) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.aio.api.factory.f) iPatchRedirector.redirect((short) 7, (Object) this, (Object) inputBarAdornApi);
        }
        if (inputBarAdornApi == null) {
            return new AIOThirdLevelFactory(null, 1, null);
        }
        return new AIOThirdLevelFactory(inputBarAdornApi);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB
    @NotNull
    public com.tencent.aio.base.mvvm.a<Object, Object> getGroupAIOBottomBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new GroupAIOBottomBarVB();
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB
    @NotNull
    public com.tencent.aio.api.factory.f getGroupAIOThirdLevelFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.api.factory.f) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new GroupAIOThirdLevelFactory();
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> getInputContainerVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IAIOUniversalBusinessVB.a.a(this, new com.tencent.mobileqq.aio.factory.inputadorn.c(), false, 2, null);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB
    @NotNull
    public com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> getInputContainerVBWithAdornApi(@NotNull com.tencent.mobileqq.aio.input.adorn.a<?> inputAdornApi, boolean enableExpandable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 3, this, inputAdornApi, Boolean.valueOf(enableExpandable));
        }
        Intrinsics.checkNotNullParameter(inputAdornApi, "inputAdornApi");
        return new AIOInputContainerVB(inputAdornApi, enableExpandable);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB
    @NotNull
    public com.tencent.aio.base.mvvm.a<Object, Object> getShortcutBarVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new AIOShortcutBarVB();
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniversalBusinessVB
    @NotNull
    public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> getTitleVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new AIODefaultTitleContainerVB();
    }
}
