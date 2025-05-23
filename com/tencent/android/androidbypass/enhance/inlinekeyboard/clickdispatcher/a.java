package com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher;

import com.tencent.android.androidbypass.enhance.inlinekeyboard.model.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003JQ\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00018\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/a;", "DispatchContext", "Payload", "", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/c;", "btnPermissionRequired", "payload", "Lkotlin/Function0;", "", "onPermissionGranted", "onPermissionDenied", "a", "(Ljava/lang/Object;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/c;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface a<DispatchContext, Payload> {
    void a(DispatchContext ctx, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @NotNull c btnPermissionRequired, @Nullable Payload payload, @NotNull Function0<Unit> onPermissionGranted, @Nullable Function0<Unit> onPermissionDenied);
}
