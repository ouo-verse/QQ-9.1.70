package com.tencent.qq.minibox.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AvailableCheckTask implements Handler.Callback {

    /* renamed from: e, reason: collision with root package name */
    private BroadcastReceiver f344479e;

    /* renamed from: d, reason: collision with root package name */
    private final List<bs3.b> f344478d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private volatile int f344480f = 0;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f344481h = true;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f344482i = false;

    /* renamed from: m, reason: collision with root package name */
    private WeakReferenceHandler f344483m = new WeakReferenceHandler(Looper.getMainLooper(), this);
    private final List<String> C = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("ACTION_MINI_BOX_AVAILABLE_CHECK".equals(intent.getAction())) {
                AvailableCheckTask.this.f344480f = intent.getIntExtra("EXTRA_KEY_CHECK_STEP", 0);
                QLog.i("minibox_va_AvailableCheckTask", 1, "initCheckReceiver onReceive availableCheckStep:" + AvailableCheckTask.this.f344480f);
                if (100 == AvailableCheckTask.this.f344480f) {
                    AvailableCheckTask.this.f344481h = true;
                    AvailableCheckTask.this.h();
                    AvailableCheckTask.this.i(3);
                } else if (4 == AvailableCheckTask.this.f344480f) {
                    AvailableCheckTask.this.f344481h = false;
                    AvailableCheckTask.this.h();
                    AvailableCheckTask.this.i(2);
                }
            }
        }
    }

    public AvailableCheckTask() {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f344478d.isEmpty()) {
            synchronized (this.f344478d) {
                QLog.i("minibox_va_AvailableCheckTask", 1, "callbackCheckFinish isAvailable:" + this.f344481h + " availableCheckStep:" + this.f344480f);
                Iterator<bs3.b> it = this.f344478d.iterator();
                while (it.hasNext()) {
                    it.next().onChecked(this.f344481h, this.f344480f, "");
                }
                this.f344478d.clear();
                n();
            }
        }
        this.f344483m.removeMessages(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("ext7", String.valueOf(i3));
        ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989385", "8", "", hashMap);
    }

    private void j() {
        if (this.f344479e == null) {
            this.f344479e = new a();
            BaseApplication.getContext().registerReceiver(this.f344479e, new IntentFilter("ACTION_MINI_BOX_AVAILABLE_CHECK"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            QLog.e("minibox_va_AvailableCheckTask", 1, "isArm64Runtime: do not support.version=" + i3);
            return false;
        }
        return Process.is64Bit();
    }

    private void n() {
        if (this.f344479e != null) {
            try {
                BaseApplication.getContext().unregisterReceiver(this.f344479e);
            } catch (Exception e16) {
                QLog.e("minibox_va_AvailableCheckTask", 1, "unregisterCheckReceiver", e16);
            }
            this.f344479e = null;
        }
    }

    public void g(bs3.b bVar) {
        synchronized (this.f344478d) {
            this.f344478d.remove(bVar);
            this.f344478d.add(bVar);
            j();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 255) {
            QLog.i("minibox_va_AvailableCheckTask", 1, "handleMessage MSG_CODE_CHECK_TIME_OUT");
            h();
            i(1);
            return false;
        }
        return false;
    }

    public boolean l(String str) {
        boolean z16 = false;
        if (this.f344478d.isEmpty()) {
            QLog.e("minibox_va_AvailableCheckTask", 1, "onCrashReport has callback! availableCheckListeners.isEmpty()");
            return false;
        }
        if (this.C.isEmpty()) {
            QLog.e("minibox_va_AvailableCheckTask", 1, "onCrashReport crashRules.isEmpty()");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("minibox_va_AvailableCheckTask", 1, "onCrashReport TextUtils.isEmpty(crashStack))");
            return false;
        }
        Iterator<String> it = this.C.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (str.contains(next)) {
                this.f344481h = false;
                QLog.e("minibox_va_AvailableCheckTask", 1, "onCrashReport match! rule:" + next);
                z16 = true;
                break;
            }
        }
        if (z16) {
            h();
            i(2);
        }
        return z16;
    }

    public void m(Boolean bool, int i3, List<String> list) {
        this.f344481h = bool.booleanValue();
        if (list.isEmpty()) {
            h();
            return;
        }
        this.C.clear();
        this.C.addAll(list);
        QLog.i("minibox_va_AvailableCheckTask", 1, "startCheck ");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qq.minibox.api.impl.AvailableCheckTask.2
            @Override // java.lang.Runnable
            public void run() {
                AvailableCheckTask.this.i(0);
                if (!AvailableCheckTask.this.k()) {
                    AvailableCheckTask.this.f344481h = false;
                    AvailableCheckTask.this.f344480f = -1;
                    AvailableCheckTask.this.h();
                    return;
                }
                MiniBoxSDK.checkAvailable("");
            }
        }, 16, null, false);
        this.f344483m.sendEmptyMessageDelayed(255, i3);
    }
}
