package com.tencent.ecommerce.biz.hr.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.hr.component.HRPAGView;
import com.tencent.ecommerce.biz.hr.ktx.HRResourceExtKt;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.kuikly.core.render.android.expand.module.j;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGText;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002^_B\u000f\u0012\u0006\u0010[\u001a\u00020Z\u00a2\u0006\u0004\b\\\u0010]J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016JI\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00032+\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bj\u0004\u0018\u0001`\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0016\u0010\u001a\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0003H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\u000fH\u0002J\b\u0010'\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020\u000fH\u0002R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R;\u00108\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R;\u0010:\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R;\u0010<\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00107R;\u0010>\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00107R;\u0010@\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bj\u0004\u0018\u0001`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00107R\u0016\u0010B\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010*R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bM\u0010*R\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR(\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0\u000b0C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010ER\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010Y\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010X\u00a8\u0006`"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRPAGView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Li01/c;", "", "propKey", "", "propValue", "", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "success", "Lkotlin/Function0;", "block", "f0", "p0", "g0", "d0", "src", "n0", "o0", "m0", "k0", "path", "l0", "Lorg/libpag/PAGFile;", "pagFile", "i0", "j0", "e0", "h0", "c0", "H", "Z", "autoPlay", "I", "srcSourceReady", "Lorg/libpag/PAGView;", "J", "Lorg/libpag/PAGView;", "pagView", "Lorg/libpag/PAGView$PAGViewListener;", "K", "Lorg/libpag/PAGView$PAGViewListener;", "pagAnimationListener", "L", "Lkotlin/jvm/functions/Function1;", "animationStartCallback", "M", "animationEndCallback", "N", "animationCancelCallback", "P", "animationRepeatCallback", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "loadFailureCallback", BdhLogUtil.LogTag.Tag_Req, "hadCallLoadFail", "", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "replaceImageTagList", "T", "replaceTextList", "Lcom/tencent/ecommerce/biz/hr/component/HRPAGView$ECPagSoLoader;", "U", "Lcom/tencent/ecommerce/biz/hr/component/HRPAGView$ECPagSoLoader;", "pagSoLoader", "V", "pagSoLoadSuccess", "Lcom/tencent/ecommerce/biz/hr/component/a;", "W", "Lcom/tencent/ecommerce/biz/hr/component/a;", "pagSoLoadResultCallback", "a0", "pagSoDownloadCallbackList", "b0", "Ljava/lang/String;", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ECPagSoLoader", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRPAGView extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean srcSourceReady;

    /* renamed from: J, reason: from kotlin metadata */
    private PAGView pagView;

    /* renamed from: K, reason: from kotlin metadata */
    private PAGView.PAGViewListener pagAnimationListener;

    /* renamed from: L, reason: from kotlin metadata */
    private Function1<Object, Unit> animationStartCallback;

    /* renamed from: M, reason: from kotlin metadata */
    private Function1<Object, Unit> animationEndCallback;

    /* renamed from: N, reason: from kotlin metadata */
    private Function1<Object, Unit> animationCancelCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private Function1<Object, Unit> animationRepeatCallback;

    /* renamed from: Q, reason: from kotlin metadata */
    private Function1<Object, Unit> loadFailureCallback;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean hadCallLoadFail;

    /* renamed from: S, reason: from kotlin metadata */
    private List<String> replaceImageTagList;

    /* renamed from: T, reason: from kotlin metadata */
    private List<String> replaceTextList;

    /* renamed from: U, reason: from kotlin metadata */
    private final ECPagSoLoader pagSoLoader;

    /* renamed from: V, reason: from kotlin metadata */
    private final boolean pagSoLoadSuccess;

    /* renamed from: W, reason: from kotlin metadata */
    private a pagSoLoadResultCallback;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private List<Function1<Boolean, Unit>> pagSoDownloadCallbackList;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String src;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\b\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00050\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRPAGView$ECPagSoLoader;", "", "", "b", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function1;", "", "resultBlock", "c", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class ECPagSoLoader {

        /* renamed from: a, reason: collision with root package name */
        private static boolean f102552a;

        /* renamed from: b, reason: collision with root package name */
        private static boolean f102553b;

        public final void b() {
            if (f102552a) {
                return;
            }
            f102552a = true;
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().downloadPagSo();
        }

        public final void c(final WeakReference<Function1<Boolean, Unit>> resultBlock) {
            if (f102553b) {
                Function1<Boolean, Unit> function1 = resultBlock.get();
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                    return;
                }
                return;
            }
            cg0.a.b("HRPAGView", "start load pag so");
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().loadPagSoAsync(new Function1<Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$ECPagSoLoader$loadPagSoAsync$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final boolean z16) {
                    cg0.a.b("HRPAGView", "load pag async result: " + z16);
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$ECPagSoLoader$loadPagSoAsync$1.1
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
                            HRPAGView.ECPagSoLoader.f102553b = z16;
                            Function1 function12 = (Function1) resultBlock.get();
                            if (function12 != null) {
                            }
                        }
                    });
                }
            });
        }
    }

    public HRPAGView(Context context) {
        super(context);
        this.autoPlay = true;
        this.replaceImageTagList = new ArrayList();
        this.replaceTextList = new ArrayList();
        this.pagSoLoader = new ECPagSoLoader();
        this.pagSoDownloadCallbackList = new ArrayList();
        this.src = "";
    }

    private final void c0() {
        if (this.pagView == null) {
            this.pagView = new PAGView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            PAGView pAGView = this.pagView;
            Intrinsics.checkNotNull(pAGView);
            pAGView.setLayoutParams(layoutParams);
            addView(this.pagView);
            cg0.a.b("HRPAGView", "add pag view: " + hashCode());
        }
    }

    private final void d0(final Function0<Unit> block) {
        if (this.pagSoLoadSuccess) {
            c0();
            block.invoke();
            return;
        }
        if (this.pagSoLoadResultCallback == null) {
            this.pagSoLoadResultCallback = new a(this);
        }
        Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$ensurePAGSoReady$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                a aVar;
                aVar = HRPAGView.this.pagSoLoadResultCallback;
                if (aVar != null) {
                    aVar.b(z16, block);
                }
            }
        };
        this.pagSoDownloadCallbackList.add(function1);
        this.pagSoLoader.c(new WeakReference<>(function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        if (this.pagAnimationListener != null) {
            return;
        }
        b bVar = new b();
        this.pagAnimationListener = bVar;
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.addListener(bVar);
        }
    }

    private final void g0() {
        d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$play$1
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
                PAGView pAGView;
                pAGView = HRPAGView.this.pagView;
                if (pAGView != null) {
                    pAGView.play();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        PAGView pAGView;
        if (this.srcSourceReady && this.autoPlay && (pAGView = this.pagView) != null) {
            Intrinsics.checkNotNull(pAGView);
            if (pAGView.isPlaying()) {
                return;
            }
            cg0.a.b("HRPAGView", "start play pag: " + hashCode());
            PAGView pAGView2 = this.pagView;
            Intrinsics.checkNotNull(pAGView2);
            pAGView2.play();
        }
    }

    private final void i0(PAGFile pagFile) {
        List split$default;
        j jVar;
        if (this.replaceImageTagList.isEmpty()) {
            return;
        }
        if (pagFile.numImages() <= 0) {
            cg0.a.b("HRPAGView", "pag file numImages is zero");
            return;
        }
        Iterator<T> it = this.replaceImageTagList.iterator();
        while (it.hasNext()) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{"&&"}, false, 0, 6, (Object) null);
            if (split$default.size() == 2) {
                String str = (String) split$default.get(0);
                int parseInt = Integer.parseInt((String) split$default.get(1));
                com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
                Bitmap bitmap = (aVar == null || (jVar = (j) aVar.a("KRMemoryCacheModule")) == null) ? null : (Bitmap) jVar.g(str);
                Bitmap bitmap2 = bitmap instanceof Bitmap ? bitmap : null;
                if (bitmap2 != null && parseInt < pagFile.numImages()) {
                    pagFile.replaceImage(parseInt, PAGImage.FromBitmap(bitmap2));
                } else {
                    cg0.a.b("HRPAGView", "pag file replaceParam error imageTag=" + str + " replaceIndex=" + parseInt + " numImages=" + pagFile.numImages());
                }
            }
        }
    }

    private final void j0(PAGFile pagFile) {
        List split$default;
        if (this.replaceTextList.isEmpty()) {
            return;
        }
        if (pagFile.numTexts() <= 0) {
            cg0.a.b("HRPAGView", "pag file numTexts is zero");
            return;
        }
        Iterator<T> it = this.replaceTextList.iterator();
        while (it.hasNext()) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{"&&"}, false, 0, 6, (Object) null);
            if (split$default.size() == 2) {
                String str = (String) split$default.get(0);
                int parseInt = Integer.parseInt((String) split$default.get(1));
                if (parseInt >= pagFile.numTexts()) {
                    cg0.a.b("HRPAGView", "pag file replaceParam error replaceIndex=" + parseInt + " numTexts=" + pagFile.numTexts());
                } else {
                    PAGText textData = pagFile.getTextData(parseInt);
                    textData.text = str;
                    pagFile.replaceText(parseInt, textData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(String path) {
        boolean startsWith$default;
        PAGFile Load;
        String replace$default;
        if ((!this.replaceImageTagList.isEmpty()) || (!this.replaceTextList.isEmpty())) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "assets://", false, 2, null);
            if (startsWith$default) {
                replace$default = StringsKt__StringsJVMKt.replace$default(path, "assets://", "", false, 4, (Object) null);
                Load = PagViewMonitor.Load(getContext().getAssets(), replace$default);
            } else {
                Load = PagViewMonitor.Load(path);
            }
            if (Load == null) {
                cg0.a.b("HRPAGView", "pag file is null path=" + path);
                PAGView pAGView = this.pagView;
                if (pAGView != null) {
                    pAGView.setPath(path);
                    return;
                }
                return;
            }
            i0(Load);
            j0(Load);
            PAGView pAGView2 = this.pagView;
            if (pAGView2 != null) {
                pAGView2.setComposition(Load);
                return;
            }
            return;
        }
        PAGView pAGView3 = this.pagView;
        if (pAGView3 != null) {
            pAGView3.setPath(path);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(Object propValue) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            if (propValue != null) {
                pAGView.setRepeatCount(((Integer) propValue).intValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(String src) {
        boolean startsWith$default;
        List split$default;
        boolean startsWith$default2;
        boolean contains$default;
        if (Intrinsics.areEqual(this.src, src)) {
            return;
        }
        this.src = src;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(src, "qecommerce", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(src, "ecommerce", false, 2, null);
            if (!startsWith$default2) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) src, (CharSequence) "http", false, 2, (Object) null);
                if (contains$default) {
                    o0(src);
                    return;
                }
                return;
            }
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) src, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        String url = ECSkin.INSTANCE.getUrl(split$default.isEmpty() ^ true ? (String) split$default.get(0) : src);
        if (url != null) {
            if (url.length() > 0) {
                o0(url);
                return;
            }
        }
        l0("assets://pag/" + src + ".pag");
        this.srcSourceReady = true;
        h0();
    }

    private final void p0() {
        d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$stop$1
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
                PAGView pAGView;
                pAGView = HRPAGView.this.pagView;
                if (pAGView != null) {
                    pAGView.stop();
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(String propKey, final Object propValue) {
        switch (propKey.hashCode()) {
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    if (propValue != null) {
                        this.loadFailureCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$setProp$8
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        });
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                }
                return super.b(propKey, propValue);
            case -1458222274:
                if (propKey.equals("animationStart")) {
                    d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$setProp$4
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
                            HRPAGView hRPAGView = HRPAGView.this;
                            Object obj = propValue;
                            if (obj != null) {
                                hRPAGView.animationStartCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                                HRPAGView.this.e0();
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case -349798637:
                if (propKey.equals("replaceImageTag")) {
                    List<String> list = this.replaceImageTagList;
                    if (propValue != null) {
                        list.add((String) propValue);
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                return super.b(propKey, propValue);
            case 114148:
                if (propKey.equals("src")) {
                    d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$setProp$1
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
                            HRPAGView hRPAGView = HRPAGView.this;
                            Object obj = propValue;
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            hRPAGView.n0((String) obj);
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 430174721:
                if (propKey.equals(HippyQQPagView.FunctionName.REPLACE_TEXT)) {
                    List<String> list2 = this.replaceTextList;
                    if (propValue != null) {
                        list2.add((String) propValue);
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                return super.b(propKey, propValue);
            case 1173886647:
                if (propKey.equals("animationEnd")) {
                    d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$setProp$6
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
                            HRPAGView hRPAGView = HRPAGView.this;
                            Object obj = propValue;
                            if (obj != null) {
                                hRPAGView.animationEndCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                                HRPAGView.this.e0();
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 1438608771:
                if (propKey.equals("autoPlay")) {
                    d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$setProp$3
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
                            HRPAGView.this.k0(propValue);
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 1564508958:
                if (propKey.equals("animationCancel")) {
                    d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$setProp$5
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
                            HRPAGView hRPAGView = HRPAGView.this;
                            Object obj = propValue;
                            if (obj != null) {
                                hRPAGView.animationCancelCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                                HRPAGView.this.e0();
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 1571519540:
                if (propKey.equals("repeatCount")) {
                    d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$setProp$2
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
                            HRPAGView.this.m0(propValue);
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 1997701695:
                if (propKey.equals("animationRepeat")) {
                    d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$setProp$7
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
                            HRPAGView hRPAGView = HRPAGView.this;
                            Object obj = propValue;
                            if (obj != null) {
                                hRPAGView.animationRepeatCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                                HRPAGView.this.e0();
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            default:
                return super.b(propKey, propValue);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        int hashCode = method.hashCode();
        if (hashCode != 3443508) {
            if (hashCode == 3540994 && method.equals("stop")) {
                p0();
                return Unit.INSTANCE;
            }
        } else if (method.equals("play")) {
            g0();
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.pagSoLoadResultCallback;
        if (aVar != null) {
            aVar.a();
        }
        this.pagSoLoadResultCallback = null;
        this.pagSoDownloadCallbackList.clear();
    }

    private final void o0(final String src) {
        PAGView pAGView;
        this.srcSourceReady = false;
        setVisibility(4);
        PAGView pAGView2 = this.pagView;
        if (pAGView2 != null && pAGView2.isPlaying() && (pAGView = this.pagView) != null) {
            pAGView.stop();
        }
        HRResourceExtKt.a(getContext(), src, ".pag", new Function1<File, Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$setSrcWithNetworkUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(File file) {
                invoke2(file);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final File file) {
                HRPAGView.this.post(new Runnable() { // from class: com.tencent.ecommerce.biz.hr.component.HRPAGView$setSrcWithNetworkUrl$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Function1 function1;
                        Map emptyMap;
                        HRPAGView.this.setVisibility(0);
                        if (file == null) {
                            function1 = HRPAGView.this.loadFailureCallback;
                            if (function1 != null) {
                                emptyMap = MapsKt__MapsKt.emptyMap();
                            }
                            cg0.a.a("HRPAGView", "setPagSrc", "download pag file error, src: " + src + ", hashCode: " + HRPAGView.this.hashCode());
                            return;
                        }
                        HRPAGView.this.srcSourceReady = true;
                        HRPAGView.this.l0(file.getAbsolutePath());
                        HRPAGView.this.h0();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(Object propValue) {
        if (propValue != null) {
            this.autoPlay = ((Integer) propValue).intValue() == 1;
            h0();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void f0(boolean success, Function0<Unit> block) {
        Function1<Object, Unit> function1;
        Map emptyMap;
        if (success) {
            c0();
            block.invoke();
        } else {
            if (this.hadCallLoadFail || (function1 = this.loadFailureCallback) == null) {
                return;
            }
            Intrinsics.checkNotNull(function1);
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
            this.hadCallLoadFail = true;
            this.pagSoLoader.b();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/ecommerce/biz/hr/component/HRPAGView$b", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements PAGView.PAGViewListener {
        b() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView p06) {
            Map emptyMap;
            Function1 function1 = HRPAGView.this.animationCancelCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView p06) {
            Map emptyMap;
            Function1 function1 = HRPAGView.this.animationEndCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView p06) {
            Map emptyMap;
            Function1 function1 = HRPAGView.this.animationRepeatCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView p06) {
            Map emptyMap;
            Function1 function1 = HRPAGView.this.animationStartCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView p06) {
        }
    }
}
