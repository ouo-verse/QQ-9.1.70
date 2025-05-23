package com.tencent.richframework.gallery;

import android.app.Activity;
import android.content.Intent;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QUIProfileResources;
import android.content.res.Resources;
import android.view.LayoutInflater;
import be0.a;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QUIProfileConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tR\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/richframework/gallery/QQGalleryQUIProfileTheme;", "", "", "setCustomColorPalette", "", "needUseProfileResources", "Landroid/content/res/Resources;", PM.BASE, "getResources", "Landroid/view/LayoutInflater;", "getLayoutInflater", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "quiLayoutInflaters", "Lcom/tencent/biz/richframework/collection/RFWThreadLocal;", "quiProfileResources", "Ljava/util/concurrent/atomic/AtomicBoolean;", "setColorPalette", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "(Landroid/app/Activity;)V", "Companion", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QQGalleryQUIProfileTheme {

    @NotNull
    private final Activity activity;

    @NotNull
    private final RFWThreadLocal<LayoutInflater> quiLayoutInflaters;

    @NotNull
    private final RFWThreadLocal<Resources> quiProfileResources;

    @NotNull
    private final AtomicBoolean setColorPalette;

    public QQGalleryQUIProfileTheme(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.quiLayoutInflaters = new RFWThreadLocal<>();
        this.quiProfileResources = new RFWThreadLocal<>();
        this.setColorPalette = new AtomicBoolean(false);
    }

    private final boolean needUseProfileResources() {
        Intent intent = this.activity.getIntent();
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra("enableQUIProfile", false);
    }

    private final void setCustomColorPalette() {
        if (this.setColorPalette.getAndSet(true)) {
            return;
        }
        a.b("qq_gallery").c(QUIProfileConstants.DEFAULT_COLOR_PALETTE);
    }

    @NotNull
    public final LayoutInflater getLayoutInflater(@NotNull LayoutInflater base) {
        Intrinsics.checkNotNullParameter(base, "base");
        LayoutInflater layoutInflater = this.quiLayoutInflaters.get();
        if (layoutInflater != null) {
            return layoutInflater;
        }
        if (needUseProfileResources()) {
            QLog.i("QQGalleryQUIProfileTheme", 1, "use profile layout inflater " + this.activity.getClass().getName());
            QUIProfileLayoutInflater qUIProfileLayoutInflater = new QUIProfileLayoutInflater(base, this.activity, "qq_gallery");
            setCustomColorPalette();
            this.quiLayoutInflaters.set(qUIProfileLayoutInflater);
            return qUIProfileLayoutInflater;
        }
        return base;
    }

    @NotNull
    public final Resources getResources(@NotNull Resources base) {
        Intrinsics.checkNotNullParameter(base, "base");
        Resources resources = this.quiProfileResources.get();
        if (resources != null) {
            return resources;
        }
        if (needUseProfileResources()) {
            QLog.i("QQGalleryQUIProfileTheme", 1, "use profile resources " + this.activity.getClass().getName());
            QUIProfileResources qUIProfileResources = new QUIProfileResources(base, this.activity, "qq_gallery");
            setCustomColorPalette();
            this.quiProfileResources.set(qUIProfileResources);
            return qUIProfileResources;
        }
        return base;
    }
}
