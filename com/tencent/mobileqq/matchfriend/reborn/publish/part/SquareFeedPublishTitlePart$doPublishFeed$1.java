package com.tencent.mobileqq.matchfriend.reborn.publish.part;

import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.matchfriend.reborn.publish.SquareFeedPublishSuccessEvent;
import com.tencent.mobileqq.matchfriend.reborn.publish.anim.PicInfo;
import com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTitlePart$doPublishFeed$1;
import com.tencent.mobileqq.matchfriend.reborn.publish.request.SquareFeedPublishRequest;
import com.tencent.mobileqq.matchfriend.reborn.publish.request.SquareFeedPublishResult;
import com.tencent.mobileqq.matchfriend.reborn.publish.upload.PicUploadResult;
import com.tencent.mobileqq.matchfriend.reborn.publish.upload.SquareFeedPicUploader;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.inputview.QUIMultiLineInputView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$StImage;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import s82.SquarePublishPicInfo;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTitlePart$doPublishFeed$1", f = "SquareFeedPublishTitlePart.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class SquareFeedPublishTitlePart$doPublishFeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CharSequence $currentText;
    final /* synthetic */ SquarePublishPicInfo $picInfo;
    int label;
    final /* synthetic */ SquareFeedPublishTitlePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTitlePart$doPublishFeed$1$1", f = "SquareFeedPublishTitlePart.kt", i = {}, l = {157, 178, 180}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTitlePart$doPublishFeed$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $currentText;
        final /* synthetic */ SquarePublishPicInfo $picInfo;
        int label;
        final /* synthetic */ SquareFeedPublishTitlePart this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTitlePart$doPublishFeed$1$1$2", f = "SquareFeedPublishTitlePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTitlePart$doPublishFeed$1$1$2, reason: invalid class name */
        /* loaded from: classes33.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CharSequence $currentText;
            final /* synthetic */ SquareFeedPublishResult $publishResult;
            int label;
            final /* synthetic */ SquareFeedPublishTitlePart this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(SquareFeedPublishTitlePart squareFeedPublishTitlePart, SquareFeedPublishResult squareFeedPublishResult, CharSequence charSequence, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = squareFeedPublishTitlePart;
                this.$publishResult = squareFeedPublishResult;
                this.$currentText = charSequence;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$publishResult, this.$currentText, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AtomicBoolean atomicBoolean;
                QUIButton qUIButton;
                QUIMultiLineInputView qUIMultiLineInputView;
                CharSequence trim;
                boolean K9;
                QUIMultiLineInputView qUIMultiLineInputView2;
                ImageView imageView;
                FeedPB$StImage c16;
                PBUInt32Field pBUInt32Field;
                FeedPB$StImage c17;
                PBUInt32Field pBUInt32Field2;
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    atomicBoolean = this.this$0.isPublishing;
                    atomicBoolean.set(false);
                    qUIButton = this.this$0.publishBtn;
                    if (qUIButton != null) {
                        qUIButton.s();
                    }
                    if (this.$publishResult.getIsSuccess()) {
                        QQToast.makeText(this.this$0.getContext(), 2, "\u53d1\u5e03\u6210\u529f", 0).show();
                        Context context = this.this$0.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        com.tencent.kuikly.core.render.android.expand.module.l.e(context, "JIEBAN_PUBLISH_SUCCESS_EVENT", new JSONObject());
                        FeedPB$Feed feed = this.$publishResult.getFeed();
                        qUIMultiLineInputView = this.this$0.editText;
                        Integer num = null;
                        if (qUIMultiLineInputView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("editText");
                            qUIMultiLineInputView = null;
                        }
                        EditText h16 = qUIMultiLineInputView.h();
                        trim = StringsKt__StringsKt.trim(this.$currentText);
                        h16.setText(trim);
                        SimpleEventBus.getInstance().dispatchEvent(new SquareFeedPublishSuccessEvent(feed));
                        K9 = this.this$0.K9();
                        if (K9) {
                            com.tencent.mobileqq.matchfriend.reborn.publish.anim.d dVar = com.tencent.mobileqq.matchfriend.reborn.publish.anim.d.f245261a;
                            qUIMultiLineInputView2 = this.this$0.editText;
                            if (qUIMultiLineInputView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("editText");
                                qUIMultiLineInputView2 = null;
                            }
                            EditText h17 = qUIMultiLineInputView2.h();
                            imageView = this.this$0.imageView;
                            if (imageView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("imageView");
                                imageView = null;
                            }
                            Integer boxInt = (feed == null || (c17 = u72.a.c(feed)) == null || (pBUInt32Field2 = c17.high) == null) ? null : Boxing.boxInt(pBUInt32Field2.get());
                            if (feed != null && (c16 = u72.a.c(feed)) != null && (pBUInt32Field = c16.width) != null) {
                                num = Boxing.boxInt(pBUInt32Field.get());
                            }
                            dVar.c("qqstranger_feed", h17, new PicInfo(imageView, boxInt, num));
                        } else {
                            this.this$0.getActivity().finish();
                        }
                    } else {
                        QQToast.makeText(this.this$0.getContext(), 1, "\u53d1\u5e03\u5931\u8d25", 0).show();
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CharSequence charSequence, SquarePublishPicInfo squarePublishPicInfo, SquareFeedPublishTitlePart squareFeedPublishTitlePart, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$currentText = charSequence;
            this.$picInfo = squarePublishPicInfo;
            this.this$0 = squareFeedPublishTitlePart;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(SquareFeedPublishTitlePart squareFeedPublishTitlePart) {
            QQToast.makeText(squareFeedPublishTitlePart.getContext(), 1, "\u53d1\u5e03\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002", 0).show();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$currentText, this.$picInfo, this.this$0, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x00b5, code lost:
        
            if (((com.tencent.mobileqq.matchfriend.reborn.publish.upload.PicUploadResult) r1).getSuccess() == false) goto L30;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x014d A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            List<PicUploadResult> emptyList;
            List listOf;
            String localPath;
            String encodeContent;
            CharSequence trim;
            int i3;
            Object first;
            MainCoroutineDispatcher main;
            AnonymousClass2 anonymousClass2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i16 = this.label;
            if (i16 == 0) {
                ResultKt.throwOnFailure(obj);
                QLog.i("SquareFeedPublishTitlePart", 1, "[doPublishFeed] start. currentText size=" + this.$currentText.length() + ", picInfo=" + this.$picInfo);
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                SquarePublishPicInfo squarePublishPicInfo = this.$picInfo;
                boolean z16 = false;
                if (squarePublishPicInfo != null && (localPath = squarePublishPicInfo.getLocalPath()) != null) {
                    if (localPath.length() > 0) {
                        z16 = true;
                    }
                }
                if (z16) {
                    SquareFeedPicUploader squareFeedPicUploader = SquareFeedPicUploader.f245352a;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(this.$picInfo.getLocalPath());
                    this.label = 1;
                    obj = SquareFeedPicUploader.m(squareFeedPicUploader, listOf, false, this, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                CharSequence charSequence = this.$currentText;
                if (charSequence instanceof QQTextBuilder) {
                    encodeContent = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).fromQQTextBuilder((QQTextBuilder) this.$currentText);
                } else {
                    encodeContent = charSequence.toString();
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("SquareFeedPublishTitlePart", 4, "[doPublishFeed] encodeContent=" + encodeContent);
                }
                SquareFeedPublishRequest squareFeedPublishRequest = SquareFeedPublishRequest.f245346a;
                Intrinsics.checkNotNullExpressionValue(encodeContent, "encodeContent");
                trim = StringsKt__StringsKt.trim((CharSequence) encodeContent);
                String obj2 = trim.toString();
                i3 = this.this$0.source;
                this.label = 2;
                obj = squareFeedPublishRequest.a(obj2, emptyList, i3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                SquareFeedPublishResult squareFeedPublishResult = (SquareFeedPublishResult) obj;
                QLog.i("SquareFeedPublishTitlePart", 1, "[doPublishFeed]reqPublish done. publishResult=" + squareFeedPublishResult);
                main = Dispatchers.getMain();
                anonymousClass2 = new AnonymousClass2(this.this$0, squareFeedPublishResult, this.$currentText, null);
                this.label = 3;
                if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                SquareFeedPublishResult squareFeedPublishResult2 = (SquareFeedPublishResult) obj;
                QLog.i("SquareFeedPublishTitlePart", 1, "[doPublishFeed]reqPublish done. publishResult=" + squareFeedPublishResult2);
                main = Dispatchers.getMain();
                anonymousClass2 = new AnonymousClass2(this.this$0, squareFeedPublishResult2, this.$currentText, null);
                this.label = 3;
                if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            emptyList = (List) obj;
            QLog.i("SquareFeedPublishTitlePart", 1, "[doPublishFeed] uploadPic done. url size=" + emptyList.size());
            if (!emptyList.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) emptyList);
            }
            final SquareFeedPublishTitlePart squareFeedPublishTitlePart = this.this$0;
            squareFeedPublishTitlePart.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.n
                @Override // java.lang.Runnable
                public final void run() {
                    SquareFeedPublishTitlePart$doPublishFeed$1.AnonymousClass1.b(SquareFeedPublishTitlePart.this);
                }
            });
            QLog.d("SquareFeedPublishTitlePart", 1, "[doPublishFeed] uploadPic failed.");
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareFeedPublishTitlePart$doPublishFeed$1(CharSequence charSequence, SquarePublishPicInfo squarePublishPicInfo, SquareFeedPublishTitlePart squareFeedPublishTitlePart, Continuation<? super SquareFeedPublishTitlePart$doPublishFeed$1> continuation) {
        super(2, continuation);
        this.$currentText = charSequence;
        this.$picInfo = squarePublishPicInfo;
        this.this$0 = squareFeedPublishTitlePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SquareFeedPublishTitlePart$doPublishFeed$1(this.$currentText, this.$picInfo, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io5 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentText, this.$picInfo, this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SquareFeedPublishTitlePart$doPublishFeed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
