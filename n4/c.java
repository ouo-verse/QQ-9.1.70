package n4;

import com.qzone.album.data.model.TimeLine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends a {

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Long, m4.c> f418290d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, HashMap<Integer, ArrayList<TimeLine>>> f418291e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    protected boolean f418292f = false;

    private void n(ArrayList<Long> arrayList, int i3, int i16, int i17) {
        m4.c cVar = this.f418290d.get(arrayList.get(i3));
        if (cVar != null) {
            if (i16 >= 0 && i16 < arrayList.size()) {
                m4.c cVar2 = this.f418290d.get(arrayList.get(i16));
                if (cVar2 != null) {
                    cVar.f416110i = cVar2.f416108g;
                } else {
                    cVar.f416110i = 0L;
                }
            } else {
                cVar.f416110i = 0L;
            }
            if (i17 < arrayList.size() && i17 >= 0) {
                m4.c cVar3 = this.f418290d.get(arrayList.get(i17));
                if (cVar3 != null) {
                    cVar.f416109h = cVar3.f416108g;
                    return;
                } else {
                    cVar.f416109h = 0L;
                    return;
                }
            }
            cVar.f416109h = 0L;
        }
    }

    @Override // n4.a
    protected void g(long j3, long j16, m4.d dVar) {
        int i3;
        int i16;
        int i17;
        HashMap<String, Long> hashMap = this.f418286a;
        if (hashMap == null) {
            return;
        }
        hashMap.clear();
        if (this.f418290d.get(Long.valueOf(j3)) == null || this.f418290d.get(Long.valueOf(j3)).f416102a == null) {
            return;
        }
        int i18 = this.f418290d.get(Long.valueOf(j3)).f416102a.total;
        this.f418286a.put("upBeginTime", Long.valueOf(j3));
        if (this.f418290d.get(Long.valueOf(j3)) != null && this.f418290d.get(Long.valueOf(j3)).f416109h > 0) {
            this.f418286a.put("upHasMore", 1L);
        } else {
            this.f418286a.put("upHasMore", 0L);
        }
        int i19 = 0;
        long j17 = j16;
        int i26 = 0;
        long j18 = j3;
        while (this.f418290d.get(Long.valueOf(j3)) != null && this.f418290d.get(Long.valueOf(j3)).f416102a != null) {
            if (i26 < o4.a.f421922a) {
                if (this.f418292f) {
                    j17 = this.f418290d.get(Long.valueOf(j3)).f416102a.endTime;
                } else {
                    j18 = this.f418290d.get(Long.valueOf(j3)).f416102a.beginTime;
                }
                if (!this.f418290d.get(Long.valueOf(j3)).f416103b) {
                    i26 += this.f418290d.get(Long.valueOf(j3)).f416102a.total;
                    j3 = this.f418290d.get(Long.valueOf(j3)).f416110i;
                    if (j3 > 0 && this.f418290d.get(Long.valueOf(j3)) != null && this.f418290d.get(Long.valueOf(j3)).f416103b) {
                        j3 = this.f418290d.get(Long.valueOf(j3)).f416109h;
                        this.f418286a.put("downHasMore", 1L);
                    }
                } else if (this.f418290d.get(Long.valueOf(j3)).f416106e != null && this.f418290d.get(Long.valueOf(j3)).f416106e.size() > 0) {
                    i17 = this.f418290d.get(Long.valueOf(j3)).f416106e.get(0).intValue();
                    int intValue = this.f418290d.get(Long.valueOf(j3)).f416107f.get(0).intValue();
                    int size = this.f418290d.get(Long.valueOf(j3)).f416104c.size();
                    this.f418286a.put("downHasMore", 1L);
                    i16 = 1;
                    i3 = intValue;
                    i19 = size;
                    this.f418286a.put("upPiecePointIndex", Long.valueOf(i19));
                    this.f418286a.put("downPiecePointIndex", Long.valueOf(i16));
                    this.f418286a.put("beginTime", Long.valueOf(j18));
                    this.f418286a.put("endTime", Long.valueOf(j17));
                    this.f418286a.put("start", Long.valueOf(i17));
                    this.f418286a.put("number", Long.valueOf(i3));
                    this.f418286a.put("photoOffset", 0L);
                    this.f418286a.put("downBeginTime", Long.valueOf(j3));
                    return;
                }
                if (j3 <= 0) {
                    this.f418286a.put("downHasMore", 0L);
                } else {
                    this.f418286a.put("downHasMore", 1L);
                }
            } else {
                j3 = this.f418290d.get(Long.valueOf(j3)).f416109h;
            }
            i16 = 0;
            i3 = i26;
            i17 = 0;
            this.f418286a.put("upPiecePointIndex", Long.valueOf(i19));
            this.f418286a.put("downPiecePointIndex", Long.valueOf(i16));
            this.f418286a.put("beginTime", Long.valueOf(j18));
            this.f418286a.put("endTime", Long.valueOf(j17));
            this.f418286a.put("start", Long.valueOf(i17));
            this.f418286a.put("number", Long.valueOf(i3));
            this.f418286a.put("photoOffset", 0L);
            this.f418286a.put("downBeginTime", Long.valueOf(j3));
            return;
        }
    }

    public void o(boolean z16) {
        this.f418292f = z16;
    }

    @Override // n4.a
    protected void h(long j3, long j16) {
        int i3;
        int i16;
        this.f418288c.clear();
        long longValue = this.f418286a.get("downBeginTime").longValue();
        if (this.f418290d.get(Long.valueOf(longValue)) == null || this.f418290d.get(Long.valueOf(longValue)).f416102a == null) {
            return;
        }
        int intValue = this.f418286a.get("downPiecePointIndex").intValue();
        if (this.f418290d.get(Long.valueOf(longValue)).f416103b && intValue < this.f418290d.get(Long.valueOf(longValue)).f416106e.size()) {
            long j17 = this.f418290d.get(Long.valueOf(longValue)).f416102a.endTime;
            int intValue2 = this.f418290d.get(Long.valueOf(longValue)).f416106e.get(intValue).intValue();
            int intValue3 = this.f418290d.get(Long.valueOf(longValue)).f416107f.get(intValue).intValue();
            int i17 = intValue + 1;
            this.f418288c.put("beginTime", Long.valueOf(longValue));
            this.f418288c.put("endTime", Long.valueOf(j17));
            this.f418288c.put("start", Long.valueOf(intValue2));
            this.f418288c.put("number", Long.valueOf(intValue3));
            this.f418286a.put("downPiecePointIndex", Long.valueOf(i17));
            if (i17 != this.f418290d.get(Long.valueOf(longValue)).f416106e.size() || this.f418290d.get(Long.valueOf(longValue)).f416110i > 0) {
                return;
            }
            this.f418286a.put("downHasMore", 0L);
            return;
        }
        this.f418286a.put("downPiecePointIndex", Long.valueOf(0));
        long j18 = this.f418290d.get(Long.valueOf(longValue)).f416110i;
        if (this.f418290d.get(Long.valueOf(j18)) == null || this.f418290d.get(Long.valueOf(j18)).f416102a == null) {
            return;
        }
        int i18 = 0;
        long j19 = this.f418290d.get(Long.valueOf(j18)).f416102a.endTime;
        long j26 = j18;
        while (this.f418290d.get(Long.valueOf(j18)) != null && this.f418290d.get(Long.valueOf(j18)).f416102a != null) {
            if (i18 < o4.a.f421922a) {
                if (this.f418292f) {
                    j19 = this.f418290d.get(Long.valueOf(j18)).f416102a.endTime;
                    j26 = j26;
                } else {
                    j26 = this.f418290d.get(Long.valueOf(j18)).f416102a.beginTime;
                }
                if (!this.f418290d.get(Long.valueOf(j18)).f416103b) {
                    i18 += this.f418290d.get(Long.valueOf(j18)).f416102a.total;
                    j18 = this.f418290d.get(Long.valueOf(j18)).f416110i;
                    if (j18 > 0 && this.f418290d.get(Long.valueOf(j18)) != null && this.f418290d.get(Long.valueOf(j18)).f416103b) {
                        j18 = this.f418290d.get(Long.valueOf(j18)).f416109h;
                        this.f418286a.put("downHasMore", 1L);
                    }
                } else if (this.f418290d.get(Long.valueOf(j18)).f416106e != null && this.f418290d.get(Long.valueOf(j18)).f416106e.size() > 0) {
                    int intValue4 = this.f418290d.get(Long.valueOf(j18)).f416106e.get(0).intValue();
                    int intValue5 = this.f418290d.get(Long.valueOf(j18)).f416107f.get(0).intValue();
                    this.f418290d.get(Long.valueOf(j18)).f416104c.size();
                    this.f418286a.put("downHasMore", 1L);
                    i18 = intValue5;
                    i3 = 1;
                    i16 = intValue4;
                    this.f418288c.put("beginTime", Long.valueOf(j26));
                    this.f418288c.put("endTime", Long.valueOf(j19));
                    this.f418288c.put("start", Long.valueOf(i16));
                    this.f418288c.put("number", Long.valueOf(i18));
                    this.f418286a.put("downBeginTime", Long.valueOf(j18));
                    this.f418286a.put("downPiecePointIndex", Long.valueOf(i3));
                    return;
                }
                if (j18 <= 0) {
                    this.f418286a.put("downHasMore", 0L);
                } else {
                    this.f418286a.put("downHasMore", 1L);
                }
            } else {
                j18 = this.f418290d.get(Long.valueOf(j18)).f416109h;
            }
            i16 = 0;
            i3 = 0;
            this.f418288c.put("beginTime", Long.valueOf(j26));
            this.f418288c.put("endTime", Long.valueOf(j19));
            this.f418288c.put("start", Long.valueOf(i16));
            this.f418288c.put("number", Long.valueOf(i18));
            this.f418286a.put("downBeginTime", Long.valueOf(j18));
            this.f418286a.put("downPiecePointIndex", Long.valueOf(i3));
            return;
        }
    }

    @Override // n4.a
    protected void i(long j3, long j16) {
        int i3;
        int i16;
        this.f418287b.clear();
        long longValue = this.f418286a.get("upBeginTime").longValue();
        int intValue = this.f418286a.get("upPiecePointIndex").intValue();
        if (this.f418290d.get(Long.valueOf(longValue)) == null || this.f418290d.get(Long.valueOf(longValue)).f416102a == null) {
            return;
        }
        if (this.f418290d.get(Long.valueOf(longValue)).f416103b && intValue < this.f418290d.get(Long.valueOf(longValue)).f416104c.size()) {
            long j17 = this.f418290d.get(Long.valueOf(longValue)).f416102a.endTime;
            int intValue2 = this.f418290d.get(Long.valueOf(longValue)).f416104c.get(intValue).intValue();
            int intValue3 = this.f418290d.get(Long.valueOf(longValue)).f416105d.get(intValue).intValue();
            int i17 = intValue + 1;
            this.f418287b.put("beginTime", Long.valueOf(longValue));
            this.f418287b.put("endTime", Long.valueOf(j17));
            this.f418287b.put("start", Long.valueOf(intValue2));
            this.f418287b.put("number", Long.valueOf(intValue3));
            this.f418286a.put("upPiecePointIndex", Long.valueOf(i17));
            if (i17 != this.f418290d.get(Long.valueOf(longValue)).f416104c.size() || this.f418290d.get(Long.valueOf(longValue)).f416109h > 0) {
                return;
            }
            this.f418286a.put("upHasMore", 0L);
            return;
        }
        this.f418286a.put("upPiecePointIndex", Long.valueOf(0));
        long j18 = this.f418290d.get(Long.valueOf(longValue)).f416109h;
        if (this.f418290d.get(Long.valueOf(j18)) == null || this.f418290d.get(Long.valueOf(j18)).f416102a == null) {
            return;
        }
        int i18 = 0;
        long j19 = this.f418290d.get(Long.valueOf(j18)).f416102a.endTime;
        long j26 = j18;
        for (long j27 = 0; j18 > j27 && this.f418290d.get(Long.valueOf(j18)) != null && this.f418290d.get(Long.valueOf(j18)).f416102a != null; j27 = 0) {
            if (this.f418292f) {
                j26 = this.f418290d.get(Long.valueOf(j18)).f416102a.beginTime;
            } else {
                j19 = this.f418290d.get(Long.valueOf(j18)).f416102a.endTime;
                j26 = j26;
            }
            if (i18 < o4.a.f421922a) {
                if (!this.f418290d.get(Long.valueOf(j18)).f416103b) {
                    i18 += this.f418290d.get(Long.valueOf(j18)).f416102a.total;
                    j18 = this.f418290d.get(Long.valueOf(j18)).f416109h;
                    if (j18 > 0 && this.f418290d.get(Long.valueOf(j18)) != null && this.f418290d.get(Long.valueOf(j18)).f416103b) {
                        this.f418286a.put("upHasMore", 1L);
                        break;
                    }
                } else if (this.f418290d.get(Long.valueOf(j18)).f416104c != null && this.f418290d.get(Long.valueOf(j18)).f416104c.size() > 0) {
                    int intValue4 = this.f418290d.get(Long.valueOf(j18)).f416104c.get(0).intValue();
                    int intValue5 = this.f418290d.get(Long.valueOf(j18)).f416105d.get(0).intValue();
                    this.f418286a.put("upBeginTime", Long.valueOf(j18));
                    this.f418286a.put("upHasMore", 1L);
                    i18 = intValue5;
                    i3 = 1;
                    i16 = intValue4;
                    break;
                }
                if (j18 <= 0) {
                    this.f418286a.put("upHasMore", 0L);
                    break;
                }
                this.f418286a.put("upHasMore", 1L);
            } else {
                j18 = this.f418290d.get(Long.valueOf(j18)).f416110i;
                break;
            }
        }
        this.f418286a.put("upHasMore", 0L);
        j26 = j26;
        i16 = 0;
        i3 = 0;
        this.f418286a.put("upPiecePointIndex", Long.valueOf(i3));
        this.f418287b.put("beginTime", Long.valueOf(j26));
        this.f418287b.put("endTime", Long.valueOf(j19));
        this.f418287b.put("start", Long.valueOf(i16));
        this.f418287b.put("number", Long.valueOf(i18));
        this.f418286a.put("upBeginTime", Long.valueOf(j18));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        if (r10 > r14.beginTime) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(ArrayList<TimeLine> arrayList) {
        Iterator<Integer> it;
        long j3;
        Iterator<Integer> it5;
        HashMap<Integer, HashMap<Integer, ArrayList<TimeLine>>> a16 = o4.c.a(arrayList);
        this.f418291e = a16;
        if (a16 == null || a16.size() <= 0) {
            return;
        }
        if (this.f418290d == null) {
            this.f418290d = new HashMap<>();
        }
        this.f418290d.clear();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        Iterator<Integer> it6 = this.f418291e.keySet().iterator();
        while (it6.hasNext()) {
            HashMap<Integer, ArrayList<TimeLine>> hashMap = this.f418291e.get(it6.next());
            if (hashMap != null && hashMap.size() > 0) {
                Iterator<Integer> it7 = hashMap.keySet().iterator();
                while (it7.hasNext()) {
                    ArrayList<TimeLine> arrayList3 = hashMap.get(it7.next());
                    long j16 = 0;
                    int i3 = 0;
                    if (arrayList3 == null || arrayList3.size() <= 0) {
                        it = it7;
                        j3 = 0;
                    } else {
                        Iterator<TimeLine> it8 = arrayList3.iterator();
                        j3 = 0;
                        long j17 = 0;
                        while (it8.hasNext()) {
                            TimeLine next = it8.next();
                            i3 += next.total;
                            if (j3 != 0) {
                                it5 = it7;
                            } else {
                                it5 = it7;
                            }
                            j3 = next.beginTime;
                            if (j17 == 0 || j17 < next.endTime) {
                                j17 = next.endTime;
                            }
                            it7 = it5;
                        }
                        it = it7;
                        j16 = j17;
                    }
                    m4.c cVar = new m4.c();
                    TimeLine timeLine = new TimeLine();
                    timeLine.total = i3;
                    timeLine.endTime = j16;
                    timeLine.beginTime = j3;
                    cVar.f416102a = timeLine;
                    cVar.f416108g = j3;
                    if (i3 > o4.a.f421922a) {
                        cVar.f416103b = true;
                        l(cVar, i3);
                    }
                    arrayList2.add(Long.valueOf(j3));
                    this.f418290d.put(Long.valueOf(j3), cVar);
                    it7 = it;
                }
            }
        }
        if (arrayList2.size() > 0) {
            Collections.sort(arrayList2);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                if (this.f418292f) {
                    n(arrayList2, size, size + 1, size - 1);
                } else {
                    n(arrayList2, size, size - 1, size + 1);
                }
            }
        }
    }
}
