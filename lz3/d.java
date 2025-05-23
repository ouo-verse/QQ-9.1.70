package lz3;

import com.tencent.rdelivery.dependency.AbsLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes25.dex */
public final /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f415850a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f415851b;

    static {
        int[] iArr = new int[AbsLog.Level.values().length];
        f415850a = iArr;
        AbsLog.Level level = AbsLog.Level.VERBOSE;
        iArr[level.ordinal()] = 1;
        AbsLog.Level level2 = AbsLog.Level.DEBUG;
        iArr[level2.ordinal()] = 2;
        AbsLog.Level level3 = AbsLog.Level.INFO;
        iArr[level3.ordinal()] = 3;
        AbsLog.Level level4 = AbsLog.Level.WARN;
        iArr[level4.ordinal()] = 4;
        AbsLog.Level level5 = AbsLog.Level.ERROR;
        iArr[level5.ordinal()] = 5;
        int[] iArr2 = new int[AbsLog.Level.values().length];
        f415851b = iArr2;
        iArr2[level.ordinal()] = 1;
        iArr2[level2.ordinal()] = 2;
        iArr2[level3.ordinal()] = 3;
        iArr2[level4.ordinal()] = 4;
        iArr2[level5.ordinal()] = 5;
    }
}
