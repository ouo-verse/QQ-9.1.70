package com.tencent.ecommerce.biz.hr.component;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ecommerce.biz.hr.ktx.HRResourceExtKt;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.kuikly.core.render.android.expand.component.KRImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\u00020\u0001:\u0001GB\u000f\u0012\u0006\u0010C\u001a\u00020B\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR;\u0010)\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"j\u0004\u0018\u0001`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R;\u0010+\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"j\u0004\u0018\u0001`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R;\u0010-\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"j\u0004\u0018\u0001`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R;\u0010/\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"j\u0004\u0018\u0001`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u0004\u0018\u00010;8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010A\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010@\u00a8\u0006H"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRAPNGView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRImageView;", "", "propValue", "", "H0", "", "filePath", "F0", "G0", "I0", "C0", "D0", "A0", "B0", "propKey", "", "b", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "Lcom/tencent/image/URLDrawable;", "P", "Lcom/tencent/image/URLDrawable;", "apngDrawable", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "repeatCount", BdhLogUtil.LogTag.Tag_Req, "Z", "autoPlay", ExifInterface.LATITUDE_SOUTH, QzoneWebMusicJsPlugin.EVENT_PLAYING, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "T", "Lkotlin/jvm/functions/Function1;", "animationStartCallback", "U", "animationEndCallback", "V", "animationRepeatCallback", "W", "loadFailureCallback", "Lkotlin/Function0;", "a0", "Lkotlin/jvm/functions/Function0;", "loadApngDrawableLazyTask", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "b0", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "apnListener", "c0", "Ljava/lang/String;", "src", "Lcom/tencent/image/ApngImage;", "E0", "()Lcom/tencent/image/ApngImage;", "apnImage", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "d0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRAPNGView extends KRImageView {

    /* renamed from: P, reason: from kotlin metadata */
    private URLDrawable apngDrawable;

    /* renamed from: Q, reason: from kotlin metadata */
    private int repeatCount;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean autoPlay;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean playing;

    /* renamed from: T, reason: from kotlin metadata */
    private Function1<Object, Unit> animationStartCallback;

    /* renamed from: U, reason: from kotlin metadata */
    private Function1<Object, Unit> animationEndCallback;

    /* renamed from: V, reason: from kotlin metadata */
    private Function1<Object, Unit> animationRepeatCallback;

    /* renamed from: W, reason: from kotlin metadata */
    private Function1<Object, Unit> loadFailureCallback;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> loadApngDrawableLazyTask;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ApngDrawable.OnPlayRepeatListener apnListener;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String src;

    public HRAPNGView(Context context) {
        super(context);
        this.repeatCount = 1;
        this.autoPlay = true;
        this.src = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0() {
        Map emptyMap;
        Function1<Object, Unit> function1 = this.animationEndCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
        cg0.a.b("HRAPNGView", "onApng End: " + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0() {
        Map emptyMap;
        Function1<Object, Unit> function1 = this.animationRepeatCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    private final void C0() {
        Map emptyMap;
        Function1<Object, Unit> function1 = this.animationStartCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0() {
        Map emptyMap;
        Function1<Object, Unit> function1 = this.loadFailureCallback;
        if (function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApngImage E0() {
        URLDrawable uRLDrawable = this.apngDrawable;
        Drawable currDrawable = uRLDrawable != null ? uRLDrawable.getCurrDrawable() : null;
        if (!(currDrawable instanceof ApngDrawable)) {
            currDrawable = null;
        }
        ApngDrawable apngDrawable = (ApngDrawable) currDrawable;
        if (apngDrawable != null) {
            return apngDrawable.getImage();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(final String filePath) {
        int h16 = com.tencent.kuikly.core.render.android.css.ktx.b.h(this);
        int g16 = com.tencent.kuikly.core.render.android.css.ktx.b.g(this);
        if (h16 > 0 && g16 > 0) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseApngImage = true;
            obtain.mRequestWidth = h16;
            obtain.mRequestHeight = g16;
            obtain.mUseMemoryCache = false;
            obtain.mLoadingDrawable = new ColorDrawable(0);
            Bundle bundle = new Bundle();
            bundle.putInt("key_loop", this.repeatCount);
            bundle.putBoolean("key_double_bitmap", true);
            bundle.putString("key_name", filePath);
            Unit unit = Unit.INSTANCE;
            obtain.mExtraInfo = bundle;
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(filePath, obtain);
            this.apngDrawable = fileDrawable;
            if (fileDrawable != null) {
                fileDrawable.setURLDrawableListener(new b());
            }
            URLDrawable uRLDrawable = this.apngDrawable;
            if (uRLDrawable != null) {
                uRLDrawable.startDownload();
                return;
            }
            return;
        }
        this.loadApngDrawableLazyTask = new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRAPNGView$loadApnDrawable$1
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
                HRAPNGView.this.F0(filePath);
            }
        };
        cg0.a.b("HRAPNGView", "loadApnDrawable, size not ready, lazy load task, " + hashCode());
    }

    private final void G0() {
        if (this.loadApngDrawableLazyTask != null && com.tencent.kuikly.core.render.android.css.ktx.b.h(this) > 0 && com.tencent.kuikly.core.render.android.css.ktx.b.g(this) > 0) {
            Function0<Unit> function0 = this.loadApngDrawableLazyTask;
            if (function0 != null) {
                function0.invoke();
            }
            this.loadApngDrawableLazyTask = null;
            cg0.a.b("HRAPNGView", "run load apn drawable lazy task: " + hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0() {
        if (this.playing || !this.autoPlay || E0() == null) {
            return;
        }
        ApngImage E0 = E0();
        if (E0 != null) {
            E0.setSupportGlobalPasued(false);
        }
        C0();
        setImageDrawable(this.apngDrawable);
        this.playing = true;
        cg0.a.b("HRAPNGView", "start play apng: " + hashCode());
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRImageView, i01.c
    public boolean b(String propKey, final Object propValue) {
        switch (propKey.hashCode()) {
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    if (propValue != null) {
                        this.loadFailureCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                }
                break;
            case -1458222274:
                if (propKey.equals("animationStart")) {
                    if (propValue != null) {
                        this.animationStartCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                }
                break;
            case 114148:
                if (propKey.equals("src")) {
                    post(new Runnable() { // from class: com.tencent.ecommerce.biz.hr.component.HRAPNGView$setProp$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            HRAPNGView.this.H0(propValue);
                        }
                    });
                    return true;
                }
                break;
            case 1173886647:
                if (propKey.equals("animationEnd")) {
                    if (propValue != null) {
                        this.animationEndCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                }
                break;
            case 1438608771:
                if (propKey.equals("autoPlay")) {
                    if (propValue != null) {
                        this.autoPlay = ((Integer) propValue).intValue() == 1;
                        I0();
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                break;
            case 1571519540:
                if (propKey.equals("repeatCount")) {
                    if (propValue != null) {
                        this.repeatCount = ((Integer) propValue).intValue();
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                break;
            case 1997701695:
                if (propKey.equals("animationRepeat")) {
                    if (propValue != null) {
                        this.animationRepeatCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
                }
                break;
        }
        return super.b(propKey, propValue);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRImageView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRImageView, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(Object propValue) {
        boolean contains$default;
        if (propValue != null) {
            String str = (String) propValue;
            if (Intrinsics.areEqual(this.src, str)) {
                return;
            }
            this.src = str;
            setImageDrawable(null);
            this.playing = false;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "http", false, 2, (Object) null);
            if (contains$default) {
                HRResourceExtKt.a(getContext(), str, ".png", new Function1<File, Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRAPNGView$setSrc$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        HRAPNGView.this.post(new Runnable() { // from class: com.tencent.ecommerce.biz.hr.component.HRAPNGView$setSrc$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                File file2 = file;
                                if (file2 == null) {
                                    HRAPNGView.this.D0();
                                } else {
                                    HRAPNGView.this.F0(file2.getAbsolutePath());
                                }
                            }
                        });
                    }
                });
                return;
            } else {
                F0(str);
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/hr/component/HRAPNGView$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/hr/component/HRAPNGView$loadApnDrawable$3$onLoadSuccessed$1$1", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "", "count", "", HippyQQPagView.EventName.ON_PLAY_REPEAT, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements ApngDrawable.OnPlayRepeatListener {
            a() {
            }

            @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
            public void onPlayRepeat(int count) {
                HRAPNGView.this.B0();
                if (count == HRAPNGView.this.repeatCount) {
                    HRAPNGView.this.A0();
                    HRAPNGView.this.playing = false;
                }
            }
        }

        b() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("load apn error: ");
            sb5.append(p16 != null ? p16.getMessage() : null);
            sb5.append(", ");
            sb5.append(HRAPNGView.this.hashCode());
            cg0.a.a("HRAPNGView", "loadApnDrawable", sb5.toString());
            HRAPNGView.this.D0();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable p06) {
            cg0.a.b("HRAPNGView", "onApnDrawableLoad: " + HRAPNGView.this.hashCode());
            ApngImage E0 = HRAPNGView.this.E0();
            if (E0 != null) {
                HRAPNGView.this.apnListener = new a();
                E0.setOnPlayRepeatListener(HRAPNGView.this.apnListener);
            }
            HRAPNGView.this.I0();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable p06) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
        }
    }
}
