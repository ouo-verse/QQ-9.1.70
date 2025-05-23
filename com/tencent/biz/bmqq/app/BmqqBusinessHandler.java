package com.tencent.biz.bmqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import nx.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BmqqBusinessHandler extends BusinessHandler {
    public BmqqBusinessHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = false;
        if (obj == null) {
            notifyUI(1001, false, null);
            return;
        }
        Bundle bundle = (Bundle) obj;
        int i3 = bundle.getInt("result");
        BmqqUserSimpleInfo bmqqUserSimpleInfo = (BmqqUserSimpleInfo) bundle.getParcelable("info");
        if (i3 == 0 && bmqqUserSimpleInfo != null) {
            ((QidianManager) this.appRuntime.getManager(QQManagerFactory.QIDIAN_MANAGER)).k0(bmqqUserSimpleInfo);
            z16 = true;
        }
        notifyUI(1001, z16, bmqqUserSimpleInfo);
    }

    public void E2(String str) {
        if (!a.b(this.appRuntime.getApplication(), str)) {
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("hrtxformqq.service", this.appRuntime.getAccount(), "hrtxformqq.getUsrSimpleInfo");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uin", Long.valueOf(str));
        toServiceMsg.setAttributes(hashMap);
        send(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return mx.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if ("hrtxformqq.getUsrSimpleInfo".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            D2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
