package com.tencent.mobileqq.qqguildsdk.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qqguildsdk.api.impl.BaseService;
import com.tencent.mobileqq.qqguildsdk.internal.KLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KFunction;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [P1, P2] */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004\"\b\b\u0002\u0010\u0005*\u00020\u0004\"\u0004\b\u0003\u0010\u0006\"\u0004\b\u0004\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00032\u0006\u0010\t\u001a\u0002H\u0005H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "T", "P1", "", "P2", "L", ExifInterface.LATITUDE_SOUTH, "arg1", "arg2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
final class BaseService$callbackProxy$1<P1, P2> extends Lambda implements Function2<P1, P2, Unit> {
    final /* synthetic */ BaseService.b $bypass;
    final /* synthetic */ KFunction<Unit> $kFunction;
    final /* synthetic */ T $real;
    final /* synthetic */ BaseService<L, S> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseService$callbackProxy$1(BaseService<L, S> baseService, BaseService.b bVar, T t16, KFunction<Unit> kFunction) {
        super(2);
        this.this$0 = baseService;
        this.$bypass = bVar;
        this.$real = t16;
        this.$kFunction = kFunction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(BaseService this$0, BaseService.b bypass, Object arg1, Object arg2, Object obj, KFunction kFunction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bypass, "$bypass");
        Intrinsics.checkNotNullParameter(arg1, "$arg1");
        Intrinsics.checkNotNullParameter(arg2, "$arg2");
        Intrinsics.checkNotNullParameter(kFunction, "$kFunction");
        KLog kLog = KLog.f268416a;
        String subTag = this$0.getSubTag();
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.addSpread(bypass.getArgs());
        spreadBuilder.add(arg1);
        spreadBuilder.add(arg2);
        kLog.d(subTag, spreadBuilder.toArray(new Object[spreadBuilder.size()]), Integer.valueOf(bypass.getCurSeq()));
        if (obj != null) {
            ((Function3) kFunction).invoke(obj, arg1, arg2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke2((BaseService$callbackProxy$1<P1, P2>) obj, obj2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final P1 arg1, @NotNull final P2 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "arg1");
        Intrinsics.checkNotNullParameter(arg2, "arg2");
        final BaseService<L, S> baseService = this.this$0;
        final BaseService.b bVar = this.$bypass;
        final T t16 = this.$real;
        final KFunction<Unit> kFunction = this.$kFunction;
        baseService.U0(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseService$callbackProxy$1.b(BaseService.this, bVar, arg1, arg2, t16, kFunction);
            }
        });
    }
}
