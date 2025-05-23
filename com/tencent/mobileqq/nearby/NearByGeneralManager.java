package com.tencent.mobileqq.nearby;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.newnearby.servlet.ServletObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.protocol.nearbyControl$ControlFlag;
import com.tencent.mobileqq.protocol.nearbyControl$GetMasterControlReq;
import com.tencent.mobileqq.protocol.nearbyControl$GetMasterControlRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearByGeneralManager implements Manager, a {

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f252493d;

    /* renamed from: e, reason: collision with root package name */
    SharedPreferences f252494e;

    /* renamed from: f, reason: collision with root package name */
    boolean f252495f;

    /* renamed from: h, reason: collision with root package name */
    boolean f252496h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f252497i = false;

    public NearByGeneralManager(final QQAppInterface qQAppInterface) {
        this.f252495f = true;
        this.f252496h = true;
        this.f252493d = qQAppInterface;
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("NearbyGeneralConfig", 0);
        this.f252494e = sharedPreferences;
        if (sharedPreferences != null) {
            this.f252495f = sharedPreferences.getBoolean("Notify_on_like", true);
            this.f252496h = this.f252494e.getBoolean("key_allow_nearby_like", true);
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.nearby.NearByGeneralManager.1
            @Override // java.lang.Runnable
            public void run() {
                NearByGeneralManager.this.e(qQAppInterface);
            }
        }, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final QQAppInterface qQAppInterface) {
        nearbyControl$GetMasterControlReq nearbycontrol_getmastercontrolreq = new nearbyControl$GetMasterControlReq();
        nearbycontrol_getmastercontrolreq.source.set("Android");
        nearbycontrol_getmastercontrolreq.req_flag.set(Arrays.asList(108));
        com.tencent.mobileqq.newnearby.servlet.b.a(new ServletObserver() { // from class: com.tencent.mobileqq.nearby.NearByGeneralManager.2
            @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
            public void c(int i3, byte[] bArr, Bundle bundle) {
                if (i3 != 0) {
                    QLog.e("NearByGeneralManager", 1, "reqNearbyControl GetMasterControlReq, errCode=" + i3);
                    return;
                }
                try {
                    nearbyControl$GetMasterControlRsp nearbycontrol_getmastercontrolrsp = (nearbyControl$GetMasterControlRsp) MessageMicro.mergeFrom(new nearbyControl$GetMasterControlRsp(), bArr);
                    if (nearbycontrol_getmastercontrolrsp.control_flag.isEmpty()) {
                        QLog.e("NearByGeneralManager", 1, "reqNearbyControl control_flag is empty");
                        return;
                    }
                    final nearbyControl$ControlFlag nearbycontrol_controlflag = nearbycontrol_getmastercontrolrsp.control_flag.get(0);
                    if (nearbycontrol_controlflag != null) {
                        if (Looper.getMainLooper() != Looper.myLooper()) {
                            NearByGeneralManager.this.f(nearbycontrol_controlflag, qQAppInterface);
                        } else {
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.NearByGeneralManager.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    NearByGeneralManager.this.f(nearbycontrol_controlflag, qQAppInterface);
                                }
                            }, 64, null, true);
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("NearByGeneralManager", 1, "reqNearbyControl GetMasterControlReq, Exception!", e16);
                }
            }
        }, nearbycontrol_getmastercontrolreq.toByteArray(), "trpc.nearby.trpc_nearby_control.nearby_control.GetMasterControl");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(nearbyControl$ControlFlag nearbycontrol_controlflag, QQAppInterface qQAppInterface) {
        QLog.i("NearByGeneralManager", 1, "updateNearbyShieldStatusLocal, shieldFlag: " + nearbycontrol_controlflag.value.get());
        com.tencent.mobileqq.nearby.api.e.t(qQAppInterface.getAccount(), INearbySPUtil.SP_KEY_SELF_NEARBY_SHIELD_STATUS, Boolean.valueOf(nearbycontrol_controlflag.value.get() != 2));
        if (nearbycontrol_controlflag.value.get() == 1) {
            com.tencent.mobileqq.nearby.api.e.t(qQAppInterface.getAccount(), INearbySPUtil.SP_KEY_SELF_NEARBY_VERITY_URL, nearbycontrol_controlflag.wording.get());
        }
    }

    @Override // com.tencent.mobileqq.nearby.a
    public boolean a() {
        return this.f252496h;
    }

    @Override // com.tencent.mobileqq.nearby.a
    public void b(boolean z16) {
        SharedPreferences sharedPreferences;
        if (this.f252496h == z16 || (sharedPreferences = this.f252494e) == null) {
            return;
        }
        this.f252496h = z16;
        sharedPreferences.edit().putBoolean("key_allow_nearby_like", z16).commit();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
