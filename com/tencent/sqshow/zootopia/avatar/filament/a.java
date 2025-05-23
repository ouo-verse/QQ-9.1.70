package com.tencent.sqshow.zootopia.avatar.filament;

import com.tencent.mobileqq.zplan.utils.am;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/a;", "", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "PORTAL_FIRST_FRAME_DIR", "c", "a", "COUPLE_AVATAR_FIRST_FRAME_DIR", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f369963a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String PORTAL_FIRST_FRAME_DIR;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String COUPLE_AVATAR_FIRST_FRAME_DIR;

    static {
        am amVar = am.f335779a;
        PORTAL_FIRST_FRAME_DIR = amVar.a() + "/portal/FirstFrame";
        COUPLE_AVATAR_FIRST_FRAME_DIR = amVar.a() + "/CoupleAvatar/FirstFrame";
    }

    a() {
    }

    public final String a() {
        return COUPLE_AVATAR_FIRST_FRAME_DIR;
    }

    public final String b() {
        return PORTAL_FIRST_FRAME_DIR;
    }
}
