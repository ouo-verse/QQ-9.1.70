package oicq.wlogin_sdk.tlv_type;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class tlv_t511 extends tlv_t {
    public tlv_t511() {
        this._cmd = 1297;
    }

    public byte[] get_tlv_511(List<String> list) {
        boolean z16;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && str.length() != 0) {
                arrayList.add(str);
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.putShort((short) arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (str2 != null && str2.length() != 0) {
                int indexOf = str2.indexOf(40);
                int indexOf2 = str2.indexOf(41);
                byte b16 = 1;
                if (indexOf == 0 && indexOf2 > 0) {
                    int intValue = Integer.valueOf(str2.substring(indexOf + 1, indexOf2)).intValue();
                    byte b17 = 0;
                    if ((1048576 & intValue) > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if ((intValue & 134217728) > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z16) {
                        b17 = (byte) 1;
                    }
                    if (z17) {
                        b16 = (byte) (b17 | 2);
                    } else {
                        b16 = b17;
                    }
                    str2 = str2.substring(indexOf2 + 1);
                }
                allocate.put(b16);
                allocate.putShort((short) str2.length());
                allocate.put(str2.getBytes());
            }
        }
        fill_head(this._cmd);
        fill_body(allocate.array(), allocate.position());
        set_length();
        return get_buf();
    }
}
