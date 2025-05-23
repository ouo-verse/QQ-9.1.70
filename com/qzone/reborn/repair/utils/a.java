package com.qzone.reborn.repair.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQZoneMMKVApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/repair/utils/a;", "", "", "a", "", "e", "c", "g", "b", "f", "d", tl.h.F, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f59293a = new a();

    a() {
    }

    public final boolean a() {
        return ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue("qzone_album_photo_repair_entrance_is_first_show", true);
    }

    public final boolean b() {
        return ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue("qzone_album_photo_repair_entrance_is_first_click", true);
    }

    public final boolean c() {
        return ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue("qzone_layer_photo_repair_entrance_anim_is_first_show", true);
    }

    public final boolean d() {
        return ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue("qzone_layer_photo_repair_entrance_is_first_show", true);
    }

    public final void e() {
        ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("qzone_album_photo_repair_entrance_is_first_show", false);
    }

    public final void f() {
        ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("qzone_album_photo_repair_entrance_is_first_click", false);
    }

    public final void g() {
        ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("qzone_layer_photo_repair_entrance_anim_is_first_show", false);
    }

    public final void h() {
        ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("qzone_layer_photo_repair_entrance_is_first_show", false);
    }
}
