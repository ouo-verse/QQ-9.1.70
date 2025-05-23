package ay0;

import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a extends TRTCCloudListener {

    /* renamed from: a, reason: collision with root package name */
    static ArrayList<WeakReference<TRTCCloudListener>> f27206a = new ArrayList<>();

    /* compiled from: P */
    /* renamed from: ay0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0076a {
        void a(TRTCCloudListener tRTCCloudListener);
    }

    public void L(InterfaceC0076a interfaceC0076a) {
        for (int size = f27206a.size() - 1; size >= 0; size--) {
            TRTCCloudListener tRTCCloudListener = f27206a.get(size).get();
            if (tRTCCloudListener != null) {
                interfaceC0076a.a(tRTCCloudListener);
            } else {
                f27206a.remove(size);
            }
        }
    }

    public void M(TRTCCloudListener tRTCCloudListener) {
        f27206a.add(new WeakReference<>(tRTCCloudListener));
    }
}
