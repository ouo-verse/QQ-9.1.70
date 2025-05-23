package com.tencent.mobileqq.phonecontact.util;

import android.text.TextUtils;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.phonecontact.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8222a implements Comparator<String> {
        static IPatchRedirector $redirector_;

        C8222a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            if ("\u2605".equals(str2)) {
                return 1;
            }
            if ("\u2605".equals(str) || "#".equals(str2)) {
                return -1;
            }
            if ("#".equals(str)) {
                return 1;
            }
            return str.compareTo(str2);
        }
    }

    public static com.tencent.mobileqq.phonecontact.data.a a(List<PhoneContact> list, ArrayList<PhoneContact> arrayList, boolean z16) {
        List<PhoneContact> list2;
        char c16;
        int i3;
        String valueOf;
        if (list == null) {
            list = new ArrayList<>();
        }
        com.tencent.mobileqq.phonecontact.data.a aVar = new com.tencent.mobileqq.phonecontact.data.a();
        aVar.f258459d = list;
        if (arrayList != null) {
            list2 = (List) arrayList.clone();
        } else {
            list2 = null;
        }
        Iterator<PhoneContact> it = list.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String str = "#";
            i3 = 0;
            if (!hasNext) {
                break;
            }
            PhoneContact next = it.next();
            if (TextUtils.isEmpty(next.pinyinFirst)) {
                valueOf = "#";
            } else {
                valueOf = String.valueOf(next.pinyinFirst.charAt(0));
            }
            char charAt = valueOf.charAt(0);
            if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
                str = valueOf.toUpperCase();
            }
            if (aVar.f258456a.get(str) == null) {
                aVar.f258456a.put(str, new ArrayList());
            }
            aVar.f258456a.get(str).add(next);
            if (list2 != null && z16) {
                Iterator<PhoneContact> it5 = list2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    if (TextUtils.equals(it5.next().unifiedCode, next.unifiedCode)) {
                        if (aVar.f258456a.get("\u2605") == null) {
                            aVar.f258456a.put("\u2605", new ArrayList());
                        }
                        aVar.f258456a.get("\u2605").add(next);
                    }
                }
            }
        }
        if (list2 != null) {
            aVar.f258460e = list2;
            if (!z16) {
                if (aVar.f258456a.get("\u2605") == null) {
                    aVar.f258456a.put("\u2605", new ArrayList());
                }
                aVar.f258456a.get("\u2605").addAll(list2);
            }
        }
        LinkedHashMap<String, List<PhoneContact>> linkedHashMap = aVar.f258456a;
        aVar.f258456a = new LinkedHashMap<>();
        for (c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
            if (linkedHashMap.get(String.valueOf(c16)) != null) {
                aVar.f258456a.put(String.valueOf(c16), linkedHashMap.get(String.valueOf(c16)));
            }
        }
        if (linkedHashMap.get("#") != null) {
            aVar.f258456a.put("#", linkedHashMap.get("#"));
        }
        if (list2 != null && ((list.size() > 10 || !z16) && linkedHashMap.get("\u2605") != null)) {
            aVar.f258456a.put("\u2605", list2);
        }
        linkedHashMap.clear();
        int[] iArr = new int[aVar.f258456a.keySet().size()];
        aVar.f258457b = iArr;
        aVar.f258458c = new String[iArr.length];
        ArrayList arrayList2 = new ArrayList(aVar.f258456a.keySet());
        Collections.sort(arrayList2, new C8222a());
        Iterator it6 = arrayList2.iterator();
        int[] iArr2 = aVar.f258457b;
        if (iArr2.length == 0) {
            return aVar;
        }
        iArr2[0] = 0;
        int i16 = 1;
        while (true) {
            int[] iArr3 = aVar.f258457b;
            if (i16 >= iArr3.length) {
                break;
            }
            iArr3[i16] = iArr3[i16] + iArr3[i16 - 1] + aVar.f258456a.get(it6.next()).size() + 1;
            i16++;
        }
        Iterator it7 = arrayList2.iterator();
        while (it7.hasNext()) {
            aVar.f258458c[i3] = (String) it7.next();
            i3++;
        }
        return aVar;
    }
}
