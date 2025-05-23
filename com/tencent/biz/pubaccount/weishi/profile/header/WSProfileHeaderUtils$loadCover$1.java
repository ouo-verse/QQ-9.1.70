package com.tencent.biz.pubaccount.weishi.profile.header;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import java.net.URL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.pubaccount.weishi.profile.header.WSProfileHeaderUtils$loadCover$1", f = "WSProfileHeaderUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class WSProfileHeaderUtils$loadCover$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ WeakReference<KandianUrlImageView> $ivCoverRef;
    final /* synthetic */ WeakReference<ColorDrawable> $placeHolderDrawableRef;
    final /* synthetic */ String $url;
    final /* synthetic */ int $width;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSProfileHeaderUtils$loadCover$1(WeakReference<KandianUrlImageView> weakReference, String str, int i3, int i16, WeakReference<ColorDrawable> weakReference2, Continuation<? super WSProfileHeaderUtils$loadCover$1> continuation) {
        super(2, continuation);
        this.$ivCoverRef = weakReference;
        this.$url = str;
        this.$width = i3;
        this.$height = i16;
        this.$placeHolderDrawableRef = weakReference2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WSProfileHeaderUtils$loadCover$1 wSProfileHeaderUtils$loadCover$1 = new WSProfileHeaderUtils$loadCover$1(this.$ivCoverRef, this.$url, this.$width, this.$height, this.$placeHolderDrawableRef, continuation);
        wSProfileHeaderUtils$loadCover$1.L$0 = obj;
        return wSProfileHeaderUtils$loadCover$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.$ivCoverRef.get() == null) {
                return Unit.INSTANCE;
            }
            WSPicLoader g16 = WSPicLoader.g();
            String str = this.$url;
            final int i3 = this.$width;
            final int i16 = this.$height;
            final WeakReference<KandianUrlImageView> weakReference = this.$ivCoverRef;
            final WeakReference<ColorDrawable> weakReference2 = this.$placeHolderDrawableRef;
            g16.d(str, i3, i16, new com.tencent.biz.pubaccount.weishi.image.b() { // from class: com.tencent.biz.pubaccount.weishi.profile.header.WSProfileHeaderUtils$loadCover$1.1
                @Override // iy.a
                public void a(URL url, Object closeableBitmap) {
                    Bitmap bitmap;
                    com.tencent.mobileqq.kandian.base.image.imageloader.a aVar = closeableBitmap instanceof com.tencent.mobileqq.kandian.base.image.imageloader.a ? (com.tencent.mobileqq.kandian.base.image.imageloader.a) closeableBitmap : null;
                    if (aVar == null || (bitmap = aVar.get()) == null) {
                        return;
                    }
                    WeakReference<KandianUrlImageView> weakReference3 = weakReference;
                    int i17 = i3;
                    int i18 = i16;
                    CoroutineScope coroutineScope2 = coroutineScope;
                    if (weakReference3.get() != null) {
                        CorountineFunKt.e(coroutineScope2, null, Boolean.TRUE, null, null, new WSProfileHeaderUtils$loadCover$1$1$onLoadSuccessed$1$1$1(weakReference3, com.tencent.biz.qqstory.utils.b.n(bitmap, i17, i18, false), null), 13, null);
                    }
                }

                @Override // com.tencent.biz.pubaccount.weishi.image.b, iy.a
                public void c(URL url, Throwable var3) {
                    super.c(url, var3);
                    CorountineFunKt.e(coroutineScope, null, Boolean.TRUE, null, null, new WSProfileHeaderUtils$loadCover$1$1$onLoadFailed$1(weakReference2, weakReference, null), 13, null);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WSProfileHeaderUtils$loadCover$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
