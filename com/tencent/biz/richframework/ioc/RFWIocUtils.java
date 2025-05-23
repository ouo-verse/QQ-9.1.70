package com.tencent.biz.richframework.ioc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWIocUtils {
    public static CopyOnWriteArrayList<String> object2CopyOnWriteArrayListOfString(Object obj) {
        if (!(obj instanceof CopyOnWriteArrayList)) {
            return null;
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = (CopyOnWriteArrayList) obj;
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (!(it.next() instanceof String)) {
                return null;
            }
        }
        return copyOnWriteArrayList;
    }
}
