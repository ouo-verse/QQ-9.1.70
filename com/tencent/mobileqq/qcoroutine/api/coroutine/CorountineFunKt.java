package com.tencent.mobileqq.qcoroutine.api.coroutine;

import android.os.Looper;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.DispatcherThread;
import com.tencent.mobileqq.qcoroutine.framework.coroutine.QCoroutineExecute;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001ak\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001ak\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012\"\u0004\b\u0000\u0010\u0011*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a]\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001ab\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "name", "", "isMain", "Lkotlinx/coroutines/CoroutineStart;", "start", "needReturn", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "d", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;)Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "T", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/a;", "b", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lcom/tencent/mobileqq/qcoroutine/api/coroutine/a;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "type", "f", "(Lcom/tencent/mobileqq/qcoroutine/api/i;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", h.F, "(Lcom/tencent/mobileqq/qcoroutine/api/i;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "(Ljava/lang/Boolean;)Z", "QCoroutine_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class CorountineFunKt {
    public static final boolean a(@Nullable Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return !Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
    }

    @Nullable
    public static final <T> a<T> b(@NotNull CoroutineScope qAsync, @NotNull String name, @Nullable Boolean bool, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(qAsync, "$this$qAsync");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return QCoroutineExecute.INSTANCE.a(qAsync, name, bool, start, block);
    }

    public static /* synthetic */ a c(CoroutineScope coroutineScope, String str, Boolean bool, CoroutineStart coroutineStart, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 2) != 0) {
            bool = null;
        }
        if ((i3 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return b(coroutineScope, str, bool, coroutineStart, function2);
    }

    @Nullable
    public static final b d(@NotNull CoroutineScope qLaunch, @NotNull String name, @Nullable Boolean bool, @NotNull CoroutineStart start, @Nullable Boolean bool2, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(qLaunch, "$this$qLaunch");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        if (a(bool2)) {
            return QCoroutineExecute.INSTANCE.b(qLaunch, name, bool, start, block);
        }
        DispatcherThread.C.d(new Function0<Unit>(name, bool, start, block) { // from class: com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt$qLaunch$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function2 $block;
            final /* synthetic */ Boolean $isMain;
            final /* synthetic */ String $name;
            final /* synthetic */ CoroutineStart $start;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$name = name;
                this.$isMain = bool;
                this.$start = start;
                this.$block = block;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, CoroutineScope.this, name, bool, start, block);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    QCoroutineExecute.INSTANCE.b(CoroutineScope.this, this.$name, this.$isMain, this.$start, this.$block);
                } else {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        });
        return null;
    }

    public static /* synthetic */ b e(CoroutineScope coroutineScope, String str, Boolean bool, CoroutineStart coroutineStart, Boolean bool2, Function2 function2, int i3, Object obj) {
        Boolean bool3;
        Boolean bool4;
        if ((i3 & 1) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i3 & 2) != 0) {
            bool3 = null;
        } else {
            bool3 = bool;
        }
        if ((i3 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i3 & 8) != 0) {
            bool4 = null;
        } else {
            bool4 = bool2;
        }
        return d(coroutineScope, str2, bool3, coroutineStart2, bool4, function2);
    }

    @Nullable
    public static final <T> T f(@NotNull i type, @NotNull String name, @Nullable Boolean bool, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        return (T) QCoroutineExecute.INSTANCE.c(type, name, bool, block);
    }

    public static /* synthetic */ Object g(i iVar, String str, Boolean bool, Function2 function2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bool = null;
        }
        return f(iVar, str, bool, function2);
    }

    @Nullable
    public static final <T> Object h(@NotNull i iVar, @NotNull String str, @Nullable Boolean bool, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return QCoroutineExecute.INSTANCE.d(iVar, str, bool, function2, continuation);
    }

    public static /* synthetic */ Object i(i iVar, String str, Boolean bool, Function2 function2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            bool = null;
        }
        return h(iVar, str, bool, function2, continuation);
    }
}
