package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.GrayTipsMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGuideCustomizeGrayTipsApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006J\u001c\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/ac;", "", "Lcom/tencent/mobileqq/aio/msg/GrayTipsMsgItem;", "msgItem", "", "e", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "context", "", "displayList", "", "b", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ac {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ac f194103a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65294);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f194103a = new ac();
        }
    }

    ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        ((IGuideCustomizeGrayTipsApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuideCustomizeGrayTipsApi.class)).isNeedAddGuideCustomizeGrayTips(context);
    }

    private final boolean e(GrayTipsMsgItem msgItem) {
        GrayTipElement grayTipElement;
        boolean z16;
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(8);
        if (firstTypeElement != null) {
            grayTipElement = firstTypeElement.grayTipElement;
        } else {
            grayTipElement = null;
        }
        if (grayTipElement == null || grayTipElement.subElementType != 17) {
            return false;
        }
        JsonGrayElement jsonGrayElement = grayTipElement.jsonGrayTipElement;
        if (jsonGrayElement != null && ((int) jsonGrayElement.busiId) == 2000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    public final void b(@NotNull final com.tencent.aio.api.runtime.a context, @NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) displayList);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        if (QLog.isDevelopLevel()) {
            QLog.d("PaiYiPaiMsgProcessor", 2, "[insertGuideCustomizeGrayTipsIfNeed] start");
        }
        if (context.g().r().c().e() == 3) {
            if (QLog.isColorLevel()) {
                QLog.d("PaiYiPaiMsgProcessor", 2, "[insertGuideCustomizeGrayTipsIfNeed] chatType == MsgConstant.KCHATTYPEDISC");
                return;
            }
            return;
        }
        boolean z16 = false;
        boolean z17 = false;
        for (com.tencent.aio.data.msglist.a aVar : displayList) {
            if (aVar instanceof GrayTipsMsgItem) {
                ac acVar = f194103a;
                if (acVar.d(aVar)) {
                    z17 = true;
                }
                if (acVar.e((GrayTipsMsgItem) aVar)) {
                    z16 = true;
                }
            }
        }
        if (!z16 && z17) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.utils.ab
                @Override // java.lang.Runnable
                public final void run() {
                    ac.c(com.tencent.aio.api.runtime.a.this);
                }
            }, 16, null, false);
        }
    }

    public final boolean d(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        GrayTipElement grayTipElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof GrayTipsMsgItem) || d.s((AIOMsgItem) msgItem)) {
            return false;
        }
        MsgElement firstTypeElement = ((GrayTipsMsgItem) msgItem).getFirstTypeElement(8);
        if (firstTypeElement != null) {
            grayTipElement = firstTypeElement.grayTipElement;
        } else {
            grayTipElement = null;
        }
        if (grayTipElement == null || grayTipElement.subElementType != 1) {
            return false;
        }
        RevokeElement revokeElement = grayTipElement.revokeElement;
        if (!revokeElement.isSelfOperate || ((int) revokeElement.operatorRole) != 0) {
            return false;
        }
        return true;
    }
}
