package ox2;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.List;
import org.light.utils.CollectionUtils;
import tvideo.TVideoChannelList$VideoChannelData;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<TVideoChannelList$VideoChannelData> f424441a;

    /* renamed from: b, reason: collision with root package name */
    private TVideoChannelList$VideoChannelData f424442b;

    /* renamed from: c, reason: collision with root package name */
    private int f424443c = 1;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(List<TVideoChannelList$VideoChannelData> list);
    }

    /* compiled from: P */
    /* renamed from: ox2.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static class C10967b {

        /* renamed from: a, reason: collision with root package name */
        public static b f424444a = new b();
    }

    b() {
    }

    public static b e() {
        return C10967b.f424444a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(a aVar, List list) {
        if (!CollectionUtils.isEmpty(list)) {
            this.f424441a = list;
        }
        if (aVar != null) {
            aVar.a(list);
        }
    }

    public void b(List<TVideoChannelList$VideoChannelData> list) {
        TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData;
        Iterator<TVideoChannelList$VideoChannelData> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                tVideoChannelList$VideoChannelData = it.next();
                if (tVideoChannelList$VideoChannelData != null && tVideoChannelList$VideoChannelData.channel_id.get() == d()) {
                    break;
                }
            } else {
                tVideoChannelList$VideoChannelData = null;
                break;
            }
        }
        l(tVideoChannelList$VideoChannelData);
    }

    public TVideoChannelList$VideoChannelData c() {
        return this.f424442b;
    }

    public int d() {
        TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData = this.f424442b;
        if (tVideoChannelList$VideoChannelData != null) {
            return tVideoChannelList$VideoChannelData.channel_id.get();
        }
        return 1;
    }

    public int f(int i3) {
        if (!CollectionUtils.isEmpty(this.f424441a)) {
            for (int i16 = 0; i16 < this.f424441a.size(); i16++) {
                TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData = this.f424441a.get(i16);
                if (tVideoChannelList$VideoChannelData != null && i3 == tVideoChannelList$VideoChannelData.channel_id.get()) {
                    return i16;
                }
            }
        }
        return 0;
    }

    public int g() {
        return this.f424443c;
    }

    @Nullable
    public TVideoChannelList$VideoChannelData h(int i3) {
        if (!CollectionUtils.isEmpty(this.f424441a)) {
            for (int i16 = 0; i16 < this.f424441a.size(); i16++) {
                TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData = this.f424441a.get(i16);
                if (tVideoChannelList$VideoChannelData != null && i3 == tVideoChannelList$VideoChannelData.channel_id.get()) {
                    return tVideoChannelList$VideoChannelData;
                }
            }
            return null;
        }
        return null;
    }

    public void j() {
        this.f424442b = null;
        this.f424441a = null;
    }

    public void k(final a aVar) {
        if (CollectionUtils.isEmpty(this.f424441a)) {
            com.tencent.mobileqq.tvideo.viewmodel.b bVar = new com.tencent.mobileqq.tvideo.viewmodel.b();
            bVar.mVideoData.observeForever(new Observer() { // from class: ox2.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    b.this.i(aVar, (List) obj);
                }
            });
            bVar.n2();
        } else if (aVar != null) {
            aVar.a(this.f424441a);
        }
    }

    public void l(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData) {
        this.f424442b = tVideoChannelList$VideoChannelData;
    }
}
