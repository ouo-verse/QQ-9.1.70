package com.tencent.ecommerce.biz.orders.buyerorders.searchpage.presentation;

import com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain.ECOrderSearchScene;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f103420a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f103421b;

    static {
        int[] iArr = new int[ECOrderSearchScene.values().length];
        f103420a = iArr;
        ECOrderSearchScene eCOrderSearchScene = ECOrderSearchScene.Q_SHOP;
        iArr[eCOrderSearchScene.ordinal()] = 1;
        ECOrderSearchScene eCOrderSearchScene2 = ECOrderSearchScene.APPLY_SAMPLE;
        iArr[eCOrderSearchScene2.ordinal()] = 2;
        int[] iArr2 = new int[ECOrderSearchScene.values().length];
        f103421b = iArr2;
        iArr2[eCOrderSearchScene.ordinal()] = 1;
        iArr2[eCOrderSearchScene2.ordinal()] = 2;
    }
}
