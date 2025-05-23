package com.tencent.mobileqq.search.util;

import addcontacts.AccountSearchPb$record;
import android.text.TextUtils;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static int f285073a;

    /* renamed from: b, reason: collision with root package name */
    public static long[] f285074b;

    /* renamed from: c, reason: collision with root package name */
    public static String f285075c;

    /* renamed from: d, reason: collision with root package name */
    public static String f285076d;

    public static void a() {
        f285073a = 0;
        f285074b = null;
        f285075c = null;
        f285076d = null;
    }

    public static int b(List<com.tencent.mobileqq.search.model.y> list, String str) {
        if (list == null || list.size() == 0) {
            return 2;
        }
        for (com.tencent.mobileqq.search.model.y yVar : list) {
            if (yVar instanceof lo2.c) {
                lo2.c cVar = (lo2.c) yVar;
                if (cVar.J() == 1002 && !TextUtils.isEmpty(str) && str.equals(cVar.getUin())) {
                    return 1;
                }
            }
        }
        return 2;
    }

    public static String c(List<com.tencent.mobileqq.search.model.y> list, int i3) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            int min = Math.min(list.size(), i3);
            if (min <= 0) {
                return sb5.toString();
            }
            for (int i16 = 0; i16 < min; i16++) {
                com.tencent.mobileqq.search.model.y yVar = list.get(i16);
                if (yVar != null) {
                    if (yVar instanceof lo2.c) {
                        str = ((lo2.c) yVar).H;
                    } else if (yVar instanceof up2.b) {
                        str = ((up2.b) yVar).getUin();
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (sb5.length() != 0) {
                            sb5.append("\uff0c");
                        }
                        sb5.append(str);
                    }
                }
            }
            return sb5.toString();
        }
        return sb5.toString();
    }

    public static void d(int i3, long[] jArr, String str, String str2) {
        f285073a = i3;
        f285074b = jArr;
        f285075c = str;
        f285076d = str2;
    }

    public static void e(List<com.tencent.mobileqq.search.model.x> list, int i3, String str) {
        int i16;
        if (list != null && list.size() > 0) {
            if (i3 == 99) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            for (com.tencent.mobileqq.search.model.x xVar : list) {
                if ((xVar instanceof lo2.b) && xVar.o() != null) {
                    lo2.b bVar = (lo2.b) xVar;
                    if (bVar.D == 1107) {
                        for (com.tencent.mobileqq.search.model.y yVar : bVar.o()) {
                            if (yVar instanceof lo2.c) {
                                lo2.c cVar = (lo2.c) yVar;
                                if (cVar.J() == 1107) {
                                    SearchUtils.V0("Sgrp", "search_result", "exp", i16, 0, cVar.H);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    public static void f(int i3, long[] jArr, String str, String str2) {
        String str3;
        d(i3, jArr, str, str2);
        if (i3 == 2) {
            str3 = "2";
        } else {
            str3 = "1";
        }
        if (jArr != null && jArr.length == 2 && jArr[0] == 1001 && jArr[1] == Constant.FROM_ID_UNINSTALL_PLUGIN) {
            SearchUtils.V0("all_search", "user_grp", "search_cnt", 0, 0, "", str3, str2, "");
        } else if (jArr != null && jArr.length == 1 && jArr[0] == Constant.FROM_ID_UNINSTALL_PLUGIN) {
            SearchUtils.V0("all_search", "more_grp", "search_cnt", 0, 0, "", str3, str2, "");
        }
    }

    public static int g(ArrayList<un2.a> arrayList, String str) {
        List<AccountSearchPb$record> list;
        int i3;
        if (arrayList == null || arrayList.size() == 0) {
            return 2;
        }
        Iterator<un2.a> it = arrayList.iterator();
        int i16 = 2;
        String str2 = "";
        while (it.hasNext()) {
            un2.a next = it.next();
            if (next != null) {
                if (next.f439268a == 80000001 && (list = next.f439272e) != null && list.size() > 0) {
                    for (AccountSearchPb$record accountSearchPb$record : next.f439272e) {
                        if (accountSearchPb$record != null) {
                            String valueOf = String.valueOf(accountSearchPb$record.code.get());
                            if (!TextUtils.isEmpty(valueOf) && valueOf.equals(str)) {
                                i3 = 1;
                            } else {
                                i3 = 2;
                            }
                            SearchUtils.V0("add_page", "all_result", "exp_grp", 0, i3, valueOf, "", str, "");
                            i16 = i3;
                        }
                    }
                }
                switch (next.f439268a) {
                    case 80000000:
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "1";
                            break;
                        } else {
                            str2 = str2 + "::1";
                            break;
                        }
                    case 80000001:
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "2";
                            break;
                        } else {
                            str2 = str2 + "::2";
                            break;
                        }
                    case 80000002:
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "3";
                            break;
                        } else {
                            str2 = str2 + "::3";
                            break;
                        }
                    case 80000003:
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "4";
                            break;
                        } else {
                            str2 = str2 + "::4";
                            break;
                        }
                }
            }
        }
        SearchUtils.V0("add_page", "all_result", "exp", 0, i16, "", str2, str, "");
        return i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0219  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(List<com.tencent.mobileqq.search.model.v> list, List<com.tencent.mobileqq.search.model.x> list2, boolean z16, long[] jArr, String str, String str2) {
        String str3;
        int i3;
        int i16;
        String str4;
        int i17;
        if (list2 != null && list2.size() > 0) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        int i18 = 1002;
        if (jArr != null && jArr.length == 2 && jArr[0] == 1001 && jArr[1] == Constant.FROM_ID_UNINSTALL_PLUGIN) {
            if (z16) {
                return;
            }
            if (list2 == null || list2.size() <= 0) {
                str4 = "";
                i17 = 2;
            } else {
                str4 = "";
                int i19 = 2;
                for (com.tencent.mobileqq.search.model.x xVar : list2) {
                    if ((xVar instanceof lo2.b) && xVar.o() != null) {
                        lo2.b bVar = (lo2.b) xVar;
                        long j3 = bVar.D;
                        if (j3 == 1001) {
                            if (TextUtils.isEmpty(str4)) {
                                str4 = "1";
                            } else {
                                str4 = str4 + "::1";
                            }
                        } else if (j3 == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                            if (TextUtils.isEmpty(str4)) {
                                str4 = "2";
                            } else {
                                str4 = str4 + "::2";
                            }
                            List<com.tencent.mobileqq.search.model.y> o16 = bVar.o();
                            int b16 = b(o16, str2);
                            for (com.tencent.mobileqq.search.model.y yVar : o16) {
                                if (yVar instanceof lo2.c) {
                                    lo2.c cVar = (lo2.c) yVar;
                                    if (cVar.J() == i18) {
                                        SearchUtils.V0("all_search", "user_grp", "exp_grp", 0, b16, cVar.getUin(), (cVar.f415204v0 + 1) + "", str2, cVar.G());
                                    }
                                }
                                i18 = 1002;
                            }
                            i19 = b16;
                        }
                    }
                    i18 = 1002;
                }
                i17 = i19;
            }
            SearchUtils.V0("all_search", "user_grp", "exp", 0, i17, "", str4, str2, "");
            return;
        }
        if (jArr != null && jArr.length == 1 && jArr[0] == Constant.FROM_ID_UNINSTALL_PLUGIN) {
            if (z16 && list != null && !list.isEmpty()) {
                Iterator<com.tencent.mobileqq.search.model.v> it = list.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (it.next() instanceof lo2.c) {
                        i3++;
                    }
                }
            } else {
                i3 = 0;
            }
            if (list2 != null && list2.size() > 0) {
                for (com.tencent.mobileqq.search.model.x xVar2 : list2) {
                    if ((xVar2 instanceof lo2.b) && xVar2.o() != null) {
                        lo2.b bVar2 = (lo2.b) xVar2;
                        if (bVar2.D == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                            List<com.tencent.mobileqq.search.model.y> o17 = bVar2.o();
                            i16 = b(o17, str2);
                            if (o17 != null) {
                                for (com.tencent.mobileqq.search.model.y yVar2 : o17) {
                                    if (yVar2 instanceof lo2.c) {
                                        lo2.c cVar2 = (lo2.c) yVar2;
                                        if (cVar2.J() == 1002) {
                                            int i26 = cVar2.f415204v0 + i3;
                                            cVar2.f415204v0 = i26;
                                            SearchUtils.V0("all_search", "more_grp", "exp_grp", 0, i16, cVar2.getUin(), (i26 + 1) + "", str2, cVar2.G());
                                        }
                                    }
                                }
                            }
                            if (!z16) {
                                SearchUtils.V0("all_search", "more_grp", "load_more", 0, i16, str3, "", str2, "");
                                return;
                            } else {
                                SearchUtils.V0("all_search", "more_grp", "exp", 0, i16, str3, "", str2, "");
                                return;
                            }
                        }
                    }
                }
            }
            i16 = 2;
            if (!z16) {
            }
        }
    }

    public static void i(lo2.c cVar) {
        int i3;
        if (cVar != null && cVar.J() == 1002) {
            String keyword = cVar.getKeyword();
            String uin = cVar.getUin();
            String G = cVar.G();
            String str = (cVar.f415204v0 + 1) + "";
            if (!TextUtils.isEmpty(keyword) && keyword.equals(uin)) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            long[] jArr = f285074b;
            if (jArr != null && jArr.length == 2 && jArr[0] == 1001 && jArr[1] == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                SearchUtils.V0("all_search", "user_grp", "clk_grp", 0, i3, uin, str, keyword, G);
            } else if (jArr != null && jArr.length == 1 && jArr[0] == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                SearchUtils.V0("all_search", "more_grp", "clk_grp", 0, i3, uin, str, keyword, G);
            }
        }
    }

    public static void j(List<com.tencent.mobileqq.search.model.y> list, String str) {
        long[] jArr;
        if (list != null && list.size() != 0 && (jArr = f285074b) != null && jArr.length == 2 && jArr[0] == 1001 && jArr[1] == Constant.FROM_ID_UNINSTALL_PLUGIN) {
            SearchUtils.V0("all_search", "user_grp", "clk_more_grp", 0, b(list, str), "", "", str, "");
        }
    }
}
