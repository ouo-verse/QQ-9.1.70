package gc0;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a extends fc0.a {

    /* renamed from: b, reason: collision with root package name */
    protected final dc0.b f401907b;

    /* renamed from: c, reason: collision with root package name */
    protected long f401908c;

    /* renamed from: d, reason: collision with root package name */
    protected long f401909d;

    /* renamed from: e, reason: collision with root package name */
    protected int f401910e;

    /* renamed from: f, reason: collision with root package name */
    protected int f401911f;

    public a(dc0.b bVar, long j3, int i3, int i16) {
        this.f401907b = bVar;
        this.f401908c = j3;
        this.f401910e = i3;
        this.f401911f = i16;
    }

    @Override // fc0.b
    public String a(QFSEdgeItem qFSEdgeItem) {
        if (qFSEdgeItem != null && qFSEdgeItem.getItemID() != null) {
            return qFSEdgeItem.getItemID();
        }
        return "";
    }

    public boolean i() {
        boolean z16 = false;
        if (this.f401909d == 0 || System.currentTimeMillis() - this.f401909d < this.f401908c) {
            return false;
        }
        List<QFSEdgeItem> d16 = d();
        synchronized (d16) {
            Iterator<QFSEdgeItem> it = d16.iterator();
            while (it.hasNext()) {
                QFSEdgeItem next = it.next();
                if (System.currentTimeMillis() - next.getTimeStamp() > this.f401908c) {
                    it.remove();
                    this.f401907b.d().d(k(), this.f401907b.d().a(), "[filterValidItemList]  | mOldestTime = " + this.f401909d + " | mItemEffectiveTime = " + this.f401908c + " | removeItem.id = " + next.getItemID());
                    z16 = true;
                }
            }
        }
        return z16;
    }

    public List<QFSEdgeItem> j(int i3, long j3) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        List<QFSEdgeItem> d16 = d();
        synchronized (d16) {
            for (QFSEdgeItem qFSEdgeItem : d16) {
                if (j3 < 0 || currentTimeMillis - qFSEdgeItem.getTimeStamp() <= j3) {
                    arrayList.add(qFSEdgeItem);
                }
                if (arrayList.size() == i3) {
                    break;
                }
            }
        }
        return arrayList;
    }

    protected abstract String k();

    public long l() {
        long j3 = 0;
        if (this.f401909d == 0) {
            return -1L;
        }
        long currentTimeMillis = this.f401908c - (System.currentTimeMillis() - this.f401909d);
        if (currentTimeMillis >= 0) {
            j3 = currentTimeMillis;
        }
        this.f401907b.d().d(k(), this.f401907b.d().a(), "[getLoopCheckValidDelayTime]  | intervalTime = " + j3);
        return j3;
    }

    public boolean m() {
        if (d().size() >= this.f401910e) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if (d().size() > this.f401911f) {
            return true;
        }
        return false;
    }

    public void o() {
        List<QFSEdgeItem> d16 = d();
        if (d16.isEmpty()) {
            this.f401909d = 0L;
            return;
        }
        long timeStamp = d16.get(0).getTimeStamp();
        synchronized (d16) {
            for (QFSEdgeItem qFSEdgeItem : d16) {
                if (qFSEdgeItem.getTimeStamp() < timeStamp) {
                    timeStamp = qFSEdgeItem.getTimeStamp();
                }
            }
            this.f401909d = timeStamp;
            this.f401907b.d().d(k(), this.f401907b.d().a(), "[refreshRecordOldestTime]  | mOldestTime = " + this.f401909d);
        }
    }
}
