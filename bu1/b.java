package bu1;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public long f29153a;

    /* renamed from: b, reason: collision with root package name */
    public a f29154b;

    /* renamed from: c, reason: collision with root package name */
    public MessageRecord f29155c;

    /* renamed from: d, reason: collision with root package name */
    public int f29156d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Long> f29157e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<Long> f29158f;

    public b() {
        this.f29153a = 0L;
        this.f29154b = new a();
        this.f29155c = null;
        this.f29156d = 0;
        this.f29157e = new ArrayList<>();
        this.f29158f = new ArrayList<>();
    }

    public long a() {
        a aVar = this.f29154b;
        if (aVar != null) {
            return aVar.e();
        }
        return 0L;
    }

    public long b() {
        a aVar = this.f29154b;
        if (aVar != null) {
            return aVar.f29143b;
        }
        return 0L;
    }

    public boolean c() {
        a aVar = this.f29154b;
        if (aVar != null) {
            return aVar.h();
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b) || this.f29153a != ((b) obj).f29153a) {
            return false;
        }
        return true;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("msgSeq:");
        sb5.append(this.f29153a);
        sb5.append(" ");
        sb5.append("guildMsgEventInfo:");
        a aVar = this.f29154b;
        String str3 = "null";
        if (aVar == null) {
            str = "null";
        } else {
            str = aVar.toString();
        }
        sb5.append(str);
        sb5.append(" ");
        sb5.append("updateStatus:");
        sb5.append(this.f29156d);
        sb5.append(" ");
        sb5.append("replySeqList:");
        ArrayList<Long> arrayList = this.f29157e;
        if (arrayList == null) {
            str2 = "null";
        } else {
            str2 = arrayList.toString();
        }
        sb5.append(str2);
        sb5.append(" ");
        sb5.append("rootSeqList:");
        ArrayList<Long> arrayList2 = this.f29158f;
        if (arrayList2 != null) {
            str3 = arrayList2.toString();
        }
        sb5.append(str3);
        sb5.append(" ");
        return sb5.toString();
    }

    public b(long j3) {
        this.f29153a = 0L;
        this.f29154b = new a();
        this.f29155c = null;
        this.f29156d = 0;
        this.f29157e = new ArrayList<>();
        this.f29158f = new ArrayList<>();
        this.f29153a = j3;
    }
}
