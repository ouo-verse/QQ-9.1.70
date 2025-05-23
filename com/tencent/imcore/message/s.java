package com.tencent.imcore.message;

import com.tencent.mobileqq.app.QQMessageFacadeConfig;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class s {
    static IPatchRedirector $redirector_;

    public static void a() {
        try {
            ArrayList<Class<? extends MessageRecord.Callback>> arrayList = QQMessageFacadeConfig.sMessageRecordCallbackCls;
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }
}
