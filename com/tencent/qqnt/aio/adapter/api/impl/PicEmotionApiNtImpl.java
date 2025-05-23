package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IPicEmotionApi;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchEmojiInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/PicEmotionApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IPicEmotionApi;", "()V", "downloadPicEmotion", "", "emojiInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiHotPicSearchEmojiInfo;", "callback", "Lkotlin/Function1;", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class PicEmotionApiNtImpl implements IPicEmotionApi {
    static IPatchRedirector $redirector_;

    public PicEmotionApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IPicEmotionApi
    public void downloadPicEmotion(@NotNull EmojiHotPicSearchEmojiInfo emojiInfo, @NotNull Function1<? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emojiInfo, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(emojiInfo, "emojiInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(null);
    }
}
