package com.tencent.qqnt.chats.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J&\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/utils/f;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "uid", "", "chatType", "guildId", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "d", "contact", "a", "another", "c", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f355547a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45806);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f355547a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactInfo contact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) item, (Object) contact)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(contact, "contact");
        String str = contact.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
        return b(item, str, contact.chatType, ex3.a.f(contact));
    }

    public final boolean b(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull String uid, int chatType, @NotNull String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, item, uid, Integer.valueOf(chatType), guildId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (!TextUtils.isEmpty(item.k()) && Intrinsics.areEqual(item.k(), uid)) {
            return true;
        }
        if (TextUtils.isEmpty(item.k()) && item.n() == chatType) {
            return true;
        }
        if (!TextUtils.isEmpty(guildId) && Intrinsics.areEqual(ex3.a.f(item.s()), guildId)) {
            return true;
        }
        return false;
    }

    public final boolean c(@NotNull RecentContactInfo item, @NotNull RecentContactInfo another) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) item, (Object) another)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(another, "another");
        if (item != another) {
            String str = another.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "another.peerUid");
            if (!d(item, str, another.chatType, ex3.a.f(another))) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(@NotNull RecentContactInfo item, @NotNull String uid, int chatType, @NotNull String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, item, uid, Integer.valueOf(chatType), guildId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (!TextUtils.isEmpty(item.peerUid) && Intrinsics.areEqual(item.peerUid, uid)) {
            return true;
        }
        if (TextUtils.isEmpty(item.peerUid) && item.chatType == chatType) {
            return true;
        }
        if (!TextUtils.isEmpty(guildId) && Intrinsics.areEqual(ex3.a.f(item), guildId)) {
            return true;
        }
        return false;
    }
}
