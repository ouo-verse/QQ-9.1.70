package com.tencent.qqnt.trace;

import android.os.SystemClock;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.tracer.RFWTraceStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\"\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u0019\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001e\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010(\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\"\u0010+\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R2\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00020,j\b\u0012\u0004\u0012\u00020\u0002`-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00106\u001a\u0002048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/trace/j;", "", "", "node", "", "d", "", "r", "a", "e", "l", "o", "", "msfInitStartTime", "msfInitEndTime", "i", tl.h.F, "g", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", DomainData.DOMAIN_NAME, "b", "Z", "isClickOfflinePush", "c", "pushMsgDidShow", "J", "()J", "setClickPushTime", "(J)V", "clickPushTime", "getMsfServiceInitTime", "setMsfServiceInitTime", "msfServiceInitTime", "getMsfRegisterServiceTime", "setMsfRegisterServiceTime", "msfRegisterServiceTime", "getKernelInitStartTime", "setKernelInitStartTime", "kernelInitStartTime", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getUniqueNodeNames", "()Ljava/util/ArrayList;", "setUniqueNodeNames", "(Ljava/util/ArrayList;)V", "uniqueNodeNames", "Lcom/tencent/richframework/tracer/RFWTraceStream;", "()Lcom/tencent/richframework/tracer/RFWTraceStream;", "stream", "<init>", "()V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f362346a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isClickOfflinePush;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean pushMsgDidShow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long clickPushTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long msfServiceInitTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long msfRegisterServiceTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long kernelInitStartTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<String> uniqueNodeNames;

    static {
        ArrayList<String> arrayListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42849);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        f362346a = new j();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("MSF_CONNECT_START", "REGISTER_PROXY_START", "REGISTER_PROXY_END", "MSG_SYNC_FIRST_END", "MSF_SEND_REGISTER_PROXY_RSP", "MSF_SEND_REGISTER_PROXY_REQ");
        uniqueNodeNames = arrayListOf;
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a() {
        isClickOfflinePush = false;
        clickPushTime = 0L;
        msfServiceInitTime = 0L;
        msfRegisterServiceTime = 0L;
        kernelInitStartTime = 0L;
    }

    private final RFWTraceStream c() {
        return r.f362387a.findStream("MSF_MSG_PUSH");
    }

    private final boolean d(String node) {
        if (r.f362387a.findStream("MSF_MSG_PUSH").nodeTime(node) == 0 || !uniqueNodeNames.contains(node)) {
            return true;
        }
        return false;
    }

    private final void r() {
        if (isClickOfflinePush && pushMsgDidShow) {
            try {
                if (msfServiceInitTime != 0) {
                    c().tagNode("MSF_START_SERVICE", msfServiceInitTime);
                }
                if (msfRegisterServiceTime != 0) {
                    c().tagNode("REGISTER_MSF_SERVICE", msfRegisterServiceTime);
                }
                if (msfRegisterServiceTime != 0) {
                    c().tagNode("KERNEL_INIT_START", kernelInitStartTime);
                }
                c().tagNode("MSF_PUSH_END_STREAM", SystemClock.elapsedRealtime());
                c().end();
                a();
            } catch (Exception e16) {
                QLog.d("MSFMsgPushTracer", 1, "streamEnd. error", e16);
            }
        }
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return clickPushTime;
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isDevelopLevel()) {
            QLog.d("MSFMsgPushTracer", 4, "onClickPush: time=" + elapsedRealtime);
        }
        c().reset();
        c().tagNode("MSF_PUSH_CLICK", elapsedRealtime);
        isClickOfflinePush = true;
        pushMsgDidShow = false;
        clickPushTime = elapsedRealtime;
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (!isClickOfflinePush) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isDevelopLevel()) {
            QLog.d("MSFMsgPushTracer", 4, "onKernelInitEnd: time=" + elapsedRealtime);
        }
        c().tagNode("KERNEL_INIT_END", elapsedRealtime);
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (!isClickOfflinePush) {
            kernelInitStartTime = SystemClock.elapsedRealtime();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isDevelopLevel()) {
            QLog.d("MSFMsgPushTracer", 4, "onKernelInitStart: time=" + elapsedRealtime);
        }
        c().tagNode("KERNEL_INIT_START", elapsedRealtime);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (!isClickOfflinePush) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isDevelopLevel()) {
            QLog.d("MSFMsgPushTracer", 4, "onMSFConnectEnd: time=" + elapsedRealtime);
        }
        c().tagNode("MSF_CONNECT_END", elapsedRealtime);
    }

    public final void i(long msfInitStartTime, long msfInitEndTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(msfInitStartTime), Long.valueOf(msfInitEndTime));
            return;
        }
        if (isClickOfflinePush && d("MSF_CONNECT_START")) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (QLog.isDevelopLevel()) {
                QLog.d("MSFMsgPushTracer", 4, "onMSFConnectStart: time=" + elapsedRealtime);
            }
            c().tagNode("MSF_INIT_START", msfInitStartTime);
            c().tagNode("MSF_INIT_END", msfInitEndTime);
            c().tagNode("MSF_CONNECT_START", elapsedRealtime);
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (isClickOfflinePush && d("MSF_SEND_REGISTER_PROXY_REQ")) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (QLog.isDevelopLevel()) {
                QLog.d("MSFMsgPushTracer", 4, "onMSFSendRegisterProxyReq: time=" + elapsedRealtime);
            }
            c().tagNode("MSF_SEND_REGISTER_PROXY_REQ", elapsedRealtime);
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (isClickOfflinePush && d("MSF_SEND_REGISTER_PROXY_RSP")) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (QLog.isDevelopLevel()) {
                QLog.d("MSFMsgPushTracer", 4, "onMSFSendRegisterProxyRsp: time=" + elapsedRealtime);
            }
            c().tagNode("MSF_SEND_REGISTER_PROXY_RSP", elapsedRealtime);
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (!isClickOfflinePush) {
            msfServiceInitTime = SystemClock.elapsedRealtime();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isDevelopLevel()) {
            QLog.d("MSFMsgPushTracer", 4, "onMSFServiceStart: time=" + elapsedRealtime);
        }
        c().tagNode("MSF_START_SERVICE", elapsedRealtime);
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (isClickOfflinePush && d("MSG_SYNC_FIRST_END")) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (QLog.isDevelopLevel()) {
                QLog.d("MSFMsgPushTracer", 4, "onMsgSyncFirstEnd: time=" + elapsedRealtime);
            }
            c().tagNode("MSG_SYNC_FIRST_END", elapsedRealtime);
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (!isClickOfflinePush) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isDevelopLevel()) {
            QLog.d("MSFMsgPushTracer", 4, "onPushMsgDidShow: time=" + elapsedRealtime);
        }
        pushMsgDidShow = true;
        c().tagNode("PUSH_MSG_DID_SHOW", elapsedRealtime);
        r();
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (!isClickOfflinePush) {
            msfRegisterServiceTime = SystemClock.elapsedRealtime();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isDevelopLevel()) {
            QLog.d("MSFMsgPushTracer", 4, "onRegisterMSFService: time=" + elapsedRealtime);
        }
        c().tagNode("REGISTER_MSF_SERVICE", elapsedRealtime);
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (isClickOfflinePush && d("REGISTER_PROXY_END")) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (QLog.isDevelopLevel()) {
                QLog.d("MSFMsgPushTracer", 4, "onRegisterProxyEnd: time=" + elapsedRealtime);
            }
            c().tagNode("REGISTER_PROXY_END", elapsedRealtime);
        }
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (isClickOfflinePush && d("REGISTER_PROXY_START")) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (QLog.isDevelopLevel()) {
                QLog.d("MSFMsgPushTracer", 4, "onRegisterProxyStart: time=" + elapsedRealtime);
            }
            c().tagNode("REGISTER_PROXY_START", elapsedRealtime);
        }
    }
}
