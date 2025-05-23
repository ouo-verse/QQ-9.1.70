package com.tencent.mobileqq.vas.hippy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    Activity f309489a;

    /* renamed from: b, reason: collision with root package name */
    public Context f309490b;

    /* renamed from: c, reason: collision with root package name */
    a f309491c = new a();

    /* renamed from: d, reason: collision with root package name */
    QQProgressDialog f309492d;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends VipFunCallObserver {

        /* renamed from: d, reason: collision with root package name */
        Promise f309493d;

        public a() {
        }

        public void a(Promise promise) {
            this.f309493d = promise;
        }

        @Override // com.tencent.mobileqq.vas.vipav.VipFunCallObserver, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            try {
                Bundle bundle = (Bundle) obj;
                c.this.b(false, 0);
                if (bundle == null) {
                    QLog.e("VasFunCallHippyHelper", 1, "fcObserver.onUpdate dataBundle=null");
                    this.f309493d.reject("fcObserver.onUpdate dataBundle=null");
                    return;
                }
                int i16 = bundle.getInt("result", -1);
                if (i16 != 0) {
                    this.f309493d.reject(d.a(i16, "fcObserver.onUpdate dataBundle is null", null));
                    return;
                }
                this.f309493d.resolve(d.a(0, "success", obj));
                if (QLog.isColorLevel()) {
                    QLog.d("VasFunCallHippyHelper", 2, "fcObserver.onUpdate ret=" + i16 + ", type=" + i3 + ", isSuccess=" + z16);
                }
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (qQAppInterface == null) {
                    return;
                }
                qQAppInterface.removeObserver(this);
            } catch (Exception e16) {
                QLog.e("VasFunCallHippyHelper", 1, "fcObserver onUpdate Err:" + e16.getMessage());
            }
        }
    }

    public c(Context context, Activity activity) {
        this.f309490b = context;
        this.f309489a = activity;
    }

    public void a(HippyMap hippyMap, Promise promise) {
        Bundle bundle = new Bundle();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        this.f309491c.a(promise);
        VipSetFunCallHandler vipSetFunCallHandler = (VipSetFunCallHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
        int i3 = hippyMap.getInt("callId");
        int i16 = hippyMap.getInt(VipFunCallConstants.KEY_RING_ID);
        b(true, R.string.f173205i02);
        bundle.putInt("callId", i3);
        bundle.putInt(VipFunCallConstants.KEY_RING_ID, i16);
        bundle.putInt("from", 1);
        qQAppInterface.addObserver(this.f309491c);
        if (vipSetFunCallHandler != null) {
            vipSetFunCallHandler.P2(3, bundle);
        }
    }

    void b(boolean z16, int i3) {
        if (z16) {
            if (this.f309492d == null && (this.f309489a instanceof QBaseActivity)) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f309490b, ((QBaseActivity) this.f309489a).getTitleBarHeight());
                this.f309492d = qQProgressDialog;
                qQProgressDialog.setCancelable(true);
            }
            QQProgressDialog qQProgressDialog2 = this.f309492d;
            if (qQProgressDialog2 != null) {
                qQProgressDialog2.setMessage(i3);
                this.f309492d.show();
                return;
            }
            return;
        }
        QQProgressDialog qQProgressDialog3 = this.f309492d;
        if (qQProgressDialog3 != null && qQProgressDialog3.isShowing()) {
            this.f309492d.dismiss();
        }
    }
}
