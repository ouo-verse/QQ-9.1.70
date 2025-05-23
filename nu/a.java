package nu;

import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a {
    public Object a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        return null;
    }

    public boolean b(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        return false;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<String> d16 = d();
        if (d16.isEmpty()) {
            return false;
        }
        Iterator<String> it = d16.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public abstract List<String> d();
}
