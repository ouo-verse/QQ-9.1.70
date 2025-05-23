package com.tencent.robot.adelie.homepage.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.opr.helper.sr.SuperResolutionHelper;
import com.tencent.mobileqq.opr.helper.sr.model.SrStatus;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.homepage.utils.CommonExKt$superResolutionSafely$1$1", f = "CommonEx.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class CommonExKt$superResolutionSafely$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ WeakReference<ImageView> $imageViewRef;
    final /* synthetic */ boolean $keepSize;
    final /* synthetic */ String $localPath;
    final /* synthetic */ String $logTag;
    final /* synthetic */ Option $option;
    final /* synthetic */ String $optionUrl;
    final /* synthetic */ SuperResolutionHelper $srHelper;
    final /* synthetic */ WeakReference<Function3<Boolean, Long, String, Unit>> $superResolutionListenerRef;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonExKt$superResolutionSafely$1$1(SuperResolutionHelper superResolutionHelper, String str, boolean z16, String str2, Bitmap bitmap, WeakReference<ImageView> weakReference, String str3, String str4, Option option, WeakReference<Function3<Boolean, Long, String, Unit>> weakReference2, Continuation<? super CommonExKt$superResolutionSafely$1$1> continuation) {
        super(2, continuation);
        this.$srHelper = superResolutionHelper;
        this.$url = str;
        this.$keepSize = z16;
        this.$localPath = str2;
        this.$bitmap = bitmap;
        this.$imageViewRef = weakReference;
        this.$logTag = str3;
        this.$optionUrl = str4;
        this.$option = option;
        this.$superResolutionListenerRef = weakReference2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommonExKt$superResolutionSafely$1$1(this.$srHelper, this.$url, this.$keepSize, this.$localPath, this.$bitmap, this.$imageViewRef, this.$logTag, this.$optionUrl, this.$option, this.$superResolutionListenerRef, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SuperResolutionHelper superResolutionHelper = this.$srHelper;
            String str = this.$url;
            boolean z16 = this.$keepSize;
            String str2 = this.$localPath;
            Bitmap bitmap = this.$bitmap;
            this.label = 1;
            obj = superResolutionHelper.v(str, z16, str2, bitmap, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        com.tencent.mobileqq.opr.helper.sr.model.d dVar = (com.tencent.mobileqq.opr.helper.sr.model.d) obj;
        ImageView imageView = this.$imageViewRef.get();
        if (imageView == null) {
            return Unit.INSTANCE;
        }
        String str3 = (String) imageView.getTag(R.id.xix);
        QLog.i(this.$logTag, 1, "showImage get superResolution result:" + dVar + " for optionUrl:" + this.$optionUrl + ", currentUrl:" + str3);
        if (dVar.b().getSuccess() && dVar.a() != null && Intrinsics.areEqual(str3, this.$option.getUrl())) {
            CommonExKt.f(imageView, dVar.a(), new BitmapDrawable(this.$bitmap), null, null, 12, null);
            Function3<Boolean, Long, String, Unit> function3 = this.$superResolutionListenerRef.get();
            if (function3 != null) {
                function3.invoke(Boxing.boxBoolean(true), Boxing.boxLong(SrStatus.Success.getErrorCode()), "");
            }
        } else {
            Function3<Boolean, Long, String, Unit> function32 = this.$superResolutionListenerRef.get();
            if (function32 != null) {
                function32.invoke(Boxing.boxBoolean(false), Boxing.boxLong(dVar.b().getErrorCode()), dVar.b().getErrorMessage());
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CommonExKt$superResolutionSafely$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
