package com.tencent.mobileqq.wink.aigc.newtest;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import feedcloud.FeedCloudAigcsvr$Image;
import feedcloud.FeedCloudAigcsvr$QueryRsp;
import feedcloud.FeedCloudAigcsvr$SubmitRsp;
import feedcloud.FeedCloudAigcsvr$Task;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.aigc.newtest.WinkMaliDrawFragment$draw$2", f = "WinkMaliDrawFragment.kt", i = {0, 0, 1, 1, 3, 3, 4, 6, 6, 9, 10, 12}, l = {180, 181, 184, 188, 189, 193, 197, 198, 201, 208, 209, 216, 218}, m = "invokeSuspend", n = {"mediaInfo", "model", "mediaInfo", "model", "mediaInfo", "model", "model", "model", "uploadUrl", "submitRsp", "submitRsp", "resultUrl"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$0", "L$0"})
/* loaded from: classes21.dex */
public final class WinkMaliDrawFragment$draw$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WinkMaliDrawFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMaliDrawFragment$draw$2(WinkMaliDrawFragment winkMaliDrawFragment, Continuation<? super WinkMaliDrawFragment$draw$2> continuation) {
        super(2, continuation);
        this.this$0 = winkMaliDrawFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkMaliDrawFragment$draw$2(this.this$0, continuation);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0170 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ef  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x01bd -> B:12:0x01c0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        LocalMediaInfo localMediaInfo;
        ModelItem modelItem;
        Object Kh;
        a Eh;
        Object Kh2;
        Object Kh3;
        a Eh2;
        ModelItem modelItem2;
        ImageResult imageResult;
        String str;
        boolean z16;
        Object Kh4;
        Object Kh5;
        boolean isBlank;
        a Eh3;
        FeedCloudAigcsvr$SubmitRsp feedCloudAigcsvr$SubmitRsp;
        WinkMaliDrawFragment$draw$2 winkMaliDrawFragment$draw$2;
        Object obj2;
        String str2;
        Object Kh6;
        FeedCloudAigcsvr$SubmitRsp feedCloudAigcsvr$SubmitRsp2;
        a Eh4;
        boolean isBlank2;
        Object Kh7;
        Object Kh8;
        FeedCloudAigcsvr$QueryRsp feedCloudAigcsvr$QueryRsp;
        String str3;
        FeedCloudAigcsvr$Task feedCloudAigcsvr$Task;
        FeedCloudAigcsvr$Image feedCloudAigcsvr$Image;
        PBStringField pBStringField;
        FeedCloudAigcsvr$Task feedCloudAigcsvr$Task2;
        PBUInt32Field pBUInt32Field;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = 0;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                localMediaInfo = this.this$0.localMediaInfo;
                modelItem = this.this$0.modelItem;
                if (localMediaInfo != null && modelItem != null) {
                    WinkMaliDrawFragment winkMaliDrawFragment = this.this$0;
                    this.L$0 = localMediaInfo;
                    this.L$1 = modelItem;
                    this.label = 1;
                    Kh = winkMaliDrawFragment.Kh("\u670d\u52a1\u7ed1\u5b9a\u4e2d...", this);
                    if (Kh == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Eh = this.this$0.Eh();
                    this.L$0 = localMediaInfo;
                    this.L$1 = modelItem;
                    this.label = 2;
                    obj = Eh.Q1(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "[draw] no upload service");
                        WinkMaliDrawFragment winkMaliDrawFragment2 = this.this$0;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 3;
                        Kh3 = winkMaliDrawFragment2.Kh("\u670d\u52a1\u7ed1\u5b9a\u5931\u8d25", this);
                        if (Kh3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    WinkMaliDrawFragment winkMaliDrawFragment3 = this.this$0;
                    this.L$0 = localMediaInfo;
                    this.L$1 = modelItem;
                    this.label = 4;
                    Kh2 = winkMaliDrawFragment3.Kh("\u4e0a\u4f20\u7167\u7247\u4e2d...", this);
                    if (Kh2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Eh2 = this.this$0.Eh();
                    this.L$0 = modelItem;
                    this.L$1 = null;
                    this.label = 5;
                    obj = Eh2.W1(localMediaInfo, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    modelItem2 = modelItem;
                    imageResult = (ImageResult) obj;
                    if (imageResult != null) {
                        str = imageResult.getOriginUrl();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(str);
                        if (!isBlank) {
                            z16 = false;
                            if (!z16) {
                                com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "[draw] no upload url");
                                WinkMaliDrawFragment winkMaliDrawFragment4 = this.this$0;
                                this.L$0 = null;
                                this.label = 6;
                                Kh5 = winkMaliDrawFragment4.Kh("\u4e0a\u4f20\u7167\u7247\u5931\u8d25", this);
                                if (Kh5 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            WinkMaliDrawFragment winkMaliDrawFragment5 = this.this$0;
                            this.L$0 = modelItem2;
                            this.L$1 = str;
                            this.label = 7;
                            Kh4 = winkMaliDrawFragment5.Kh("\u56fe\u7247\u751f\u6210\u4e2d...", this);
                            if (Kh4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Eh3 = this.this$0.Eh();
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 8;
                            obj = Eh3.U1(modelItem2, str, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            feedCloudAigcsvr$SubmitRsp = (FeedCloudAigcsvr$SubmitRsp) obj;
                            if (feedCloudAigcsvr$SubmitRsp == null) {
                                com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "[draw] no rsp");
                                WinkMaliDrawFragment winkMaliDrawFragment6 = this.this$0;
                                this.label = 9;
                                Kh6 = winkMaliDrawFragment6.Kh("\u56fe\u7247\u751f\u6210\u5931\u8d25", this);
                                if (Kh6 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            winkMaliDrawFragment$draw$2 = this;
                            obj2 = coroutine_suspended;
                            str2 = "";
                            if (i3 == 2) {
                                winkMaliDrawFragment$draw$2.L$0 = feedCloudAigcsvr$SubmitRsp;
                                winkMaliDrawFragment$draw$2.label = 10;
                                if (DelayKt.delay(2000L, winkMaliDrawFragment$draw$2) == obj2) {
                                    return obj2;
                                }
                                coroutine_suspended = obj2;
                                feedCloudAigcsvr$SubmitRsp2 = feedCloudAigcsvr$SubmitRsp;
                                Eh4 = winkMaliDrawFragment$draw$2.this$0.Eh();
                                String str4 = feedCloudAigcsvr$SubmitRsp2.task_id.get();
                                Intrinsics.checkNotNullExpressionValue(str4, "submitRsp.task_id.get()");
                                winkMaliDrawFragment$draw$2.L$0 = feedCloudAigcsvr$SubmitRsp2;
                                winkMaliDrawFragment$draw$2.label = 11;
                                obj = Eh4.T1(str4, winkMaliDrawFragment$draw$2);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                feedCloudAigcsvr$QueryRsp = (FeedCloudAigcsvr$QueryRsp) obj;
                                if (feedCloudAigcsvr$QueryRsp == null && (feedCloudAigcsvr$Task2 = feedCloudAigcsvr$QueryRsp.task) != null && (pBUInt32Field = feedCloudAigcsvr$Task2.task_status) != null) {
                                    i3 = pBUInt32Field.get();
                                } else {
                                    i3 = -1;
                                }
                                if (feedCloudAigcsvr$QueryRsp == null && (feedCloudAigcsvr$Task = feedCloudAigcsvr$QueryRsp.task) != null && (feedCloudAigcsvr$Image = feedCloudAigcsvr$Task.image) != null && (pBStringField = feedCloudAigcsvr$Image.url) != null) {
                                    str3 = pBStringField.get();
                                } else {
                                    str3 = null;
                                }
                                if (str3 == null) {
                                    str3 = "";
                                }
                                com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "[draw] status=" + i3 + ", resultUrl=" + str3);
                                Object obj3 = coroutine_suspended;
                                str2 = str3;
                                feedCloudAigcsvr$SubmitRsp = feedCloudAigcsvr$SubmitRsp2;
                                obj2 = obj3;
                                if (i3 == 2) {
                                    isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                                    if (isBlank2) {
                                        WinkMaliDrawFragment winkMaliDrawFragment7 = winkMaliDrawFragment$draw$2.this$0;
                                        winkMaliDrawFragment$draw$2.L$0 = null;
                                        winkMaliDrawFragment$draw$2.label = 12;
                                        Kh8 = winkMaliDrawFragment7.Kh("\u56fe\u7247\u751f\u6210\u5931\u8d25", winkMaliDrawFragment$draw$2);
                                        if (Kh8 == obj2) {
                                            return obj2;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    WinkMaliDrawFragment winkMaliDrawFragment8 = winkMaliDrawFragment$draw$2.this$0;
                                    winkMaliDrawFragment$draw$2.L$0 = str2;
                                    winkMaliDrawFragment$draw$2.label = 13;
                                    Kh7 = winkMaliDrawFragment8.Kh("\u56fe\u7247\u52a0\u8f7d\u4e2d...", winkMaliDrawFragment$draw$2);
                                    if (Kh7 == obj2) {
                                        return obj2;
                                    }
                                    winkMaliDrawFragment$draw$2.this$0.Jh(str2, true);
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                } else {
                    com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "[draw] invalid params");
                    return Unit.INSTANCE;
                }
                break;
            case 1:
                modelItem = (ModelItem) this.L$1;
                localMediaInfo = (LocalMediaInfo) this.L$0;
                ResultKt.throwOnFailure(obj);
                Eh = this.this$0.Eh();
                this.L$0 = localMediaInfo;
                this.L$1 = modelItem;
                this.label = 2;
                obj = Eh.Q1(this);
                if (obj == coroutine_suspended) {
                }
                if (!((Boolean) obj).booleanValue()) {
                }
                break;
            case 2:
                modelItem = (ModelItem) this.L$1;
                localMediaInfo = (LocalMediaInfo) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 4:
                modelItem = (ModelItem) this.L$1;
                localMediaInfo = (LocalMediaInfo) this.L$0;
                ResultKt.throwOnFailure(obj);
                Eh2 = this.this$0.Eh();
                this.L$0 = modelItem;
                this.L$1 = null;
                this.label = 5;
                obj = Eh2.W1(localMediaInfo, this);
                if (obj == coroutine_suspended) {
                }
                modelItem2 = modelItem;
                imageResult = (ImageResult) obj;
                if (imageResult != null) {
                }
                if (str != null) {
                }
                z16 = true;
                if (!z16) {
                }
                break;
            case 5:
                modelItem = (ModelItem) this.L$0;
                ResultKt.throwOnFailure(obj);
                modelItem2 = modelItem;
                imageResult = (ImageResult) obj;
                if (imageResult != null) {
                }
                if (str != null) {
                }
                z16 = true;
                if (!z16) {
                }
                break;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 7:
                str = (String) this.L$1;
                modelItem2 = (ModelItem) this.L$0;
                ResultKt.throwOnFailure(obj);
                Eh3 = this.this$0.Eh();
                this.L$0 = null;
                this.L$1 = null;
                this.label = 8;
                obj = Eh3.U1(modelItem2, str, this);
                if (obj == coroutine_suspended) {
                }
                feedCloudAigcsvr$SubmitRsp = (FeedCloudAigcsvr$SubmitRsp) obj;
                if (feedCloudAigcsvr$SubmitRsp == null) {
                }
                break;
            case 8:
                ResultKt.throwOnFailure(obj);
                feedCloudAigcsvr$SubmitRsp = (FeedCloudAigcsvr$SubmitRsp) obj;
                if (feedCloudAigcsvr$SubmitRsp == null) {
                }
                break;
            case 9:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 10:
                feedCloudAigcsvr$SubmitRsp2 = (FeedCloudAigcsvr$SubmitRsp) this.L$0;
                ResultKt.throwOnFailure(obj);
                winkMaliDrawFragment$draw$2 = this;
                Eh4 = winkMaliDrawFragment$draw$2.this$0.Eh();
                String str42 = feedCloudAigcsvr$SubmitRsp2.task_id.get();
                Intrinsics.checkNotNullExpressionValue(str42, "submitRsp.task_id.get()");
                winkMaliDrawFragment$draw$2.L$0 = feedCloudAigcsvr$SubmitRsp2;
                winkMaliDrawFragment$draw$2.label = 11;
                obj = Eh4.T1(str42, winkMaliDrawFragment$draw$2);
                if (obj == coroutine_suspended) {
                }
                feedCloudAigcsvr$QueryRsp = (FeedCloudAigcsvr$QueryRsp) obj;
                if (feedCloudAigcsvr$QueryRsp == null) {
                    break;
                }
                i3 = -1;
                if (feedCloudAigcsvr$QueryRsp == null) {
                    break;
                }
                str3 = null;
                if (str3 == null) {
                }
                com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "[draw] status=" + i3 + ", resultUrl=" + str3);
                Object obj32 = coroutine_suspended;
                str2 = str3;
                feedCloudAigcsvr$SubmitRsp = feedCloudAigcsvr$SubmitRsp2;
                obj2 = obj32;
                if (i3 == 2) {
                }
                break;
            case 11:
                feedCloudAigcsvr$SubmitRsp2 = (FeedCloudAigcsvr$SubmitRsp) this.L$0;
                ResultKt.throwOnFailure(obj);
                winkMaliDrawFragment$draw$2 = this;
                feedCloudAigcsvr$QueryRsp = (FeedCloudAigcsvr$QueryRsp) obj;
                if (feedCloudAigcsvr$QueryRsp == null) {
                }
                i3 = -1;
                if (feedCloudAigcsvr$QueryRsp == null) {
                }
                str3 = null;
                if (str3 == null) {
                }
                com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "[draw] status=" + i3 + ", resultUrl=" + str3);
                Object obj322 = coroutine_suspended;
                str2 = str3;
                feedCloudAigcsvr$SubmitRsp = feedCloudAigcsvr$SubmitRsp2;
                obj2 = obj322;
                if (i3 == 2) {
                }
                break;
            case 12:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 13:
                str2 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                winkMaliDrawFragment$draw$2 = this;
                winkMaliDrawFragment$draw$2.this$0.Jh(str2, true);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkMaliDrawFragment$draw$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
