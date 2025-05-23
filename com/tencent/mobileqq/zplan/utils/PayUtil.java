package com.tencent.mobileqq.zplan.utils;

import android.content.Context;
import com.tencent.mobileqq.zootopia.download.DownloadDialogUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ2\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/PayUtil;", "", "Landroid/content/Context;", "context", "", "currentGoldCoin", "diffGoldCoin", "Lkotlin/Function1;", "", "", "callback", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PayUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final PayUtil f335729a = new PayUtil();

    PayUtil() {
    }

    public final void a(Context context, int currentGoldCoin, int diffGoldCoin, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DownloadDialogUtils.f327978a.t(new PayUtil$showPayDialog$1(context, currentGoldCoin, diffGoldCoin, callback));
    }
}
