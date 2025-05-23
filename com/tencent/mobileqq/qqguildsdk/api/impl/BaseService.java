package com.tencent.mobileqq.qqguildsdk.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qqguildsdk.api.impl.BaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\r\b\u0016\u0018\u0000 P*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002QRB!\u0012\u0006\u00109\u001a\u00020\u0017\u0012\u0006\u0010?\u001a\u00020:\u0012\b\u0010\"\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\bN\u0010OJ<\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00002#\u0010\t\u001a\u001f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0004\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJD\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u000e\u001a\u00020\r2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\u0005H\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J-\u0010\u001b\u001a\u0004\u0018\u00018\u0002\"\u0004\b\u0002\u0010\u00162\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00020\u0019H\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0080\u0001\u0010&\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u001726\u0010!\u001a2\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\n0\u001d26\u0010%\u001a2\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0\u001dH\u0004J\b\u0010'\u001a\u00020\nH\u0016Jm\u0010.\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00020\n0\u001d\"\u0004\b\u0002\u0010\u0016\"\b\b\u0003\u0010)*\u00020(\"\b\b\u0004\u0010**\u00020(2\u0006\u0010$\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00018\u00022\u001e\u0010-\u001a\u001a\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00020\n0,H\u0004\u00a2\u0006\u0004\b.\u0010/J\u0087\u0001\u00103\u001a\u001c\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u0005\u0012\u0004\u0012\u00020\n02\"\u0004\b\u0002\u0010\u0016\"\b\b\u0003\u0010)*\u00020(\"\b\b\u0004\u0010**\u00020(\"\b\b\u0005\u00100*\u00020(2\u0006\u0010$\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00018\u00022&\u0010-\u001a\"\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u0005\u0012\u0004\u0012\u00020\n01H\u0004\u00a2\u0006\u0004\b3\u00104R\u0017\u00109\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u0010?\u001a\u00020:8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R$\u0010\"\u001a\u0004\u0018\u00018\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER.\u0010M\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0F8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService;", "L", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qqguildsdk/util/c;", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "add", "", "L0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "", "needCheck", "id", "remove", "W0", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)V", "Ljava/lang/Runnable;", "r", "U0", "T", "", "method", "Lkotlin/Function0;", WidgetCacheConstellationData.WORK, "O0", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "code", "msg", "onCheckFail", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;", "bypass", "onCheckSuccess", "P0", QCircleLpReportDc05507.KEY_CLEAR, "", "P1", "P2", "real", "Lkotlin/reflect/KFunction3;", "kFunction", "M0", "(Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;Ljava/lang/Object;Lkotlin/reflect/KFunction;)Lkotlin/jvm/functions/Function2;", "P3", "Lkotlin/reflect/KFunction4;", "Lkotlin/Function3;", "N0", "(Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;Ljava/lang/Object;Lkotlin/reflect/KFunction;)Lkotlin/jvm/functions/Function3;", "d", "Ljava/lang/String;", "T0", "()Ljava/lang/String;", "subTag", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "e", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "Q0", "()Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "content", "f", "Ljava/lang/Object;", "S0", "()Ljava/lang/Object;", "setService", "(Ljava/lang/Object;)V", "", tl.h.F, "Ljava/util/Map;", "R0", "()Ljava/util/Map;", "setListenersMap", "(Ljava/util/Map;)V", "listenersMap", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;Ljava/lang/Object;)V", "i", "a", "b", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class BaseService<L, S> implements com.tencent.mobileqq.qqguildsdk.util.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ServiceContent content;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private S service;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<L, Long> listenersMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/BaseService$b;", "", "", "a", "I", "b", "()I", "curSeq", "", "[Ljava/lang/Object;", "()[Ljava/lang/Object;", "args", "<init>", "(I[Ljava/lang/Object;)V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int curSeq;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Object[] args;

        public b(int i3, @NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.curSeq = i3;
            this.args = args;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Object[] getArgs() {
            return this.args;
        }

        /* renamed from: b, reason: from getter */
        public final int getCurSeq() {
            return this.curSeq;
        }
    }

    public BaseService(@NotNull String subTag, @NotNull ServiceContent content, @Nullable S s16) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        Intrinsics.checkNotNullParameter(content, "content");
        this.subTag = subTag;
        this.content = content;
        this.service = s16;
        this.listenersMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(Runnable r16, BaseService this$0) {
        Intrinsics.checkNotNullParameter(r16, "$r");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis();
        r16.run();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 100) {
            QLog.w(this$0.subTag, 1, "execute time: " + currentTimeMillis2, new Throwable());
        }
    }

    public static /* synthetic */ void X0(BaseService baseService, Object obj, boolean z16, Function1 function1, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            baseService.W0(obj, z16, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeListener");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L0(final L listener, @NotNull final Function1<? super L, Long> add) {
        Long l3;
        Intrinsics.checkNotNullParameter(add, "add");
        if (!this.listenersMap.containsKey(listener) && (l3 = (Long) O0("addListener", new Function0<Long>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.BaseService$addListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Long invoke() {
                return add.invoke(listener);
            }
        })) != null) {
            this.listenersMap.put(listener, Long.valueOf(l3.longValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final <T, P1, P2> Function2<P1, P2, Unit> M0(@NotNull b bypass, @Nullable T real, @NotNull KFunction<Unit> kFunction) {
        Intrinsics.checkNotNullParameter(bypass, "bypass");
        Intrinsics.checkNotNullParameter(kFunction, "kFunction");
        return new BaseService$callbackProxy$1(this, bypass, real, kFunction);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final <T, P1, P2, P3> Function3<P1, P2, P3, Unit> N0(@NotNull b bypass, @Nullable T real, @NotNull KFunction<Unit> kFunction) {
        Intrinsics.checkNotNullParameter(bypass, "bypass");
        Intrinsics.checkNotNullParameter(kFunction, "kFunction");
        return new BaseService$callbackProxy$2(this, bypass, real, kFunction);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final <T> T O0(@NotNull String method, @NotNull final Function0<? extends T> work) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(work, "work");
        return (T) this.content.getMCallMonitor().a(this.subTag, method, new Function0<T>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.BaseService$check$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return work.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P0(@NotNull String method, @NotNull Function2<? super Integer, ? super String, Unit> onCheckFail, @NotNull final Function2<? super S, ? super b, Unit> onCheckSuccess) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(onCheckFail, "onCheckFail");
        Intrinsics.checkNotNullParameter(onCheckSuccess, "onCheckSuccess");
        this.content.getMCallMonitor().Q(this.subTag, new Object[]{TuplesKt.to("method", method)}, this.service, onCheckFail, new Function3<S, Integer, Object[], Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.BaseService$easyCheck$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Integer num, Object[] objArr) {
                invoke((BaseService$easyCheck$1<S>) obj, num.intValue(), objArr);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull S s16, int i3, @NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(s16, "s");
                Intrinsics.checkNotNullParameter(args, "args");
                onCheckSuccess.invoke(s16, new BaseService.b(i3, args));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: Q0, reason: from getter */
    public final ServiceContent getContent() {
        return this.content;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Map<L, Long> R0() {
        return this.listenersMap;
    }

    @Nullable
    public final S S0() {
        return this.service;
    }

    @NotNull
    /* renamed from: T0, reason: from getter */
    public final String getSubTag() {
        return this.subTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U0(@NotNull final Runnable r16) {
        Intrinsics.checkNotNullParameter(r16, "r");
        if (this.content.e()) {
            this.content.i().post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseService.V0(r16, this);
                }
            });
        } else {
            QLog.e(this.subTag, 1, "context is not enable");
        }
    }

    protected final void W0(final L listener, boolean needCheck, @NotNull final Function1<? super Long, Unit> remove) {
        Intrinsics.checkNotNullParameter(remove, "remove");
        Function0<Long> function0 = new Function0<Long>(this) { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.BaseService$removeListener$block$1
            final /* synthetic */ BaseService<L, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Long invoke() {
                Long l3 = (Long) this.this$0.R0().get(listener);
                if (l3 == null) {
                    return null;
                }
                Function1<Long, Unit> function1 = remove;
                BaseService<L, S> baseService = this.this$0;
                Object obj = listener;
                function1.invoke(Long.valueOf(l3.longValue()));
                return (Long) baseService.R0().remove(obj);
            }
        };
        if (needCheck) {
            O0("removeListener", function0);
        } else {
            function0.invoke();
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.util.c
    public void clear() {
        QLog.i("BaseService", 1, this + " destroy");
        S s16 = this.service;
        if (s16 != null) {
            gd2.g gVar = gd2.g.f401968a;
            Intrinsics.checkNotNull(s16);
            gVar.b(s16);
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("release_srv_when_destroy", true)) {
            this.service = null;
        }
    }
}
