package ip2;

import android.text.TextUtils;
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
import lo2.t;
import lo2.w;
import lo2.y;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon$ResultItem;
import unify.search.UnifySearchCommon$ResultItemGroup;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h implements d<x> {

    /* renamed from: a, reason: collision with root package name */
    private boolean f408134a = false;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:158:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0533  */
    @Override // ip2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<x> a(Object... objArr) {
        List arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i3;
        UnifySearchCommon$ResultItemGroup unifySearchCommon$ResultItemGroup;
        lo2.b bVar;
        ArrayList arrayList4;
        int i16;
        lo2.b bVar2;
        ArrayList arrayList5;
        long j3;
        ArrayList arrayList6;
        String str;
        int i17;
        List<UnifySearchCommon$ResultItem> list;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i18;
        int i19;
        String str7;
        String str8;
        String str9;
        UnifySearchCommon$ResultItemGroup unifySearchCommon$ResultItemGroup2;
        int i26;
        ArrayList arrayList7;
        lo2.b bVar3;
        List<UnifySearchCommon$ResultItem> list2;
        ArrayList arrayList8;
        String str10;
        long j16;
        String str11;
        int i27;
        int i28;
        int i29;
        ArrayList arrayList9;
        String str12;
        ArrayList arrayList10;
        ArrayList arrayList11;
        String str13;
        UnifySearchCommon$ResultItem unifySearchCommon$ResultItem;
        String str14;
        int i36;
        ArrayList arrayList12;
        char c16;
        m jVar;
        JSONException jSONException;
        String str15;
        int i37;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String optString;
        int i38;
        if (objArr == null || objArr.length < 3) {
            return null;
        }
        int i39 = 0;
        Object obj = objArr[0];
        String str16 = "";
        String str17 = obj instanceof String ? (String) obj : "";
        int i46 = 1;
        Object obj2 = objArr[1];
        if (obj2 instanceof List) {
            arrayList = (List) obj2;
        } else {
            arrayList = new ArrayList();
        }
        char c17 = 2;
        Object obj3 = objArr[2];
        int intValue = obj3 instanceof Integer ? ((Integer) obj3).intValue() : -1;
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        lo2.b bVar4 = null;
        while (true) {
            String str18 = "Q.uniteSearch.NetBaseParser";
            if (it.hasNext()) {
                UnifySearchCommon$ResultItemGroup unifySearchCommon$ResultItemGroup3 = (UnifySearchCommon$ResultItemGroup) it.next();
                long j17 = unifySearchCommon$ResultItemGroup3.group_mask.get();
                String stringUtf8 = unifySearchCommon$ResultItemGroup3.group_name.get().toStringUtf8();
                List<ByteStringMicro> list3 = unifySearchCommon$ResultItemGroup3.rpt_highlight_words.get();
                ArrayList arrayList15 = new ArrayList(list3.size());
                Iterator<ByteStringMicro> it5 = list3.iterator();
                while (it5.hasNext()) {
                    arrayList15.add(it5.next().toStringUtf8());
                }
                List<UnifySearchCommon$ResultItem> list4 = unifySearchCommon$ResultItemGroup3.result_items.get();
                ArrayList arrayList16 = new ArrayList(list4.size());
                boolean z16 = this.f408134a ? i46 : unifySearchCommon$ResultItemGroup3.hide_title.get() == i46 ? i46 : i39;
                String stringUtf82 = unifySearchCommon$ResultItemGroup3.group_footer_name.get().toStringUtf8();
                String stringUtf83 = unifySearchCommon$ResultItemGroup3.group_footer_jump_url.get().toStringUtf8();
                String str19 = str16;
                long size = list4.size();
                ArrayList arrayList17 = arrayList13;
                int i47 = 0;
                while (i47 < list4.size()) {
                    UnifySearchCommon$ResultItem unifySearchCommon$ResultItem2 = list4.get(i47);
                    List<UnifySearchCommon$ResultItem> list5 = unifySearchCommon$ResultItem2.sub_result_items.get();
                    int i48 = i47;
                    int size2 = list5.size() + 1;
                    ArrayList arrayList18 = new ArrayList(size2);
                    arrayList18.add(unifySearchCommon$ResultItem2);
                    arrayList18.addAll(list5);
                    int i49 = 0;
                    while (i49 < size2) {
                        int i56 = size2;
                        UnifySearchCommon$ResultItem unifySearchCommon$ResultItem3 = (UnifySearchCommon$ResultItem) arrayList18.get(i49);
                        String stringUtf84 = unifySearchCommon$ResultItem3.result_id.get().toStringUtf8();
                        boolean has = unifySearchCommon$ResultItem3.layout_id.has();
                        ArrayList arrayList19 = arrayList18;
                        String stringUtf85 = unifySearchCommon$ResultItem3.name.get().toStringUtf8();
                        if (unifySearchCommon$ResultItem3.group_mask.has()) {
                            bVar2 = bVar4;
                            arrayList5 = arrayList14;
                            j3 = unifySearchCommon$ResultItem3.group_mask.get();
                        } else {
                            bVar2 = bVar4;
                            arrayList5 = arrayList14;
                            j3 = j17;
                        }
                        int i57 = i49;
                        String stringUtf86 = unifySearchCommon$ResultItem3.pic_url.get().toStringUtf8();
                        String stringUtf87 = unifySearchCommon$ResultItem3.jmp_url.get().toStringUtf8();
                        String stringUtf88 = unifySearchCommon$ResultItem3.extension.get().toStringUtf8();
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            arrayList6 = arrayList16;
                            sb5.append("exhibition Result");
                            sb5.append(stringUtf88);
                            QLog.d(str18, 2, sb5.toString());
                        } else {
                            arrayList6 = arrayList16;
                        }
                        if (j3 != 1001 || TextUtils.isEmpty(stringUtf88)) {
                            str = null;
                            i17 = 0;
                        } else {
                            try {
                                JSONObject jSONObject3 = new JSONObject(stringUtf88);
                                i38 = jSONObject3.optInt("is_qid_no");
                                try {
                                    str = jSONObject3.optString("qid");
                                    i17 = i38;
                                } catch (Exception e16) {
                                    e = e16;
                                    e.printStackTrace();
                                    i17 = i38;
                                    str = null;
                                    if (j3 != 8001) {
                                    }
                                    str9 = str3;
                                    str8 = str9;
                                    str7 = str8;
                                    str6 = str7;
                                    str5 = str6;
                                    i19 = 0;
                                    i18 = 0;
                                    if (has) {
                                    }
                                    int i58 = i27 + 1;
                                    i48 = i28;
                                    str18 = str12;
                                    arrayList16 = arrayList10;
                                    arrayList17 = arrayList9;
                                    intValue = i29;
                                    arrayList18 = arrayList19;
                                    str19 = str11;
                                    list4 = list2;
                                    arrayList15 = arrayList8;
                                    bVar4 = bVar3;
                                    unifySearchCommon$ResultItemGroup3 = unifySearchCommon$ResultItemGroup2;
                                    arrayList14 = arrayList7;
                                    size2 = i26;
                                    i49 = i58;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                i38 = 0;
                            }
                        }
                        if (j3 != 8001) {
                            str2 = stringUtf86;
                            str3 = str19;
                            if (stringUtf88.equals(str3)) {
                                str4 = str;
                                list = list4;
                            } else {
                                try {
                                    jSONObject = new JSONObject(stringUtf88);
                                    str4 = str;
                                } catch (JSONException e18) {
                                    e = e18;
                                    str4 = str;
                                }
                                try {
                                    list = list4;
                                } catch (JSONException e19) {
                                    e = e19;
                                    list = list4;
                                    jSONException = e;
                                    str9 = str3;
                                    str15 = str9;
                                    str7 = str15;
                                    str6 = str7;
                                    i37 = 0;
                                    i18 = 0;
                                    jSONException.printStackTrace();
                                    str8 = str15;
                                    i19 = i37;
                                    str5 = str3;
                                    if (has) {
                                    }
                                    int i582 = i27 + 1;
                                    i48 = i28;
                                    str18 = str12;
                                    arrayList16 = arrayList10;
                                    arrayList17 = arrayList9;
                                    intValue = i29;
                                    arrayList18 = arrayList19;
                                    str19 = str11;
                                    list4 = list2;
                                    arrayList15 = arrayList8;
                                    bVar4 = bVar3;
                                    unifySearchCommon$ResultItemGroup3 = unifySearchCommon$ResultItemGroup2;
                                    arrayList14 = arrayList7;
                                    size2 = i26;
                                    i49 = i582;
                                }
                                try {
                                    jSONObject2 = new JSONObject(jSONObject.optJSONArray("attribute").get(0).toString());
                                    str8 = jSONObject2.optString("exhibition_type");
                                    try {
                                        str7 = jSONObject2.optString("exhibition_name");
                                    } catch (JSONException e26) {
                                        e = e26;
                                        str7 = str3;
                                        str6 = str7;
                                    }
                                } catch (JSONException e27) {
                                    e = e27;
                                    jSONException = e;
                                    str9 = str3;
                                    str15 = str9;
                                    str7 = str15;
                                    str6 = str7;
                                    i37 = 0;
                                    i18 = 0;
                                    jSONException.printStackTrace();
                                    str8 = str15;
                                    i19 = i37;
                                    str5 = str3;
                                    if (has) {
                                    }
                                    int i5822 = i27 + 1;
                                    i48 = i28;
                                    str18 = str12;
                                    arrayList16 = arrayList10;
                                    arrayList17 = arrayList9;
                                    intValue = i29;
                                    arrayList18 = arrayList19;
                                    str19 = str11;
                                    list4 = list2;
                                    arrayList15 = arrayList8;
                                    bVar4 = bVar3;
                                    unifySearchCommon$ResultItemGroup3 = unifySearchCommon$ResultItemGroup2;
                                    arrayList14 = arrayList7;
                                    size2 = i26;
                                    i49 = i5822;
                                }
                                try {
                                    i19 = jSONObject2.optInt("count");
                                    try {
                                        i18 = jSONObject2.optInt("tag_type");
                                    } catch (JSONException e28) {
                                        e = e28;
                                        str6 = str3;
                                        str15 = str8;
                                        i37 = i19;
                                        i18 = 0;
                                        jSONException = e;
                                        str9 = str6;
                                        jSONException.printStackTrace();
                                        str8 = str15;
                                        i19 = i37;
                                        str5 = str3;
                                        if (has) {
                                        }
                                        int i58222 = i27 + 1;
                                        i48 = i28;
                                        str18 = str12;
                                        arrayList16 = arrayList10;
                                        arrayList17 = arrayList9;
                                        intValue = i29;
                                        arrayList18 = arrayList19;
                                        str19 = str11;
                                        list4 = list2;
                                        arrayList15 = arrayList8;
                                        bVar4 = bVar3;
                                        unifySearchCommon$ResultItemGroup3 = unifySearchCommon$ResultItemGroup2;
                                        arrayList14 = arrayList7;
                                        size2 = i26;
                                        i49 = i58222;
                                    }
                                } catch (JSONException e29) {
                                    e = e29;
                                    str6 = str3;
                                    str15 = str8;
                                    i37 = 0;
                                    i18 = 0;
                                    jSONException = e;
                                    str9 = str6;
                                    jSONException.printStackTrace();
                                    str8 = str15;
                                    i19 = i37;
                                    str5 = str3;
                                    if (has) {
                                    }
                                    int i582222 = i27 + 1;
                                    i48 = i28;
                                    str18 = str12;
                                    arrayList16 = arrayList10;
                                    arrayList17 = arrayList9;
                                    intValue = i29;
                                    arrayList18 = arrayList19;
                                    str19 = str11;
                                    list4 = list2;
                                    arrayList15 = arrayList8;
                                    bVar4 = bVar3;
                                    unifySearchCommon$ResultItemGroup3 = unifySearchCommon$ResultItemGroup2;
                                    arrayList14 = arrayList7;
                                    size2 = i26;
                                    i49 = i582222;
                                }
                                try {
                                    str6 = jSONObject2.optString("color");
                                    try {
                                        optString = jSONObject2.optString("exhibition_msg");
                                    } catch (JSONException e36) {
                                        str15 = str8;
                                        i37 = i19;
                                        jSONException = e36;
                                        str9 = str3;
                                    }
                                } catch (JSONException e37) {
                                    e = e37;
                                    str6 = str3;
                                    str15 = str8;
                                    i37 = i19;
                                    jSONException = e;
                                    str9 = str6;
                                    jSONException.printStackTrace();
                                    str8 = str15;
                                    i19 = i37;
                                    str5 = str3;
                                    if (has) {
                                    }
                                    int i5822222 = i27 + 1;
                                    i48 = i28;
                                    str18 = str12;
                                    arrayList16 = arrayList10;
                                    arrayList17 = arrayList9;
                                    intValue = i29;
                                    arrayList18 = arrayList19;
                                    str19 = str11;
                                    list4 = list2;
                                    arrayList15 = arrayList8;
                                    bVar4 = bVar3;
                                    unifySearchCommon$ResultItemGroup3 = unifySearchCommon$ResultItemGroup2;
                                    arrayList14 = arrayList7;
                                    size2 = i26;
                                    i49 = i5822222;
                                }
                                try {
                                    str5 = jSONObject.optString("jumpPath");
                                    str9 = optString;
                                } catch (JSONException e38) {
                                    i37 = i19;
                                    jSONException = e38;
                                    str9 = optString;
                                    str15 = str8;
                                    jSONException.printStackTrace();
                                    str8 = str15;
                                    i19 = i37;
                                    str5 = str3;
                                    if (has) {
                                    }
                                    int i58222222 = i27 + 1;
                                    i48 = i28;
                                    str18 = str12;
                                    arrayList16 = arrayList10;
                                    arrayList17 = arrayList9;
                                    intValue = i29;
                                    arrayList18 = arrayList19;
                                    str19 = str11;
                                    list4 = list2;
                                    arrayList15 = arrayList8;
                                    bVar4 = bVar3;
                                    unifySearchCommon$ResultItemGroup3 = unifySearchCommon$ResultItemGroup2;
                                    arrayList14 = arrayList7;
                                    size2 = i26;
                                    i49 = i58222222;
                                }
                                if (has) {
                                    switch (unifySearchCommon$ResultItem3.layout_id.get()) {
                                        case 2:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new j(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 3:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new aj(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 4:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new l(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 5:
                                        case 10:
                                        case 17:
                                        case 18:
                                        case 19:
                                        default:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = null;
                                            break;
                                        case 6:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new ai(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 7:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new ad(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 8:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new ae(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 9:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new af(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 11:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new r(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 12:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new n(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 13:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new ac(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 14:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new ah(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 15:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new y(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 16:
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            str13 = str18;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            str14 = str3;
                                            i26 = i56;
                                            i36 = i48;
                                            arrayList7 = arrayList5;
                                            bVar3 = bVar2;
                                            arrayList12 = arrayList6;
                                            list2 = list;
                                            c16 = 2;
                                            arrayList8 = arrayList15;
                                            jVar = new w(str17, j17, arrayList8, unifySearchCommon$ResultItem, intValue);
                                            break;
                                        case 20:
                                            ArrayList arrayList20 = arrayList6;
                                            c16 = 2;
                                            list2 = list;
                                            arrayList8 = arrayList15;
                                            str13 = str18;
                                            unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                            bVar3 = bVar2;
                                            str14 = str3;
                                            arrayList7 = arrayList5;
                                            arrayList12 = arrayList20;
                                            arrayList11 = arrayList17;
                                            unifySearchCommon$ResultItem = unifySearchCommon$ResultItem3;
                                            i26 = i56;
                                            i36 = i48;
                                            jVar = new t(str17, j17, arrayList8, unifySearchCommon$ResultItem3, intValue, true);
                                            break;
                                    }
                                    if (jVar == null || !jVar.N()) {
                                        size--;
                                    } else {
                                        jVar.f283548i = unifySearchCommon$ResultItem.seporator_type.get();
                                        jVar.V = z16;
                                        arrayList12.add(jVar);
                                    }
                                    arrayList10 = arrayList12;
                                    str11 = str14;
                                    i27 = i57;
                                    str12 = str13;
                                    i28 = i36;
                                    i29 = intValue;
                                    arrayList9 = arrayList11;
                                } else {
                                    ArrayList arrayList21 = arrayList17;
                                    unifySearchCommon$ResultItemGroup2 = unifySearchCommon$ResultItemGroup3;
                                    String str20 = str18;
                                    String str21 = str3;
                                    i26 = i56;
                                    int i59 = i48;
                                    arrayList7 = arrayList5;
                                    bVar3 = bVar2;
                                    ArrayList arrayList22 = arrayList6;
                                    list2 = list;
                                    arrayList8 = arrayList15;
                                    if (SearchUtils.O0(j3)) {
                                        str10 = str20;
                                        if (j3 == 2073745984) {
                                            pn2.c cVar = new pn2.c(str17, stringUtf88, -4, str2);
                                            cVar.f283548i = unifySearchCommon$ResultItem3.seporator_type.get();
                                            arrayList22.add(cVar);
                                        } else {
                                            String str22 = str4;
                                            j16 = size;
                                            int i65 = intValue;
                                            str11 = str21;
                                            i27 = i57;
                                            lo2.c cVar2 = new lo2.c(str17, stringUtf84, stringUtf85, str2, stringUtf87, stringUtf88, j3, arrayList8, i65, str8, str7, i19, i18, str6, str9, str5);
                                            cVar2.f283548i = unifySearchCommon$ResultItem3.seporator_type.get();
                                            cVar2.f415198p0 = z16;
                                            i28 = i59;
                                            cVar2.f415203u0 = i28;
                                            cVar2.f415204v0 = i28;
                                            i29 = i65;
                                            cVar2.T = i29;
                                            if (i17 == 1 && j3 == 1001) {
                                                cVar2.V = str22;
                                                arrayList9 = arrayList21;
                                                arrayList9.add(cVar2);
                                                size = j16 - 1;
                                                if (QLog.isColorLevel()) {
                                                    str12 = str10;
                                                    QLog.d(str12, 2, "QID_LOG,search_has," + str17 + "," + stringUtf85);
                                                } else {
                                                    str12 = str10;
                                                }
                                                arrayList10 = arrayList22;
                                            } else {
                                                arrayList9 = arrayList21;
                                                str12 = str10;
                                                arrayList10 = arrayList22;
                                                arrayList10.add(cVar2);
                                                size = j16;
                                            }
                                        }
                                    } else {
                                        str10 = str20;
                                        QLog.e(str10, 1, "itemGroupMask is not valid. mask=" + j3);
                                    }
                                    j16 = size;
                                    str12 = str10;
                                    arrayList10 = arrayList22;
                                    str11 = str21;
                                    i27 = i57;
                                    i28 = i59;
                                    i29 = intValue;
                                    arrayList9 = arrayList21;
                                    size = j16;
                                }
                                int i582222222 = i27 + 1;
                                i48 = i28;
                                str18 = str12;
                                arrayList16 = arrayList10;
                                arrayList17 = arrayList9;
                                intValue = i29;
                                arrayList18 = arrayList19;
                                str19 = str11;
                                list4 = list2;
                                arrayList15 = arrayList8;
                                bVar4 = bVar3;
                                unifySearchCommon$ResultItemGroup3 = unifySearchCommon$ResultItemGroup2;
                                arrayList14 = arrayList7;
                                size2 = i26;
                                i49 = i582222222;
                            }
                        } else {
                            list = list4;
                            str2 = stringUtf86;
                            str3 = str19;
                            str4 = str;
                        }
                        str9 = str3;
                        str8 = str9;
                        str7 = str8;
                        str6 = str7;
                        str5 = str6;
                        i19 = 0;
                        i18 = 0;
                        if (has) {
                        }
                        int i5822222222 = i27 + 1;
                        i48 = i28;
                        str18 = str12;
                        arrayList16 = arrayList10;
                        arrayList17 = arrayList9;
                        intValue = i29;
                        arrayList18 = arrayList19;
                        str19 = str11;
                        list4 = list2;
                        arrayList15 = arrayList8;
                        bVar4 = bVar3;
                        unifySearchCommon$ResultItemGroup3 = unifySearchCommon$ResultItemGroup2;
                        arrayList14 = arrayList7;
                        size2 = i26;
                        i49 = i5822222222;
                    }
                    arrayList16 = arrayList16;
                    intValue = intValue;
                    i47 = i48 + 1;
                    c17 = 2;
                    arrayList14 = arrayList14;
                }
                ArrayList arrayList23 = arrayList16;
                UnifySearchCommon$ResultItemGroup unifySearchCommon$ResultItemGroup4 = unifySearchCommon$ResultItemGroup3;
                ArrayList arrayList24 = arrayList15;
                lo2.b bVar5 = bVar4;
                ArrayList arrayList25 = arrayList14;
                String str23 = str19;
                int i66 = intValue;
                ArrayList arrayList26 = arrayList17;
                if (j17 == 1001) {
                    unifySearchCommon$ResultItemGroup = unifySearchCommon$ResultItemGroup4;
                    arrayList2 = arrayList23;
                    arrayList3 = arrayList26;
                    i3 = i66;
                    bVar = new lo2.b(str17, j17, "QID", null, 0L, unifySearchCommon$ResultItemGroup.more_url.get().toStringUtf8(), unifySearchCommon$ResultItemGroup.more_name.get().toStringUtf8(), arrayList24, z16, unifySearchCommon$ResultItemGroup.highlight_title_keyword.get() == 1, unifySearchCommon$ResultItemGroup.hide_title_blank_view.get() == 1, stringUtf82, stringUtf83);
                } else {
                    arrayList2 = arrayList23;
                    arrayList3 = arrayList26;
                    i3 = i66;
                    unifySearchCommon$ResultItemGroup = unifySearchCommon$ResultItemGroup4;
                    bVar = bVar5;
                }
                if (size > 0) {
                    i16 = 1;
                    lo2.b bVar6 = new lo2.b(str17, j17, stringUtf8, arrayList2, unifySearchCommon$ResultItemGroup.total_result_count.get(), unifySearchCommon$ResultItemGroup.more_url.get().toStringUtf8(), unifySearchCommon$ResultItemGroup.more_name.get().toStringUtf8(), arrayList24, z16, unifySearchCommon$ResultItemGroup.highlight_title_keyword.get() == 1, unifySearchCommon$ResultItemGroup.hide_title_blank_view.get() == 1, stringUtf82, stringUtf83);
                    arrayList4 = arrayList25;
                    arrayList4.add(bVar6);
                } else {
                    arrayList4 = arrayList25;
                    i16 = 1;
                }
                bVar4 = bVar;
                arrayList14 = arrayList4;
                i46 = i16;
                intValue = i3;
                str16 = str23;
                arrayList13 = arrayList3;
                i39 = 0;
                c17 = 2;
            } else {
                lo2.b bVar7 = bVar4;
                ArrayList arrayList27 = arrayList14;
                ArrayList arrayList28 = arrayList13;
                if (bVar7 != null && !arrayList28.isEmpty()) {
                    bVar7.C(arrayList28);
                    bVar7.E(arrayList28.size());
                    arrayList27.add(0, bVar7);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.uniteSearch.NetBaseParser", 2, "QID_LOG,search_add," + arrayList28.size());
                    }
                }
                return arrayList27;
            }
        }
    }

    public void b(boolean z16) {
        this.f408134a = z16;
    }
}
