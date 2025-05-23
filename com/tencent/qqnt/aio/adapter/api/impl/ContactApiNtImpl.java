package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IContactApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ContactApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IContactApi;", "()V", "openAddFriend", "", "context", "Landroid/content/Context;", "nick", "", "uid", "openProfileCard", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "openUserProfileCard", "openUserProfileCardByUin", "uin", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class ContactApiNtImpl implements IContactApi {
    static IPatchRedirector $redirector_;

    public ContactApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IContactApi
    public void openAddFriend(@NotNull Context context, @NotNull String nick, @NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, nick, uid);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Toast.makeText(context, "openAddFriend uid=" + uid, 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IContactApi
    public void openProfileCard(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Toast.makeText(context, "openProfileCard uid=" + msgItem.getMsgRecord().senderUid, 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IContactApi
    public void openUserProfileCard(@NotNull Context context, @NotNull String uid, @NotNull String nick) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, uid, nick);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Toast.makeText(context, "openUserProfileCard uid=" + uid, 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IContactApi
    public void openUserProfileCardByUin(@NotNull Context context, @NotNull String uin, @NotNull String nick) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, uin, nick);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Toast.makeText(context, "openUserProfileCardByUin uid=" + uin, 0).show();
    }
}
