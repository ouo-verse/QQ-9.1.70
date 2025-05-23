package b14;

import com.tencent.bugly.common.heapdump.ForkJvmHeapDumper;
import com.tencent.bugly.common.heapdump.IHeapDumper;
import com.tencent.bugly.common.heapdump.StandardHeapDumper;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final IHeapDumper[] f27744a = {new ForkJvmHeapDumper(), new StandardHeapDumper()};

    public static IHeapDumper a() {
        for (IHeapDumper iHeapDumper : f27744a) {
            if (iHeapDumper.isValid()) {
                return iHeapDumper;
            }
        }
        return new StandardHeapDumper();
    }
}
