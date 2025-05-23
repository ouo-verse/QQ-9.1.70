package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.AniStickerMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/aa;", "", "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "msgItem", "", "d", "Lcom/tencent/mobileqq/aio/msg/ArkMsgItem;", "a", "Lcom/tencent/mobileqq/aio/msg/FileMsgItem;", "c", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class aa {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final aa f194101a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f194101a = new aa();
        }
    }

    aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(ArkMsgItem msgItem) {
        return a81.e.INSTANCE.w(msgItem);
    }

    private final boolean c(FileMsgItem msgItem) {
        boolean z16;
        FileElement n26 = msgItem.n2();
        if (n26 == null) {
            return false;
        }
        if (!com.tencent.qqnt.aio.utils.m.f352305a.f(n26.filePath)) {
            String str = n26.fileUuid;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return false;
            }
        }
        return true;
    }

    private final boolean d(ShortVideoMsgItem msgItem) {
        if (msgItem.N2() || msgItem.O2() || msgItem.Q2() || !com.tencent.qqnt.aio.utils.m.f352305a.f(msgItem.I2())) {
            return false;
        }
        return true;
    }

    public final boolean b(@NotNull AIOMsgItem msgItem) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof com.tencent.mobileqq.aio.msg.ae) {
            z16 = true;
        } else {
            z16 = msgItem instanceof PicMsgItem;
        }
        if (z16) {
            z17 = true;
        } else {
            z17 = msgItem instanceof com.tencent.mobileqq.aio.msg.o;
        }
        if (z17) {
            z18 = true;
        } else {
            z18 = msgItem instanceof com.tencent.mobileqq.aio.msg.u;
        }
        if (z18) {
            z19 = true;
        } else {
            z19 = msgItem instanceof AniStickerMsgItem;
        }
        if (z19) {
            return true;
        }
        if (msgItem instanceof PttMsgItem) {
            z26 = true;
        } else {
            z26 = msgItem instanceof com.tencent.mobileqq.aio.msg.p;
        }
        if (z26) {
            return true;
        }
        if (msgItem instanceof ShortVideoMsgItem) {
            return d((ShortVideoMsgItem) msgItem);
        }
        if (msgItem instanceof ArkMsgItem) {
            return a((ArkMsgItem) msgItem);
        }
        if (msgItem instanceof FileMsgItem) {
            return c((FileMsgItem) msgItem);
        }
        return false;
    }
}
