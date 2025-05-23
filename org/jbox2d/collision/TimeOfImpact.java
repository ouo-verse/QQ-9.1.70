package org.jbox2d.collision;

import org.jbox2d.collision.Distance;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Transform;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TimeOfImpact {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_ITERATIONS = 1000;
    public static int toiCalls;
    public static int toiIters;
    public static int toiMaxIters;
    public static int toiMaxRootIters;
    public static int toiRootIters;
    private final IWorldPool pool;
    private final Distance.SimplexCache cache = new Distance.SimplexCache();
    private final DistanceInput distanceInput = new DistanceInput();
    private final Transform xfA = new Transform();
    private final Transform xfB = new Transform();
    private final DistanceOutput distanceOutput = new DistanceOutput();
    private final SeparationFunction fcn = new SeparationFunction();
    private final int[] indexes = new int[2];
    private final Sweep sweepA = new Sweep();
    private final Sweep sweepB = new Sweep();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TOIInput {
        public final Distance.DistanceProxy proxyA = new Distance.DistanceProxy();
        public final Distance.DistanceProxy proxyB = new Distance.DistanceProxy();
        public final Sweep sweepA = new Sweep();
        public final Sweep sweepB = new Sweep();
        public float tMax;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TOIOutput {
        public TOIOutputState state;

        /* renamed from: t, reason: collision with root package name */
        public float f423630t;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum TOIOutputState {
        UNKNOWN,
        FAILED,
        OVERLAPPED,
        TOUCHING,
        SEPARATED
    }

    public TimeOfImpact(IWorldPool iWorldPool) {
        this.pool = iWorldPool;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d5, code lost:
    
        r20 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f1, code lost:
    
        r11 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009c, code lost:
    
        r0 = r16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void timeOfImpact(TOIOutput tOIOutput, TOIInput tOIInput) {
        int i3;
        int i16;
        int i17;
        float f16;
        TimeOfImpact timeOfImpact = this;
        int i18 = 1;
        toiCalls++;
        tOIOutput.state = TOIOutputState.UNKNOWN;
        tOIOutput.f423630t = tOIInput.tMax;
        Distance.DistanceProxy distanceProxy = tOIInput.proxyA;
        Distance.DistanceProxy distanceProxy2 = tOIInput.proxyB;
        timeOfImpact.sweepA.set(tOIInput.sweepA);
        timeOfImpact.sweepB.set(tOIInput.sweepB);
        timeOfImpact.sweepA.normalize();
        timeOfImpact.sweepB.normalize();
        float f17 = tOIInput.tMax;
        float max = MathUtils.max(0.005f, (distanceProxy.m_radius + distanceProxy2.m_radius) - 0.015f);
        int i19 = 0;
        timeOfImpact.cache.count = 0;
        DistanceInput distanceInput = timeOfImpact.distanceInput;
        distanceInput.proxyA = tOIInput.proxyA;
        distanceInput.proxyB = tOIInput.proxyB;
        distanceInput.useRadii = false;
        float f18 = 0.0f;
        float f19 = 0.0f;
        int i26 = 0;
        while (true) {
            timeOfImpact.sweepA.getTransform(timeOfImpact.xfA, f19);
            timeOfImpact.sweepB.getTransform(timeOfImpact.xfB, f19);
            DistanceInput distanceInput2 = timeOfImpact.distanceInput;
            distanceInput2.transformA = timeOfImpact.xfA;
            distanceInput2.transformB = timeOfImpact.xfB;
            timeOfImpact.pool.getDistance().distance(timeOfImpact.distanceOutput, timeOfImpact.cache, timeOfImpact.distanceInput);
            float f26 = timeOfImpact.distanceOutput.distance;
            if (f26 <= f18) {
                tOIOutput.state = TOIOutputState.OVERLAPPED;
                tOIOutput.f423630t = f18;
                break;
            }
            float f27 = max + 0.00125f;
            if (f26 < f27) {
                tOIOutput.state = TOIOutputState.TOUCHING;
                tOIOutput.f423630t = f19;
                break;
            }
            float f28 = f19;
            timeOfImpact.fcn.initialize(timeOfImpact.cache, distanceProxy, timeOfImpact.sweepA, distanceProxy2, timeOfImpact.sweepB, f19);
            f19 = f17;
            int i27 = i19;
            while (true) {
                float findMinSeparation = timeOfImpact.fcn.findMinSeparation(timeOfImpact.indexes, f19);
                if (findMinSeparation > f27) {
                    tOIOutput.state = TOIOutputState.SEPARATED;
                    tOIOutput.f423630t = f17;
                    f19 = f28;
                    break;
                }
                float f29 = max - 0.00125f;
                if (findMinSeparation > f29) {
                    i16 = i18;
                    i17 = i19;
                    break;
                }
                SeparationFunction separationFunction = timeOfImpact.fcn;
                int[] iArr = timeOfImpact.indexes;
                float f36 = f28;
                float evaluate = separationFunction.evaluate(iArr[i19], iArr[i18], f36);
                if (evaluate < f29) {
                    tOIOutput.state = TOIOutputState.FAILED;
                    tOIOutput.f423630t = f36;
                    break;
                }
                if (evaluate <= f27) {
                    tOIOutput.state = TOIOutputState.TOUCHING;
                    tOIOutput.f423630t = f36;
                    break;
                }
                float f37 = f36;
                float f38 = f19;
                int i28 = i19;
                while (true) {
                    if ((i28 & 1) == i18) {
                        f16 = (((max - evaluate) * (f38 - f37)) / (findMinSeparation - evaluate)) + f37;
                    } else {
                        f16 = 0.5f * (f37 + f38);
                    }
                    SeparationFunction separationFunction2 = timeOfImpact.fcn;
                    f28 = f36;
                    int[] iArr2 = timeOfImpact.indexes;
                    i17 = 0;
                    float evaluate2 = separationFunction2.evaluate(iArr2[0], iArr2[1], f16);
                    if (MathUtils.abs(evaluate2 - max) < 0.00125f) {
                        f19 = f16;
                        i16 = 1;
                        break;
                    }
                    if (evaluate2 > max) {
                        evaluate = evaluate2;
                        f37 = f16;
                    } else {
                        findMinSeparation = evaluate2;
                        f38 = f16;
                    }
                    i28++;
                    i16 = 1;
                    toiRootIters++;
                    if (i28 == 50) {
                        break;
                    }
                    timeOfImpact = this;
                    i18 = 1;
                    f36 = f28;
                }
                toiMaxRootIters = MathUtils.max(toiMaxRootIters, i28);
                i27 += i16;
                if (i27 == 8) {
                    f19 = f28;
                    break;
                } else {
                    timeOfImpact = this;
                    i18 = i16;
                    i19 = 0;
                }
            }
            i16 = i18;
            int i29 = i16;
            i17 = i19;
            i3 = i26 + 1;
            toiIters += i16;
            if (i29 != 0) {
                break;
            }
            if (i3 == 1000) {
                tOIOutput.state = TOIOutputState.FAILED;
                tOIOutput.f423630t = f19;
                break;
            } else {
                i26 = i3;
                i18 = i16;
                i19 = i17;
                f18 = 0.0f;
                timeOfImpact = this;
            }
        }
        toiMaxIters = MathUtils.max(toiMaxIters, i3);
    }
}
