package com.tencent.mobileqq.vas.kuikly;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.ArrayMap;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.network.api.IECHttpDownloader;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vas.kuikly.VasNativePagView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGImage;
import org.libpag.PAGText;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0003{|$B\u000f\u0012\u0006\u0010x\u001a\u000201\u00a2\u0006\u0004\by\u0010zJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0002J\b\u0010\u001e\u001a\u00020\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\f\u0010!\u001a\u00020\t*\u00020\tH\u0002J\u0018\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016JI\u0010-\u001a\u0004\u0018\u00010\u00102\u0006\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\t2+\u0010,\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0003\u0018\u00010'j\u0004\u0018\u0001`+H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016J\u001c\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020#2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006J0\u00105\u001a\u00020\u0003*\u0002012\u0006\u0010\n\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0014\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0004\u0012\u00020\u00030'R\u0016\u00108\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00109R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR;\u0010H\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0003\u0018\u00010'j\u0004\u0018\u0001`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR;\u0010J\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0003\u0018\u00010'j\u0004\u0018\u0001`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010GR;\u0010L\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0003\u0018\u00010'j\u0004\u0018\u0001`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010GR;\u0010N\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0003\u0018\u00010'j\u0004\u0018\u0001`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010GR;\u0010P\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0003\u0018\u00010'j\u0004\u0018\u0001`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010GR;\u0010R\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0003\u0018\u00010'j\u0004\u0018\u0001`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010GR\u0016\u0010T\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u00107R\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\t0U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020\t0U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010WR\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020\t0U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010WR\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020\t0U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010WR\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00170U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010WR\"\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020d0c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020#8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u00107R\u0018\u0010r\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010qR(\u0010s\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00030'0U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010WR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010tR\u0014\u0010w\u001a\u00020#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bu\u0010v\u00a8\u0006}"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasNativePagView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Li01/c;", "", "B0", "o0", "Lkotlin/Function0;", "block", "h0", "", "src", "z0", "k0", "A0", "", "v0", "", "propValue", "x0", "u0", "y0", "path", "w0", "Lorg/libpag/PAGFile;", "pagFile", "s0", "r0", "t0", "q0", "m0", "p0", "g0", "j0", "C0", "propKey", "", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "success", "n0", "Landroid/content/Context;", "filePostfix", "Ljava/io/File;", "resultBlock", "i0", "H", "Z", "autoPlay", "I", "srcSourceReady", "", "J", "scaleType", "Lorg/libpag/PAGView;", "K", "Lorg/libpag/PAGView;", "pagView", "Lorg/libpag/PAGView$PAGViewListener;", "L", "Lorg/libpag/PAGView$PAGViewListener;", "pagAnimationListener", "M", "Lkotlin/jvm/functions/Function1;", "animationStartCallback", "N", "animationEndCallback", "P", "animationCancelCallback", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "animationRepeatCallback", BdhLogUtil.LogTag.Tag_Req, "loadFailureCallback", ExifInterface.LATITUDE_SOUTH, "loadSuccessCallback", "T", "hadCallLoadFail", "", "U", "Ljava/util/List;", "replaceImageTagList", "V", "replaceImagePathList", "W", "replaceTextList", "a0", "replaceFontList", "b0", "mSrcList", "c0", "mPagList", "", "Lorg/libpag/PAGFont;", "d0", "Ljava/util/Map;", "mFontMap", "e0", "Lorg/libpag/PAGFile;", "mPagFile", "Lcom/tencent/mobileqq/vas/kuikly/VasNativePagView$ECPagSoLoader;", "f0", "Lcom/tencent/mobileqq/vas/kuikly/VasNativePagView$ECPagSoLoader;", "pagSoLoader", "pagSoLoadSuccess", "Lcom/tencent/mobileqq/vas/kuikly/a;", "Lcom/tencent/mobileqq/vas/kuikly/a;", "pagSoLoadResultCallback", "pagSoDownloadCallbackList", "Ljava/lang/String;", "k", "()Z", "reusable", "context", "<init>", "(Landroid/content/Context;)V", "a", "ECPagSoLoader", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasNativePagView extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean srcSourceReady;

    /* renamed from: J, reason: from kotlin metadata */
    private int scaleType;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private PAGView pagView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private PAGView.PAGViewListener pagAnimationListener;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> animationStartCallback;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> animationEndCallback;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> animationCancelCallback;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> animationRepeatCallback;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> loadFailureCallback;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> loadSuccessCallback;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean hadCallLoadFail;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private List<String> replaceImageTagList;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private List<String> replaceImagePathList;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private List<String> replaceTextList;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> replaceFontList;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> mSrcList;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<PAGFile> mPagList;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, PAGFont> mFontMap;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGFile mPagFile;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ECPagSoLoader pagSoLoader;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final boolean pagSoLoadSuccess;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a pagSoLoadResultCallback;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Function1<Boolean, Unit>> pagSoDownloadCallbackList;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String src;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\b\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00050\u0004R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasNativePagView$ECPagSoLoader;", "", "", "c", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function1;", "", "resultBlock", "d", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "uiHandler", "<init>", "()V", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class ECPagSoLoader {

        /* renamed from: c, reason: collision with root package name */
        private static boolean f309703c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f309704d;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Handler uiHandler = new Handler(Looper.getMainLooper());

        public final void c() {
            if (f309703c) {
                return;
            }
            f309703c = true;
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().downloadPagSo();
        }

        public final void d(@NotNull WeakReference<Function1<Boolean, Unit>> resultBlock) {
            Intrinsics.checkNotNullParameter(resultBlock, "resultBlock");
            if (f309704d) {
                Function1<Boolean, Unit> function1 = resultBlock.get();
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                    return;
                }
                return;
            }
            QLog.i("HRPAGView", 1, "start load pag so");
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader().loadPagSoAsync(new VasNativePagView$ECPagSoLoader$loadPagSoAsync$1(resultBlock, this));
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007R4\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u00060\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasNativePagView$b;", "", "", "filePath", "", "b", "Lkotlin/Function1;", "Ljava/io/File;", "", "resultBlock", "c", "file", "a", "Landroid/util/ArrayMap;", "", "Landroid/util/ArrayMap;", "downloadingMap", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f309706a = new b();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final ArrayMap<String, List<Function1<File, Unit>>> downloadingMap = new ArrayMap<>();

        b() {
        }

        public final void a(@NotNull String filePath, @Nullable File file) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            synchronized (this) {
                List<Function1<File, Unit>> remove = downloadingMap.remove(filePath);
                if (remove != null) {
                    Intrinsics.checkNotNullExpressionValue(remove, "remove(filePath)");
                    Iterator<T> it = remove.iterator();
                    while (it.hasNext()) {
                        ((Function1) it.next()).invoke(file);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final boolean b(@NotNull String filePath) {
            boolean z16;
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            synchronized (this) {
                List<Function1<File, Unit>> list = downloadingMap.get(filePath);
                if (list != null) {
                    Intrinsics.checkNotNullExpressionValue(list, "downloadingMap[filePath]");
                    z16 = !list.isEmpty();
                } else {
                    z16 = false;
                }
            }
            return z16;
        }

        public final void c(@NotNull String filePath, @NotNull Function1<? super File, Unit> resultBlock) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(resultBlock, "resultBlock");
            synchronized (this) {
                ArrayMap<String, List<Function1<File, Unit>>> arrayMap = downloadingMap;
                List<Function1<File, Unit>> list = arrayMap.get(filePath);
                if (list == null) {
                    list = new ArrayList<>();
                    arrayMap.put(filePath, list);
                }
                Intrinsics.checkNotNullExpressionValue(list, "downloadingMap[filePath]\u2026 = this\n                }");
                list.add(resultBlock);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasNativePagView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.autoPlay = true;
        this.scaleType = 2;
        this.replaceImageTagList = new ArrayList();
        this.replaceImagePathList = new ArrayList();
        this.replaceTextList = new ArrayList();
        this.replaceFontList = new ArrayList();
        this.mSrcList = new ArrayList();
        this.mPagList = new ArrayList();
        this.mFontMap = new LinkedHashMap();
        this.pagSoLoader = new ECPagSoLoader();
        this.pagSoDownloadCallbackList = new ArrayList();
        this.src = "";
    }

    private final void A0(String src) {
        PAGView pAGView;
        boolean z16 = false;
        this.srcSourceReady = false;
        setVisibility(4);
        PAGView pAGView2 = this.pagView;
        if (pAGView2 != null && pAGView2.isPlaying()) {
            z16 = true;
        }
        if (z16 && (pAGView = this.pagView) != null) {
            pAGView.stop();
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        i0(context, src, ".pag", new VasNativePagView$setSrcWithNetworkUrl$1(this, src));
    }

    private final void B0() {
        h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$stop$1
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
                pAGView = VasNativePagView.this.pagView;
                if (pAGView != null) {
                    pAGView.stop();
                }
            }
        });
    }

    private final String C0(String str) {
        int checkRadix;
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : digest) {
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            String num = Integer.toString(b16 & 255, checkRadix);
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            if (num.length() == 1) {
                sb5.append('0');
            }
            sb5.append(num);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply {\n\u2026   }\n        }.toString()");
        return sb6;
    }

    private final void g0() {
        if (this.pagView == null) {
            this.pagView = new PAGView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            PAGView pAGView = this.pagView;
            Intrinsics.checkNotNull(pAGView);
            pAGView.setLayoutParams(layoutParams);
            addView(this.pagView);
            QLog.i("HRPAGView", 1, "add pag view: " + hashCode());
        }
    }

    private final void h0(final Function0<Unit> block) {
        if (this.pagSoLoadSuccess) {
            g0();
            block.invoke();
            return;
        }
        if (this.pagSoLoadResultCallback == null) {
            this.pagSoLoadResultCallback = new a(this);
        }
        Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$ensurePAGSoReady$callback$1
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
                aVar = VasNativePagView.this.pagSoLoadResultCallback;
                if (aVar != null) {
                    aVar.b(z16, block);
                }
            }
        };
        this.pagSoDownloadCallbackList.add(function1);
        this.pagSoLoader.d(new WeakReference<>(function1));
    }

    private final String j0(String src) {
        String substringAfterLast;
        String substringBefore;
        substringAfterLast = StringsKt__StringsKt.substringAfterLast(src, '/', "");
        substringBefore = StringsKt__StringsKt.substringBefore(substringAfterLast, '.', "");
        return substringBefore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(String src) {
        boolean startsWith$default;
        String replace$default;
        List split$default;
        List<String> mutableList;
        boolean contains$default;
        PAGView pAGView;
        boolean z16 = false;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(src, "pags://", false, 2, null);
        if (startsWith$default) {
            replace$default = StringsKt__StringsJVMKt.replace$default(src, "pags://", "", false, 4, (Object) null);
            split$default = StringsKt__StringsKt.split$default((CharSequence) replace$default, new String[]{"||"}, false, 0, 6, (Object) null);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) split$default);
            this.mSrcList = mutableList;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) src, (CharSequence) "http", false, 2, (Object) null);
            if (contains$default) {
                this.srcSourceReady = false;
                setVisibility(4);
                PAGView pAGView2 = this.pagView;
                if (pAGView2 != null && pAGView2.isPlaying()) {
                    z16 = true;
                }
                if (z16 && (pAGView = this.pagView) != null) {
                    pAGView.stop();
                }
                final ArrayList arrayList = new ArrayList();
                for (String str : this.mSrcList) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    i0(context, str, ".pag", new Function1<File, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$multiSrc$1$1
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
                        public final void invoke2(@Nullable File file) {
                            arrayList.add(String.valueOf(file != null ? file.getAbsolutePath() : null));
                        }
                    });
                }
                post(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        VasNativePagView.l0(VasNativePagView.this);
                    }
                });
                return;
            }
            v0(this.mSrcList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(VasNativePagView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibility(0);
        this$0.v0(this$0.mSrcList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        if (this.pagAnimationListener != null) {
            return;
        }
        c cVar = new c();
        this.pagAnimationListener = cVar;
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.addListener(cVar);
        }
    }

    private final void o0() {
        h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$play$1
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
                pAGView = VasNativePagView.this.pagView;
                if (pAGView != null) {
                    pAGView.play();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0() {
        PAGView pAGView;
        if (this.srcSourceReady && this.autoPlay && (pAGView = this.pagView) != null) {
            Intrinsics.checkNotNull(pAGView);
            if (!pAGView.isPlaying()) {
                QLog.i("HRPAGView", 1, "start play pag: " + hashCode());
                PAGView pAGView2 = this.pagView;
                Intrinsics.checkNotNull(pAGView2);
                pAGView2.play();
            }
        }
    }

    private final void q0(PAGFile pagFile) {
        List split$default;
        String str;
        boolean z16;
        boolean z17;
        if (this.replaceFontList.isEmpty()) {
            return;
        }
        Iterator<T> it = this.replaceFontList.iterator();
        while (it.hasNext()) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{"&&"}, false, 0, 6, (Object) null);
            if (split$default.size() == 3) {
                String str2 = (String) split$default.get(0);
                int parseInt = Integer.parseInt((String) split$default.get(1));
                int parseInt2 = Integer.parseInt((String) split$default.get(2));
                if (split$default.size() > 3) {
                    str = (String) split$default.get(3);
                } else {
                    str = "";
                }
                if (parseInt > 0 && this.mPagList.size() > parseInt) {
                    PAGFile pAGFile = this.mPagList.get(parseInt);
                    if (parseInt2 >= pAGFile.numTexts()) {
                        QLog.i("HRPAGView", 1, "pag file replaceParam error replaceIndex=" + parseInt2 + " numTexts=" + pagFile.numTexts());
                    } else {
                        PAGText textData = pAGFile.getTextData(parseInt2);
                        PAGFont pagFont = PAGFont.RegisterFont(str2);
                        if (str.length() > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            pagFont.fontStyle = str;
                        }
                        Intrinsics.checkNotNullExpressionValue(pagFont, "pagFont");
                        this.mFontMap.put(parseInt + "||" + parseInt2, pagFont);
                        String str3 = pagFont.fontFamily;
                        textData.fontFamily = str3;
                        textData.fontStyle = pagFont.fontStyle;
                        QLog.i("HRPAGView", 1, "replaceFont: " + str3);
                        pAGFile.replaceText(parseInt2, textData);
                    }
                } else if (parseInt2 >= pagFile.numTexts()) {
                    QLog.i("HRPAGView", 1, "pag file replaceParam error replaceIndex=" + parseInt2 + " numTexts=" + pagFile.numTexts());
                } else {
                    PAGText textData2 = pagFile.getTextData(parseInt2);
                    PAGFont pagFont2 = PAGFont.RegisterFont(str2);
                    if (str.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        pagFont2.fontStyle = str;
                    }
                    Intrinsics.checkNotNullExpressionValue(pagFont2, "pagFont");
                    this.mFontMap.put(parseInt + "||" + parseInt2, pagFont2);
                    String str4 = pagFont2.fontFamily;
                    textData2.fontFamily = str4;
                    textData2.fontStyle = pagFont2.fontStyle;
                    QLog.i("HRPAGView", 1, "replaceFont: " + str4);
                    pagFile.replaceText(parseInt2, textData2);
                }
            }
        }
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setComposition(pagFile);
        }
    }

    private final void r0(PAGFile pagFile) {
        List split$default;
        Bitmap bitmap;
        com.tencent.kuikly.core.render.android.expand.module.j jVar;
        if (this.replaceImageTagList.isEmpty()) {
            return;
        }
        Iterator<T> it = this.replaceImageTagList.iterator();
        while (it.hasNext()) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{"&&"}, false, 0, 6, (Object) null);
            if (split$default.size() == 3) {
                String str = (String) split$default.get(0);
                int parseInt = Integer.parseInt((String) split$default.get(1));
                int parseInt2 = Integer.parseInt((String) split$default.get(2));
                com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
                Bitmap bitmap2 = null;
                if (aVar != null && (jVar = (com.tencent.kuikly.core.render.android.expand.module.j) aVar.a("KRMemoryCacheModule")) != null) {
                    bitmap = (Bitmap) jVar.g(str);
                } else {
                    bitmap = null;
                }
                if (bitmap instanceof Bitmap) {
                    bitmap2 = bitmap;
                }
                if (parseInt > 0 && this.mPagList.size() > parseInt) {
                    PAGFile pAGFile = this.mPagList.get(parseInt);
                    if (parseInt2 >= pAGFile.numImages()) {
                        QLog.i("HRPAGView", 1, "pag file replaceParam error imageTag=" + str + " replaceIndex=" + parseInt2 + " numImages=" + pagFile.numImages());
                    } else {
                        pAGFile.replaceImage(parseInt2, PAGImage.FromBitmap(bitmap2));
                    }
                } else if (bitmap2 != null && parseInt2 < pagFile.numImages()) {
                    pagFile.replaceImage(parseInt2, PAGImage.FromBitmap(bitmap2));
                } else {
                    QLog.i("HRPAGView", 1, "pag file replaceParam error imageTag=" + str + " replaceIndex=" + parseInt2 + " numImages=" + pagFile.numImages());
                }
            }
        }
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setComposition(pagFile);
        }
    }

    private final void s0(PAGFile pagFile) {
        List split$default;
        if (this.replaceImagePathList.isEmpty()) {
            return;
        }
        Iterator<T> it = this.replaceImagePathList.iterator();
        while (it.hasNext()) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{"&&"}, false, 0, 6, (Object) null);
            if (split$default.size() == 3) {
                boolean z16 = false;
                String str = (String) split$default.get(0);
                int parseInt = Integer.parseInt((String) split$default.get(1));
                int parseInt2 = Integer.parseInt((String) split$default.get(2));
                if (parseInt > 0 && this.mPagList.size() > parseInt) {
                    PAGFile pAGFile = this.mPagList.get(parseInt);
                    if (parseInt2 >= pAGFile.numImages()) {
                        QLog.i("HRPAGView", 1, "pag file replaceParam error imageTag=" + str + " replaceIndex=" + parseInt2 + " numImages=" + pagFile.numImages());
                    } else {
                        pAGFile.replaceImage(parseInt2, PAGImage.FromPath(str));
                    }
                } else {
                    if (str.length() == 0) {
                        z16 = true;
                    }
                    if (!z16 && parseInt2 < pagFile.numImages()) {
                        pagFile.replaceImage(parseInt2, PAGImage.FromPath(str));
                    } else {
                        QLog.i("HRPAGView", 1, "pag file replaceParam error imageTag=" + str + " replaceIndex=" + parseInt2 + " numImages=" + pagFile.numImages());
                    }
                }
            }
        }
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setComposition(pagFile);
        }
    }

    private final void t0(PAGFile pagFile) {
        List split$default;
        if (this.replaceTextList.isEmpty()) {
            return;
        }
        Iterator<T> it = this.replaceTextList.iterator();
        while (it.hasNext()) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{"&&"}, false, 0, 6, (Object) null);
            if (split$default.size() == 3) {
                String str = (String) split$default.get(0);
                int parseInt = Integer.parseInt((String) split$default.get(1));
                int parseInt2 = Integer.parseInt((String) split$default.get(2));
                if (parseInt > 0 && this.mPagList.size() > parseInt) {
                    PAGFile pAGFile = this.mPagList.get(parseInt);
                    if (parseInt2 >= pAGFile.numTexts()) {
                        QLog.i("HRPAGView", 1, "pag file replaceParam error replaceIndex=" + parseInt2 + " numTexts=" + pagFile.numTexts());
                    } else {
                        PAGText textData = pAGFile.getTextData(parseInt2);
                        textData.text = str;
                        PAGFont pAGFont = this.mFontMap.get(parseInt + "||" + parseInt2);
                        if (pAGFont != null) {
                            textData.fontFamily = pAGFont.fontFamily;
                            textData.fontStyle = pAGFont.fontStyle;
                        }
                        QLog.i("HRPAGView", 1, "replaceText: " + textData.text);
                        pAGFile.replaceText(parseInt2, textData);
                    }
                } else if (parseInt2 >= pagFile.numTexts()) {
                    QLog.i("HRPAGView", 1, "pag file replaceParam error replaceIndex=" + parseInt2 + " numTexts=" + pagFile.numTexts());
                } else {
                    PAGText textData2 = pagFile.getTextData(parseInt2);
                    textData2.text = str;
                    PAGFont pAGFont2 = this.mFontMap.get(parseInt + "||" + parseInt2);
                    if (pAGFont2 != null) {
                        textData2.fontFamily = pAGFont2.fontFamily;
                        textData2.fontStyle = pAGFont2.fontStyle;
                    }
                    QLog.i("HRPAGView", 1, "replaceText: " + textData2.text);
                    pagFile.replaceText(parseInt2, textData2);
                }
            }
        }
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setComposition(pagFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Int");
        boolean z16 = true;
        if (((Integer) propValue).intValue() != 1) {
            z16 = false;
        }
        this.autoPlay = z16;
        p0();
    }

    private final void v0(List<String> src) {
        Map emptyMap;
        Map emptyMap2;
        if (src.isEmpty()) {
            Function1<Object, Unit> function1 = this.loadFailureCallback;
            if (function1 != null) {
                emptyMap2 = MapsKt__MapsKt.emptyMap();
                function1.invoke(emptyMap2);
            }
            QLog.e("HRPAGView", 1, "multiSrc set fail, src is empty");
            return;
        }
        int i3 = 0;
        for (Object obj : src) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if (i3 == 0) {
                PAGFile pagLayer = PagViewMonitor.Load(str);
                this.mPagFile = pagLayer;
                List<PAGFile> list = this.mPagList;
                Intrinsics.checkNotNullExpressionValue(pagLayer, "pagLayer");
                list.add(pagLayer);
            } else {
                PAGFile Load = PagViewMonitor.Load(str);
                if (Load != null) {
                    PAGFile pAGFile = this.mPagFile;
                    if (pAGFile != null) {
                        pAGFile.addLayer(Load);
                    }
                    this.mPagList.add(Load);
                }
            }
            i3 = i16;
        }
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setComposition(this.mPagFile);
        }
        this.srcSourceReady = true;
        Function1<Object, Unit> function12 = this.loadSuccessCallback;
        if (function12 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function12.invoke(emptyMap);
        }
        p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(String path) {
        Map emptyMap;
        this.mPagFile = PagViewMonitor.Load(path);
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setPath(path);
        }
        Function1<Object, Unit> function1 = this.loadSuccessCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(Object propValue) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Int");
            pAGView.setRepeatCount(((Integer) propValue).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) propValue).intValue();
        this.scaleType = intValue;
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setScaleMode(intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(String src) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean contains$default;
        if (Intrinsics.areEqual(this.src, src)) {
            return;
        }
        this.src = src;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(src, "/", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(src, "qecommerce", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(src, "ecommerce", false, 2, null);
                if (!startsWith$default3) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) src, (CharSequence) "http", false, 2, (Object) null);
                    if (contains$default) {
                        A0(src);
                        return;
                    }
                    return;
                }
            }
            w0("assets://pag/" + src + ".pag");
            this.srcSourceReady = true;
            p0();
            return;
        }
        w0(src);
        this.srcSourceReady = true;
        p0();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(@NotNull String propKey, @NotNull final Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1877911644:
                if (propKey.equals("scaleType")) {
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$5
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
                            VasNativePagView.this.y0(propValue);
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    this.loadFailureCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$10
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
                return super.b(propKey, propValue);
            case -1458222274:
                if (propKey.equals("animationStart")) {
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$6
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
                            VasNativePagView vasNativePagView = VasNativePagView.this;
                            Object obj = propValue;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
                            vasNativePagView.animationStartCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                            VasNativePagView.this.m0();
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 114148:
                if (propKey.equals("src")) {
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$1
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
                            VasNativePagView vasNativePagView = VasNativePagView.this;
                            Object obj = propValue;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            vasNativePagView.z0((String) obj);
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 653801963:
                if (propKey.equals("multiSrc")) {
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$2
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
                            VasNativePagView vasNativePagView = VasNativePagView.this;
                            Object obj = propValue;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            vasNativePagView.k0((String) obj);
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 1173886647:
                if (propKey.equals("animationEnd")) {
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$8
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
                            VasNativePagView vasNativePagView = VasNativePagView.this;
                            Object obj = propValue;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
                            vasNativePagView.animationEndCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                            VasNativePagView.this.m0();
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 1438608771:
                if (propKey.equals("autoPlay")) {
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$4
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
                            VasNativePagView.this.u0(propValue);
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 1564508958:
                if (propKey.equals("animationCancel")) {
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$7
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
                            VasNativePagView vasNativePagView = VasNativePagView.this;
                            Object obj = propValue;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
                            vasNativePagView.animationCancelCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                            VasNativePagView.this.m0();
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 1571519540:
                if (propKey.equals("repeatCount")) {
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$3
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
                            VasNativePagView.this.x0(propValue);
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 1915020349:
                if (propKey.equals("loadSuccess")) {
                    this.loadSuccessCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$11
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
                            Function1 function1;
                            Map emptyMap;
                            function1 = VasNativePagView.this.loadSuccessCallback;
                            if (function1 != null) {
                                emptyMap = MapsKt__MapsKt.emptyMap();
                                function1.invoke(emptyMap);
                            }
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            case 1997701695:
                if (propKey.equals("animationRepeat")) {
                    h0(new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$setProp$9
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
                            VasNativePagView vasNativePagView = VasNativePagView.this;
                            Object obj = propValue;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
                            vasNativePagView.animationRepeatCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                            VasNativePagView.this.m0();
                        }
                    });
                    return true;
                }
                return super.b(propKey, propValue);
            default:
                return super.b(propKey, propValue);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000f. Please report as an issue. */
    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(method, "method");
        Long l3 = null;
        switch (method.hashCode()) {
            case -1754283261:
                if (method.equals("replaceImageByPath")) {
                    if (this.mPagFile != null) {
                        this.replaceImagePathList.add(String.valueOf(params));
                        PAGFile pAGFile = this.mPagFile;
                        Intrinsics.checkNotNull(pAGFile);
                        s0(pAGFile);
                    } else {
                        QLog.e("HRPAGView", 1, "replaceImageByPathError");
                    }
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -349798637:
                if (method.equals("replaceImageTag")) {
                    if (this.mPagFile != null) {
                        this.replaceImageTagList.add(String.valueOf(params));
                        PAGFile pAGFile2 = this.mPagFile;
                        Intrinsics.checkNotNull(pAGFile2);
                        r0(pAGFile2);
                    } else {
                        QLog.e("HRPAGView", 1, "replaceImageTagError");
                    }
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 3443508:
                if (method.equals("play")) {
                    o0();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 3540994:
                if (method.equals("stop")) {
                    B0();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 85887754:
                if (method.equals("getDuration")) {
                    if (callback == null) {
                        return null;
                    }
                    PAGView pAGView = this.pagView;
                    if (pAGView != null) {
                        l3 = Long.valueOf(pAGView.duration());
                    }
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("duration", l3));
                    callback.invoke(mapOf);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 429766947:
                if (method.equals("replaceFont")) {
                    if (this.mPagFile != null) {
                        this.replaceFontList.add(String.valueOf(params));
                        PAGFile pAGFile3 = this.mPagFile;
                        Intrinsics.checkNotNull(pAGFile3);
                        q0(pAGFile3);
                    } else {
                        QLog.e("HRPAGView", 1, "replaceFontError");
                    }
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 430174721:
                if (method.equals(HippyQQPagView.FunctionName.REPLACE_TEXT)) {
                    if (this.mPagFile != null) {
                        this.replaceTextList.add(String.valueOf(params));
                        PAGFile pAGFile4 = this.mPagFile;
                        Intrinsics.checkNotNull(pAGFile4);
                        t0(pAGFile4);
                    } else {
                        QLog.e("HRPAGView", 1, "replaceTextError");
                    }
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 988242095:
                if (method.equals(HippyQQPagView.FunctionName.SET_PROGRESS)) {
                    PAGView pAGView2 = this.pagView;
                    if (pAGView2 == null) {
                        return null;
                    }
                    Intrinsics.checkNotNull(params);
                    pAGView2.setProgress(Double.parseDouble(params));
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1076821923:
                if (method.equals(HippyQQPagView.FunctionName.GET_PROGRESS)) {
                    PAGView pAGView3 = this.pagView;
                    if (pAGView3 == null || callback == null) {
                        return null;
                    }
                    callback.invoke(String.valueOf(pAGView3.getProgress()));
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    public final void i0(@NotNull Context context, @NotNull String src, @NotNull String filePostfix, @NotNull Function1<? super File, Unit> resultBlock) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(filePostfix, "filePostfix");
        Intrinsics.checkNotNullParameter(resultBlock, "resultBlock");
        final String str = context.getFilesDir().getAbsolutePath() + "/ec_resource/" + j0(src) + "/" + C0(src) + filePostfix;
        final File file = new File(str);
        try {
            if (file.exists()) {
                b bVar = b.f309706a;
                if (bVar.b(str)) {
                    bVar.c(str, resultBlock);
                    return;
                } else {
                    resultBlock.invoke(file);
                    return;
                }
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
            b.f309706a.c(str, resultBlock);
            IECHttpDownloader httpDownloader = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getHttpDownloader();
            if (httpDownloader != null) {
                httpDownloader.downloadFileAsync(src, file, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.VasNativePagView$fetchResourceFile$2
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
                        if (z16) {
                            VasNativePagView.b.f309706a.a(str, file);
                        } else {
                            file.delete();
                            VasNativePagView.b.f309706a.a(str, null);
                        }
                    }
                });
            }
        } catch (Throwable th5) {
            QLog.i("fetchResourceFile", 1, "fetchResourceFile error: " + th5);
            file.deleteOnExit();
            resultBlock.invoke(null);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    public final void n0(boolean success, @NotNull Function0<Unit> block) {
        Function1<Object, Unit> function1;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(block, "block");
        if (success) {
            g0();
            block.invoke();
        } else if (!this.hadCallLoadFail && (function1 = this.loadFailureCallback) != null) {
            Intrinsics.checkNotNull(function1);
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
            this.hadCallLoadFail = true;
            this.pagSoLoader.c();
        }
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/kuikly/VasNativePagView$c", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements PAGView.PAGViewListener {
        c() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
            Map emptyMap;
            Function1 function1 = VasNativePagView.this.animationCancelCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                function1.invoke(emptyMap);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            Map emptyMap;
            Function1 function1 = VasNativePagView.this.animationEndCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                function1.invoke(emptyMap);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
            Map emptyMap;
            Function1 function1 = VasNativePagView.this.animationRepeatCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                function1.invoke(emptyMap);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView p06) {
            Map emptyMap;
            Function1 function1 = VasNativePagView.this.animationStartCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                function1.invoke(emptyMap);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
        }
    }
}
