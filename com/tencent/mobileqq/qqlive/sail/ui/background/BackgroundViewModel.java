package com.tencent.mobileqq.qqlive.sail.ui.background;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.base.coroutine.QQLiveCoroutineScopes;
import com.tencent.mobileqq.qqlive.sail.base.d;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J%\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0006\u0010\u0017\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u001b\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/background/BackgroundViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "", "url", "", "width", "Landroid/graphics/drawable/BitmapDrawable;", "Z1", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "priority", "", "R1", "Lcom/tencent/libra/request/Option;", "option", "Landroid/graphics/Bitmap;", "S1", "(Lcom/tencent/libra/request/Option;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", MimeHelper.IMAGE_SUBTYPE_BITMAP, ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/qqlive/sail/ui/background/a;", "info", "", "Q1", "U1", "T1", "topUrl", "bottomUrl", "W1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_bgDrawableLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "bgDrawableLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class BackgroundViewModel extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Nullable
    private static final Drawable D;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<a> _bgDrawableLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<a> bgDrawableLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/background/BackgroundViewModel$a;", "", "", "BG_PRIORITY_BLUR_COVER", "I", "BG_PRIORITY_DEFAULT", "BG_PRIORITY_ROOM_SKIN", "", "TAG", "Ljava/lang/String;", "Landroid/graphics/drawable/Drawable;", "defaultBgDrawable", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.background.BackgroundViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/background/BackgroundViewModel$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends QCirclePicStateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Bitmap> f272476d;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Bitmap> cancellableContinuation) {
            this.f272476d = cancellableContinuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuation);
            }
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) state, (Object) option);
                return;
            }
            if (this.f272476d.isActive()) {
                boolean z17 = true;
                if (state != null && state.isFinishSuccess()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Bitmap bitmap = null;
                if (z16) {
                    CancellableContinuation<Bitmap> cancellableContinuation = this.f272476d;
                    Result.Companion companion = Result.INSTANCE;
                    if (option != null) {
                        bitmap = option.getResultBitMap();
                    }
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(bitmap));
                    return;
                }
                if (state == null || !state.isFinishError()) {
                    z17 = false;
                }
                if (z17) {
                    this.f272476d.resumeWith(Result.m476constructorimpl(null));
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51483);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            D = ContextCompat.getDrawable(BaseApplication.context, R.drawable.f162530lq0);
        }
    }

    public BackgroundViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<a> mutableLiveData = new MutableLiveData<>();
        this._bgDrawableLiveData = mutableLiveData;
        this.bgDrawableLiveData = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(a info) {
        a value = this._bgDrawableLiveData.getValue();
        if (value != null && value.c() > info.c()) {
            AegisLogger.INSTANCE.i("Audience|BackgroundViewModel", "changeBgDrawable", "current drawable has greater priority, " + value.c() + ">" + info.c());
            return;
        }
        this._bgDrawableLiveData.postValue(info);
    }

    private final boolean R1(int priority) {
        a value = this.bgDrawableLiveData.getValue();
        if (value != null && value.c() >= priority) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object S1(Option option, Continuation<? super Bitmap> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QCircleFeedPicLoader.g().loadImage(option, new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Z1(String str, int i3, Continuation<? super BitmapDrawable> continuation) {
        BackgroundViewModel$getRoomSkinDrawable$1 backgroundViewModel$getRoomSkinDrawable$1;
        Object coroutine_suspended;
        int i16;
        Bitmap bitmap;
        if (continuation instanceof BackgroundViewModel$getRoomSkinDrawable$1) {
            backgroundViewModel$getRoomSkinDrawable$1 = (BackgroundViewModel$getRoomSkinDrawable$1) continuation;
            int i17 = backgroundViewModel$getRoomSkinDrawable$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                backgroundViewModel$getRoomSkinDrawable$1.label = i17 - Integer.MIN_VALUE;
                Object obj = backgroundViewModel$getRoomSkinDrawable$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = backgroundViewModel$getRoomSkinDrawable$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Option option = Option.obtain();
                    option.setUrl(str);
                    option.setRequestWidth(i3);
                    Intrinsics.checkNotNullExpressionValue(option, "option");
                    backgroundViewModel$getRoomSkinDrawable$1.label = 1;
                    obj = S1(option, backgroundViewModel$getRoomSkinDrawable$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                bitmap = (Bitmap) obj;
                if (bitmap == null) {
                    return new BitmapDrawable(BaseApplication.context.getResources(), bitmap);
                }
                return null;
            }
        }
        backgroundViewModel$getRoomSkinDrawable$1 = new BackgroundViewModel$getRoomSkinDrawable$1(this, continuation);
        Object obj2 = backgroundViewModel$getRoomSkinDrawable$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = backgroundViewModel$getRoomSkinDrawable$1.label;
        if (i16 == 0) {
        }
        bitmap = (Bitmap) obj2;
        if (bitmap == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap a2(Bitmap bitmap) {
        if (bitmap == null) {
            AegisLogger.INSTANCE.w("Audience|BackgroundViewModel", "luminanceBitmap", "invalid bitmap");
            return null;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(0.5f, 0.5f, 0.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.set(new float[]{0.75f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.75f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.75f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        ColorMatrix colorMatrix3 = new ColorMatrix();
        colorMatrix3.postConcat(colorMatrix);
        colorMatrix3.postConcat(colorMatrix2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Paint paint = new Paint(1);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix3));
        new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public final void T1(@Nullable String url) {
        boolean z16;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) url);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("Audience|BackgroundViewModel", "fetchBlurBackground", "url=" + url);
        }
        if (url != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(url);
            if (!isBlank) {
                z16 = false;
                if (!z16 && !R1(1)) {
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), QQLiveCoroutineScopes.f270996a.a().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)), null, new BackgroundViewModel$fetchBlurBackground$1(url, this, null), 2, null);
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), QQLiveCoroutineScopes.f270996a.a().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)), null, new BackgroundViewModel$fetchBlurBackground$1(url, this, null), 2, null);
        }
    }

    public final void U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (!R1(2)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), QQLiveCoroutineScopes.f270996a.a().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)), null, new BackgroundViewModel$fetchDefaultBackground$1(this, null), 2, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r5 != false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W1(@Nullable String topUrl, @Nullable String bottomUrl) {
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) topUrl, (Object) bottomUrl);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.i("Audience|BackgroundViewModel", "fetchRoomSkinBackground", "topUrl=" + topUrl + ", bottomUrl=" + bottomUrl);
        }
        boolean z17 = false;
        if (topUrl != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(topUrl);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (bottomUrl != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(bottomUrl);
                    }
                    z17 = true;
                    if (!z17) {
                        if (PadUtil.a(BaseApplication.context) != DeviceType.PHONE) {
                            companion.i("Audience|BackgroundViewModel", "\u4e0d\u662f\u666e\u901a\u8bbe\u5907\uff0c\u4e0d\u5c55\u793a\u80cc\u666f\u76ae\u80a4");
                            return;
                        } else if (!ht3.a.e("qqlive_room_dynamic_bg_enable", true)) {
                            companion.i("Audience|BackgroundViewModel", "\u914d\u7f6e\u5173\u95ed");
                            return;
                        } else {
                            if (!R1(2)) {
                                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), QQLiveCoroutineScopes.f270996a.a().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)), null, new BackgroundViewModel$fetchRoomSkinBackground$1(this, topUrl, bottomUrl, null), 2, null);
                                return;
                            }
                            return;
                        }
                    }
                }
                companion.w("Audience|BackgroundViewModel", "fetchRoomSkinBackground", "invalid url, top=" + topUrl + ", bottom=" + bottomUrl);
            }
        }
        z16 = true;
        if (!z16) {
        }
        companion.w("Audience|BackgroundViewModel", "fetchRoomSkinBackground", "invalid url, top=" + topUrl + ", bottom=" + bottomUrl);
    }

    @NotNull
    public final LiveData<a> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bgDrawableLiveData;
    }
}
