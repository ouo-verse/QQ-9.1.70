package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.util.SparseIntArray;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f179910a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements Comparator<IEmoticonSort> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(IEmoticonSort iEmoticonSort, IEmoticonSort iEmoticonSort2) {
            if (iEmoticonSort != null && iEmoticonSort2 != null) {
                return Float.compare(iEmoticonSort.getExposeNum(), iEmoticonSort2.getExposeNum());
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements Comparator<IEmoticonSort> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(IEmoticonSort iEmoticonSort, IEmoticonSort iEmoticonSort2) {
            if (iEmoticonSort != null && iEmoticonSort2 != null) {
                float f16 = e.f179910a.get(iEmoticonSort.getBusinessType());
                return Float.compare((iEmoticonSort2.getClickNum() * 100) + ((1.0f / (iEmoticonSort2.getExposeNum() + 1)) / 10.0f) + e.f179910a.get(iEmoticonSort2.getBusinessType()), (iEmoticonSort.getClickNum() * 100) + ((1.0f / (iEmoticonSort.getExposeNum() + 1)) / 10.0f) + f16);
            }
            return 0;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f179910a = sparseIntArray;
        sparseIntArray.put(2, 10);
        sparseIntArray.put(3, 20);
        sparseIntArray.put(4, 30);
    }

    private static <T extends IEmoticonSort> void b(List<T> list, List<T> list2) {
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

    public static <T extends IEmoticonSort> List<T> c(AppRuntime appRuntime, List<T> list) {
        ArrayList<IEmoticonSort> arrayList = new ArrayList();
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
                for (IEmoticonSort iEmoticonSort : arrayList) {
                    QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions item.ClickNum:" + iEmoticonSort.getClickNum() + ",item.ExposeNum: " + iEmoticonSort.getExposeNum());
                }
                QLog.d("SearchStickerRecEmoticonUtil", 2, "getSearchStickerRecEmotions stickerRecEmotionList.size:" + arrayList.size());
            }
        }
        return arrayList;
    }

    private static <T extends IEmoticonSort> boolean d(List<T> list, T t16) {
        if (list != null && t16 != null) {
            for (T t17 : list) {
                if (t17.getBusinessType() != t16.getBusinessType()) {
                    if (t17.getBusinessType() == 2 && t16.getBusinessType() == 4) {
                        CustomEmotionData customEmotionData = ((j) t16).f179940b;
                        String str = customEmotionData.emoPath;
                        String str2 = customEmotionData.eId;
                        Emoticon emoticon = ((l) t17).f179944b;
                        String str3 = emoticon.epId;
                        String str4 = emoticon.eId;
                        if (str != null && str.equals(str3) && str2 != null && str2.equals(str4)) {
                            return true;
                        }
                    } else if (t17.getBusinessType() == 4 && t16.getBusinessType() == 2) {
                        CustomEmotionData customEmotionData2 = ((j) t17).f179940b;
                        String str5 = customEmotionData2.emoPath;
                        String str6 = customEmotionData2.eId;
                        Emoticon emoticon2 = ((l) t16).f179944b;
                        String str7 = emoticon2.epId;
                        String str8 = emoticon2.eId;
                        if (str5 != null && str5.equals(str7) && str6 != null && str6.equals(str8)) {
                            return true;
                        }
                    } else {
                        if (t17.getBusinessType() == 4 && t16.getBusinessType() == 3) {
                            j jVar = (j) t17;
                            if (jVar.getImgMd5() != null && jVar.getImgMd5().equals(((f) t16).getImgMd5())) {
                                return true;
                            }
                        }
                        if (t17.getBusinessType() == 3 && t16.getBusinessType() == 4) {
                            j jVar2 = (j) t16;
                            if (jVar2.getImgMd5() != null && jVar2.getImgMd5().equals(((f) t17).getImgMd5())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static <T extends IEmoticonSort> void e(List<T> list, List<T> list2) {
        ArrayList arrayList = new ArrayList();
        for (T t16 : list) {
            if (t16.getBusinessType() == 5) {
                list2.add(t16);
                arrayList.add(t16);
            }
        }
        list.removeAll(arrayList);
    }

    public static <T extends IEmoticonSort> void f(List<T> list) {
        Collections.sort(list, new b());
    }
}
