package com.tencent.mobileqq.utils.dialogutils;

import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes20.dex */
public class QQCustomMenuItemGuildPriorityHelper {

    /* renamed from: a, reason: collision with root package name */
    private static int f307644a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, Integer> f307645b = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemGuildPriorityHelper.1
        {
            String string = BaseApplication.getContext().getString(R.string.f207775ax);
            int i3 = QQCustomMenuItemGuildPriorityHelper.f307644a;
            QQCustomMenuItemGuildPriorityHelper.f307644a = i3 - 1;
            put(string, Integer.valueOf(i3));
            String string2 = BaseApplication.getContext().getString(R.string.f207685ao);
            int i16 = QQCustomMenuItemGuildPriorityHelper.f307644a;
            QQCustomMenuItemGuildPriorityHelper.f307644a = i16 - 1;
            put(string2, Integer.valueOf(i16));
            String string3 = BaseApplication.getContext().getString(R.string.f207555ab);
            int i17 = QQCustomMenuItemGuildPriorityHelper.f307644a;
            QQCustomMenuItemGuildPriorityHelper.f307644a = i17 - 1;
            put(string3, Integer.valueOf(i17));
            String string4 = BaseApplication.getContext().getString(R.string.f208185c1);
            int i18 = QQCustomMenuItemGuildPriorityHelper.f307644a;
            QQCustomMenuItemGuildPriorityHelper.f307644a = i18 - 1;
            put(string4, Integer.valueOf(i18));
            String string5 = BaseApplication.getContext().getString(R.string.f207705aq);
            int i19 = QQCustomMenuItemGuildPriorityHelper.f307644a;
            QQCustomMenuItemGuildPriorityHelper.f307644a = i19 - 1;
            put(string5, Integer.valueOf(i19));
            String string6 = BaseApplication.getContext().getString(R.string.f207765aw);
            int i26 = QQCustomMenuItemGuildPriorityHelper.f307644a;
            QQCustomMenuItemGuildPriorityHelper.f307644a = i26 - 1;
            put(string6, Integer.valueOf(i26));
            String string7 = BaseApplication.getContext().getString(R.string.f207675an);
            int i27 = QQCustomMenuItemGuildPriorityHelper.f307644a;
            QQCustomMenuItemGuildPriorityHelper.f307644a = i27 - 1;
            put(string7, Integer.valueOf(i27));
            String string8 = BaseApplication.getContext().getString(R.string.f207665am);
            int i28 = QQCustomMenuItemGuildPriorityHelper.f307644a;
            QQCustomMenuItemGuildPriorityHelper.f307644a = i28 - 1;
            put(string8, Integer.valueOf(i28));
            String string9 = BaseApplication.getContext().getString(R.string.f207755av);
            int i29 = QQCustomMenuItemGuildPriorityHelper.f307644a;
            QQCustomMenuItemGuildPriorityHelper.f307644a = i29 - 1;
            put(string9, Integer.valueOf(i29));
        }
    };

    /* loaded from: classes20.dex */
    class a implements Comparator<b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            int i3;
            int i16;
            if (bVar == bVar2) {
                return 0;
            }
            if (bVar == null) {
                return 1;
            }
            if (bVar2 == null) {
                return -1;
            }
            if (QQCustomMenuItemGuildPriorityHelper.f307645b.containsKey(bVar.f307671a) && QQCustomMenuItemGuildPriorityHelper.f307645b.containsKey(bVar2.f307671a)) {
                i3 = ((Integer) QQCustomMenuItemGuildPriorityHelper.f307645b.get(bVar2.f307671a)).intValue();
                i16 = ((Integer) QQCustomMenuItemGuildPriorityHelper.f307645b.get(bVar.f307671a)).intValue();
            } else {
                i3 = bVar2.f307674d;
                i16 = bVar.f307674d;
            }
            return i3 - i16;
        }
    }

    public static void d(com.tencent.mobileqq.utils.dialogutils.a aVar) {
        b bVar;
        ArrayList arrayList = new ArrayList(aVar.f307669a);
        Collections.sort(arrayList, new a());
        String string = BaseApplication.getContext().getString(R.string.f207685ao);
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                bVar = (b) it.next();
                if (bVar != null && string.equals(bVar.f307671a)) {
                    break;
                }
            } else {
                bVar = null;
                break;
            }
        }
        if (bVar != null && bVar.f307675e) {
            arrayList.remove(bVar);
            int size = arrayList.size();
            String string2 = BaseApplication.getContext().getString(R.string.f207755av);
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (string2.equals(((b) arrayList.get(i3)).f307671a)) {
                    size = i3;
                    break;
                }
                i3++;
            }
            arrayList.add(size, bVar);
        }
        aVar.f307669a.clear();
        aVar.f307669a.addAll(arrayList);
    }
}
