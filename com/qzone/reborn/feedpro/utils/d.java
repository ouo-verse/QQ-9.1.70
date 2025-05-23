package com.qzone.reborn.feedpro.utils;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/d;", "", "", "b", "a", "Z", "hasFeedProAnyAccount", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f54318a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean hasFeedProAnyAccount;

    d() {
    }

    public final boolean a() {
        return hasFeedProAnyAccount;
    }

    public final boolean b() {
        if (com.qzone.reborn.util.k.f59549a.c() || pl.a.f426446a.y()) {
            return false;
        }
        if (com.qzone.reborn.configx.g.f53821a.c().j()) {
            QLog.e("QzoneFeedProABManager", 1, "isFeedPro  is close cangLanSwitch");
            return false;
        }
        boolean e16 = com.qzone.reborn.a.e(com.qzone.reborn.a.f52169a, "exp_qzone_new_frame", null, 2, null);
        if (e16) {
            hasFeedProAnyAccount = true;
        }
        return e16;
    }
}
