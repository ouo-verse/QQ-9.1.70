package com.tencent.mobileqq.aio.doutu;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.doutu.d;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/doutu/c;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", "", "c", "Lcom/tencent/qqnt/doutu/d;", "msgItem", "", "e", "d", "b", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f188260a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43391);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f188260a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean c(AIOMsgItem msg2) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (msg2 instanceof PicMsgItem) {
            PicElement p26 = ((PicMsgItem) msg2).p2();
            long j3 = p26.fileSize;
            if (1 <= j3 && j3 < 512000) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                long j16 = p26.picWidth;
                if (1 <= j16 && j16 < 500) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    long j17 = p26.picHeight;
                    if (1 <= j17 && j17 < 500) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final void e(AIOMsgItem msg2, d msgItem) {
        int i3 = 1;
        if (msg2.getMsgRecord().msgType == 17) {
            msgItem.f356094e = true;
            MsgElement firstTypeElement = msg2.getFirstTypeElement(11);
            if (firstTypeElement != null) {
                msgItem.f356096g = firstTypeElement.marketFaceElement.emojiId;
            }
        } else {
            if (msg2 instanceof PicMsgItem) {
                msgItem.f356095f = true;
                PicElement p26 = ((PicMsgItem) msg2).p2();
                msgItem.f356097h = p26.md5HexStr;
                int i16 = p26.picSubType;
                if (i16 == 1) {
                    i3 = 2;
                } else {
                    i3 = 3;
                    if (i16 != 3) {
                        if (i16 == 13) {
                            i3 = 4;
                        } else if (MsgExtKt.x(p26)) {
                            i3 = 5;
                        }
                    }
                }
            }
            i3 = 6;
        }
        msgItem.f356098i = i3;
    }

    @NotNull
    public final d a(@NotNull AIOMsgItem msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2);
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        d dVar = new d();
        MsgRecord msgRecord = msg2.getMsgRecord();
        dVar.f356090a = msgRecord.msgTime;
        dVar.f356091b = msg2.isSelf();
        dVar.f356092c = msg2.getMsgId();
        dVar.f356093d = msg2.G0();
        dVar.f356100k = msgRecord.senderUid;
        dVar.f356099j = msg2.G();
        e(msg2, dVar);
        dVar.f356102m = Long.valueOf(msgRecord.senderUin);
        dVar.f356103n = Long.valueOf(msgRecord.peerUin);
        return dVar;
    }

    public final boolean b(@NotNull AIOMsgItem msg2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.getMsgRecord().msgType == 17) {
            return true;
        }
        if (msg2 instanceof PicMsgItem) {
            PicElement p26 = ((PicMsgItem) msg2).p2();
            if (MsgExtKt.x(p26) || (i3 = p26.picSubType) == 1 || i3 == 3 || i3 == 13) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean d(@NotNull AIOMsgItem msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!b(msg2) && !c(msg2)) {
            return false;
        }
        return true;
    }
}
