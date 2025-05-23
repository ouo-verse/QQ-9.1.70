package com.tencent.av.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.avcore.netchannel.AbstractNetChannel;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    static String f73567d = "smartdevice::sharp";

    /* renamed from: a, reason: collision with root package name */
    BaseVideoAppInterface f73568a;

    /* renamed from: b, reason: collision with root package name */
    AbstractNetChannel f73569b;

    /* renamed from: c, reason: collision with root package name */
    a f73570c = new a();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            byte[] byteArray;
            byte[] byteArray2;
            if (intent.getAction().equalsIgnoreCase(((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getSmartDeviceReceiveSharpMsg())) {
                if (QLog.isColorLevel()) {
                    QLog.d(c.f73567d, 2, "recv broadcast : smartdevice receive sharp msg");
                }
                Bundle bundleExtra = intent.getBundleExtra(AppConstants.Key.COLUMN_MSG_DATA);
                if (bundleExtra != null && (byteArray2 = bundleExtra.getByteArray("value")) != null) {
                    c.this.f73569b.receiveSharpVideoCall(0L, byteArray2, null);
                    return;
                }
                return;
            }
            if (intent.getAction().equalsIgnoreCase(((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getSmartDeviceReceiveSharpAckMsg())) {
                if (QLog.isColorLevel()) {
                    QLog.d(c.f73567d, 2, "recv broadcast : smartdevice receive sharp ack msg");
                }
                if (intent.getBooleanExtra("timeout", false)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(c.f73567d, 2, "recv broadcast : smartdevice receive sharp timeout msg");
                        return;
                    }
                    return;
                } else {
                    Bundle bundleExtra2 = intent.getBundleExtra(AppConstants.Key.COLUMN_MSG_DATA);
                    if (bundleExtra2 != null && (byteArray = bundleExtra2.getByteArray("value")) != null) {
                        c.this.f73569b.receiveSharpVideoAck(0L, byteArray, null);
                        return;
                    }
                    return;
                }
            }
            if (!intent.getAction().equals(((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getDeviceUnBindRst()) || (extras = intent.getExtras()) == null) {
                return;
            }
            ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).deviceExitVideoProcess(c.this.f73568a, extras);
        }
    }

    public c(AbstractNetChannel abstractNetChannel, BaseVideoAppInterface baseVideoAppInterface) {
        this.f73569b = abstractNetChannel;
        this.f73568a = baseVideoAppInterface;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getSmartDeviceReceiveSharpMsg());
        intentFilter.addAction(((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getSmartDeviceReceiveSharpAckMsg());
        intentFilter.addAction(((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getDeviceUnBindRst());
        this.f73568a.getApp().registerReceiver(this.f73570c, intentFilter, ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getBroadcastPermission(), null);
    }

    void a(byte[] bArr, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(f73567d, 2, "send broadcast : smartdevice send sharp msg");
        }
        Bundle bundle = new Bundle();
        bundle.putInt("size", bArr.length);
        bundle.putLong("uin", j3);
        bundle.putByteArray("value", bArr);
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.COLUMN_MSG_DATA, bundle);
        intent.setAction(((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getSmartDeviceSendSharpMsg());
        this.f73568a.getApp().sendBroadcast(intent, ((IExternalUtilsApi) QRoute.api(IExternalUtilsApi.class)).getBroadcastPermission());
    }

    public void b(byte[] bArr, long j3) {
        a(bArr, j3);
    }
}
