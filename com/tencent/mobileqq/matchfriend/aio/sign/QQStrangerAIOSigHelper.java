package com.tencent.mobileqq.matchfriend.aio.sign;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\b\t*\u0001\u0017\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0016R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/sign/QQStrangerAIOSigHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "g", h.F, "Lcom/tencent/qqnt/kernel/api/w;", "i", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "msgId", "j", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "d", "J", "lastSendErrorMsgId", "com/tencent/mobileqq/matchfriend/aio/sign/QQStrangerAIOSigHelper$b", "e", "Lcom/tencent/mobileqq/matchfriend/aio/sign/QQStrangerAIOSigHelper$b;", "msgListener", "<init>", "()V", "f", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerAIOSigHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastSendErrorMsgId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b msgListener = new b();

    private final void g() {
        w i3 = i();
        if (i3 != null) {
            i3.addMsgListener(this.msgListener);
        }
    }

    private final void h() {
        w i3 = i();
        if (i3 != null) {
            i3.removeMsgListener(this.msgListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final w i() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getMsgService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Contact peer, long msgId) {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QQStrangerAIOSigHelper", null, null, null, new QQStrangerAIOSigHelper$refreshSignAndResendMsg$1(msgId, this, peer, null), 14, null);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350684w1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "QQStrangerAIOSigHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onCreate(com.tencent.aio.main.businesshelper.b bVar) {
        h.a.a(this, bVar);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/matchfriend/aio/sign/QQStrangerAIOSigHelper$b", "Lcom/tencent/qqnt/msg/i;", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "errorCode", "", "errorMsg", "", "onSendMsgError", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends com.tencent.qqnt.msg.i {
        b() {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onSendMsgError(long msgId, Contact peer, int errorCode, String errorMsg) {
            boolean z16 = false;
            if (peer != null && peer.chatType == 104) {
                z16 = true;
            }
            if (z16) {
                QLog.d("QQStrangerAIOSigHelper", 1, "onSendMsgError msgId: " + msgId + ", errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                if (errorCode == 48) {
                    QQStrangerAIOSigHelper.this.j(peer, msgId);
                }
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 0) {
            g();
        } else {
            if (state != 12) {
                return;
            }
            h();
        }
    }
}
