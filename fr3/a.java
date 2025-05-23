package fr3;

import com.tencent.qmethod.monitor.config.GeneralRule;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f400358a;

    static {
        int[] iArr = new int[GeneralRule.values().length];
        f400358a = iArr;
        iArr[GeneralRule.BACK_BAN_AND_FRONT_BAN.ordinal()] = 1;
        iArr[GeneralRule.BACK_BAN_AND_FRONT_NORMAL.ordinal()] = 2;
        iArr[GeneralRule.BACK_CACHE_ONLY_AND_FRONT_NORMAL.ordinal()] = 3;
        iArr[GeneralRule.BACK_CACHE_ONLY_AND_FRONT_CACHE_ONLY.ordinal()] = 4;
        iArr[GeneralRule.BACK_NORMAL_AND_FRONT_NORMAL.ordinal()] = 5;
    }
}
