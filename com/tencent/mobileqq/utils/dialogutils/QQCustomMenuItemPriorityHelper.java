package com.tencent.mobileqq.utils.dialogutils;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes20.dex */
public class QQCustomMenuItemPriorityHelper {

    /* renamed from: a, reason: collision with root package name */
    private static int f307646a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public static final int f307647b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Integer> f307648c;

    /* loaded from: classes20.dex */
    class a implements Comparator<b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            if (bVar == bVar2) {
                return 0;
            }
            if (bVar == null) {
                return 1;
            }
            if (bVar2 == null) {
                return -1;
            }
            return bVar2.f307674d - bVar.f307674d;
        }
    }

    static {
        int i3;
        if (ViewUtils.getDensity() > 1.5f && FontSettingManager.getFontLevel() <= 16.0f) {
            i3 = 5;
        } else {
            i3 = 4;
        }
        f307647b = i3;
        f307648c = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper.1
            {
                String string = BaseApplication.getContext().getString(R.string.f207685ao);
                int i16 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i16 - 1;
                put(string, Integer.valueOf(i16));
                String string2 = BaseApplication.getContext().getString(R.string.f207465a3);
                int i17 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i17 - 1;
                put(string2, Integer.valueOf(i17));
                String string3 = BaseApplication.getContext().getString(R.string.f207815b1);
                int i18 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i18 - 1;
                put(string3, Integer.valueOf(i18));
                String string4 = BaseApplication.getContext().getString(R.string.f207855b5);
                int i19 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i19 - 1;
                put(string4, Integer.valueOf(i19));
                String string5 = BaseApplication.getContext().getString(R.string.f207825b2);
                int i26 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i26 - 1;
                put(string5, Integer.valueOf(i26));
                String string6 = BaseApplication.getContext().getString(R.string.f208645d_);
                int i27 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i27 - 1;
                put(string6, Integer.valueOf(i27));
                String string7 = BaseApplication.getContext().getString(R.string.f207835b3);
                int i28 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i28 - 1;
                put(string7, Integer.valueOf(i28));
                String string8 = BaseApplication.getContext().getString(R.string.f207805b0);
                int i29 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i29 - 1;
                put(string8, Integer.valueOf(i29));
                String string9 = BaseApplication.getContext().getString(R.string.f207695ap);
                int i36 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i36 - 1;
                put(string9, Integer.valueOf(i36));
                String string10 = BaseApplication.getContext().getString(R.string.f208635d9);
                int i37 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i37 - 1;
                put(string10, Integer.valueOf(i37));
                String string11 = BaseApplication.getContext().getString(R.string.f207455a2);
                int i38 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i38 - 1;
                put(string11, Integer.valueOf(i38));
                String string12 = BaseApplication.getContext().getString(R.string.f207565ac);
                int i39 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i39 - 1;
                put(string12, Integer.valueOf(i39));
                String string13 = BaseApplication.getContext().getString(R.string.f207555ab);
                int i46 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i46 - 1;
                put(string13, Integer.valueOf(i46));
                String string14 = BaseApplication.getContext().getString(R.string.f207635aj);
                int i47 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i47 - 1;
                put(string14, Integer.valueOf(i47));
                String string15 = BaseApplication.getContext().getString(R.string.f207755av);
                int i48 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i48 - 1;
                put(string15, Integer.valueOf(i48));
                String string16 = BaseApplication.getContext().getString(R.string.f208395cl);
                int i49 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i49 - 1;
                put(string16, Integer.valueOf(i49));
                String string17 = BaseApplication.getContext().getString(R.string.f207585ae);
                int i56 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i56 - 1;
                put(string17, Integer.valueOf(i56));
                String string18 = BaseApplication.getContext().getString(R.string.f208625d8);
                int i57 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i57 - 1;
                put(string18, Integer.valueOf(i57));
                String string19 = BaseApplication.getContext().getString(R.string.f208185c1);
                int i58 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i58 - 1;
                put(string19, Integer.valueOf(i58));
                String string20 = BaseApplication.getContext().getString(R.string.f207615ah);
                int i59 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i59 - 1;
                put(string20, Integer.valueOf(i59));
                String string21 = BaseApplication.getContext().getString(R.string.f207525a9);
                int i65 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i65 - 1;
                put(string21, Integer.valueOf(i65));
                String string22 = BaseApplication.getContext().getString(R.string.f207535a_);
                int i66 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i66 - 1;
                put(string22, Integer.valueOf(i66));
                String string23 = BaseApplication.getContext().getString(R.string.f207505a7);
                int i67 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i67 - 1;
                put(string23, Integer.valueOf(i67));
                String string24 = BaseApplication.getContext().getString(R.string.f207495a6);
                int i68 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i68 - 1;
                put(string24, Integer.valueOf(i68));
                String string25 = BaseApplication.getContext().getString(R.string.f208405cm);
                int i69 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i69 - 1;
                put(string25, Integer.valueOf(i69));
                String string26 = BaseApplication.getContext().getString(R.string.f208745dj);
                int i75 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i75 - 1;
                put(string26, Integer.valueOf(i75));
                String string27 = BaseApplication.getContext().getString(R.string.f208705df);
                int i76 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i76 - 1;
                put(string27, Integer.valueOf(i76));
                String string28 = BaseApplication.getContext().getString(R.string.f208715dg);
                int i77 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i77 - 1;
                put(string28, Integer.valueOf(i77));
                String string29 = BaseApplication.getContext().getString(R.string.f207545aa);
                int i78 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i78 - 1;
                put(string29, Integer.valueOf(i78));
                String string30 = BaseApplication.getContext().getString(R.string.f207845b4);
                int i79 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i79 - 1;
                put(string30, Integer.valueOf(i79));
                String string31 = BaseApplication.getContext().getString(R.string.f208215c4);
                int i85 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i85 - 1;
                put(string31, Integer.valueOf(i85));
                String string32 = BaseApplication.getContext().getString(R.string.f208445cq);
                int i86 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i86 - 1;
                put(string32, Integer.valueOf(i86));
                String string33 = BaseApplication.getContext().getString(R.string.f207625ai);
                int i87 = QQCustomMenuItemPriorityHelper.f307646a;
                QQCustomMenuItemPriorityHelper.f307646a = i87 - 1;
                put(string33, Integer.valueOf(i87));
                put(BaseApplication.getContext().getString(R.string.f207445a1), -2147483647);
                put(BaseApplication.getContext().getString(R.string.f207765aw), Integer.MIN_VALUE);
            }
        };
    }

    public static int c(String str) {
        Integer num = f307648c.get(str);
        if (num != null) {
            return num.intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQCustomMenuItemPriorityHelper", 2, "[menu] menu '" + str + "' priority not init ");
        }
        int i3 = f307646a;
        f307646a = i3 - 1;
        return i3;
    }

    public static void d(com.tencent.mobileqq.utils.dialogutils.a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f307669a);
        Collections.sort(arrayList, new a());
        Iterator it = arrayList.iterator();
        b bVar = null;
        b bVar2 = null;
        b bVar3 = null;
        b bVar4 = null;
        b bVar5 = null;
        while (it.hasNext()) {
            b bVar6 = (b) it.next();
            if (bVar6 != null) {
                if (bVar6.f307671a.equals(BaseApplication.getContext().getString(R.string.f207765aw))) {
                    bVar4 = bVar6;
                } else if (bVar6.f307671a.equals(BaseApplication.getContext().getString(R.string.f207445a1))) {
                    bVar5 = bVar6;
                } else if (bVar6.f307671a.equals(BaseApplication.getContext().getString(R.string.f207685ao))) {
                    bVar = bVar6;
                } else if (bVar6.f307671a.equals(BaseApplication.getContext().getString(R.string.f207755av))) {
                    bVar2 = bVar6;
                } else if (bVar6.f307671a.equals(BaseApplication.getContext().getString(R.string.f207525a9))) {
                    bVar3 = bVar6;
                }
            }
        }
        if (bVar != null && bVar.f307675e) {
            arrayList.remove(bVar);
            arrayList.add(bVar);
        }
        if (bVar2 != null && bVar2.f307675e && bVar3 != null) {
            arrayList.remove(bVar2);
            arrayList.add(arrayList.indexOf(bVar3), bVar2);
        }
        if (bVar5 != null) {
            arrayList.remove(bVar5);
            arrayList.add(bVar5);
        }
        if (bVar4 != null) {
            arrayList.remove(bVar4);
            int size = arrayList.size();
            int i3 = f307647b;
            if (size >= i3) {
                arrayList.add(i3 - 1, bVar4);
            } else {
                arrayList.add(bVar4);
            }
        }
        aVar.f307669a.clear();
        aVar.f307669a.addAll(arrayList);
    }
}
