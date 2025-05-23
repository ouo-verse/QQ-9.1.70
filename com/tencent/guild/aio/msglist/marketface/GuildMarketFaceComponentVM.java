package com.tencent.guild.aio.msglist.marketface;

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.msglist.marketface.a;
import com.tencent.guild.api.marketface.IMarketFaceApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001b\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J#\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/guild/aio/msglist/marketface/GuildMarketFaceComponentVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/guild/aio/msglist/marketface/a$a;", "intent", "", "l", "Landroid/widget/ImageView;", "bubbleIv", "Lmr0/a;", "faceDrawableInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/msglist/marketface/b;", "intentData", "j", "(Lcom/tencent/guild/aio/msglist/marketface/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "type", "", "o", "p", "handleIntent", "info", DomainData.DOMAIN_NAME, "(Lmr0/a;Lcom/tencent/guild/aio/msglist/marketface/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMarketFaceComponentVM extends com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> {
    /* JADX WARN: Multi-variable type inference failed */
    private final Object j(IntentData intentData, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        QLog.i("GuildMarketFaceComponentVM", 1, "handleMagicMarketFace");
        IMarketFaceApi iMarketFaceApi = (IMarketFaceApi) QRoute.api(IMarketFaceApi.class);
        MarketFaceElement msgEle = intentData.getMsgEle();
        ImageView bubbleIv = intentData.getBubbleIv();
        long msgId = intentData.getMsgId();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        Object bindMagicMarketFaceToView = iMarketFaceApi.bindMagicMarketFaceToView(msgEle, bubbleIv, msgId, new Contact(4, b16, com.tencent.guild.aio.util.a.g(g17)), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (bindMagicMarketFaceToView == coroutine_suspended) {
            return bindMagicMarketFaceToView;
        }
        return Unit.INSTANCE;
    }

    private final void l(a.C1204a intent) {
        MarketFaceElement msgEle = intent.getData().getMsgEle();
        QLog.i("GuildMarketFaceComponentVM", 1, "begin==queryMarketFacePkg ThreadName=" + Thread.currentThread().getName() + " intent=" + intent);
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new GuildMarketFaceComponentVM$handleMarketFaceShow$1(msgEle, this, intent, null), 3, null);
    }

    private final void m(ImageView bubbleIv, mr0.a faceDrawableInfo) {
        QLog.i("GuildMarketFaceComponentVM", 1, "handleNormalMarketFaceShown faceName=" + faceDrawableInfo.getJobType());
        bubbleIv.setLayoutParams(new FrameLayout.LayoutParams(faceDrawableInfo.c().getFirst().intValue(), faceDrawableInfo.c().getSecond().intValue()));
        bubbleIv.setImageDrawable(faceDrawableInfo.getDrawable());
    }

    private final boolean o(int type) {
        if (type == 2) {
            return true;
        }
        return false;
    }

    private final boolean p(int type) {
        if (type == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C1204a) {
            l((a.C1204a) intent);
        }
    }

    @Nullable
    public final Object n(@NotNull mr0.a aVar, @NotNull IntentData intentData, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        QLog.i("GuildMarketFaceComponentVM", 1, "handleSuccess type=" + aVar.getJobType());
        if (p(aVar.getJobType())) {
            m(intentData.getBubbleIv(), aVar);
        } else {
            if (o(aVar.getJobType())) {
                Object j3 = j(intentData, continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (j3 == coroutine_suspended) {
                    return j3;
                }
                return Unit.INSTANCE;
            }
            QLog.i("GuildMarketFaceComponentVM", 1, "unSupport MarketFace");
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        QLog.i("GuildMarketFaceComponentVM", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        QLog.i("GuildMarketFaceComponentVM", 4, "onCreate");
    }
}
