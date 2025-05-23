package bn;

import java.util.List;
import qzonemoment.QZMomentMeta$StImage;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<QZMomentMeta$StImage> f28660a;

    /* renamed from: b, reason: collision with root package name */
    private QZMomentMeta$StImage f28661b;

    public QZMomentMeta$StImage a() {
        return this.f28661b;
    }

    public void b(List<QZMomentMeta$StImage> list) {
        this.f28660a = list;
        if (list == null) {
            return;
        }
        for (QZMomentMeta$StImage qZMomentMeta$StImage : list) {
            if (qZMomentMeta$StImage.image_type.get() == 2) {
                this.f28661b = qZMomentMeta$StImage;
            }
        }
    }
}
