package com.tencent.biz.pubaccount.weishi.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.LiuHaiUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/ah;", "", "Landroid/content/Context;", "context", "", "f", "e", "", "dipValue", "b", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "c", "Landroid/app/Activity;", "", "a", "d", "g", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ah {

    /* renamed from: a, reason: collision with root package name */
    public static final ah f81701a = new ah();

    ah() {
    }

    @JvmStatic
    public static final boolean a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return ScreenUtil.checkDeviceHasNavigationBar(activity);
    }

    @JvmStatic
    public static final int b(float dipValue) {
        return ScreenUtil.dip2px(dipValue);
    }

    @JvmStatic
    public static final int c(Context activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return ScreenUtil.getNavigationBarHeight(activity);
    }

    @JvmStatic
    public static final int d(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return LiuHaiUtils.getNotchInScreenHeight(activity);
    }

    @JvmStatic
    public static final int e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ScreenUtil.getRealHeight(context);
    }

    @JvmStatic
    public static final int f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ScreenUtil.getRealWidth(context);
    }

    @JvmStatic
    public static final int g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getConfiguration().orientation;
    }
}
