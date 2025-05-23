package kb1;

import com.tencent.mobileqq.emosm.control.EmoAsyncStep;
import com.tencent.mobileqq.emosm.control.EmoCaptureAsyncAutomator;
import com.tencent.mobileqq.emosm.control.EmoCaptureAsyncStepFactory;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public EmoCaptureAsyncAutomator f411986a = new EmoCaptureAsyncAutomator();

    public void a() {
        this.f411986a.e();
    }

    public void b(String str, Object[] objArr) {
        EmoAsyncStep a16 = EmoCaptureAsyncStepFactory.a(this.f411986a, str);
        a16.E = objArr;
        this.f411986a.j(a16);
    }
}
