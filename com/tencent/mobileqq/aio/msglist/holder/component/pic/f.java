package com.tencent.mobileqq.aio.msglist.holder.component.pic;

import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.doutu.api.IDoutuService;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/pic/f;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picMsgElement", "Landroid/view/View;", "imageView", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lcom/tencent/qqnt/aio/holder/a;", "intent", "o", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A(AIOMsgItem msgItem, MsgElement picMsgElement, View imageView) {
        z.a aVar;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new AIOMsgListEvent.GetAIORichMediaMsgListEvent(msgItem.getMsgRecord()));
        List<AIOMsgItem> list = null;
        if (k3 instanceof z.a) {
            aVar = (z.a) k3;
        } else {
            aVar = null;
        }
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        if (aVar != null) {
            list = aVar.a();
        }
        IRichMediaBrowserApi.a.a(iRichMediaBrowserApi, peekAppRuntime, requireContext, imageView, msgItem, picMsgElement, false, null, list, false, 256, null);
    }

    private final void B() {
        MqqHandler mqqHandler;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            IDoutuService iDoutuService = (IDoutuService) ((BaseQQAppInterface) peekAppRuntime).getRuntimeService(IDoutuService.class);
            if (iDoutuService != null) {
                mqqHandler = iDoutuService.getDoutuMainHandler();
            } else {
                mqqHandler = null;
            }
            Intrinsics.checkNotNull(mqqHandler);
            Message obtainMessage = mqqHandler.obtainMessage(81, (Runnable) null);
            Intrinsics.checkNotNull(obtainMessage);
            obtainMessage.sendToTarget();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.ac) {
            d.ac acVar = (d.ac) intent;
            A(acVar.b(), acVar.c(), acVar.a());
        } else if (intent instanceof d.as) {
            B();
        } else {
            super.handleIntent(intent);
        }
    }
}
