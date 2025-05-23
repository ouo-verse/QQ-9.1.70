package com.qzone.reborn.albumx.qzonex.utils;

import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/d;", "", "", "a", "", "b", "Ljava/lang/Boolean;", "isOpenAlbumxTab", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f53403a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Boolean isOpenAlbumxTab;

    d() {
    }

    @JvmStatic
    public static final boolean a() {
        boolean c16 = gd.a.f401926a.c("KEY_OPEN_NEW_QZONE_ALBUMX_ENTRANCE", true);
        if (AppSetting.s()) {
            QLog.e("QZALbumxConfigManager", 1, "isOpenQZAlbumx  is open debugSwitch");
            return c16;
        }
        com.qzone.reborn.configx.g gVar = com.qzone.reborn.configx.g.f53821a;
        if (gVar.e().l()) {
            QLog.e("QZALbumxConfigManager", 1, "isOpenQZAlbumx  is close cangLanSwitch");
            return false;
        }
        Boolean bool = isOpenAlbumxTab;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (!com.qzone.reborn.util.e.b("QZALbumxConfigManager_isOpenQZAlbumx", 200L)) {
                QLog.d("QZALbumxConfigManager", 1, "isOpenQZAlbumx  tab has value , isOpenAlbumxTab=" + isOpenAlbumxTab);
            }
            return booleanValue;
        }
        boolean d16 = com.qzone.reborn.a.f52169a.d("exp_album_reconstruction_9125_andr", "_B");
        boolean m3 = gVar.e().m();
        isOpenAlbumxTab = Boolean.valueOf(d16 || m3);
        QLog.e("QZALbumxConfigManager", 1, "isOpenQZAlbumx  init tab value , isOpenAlbumxTab=" + d16 + ", isOpenAlbumxSmallGrayCanglanSwitch:" + m3);
        Boolean bool2 = isOpenAlbumxTab;
        Intrinsics.checkNotNull(bool2, "null cannot be cast to non-null type kotlin.Boolean");
        return bool2.booleanValue();
    }

    @JvmStatic
    public static final void b() {
        isOpenAlbumxTab = null;
        if (com.qzone.reborn.configx.g.f53821a.b().i0()) {
            lc.i.f414345a.x();
        }
        QLog.d("QZALbumxConfigManager", 1, "resetData  isOpenAlbumxTab = null");
    }
}
