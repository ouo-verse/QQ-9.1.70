package com.tencent.kuikly.core.render.android.expand.component;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.expand.vendor.KRFileManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import d01.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001JB\u000f\u0012\u0006\u0010F\u001a\u00020E\u00a2\u0006\u0004\bG\u0010HJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0016\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016JI\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032+\u0010\u001d\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018j\u0004\u0018\u0001`\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0016J3\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00032#\u0010$\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\u0018J\u000e\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R;\u00102\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R;\u00104\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R;\u00106\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00101R\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u0010R\u0016\u0010:\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u0010R0\u0010?\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110;j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0011`<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010!\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010,\u00a8\u0006K"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRAPNGView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Ld01/c;", "", "params", "", "X", "b0", "", "", "a0", "Y", "propValue", ExifInterface.LATITUDE_SOUTH, "c0", "filePath", "Z", "Lkotlin/Function0;", "task", "W", "V", "propKey", "b", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "apngView", "onAnimationEnd", "cdnUrl", "resultCallback", "T", "U", "H", "Ljava/lang/String;", "src", "I", "getAutoPlay", "()Z", "setAutoPlay", "(Z)V", "autoPlay", "J", "Lkotlin/jvm/functions/Function1;", "loadFailureCallback", "K", "animationStartCallback", "L", "animationEndCallback", "M", "hadStop", "N", "hadFilePath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "P", "Ljava/util/ArrayList;", "fileLoadLazyTasks", "Ld01/b;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ld01/b;", "k", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRAPNGView extends KRView implements d01.c {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: from kotlin metadata */
    private String src;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: J, reason: from kotlin metadata */
    private Function1<Object, Unit> loadFailureCallback;

    /* renamed from: K, reason: from kotlin metadata */
    private Function1<Object, Unit> animationStartCallback;

    /* renamed from: L, reason: from kotlin metadata */
    private Function1<Object, Unit> animationEndCallback;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean hadStop;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hadFilePath;

    /* renamed from: P, reason: from kotlin metadata */
    private final ArrayList<Function0<Unit>> fileLoadLazyTasks;

    /* renamed from: Q, reason: from kotlin metadata */
    private d01.b apngView;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRAPNGView$a;", "", "", "url", "", "a", "ANIMATION_END", "Ljava/lang/String;", "ANIMATION_START", "AUTO_PLAY", "LOAD_FAIL", "METHOD_PLAY", "METHOD_STOP", "REPEAT_COUNT", "SRC", "VIEW_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRAPNGView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a(@NotNull String url) {
            boolean startsWith$default;
            boolean startsWith$default2;
            Intrinsics.checkNotNullParameter(url, "url");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
                if (!startsWith$default2) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRAPNGView(@NotNull Context context) {
        super(context);
        final d01.b bVar;
        Intrinsics.checkNotNullParameter(context, "context");
        this.src = "";
        this.autoPlay = true;
        this.fileLoadLazyTasks = new ArrayList<>();
        d01.d a16 = u.f392615m.a();
        if (a16 != null && (bVar = a16.a(context)) != null) {
            W(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRAPNGView$$special$$inlined$apply$lambda$1
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
                    d01.b.this.e(this);
                }
            });
            View d16 = bVar.d();
            d16.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(d16);
            Unit unit = Unit.INSTANCE;
        } else {
            bVar = null;
        }
        this.apngView = bVar;
    }

    private final boolean S(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.autoPlay = z16;
            c0();
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V() {
        if (this.hadFilePath) {
            Object[] array = this.fileLoadLazyTasks.toArray(new Function0[0]);
            if (array != null) {
                for (Object obj : array) {
                    ((Function0) obj).invoke();
                }
                this.fileLoadLazyTasks.clear();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    private final void W(Function0<Unit> task) {
        if (this.hadFilePath) {
            task.invoke();
        } else {
            this.fileLoadLazyTasks.add(task);
        }
    }

    private final void X(String params) {
        W(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRAPNGView$play$1
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
                d01.b bVar;
                Function1 function1;
                KRAPNGView.this.hadStop = false;
                bVar = KRAPNGView.this.apngView;
                if (bVar != null) {
                    bVar.b();
                }
                function1 = KRAPNGView.this.animationStartCallback;
                if (function1 != null) {
                }
            }
        });
    }

    private final boolean Y(final Object params) {
        W(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRAPNGView$repeatCount$1
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
                d01.b bVar;
                bVar = KRAPNGView.this.apngView;
                if (bVar != null) {
                    Object obj = params;
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    bVar.setRepeatCount(((Integer) obj).intValue());
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(String filePath) {
        d01.b bVar = this.apngView;
        if (bVar != null) {
            bVar.setFilePath(filePath);
        }
        this.hadFilePath = true;
    }

    private final boolean a0(Object params) {
        if (params != null) {
            String str = (String) params;
            if (Intrinsics.areEqual(this.src, str)) {
                return true;
            }
            this.src = str;
            if (INSTANCE.a(str)) {
                T(this.src, new Function1<String, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRAPNGView$setSrc$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                        invoke2(str2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable String str2) {
                        if (str2 != null) {
                            KRAPNGView.this.Z(str2);
                        }
                        KRAPNGView.this.V();
                    }
                });
            } else {
                Z(this.src);
                post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRAPNGView$setSrc$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        KRAPNGView.this.c0();
                    }
                });
                V();
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void b0(String params) {
        W(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRAPNGView$stop$1
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
                boolean z16;
                d01.b bVar;
                z16 = KRAPNGView.this.hadStop;
                if (z16) {
                    return;
                }
                KRAPNGView.this.hadStop = true;
                bVar = KRAPNGView.this.apngView;
                if (bVar != null) {
                    bVar.stopAnimation();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        if (this.autoPlay && this.hadFilePath) {
            X(null);
        }
    }

    public final void T(@NotNull final String cdnUrl, @NotNull final Function1<? super String, Unit> resultCallback) {
        Intrinsics.checkNotNullParameter(cdnUrl, "cdnUrl");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        final String U = U(cdnUrl);
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null) {
            KRFileManager.f118087b.d(aVar, cdnUrl, U, new Function1<String, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRAPNGView$fetchAPNGFileIfNeedWithCdnUrl$$inlined$also$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str) {
                    Function1 function1;
                    if (str == null) {
                        function1 = KRAPNGView.this.loadFailureCallback;
                        if (function1 != null) {
                        }
                        resultCallback.invoke(null);
                        return;
                    }
                    resultCallback.invoke(str);
                    KRAPNGView.this.post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRAPNGView$fetchAPNGFileIfNeedWithCdnUrl$$inlined$also$lambda$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            KRAPNGView.this.c0();
                        }
                    });
                }
            });
        }
    }

    @NotNull
    public final String U(@NotNull String cdnUrl) {
        com.tencent.kuikly.core.render.android.expand.module.e eVar;
        String d16;
        Intrinsics.checkNotNullParameter(cdnUrl, "cdnUrl");
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null) {
            eVar = (com.tencent.kuikly.core.render.android.expand.module.e) aVar.a("KRCodecModule");
        } else {
            eVar = null;
        }
        if (eVar != null && (d16 = eVar.d(cdnUrl)) != null) {
            cdnUrl = d16;
        }
        StringBuilder sb5 = new StringBuilder();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        File cacheDir = context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
        sb5.append(cacheDir.getAbsolutePath());
        sb5.append("/kuikly");
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath() + "/kuikly_apng_" + cdnUrl + ".png";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        boolean z16;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        boolean z17 = true;
        switch (propKey.hashCode()) {
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    this.loadFailureCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case -1458222274:
                if (propKey.equals("animationStart")) {
                    this.animationStartCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 114148:
                if (propKey.equals("src")) {
                    z17 = a0(propValue);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 1173886647:
                if (propKey.equals("animationEnd")) {
                    this.animationEndCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 1438608771:
                if (propKey.equals("autoPlay")) {
                    z17 = S(propValue);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            case 1571519540:
                if (propKey.equals("repeatCount")) {
                    z17 = Y(propValue);
                    break;
                }
                z17 = super.b(propKey, propValue);
                break;
            default:
                z17 = super.b(propKey, propValue);
                break;
        }
        if (!z17) {
            d01.b bVar = this.apngView;
            if (bVar != null) {
                z16 = bVar.a(propKey, propValue);
            } else {
                z16 = false;
            }
            return z16;
        }
        return z17;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != 3443508) {
            if (hashCode == 3540994 && method.equals("stop")) {
                b0(params);
                return Unit.INSTANCE;
            }
        } else if (method.equals("play")) {
            X(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // d01.c
    public void onAnimationEnd(@NotNull View apngView) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(apngView, "apngView");
        Function1<Object, Unit> function1 = this.animationEndCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    public void onDestroy() {
        super.onDestroy();
        b0(null);
        this.fileLoadLazyTasks.clear();
        d01.b bVar = this.apngView;
        if (bVar != null) {
            bVar.c(this);
        }
    }

    public final void setAutoPlay(boolean z16) {
        this.autoPlay = z16;
    }
}
