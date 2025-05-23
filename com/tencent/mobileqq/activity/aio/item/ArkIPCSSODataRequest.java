package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateSSO;
import com.tencent.ark.open.delegate.IArkDelegateSSOCallback;
import com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

/* loaded from: classes10.dex */
class ArkIPCSSODataRequest extends ArkSSODataRequest {
    public ArkIPCSSODataRequest(String str) {
        super(null, str);
    }

    @Override // com.tencent.mobileqq.activity.aio.item.ArkSSODataRequest
    protected boolean k(final ArkSSODataRequest.a aVar, int i3) {
        final WeakReference weakReference = new WeakReference(this);
        IArkDelegateSSO sSODelegate = ArkDelegateManager.getInstance().getSSODelegate();
        if (sSODelegate == null) {
            return false;
        }
        sSODelegate.send(aVar.f179322a, aVar.f179323b, i3, new IArkDelegateSSOCallback() { // from class: com.tencent.mobileqq.activity.aio.item.ArkIPCSSODataRequest.1
            @Override // com.tencent.ark.open.delegate.IArkDelegateSSOCallback
            public void onComplete(boolean z16, Object obj) {
                final int i16;
                if (z16) {
                    i16 = 0;
                } else {
                    i16 = -1;
                }
                final String str = (String) obj;
                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(ArkIPCSSODataRequest.this.f179312g, new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.ArkIPCSSODataRequest.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArkIPCSSODataRequest arkIPCSSODataRequest = (ArkIPCSSODataRequest) weakReference.get();
                        if (arkIPCSSODataRequest == null) {
                            return;
                        }
                        arkIPCSSODataRequest.j(aVar, i16, str);
                    }
                });
            }
        });
        return true;
    }
}
