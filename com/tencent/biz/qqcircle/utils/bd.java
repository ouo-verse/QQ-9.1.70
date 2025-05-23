package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/qqcircle/utils/bd;", "", "", tl.h.F, "l", "d", "k", "i", "", "f", "g", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "b", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "netInfoHandler", "c", "Ljava/lang/String;", "mIpAddress", "mOperatorName", "<init>", "()V", "qcircle-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class bd {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static INetInfoHandler netInfoHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile String mOperatorName;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bd f92680a = new bd();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static volatile String mIpAddress = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/utils/bd$a", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", "apn", "", "onNetNone2Mobile", "onNetWifi2Mobile", TPDownloadProxyEnum.USER_SSID, "onNetNone2Wifi", "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "qcircle-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a implements INetInfoHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            QLog.i("QFSDevicesInfoUtils", 1, "onNetMobile2None");
            bd.f92680a.i();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(@Nullable String ssid) {
            QLog.i("QFSDevicesInfoUtils", 1, "onNetMobile2Wifi");
            bd.f92680a.i();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(@Nullable String apn) {
            QLog.i("QFSDevicesInfoUtils", 1, "onNetNone2Mobile");
            bd.f92680a.i();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(@Nullable String ssid) {
            QLog.i("QFSDevicesInfoUtils", 1, "onNetNone2Wifi");
            bd.f92680a.i();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(@Nullable String apn) {
            QLog.i("QFSDevicesInfoUtils", 1, "onNetWifi2Mobile");
            bd.f92680a.i();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            QLog.i("QFSDevicesInfoUtils", 1, "onNetWifi2None");
            bd.f92680a.i();
        }
    }

    bd() {
    }

    private final void d() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.bb
            @Override // java.lang.Runnable
            public final void run() {
                bd.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        f92680a.l();
    }

    private final void h() {
        if (netInfoHandler != null) {
            return;
        }
        netInfoHandler = new a();
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            QLog.i("QFSDevicesInfoUtils", 1, "registerConnectionChangeReceiver");
            AppNetConnInfo.registerConnectionChangeReceiver(context, netInfoHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.bc
            @Override // java.lang.Runnable
            public final void run() {
                bd.j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        f92680a.k();
    }

    private final void k() {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            String a16 = com.tencent.mobileqq.utils.av.a(context);
            if (a16 == null) {
                a16 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(a16, "IPUtils.getIpAddress(it) ?: \"\"");
            }
            mIpAddress = a16;
        }
    }

    private final void l() {
        try {
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                mOperatorName = com.tencent.mobileqq.utils.ah.G(context).f307419c;
            }
        } catch (Exception unused) {
            mOperatorName = "";
        }
    }

    @NotNull
    public final String f() {
        BaseApplication context;
        if (TextUtils.isEmpty(mIpAddress) && (context = BaseApplication.getContext()) != null) {
            String a16 = com.tencent.mobileqq.utils.av.a(context);
            if (a16 == null) {
                a16 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(a16, "IPUtils.getIpAddress(it) ?: \"\"");
            }
            mIpAddress = a16;
        }
        h();
        return mIpAddress;
    }

    @NotNull
    public final String g() {
        if (mOperatorName == null) {
            l();
        }
        d();
        String str = mOperatorName;
        if (str == null) {
            return "";
        }
        return str;
    }
}
