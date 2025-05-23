package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.util.List;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class DataLineMsgIpadProxy extends DataLineMsgProxy {
    static IPatchRedirector $redirector_;

    public DataLineMsgIpadProxy(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) baseProxyManager);
        } else {
            this.f196493c = DataLineMsgRecord.tableName(1);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.DataLineMsgProxy
    public List<DataLineMsgRecord> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return DBMethodProxy.rawQuery(this.app.getEntityManagerFactory().createEntityManager(), DataLineMsgRecord.class, "select * from mr_data_line_ipad", null);
    }
}
