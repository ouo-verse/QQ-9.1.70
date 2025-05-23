package com.tencent.filament.zplan.scene.couple.config;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f105945a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f105946b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f105947c;

    static {
        int[] iArr = new int[EnumUserGender.values().length];
        f105945a = iArr;
        EnumUserGender enumUserGender = EnumUserGender.GENDER_MALE;
        iArr[enumUserGender.ordinal()] = 1;
        EnumUserGender enumUserGender2 = EnumUserGender.GENDER_FEMALE;
        iArr[enumUserGender2.ordinal()] = 2;
        int[] iArr2 = new int[EnumUserGender.values().length];
        f105946b = iArr2;
        iArr2[enumUserGender.ordinal()] = 1;
        iArr2[enumUserGender2.ordinal()] = 2;
        int[] iArr3 = new int[CoupleAvatarScene.AvatarTarget.values().length];
        f105947c = iArr3;
        iArr3[CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT.ordinal()] = 1;
        iArr3[CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT.ordinal()] = 2;
    }
}
