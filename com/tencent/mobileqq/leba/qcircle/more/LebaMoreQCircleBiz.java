package com.tencent.mobileqq.leba.qcircle.more;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.qcircle.utils.c;
import com.tencent.mobileqq.leba.business.b;
import com.tencent.mobileqq.leba.entity.i;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetMultiCircleWnsConfigRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import mqq.app.AppRuntime;
import qqcircle.QQCircleSwitch$SetMultiCircleSwitchRsp;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaMoreQCircleBiz extends b {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleSwitch$SetMultiCircleSwitchRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f240730a;

        a(boolean z16) {
            this.f240730a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSwitch$SetMultiCircleSwitchRsp qQCircleSwitch$SetMultiCircleSwitchRsp) {
            if (!z16 || j3 != 0) {
                LebaMoreQCircleBiz.this.f(!this.f240730a);
                QLog.i("LebaMoreQCircleBiz", 1, "list setCircleSwitch error retcode= " + j3);
                return;
            }
            QLog.i("LebaMoreQCircleBiz", 1, "list setCircleSwitch success isChecked" + this.f240730a);
            if (!this.f240730a) {
                c.f().clearPedPoint();
                QLog.i("LebaMoreQCircleBiz", 1, "list setCircleSwitch success clearPedPoint");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z16) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.leba.qcircle.more.LebaMoreQCircleBiz.2
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                uq3.c.i7("qqcircle", "qqcircle_entrance_enable", str);
            }
        });
    }

    @Override // com.tencent.mobileqq.leba.business.b
    public boolean b(i iVar) {
        if (iVar == null || !iVar.f240490e || iVar.f240491f != 2 || a() == null) {
            return false;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xsj_main_entrance", QCircleDaTongConstant.ElementParamValue.QQ_UPDATES_TAB_SECOND);
        c.g().enterBySchemeAction(a(), QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE, hashMap, null);
        return true;
    }

    @Override // com.tencent.mobileqq.leba.business.b
    public void d(AppRuntime appRuntime, boolean z16, i iVar) {
        String str;
        n nVar;
        if (iVar == null) {
            return;
        }
        if (iVar.f240491f != 2 && ((nVar = iVar.f240488c) == null || nVar.f240504a != 4045)) {
            return;
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qqcircle_entrance_enable", str);
        f(z16);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("qqcircle", hashMap);
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetMultiCircleWnsConfigRequest(hashMap2), new a(z16));
    }
}
