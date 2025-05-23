package com.tencent.mobileqq.friend.device;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.cq;
import com.tencent.mobileqq.app.k;
import com.tencent.mobileqq.config.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DeviceFragment extends ContactsBaseFragment implements c.b, Handler.Callback {
    protected XListView N;
    protected com.tencent.mobileqq.friend.device.b P;
    protected boolean Q;
    protected boolean R;
    protected boolean S = false;
    protected boolean T = true;
    private MqqWeakReferenceHandler U = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    private cq V = new a();
    private final bs W = new b();
    private final k X = new c();
    private final ar Y = new d();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends cq {
        a() {
        }

        @Override // com.tencent.mobileqq.app.cq
        protected void d(int i3) {
            DeviceFragment.this.P.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b extends bs {
        b() {
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onSelfIpadOnlineStatusUpdateNotify(int i3, int i16) {
            DeviceFragment deviceFragment = DeviceFragment.this;
            com.tencent.mobileqq.friend.device.b bVar = deviceFragment.P;
            if (bVar == null) {
                return;
            }
            deviceFragment.R = i3 != 0;
            bVar.o();
            DeviceFragment deviceFragment2 = DeviceFragment.this;
            deviceFragment2.P.n(deviceFragment2.R, AppConstants.DATALINE_IPAD_UIN);
            DeviceFragment.this.P.notifyDataSetChanged();
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onSelfPcOnlineStatusUpdateNotify(int i3, int i16) {
            DeviceFragment deviceFragment = DeviceFragment.this;
            com.tencent.mobileqq.friend.device.b bVar = deviceFragment.P;
            if (bVar == null) {
                return;
            }
            deviceFragment.Q = i3 != 0;
            bVar.p();
            DeviceFragment.this.P.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class c extends k {
        c() {
        }

        @Override // com.tencent.mobileqq.app.k
        protected void f() {
            com.tencent.mobileqq.friend.device.b bVar = DeviceFragment.this.P;
            if (bVar == null) {
                return;
            }
            bVar.p();
            DeviceFragment.this.P.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class d extends ar {
        d() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onPullIpad() {
            com.tencent.mobileqq.friend.device.b bVar = DeviceFragment.this.P;
            if (bVar == null) {
                return;
            }
            bVar.o();
            DeviceFragment.this.P.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void Ah() {
        com.tencent.mobileqq.friend.device.b bVar = this.P;
        if (bVar != null) {
            bVar.k();
            this.P.destroy();
            this.N.setAdapter((ListAdapter) null);
            this.P = null;
        }
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.W);
            this.E.removeObserver(this.X);
            this.E.removeObserver(this.Y);
            this.E.removeObserver(this.V);
            this.E.getConfigProcess().i(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG, this);
        }
    }

    public void Hh() {
        BaseApplication context = BaseApplication.getContext();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.E.getCurrentAccountUin());
        sb5.append(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_FILE);
        boolean z16 = context.getSharedPreferences(sb5.toString(), 0).getInt(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_SWITCH, 1) == 1;
        this.T = z16;
        com.tencent.mobileqq.friend.device.b bVar = this.P;
        if (bVar != null) {
            bVar.r(z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void doOnDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.DeviceFragment", 2, "doOnDestroy");
        }
        com.tencent.mobileqq.friend.device.b bVar = this.P;
        if (bVar != null) {
            bVar.k();
            this.P.destroy();
        }
        Ah();
        this.U.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.activity.contacts.base.h.a
    public View getScrollableView() {
        return this.N;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            boolean z16 = message.arg1 == 1;
            boolean z17 = this.T;
            if (z16 != z17) {
                boolean z18 = !z17;
                this.T = z18;
                com.tencent.mobileqq.friend.device.b bVar = this.P;
                if (bVar != null) {
                    bVar.r(z18);
                    this.P.notifyDataSetChanged();
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void ph() {
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface == null || !this.H) {
            return;
        }
        qQAppInterface.addObserver(this.W);
        this.E.addObserver(this.X);
        this.E.addObserver(this.Y);
        this.E.addObserver(this.V);
        this.E.getConfigProcess().a(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG, this);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void qh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.DeviceFragment", 2, "doOnPause:" + z16);
        }
        if (z16) {
            Ah();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void refresh() {
        ContactsBaseFragment.c cVar = this.C;
        if (cVar != null) {
            cVar.c(th(), true, null);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void resetData() {
        if (this.H && this.N != null) {
            com.tencent.mobileqq.friend.device.b bVar = new com.tencent.mobileqq.friend.device.b(this.K, this.E, this.N, 104, true);
            this.P = bVar;
            this.N.setAdapter((ListAdapter) bVar);
            this.P.n(this.Q, AppConstants.DATALINE_PC_UIN);
            this.P.n(this.R, AppConstants.DATALINE_IPAD_UIN);
            Hh();
            this.P.notifyDataSetChanged();
        } else {
            com.tencent.mobileqq.friend.device.b bVar2 = this.P;
            if (bVar2 != null) {
                bVar2.q(this.E);
            }
        }
        this.U.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void rh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("contacts.fragment.DeviceFragment", 2, "doOnResume:" + z16);
        }
        if (this.N == null) {
            return;
        }
        ph();
        if (this.P == null) {
            com.tencent.mobileqq.friend.device.b bVar = new com.tencent.mobileqq.friend.device.b(this.K, this.E, this.N, 104, true);
            this.P = bVar;
            this.N.setAdapter((ListAdapter) bVar);
        }
        Hh();
        this.P.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected View uh(LayoutInflater layoutInflater, Bundle bundle) {
        XListView xListView = this.N;
        if (xListView == null) {
            XListView xListView2 = new XListView(layoutInflater.getContext());
            this.N = xListView2;
            xListView2.setId(R.id.ehy);
            this.N.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.N.setNeedCheckSpringback(true);
            this.N.setCacheColorHint(0);
            this.N.setDivider(null);
            this.N.setOverScrollMode(0);
            this.N.setPadding(0, 0, 0, BaseAIOUtils.f(54.0f, getResources()));
            this.N.setClipToPadding(false);
            this.N.setScrollBarStyle(33554432);
            this.N.mForContacts = true;
        } else {
            ViewParent parent = xListView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.N);
            }
        }
        return this.N;
    }

    @Override // com.tencent.mobileqq.config.c.b
    public void onGetConfig(QQAppInterface qQAppInterface, int i3, String str, final c.a aVar) {
        if (aVar == null || !AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG.equals(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DeviceFragment", 2, "handleConfigForTag smartDeviceDiscoverCfg content = " + aVar.f202860d);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.friend.device.DeviceFragment.5
            @Override // java.lang.Runnable
            public void run() {
                Message obtainMessage;
                try {
                    try {
                        int optInt = new JSONObject(aVar.f202860d).optInt(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_SWITCH, 1);
                        DeviceFragment.this.U.removeCallbacksAndMessages(1);
                        obtainMessage = DeviceFragment.this.U.obtainMessage(1, optInt, 0);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        DeviceFragment.this.U.removeCallbacksAndMessages(1);
                        obtainMessage = DeviceFragment.this.U.obtainMessage(1, 1, 0);
                        obtainMessage.sendToTarget();
                    } catch (Exception unused) {
                        DeviceFragment.this.U.removeCallbacksAndMessages(1);
                        obtainMessage = DeviceFragment.this.U.obtainMessage(1, 1, 0);
                        obtainMessage.sendToTarget();
                    }
                    obtainMessage.sendToTarget();
                } catch (Throwable th5) {
                    DeviceFragment.this.U.removeCallbacksAndMessages(1);
                    DeviceFragment.this.U.obtainMessage(1, 1, 0).sendToTarget();
                    throw th5;
                }
            }
        }, 5, null, true);
    }
}
