package com.tencent.mobileqq.zplan.card.impl.view.smallhome.data;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\r\u001a\u00020\fH&R\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/a;", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "d", "e", "", "refreshInterval", "c", "b", "", "a", "J", "mRefreshInterval", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a extends Handler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long mRefreshInterval;

    public a() {
        super(ThreadManagerV2.getQQCommonThreadLooper());
    }

    public abstract String a();

    public abstract void b();

    public final void c(long refreshInterval) {
        QLog.i(a(), 2, "setRefreshInterval refreshInterval=" + refreshInterval);
        this.mRefreshInterval = refreshInterval;
        if (refreshInterval == 0) {
            e();
        }
    }

    public final void d() {
        QLog.i(a(), 2, "startLoopRefresh mRefreshInterval = " + this.mRefreshInterval);
        if (this.mRefreshInterval > 0) {
            removeMessages(1);
            sendEmptyMessageDelayed(1, this.mRefreshInterval);
        }
    }

    public final void e() {
        QLog.i(a(), 2, "stopLoopRefresh");
        removeMessages(1);
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1) {
            b();
            sendEmptyMessageDelayed(1, this.mRefreshInterval);
        }
    }
}
