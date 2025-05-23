package com.tencent.ecommerce.base.customview.vnode;

import android.os.Handler;
import android.os.Looper;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ticket.api.IECTicketManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B'\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/base/customview/vnode/PTSTimerRunnable;", "Ljava/lang/Runnable;", "", "f", "g", "", "e", TencentLocation.RUN_MODE, "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "handler", "", "Z", "isRun", "Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "ticketManager", h.F, "J", "getStartTime", "()J", "setStartTime", "(J)V", "startTime", "i", "getEndTime", "setEndTime", "endTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "gapTimeMills", "Lcom/tencent/ecommerce/base/customview/vnode/IPTTimerTextCallback;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/customview/vnode/IPTTimerTextCallback;", "callback", "<init>", "(JJJLcom/tencent/ecommerce/base/customview/vnode/IPTTimerTextCallback;)V", "D", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class PTSTimerRunnable implements Runnable {

    /* renamed from: C, reason: from kotlin metadata */
    private final IPTTimerTextCallback callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isRun;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IECTicketManager ticketManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long gapTimeMills;

    public PTSTimerRunnable(long j3, long j16, long j17, IPTTimerTextCallback iPTTimerTextCallback) {
        this.startTime = j3;
        this.endTime = j16;
        this.gapTimeMills = j17;
        this.callback = iPTTimerTextCallback;
        cg0.a.b("PTSTimerRunnable", "startTime = " + this.startTime + " endTime = " + this.endTime + " gapTimeMills = " + j17);
        this.ticketManager = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket();
        f();
    }

    private final long e() {
        IECTicketManager iECTicketManager = this.ticketManager;
        if (iECTicketManager != null) {
            return iECTicketManager.getServerTimeMillis();
        }
        return System.currentTimeMillis();
    }

    private final void f() {
        long e16 = e();
        if (e16 < this.startTime) {
            Handler handler = this.handler;
            final PTSTimerRunnable$initRunnableState$1 pTSTimerRunnable$initRunnableState$1 = new PTSTimerRunnable$initRunnableState$1(this);
            handler.postDelayed(new Runnable() { // from class: com.tencent.ecommerce.base.customview.vnode.PTSTimerRunnable$sam$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Function0.this.invoke();
                }
            }, this.startTime - e16);
            this.callback.onContentUpdate();
            return;
        }
        if (e16 > this.endTime) {
            this.callback.onContentUpdate();
        } else {
            g();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.isRun) {
            this.isRun = this.callback.onContentUpdate();
            if (e() > this.endTime) {
                this.isRun = false;
                this.callback.onTimerEnd();
            } else {
                PTSTimerRunnable pTSTimerRunnable = (PTSTimerRunnable) new WeakReference(this).get();
                if (pTSTimerRunnable != null) {
                    this.handler.postDelayed(pTSTimerRunnable, this.gapTimeMills);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.isRun = true;
        this.callback.onTimerStart();
        run();
    }
}
