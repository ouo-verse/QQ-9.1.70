package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils;

import android.util.DisplayMetrics;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/utils/ViewUtils;", "", "", "dpValue", "b", "", "c", "a", "Landroid/util/DisplayMetrics;", "Lkotlin/Lazy;", "d", "()Landroid/util/DisplayMetrics;", "displayMetrics", "I", "densityDpi", UserInfo.SEX_FEMALE, "density", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ViewUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ViewUtils f244350a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy displayMetrics;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int densityDpi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final float density;

    static {
        Lazy lazy;
        ViewUtils viewUtils = new ViewUtils();
        f244350a = viewUtils;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DisplayMetrics>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.ViewUtils$displayMetrics$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DisplayMetrics invoke() {
                return BaseApplication.getContext().getResources().getDisplayMetrics();
            }
        });
        displayMetrics = lazy;
        densityDpi = viewUtils.d().densityDpi;
        density = viewUtils.d().density;
    }

    ViewUtils() {
    }

    private final DisplayMetrics d() {
        Object value = displayMetrics.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-displayMetrics>(...)");
        return (DisplayMetrics) value;
    }

    public final int a(float dpValue) {
        return (int) ((dpValue * density) + 0.5f);
    }

    public final float c(float dpValue) {
        return (dpValue * density) + 0.5f;
    }

    public final int b(int dpValue) {
        return a(dpValue);
    }
}
