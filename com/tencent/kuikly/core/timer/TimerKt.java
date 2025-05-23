package com.tencent.kuikly.core.timer;

import com.tencent.kuikly.core.global.GlobalFunctions;
import com.tencent.kuikly.core.manager.BridgeManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\u001a \u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u0012\u0010\t\u001a\u00020\u00032\n\u0010\b\u001a\u00060\u0005j\u0002`\u0006\u001a&\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0000\u001a&\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u001e\u0010\u000e\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0000\u001a\u001e\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u001a\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005*\n\u0010\u0012\"\u00020\u00052\u00020\u0005\u00a8\u0006\u0013"}, d2 = {"", "delay", "Lkotlin/Function0;", "", "callback", "", "Lcom/tencent/kuikly/core/timer/CallbackRef;", "c", "callbackRef", "a", "pagerId", "timeout", "f", "e", "g", "d", "timeoutRef", "b", "CallbackRef", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TimerKt {
    public static final void a(String callbackRef) {
        Intrinsics.checkNotNullParameter(callbackRef, "callbackRef");
        b(callbackRef);
    }

    public static final void b(String timeoutRef) {
        Intrinsics.checkNotNullParameter(timeoutRef, "timeoutRef");
        GlobalFunctions.f117252a.c(BridgeManager.f117344a.u(), timeoutRef);
    }

    public static final String c(int i3, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return g(callback, i3);
    }

    public static final String d(int i3, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        GlobalFunctions globalFunctions = GlobalFunctions.f117252a;
        BridgeManager bridgeManager = BridgeManager.f117344a;
        String a16 = globalFunctions.a(bridgeManager.u(), new Function1<Object, Boolean>() { // from class: com.tencent.kuikly.core.timer.TimerKt$setTimeout$callbackRef$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                callback.invoke();
                return Boolean.FALSE;
            }
        });
        bridgeManager.N(bridgeManager.u(), i3, a16);
        return a16;
    }

    public static final String e(String pagerId, int i3, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String a16 = GlobalFunctions.f117252a.a(pagerId, new Function1<Object, Boolean>() { // from class: com.tencent.kuikly.core.timer.TimerKt$setTimeout$callbackRef$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                callback.invoke();
                return Boolean.FALSE;
            }
        });
        BridgeManager.f117344a.N(pagerId, i3, a16);
        return a16;
    }

    public static final String f(String pagerId, final Function0<Unit> callback, int i3) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String a16 = GlobalFunctions.f117252a.a(pagerId, new Function1<Object, Boolean>() { // from class: com.tencent.kuikly.core.timer.TimerKt$setTimeout$callbackRef$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                callback.invoke();
                return Boolean.FALSE;
            }
        });
        BridgeManager.f117344a.N(pagerId, i3, a16);
        return a16;
    }

    public static final String g(final Function0<Unit> callback, int i3) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        GlobalFunctions globalFunctions = GlobalFunctions.f117252a;
        BridgeManager bridgeManager = BridgeManager.f117344a;
        String a16 = globalFunctions.a(bridgeManager.u(), new Function1<Object, Boolean>() { // from class: com.tencent.kuikly.core.timer.TimerKt$setTimeout$callbackRef$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                callback.invoke();
                return Boolean.FALSE;
            }
        });
        bridgeManager.N(bridgeManager.u(), i3, a16);
        return a16;
    }

    public static /* synthetic */ String h(int i3, Function0 function0, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        return d(i3, function0);
    }
}
