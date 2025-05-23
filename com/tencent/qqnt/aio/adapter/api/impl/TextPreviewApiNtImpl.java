package com.tencent.qqnt.aio.adapter.api.impl;

import android.widget.Toast;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.ITextPreviewApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/TextPreviewApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/ITextPreviewApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "previewText", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "realMsgId", "", "openTextPreview", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TextPreviewApiNtImpl implements ITextPreviewApi {
    static IPatchRedirector $redirector_;

    public TextPreviewApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITextPreviewApi
    public void openTextPreview(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String previewText, @NotNull AIOMsgItem msgItem, long realMsgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, aioContext, previewText, msgItem, Long.valueOf(realMsgId));
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(previewText, "previewText");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        QLog.i("TextPreviewApiNtImpl", 1, "openTextPreview: " + previewText);
        Toast.makeText(aioContext.c().requireContext(), "\u6253\u5f00\u6587\u672c\u9884\u89c8", 0).show();
    }
}
