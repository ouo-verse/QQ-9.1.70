package com.tencent.qqperf.monitor.crash.catchedexception;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes25.dex */
public class CaughtException extends Exception {
    private static HashSet<String> spareStackWords = new HashSet<String>() { // from class: com.tencent.qqperf.monitor.crash.catchedexception.CaughtException.1
        {
            add(CaughtException.class.getName());
            add(a.class.getName());
        }
    };

    public CaughtException(String str) {
        this(str, null);
    }

    private void filterSpareStack() {
        StackTraceElement[] stackTrace = getStackTrace();
        ArrayList arrayList = new ArrayList(stackTrace.length);
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!spareStack(stackTraceElement)) {
                arrayList.add(stackTraceElement);
            }
        }
        setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
    }

    private void modifySelfMessage() {
        String message = getMessage();
        try {
            Field declaredField = Throwable.class.getDeclaredField("detailMessage");
            declaredField.setAccessible(true);
            declaredField.set(this, "\u8fd9\u4e0d\u662f\u5f02\u5e38" + message);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (NoSuchFieldException e17) {
            e17.printStackTrace();
        }
    }

    private boolean spareStack(StackTraceElement stackTraceElement) {
        Iterator<String> it = spareStackWords.iterator();
        while (it.hasNext()) {
            if (stackTraceElement.toString().contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public CaughtException(String str, Throwable th5) {
        super(str, th5);
        filterSpareStack();
        modifySelfMessage();
    }

    public CaughtException(Throwable th5) {
        super(th5);
    }
}
