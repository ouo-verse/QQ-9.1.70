package com.tencent.zplan.record.provider.helper;

import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.model.BusinessConfig;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f386159a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f386160b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f386161c;

    static {
        int[] iArr = new int[MODE.values().length];
        f386159a = iArr;
        iArr[MODE.APNG.ordinal()] = 1;
        iArr[MODE.GIF.ordinal()] = 2;
        iArr[MODE.FRAME.ordinal()] = 3;
        iArr[MODE.SHARPP.ordinal()] = 4;
        iArr[MODE.MP4.ordinal()] = 5;
        int[] iArr2 = new int[AppTheme.values().length];
        f386160b = iArr2;
        iArr2[AppTheme.DAY.ordinal()] = 1;
        iArr2[AppTheme.NIGHT.ordinal()] = 2;
        int[] iArr3 = new int[BusinessConfig.FrameType.values().length];
        f386161c = iArr3;
        iArr3[BusinessConfig.FrameType.JPG.ordinal()] = 1;
        iArr3[BusinessConfig.FrameType.PNG.ordinal()] = 2;
    }
}
