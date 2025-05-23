package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.app.bf;
import com.tencent.mobileqq.app.bi;
import com.tencent.mobileqq.app.bj;
import com.tencent.mobileqq.app.bm;
import com.tencent.mobileqq.gamecenter.api.IGameCenterMyGameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFinancialApi;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.util.conversationtitlebutton.api.IConversationTitleBtnFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new bi());
        arrayList.add(new bm());
        arrayList.add(new com.tencent.mobileqq.pluspanel.b());
        arrayList.add(new bj());
        arrayList.add(new bf());
        try {
            arrayList.add(new ma2.a());
            arrayList.add(new com.tencent.mobileqq.matchfriend.entry.a());
        } catch (Throwable th5) {
            QLog.w("RedTouchConfig", 1, "[getDynamicRedPointPathList] exc:" + th5.getMessage());
        }
        try {
            arrayList.add(new dh3.a());
        } catch (Throwable th6) {
            QLog.w("RedTouchConfig", 1, "[getDynamicRedPointPathList] exc:" + th6.getMessage());
        }
        try {
            arrayList.add(((IConversationTitleBtnFactory) QRoute.api(IConversationTitleBtnFactory.class)).createTitleButtonDynamicRedPoint());
        } catch (Throwable th7) {
            QLog.w("RedTouchConfig", 1, "[getDynamicRedPointPathList] exc:" + th7.getMessage());
        }
        try {
            arrayList.add(((IQWalletFinancialApi) QRoute.api(IQWalletFinancialApi.class)).getFinancialDynamicRedPointPathInterface());
        } catch (Throwable th8) {
            QLog.w("RedTouchConfig", 1, "[getDynamicRedPointPathList] exc:" + th8.getMessage());
        }
        try {
            arrayList.add(((IGameCenterMyGameApi) QRoute.api(IGameCenterMyGameApi.class)).getMyGameRedPointPathInterface());
        } catch (Throwable th9) {
            QLog.w("RedTouchConfig", 1, "[getMyGameRedPointPathInterface] exc:" + th9.getMessage());
        }
        return arrayList;
    }
}
