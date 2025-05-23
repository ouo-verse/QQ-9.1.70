package com.tencent.qqnt.aio.assistedchat.progolue;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tJ\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/progolue/c;", "", "", "prefix", "", "chatType", "peerUid", "c", "peerUin", "", "a", "value", "", "d", "emojiId", "e", "b", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f349416a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60051);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f349416a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c(String prefix, int chatType, String peerUid) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return prefix + "_" + chatType + "_" + str + "_" + peerUid;
    }

    public final boolean a(@NotNull String peerUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) peerUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(c("C2CNeedRequestPrologue", 1, peerUin), false);
    }

    public final int b(int chatType, @NotNull String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, chatType, (Object) peerUid)).intValue();
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(c("StrangerSayHi", chatType, peerUid), -1);
    }

    public final void d(@NotNull String peerUin, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, peerUin, Boolean.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String c16 = c("C2CNeedRequestPrologue", 1, peerUin);
        if (!value) {
            from.removeKey(c16);
        } else {
            from.encodeBool(c16, value);
        }
    }

    public final void e(int chatType, @NotNull String peerUid, int emojiId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(chatType), peerUid, Integer.valueOf(emojiId));
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String c16 = c("StrangerSayHi", chatType, peerUid);
        if (emojiId == -1) {
            from.removeKey(c16);
        } else {
            from.encodeInt(c16, emojiId);
        }
    }
}
