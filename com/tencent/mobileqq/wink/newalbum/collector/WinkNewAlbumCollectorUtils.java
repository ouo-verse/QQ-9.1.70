package com.tencent.mobileqq.wink.newalbum.collector;

import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s83.WinkNewAlbumConfigInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J*\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\u001c\u0010\f\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u0003J\u001c\u0010\u000e\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u0003J\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewAlbumCollectorUtils;", "", "", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "candidateAlbumContexts", "Lkotlin/Function1;", "Lz83/a;", "", "dateComponentChecker", "", "a", "newAlbumContext", "d", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewAlbumCollectorUtils$a;", "c", "Ls83/a;", "albumConfigInfo", "queryTime", "isLast", "", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumCollectorUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkNewAlbumCollectorUtils f324042a = new WinkNewAlbumCollectorUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewAlbumCollectorUtils$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "year", "b", "month", "day", "<init>", "(III)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorUtils$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class QueryTime {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int year;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int month;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int day;

        public QueryTime(int i3, int i16, int i17) {
            this.year = i3;
            this.month = i16;
            this.day = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getDay() {
            return this.day;
        }

        /* renamed from: b, reason: from getter */
        public final int getMonth() {
            return this.month;
        }

        /* renamed from: c, reason: from getter */
        public final int getYear() {
            return this.year;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QueryTime)) {
                return false;
            }
            QueryTime queryTime = (QueryTime) other;
            if (this.year == queryTime.year && this.month == queryTime.month && this.day == queryTime.day) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.year * 31) + this.month) * 31) + this.day;
        }

        @NotNull
        public String toString() {
            return "QueryTime(year=" + this.year + ", month=" + this.month + ", day=" + this.day + ")";
        }
    }

    WinkNewAlbumCollectorUtils() {
    }

    private final int a(List<WinkNewAlbumContext> candidateAlbumContexts, Function1<? super z83.a, Boolean> dateComponentChecker) {
        List<WinkNewAlbumContext> list = candidateAlbumContexts;
        int i3 = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (dateComponentChecker.invoke(((WinkNewAlbumContext) it.next()).getMetaData()).booleanValue() && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i3;
    }

    @NotNull
    public final String b(@NotNull WinkNewAlbumConfigInfo albumConfigInfo, @NotNull QueryTime queryTime, boolean isLast) {
        boolean contains$default;
        String str;
        List split$default;
        String joinToString$default;
        int i3;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(albumConfigInfo, "albumConfigInfo");
        Intrinsics.checkNotNullParameter(queryTime, "queryTime");
        if (isLast) {
            return albumConfigInfo.getStorySQL();
        }
        if (!w83.b.f445025a.I()) {
            return albumConfigInfo.getStorySQL();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WinkNewAlbumCollectorUtils", 4, "genQuery origin sql:" + albumConfigInfo.getStorySQL() + ", params year:" + queryTime.getYear() + ", month:" + queryTime.getMonth() + ", day:" + queryTime.getDay());
        }
        String storySQL = albumConfigInfo.getStorySQL();
        boolean z16 = true;
        int length = storySQL.length() - 1;
        int i16 = 0;
        boolean z17 = false;
        while (i16 <= length) {
            if (!z17) {
                i3 = i16;
            } else {
                i3 = length;
            }
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) ";", storySQL.charAt(i3), false, 2, (Object) null);
            if (!z17) {
                if (!contains$default2) {
                    z17 = true;
                } else {
                    i16++;
                }
            } else {
                if (!contains$default2) {
                    break;
                }
                length--;
            }
        }
        String obj = storySQL.subSequence(i16, length + 1).toString();
        String l3 = com.tencent.mobileqq.wink.newalbum.database.b.l();
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) obj, (CharSequence) "INNER JOIN", false, 2, (Object) null);
        String str2 = "";
        if (contains$default) {
            str = "";
        } else {
            str = " INNER JOIN " + l3 + " ON t_clip_" + albumConfigInfo.getStoryID() + ".id = " + l3 + ".id";
        }
        ArrayList arrayList = new ArrayList();
        if (queryTime.getYear() > 0) {
            arrayList.add(l3 + ".year = " + queryTime.getYear());
        }
        if (queryTime.getMonth() > 0) {
            arrayList.add(l3 + ".month = " + queryTime.getMonth());
        }
        if (queryTime.getDay() > 0) {
            arrayList.add(l3 + ".dayofmonth = " + queryTime.getDay());
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) obj, new String[]{" WHERE "}, false, 0, 6, (Object) null);
        String str3 = (String) split$default.get(0);
        if (split$default.size() > 1) {
            str2 = " WHERE " + split$default.get(1);
        }
        if (!arrayList.isEmpty()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, " AND ", null, null, 0, null, null, 62, null);
            if (str2.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                str2 = str2 + " AND " + joinToString$default;
            } else {
                str2 = " WHERE " + joinToString$default;
            }
        }
        String str4 = str3 + str + str2;
        if (QLog.isDevelopLevel()) {
            QLog.d("WinkNewAlbumCollectorUtils", 4, "genQuery result sql:" + str4);
        }
        return str4;
    }

    @NotNull
    public final QueryTime c(@NotNull List<WinkNewAlbumContext> candidateAlbumContexts, @NotNull WinkNewAlbumContext newAlbumContext) {
        Object last;
        Object last2;
        Intrinsics.checkNotNullParameter(candidateAlbumContexts, "candidateAlbumContexts");
        Intrinsics.checkNotNullParameter(newAlbumContext, "newAlbumContext");
        w83.b bVar = w83.b.f445025a;
        if (!bVar.I()) {
            return new QueryTime(0, 0, 0);
        }
        if (!candidateAlbumContexts.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) candidateAlbumContexts);
            if (((WinkNewAlbumContext) last).getIsLast()) {
                return new QueryTime(0, 0, 0);
            }
            if (!newAlbumContext.getIsLast()) {
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) candidateAlbumContexts);
                final z83.a metaData = ((WinkNewAlbumContext) last2).getMetaData();
                Function1<z83.a, Boolean> function1 = new Function1<z83.a, Boolean>() { // from class: com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorUtils$genQueryTime$yearChecker$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull z83.a metaData2) {
                        Intrinsics.checkNotNullParameter(metaData2, "metaData");
                        return Boolean.valueOf(metaData2.getYear() == z83.a.this.getYear());
                    }
                };
                Function1<z83.a, Boolean> function12 = new Function1<z83.a, Boolean>() { // from class: com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorUtils$genQueryTime$monthChecker$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull z83.a metaData2) {
                        Intrinsics.checkNotNullParameter(metaData2, "metaData");
                        return Boolean.valueOf(metaData2.getMonth() == z83.a.this.getMonth());
                    }
                };
                int a16 = a(candidateAlbumContexts, new Function1<z83.a, Boolean>() { // from class: com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorUtils$genQueryTime$dayChecker$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull z83.a metaData2) {
                        Intrinsics.checkNotNullParameter(metaData2, "metaData");
                        return Boolean.valueOf(metaData2.getDayOfMonth() == z83.a.this.getDayOfMonth());
                    }
                });
                if (newAlbumContext.getMetaData().getDayOfMonth() != metaData.getDayOfMonth() && a16 >= bVar.h()) {
                    return new QueryTime(metaData.getYear(), metaData.getMonth(), metaData.getDayOfMonth());
                }
                int a17 = a(candidateAlbumContexts, function12);
                if (newAlbumContext.getMetaData().getMonth() != metaData.getMonth() && a17 >= bVar.h()) {
                    return new QueryTime(metaData.getYear(), metaData.getMonth(), 0);
                }
                int a18 = a(candidateAlbumContexts, function1);
                if (newAlbumContext.getMetaData().getYear() != metaData.getYear() && a18 >= bVar.h()) {
                    return new QueryTime(metaData.getYear(), 0, 0);
                }
                return new QueryTime(0, 0, 0);
            }
            return new QueryTime(0, 0, 0);
        }
        return new QueryTime(0, 0, 0);
    }

    public final boolean d(@NotNull List<WinkNewAlbumContext> candidateAlbumContexts, @NotNull WinkNewAlbumContext newAlbumContext) {
        Intrinsics.checkNotNullParameter(candidateAlbumContexts, "candidateAlbumContexts");
        Intrinsics.checkNotNullParameter(newAlbumContext, "newAlbumContext");
        QueryTime c16 = c(candidateAlbumContexts, newAlbumContext);
        if (c16.getYear() == 0 && c16.getMonth() == 0 && c16.getDay() == 0) {
            return false;
        }
        return true;
    }
}
