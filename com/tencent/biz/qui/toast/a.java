package com.tencent.biz.qui.toast;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qui/toast/a;", "", "Lkotlin/Function0;", "", "dismissCallback", "a", "Landroid/app/Activity;", "getActivity", "QUIToast_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface a {
    void a(@NotNull Function0<Unit> dismissCallback);

    @Nullable
    Activity getActivity();
}
