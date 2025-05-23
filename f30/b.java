package f30;

import androidx.annotation.WorkerThread;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StNotice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends e30.a<FeedCloudMeta$StNotice> {

    /* renamed from: d, reason: collision with root package name */
    public static List<a> f397777d;

    /* renamed from: c, reason: collision with root package name */
    private boolean f397778c;

    static {
        ArrayList arrayList = new ArrayList();
        f397777d = arrayList;
        arrayList.add(new a());
    }

    public b(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        super(feedCloudMeta$StNotice);
        this.f397778c = false;
    }

    public static b f() {
        b bVar = new b(null);
        bVar.f397778c = true;
        return bVar;
    }

    public static void h(b bVar, FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        if (bVar != null && feedCloudMeta$StNotice != null) {
            Iterator<a> it = f397777d.iterator();
            while (it.hasNext()) {
                it.next().b(bVar);
            }
        }
    }

    @WorkerThread
    public static ArrayList<b> i(List<FeedCloudMeta$StNotice> list) {
        ArrayList<b> arrayList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            Iterator<FeedCloudMeta$StNotice> it = list.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(new b(it.next()).g());
                } catch (Exception e16) {
                    QLog.d("StNoticeBlockData", 1, "transForm exception:" + e16.getMessage());
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public FeedCloudMeta$StNotice d() {
        return (FeedCloudMeta$StNotice) super.a();
    }

    public boolean e() {
        return this.f397778c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b g() {
        h(this, (FeedCloudMeta$StNotice) this.f395525b);
        return this;
    }
}
