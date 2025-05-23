package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.mini.servlet.HomeReportServlet;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/servlet/HomeReportServlet;", "Lmqq/app/MSFServlet;", "()V", "onReceive", "", Const.BUNDLE_KEY_REQUEST, "Landroid/content/Intent;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSend", "packet", "Lmqq/app/Packet;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class HomeReportServlet extends MSFServlet {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long DEFAULT_TIMEOUT = 30000;
    private static final String EXTRA_CMD = "cmd";
    private static final String EXTRA_DATA = "data";
    public static final String EXTRA_TIMEOUT = "timeout";
    private static final String TAG = "HomeReportServlet";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/mini/servlet/HomeReportServlet$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "EXTRA_CMD", "", "EXTRA_DATA", "EXTRA_TIMEOUT", "TAG", "sendRequest", "", "cmd", "reqBytes", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void sendRequest$lambda$1$lambda$0(String cmd, int i3, boolean z16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(cmd, "$cmd");
            if (z16) {
                QLog.d(HomeReportServlet.TAG, 2, "onSend exit cmd=" + cmd);
            }
        }

        public final void sendRequest(final String cmd, byte[] reqBytes) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            NewIntent newIntent = new NewIntent(peekAppRuntime != null ? peekAppRuntime.getApplication() : null, HomeReportServlet.class);
            newIntent.putExtra("cmd", cmd);
            newIntent.putExtra("data", reqBytes);
            newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.mobileqq.mini.servlet.a
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    HomeReportServlet.Companion.sendRequest$lambda$1$lambda$0(cmd, i3, z16, bundle);
                }
            });
            peekAppRuntime.startServlet(newIntent);
        }

        Companion() {
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent request, FromServiceMsg response) {
        long j3;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        if (QLog.isColorLevel()) {
            j3 = System.currentTimeMillis();
            QLog.d(TAG, 2, "onReceive cmd=" + request.getStringExtra("cmd") + ",success=" + response.isSuccess());
        } else {
            j3 = 0;
        }
        if (response.isSuccess()) {
            int length = response.getWupBuffer().length - 4;
            PkgTools.copyData(new byte[length], 0, response.getWupBuffer(), 4, length);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReceive exit|cost: " + (System.currentTimeMillis() - j3));
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent request, Packet packet) {
        String stringExtra = request != null ? request.getStringExtra("cmd") : null;
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.d(TAG, 2, "cmd is empty");
            return;
        }
        byte[] byteArrayExtra = request != null ? request.getByteArrayExtra("data") : null;
        long longExtra = request != null ? request.getLongExtra("timeout", 30000L) : 30000L;
        if (packet != null) {
            packet.setSSOCommand(stringExtra);
        }
        if (packet != null) {
            packet.setTimeout(longExtra);
        }
        if (byteArrayExtra != null) {
            byte[] bArr = new byte[byteArrayExtra.length + 4];
            PkgTools.dWord2Byte(bArr, 0, byteArrayExtra.length + 4);
            PkgTools.copyData(bArr, 4, byteArrayExtra, byteArrayExtra.length);
            if (packet != null) {
                packet.putSendData(bArr);
            }
        } else {
            byte[] bArr2 = new byte[4];
            PkgTools.dWord2Byte(bArr2, 0, 4L);
            if (packet != null) {
                packet.putSendData(bArr2);
            }
        }
        QLog.d(TAG, 2, "onSend exit cmd=" + stringExtra);
    }
}
