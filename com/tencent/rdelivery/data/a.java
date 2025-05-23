package com.tencent.rdelivery.data;

import com.tencent.rdelivery.data.DataManager;
import com.tencent.rdelivery.net.BaseProto$PullType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes25.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f364216a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f364217b;

    static {
        int[] iArr = new int[BaseProto$PullType.values().length];
        f364216a = iArr;
        iArr[BaseProto$PullType.ALL.ordinal()] = 1;
        iArr[BaseProto$PullType.CONFIG.ordinal()] = 2;
        iArr[BaseProto$PullType.GROUP.ordinal()] = 3;
        iArr[BaseProto$PullType.DEPRECATED.ordinal()] = 4;
        iArr[BaseProto$PullType.UNKNOWN.ordinal()] = 5;
        int[] iArr2 = new int[DataManager.CfgChangeType.values().length];
        f364217b = iArr2;
        iArr2[DataManager.CfgChangeType.UPDATE.ordinal()] = 1;
        iArr2[DataManager.CfgChangeType.DELETE.ordinal()] = 2;
    }
}
