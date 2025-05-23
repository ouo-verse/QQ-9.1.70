package com.tencent.qqnt.aio.predownload.pic.stragegy;

import com.tencent.mobileqq.aio.msg.w;
import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.predownload.pic.config.b;
import com.tencent.qqnt.kernel.api.ab;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicDownParams;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.PicReqParams;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/pic/stragegy/a;", "", "", "b", "Lcom/tencent/mobileqq/aio/msg/w;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picMsgElement", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f351808a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65593);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f351808a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final PicSize a(@NotNull w msgItem, @NotNull MsgElement picMsgElement) {
        PicDownParams picDownParams;
        PicSize i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PicSize) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem, (Object) picMsgElement);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(picMsgElement, "picMsgElement");
        PicElement picElement = picMsgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
        PicReqParams picReqParams = new PicReqParams(msgItem.p0(), msgItem.r0(), (int) picElement.fileSize, MsgExtKt.u(picElement));
        ab g16 = f.g();
        if (g16 != null) {
            picDownParams = g16.queryPicDownloadSize(picReqParams);
        } else {
            picDownParams = null;
        }
        if (picDownParams != null) {
            if (picDownParams.downType == 1) {
                AIOPicDownloader aIOPicDownloader = AIOPicDownloader.f190570a;
                PicElement picElement2 = picMsgElement.picElement;
                Intrinsics.checkNotNullExpressionValue(picElement2, "picMsgElement.picElement");
                i3 = aIOPicDownloader.i(picElement2, 1, 0);
            } else {
                AIOPicDownloader aIOPicDownloader2 = AIOPicDownloader.f190570a;
                PicElement picElement3 = picMsgElement.picElement;
                Intrinsics.checkNotNullExpressionValue(picElement3, "picMsgElement.picElement");
                int i16 = picDownParams.downType;
                Integer num = picDownParams.downSize;
                Intrinsics.checkNotNullExpressionValue(num, "picDownParams.downSize");
                i3 = aIOPicDownloader2.i(picElement3, i16, num.intValue());
            }
        } else {
            AIOPicDownloader aIOPicDownloader3 = AIOPicDownloader.f190570a;
            PicElement picElement4 = picMsgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement4, "picMsgElement.picElement");
            i3 = aIOPicDownloader3.i(picElement4, 2, 198);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PicPreDownloadStrategy", 2, "[getAIOPicPreDownloadPicSize] msgId=" + msgItem.getMsgId() + ", elementId=" + picMsgElement.elementId, ", picSize=" + i3 + ", picReqParams=" + picReqParams + ", picDownParams=" + picDownParams);
        }
        return i3;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            b.f351799a.g();
        }
    }
}
