package com.tencent.qqnt.aio.adapter.api.impl;

import android.text.Editable;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J4\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/QQTextApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "()V", "createNewQQTextForStreamMsg", "", "qqText", "start", "", "end", "getQQText", "content", WadlProxyConsts.FLAGS, "emoSize", "view", "Landroid/view/View;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class QQTextApiNtImpl implements IQQTextApi {
    static IPatchRedirector $redirector_;

    public QQTextApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public CharSequence createNewQQTextForStreamMsg(@NotNull CharSequence qqText, int start, int end) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, this, qqText, Integer.valueOf(start), Integer.valueOf(end));
        }
        Intrinsics.checkNotNullParameter(qqText, "qqText");
        return new QQText(qqText, 0, 0, (Object) null);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public Editable.Factory getInputNotReuseQQTextBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Editable.Factory) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return IQQTextApi.a.a(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public Editable.Factory getInputQQTextBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Editable.Factory) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return IQQTextApi.a.b(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public CharSequence getQQText(@NotNull CharSequence content, int flags, int emoSize, @Nullable View view, @Nullable AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, this, content, Integer.valueOf(flags), Integer.valueOf(emoSize), view, msgItem);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        return new QQText(content, flags, emoSize, view);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public CharSequence getQQTextPurePlainText(@NotNull CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, (Object) this, (Object) charSequence, i3);
        }
        return IQQTextApi.a.d(this, charSequence, i3);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    public float measureNickNameQQText(@NotNull CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this, (Object) charSequence, i3)).floatValue();
        }
        return IQQTextApi.a.e(this, charSequence, i3);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    public void setBizSrc(@NotNull CharSequence charSequence, @NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) charSequence, (Object) str);
        } else {
            IQQTextApi.a.f(this, charSequence, str);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public CharSequence toPlainText(@NotNull CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this, (Object) charSequence, i3);
        }
        return IQQTextApi.a.g(this, charSequence, i3);
    }
}
