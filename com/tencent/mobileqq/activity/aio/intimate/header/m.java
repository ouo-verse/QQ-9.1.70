package com.tencent.mobileqq.activity.aio.intimate.header;

import com.tencent.image.URLDrawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/m;", "", "", "type", "level", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f179063a = new m();

    m() {
    }

    public final void a(int type, int level) {
        URLDrawable.getDrawable(IntimateHeaderCardUtil.d(type, level), URLDrawable.URLDrawableOptions.obtain()).startDownload();
        if (IntimateHeaderCardUtil.M(type)) {
            URLDrawable.getDrawable(IntimateHeaderCardUtil.g(type), URLDrawable.URLDrawableOptions.obtain()).startDownload();
            URLDrawable.getDrawable(IntimateHeaderCardUtil.e(type, level), URLDrawable.URLDrawableOptions.obtain()).startDownload();
        }
        URLDrawable.getDrawable(IntimateHeaderCardUtil.c(type, level), URLDrawable.URLDrawableOptions.obtain()).startDownload();
        URLDrawable.getDrawable(IntimateHeaderCardUtil.b(type), URLDrawable.URLDrawableOptions.obtain()).startDownload();
        URLDrawable.getDrawable(IntimateHeaderCardUtil.y(type), URLDrawable.URLDrawableOptions.obtain()).startDownload();
        URLDrawable.getDrawable(IntimateHeaderCardUtil.z(type), URLDrawable.URLDrawableOptions.obtain()).startDownload();
        URLDrawable.getDrawable(IntimateHeaderCardUtil.H(type, level), URLDrawable.URLDrawableOptions.obtain()).startDownload();
    }
}
