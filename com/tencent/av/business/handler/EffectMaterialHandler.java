package com.tencent.av.business.handler;

import android.os.Bundle;
import com.tencent.av.business.servlet.EffectMaterialService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EffectMaterialHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private List<eu.a<EffectMaterialHandler>> f73263d;

    /* renamed from: e, reason: collision with root package name */
    private EffectMaterialService f73264e;

    protected EffectMaterialHandler(AppInterface appInterface) {
        super(appInterface);
        this.f73263d = new ArrayList();
        this.f73264e = new EffectMaterialService(appInterface);
        E2();
    }

    public EffectMaterialService D2() {
        return this.f73264e;
    }

    void E2() {
        this.f73263d.add(new eu.b(this.appRuntime, this));
    }

    public void F2(String str, String str2) {
        QLog.i("EffectMaterialHandler", 1, "requestEffectMaterials service id " + str);
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.i("EffectMaterialHandler", 1, "requestEffectMaterials no network");
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetCatMatTree");
        Bundle bundle = toServiceMsg.extraData;
        bundle.putString("ServiceId", str);
        bundle.putString("GroupId", str2);
        this.f73264e.d(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("ShadowBackendSvc.GetCatMatTree");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            if (QLog.isColorLevel()) {
                QLog.i("EffectMaterialHandler", 2, "onReceive cmd: " + toServiceMsg.getServiceCmd());
            }
            for (eu.a<EffectMaterialHandler> aVar : this.f73263d) {
                if (aVar.a(toServiceMsg.getServiceCmd())) {
                    aVar.c(toServiceMsg, fromServiceMsg, obj);
                }
            }
            return;
        }
        QLog.e("EffectMaterialHandler", 1, "onReceive req == null || res == null");
    }
}
