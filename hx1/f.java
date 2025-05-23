package hx1;

import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final CommonBotInfo f406565a;

    /* renamed from: b, reason: collision with root package name */
    public final CommonBotFeatureInfo f406566b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f406567c;

    /* renamed from: d, reason: collision with root package name */
    public final int f406568d;

    public f(CommonBotInfo commonBotInfo, boolean z16) {
        this.f406565a = commonBotInfo;
        this.f406567c = z16;
        this.f406566b = null;
        this.f406568d = 2;
    }

    public String toString() {
        return "UiData{info=" + this.f406565a + ", featureInfo=" + this.f406566b + ", isMuted=" + this.f406567c + ", type=" + this.f406568d + '}';
    }

    public f(CommonBotInfo commonBotInfo, CommonBotFeatureInfo commonBotFeatureInfo, boolean z16, int i3) {
        this.f406565a = commonBotInfo;
        this.f406566b = commonBotFeatureInfo;
        this.f406567c = z16;
        this.f406568d = i3;
    }
}
