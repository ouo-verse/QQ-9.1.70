package hc0;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeUser;
import com.tencent.tedger.outapi.beans.EdgeUser;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f implements com.tencent.tedger.outapi.delegate.a {
    @Override // com.tencent.tedger.outapi.delegate.a
    public EdgeUser a(byte[] bArr) {
        return QFSEdgeUser.getEdgeUser(bArr);
    }
}
