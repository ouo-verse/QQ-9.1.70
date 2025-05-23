package com.tencent.qqnt.emotion.stickerrecommended;

import android.util.SparseIntArray;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes24.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f356529a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class a implements Comparator<e> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e eVar, e eVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar, (Object) eVar2)).intValue();
            }
            if (eVar != null && eVar2 != null) {
                return Float.compare(eVar.getExposeNum(), eVar2.getExposeNum());
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class b implements Comparator<e> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e eVar, e eVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar, (Object) eVar2)).intValue();
            }
            if (eVar != null && eVar2 != null) {
                float f16 = i.f356529a.get(eVar.getBusinessType());
                return Float.compare((eVar2.getClickNum() * 100) + ((1.0f / (eVar2.getExposeNum() + 1)) / 10.0f) + i.f356529a.get(eVar2.getBusinessType()), (eVar.getClickNum() * 100) + ((1.0f / (eVar.getExposeNum() + 1)) / 10.0f) + f16);
            }
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37495);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        f356529a = sparseIntArray;
        sparseIntArray.put(2, 10);
        sparseIntArray.put(3, 20);
        sparseIntArray.put(4, 30);
    }

    private static <T extends e> void b(List<T> list, List<T> list2) {
        T t16;
        if (list2 != null && list != null && !list.isEmpty()) {
            T remove = list.remove(0);
            while (true) {
                t16 = remove;
                if (!d(list2, t16) || list.size() <= 0) {
                    break;
                } else {
                    remove = list.remove(0);
                }
            }
            if (!d(list2, t16)) {
                list2.add(t16);
            }
        }
    }

    public static <T extends e> List<T> c(AppRuntime appRuntime, List<T> list) {
        ArrayList<e> arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecSearches.size:" + list.size());
            }
            e(list, arrayList);
            f(list);
            if (list.size() > 0) {
                arrayList.add(list.remove(0));
            }
            if (list.size() > 0) {
                b(list, arrayList);
            }
            if (list.size() > 0) {
                Collections.sort(list, new a());
                b(list, arrayList);
            }
            if (QLog.isColorLevel()) {
                for (e eVar : arrayList) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions item.ClickNum:" + eVar.getClickNum() + ",item.ExposeNum: " + eVar.getExposeNum());
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecEmotionList.size:" + arrayList.size());
                }
            }
        }
        return arrayList;
    }

    private static <T extends e> boolean d(List<T> list, T t16) {
        if (list != null && t16 != null) {
            for (T t17 : list) {
                if (t17.getBusinessType() != t16.getBusinessType()) {
                    if (t17.getBusinessType() == 2 && t16.getBusinessType() == 4) {
                        CustomEmotionData customEmotionData = ((r) t16).f356623f;
                        String str = customEmotionData.emoPath;
                        String str2 = customEmotionData.eId;
                        Emoticon emoticon = ((t) t17).f356642f;
                        String str3 = emoticon.epId;
                        String str4 = emoticon.eId;
                        if (str != null && str.equals(str3) && str2 != null && str2.equals(str4)) {
                            return true;
                        }
                    } else if (t17.getBusinessType() == 4 && t16.getBusinessType() == 2) {
                        CustomEmotionData customEmotionData2 = ((r) t17).f356623f;
                        String str5 = customEmotionData2.emoPath;
                        String str6 = customEmotionData2.eId;
                        Emoticon emoticon2 = ((t) t16).f356642f;
                        String str7 = emoticon2.epId;
                        String str8 = emoticon2.eId;
                        if (str5 != null && str5.equals(str7) && str6 != null && str6.equals(str8)) {
                            return true;
                        }
                    } else {
                        if (t17.getBusinessType() == 4 && t16.getBusinessType() == 3) {
                            r rVar = (r) t17;
                            if (rVar.getImgMd5() != null && rVar.getImgMd5().equals(((m) t16).getImgMd5())) {
                                return true;
                            }
                        }
                        if (t17.getBusinessType() == 3 && t16.getBusinessType() == 4) {
                            r rVar2 = (r) t16;
                            if (rVar2.getImgMd5() != null && rVar2.getImgMd5().equals(((m) t17).getImgMd5())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static <T extends e> void e(List<T> list, List<T> list2) {
        ArrayList arrayList = new ArrayList();
        for (T t16 : list) {
            if (t16.getBusinessType() == 5) {
                list2.add(t16);
                arrayList.add(t16);
            }
        }
        list.removeAll(arrayList);
    }

    public static <T extends e> void f(List<T> list) {
        Collections.sort(list, new b());
    }
}
