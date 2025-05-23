package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.teamwork.api.ISeparateForwardProxy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes18.dex */
public class SeparateForwardProxyImpl implements ISeparateForwardProxy {
    private com.tencent.mobileqq.activity.chathistory.b forwardManager;

    @Override // com.tencent.mobileqq.teamwork.api.ISeparateForwardProxy
    public void createSeparateForward(Activity activity, int i3) {
        if (activity instanceof QBaseActivity) {
            this.forwardManager = new com.tencent.mobileqq.activity.chathistory.b((QBaseActivity) activity, 109);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ISeparateForwardProxy
    public void forward(Object obj) {
        if (this.forwardManager != null && (obj instanceof List)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (List) obj) {
                if (obj2 instanceof ChatMessage) {
                    arrayList.add((ChatMessage) obj2);
                }
            }
            this.forwardManager.c(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ISeparateForwardProxy
    public void onCreate() {
        com.tencent.mobileqq.activity.chathistory.b bVar = this.forwardManager;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ISeparateForwardProxy
    public void onDestroy() {
        com.tencent.mobileqq.activity.chathistory.b bVar = this.forwardManager;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ISeparateForwardProxy
    public void onFowardActivityResult(Intent intent) {
        com.tencent.mobileqq.activity.chathistory.b bVar = this.forwardManager;
        if (bVar != null) {
            bVar.h(intent);
        }
    }
}
