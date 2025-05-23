package com.tencent.mobileqq.data.dt;

import android.content.Intent;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\" \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\" \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\" \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lkotlin/Function1;", "Landroid/content/Intent;", "", "a", "Lkotlin/jvm/functions/Function1;", "isNotificationClick", "b", "isThirdPush", "c", "isTianshuPush", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QQDtConfigHelperKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Function1<Intent, Boolean> f203138a = new Function1<Intent, Boolean>() { // from class: com.tencent.mobileqq.data.dt.QQDtConfigHelperKt$isNotificationClick$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Boolean invoke(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return Boolean.valueOf(intent.getBooleanExtra(AppConstants.Key.KEY_NOTIFICATION_CLICK_ACTION, false));
        }
    };

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Function1<Intent, Boolean> f203139b = new Function1<Intent, Boolean>() { // from class: com.tencent.mobileqq.data.dt.QQDtConfigHelperKt$isThirdPush$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Boolean invoke(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return Boolean.valueOf(com.tencent.mobileqq.pushnotice.c.c(intent));
        }
    };

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Function1<Intent, Boolean> f203140c = new Function1<Intent, Boolean>() { // from class: com.tencent.mobileqq.data.dt.QQDtConfigHelperKt$isTianshuPush$1
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Boolean invoke(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return Boolean.valueOf(intent.hasExtra("KEY_PUSH_ID"));
        }
    };
}
