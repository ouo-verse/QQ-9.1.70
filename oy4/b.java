package oy4;

import com.tencent.component.utils.LogUtil;
import com.tme.karaoke.lib_earback.e;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b implements e {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f424521c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f424522d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f424523a = false;

    /* renamed from: b, reason: collision with root package name */
    private a f424524b;

    b() {
    }

    public static b a() {
        if (f424522d == null) {
            synchronized (b.class) {
                if (f424522d == null) {
                    f424522d = new b();
                }
            }
        }
        return f424522d;
    }

    public boolean b() {
        a aVar = this.f424524b;
        if (aVar != null) {
            return aVar.isEarbackWorking();
        }
        return false;
    }

    public void c(a aVar) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setKaraRecorder -> recorder:");
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        LogUtil.i("NativeFeedback", sb5.toString());
        this.f424524b = aVar;
    }

    @Override // com.tme.karaoke.lib_earback.e
    public boolean turnFeedback(boolean z16) {
        LogUtil.i("NativeFeedback", "turnFeedback: " + z16);
        a aVar = this.f424524b;
        if (aVar != null) {
            aVar.turnFeedback(z16);
            return b();
        }
        LogUtil.w("NativeFeedback", "mRecorder is null");
        return false;
    }
}
