package com.tencent.mobileqq.listentogether;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0002ABB\u000f\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0003J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0014J@\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000fH\u0014J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0006\u0010\u001a\u001a\u00020\u0003R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u00103\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00107\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\"\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&R\u0017\u0010=\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/listentogether/d;", "Lcom/tencent/mobileqq/listentogether/e;", "Landroid/os/Handler$Callback;", "", HippyTKDListViewAdapter.X, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "Lcom/tencent/mobileqq/listentogether/ListenTogetherSession;", SessionDbHelper.SESSION_ID, "u", "", "suc", "", "type", "", "uin", "", "reqTs", WidgetCacheConstellationData.INTERVAL, "errCode", "errWording", "g", "Landroid/os/Message;", "msg", "handleMessage", "v", "Lcom/tencent/mobileqq/app/QQAppInterface;", "d", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "e", "I", "getInterval", "()I", "setInterval", "(I)V", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler", tl.h.F, "Z", "getStop", "()Z", "setStop", "(Z)V", "stop", "i", "getErrCount", "setErrCount", "errCount", "Lcom/tencent/mobileqq/listentogether/d$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/listentogether/d$b;", "getJoinedData", "()Lcom/tencent/mobileqq/listentogether/d$b;", "joinedData", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d extends e implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QQAppInterface app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile int interval;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean stop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile int errCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final b joinedData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/listentogether/d$b;", "", "other", "", "equals", "", "a", "I", "()I", "c", "(I)V", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "uin", "type", "<init>", "(ILjava/lang/String;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int sessionType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String uin;

        public b(int i3, String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            this.sessionType = i3;
            this.uin = uin;
        }

        /* renamed from: a, reason: from getter */
        public final int getSessionType() {
            return this.sessionType;
        }

        /* renamed from: b, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        public final void c(int i3) {
            this.sessionType = i3;
        }

        public final void d(String str) {
            this.uin = str;
        }

        public boolean equals(Object other) {
            boolean equals$default;
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (bVar.sessionType != this.sessionType) {
                return false;
            }
            equals$default = StringsKt__StringsJVMKt.equals$default(bVar.uin, this.uin, false, 2, null);
            return equals$default;
        }
    }

    public d(QQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
        this.interval = 60000;
        this.handler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.stop = true;
        this.joinedData = new b(0, "");
        app.addObserver(this, true);
    }

    private final synchronized void w() {
        if (this.stop) {
            return;
        }
        BusinessHandler businessHandler = this.app.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.listentogether.ListenTogetherHandler");
        ((ListenTogetherHandler) businessHandler).a3(this.joinedData.getSessionType(), this.joinedData.getUin());
        x();
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherHeartBeatController", 2, "doHeartBeat uin=" + this.joinedData.getUin());
        }
    }

    private final void x() {
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, this.interval);
    }

    @Override // com.tencent.mobileqq.listentogether.e
    protected void g(boolean suc, int type, String uin, long reqTs, int interval, int errCode, String errWording) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(errWording, "errWording");
        if (this.stop) {
            return;
        }
        boolean z16 = SystemClock.elapsedRealtime() - reqTs > 30000;
        if (suc && !z16) {
            this.errCount = 0;
        } else {
            this.errCount++;
        }
        if (this.errCount > 15) {
            QLog.d("ListenTogetherHeartBeatController", 1, "onHeartBeat isTimeout=" + z16 + " errCount=" + this.errCount + " stop");
            z();
        }
        if (suc) {
            if (interval <= 0 || interval == this.interval) {
                return;
            }
            this.interval = interval;
            return;
        }
        if (suc) {
            return;
        }
        QLog.d("ListenTogetherHeartBeatController", 1, "onHeartBeat failed errCode=" + errCode + " errWordig=" + errWording);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what != 0) {
            return false;
        }
        w();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0065 A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001d, B:7:0x0034, B:8:0x0054, B:11:0x005f, B:13:0x0065, B:16:0x009e, B:18:0x00a2, B:19:0x00a5, B:21:0x00a9, B:25:0x00ad, B:28:0x00b3, B:31:0x0046), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001d, B:7:0x0034, B:8:0x0054, B:11:0x005f, B:13:0x0065, B:16:0x009e, B:18:0x00a2, B:19:0x00a5, B:21:0x00a9, B:25:0x00ad, B:28:0x00b3, B:31:0x0046), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    @Override // com.tencent.mobileqq.listentogether.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected synchronized void u(ListenTogetherSession session) {
        boolean z16;
        Intrinsics.checkNotNullParameter(session, "session");
        ListenTogetherManager J = ListenTogetherManager.J(this.app);
        boolean f06 = J.f0();
        boolean l06 = J.l0(session.f437188e, session.f437189f);
        boolean z17 = true;
        if (l06) {
            b bVar = this.joinedData;
            int i3 = session.f437188e;
            String str = session.f437189f;
            Intrinsics.checkNotNullExpressionValue(str, "session.uin");
            if (!Intrinsics.areEqual(bVar, new b(i3, str))) {
                this.joinedData.c(session.f437188e);
                this.joinedData.d(session.f437189f);
                z16 = true;
                if (this.joinedData.getSessionType() == 2) {
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ListenTogetherHeartBeatController", 2, "onUIModuleNeedRefresh joinState=" + session.f437192m + " isJoin=" + f06 + " isJoinThisSession=" + l06 + " isJoinedSessionC2c=" + z17);
                }
                if (!f06) {
                    if (z16 && !this.stop) {
                        z();
                    }
                    if (this.stop) {
                        y();
                    }
                } else if (!this.stop && !f06) {
                    z();
                }
            }
        }
        if (!f06) {
            this.joinedData.c(0);
            this.joinedData.d("");
        }
        z16 = false;
        if (this.joinedData.getSessionType() == 2) {
        }
        if (QLog.isColorLevel()) {
        }
        if (!f06) {
        }
    }

    public final void v() {
        z();
        this.handler.removeCallbacksAndMessages(null);
        this.app.removeObserver(this);
    }

    public final void z() {
        QLog.d("ListenTogetherHeartBeatController", 1, "stop heartBeat");
        this.stop = true;
        this.handler.removeMessages(0);
    }

    public final void y() {
        QLog.d("ListenTogetherHeartBeatController", 1, "start heartBeat");
        this.stop = false;
        this.errCount = 0;
        w();
    }
}
