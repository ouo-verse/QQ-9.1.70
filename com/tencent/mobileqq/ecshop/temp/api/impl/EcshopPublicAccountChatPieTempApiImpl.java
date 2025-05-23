package com.tencent.mobileqq.ecshop.temp.api.impl;

import a61.c;
import android.content.Context;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopPublicAccountChatPieTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/ecshop/temp/api/impl/EcshopPublicAccountChatPieTempApiImpl;", "Lcom/tencent/mobileqq/ecshop/temp/api/IEcshopPublicAccountChatPieTempApi;", "Landroid/content/Context;", "context", "La61/c;", "getCurrentPie", "Lcom/tencent/mobileqq/data/ChatMessage;", "chatMessage", "", "startDelAnimAndDelMsg", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class EcshopPublicAccountChatPieTempApiImpl implements IEcshopPublicAccountChatPieTempApi {
    static IPatchRedirector $redirector_;

    public EcshopPublicAccountChatPieTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final c getCurrentPie(Context context) {
        BaseActivity baseActivity;
        ChatFragment chatFragment;
        if (context instanceof BaseActivity) {
            baseActivity = (BaseActivity) context;
        } else {
            baseActivity = null;
        }
        if (baseActivity == null || (chatFragment = baseActivity.getChatFragment()) == null) {
            return null;
        }
        return chatFragment.qh();
    }

    static /* synthetic */ c getCurrentPie$default(EcshopPublicAccountChatPieTempApiImpl ecshopPublicAccountChatPieTempApiImpl, Context context, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            context = BaseActivity.sTopActivity;
        }
        return ecshopPublicAccountChatPieTempApiImpl.getCurrentPie(context);
    }

    @Override // com.tencent.mobileqq.ecshop.temp.api.IEcshopPublicAccountChatPieTempApi
    public void startDelAnimAndDelMsg(@NotNull Context context, @NotNull ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) chatMessage);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(chatMessage, "chatMessage");
        c currentPie = getCurrentPie(context);
        if (currentPie != null) {
            currentPie.x(chatMessage);
        }
    }
}
