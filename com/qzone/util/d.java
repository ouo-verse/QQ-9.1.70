package com.qzone.util;

import com.tencent.mobileqq.R;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d {
    public static <T> T[] a(T[] tArr, int i3, int i16) {
        int length = tArr.length;
        if (i3 > i16) {
            throw new IllegalArgumentException();
        }
        if (i3 >= 0 && i3 <= length) {
            int i17 = i16 - i3;
            int min = Math.min(i17, length - i3);
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i17));
            System.arraycopy(tArr, i3, tArr2, 0, min);
            return tArr2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static <T> T[] b(T[] tArr, int i3) {
        int length = tArr.length;
        if (i3 >= 0 && i3 < length) {
            LinkedList linkedList = new LinkedList();
            for (int i16 = 0; i16 < length; i16++) {
                if (i16 != i3) {
                    linkedList.add(tArr[i16]);
                }
            }
            return (T[]) a(linkedList.toArray(tArr), 0, r5.length - 1);
        }
        throw new IllegalArgumentException(l.a(R.string.f171608jr0));
    }

    public static <T> T[] c(T[] tArr, List<Integer> list) {
        int length = tArr.length;
        if (list != null && !list.isEmpty()) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue < 0 || intValue >= length) {
                    throw new IllegalArgumentException(l.a(R.string.f171609jr1));
                }
            }
            LinkedList linkedList = new LinkedList();
            int i3 = 0;
            while (true) {
                boolean z16 = true;
                if (i3 < length) {
                    Iterator<Integer> it5 = list.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        if (i3 == it5.next().intValue()) {
                            z16 = false;
                            break;
                        }
                    }
                    if (z16) {
                        linkedList.add(tArr[i3]);
                    }
                    i3++;
                } else {
                    Object[] array = linkedList.toArray(tArr);
                    return (T[]) a(array, 0, array.length - 1);
                }
            }
        } else {
            throw new IllegalArgumentException(l.a(R.string.jqz));
        }
    }
}
