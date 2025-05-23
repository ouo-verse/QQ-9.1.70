package com.tencent.mobileqq.zplan.minihome.api.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zplan.minihome.GiftReportInfo;
import com.tencent.mobileqq.zplan.minihome.GiftRewardDesc;
import com.tencent.mobileqq.zplan.minihome.MiniHomeNetworkKt;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeRewardDialog;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.api.impl.MiniHomeHelperImpl$askShowGiftRewardDialog$1", f = "MiniHomeHelperImpl.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class MiniHomeHelperImpl$askShowGiftRewardDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $friendUin;
    final /* synthetic */ GiftReportInfo $reportInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.api.impl.MiniHomeHelperImpl$askShowGiftRewardDialog$1$3", f = "MiniHomeHelperImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.minihome.api.impl.MiniHomeHelperImpl$askShowGiftRewardDialog$1$3, reason: invalid class name */
    /* loaded from: classes34.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Context $context;
        final /* synthetic */ GiftRewardDesc $giftRewardDesc;
        final /* synthetic */ GiftReportInfo $reportInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Activity activity, Context context, GiftRewardDesc giftRewardDesc, GiftReportInfo giftReportInfo, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$context = context;
            this.$giftRewardDesc = giftRewardDesc;
            this.$reportInfo = giftReportInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$activity, this.$context, this.$giftRewardDesc, this.$reportInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Activity activity = this.$activity;
                boolean z16 = false;
                if (activity != null && !activity.isFinishing()) {
                    z16 = true;
                }
                if (z16) {
                    try {
                        new MiniHomeRewardDialog(this.$context, this.$giftRewardDesc, this.$reportInfo).show();
                    } catch (Throwable th5) {
                        QLog.e(MiniHomeHelperImpl.TAG, 1, "MiniHomeRewardDialog.show failed.", th5);
                    }
                } else {
                    QLog.e(MiniHomeHelperImpl.TAG, 1, "askShowGiftRewardDialog failed, activity null or finishing.");
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeHelperImpl$askShowGiftRewardDialog$1(String str, Activity activity, Context context, GiftReportInfo giftReportInfo, Continuation<? super MiniHomeHelperImpl$askShowGiftRewardDialog$1> continuation) {
        super(2, continuation);
        this.$friendUin = str;
        this.$activity = activity;
        this.$context = context;
        this.$reportInfo = giftReportInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeHelperImpl$askShowGiftRewardDialog$1(this.$friendUin, this.$activity, this.$context, this.$reportInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeHelperImpl$askShowGiftRewardDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object a16;
        q55.b bVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                long parseLong = Long.parseLong(this.$friendUin);
                this.label = 1;
                a16 = MiniHomeNetworkKt.a(parseLong, this);
                if (a16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                a16 = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bVar = (q55.b) a16;
        } catch (Throwable th5) {
            QLog.e("askShowGiftRewardDialog", 1, th5, new Object[0]);
        }
        if (bVar == null) {
            return Unit.INSTANCE;
        }
        String str = bVar.f428429a;
        String str2 = str == null ? "" : str;
        String str3 = bVar.f428430b;
        String str4 = str3 == null ? "" : str3;
        String str5 = bVar.f428431c;
        String str6 = str5 == null ? "" : str5;
        String str7 = bVar.f428432d;
        String str8 = str7 == null ? "" : str7;
        String str9 = bVar.f428433e;
        String str10 = str9 == null ? "" : str9;
        String str11 = bVar.f428434f;
        if (str11 == null) {
            str11 = "";
        }
        GiftRewardDesc giftRewardDesc = new GiftRewardDesc(str2, str4, str6, str8, str10, str11);
        QLog.i(MiniHomeHelperImpl.TAG, 1, "giftRewardDesc: " + giftRewardDesc);
        if (giftRewardDesc.getAwardPicUrl().length() > 0) {
            String awardPicUrl = giftRewardDesc.getAwardPicUrl();
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            URLDrawable.getDrawable(awardPicUrl, obtain);
        }
        if (giftRewardDesc.getAwardBackgroundPicUrl().length() > 0) {
            String awardBackgroundPicUrl = giftRewardDesc.getAwardBackgroundPicUrl();
            URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain2.mFailedDrawable = drawable2;
            obtain2.mLoadingDrawable = drawable2;
            URLDrawable.getDrawable(awardBackgroundPicUrl, obtain2);
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "MiniHomeHelperImpl showRewardDialog", null, null, null, new AnonymousClass3(this.$activity, this.$context, giftRewardDesc, this.$reportInfo, null), 14, null);
        }
        return Unit.INSTANCE;
    }
}
