package com.tencent.mobileqq.guild.feed.morepanel;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.morepanel.handler.u;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils$delayShowQRCode$2", f = "FeedMorePanelUtils.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedMorePanelUtils$delayShowQRCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ k $launchParam;
    final /* synthetic */ Object $mediaData;
    final /* synthetic */ com.tencent.mobileqq.sharepanel.f $sharePanel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/qrscan/ScannerResult;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils$delayShowQRCode$2$1", f = "FeedMorePanelUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils$delayShowQRCode$2$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ScannerResult>, Object> {
        final /* synthetic */ k $launchParam;
        final /* synthetic */ Object $mediaData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, k kVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mediaData = obj;
            this.$launchParam = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$mediaData, this.$launchParam, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Option option = new Option();
                option.setUrl(bm.d(this.$mediaData));
                Logger.f235387a.d().i("FeedMorePanelUtils", 1, "delayShowQRCode path: " + com.tencent.mobileqq.guild.picload.e.a().c(option));
                return ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + com.tencent.mobileqq.guild.picload.e.a().c(option)), (Context) this.$launchParam.e().h(), 1, false);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ScannerResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/FeedMorePanelUtils$delayShowQRCode$2$a", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "", "id", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements x {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScannerResult f220196a;

        a(ScannerResult scannerResult) {
            this.f220196a = scannerResult;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            if (Intrinsics.areEqual(id5, "recognize_qr_code")) {
                return new u(this.f220196a).a(id5, panelContext);
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
            return x.a.c(this, str, panelContext);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
        public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem actionSheetItem, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
            return x.a.a(this, actionSheetItem, panelContext, shareActionSheet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedMorePanelUtils$delayShowQRCode$2(Object obj, k kVar, com.tencent.mobileqq.sharepanel.f fVar, Continuation<? super FeedMorePanelUtils$delayShowQRCode$2> continuation) {
        super(2, continuation);
        this.$mediaData = obj;
        this.$launchParam = kVar;
        this.$sharePanel = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedMorePanelUtils$delayShowQRCode$2(this.$mediaData, this.$launchParam, this.$sharePanel, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List<x> c16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        NewFeedMorePanelBusiImpl.a aVar = null;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            i.d dVar = i.d.f261782e;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mediaData, this.$launchParam, null);
            this.label = 1;
            obj = CorountineFunKt.i(dVar, null, null, anonymousClass1, this, 6, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ScannerResult scannerResult = (ScannerResult) obj;
        if (scannerResult != null) {
            com.tencent.mobileqq.sharepanel.f fVar = this.$sharePanel;
            k kVar = this.$launchParam;
            Logger logger = Logger.f235387a;
            logger.d().i("FeedMorePanelUtils", 1, "delayShowQRCode scannerResult:" + scannerResult);
            if (!scannerResult.l()) {
                logger.d().i("FeedMorePanelUtils", 1, "delayShowQRCode scannerResult noNeed QRCode");
                return Unit.INSTANCE;
            }
            FeedMorePanelUtils.f220193a.b(fVar, "recognize_qr_code");
            com.tencent.mobileqq.sharepanel.j newItemClickListener = kVar.getNewItemClickListener();
            if (newItemClickListener instanceof NewFeedMorePanelBusiImpl.a) {
                aVar = (NewFeedMorePanelBusiImpl.a) newItemClickListener;
            }
            if (aVar != null && (c16 = aVar.c()) != null) {
                Boxing.boxBoolean(c16.add(new a(scannerResult)));
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedMorePanelUtils$delayShowQRCode$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
