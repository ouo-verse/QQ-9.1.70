package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture;

import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$7;
import com.tencent.hippykotlin.demo.pages.base.Timer;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ChatContentBot;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ChatContentUser;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.DrawSceneRsp;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ImageInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchAICardNetRepo;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qzone.remote.ServiceConst;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardViewModel$innerLoadData$1", f = "QSearchAICardViewModel.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class QSearchAIPictureCardViewModel$innerLoadData$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $isFirstRequest;
    public final /* synthetic */ String $sessionId;
    public int label;
    public final /* synthetic */ QSearchAIPictureCardViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchAIPictureCardViewModel$innerLoadData$1(QSearchAIPictureCardViewModel qSearchAIPictureCardViewModel, String str, boolean z16, Continuation<? super QSearchAIPictureCardViewModel$innerLoadData$1> continuation) {
        super(2, continuation);
        this.this$0 = qSearchAIPictureCardViewModel;
        this.$sessionId = str;
        this.$isFirstRequest = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QSearchAIPictureCardViewModel$innerLoadData$1(this.this$0, this.$sessionId, this.$isFirstRequest, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((QSearchAIPictureCardViewModel$innerLoadData$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ArrayList arrayListOf;
        Continuation intercepted;
        Object orThrow;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QSearchAICardNetRepo qSearchAICardNetRepo = (QSearchAICardNetRepo) this.this$0.repo$delegate.getValue();
            String str = this.this$0.keyword;
            String str2 = this.$sessionId;
            boolean z16 = this.$isFirstRequest;
            this.label = 1;
            qSearchAICardNetRepo.getClass();
            int i16 = z16 ? 1 : 2;
            Utils utils = Utils.INSTANCE;
            String str3 = utils.currentBridgeModule().getDeviceInfo().terminalId;
            if (str3.length() == 0) {
                str3 = String.valueOf(utils.currentBridgeModule().currentTimeStamp());
                utils.logToNative("QSearchAICardNetRepo generateRequestId deviceInfo.terminalId is empty, use timestamp " + str3);
            }
            String currentAccount = utils.currentBridgeModule().getCurrentAccount();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ChatContentUser(1, utils.currentBridgeModule().base64Code(str, true), String.valueOf(utils.currentBridgeModule().currentTimeStamp()), 56));
            NetworkUtils networkUtils = NetworkUtils.INSTANCE;
            DrawSceneRsp drawSceneRsp = new DrawSceneRsp(0, null, null, null, 0, 31, null);
            networkUtils.getClass();
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            Function1<ISSORspModel<Object>, Unit> function1 = new Function1<ISSORspModel<Object>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$9$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ISSORspModel<Object> iSSORspModel) {
                    Continuation<NetworkUtils.SuspendResult<ISSORspModel<Object>>> continuation = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(new NetworkUtils.SuspendResult.Succeed(iSSORspModel)));
                    return Unit.INSTANCE;
                }
            };
            Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$9$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, String str4) {
                    int intValue = num.intValue();
                    Continuation<NetworkUtils.SuspendResult<ISSORspModel<Object>>> continuation = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(new NetworkUtils.SuspendResult.Failed(str4, intValue)));
                    return Unit.INSTANCE;
                }
            };
            BridgeModule currentBridgeModule = utils.currentBridgeModule();
            e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("request_id", str3, "user_id", currentAccount);
            m3.v("business_id", "115");
            m3.v("bot_id", "1018");
            com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
            if (arrayListOf != null) {
                Iterator it = arrayListOf.iterator();
                while (it.hasNext()) {
                    bVar.t(((ChatContentUser) it.next()).encode());
                }
            }
            m3.v("messages", bVar);
            m3.v(ServiceConst.PARA_SESSION_ID, str2);
            m3.t("op_type", i16);
            currentBridgeModule.ssoRequest("trpc.slcu_content_center.trpc_go_qqchat_svr.QQChatProcessService/SsoDrawScene", m3, false, new NetworkUtils$requestWithCmd$7(function2, drawSceneRsp, function1));
            orThrow = safeContinuation.getOrThrow();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (orThrow == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
            orThrow = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NetworkUtils.SuspendResult suspendResult = (NetworkUtils.SuspendResult) orThrow;
        if (suspendResult instanceof NetworkUtils.SuspendResult.Failed) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("fetchAIPicture failed <--x(");
            sb5.append(suspendResult);
            sb5.append(") keyword=");
            sb5.append(this.this$0.keyword);
            sb5.append(" sessionId=");
            sb5.append(this.$sessionId);
            sb5.append(" isFirstRequest=");
            AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(sb5, this.$isFirstRequest, kLog, "QSearchAIPictureCardViewModel");
            QSearchAIPictureCardViewModel.access$notifyFailed(this.this$0, ((NetworkUtils.SuspendResult.Failed) suspendResult).errorCode);
        } else if (suspendResult instanceof NetworkUtils.SuspendResult.Succeed) {
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("fetchAIPicture succeed <--x(");
            sb6.append(suspendResult);
            sb6.append(") keyword=");
            sb6.append(this.this$0.keyword);
            sb6.append(" sessionId=");
            sb6.append(this.$sessionId);
            sb6.append(" isFirstRequest=");
            AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(sb6, this.$isFirstRequest, kLog2, "QSearchAIPictureCardViewModel");
            NetworkUtils.SuspendResult.Succeed succeed = (NetworkUtils.SuspendResult.Succeed) suspendResult;
            DrawSceneRsp drawSceneRsp2 = (DrawSceneRsp) succeed.data;
            int i17 = drawSceneRsp2.retCode;
            if (i17 != 0) {
                QSearchAIPictureCardViewModel.access$notifyFailed(this.this$0, i17);
                return Unit.INSTANCE;
            }
            ArrayList<ChatContentBot> arrayList = drawSceneRsp2.messages;
            if (!(arrayList == null || arrayList.isEmpty())) {
                QSearchAIPictureCardViewModel qSearchAIPictureCardViewModel = this.this$0;
                ArrayList<ChatContentBot> arrayList2 = ((DrawSceneRsp) succeed.data).messages;
                Intrinsics.checkNotNull(arrayList2, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ChatContentBot>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ChatContentBot> }");
                ImageInfo imageInfo = arrayList2.get(0).imgInfo;
                ReadWriteProperty readWriteProperty = qSearchAIPictureCardViewModel.imageInfo$delegate;
                KProperty<?>[] kPropertyArr = QSearchAIPictureCardViewModel.$$delegatedProperties;
                readWriteProperty.setValue(qSearchAIPictureCardViewModel, kPropertyArr[0], imageInfo);
                QSearchAIPictureCardViewModel qSearchAIPictureCardViewModel2 = this.this$0;
                ImageInfo imageInfo2 = qSearchAIPictureCardViewModel2.getImageInfo();
                long j3 = imageInfo2 != null ? imageInfo2.orgImgWidth : 0L;
                ImageInfo imageInfo3 = qSearchAIPictureCardViewModel2.getImageInfo();
                long j16 = imageInfo3 != null ? imageInfo3.orgImgHeight : 0L;
                float f16 = j16 > 0 ? (((float) j3) * 194.0f) / ((float) j16) : 129.0f;
                qSearchAIPictureCardViewModel2.imageSize$delegate.setValue(qSearchAIPictureCardViewModel2, kPropertyArr[1], new w(f16 > 0.0f ? f16 : 129.0f, 194.0f));
                ImageInfo imageInfo4 = this.this$0.getImageInfo();
                if (imageInfo4 != null) {
                    QSearchAIPictureCardViewModel qSearchAIPictureCardViewModel3 = this.this$0;
                    if (imageInfo4.orgDownUrl.length() > 0) {
                        qSearchAIPictureCardViewModel3.getClass();
                        qSearchAIPictureCardViewModel3.endTime = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
                        qSearchAIPictureCardViewModel3.setCardStatus(2);
                        qSearchAIPictureCardViewModel3.setCardHeight((FontModuleExtKt.qqFontScaleAddSize(14.0f) * 2) + qSearchAIPictureCardViewModel3.getImageSize().getHeight() + 68.0f);
                        return Unit.INSTANCE;
                    }
                }
            }
            DrawSceneRsp drawSceneRsp3 = (DrawSceneRsp) succeed.data;
            int i18 = drawSceneRsp3.waitTs;
            if (i18 > 0) {
                final QSearchAIPictureCardViewModel qSearchAIPictureCardViewModel4 = this.this$0;
                if (!qSearchAIPictureCardViewModel4.stoped) {
                    final String str4 = drawSceneRsp3.sessionId;
                    Timer timer = qSearchAIPictureCardViewModel4.requestTimer;
                    if (timer != null) {
                        timer.stopTimer();
                    }
                    long j17 = i18 * 1000;
                    Timer timer2 = new Timer(j17, 0, (Function1) null, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardViewModel$startRequestTimer$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Object obj2) {
                            QSearchAIPictureCardViewModel.this.innerLoadData(str4, false);
                            return Unit.INSTANCE;
                        }
                    }, 14);
                    if (!timer2.isRunning) {
                        timer2.isRunning = true;
                        timer2.countDownTime = j17;
                        timer2.countDownTime();
                    }
                    qSearchAIPictureCardViewModel4.requestTimer = timer2;
                }
            }
            QSearchAIPictureCardViewModel.access$notifyFailed(this.this$0, -1);
        }
        return Unit.INSTANCE;
    }
}
