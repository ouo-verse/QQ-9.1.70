package com.tencent.qqnt.aio.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.activity.HorizontalActivity;
import com.tencent.qqnt.aio.api.IHorizontalMiniAIOApi;
import com.tencent.qqnt.miniaio.HorizontalMiniaioFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J2\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/HorizontalMiniAIOApiImpl;", "Lcom/tencent/qqnt/aio/api/IHorizontalMiniAIOApi;", "()V", "getHorizontalMiniaioFragment", "Ljava/lang/Class;", "Lcom/tencent/qqnt/miniaio/HorizontalMiniaioFragment;", "isForeGround", "", "navigateToHorizontalMiniaio", "", "context", "Landroid/content/Context;", "chatType", "", "uid", "", "nick", "extra", "Landroid/os/Bundle;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class HorizontalMiniAIOApiImpl implements IHorizontalMiniAIOApi {
    static IPatchRedirector $redirector_;

    public HorizontalMiniAIOApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IHorizontalMiniAIOApi
    @NotNull
    public Class<HorizontalMiniaioFragment> getHorizontalMiniaioFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return HorizontalMiniaioFragment.class;
    }

    @Override // com.tencent.qqnt.aio.api.IHorizontalMiniAIOApi
    public boolean isForeGround() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return HorizontalMiniaioFragment.INSTANCE.a();
    }

    @Override // com.tencent.qqnt.aio.api.IHorizontalMiniAIOApi
    public void navigateToHorizontalMiniaio(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, @Nullable Bundle extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(chatType), uid, nick, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intent intent = new Intent(context, (Class<?>) HorizontalActivity.class);
        intent.putExtra("key_chat_name", nick);
        intent.putExtra("key_chat_type", chatType);
        intent.putExtra("key_peerId", uid);
        if (extra != null) {
            intent.putExtras(extra);
        }
        context.startActivity(intent);
    }
}
