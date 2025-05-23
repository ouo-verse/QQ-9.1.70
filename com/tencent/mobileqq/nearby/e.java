package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f252574a = n.i().getName();

    /* renamed from: b, reason: collision with root package name */
    public static final String f252575b = FaceConstant.Nearby.NEAR_BY_FACE_HANDLER;

    /* renamed from: c, reason: collision with root package name */
    public static final int f252576c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f252577d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f252578e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f252579f;

    /* renamed from: g, reason: collision with root package name */
    public static final int f252580g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f252581h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f252582i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f252583j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f252584k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f252585l;

    static {
        int o16 = n.o();
        f252576c = o16;
        f252577d = o16;
        int i3 = o16 + 1;
        f252578e = i3;
        int i16 = i3 + 1;
        f252579f = i16;
        int i17 = i16 + 1;
        f252580g = i17;
        int i18 = i17 + 1;
        f252581h = i18;
        int i19 = i18 + 1;
        f252582i = i19;
        int i26 = i19 + 1;
        f252583j = i26;
        f252584k = i26 + 1;
        f252585l = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".nearby_hearanim");
    }
}
