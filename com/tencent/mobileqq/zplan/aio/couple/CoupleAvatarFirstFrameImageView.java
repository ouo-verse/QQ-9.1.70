package com.tencent.mobileqq.zplan.aio.couple;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.common.model.AppTheme;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B5\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarFirstFrameImageView;", "Landroid/widget/ImageView;", "Lcom/tencent/zplan/common/model/AppTheme;", "b", "Landroid/graphics/drawable/Drawable;", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "", "d", "Ljava/lang/String;", "getPeerUin", "()Ljava/lang/String;", "peerUin", "e", "I", "getViewWidth", "()I", "viewWidth", "f", "getViewHeight", "viewHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Ljava/lang/String;IILandroid/content/Context;Landroid/util/AttributeSet;)V", tl.h.F, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CoupleAvatarFirstFrameImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String peerUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int viewWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int viewHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarFirstFrameImageView$1", f = "CoupleAvatarFirstFrameImageView.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarFirstFrameImageView$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            CoupleAvatarFirstFrameImageView coupleAvatarFirstFrameImageView;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                CoupleAvatarFirstFrameImageView coupleAvatarFirstFrameImageView2 = CoupleAvatarFirstFrameImageView.this;
                this.L$0 = coupleAvatarFirstFrameImageView2;
                this.label = 1;
                Object c16 = coupleAvatarFirstFrameImageView2.c(this);
                if (c16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coupleAvatarFirstFrameImageView = coupleAvatarFirstFrameImageView2;
                obj = c16;
            } else if (i3 == 1) {
                coupleAvatarFirstFrameImageView = (CoupleAvatarFirstFrameImageView) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coupleAvatarFirstFrameImageView.setImageDrawable((Drawable) obj);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ CoupleAvatarFirstFrameImageView(String str, int i3, int i16, Context context, AttributeSet attributeSet, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i16, context, (i17 & 16) != 0 ? null : attributeSet);
    }

    private final AppTheme b() {
        if (QQTheme.isNowThemeIsNight()) {
            return AppTheme.NIGHT;
        }
        return AppTheme.DAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(Continuation<? super Drawable> continuation) {
        CoupleAvatarFirstFrameImageView$getFirstFrameDrawable$1 coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1;
        Object coroutine_suspended;
        int i3;
        URLDrawable.URLDrawableOptions obtain;
        CoupleAvatarFirstFrameImageView coupleAvatarFirstFrameImageView;
        String str;
        if (continuation instanceof CoupleAvatarFirstFrameImageView$getFirstFrameDrawable$1) {
            coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1 = (CoupleAvatarFirstFrameImageView$getFirstFrameDrawable$1) continuation;
            int i16 = coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.label = i16 - Integer.MIN_VALUE;
                Object obj = coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    obtain = URLDrawable.URLDrawableOptions.obtain();
                    Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
                    obtain.mLoadingDrawable = TRANSPARENT;
                    obtain.mFailedDrawable = TRANSPARENT;
                    String e16 = bb.f335811a.e();
                    if (e16 == null) {
                        Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
                        return TRANSPARENT;
                    }
                    QRouteApi api = QRoute.api(IZPlanCoupleSceneHelper.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanCoupleSceneHelper::class.java)");
                    i a16 = IZPlanCoupleSceneHelper.a.a((IZPlanCoupleSceneHelper) api, this.peerUin, null, 2, null);
                    if (a16 != null) {
                        coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.L$0 = this;
                        coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.L$1 = obtain;
                        coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.L$2 = e16;
                        coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.label = 1;
                        obj = a16.e(coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coupleAvatarFirstFrameImageView = this;
                        str = e16;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
                        return TRANSPARENT;
                    }
                } else if (i3 == 1) {
                    str = (String) coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.L$2;
                    obtain = (URLDrawable.URLDrawableOptions) coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.L$1;
                    coupleAvatarFirstFrameImageView = (CoupleAvatarFirstFrameImageView) coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int intValue = ((Number) obj).intValue();
                if (!(str.length() != 0)) {
                    if (!(coupleAvatarFirstFrameImageView.peerUin.length() == 0)) {
                        String str2 = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(str).appearanceKey;
                        if (str2.length() == 0) {
                            Drawable TRANSPARENT2 = com.tencent.mobileqq.urldrawable.b.f306350a;
                            Intrinsics.checkNotNullExpressionValue(TRANSPARENT2, "TRANSPARENT");
                            return TRANSPARENT2;
                        }
                        String str3 = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(coupleAvatarFirstFrameImageView.peerUin).appearanceKey;
                        if (str3.length() == 0) {
                            Drawable TRANSPARENT3 = com.tencent.mobileqq.urldrawable.b.f306350a;
                            Intrinsics.checkNotNullExpressionValue(TRANSPARENT3, "TRANSPARENT");
                            return TRANSPARENT3;
                        }
                        String c16 = e.f331005a.c(str3, str2, intValue, coupleAvatarFirstFrameImageView.b());
                        if (c16 == null || c16.length() == 0) {
                            Drawable TRANSPARENT4 = com.tencent.mobileqq.urldrawable.b.f306350a;
                            Intrinsics.checkNotNullExpressionValue(TRANSPARENT4, "TRANSPARENT");
                            return TRANSPARENT4;
                        }
                        QLog.i("CoupleAvatarFirstFrameImageView", 1, "getFirstFrameDrawable firstFramePath:" + c16);
                        URLDrawable fileDrawable = URLDrawable.getFileDrawable(c16, obtain);
                        Intrinsics.checkNotNullExpressionValue(fileDrawable, "getFileDrawable(firstFramePath, option)");
                        return fileDrawable;
                    }
                }
                Drawable TRANSPARENT5 = com.tencent.mobileqq.urldrawable.b.f306350a;
                Intrinsics.checkNotNullExpressionValue(TRANSPARENT5, "TRANSPARENT");
                return TRANSPARENT5;
            }
        }
        coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1 = new CoupleAvatarFirstFrameImageView$getFirstFrameDrawable$1(this, continuation);
        Object obj2 = coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = coupleAvatarFirstFrameImageView$getFirstFrameDrawable$1.label;
        if (i3 != 0) {
        }
        int intValue2 = ((Number) obj2).intValue();
        if (!(str.length() != 0)) {
        }
        Drawable TRANSPARENT52 = com.tencent.mobileqq.urldrawable.b.f306350a;
        Intrinsics.checkNotNullExpressionValue(TRANSPARENT52, "TRANSPARENT");
        return TRANSPARENT52;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode == 0 || (mode == Integer.MIN_VALUE && size > this.viewHeight)) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.viewHeight, Integer.MIN_VALUE);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarFirstFrameImageView(String peerUin, int i3, int i16, Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(context, "context");
        this.peerUin = peerUin;
        this.viewWidth = i3;
        this.viewHeight = i16;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "zplan_CoupleAvatarFirstFrameImageView", null, null, null, new AnonymousClass1(null), 14, null);
        }
    }
}
