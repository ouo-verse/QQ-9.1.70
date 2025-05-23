package hc0;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class n implements com.tencent.tedger.outapi.delegate.b {
    @Override // com.tencent.tedger.outapi.delegate.b
    public boolean a(String str, String str2) {
        return false;
    }

    @Override // com.tencent.tedger.outapi.delegate.b
    public boolean b(String str, List<com.tencent.tedger.outapi.beans.a> list) {
        if (list == null) {
            return false;
        }
        QLog.d("TEDGEQFS_QFSRerankDatabaseDelegate", 1, "saveDate  tabName:" + str + ",items size:" + list.size());
        for (com.tencent.tedger.outapi.beans.a aVar : list) {
            if (aVar != null) {
                ic0.c.d().e(str, aVar.f375273a, aVar.f375274b, aVar.f375275c);
            }
        }
        return true;
    }

    @Override // com.tencent.tedger.outapi.delegate.b
    public com.tencent.tedger.outapi.beans.a c(String str, String str2) {
        return ic0.c.d().g(str, str2);
    }

    @Override // com.tencent.tedger.outapi.delegate.b
    public int d(String str, String str2, String[] strArr) {
        QLog.d("TEDGEQFS_QFSRerankDatabaseDelegate", 4, "delete tabName:" + str);
        return ic0.c.d().b(str, str2, strArr);
    }

    @Override // com.tencent.tedger.outapi.delegate.b
    public List<com.tencent.tedger.outapi.beans.a> e(String str, String str2, boolean z16) {
        Integer valueOf;
        List<com.tencent.tedger.outapi.beans.a> f16 = ic0.c.d().f(str, str2, z16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getData  tabName:");
        sb5.append(str);
        sb5.append("\uff0cdata is ");
        if (f16 == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(f16.size());
        }
        sb5.append(valueOf);
        QLog.d("TEDGEQFS_QFSRerankDatabaseDelegate", 1, sb5.toString());
        return f16;
    }
}
