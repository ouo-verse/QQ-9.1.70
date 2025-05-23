package com.tencent.qqnt.emoticon.api.impl;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qqnt.emoticon.api.IEmoticonApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/emoticon/api/impl/EmoticonApiNtImpl;", "Lcom/tencent/qqnt/emoticon/api/IEmoticonApi;", "Lcom/tencent/mobileqq/text/style/EmoticonSpan;", "()V", "getEmoticonSpanClass", "Ljava/lang/Class;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class EmoticonApiNtImpl implements IEmoticonApi<EmoticonSpan> {
    static IPatchRedirector $redirector_;

    public EmoticonApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    public int getDevicePerfLevel(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).intValue();
        }
        return IEmoticonApi.a.a(this, context);
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    @NotNull
    public Class<EmoticonSpan> getEmoticonSpanClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return EmoticonSpan.class;
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    @Nullable
    public <T extends IConfigData> T loadConfig(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return (T) IEmoticonApi.a.b(this, str);
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    public void showAIEmoticonPanel(@NotNull FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fragmentActivity);
        } else {
            IEmoticonApi.a.c(this, fragmentActivity);
        }
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    public void showCompositeEmoticonPanel(@NotNull FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fragmentActivity);
        } else {
            IEmoticonApi.a.d(this, fragmentActivity);
        }
    }

    @Override // com.tencent.qqnt.emoticon.api.IEmoticonApi
    public void showZPlanEmoticonPanel(@NotNull FragmentActivity fragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fragmentActivity);
        } else {
            IEmoticonApi.a.e(this, fragmentActivity);
        }
    }
}
