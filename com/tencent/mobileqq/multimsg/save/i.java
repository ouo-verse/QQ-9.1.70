package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.multimsg.save.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/multimsg/save/i;", "", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgList", "Lcom/tencent/mobileqq/multimsg/save/m$b;", "a", "aioMsgItem", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f251704a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59003);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f251704a = new i();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final List<m.b> a(@NotNull List<? extends AIOMsgItem> aioMsgList) {
        Intrinsics.checkNotNullParameter(aioMsgList, "aioMsgList");
        if (aioMsgList.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends AIOMsgItem> it = aioMsgList.iterator();
        while (it.hasNext()) {
            m.b c16 = f251704a.c(it.next());
            if (c16 != null) {
                arrayList.add(c16);
            }
        }
        return arrayList;
    }

    @NotNull
    public final RichMediaElementGetReq b(@NotNull AIOMsgItem aioMsgItem, @NotNull MsgElement msgElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RichMediaElementGetReq) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioMsgItem, (Object) msgElement);
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        return new RichMediaElementGetReq(aioMsgItem.q0(), aioMsgItem.r0(), aioMsgItem.p0(), msgElement.elementId, 1, 0, ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getLocalPath(aioMsgItem), 0L, 1, 0);
    }

    @Nullable
    public final m.b c(@NotNull AIOMsgItem aioMsgItem) {
        MsgElement firstTypeElement;
        FileElement fileElement;
        FileElement fileElement2;
        VideoElement videoElement;
        PicElement picElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (m.b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioMsgItem);
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        if (com.tencent.mobileqq.aio.utils.d.L(aioMsgItem) && !com.tencent.mobileqq.aio.utils.d.y(aioMsgItem)) {
            MsgElement firstTypeElement2 = aioMsgItem.getFirstTypeElement(2);
            if (firstTypeElement2 != null) {
                picElement = firstTypeElement2.picElement;
            } else {
                picElement = null;
            }
            if (picElement == null || MsgExtKt.r(picElement)) {
                return null;
            }
            return new m.b(0, picElement.fileSize, new RichMediaElementGetReq(aioMsgItem.getMsgId(), aioMsgItem.getMsgRecord().peerUid, aioMsgItem.p0(), firstTypeElement2.elementId, 1, 0, ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getLocalPath(aioMsgItem), 0L, 1, 0));
        }
        if (aioMsgItem.getMsgRecord().msgType == 7) {
            MsgElement firstTypeElement3 = aioMsgItem.getFirstTypeElement(5);
            if (firstTypeElement3 == null || (videoElement = firstTypeElement3.videoElement) == null) {
                return null;
            }
            return new m.b(1, videoElement.fileSize, new RichMediaElementGetReq(aioMsgItem.q0(), aioMsgItem.r0(), aioMsgItem.p0(), firstTypeElement3.elementId, 1, 0, ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getLocalPath(aioMsgItem), 0L, 1, 0));
        }
        if (com.tencent.mobileqq.aio.utils.d.K(aioMsgItem)) {
            MsgElement firstTypeElement4 = aioMsgItem.getFirstTypeElement(3);
            if (firstTypeElement4 == null || (fileElement2 = firstTypeElement4.fileElement) == null) {
                return null;
            }
            return new m.b(2, fileElement2.fileSize, f251704a.b(aioMsgItem, firstTypeElement4));
        }
        if (!com.tencent.mobileqq.aio.utils.d.c0(aioMsgItem) || (firstTypeElement = aioMsgItem.getFirstTypeElement(3)) == null || (fileElement = firstTypeElement.fileElement) == null) {
            return null;
        }
        return new m.b(3, fileElement.fileSize, f251704a.b(aioMsgItem, firstTypeElement));
    }
}
