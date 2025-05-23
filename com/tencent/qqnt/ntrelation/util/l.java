package com.tencent.qqnt.ntrelation.util;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b \u0010!JD\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000222\u0010\b\u001a.\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00060\u0004j\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006`\u0007H\u0002JP\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u000bj\b\u0012\u0004\u0012\u00020\u0011`\f2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\f2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000ej\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u000fH\u0002J&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u000bj\b\u0012\u0004\u0012\u00020\u0011`\f2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0005R\u001a\u0010\u001d\u001a\u00020\u00058\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000ej\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/l;", "", "Lcom/tencent/qqnt/ntrelation/util/l$a;", "paInfo", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "indexedFriends", "", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listData", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "listComparator", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "b", "", "Lcom/tencent/mobileqq/data/Friends;", "friends", "c", "uid", "", "d", "Ljava/lang/String;", "getINDEX_STAR", "()Ljava/lang/String;", "INDEX_STAR", "Ljava/util/Comparator;", "mListComparator", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f360279a = new l();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String INDEX_STAR = "\u2605";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Comparator<AlphaCompareStruct> mListComparator = new b();

    l() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
    
        if (r0 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(AlphaCompareStruct paInfo, LinkedHashMap<String, List<AlphaCompareStruct>> indexedFriends) {
        String str;
        String pinyinFirst;
        String str2 = "#";
        if (paInfo.getPinyinFirst() != null) {
            String pinyinFirst2 = paInfo.getPinyinFirst();
            if (!(pinyinFirst2 != null && pinyinFirst2.length() == 0) && (pinyinFirst = paInfo.getPinyinFirst()) != null) {
                str = pinyinFirst.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
        }
        str = "#";
        char charAt = str.charAt(0);
        if ((Intrinsics.compare(65, (int) charAt) <= 0 && Intrinsics.compare((int) charAt, 90) <= 0) || (Intrinsics.compare(97, (int) charAt) <= 0 && Intrinsics.compare((int) charAt, 122) <= 0)) {
            str2 = str.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toUpperCase()");
        }
        if (indexedFriends.get(str2) == null) {
            indexedFriends.put(str2, new ArrayList());
        }
        List<AlphaCompareStruct> list = indexedFriends.get(str2);
        if (list != null) {
            list.add(paInfo);
        }
        if (paInfo.getIsSpecialCare()) {
            String str3 = INDEX_STAR;
            if (indexedFriends.get(str3) == null) {
                indexedFriends.put(str3, new ArrayList());
            }
            List<AlphaCompareStruct> list2 = indexedFriends.get(str3);
            if (list2 != null) {
                list2.add(paInfo);
            }
        }
    }

    public final boolean d(String uid) {
        FriendsManager friendsManager;
        SpecialCareInfo O;
        Intrinsics.checkNotNullParameter(uid, "uid");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return (peekAppRuntime == null || (friendsManager = (FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)) == null || (O = friendsManager.O(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(uid))) == null || O.globalSwitch != 1) ? false : true;
    }

    private final ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b(ArrayList<AlphaCompareStruct> listData, Comparator<AlphaCompareStruct> listComparator) {
        List<AlphaCompareStruct> list;
        int collectionSizeOrDefault;
        List<AlphaCompareStruct> list2;
        int collectionSizeOrDefault2;
        List<AlphaCompareStruct> list3;
        int collectionSizeOrDefault3;
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList = new ArrayList<>();
        LinkedHashMap<String, List<AlphaCompareStruct>> linkedHashMap = new LinkedHashMap<>();
        if (listData == null || listData.isEmpty()) {
            return arrayList;
        }
        Iterator<AlphaCompareStruct> it = listData.iterator();
        while (it.hasNext()) {
            AlphaCompareStruct paInfo = it.next();
            Intrinsics.checkNotNullExpressionValue(paInfo, "paInfo");
            a(paInfo, linkedHashMap);
        }
        String str = INDEX_STAR;
        if (linkedHashMap.get(str) != null && (list3 = linkedHashMap.get(str)) != null) {
            try {
                Collections.sort(list3, listComparator);
            } catch (IllegalArgumentException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("UidAlphaListUtil", 2, "INDEX_STAR sort error " + e16);
                }
            }
            String str2 = INDEX_STAR;
            int size = list3.size();
            ArrayList arrayList2 = new ArrayList();
            List<AlphaCompareStruct> list4 = list3;
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
            Iterator<T> it5 = list4.iterator();
            while (it5.hasNext()) {
                arrayList3.add(((AlphaCompareStruct) it5.next()).getUid());
            }
            arrayList.add(new com.tencent.qqnt.ntrelation.friendsinfo.bean.b(0, str2, size, 0, (byte) 0, arrayList2, new ArrayList(arrayList3)));
        }
        for (char c16 = 'A'; Intrinsics.compare((int) c16, 90) <= 0; c16 = (char) (c16 + 1)) {
            if (linkedHashMap.get(String.valueOf(c16)) != null && (list2 = linkedHashMap.get(String.valueOf(c16))) != null) {
                try {
                    Collections.sort(list2, listComparator);
                } catch (IllegalArgumentException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("UidAlphaListUtil", 2, "A Z sort error " + e17);
                    }
                }
                String valueOf = String.valueOf(c16);
                int size2 = list2.size();
                ArrayList arrayList4 = new ArrayList();
                List<AlphaCompareStruct> list5 = list2;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10);
                ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault2);
                Iterator<T> it6 = list5.iterator();
                while (it6.hasNext()) {
                    arrayList5.add(((AlphaCompareStruct) it6.next()).getUid());
                }
                arrayList.add(new com.tencent.qqnt.ntrelation.friendsinfo.bean.b(0, valueOf, size2, 0, (byte) 0, arrayList4, new ArrayList(arrayList5)));
            }
        }
        if (linkedHashMap.get("#") != null && (list = linkedHashMap.get("#")) != null) {
            try {
                Collections.sort(list, listComparator);
            } catch (IllegalArgumentException e18) {
                if (QLog.isColorLevel()) {
                    QLog.e("UidAlphaListUtil", 2, "# sort error " + e18 + ",list = " + list);
                }
            }
            int size3 = list.size();
            ArrayList arrayList6 = new ArrayList();
            List<AlphaCompareStruct> list6 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
            ArrayList arrayList7 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it7 = list6.iterator();
            while (it7.hasNext()) {
                arrayList7.add(((AlphaCompareStruct) it7.next()).getUid());
            }
            arrayList.add(new com.tencent.qqnt.ntrelation.friendsinfo.bean.b(0, "#", size3, 0, (byte) 0, arrayList6, new ArrayList(arrayList7)));
        }
        return arrayList;
    }

    public final ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> c(List<? extends Friends> friends) {
        if (friends == null) {
            return new ArrayList<>();
        }
        if (friends.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<AlphaCompareStruct> arrayList = new ArrayList<>();
        int size = friends.size();
        for (int i3 = 0; i3 < size; i3++) {
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(friends.get(i3).uin);
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            aVar.d(uid);
            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            arrayList.add(new AlphaCompareStruct(uid, nameWithConfig, ChnToSpell.d(nameWithConfig, 2), d(uid)));
        }
        return b(arrayList, mListComparator);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/l$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uid", "b", "name", "pinyinFirst", "d", "Z", "()Z", "isSpecialCare", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.util.l$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class AlphaCompareStruct {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String uid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String pinyinFirst;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSpecialCare;

        public AlphaCompareStruct(String uid, String str, String str2, boolean z16) {
            Intrinsics.checkNotNullParameter(uid, "uid");
            this.uid = uid;
            this.name = str;
            this.pinyinFirst = str2;
            this.isSpecialCare = z16;
        }

        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: b, reason: from getter */
        public final String getPinyinFirst() {
            return this.pinyinFirst;
        }

        /* renamed from: c, reason: from getter */
        public final String getUid() {
            return this.uid;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSpecialCare() {
            return this.isSpecialCare;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.uid.hashCode() * 31;
            String str = this.name;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.pinyinFirst;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z16 = this.isSpecialCare;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode3 + i3;
        }

        public String toString() {
            return "AlphaCompareStruct(uid=" + this.uid + ", name=" + this.name + ", pinyinFirst=" + this.pinyinFirst + ", isSpecialCare=" + this.isSpecialCare + ')';
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AlphaCompareStruct)) {
                return false;
            }
            AlphaCompareStruct alphaCompareStruct = (AlphaCompareStruct) other;
            return Intrinsics.areEqual(this.uid, alphaCompareStruct.uid) && Intrinsics.areEqual(this.name, alphaCompareStruct.name) && Intrinsics.areEqual(this.pinyinFirst, alphaCompareStruct.pinyinFirst) && this.isSpecialCare == alphaCompareStruct.isSpecialCare;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0003J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/ntrelation/util/l$b", "Ljava/util/Comparator;", "Lcom/tencent/qqnt/ntrelation/util/l$a;", "Lkotlin/Comparator;", "innerPAInfo1", "innerPAInfo2", "", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements Comparator<AlphaCompareStruct> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AlphaCompareStruct innerPAInfo1, AlphaCompareStruct innerPAInfo2) {
            if (innerPAInfo1 == null && innerPAInfo2 == null) {
                return 0;
            }
            if (innerPAInfo1 == null && innerPAInfo2 != null) {
                return -1;
            }
            if (innerPAInfo1 != null && innerPAInfo2 == null) {
                return 1;
            }
            String name = innerPAInfo1 != null ? innerPAInfo1.getName() : null;
            String name2 = innerPAInfo2 != null ? innerPAInfo2.getName() : null;
            if (name == null && name2 == null) {
                return 0;
            }
            if (name != null || name2 == null) {
                if (name == null || name2 != null) {
                    if (name == null) {
                        return 0;
                    }
                    int length = name.length();
                    if (name2 == null) {
                        return 0;
                    }
                    int length2 = name2.length();
                    int min = Math.min(length, length2);
                    for (int i3 = 0; i3 < min; i3++) {
                        char charAt = name.charAt(i3);
                        char charAt2 = name2.charAt(i3);
                        if (charAt != charAt2) {
                            ChnToSpell.a g16 = ChnToSpell.g(charAt);
                            ChnToSpell.a g17 = ChnToSpell.g(charAt2);
                            int i16 = g16.f306904a;
                            int i17 = g17.f306904a;
                            if (i16 != i17) {
                                return i16 - i17;
                            }
                            String str = g16.f306905b;
                            String str2 = g17.f306905b;
                            Intrinsics.checkNotNullExpressionValue(str2, "charSpelling2.spelling");
                            return str.compareTo(str2);
                        }
                    }
                    if (length >= length2) {
                        if (length <= length2) {
                            return 0;
                        }
                    }
                }
                return 1;
            }
            return -1;
        }
    }
}
