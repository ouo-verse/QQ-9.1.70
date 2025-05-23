package com.tencent.mobileqq.qwallet.impl.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J>\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/impl/servlet/c;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "client", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "data", "Ljava/lang/Class;", "Lmqq/observer/BusinessObserver;", "filter", "notifyObserver", "<init>", "()V", "d", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c extends MSFServlet {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/impl/servlet/c$a;", "", "Lcom/tencent/mobileqq/qwallet/impl/servlet/QWalletCommonRequest;", Const.BUNDLE_KEY_REQUEST, "Lmqq/observer/BusinessObserver;", "observer", "", "a", "", "KEY_CALLBACK_ON_SUB_THREAD", "Ljava/lang/String;", "KEY_JCE_REQ", "KEY_JCE_RSP", "KEY_REQUEST", "KEY_RET_CODE", "TAG", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.impl.servlet.c$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull QWalletCommonRequest request, @Nullable BusinessObserver observer) {
            Intrinsics.checkNotNullParameter(request, "request");
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), c.class);
            newIntent.putExtra(Const.BUNDLE_KEY_REQUEST, request);
            newIntent.putExtra("onSubThread", request.getCallbackOnSubThread());
            newIntent.setObserver(observer);
            QLog.i("Q.qwallet.QWalletCommonServlet", 1, "send " + request);
            waitAppRuntime.startServlet(newIntent);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BusinessObserver businessObserver, int i3, boolean z16, Bundle bundle) {
        businessObserver.onReceive(i3, z16, bundle);
    }

    @JvmStatic
    public static final void c(@NotNull QWalletCommonRequest qWalletCommonRequest, @Nullable BusinessObserver businessObserver) {
        INSTANCE.a(qWalletCommonRequest, businessObserver);
    }

    @Override // mqq.app.Servlet
    public void notifyObserver(@NotNull Intent request, final int type, final boolean isSuccess, @Nullable final Bundle data, @Nullable Class<? extends BusinessObserver> filter) {
        NewIntent newIntent;
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.getBooleanExtra("onSubThread", false)) {
            final BusinessObserver businessObserver = null;
            if (request instanceof NewIntent) {
                newIntent = (NewIntent) request;
            } else {
                newIntent = null;
            }
            if (newIntent != null) {
                businessObserver = newIntent.getObserver();
            }
            if (businessObserver != null) {
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qwallet.impl.servlet.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.b(BusinessObserver.this, type, isSuccess, data);
                    }
                });
                return;
            }
            return;
        }
        super.notifyObserver(request, type, isSuccess, data, filter);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(@Nullable Intent request, @Nullable FromServiceMsg response) {
        JceStruct decodeResponse;
        if (response != null && request != null) {
            Serializable serializableExtra = request.getSerializableExtra(Const.BUNDLE_KEY_REQUEST);
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.mobileqq.qwallet.impl.servlet.QWalletCommonRequest");
            QWalletCommonRequest qWalletCommonRequest = (QWalletCommonRequest) serializableExtra;
            QLog.i("Q.qwallet.QWalletCommonServlet", 1, "onReceive " + qWalletCommonRequest.getSsoCommand() + MsgSummary.STR_COLON + response.isSuccess());
            Bundle bundle = new Bundle();
            bundle.putSerializable("req", qWalletCommonRequest.getReq());
            bundle.putInt("msfRetCode", response.getResultCode());
            if (response.isSuccess() && (decodeResponse = qWalletCommonRequest.decodeResponse(response)) != null) {
                bundle.putSerializable("rsp", decodeResponse);
            }
            qWalletCommonRequest.getDecorator();
            notifyObserver(request, qWalletCommonRequest.getCmdType(), response.isSuccess(), bundle, null);
            return;
        }
        QLog.i("Q.qwallet.QWalletCommonServlet", 1, "onReceive request or response is null");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent request, @Nullable Packet client) {
        Serializable serializable;
        QWalletCommonRequest qWalletCommonRequest = null;
        if (request != null) {
            serializable = request.getSerializableExtra(Const.BUNDLE_KEY_REQUEST);
        } else {
            serializable = null;
        }
        if (serializable instanceof QWalletCommonRequest) {
            qWalletCommonRequest = (QWalletCommonRequest) serializable;
        }
        if (qWalletCommonRequest != null && client != null) {
            try {
                client.addRequestPacket("req", qWalletCommonRequest.getReq());
                client.setSSOCommand(qWalletCommonRequest.getSsoCommand());
                client.setFuncName(qWalletCommonRequest.getFuncName());
                client.setServantName(qWalletCommonRequest.getServantName());
                client.setTimeout(qWalletCommonRequest.getTimeoutMs());
            } catch (OutOfMemoryError e16) {
                QLog.w("Q.qwallet.QWalletCommonServlet", 1, "onSend sso package oom.", e16);
            }
        }
    }
}
