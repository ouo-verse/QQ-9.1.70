package com.tencent.kuikly.core.render.android.expand.component.lottie;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.a;
import com.tencent.kuikly.core.render.android.expand.module.e;
import com.tencent.kuikly.core.render.android.expand.vendor.KRFileManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import d01.j;
import d01.q;
import d01.r;
import d01.u;
import i01.c;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001EB\u000f\u0012\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016JI\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010#\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052+\u0010)\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0003\u0018\u00010$j\u0004\u0018\u0001`(H\u0016J\b\u0010+\u001a\u00020\u0003H\u0014J\b\u0010,\u001a\u00020\u0003H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R;\u00107\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0003\u0018\u00010$j\u0004\u0018\u0001`(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00106R;\u00108\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0003\u0018\u00010$j\u0004\u0018\u0001`(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00106R;\u00109\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0003\u0018\u00010$j\u0004\u0018\u0001`(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00106R\u0016\u0010;\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00102R\u0016\u0010=\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00100R\u0016\u0010?\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00102\u00a8\u0006F"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/lottie/KRLottieView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "j", "", "filePath", "Ld01/q;", "i", "", "propValue", "", "y", "w", "t", "r", "v", "u", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "p", "B", BdhLogUtil.LogTag.Tag_Conn, "src", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "cdnUrl", "l", "url", "o", "lottieView", HippyTKDListViewAdapter.X, "propKey", "b", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", NodeProps.ON_DETACHED_FROM_WINDOW, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Ld01/q;", "e", "Ljava/lang/String;", "f", "Z", "autoPlay", h.F, "loopAnimation", "Lkotlin/jvm/functions/Function1;", "loadFailure", "animationStart", "animationEnd", "D", "didSetFilePath", "E", "lastFilePath", UserInfo.SEX_FEMALE, "hadDestroy", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "G", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRLottieView extends FrameLayout implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private Function1<Object, Unit> animationEnd;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean didSetFilePath;

    /* renamed from: E, reason: from kotlin metadata */
    private String lastFilePath;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hadDestroy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private q lottieView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String src;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean loopAnimation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> loadFailure;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> animationStart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/lottie/KRLottieView$b", "Ld01/r;", "", "animationFinished", "", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b implements r {
        b() {
        }

        @Override // d01.r
        public void a(boolean animationFinished) {
            Map emptyMap;
            Function1 function1 = KRLottieView.this.animationEnd;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRLottieView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.src = "";
        this.autoPlay = true;
        this.loopAnimation = true;
        this.lastFilePath = "";
    }

    private final void A(String params) {
        this.autoPlay = false;
        q qVar = this.lottieView;
        if (qVar != null) {
            qVar.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        if (this.didSetFilePath && this.autoPlay) {
            q(null);
        }
    }

    private final void C() {
        post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.lottie.KRLottieView$tryToAutoPlayInNextLoop$1
            @Override // java.lang.Runnable
            public final void run() {
                KRLottieView.this.B();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        if (r0 != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final q i(String filePath) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean z16 = false;
        q qVar = null;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(filePath, "{", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(filePath, " {", false, 2, null);
        }
        z16 = true;
        if (z16) {
            j g16 = u.f392615m.g();
            if (g16 != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                qVar = g16.b(context, filePath);
            }
        } else {
            j g17 = u.f392615m.g();
            if (g17 != null) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                qVar = g17.a(context2, filePath);
            }
        }
        Intrinsics.checkNotNull(qVar);
        return qVar;
    }

    private final void j() {
        if (this.hadDestroy) {
            return;
        }
        this.hadDestroy = true;
        q qVar = this.lottieView;
        if (qVar != null) {
            qVar.destroy();
        }
    }

    private final String l(String cdnUrl) {
        e eVar;
        String d16;
        a aVar = get_kuiklyRenderContext();
        if (aVar != null) {
            eVar = (e) aVar.a("KRCodecModule");
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
        return file.getAbsolutePath() + "/kuikly_lottie_" + cdnUrl + ".lottie";
    }

    private final void m(final String src) {
        final String l3 = l(src);
        if (new File(l3).exists()) {
            z(l3);
            C();
        } else {
            a aVar = get_kuiklyRenderContext();
            if (aVar != null) {
                KRFileManager.f118087b.d(aVar, src, l3, new Function1<String, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.lottie.KRLottieView$handleCDNTypeWithSrc$$inlined$also$lambda$1
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
                        Map emptyMap;
                        if (str != null) {
                            if (str.length() > 0) {
                                KRLottieView.this.z(l3);
                                KRLottieView.this.B();
                                return;
                            }
                        }
                        function1 = KRLottieView.this.loadFailure;
                        if (function1 != null) {
                            emptyMap = MapsKt__MapsKt.emptyMap();
                        }
                    }
                });
            }
        }
    }

    private final boolean o(String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
            if (!startsWith$default2) {
                return false;
            }
        }
        return true;
    }

    private final void p(String params) {
        this.autoPlay = false;
        q qVar = this.lottieView;
        if (qVar != null) {
            qVar.pause();
        }
    }

    private final void q(String params) {
        Map emptyMap;
        this.autoPlay = true;
        q qVar = this.lottieView;
        if (qVar != null) {
            qVar.play();
        }
        Function1<Object, Unit> function1 = this.animationStart;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    private final boolean r(Object propValue) {
        if (!TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
            propValue = null;
        }
        this.animationEnd = (Function1) propValue;
        return true;
    }

    private final boolean t(Object propValue) {
        if (!TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
            propValue = null;
        }
        this.animationStart = (Function1) propValue;
        return true;
    }

    private final boolean u(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.autoPlay = z16;
            if (z16) {
                B();
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean v(Object propValue) {
        if (!TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
            propValue = null;
        }
        this.loadFailure = (Function1) propValue;
        return true;
    }

    private final boolean w(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 != this.loopAnimation) {
                this.loopAnimation = z16;
                q qVar = this.lottieView;
                if (qVar != null) {
                    qVar.i(z16);
                }
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(q lottieView) {
        if (!(!Intrinsics.areEqual(this.lottieView, lottieView)) || !(lottieView instanceof View)) {
            return;
        }
        Object obj = this.lottieView;
        if (!(obj instanceof View)) {
            obj = null;
        }
        View view = (View) obj;
        if (view != null) {
            removeView(view);
        }
        this.lottieView = lottieView;
        if (lottieView != 0) {
            View view2 = (View) lottieView;
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(view2);
            q qVar = this.lottieView;
            if (qVar != null) {
                qVar.i(this.loopAnimation);
            }
            q qVar2 = this.lottieView;
            if (qVar2 != null) {
                qVar2.setLottieViewListener(new b());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    private final boolean y(Object propValue) {
        if (propValue != null) {
            String str = (String) propValue;
            if (!Intrinsics.areEqual(str, this.src)) {
                this.src = str;
                if (o(str)) {
                    m(this.src);
                } else {
                    z(this.src);
                    C();
                }
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(String filePath) {
        if (Intrinsics.areEqual(this.lastFilePath, filePath)) {
            return;
        }
        this.lastFilePath = filePath;
        x(i(filePath));
        this.didSetFilePath = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0010. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    return v(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1458222274:
                if (propKey.equals("animationStart")) {
                    return t(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 114148:
                if (propKey.equals("src")) {
                    return y(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 515222848:
                if (propKey.equals("loopAnimation")) {
                    return w(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1173886647:
                if (propKey.equals("animationEnd")) {
                    return r(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1438608771:
                if (propKey.equals("autoPlay")) {
                    return u(propValue);
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "method");
        return c.a.a(this, method, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.l(this, parent);
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
    public a get_kuiklyRenderContext() {
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
    public void n(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.i(this, parent);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String propKey) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        return c.a.m(this, propKey);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        c.a.q(this, shadow);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != 3443508) {
            if (hashCode != 3540994) {
                if (hashCode == 106440182 && method.equals("pause")) {
                    p(params);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("stop")) {
                A(params);
                return Unit.INSTANCE;
            }
        } else if (method.equals("play")) {
            q(params);
            return Unit.INSTANCE;
        }
        return c.a.b(this, method, params, callback);
    }
}
