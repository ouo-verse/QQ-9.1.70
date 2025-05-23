package ip2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.search.model.ad;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lo2.ae;
import lo2.af;
import lo2.ah;
import lo2.ai;
import lo2.aj;
import lo2.j;
import lo2.l;
import lo2.m;
import lo2.n;
import lo2.r;
import lo2.w;
import lo2.y;
import unite.DynamicSearch$ResultItem;
import unite.DynamicSearch$ResultItemGroup;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e implements d<x> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    @Override // ip2.d
    public List<x> a(Object... objArr) {
        String str;
        List<DynamicSearch$ResultItemGroup> arrayList;
        int i3;
        int i16;
        ArrayList arrayList2;
        int i17;
        boolean z16;
        boolean z17;
        long j3;
        int i18;
        int i19;
        int i26;
        ?? r26;
        ArrayList arrayList3;
        ArrayList arrayList4;
        String str2;
        List<DynamicSearch$ResultItem> list;
        DynamicSearch$ResultItemGroup dynamicSearch$ResultItemGroup;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        int i27;
        DynamicSearch$ResultItem dynamicSearch$ResultItem;
        ?? r27;
        m jVar;
        if (objArr != null && objArr.length >= 3) {
            int i28 = 0;
            Object obj = objArr[0];
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = "";
            }
            int i29 = 1;
            Object obj2 = objArr[1];
            if (obj2 instanceof List) {
                arrayList = (List) obj2;
            } else {
                arrayList = new ArrayList();
            }
            Object obj3 = objArr[2];
            if (obj3 instanceof Integer) {
                i3 = ((Integer) obj3).intValue();
            } else {
                i3 = -1;
            }
            ArrayList arrayList8 = new ArrayList(arrayList.size());
            for (DynamicSearch$ResultItemGroup dynamicSearch$ResultItemGroup2 : arrayList) {
                long j16 = dynamicSearch$ResultItemGroup2.group_mask.get();
                String stringUtf8 = dynamicSearch$ResultItemGroup2.group_name.get().toStringUtf8();
                List<ByteStringMicro> list2 = dynamicSearch$ResultItemGroup2.rpt_highlight_words.get();
                ArrayList arrayList9 = new ArrayList(list2.size());
                Iterator<ByteStringMicro> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList9.add(it.next().toStringUtf8());
                }
                List<DynamicSearch$ResultItem> list3 = dynamicSearch$ResultItemGroup2.result_items.get();
                ArrayList arrayList10 = new ArrayList(list3.size());
                if (dynamicSearch$ResultItemGroup2.hide_title.get() == i29) {
                    i16 = i29;
                } else {
                    i16 = i28;
                }
                String stringUtf82 = dynamicSearch$ResultItemGroup2.group_footer_name.get().toStringUtf8();
                String stringUtf83 = dynamicSearch$ResultItemGroup2.group_footer_jump_url.get().toStringUtf8();
                long size = list3.size();
                int i36 = i28;
                while (i36 < list3.size()) {
                    DynamicSearch$ResultItem dynamicSearch$ResultItem2 = list3.get(i36);
                    List<DynamicSearch$ResultItem> list4 = dynamicSearch$ResultItem2.sub_result_items.get();
                    int size2 = list4.size() + 1;
                    ArrayList arrayList11 = new ArrayList(size2);
                    arrayList11.add(dynamicSearch$ResultItem2);
                    arrayList11.addAll(list4);
                    long j17 = size;
                    int i37 = 0;
                    while (i37 < size2) {
                        DynamicSearch$ResultItem dynamicSearch$ResultItem3 = (DynamicSearch$ResultItem) arrayList11.get(i37);
                        String stringUtf84 = dynamicSearch$ResultItem3.result_id.get().toStringUtf8();
                        boolean has = dynamicSearch$ResultItem3.layout_id.has();
                        String stringUtf85 = dynamicSearch$ResultItem3.name.get().toStringUtf8();
                        if (dynamicSearch$ResultItem3.group_mask.has()) {
                            j3 = dynamicSearch$ResultItem3.group_mask.get();
                        } else {
                            j3 = j16;
                        }
                        String stringUtf86 = dynamicSearch$ResultItem3.pic_url.get().toStringUtf8();
                        String stringUtf87 = dynamicSearch$ResultItem3.jmp_url.get().toStringUtf8();
                        ArrayList arrayList12 = arrayList11;
                        String stringUtf88 = dynamicSearch$ResultItem3.extension.get().toStringUtf8();
                        if (has) {
                            switch (dynamicSearch$ResultItem3.layout_id.get()) {
                                case 2:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new j(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 3:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new aj(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 4:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new l(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 5:
                                case 10:
                                default:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = null;
                                    break;
                                case 6:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new ai(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 7:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new ad(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 8:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new ae(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 9:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new af(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 11:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new r(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 12:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new n(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 13:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new ac(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 14:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new ah(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 15:
                                    i18 = size2;
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new y(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                                case 16:
                                    i19 = i37;
                                    dynamicSearch$ResultItem = dynamicSearch$ResultItem3;
                                    i18 = size2;
                                    i26 = i36;
                                    r27 = i16;
                                    arrayList3 = arrayList8;
                                    arrayList4 = arrayList10;
                                    jVar = new w(str, j16, arrayList9, dynamicSearch$ResultItem, i3);
                                    break;
                            }
                            if (jVar != null && jVar.N()) {
                                jVar.f283548i = dynamicSearch$ResultItem.seporator_type.get();
                                jVar.V = r27;
                                arrayList4.add(jVar);
                                r26 = r27;
                            } else {
                                j17--;
                                r26 = r27;
                            }
                        } else {
                            i18 = size2;
                            i19 = i37;
                            i26 = i36;
                            r26 = i16;
                            arrayList3 = arrayList8;
                            arrayList4 = arrayList10;
                            if (!SearchUtils.O0(j3)) {
                                QLog.e("Q.uniteSearch.NetBaseParser", 1, "itemGroupMask is not valid. mask=" + j3);
                                r26 = r26;
                            } else {
                                long j18 = j3;
                                if (j18 == 2073745984) {
                                    pn2.c cVar = new pn2.c(str, stringUtf88, -4, stringUtf86);
                                    cVar.f283548i = dynamicSearch$ResultItem3.seporator_type.get();
                                    arrayList4.add(cVar);
                                    r26 = r26;
                                } else {
                                    str2 = str;
                                    ArrayList arrayList13 = arrayList9;
                                    list = list3;
                                    dynamicSearch$ResultItemGroup = dynamicSearch$ResultItemGroup2;
                                    arrayList5 = arrayList13;
                                    arrayList6 = arrayList4;
                                    arrayList7 = arrayList3;
                                    lo2.c cVar2 = new lo2.c(str, stringUtf84, stringUtf85, stringUtf86, stringUtf87, stringUtf88, j18, arrayList13, i3);
                                    cVar2.f283548i = dynamicSearch$ResultItem3.seporator_type.get();
                                    cVar2.f415198p0 = r26;
                                    i27 = i26;
                                    cVar2.f415203u0 = i27;
                                    cVar2.f415204v0 = i27;
                                    cVar2.T = i3;
                                    arrayList6.add(cVar2);
                                    i37 = i19 + 1;
                                    arrayList10 = arrayList6;
                                    i16 = r26;
                                    i36 = i27;
                                    str = str2;
                                    list3 = list;
                                    arrayList9 = arrayList5;
                                    size2 = i18;
                                    dynamicSearch$ResultItemGroup2 = dynamicSearch$ResultItemGroup;
                                    arrayList8 = arrayList7;
                                    arrayList11 = arrayList12;
                                }
                            }
                        }
                        str2 = str;
                        arrayList5 = arrayList9;
                        list = list3;
                        dynamicSearch$ResultItemGroup = dynamicSearch$ResultItemGroup2;
                        arrayList6 = arrayList4;
                        i27 = i26;
                        arrayList7 = arrayList3;
                        i37 = i19 + 1;
                        arrayList10 = arrayList6;
                        i16 = r26;
                        i36 = i27;
                        str = str2;
                        list3 = list;
                        arrayList9 = arrayList5;
                        size2 = i18;
                        dynamicSearch$ResultItemGroup2 = dynamicSearch$ResultItemGroup;
                        arrayList8 = arrayList7;
                        arrayList11 = arrayList12;
                    }
                    i36++;
                    size = j17;
                }
                String str3 = str;
                ?? r28 = i16;
                ArrayList arrayList14 = arrayList10;
                ArrayList arrayList15 = arrayList9;
                DynamicSearch$ResultItemGroup dynamicSearch$ResultItemGroup3 = dynamicSearch$ResultItemGroup2;
                ArrayList arrayList16 = arrayList8;
                if (size > 0) {
                    long j19 = dynamicSearch$ResultItemGroup3.total_result_count.get();
                    String stringUtf89 = dynamicSearch$ResultItemGroup3.more_url.get().toStringUtf8();
                    String stringUtf810 = dynamicSearch$ResultItemGroup3.more_name.get().toStringUtf8();
                    if (dynamicSearch$ResultItemGroup3.highlight_title_keyword.get() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (dynamicSearch$ResultItemGroup3.hide_title_blank_view.get() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    i17 = 1;
                    lo2.b bVar = new lo2.b(str3, j16, stringUtf8, arrayList14, j19, stringUtf89, stringUtf810, arrayList15, r28, z16, z17, stringUtf82, stringUtf83);
                    arrayList2 = arrayList16;
                    arrayList2.add(bVar);
                } else {
                    arrayList2 = arrayList16;
                    i17 = 1;
                }
                arrayList8 = arrayList2;
                i29 = i17;
                str = str3;
                i28 = 0;
            }
            return arrayList8;
        }
        return null;
    }
}
