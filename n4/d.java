package n4;

import com.qzone.album.data.model.PhotoPoiArea;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends a {

    /* renamed from: d, reason: collision with root package name */
    private HashMap<m4.b, m4.a> f418293d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f418294e = new HashMap<>();

    @Override // n4.a
    protected void h(long j3, long j16) {
        this.f418288c.clear();
        long longValue = this.f418286a.get("downBeginTime").longValue();
        String str = this.f418294e.get("downPoiAreaDescription");
        m4.b bVar = new m4.b();
        bVar.f416100a = longValue;
        bVar.f416101b = str;
        if (this.f418293d.get(bVar) == null || this.f418293d.get(bVar).f416094a == null) {
            return;
        }
        long j17 = this.f418293d.get(bVar).f416097d;
        String str2 = this.f418293d.get(bVar).f416099f;
        bVar.f416100a = j17;
        bVar.f416101b = str2;
        if (this.f418293d.get(bVar) == null || this.f418293d.get(bVar).f416094a == null) {
            return;
        }
        int i3 = 0;
        long j18 = 0;
        while (this.f418293d.get(bVar) != null && this.f418293d.get(bVar).f416094a != null) {
            if (i3 < o4.a.f421922a) {
                i3 = (int) (i3 + this.f418293d.get(bVar).f416094a.photoNum);
                j18 = this.f418293d.get(bVar).f416094a.endShootTime;
                long j19 = this.f418293d.get(bVar).f416097d;
                String str3 = this.f418293d.get(bVar).f416099f;
                bVar.f416100a = j19;
                bVar.f416101b = str3;
                if (j19 <= 0) {
                    this.f418286a.put("downHasMore", 0L);
                } else {
                    this.f418286a.put("downHasMore", 1L);
                }
            } else {
                this.f418286a.put("downBeginTime", Long.valueOf(this.f418293d.get(bVar).f416096c));
                this.f418294e.put("downPoiAreaDescription", this.f418293d.get(bVar).f416098e);
            }
            this.f418288c.put("beginTime", Long.valueOf(j17));
            this.f418288c.put("endTime", Long.valueOf(j18));
            this.f418288c.put("start", 0L);
            this.f418288c.put("number", Long.valueOf(i3));
            return;
        }
    }

    @Override // n4.a
    protected void i(long j3, long j16) {
        this.f418287b.clear();
        long longValue = this.f418286a.get("upBeginTime").longValue();
        String str = this.f418294e.get("upPoiAreaDescription");
        m4.b bVar = new m4.b();
        bVar.f416100a = longValue;
        bVar.f416101b = str;
        if (this.f418293d.get(bVar) == null || this.f418293d.get(bVar).f416094a == null) {
            return;
        }
        long j17 = this.f418293d.get(bVar).f416096c;
        String str2 = this.f418293d.get(bVar).f416098e;
        bVar.f416100a = j17;
        bVar.f416101b = str2;
        if (this.f418293d.get(bVar) == null || this.f418293d.get(bVar).f416094a == null) {
            return;
        }
        long j18 = this.f418293d.get(bVar).f416094a.endShootTime;
        int i3 = 0;
        long j19 = 0;
        while (this.f418293d.get(bVar) != null && this.f418293d.get(bVar).f416094a != null) {
            if (i3 < o4.a.f421922a) {
                i3 = (int) (i3 + this.f418293d.get(bVar).f416094a.photoNum);
                j19 = this.f418293d.get(bVar).f416094a.startShootTime;
                long j26 = this.f418293d.get(bVar).f416096c;
                String str3 = this.f418293d.get(bVar).f416098e;
                bVar.f416100a = j26;
                bVar.f416101b = str3;
                if (j26 <= 0) {
                    this.f418286a.put("upHasMore", 0L);
                } else {
                    this.f418286a.put("upHasMore", 1L);
                }
            } else {
                this.f418286a.put("upBeginTime", Long.valueOf(this.f418293d.get(bVar).f416097d));
                this.f418294e.put("upPoiAreaDescription", this.f418293d.get(bVar).f416099f);
            }
            this.f418287b.put("beginTime", Long.valueOf(j19));
            this.f418287b.put("endTime", Long.valueOf(j18));
            this.f418287b.put("start", 0L);
            this.f418287b.put("number", Long.valueOf(i3));
            return;
        }
    }

    public void m(ArrayList<PhotoPoiArea> arrayList) {
        String str;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList2.removeAll(Collections.singleton(null));
        this.f418293d.clear();
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            m4.a aVar = new m4.a();
            aVar.f416094a = (PhotoPoiArea) arrayList2.get(i3);
            aVar.f416095b = ((PhotoPoiArea) arrayList2.get(i3)).startShootTime;
            aVar.f416096c = i3 > 0 ? ((PhotoPoiArea) arrayList2.get(i3 - 1)).startShootTime : 0L;
            int i16 = size - 1;
            aVar.f416097d = i3 < i16 ? ((PhotoPoiArea) arrayList2.get(i3 + 1)).startShootTime : 0L;
            String str2 = "";
            if (i3 <= 0) {
                str = "";
            } else {
                str = ((PhotoPoiArea) arrayList2.get(i3 - 1)).sceneryName;
            }
            aVar.f416098e = str;
            if (i3 < i16) {
                str2 = ((PhotoPoiArea) arrayList2.get(i3 + 1)).sceneryName;
            }
            aVar.f416099f = str2;
            m4.b bVar = new m4.b();
            bVar.f416100a = ((PhotoPoiArea) arrayList2.get(i3)).startShootTime;
            bVar.f416101b = ((PhotoPoiArea) arrayList2.get(i3)).sceneryName;
            this.f418293d.put(bVar, aVar);
            i3++;
        }
    }

    @Override // n4.a
    protected void g(long j3, long j16, m4.d dVar) {
        String str = dVar != null ? dVar.f416111a : null;
        m4.b bVar = new m4.b();
        bVar.f416100a = j3;
        bVar.f416101b = str;
        m4.b bVar2 = new m4.b();
        this.f418286a.clear();
        if (this.f418293d.get(bVar) == null || this.f418293d.get(bVar).f416094a == null) {
            return;
        }
        long j17 = this.f418293d.get(bVar).f416094a.photoNum;
        this.f418286a.put("upBeginTime", Long.valueOf(j3));
        int i3 = 0;
        long j18 = j3;
        while (this.f418293d.get(bVar) != null && this.f418293d.get(bVar).f416094a != null) {
            if (i3 < o4.a.f421922a) {
                i3 = (int) (i3 + this.f418293d.get(bVar).f416094a.photoNum);
                j18 = this.f418293d.get(bVar).f416094a.startShootTime;
                String str2 = this.f418293d.get(bVar).f416094a.description;
                long j19 = this.f418293d.get(bVar).f416096c;
                String str3 = this.f418293d.get(bVar).f416098e;
                bVar.f416100a = j19;
                bVar.f416101b = str3;
                if (j19 <= 0) {
                    this.f418286a.put("upHasMore", 0L);
                    this.f418294e.put("upPoiAreaDescription", "");
                } else {
                    this.f418286a.put("upHasMore", 1L);
                    this.f418286a.put("upBeginTime", Long.valueOf(j18));
                    this.f418294e.put("upPoiAreaDescription", str2);
                }
            } else {
                this.f418286a.put("upBeginTime", Long.valueOf(this.f418293d.get(bVar).f416097d));
                this.f418294e.put("upPoiAreaDescription", this.f418293d.get(bVar).f416099f);
                i3 = i3;
            }
            this.f418286a.put("beginTime", Long.valueOf(j18));
            this.f418286a.put("endTime", Long.valueOf(j16));
            this.f418286a.put("start", 0L);
            long j26 = i3;
            this.f418286a.put("number", Long.valueOf(j26));
            this.f418286a.put("photoOffset", Long.valueOf(j26 - j17));
            this.f418286a.put("downBeginTime", Long.valueOf(j3));
            this.f418294e.put("downPoiAreaDescription", str);
            if (this.f418293d.get(bVar) != null && this.f418293d.get(bVar).f416096c > 0) {
                this.f418286a.put("upHasMore", 1L);
            } else {
                this.f418286a.put("upHasMore", 0L);
            }
            bVar2.f416100a = j3;
            bVar2.f416101b = str;
            if (this.f418293d.get(bVar2) != null && this.f418293d.get(bVar2).f416097d > 0) {
                this.f418286a.put("downHasMore", 1L);
                return;
            } else {
                this.f418286a.put("downHasMore", 0L);
                return;
            }
        }
    }
}
