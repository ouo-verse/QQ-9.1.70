package com.tencent.guild.api.marketface.impl;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.marketface.IMarketFaceTailConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.api.marketface.impl.MarketFaceApiImpl$showCustomMarketFaceTips$2", f = "MarketFaceApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class MarketFaceApiImpl$showCustomMarketFaceTips$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Emoticon $e;
    final /* synthetic */ String $msg;
    final /* synthetic */ String $title;
    int label;
    final /* synthetic */ MarketFaceApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarketFaceApiImpl$showCustomMarketFaceTips$2(Context context, String str, String str2, Emoticon emoticon, MarketFaceApiImpl marketFaceApiImpl, Continuation<? super MarketFaceApiImpl$showCustomMarketFaceTips$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$title = str;
        this.$msg = str2;
        this.$e = emoticon;
        this.this$0 = marketFaceApiImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Emoticon emoticon, Context context, MarketFaceApiImpl marketFaceApiImpl, DialogInterface dialogInterface, int i3) {
        boolean z16;
        BaseQQAppInterface appRuntime;
        if (emoticon.jobType == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        IMarketFaceDiffApi iMarketFaceDiffApi = (IMarketFaceDiffApi) QRoute.api(IMarketFaceDiffApi.class);
        appRuntime = marketFaceApiImpl.getAppRuntime();
        iMarketFaceDiffApi.openEmoMarket(context, appRuntime.getAccount(), 8, emoticon.epId, z16);
        QRouteApi api = QRoute.api(IMarketFaceTailConfig.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMarketFaceTailConfig::class.java)");
        IMarketFaceTailConfig.a.a((IMarketFaceTailConfig) api, "bottom", "detail", "4", 102, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i3) {
        QRouteApi api = QRoute.api(IMarketFaceTailConfig.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMarketFaceTailConfig::class.java)");
        IMarketFaceTailConfig.a.a((IMarketFaceTailConfig) api, "bottom", "cancel", "4", 102, null, 16, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MarketFaceApiImpl$showCustomMarketFaceTips$2(this.$context, this.$title, this.$msg, this.$e, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                final Context context = this.$context;
                String str = this.$title;
                String str2 = this.$msg;
                final Emoticon emoticon = this.$e;
                final MarketFaceApiImpl marketFaceApiImpl = this.this$0;
                DialogUtil.createCustomDialog(context, 230, str, str2, "\u53d6\u6d88", "\u67e5\u770b\u8be6\u60c5", new DialogInterface.OnClickListener() { // from class: com.tencent.guild.api.marketface.impl.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        MarketFaceApiImpl$showCustomMarketFaceTips$2.c(Emoticon.this, context, marketFaceApiImpl, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.guild.api.marketface.impl.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        MarketFaceApiImpl$showCustomMarketFaceTips$2.d(dialogInterface, i3);
                    }
                }).show();
                QRouteApi api = QRoute.api(IMarketFaceTailConfig.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IMarketFaceTailConfig::class.java)");
                IMarketFaceTailConfig.a.a((IMarketFaceTailConfig) api, "bottom", OpenConstants.ApiName.PAY, "4", 102, null, 16, null);
            } catch (Exception e16) {
                QLog.e(com.tencent.qqnt.emotion.adapter.api.impl.MarketFaceApiImpl.TAG, 1, e16.getMessage());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MarketFaceApiImpl$showCustomMarketFaceTips$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
