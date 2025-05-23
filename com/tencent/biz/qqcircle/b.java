package com.tencent.biz.qqcircle;

import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements IModule.FocusChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public static final b f82683f = new b();

    /* renamed from: d, reason: collision with root package name */
    private IModule f82684d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f82685e = false;

    b() {
        IModule moduleByName = AVBizModuleFactory.getModuleByName(Constants.Business.QQCIRCLE);
        this.f82684d = moduleByName;
        moduleByName.setListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f82684d.abandonAVFocus();
    }

    public void b() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.c();
            }
        });
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusGain() {
        QLog.d("AVController", 1, "AVFocusGain:" + hashCode());
        this.f82685e = false;
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusLoss() {
        QLog.d("AVController", 1, "AVFocusLoss:" + hashCode());
        this.f82685e = true;
    }
}
