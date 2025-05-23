package n4;

import com.qzone.album.data.model.TimeLine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Long, m4.c> f418289d = new HashMap<>();

    /* JADX WARN: Removed duplicated region for block: B:28:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0185 A[LOOP:0: B:10:0x004b->B:82:0x0185, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x017b A[SYNTHETIC] */
    @Override // n4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void g(long j3, long j16, m4.d dVar) {
        int i3;
        int i16;
        int i17;
        long j17;
        boolean z16;
        HashMap<String, Long> hashMap = this.f418286a;
        if (hashMap == null) {
            return;
        }
        hashMap.clear();
        if (this.f418289d.get(Long.valueOf(j3)) == null || this.f418289d.get(Long.valueOf(j3)).f416102a == null) {
            return;
        }
        long j18 = this.f418289d.get(Long.valueOf(j3)).f416102a.total;
        this.f418286a.put("upBeginTime", Long.valueOf(j3));
        int i18 = 0;
        long j19 = j3;
        long j26 = j16;
        int i19 = 0;
        while (this.f418289d.get(Long.valueOf(j19)) != null && this.f418289d.get(Long.valueOf(j19)).f416102a != null) {
            if (i19 < o4.a.f421922a) {
                if (!this.f418289d.get(Long.valueOf(j19)).f416103b) {
                    i19 += this.f418289d.get(Long.valueOf(j19)).f416102a.total;
                    j26 = this.f418289d.get(Long.valueOf(j19)).f416102a.endTime;
                    j19 = this.f418289d.get(Long.valueOf(j19)).f416109h;
                    if (j19 > 0 && this.f418289d.get(Long.valueOf(j19)) != null && this.f418289d.get(Long.valueOf(j19)).f416103b) {
                        j19 = this.f418289d.get(Long.valueOf(j19)).f416110i;
                        this.f418286a.put("upHasMore", 1L);
                        i17 = i18;
                        i3 = i19;
                        i16 = i17;
                        this.f418286a.put("upBeginTime", Long.valueOf(j19));
                        this.f418286a.put("beginTime", Long.valueOf(j3));
                        this.f418286a.put("endTime", Long.valueOf(j26));
                        this.f418286a.put("upPiecePointIndex", Long.valueOf(i18));
                        this.f418286a.put("start", Long.valueOf(i16));
                        this.f418286a.put("downPiecePointIndex", Long.valueOf(i17));
                        long j27 = i3;
                        this.f418286a.put("number", Long.valueOf(j27));
                        HashMap<String, Long> hashMap2 = this.f418286a;
                        j17 = j27 - j18;
                        if (j17 <= 0) {
                            j17 = 0;
                        }
                        hashMap2.put("photoOffset", Long.valueOf(j17));
                        this.f418286a.put("downBeginTime", Long.valueOf(j3));
                        if ((j19 <= 0 && this.f418289d.get(Long.valueOf(j19)) != null && !this.f418289d.get(Long.valueOf(j19)).f416103b && this.f418289d.get(Long.valueOf(j19)).f416109h > 0) || (j19 > 0 && this.f418289d.get(Long.valueOf(j19)) != null && this.f418289d.get(Long.valueOf(j19)).f416103b && i18 <= this.f418289d.get(Long.valueOf(j19)).f416105d.size())) {
                            if (this.f418289d.get(Long.valueOf(j19)).f416103b && i18 == this.f418289d.get(Long.valueOf(j19)).f416105d.size()) {
                                long j28 = this.f418289d.get(Long.valueOf(j19)).f416109h;
                                if (j28 <= 0 || this.f418289d.get(Long.valueOf(j28)) == null || this.f418289d.get(Long.valueOf(j28)).f416102a == null) {
                                    z16 = false;
                                    this.f418286a.put("upHasMore", Long.valueOf(!z16 ? 1L : 0L));
                                }
                            }
                            z16 = true;
                            this.f418286a.put("upHasMore", Long.valueOf(!z16 ? 1L : 0L));
                        } else {
                            this.f418286a.put("upHasMore", 0L);
                        }
                        if ((this.f418289d.get(Long.valueOf(j3)) == null && !this.f418289d.get(Long.valueOf(j3)).f416103b && this.f418289d.get(Long.valueOf(j3)).f416110i > 0) || (this.f418289d.get(Long.valueOf(j3)) != null && this.f418289d.get(Long.valueOf(j3)).f416103b && this.f418289d.get(Long.valueOf(j3)).f416107f != null && i17 < this.f418289d.get(Long.valueOf(j3)).f416107f.size())) {
                            this.f418286a.put("downHasMore", 1L);
                            return;
                        } else {
                            this.f418286a.put("downHasMore", 0L);
                            return;
                        }
                    }
                    if (j19 > 0) {
                        this.f418286a.put("upHasMore", 0L);
                    } else {
                        this.f418286a.put("upHasMore", 1L);
                        i18 = 0;
                    }
                } else {
                    j26 = this.f418289d.get(Long.valueOf(j19)).f416102a.endTime;
                    if (this.f418289d.get(Long.valueOf(j19)).f416106e != null && this.f418289d.get(Long.valueOf(j19)).f416106e.size() > 0) {
                        i16 = this.f418289d.get(Long.valueOf(j19)).f416106e.get(i18).intValue();
                        i3 = this.f418289d.get(Long.valueOf(j19)).f416107f.get(i18).intValue();
                        int size = this.f418289d.get(Long.valueOf(j19)).f416104c.size();
                        this.f418286a.put("downHasMore", 1L);
                        i18 = size;
                        i17 = 1;
                        this.f418286a.put("upBeginTime", Long.valueOf(j19));
                        this.f418286a.put("beginTime", Long.valueOf(j3));
                        this.f418286a.put("endTime", Long.valueOf(j26));
                        this.f418286a.put("upPiecePointIndex", Long.valueOf(i18));
                        this.f418286a.put("start", Long.valueOf(i16));
                        this.f418286a.put("downPiecePointIndex", Long.valueOf(i17));
                        long j272 = i3;
                        this.f418286a.put("number", Long.valueOf(j272));
                        HashMap<String, Long> hashMap22 = this.f418286a;
                        j17 = j272 - j18;
                        if (j17 <= 0) {
                        }
                        hashMap22.put("photoOffset", Long.valueOf(j17));
                        this.f418286a.put("downBeginTime", Long.valueOf(j3));
                        if (j19 <= 0) {
                        }
                        this.f418286a.put("upHasMore", 0L);
                        if (this.f418289d.get(Long.valueOf(j3)) == null) {
                        }
                        this.f418286a.put("downHasMore", 0L);
                        return;
                    }
                    if (j19 > 0) {
                    }
                }
            }
            i3 = i19;
            i18 = 0;
            i16 = 0;
            i17 = 0;
            this.f418286a.put("upBeginTime", Long.valueOf(j19));
            this.f418286a.put("beginTime", Long.valueOf(j3));
            this.f418286a.put("endTime", Long.valueOf(j26));
            this.f418286a.put("upPiecePointIndex", Long.valueOf(i18));
            this.f418286a.put("start", Long.valueOf(i16));
            this.f418286a.put("downPiecePointIndex", Long.valueOf(i17));
            long j2722 = i3;
            this.f418286a.put("number", Long.valueOf(j2722));
            HashMap<String, Long> hashMap222 = this.f418286a;
            j17 = j2722 - j18;
            if (j17 <= 0) {
            }
            hashMap222.put("photoOffset", Long.valueOf(j17));
            this.f418286a.put("downBeginTime", Long.valueOf(j3));
            if (j19 <= 0) {
            }
            this.f418286a.put("upHasMore", 0L);
            if (this.f418289d.get(Long.valueOf(j3)) == null) {
            }
            this.f418286a.put("downHasMore", 0L);
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01ec A[LOOP:0: B:32:0x0148->B:64:0x01ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01db A[SYNTHETIC] */
    @Override // n4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void h(long j3, long j16) {
        m4.c cVar;
        TimeLine timeLine;
        int i3;
        int i16;
        String str;
        long j17;
        int i17;
        long j18;
        long j19;
        long j26;
        this.f418288c.clear();
        long longValue = this.f418286a.get("downBeginTime").longValue();
        int intValue = this.f418286a.get("downPiecePointIndex").intValue();
        HashMap<Long, m4.c> hashMap = this.f418289d;
        if (hashMap == null || !(hashMap.get(Long.valueOf(longValue)) == null || this.f418289d.get(Long.valueOf(longValue)).f416102a == null)) {
            HashMap<Long, m4.c> hashMap2 = this.f418289d;
            if (hashMap2 != null && hashMap2.get(Long.valueOf(longValue)).f416103b && intValue < this.f418289d.get(Long.valueOf(longValue)).f416106e.size()) {
                long j27 = this.f418289d.get(Long.valueOf(longValue)).f416102a.endTime;
                int intValue2 = this.f418289d.get(Long.valueOf(longValue)).f416106e.get(intValue).intValue();
                int intValue3 = this.f418289d.get(Long.valueOf(longValue)).f416107f.get(intValue).intValue();
                int i18 = intValue + 1;
                this.f418288c.put("beginTime", Long.valueOf(longValue));
                this.f418288c.put("endTime", Long.valueOf(j27));
                this.f418288c.put("start", Long.valueOf(intValue2));
                this.f418288c.put("number", Long.valueOf(intValue3));
                this.f418286a.put("downPiecePointIndex", Long.valueOf(i18));
                if (i18 != this.f418289d.get(Long.valueOf(longValue)).f416106e.size() || this.f418289d.get(Long.valueOf(longValue)).f416110i > 0) {
                    return;
                }
                this.f418286a.put("downHasMore", 0L);
                return;
            }
            this.f418286a.put("downPiecePointIndex", Long.valueOf(0));
            HashMap<Long, m4.c> hashMap3 = this.f418289d;
            if (hashMap3 == null || (cVar = hashMap3.get(Long.valueOf(longValue))) == null || (timeLine = cVar.f416102a) == null) {
                return;
            }
            int i19 = 0;
            long j28 = cVar.f416110i;
            long j29 = timeLine.endTime;
            long j36 = 0;
            while (true) {
                TimeLine timeLine2 = cVar.f416102a;
                if (timeLine2 != null) {
                    long j37 = j36;
                    if (i19 < o4.a.f421922a) {
                        boolean z16 = cVar.f416103b;
                        if (!z16) {
                            i19 += timeLine2.total;
                            long j38 = j29;
                            j19 = timeLine2.beginTime;
                            long j39 = cVar.f416110i;
                            if (j39 > 0 && z16) {
                                long j46 = cVar.f416109h;
                                this.f418286a.put("downHasMore", 1L);
                                str = "downHasMore";
                                j29 = j38;
                                i3 = 0;
                                i16 = 0;
                                j17 = j19;
                                j28 = j46;
                                break;
                            }
                            j26 = j39;
                            j29 = j38;
                            i17 = 0;
                            j18 = 0;
                            if (j26 > j18) {
                                this.f418286a.put("downHasMore", Long.valueOf(j18));
                                i3 = i17;
                                i16 = i3;
                                str = "downHasMore";
                                j17 = j19;
                                j28 = j26;
                                break;
                            }
                            this.f418286a.put("downHasMore", 1L);
                            j36 = j19;
                            j28 = j26;
                        } else {
                            j29 = timeLine2.endTime;
                            ArrayList<Integer> arrayList = cVar.f416106e;
                            if (arrayList != null && arrayList.size() > 0) {
                                long j47 = cVar.f416102a.beginTime;
                                i16 = cVar.f416106e.get(0).intValue();
                                i19 = cVar.f416107f.get(0).intValue();
                                this.f418286a.put("downBeginTime", Long.valueOf(j28));
                                this.f418286a.put("downHasMore", 1L);
                                str = "downHasMore";
                                j17 = j47;
                                i3 = 1;
                                break;
                            }
                            i17 = 0;
                            j18 = 0;
                            long j48 = j28;
                            j19 = j37;
                            j26 = j48;
                            if (j26 > j18) {
                            }
                        }
                    } else {
                        this.f418286a.put("downBeginTime", Long.valueOf(cVar.f416109h));
                        i3 = 0;
                        i16 = 0;
                        str = "downHasMore";
                        j17 = j37;
                        j29 = j29;
                        break;
                    }
                } else {
                    return;
                }
            }
            this.f418288c.put("beginTime", Long.valueOf(j17));
            this.f418288c.put("endTime", Long.valueOf(j29));
            this.f418288c.put("start", Long.valueOf(i16));
            this.f418288c.put("number", Long.valueOf(i19));
            this.f418286a.put("downBeginTime", Long.valueOf(j28));
            this.f418286a.put("downPiecePointIndex", Long.valueOf(i3));
            if ((this.f418289d.get(Long.valueOf(j17)) != null && !this.f418289d.get(Long.valueOf(j17)).f416103b && this.f418289d.get(Long.valueOf(j17)).f416110i > 0) || (this.f418289d.get(Long.valueOf(j17)) != null && this.f418289d.get(Long.valueOf(j17)).f416103b && this.f418289d.get(Long.valueOf(j17)).f416107f != null && i3 < this.f418289d.get(Long.valueOf(j17)).f416107f.size())) {
                this.f418286a.put(str, 1L);
            } else {
                this.f418286a.put(str, 0L);
            }
        }
    }

    @Override // n4.a
    protected void i(long j3, long j16) {
        long j17;
        String str;
        int i3;
        int i16;
        long j18;
        this.f418287b.clear();
        int intValue = this.f418286a.get("upPiecePointIndex").intValue();
        long longValue = this.f418286a.get("upBeginTime").longValue();
        if (this.f418289d.get(Long.valueOf(longValue)) == null || this.f418289d.get(Long.valueOf(longValue)).f416102a == null) {
            return;
        }
        if (this.f418289d.get(Long.valueOf(longValue)).f416103b && intValue < this.f418289d.get(Long.valueOf(longValue)).f416104c.size()) {
            long j19 = this.f418289d.get(Long.valueOf(longValue)).f416102a.endTime;
            int intValue2 = this.f418289d.get(Long.valueOf(longValue)).f416104c.get(intValue).intValue();
            int intValue3 = this.f418289d.get(Long.valueOf(longValue)).f416105d.get(intValue).intValue();
            int i17 = intValue + 1;
            this.f418287b.put("beginTime", Long.valueOf(longValue));
            this.f418287b.put("endTime", Long.valueOf(j19));
            this.f418287b.put("start", Long.valueOf(intValue2));
            this.f418287b.put("number", Long.valueOf(intValue3));
            this.f418286a.put("upPiecePointIndex", Long.valueOf(i17));
            if (i17 != this.f418289d.get(Long.valueOf(longValue)).f416104c.size() || this.f418289d.get(Long.valueOf(longValue)).f416109h > 0) {
                return;
            }
            this.f418286a.put("upHasMore", 0L);
            return;
        }
        this.f418286a.put("upPiecePointIndex", Long.valueOf(0));
        long j26 = this.f418289d.get(Long.valueOf(longValue)).f416109h;
        int i18 = 0;
        long j27 = j26;
        long j28 = 0;
        while (j27 > 0 && this.f418289d.get(Long.valueOf(j27)) != null && this.f418289d.get(Long.valueOf(j27)).f416102a != null) {
            if (i18 < o4.a.f421922a) {
                if (!this.f418289d.get(Long.valueOf(j27)).f416103b) {
                    i18 += this.f418289d.get(Long.valueOf(j27)).f416102a.total;
                    j17 = this.f418289d.get(Long.valueOf(j27)).f416102a.endTime;
                    long j29 = this.f418289d.get(Long.valueOf(j27)).f416109h;
                    if (j29 <= 0 || this.f418289d.get(Long.valueOf(j29)) == null || !this.f418289d.get(Long.valueOf(j29)).f416103b) {
                        j27 = j29;
                        j28 = j17;
                    } else {
                        j18 = this.f418289d.get(Long.valueOf(j29)).f416110i;
                        this.f418286a.put("upHasMore", 1L);
                    }
                } else {
                    j28 = this.f418289d.get(Long.valueOf(j27)).f416102a.endTime;
                    if (this.f418289d.get(Long.valueOf(j27)).f416104c != null && this.f418289d.get(Long.valueOf(j27)).f416104c.size() > 0) {
                        int intValue4 = this.f418289d.get(Long.valueOf(j27)).f416104c.get(0).intValue();
                        int intValue5 = this.f418289d.get(Long.valueOf(j27)).f416105d.get(0).intValue();
                        this.f418286a.put("upBeginTime", Long.valueOf(j27));
                        this.f418286a.put("upHasMore", 1L);
                        i18 = intValue5;
                        str = "upHasMore";
                        i3 = 1;
                        i16 = intValue4;
                        break;
                    }
                }
                if (j27 <= 0) {
                    this.f418286a.put("upHasMore", 0L);
                    str = "upHasMore";
                    break;
                }
                this.f418286a.put("upHasMore", 1L);
            } else {
                j17 = j28;
                j18 = this.f418289d.get(Long.valueOf(j27)).f416110i;
            }
            str = "upHasMore";
            j27 = j18;
        }
        j17 = j28;
        this.f418286a.put("upHasMore", 0L);
        str = "upHasMore";
        j28 = j17;
        i16 = 0;
        i3 = 0;
        this.f418287b.put("beginTime", Long.valueOf(j26));
        this.f418287b.put("endTime", Long.valueOf(j28));
        this.f418287b.put("start", Long.valueOf(i16));
        this.f418287b.put("number", Long.valueOf(i18));
        this.f418286a.put("upBeginTime", Long.valueOf(j27));
        this.f418286a.put("upPiecePointIndex", Long.valueOf(i3));
        if ((j27 > 0 && this.f418289d.get(Long.valueOf(j27)) != null && !this.f418289d.get(Long.valueOf(j27)).f416103b && this.f418289d.get(Long.valueOf(j27)).f416109h > 0) || (j27 > 0 && this.f418289d.get(Long.valueOf(j27)) != null && this.f418289d.get(Long.valueOf(j27)).f416103b && i3 < this.f418289d.get(Long.valueOf(j27)).f416105d.size())) {
            this.f418286a.put(str, 1L);
        } else {
            this.f418286a.put(str, 0L);
        }
    }

    public void m(ArrayList<TimeLine> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f418289d.clear();
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList2.removeAll(Collections.singleton(null));
        int size = arrayList2.size() - 1;
        int i3 = size;
        while (i3 >= 0) {
            m4.c cVar = new m4.c();
            TimeLine timeLine = (TimeLine) arrayList2.get(i3);
            int i16 = timeLine.total;
            if (i16 > o4.a.f421922a) {
                cVar.f416103b = true;
                l(cVar, i16);
            }
            cVar.f416102a = timeLine;
            cVar.f416108g = timeLine.beginTime;
            long j3 = 0;
            cVar.f416109h = i3 < size ? ((TimeLine) arrayList2.get(i3 + 1)).beginTime : 0L;
            if (i3 > 0) {
                j3 = ((TimeLine) arrayList2.get(i3 - 1)).beginTime;
            }
            cVar.f416110i = j3;
            this.f418289d.put(Long.valueOf(timeLine.beginTime), cVar);
            i3--;
        }
    }
}
