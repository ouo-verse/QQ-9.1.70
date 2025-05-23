package com.tencent.qqnt.aio.nick.api.impl;

import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.chats.api.IChatsConfigRuntimeService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/nick/api/impl/NickNameApiImpl;", "Lcom/tencent/qqnt/aio/nick/api/INickNameApi;", "()V", "getEmotionNickName", "", "name", "emoSize", "", "getPurePlainText", "lengthLimit", "", "measureNickName", "", "remarkPriorityFirst", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class NickNameApiImpl implements INickNameApi {
    static IPatchRedirector $redirector_;

    public NickNameApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.nick.api.INickNameApi
    @NotNull
    public CharSequence getEmotionNickName(@NotNull CharSequence name, int emoSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, (Object) name, emoSize);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        return IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), name, 16, emoSize, null, null, 24, null);
    }

    @Override // com.tencent.qqnt.aio.nick.api.INickNameApi
    @NotNull
    public CharSequence getPurePlainText(@NotNull CharSequence name, boolean lengthLimit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, this, name, Boolean.valueOf(lengthLimit));
        }
        Intrinsics.checkNotNullParameter(name, "name");
        String obj = ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getQQTextPurePlainText(name, 16).toString();
        if (lengthLimit && StringUtil.getWordCountNeo(obj) > d.e()) {
            return StringUtil.substringNeo(obj, 0, d.e() - 3) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return obj;
    }

    @Override // com.tencent.qqnt.aio.nick.api.INickNameApi
    public float measureNickName(@NotNull CharSequence name, int emoSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this, (Object) name, emoSize)).floatValue();
        }
        Intrinsics.checkNotNullParameter(name, "name");
        return ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).measureNickNameQQText(name, emoSize);
    }

    @Override // com.tencent.qqnt.aio.nick.api.INickNameApi
    public boolean remarkPriorityFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return ((IChatsConfigRuntimeService) peekAppRuntime.getRuntimeService(IChatsConfigRuntimeService.class, "")).nickUseNTOrder();
        }
        return false;
    }
}
