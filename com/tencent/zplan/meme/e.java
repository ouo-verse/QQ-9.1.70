package com.tencent.zplan.meme;

import com.tencent.zplan.meme.action.MODE;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f385769a;

    static {
        int[] iArr = new int[MODE.values().length];
        f385769a = iArr;
        iArr[MODE.APNG.ordinal()] = 1;
        iArr[MODE.GIF.ordinal()] = 2;
        iArr[MODE.FRAME.ordinal()] = 3;
        iArr[MODE.SHARPP.ordinal()] = 4;
        iArr[MODE.MP4.ordinal()] = 5;
    }
}
