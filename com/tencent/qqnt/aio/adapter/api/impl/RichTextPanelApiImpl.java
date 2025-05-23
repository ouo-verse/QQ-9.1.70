package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.panel.richtext.NTRichEmojiPanelProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqnt.aio.adapter.api.IRichTextPanelApi;
import com.tencent.qqnt.aio.adapter.richtext.NTRichTextPanelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/RichTextPanelApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IRichTextPanelApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/aio/api/e;", "getPanelProvider", "", "getZhituConfigState", "getEmojiPanelProvider", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RichTextPanelApiImpl implements IRichTextPanelApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IRichTextPanelApi
    public com.tencent.qqnt.aio.api.e getEmojiPanelProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new NTRichEmojiPanelProvider(context);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichTextPanelApi
    public com.tencent.qqnt.aio.api.e getPanelProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new NTRichTextPanelProvider(context);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichTextPanelApi
    public boolean getZhituConfigState() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !(peekAppRuntime instanceof QQAppInterface)) {
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        return com.tencent.mobileqq.flashchat.e.d(qQAppInterface).k(qQAppInterface);
    }
}
