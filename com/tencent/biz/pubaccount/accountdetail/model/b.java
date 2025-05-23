package com.tencent.biz.pubaccount.accountdetail.model;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    Context f79111a;

    /* renamed from: b, reason: collision with root package name */
    Activity f79112b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0800b f79113c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f79114d = true;

    /* renamed from: e, reason: collision with root package name */
    BroadcastReceiver f79115e = new a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailVideoManager", 2, "onReceive ===>" + action);
            }
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action) || ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(action)) {
                b.this.a();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.accountdetail.model.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public interface InterfaceC0800b {
    }

    public b(Activity activity, InterfaceC0800b interfaceC0800b) {
        this.f79111a = activity.getApplicationContext();
        this.f79112b = activity;
        this.f79113c = interfaceC0800b;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        this.f79111a.registerReceiver(this.f79115e, intentFilter);
    }

    public void d(boolean z16) {
    }

    public void a() {
    }

    public void c() {
    }

    public void b(PublicAccountConfigAttrImpl publicAccountConfigAttrImpl, FrameLayout frameLayout) {
    }
}
