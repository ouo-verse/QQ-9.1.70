package com.qzone.reborn.util;

import android.app.Activity;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QUIProfileResources;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.qq.e.comm.managers.plugin.PM;
import com.qzone.reborn.feedx.util.ae;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QUIProfileConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/util/b;", "Ld5/r;", "", "g", "", "d", "", "f", "", "e", "Landroid/content/res/Resources;", PM.BASE, "b", "Landroid/view/LayoutInflater;", "a", "c", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Z", "getShouldApplyTheme", "()Z", "shouldApplyTheme", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "quiLayoutInflaters", "quiProfileResources", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "setColorPalette", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "quiTokenThemeMode", "<init>", "(Landroid/app/Activity;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b implements d5.r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean shouldApplyTheme;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final RFWThreadLocal<LayoutInflater> quiLayoutInflaters;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final RFWThreadLocal<Resources> quiProfileResources;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean setColorPalette;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger quiTokenThemeMode;

    public b(Activity activity, boolean z16) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.shouldApplyTheme = z16;
        this.quiLayoutInflaters = new RFWThreadLocal<>();
        this.quiProfileResources = new RFWThreadLocal<>();
        this.setColorPalette = new AtomicBoolean(false);
        this.quiTokenThemeMode = new AtomicInteger(0);
    }

    private final String d() {
        String str;
        int e16 = e();
        if (f()) {
            str = "_" + e16;
        } else {
            str = "";
        }
        return "qzone" + str;
    }

    private final int e() {
        int i3 = this.quiTokenThemeMode.get();
        if (i3 == 0) {
            i3 = com.qzone.reborn.configx.g.f53821a.a().l() ? cd.c.f30656a.h() : 1000;
            this.quiTokenThemeMode.set(i3);
            QLog.i("QZoneQUIProfileTheme", 1, "current qui token theme mode : " + i3);
        }
        return i3;
    }

    private final boolean f() {
        int e16 = e();
        return (e16 == 1001) || (e16 == 1002);
    }

    private final void g() {
        ae0.a aVar;
        if (this.setColorPalette.getAndSet(true)) {
            return;
        }
        boolean z16 = e() == 1002;
        be0.a b16 = be0.a.b(d());
        if (z16) {
            aVar = QUIProfileConstants.DEFAULT_NIGHT_COLOR_PALETTE;
        } else {
            aVar = QUIProfileConstants.DEFAULT_COLOR_PALETTE;
        }
        b16.c(aVar);
    }

    @Override // d5.r
    public LayoutInflater a(LayoutInflater base) {
        Intrinsics.checkNotNullParameter(base, "base");
        LayoutInflater layoutInflater = this.quiLayoutInflaters.get();
        if (layoutInflater != null) {
            return layoutInflater;
        }
        if (!c()) {
            return base;
        }
        QLog.i("QZoneQUIProfileTheme", 1, "use profile layout inflater " + this.activity.getClass().getName());
        QUIProfileLayoutInflater qUIProfileLayoutInflater = new QUIProfileLayoutInflater(base, this.activity, d());
        g();
        this.quiLayoutInflaters.set(qUIProfileLayoutInflater);
        return qUIProfileLayoutInflater;
    }

    @Override // d5.r
    public Resources b(Resources base) {
        Intrinsics.checkNotNullParameter(base, "base");
        Resources resources = this.quiProfileResources.get();
        if (resources != null) {
            return resources;
        }
        if (!c()) {
            return base;
        }
        QLog.i("QZoneQUIProfileTheme", 1, "use profile resources " + this.activity.getClass().getName());
        QUIProfileResources qUIProfileResources = new QUIProfileResources(base, this.activity, d());
        g();
        this.quiProfileResources.set(qUIProfileResources);
        return qUIProfileResources;
    }

    public boolean c() {
        if (ae.a() && this.shouldApplyTheme) {
            return true;
        }
        return f();
    }
}
