package com.tencent.filament.zplan.render.impl;

import com.tencent.filament.zplan.business.api.SceneType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f105910a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f105911b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f105912c;

    static {
        int[] iArr = new int[SceneType.values().length];
        f105910a = iArr;
        iArr[SceneType.NONE.ordinal()] = 1;
        SceneType sceneType = SceneType.PORTAL;
        iArr[sceneType.ordinal()] = 2;
        iArr[SceneType.DRAWER.ordinal()] = 3;
        iArr[SceneType.DYNAMIC.ordinal()] = 4;
        iArr[SceneType.ProfileCard.ordinal()] = 5;
        iArr[SceneType.AIGC_PREVIEW.ordinal()] = 6;
        iArr[SceneType.FRIEND_PROFILE_CARD.ordinal()] = 7;
        iArr[SceneType.FRIENDS_DRESSUP.ordinal()] = 8;
        iArr[SceneType.MY_NEAR_BY.ordinal()] = 9;
        iArr[SceneType.GUEST_NEAR_BY.ordinal()] = 10;
        int[] iArr2 = new int[SceneType.values().length];
        f105911b = iArr2;
        iArr2[sceneType.ordinal()] = 1;
        int[] iArr3 = new int[SceneType.values().length];
        f105912c = iArr3;
        iArr3[sceneType.ordinal()] = 1;
    }
}
