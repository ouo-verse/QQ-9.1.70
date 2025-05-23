package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f105677a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f105678b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f105679c;

    static {
        int[] iArr = new int[EnumUserGender.values().length];
        f105677a = iArr;
        EnumUserGender enumUserGender = EnumUserGender.GENDER_FEMALE;
        iArr[enumUserGender.ordinal()] = 1;
        EnumUserGender enumUserGender2 = EnumUserGender.GENDER_MALE;
        iArr[enumUserGender2.ordinal()] = 2;
        int[] iArr2 = new int[EnumUserGender.values().length];
        f105678b = iArr2;
        iArr2[enumUserGender.ordinal()] = 1;
        iArr2[enumUserGender2.ordinal()] = 2;
        int[] iArr3 = new int[EnumUserGender.values().length];
        f105679c = iArr3;
        iArr3[enumUserGender.ordinal()] = 1;
        iArr3[enumUserGender2.ordinal()] = 2;
    }
}
