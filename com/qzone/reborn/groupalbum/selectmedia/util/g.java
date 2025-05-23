package com.qzone.reborn.groupalbum.selectmedia.util;

import android.content.res.Resources;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/util/g;", "", "", "c", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f56961a = new g();

    g() {
    }

    public final int a() {
        int b16 = b();
        int c16 = c();
        return c16 < b16 ? c16 : b16;
    }

    public final int b() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public final int c() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
