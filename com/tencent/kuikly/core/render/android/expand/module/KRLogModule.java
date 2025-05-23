package com.tencent.kuikly.core.render.android.expand.module;

import android.annotation.SuppressLint;
import com.tencent.kuikly.core.render.android.KuiklyContextParams;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tenpay.proxy.dlg.location.QbAddrData;
import d01.w;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00062\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b%\u0010&J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0003JI\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2+\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u0014H\u0016R:\u0010\u001b\u001a&\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00040\u0017j\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KRLogModule;", "Li01/e;", "Lkotlin/Function0;", "", "Lcom/tencent/kuikly/core/render/android/scheduler/KRSubThreadTask;", "task", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "params", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "l", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "logTasks", "", "e", "Z", "needSyncQueue", "f", "Lkotlin/Lazy;", "j", "()Z", "asyncLogEnable", "<init>", "()V", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRLogModule extends i01.e {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy f118020h;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile ArrayList<Function0<Unit>> logTasks = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean needSyncQueue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy asyncLogEnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KRLogModule$a;", "", "", "msg", "b", "Ljava/text/SimpleDateFormat;", "formatter$delegate", "Lkotlin/Lazy;", "a", "()Ljava/text/SimpleDateFormat;", "formatter", "METHOD_LOG_DEBUG", "Ljava/lang/String;", "METHOD_LOG_ERROR", "METHOD_LOG_INFO", "MODULE_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    @SuppressLint({"SimpleDateFormat"})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.module.KRLogModule$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final SimpleDateFormat a() {
            return (SimpleDateFormat) KRLogModule.f118020h.getValue();
        }

        @NotNull
        public final String b(@NotNull String msg2) {
            int indexOf$default;
            int indexOf$default2;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            System.currentTimeMillis();
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) msg2, "[KLog][", 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                int i3 = indexOf$default + 7;
                indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) msg2, "]:", i3, false, 4, (Object) null);
                if (indexOf$default2 != -1) {
                    String substring = msg2.substring(i3, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    return substring;
                }
                return "";
            }
            return "";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SimpleDateFormat>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRLogModule$Companion$formatter$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("HH:mm.ss.SSS");
            }
        });
        f118020h = lazy;
    }

    public KRLogModule() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRLogModule$asyncLogEnable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                d01.i f16;
                KuiklyContextParams contextParams;
                com.tencent.kuikly.core.render.android.a aVar = KRLogModule.this.get_kuiklyRenderContext();
                return (aVar == null || (contextParams = aVar.getContextParams()) == null || !contextParams.e()) && (f16 = d01.u.f392615m.f()) != null && f16.a();
            }
        });
        this.asyncLogEnable = lazy;
    }

    private final void i(Function0<Unit> task) {
        this.logTasks.add(task);
        q();
    }

    private final boolean j() {
        return ((Boolean) this.asyncLogEnable.getValue()).booleanValue();
    }

    @SuppressLint({"SimpleDateFormat"})
    private final String l() {
        String format = INSTANCE.a().format(new Date(System.currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(date)");
        return format;
    }

    private final void m(final String params) {
        if (j()) {
            final String l3 = l();
            i(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRLogModule$logDebug$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str = params;
                    if (str == null) {
                        str = "";
                    }
                    w.f392617a.a(KRLogModule.INSTANCE.b(str), QbAddrData.DATA_SPLITER + l3 + QbAddrData.DATA_SPLITER + str);
                }
            });
        } else {
            if (params == null) {
                params = "";
            }
            w.f392617a.a(INSTANCE.b(params), params);
        }
    }

    private final void o(final String params) {
        if (j()) {
            final String l3 = l();
            i(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRLogModule$logError$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str = params;
                    if (str == null) {
                        str = "";
                    }
                    w.f392617a.b(KRLogModule.INSTANCE.b(str), QbAddrData.DATA_SPLITER + l3 + QbAddrData.DATA_SPLITER + str);
                }
            });
        } else {
            if (params == null) {
                params = "";
            }
            w.f392617a.b(INSTANCE.b(params), params);
        }
    }

    private final void p(final String params) {
        if (j()) {
            final String l3 = l();
            i(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRLogModule$logInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str = params;
                    if (str == null) {
                        str = "";
                    }
                    w.f392617a.c(KRLogModule.INSTANCE.b(str), QbAddrData.DATA_SPLITER + l3 + QbAddrData.DATA_SPLITER + str);
                }
            });
        } else {
            if (params == null) {
                params = "";
            }
            w.f392617a.c(INSTANCE.b(params), params);
        }
    }

    private final void q() {
        KuiklyContextParams contextParams;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (contextParams = aVar.getContextParams()) != null && !this.needSyncQueue) {
            this.needSyncQueue = true;
            KuiklyRenderThreadManager.f118203b.g(contextParams, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRLogModule$setNeedSyncQueue$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ArrayList arrayList;
                    final List list;
                    KRLogModule.this.needSyncQueue = false;
                    arrayList = KRLogModule.this.logTasks;
                    list = CollectionsKt___CollectionsKt.toList(arrayList);
                    KRLogModule.this.logTasks = new ArrayList();
                    KuiklyRenderThreadManager.f118203b.k(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRLogModule$setNeedSyncQueue$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ((Function0) it.next()).invoke();
                            }
                        }
                    }, false);
                }
            });
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != 341391890) {
            if (hashCode != 1988324719) {
                if (hashCode == 1989650724 && method.equals("logError")) {
                    o(params);
                    return null;
                }
            } else if (method.equals("logDebug")) {
                m(params);
                return null;
            }
        } else if (method.equals("logInfo")) {
            p(params);
            return null;
        }
        super.call(method, params, callback);
        return null;
    }
}
