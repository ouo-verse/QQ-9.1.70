package oz;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private b f424550a;

    /* renamed from: b, reason: collision with root package name */
    private d f424551b = new d();

    /* renamed from: c, reason: collision with root package name */
    private c f424552c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f424553d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f424554e;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements jz.c<c> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ jz.a f424555d;

        a(jz.a aVar) {
            this.f424555d = aVar;
        }

        @Override // jz.c
        public void d0(List<c> list, boolean z16, boolean z17, Object obj) {
            if (obj instanceof Boolean) {
                g.this.f424554e = ((Boolean) obj).booleanValue();
            }
            if (g.this.f424550a != null) {
                b bVar = g.this.f424550a;
                if (!this.f424555d.a()) {
                    list = g.this.k(list);
                }
                bVar.g(list, this.f424555d.a(), g.this.f424554e);
            }
            if (!this.f424555d.a() || g.this.f424552c == null) {
                return;
            }
            if (g.this.f424553d) {
                g gVar = g.this;
                gVar.m(gVar.f424552c.f424527a);
            } else {
                g gVar2 = g.this;
                gVar2.n(gVar2.f424552c.f424527a);
            }
        }

        @Override // jz.c
        public void i(int i3, String str, boolean z16, boolean z17) {
            if (g.this.f424550a != null) {
                g.this.f424550a.i(this.f424555d.a(), i3, str);
            }
        }
    }

    public g(b bVar) {
        this.f424550a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<c> k(List<c> list) {
        b bVar = this.f424550a;
        if (bVar != null && bVar.f() != null) {
            ArrayList arrayList = new ArrayList();
            c cVar = this.f424550a.f().size() > 0 ? this.f424550a.f().get(0) : null;
            c cVar2 = this.f424550a.f().size() > 1 ? this.f424550a.f().get(1) : null;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (cVar != null && TextUtils.equals(cVar.a(), list.get(i3).a())) {
                    arrayList.add(list.get(i3));
                }
                if (cVar2 != null && TextUtils.equals(cVar2.a(), list.get(i3).a())) {
                    arrayList.add(list.get(i3));
                }
            }
            list.removeAll(arrayList);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(stDrama stdrama) {
        b bVar = this.f424550a;
        if (bVar == null || bVar.f() == null || stdrama == null || stdrama.dramaInfo == null) {
            return;
        }
        c cVar = new c(stdrama);
        List<c> arrayList = new ArrayList<>(this.f424550a.f());
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            c cVar2 = arrayList.get(i3);
            if (TextUtils.equals(cVar.a(), cVar2.a())) {
                arrayList2.add(cVar2);
                if (cVar2.f424527a.dramaInfo.curWatchedFeedNum > cVar.f424527a.dramaInfo.curWatchedFeedNum) {
                    cVar = cVar2;
                }
            }
        }
        arrayList.removeAll(arrayList2);
        cVar.g(true);
        arrayList.add(0, cVar);
        this.f424550a.l(arrayList, this.f424554e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(stDrama stdrama) {
        c cVar = new c(stdrama);
        ArrayList arrayList = new ArrayList(this.f424550a.f());
        int i3 = 0;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            c cVar2 = (c) arrayList.get(i16);
            if (TextUtils.equals(cVar.a(), cVar2.a())) {
                if (cVar2.f424527a.dramaInfo.curWatchedFeedNum <= cVar.f424527a.dramaInfo.curWatchedFeedNum) {
                    i3 = i16;
                } else {
                    i3 = i16;
                    cVar = cVar2;
                }
            }
        }
        if (arrayList.size() > 0) {
            if (i3 == 0) {
                cVar.g(true);
                arrayList.set(0, cVar);
            } else {
                cVar.g(false);
                arrayList.remove(i3);
                arrayList.add(1, cVar);
            }
        }
        this.f424550a.l(arrayList, this.f424554e);
    }

    public stDrama i(stDrama stdrama) {
        stDrama stdrama2 = new stDrama();
        stDramaInfo stdramainfo = new stDramaInfo();
        stDramaInfo stdramainfo2 = stdrama.dramaInfo;
        stdramainfo.f25116id = stdramainfo2.f25116id;
        stdramainfo.name = stdramainfo2.name;
        stdramainfo.recmdDesc = stdramainfo2.recmdDesc;
        stdramainfo.coverImg = stdramainfo2.coverImg;
        stdramainfo.tag = stdramainfo2.tag;
        stdramainfo.isPublishCompleted = stdramainfo2.isPublishCompleted;
        stdramainfo.isFollowed = stdramainfo2.isFollowed;
        stdramainfo.playCount = stdramainfo2.playCount;
        stdramainfo.curPublishedFeedNum = stdramainfo2.curPublishedFeedNum;
        stdramainfo.curWatchedFeedNum = stdramainfo2.curWatchedFeedNum;
        stdramainfo.curWatchedFeedID = stdramainfo2.curWatchedFeedID;
        stdrama2.dramaInfo = stdramainfo;
        stdrama2.tagIcon = stdrama.tagIcon;
        return stdrama2;
    }

    public void j(jz.a aVar) {
        this.f424551b.a(aVar, new a(aVar));
    }

    public void l(stDrama stdrama, boolean z16) {
        c cVar = new c(stdrama);
        this.f424552c = cVar;
        cVar.g(z16);
        this.f424553d = z16;
        if (z16) {
            m(stdrama);
        } else {
            n(stdrama);
        }
    }
}
