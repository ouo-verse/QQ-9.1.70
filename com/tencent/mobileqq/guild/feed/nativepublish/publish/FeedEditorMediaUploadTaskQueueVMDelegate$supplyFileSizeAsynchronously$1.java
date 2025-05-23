package com.tencent.mobileqq.guild.feed.nativepublish.publish;

import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.publish.FeedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1", f = "FeedEditorMediaUploadTaskQueueVMDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, LocalMediaInfo> $missingFileSizeList;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedEditorMediaUploadTaskQueueVMDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1(Map<String, ? extends LocalMediaInfo> map, FeedEditorMediaUploadTaskQueueVMDelegate feedEditorMediaUploadTaskQueueVMDelegate, Continuation<? super FeedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1> continuation) {
        super(2, continuation);
        this.$missingFileSizeList = map;
        this.this$0 = feedEditorMediaUploadTaskQueueVMDelegate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1 feedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1 = new FeedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1(this.$missingFileSizeList, this.this$0, continuation);
        feedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1.L$0 = obj;
        return feedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        long j3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Map<String, LocalMediaInfo> map = this.$missingFileSizeList;
            FeedEditorMediaUploadTaskQueueVMDelegate feedEditorMediaUploadTaskQueueVMDelegate = this.this$0;
            Iterator<Map.Entry<String, LocalMediaInfo>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                LocalMediaInfo value = it.next().getValue();
                try {
                    String str = value.path;
                    if (str == null) {
                        str = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.path ?: \"\"");
                    }
                    StructStat stat = Os.stat(str);
                    if (stat != null) {
                        j3 = stat.st_size;
                    } else {
                        j3 = 0;
                    }
                    if (j3 > 0) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, ae.a().e(), null, new FeedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1$1$1(value, j3, null), 2, null);
                    }
                } catch (ErrnoException e16) {
                    QLog.e(feedEditorMediaUploadTaskQueueVMDelegate.getLogTag(), 1, "[supplyFileSizeAsynchronously]: read " + value.path + " file size failed", e16);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorMediaUploadTaskQueueVMDelegate$supplyFileSizeAsynchronously$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
