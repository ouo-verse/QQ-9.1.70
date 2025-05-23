package bn;

import java.util.List;
import qzonemoment.QZMomentMeta$StImage;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private b f28668a;

    /* renamed from: b, reason: collision with root package name */
    private int f28669b;

    /* renamed from: c, reason: collision with root package name */
    private List<QZMomentMeta$StImage> f28670c;

    /* renamed from: d, reason: collision with root package name */
    private QZMomentMeta$StImage f28671d;

    /* renamed from: e, reason: collision with root package name */
    private QZMomentMeta$StImage f28672e;

    public QZMomentMeta$StImage a() {
        return this.f28671d;
    }

    public b b() {
        return this.f28668a;
    }

    public int c() {
        return this.f28669b;
    }

    public QZMomentMeta$StImage d() {
        return this.f28672e;
    }

    public void e(b bVar) {
        this.f28668a = bVar;
    }

    public void f(int i3) {
        this.f28669b = i3;
    }

    public void g(List<QZMomentMeta$StImage> list) {
        this.f28670c = list;
        if (list == null) {
            return;
        }
        for (QZMomentMeta$StImage qZMomentMeta$StImage : list) {
            if (qZMomentMeta$StImage.image_type.get() == 1) {
                this.f28672e = qZMomentMeta$StImage;
            } else if (qZMomentMeta$StImage.image_type.get() == 2) {
                this.f28671d = qZMomentMeta$StImage;
            }
        }
    }
}
