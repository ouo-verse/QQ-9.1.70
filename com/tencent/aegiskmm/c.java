package com.tencent.aegiskmm;

import com.tencent.aegiskmm.bean.AegisLogType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final /* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f61787a;

    static {
        int[] iArr = new int[AegisLogType.values().length];
        f61787a = iArr;
        iArr[AegisLogType.NORMAL.ordinal()] = 1;
        iArr[AegisLogType.PV.ordinal()] = 2;
        iArr[AegisLogType.API.ordinal()] = 3;
        iArr[AegisLogType.NATIVE_LOAD_EVENT.ordinal()] = 4;
        iArr[AegisLogType.CUSTOM_TIME.ordinal()] = 5;
        iArr[AegisLogType.CUSTOM_EVENT.ordinal()] = 6;
        iArr[AegisLogType.PAGE_PERFORMANCE.ordinal()] = 7;
        iArr[AegisLogType.API_SPEED.ordinal()] = 8;
        iArr[AegisLogType.ASSETS_SPEED.ordinal()] = 9;
        iArr[AegisLogType.WEB_VITALS.ordinal()] = 10;
    }
}
