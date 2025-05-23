package com.tencent.robot.adelie.kuikly.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.robot.adelie.homepage.g;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import i01.b;
import i01.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001'B\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R;\u0010\u0017\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R;\u0010\u0019\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R;\u0010\u001b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\"\u0010\t\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/robot/adelie/kuikly/view/AdelieSuperResolutionImageView;", "Landroid/widget/ImageView;", "Li01/c;", "", "propValue", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "src", "g", "", "propKey", "b", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "d", "Lkotlin/jvm/functions/Function1;", "loadSuccessCallback", "e", "loadSuperResolutionCallback", "f", "loadFailCallback", h.F, "Ljava/lang/String;", "getSrc", "()Ljava/lang/String;", "setSrc", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieSuperResolutionImageView extends ImageView implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> loadSuccessCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> loadSuperResolutionCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> loadFailCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String src;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieSuperResolutionImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.src = "";
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private final boolean g(final Object src) {
        if (!(src instanceof String)) {
            return false;
        }
        String str = (String) src;
        this.src = str;
        CommonExKt.j(this, g.f366352a.b(), str, null, null, new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.kuikly.view.a
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                AdelieSuperResolutionImageView.i(AdelieSuperResolutionImageView.this, src, loadState, option);
            }
        }, new Function3<Boolean, Long, String, Unit>() { // from class: com.tencent.robot.adelie.kuikly.view.AdelieSuperResolutionImageView$loadImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Long l3, String str2) {
                invoke(bool.booleanValue(), l3.longValue(), str2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, long j3, @Nullable String str2) {
                Function1 function1;
                Map mapOf;
                Function1 function12;
                Map mapOf2;
                if (z16) {
                    function12 = AdelieSuperResolutionImageView.this.loadSuperResolutionCallback;
                    if (function12 != null) {
                        mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("src", src));
                        function12.invoke(mapOf2);
                        return;
                    }
                    return;
                }
                function1 = AdelieSuperResolutionImageView.this.loadFailCallback;
                if (function1 != null) {
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", Long.valueOf(j3)), TuplesKt.to("msg", str2));
                    function1.invoke(mapOf);
                }
            }
        }, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AdelieSuperResolutionImageView this$0, Object src, LoadState loadState, Option option) {
        boolean z16;
        Function1<Object, Unit> function1;
        Map mapOf;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(src, "$src");
        if (loadState != null && loadState.isFinishSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Function1<Object, Unit> function12 = this$0.loadSuccessCallback;
            if (function12 != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("src", src));
                function12.invoke(mapOf2);
                return;
            }
            return;
        }
        if ((loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) && (function1 = this$0.loadFailCallback) != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", Integer.valueOf(loadState.ordinal())), TuplesKt.to("msg", loadState.name()));
            function1.invoke(mapOf);
        }
    }

    private final boolean j(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.loadFailCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final boolean l(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.loadSuccessCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    private final boolean m(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.loadSuperResolutionCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0010. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1021576190:
                if (propKey.equals("loadSuperResolutionSuccess")) {
                    return m(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 114148:
                if (propKey.equals("src")) {
                    return g(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1845177636:
                if (propKey.equals("loadFail")) {
                    return j(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1915020349:
                if (propKey.equals("loadSuccess")) {
                    return l(propValue);
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull b bVar) {
        c.a.q(this, bVar);
    }

    public final void setSrc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.src = str;
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable String str2, @Nullable Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }
}
